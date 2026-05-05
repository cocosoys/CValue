/*    */ package org.bukkit.event.player;
/*    */ 
/*    */ import org.bukkit.block.Block;
/*    */ import org.bukkit.entity.Player;
/*    */ import org.bukkit.event.HandlerList;
/*    */ 
/*    */ 
/*    */ public class PlayerBedLeaveEvent
/*    */   extends PlayerEvent
/*    */ {
/* 11 */   private static final HandlerList handlers = new HandlerList();
/*    */   private final Block bed;
/*    */   
/*    */   public PlayerBedLeaveEvent(Player who, Block bed) {
/* 15 */     super(who);
/* 16 */     this.bed = bed;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Block getBed() {
/* 25 */     return this.bed;
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


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\player\PlayerBedLeaveEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */