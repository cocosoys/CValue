/*    */ package org.bukkit.craftbukkit.v1_7_R4.entity;
/*    */ import net.minecraft.server.v1_7_R4.EntityCreature;
/*    */ import net.minecraft.server.v1_7_R4.EntityLiving;
/*    */ import net.minecraft.server.v1_7_R4.EntityTameableAnimal;
/*    */ import net.minecraft.server.v1_7_R4.EntityWolf;
/*    */ import org.bukkit.DyeColor;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*    */ 
/*    */ public class CraftWolf extends CraftTameableAnimal implements Wolf {
/*    */   public CraftWolf(CraftServer server, EntityWolf wolf) {
/* 11 */     super(server, (EntityTameableAnimal)wolf);
/*    */   }
/*    */   
/*    */   public boolean isAngry() {
/* 15 */     return getHandle().isAngry();
/*    */   }
/*    */   
/*    */   public void setAngry(boolean angry) {
/* 19 */     getHandle().setAngry(angry);
/*    */   }
/*    */ 
/*    */   
/*    */   public EntityWolf getHandle() {
/* 24 */     return (EntityWolf)this.entity;
/*    */   }
/*    */ 
/*    */   
/*    */   public EntityType getType() {
/* 29 */     return EntityType.WOLF;
/*    */   }
/*    */   
/*    */   public DyeColor getCollarColor() {
/* 33 */     return DyeColor.getByWoolData((byte)getHandle().getCollarColor());
/*    */   }
/*    */   
/*    */   public void setCollarColor(DyeColor color) {
/* 37 */     getHandle().setCollarColor(color.getWoolData());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\entity\CraftWolf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */