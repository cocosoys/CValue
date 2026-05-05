/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockCloth
/*    */   extends Block
/*    */ {
/*    */   public BlockCloth(Material paramMaterial) {
/* 15 */     super(paramMaterial);
/* 16 */     a(CreativeModeTab.b);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getDropData(int paramInt) {
/* 26 */     return paramInt;
/*    */   }
/*    */   
/*    */   public static int b(int paramInt) {
/* 30 */     return c(paramInt);
/*    */   }
/*    */   
/*    */   public static int c(int paramInt) {
/* 34 */     return (paramInt ^ 0xFFFFFFFF) & 0xF;
/*    */   }
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
/*    */   public MaterialMapColor f(int paramInt) {
/* 55 */     return MaterialMapColor.a(paramInt);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BlockCloth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */