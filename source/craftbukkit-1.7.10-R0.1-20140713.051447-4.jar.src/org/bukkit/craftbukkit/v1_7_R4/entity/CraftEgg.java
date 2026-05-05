/*    */ package org.bukkit.craftbukkit.v1_7_R4.entity;
/*    */ import net.minecraft.server.v1_7_R4.Entity;
/*    */ import net.minecraft.server.v1_7_R4.EntityEgg;
/*    */ import net.minecraft.server.v1_7_R4.EntityProjectile;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*    */ import org.bukkit.entity.EntityType;
/*    */ 
/*    */ public class CraftEgg extends CraftProjectile implements Egg {
/*    */   public CraftEgg(CraftServer server, EntityEgg entity) {
/* 10 */     super(server, (Entity)entity);
/*    */   }
/*    */ 
/*    */   
/*    */   public EntityEgg getHandle() {
/* 15 */     return (EntityEgg)this.entity;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 20 */     return "CraftEgg";
/*    */   }
/*    */   
/*    */   public EntityType getType() {
/* 24 */     return EntityType.EGG;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\entity\CraftEgg.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */