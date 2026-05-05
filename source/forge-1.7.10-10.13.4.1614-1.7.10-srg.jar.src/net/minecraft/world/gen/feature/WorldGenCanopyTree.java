/*     */ package net.minecraft.world.gen.feature;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.Direction;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class WorldGenCanopyTree
/*     */   extends WorldGenAbstractTree
/*     */ {
/*     */   private static final String __OBFID = "CL_00000430";
/*     */   
/*     */   public WorldGenCanopyTree(boolean p_i45461_1_) {
/*  16 */     super(p_i45461_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/*  21 */     int i = p_76484_2_.nextInt(3) + p_76484_2_.nextInt(2) + 6;
/*     */     
/*  23 */     boolean bool = true;
/*  24 */     if (p_76484_4_ < 1 || p_76484_4_ + i + 1 > 256) return false;
/*     */     
/*  26 */     for (int j = p_76484_4_; j <= p_76484_4_ + 1 + i; j++) {
/*  27 */       byte b1 = 1;
/*  28 */       if (j == p_76484_4_) b1 = 0; 
/*  29 */       if (j >= p_76484_4_ + 1 + i - 2) b1 = 2; 
/*  30 */       for (int i4 = p_76484_3_ - b1; i4 <= p_76484_3_ + b1 && bool; i4++) {
/*  31 */         for (int i5 = p_76484_5_ - b1; i5 <= p_76484_5_ + b1 && bool; i5++) {
/*  32 */           if (j >= 0 && j < 256) {
/*  33 */             Block block1 = p_76484_1_.func_147439_a(i4, j, i5);
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
/*  48 */     func_150515_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ - 1, p_76484_5_, Blocks.field_150346_d);
/*  49 */     func_150515_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ - 1, p_76484_5_ + 1, Blocks.field_150346_d);
/*  50 */     func_150515_a(p_76484_1_, p_76484_3_, p_76484_4_ - 1, p_76484_5_ + 1, Blocks.field_150346_d);
/*     */     
/*  52 */     int k = p_76484_2_.nextInt(4);
/*  53 */     int m = i - p_76484_2_.nextInt(4);
/*  54 */     int n = 2 - p_76484_2_.nextInt(3);
/*     */     
/*  56 */     int i1 = p_76484_3_, i2 = p_76484_5_;
/*  57 */     int i3 = 0; byte b;
/*  58 */     for (b = 0; b < i; b++) {
/*  59 */       int i4 = p_76484_4_ + b;
/*  60 */       if (b >= m && n > 0) {
/*  61 */         i1 += Direction.field_71583_a[k];
/*  62 */         i2 += Direction.field_71581_b[k];
/*  63 */         n--;
/*     */       } 
/*  65 */       Block block1 = p_76484_1_.func_147439_a(i1, i4, i2);
/*  66 */       if (block1.func_149688_o() == Material.field_151579_a || block1.func_149688_o() == Material.field_151584_j) {
/*  67 */         func_150516_a(p_76484_1_, i1, i4, i2, Blocks.field_150363_s, 1);
/*  68 */         func_150516_a(p_76484_1_, i1 + 1, i4, i2, Blocks.field_150363_s, 1);
/*  69 */         func_150516_a(p_76484_1_, i1, i4, i2 + 1, Blocks.field_150363_s, 1);
/*  70 */         func_150516_a(p_76484_1_, i1 + 1, i4, i2 + 1, Blocks.field_150363_s, 1);
/*  71 */         i3 = i4;
/*     */       } 
/*     */     } 
/*     */     
/*  75 */     for (b = -2; b <= 0; b++) {
/*  76 */       for (byte b1 = -2; b1 <= 0; b1++) {
/*  77 */         byte b2 = -1;
/*  78 */         func_150526_a(p_76484_1_, i1 + b, i3 + b2, i2 + b1);
/*  79 */         func_150526_a(p_76484_1_, 1 + i1 - b, i3 + b2, i2 + b1);
/*  80 */         func_150526_a(p_76484_1_, i1 + b, i3 + b2, 1 + i2 - b1);
/*  81 */         func_150526_a(p_76484_1_, 1 + i1 - b, i3 + b2, 1 + i2 - b1);
/*  82 */         if ((b > -2 || b1 > -1) && (b != -1 || b1 != -2)) {
/*     */ 
/*     */           
/*  85 */           b2 = 1;
/*  86 */           func_150526_a(p_76484_1_, i1 + b, i3 + b2, i2 + b1);
/*  87 */           func_150526_a(p_76484_1_, 1 + i1 - b, i3 + b2, i2 + b1);
/*  88 */           func_150526_a(p_76484_1_, i1 + b, i3 + b2, 1 + i2 - b1);
/*  89 */           func_150526_a(p_76484_1_, 1 + i1 - b, i3 + b2, 1 + i2 - b1);
/*     */         } 
/*     */       } 
/*  92 */     }  if (p_76484_2_.nextBoolean()) {
/*  93 */       func_150526_a(p_76484_1_, i1, i3 + 2, i2);
/*  94 */       func_150526_a(p_76484_1_, i1 + 1, i3 + 2, i2);
/*  95 */       func_150526_a(p_76484_1_, i1 + 1, i3 + 2, i2 + 1);
/*  96 */       func_150526_a(p_76484_1_, i1, i3 + 2, i2 + 1);
/*     */     } 
/*  98 */     for (b = -3; b <= 4; b++) {
/*  99 */       for (byte b1 = -3; b1 <= 4; b1++) {
/* 100 */         if ((b != -3 || b1 != -3) && (b != -3 || b1 != 4) && (b != 4 || b1 != -3) && (b != 4 || b1 != 4))
/*     */         {
/*     */           
/* 103 */           if (Math.abs(b) < 3 || Math.abs(b1) < 3)
/*     */           {
/*     */             
/* 106 */             func_150526_a(p_76484_1_, i1 + b, i3, i2 + b1);
/*     */           }
/*     */         }
/*     */       } 
/*     */     } 
/* 111 */     for (b = -1; b <= 2; b++) {
/* 112 */       for (byte b1 = -1; b1 <= 2; b1++) {
/* 113 */         if (b < 0 || b > 1 || b1 < 0 || b1 > 1)
/*     */         {
/*     */           
/* 116 */           if (p_76484_2_.nextInt(3) <= 0) {
/*     */ 
/*     */             
/* 119 */             int i4 = p_76484_2_.nextInt(3) + 2; byte b2;
/* 120 */             for (b2 = 0; b2 < i4; b2++) {
/* 121 */               func_150516_a(p_76484_1_, p_76484_3_ + b, i3 - b2 - 1, p_76484_5_ + b1, Blocks.field_150363_s, 1);
/*     */             }
/* 123 */             for (b2 = -1; b2 <= 1; b2++) {
/* 124 */               for (byte b3 = -1; b3 <= 1; b3++) {
/* 125 */                 func_150526_a(p_76484_1_, i1 + b + b2, i3 - 0, i2 + b1 + b3);
/*     */               }
/*     */             } 
/* 128 */             for (b2 = -2; b2 <= 2; b2++) {
/* 129 */               for (byte b3 = -2; b3 <= 2; b3++) {
/* 130 */                 if (Math.abs(b2) != 2 || Math.abs(b3) != 2)
/*     */                 {
/*     */                   
/* 133 */                   func_150526_a(p_76484_1_, i1 + b + b2, i3 - 1, i2 + b1 + b3);
/*     */                 }
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/* 141 */     return true;
/*     */   }
/*     */   
/*     */   private void func_150526_a(World p_150526_1_, int p_150526_2_, int p_150526_3_, int p_150526_4_) {
/* 145 */     Block block = p_150526_1_.func_147439_a(p_150526_2_, p_150526_3_, p_150526_4_);
/* 146 */     if (block.func_149688_o() == Material.field_151579_a) func_150516_a(p_150526_1_, p_150526_2_, p_150526_3_, p_150526_4_, (Block)Blocks.field_150361_u, 1); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenCanopyTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */