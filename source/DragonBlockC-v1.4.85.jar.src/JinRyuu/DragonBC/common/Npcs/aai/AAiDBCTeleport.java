/*    */ package JinRyuu.DragonBC.common.Npcs.aai;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.DBCConfig;
/*    */ import JinRyuu.DragonBC.common.Npcs.EntityDBC;
/*    */ import JinRyuu.JRMCore.entity.aai.AAi;
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class AAiDBCTeleport
/*    */   extends AAi
/*    */ {
/*    */   private int timer;
/*    */   private int rateMin;
/*    */   private int rateMax;
/*    */   private int rate;
/*    */   private String sound;
/*    */   
/*    */   public AAiDBCTeleport(int[] values) {
/* 21 */     this(values[0], values[1], "jinryuudragonbc:DBC2.tp");
/*    */   }
/*    */   
/*    */   public AAiDBCTeleport(int[] values, String sound) {
/* 25 */     this(values[0], values[1], sound);
/*    */   }
/*    */   
/*    */   public AAiDBCTeleport(int rateMin, int rateMax, String sound) {
/* 29 */     this.timer = 0;
/* 30 */     this.rateMin = rateMin;
/* 31 */     this.rateMax = (rateMax < 1) ? 1 : rateMax;
/* 32 */     this.rate = generateRate();
/* 33 */     this.sound = sound;
/*    */   }
/*    */   
/*    */   public void update() {
/* 37 */     EntityDBC entity = (EntityDBC)this.aaiSystem.entity;
/* 38 */     boolean EnemyTeleportOutOfLock = DBCConfig.EnemyTeleportOutOfLock;
/*    */     
/* 40 */     if (entity.func_70089_S() && !entity.field_70170_p.field_72995_K && (EnemyTeleportOutOfLock || !entity.isLocked()) && !entity.chargingKiAttack) {
/*    */       
/* 42 */       this.timer++;
/* 43 */       List<Entity> list = entity.field_70170_p.func_72872_a(EntityPlayer.class, entity.field_70121_D.func_72314_b(16.0D, 16.0D, 16.0D));
/*    */       
/* 45 */       if (!list.isEmpty())
/*    */       {
/* 47 */         for (int i = 0; i < list.size(); i++) {
/*    */           
/* 49 */           Entity target = list.get(i);
/* 50 */           entity.becomeAngryAt2(target);
/*    */           
/* 52 */           if (this.timer >= this.rate) {
/*    */             
/* 54 */             this.rate = generateRate();
/* 55 */             this.timer = 0;
/* 56 */             entity.func_70634_a(target.field_70165_t, target.field_70163_u + 1.0D, target.field_70161_v);
/* 57 */             entity.field_70170_p.func_72956_a((Entity)entity, this.sound, 0.5F, entity.field_70170_p.field_73012_v.nextFloat() * 0.1F + 0.9F);
/*    */           } 
/*    */         } 
/*    */       }
/*    */     } 
/*    */   }
/*    */   
/*    */   public int generateRate() {
/* 65 */     return this.rateMin + (new Random()).nextInt(this.rateMax + 1);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Npcs\aai\AAiDBCTeleport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */