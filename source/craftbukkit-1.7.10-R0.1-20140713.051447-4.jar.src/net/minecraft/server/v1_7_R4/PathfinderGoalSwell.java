/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PathfinderGoalSwell
/*    */   extends PathfinderGoal
/*    */ {
/*    */   EntityCreeper a;
/*    */   EntityLiving b;
/*    */   
/*    */   public PathfinderGoalSwell(EntityCreeper paramEntityCreeper) {
/* 12 */     this.a = paramEntityCreeper;
/* 13 */     a(1);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean a() {
/* 18 */     EntityLiving entityLiving = this.a.getGoalTarget();
/* 19 */     return (this.a.cb() > 0 || (entityLiving != null && this.a.f(entityLiving) < 9.0D));
/*    */   }
/*    */ 
/*    */   
/*    */   public void c() {
/* 24 */     this.a.getNavigation().h();
/* 25 */     this.b = this.a.getGoalTarget();
/*    */   }
/*    */ 
/*    */   
/*    */   public void d() {
/* 30 */     this.b = null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void e() {
/* 35 */     if (this.b == null) {
/* 36 */       this.a.a(-1);
/*    */       
/*    */       return;
/*    */     } 
/* 40 */     if (this.a.f(this.b) > 49.0D) {
/* 41 */       this.a.a(-1);
/*    */       
/*    */       return;
/*    */     } 
/* 45 */     if (!this.a.getEntitySenses().canSee(this.b)) {
/* 46 */       this.a.a(-1);
/*    */       
/*    */       return;
/*    */     } 
/* 50 */     this.a.a(1);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PathfinderGoalSwell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */