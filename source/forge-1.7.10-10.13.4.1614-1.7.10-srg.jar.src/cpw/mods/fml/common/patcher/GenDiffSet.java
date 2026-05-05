/*    */ package cpw.mods.fml.common.patcher;
/*    */ 
/*    */ import com.google.common.hash.Hashing;
/*    */ import com.google.common.io.ByteArrayDataOutput;
/*    */ import com.google.common.io.ByteStreams;
/*    */ import com.google.common.io.Files;
/*    */ import cpw.mods.fml.common.asm.transformers.deobf.FMLDeobfuscatingRemapper;
/*    */ import cpw.mods.fml.repackage.com.nothome.delta.Delta;
/*    */ import java.io.File;
/*    */ import java.io.IOException;
/*    */ import java.util.Arrays;
/*    */ import java.util.List;
/*    */ import java.util.Locale;
/*    */ import java.util.jar.JarEntry;
/*    */ import java.util.jar.JarFile;
/*    */ import java.util.logging.Logger;
/*    */ import org.apache.logging.log4j.Level;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GenDiffSet
/*    */ {
/* 25 */   private static final List<String> RESERVED_NAMES = Arrays.asList(new String[] { "CON", "PRN", "AUX", "NUL", "COM1", "COM2", "COM3", "COM4", "COM5", "COM6", "COM7", "COM8", "COM9", "LPT1", "LPT2", "LPT3", "LPT4", "LPT5", "LPT6", "LPT7", "LPT8", "LPT9" });
/*    */ 
/*    */   
/*    */   public static void main(String[] args) throws IOException {
/* 29 */     String sourceJar = args[0];
/* 30 */     String targetDir = args[1];
/* 31 */     String deobfData = args[2];
/* 32 */     String outputDir = args[3];
/* 33 */     String killTarget = args[4];
/*    */     
/* 35 */     LogManager.getLogger("GENDIFF").log(Level.INFO, String.format("Creating patches at %s for %s from %s", new Object[] { outputDir, sourceJar, targetDir }));
/* 36 */     Delta delta = new Delta();
/* 37 */     FMLDeobfuscatingRemapper remapper = FMLDeobfuscatingRemapper.INSTANCE;
/* 38 */     remapper.setupLoadOnly(deobfData, false);
/* 39 */     JarFile sourceZip = new JarFile(sourceJar);
/* 40 */     boolean kill = killTarget.equalsIgnoreCase("true");
/*    */     
/* 42 */     File f = new File(outputDir);
/* 43 */     f.mkdirs();
/*    */     
/* 45 */     for (String name : remapper.getObfedClasses()) {
/*    */ 
/*    */       
/* 48 */       String fileName = name;
/* 49 */       String jarName = name;
/* 50 */       if (RESERVED_NAMES.contains(name.toUpperCase(Locale.ENGLISH)))
/*    */       {
/* 52 */         fileName = "_" + name;
/*    */       }
/* 54 */       File targetFile = new File(targetDir, fileName.replace('/', File.separatorChar) + ".class");
/* 55 */       jarName = jarName + ".class";
/* 56 */       if (targetFile.exists()) {
/*    */         
/* 58 */         String sourceClassName = name.replace('/', '.');
/* 59 */         String targetClassName = remapper.map(name).replace('/', '.');
/* 60 */         JarEntry entry = sourceZip.getJarEntry(jarName);
/*    */         
/* 62 */         byte[] vanillaBytes = (entry != null) ? ByteStreams.toByteArray(sourceZip.getInputStream(entry)) : new byte[0];
/* 63 */         byte[] patchedBytes = Files.toByteArray(targetFile);
/*    */         
/* 65 */         byte[] diff = delta.compute(vanillaBytes, patchedBytes);
/*    */ 
/*    */         
/* 68 */         ByteArrayDataOutput diffOut = ByteStreams.newDataOutput(diff.length + 50);
/*    */         
/* 70 */         diffOut.writeUTF(name);
/*    */         
/* 72 */         diffOut.writeUTF(sourceClassName);
/*    */         
/* 74 */         diffOut.writeUTF(targetClassName);
/*    */         
/* 76 */         diffOut.writeBoolean((entry != null));
/* 77 */         if (entry != null)
/*    */         {
/* 79 */           diffOut.writeInt(Hashing.adler32().hashBytes(vanillaBytes).asInt());
/*    */         }
/*    */         
/* 82 */         diffOut.writeInt(diff.length);
/*    */         
/* 84 */         diffOut.write(diff);
/*    */         
/* 86 */         File target = new File(outputDir, targetClassName + ".binpatch");
/* 87 */         target.getParentFile().mkdirs();
/* 88 */         Files.write(diffOut.toByteArray(), target);
/* 89 */         Logger.getLogger("GENDIFF").info(String.format("Wrote patch for %s (%s) at %s", new Object[] { name, targetClassName, target.getAbsolutePath() }));
/* 90 */         if (kill) {
/*    */           
/* 92 */           targetFile.delete();
/* 93 */           Logger.getLogger("GENDIFF").info(String.format("  Deleted target: %s", new Object[] { targetFile.toString() }));
/*    */         } 
/*    */       } 
/*    */     } 
/* 97 */     sourceZip.close();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\patcher\GenDiffSet.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */