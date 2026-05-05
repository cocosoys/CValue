/*    */ package org.bukkit.event.world;
/*    */ 
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.event.Event;
/*    */ 
/*    */ 
/*    */ public abstract class WorldEvent
/*    */   extends Event
/*    */ {
/*    */   private final World world;
/*    */   
/*    */   public WorldEvent(World world) {
/* 13 */     this.world = world;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public World getWorld() {
/* 22 */     return this.world;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\world\WorldEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */