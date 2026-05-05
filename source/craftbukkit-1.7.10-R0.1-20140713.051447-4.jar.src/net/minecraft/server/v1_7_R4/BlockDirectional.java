/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class BlockDirectional
/*    */   extends Block
/*    */ {
/*    */   protected BlockDirectional(Material paramMaterial) {
/* 11 */     super(paramMaterial);
/*    */   }
/*    */   
/*    */   public static int l(int paramInt) {
/* 15 */     return paramInt & 0x3;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BlockDirectional.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */