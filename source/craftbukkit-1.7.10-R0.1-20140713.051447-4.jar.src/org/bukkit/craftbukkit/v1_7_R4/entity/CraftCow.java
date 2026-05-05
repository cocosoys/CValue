/*    */ package org.bukkit.craftbukkit.v1_7_R4.entity;
/*    */ import net.minecraft.server.v1_7_R4.EntityAgeable;
/*    */ import net.minecraft.server.v1_7_R4.EntityAnimal;
/*    */ import net.minecraft.server.v1_7_R4.EntityCow;
/*    */ import net.minecraft.server.v1_7_R4.EntityCreature;
/*    */ import net.minecraft.server.v1_7_R4.EntityLiving;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*    */ import org.bukkit.entity.EntityType;
/*    */ 
/*    */ public class CraftCow extends CraftAnimals implements Cow {
/*    */   public CraftCow(CraftServer server, EntityCow entity) {
/* 12 */     super(server, (EntityAnimal)entity);
/*    */   }
/*    */ 
/*    */   
/*    */   public EntityCow getHandle() {
/* 17 */     return (EntityCow)this.entity;
/*    */   }
/*    */ 
/*    */   
/*    */   public String toString() {
/* 22 */     return "CraftCow";
/*    */   }
/*    */   
/*    */   public EntityType getType() {
/* 26 */     return EntityType.COW;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\entity\CraftCow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */