/*    */ package cpw.mods.fml.common;
/*    */ 
/*    */ import com.google.common.io.Files;
/*    */ import java.io.Closeable;
/*    */ import java.io.File;
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.IOException;
/*    */ import java.io.OutputStream;
/*    */ import java.net.URI;
/*    */ import java.util.Deque;
/*    */ import java.util.LinkedList;
/*    */ import java.util.zip.ZipEntry;
/*    */ import java.util.zip.ZipOutputStream;
/*    */ import org.apache.logging.log4j.Level;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ZipperUtil
/*    */ {
/*    */   public static void zip(File directory, File zipfile) throws IOException {
/* 28 */     URI base = directory.toURI();
/* 29 */     Deque<File> queue = new LinkedList<File>();
/* 30 */     queue.push(directory);
/* 31 */     OutputStream out = new FileOutputStream(zipfile);
/* 32 */     Closeable res = null;
/*    */     
/*    */     try {
/* 35 */       ZipOutputStream zout = new ZipOutputStream(out);
/* 36 */       res = zout;
/* 37 */       while (!queue.isEmpty()) {
/*    */         
/* 39 */         directory = queue.pop();
/* 40 */         for (File kid : directory.listFiles()) {
/*    */           
/* 42 */           String name = base.relativize(kid.toURI()).getPath();
/* 43 */           if (kid.isDirectory()) {
/*    */             
/* 45 */             queue.push(kid);
/* 46 */             name = name.endsWith("/") ? name : (name + "/");
/* 47 */             zout.putNextEntry(new ZipEntry(name));
/*    */           } else {
/*    */             
/* 50 */             zout.putNextEntry(new ZipEntry(name));
/* 51 */             Files.copy(kid, zout);
/* 52 */             zout.closeEntry();
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } finally {
/*    */       
/* 58 */       res.close();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void backupWorld() throws IOException {
/* 64 */     String dirName = FMLCommonHandler.instance().getMinecraftServerInstance().getFolderName();
/*    */     
/* 66 */     backupWorld(dirName);
/*    */   }
/*    */ 
/*    */   
/*    */   @Deprecated
/*    */   public static void backupWorld(String dirName, String saveName) throws IOException {
/* 72 */     backupWorld(dirName);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void backupWorld(String dirName) throws IOException {
/* 77 */     File dstFolder = FMLCommonHandler.instance().getSavesDirectory();
/* 78 */     File zip = new File(dstFolder, String.format("%s-%2$tY%2$tm%2$td-%2$tH%2$tM%2$tS.zip", new Object[] { dirName, Long.valueOf(System.currentTimeMillis()) }));
/*    */ 
/*    */     
/*    */     try {
/* 82 */       zip(new File(dstFolder, dirName), zip);
/*    */     }
/* 84 */     catch (IOException e) {
/*    */       
/* 86 */       FMLLog.log(Level.WARN, e, "World backup failed.", new Object[0]);
/* 87 */       throw e;
/*    */     } 
/*    */     
/* 90 */     FMLLog.info("World backup created at %s.", new Object[] { zip.getCanonicalPath() });
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\ZipperUtil.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */