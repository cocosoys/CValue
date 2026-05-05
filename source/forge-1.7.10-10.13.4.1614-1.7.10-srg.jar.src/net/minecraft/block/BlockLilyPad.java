/*    */ package net.minecraft.block;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockLilyPad extends BlockBush {
/*    */   protected BlockLilyPad() {
/* 16 */     float f1 = 0.5F;
/* 17 */     float f2 = 0.015625F;
/* 18 */     func_149676_a(0.5F - f1, 0.0F, 0.5F - f1, 0.5F + f1, f2, 0.5F + f1);
/* 19 */     func_149647_a(CreativeTabs.field_78031_c);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149645_b() {
/* 24 */     return 23;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000332";
/*    */   
/*    */   public void func_149743_a(World p_149743_1_, int p_149743_2_, int p_149743_3_, int p_149743_4_, AxisAlignedBB p_149743_5_, List p_149743_6_, Entity p_149743_7_) {
/* 29 */     if (p_149743_7_ == null || !(p_149743_7_ instanceof net.minecraft.entity.item.EntityBoat)) {
/* 30 */       super.func_149743_a(p_149743_1_, p_149743_2_, p_149743_3_, p_149743_4_, p_149743_5_, p_149743_6_, p_149743_7_);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/* 36 */     return AxisAlignedBB.func_72330_a(p_149668_2_ + this.field_149759_B, p_149668_3_ + this.field_149760_C, p_149668_4_ + this.field_149754_D, p_149668_2_ + this.field_149755_E, p_149668_3_ + this.field_149756_F, p_149668_4_ + this.field_149757_G);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149635_D() {
/* 41 */     return 2129968;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149741_i(int p_149741_1_) {
/* 46 */     return 2129968;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149720_d(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
/* 51 */     return 2129968;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean func_149854_a(Block p_149854_1_) {
/* 56 */     return (p_149854_1_ == Blocks.field_150355_j);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
/* 61 */     if (p_149718_3_ < 0 || p_149718_3_ >= 256) return false; 
/* 62 */     return (p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_ - 1, p_149718_4_).func_149688_o() == Material.field_151586_h && p_149718_1_.func_72805_g(p_149718_2_, p_149718_3_ - 1, p_149718_4_) == 0);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockLilyPad.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */