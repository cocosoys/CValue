/*    */ package net.minecraft.block;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ 
/*    */ public class BlockGlass extends BlockBreakable {
/*    */   public BlockGlass(Material p_i45408_1_, boolean p_i45408_2_) {
/* 11 */     super("glass", p_i45408_1_, p_i45408_2_);
/* 12 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149745_a(Random p_149745_1_) {
/* 17 */     return 0;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000249";
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149701_w() {
/* 22 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_149686_d() {
/* 27 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean func_149700_E() {
/* 32 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockGlass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */