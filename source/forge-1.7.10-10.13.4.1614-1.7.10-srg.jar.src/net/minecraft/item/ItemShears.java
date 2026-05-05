/*    */ package net.minecraft.item;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class ItemShears extends Item {
/*    */   public ItemShears() {
/* 12 */     func_77625_d(1);
/* 13 */     func_77656_e(238);
/* 14 */     func_77637_a(CreativeTabs.field_78040_i);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_150894_a(ItemStack p_150894_1_, World p_150894_2_, Block p_150894_3_, int p_150894_4_, int p_150894_5_, int p_150894_6_, EntityLivingBase p_150894_7_) {
/* 19 */     if (p_150894_3_.func_149688_o() == Material.field_151584_j || p_150894_3_ == Blocks.field_150321_G || p_150894_3_ == Blocks.field_150329_H || p_150894_3_ == Blocks.field_150395_bd || p_150894_3_ == Blocks.field_150473_bD) {
/* 20 */       p_150894_1_.func_77972_a(1, p_150894_7_);
/* 21 */       return true;
/*    */     } 
/* 23 */     return super.func_150894_a(p_150894_1_, p_150894_2_, p_150894_3_, p_150894_4_, p_150894_5_, p_150894_6_, p_150894_7_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000062";
/*    */   
/*    */   public boolean func_150897_b(Block p_150897_1_) {
/* 28 */     return (p_150897_1_ == Blocks.field_150321_G || p_150897_1_ == Blocks.field_150488_af || p_150897_1_ == Blocks.field_150473_bD);
/*    */   }
/*    */ 
/*    */   
/*    */   public float func_150893_a(ItemStack p_150893_1_, Block p_150893_2_) {
/* 33 */     if (p_150893_2_ == Blocks.field_150321_G || p_150893_2_.func_149688_o() == Material.field_151584_j) {
/* 34 */       return 15.0F;
/*    */     }
/* 36 */     if (p_150893_2_ == Blocks.field_150325_L) {
/* 37 */       return 5.0F;
/*    */     }
/* 39 */     return super.func_150893_a(p_150893_1_, p_150893_2_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\ItemShears.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */