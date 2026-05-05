/*    */ package cpw.mods.fml.relauncher;
/*    */ 
/*    */ import java.util.Map;
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
/*    */ public class FMLCorePlugin
/*    */   implements IFMLLoadingPlugin
/*    */ {
/*    */   public String[] getASMTransformerClass() {
/* 22 */     return new String[] { "cpw.mods.fml.common.asm.transformers.MarkerTransformer", "cpw.mods.fml.common.asm.transformers.SideTransformer", "cpw.mods.fml.common.asm.transformers.EventSubscriptionTransformer" };
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getAccessTransformerClass() {
/* 32 */     return "cpw.mods.fml.common.asm.transformers.AccessTransformer";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getModContainerClass() {
/* 37 */     return "cpw.mods.fml.common.FMLContainer";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String getSetupClass() {
/* 43 */     return "cpw.mods.fml.common.asm.FMLSanityChecker";
/*    */   }
/*    */   
/*    */   public void injectData(Map<String, Object> data) {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\relauncher\FMLCorePlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */