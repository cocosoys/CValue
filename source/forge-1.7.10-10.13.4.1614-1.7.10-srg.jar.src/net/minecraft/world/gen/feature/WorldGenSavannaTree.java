/*     */ package net.minecraft.world.gen.feature;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class WorldGenSavannaTree
/*     */   extends WorldGenAbstractTree
/*     */ {
/*     */   private static final String __OBFID = "CL_00000432";
/*     */   
/*     */   public WorldGenSavannaTree(boolean p_i45463_1_) {
/*  16 */     super(p_i45463_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/*  21 */     int i = p_76484_2_.nextInt(3) + p_76484_2_.nextInt(3) + 5;
/*     */     
/*  23 */     boolean bool = true;
/*  24 */     if (p_76484_4_ < 1 || p_76484_4_ + i + 1 > 256) return false;
/*     */     
/*  26 */     for (int j = p_76484_4_; j <= p_76484_4_ + 1 + i; j++) {
/*  27 */       byte b = 1;
/*  28 */       if (j == p_76484_4_) b = 0; 
/*  29 */       if (j >= p_76484_4_ + 1 + i - 2) b = 2; 
/*  30 */       for (int i5 = p_76484_3_ - b; i5 <= p_76484_3_ + b && bool; i5++) {
/*  31 */         for (int i6 = p_76484_5_ - b; i6 <= p_76484_5_ + b && bool; i6++) {
/*  32 */           if (j >= 0 && j < 256) {
/*  33 */             Block block1 = p_76484_1_.func_147439_a(i5, j, i6);
/*  34 */             if (!func_150523_a(block1)) bool = false; 
/*     */           } else {
/*  36 */             bool = false;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  42 */     if (!bool) return false;
/*     */     
/*  44 */     Block block = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_);
/*  45 */     if ((block != Blocks.field_150349_c && block != Blocks.field_150346_d) || p_76484_4_ >= 256 - i - 1) return false;
/*     */     
/*  47 */     func_150515_a(p_76484_1_, p_76484_3_, p_76484_4_ - 1, p_76484_5_, Blocks.field_150346_d);
/*     */     
/*  49 */     int k = p_76484_2_.nextInt(4);
/*  50 */     int m = i - p_76484_2_.nextInt(4) - 1;
/*  51 */     int n = 3 - p_76484_2_.nextInt(3);
/*     */     
/*  53 */     int i1 = p_76484_3_, i2 = p_76484_5_;
/*  54 */     int i3 = 0; int i4;
/*  55 */     for (i4 = 0; i4 < i; i4++) {
/*  56 */       int i5 = p_76484_4_ + i4;
/*  57 */       if (i4 >= m && n > 0) {
/*  58 */         i1 += Direction.field_71583_a[k];
/*  59 */         i2 += Direction.field_71581_b[k];
/*  60 */         n--;
/*     */       } 
/*  62 */       Block block1 = p_76484_1_.func_147439_a(i1, i5, i2);
/*  63 */       if (block1.func_149688_o() == Material.field_151579_a || block1.func_149688_o() == Material.field_151584_j) {
/*  64 */         func_150516_a(p_76484_1_, i1, i5, i2, Blocks.field_150363_s, 0);
/*  65 */         i3 = i5;
/*     */       } 
/*     */     } 
/*     */     
/*  69 */     for (i4 = -1; i4 <= 1; i4++) {
/*  70 */       for (byte b = -1; b <= 1; b++) {
/*  71 */         func_150525_a(p_76484_1_, i1 + i4, i3 + 1, i2 + b);
/*     */       }
/*     */     } 
/*  74 */     func_150525_a(p_76484_1_, i1 + 2, i3 + 1, i2);
/*  75 */     func_150525_a(p_76484_1_, i1 - 2, i3 + 1, i2);
/*  76 */     func_150525_a(p_76484_1_, i1, i3 + 1, i2 + 2);
/*  77 */     func_150525_a(p_76484_1_, i1, i3 + 1, i2 - 2);
/*  78 */     for (i4 = -3; i4 <= 3; i4++) {
/*  79 */       for (byte b = -3; b <= 3; b++) {
/*  80 */         if (Math.abs(i4) != 3 || Math.abs(b) != 3)
/*     */         {
/*     */           
/*  83 */           func_150525_a(p_76484_1_, i1 + i4, i3, i2 + b);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  89 */     i1 = p_76484_3_;
/*  90 */     i2 = p_76484_5_;
/*  91 */     i4 = p_76484_2_.nextInt(4);
/*  92 */     if (i4 != k) {
/*  93 */       int i5 = m - p_76484_2_.nextInt(2) - 1;
/*  94 */       int i6 = 1 + p_76484_2_.nextInt(3);
/*     */       
/*  96 */       i3 = 0; int i7;
/*  97 */       for (i7 = i5; i7 < i && i6 > 0; i7++, i6--) {
/*  98 */         if (i7 >= 1) {
/*     */ 
/*     */           
/* 101 */           int i8 = p_76484_4_ + i7;
/* 102 */           i1 += Direction.field_71583_a[i4];
/* 103 */           i2 += Direction.field_71581_b[i4];
/* 104 */           Block block1 = p_76484_1_.func_147439_a(i1, i8, i2);
/* 105 */           if (block1.func_149688_o() == Material.field_151579_a || block1.func_149688_o() == Material.field_151584_j) {
/* 106 */             func_150516_a(p_76484_1_, i1, i8, i2, Blocks.field_150363_s, 0);
/* 107 */             i3 = i8;
/*     */           } 
/*     */         } 
/* 110 */       }  if (i3 > 0) {
/* 111 */         for (i7 = -1; i7 <= 1; i7++) {
/* 112 */           for (byte b = -1; b <= 1; b++) {
/* 113 */             func_150525_a(p_76484_1_, i1 + i7, i3 + 1, i2 + b);
/*     */           }
/*     */         } 
/* 116 */         for (i7 = -2; i7 <= 2; i7++) {
/* 117 */           for (byte b = -2; b <= 2; b++) {
/* 118 */             if (Math.abs(i7) != 2 || Math.abs(b) != 2)
/*     */             {
/*     */               
/* 121 */               func_150525_a(p_76484_1_, i1 + i7, i3, i2 + b);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/* 127 */     return true;
/*     */   }
/*     */   
/*     */   private void func_150525_a(World p_150525_1_, int p_150525_2_, int p_150525_3_, int p_150525_4_) {
/* 131 */     Block block = p_150525_1_.func_147439_a(p_150525_2_, p_150525_3_, p_150525_4_);
/* 132 */     if (block.func_149688_o() == Material.field_151579_a || block.func_149688_o() == Material.field_151584_j) func_150516_a(p_150525_1_, p_150525_2_, p_150525_3_, p_150525_4_, (Block)Blocks.field_150361_u, 0); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenSavannaTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */