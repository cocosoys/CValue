/*    */ package org.bukkit.craftbukkit.v1_7_R4.entity;
/*    */ 
/*    */ import net.minecraft.server.v1_7_R4.EntityMinecartAbstract;
/*    */ import net.minecraft.server.v1_7_R4.EntityMinecartMobSpawner;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*    */ import org.bukkit.entity.EntityType;
/*    */ import org.bukkit.entity.minecart.SpawnerMinecart;
/*    */ 
/*    */ final class CraftMinecartMobSpawner extends CraftMinecart implements SpawnerMinecart {
/*    */   CraftMinecartMobSpawner(CraftServer server, EntityMinecartMobSpawner entity) {
/* 11 */     super(server, (EntityMinecartAbstract)entity);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 16 */     return "CraftMinecartMobSpawner";
/*    */   }
/*    */   
/*    */   public EntityType getType() {
/* 20 */     return EntityType.MINECART_MOB_SPAWNER;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\entity\CraftMinecartMobSpawner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */