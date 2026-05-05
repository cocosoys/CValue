/*    */ package org.bukkit.craftbukkit.v1_7_R4.entity;
/*    */ import net.minecraft.server.v1_7_R4.Entity;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*    */ import org.bukkit.entity.Vehicle;
/*    */ 
/*    */ public abstract class CraftVehicle extends CraftEntity implements Vehicle {
/*    */   public CraftVehicle(CraftServer server, Entity entity) {
/*  8 */     super(server, entity);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 13 */     return "CraftVehicle{passenger=" + getPassenger() + '}';
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\entity\CraftVehicle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */