/*    */ package org.bukkit.event.vehicle;
/*    */ 
/*    */ import org.bukkit.entity.Vehicle;
/*    */ import org.bukkit.event.Event;
/*    */ 
/*    */ 
/*    */ public abstract class VehicleEvent
/*    */   extends Event
/*    */ {
/*    */   protected Vehicle vehicle;
/*    */   
/*    */   public VehicleEvent(Vehicle vehicle) {
/* 13 */     this.vehicle = vehicle;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public final Vehicle getVehicle() {
/* 22 */     return this.vehicle;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\event\vehicle\VehicleEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */