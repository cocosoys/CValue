/*    */ package net.minecraftforge.classloading;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
/*    */ import java.io.File;
/*    */ import java.util.Map;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FMLForgePlugin
/*    */   implements IFMLLoadingPlugin
/*    */ {
/*    */   public static boolean RUNTIME_DEOBF = false;
/*    */   public static File forgeLocation;
/*    */   
/*    */   public String[] getASMTransformerClass() {
/* 16 */     return new String[] { "net.minecraftforge.classloading.FluidIdTransformer" };
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getModContainerClass() {
/* 22 */     return "net.minecraftforge.common.ForgeModContainer";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getSetupClass() {
/* 28 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void injectData(Map<String, Object> data) {
/* 34 */     RUNTIME_DEOBF = ((Boolean)data.get("runtimeDeobfuscationEnabled")).booleanValue();
/* 35 */     forgeLocation = (File)data.get("coremodLocation");
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getAccessTransformerClass() {
/* 41 */     return "net.minecraftforge.transformers.ForgeAccessTransformer";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\classloading\FMLForgePlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */