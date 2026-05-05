/*    */ package org.bukkit.craftbukkit.v1_7_R4.entity;
/*    */ import net.minecraft.server.v1_7_R4.EntityCreature;
/*    */ import net.minecraft.server.v1_7_R4.EntityGolem;
/*    */ import net.minecraft.server.v1_7_R4.EntityLiving;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*    */ 
/*    */ public class CraftGolem extends CraftCreature implements Golem {
/*    */   public CraftGolem(CraftServer server, EntityGolem entity) {
/*  9 */     super(server, (EntityCreature)entity);
/*    */   }
/*    */ 
/*    */   
/*    */   public EntityGolem getHandle() {
/* 14 */     return (EntityGolem)this.entity;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 19 */     return "CraftGolem";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\entity\CraftGolem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */