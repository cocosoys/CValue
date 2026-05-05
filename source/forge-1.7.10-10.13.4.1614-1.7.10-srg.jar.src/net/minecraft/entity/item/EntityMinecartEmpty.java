/*    */ package net.minecraft.entity.item;
/*    */ 
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class EntityMinecartEmpty extends EntityMinecart {
/*    */   private static final String __OBFID = "CL_00001677";
/*    */   
/*    */   public EntityMinecartEmpty(World p_i1722_1_) {
/* 10 */     super(p_i1722_1_);
/*    */   }
/*    */   
/*    */   public EntityMinecartEmpty(World p_i1723_1_, double p_i1723_2_, double p_i1723_4_, double p_i1723_6_) {
/* 14 */     super(p_i1723_1_, p_i1723_2_, p_i1723_4_, p_i1723_6_);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_130002_c(EntityPlayer p_130002_1_) {
/* 19 */     if (this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer && this.field_70153_n != p_130002_1_) return true; 
/* 20 */     if (this.field_70153_n != null && this.field_70153_n != p_130002_1_) return false; 
/* 21 */     if (!this.field_70170_p.field_72995_K) {
/* 22 */       p_130002_1_.func_70078_a(this);
/*    */     }
/*    */     
/* 25 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_94087_l() {
/* 30 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\item\EntityMinecartEmpty.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */