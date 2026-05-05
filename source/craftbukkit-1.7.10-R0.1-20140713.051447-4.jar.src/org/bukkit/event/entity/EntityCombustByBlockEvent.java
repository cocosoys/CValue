/*    */ package org.bukkit.event.entity;
/*    */ 
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.entity.Entity;
/*    */ 
/*    */ 
/*    */ public class EntityCombustByBlockEvent
/*    */   extends EntityCombustEvent
/*    */ {
/*    */   private final Block combuster;
/*    */   
/*    */   public EntityCombustByBlockEvent(Block combuster, Entity combustee, int duration) {
/* 13 */     super(combustee, duration);
/* 14 */     this.combuster = combuster;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Block getCombuster() {
/* 25 */     return this.combuster;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\entity\EntityCombustByBlockEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */