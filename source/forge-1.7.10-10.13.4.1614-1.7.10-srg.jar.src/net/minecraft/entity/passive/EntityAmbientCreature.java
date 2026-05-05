/*    */ package net.minecraft.entity.passive;
/*    */ 
/*    */ import net.minecraft.entity.EntityLiving;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public abstract class EntityAmbientCreature
/*    */   extends EntityLiving implements IAnimals {
/*    */   public EntityAmbientCreature(World p_i1679_1_) {
/* 10 */     super(p_i1679_1_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001636";
/*    */   
/*    */   public boolean func_110164_bC() {
/* 15 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean func_70085_c(EntityPlayer p_70085_1_) {
/* 20 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\passive\EntityAmbientCreature.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */