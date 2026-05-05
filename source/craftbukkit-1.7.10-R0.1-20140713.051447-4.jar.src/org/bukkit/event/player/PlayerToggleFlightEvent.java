/*    */ package org.bukkit.event.player;
/*    */ 
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Cancellable;
/*    */ import org.bukkit.event.HandlerList;
/*    */ 
/*    */ public class PlayerToggleFlightEvent
/*    */   extends PlayerEvent
/*    */   implements Cancellable
/*    */ {
/* 11 */   private static final HandlerList handlers = new HandlerList();
/*    */   private final boolean isFlying;
/*    */   private boolean cancel = false;
/*    */   
/*    */   public PlayerToggleFlightEvent(Player player, boolean isFlying) {
/* 16 */     super(player);
/* 17 */     this.isFlying = isFlying;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isFlying() {
/* 26 */     return this.isFlying;
/*    */   }
/*    */   
/*    */   public boolean isCancelled() {
/* 30 */     return this.cancel;
/*    */   }
/*    */   
/*    */   public void setCancelled(boolean cancel) {
/* 34 */     this.cancel = cancel;
/*    */   }
/*    */ 
/*    */   
/*    */   public HandlerList getHandlers() {
/* 39 */     return handlers;
/*    */   }
/*    */   
/*    */   public static HandlerList getHandlerList() {
/* 43 */     return handlers;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\player\PlayerToggleFlightEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */