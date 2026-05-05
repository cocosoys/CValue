/*    */ package net.minecraft.block;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockStoneSlab
/*    */   extends BlockSlab
/*    */ {
/* 20 */   public static final String[] field_150006_b = new String[] { "stone", "sand", "wood", "cobble", "brick", "smoothStoneBrick", "netherBrick", "quartz" };
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon field_150007_M;
/*    */   private static final String __OBFID = "CL_00000320";
/*    */   
/*    */   public BlockStoneSlab(boolean p_i45431_1_) {
/* 27 */     super(p_i45431_1_, Material.field_151576_e);
/* 28 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 33 */     int i = p_149691_2_ & 0x7;
/* 34 */     if (this.field_150004_a && (p_149691_2_ & 0x8) != 0) {
/* 35 */       p_149691_1_ = 1;
/*    */     }
/* 37 */     if (i == 0) {
/* 38 */       if (p_149691_1_ == 1 || p_149691_1_ == 0) return this.field_149761_L; 
/* 39 */       return this.field_150007_M;
/* 40 */     }  if (i == 1)
/* 41 */       return Blocks.field_150322_A.func_149733_h(p_149691_1_); 
/* 42 */     if (i == 2) return Blocks.field_150344_f.func_149733_h(p_149691_1_); 
/* 43 */     if (i == 3)
/* 44 */       return Blocks.field_150347_e.func_149733_h(p_149691_1_); 
/* 45 */     if (i == 4)
/* 46 */       return Blocks.field_150336_V.func_149733_h(p_149691_1_); 
/* 47 */     if (i == 5)
/* 48 */       return Blocks.field_150417_aV.func_149691_a(p_149691_1_, 0); 
/* 49 */     if (i == 6)
/* 50 */       return Blocks.field_150385_bj.func_149733_h(1); 
/* 51 */     if (i == 7) {
/* 52 */       return Blocks.field_150371_ca.func_149733_h(p_149691_1_);
/*    */     }
/*    */     
/* 55 */     return this.field_149761_L;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 60 */     this.field_149761_L = p_149651_1_.func_94245_a("stone_slab_top");
/* 61 */     this.field_150007_M = p_149651_1_.func_94245_a("stone_slab_side");
/*    */   }
/*    */ 
/*    */   
/*    */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 66 */     return Item.func_150898_a(Blocks.field_150333_U);
/*    */   }
/*    */ 
/*    */   
/*    */   protected ItemStack func_149644_j(int p_149644_1_) {
/* 71 */     return new ItemStack(Item.func_150898_a(Blocks.field_150333_U), 2, p_149644_1_ & 0x7);
/*    */   }
/*    */ 
/*    */   
/*    */   public String func_150002_b(int p_150002_1_) {
/* 76 */     if (p_150002_1_ < 0 || p_150002_1_ >= field_150006_b.length) {
/* 77 */       p_150002_1_ = 0;
/*    */     }
/* 79 */     return func_149739_a() + "." + field_150006_b[p_150002_1_];
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/* 84 */     if (p_149666_1_ == Item.func_150898_a(Blocks.field_150334_T))
/*    */       return; 
/* 86 */     for (byte b = 0; b <= 7; b++) {
/* 87 */       if (b != 2)
/* 88 */         p_149666_3_.add(new ItemStack(p_149666_1_, 1, b)); 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockStoneSlab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */