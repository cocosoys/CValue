/*    */ package org.bukkit.craftbukkit.v1_7_R4.entity;
/*    */ 
/*    */ import net.minecraft.server.v1_7_R4.EntityMinecartAbstract;
/*    */ import net.minecraft.server.v1_7_R4.EntityMinecartTNT;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*    */ import org.bukkit.entity.EntityType;
/*    */ import org.bukkit.entity.minecart.ExplosiveMinecart;
/*    */ 
/*    */ final class CraftMinecartTNT extends CraftMinecart implements ExplosiveMinecart {
/*    */   CraftMinecartTNT(CraftServer server, EntityMinecartTNT entity) {
/* 11 */     super(server, (EntityMinecartAbstract)entity);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 16 */     return "CraftMinecartTNT";
/*    */   }
/*    */   
/*    */   public EntityType getType() {
/* 20 */     return EntityType.MINECART_TNT;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\entity\CraftMinecartTNT.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */