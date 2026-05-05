/*    */ package net.minecraft.block;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.world.EnumSkyBlock;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockSnowBlock extends Block {
/*    */   protected BlockSnowBlock() {
/* 11 */     super(Material.field_151596_z);
/* 12 */     func_149675_a(true);
/* 13 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000308";
/*    */   
/*    */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 18 */     return Items.field_151126_ay;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149745_a(Random p_149745_1_) {
/* 23 */     return 4;
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/* 28 */     if (p_149674_1_.func_72972_b(EnumSkyBlock.Block, p_149674_2_, p_149674_3_, p_149674_4_) > 11) {
/* 29 */       func_149697_b(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_, p_149674_1_.func_72805_g(p_149674_2_, p_149674_3_, p_149674_4_), 0);
/* 30 */       p_149674_1_.func_147468_f(p_149674_2_, p_149674_3_, p_149674_4_);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockSnowBlock.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */