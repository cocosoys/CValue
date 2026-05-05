/*    */ package net.minecraft.block;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockNewLeaf
/*    */   extends BlockLeaves
/*    */ {
/* 17 */   public static final String[][] field_150132_N = new String[][] { { "leaves_acacia", "leaves_big_oak" }, { "leaves_acacia_opaque", "leaves_big_oak_opaque" } };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 24 */   public static final String[] field_150133_O = new String[] { "acacia", "big_oak" };
/*    */   
/*    */   private static final String __OBFID = "CL_00000276";
/*    */ 
/*    */   
/*    */   protected void func_150124_c(World p_150124_1_, int p_150124_2_, int p_150124_3_, int p_150124_4_, int p_150124_5_, int p_150124_6_) {
/* 30 */     if ((p_150124_5_ & 0x3) == 1 && p_150124_1_.field_73012_v.nextInt(p_150124_6_) == 0) {
/* 31 */       func_149642_a(p_150124_1_, p_150124_2_, p_150124_3_, p_150124_4_, new ItemStack(Items.field_151034_e, 1, 0));
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149692_a(int p_149692_1_) {
/* 37 */     return super.func_149692_a(p_149692_1_) + 4;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149643_k(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_) {
/* 42 */     return p_149643_1_.func_72805_g(p_149643_2_, p_149643_3_, p_149643_4_) & 0x3;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 47 */     if ((p_149691_2_ & 0x3) == 1) {
/* 48 */       return this.field_150129_M[this.field_150127_b][1];
/*    */     }
/* 50 */     return this.field_150129_M[this.field_150127_b][0];
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/* 55 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 0));
/* 56 */     p_149666_3_.add(new ItemStack(p_149666_1_, 1, 1));
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 61 */     for (byte b = 0; b < field_150132_N.length; b++) {
/* 62 */       this.field_150129_M[b] = new IIcon[(field_150132_N[b]).length];
/*    */       
/* 64 */       for (byte b1 = 0; b1 < (field_150132_N[b]).length; b1++) {
/* 65 */         this.field_150129_M[b][b1] = p_149651_1_.func_94245_a(field_150132_N[b][b1]);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public String[] func_150125_e() {
/* 72 */     return field_150133_O;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockNewLeaf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */