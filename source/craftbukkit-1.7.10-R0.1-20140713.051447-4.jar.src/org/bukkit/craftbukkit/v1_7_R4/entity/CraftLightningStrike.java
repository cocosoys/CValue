/*    */ package org.bukkit.craftbukkit.v1_7_R4.entity;
/*    */ import net.minecraft.server.v1_7_R4.Entity;
/*    */ import net.minecraft.server.v1_7_R4.EntityLightning;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*    */ import org.bukkit.entity.EntityType;
/*    */ import org.bukkit.entity.LightningStrike;
/*    */ 
/*    */ public class CraftLightningStrike extends CraftEntity implements LightningStrike {
/*    */   public CraftLightningStrike(CraftServer server, EntityLightning entity) {
/* 10 */     super(server, (Entity)entity);
/*    */   }
/*    */   
/*    */   public boolean isEffect() {
/* 14 */     return ((EntityLightning)super.getHandle()).isEffect;
/*    */   }
/*    */ 
/*    */   
/*    */   public EntityLightning getHandle() {
/* 19 */     return (EntityLightning)this.entity;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 24 */     return "CraftLightningStrike";
/*    */   }
/*    */   
/*    */   public EntityType getType() {
/* 28 */     return EntityType.LIGHTNING;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\entity\CraftLightningStrike.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */