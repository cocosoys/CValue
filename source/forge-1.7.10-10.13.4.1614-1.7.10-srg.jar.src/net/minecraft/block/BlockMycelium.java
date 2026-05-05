/*    */ package net.minecraft.block;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.util.IIcon;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockMycelium extends Block {
/*    */   @SideOnly(Side.CLIENT)
/*    */   private IIcon field_150200_a;
/*    */   
/*    */   protected BlockMycelium() {
/* 20 */     super(Material.field_151577_b);
/* 21 */     func_149675_a(true);
/* 22 */     func_149647_a(CreativeTabs.field_78030_b);
/*    */   } @SideOnly(Side.CLIENT)
/*    */   private IIcon field_150199_b; private static final String __OBFID = "CL_00000273";
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/* 27 */     if (p_149691_1_ == 1) return this.field_150200_a; 
/* 28 */     if (p_149691_1_ == 0) return Blocks.field_150346_d.func_149733_h(p_149691_1_); 
/* 29 */     return this.field_149761_L;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public IIcon func_149673_e(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_) {
/* 34 */     if (p_149673_5_ == 1) return this.field_150200_a; 
/* 35 */     if (p_149673_5_ == 0) return Blocks.field_150346_d.func_149733_h(p_149673_5_); 
/* 36 */     Material material = p_149673_1_.func_147439_a(p_149673_2_, p_149673_3_ + 1, p_149673_4_).func_149688_o();
/* 37 */     if (material == Material.field_151597_y || material == Material.field_151596_z) return this.field_150199_b; 
/* 38 */     return this.field_149761_L;
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister p_149651_1_) {
/* 43 */     this.field_149761_L = p_149651_1_.func_94245_a(func_149641_N() + "_side");
/* 44 */     this.field_150200_a = p_149651_1_.func_94245_a(func_149641_N() + "_top");
/* 45 */     this.field_150199_b = p_149651_1_.func_94245_a("grass_side_snowed");
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/* 50 */     if (p_149674_1_.field_72995_K)
/*    */       return; 
/* 52 */     if (p_149674_1_.func_72957_l(p_149674_2_, p_149674_3_ + 1, p_149674_4_) < 4 && p_149674_1_.func_147439_a(p_149674_2_, p_149674_3_ + 1, p_149674_4_).func_149717_k() > 2) {
/* 53 */       p_149674_1_.func_147449_b(p_149674_2_, p_149674_3_, p_149674_4_, Blocks.field_150346_d);
/*    */     }
/* 55 */     else if (p_149674_1_.func_72957_l(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9) {
/* 56 */       for (byte b = 0; b < 4; b++) {
/* 57 */         int i = p_149674_2_ + p_149674_5_.nextInt(3) - 1;
/* 58 */         int j = p_149674_3_ + p_149674_5_.nextInt(5) - 3;
/* 59 */         int k = p_149674_4_ + p_149674_5_.nextInt(3) - 1;
/* 60 */         Block block = p_149674_1_.func_147439_a(i, j + 1, k);
/* 61 */         if (p_149674_1_.func_147439_a(i, j, k) == Blocks.field_150346_d && p_149674_1_.func_72805_g(i, j, k) == 0 && p_149674_1_.func_72957_l(i, j + 1, k) >= 4 && block.func_149717_k() <= 2) {
/* 62 */           p_149674_1_.func_147449_b(i, j, k, this);
/*    */         }
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149734_b(World p_149734_1_, int p_149734_2_, int p_149734_3_, int p_149734_4_, Random p_149734_5_) {
/* 71 */     super.func_149734_b(p_149734_1_, p_149734_2_, p_149734_3_, p_149734_4_, p_149734_5_);
/* 72 */     if (p_149734_5_.nextInt(10) == 0) p_149734_1_.func_72869_a("townaura", (p_149734_2_ + p_149734_5_.nextFloat()), (p_149734_3_ + 1.1F), (p_149734_4_ + p_149734_5_.nextFloat()), 0.0D, 0.0D, 0.0D);
/*    */   
/*    */   }
/*    */   
/*    */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 77 */     return Blocks.field_150346_d.func_149650_a(0, p_149650_2_, p_149650_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockMycelium.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */