/*    */ package net.minecraft.block;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.List;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockDirt
/*    */   extends Block
/*    */ {
/* 19 */   public static final String[] field_150009_a = new String[] { "default", "default", "podzol" };
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon field_150008_b;
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon field_150010_M;
/*    */   private static final String __OBFID = "CL_00000228";
/*    */   
/*    */   protected BlockDirt() {
/* 27 */     super(Material.field_151578_c);
/* 28 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 33 */     if (p_149691_2_ == 2) {
/* 34 */       if (p_149691_1_ == 1)
/* 35 */         return this.field_150008_b; 
/* 36 */       if (p_149691_1_ != 0) {
/* 37 */         return this.field_150010_M;
/*    */       }
/*    */     } 
/* 40 */     return this.field_149761_L;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149673_e(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_) {
/* 45 */     int i = p_149673_1_.func_72805_g(p_149673_2_, p_149673_3_, p_149673_4_);
/* 46 */     if (i == 2) {
/* 47 */       if (p_149673_5_ == 1)
/* 48 */         return this.field_150008_b; 
/* 49 */       if (p_149673_5_ != 0) {
/* 50 */         Material material = p_149673_1_.func_147439_a(p_149673_2_, p_149673_3_ + 1, p_149673_4_).func_149688_o();
/* 51 */         if (material == Material.field_151597_y || material == Material.field_151596_z) {
/* 52 */           return Blocks.field_150349_c.func_149673_e(p_149673_1_, p_149673_2_, p_149673_3_, p_149673_4_, p_149673_5_);
/*    */         }
/* 54 */         Block block = p_149673_1_.func_147439_a(p_149673_2_, p_149673_3_ + 1, p_149673_4_);
/* 55 */         if (block != Blocks.field_150346_d && block != Blocks.field_150349_c) {
/* 56 */           return this.field_150010_M;
/*    */         }
/*    */       } 
/*    */     } 
/* 60 */     return this.field_149761_L;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149692_a(int p_149692_1_) {
/* 65 */     return 0;
/*    */   }
/*    */ 
/*    */   
/*    */   protected ItemStack func_149644_j(int p_149644_1_) {
/* 70 */     if (p_149644_1_ == 1) p_149644_1_ = 0; 
/* 71 */     return super.func_149644_j(p_149644_1_);
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149666_a(Item p_149666_1_, CreativeTabs p_149666_2_, List<ItemStack> p_149666_3_) {
/* 76 */     p_149666_3_.add(new ItemStack(this, 1, 0));
/* 77 */     p_149666_3_.add(new ItemStack(this, 1, 2));
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 82 */     super.func_149651_a(p_149651_1_);
/*    */     
/* 84 */     this.field_150008_b = p_149651_1_.func_94245_a(func_149641_N() + "_" + "podzol_top");
/* 85 */     this.field_150010_M = p_149651_1_.func_94245_a(func_149641_N() + "_" + "podzol_side");
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_149643_k(World p_149643_1_, int p_149643_2_, int p_149643_3_, int p_149643_4_) {
/* 90 */     int i = p_149643_1_.func_72805_g(p_149643_2_, p_149643_3_, p_149643_4_);
/* 91 */     if (i == 1) {
/* 92 */       i = 0;
/*    */     }
/* 94 */     return i;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockDirt.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */