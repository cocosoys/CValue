/*    */ package org.bukkit.event.block;
/*    */ 
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.event.Cancellable;
/*    */ import org.bukkit.event.HandlerList;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LeavesDecayEvent
/*    */   extends BlockEvent
/*    */   implements Cancellable
/*    */ {
/* 13 */   private static final HandlerList handlers = new HandlerList();
/*    */   private boolean cancel = false;
/*    */   
/*    */   public LeavesDecayEvent(Block block) {
/* 17 */     super(block);
/*    */   }
/*    */   
/*    */   public boolean isCancelled() {
/* 21 */     return this.cancel;
/*    */   }
/*    */   
/*    */   public void setCancelled(boolean cancel) {
/* 25 */     this.cancel = cancel;
/*    */   }
/*    */ 
/*    */   
/*    */   public HandlerList getHandlers() {
/* 30 */     return handlers;
/*    */   }
/*    */   
/*    */   public static HandlerList getHandlerList() {
/* 34 */     return handlers;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\block\LeavesDecayEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */