/*    */ package org.bukkit.event.world;
/*    */ 
/*    */ import org.bukkit.Chunk;
/*    */ import org.bukkit.event.Cancellable;
/*    */ import org.bukkit.event.HandlerList;
/*    */ 
/*    */ public class ChunkUnloadEvent
/*    */   extends ChunkEvent
/*    */   implements Cancellable
/*    */ {
/* 11 */   private static final HandlerList handlers = new HandlerList();
/*    */   private boolean cancel = false;
/*    */   
/*    */   public ChunkUnloadEvent(Chunk chunk) {
/* 15 */     super(chunk);
/*    */   }
/*    */   
/*    */   public boolean isCancelled() {
/* 19 */     return this.cancel;
/*    */   }
/*    */   
/*    */   public void setCancelled(boolean cancel) {
/* 23 */     this.cancel = cancel;
/*    */   }
/*    */ 
/*    */   
/*    */   public HandlerList getHandlers() {
/* 28 */     return handlers;
/*    */   }
/*    */   
/*    */   public static HandlerList getHandlerList() {
/* 32 */     return handlers;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\world\ChunkUnloadEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */