/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ public class PathfinderGoalRandomTargetNonTamed
/*    */   extends PathfinderGoalNearestAttackableTarget
/*    */ {
/*    */   private EntityTameableAnimal a;
/*    */   
/*    */   public PathfinderGoalRandomTargetNonTamed(EntityTameableAnimal paramEntityTameableAnimal, Class paramClass, int paramInt, boolean paramBoolean) {
/*  9 */     super(paramEntityTameableAnimal, paramClass, paramInt, paramBoolean);
/* 10 */     this.a = paramEntityTameableAnimal;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean a() {
/* 15 */     return (!this.a.isTamed() && super.a());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PathfinderGoalRandomTargetNonTamed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */