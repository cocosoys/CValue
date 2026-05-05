/*    */ package JinRyuu.DragonBC.common.Npcs.aai;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Npcs.EntityDBC;
/*    */ import JinRyuu.JRMCore.entity.aai.AAi;
/*    */ import JinRyuu.JRMCore.server.JGMathHelper;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ public class AAiDBCGroundJump
/*    */   extends AAi {
/*    */   private static final int STILL_JUMP_TIMER = 10;
/*    */   private double multi;
/*    */   private double rate;
/*    */   private double multi2;
/*    */   private double limit;
/*    */   private double limit2;
/*    */   private int stillStandingCountdown;
/*    */   private double xzDistLast;
/*    */   private double posXLast;
/*    */   private double posZLast;
/*    */   
/*    */   public AAiDBCGroundJump(double[] values) {
/* 22 */     this(values[0], values[1], values[2], values[3], values[4]);
/*    */   }
/*    */   
/*    */   public AAiDBCGroundJump(double multi, double rate, double multi2, double limit, double limit2) {
/* 26 */     this.multi = multi;
/* 27 */     this.rate = rate;
/* 28 */     this.multi2 = multi2;
/* 29 */     this.limit = limit;
/* 30 */     this.limit2 = limit2;
/*    */     
/* 32 */     this.stillStandingCountdown = 10;
/* 33 */     this.xzDistLast = 0.0D;
/* 34 */     this.posXLast = 0.0D;
/* 35 */     this.posZLast = 0.0D;
/*    */   }
/*    */   
/*    */   public void update() {
/* 39 */     EntityDBC entity = (EntityDBC)this.aaiSystem.entity;
/*    */     
/* 41 */     if (entity.func_70089_S() && !entity.field_70170_p.field_72995_K && !entity.isLocked() && entity.getTargetedEntity() != null && entity.getTargetedEntity().func_70089_S() && entity
/* 42 */       .getTargetedEntity().func_70068_e((Entity)entity) < 4096.0D) {
/*    */       
/* 44 */       double xzDist = entity.getXZDistanceToEntity(entity.getTargetedEntity());
/* 45 */       double yDist = entity.getYDistanceToEntity(entity.getTargetedEntity());
/*    */ 
/*    */       
/* 48 */       if (JGMathHelper.doubleSmallerThan(xzDist - this.xzDistLast, 0.01D) || (
/* 49 */         JGMathHelper.doubleSmallerThan(entity.field_70165_t - this.posXLast, 0.01D) && JGMathHelper.doubleSmallerThan(entity.field_70161_v - this.posZLast, 0.01D))) {
/*    */         
/* 51 */         this.stillStandingCountdown--;
/*    */       }
/*    */       else {
/*    */         
/* 55 */         this.stillStandingCountdown = 10;
/*    */       } 
/*    */       
/* 58 */       this.xzDistLast = xzDist;
/* 59 */       this.posXLast = entity.field_70165_t;
/* 60 */       this.posZLast = entity.field_70161_v;
/*    */       
/* 62 */       boolean attemptRandomJump = (entity.field_70173_aa % 25 == 0 && xzDist > entity.field_70130_N + 2.5D) ? checkChanceToUse(0.25D) : false;
/*    */       
/* 64 */       if ((!entity.canFly || (entity.getTargetedEntity()).field_70122_E || attemptRandomJump || isStandingStill()) && (attemptRandomJump || 
/* 65 */         isStandingStill() || yDist > (entity.field_70131_O * 1.5F)) && (attemptRandomJump || 
/* 66 */         isStandingStill() || (entity.getTargetedEntity()).field_70163_u - entity.field_70163_u > 0.0D) && entity.field_70122_E && 
/*    */         
/* 68 */         !entity.isJumping() && 
/* 69 */         checkChanceToUse(this.rate)) {
/*    */         
/* 71 */         entity.useJump();
/* 72 */         double jumpMulti = 1.0D + ((isStandingStill() || attemptRandomJump) ? (3.0D + yDist) : yDist) / 5.0D;
/* 73 */         entity.field_70181_x *= jumpMulti * this.multi;
/* 74 */         if (this.limit2 != -1.0D) entity.field_70181_x = JGMathHelper.doubleLimit(entity.field_70181_x, this.limit2);
/*    */ 
/*    */         
/* 77 */         double xDiff = ((entity.getTargetedEntity()).field_70165_t - entity.field_70165_t) / 10.0D * this.multi2;
/* 78 */         double zDiff = ((entity.getTargetedEntity()).field_70161_v - entity.field_70161_v) / 10.0D * this.multi2;
/*    */         
/* 80 */         entity.field_70159_w += xDiff;
/* 81 */         if (this.limit != -1.0D) entity.field_70159_w = JGMathHelper.doubleLimit(entity.field_70159_w, this.limit); 
/* 82 */         entity.field_70179_y += zDiff;
/* 83 */         if (this.limit != -1.0D) entity.field_70179_y = JGMathHelper.doubleLimit(entity.field_70179_y, this.limit);
/*    */         
/* 85 */         this.stillStandingCountdown = 10;
/*    */       }
/*    */       else {
/*    */         
/* 89 */         entity.func_70637_d(false);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   private boolean isStandingStill() {
/* 94 */     return (this.stillStandingCountdown <= 0);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\aai\AAiDBCGroundJump.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */