/*    */ package net.minecraft.block;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ 
/*    */ public class BlockLeavesBase extends Block {
/*    */   protected boolean field_150121_P;
/*    */   
/*    */   protected BlockLeavesBase(Material p_i45433_1_, boolean p_i45433_2_) {
/* 10 */     super(p_i45433_1_);
/* 11 */     this.field_150121_P = p_i45433_2_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000326";
/*    */   
/*    */   public boolean func_149662_c() {
/* 16 */     return false;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
/* 21 */     Block block = p_149646_1_.func_147439_a(p_149646_2_, p_149646_3_, p_149646_4_);
/* 22 */     if (!this.field_150121_P && block == this) return false; 
/* 23 */     return super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockLeavesBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */