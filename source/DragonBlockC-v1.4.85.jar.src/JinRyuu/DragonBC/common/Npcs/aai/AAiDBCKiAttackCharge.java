/*    */ package JinRyuu.DragonBC.common.Npcs.aai;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Npcs.EntityDBC;
/*    */ import JinRyuu.JRMCore.entity.aai.AAi;
/*    */ import JinRyuu.JRMCore.server.JGMathHelper;
/*    */ import java.util.Random;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ public class AAiDBCKiAttackCharge
/*    */   extends AAi {
/*    */   private double multi;
/*    */   private double rate;
/*    */   private double limit;
/*    */   
/*    */   public AAiDBCKiAttackCharge(double[] values) {
/* 16 */     this(values[0], values[1], values[2]);
/*    */   }
/*    */   
/*    */   public AAiDBCKiAttackCharge(double multi, double rate, double limit) {
/* 20 */     this.multi = multi;
/* 21 */     this.rate = rate;
/* 22 */     this.limit = limit;
/*    */   }
/*    */   
/*    */   public void update() {
/* 26 */     EntityDBC entity = (EntityDBC)this.aaiSystem.entity;
/*    */     
/* 28 */     if (entity.func_70089_S() && entity.canFireKiAttacks && !entity.isLocked() && !entity.field_70170_p.field_72995_K && entity.getTargetedEntity() != null && entity.getTargetedEntity().func_70089_S() && entity
/* 29 */       .getTargetedEntity().func_70068_e((Entity)entity) < 4096.0D) {
/*    */ 
/*    */       
/* 32 */       int chargeTimerMax = 25;
/* 33 */       int KI_ATTACK_DISTANCE = 10;
/*    */       
/* 35 */       double xzDist = entity.getXZDistanceToEntity(entity.getTargetedEntity());
/* 36 */       double yDist = entity.getYDistanceToEntity(entity.getTargetedEntity());
/*    */ 
/*    */       
/* 39 */       if (!entity.chargingKiAttack && entity.field_70173_aa % 25 == 0 && checkChanceToUse(this.rate)) {
/*    */         
/* 41 */         entity.chargingKiAttack = true;
/* 42 */         entity.chargingKiAttackTimer = 0;
/* 43 */         entity.chargingKiAttackTimerMax = (byte)(35 + (new Random()).nextInt(25));
/*    */       } 
/*    */ 
/*    */       
/* 47 */       if (entity.chargingKiAttack) {
/*    */ 
/*    */         
/* 50 */         entity.chargingKiAttackTimer++;
/*    */         
/* 52 */         if (entity.chargingKiAttackTimer >= entity.chargingKiAttackTimerMax) {
/*    */           
/* 54 */           entity.chargingKiAttack = false;
/* 55 */           entity.chargingKiAttackTimer = 0;
/*    */         } 
/*    */ 
/*    */         
/* 59 */         if (xzDist < 10.0D) {
/*    */           
/* 61 */           double xDiff = ((entity.getTargetedEntity()).field_70165_t - entity.field_70165_t) / 10.0D * this.multi;
/* 62 */           double zDiff = ((entity.getTargetedEntity()).field_70161_v - entity.field_70161_v) / 10.0D * this.multi;
/* 63 */           entity.field_70159_w = -xDiff; entity.field_70159_w = JGMathHelper.doubleLimit(entity.field_70159_w, this.limit);
/* 64 */           entity.field_70179_y = -zDiff; entity.field_70179_y = JGMathHelper.doubleLimit(entity.field_70179_y, this.limit);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\aai\AAiDBCKiAttackCharge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */