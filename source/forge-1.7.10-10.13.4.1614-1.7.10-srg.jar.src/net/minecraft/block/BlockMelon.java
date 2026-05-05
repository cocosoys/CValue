/*    */ package net.minecraft.block;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ public class BlockMelon extends Block {
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon field_150201_a;
/*    */   
/*    */   protected BlockMelon() {
/* 15 */     super(Material.field_151572_C);
/* 16 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000267";
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 21 */     if (p_149691_1_ == 1 || p_149691_1_ == 0) return this.field_150201_a; 
/* 22 */     return this.field_149761_L;
/*    */   }
/*    */ 
/*    */   
/*    */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 27 */     return Items.field_151127_ba;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149745_a(Random p_149745_1_) {
/* 32 */     return 3 + p_149745_1_.nextInt(5);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149679_a(int p_149679_1_, Random p_149679_2_) {
/* 37 */     int i = func_149745_a(p_149679_2_) + p_149679_2_.nextInt(1 + p_149679_1_);
/* 38 */     if (i > 9) {
/* 39 */       i = 9;
/*    */     }
/* 41 */     return i;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 46 */     this.field_149761_L = p_149651_1_.func_94245_a(func_149641_N() + "_side");
/* 47 */     this.field_150201_a = p_149651_1_.func_94245_a(func_149641_N() + "_top");
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockMelon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */