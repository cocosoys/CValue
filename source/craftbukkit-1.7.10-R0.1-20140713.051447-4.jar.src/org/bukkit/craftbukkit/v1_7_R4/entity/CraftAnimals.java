/*    */ package org.bukkit.craftbukkit.v1_7_R4.entity;
/*    */ import net.minecraft.server.v1_7_R4.EntityAgeable;
/*    */ import net.minecraft.server.v1_7_R4.EntityAnimal;
/*    */ import net.minecraft.server.v1_7_R4.EntityCreature;
/*    */ import net.minecraft.server.v1_7_R4.EntityLiving;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*    */ 
/*    */ public class CraftAnimals extends CraftAgeable implements Animals {
/*    */   public CraftAnimals(CraftServer server, EntityAnimal entity) {
/* 10 */     super(server, (EntityAgeable)entity);
/*    */   }
/*    */ 
/*    */   
/*    */   public EntityAnimal getHandle() {
/* 15 */     return (EntityAnimal)this.entity;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 20 */     return "CraftAnimals";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\entity\CraftAnimals.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */