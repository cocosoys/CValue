/*    */ package org.bukkit.event.player;
/*    */ 
/*    */ import org.apache.commons.lang.Validate;
/*    */ import org.bukkit.Location;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.HandlerList;
/*    */ 
/*    */ 
/*    */ public class PlayerRespawnEvent
/*    */   extends PlayerEvent
/*    */ {
/* 12 */   private static final HandlerList handlers = new HandlerList();
/*    */   private Location respawnLocation;
/*    */   private final boolean isBedSpawn;
/*    */   
/*    */   public PlayerRespawnEvent(Player respawnPlayer, Location respawnLocation, boolean isBedSpawn) {
/* 17 */     super(respawnPlayer);
/* 18 */     this.respawnLocation = respawnLocation;
/* 19 */     this.isBedSpawn = isBedSpawn;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Location getRespawnLocation() {
/* 28 */     return this.respawnLocation;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void setRespawnLocation(Location respawnLocation) {
/* 37 */     Validate.notNull(respawnLocation, "Respawn location can not be null");
/* 38 */     Validate.notNull(respawnLocation.getWorld(), "Respawn world can not be null");
/*    */     
/* 40 */     this.respawnLocation = respawnLocation;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isBedSpawn() {
/* 49 */     return this.isBedSpawn;
/*    */   }
/*    */ 
/*    */   
/*    */   public HandlerList getHandlers() {
/* 54 */     return handlers;
/*    */   }
/*    */   
/*    */   public static HandlerList getHandlerList() {
/* 58 */     return handlers;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\player\PlayerRespawnEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */