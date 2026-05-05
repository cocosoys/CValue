/*    */ package net.minecraft.block;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ 
/*    */ public class BlockRail extends BlockRailBase {
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon field_150056_b;
/*    */   
/*    */   protected BlockRail() {
/* 11 */     super(false);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000293";
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 16 */     if (p_149691_2_ >= 6) {
/* 17 */       return this.field_150056_b;
/*    */     }
/* 19 */     return this.field_149761_L;
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 25 */     super.func_149651_a(p_149651_1_);
/* 26 */     this.field_150056_b = p_149651_1_.func_94245_a(func_149641_N() + "_turned");
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_150048_a(World p_150048_1_, int p_150048_2_, int p_150048_3_, int p_150048_4_, int p_150048_5_, int p_150048_6_, Block p_150048_7_) {
/* 31 */     if (p_150048_7_.func_149744_f() && (
/* 32 */       new BlockRailBase.Rail(this, p_150048_1_, p_150048_2_, p_150048_3_, p_150048_4_)).func_150650_a() == 3)
/* 33 */       func_150052_a(p_150048_1_, p_150048_2_, p_150048_3_, p_150048_4_, false); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockRail.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */