/*    */ package org.bukkit.event.block;
/*    */ 
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.event.Cancellable;
/*    */ import org.bukkit.event.HandlerList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockBurnEvent
/*    */   extends BlockEvent
/*    */   implements Cancellable
/*    */ {
/* 14 */   private static final HandlerList handlers = new HandlerList();
/*    */   private boolean cancelled;
/*    */   
/*    */   public BlockBurnEvent(Block block) {
/* 18 */     super(block);
/* 19 */     this.cancelled = false;
/*    */   }
/*    */   
/*    */   public boolean isCancelled() {
/* 23 */     return this.cancelled;
/*    */   }
/*    */   
/*    */   public void setCancelled(boolean cancel) {
/* 27 */     this.cancelled = cancel;
/*    */   }
/*    */ 
/*    */   
/*    */   public HandlerList getHandlers() {
/* 32 */     return handlers;
/*    */   }
/*    */   
/*    */   public static HandlerList getHandlerList() {
/* 36 */     return handlers;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\block\BlockBurnEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */