/*    */ package org.bukkit.event.vehicle;
/*    */ 
/*    */ import org.bukkit.entity.Vehicle;
/*    */ import org.bukkit.event.HandlerList;
/*    */ 
/*    */ 
/*    */ public class VehicleUpdateEvent
/*    */   extends VehicleEvent
/*    */ {
/* 10 */   private static final HandlerList handlers = new HandlerList();
/*    */   
/*    */   public VehicleUpdateEvent(Vehicle vehicle) {
/* 13 */     super(vehicle);
/*    */   }
/*    */ 
/*    */   
/*    */   public HandlerList getHandlers() {
/* 18 */     return handlers;
/*    */   }
/*    */   
/*    */   public static HandlerList getHandlerList() {
/* 22 */     return handlers;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\vehicle\VehicleUpdateEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */