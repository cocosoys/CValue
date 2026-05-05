/*    */ package org.bukkit.event.entity;
/*    */ 
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.LivingEntity;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityTargetLivingEntityEvent
/*    */   extends EntityTargetEvent
/*    */ {
/*    */   public EntityTargetLivingEntityEvent(Entity entity, LivingEntity target, EntityTargetEvent.TargetReason reason) {
/* 12 */     super(entity, (Entity)target, reason);
/*    */   }
/*    */   
/*    */   public LivingEntity getTarget() {
/* 16 */     return (LivingEntity)super.getTarget();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setTarget(Entity target) {
/* 30 */     if (target == null || target instanceof LivingEntity)
/* 31 */       super.setTarget(target); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\entity\EntityTargetLivingEntityEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */