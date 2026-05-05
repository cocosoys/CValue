/*    */ package org.bukkit.craftbukkit.v1_7_R4.entity;
/*    */ 
/*    */ import net.minecraft.server.v1_7_R4.Entity;
/*    */ import net.minecraft.server.v1_7_R4.EntityArrow;
/*    */ import org.apache.commons.lang.Validate;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*    */ import org.bukkit.entity.Arrow;
/*    */ import org.bukkit.entity.EntityType;
/*    */ import org.bukkit.entity.LivingEntity;
/*    */ import org.bukkit.projectiles.ProjectileSource;
/*    */ 
/*    */ public class CraftArrow
/*    */   extends AbstractProjectile implements Arrow {
/*    */   public CraftArrow(CraftServer server, EntityArrow entity) {
/* 15 */     super(server, (Entity)entity);
/*    */   }
/*    */   
/*    */   public void setKnockbackStrength(int knockbackStrength) {
/* 19 */     Validate.isTrue((knockbackStrength >= 0), "Knockback cannot be negative");
/* 20 */     getHandle().setKnockbackStrength(knockbackStrength);
/*    */   }
/*    */   
/*    */   public int getKnockbackStrength() {
/* 24 */     return (getHandle()).knockbackStrength;
/*    */   }
/*    */   
/*    */   public boolean isCritical() {
/* 28 */     return getHandle().isCritical();
/*    */   }
/*    */   
/*    */   public void setCritical(boolean critical) {
/* 32 */     getHandle().setCritical(critical);
/*    */   }
/*    */   
/*    */   public ProjectileSource getShooter() {
/* 36 */     return (getHandle()).projectileSource;
/*    */   }
/*    */   
/*    */   public void setShooter(ProjectileSource shooter) {
/* 40 */     if (shooter instanceof LivingEntity) {
/* 41 */       (getHandle()).shooter = (Entity)((CraftLivingEntity)shooter).getHandle();
/*    */     } else {
/* 43 */       (getHandle()).shooter = null;
/*    */     } 
/* 45 */     (getHandle()).projectileSource = shooter;
/*    */   }
/*    */ 
/*    */   
/*    */   public EntityArrow getHandle() {
/* 50 */     return (EntityArrow)this.entity;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 55 */     return "CraftArrow";
/*    */   }
/*    */   
/*    */   public EntityType getType() {
/* 59 */     return EntityType.ARROW;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\entity\CraftArrow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */