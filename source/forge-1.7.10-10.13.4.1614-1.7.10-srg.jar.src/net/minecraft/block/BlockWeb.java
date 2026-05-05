/*    */ package net.minecraft.block;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockWeb extends Block {
/*    */   public BlockWeb() {
/* 13 */     super(Material.field_151569_G);
/* 14 */     func_149647_a(CreativeTabs.field_78031_c);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000333";
/*    */   
/*    */   public void func_149670_a(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
/* 19 */     p_149670_5_.func_70110_aj();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_149662_c() {
/* 24 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/* 29 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149645_b() {
/* 34 */     return 1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149686_d() {
/* 43 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 49 */     return Items.field_151007_F;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean func_149700_E() {
/* 54 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockWeb.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */