/*    */ package JinRyuu.DragonBC.common.Npcs.aai;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Npcs.EntityDBC;
/*    */ import JinRyuu.JRMCore.entity.aai.AAi;
/*    */ import JinRyuu.JRMCore.server.JGMathHelper;
/*    */ 
/*    */ public class AAiDBCFlyingCharge
/*    */   extends AAi {
/*    */   private double multi;
/*    */   private double rate;
/*    */   private double limit;
/*    */   
/*    */   public AAiDBCFlyingCharge(double[] values) {
/* 14 */     this(values[0], values[1], values[2]);
/*    */   }
/*    */   
/*    */   public AAiDBCFlyingCharge(double multi, double rate, double limit) {
/* 18 */     this.multi = multi;
/* 19 */     this.rate = rate;
/* 20 */     this.limit = limit;
/*    */   }
/*    */   
/*    */   public void update() {
/* 24 */     EntityDBC entity = (EntityDBC)this.aaiSystem.entity;
/*    */     
/* 26 */     if (entity.func_70089_S() && !entity.field_70170_p.field_72995_K && !entity.isLocked() && !entity.chargingKiAttack && entity
/* 27 */       .getTargetedEntity() != null && entity.func_70685_l(entity.getTargetedEntity()) && 
/* 28 */       checkChanceToUse(this.rate) && entity.canFly && !entity.field_70122_E) {
/*    */       
/* 30 */       if (JGMathHelper.doubleSmallerThan(entity.field_70159_w, 0.5D)) {
/*    */         
/* 32 */         double xDiff = ((entity.getTargetedEntity()).field_70165_t - entity.field_70165_t) / 50.0D * this.multi;
/* 33 */         entity.field_70159_w = xDiff;
/* 34 */         if (this.limit != -1.0D) entity.field_70159_w = JGMathHelper.doubleLimit(entity.field_70159_w, this.limit);
/*    */       
/*    */       } 
/* 37 */       if (JGMathHelper.doubleSmallerThan(entity.field_70179_y, 0.5D)) {
/*    */         
/* 39 */         double zDiff = ((entity.getTargetedEntity()).field_70161_v - entity.field_70161_v) / 50.0D * this.multi;
/* 40 */         entity.field_70179_y = zDiff;
/* 41 */         if (this.limit != -1.0D) entity.field_70179_y = JGMathHelper.doubleLimit(entity.field_70179_y, this.limit); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\aai\AAiDBCFlyingCharge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */