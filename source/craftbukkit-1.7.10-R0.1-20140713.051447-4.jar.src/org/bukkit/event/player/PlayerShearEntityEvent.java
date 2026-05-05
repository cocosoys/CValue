/*    */ package org.bukkit.event.player;
/*    */ 
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.Cancellable;
/*    */ import org.bukkit.event.HandlerList;
/*    */ 
/*    */ public class PlayerShearEntityEvent
/*    */   extends PlayerEvent
/*    */   implements Cancellable
/*    */ {
/* 12 */   private static final HandlerList handlers = new HandlerList();
/*    */   private boolean cancel;
/*    */   private final Entity what;
/*    */   
/*    */   public PlayerShearEntityEvent(Player who, Entity what) {
/* 17 */     super(who);
/* 18 */     this.cancel = false;
/* 19 */     this.what = what;
/*    */   }
/*    */   
/*    */   public boolean isCancelled() {
/* 23 */     return this.cancel;
/*    */   }
/*    */   
/*    */   public void setCancelled(boolean cancel) {
/* 27 */     this.cancel = cancel;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Entity getEntity() {
/* 36 */     return this.what;
/*    */   }
/*    */ 
/*    */   
/*    */   public HandlerList getHandlers() {
/* 41 */     return handlers;
/*    */   }
/*    */   
/*    */   public static HandlerList getHandlerList() {
/* 45 */     return handlers;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\player\PlayerShearEntityEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */