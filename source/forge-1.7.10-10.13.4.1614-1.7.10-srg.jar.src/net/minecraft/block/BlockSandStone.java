/*    */ package net.minecraft.block;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ public class BlockSandStone
/*    */   extends Block
/*    */ {
/* 16 */   public static final String[] field_150157_a = new String[] { "default", "chiseled", "smooth" };
/*    */ 
/*    */ 
/*    */   
/* 20 */   private static final String[] field_150156_b = new String[] { "normal", "carved", "smooth" };
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon[] field_150158_M;
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon field_150159_N;
/*    */   
/*    */   public BlockSandStone() {
/* 29 */     super(Material.field_151576_e);
/* 30 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   } @SideOnly(Side.CLIENT)
/*    */   private IIcon field_150160_O; private static final String __OBFID = "CL_00000304";
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 35 */     if (p_149691_1_ == 1 || (p_149691_1_ == 0 && (p_149691_2_ == 1 || p_149691_2_ == 2))) {
/* 36 */       return this.field_150159_N;
/*    */     }
/* 38 */     if (p_149691_1_ == 0) {
/* 39 */       return this.field_150160_O;
/*    */     }
/* 41 */     if (p_149691_2_ < 0 || p_149691_2_ >= this.field_150158_M.length) p_149691_2_ = 0; 
/* 42 */     return this.field_150158_M[p_149691_2_];
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149692_a(int p_149692_1_) {
/* 47 */     return p_149692_1_;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/* 52 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
/* 53 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
/* 54 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 2));
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 59 */     this.field_150158_M = new IIcon[field_150156_b.length];
/*    */     
/* 61 */     for (byte b = 0; b < this.field_150158_M.length; b++) {
/* 62 */       this.field_150158_M[b] = p_149651_1_.func_94245_a(func_149641_N() + "_" + field_150156_b[b]);
/*    */     }
/*    */     
/* 65 */     this.field_150159_N = p_149651_1_.func_94245_a(func_149641_N() + "_top");
/* 66 */     this.field_150160_O = p_149651_1_.func_94245_a(func_149641_N() + "_bottom");
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockSandStone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */