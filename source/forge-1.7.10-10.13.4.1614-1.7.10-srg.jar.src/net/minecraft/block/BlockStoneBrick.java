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
/*    */ public class BlockStoneBrick
/*    */   extends Block
/*    */ {
/* 16 */   public static final String[] field_150142_a = new String[] { "default", "mossy", "cracked", "chiseled" };
/*    */ 
/*    */ 
/*    */   
/* 20 */   public static final String[] field_150141_b = new String[] { null, "mossy", "cracked", "carved" };
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon[] field_150143_M;
/*    */   private static final String __OBFID = "CL_00000318";
/*    */   
/*    */   public BlockStoneBrick() {
/* 27 */     super(Material.field_151576_e);
/* 28 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 33 */     if (p_149691_2_ < 0 || p_149691_2_ >= field_150141_b.length) p_149691_2_ = 0; 
/* 34 */     return this.field_150143_M[p_149691_2_];
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149692_a(int p_149692_1_) {
/* 39 */     return p_149692_1_;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/* 44 */     for (byte b = 0; b < 4; b++) {
/* 45 */       p_149666_3_.add(new ItemStack(p_149666_1_, 1, b));
/*    */     }
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 51 */     this.field_150143_M = new IIcon[field_150141_b.length];
/*    */     
/* 53 */     for (byte b = 0; b < this.field_150143_M.length; b++) {
/* 54 */       String str = func_149641_N();
/* 55 */       if (field_150141_b[b] != null) str = str + "_" + field_150141_b[b]; 
/* 56 */       this.field_150143_M[b] = p_149651_1_.func_94245_a(str);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockStoneBrick.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */