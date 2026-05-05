/*    */ package org.bukkit.craftbukkit.v1_7_R4.entity;
/*    */ import net.minecraft.server.v1_7_R4.Entity;
/*    */ import net.minecraft.server.v1_7_R4.EntityCreature;
/*    */ import net.minecraft.server.v1_7_R4.EntityLiving;
/*    */ import net.minecraft.server.v1_7_R4.EntityMonster;
/*    */ import net.minecraft.server.v1_7_R4.EntitySpider;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*    */ import org.bukkit.entity.EntityType;
/*    */ 
/*    */ public class CraftSpider extends CraftMonster implements Spider {
/*    */   public CraftSpider(CraftServer server, EntitySpider entity) {
/* 12 */     super(server, (EntityMonster)entity);
/*    */   }
/*    */ 
/*    */   
/*    */   public EntitySpider getHandle() {
/* 17 */     return (EntitySpider)this.entity;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 22 */     return "CraftSpider";
/*    */   }
/*    */   
/*    */   public EntityType getType() {
/* 26 */     return EntityType.SPIDER;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\entity\CraftSpider.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */