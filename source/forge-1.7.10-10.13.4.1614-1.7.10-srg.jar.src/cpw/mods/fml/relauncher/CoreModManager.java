/*     */ package cpw.mods.fml.relauncher;
/*     */ 
/*     */ import com.google.common.base.Strings;
/*     */ import com.google.common.base.Throwables;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.ObjectArrays;
/*     */ import com.google.common.primitives.Ints;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.launcher.FMLInjectionAndSortingTweaker;
/*     */ import cpw.mods.fml.common.launcher.FMLTweaker;
/*     */ import cpw.mods.fml.common.toposort.TopologicalSort;
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.FilenameFilter;
/*     */ import java.io.IOException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.net.URL;
/*     */ import java.net.URLClassLoader;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Calendar;
/*     */ import java.util.Comparator;
/*     */ import java.util.HashMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.jar.Attributes;
/*     */ import java.util.jar.JarFile;
/*     */ import net.minecraft.launchwrapper.ITweaker;
/*     */ import net.minecraft.launchwrapper.Launch;
/*     */ import net.minecraft.launchwrapper.LaunchClassLoader;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CoreModManager
/*     */ {
/*  60 */   private static final Attributes.Name COREMODCONTAINSFMLMOD = new Attributes.Name("FMLCorePluginContainsFMLMod");
/*  61 */   private static final Attributes.Name MODTYPE = new Attributes.Name("ModType");
/*  62 */   private static final Attributes.Name MODSIDE = new Attributes.Name("ModSide");
/*  63 */   private static String[] rootPlugins = new String[] { "cpw.mods.fml.relauncher.FMLCorePlugin", "net.minecraftforge.classloading.FMLForgePlugin" };
/*  64 */   private static List<String> loadedCoremods = Lists.newArrayList();
/*     */   private static List<FMLPluginWrapper> loadPlugins;
/*     */   private static boolean deobfuscatedEnvironment;
/*     */   private static FMLTweaker tweaker;
/*     */   private static File mcDir;
/*  69 */   private static List<String> reparsedCoremods = Lists.newArrayList();
/*  70 */   private static List<String> accessTransformers = Lists.newArrayList();
/*     */   private static Method ADDURL;
/*     */   
/*     */   private static class FMLPluginWrapper
/*     */     implements ITweaker {
/*     */     public final String name;
/*     */     public final IFMLLoadingPlugin coreModInstance;
/*     */     public final List<String> predepends;
/*     */     public final File location;
/*     */     public final int sortIndex;
/*     */     
/*     */     public FMLPluginWrapper(String name, IFMLLoadingPlugin coreModInstance, File location, int sortIndex, String... predepends) {
/*  82 */       this.name = name;
/*  83 */       this.coreModInstance = coreModInstance;
/*  84 */       this.location = location;
/*  85 */       this.sortIndex = sortIndex;
/*  86 */       this.predepends = Lists.newArrayList((Object[])predepends);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/*  92 */       return String.format("%s {%s}", new Object[] { this.name, this.predepends });
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {}
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void injectIntoClassLoader(LaunchClassLoader classLoader) {
/* 104 */       FMLRelaunchLog.fine("Injecting coremod %s {%s} class transformers", new Object[] { this.name, this.coreModInstance.getClass().getName() });
/* 105 */       if (this.coreModInstance.getASMTransformerClass() != null) for (String transformer : this.coreModInstance.getASMTransformerClass()) {
/*     */           
/* 107 */           FMLRelaunchLog.finer("Registering transformer %s", new Object[] { transformer });
/* 108 */           classLoader.registerTransformer(transformer);
/*     */         }  
/* 110 */       FMLRelaunchLog.fine("Injection complete", new Object[0]);
/*     */       
/* 112 */       FMLRelaunchLog.fine("Running coremod plugin for %s {%s}", new Object[] { this.name, this.coreModInstance.getClass().getName() });
/* 113 */       Map<String, Object> data = new HashMap<String, Object>();
/* 114 */       data.put("mcLocation", CoreModManager.mcDir);
/* 115 */       data.put("coremodList", CoreModManager.loadPlugins);
/* 116 */       data.put("runtimeDeobfuscationEnabled", Boolean.valueOf(!CoreModManager.deobfuscatedEnvironment));
/* 117 */       FMLRelaunchLog.fine("Running coremod plugin %s", new Object[] { this.name });
/* 118 */       data.put("coremodLocation", this.location);
/* 119 */       this.coreModInstance.injectData(data);
/* 120 */       String setupClass = this.coreModInstance.getSetupClass();
/* 121 */       if (setupClass != null) {
/*     */         
/*     */         try {
/*     */           
/* 125 */           IFMLCallHook call = (IFMLCallHook)Class.forName(setupClass, true, (ClassLoader)classLoader).newInstance();
/* 126 */           Map<String, Object> callData = new HashMap<String, Object>();
/* 127 */           callData.put("runtimeDeobfuscationEnabled", Boolean.valueOf(!CoreModManager.deobfuscatedEnvironment));
/* 128 */           callData.put("mcLocation", CoreModManager.mcDir);
/* 129 */           callData.put("classLoader", classLoader);
/* 130 */           callData.put("coremodLocation", this.location);
/* 131 */           callData.put("deobfuscationFileName", FMLInjectionData.debfuscationDataName());
/* 132 */           call.injectData(callData);
/* 133 */           call.call();
/*     */         }
/* 135 */         catch (Exception e) {
/*     */           
/* 137 */           throw new RuntimeException(e);
/*     */         } 
/*     */       }
/* 140 */       FMLRelaunchLog.fine("Coremod plugin class %s run successfully", new Object[] { this.coreModInstance.getClass().getSimpleName() });
/*     */       
/* 142 */       String modContainer = this.coreModInstance.getModContainerClass();
/* 143 */       if (modContainer != null)
/*     */       {
/* 145 */         FMLInjectionData.containers.add(modContainer);
/*     */       }
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String getLaunchTarget() {
/* 152 */       return "";
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public String[] getLaunchArguments() {
/* 158 */       return new String[0];
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void handleLaunch(File mcDir, LaunchClassLoader classLoader, FMLTweaker tweaker) {
/* 165 */     CoreModManager.mcDir = mcDir;
/* 166 */     CoreModManager.tweaker = tweaker;
/*     */ 
/*     */     
/*     */     try {
/* 170 */       byte[] bs = classLoader.getClassBytes("net.minecraft.world.World");
/* 171 */       if (bs != null)
/*     */       {
/* 173 */         FMLRelaunchLog.info("Managed to load a deobfuscated Minecraft name- we are in a deobfuscated environment. Skipping runtime deobfuscation", new Object[0]);
/* 174 */         deobfuscatedEnvironment = true;
/*     */       }
/*     */     
/* 177 */     } catch (IOException iOException) {}
/*     */ 
/*     */ 
/*     */     
/* 181 */     if (!deobfuscatedEnvironment)
/*     */     {
/* 183 */       FMLRelaunchLog.fine("Enabling runtime deobfuscation", new Object[0]);
/*     */     }
/*     */     
/* 186 */     tweaker.injectCascadingTweak("cpw.mods.fml.common.launcher.FMLInjectionAndSortingTweaker");
/*     */     
/*     */     try {
/* 189 */       classLoader.registerTransformer("cpw.mods.fml.common.asm.transformers.PatchingTransformer");
/*     */     }
/* 191 */     catch (Exception e) {
/*     */       
/* 193 */       FMLRelaunchLog.log(Level.ERROR, e, "The patch transformer failed to load! This is critical, loading cannot continue!", new Object[0]);
/* 194 */       throw Throwables.propagate(e);
/*     */     } 
/*     */     
/* 197 */     loadPlugins = new ArrayList<FMLPluginWrapper>();
/* 198 */     for (String rootPluginName : rootPlugins)
/*     */     {
/* 200 */       loadCoreMod(classLoader, rootPluginName, new File(FMLTweaker.getJarLocation()));
/*     */     }
/*     */     
/* 203 */     if (loadPlugins.isEmpty())
/*     */     {
/* 205 */       throw new RuntimeException("A fatal error has occured - no valid fml load plugin was found - this is a completely corrupt FML installation.");
/*     */     }
/*     */     
/* 208 */     FMLRelaunchLog.fine("All fundamental core mods are successfully located", new Object[0]);
/*     */ 
/*     */     
/* 211 */     String commandLineCoremods = System.getProperty("fml.coreMods.load", "");
/* 212 */     for (String coreModClassName : commandLineCoremods.split(",")) {
/*     */       
/* 214 */       if (!coreModClassName.isEmpty()) {
/*     */ 
/*     */ 
/*     */         
/* 218 */         FMLRelaunchLog.info("Found a command line coremod : %s", new Object[] { coreModClassName });
/* 219 */         loadCoreMod(classLoader, coreModClassName, null);
/*     */       } 
/* 221 */     }  discoverCoreMods(mcDir, classLoader);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void discoverCoreMods(File mcDir, LaunchClassLoader classLoader) {
/* 227 */     ModListHelper.parseModList(mcDir);
/* 228 */     FMLRelaunchLog.fine("Discovering coremods", new Object[0]);
/* 229 */     File coreMods = setupCoreModDir(mcDir);
/* 230 */     FilenameFilter ff = new FilenameFilter()
/*     */       {
/*     */         public boolean accept(File dir, String name)
/*     */         {
/* 234 */           return name.endsWith(".jar");
/*     */         }
/*     */       };
/* 237 */     FilenameFilter derpfilter = new FilenameFilter()
/*     */       {
/*     */         public boolean accept(File dir, String name)
/*     */         {
/* 241 */           return name.endsWith(".jar.zip");
/*     */         }
/*     */       };
/* 244 */     File[] derplist = coreMods.listFiles(derpfilter);
/* 245 */     if (derplist != null && derplist.length > 0) {
/*     */       
/* 247 */       FMLRelaunchLog.severe("FML has detected several badly downloaded jar files,  which have been named as zip files. You probably need to download them again, or they may not work properly", new Object[0]);
/* 248 */       for (File f : derplist) {
/*     */         
/* 250 */         FMLRelaunchLog.severe("Problem file : %s", new Object[] { f.getName() });
/*     */       } 
/*     */     } 
/* 253 */     FileFilter derpdirfilter = new FileFilter()
/*     */       {
/*     */         public boolean accept(File pathname)
/*     */         {
/* 257 */           return (pathname.isDirectory() && (new File(pathname, "META-INF")).isDirectory());
/*     */         }
/*     */       };
/*     */     
/* 261 */     File[] derpdirlist = coreMods.listFiles(derpdirfilter);
/* 262 */     if (derpdirlist != null && derpdirlist.length > 0) {
/*     */       
/* 264 */       FMLRelaunchLog.log.getLogger().log(Level.FATAL, "There appear to be jars extracted into the mods directory. This is VERY BAD and will almost NEVER WORK WELL");
/* 265 */       FMLRelaunchLog.log.getLogger().log(Level.FATAL, "You should place original jars only in the mods directory. NEVER extract them to the mods directory.");
/* 266 */       FMLRelaunchLog.log.getLogger().log(Level.FATAL, "The directories below appear to be extracted jar files. Fix this before you continue.");
/*     */       
/* 268 */       for (File f : derpdirlist) {
/*     */         
/* 270 */         FMLRelaunchLog.log.getLogger().log(Level.FATAL, "Directory {} contains {}", new Object[] { f.getName(), Arrays.asList((new File(f, "META-INF")).list()) });
/*     */       } 
/*     */       
/* 273 */       RuntimeException re = new RuntimeException("Extracted mod jars found, loading will NOT continue");
/*     */ 
/*     */       
/*     */       try {
/* 277 */         Class<?> crashreportclass = classLoader.loadClass("b");
/* 278 */         Object crashreport = crashreportclass.getMethod("a", new Class[] { Throwable.class, String.class }).invoke(null, new Object[] { re, "FML has discovered extracted jar files in the mods directory.\nThis breaks mod loading functionality completely.\nRemove the directories and replace with the jar files originally provided." });
/* 279 */         File crashreportfile = new File(new File(coreMods.getParentFile(), "crash-reports"), String.format("fml-crash-%1$tY-%1$tm-%1$td_%1$tT.txt", new Object[] { Calendar.getInstance() }));
/* 280 */         crashreportclass.getMethod("a", new Class[] { File.class }).invoke(crashreport, new Object[] { crashreportfile });
/* 281 */         System.out.println("#@!@# FML has crashed the game deliberately. Crash report saved to: #@!@# " + crashreportfile.getAbsolutePath());
/* 282 */       } catch (Exception e) {
/*     */         
/* 284 */         e.printStackTrace();
/*     */       } 
/*     */       
/* 287 */       throw re;
/*     */     } 
/* 289 */     File[] coreModList = coreMods.listFiles(ff);
/* 290 */     File versionedModDir = new File(coreMods, FMLInjectionData.mccversion);
/* 291 */     if (versionedModDir.isDirectory()) {
/*     */       
/* 293 */       File[] versionedCoreMods = versionedModDir.listFiles(ff);
/* 294 */       coreModList = (File[])ObjectArrays.concat((Object[])coreModList, (Object[])versionedCoreMods, File.class);
/*     */     } 
/*     */     
/* 297 */     coreModList = (File[])ObjectArrays.concat((Object[])coreModList, ModListHelper.additionalMods.values().toArray((Object[])new File[0]), File.class);
/*     */     
/* 299 */     coreModList = FileListHelper.sortFileList(coreModList);
/*     */     
/* 301 */     for (File coreMod : coreModList) {
/*     */       
/* 303 */       FMLRelaunchLog.fine("Examining for coremod candidacy %s", new Object[] { coreMod.getName() });
/* 304 */       JarFile jar = null;
/*     */     } 
/*     */   }
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
/*     */   private static void handleCascadingTweak(File coreMod, JarFile jar, String cascadedTweaker, LaunchClassLoader classLoader, Integer sortingOrder) {
/*     */     try {
/* 400 */       if (ADDURL == null) {
/*     */         
/* 402 */         ADDURL = URLClassLoader.class.getDeclaredMethod("addURL", new Class[] { URL.class });
/* 403 */         ADDURL.setAccessible(true);
/*     */       } 
/* 405 */       ADDURL.invoke(classLoader.getClass().getClassLoader(), new Object[] { coreMod.toURI().toURL() });
/* 406 */       classLoader.addURL(coreMod.toURI().toURL());
/* 407 */       tweaker.injectCascadingTweak(cascadedTweaker);
/* 408 */       tweakSorting.put(cascadedTweaker, sortingOrder);
/*     */     }
/* 410 */     catch (Exception e) {
/*     */       
/* 412 */       FMLRelaunchLog.log(Level.INFO, e, "There was a problem trying to load the mod dir tweaker %s", new Object[] { coreMod.getAbsolutePath() });
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static File setupCoreModDir(File mcDir) {
/* 423 */     File coreModDir = new File(mcDir, "mods");
/*     */     
/*     */     try {
/* 426 */       coreModDir = coreModDir.getCanonicalFile();
/*     */     }
/* 428 */     catch (IOException e) {
/*     */       
/* 430 */       throw new RuntimeException(String.format("Unable to canonicalize the coremod dir at %s", new Object[] { mcDir.getName() }), e);
/*     */     } 
/* 432 */     if (!coreModDir.exists()) {
/*     */       
/* 434 */       coreModDir.mkdir();
/*     */     }
/* 436 */     else if (coreModDir.exists() && !coreModDir.isDirectory()) {
/*     */       
/* 438 */       throw new RuntimeException(String.format("Found a coremod file in %s that's not a directory", new Object[] { mcDir.getName() }));
/*     */     } 
/* 440 */     return coreModDir;
/*     */   }
/*     */ 
/*     */   
/*     */   public static List<String> getLoadedCoremods() {
/* 445 */     return loadedCoremods;
/*     */   }
/*     */ 
/*     */   
/*     */   public static List<String> getReparseableCoremods() {
/* 450 */     return reparsedCoremods;
/*     */   }
/*     */ 
/*     */   
/*     */   private static FMLPluginWrapper loadCoreMod(LaunchClassLoader classLoader, String coreModClass, File location) {
/* 455 */     String coreModName = coreModClass.substring(coreModClass.lastIndexOf('.') + 1);
/*     */     
/*     */     try {
/* 458 */       FMLRelaunchLog.fine("Instantiating coremod class %s", new Object[] { coreModName });
/* 459 */       classLoader.addTransformerExclusion(coreModClass);
/* 460 */       Class<?> coreModClazz = Class.forName(coreModClass, true, (ClassLoader)classLoader);
/* 461 */       IFMLLoadingPlugin.Name coreModNameAnn = coreModClazz.<IFMLLoadingPlugin.Name>getAnnotation(IFMLLoadingPlugin.Name.class);
/* 462 */       if (coreModNameAnn != null && !Strings.isNullOrEmpty(coreModNameAnn.value())) {
/*     */         
/* 464 */         coreModName = coreModNameAnn.value();
/* 465 */         FMLRelaunchLog.finer("coremod named %s is loading", new Object[] { coreModName });
/*     */       } 
/* 467 */       IFMLLoadingPlugin.MCVersion requiredMCVersion = coreModClazz.<IFMLLoadingPlugin.MCVersion>getAnnotation(IFMLLoadingPlugin.MCVersion.class);
/* 468 */       if (!Arrays.<String>asList(rootPlugins).contains(coreModClass) && (requiredMCVersion == null || Strings.isNullOrEmpty(requiredMCVersion.value()))) {
/*     */         
/* 470 */         FMLRelaunchLog.log(Level.WARN, "The coremod %s does not have a MCVersion annotation, it may cause issues with this version of Minecraft", new Object[] { coreModClass });
/*     */       } else {
/*     */         
/* 473 */         if (requiredMCVersion != null && !FMLInjectionData.mccversion.equals(requiredMCVersion.value())) {
/*     */           
/* 475 */           FMLRelaunchLog.log(Level.ERROR, "The coremod %s is requesting minecraft version %s and minecraft is %s. It will be ignored.", new Object[] { coreModClass, requiredMCVersion
/* 476 */                 .value(), FMLInjectionData.mccversion });
/* 477 */           return null;
/*     */         } 
/* 479 */         if (requiredMCVersion != null)
/*     */         {
/* 481 */           FMLRelaunchLog.log(Level.DEBUG, "The coremod %s requested minecraft version %s and minecraft is %s. It will be loaded.", new Object[] { coreModClass, requiredMCVersion
/* 482 */                 .value(), FMLInjectionData.mccversion }); } 
/*     */       } 
/* 484 */       IFMLLoadingPlugin.TransformerExclusions trExclusions = coreModClazz.<IFMLLoadingPlugin.TransformerExclusions>getAnnotation(IFMLLoadingPlugin.TransformerExclusions.class);
/* 485 */       if (trExclusions != null)
/*     */       {
/* 487 */         for (String st : trExclusions.value())
/*     */         {
/* 489 */           classLoader.addTransformerExclusion(st);
/*     */         }
/*     */       }
/* 492 */       IFMLLoadingPlugin.DependsOn deplist = coreModClazz.<IFMLLoadingPlugin.DependsOn>getAnnotation(IFMLLoadingPlugin.DependsOn.class);
/* 493 */       String[] dependencies = new String[0];
/* 494 */       if (deplist != null)
/*     */       {
/* 496 */         dependencies = deplist.value();
/*     */       }
/* 498 */       IFMLLoadingPlugin.SortingIndex index = coreModClazz.<IFMLLoadingPlugin.SortingIndex>getAnnotation(IFMLLoadingPlugin.SortingIndex.class);
/* 499 */       int sortIndex = (index != null) ? index.value() : 0;
/*     */       
/* 501 */       IFMLLoadingPlugin plugin = (IFMLLoadingPlugin)coreModClazz.newInstance();
/* 502 */       String accessTransformerClass = plugin.getAccessTransformerClass();
/* 503 */       if (accessTransformerClass != null) {
/*     */         
/* 505 */         FMLRelaunchLog.log(Level.DEBUG, "Added access transformer class %s to enqueued access transformers", new Object[] { accessTransformerClass });
/* 506 */         accessTransformers.add(accessTransformerClass);
/*     */       } 
/* 508 */       FMLPluginWrapper wrap = new FMLPluginWrapper(coreModName, plugin, location, sortIndex, dependencies);
/* 509 */       loadPlugins.add(wrap);
/* 510 */       FMLRelaunchLog.fine("Enqueued coremod %s", new Object[] { coreModName });
/* 511 */       return wrap;
/*     */     }
/* 513 */     catch (ClassNotFoundException cnfe) {
/*     */       
/* 515 */       if (!Lists.newArrayList((Object[])rootPlugins).contains(coreModClass)) {
/* 516 */         FMLRelaunchLog.log(Level.ERROR, cnfe, "Coremod %s: Unable to class load the plugin %s", new Object[] { coreModName, coreModClass });
/*     */       } else {
/* 518 */         FMLRelaunchLog.fine("Skipping root plugin %s", new Object[] { coreModClass });
/*     */       } 
/* 520 */     } catch (ClassCastException cce) {
/*     */       
/* 522 */       FMLRelaunchLog.log(Level.ERROR, cce, "Coremod %s: The plugin %s is not an implementor of IFMLLoadingPlugin", new Object[] { coreModName, coreModClass });
/*     */     }
/* 524 */     catch (InstantiationException ie) {
/*     */       
/* 526 */       FMLRelaunchLog.log(Level.ERROR, ie, "Coremod %s: The plugin class %s was not instantiable", new Object[] { coreModName, coreModClass });
/*     */     }
/* 528 */     catch (IllegalAccessException iae) {
/*     */       
/* 530 */       FMLRelaunchLog.log(Level.ERROR, iae, "Coremod %s: The plugin class %s was not accessible", new Object[] { coreModName, coreModClass });
/*     */     } 
/* 532 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private static void sortCoreMods() {
/* 538 */     TopologicalSort.DirectedGraph<FMLPluginWrapper> sortGraph = new TopologicalSort.DirectedGraph();
/* 539 */     Map<String, FMLPluginWrapper> pluginMap = Maps.newHashMap();
/* 540 */     for (FMLPluginWrapper plug : loadPlugins) {
/*     */       
/* 542 */       sortGraph.addNode(plug);
/* 543 */       pluginMap.put(plug.name, plug);
/*     */     } 
/*     */     
/* 546 */     for (FMLPluginWrapper plug : loadPlugins) {
/*     */       
/* 548 */       for (String dep : plug.predepends) {
/*     */         
/* 550 */         if (!pluginMap.containsKey(dep)) {
/*     */           
/* 552 */           FMLRelaunchLog.log(Level.ERROR, "Missing coremod dependency - the coremod %s depends on coremod %s which isn't present.", new Object[] { plug.name, dep });
/* 553 */           throw new RuntimeException();
/*     */         } 
/* 555 */         sortGraph.addEdge(plug, pluginMap.get(dep));
/*     */       } 
/*     */     } 
/*     */     
/*     */     try {
/* 560 */       loadPlugins = TopologicalSort.topologicalSort(sortGraph);
/* 561 */       FMLRelaunchLog.fine("Sorted coremod list %s", new Object[] { loadPlugins });
/*     */     }
/* 563 */     catch (Exception e) {
/*     */       
/* 565 */       FMLLog.log(Level.ERROR, e, "There was a problem performing the coremod sort", new Object[0]);
/* 566 */       throw Throwables.propagate(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void injectTransformers(LaunchClassLoader classLoader) {
/* 573 */     Launch.blackboard.put("fml.deobfuscatedEnvironment", Boolean.valueOf(deobfuscatedEnvironment));
/* 574 */     tweaker.injectCascadingTweak("cpw.mods.fml.common.launcher.FMLDeobfTweaker");
/* 575 */     tweakSorting.put("cpw.mods.fml.common.launcher.FMLDeobfTweaker", Integer.valueOf(1000));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void injectCoreModTweaks(FMLInjectionAndSortingTweaker fmlInjectionAndSortingTweaker) {
/* 581 */     List<ITweaker> tweakers = (List<ITweaker>)Launch.blackboard.get("Tweaks");
/*     */     
/* 583 */     tweakers.add(0, fmlInjectionAndSortingTweaker);
/* 584 */     for (FMLPluginWrapper wrapper : loadPlugins)
/*     */     {
/* 586 */       tweakers.add(wrapper);
/*     */     }
/*     */   }
/*     */   
/* 590 */   private static Map<String, Integer> tweakSorting = Maps.newHashMap();
/*     */ 
/*     */ 
/*     */   
/*     */   public static void sortTweakList() {
/* 595 */     List<ITweaker> tweakers = (List<ITweaker>)Launch.blackboard.get("Tweaks");
/*     */ 
/*     */     
/* 598 */     ITweaker[] toSort = tweakers.<ITweaker>toArray(new ITweaker[tweakers.size()]);
/* 599 */     Arrays.sort(toSort, new Comparator<ITweaker>()
/*     */         {
/*     */           public int compare(ITweaker o1, ITweaker o2)
/*     */           {
/* 603 */             Integer first = null;
/* 604 */             Integer second = null;
/* 605 */             if (o1 instanceof FMLInjectionAndSortingTweaker)
/*     */             {
/* 607 */               first = Integer.valueOf(-2147483648);
/*     */             }
/* 609 */             if (o2 instanceof FMLInjectionAndSortingTweaker)
/*     */             {
/* 611 */               second = Integer.valueOf(-2147483648);
/*     */             }
/*     */             
/* 614 */             if (o1 instanceof CoreModManager.FMLPluginWrapper) {
/*     */               
/* 616 */               first = Integer.valueOf(((CoreModManager.FMLPluginWrapper)o1).sortIndex);
/*     */             }
/* 618 */             else if (first == null) {
/*     */               
/* 620 */               first = (Integer)CoreModManager.tweakSorting.get(o1.getClass().getName());
/*     */             } 
/* 622 */             if (o2 instanceof CoreModManager.FMLPluginWrapper) {
/*     */               
/* 624 */               second = Integer.valueOf(((CoreModManager.FMLPluginWrapper)o2).sortIndex);
/*     */             }
/* 626 */             else if (second == null) {
/*     */               
/* 628 */               second = (Integer)CoreModManager.tweakSorting.get(o2.getClass().getName());
/*     */             } 
/* 630 */             if (first == null)
/*     */             {
/* 632 */               first = Integer.valueOf(0);
/*     */             }
/* 634 */             if (second == null)
/*     */             {
/* 636 */               second = Integer.valueOf(0);
/*     */             }
/*     */             
/* 639 */             return Ints.saturatedCast(first.intValue() - second.intValue());
/*     */           }
/*     */         });
/*     */ 
/*     */     
/* 644 */     for (int j = 0; j < toSort.length; j++) {
/* 645 */       tweakers.set(j, toSort[j]);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static List<String> getAccessTransformers() {
/* 651 */     return accessTransformers;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\relauncher\CoreModManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */