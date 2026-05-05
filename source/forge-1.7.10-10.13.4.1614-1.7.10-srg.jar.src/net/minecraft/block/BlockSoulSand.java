/*    */ package net.minecraft.block;
/*    */ 
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.AxisAlignedBB;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockSoulSand extends Block {
/*    */   public BlockSoulSand() {
/* 11 */     super(Material.field_151595_p);
/* 12 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   }
/*    */ 
/*    */   
/*    */   public AxisAlignedBB func_149668_a(World p_149668_1_, int p_149668_2_, int p_149668_3_, int p_149668_4_) {
/* 17 */     float f = 0.125F;
/* 18 */     return AxisAlignedBB.func_72330_a(p_149668_2_, p_149668_3_, p_149668_4_, (p_149668_2_ + 1), ((p_149668_3_ + 1) - f), (p_149668_4_ + 1));
/*    */   }
/*    */   private static final String __OBFID = "CL_00000310";
/*    */   
/*    */   public void func_149670_a(World p_149670_1_, int p_149670_2_, int p_149670_3_, int p_149670_4_, Entity p_149670_5_) {
/* 23 */     p_149670_5_.field_70159_w *= 0.4D;
/* 24 */     p_149670_5_.field_70179_y *= 0.4D;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockSoulSand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */