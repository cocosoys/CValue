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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ final class DispenseBehaviorArrow
/*    */   extends DispenseBehaviorProjectile
/*    */ {
/*    */   protected IProjectile a(World paramWorld, IPosition paramIPosition) {
/* 23 */     EntityArrow entityArrow = new EntityArrow(paramWorld, paramIPosition.getX(), paramIPosition.getY(), paramIPosition.getZ());
/* 24 */     entityArrow.fromPlayer = 1;
/*    */     
/* 26 */     return entityArrow;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\DispenseBehaviorArrow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */