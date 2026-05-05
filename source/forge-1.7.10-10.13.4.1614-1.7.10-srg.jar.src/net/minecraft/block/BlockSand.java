/*    */ package net.minecraft.block;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.material.MapColor;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ public class BlockSand
/*    */   extends BlockFalling
/*    */ {
/* 16 */   public static final String[] field_149838_a = new String[] { "default", "red" };
/*    */   @SideOnly(Side.CLIENT)
/*    */   private static IIcon field_149837_b;
/*    */   @SideOnly(Side.CLIENT)
/*    */   private static IIcon field_149839_N;
/*    */   private static final String __OBFID = "CL_00000303";
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 25 */     return (p_149691_2_ == 1) ? field_149839_N : field_149837_b;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 30 */     field_149837_b = p_149651_1_.func_94245_a("sand");
/* 31 */     field_149839_N = p_149651_1_.func_94245_a("red_sand");
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149692_a(int p_149692_1_) {
/* 36 */     return p_149692_1_;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/* 41 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
/* 42 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
/*    */   }
/*    */ 
/*    */   
/*    */   public MapColor func_149728_f(int p_149728_1_) {
/* 47 */     if (p_149728_1_ == 1) {
/* 48 */       return MapColor.field_151664_l;
/*    */     }
/* 50 */     return MapColor.field_151658_d;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockSand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */