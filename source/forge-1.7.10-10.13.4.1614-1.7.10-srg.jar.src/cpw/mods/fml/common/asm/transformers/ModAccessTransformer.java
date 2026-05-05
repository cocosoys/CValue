/*    */ package cpw.mods.fml.common.asm.transformers;
/*    */ 
/*    */ import com.google.common.base.Charsets;
/*    */ import com.google.common.collect.Maps;
/*    */ import com.google.common.io.ByteSource;
/*    */ import com.google.common.io.CharSource;
/*    */ import cpw.mods.fml.relauncher.FMLRelaunchLog;
/*    */ import java.io.IOException;
/*    */ import java.io.InputStream;
/*    */ import java.lang.reflect.Field;
/*    */ import java.util.Map;
/*    */ import java.util.jar.JarEntry;
/*    */ import java.util.jar.JarFile;
/*    */ import java.util.jar.Manifest;
/*    */ 
/*    */ public class ModAccessTransformer extends AccessTransformer {
/* 17 */   private static Map<String, String> embedded = Maps.newHashMap();
/*    */ 
/*    */   
/*    */   public ModAccessTransformer() throws Exception {
/* 21 */     super((Class)ModAccessTransformer.class);
/*    */     
/* 23 */     ClassLoader classLoader = getClass().getClassLoader().getClass().getClassLoader();
/* 24 */     Class<?> otherClazz = Class.forName(getClass().getName(), true, classLoader);
/* 25 */     Field otherField = otherClazz.getDeclaredField("embedded");
/* 26 */     otherField.setAccessible(true);
/* 27 */     embedded = (Map<String, String>)otherField.get(null);
/*    */     
/* 29 */     for (Map.Entry<String, String> e : embedded.entrySet()) {
/*    */       
/* 31 */       int old_count = getModifiers().size();
/* 32 */       processATFile(CharSource.wrap(e.getValue()));
/* 33 */       int added = getModifiers().size() - old_count;
/* 34 */       if (added > 0)
/*    */       {
/* 36 */         FMLRelaunchLog.fine("Loaded %d rules from AccessTransformer mod jar file %s\n", new Object[] { Integer.valueOf(added), e.getKey() });
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void addJar(JarFile jar) throws IOException {
/* 43 */     Manifest manifest = jar.getManifest();
/* 44 */     String atList = manifest.getMainAttributes().getValue("FMLAT");
/* 45 */     if (atList == null)
/* 46 */       return;  for (String at : atList.split(" ")) {
/*    */       
/* 48 */       JarEntry jarEntry = jar.getJarEntry("META-INF/" + at);
/* 49 */       if (jarEntry != null)
/*    */       {
/* 51 */         embedded.put(String.format("%s!META-INF/%s", new Object[] { jar.getName(), at }), (new JarByteSource(jar, jarEntry))
/* 52 */             .asCharSource(Charsets.UTF_8).read());
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   private static class JarByteSource
/*    */     extends ByteSource {
/*    */     private JarFile jar;
/*    */     private JarEntry entry;
/*    */     
/*    */     public JarByteSource(JarFile jar, JarEntry entry) {
/* 63 */       this.jar = jar;
/* 64 */       this.entry = entry;
/*    */     }
/*    */ 
/*    */     
/*    */     public InputStream openStream() throws IOException {
/* 69 */       return this.jar.getInputStream(this.entry);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\asm\transformers\ModAccessTransformer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */