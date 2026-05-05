/*    */ package org.bukkit.craftbukkit.v1_7_R4.entity;
/*    */ 
/*    */ import net.minecraft.server.v1_7_R4.EntityMinecartAbstract;
/*    */ import net.minecraft.server.v1_7_R4.EntityMinecartFurnace;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*    */ import org.bukkit.entity.EntityType;
/*    */ import org.bukkit.entity.PoweredMinecart;
/*    */ 
/*    */ public class CraftMinecartFurnace
/*    */   extends CraftMinecart implements PoweredMinecart {
/*    */   public CraftMinecartFurnace(CraftServer server, EntityMinecartFurnace entity) {
/* 12 */     super(server, (EntityMinecartAbstract)entity);
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 17 */     return "CraftMinecartFurnace";
/*    */   }
/*    */   
/*    */   public EntityType getType() {
/* 21 */     return EntityType.MINECART_FURNACE;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\entity\CraftMinecartFurnace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */