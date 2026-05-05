/*    */ package net.minecraft.server.v1_7_R4;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.event.Event;
/*    */ import org.bukkit.event.entity.ExplosionPrimeEvent;
/*    */ 
/*    */ public class EntityWitherSkull extends EntityFireball {
/*    */   public EntityWitherSkull(World world) {
/*  8 */     super(world);
/*  9 */     a(0.3125F, 0.3125F);
/*    */   }
/*    */   
/*    */   public EntityWitherSkull(World world, EntityLiving entityliving, double d0, double d1, double d2) {
/* 13 */     super(world, entityliving, d0, d1, d2);
/* 14 */     a(0.3125F, 0.3125F);
/*    */   }
/*    */   
/*    */   protected float e() {
/* 18 */     return isCharged() ? 0.73F : super.e();
/*    */   }
/*    */   
/*    */   public boolean isBurning() {
/* 22 */     return false;
/*    */   }
/*    */   
/*    */   public float a(Explosion explosion, World world, int i, int j, int k, Block block) {
/* 26 */     float f = super.a(explosion, world, i, j, k, block);
/*    */     
/* 28 */     if (isCharged() && block != Blocks.BEDROCK && block != Blocks.ENDER_PORTAL && block != Blocks.ENDER_PORTAL_FRAME && block != Blocks.COMMAND) {
/* 29 */       f = Math.min(0.8F, f);
/*    */     }
/*    */     
/* 32 */     return f;
/*    */   }
/*    */   
/*    */   protected void a(MovingObjectPosition movingobjectposition) {
/* 36 */     if (!this.world.isStatic) {
/* 37 */       if (movingobjectposition.entity != null) {
/* 38 */         if (this.shooter != null) {
/* 39 */           if (movingobjectposition.entity.damageEntity(DamageSource.mobAttack(this.shooter), 8.0F) && !movingobjectposition.entity.isAlive()) {
/* 40 */             this.shooter.heal(5.0F, EntityRegainHealthEvent.RegainReason.WITHER);
/*    */           }
/*    */         } else {
/* 43 */           movingobjectposition.entity.damageEntity(DamageSource.MAGIC, 5.0F);
/*    */         } 
/*    */         
/* 46 */         if (movingobjectposition.entity instanceof EntityLiving) {
/* 47 */           byte b0 = 0;
/*    */           
/* 49 */           if (this.world.difficulty == EnumDifficulty.NORMAL) {
/* 50 */             b0 = 10;
/* 51 */           } else if (this.world.difficulty == EnumDifficulty.HARD) {
/* 52 */             b0 = 40;
/*    */           } 
/*    */           
/* 55 */           if (b0 > 0) {
/* 56 */             ((EntityLiving)movingobjectposition.entity).addEffect(new MobEffect(MobEffectList.WITHER.id, 20 * b0, 1));
/*    */           }
/*    */         } 
/*    */       } 
/*    */ 
/*    */       
/* 62 */       ExplosionPrimeEvent event = new ExplosionPrimeEvent((Entity)getBukkitEntity(), 1.0F, false);
/* 63 */       this.world.getServer().getPluginManager().callEvent((Event)event);
/*    */       
/* 65 */       if (!event.isCancelled()) {
/* 66 */         this.world.createExplosion(this, this.locX, this.locY, this.locZ, event.getRadius(), event.getFire(), this.world.getGameRules().getBoolean("mobGriefing"));
/*    */       }
/*    */ 
/*    */       
/* 70 */       die();
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean R() {
/* 75 */     return false;
/*    */   }
/*    */   
/*    */   public boolean damageEntity(DamageSource damagesource, float f) {
/* 79 */     return false;
/*    */   }
/*    */   
/*    */   protected void c() {
/* 83 */     this.datawatcher.a(10, Byte.valueOf((byte)0));
/*    */   }
/*    */   
/*    */   public boolean isCharged() {
/* 87 */     return (this.datawatcher.getByte(10) == 1);
/*    */   }
/*    */   
/*    */   public void setCharged(boolean flag) {
/* 91 */     this.datawatcher.watch(10, Byte.valueOf((byte)(flag ? 1 : 0)));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\EntityWitherSkull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */