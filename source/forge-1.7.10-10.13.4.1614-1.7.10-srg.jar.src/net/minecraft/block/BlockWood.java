/*    */ package net.minecraft.block;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ public class BlockWood extends Block {
/* 11 */   public static final String[] field_150096_a = new String[] { "oak", "spruce", "birch", "jungle", "acacia", "big_oak" };
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon[] field_150095_b;
/*    */   private static final String __OBFID = "CL_00000335";
/*    */   
/*    */   public BlockWood() {
/* 18 */     super(Material.field_151575_d);
/* 19 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 24 */     if (p_149691_2_ < 0 || p_149691_2_ >= this.field_150095_b.length) {
/* 25 */       p_149691_2_ = 0;
/*    */     }
/* 27 */     return this.field_150095_b[p_149691_2_];
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149692_a(int p_149692_1_) {
/* 32 */     return p_149692_1_;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/* 37 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
/* 38 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
/* 39 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 2));
/* 40 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 3));
/* 41 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 4));
/* 42 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 5));
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 47 */     this.field_150095_b = new IIcon[field_150096_a.length];
/*    */     
/* 49 */     for (byte b = 0; b < this.field_150095_b.length; b++)
/* 50 */       this.field_150095_b[b] = p_149651_1_.func_94245_a(func_149641_N() + "_" + field_150096_a[b]); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockWood.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */