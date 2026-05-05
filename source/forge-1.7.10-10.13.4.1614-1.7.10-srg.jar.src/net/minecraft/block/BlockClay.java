/*    */ package net.minecraft.block;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ public class BlockClay extends Block {
/*    */   public BlockClay() {
/* 10 */     super(Material.field_151571_B);
/* 11 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000215";
/*    */   
/*    */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 16 */     return Items.field_151119_aD;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149745_a(Random p_149745_1_) {
/* 21 */     return 4;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockClay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */