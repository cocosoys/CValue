/*    */ package org.bukkit.event.entity;
/*    */ 
/*    */ import org.bukkit.Material;
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.LivingEntity;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class EntityBreakDoorEvent
/*    */   extends EntityChangeBlockEvent
/*    */ {
/*    */   public EntityBreakDoorEvent(LivingEntity entity, Block targetBlock) {
/* 15 */     super((Entity)entity, targetBlock, Material.AIR, (byte)0);
/*    */   }
/*    */ 
/*    */   
/*    */   public LivingEntity getEntity() {
/* 20 */     return (LivingEntity)this.entity;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\entity\EntityBreakDoorEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */