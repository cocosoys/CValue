/*    */ package cpw.mods.fml.common;
/*    */ 
/*    */ import com.google.common.collect.ImmutableList;
/*    */ import cpw.mods.fml.common.asm.transformers.ModAPITransformer;
/*    */ import cpw.mods.fml.common.discovery.ASMDataTable;
/*    */ import java.io.File;
/*    */ import java.net.MalformedURLException;
/*    */ import java.net.URISyntaxException;
/*    */ import java.net.URL;
/*    */ import java.net.URLClassLoader;
/*    */ import java.util.List;
/*    */ import java.util.Set;
/*    */ import net.minecraft.launchwrapper.IClassTransformer;
/*    */ import net.minecraft.launchwrapper.LaunchClassLoader;
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
/*    */ 
/*    */ 
/*    */ public class ModClassLoader
/*    */   extends URLClassLoader
/*    */ {
/* 41 */   private static final List<String> STANDARD_LIBRARIES = (List<String>)ImmutableList.of("jinput.jar", "lwjgl.jar", "lwjgl_util.jar", "rt.jar");
/*    */   private LaunchClassLoader mainClassLoader;
/*    */   
/*    */   public ModClassLoader(ClassLoader parent) {
/* 45 */     super(new URL[0], (ClassLoader)null);
/* 46 */     this.mainClassLoader = (LaunchClassLoader)parent;
/*    */   }
/*    */ 
/*    */   
/*    */   public void addFile(File modFile) throws MalformedURLException {
/* 51 */     URL url = modFile.toURI().toURL();
/* 52 */     this.mainClassLoader.addURL(url);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<?> loadClass(String name) throws ClassNotFoundException {
/* 58 */     return this.mainClassLoader.loadClass(name);
/*    */   }
/*    */   
/*    */   public File[] getParentSources() {
/* 62 */     List<URL> urls = this.mainClassLoader.getSources();
/* 63 */     File[] sources = new File[urls.size()];
/*    */     
/*    */     try {
/* 66 */       for (int i = 0; i < urls.size(); i++)
/*    */       {
/* 68 */         sources[i] = new File(((URL)urls.get(i)).toURI());
/*    */       }
/* 70 */       return sources;
/*    */     }
/* 72 */     catch (URISyntaxException e) {
/*    */       
/* 74 */       FMLLog.log(Level.ERROR, e, "Unable to process our input to locate the minecraft code", new Object[0]);
/* 75 */       throw new LoaderException(e);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public List<String> getDefaultLibraries() {
/* 81 */     return STANDARD_LIBRARIES;
/*    */   }
/*    */ 
/*    */   
/*    */   public void clearNegativeCacheFor(Set<String> classList) {
/* 86 */     this.mainClassLoader.clearNegativeEntries(classList);
/*    */   }
/*    */ 
/*    */   
/*    */   public ModAPITransformer addModAPITransformer(ASMDataTable dataTable) {
/* 91 */     this.mainClassLoader.registerTransformer("cpw.mods.fml.common.asm.transformers.ModAPITransformer");
/* 92 */     List<IClassTransformer> transformers = this.mainClassLoader.getTransformers();
/* 93 */     ModAPITransformer modAPI = (ModAPITransformer)transformers.get(transformers.size() - 1);
/* 94 */     modAPI.initTable(dataTable);
/* 95 */     return modAPI;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\ModClassLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */