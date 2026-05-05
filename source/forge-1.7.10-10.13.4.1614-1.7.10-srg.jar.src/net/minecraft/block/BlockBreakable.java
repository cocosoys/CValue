/*    */ package net.minecraft.block;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.util.Facing;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ 
/*    */ public class BlockBreakable extends Block {
/*    */   private boolean field_149996_a;
/*    */   
/*    */   protected BlockBreakable(String p_i45411_1_, Material p_i45411_2_, boolean p_i45411_3_) {
/* 13 */     super(p_i45411_2_);
/* 14 */     this.field_149996_a = p_i45411_3_;
/* 15 */     this.field_149995_b = p_i45411_1_;
/*    */   }
/*    */   private String field_149995_b; private static final String __OBFID = "CL_00000254";
/*    */   
/*    */   public boolean func_149662_c() {
/* 20 */     return false;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public boolean func_149646_a(IBlockAccess p_149646_1_, int p_149646_2_, int p_149646_3_, int p_149646_4_, int p_149646_5_) {
/* 25 */     Block block = p_149646_1_.func_147439_a(p_149646_2_, p_149646_3_, p_149646_4_);
/* 26 */     if (this == Blocks.field_150359_w || this == Blocks.field_150399_cn) {
/* 27 */       if (p_149646_1_.func_72805_g(p_149646_2_, p_149646_3_, p_149646_4_) != p_149646_1_.func_72805_g(p_149646_2_ - Facing.field_71586_b[p_149646_5_], p_149646_3_ - Facing.field_71587_c[p_149646_5_], p_149646_4_ - Facing.field_71585_d[p_149646_5_])) {
/* 28 */         return true;
/*    */       }
/* 30 */       if (block == this) {
/* 31 */         return false;
/*    */       }
/*    */     } 
/* 34 */     if (!this.field_149996_a && block == this) return false; 
/* 35 */     return super.func_149646_a(p_149646_1_, p_149646_2_, p_149646_3_, p_149646_4_, p_149646_5_);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 44 */     this.field_149761_L = p_149651_1_.func_94245_a(this.field_149995_b);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockBreakable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */