/*      */ package cpw.mods.fml.common;
/*      */ 
/*      */ import com.google.common.base.CharMatcher;
/*      */ import com.google.common.base.Function;
/*      */ import com.google.common.base.Joiner;
/*      */ import com.google.common.base.Splitter;
/*      */ import com.google.common.collect.ArrayListMultimap;
/*      */ import com.google.common.collect.BiMap;
/*      */ import com.google.common.collect.HashBiMap;
/*      */ import com.google.common.collect.ImmutableList;
/*      */ import com.google.common.collect.ImmutableMap;
/*      */ import com.google.common.collect.ImmutableMultiset;
/*      */ import com.google.common.collect.Iterables;
/*      */ import com.google.common.collect.LinkedHashMultimap;
/*      */ import com.google.common.collect.ListMultimap;
/*      */ import com.google.common.collect.Lists;
/*      */ import com.google.common.collect.Maps;
/*      */ import com.google.common.collect.Multimap;
/*      */ import com.google.common.collect.Multimaps;
/*      */ import com.google.common.collect.Multiset;
/*      */ import com.google.common.collect.Multisets;
/*      */ import com.google.common.collect.Ordering;
/*      */ import com.google.common.collect.Sets;
/*      */ import com.google.common.collect.TreeMultimap;
/*      */ import com.google.common.collect.UnmodifiableIterator;
/*      */ import com.google.gson.JsonArray;
/*      */ import com.google.gson.JsonElement;
/*      */ import com.google.gson.JsonObject;
/*      */ import com.google.gson.JsonParser;
/*      */ import cpw.mods.fml.common.discovery.ModDiscoverer;
/*      */ import cpw.mods.fml.common.event.FMLEvent;
/*      */ import cpw.mods.fml.common.event.FMLInterModComms;
/*      */ import cpw.mods.fml.common.event.FMLLoadEvent;
/*      */ import cpw.mods.fml.common.event.FMLMissingMappingsEvent;
/*      */ import cpw.mods.fml.common.event.FMLModIdMappingEvent;
/*      */ import cpw.mods.fml.common.functions.ArtifactVersionNameFunction;
/*      */ import cpw.mods.fml.common.functions.ModIdFunction;
/*      */ import cpw.mods.fml.common.registry.GameData;
/*      */ import cpw.mods.fml.common.registry.GameRegistry;
/*      */ import cpw.mods.fml.common.registry.ItemStackHolderInjector;
/*      */ import cpw.mods.fml.common.registry.ObjectHolderRegistry;
/*      */ import cpw.mods.fml.common.toposort.ModSorter;
/*      */ import cpw.mods.fml.common.toposort.ModSortingException;
/*      */ import cpw.mods.fml.common.versioning.ArtifactVersion;
/*      */ import cpw.mods.fml.common.versioning.VersionParser;
/*      */ import cpw.mods.fml.relauncher.ModListHelper;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import java.io.File;
/*      */ import java.io.FileReader;
/*      */ import java.io.FileWriter;
/*      */ import java.io.IOException;
/*      */ import java.net.MalformedURLException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.Iterator;
/*      */ import java.util.LinkedHashMap;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Properties;
/*      */ import java.util.Set;
/*      */ import org.apache.logging.log4j.Level;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class Loader
/*      */ {
/*      */   public static final String MC_VERSION = "1.7.10";
/*  124 */   private static final Splitter DEPENDENCYPARTSPLITTER = Splitter.on(":").omitEmptyStrings().trimResults();
/*  125 */   private static final Splitter DEPENDENCYSPLITTER = Splitter.on(";").omitEmptyStrings().trimResults();
/*      */   
/*      */   private static Loader instance;
/*      */   
/*      */   private static String major;
/*      */   
/*      */   private static String minor;
/*      */   
/*      */   private static String rev;
/*      */   
/*      */   private static String build;
/*      */   
/*      */   private static String mccversion;
/*      */   
/*      */   private static String mcpversion;
/*      */   
/*      */   private ModClassLoader modClassLoader;
/*      */   
/*      */   private List<ModContainer> mods;
/*      */   
/*      */   private Map<String, ModContainer> namedMods;
/*      */   
/*      */   private ListMultimap<String, String> reverseDependencies;
/*      */   
/*      */   private File canonicalConfigDir;
/*      */   
/*      */   private File canonicalModsDir;
/*      */   
/*      */   private LoadController modController;
/*      */   
/*      */   private MinecraftDummyContainer minecraft;
/*      */   
/*      */   private MCPDummyContainer mcp;
/*      */   
/*      */   private static File minecraftDir;
/*      */   
/*      */   private static List<String> injectedContainers;
/*      */   
/*      */   private ImmutableMap<String, String> fmlBrandingProperties;
/*      */   
/*      */   private File forcedModFile;
/*      */   
/*      */   private ModDiscoverer discoverer;
/*      */   
/*      */   private ProgressManager.ProgressBar progressBar;
/*      */   private ListMultimap<String, ArtifactVersion> injectedBefore;
/*      */   private ListMultimap<String, ArtifactVersion> injectedAfter;
/*      */   
/*      */   public static Loader instance() {
/*  174 */     if (instance == null)
/*      */     {
/*  176 */       instance = new Loader();
/*      */     }
/*      */     
/*  179 */     return instance;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static void injectData(Object... data) {
/*  185 */     major = (String)data[0];
/*  186 */     minor = (String)data[1];
/*  187 */     rev = (String)data[2];
/*  188 */     build = (String)data[3];
/*  189 */     mccversion = (String)data[4];
/*  190 */     mcpversion = (String)data[5];
/*  191 */     minecraftDir = (File)data[6];
/*  192 */     injectedContainers = (List<String>)data[7];
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void sortModList() {
/*      */     FMLLog.finer("Verifying mod requirements are satisfied", new Object[0]);
/*      */     try {
/*      */       HashBiMap hashBiMap = HashBiMap.create();
/*      */       for (ModContainer mod : Iterables.concat(getActiveModList(), ModAPIManager.INSTANCE.getAPIList())) {
/*      */         hashBiMap.put(mod.getModId(), mod.getProcessedVersion());
/*      */       }
/*      */       ArrayListMultimap<String, String> reqList = ArrayListMultimap.create();
/*      */       for (ModContainer mod : getActiveModList()) {
/*      */         if (!mod.acceptableMinecraftVersionRange().containsVersion(this.minecraft.getProcessedVersion())) {
/*      */           FMLLog.severe("The mod %s does not wish to run in Minecraft version %s. You will have to remove it to play.", new Object[] { mod.getModId(), getMCVersionString() });
/*      */           throw new WrongMinecraftVersionException(mod);
/*      */         } 
/*      */         ImmutableMap immutableMap = Maps.uniqueIndex(mod.getRequirements(), (Function)new ArtifactVersionNameFunction());
/*      */         Set<ArtifactVersion> versionMissingMods = Sets.newHashSet();
/*      */         Sets.SetView setView = Sets.difference(immutableMap.keySet(), hashBiMap.keySet());
/*      */         if (!setView.isEmpty()) {
/*      */           FMLLog.severe("The mod %s (%s) requires mods %s to be available", new Object[] { mod.getModId(), mod.getName(), setView });
/*      */           for (String modid : setView) {
/*      */             versionMissingMods.add((ArtifactVersion)immutableMap.get(modid));
/*      */           }
/*      */           throw new MissingModsException(versionMissingMods);
/*      */         } 
/*      */         reqList.putAll(mod.getModId(), immutableMap.keySet());
/*      */         ImmutableList<ArtifactVersion> allDeps = ImmutableList.builder().addAll(mod.getDependants()).addAll(mod.getDependencies()).build();
/*      */         for (UnmodifiableIterator<ArtifactVersion> unmodifiableIterator = allDeps.iterator(); unmodifiableIterator.hasNext(); ) {
/*      */           ArtifactVersion v = unmodifiableIterator.next();
/*      */           if (hashBiMap.containsKey(v.getLabel())) {
/*      */             if (!v.containsVersion((ArtifactVersion)hashBiMap.get(v.getLabel()))) {
/*      */               versionMissingMods.add(v);
/*      */             }
/*      */           }
/*      */         } 
/*      */         if (!versionMissingMods.isEmpty()) {
/*      */           FMLLog.severe("The mod %s (%s) requires mod versions %s to be available", new Object[] { mod.getModId(), mod.getName(), versionMissingMods });
/*      */           throw new MissingModsException(versionMissingMods);
/*      */         } 
/*      */       } 
/*      */       FMLLog.finer("All mod requirements are satisfied", new Object[0]);
/*      */       this.reverseDependencies = (ListMultimap<String, String>)Multimaps.invertFrom((Multimap)reqList, (Multimap)ArrayListMultimap.create());
/*      */       ModSorter sorter = new ModSorter(getActiveModList(), this.namedMods);
/*      */       try {
/*      */         FMLLog.finer("Sorting mods into an ordered list", new Object[0]);
/*      */         List<ModContainer> sortedMods = sorter.sort();
/*      */         this.modController.getActiveModList().clear();
/*      */         this.modController.getActiveModList().addAll(sortedMods);
/*      */         this.mods.removeAll(sortedMods);
/*      */         sortedMods.addAll(this.mods);
/*      */         this.mods = sortedMods;
/*      */         FMLLog.finer("Mod sorting completed successfully", new Object[0]);
/*      */       } catch (ModSortingException sortException) {
/*      */         FMLLog.severe("A dependency cycle was detected in the input mod set so an ordering cannot be determined", new Object[0]);
/*      */         ModSortingException.SortingExceptionData<ModContainer> exceptionData = sortException.getExceptionData();
/*      */         FMLLog.severe("The first mod in the cycle is %s", new Object[] { exceptionData.getFirstBadNode() });
/*      */         FMLLog.severe("The mod cycle involves", new Object[0]);
/*      */         for (ModContainer mc : exceptionData.getVisitedNodes()) {
/*      */           FMLLog.severe("%s : before: %s, after: %s", new Object[] { mc.toString(), mc.getDependants(), mc.getDependencies() });
/*      */         } 
/*      */         FMLLog.log(Level.ERROR, (Throwable)sortException, "The full error", new Object[0]);
/*      */         throw sortException;
/*      */       } 
/*      */     } finally {
/*      */       FMLLog.fine("Mod sorting data", new Object[0]);
/*      */       int unprintedMods = this.mods.size();
/*      */       for (ModContainer mod : getActiveModList()) {
/*      */         if (!mod.isImmutable()) {
/*      */           FMLLog.fine("\t%s(%s:%s): %s (%s)", new Object[] { mod.getModId(), mod.getName(), mod.getVersion(), mod.getSource().getName(), mod.getSortingRules() });
/*      */           unprintedMods--;
/*      */         } 
/*      */       } 
/*      */       if (unprintedMods == this.mods.size()) {
/*      */         FMLLog.fine("No user mods found to sort", new Object[0]);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private ModDiscoverer identifyMods() {
/*      */     FMLLog.fine("Building injected Mod Containers %s", new Object[] { injectedContainers });
/*      */     this.mods.add(new InjectedModContainer(this.mcp, new File("minecraft.jar")));
/*      */     for (String cont : injectedContainers) {
/*      */       ModContainer mc;
/*      */       try {
/*      */         mc = (ModContainer)Class.forName(cont, true, this.modClassLoader).newInstance();
/*      */       } catch (Exception e) {
/*      */         FMLLog.log(Level.ERROR, e, "A problem occured instantiating the injected mod container %s", new Object[] { cont });
/*      */         throw new LoaderException(e);
/*      */       } 
/*      */       this.mods.add(new InjectedModContainer(mc, mc.getSource()));
/*      */     } 
/*      */     ModDiscoverer discoverer = new ModDiscoverer();
/*      */     FMLLog.fine("Attempting to load mods contained in the minecraft jar file and associated classes", new Object[0]);
/*      */     discoverer.findClasspathMods(this.modClassLoader);
/*      */     FMLLog.fine("Minecraft jar mods loaded successfully", new Object[0]);
/*      */     FMLLog.getLogger().log(Level.INFO, "Found {} mods from the command line. Injecting into mod discoverer", new Object[] { Integer.valueOf(ModListHelper.additionalMods.size()) });
/*      */     FMLLog.info("Searching %s for mods", new Object[] { this.canonicalModsDir.getAbsolutePath() });
/*      */     discoverer.findModDirMods(this.canonicalModsDir, (File[])ModListHelper.additionalMods.values().toArray((Object[])new File[0]));
/*      */     File versionSpecificModsDir = new File(this.canonicalModsDir, mccversion);
/*      */     if (versionSpecificModsDir.isDirectory()) {
/*      */       FMLLog.info("Also searching %s for mods", new Object[] { versionSpecificModsDir });
/*      */       discoverer.findModDirMods(versionSpecificModsDir);
/*      */     } 
/*      */     this.mods.addAll(discoverer.identifyMods());
/*      */     identifyDuplicates(this.mods);
/*      */     this.namedMods = (Map<String, ModContainer>)Maps.uniqueIndex(this.mods, (Function)new ModIdFunction());
/*      */     FMLLog.info("Forge Mod Loader has identified %d mod%s to load", new Object[] { Integer.valueOf(this.mods.size()), (this.mods.size() != 1) ? "s" : "" });
/*      */     return discoverer;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private class ModIdComparator
/*      */     implements Comparator<ModContainer>
/*      */   {
/*      */     private ModIdComparator() {}
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int compare(ModContainer o1, ModContainer o2) {
/*      */       return o1.getModId().compareTo(o2.getModId());
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void identifyDuplicates(List<ModContainer> mods) {
/*      */     TreeMultimap<ModContainer, File> dupsearch = TreeMultimap.create(new ModIdComparator(), (Comparator)Ordering.arbitrary());
/*      */     for (ModContainer mc : mods) {
/*      */       if (mc.getSource() != null) {
/*      */         dupsearch.put(mc, mc.getSource());
/*      */       }
/*      */     } 
/*      */     ImmutableMultiset<ModContainer> duplist = Multisets.copyHighestCountFirst(dupsearch.keys());
/*      */     LinkedHashMultimap linkedHashMultimap = LinkedHashMultimap.create();
/*      */     for (UnmodifiableIterator<Multiset.Entry<ModContainer>> unmodifiableIterator = duplist.entrySet().iterator(); unmodifiableIterator.hasNext(); ) {
/*      */       Multiset.Entry<ModContainer> e = unmodifiableIterator.next();
/*      */       if (e.getCount() > 1) {
/*      */         FMLLog.severe("Found a duplicate mod %s at %s", new Object[] { ((ModContainer)e.getElement()).getModId(), dupsearch.get(e.getElement()) });
/*      */         linkedHashMultimap.putAll(e.getElement(), dupsearch.get(e.getElement()));
/*      */       } 
/*      */     } 
/*      */     if (!linkedHashMultimap.isEmpty()) {
/*      */       throw new DuplicateModsFoundException(linkedHashMultimap);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void initializeLoader() {
/*      */     String canonicalModsPath, canonicalConfigPath;
/*      */     File modsDir = new File(minecraftDir, "mods");
/*      */     File configDir = new File(minecraftDir, "config");
/*      */     try {
/*      */       canonicalModsPath = modsDir.getCanonicalPath();
/*      */       canonicalConfigPath = configDir.getCanonicalPath();
/*      */       this.canonicalConfigDir = configDir.getCanonicalFile();
/*      */       this.canonicalModsDir = modsDir.getCanonicalFile();
/*      */     } catch (IOException ioe) {
/*      */       FMLLog.log(Level.ERROR, ioe, "Failed to resolve loader directories: mods : %s ; config %s", new Object[] { this.canonicalModsDir.getAbsolutePath(), configDir.getAbsolutePath() });
/*      */       throw new LoaderException(ioe);
/*      */     } 
/*      */     if (!this.canonicalModsDir.exists()) {
/*      */       FMLLog.info("No mod directory found, creating one: %s", new Object[] { canonicalModsPath });
/*      */       boolean dirMade = this.canonicalModsDir.mkdir();
/*      */       if (!dirMade) {
/*      */         FMLLog.severe("Unable to create the mod directory %s", new Object[] { canonicalModsPath });
/*      */         throw new LoaderException(String.format("Unable to create the mod directory %s", new Object[] { canonicalModsPath }));
/*      */       } 
/*      */       FMLLog.info("Mod directory created successfully", new Object[0]);
/*      */     } 
/*      */     if (!this.canonicalConfigDir.exists()) {
/*      */       FMLLog.fine("No config directory found, creating one: %s", new Object[] { canonicalConfigPath });
/*      */       boolean dirMade = this.canonicalConfigDir.mkdir();
/*      */       if (!dirMade) {
/*      */         FMLLog.severe("Unable to create the config directory %s", new Object[] { canonicalConfigPath });
/*      */         throw new LoaderException();
/*      */       } 
/*      */       FMLLog.info("Config directory created successfully", new Object[0]);
/*      */     } 
/*      */     if (!this.canonicalModsDir.isDirectory()) {
/*      */       FMLLog.severe("Attempting to load mods from %s, which is not a directory", new Object[] { canonicalModsPath });
/*      */       throw new LoaderException();
/*      */     } 
/*      */     if (!configDir.isDirectory()) {
/*      */       FMLLog.severe("Attempting to load configuration from %s, which is not a directory", new Object[] { canonicalConfigPath });
/*      */       throw new LoaderException();
/*      */     } 
/*      */     readInjectedDependencies();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public List<ModContainer> getModList() {
/*      */     return ((instance()).mods != null) ? (List<ModContainer>)ImmutableList.copyOf((instance()).mods) : (List<ModContainer>)ImmutableList.of();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void loadMods() {
/*      */     this.progressBar = ProgressManager.push("Loading", 7);
/*      */     this.progressBar.step("Constructing Mods");
/*      */     initializeLoader();
/*      */     this.mods = Lists.newArrayList();
/*      */     this.namedMods = Maps.newHashMap();
/*      */     this.modController = new LoadController(this);
/*      */     this.modController.transition(LoaderState.LOADING, false);
/*      */     this.discoverer = identifyMods();
/*      */     ModAPIManager.INSTANCE.manageAPI(this.modClassLoader, this.discoverer);
/*      */     disableRequestedMods();
/*      */     this.modController.distributeStateMessage(FMLLoadEvent.class);
/*      */     sortModList();
/*      */     ModAPIManager.INSTANCE.cleanupAPIContainers(this.modController.getActiveModList());
/*      */     ModAPIManager.INSTANCE.cleanupAPIContainers(this.mods);
/*      */     this.mods = (List<ModContainer>)ImmutableList.copyOf(this.mods);
/*      */     for (File nonMod : this.discoverer.getNonModLibs()) {
/*      */       if (nonMod.isFile()) {
/*      */         FMLLog.info("FML has found a non-mod file %s in your mods directory. It will now be injected into your classpath. This could severe stability issues, it should be removed if possible.", new Object[] { nonMod.getName() });
/*      */         try {
/*      */           this.modClassLoader.addFile(nonMod);
/*      */         } catch (MalformedURLException e) {
/*      */           FMLLog.log(Level.ERROR, e, "Encountered a weird problem with non-mod file injection : %s", new Object[] { nonMod.getName() });
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     this.modController.transition(LoaderState.CONSTRUCTING, false);
/*      */     this.modController.distributeStateMessage(LoaderState.CONSTRUCTING, new Object[] { this.modClassLoader, this.discoverer.getASMTable(), this.reverseDependencies });
/*      */     List<ModContainer> mods = Lists.newArrayList();
/*      */     mods.addAll(getActiveModList());
/*      */     Collections.sort(mods, new Comparator<ModContainer>()
/*      */         {
/*      */           public int compare(ModContainer o1, ModContainer o2) {
/*      */             return o1.getModId().compareTo(o2.getModId());
/*      */           }
/*      */         });
/*      */     FMLLog.fine("Mod signature data", new Object[0]);
/*      */     FMLLog.fine(" \tValid Signatures:", new Object[0]);
/*      */     for (ModContainer mod : getActiveModList()) {
/*      */       if (mod.getSigningCertificate() != null) {
/*      */         FMLLog.fine("\t\t(%s) %s\t(%s\t%s)\t%s", new Object[] { CertificateHelper.getFingerprint(mod.getSigningCertificate()), mod.getModId(), mod.getName(), mod.getVersion(), mod.getSource().getName() });
/*      */       }
/*      */     } 
/*      */     FMLLog.fine(" \tMissing Signatures:", new Object[0]);
/*      */     for (ModContainer mod : getActiveModList()) {
/*      */       if (mod.getSigningCertificate() == null) {
/*      */         FMLLog.fine("\t\t%s\t(%s\t%s)\t%s", new Object[] { mod.getModId(), mod.getName(), mod.getVersion(), mod.getSource().getName() });
/*      */       }
/*      */     } 
/*      */     if (getActiveModList().isEmpty()) {
/*      */       FMLLog.fine("No user mod signature data found", new Object[0]);
/*      */     }
/*      */     this.progressBar.step("Initializing mods Phase 1");
/*      */     this.modController.transition(LoaderState.PREINITIALIZATION, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void preinitializeMods() {
/*      */     if (!this.modController.isInState(LoaderState.PREINITIALIZATION)) {
/*      */       FMLLog.warning("There were errors previously. Not beginning mod initialization phase", new Object[0]);
/*      */       return;
/*      */     } 
/*      */     ObjectHolderRegistry.INSTANCE.findObjectHolders(this.discoverer.getASMTable());
/*      */     ItemStackHolderInjector.INSTANCE.findHolders(this.discoverer.getASMTable());
/*      */     this.modController.distributeStateMessage(LoaderState.PREINITIALIZATION, new Object[] { this.discoverer.getASMTable(), this.canonicalConfigDir });
/*      */     ObjectHolderRegistry.INSTANCE.applyObjectHolders();
/*      */     ItemStackHolderInjector.INSTANCE.inject();
/*      */     this.modController.transition(LoaderState.INITIALIZATION, false);
/*      */     this.progressBar.step("Initializing Minecraft Engine");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void disableRequestedMods() {
/*      */     String forcedModList = System.getProperty("fml.modStates", "");
/*      */     FMLLog.finer("Received a system property request '%s'", new Object[] { forcedModList });
/*      */     Map<String, String> sysPropertyStateList = Splitter.on(CharMatcher.anyOf(";:")).omitEmptyStrings().trimResults().withKeyValueSeparator("=").split(forcedModList);
/*      */     FMLLog.finer("System property request managing the state of %d mods", new Object[] { Integer.valueOf(sysPropertyStateList.size()) });
/*      */     Map<String, String> modStates = Maps.newHashMap();
/*      */     this.forcedModFile = new File(this.canonicalConfigDir, "fmlModState.properties");
/*      */     Properties forcedModListProperties = new Properties();
/*      */     if (this.forcedModFile.exists() && this.forcedModFile.isFile()) {
/*      */       FMLLog.finer("Found a mod state file %s", new Object[] { this.forcedModFile.getName() });
/*      */       try {
/*      */         forcedModListProperties.load(new FileReader(this.forcedModFile));
/*      */         FMLLog.finer("Loaded states for %d mods from file", new Object[] { Integer.valueOf(forcedModListProperties.size()) });
/*      */       } catch (Exception e) {
/*      */         FMLLog.log(Level.INFO, e, "An error occurred reading the fmlModState.properties file", new Object[0]);
/*      */       } 
/*      */     } 
/*      */     modStates.putAll((Map<? extends String, ? extends String>)Maps.fromProperties(forcedModListProperties));
/*      */     modStates.putAll(sysPropertyStateList);
/*      */     FMLLog.fine("After merging, found state information for %d mods", new Object[] { Integer.valueOf(modStates.size()) });
/*      */     Map<String, Boolean> isEnabled = Maps.transformValues(modStates, new Function<String, Boolean>()
/*      */         {
/*      */           public Boolean apply(String input) {
/*      */             return Boolean.valueOf(Boolean.parseBoolean(input));
/*      */           }
/*      */         });
/*      */     for (Map.Entry<String, Boolean> entry : isEnabled.entrySet()) {
/*      */       if (this.namedMods.containsKey(entry.getKey())) {
/*      */         FMLLog.info("Setting mod %s to enabled state %b", new Object[] { entry.getKey(), entry.getValue() });
/*      */         ((ModContainer)this.namedMods.get(entry.getKey())).setEnabledState(((Boolean)entry.getValue()).booleanValue());
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isModLoaded(String modname) {
/*      */     return ((instance()).namedMods.containsKey(modname) && (instance()).modController.getModState(instance.namedMods.get(modname)) != LoaderState.ModState.DISABLED);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private Loader() {
/* 1029 */     this.injectedBefore = (ListMultimap<String, ArtifactVersion>)ArrayListMultimap.create();
/* 1030 */     this.injectedAfter = (ListMultimap<String, ArtifactVersion>)ArrayListMultimap.create(); this.modClassLoader = new ModClassLoader(getClass().getClassLoader()); if (!mccversion.equals("1.7.10")) { FMLLog.severe("This version of FML is built for Minecraft %s, we have detected Minecraft %s in your minecraft jar file", new Object[] { mccversion, "1.7.10" }); throw new LoaderException(String.format("This version of FML is built for Minecraft %s, we have detected Minecraft %s in your minecraft jar file", new Object[] { mccversion, "1.7.10" })); }  this.minecraft = new MinecraftDummyContainer("1.7.10"); this.mcp = new MCPDummyContainer(MetadataCollection.from(getClass().getResourceAsStream("/mcpmod.info"), "MCP").getMetadataForId("mcp", null));
/*      */   } public File getConfigDir() { return this.canonicalConfigDir; } public String getCrashInformation() { if (this.modController == null) return "";  StringBuilder ret = new StringBuilder(); List<String> branding = FMLCommonHandler.instance().getBrandings(false); Joiner.on(' ').skipNulls().appendTo(ret, branding); if (this.modController != null) this.modController.printModStates(ret);  return ret.toString(); } public String getFMLVersionString() { return "7.10.99.99"; } public ClassLoader getModClassLoader() { return this.modClassLoader; } public void computeDependencies(String dependencyString, Set<ArtifactVersion> requirements, List<ArtifactVersion> dependencies, List<ArtifactVersion> dependants) { if (dependencyString == null || dependencyString.length() == 0) return;  boolean parseFailure = false; for (String dep : DEPENDENCYSPLITTER.split(dependencyString)) { List<String> depparts = Lists.newArrayList(DEPENDENCYPARTSPLITTER.split(dep)); if (depparts.size() != 2) { parseFailure = true; continue; }  String instruction = depparts.get(0); String target = depparts.get(1); boolean targetIsAll = target.startsWith("*"); if (targetIsAll && target.length() > 1) { parseFailure = true; continue; }  if ("required-before".equals(instruction) || "required-after".equals(instruction)) if (!targetIsAll) { requirements.add(VersionParser.parseVersionReference(target)); } else { parseFailure = true; continue; }   if (targetIsAll && target.indexOf('@') > -1) { parseFailure = true; continue; }  if ("required-before".equals(instruction) || "before".equals(instruction)) { dependants.add(VersionParser.parseVersionReference(target)); continue; }  if ("required-after".equals(instruction) || "after".equals(instruction)) { dependencies.add(VersionParser.parseVersionReference(target)); continue; }  parseFailure = true; }  if (parseFailure) { FMLLog.log(Level.WARN, "Unable to parse dependency string %s", new Object[] { dependencyString }); throw new LoaderException(String.format("Unable to parse dependency string %s", new Object[] { dependencyString })); }  } public Map<String, ModContainer> getIndexedModList() { return (Map<String, ModContainer>)ImmutableMap.copyOf(this.namedMods); } public void initializeMods() { this.progressBar.step("Initializing mods Phase 2"); this.modController.distributeStateMessage(LoaderState.INITIALIZATION, new Object[0]); this.progressBar.step("Initializing mods Phase 3"); this.modController.transition(LoaderState.POSTINITIALIZATION, false); this.modController.distributeStateMessage(FMLInterModComms.IMCEvent.class); ItemStackHolderInjector.INSTANCE.inject(); this.modController.distributeStateMessage(LoaderState.POSTINITIALIZATION, new Object[0]); this.progressBar.step("Finishing up"); this.modController.transition(LoaderState.AVAILABLE, false); this.modController.distributeStateMessage(LoaderState.AVAILABLE, new Object[0]); GameData.freezeData(); GameData.dumpRegistry(minecraftDir); FMLLog.info("Forge Mod Loader has successfully loaded %d mod%s", new Object[] { Integer.valueOf(this.mods.size()), (this.mods.size() == 1) ? "" : "s" }); this.progressBar.step("Completing Minecraft initialization"); } public ICrashCallable getCallableCrashInformation() { return new ICrashCallable() { public String call() throws Exception { return Loader.this.getCrashInformation(); } public String getLabel() { return "FML"; } }
/*      */       ; } public List<ModContainer> getActiveModList() { return (this.modController != null) ? this.modController.getActiveModList() : (List<ModContainer>)ImmutableList.of(); }
/*      */   public LoaderState.ModState getModState(ModContainer selectedMod) { return this.modController.getModState(selectedMod); }
/* 1034 */   private void readInjectedDependencies() { File injectedDepFile = new File(getConfigDir(), "injectedDependencies.json");
/* 1035 */     if (!injectedDepFile.exists()) {
/*      */       
/* 1037 */       FMLLog.getLogger().log(Level.DEBUG, "File {} not found. No dependencies injected", new Object[] { injectedDepFile.getAbsolutePath() });
/*      */       return;
/*      */     } 
/* 1040 */     JsonParser parser = new JsonParser();
/*      */ 
/*      */     
/*      */     try {
/* 1044 */       JsonElement injectedDeps = parser.parse(new FileReader(injectedDepFile));
/* 1045 */       for (JsonElement el : injectedDeps.getAsJsonArray()) {
/*      */         
/* 1047 */         JsonObject jo = el.getAsJsonObject();
/* 1048 */         String modId = jo.get("modId").getAsString();
/* 1049 */         JsonArray deps = jo.get("deps").getAsJsonArray();
/* 1050 */         for (JsonElement dep : deps)
/*      */         {
/* 1052 */           JsonObject depObj = dep.getAsJsonObject();
/* 1053 */           String type = depObj.get("type").getAsString();
/* 1054 */           if (type.equals("before")) {
/* 1055 */             this.injectedBefore.put(modId, VersionParser.parseVersionReference(depObj.get("target").getAsString())); continue;
/* 1056 */           }  if (type.equals("after")) {
/* 1057 */             this.injectedAfter.put(modId, VersionParser.parseVersionReference(depObj.get("target").getAsString())); continue;
/*      */           } 
/* 1059 */           FMLLog.getLogger().log(Level.ERROR, "Invalid dependency type {}", new Object[] { type });
/* 1060 */           throw new RuntimeException("Unable to parse type");
/*      */         }
/*      */       
/*      */       } 
/* 1064 */     } catch (Exception e) {
/*      */       
/* 1066 */       FMLLog.getLogger().log(Level.ERROR, "Unable to parse {} - skipping", new Object[] { injectedDepFile });
/* 1067 */       FMLLog.getLogger().throwing(Level.ERROR, e);
/*      */       return;
/*      */     } 
/* 1070 */     FMLLog.getLogger().log(Level.DEBUG, "Loaded {} injected dependencies on modIds: {}", new Object[] { Integer.valueOf(this.injectedBefore.size()), this.injectedBefore.keySet() }); }
/*      */   public String getMCVersionString() { return "Minecraft " + mccversion; }
/*      */   public boolean serverStarting(Object server) { try { this.modController.distributeStateMessage(LoaderState.SERVER_STARTING, new Object[] { server }); this.modController.transition(LoaderState.SERVER_STARTING, false); } catch (Throwable t) { FMLLog.log(Level.ERROR, t, "A fatal exception occurred during the server starting event", new Object[0]); return false; }  return true; }
/*      */   public void serverStarted() { this.modController.distributeStateMessage(LoaderState.SERVER_STARTED, new Object[0]); this.modController.transition(LoaderState.SERVER_STARTED, false); }
/*      */   public void serverStopping() { this.modController.distributeStateMessage(LoaderState.SERVER_STOPPING, new Object[0]); this.modController.transition(LoaderState.SERVER_STOPPING, false); }
/* 1075 */   public BiMap<ModContainer, Object> getModObjectList() { return this.modController.getModObjectList(); } public BiMap<Object, ModContainer> getReversedModObjectList() { return getModObjectList().inverse(); } public ModContainer activeModContainer() { return (this.modController != null) ? this.modController.activeContainer() : null; } public boolean isInState(LoaderState state) { return this.modController.isInState(state); } public MinecraftDummyContainer getMinecraftModContainer() { return this.minecraft; } public boolean hasReachedState(LoaderState state) { return (this.modController != null) ? this.modController.hasReachedState(state) : false; } List<ArtifactVersion> getInjectedBefore(String modId) { return this.injectedBefore.get(modId); }
/*      */   public String getMCPVersionString() { return String.format("MCP v%s", new Object[] { mcpversion }); }
/*      */   public void serverStopped() { GameData.revertToFrozen(); this.modController.distributeStateMessage(LoaderState.SERVER_STOPPED, new Object[0]); this.modController.transition(LoaderState.SERVER_STOPPED, true); this.modController.transition(LoaderState.AVAILABLE, true); }
/*      */   public boolean serverAboutToStart(Object server) { try { this.modController.distributeStateMessage(LoaderState.SERVER_ABOUT_TO_START, new Object[] { server }); this.modController.transition(LoaderState.SERVER_ABOUT_TO_START, false); } catch (Throwable t) { FMLLog.log(Level.ERROR, t, "A fatal exception occurred during the server about to start event", new Object[0]); return false; }  return true; }
/* 1079 */   public Map<String, String> getFMLBrandingProperties() { if (this.fmlBrandingProperties == null) { Properties loaded = new Properties(); try { loaded.load(getClass().getClassLoader().getResourceAsStream("fmlbranding.properties")); } catch (Exception exception) {} this.fmlBrandingProperties = Maps.fromProperties(loaded); }  return (Map<String, String>)this.fmlBrandingProperties; } public Map<String, String> getCustomModProperties(String modId) { return ((ModContainer)getIndexedModList().get(modId)).getCustomModProperties(); } boolean checkRemoteModList(Map<String, String> modList, Side side) { Set<String> remoteModIds = modList.keySet(); Set<String> localModIds = this.namedMods.keySet(); Set<String> difference = Sets.newLinkedHashSet((Iterable)Sets.difference(localModIds, remoteModIds)); for (Iterator<String> iterator = difference.iterator(); iterator.hasNext(); ) { String missingRemotely = iterator.next(); LoaderState.ModState modState = this.modController.getModState(this.namedMods.get(missingRemotely)); if (modState == LoaderState.ModState.DISABLED) iterator.remove();  }  FMLLog.info("Attempting connection with missing mods %s at %s", new Object[] { difference, side }); return true; } public List<String> fireMissingMappingEvent(LinkedHashMap<String, Integer> missing, boolean isLocalWorld, GameData gameData, Map<String, Integer[]> remaps) { if (missing.isEmpty()) return (List<String>)ImmutableList.of();  FMLLog.fine("There are %d mappings missing - attempting a mod remap", new Object[] { Integer.valueOf(missing.size()) }); ArrayListMultimap<String, FMLMissingMappingsEvent.MissingMapping> missingMappings = ArrayListMultimap.create(); for (Map.Entry<String, Integer> mapping : missing.entrySet()) { int id = ((Integer)mapping.getValue()).intValue(); FMLMissingMappingsEvent.MissingMapping m = new FMLMissingMappingsEvent.MissingMapping(mapping.getKey(), id); missingMappings.put(m.name.substring(0, m.name.indexOf(':')), m); }  FMLMissingMappingsEvent missingEvent = new FMLMissingMappingsEvent((ListMultimap)missingMappings); this.modController.propogateStateMessage((FMLEvent)missingEvent); if (isLocalWorld) { boolean didWarn = false; for (FMLMissingMappingsEvent.MissingMapping mapping : missingMappings.values()) { if (mapping.getAction() == FMLMissingMappingsEvent.Action.DEFAULT) { if (!didWarn) { FMLLog.severe("There are unidentified mappings in this world - we are going to attempt to process anyway", new Object[0]); didWarn = true; }  FMLLog.severe("Unidentified %s: %s, id %d", new Object[] { (mapping.type == GameRegistry.Type.BLOCK) ? "block" : "item", mapping.name, Integer.valueOf(mapping.id) }); }  }  } else { List<String> missedMapping = new ArrayList<String>(); for (FMLMissingMappingsEvent.MissingMapping mapping : missingMappings.values()) { if (mapping.getAction() == FMLMissingMappingsEvent.Action.DEFAULT) missedMapping.add(mapping.name);  }  if (!missedMapping.isEmpty()) return (List<String>)ImmutableList.copyOf(missedMapping);  }  return GameData.processIdRematches(missingMappings.values(), isLocalWorld, gameData, remaps); } public void fireRemapEvent(Map<String, Integer[]> remaps) { this.modController.propogateStateMessage((FMLEvent)new FMLModIdMappingEvent(remaps)); } public void runtimeDisableMod(String modId) { ModContainer mc = this.namedMods.get(modId); ModContainer.Disableable disableable = mc.canBeDisabled(); if (disableable == ModContainer.Disableable.NEVER) { FMLLog.info("Cannot disable mod %s - it is never allowed to be disabled", new Object[] { modId }); return; }  if (disableable == ModContainer.Disableable.DEPENDENCIES) { FMLLog.info("Cannot disable mod %s - there are dependent mods that require its presence", new Object[] { modId }); return; }  if (disableable == ModContainer.Disableable.YES) { FMLLog.info("Runtime disabling mod %s", new Object[] { modId }); this.modController.disableMod(mc); List<ModContainer> localmods = Lists.newArrayList(this.mods); localmods.remove(mc); this.mods = (List<ModContainer>)ImmutableList.copyOf(localmods); }  try { Properties props = new Properties(); props.load(new FileReader(this.forcedModFile)); props.put(modId, "false"); props.store(new FileWriter(this.forcedModFile), (String)null); } catch (Exception e) { FMLLog.log(Level.INFO, e, "An error occurred writing the fml mod states file, your disabled change won't persist", new Object[0]); }  } public void loadingComplete() { ProgressManager.pop(this.progressBar); this.progressBar = null; } List<ArtifactVersion> getInjectedAfter(String modId) { return this.injectedAfter.get(modId); }
/*      */ 
/*      */ 
/*      */   
/*      */   public final LoaderState getLoaderState() {
/* 1084 */     return (this.modController != null) ? this.modController.getState() : LoaderState.NOINIT;
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\Loader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */