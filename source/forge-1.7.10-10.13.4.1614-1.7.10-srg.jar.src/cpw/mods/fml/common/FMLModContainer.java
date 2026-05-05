/*     */ package cpw.mods.fml.common;
/*     */ 
/*     */ import com.google.common.base.Function;
/*     */ import com.google.common.base.Strings;
/*     */ import com.google.common.base.Throwables;
/*     */ import com.google.common.collect.ArrayListMultimap;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.ImmutableMap;
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import com.google.common.collect.ListMultimap;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.SetMultimap;
/*     */ import com.google.common.collect.Sets;
/*     */ import com.google.common.eventbus.EventBus;
/*     */ import com.google.common.eventbus.Subscribe;
/*     */ import cpw.mods.fml.common.discovery.ASMDataTable;
/*     */ import cpw.mods.fml.common.discovery.ModCandidate;
/*     */ import cpw.mods.fml.common.event.FMLConstructionEvent;
/*     */ import cpw.mods.fml.common.event.FMLEvent;
/*     */ import cpw.mods.fml.common.event.FMLFingerprintViolationEvent;
/*     */ import cpw.mods.fml.common.network.NetworkRegistry;
/*     */ import cpw.mods.fml.common.versioning.ArtifactVersion;
/*     */ import cpw.mods.fml.common.versioning.DefaultArtifactVersion;
/*     */ import cpw.mods.fml.common.versioning.VersionParser;
/*     */ import cpw.mods.fml.common.versioning.VersionRange;
/*     */ import java.io.File;
/*     */ import java.io.FileInputStream;
/*     */ import java.lang.annotation.Annotation;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.security.cert.Certificate;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Properties;
/*     */ import java.util.Set;
/*     */ import java.util.zip.ZipEntry;
/*     */ import java.util.zip.ZipFile;
/*     */ import org.apache.logging.log4j.Level;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FMLModContainer
/*     */   implements ModContainer
/*     */ {
/*     */   private Object modInstance;
/*     */   private File source;
/*     */   private ModMetadata modMetadata;
/*     */   private String className;
/*     */   private Map<String, Object> descriptor;
/*     */   private boolean enabled = true;
/*     */   private String internalVersion;
/*     */   private boolean overridesMetadata;
/*     */   private EventBus eventBus;
/*     */   private LoadController controller;
/*     */   private DefaultArtifactVersion processedVersion;
/*     */   private String annotationDependencies;
/*     */   private VersionRange minecraftAccepted;
/*     */   private boolean fingerprintNotPresent;
/*     */   private Set<String> sourceFingerprints;
/*     */   private Certificate certificate;
/*     */   private String modLanguage;
/*     */   private ILanguageAdapter languageAdapter;
/*     */   private ModContainer.Disableable disableability;
/*     */   private ListMultimap<Class<? extends FMLEvent>, Method> eventMethods;
/*     */   private Map<String, String> customModProperties;
/*     */   private ModCandidate candidate;
/*     */   
/*     */   public FMLModContainer(String className, ModCandidate container, Map<String, Object> modDescriptor) {
/*  89 */     this.className = className;
/*  90 */     this.source = container.getModContainer();
/*  91 */     this.candidate = container;
/*  92 */     this.descriptor = modDescriptor;
/*  93 */     this.eventMethods = (ListMultimap<Class<? extends FMLEvent>, Method>)ArrayListMultimap.create();
/*     */     
/*  95 */     this.modLanguage = (String)modDescriptor.get("modLanguage");
/*  96 */     String languageAdapterType = (String)modDescriptor.get("modLanguageAdapter");
/*  97 */     if (Strings.isNullOrEmpty(languageAdapterType)) {
/*     */       
/*  99 */       this.languageAdapter = "scala".equals(this.modLanguage) ? new ILanguageAdapter.ScalaAdapter() : new ILanguageAdapter.JavaAdapter();
/*     */     } else {
/*     */ 
/*     */       
/*     */       try {
/*     */         
/* 105 */         this.languageAdapter = (ILanguageAdapter)Class.forName(languageAdapterType, true, Loader.instance().getModClassLoader()).newInstance();
/* 106 */         FMLLog.finer("Using custom language adapter %s (type %s) for %s (modid %s)", new Object[] { this.languageAdapter, languageAdapterType, this.className, getModId() });
/*     */       }
/* 108 */       catch (Exception ex) {
/*     */         
/* 110 */         FMLLog.log(Level.ERROR, ex, "Error constructing custom mod language adapter %s (referenced by %s) (modid: %s)", new Object[] { languageAdapterType, this.className, getModId() });
/* 111 */         throw new LoaderException(ex);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private ILanguageAdapter getLanguageAdapter() {
/* 118 */     return this.languageAdapter;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getModId() {
/* 123 */     return (String)this.descriptor.get("modid");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 129 */     return this.modMetadata.name;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getVersion() {
/* 135 */     return this.internalVersion;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public File getSource() {
/* 141 */     return this.source;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ModMetadata getMetadata() {
/* 147 */     return this.modMetadata;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void bindMetadata(MetadataCollection mc) {
/* 153 */     this.modMetadata = mc.getMetadataForId(getModId(), this.descriptor);
/*     */     
/* 155 */     if (this.descriptor.containsKey("useMetadata"))
/*     */     {
/* 157 */       this.overridesMetadata = !((Boolean)this.descriptor.get("useMetadata")).booleanValue();
/*     */     }
/*     */     
/* 160 */     if (this.overridesMetadata || !this.modMetadata.useDependencyInformation) {
/*     */       
/* 162 */       Set<ArtifactVersion> requirements = Sets.newHashSet();
/* 163 */       List<ArtifactVersion> dependencies = Lists.newArrayList();
/* 164 */       List<ArtifactVersion> dependants = Lists.newArrayList();
/* 165 */       this.annotationDependencies = (String)this.descriptor.get("dependencies");
/* 166 */       Loader.instance().computeDependencies(this.annotationDependencies, requirements, dependencies, dependants);
/* 167 */       dependants.addAll(Loader.instance().getInjectedBefore(getModId()));
/* 168 */       dependencies.addAll(Loader.instance().getInjectedAfter(getModId()));
/* 169 */       this.modMetadata.requiredMods = requirements;
/* 170 */       this.modMetadata.dependencies = dependencies;
/* 171 */       this.modMetadata.dependants = dependants;
/* 172 */       FMLLog.log(getModId(), Level.TRACE, "Parsed dependency info : %s %s %s", new Object[] { requirements, dependencies, dependants });
/*     */     }
/*     */     else {
/*     */       
/* 176 */       FMLLog.log(getModId(), Level.TRACE, "Using mcmod dependency info : %s %s %s", new Object[] { this.modMetadata.requiredMods, this.modMetadata.dependencies, this.modMetadata.dependants });
/*     */     } 
/* 178 */     if (Strings.isNullOrEmpty(this.modMetadata.name)) {
/*     */       
/* 180 */       FMLLog.log(getModId(), Level.INFO, "Mod %s is missing the required element 'name'. Substituting %s", new Object[] { getModId(), getModId() });
/* 181 */       this.modMetadata.name = getModId();
/*     */     } 
/* 183 */     this.internalVersion = (String)this.descriptor.get("version");
/* 184 */     if (Strings.isNullOrEmpty(this.internalVersion)) {
/*     */       
/* 186 */       Properties versionProps = searchForVersionProperties();
/* 187 */       if (versionProps != null) {
/*     */         
/* 189 */         this.internalVersion = versionProps.getProperty(getModId() + ".version");
/* 190 */         FMLLog.log(getModId(), Level.DEBUG, "Found version %s for mod %s in version.properties, using", new Object[] { this.internalVersion, getModId() });
/*     */       } 
/*     */     } 
/*     */     
/* 194 */     if (Strings.isNullOrEmpty(this.internalVersion) && !Strings.isNullOrEmpty(this.modMetadata.version)) {
/*     */       
/* 196 */       FMLLog.log(getModId(), Level.WARN, "Mod %s is missing the required element 'version' and a version.properties file could not be found. Falling back to metadata version %s", new Object[] { getModId(), this.modMetadata.version });
/* 197 */       this.internalVersion = this.modMetadata.version;
/*     */     } 
/* 199 */     if (Strings.isNullOrEmpty(this.internalVersion)) {
/*     */       
/* 201 */       FMLLog.log(getModId(), Level.WARN, "Mod %s is missing the required element 'version' and no fallback can be found. Substituting '1.0'.", new Object[] { getModId() });
/* 202 */       this.modMetadata.version = this.internalVersion = "1.0";
/*     */     } 
/*     */     
/* 205 */     String mcVersionString = (String)this.descriptor.get("acceptedMinecraftVersions");
/* 206 */     if (!Strings.isNullOrEmpty(mcVersionString)) {
/*     */       
/* 208 */       this.minecraftAccepted = VersionParser.parseRange(mcVersionString);
/*     */     }
/*     */     else {
/*     */       
/* 212 */       this.minecraftAccepted = Loader.instance().getMinecraftModContainer().getStaticVersionRange();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Properties searchForVersionProperties() {
/*     */     try {
/* 220 */       FMLLog.log(getModId(), Level.DEBUG, "Attempting to load the file version.properties from %s to locate a version number for %s", new Object[] { getSource().getName(), getModId() });
/* 221 */       Properties version = null;
/* 222 */       if (getSource().isFile()) {
/*     */         
/* 224 */         ZipFile source = new ZipFile(getSource());
/* 225 */         ZipEntry versionFile = source.getEntry("version.properties");
/* 226 */         if (versionFile != null) {
/*     */           
/* 228 */           version = new Properties();
/* 229 */           version.load(source.getInputStream(versionFile));
/*     */         } 
/* 231 */         source.close();
/*     */       }
/* 233 */       else if (getSource().isDirectory()) {
/*     */         
/* 235 */         File propsFile = new File(getSource(), "version.properties");
/* 236 */         if (propsFile.exists() && propsFile.isFile()) {
/*     */           
/* 238 */           version = new Properties();
/* 239 */           FileInputStream fis = new FileInputStream(propsFile);
/* 240 */           version.load(fis);
/* 241 */           fis.close();
/*     */         } 
/*     */       } 
/* 244 */       return version;
/*     */     }
/* 246 */     catch (Exception e) {
/*     */       
/* 248 */       Throwables.propagateIfPossible(e);
/* 249 */       FMLLog.log(getModId(), Level.TRACE, "Failed to find a usable version.properties file", new Object[0]);
/* 250 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnabledState(boolean enabled) {
/* 257 */     this.enabled = enabled;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Set<ArtifactVersion> getRequirements() {
/* 263 */     return this.modMetadata.requiredMods;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ArtifactVersion> getDependencies() {
/* 269 */     return this.modMetadata.dependencies;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ArtifactVersion> getDependants() {
/* 275 */     return this.modMetadata.dependants;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSortingRules() {
/* 281 */     return (this.overridesMetadata || !this.modMetadata.useDependencyInformation) ? Strings.nullToEmpty(this.annotationDependencies) : this.modMetadata.printableSortingRules();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean matches(Object mod) {
/* 287 */     return (mod == this.modInstance);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object getMod() {
/* 293 */     return this.modInstance;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerBus(EventBus bus, LoadController controller) {
/* 299 */     if (this.enabled) {
/*     */       
/* 301 */       FMLLog.log(getModId(), Level.DEBUG, "Enabling mod %s", new Object[] { getModId() });
/* 302 */       this.eventBus = bus;
/* 303 */       this.controller = controller;
/* 304 */       this.eventBus.register(this);
/* 305 */       return true;
/*     */     } 
/*     */ 
/*     */     
/* 309 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Method gatherAnnotations(Class<?> clazz) throws Exception {
/* 316 */     Method factoryMethod = null;
/* 317 */     for (Method m : clazz.getDeclaredMethods()) {
/*     */       
/* 319 */       for (Annotation a : m.getAnnotations()) {
/*     */         
/* 321 */         if (a.annotationType().equals(Mod.EventHandler.class)) {
/*     */           
/* 323 */           if ((m.getParameterTypes()).length == 1 && FMLEvent.class.isAssignableFrom(m.getParameterTypes()[0]))
/*     */           {
/* 325 */             m.setAccessible(true);
/* 326 */             this.eventMethods.put(m.getParameterTypes()[0], m);
/*     */           }
/*     */           else
/*     */           {
/* 330 */             FMLLog.log(getModId(), Level.ERROR, "The mod %s appears to have an invalid event annotation %s. This annotation can only apply to methods with recognized event arguments - it will not be called", new Object[] { getModId(), a.annotationType().getSimpleName() });
/*     */           }
/*     */         
/* 333 */         } else if (a.annotationType().equals(Mod.InstanceFactory.class)) {
/*     */           
/* 335 */           if (Modifier.isStatic(m.getModifiers()) && (m.getParameterTypes()).length == 0 && factoryMethod == null) {
/*     */             
/* 337 */             m.setAccessible(true);
/* 338 */             factoryMethod = m;
/*     */           }
/* 340 */           else if (!Modifier.isStatic(m.getModifiers()) || (m.getParameterTypes()).length != 0) {
/*     */             
/* 342 */             FMLLog.log(getModId(), Level.ERROR, "The InstanceFactory annotation can only apply to a static method, taking zero arguments - it will be ignored on %s(%s)", new Object[] { m.getName(), Arrays.asList(m.getParameterTypes()) });
/*     */           }
/* 344 */           else if (factoryMethod != null) {
/*     */             
/* 346 */             FMLLog.log(getModId(), Level.ERROR, "The InstanceFactory annotation can only be used once, the application to %s(%s) will be ignored", new Object[] { m.getName(), Arrays.asList(m.getParameterTypes()) });
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 351 */     return factoryMethod;
/*     */   }
/*     */ 
/*     */   
/*     */   private void processFieldAnnotations(ASMDataTable asmDataTable) throws Exception {
/* 356 */     SetMultimap<String, ASMDataTable.ASMData> annotations = asmDataTable.getAnnotationsFor(this);
/*     */     
/* 358 */     parseSimpleFieldAnnotation(annotations, Mod.Instance.class.getName(), new Function<ModContainer, Object>()
/*     */         {
/*     */           
/*     */           public Object apply(ModContainer mc)
/*     */           {
/* 363 */             return mc.getMod();
/*     */           }
/*     */         });
/* 366 */     parseSimpleFieldAnnotation(annotations, Mod.Metadata.class.getName(), new Function<ModContainer, Object>()
/*     */         {
/*     */           
/*     */           public Object apply(ModContainer mc)
/*     */           {
/* 371 */             return mc.getMetadata();
/*     */           }
/*     */         });
/*     */   }
/*     */ 
/*     */   
/*     */   private void parseSimpleFieldAnnotation(SetMultimap<String, ASMDataTable.ASMData> annotations, String annotationClassName, Function<ModContainer, Object> retreiver) throws IllegalAccessException {
/* 378 */     String[] annName = annotationClassName.split("\\.");
/* 379 */     String annotationName = annName[annName.length - 1];
/* 380 */     for (ASMDataTable.ASMData targets : annotations.get(annotationClassName)) {
/*     */       
/* 382 */       String targetMod = (String)targets.getAnnotationInfo().get("value");
/* 383 */       Field f = null;
/* 384 */       Object injectedMod = null;
/* 385 */       ModContainer mc = this;
/* 386 */       boolean isStatic = false;
/* 387 */       Class<?> clz = this.modInstance.getClass();
/* 388 */       if (!Strings.isNullOrEmpty(targetMod))
/*     */       {
/* 390 */         if (Loader.isModLoaded(targetMod)) {
/*     */           
/* 392 */           mc = Loader.instance().getIndexedModList().get(targetMod);
/*     */         }
/*     */         else {
/*     */           
/* 396 */           mc = null;
/*     */         } 
/*     */       }
/* 399 */       if (mc != null) {
/*     */         
/*     */         try {
/*     */           
/* 403 */           clz = Class.forName(targets.getClassName(), true, Loader.instance().getModClassLoader());
/* 404 */           f = clz.getDeclaredField(targets.getObjectName());
/* 405 */           f.setAccessible(true);
/* 406 */           isStatic = Modifier.isStatic(f.getModifiers());
/* 407 */           injectedMod = retreiver.apply(mc);
/*     */         }
/* 409 */         catch (Exception e) {
/*     */           
/* 411 */           Throwables.propagateIfPossible(e);
/* 412 */           FMLLog.log(getModId(), Level.WARN, e, "Attempting to load @%s in class %s for %s and failing", new Object[] { annotationName, targets.getClassName(), mc.getModId() });
/*     */         } 
/*     */       }
/* 415 */       if (f != null) {
/*     */         
/* 417 */         Object target = null;
/* 418 */         if (!isStatic) {
/*     */           
/* 420 */           target = this.modInstance;
/* 421 */           if (!this.modInstance.getClass().equals(clz)) {
/*     */             
/* 423 */             FMLLog.log(getModId(), Level.WARN, "Unable to inject @%s in non-static field %s.%s for %s as it is NOT the primary mod instance", new Object[] { annotationName, targets.getClassName(), targets.getObjectName(), mc.getModId() });
/*     */             continue;
/*     */           } 
/*     */         } 
/* 427 */         f.set(target, injectedMod);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Subscribe
/*     */   public void constructMod(FMLConstructionEvent event) {
/*     */     try {
/* 437 */       ModClassLoader modClassLoader = event.getModClassLoader();
/* 438 */       modClassLoader.addFile(this.source);
/* 439 */       modClassLoader.clearNegativeCacheFor(this.candidate.getClassList());
/* 440 */       Class<?> clazz = Class.forName(this.className, true, modClassLoader);
/*     */       
/* 442 */       Certificate[] certificates = clazz.getProtectionDomain().getCodeSource().getCertificates();
/* 443 */       int len = 0;
/* 444 */       if (certificates != null)
/*     */       {
/* 446 */         len = certificates.length;
/*     */       }
/* 448 */       ImmutableList.Builder<String> certBuilder = ImmutableList.builder();
/* 449 */       for (int i = 0; i < len; i++)
/*     */       {
/* 451 */         certBuilder.add(CertificateHelper.getFingerprint(certificates[i]));
/*     */       }
/*     */       
/* 454 */       ImmutableList<String> certList = certBuilder.build();
/* 455 */       this.sourceFingerprints = (Set<String>)ImmutableSet.copyOf((Collection)certList);
/*     */       
/* 457 */       String expectedFingerprint = (String)this.descriptor.get("certificateFingerprint");
/*     */       
/* 459 */       this.fingerprintNotPresent = true;
/*     */       
/* 461 */       if (expectedFingerprint != null && !expectedFingerprint.isEmpty())
/*     */       {
/* 463 */         if (!this.sourceFingerprints.contains(expectedFingerprint)) {
/*     */           
/* 465 */           Level warnLevel = Level.ERROR;
/* 466 */           if (this.source.isDirectory())
/*     */           {
/* 468 */             warnLevel = Level.TRACE;
/*     */           }
/* 470 */           FMLLog.log(getModId(), warnLevel, "The mod %s is expecting signature %s for source %s, however there is no signature matching that description", new Object[] { getModId(), expectedFingerprint, this.source.getName() });
/*     */         }
/*     */         else {
/*     */           
/* 474 */           this.certificate = certificates[certList.indexOf(expectedFingerprint)];
/* 475 */           this.fingerprintNotPresent = false;
/*     */         } 
/*     */       }
/*     */ 
/*     */       
/* 480 */       List<Map<String, Object>> props = (List<Map<String, Object>>)this.descriptor.get("customProperties");
/* 481 */       if (props != null) {
/*     */         
/* 483 */         ImmutableMap.Builder<String, String> builder = ImmutableMap.builder();
/* 484 */         for (Map<String, Object> p : props)
/*     */         {
/* 486 */           builder.put(p.get("k"), p.get("v"));
/*     */         }
/* 488 */         this.customModProperties = (Map<String, String>)builder.build();
/*     */       }
/*     */       else {
/*     */         
/* 492 */         this.customModProperties = EMPTY_PROPERTIES;
/*     */       } 
/*     */       
/* 495 */       Boolean hasDisableableFlag = (Boolean)this.descriptor.get("canBeDeactivated");
/* 496 */       boolean hasReverseDepends = !event.getReverseDependencies().get(getModId()).isEmpty();
/* 497 */       if (hasDisableableFlag != null && hasDisableableFlag.booleanValue()) {
/*     */         
/* 499 */         this.disableability = hasReverseDepends ? ModContainer.Disableable.DEPENDENCIES : ModContainer.Disableable.YES;
/*     */       }
/*     */       else {
/*     */         
/* 503 */         this.disableability = hasReverseDepends ? ModContainer.Disableable.DEPENDENCIES : ModContainer.Disableable.RESTART;
/*     */       } 
/* 505 */       Method factoryMethod = gatherAnnotations(clazz);
/* 506 */       this.modInstance = getLanguageAdapter().getNewInstance(this, clazz, modClassLoader, factoryMethod);
/* 507 */       NetworkRegistry.INSTANCE.register(this, clazz, this.descriptor.containsKey("acceptableRemoteVersions") ? (String)this.descriptor.get("acceptableRemoteVersions") : null, event.getASMHarvestedData());
/* 508 */       if (this.fingerprintNotPresent)
/*     */       {
/* 510 */         this.eventBus.post(new FMLFingerprintViolationEvent(this.source.isDirectory(), this.source, ImmutableSet.copyOf(this.sourceFingerprints), expectedFingerprint));
/*     */       }
/* 512 */       ProxyInjector.inject(this, event.getASMHarvestedData(), FMLCommonHandler.instance().getSide(), getLanguageAdapter());
/* 513 */       processFieldAnnotations(event.getASMHarvestedData());
/*     */     }
/* 515 */     catch (Throwable e) {
/*     */       
/* 517 */       this.controller.errorOccurred(this, e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @Subscribe
/*     */   public void handleModStateEvent(FMLEvent event) {
/* 524 */     if (!this.eventMethods.containsKey(event.getClass())) {
/*     */       return;
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 530 */       for (Method m : this.eventMethods.get(event.getClass()))
/*     */       {
/* 532 */         m.invoke(this.modInstance, new Object[] { event });
/*     */       }
/*     */     
/* 535 */     } catch (Throwable t) {
/*     */       
/* 537 */       this.controller.errorOccurred(this, t);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ArtifactVersion getProcessedVersion() {
/* 544 */     if (this.processedVersion == null)
/*     */     {
/* 546 */       this.processedVersion = new DefaultArtifactVersion(getModId(), getVersion());
/*     */     }
/* 548 */     return (ArtifactVersion)this.processedVersion;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isImmutable() {
/* 553 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDisplayVersion() {
/* 559 */     return this.modMetadata.version;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public VersionRange acceptableMinecraftVersionRange() {
/* 565 */     return this.minecraftAccepted;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Certificate getSigningCertificate() {
/* 571 */     return this.certificate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 577 */     return "FMLMod:" + getModId() + "{" + getVersion() + "}";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, String> getCustomModProperties() {
/* 583 */     return this.customModProperties;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class<?> getCustomResourcePackClass() {
/*     */     try {
/* 591 */       return getSource().isDirectory() ? Class.forName("cpw.mods.fml.client.FMLFolderResourcePack", true, getClass().getClassLoader()) : Class.forName("cpw.mods.fml.client.FMLFileResourcePack", true, getClass().getClassLoader());
/*     */     }
/* 593 */     catch (ClassNotFoundException e) {
/*     */       
/* 595 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Map<String, String> getSharedModDescriptor() {
/* 601 */     Map<String, String> descriptor = Maps.newHashMap();
/* 602 */     descriptor.put("modsystem", "FML");
/* 603 */     descriptor.put("id", getModId());
/* 604 */     descriptor.put("version", getDisplayVersion());
/* 605 */     descriptor.put("name", getName());
/* 606 */     descriptor.put("url", this.modMetadata.url);
/* 607 */     descriptor.put("authors", this.modMetadata.getAuthorList());
/* 608 */     descriptor.put("description", this.modMetadata.description);
/* 609 */     return descriptor;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ModContainer.Disableable canBeDisabled() {
/* 615 */     return this.disableability;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGuiClassName() {
/* 621 */     return (String)this.descriptor.get("guiFactory");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getOwnedPackages() {
/* 627 */     return this.candidate.getContainedPackages();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\FMLModContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */