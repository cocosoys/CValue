/*    */ package org.bukkit.event.world;
/*    */ 
/*    */ import org.bukkit.Chunk;
/*    */ import org.bukkit.event.HandlerList;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChunkPopulateEvent
/*    */   extends ChunkEvent
/*    */ {
/* 14 */   private static final HandlerList handlers = new HandlerList();
/*    */   
/*    */   public ChunkPopulateEvent(Chunk chunk) {
/* 17 */     super(chunk);
/*    */   }
/*    */ 
/*    */   
/*    */   public HandlerList getHandlers() {
/* 22 */     return handlers;
/*    */   }
/*    */   
/*    */   public static HandlerList getHandlerList() {
/* 26 */     return handlers;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\world\ChunkPopulateEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */