/*    */ package org.bukkit.event.entity;
/*    */ 
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.EntityType;
/*    */ import org.bukkit.event.Event;
/*    */ 
/*    */ 
/*    */ public abstract class EntityEvent
/*    */   extends Event
/*    */ {
/*    */   protected Entity entity;
/*    */   
/*    */   public EntityEvent(Entity what) {
/* 14 */     this.entity = what;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Entity getEntity() {
/* 23 */     return this.entity;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public EntityType getEntityType() {
/* 32 */     return this.entity.getType();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\entity\EntityEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */