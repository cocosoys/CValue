/*    */ package net.minecraft.block;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemDye;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ public class BlockStainedGlassPane extends BlockPane {
/* 14 */   private static final IIcon[] field_150106_a = new IIcon[16];
/* 15 */   private static final IIcon[] field_150105_b = new IIcon[16]; private static final String __OBFID = "CL_00000313";
/*    */   
/*    */   public BlockStainedGlassPane() {
/* 18 */     super("glass", "glass_pane_top", Material.field_151592_s, false);
/* 19 */     func_149647_a(CreativeTabs.field_78031_c);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149735_b(int p_149735_1_, int p_149735_2_) {
/* 24 */     return field_150106_a[p_149735_2_ % field_150106_a.length];
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_150104_b(int p_150104_1_) {
/* 28 */     return field_150105_b[(p_150104_1_ ^ 0xFFFFFFFF) & 0xF];
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 33 */     return func_149735_b(p_149691_1_, (p_149691_2_ ^ 0xFFFFFFFF) & 0xF);
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149692_a(int p_149692_1_) {
/* 38 */     return p_149692_1_;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public static int func_150103_c(int p_150103_0_) {
/* 42 */     return p_150103_0_ & 0xF;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/* 47 */     for (byte b = 0; b < field_150106_a.length; b++) {
/* 48 */       p_149666_3_.add(new ItemStack(p_149666_1_, 1, b));
/*    */     }
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public int func_149701_w() {
/* 54 */     return 1;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 59 */     super.func_149651_a(p_149651_1_);
/* 60 */     for (byte b = 0; b < field_150106_a.length; b++) {
/* 61 */       field_150106_a[b] = p_149651_1_.func_94245_a(func_149641_N() + "_" + ItemDye.field_150921_b[func_150103_c(b)]);
/* 62 */       field_150105_b[b] = p_149651_1_.func_94245_a(func_149641_N() + "_pane_top_" + ItemDye.field_150921_b[func_150103_c(b)]);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockStainedGlassPane.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */