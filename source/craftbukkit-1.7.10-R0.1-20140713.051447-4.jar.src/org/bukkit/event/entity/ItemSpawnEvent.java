/*    */ package org.bukkit.event.entity;
/*    */ 
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.entity.Entity;
/*    */ import org.bukkit.entity.Item;
/*    */ import org.bukkit.event.Cancellable;
/*    */ import org.bukkit.event.HandlerList;
/*    */ 
/*    */ public class ItemSpawnEvent
/*    */   extends EntityEvent
/*    */   implements Cancellable {
/* 12 */   private static final HandlerList handlers = new HandlerList();
/*    */   private final Location location;
/*    */   private boolean canceled;
/*    */   
/*    */   public ItemSpawnEvent(Item spawnee, Location loc) {
/* 17 */     super((Entity)spawnee);
/* 18 */     this.location = loc;
/*    */   }
/*    */   
/*    */   public boolean isCancelled() {
/* 22 */     return this.canceled;
/*    */   }
/*    */   
/*    */   public void setCancelled(boolean cancel) {
/* 26 */     this.canceled = cancel;
/*    */   }
/*    */ 
/*    */   
/*    */   public Item getEntity() {
/* 31 */     return (Item)this.entity;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Location getLocation() {
/* 40 */     return this.location;
/*    */   }
/*    */ 
/*    */   
/*    */   public HandlerList getHandlers() {
/* 45 */     return handlers;
/*    */   }
/*    */   
/*    */   public static HandlerList getHandlerList() {
/* 49 */     return handlers;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\entity\ItemSpawnEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */