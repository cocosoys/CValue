/*    */ package org.bukkit.event.inventory;
/*    */ 
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.event.Cancellable;
/*    */ import org.bukkit.event.HandlerList;
/*    */ import org.bukkit.event.block.BlockEvent;
/*    */ import org.bukkit.inventory.BrewerInventory;
/*    */ 
/*    */ 
/*    */ public class BrewEvent
/*    */   extends BlockEvent
/*    */   implements Cancellable
/*    */ {
/* 14 */   private static final HandlerList handlers = new HandlerList();
/*    */   private BrewerInventory contents;
/*    */   private boolean cancelled;
/*    */   
/*    */   public BrewEvent(Block brewer, BrewerInventory contents) {
/* 19 */     super(brewer);
/* 20 */     this.contents = contents;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public BrewerInventory getContents() {
/* 29 */     return this.contents;
/*    */   }
/*    */   
/*    */   public boolean isCancelled() {
/* 33 */     return this.cancelled;
/*    */   }
/*    */   
/*    */   public void setCancelled(boolean cancel) {
/* 37 */     this.cancelled = cancel;
/*    */   }
/*    */ 
/*    */   
/*    */   public HandlerList getHandlers() {
/* 42 */     return handlers;
/*    */   }
/*    */   
/*    */   public static HandlerList getHandlerList() {
/* 46 */     return handlers;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\inventory\BrewEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */