/*    */ package net.minecraft.block;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.block.material.MapColor;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ public class BlockColored extends Block {
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon[] field_150033_a;
/*    */   
/*    */   public BlockColored(Material p_i45398_1_) {
/* 15 */     super(p_i45398_1_);
/* 16 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000217";
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 21 */     return this.field_150033_a[p_149691_2_ % this.field_150033_a.length];
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149692_a(int p_149692_1_) {
/* 26 */     return p_149692_1_;
/*    */   }
/*    */   
/*    */   public static int func_150032_b(int p_150032_0_) {
/* 30 */     return func_150031_c(p_150032_0_);
/*    */   }
/*    */   
/*    */   public static int func_150031_c(int p_150031_0_) {
/* 34 */     return (p_150031_0_ ^ 0xFFFFFFFF) & 0xF;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/* 39 */     for (byte b = 0; b < 16; b++) {
/* 40 */       p_149666_3_.add(new ItemStack(p_149666_1_, 1, b));
/*    */     }
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 46 */     this.field_150033_a = new IIcon[16];
/*    */     
/* 48 */     for (byte b = 0; b < this.field_150033_a.length; b++) {
/* 49 */       this.field_150033_a[b] = p_149651_1_.func_94245_a(func_149641_N() + "_" + ItemDye.field_150921_b[func_150031_c(b)]);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public MapColor func_149728_f(int p_149728_1_) {
/* 55 */     return MapColor.func_151644_a(p_149728_1_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockColored.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */