/*    */ package net.minecraft.block;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ 
/*    */ public class BlockHay extends BlockRotatedPillar {
/*    */   public BlockHay() {
/*  9 */     super(Material.field_151577_b);
/* 10 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000256";
/*    */   @SideOnly(Side.CLIENT)
/*    */   protected IIcon func_150163_b(int p_150163_1_) {
/* 15 */     return this.field_149761_L;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 20 */     this.field_150164_N = p_149651_1_.func_94245_a(func_149641_N() + "_top");
/* 21 */     this.field_149761_L = p_149651_1_.func_94245_a(func_149641_N() + "_side");
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockHay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */