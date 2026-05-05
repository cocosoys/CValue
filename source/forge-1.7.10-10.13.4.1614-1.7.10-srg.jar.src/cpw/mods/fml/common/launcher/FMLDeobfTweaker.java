/*    */ package cpw.mods.fml.common.launcher;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.CoreModManager;
/*    */ import cpw.mods.fml.relauncher.FMLInjectionData;
/*    */ import cpw.mods.fml.relauncher.FMLRelaunchLog;
/*    */ import java.io.File;
/*    */ import java.lang.reflect.Method;
/*    */ import java.util.List;
/*    */ import net.minecraft.launchwrapper.ITweaker;
/*    */ import net.minecraft.launchwrapper.Launch;
/*    */ import net.minecraft.launchwrapper.LaunchClassLoader;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FMLDeobfTweaker
/*    */   implements ITweaker
/*    */ {
/*    */   public void acceptOptions(List<String> args, File gameDir, File assetsDir, String profile) {}
/*    */   
/*    */   public void injectIntoClassLoader(LaunchClassLoader classLoader) {
/* 25 */     if (!((Boolean)Launch.blackboard.get("fml.deobfuscatedEnvironment")).booleanValue())
/*    */     {
/* 27 */       classLoader.registerTransformer("cpw.mods.fml.common.asm.transformers.DeobfuscationTransformer");
/*    */     }
/*    */     
/* 30 */     for (String transformer : CoreModManager.getAccessTransformers())
/*    */     {
/* 32 */       classLoader.registerTransformer(transformer);
/*    */     }
/* 34 */     classLoader.registerTransformer("cpw.mods.fml.common.asm.transformers.ModAccessTransformer");
/* 35 */     classLoader.registerTransformer("cpw.mods.fml.common.asm.transformers.ItemStackTransformer");
/*    */     
/*    */     try {
/* 38 */       FMLRelaunchLog.fine("Validating minecraft", new Object[0]);
/* 39 */       Class<?> loaderClazz = Class.forName("cpw.mods.fml.common.Loader", true, (ClassLoader)classLoader);
/* 40 */       Method m = loaderClazz.getMethod("injectData", new Class[] { Object[].class });
/* 41 */       m.invoke(null, new Object[] { FMLInjectionData.data() });
/* 42 */       m = loaderClazz.getMethod("instance", new Class[0]);
/* 43 */       m.invoke(null, new Object[0]);
/* 44 */       FMLRelaunchLog.fine("Minecraft validated, launching...", new Object[0]);
/*    */     }
/* 46 */     catch (Exception e) {
/*    */ 
/*    */       
/* 49 */       System.out.println("A CRITICAL PROBLEM OCCURED INITIALIZING MINECRAFT - LIKELY YOU HAVE AN INCORRECT VERSION FOR THIS FML");
/* 50 */       throw new RuntimeException(e);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getLaunchTarget() {
/* 57 */     throw new RuntimeException("Invalid for use as a primary tweaker");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String[] getLaunchArguments() {
/* 63 */     return new String[0];
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\launcher\FMLDeobfTweaker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */