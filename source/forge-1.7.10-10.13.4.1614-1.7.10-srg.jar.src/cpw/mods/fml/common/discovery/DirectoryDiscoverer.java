/*     */ package cpw.mods.fml.common.discovery;
/*     */ 
/*     */ import com.google.common.base.Throwables;
/*     */ import com.google.common.collect.Lists;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.LoaderException;
/*     */ import cpw.mods.fml.common.MetadataCollection;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import cpw.mods.fml.common.ModContainerFactory;
/*     */ import cpw.mods.fml.common.discovery.asm.ASMModParser;
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.io.FileInputStream;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.regex.Matcher;
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
/*     */ public class DirectoryDiscoverer
/*     */   implements ITypeDiscoverer
/*     */ {
/*     */   private ASMDataTable table;
/*     */   
/*     */   private class ClassFilter
/*     */     implements FileFilter
/*     */   {
/*     */     private ClassFilter() {}
/*     */     
/*     */     public boolean accept(File file) {
/*  41 */       return ((file.isFile() && ITypeDiscoverer.classFile.matcher(file.getName()).matches()) || file.isDirectory());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<ModContainer> discover(ModCandidate candidate, ASMDataTable table) {
/*  50 */     this.table = table;
/*  51 */     List<ModContainer> found = Lists.newArrayList();
/*  52 */     FMLLog.fine("Examining directory %s for potential mods", new Object[] { candidate.getModContainer().getName() });
/*  53 */     exploreFileSystem("", candidate.getModContainer(), found, candidate, null);
/*  54 */     for (ModContainer mc : found)
/*     */     {
/*  56 */       table.addContainer(mc);
/*     */     }
/*  58 */     return found;
/*     */   }
/*     */ 
/*     */   
/*     */   public void exploreFileSystem(String path, File modDir, List<ModContainer> harvestedMods, ModCandidate candidate, MetadataCollection mc) {
/*  63 */     if (path.length() == 0) {
/*     */       
/*  65 */       File metadata = new File(modDir, "mcmod.info");
/*     */       
/*     */       try {
/*  68 */         FileInputStream fis = new FileInputStream(metadata);
/*  69 */         mc = MetadataCollection.from(fis, modDir.getName());
/*  70 */         fis.close();
/*  71 */         FMLLog.fine("Found an mcmod.info file in directory %s", new Object[] { modDir.getName() });
/*     */       }
/*  73 */       catch (Exception e) {
/*     */         
/*  75 */         mc = MetadataCollection.from(null, "");
/*  76 */         FMLLog.fine("No mcmod.info file found in directory %s", new Object[] { modDir.getName() });
/*     */       } 
/*     */     } 
/*     */     
/*  80 */     File[] content = modDir.listFiles(new ClassFilter());
/*     */ 
/*     */     
/*  83 */     Arrays.sort((Object[])content);
/*  84 */     for (File file : content) {
/*     */       
/*  86 */       if (file.isDirectory()) {
/*     */         
/*  88 */         FMLLog.finer("Recursing into package %s", new Object[] { path + file.getName() });
/*  89 */         exploreFileSystem(path + file.getName() + ".", file, harvestedMods, candidate, mc);
/*     */       } else {
/*     */         
/*  92 */         Matcher match = classFile.matcher(file.getName());
/*     */         
/*  94 */         if (match.matches()) {
/*     */           
/*  96 */           ASMModParser modParser = null;
/*     */           
/*     */           try {
/*  99 */             FileInputStream fis = new FileInputStream(file);
/* 100 */             modParser = new ASMModParser(fis);
/* 101 */             fis.close();
/* 102 */             candidate.addClassEntry(path + file.getName());
/*     */           }
/* 104 */           catch (LoaderException e) {
/*     */             
/* 106 */             FMLLog.log(Level.ERROR, (Throwable)e, "There was a problem reading the file %s - probably this is a corrupt file", new Object[] { file.getPath() });
/* 107 */             throw e;
/*     */           }
/* 109 */           catch (Exception e) {
/*     */             
/* 111 */             Throwables.propagate(e);
/*     */           } 
/*     */           
/* 114 */           modParser.validate();
/* 115 */           modParser.sendToTable(this.table, candidate);
/* 116 */           ModContainer container = ModContainerFactory.instance().build(modParser, candidate.getModContainer(), candidate);
/* 117 */           if (container != null) {
/*     */             
/* 119 */             harvestedMods.add(container);
/* 120 */             container.bindMetadata(mc);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\discovery\DirectoryDiscoverer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */