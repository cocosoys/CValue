/*     */ package cpw.mods.fml.common.discovery;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.Sets;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import cpw.mods.fml.common.discovery.asm.ASMModParser;
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import java.util.Set;
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
/*     */ public class ModCandidate
/*     */ {
/*     */   private File classPathRoot;
/*     */   private File modContainer;
/*     */   private ContainerType sourceType;
/*     */   private boolean classpath;
/*  33 */   private List<String> baseModTypes = Lists.newArrayList();
/*     */   private boolean isMinecraft;
/*  35 */   private List<ASMModParser> baseModCandidateTypes = Lists.newArrayListWithCapacity(1);
/*  36 */   private Set<String> foundClasses = Sets.newHashSet();
/*     */   private List<ModContainer> mods;
/*  38 */   private List<String> packages = Lists.newArrayList();
/*     */   
/*     */   private ASMDataTable table;
/*     */   
/*     */   public ModCandidate(File classPathRoot, File modContainer, ContainerType sourceType) {
/*  43 */     this(classPathRoot, modContainer, sourceType, false, false);
/*     */   }
/*     */   
/*     */   public ModCandidate(File classPathRoot, File modContainer, ContainerType sourceType, boolean isMinecraft, boolean classpath) {
/*  47 */     this.classPathRoot = classPathRoot;
/*  48 */     this.modContainer = modContainer;
/*  49 */     this.sourceType = sourceType;
/*  50 */     this.isMinecraft = isMinecraft;
/*  51 */     this.classpath = classpath;
/*     */   }
/*     */ 
/*     */   
/*     */   public File getClassPathRoot() {
/*  56 */     return this.classPathRoot;
/*     */   }
/*     */ 
/*     */   
/*     */   public File getModContainer() {
/*  61 */     return this.modContainer;
/*     */   }
/*     */ 
/*     */   
/*     */   public ContainerType getSourceType() {
/*  66 */     return this.sourceType;
/*     */   }
/*     */   
/*     */   public List<ModContainer> explore(ASMDataTable table) {
/*  70 */     this.table = table;
/*  71 */     this.mods = this.sourceType.findMods(this, table);
/*  72 */     if (!this.baseModCandidateTypes.isEmpty()) {
/*     */       
/*  74 */       FMLLog.info("Attempting to reparse the mod container %s", new Object[] { getModContainer().getName() });
/*  75 */       this.mods = this.sourceType.findMods(this, table);
/*     */     } 
/*  77 */     return this.mods;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addClassEntry(String name) {
/*  82 */     String className = name.substring(0, name.lastIndexOf('.'));
/*  83 */     this.foundClasses.add(className);
/*  84 */     className = className.replace('/', '.');
/*  85 */     int pkgIdx = className.lastIndexOf('.');
/*  86 */     if (pkgIdx > -1) {
/*     */       
/*  88 */       String pkg = className.substring(0, pkgIdx);
/*  89 */       this.packages.add(pkg);
/*  90 */       this.table.registerPackage(this, pkg);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isClasspath() {
/*  96 */     return this.classpath;
/*     */   }
/*     */   
/*     */   public void rememberBaseModType(String className) {
/* 100 */     this.baseModTypes.add(className);
/*     */   }
/*     */   
/*     */   public List<String> getRememberedBaseMods() {
/* 104 */     return this.baseModTypes;
/*     */   }
/*     */   
/*     */   public boolean isMinecraftJar() {
/* 108 */     return this.isMinecraft;
/*     */   }
/*     */   
/*     */   public void rememberModCandidateType(ASMModParser modParser) {
/* 112 */     this.baseModCandidateTypes.add(modParser);
/*     */   }
/*     */   
/*     */   public Set<String> getClassList() {
/* 116 */     return this.foundClasses;
/*     */   }
/*     */   
/*     */   public List<ModContainer> getContainedMods() {
/* 120 */     return this.mods;
/*     */   }
/*     */   
/*     */   public List<String> getContainedPackages() {
/* 124 */     return this.packages;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\discovery\ModCandidate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */