/*    */ package net.minecraft.block;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.MapColor;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ public class BlockGlowstone extends Block {
/*    */   public BlockGlowstone(Material p_i45409_1_) {
/* 12 */     super(p_i45409_1_);
/* 13 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000250";
/*    */   
/*    */   public int func_149679_a(int p_149679_1_, Random p_149679_2_) {
/* 18 */     return MathHelper.func_76125_a(func_149745_a(p_149679_2_) + p_149679_2_.nextInt(p_149679_1_ + 1), 1, 4);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149745_a(Random p_149745_1_) {
/* 23 */     return 2 + p_149745_1_.nextInt(3);
/*    */   }
/*    */ 
/*    */   
/*    */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 28 */     return Items.field_151114_aO;
/*    */   }
/*    */ 
/*    */   
/*    */   public MapColor func_149728_f(int p_149728_1_) {
/* 33 */     return MapColor.field_151658_d;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockGlowstone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */