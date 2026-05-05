/*    */ package JinRyuu.DragonBC.common.Npcs.aai;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Npcs.EntityDBC;
/*    */ import JinRyuu.JRMCore.entity.aai.AAi;
/*    */ import JinRyuu.JRMCore.server.JGMathHelper;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ public class AAiDBCGroundDash extends AAi {
/*    */   private double multi;
/*    */   private double rate;
/*    */   private double multi2;
/*    */   private double limit;
/*    */   
/*    */   public AAiDBCGroundDash(double[] values) {
/* 15 */     this(values[0], values[1], values[2], values[3]);
/*    */   }
/*    */   
/*    */   public AAiDBCGroundDash(double multi, double rate, double multi2, double limit) {
/* 19 */     this.multi = multi;
/* 20 */     this.rate = rate;
/* 21 */     this.multi2 = multi2;
/* 22 */     this.limit = limit;
/*    */   }
/*    */   
/*    */   public void update() {
/* 26 */     EntityDBC entity = (EntityDBC)this.aaiSystem.entity;
/*    */     
/* 28 */     if (entity.func_70089_S() && !entity.field_70170_p.field_72995_K && !entity.isLocked() && entity.getTargetedEntity() != null && entity.getTargetedEntity().func_70089_S() && entity
/* 29 */       .getTargetedEntity().func_70068_e((Entity)entity) < 4096.0D) {
/*    */       
/* 31 */       double xzDist = entity.getXZDistanceToEntity(entity.getTargetedEntity());
/*    */       
/* 33 */       if (checkChanceToUse(this.rate) && !entity.chargingKiAttack && xzDist >= 6.0D && entity.field_70122_E && !entity.isJumping()) {
/*    */         
/* 35 */         entity.field_70159_w *= this.multi;
/* 36 */         entity.field_70179_y *= this.multi;
/*    */         
/* 38 */         double xDiff = ((entity.getTargetedEntity()).field_70165_t - entity.field_70165_t) / 50.0D * this.multi2;
/* 39 */         double zDiff = ((entity.getTargetedEntity()).field_70161_v - entity.field_70161_v) / 50.0D * this.multi2;
/*    */         
/* 41 */         entity.field_70159_w += xDiff;
/* 42 */         if (this.limit != -1.0D) entity.field_70159_w = JGMathHelper.doubleLimit(entity.field_70159_w, this.limit); 
/* 43 */         entity.field_70179_y += zDiff;
/* 44 */         if (this.limit != -1.0D) entity.field_70179_y = JGMathHelper.doubleLimit(entity.field_70179_y, this.limit); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\aai\AAiDBCGroundDash.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */