/*    */ package org.bukkit.event.player;
/*    */ 
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.HandlerList;
/*    */ import org.bukkit.inventory.Inventory;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Deprecated
/*    */ public class PlayerInventoryEvent
/*    */   extends PlayerEvent
/*    */ {
/* 19 */   private static final HandlerList handlers = new HandlerList();
/*    */   protected Inventory inventory;
/*    */   
/*    */   public PlayerInventoryEvent(Player player, Inventory inventory) {
/* 23 */     super(player);
/* 24 */     this.inventory = inventory;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Inventory getInventory() {
/* 33 */     return this.inventory;
/*    */   }
/*    */ 
/*    */   
/*    */   public HandlerList getHandlers() {
/* 38 */     return handlers;
/*    */   }
/*    */   
/*    */   public static HandlerList getHandlerList() {
/* 42 */     return handlers;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\player\PlayerInventoryEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */