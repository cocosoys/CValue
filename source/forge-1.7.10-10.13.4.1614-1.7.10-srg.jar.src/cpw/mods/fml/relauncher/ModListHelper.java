/*     */ package cpw.mods.fml.relauncher;
/*     */ 
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Sets;
/*     */ import com.google.common.io.Files;
/*     */ import com.google.gson.Gson;
/*     */ import com.google.gson.JsonSyntaxException;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import net.minecraft.launchwrapper.Launch;
/*     */ import org.apache.logging.log4j.Level;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ModListHelper
/*     */ {
/*     */   private static File mcDirectory;
/*  24 */   private static Set<File> visitedFiles = Sets.newHashSet(); public static class JsonModList {
/*  25 */     public String repositoryRoot; public List<String> modRef; public String parentList; } public static final Map<String, File> additionalMods = Maps.newLinkedHashMap();
/*     */   
/*     */   static void parseModList(File minecraftDirectory) {
/*  28 */     FMLRelaunchLog.fine("Attempting to load commandline specified mods, relative to %s", new Object[] { minecraftDirectory.getAbsolutePath() });
/*  29 */     mcDirectory = minecraftDirectory;
/*     */     
/*  31 */     Map<String, String> args = (Map<String, String>)Launch.blackboard.get("launchArgs");
/*  32 */     String listFile = args.get("--modListFile");
/*  33 */     if (listFile != null)
/*     */     {
/*  35 */       parseListFile(listFile);
/*     */     }
/*  37 */     String extraMods = args.get("--mods");
/*  38 */     if (extraMods != null) {
/*     */       
/*  40 */       String[] split = extraMods.split(",");
/*  41 */       for (String modFile : split)
/*     */       {
/*  43 */         tryAddFile(modFile, null, modFile); } 
/*     */     } 
/*     */   }
/*     */   private static void parseListFile(String listFile) {
/*     */     File f;
/*     */     String json;
/*     */     JsonModList modList;
/*     */     try {
/*  51 */       f = (new File(mcDirectory, listFile)).getCanonicalFile();
/*  52 */     } catch (IOException e2) {
/*     */       
/*  54 */       FMLRelaunchLog.log(Level.INFO, e2, "Unable to canonicalize path %s relative to %s", new Object[] { listFile, mcDirectory.getAbsolutePath() });
/*     */       return;
/*     */     } 
/*  57 */     if (!f.exists()) {
/*     */       
/*  59 */       FMLRelaunchLog.info("Failed to find modList file %s", new Object[] { f.getAbsolutePath() });
/*     */       return;
/*     */     } 
/*  62 */     if (visitedFiles.contains(f)) {
/*     */       
/*  64 */       FMLRelaunchLog.severe("There appears to be a loop in the modListFile hierarchy. You shouldn't do this!", new Object[0]);
/*  65 */       throw new RuntimeException("Loop detected, impossible to load modlistfile");
/*     */     } 
/*     */     
/*     */     try {
/*  69 */       json = Files.asCharSource(f, Charsets.UTF_8).read();
/*  70 */     } catch (IOException e1) {
/*  71 */       FMLRelaunchLog.log(Level.INFO, e1, "Failed to read modList json file %s.", new Object[] { listFile });
/*     */       return;
/*     */     } 
/*  74 */     Gson gsonParser = new Gson();
/*     */     
/*     */     try {
/*  77 */       modList = (JsonModList)gsonParser.fromJson(json, JsonModList.class);
/*  78 */     } catch (JsonSyntaxException e) {
/*  79 */       FMLRelaunchLog.log(Level.INFO, (Throwable)e, "Failed to parse modList json file %s.", new Object[] { listFile });
/*     */       return;
/*     */     } 
/*  82 */     visitedFiles.add(f);
/*     */     
/*  84 */     if (modList.parentList != null)
/*     */     {
/*  86 */       parseListFile(modList.parentList);
/*     */     }
/*  88 */     File repoRoot = new File(modList.repositoryRoot);
/*  89 */     if (!repoRoot.exists()) {
/*     */       
/*  91 */       FMLRelaunchLog.info("Failed to find the specified repository root %s", new Object[] { modList.repositoryRoot });
/*     */       
/*     */       return;
/*     */     } 
/*  95 */     for (String s : modList.modRef) {
/*     */       
/*  97 */       StringBuilder fileName = new StringBuilder();
/*  98 */       StringBuilder genericName = new StringBuilder();
/*  99 */       String[] parts = s.split(":");
/* 100 */       fileName.append(parts[0].replace('.', File.separatorChar));
/* 101 */       genericName.append(parts[0]);
/* 102 */       fileName.append(File.separatorChar);
/* 103 */       fileName.append(parts[1]).append(File.separatorChar);
/* 104 */       genericName.append(":").append(parts[1]);
/* 105 */       fileName.append(parts[2]).append(File.separatorChar);
/* 106 */       fileName.append(parts[1]).append('-').append(parts[2]);
/* 107 */       if (parts.length == 4) {
/*     */         
/* 109 */         fileName.append('-').append(parts[3]);
/* 110 */         genericName.append(":").append(parts[3]);
/*     */       } 
/* 112 */       fileName.append(".jar");
/* 113 */       tryAddFile(fileName.toString(), repoRoot, genericName.toString());
/*     */     } 
/*     */   }
/*     */   private static void tryAddFile(String modFileName, File repoRoot, String descriptor) {
/* 117 */     File modFile = (repoRoot != null) ? new File(repoRoot, modFileName) : new File(mcDirectory, modFileName);
/* 118 */     if (!modFile.exists()) {
/*     */       
/* 120 */       FMLRelaunchLog.info("Failed to find mod file %s (%s)", new Object[] { descriptor, modFile.getAbsolutePath() });
/*     */     }
/*     */     else {
/*     */       
/* 124 */       FMLRelaunchLog.fine("Adding %s (%s) to the mod list", new Object[] { descriptor, modFile.getAbsolutePath() });
/* 125 */       additionalMods.put(descriptor, modFile);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\relauncher\ModListHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */