/*     */ package net.minecraft.block;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.renderer.texture.IIconRegister;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.IIcon;
/*     */ import net.minecraft.world.ColorizerGrass;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class BlockGrass extends Block implements IGrowable {
/*  17 */   private static final Logger field_149992_a = LogManager.getLogger(); @SideOnly(Side.CLIENT)
/*     */   private IIcon field_149991_b; @SideOnly(Side.CLIENT)
/*     */   private IIcon field_149993_M;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private IIcon field_149994_N;
/*     */   private static final String __OBFID = "CL_00000251";
/*     */   
/*     */   protected BlockGrass() {
/*  25 */     super(Material.field_151577_b);
/*  26 */     func_149675_a(true);
/*  27 */     func_149647_a(CreativeTabs.field_78030_b);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149691_a(int p_149691_1_, int p_149691_2_) {
/*  32 */     if (p_149691_1_ == 1) return this.field_149991_b; 
/*  33 */     if (p_149691_1_ == 0) return Blocks.field_150346_d.func_149733_h(p_149691_1_); 
/*  34 */     return this.field_149761_L;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public IIcon func_149673_e(IBlockAccess p_149673_1_, int p_149673_2_, int p_149673_3_, int p_149673_4_, int p_149673_5_) {
/*  39 */     if (p_149673_5_ == 1) return this.field_149991_b; 
/*  40 */     if (p_149673_5_ == 0) return Blocks.field_150346_d.func_149733_h(p_149673_5_); 
/*  41 */     Material material = p_149673_1_.func_147439_a(p_149673_2_, p_149673_3_ + 1, p_149673_4_).func_149688_o();
/*  42 */     if (material == Material.field_151597_y || material == Material.field_151596_z) return this.field_149993_M; 
/*  43 */     return this.field_149761_L;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149651_a(IIconRegister p_149651_1_) {
/*  48 */     this.field_149761_L = p_149651_1_.func_94245_a(func_149641_N() + "_side");
/*  49 */     this.field_149991_b = p_149651_1_.func_94245_a(func_149641_N() + "_top");
/*  50 */     this.field_149993_M = p_149651_1_.func_94245_a(func_149641_N() + "_side_snowed");
/*  51 */     this.field_149994_N = p_149651_1_.func_94245_a(func_149641_N() + "_side_overlay");
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149635_D() {
/*  56 */     double d1 = 0.5D;
/*  57 */     double d2 = 1.0D;
/*     */     
/*  59 */     return ColorizerGrass.func_77480_a(d1, d2);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149741_i(int p_149741_1_) {
/*  64 */     return func_149635_D();
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149720_d(IBlockAccess p_149720_1_, int p_149720_2_, int p_149720_3_, int p_149720_4_) {
/*  70 */     int i = 0;
/*  71 */     int j = 0;
/*  72 */     int k = 0;
/*     */     
/*  74 */     for (byte b = -1; b <= 1; b++) {
/*  75 */       for (byte b1 = -1; b1 <= 1; b1++) {
/*  76 */         int m = p_149720_1_.func_72807_a(p_149720_2_ + b1, p_149720_4_ + b).func_150558_b(p_149720_2_ + b1, p_149720_3_, p_149720_4_ + b);
/*     */         
/*  78 */         i += (m & 0xFF0000) >> 16;
/*  79 */         j += (m & 0xFF00) >> 8;
/*  80 */         k += m & 0xFF;
/*     */       } 
/*     */     } 
/*     */     
/*  84 */     return (i / 9 & 0xFF) << 16 | (j / 9 & 0xFF) << 8 | k / 9 & 0xFF;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/*  89 */     if (p_149674_1_.field_72995_K)
/*     */       return; 
/*  91 */     if (p_149674_1_.func_72957_l(p_149674_2_, p_149674_3_ + 1, p_149674_4_) < 4 && p_149674_1_.func_147439_a(p_149674_2_, p_149674_3_ + 1, p_149674_4_).func_149717_k() > 2) {
/*  92 */       p_149674_1_.func_147449_b(p_149674_2_, p_149674_3_, p_149674_4_, Blocks.field_150346_d);
/*     */     }
/*  94 */     else if (p_149674_1_.func_72957_l(p_149674_2_, p_149674_3_ + 1, p_149674_4_) >= 9) {
/*  95 */       for (byte b = 0; b < 4; b++) {
/*  96 */         int i = p_149674_2_ + p_149674_5_.nextInt(3) - 1;
/*  97 */         int j = p_149674_3_ + p_149674_5_.nextInt(5) - 3;
/*  98 */         int k = p_149674_4_ + p_149674_5_.nextInt(3) - 1;
/*  99 */         Block block = p_149674_1_.func_147439_a(i, j + 1, k);
/* 100 */         if (p_149674_1_.func_147439_a(i, j, k) == Blocks.field_150346_d && p_149674_1_.func_72805_g(i, j, k) == 0 && p_149674_1_.func_72957_l(i, j + 1, k) >= 4 && block.func_149717_k() <= 2) {
/* 101 */           p_149674_1_.func_147449_b(i, j, k, Blocks.field_150349_c);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Item func_149650_a(int p_149650_1_, Random p_149650_2_, int p_149650_3_) {
/* 110 */     return Blocks.field_150346_d.func_149650_a(0, p_149650_2_, p_149650_3_);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static IIcon func_149990_e() {
/* 114 */     return Blocks.field_150349_c.field_149994_N;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
/* 119 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
/* 124 */     return true;
/*     */   }
/*     */   
/*     */   public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
/*     */     byte b;
/* 129 */     label26: for (b = 0; b < ''; b++) {
/* 130 */       int i = p_149853_3_;
/* 131 */       int j = p_149853_4_ + 1;
/* 132 */       int k = p_149853_5_;
/* 133 */       for (byte b1 = 0; b1 < b / 16; ) {
/* 134 */         i += p_149853_2_.nextInt(3) - 1;
/* 135 */         j += (p_149853_2_.nextInt(3) - 1) * p_149853_2_.nextInt(3) / 2;
/* 136 */         k += p_149853_2_.nextInt(3) - 1;
/* 137 */         if (p_149853_1_.func_147439_a(i, j - 1, k) == Blocks.field_150349_c) { if (p_149853_1_.func_147439_a(i, j, k).func_149721_r())
/*     */             continue label26;  b1++; }
/*     */         
/*     */         continue label26;
/*     */       } 
/* 142 */       if ((p_149853_1_.func_147439_a(i, j, k)).field_149764_J == Material.field_151579_a)
/* 143 */         if (p_149853_2_.nextInt(8) != 0) {
/* 144 */           if (Blocks.field_150329_H.func_149718_j(p_149853_1_, i, j, k)) p_149853_1_.func_147465_d(i, j, k, Blocks.field_150329_H, 1, 3); 
/*     */         } else {
/* 146 */           String str = p_149853_1_.func_72807_a(i, k).func_150572_a(p_149853_2_, i, j, k);
/* 147 */           field_149992_a.debug("Flower in " + (p_149853_1_.func_72807_a(i, k)).field_76791_y + ": " + str);
/* 148 */           BlockFlower blockFlower = BlockFlower.func_149857_e(str);
/* 149 */           if (blockFlower != null && blockFlower.func_149718_j(p_149853_1_, i, j, k)) {
/* 150 */             int m = BlockFlower.func_149856_f(str);
/* 151 */             p_149853_1_.func_147465_d(i, j, k, blockFlower, m, 3);
/*     */           } 
/*     */         }  
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockGrass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */