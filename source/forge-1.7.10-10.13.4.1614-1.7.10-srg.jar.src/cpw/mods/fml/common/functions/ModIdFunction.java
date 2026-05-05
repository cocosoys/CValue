/*    */ package cpw.mods.fml.common.functions;
/*    */ 
/*    */ import com.google.common.base.Function;
/*    */ import cpw.mods.fml.common.ModContainer;
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
/*    */ public final class ModIdFunction
/*    */   implements Function<ModContainer, String>
/*    */ {
/*    */   public String apply(ModContainer container) {
/* 24 */     return container.getModId();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\functions\ModIdFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */