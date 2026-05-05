/*     */ package net.minecraft.world.gen.feature;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class WorldGenSwamp
/*     */   extends WorldGenAbstractTree {
/*     */   public WorldGenSwamp() {
/*  12 */     super(false);
/*     */   }
/*     */   private static final String __OBFID = "CL_00000436";
/*     */   
/*     */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/*  17 */     int i = p_76484_2_.nextInt(4) + 5;
/*  18 */     while (p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_).func_149688_o() == Material.field_151586_h) {
/*  19 */       p_76484_4_--;
/*     */     }
/*  21 */     boolean bool = true;
/*  22 */     if (p_76484_4_ < 1 || p_76484_4_ + i + 1 > 256) return false;
/*     */     
/*  24 */     for (int j = p_76484_4_; j <= p_76484_4_ + 1 + i; j++) {
/*  25 */       byte b = 1;
/*  26 */       if (j == p_76484_4_) b = 0; 
/*  27 */       if (j >= p_76484_4_ + 1 + i - 2) b = 3; 
/*  28 */       for (int m = p_76484_3_ - b; m <= p_76484_3_ + b && bool; m++) {
/*  29 */         for (int n = p_76484_5_ - b; n <= p_76484_5_ + b && bool; n++) {
/*  30 */           if (j >= 0 && j < 256) {
/*  31 */             Block block1 = p_76484_1_.func_147439_a(m, j, n);
/*  32 */             if (block1.func_149688_o() != Material.field_151579_a && block1.func_149688_o() != Material.field_151584_j) {
/*  33 */               if (block1 == Blocks.field_150355_j || block1 == Blocks.field_150358_i) {
/*  34 */                 if (j > p_76484_4_) bool = false; 
/*     */               } else {
/*  36 */                 bool = false;
/*     */               } 
/*     */             }
/*     */           } else {
/*  40 */             bool = false;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  46 */     if (!bool) return false;
/*     */     
/*  48 */     Block block = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_);
/*  49 */     if ((block != Blocks.field_150349_c && block != Blocks.field_150346_d) || p_76484_4_ >= 256 - i - 1) {
/*  50 */       return false;
/*     */     }
/*  52 */     func_150515_a(p_76484_1_, p_76484_3_, p_76484_4_ - 1, p_76484_5_, Blocks.field_150346_d);
/*     */     int k;
/*  54 */     for (k = p_76484_4_ - 3 + i; k <= p_76484_4_ + i; k++) {
/*  55 */       int m = k - p_76484_4_ + i;
/*  56 */       int n = 2 - m / 2;
/*  57 */       for (int i1 = p_76484_3_ - n; i1 <= p_76484_3_ + n; i1++) {
/*  58 */         int i2 = i1 - p_76484_3_;
/*  59 */         for (int i3 = p_76484_5_ - n; i3 <= p_76484_5_ + n; i3++) {
/*  60 */           int i4 = i3 - p_76484_5_;
/*  61 */           if ((Math.abs(i2) != n || Math.abs(i4) != n || (p_76484_2_.nextInt(2) != 0 && m != 0)) && 
/*  62 */             !p_76484_1_.func_147439_a(i1, k, i3).func_149730_j()) func_150515_a(p_76484_1_, i1, k, i3, (Block)Blocks.field_150362_t);
/*     */         
/*     */         } 
/*     */       } 
/*     */     } 
/*  67 */     for (k = 0; k < i; k++) {
/*  68 */       Block block1 = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ + k, p_76484_5_);
/*  69 */       if (block1.func_149688_o() == Material.field_151579_a || block1.func_149688_o() == Material.field_151584_j || block1 == Blocks.field_150358_i || block1 == Blocks.field_150355_j) {
/*  70 */         func_150515_a(p_76484_1_, p_76484_3_, p_76484_4_ + k, p_76484_5_, Blocks.field_150364_r);
/*     */       }
/*     */     } 
/*  73 */     for (k = p_76484_4_ - 3 + i; k <= p_76484_4_ + i; k++) {
/*  74 */       int m = k - p_76484_4_ + i;
/*  75 */       int n = 2 - m / 2;
/*  76 */       for (int i1 = p_76484_3_ - n; i1 <= p_76484_3_ + n; i1++) {
/*  77 */         for (int i2 = p_76484_5_ - n; i2 <= p_76484_5_ + n; i2++) {
/*  78 */           if (p_76484_1_.func_147439_a(i1, k, i2).func_149688_o() == Material.field_151584_j) {
/*  79 */             if (p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_147439_a(i1 - 1, k, i2).func_149688_o() == Material.field_151579_a) {
/*  80 */               func_76536_b(p_76484_1_, i1 - 1, k, i2, 8);
/*     */             }
/*  82 */             if (p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_147439_a(i1 + 1, k, i2).func_149688_o() == Material.field_151579_a) {
/*  83 */               func_76536_b(p_76484_1_, i1 + 1, k, i2, 2);
/*     */             }
/*  85 */             if (p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_147439_a(i1, k, i2 - 1).func_149688_o() == Material.field_151579_a) {
/*  86 */               func_76536_b(p_76484_1_, i1, k, i2 - 1, 1);
/*     */             }
/*  88 */             if (p_76484_2_.nextInt(4) == 0 && p_76484_1_.func_147439_a(i1, k, i2 + 1).func_149688_o() == Material.field_151579_a) {
/*  89 */               func_76536_b(p_76484_1_, i1, k, i2 + 1, 4);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*  95 */     return true;
/*     */   }
/*     */   
/*     */   private void func_76536_b(World p_76536_1_, int p_76536_2_, int p_76536_3_, int p_76536_4_, int p_76536_5_) {
/*  99 */     func_150516_a(p_76536_1_, p_76536_2_, p_76536_3_, p_76536_4_, Blocks.field_150395_bd, p_76536_5_);
/* 100 */     byte b = 4;
/* 101 */     while (p_76536_1_.func_147439_a(p_76536_2_, --p_76536_3_, p_76536_4_).func_149688_o() == Material.field_151579_a && b > 0) {
/* 102 */       func_150516_a(p_76536_1_, p_76536_2_, p_76536_3_, p_76536_4_, Blocks.field_150395_bd, p_76536_5_);
/* 103 */       b--;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenSwamp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */