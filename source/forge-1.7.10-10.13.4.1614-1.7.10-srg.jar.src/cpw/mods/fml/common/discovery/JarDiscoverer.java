/*     */ package cpw.mods.fml.common.discovery;
/*     */ 
/*     */ import com.google.common.collect.Lists;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.LoaderException;
/*     */ import cpw.mods.fml.common.MetadataCollection;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import cpw.mods.fml.common.ModContainerFactory;
/*     */ import cpw.mods.fml.common.discovery.asm.ASMModParser;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ import java.util.jar.JarEntry;
/*     */ import java.util.jar.JarFile;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.zip.ZipEntry;
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
/*     */ public class JarDiscoverer
/*     */   implements ITypeDiscoverer
/*     */ {
/*     */   public List<ModContainer> discover(ModCandidate candidate, ASMDataTable table) {
/*  36 */     List<ModContainer> foundMods = Lists.newArrayList();
/*  37 */     FMLLog.fine("Examining file %s for potential mods", new Object[] { candidate.getModContainer().getName() });
/*  38 */     JarFile jar = null;
/*     */     
/*     */     try {
/*  41 */       jar = new JarFile(candidate.getModContainer());
/*     */       
/*  43 */       if (jar.getManifest() != null && (jar.getManifest().getMainAttributes().get("FMLCorePlugin") != null || jar.getManifest().getMainAttributes().get("TweakClass") != null)) {
/*     */         
/*  45 */         FMLLog.finer("Ignoring coremod or tweak system %s", new Object[] { candidate.getModContainer() });
/*  46 */         return foundMods;
/*     */       } 
/*  48 */       ZipEntry modInfo = jar.getEntry("mcmod.info");
/*  49 */       MetadataCollection mc = null;
/*  50 */       if (modInfo != null) {
/*     */         
/*  52 */         FMLLog.finer("Located mcmod.info file in file %s", new Object[] { candidate.getModContainer().getName() });
/*  53 */         mc = MetadataCollection.from(jar.getInputStream(modInfo), candidate.getModContainer().getName());
/*     */       }
/*     */       else {
/*     */         
/*  57 */         FMLLog.fine("The mod container %s appears to be missing an mcmod.info file", new Object[] { candidate.getModContainer().getName() });
/*  58 */         mc = MetadataCollection.from(null, "");
/*     */       } 
/*  60 */       for (ZipEntry ze : Collections.<JarEntry>list(jar.entries())) {
/*     */         
/*  62 */         if (ze.getName() != null && ze.getName().startsWith("__MACOSX")) {
/*     */           continue;
/*     */         }
/*     */         
/*  66 */         Matcher match = classFile.matcher(ze.getName());
/*  67 */         if (match.matches()) {
/*     */           ASMModParser modParser;
/*     */ 
/*     */           
/*     */           try {
/*  72 */             modParser = new ASMModParser(jar.getInputStream(ze));
/*  73 */             candidate.addClassEntry(ze.getName());
/*     */           }
/*  75 */           catch (LoaderException e) {
/*     */             
/*  77 */             FMLLog.log(Level.ERROR, (Throwable)e, "There was a problem reading the entry %s in the jar %s - probably a corrupt zip", new Object[] { ze.getName(), candidate.getModContainer().getPath() });
/*  78 */             jar.close();
/*  79 */             throw e;
/*     */           } 
/*  81 */           modParser.validate();
/*  82 */           modParser.sendToTable(table, candidate);
/*  83 */           ModContainer container = ModContainerFactory.instance().build(modParser, candidate.getModContainer(), candidate);
/*  84 */           if (container != null)
/*     */           {
/*  86 */             table.addContainer(container);
/*  87 */             foundMods.add(container);
/*  88 */             container.bindMetadata(mc);
/*     */           }
/*     */         
/*     */         } 
/*     */       } 
/*  93 */     } catch (Exception e) {
/*     */       
/*  95 */       FMLLog.log(Level.WARN, e, "Zip file %s failed to read properly, it will be ignored", new Object[] { candidate.getModContainer().getName() });
/*     */     }
/*     */     finally {
/*     */       
/*  99 */       if (jar != null) {
/*     */         
/*     */         try {
/*     */           
/* 103 */           jar.close();
/*     */         }
/* 105 */         catch (Exception exception) {}
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 110 */     return foundMods;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\discovery\JarDiscoverer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */