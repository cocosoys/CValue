/*     */ package net.minecraft.world.gen.feature;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class WorldGenTrees
/*     */   extends WorldGenAbstractTree
/*     */ {
/*     */   private final int field_76533_a;
/*     */   private final boolean field_76531_b;
/*     */   
/*     */   public WorldGenTrees(boolean p_i2027_1_) {
/*  17 */     this(p_i2027_1_, 4, 0, 0, false);
/*     */   }
/*     */   private final int field_76532_c; private final int field_76530_d; private static final String __OBFID = "CL_00000438";
/*     */   public WorldGenTrees(boolean p_i2028_1_, int p_i2028_2_, int p_i2028_3_, int p_i2028_4_, boolean p_i2028_5_) {
/*  21 */     super(p_i2028_1_);
/*  22 */     this.field_76533_a = p_i2028_2_;
/*  23 */     this.field_76532_c = p_i2028_3_;
/*  24 */     this.field_76530_d = p_i2028_4_;
/*  25 */     this.field_76531_b = p_i2028_5_;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/*  30 */     int i = p_76484_2_.nextInt(3) + this.field_76533_a;
/*     */     
/*  32 */     boolean bool = true;
/*  33 */     if (p_76484_4_ < 1 || p_76484_4_ + i + 1 > 256) return false;
/*     */     
/*  35 */     for (int j = p_76484_4_; j <= p_76484_4_ + 1 + i; j++) {
/*  36 */       byte b = 1;
/*  37 */       if (j == p_76484_4_) b = 0; 
/*  38 */       if (j >= p_76484_4_ + 1 + i - 2) b = 2; 
/*  39 */       for (int m = p_76484_3_ - b; m <= p_76484_3_ + b && bool; m++) {
/*  40 */         for (int n = p_76484_5_ - b; n <= p_76484_5_ + b && bool; n++) {
/*  41 */           if (j >= 0 && j < 256) {
/*  42 */             Block block1 = p_76484_1_.func_147439_a(m, j, n);
/*  43 */             if (!func_150523_a(block1)) bool = false; 
/*     */           } else {
/*  45 */             bool = false;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  51 */     if (!bool) return false;
/*     */     
/*  53 */     Block block = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_);
/*  54 */     if ((block != Blocks.field_150349_c && block != Blocks.field_150346_d && block != Blocks.field_150458_ak) || p_76484_4_ >= 256 - i - 1) return false;
/*     */     
/*  56 */     func_150515_a(p_76484_1_, p_76484_3_, p_76484_4_ - 1, p_76484_5_, Blocks.field_150346_d);
/*     */     
/*  58 */     byte b1 = 3;
/*  59 */     byte b2 = 0; int k;
/*  60 */     for (k = p_76484_4_ - b1 + i; k <= p_76484_4_ + i; k++) {
/*  61 */       int m = k - p_76484_4_ + i;
/*  62 */       int n = b2 + 1 - m / 2;
/*  63 */       for (int i1 = p_76484_3_ - n; i1 <= p_76484_3_ + n; i1++) {
/*  64 */         int i2 = i1 - p_76484_3_;
/*  65 */         for (int i3 = p_76484_5_ - n; i3 <= p_76484_5_ + n; i3++) {
/*  66 */           int i4 = i3 - p_76484_5_;
/*  67 */           if (Math.abs(i2) != n || Math.abs(i4) != n || (p_76484_2_.nextInt(2) != 0 && m != 0)) {
/*  68 */             Block block1 = p_76484_1_.func_147439_a(i1, k, i3);
/*  69 */             if (block1.func_149688_o() == Material.field_151579_a || block1.func_149688_o() == Material.field_151584_j) func_150516_a(p_76484_1_, i1, k, i3, (Block)Blocks.field_150362_t, this.field_76530_d); 
/*     */           } 
/*     */         } 
/*     */       } 
/*  73 */     }  for (k = 0; k < i; k++) {
/*  74 */       Block block1 = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ + k, p_76484_5_);
/*  75 */       if (block1.func_149688_o() == Material.field_151579_a || block1.func_149688_o() == Material.field_151584_j) {
/*  76 */         func_150516_a(p_76484_1_, p_76484_3_, p_76484_4_ + k, p_76484_5_, Blocks.field_150364_r, this.field_76532_c);
/*  77 */         if (this.field_76531_b && k > 0) {
/*  78 */           if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_147437_c(p_76484_3_ - 1, p_76484_4_ + k, p_76484_5_)) {
/*  79 */             func_150516_a(p_76484_1_, p_76484_3_ - 1, p_76484_4_ + k, p_76484_5_, Blocks.field_150395_bd, 8);
/*     */           }
/*  81 */           if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_147437_c(p_76484_3_ + 1, p_76484_4_ + k, p_76484_5_)) {
/*  82 */             func_150516_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + k, p_76484_5_, Blocks.field_150395_bd, 2);
/*     */           }
/*  84 */           if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_ + k, p_76484_5_ - 1)) {
/*  85 */             func_150516_a(p_76484_1_, p_76484_3_, p_76484_4_ + k, p_76484_5_ - 1, Blocks.field_150395_bd, 1);
/*     */           }
/*  87 */           if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_ + k, p_76484_5_ + 1)) {
/*  88 */             func_150516_a(p_76484_1_, p_76484_3_, p_76484_4_ + k, p_76484_5_ + 1, Blocks.field_150395_bd, 4);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  94 */     if (this.field_76531_b) {
/*  95 */       for (k = p_76484_4_ - 3 + i; k <= p_76484_4_ + i; k++) {
/*  96 */         int m = k - p_76484_4_ + i;
/*  97 */         int n = 2 - m / 2;
/*  98 */         for (int i1 = p_76484_3_ - n; i1 <= p_76484_3_ + n; i1++) {
/*  99 */           for (int i2 = p_76484_5_ - n; i2 <= p_76484_5_ + n; i2++) {
/* 100 */             if (p_76484_1_.func_147439_a(i1, k, i2).func_149688_o() == Material.field_151584_j) {
/* 101 */               if (p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_147439_a(i1 - 1, k, i2).func_149688_o() == Material.field_151579_a) {
/* 102 */                 func_76529_b(p_76484_1_, i1 - 1, k, i2, 8);
/*     */               }
/* 104 */               if (p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_147439_a(i1 + 1, k, i2).func_149688_o() == Material.field_151579_a) {
/* 105 */                 func_76529_b(p_76484_1_, i1 + 1, k, i2, 2);
/*     */               }
/* 107 */               if (p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_147439_a(i1, k, i2 - 1).func_149688_o() == Material.field_151579_a) {
/* 108 */                 func_76529_b(p_76484_1_, i1, k, i2 - 1, 1);
/*     */               }
/* 110 */               if (p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_147439_a(i1, k, i2 + 1).func_149688_o() == Material.field_151579_a) {
/* 111 */                 func_76529_b(p_76484_1_, i1, k, i2 + 1, 4);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 119 */       if (p_76484_2_.nextInt(5) == 0 && i > 5) {
/* 120 */         for (k = 0; k < 2; k++) {
/* 121 */           for (byte b = 0; b < 4; b++) {
/* 122 */             if (p_76484_2_.nextInt(4 - k) == 0) {
/* 123 */               int m = p_76484_2_.nextInt(3);
/* 124 */               func_150516_a(p_76484_1_, p_76484_3_ + Direction.field_71583_a[Direction.field_71580_e[b]], p_76484_4_ + i - 5 + k, p_76484_5_ + Direction.field_71581_b[Direction.field_71580_e[b]], Blocks.field_150375_by, m << 2 | b);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/* 130 */     return true;
/*     */   }
/*     */   
/*     */   private void func_76529_b(World p_76529_1_, int p_76529_2_, int p_76529_3_, int p_76529_4_, int p_76529_5_) {
/* 134 */     func_150516_a(p_76529_1_, p_76529_2_, p_76529_3_, p_76529_4_, Blocks.field_150395_bd, p_76529_5_);
/* 135 */     byte b = 4;
/* 136 */     while (p_76529_1_.func_147439_a(p_76529_2_, --p_76529_3_, p_76529_4_).func_149688_o() == Material.field_151579_a && b > 0) {
/* 137 */       func_150516_a(p_76529_1_, p_76529_2_, p_76529_3_, p_76529_4_, Blocks.field_150395_bd, p_76529_5_);
/* 138 */       b--;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenTrees.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */