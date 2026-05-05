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
/*    */ final class DispenseBehaviorSnowBall
/*    */   extends DispenseBehaviorProjectile
/*    */ {
/*    */   protected IProjectile a(World paramWorld, IPosition paramIPosition) {
/* 38 */     return new EntitySnowball(paramWorld, paramIPosition.getX(), paramIPosition.getY(), paramIPosition.getZ());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\DispenseBehaviorSnowBall.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */