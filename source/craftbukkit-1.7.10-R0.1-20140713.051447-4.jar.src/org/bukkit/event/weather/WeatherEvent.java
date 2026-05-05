/*    */ package org.bukkit.event.weather;
/*    */ 
/*    */ import org.bukkit.World;
/*    */ import org.bukkit.event.Event;
/*    */ 
/*    */ 
/*    */ public abstract class WeatherEvent
/*    */   extends Event
/*    */ {
/*    */   protected World world;
/*    */   
/*    */   public WeatherEvent(World where) {
/* 13 */     this.world = where;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final World getWorld() {
/* 22 */     return this.world;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\weather\WeatherEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */