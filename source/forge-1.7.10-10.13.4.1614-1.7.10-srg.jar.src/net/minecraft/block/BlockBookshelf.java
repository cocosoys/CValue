/*    */ package net.minecraft.block;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ public class BlockBookshelf extends Block {
/*    */   public BlockBookshelf() {
/* 12 */     super(Material.field_151575_d);
/* 13 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000206";
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 18 */     if (p_149691_1_ == 1 || p_149691_1_ == 0) return Blocks.field_150344_f.func_149733_h(p_149691_1_); 
/* 19 */     return super.func_149691_a(p_149691_1_, p_149691_2_);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149745_a(Random p_149745_1_) {
/* 24 */     return 3;
/*    */   }
/*    */ 
/*    */   
/*    */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 29 */     return Items.field_151122_aG;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockBookshelf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */