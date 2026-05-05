/*    */ package org.bukkit.craftbukkit.v1_7_R4.entity;
/*    */ 
/*    */ import net.minecraft.server.v1_7_R4.EntityMinecartAbstract;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*    */ import org.bukkit.entity.EntityType;
/*    */ import org.bukkit.entity.minecart.RideableMinecart;
/*    */ 
/*    */ public class CraftMinecartRideable
/*    */   extends CraftMinecart implements RideableMinecart {
/*    */   public CraftMinecartRideable(CraftServer server, EntityMinecartAbstract entity) {
/* 11 */     super(server, entity);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 16 */     return "CraftMinecartRideable";
/*    */   }
/*    */   
/*    */   public EntityType getType() {
/* 20 */     return EntityType.MINECART;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\entity\CraftMinecartRideable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */