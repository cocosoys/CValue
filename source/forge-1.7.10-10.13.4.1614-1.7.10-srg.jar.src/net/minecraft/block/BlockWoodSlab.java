/*    */ package net.minecraft.block;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class BlockWoodSlab extends BlockSlab {
/* 11 */   public static final String[] field_150005_b = new String[] { "oak", "spruce", "birch", "jungle", "acacia", "big_oak" };
/*    */   
/*    */   private static final String __OBFID = "CL_00000337";
/*    */   
/*    */   public BlockWoodSlab(boolean p_i45437_1_) {
/* 16 */     super(p_i45437_1_, Material.field_151575_d);
/* 17 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 22 */     return Blocks.field_150344_f.func_149691_a(p_149691_1_, p_149691_2_ & 0x7);
/*    */   }
/*    */ 
/*    */   
/*    */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 27 */     return Item.func_150898_a(Blocks.field_150376_bx);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ItemStack func_149644_j(int p_149644_1_) {
/* 32 */     return new ItemStack(Item.func_150898_a(Blocks.field_150376_bx), 2, p_149644_1_ & 0x7);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_150002_b(int p_150002_1_) {
/* 37 */     if (p_150002_1_ < 0 || p_150002_1_ >= field_150005_b.length) {
/* 38 */       p_150002_1_ = 0;
/*    */     }
/* 40 */     return func_149739_a() + "." + field_150005_b[p_150002_1_];
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/* 45 */     if (p_149666_1_ == Item.func_150898_a(Blocks.field_150373_bw))
/*    */       return; 
/* 47 */     for (byte b = 0; b < field_150005_b.length; b++)
/* 48 */       p_149666_3_.add(new ItemStack(p_149666_1_, 1, b)); 
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockWoodSlab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */