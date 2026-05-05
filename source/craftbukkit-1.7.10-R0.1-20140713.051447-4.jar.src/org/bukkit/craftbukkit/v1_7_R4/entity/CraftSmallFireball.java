/*    */ package org.bukkit.craftbukkit.v1_7_R4.entity;
/*    */ import net.minecraft.server.v1_7_R4.Entity;
/*    */ import net.minecraft.server.v1_7_R4.EntityFireball;
/*    */ import net.minecraft.server.v1_7_R4.EntitySmallFireball;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*    */ import org.bukkit.entity.EntityType;
/*    */ 
/*    */ public class CraftSmallFireball extends CraftFireball implements SmallFireball {
/*    */   public CraftSmallFireball(CraftServer server, EntitySmallFireball entity) {
/* 10 */     super(server, (EntityFireball)entity);
/*    */   }
/*    */ 
/*    */   
/*    */   public EntitySmallFireball getHandle() {
/* 15 */     return (EntitySmallFireball)this.entity;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 20 */     return "CraftSmallFireball";
/*    */   }
/*    */   
/*    */   public EntityType getType() {
/* 24 */     return EntityType.SMALL_FIREBALL;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\entity\CraftSmallFireball.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */