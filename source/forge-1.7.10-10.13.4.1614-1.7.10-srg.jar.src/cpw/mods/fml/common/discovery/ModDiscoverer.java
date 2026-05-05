/*     */ package cpw.mods.fml.common.discovery;
/*     */ 
/*     */ import com.google.common.base.Throwables;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.ObjectArrays;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.LoaderException;
/*     */ import cpw.mods.fml.common.ModClassLoader;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import cpw.mods.fml.relauncher.CoreModManager;
/*     */ import cpw.mods.fml.relauncher.FileListHelper;
/*     */ import java.io.File;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
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
/*     */ public class ModDiscoverer
/*     */ {
/*  35 */   private static Pattern zipJar = Pattern.compile("(.+).(zip|jar)$");
/*     */   
/*  37 */   private List<ModCandidate> candidates = Lists.newArrayList();
/*     */   
/*  39 */   private ASMDataTable dataTable = new ASMDataTable();
/*     */   
/*  41 */   private List<File> nonModLibs = Lists.newArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void findClasspathMods(ModClassLoader modClassLoader) {
/*  52 */     ImmutableList immutableList = ImmutableList.builder().addAll(modClassLoader.getDefaultLibraries()).addAll(CoreModManager.getLoadedCoremods()).addAll(CoreModManager.getReparseableCoremods()).build();
/*  53 */     File[] minecraftSources = modClassLoader.getParentSources();
/*  54 */     if (minecraftSources.length == 1 && minecraftSources[0].isFile()) {
/*     */       
/*  56 */       FMLLog.fine("Minecraft is a file at %s, loading", new Object[] { minecraftSources[0].getAbsolutePath() });
/*  57 */       this.candidates.add(new ModCandidate(minecraftSources[0], minecraftSources[0], ContainerType.JAR, true, true));
/*     */     }
/*     */     else {
/*     */       
/*  61 */       for (int i = 0; i < minecraftSources.length; i++) {
/*     */         
/*  63 */         if (minecraftSources[i].isFile()) {
/*     */           
/*  65 */           if (immutableList.contains(minecraftSources[i].getName()))
/*     */           {
/*  67 */             FMLLog.finer("Skipping known library file %s", new Object[] { minecraftSources[i].getAbsolutePath() });
/*     */           }
/*     */           else
/*     */           {
/*  71 */             FMLLog.fine("Found a minecraft related file at %s, examining for mod candidates", new Object[] { minecraftSources[i].getAbsolutePath() });
/*  72 */             this.candidates.add(new ModCandidate(minecraftSources[i], minecraftSources[i], ContainerType.JAR, (i == 0), true));
/*     */           }
/*     */         
/*  75 */         } else if (minecraftSources[i].isDirectory()) {
/*     */           
/*  77 */           FMLLog.fine("Found a minecraft related directory at %s, examining for mod candidates", new Object[] { minecraftSources[i].getAbsolutePath() });
/*  78 */           this.candidates.add(new ModCandidate(minecraftSources[i], minecraftSources[i], ContainerType.DIR, (i == 0), true));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void findModDirMods(File modsDir) {
/*  87 */     findModDirMods(modsDir, new File[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public void findModDirMods(File modsDir, File[] supplementalModFileCandidates) {
/*  92 */     File[] modList = FileListHelper.sortFileList(modsDir, null);
/*  93 */     modList = FileListHelper.sortFileList((File[])ObjectArrays.concat((Object[])modList, (Object[])supplementalModFileCandidates, File.class));
/*  94 */     for (File modFile : modList) {
/*     */ 
/*     */       
/*  97 */       if (CoreModManager.getLoadedCoremods().contains(modFile.getName())) {
/*     */         
/*  99 */         FMLLog.finer("Skipping already parsed coremod or tweaker %s", new Object[] { modFile.getName() });
/*     */       }
/* 101 */       else if (modFile.isDirectory()) {
/*     */         
/* 103 */         FMLLog.fine("Found a candidate mod directory %s", new Object[] { modFile.getName() });
/* 104 */         this.candidates.add(new ModCandidate(modFile, modFile, ContainerType.DIR));
/*     */       }
/*     */       else {
/*     */         
/* 108 */         Matcher matcher = zipJar.matcher(modFile.getName());
/*     */         
/* 110 */         if (matcher.matches()) {
/*     */           
/* 112 */           FMLLog.fine("Found a candidate zip or jar file %s", new Object[] { matcher.group(0) });
/* 113 */           this.candidates.add(new ModCandidate(modFile, modFile, ContainerType.JAR));
/*     */         }
/*     */         else {
/*     */           
/* 117 */           FMLLog.fine("Ignoring unknown file %s in mods directory", new Object[] { modFile.getName() });
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List<ModContainer> identifyMods() {
/* 125 */     List<ModContainer> modList = Lists.newArrayList();
/*     */     
/* 127 */     for (ModCandidate candidate : this.candidates) {
/*     */ 
/*     */       
/*     */       try {
/* 131 */         List<ModContainer> mods = candidate.explore(this.dataTable);
/* 132 */         if (mods.isEmpty() && !candidate.isClasspath()) {
/*     */           
/* 134 */           this.nonModLibs.add(candidate.getModContainer());
/*     */           
/*     */           continue;
/*     */         } 
/* 138 */         modList.addAll(mods);
/*     */       
/*     */       }
/* 141 */       catch (LoaderException le) {
/*     */         
/* 143 */         FMLLog.log(Level.WARN, (Throwable)le, "Identified a problem with the mod candidate %s, ignoring this source", new Object[] { candidate.getModContainer() });
/*     */       }
/* 145 */       catch (Throwable t) {
/*     */         
/* 147 */         Throwables.propagate(t);
/*     */       } 
/*     */     } 
/*     */     
/* 151 */     return modList;
/*     */   }
/*     */ 
/*     */   
/*     */   public ASMDataTable getASMTable() {
/* 156 */     return this.dataTable;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<File> getNonModLibs() {
/* 161 */     return this.nonModLibs;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\discovery\ModDiscoverer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */