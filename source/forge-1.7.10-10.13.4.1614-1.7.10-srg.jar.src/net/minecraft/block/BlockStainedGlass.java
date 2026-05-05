/*    */ package net.minecraft.block;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ public class BlockStainedGlass extends BlockBreakable {
/* 11 */   private static final IIcon[] field_149998_a = new IIcon[16]; private static final String __OBFID = "CL_00000312";
/*    */   
/*    */   public BlockStainedGlass(Material p_i45427_1_) {
/* 14 */     super("glass", p_i45427_1_, false);
/* 15 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 20 */     return field_149998_a[p_149691_2_ % field_149998_a.length];
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149692_a(int p_149692_1_) {
/* 25 */     return p_149692_1_;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public static int func_149997_b(int p_149997_0_) {
/* 29 */     return (p_149997_0_ ^ 0xFFFFFFFF) & 0xF;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/* 34 */     for (byte b = 0; b < field_149998_a.length; b++) {
/* 35 */       p_149666_3_.add(new ItemStack(p_149666_1_, 1, b));
/*    */     }
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149701_w() {
/* 41 */     return 1;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 46 */     for (byte b = 0; b < field_149998_a.length; b++) {
/* 47 */       field_149998_a[b] = p_149651_1_.func_94245_a(func_149641_N() + "_" + ItemDye.field_150921_b[func_149997_b(b)]);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149745_a(Random p_149745_1_) {
/* 53 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean func_149700_E() {
/* 58 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_149686_d() {
/* 63 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockStainedGlass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */