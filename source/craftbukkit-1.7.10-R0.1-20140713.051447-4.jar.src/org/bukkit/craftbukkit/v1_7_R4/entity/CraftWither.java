/*    */ package org.bukkit.craftbukkit.v1_7_R4.entity;
/*    */ import net.minecraft.server.v1_7_R4.EntityCreature;
/*    */ import net.minecraft.server.v1_7_R4.EntityLiving;
/*    */ import net.minecraft.server.v1_7_R4.EntityMonster;
/*    */ import net.minecraft.server.v1_7_R4.EntityWither;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*    */ 
/*    */ public class CraftWither extends CraftMonster implements Wither {
/*    */   public CraftWither(CraftServer server, EntityWither entity) {
/* 10 */     super(server, (EntityMonster)entity);
/*    */   }
/*    */ 
/*    */   
/*    */   public EntityWither getHandle() {
/* 15 */     return (EntityWither)this.entity;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 20 */     return "CraftWither";
/*    */   }
/*    */   
/*    */   public EntityType getType() {
/* 24 */     return EntityType.WITHER;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\entity\CraftWither.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */