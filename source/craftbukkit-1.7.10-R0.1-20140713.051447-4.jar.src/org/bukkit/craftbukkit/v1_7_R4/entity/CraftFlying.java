/*    */ package org.bukkit.craftbukkit.v1_7_R4.entity;
/*    */ import net.minecraft.server.v1_7_R4.Entity;
/*    */ import net.minecraft.server.v1_7_R4.EntityFlying;
/*    */ import net.minecraft.server.v1_7_R4.EntityLiving;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*    */ import org.bukkit.entity.Flying;
/*    */ 
/*    */ public class CraftFlying extends CraftLivingEntity implements Flying {
/*    */   public CraftFlying(CraftServer server, EntityFlying entity) {
/* 10 */     super(server, (EntityLiving)entity);
/*    */   }
/*    */ 
/*    */   
/*    */   public EntityFlying getHandle() {
/* 15 */     return (EntityFlying)this.entity;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 20 */     return "CraftFlying";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\entity\CraftFlying.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */