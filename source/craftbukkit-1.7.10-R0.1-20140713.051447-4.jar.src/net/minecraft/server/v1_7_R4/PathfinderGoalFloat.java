/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PathfinderGoalFloat
/*    */   extends PathfinderGoal
/*    */ {
/*    */   private EntityInsentient a;
/*    */   
/*    */   public PathfinderGoalFloat(EntityInsentient paramEntityInsentient) {
/* 11 */     this.a = paramEntityInsentient;
/* 12 */     a(4);
/* 13 */     paramEntityInsentient.getNavigation().e(true);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean a() {
/* 18 */     return (this.a.M() || this.a.P());
/*    */   }
/*    */ 
/*    */   
/*    */   public void e() {
/* 23 */     if (this.a.aI().nextFloat() < 0.8F) this.a.getControllerJump().a(); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PathfinderGoalFloat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */