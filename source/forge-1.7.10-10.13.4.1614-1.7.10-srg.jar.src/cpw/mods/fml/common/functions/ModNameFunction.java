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
/*    */ public class ModNameFunction
/*    */   implements Function<ModContainer, String>
/*    */ {
/*    */   public String apply(ModContainer input) {
/* 24 */     return input.getName();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\functions\ModNameFunction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */