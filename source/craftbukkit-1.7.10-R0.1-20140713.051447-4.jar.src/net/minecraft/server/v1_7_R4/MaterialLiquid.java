/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ public class MaterialLiquid extends Material {
/*    */   public MaterialLiquid(MaterialMapColor paramMaterialMapColor) {
/*  5 */     super(paramMaterialMapColor);
/*  6 */     i();
/*  7 */     n();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isLiquid() {
/* 12 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isSolid() {
/* 17 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isBuildable() {
/* 22 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\MaterialLiquid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */