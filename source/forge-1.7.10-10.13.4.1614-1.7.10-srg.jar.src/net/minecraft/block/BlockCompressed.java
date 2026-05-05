/*    */ package net.minecraft.block;
/*    */ 
/*    */ import net.minecraft.block.material.MapColor;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ 
/*    */ public class BlockCompressed extends Block {
/*    */   private final MapColor field_150202_a;
/*    */   
/*    */   public BlockCompressed(MapColor p_i45414_1_) {
/* 11 */     super(Material.field_151573_f);
/* 12 */     this.field_150202_a = p_i45414_1_;
/* 13 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000268";
/*    */   
/*    */   public MapColor func_149728_f(int p_149728_1_) {
/* 18 */     return this.field_150202_a;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockCompressed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */