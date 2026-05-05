/*     */ package net.minecraft.world.gen;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MapGenRavine
/*     */   extends MapGenBase {
/*  11 */   private float[] field_75046_d = new float[1024];
/*     */   private static final String __OBFID = "CL_00000390";
/*     */   
/*  14 */   protected void func_151540_a(long p_151540_1_, int p_151540_3_, int p_151540_4_, Block[] p_151540_5_, double p_151540_6_, double p_151540_8_, double p_151540_10_, float p_151540_12_, float p_151540_13_, float p_151540_14_, int p_151540_15_, int p_151540_16_, double p_151540_17_) { Random random = new Random(p_151540_1_);
/*     */     
/*  16 */     double d1 = (p_151540_3_ * 16 + 8);
/*  17 */     double d2 = (p_151540_4_ * 16 + 8);
/*     */     
/*  19 */     float f1 = 0.0F;
/*  20 */     float f2 = 0.0F;
/*     */     
/*  22 */     if (p_151540_16_ <= 0) {
/*  23 */       int i = this.field_75040_a * 16 - 16;
/*  24 */       p_151540_16_ = i - random.nextInt(i / 4);
/*     */     } 
/*  26 */     boolean bool = false;
/*     */     
/*  28 */     if (p_151540_15_ == -1) {
/*  29 */       p_151540_15_ = p_151540_16_ / 2;
/*  30 */       bool = true;
/*     */     } 
/*     */     
/*  33 */     float f3 = 1.0F;
/*  34 */     for (byte b = 0; b < 'Ā'; b++) {
/*  35 */       if (b == 0 || random.nextInt(3) == 0) {
/*  36 */         f3 = 1.0F + random.nextFloat() * random.nextFloat() * 1.0F;
/*     */       }
/*  38 */       this.field_75046_d[b] = f3 * f3;
/*     */     } 
/*     */     
/*  41 */     for (; p_151540_15_ < p_151540_16_; p_151540_15_++) {
/*  42 */       double d3 = 1.5D + (MathHelper.func_76126_a(p_151540_15_ * 3.1415927F / p_151540_16_) * p_151540_12_ * 1.0F);
/*  43 */       double d4 = d3 * p_151540_17_;
/*     */       
/*  45 */       d3 *= random.nextFloat() * 0.25D + 0.75D;
/*  46 */       d4 *= random.nextFloat() * 0.25D + 0.75D;
/*     */       
/*  48 */       float f4 = MathHelper.func_76134_b(p_151540_14_);
/*  49 */       float f5 = MathHelper.func_76126_a(p_151540_14_);
/*  50 */       p_151540_6_ += (MathHelper.func_76134_b(p_151540_13_) * f4);
/*  51 */       p_151540_8_ += f5;
/*  52 */       p_151540_10_ += (MathHelper.func_76126_a(p_151540_13_) * f4);
/*     */       
/*  54 */       p_151540_14_ *= 0.7F;
/*     */       
/*  56 */       p_151540_14_ += f2 * 0.05F;
/*  57 */       p_151540_13_ += f1 * 0.05F;
/*     */       
/*  59 */       f2 *= 0.8F;
/*  60 */       f1 *= 0.5F;
/*  61 */       f2 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
/*  62 */       f1 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;
/*     */       
/*  64 */       if (bool || random.nextInt(4) != 0) {
/*     */ 
/*     */         
/*  67 */         double d5 = p_151540_6_ - d1;
/*  68 */         double d6 = p_151540_10_ - d2;
/*  69 */         double d7 = (p_151540_16_ - p_151540_15_);
/*  70 */         double d8 = (p_151540_12_ + 2.0F + 16.0F);
/*  71 */         if (d5 * d5 + d6 * d6 - d7 * d7 > d8 * d8) {
/*     */           return;
/*     */         }
/*     */ 
/*     */         
/*  76 */         if (p_151540_6_ >= d1 - 16.0D - d3 * 2.0D && p_151540_10_ >= d2 - 16.0D - d3 * 2.0D && p_151540_6_ <= d1 + 16.0D + d3 * 2.0D && p_151540_10_ <= d2 + 16.0D + d3 * 2.0D) {
/*     */ 
/*     */           
/*  79 */           int i = MathHelper.func_76128_c(p_151540_6_ - d3) - p_151540_3_ * 16 - 1;
/*  80 */           int j = MathHelper.func_76128_c(p_151540_6_ + d3) - p_151540_3_ * 16 + 1;
/*     */           
/*  82 */           int k = MathHelper.func_76128_c(p_151540_8_ - d4) - 1;
/*  83 */           int m = MathHelper.func_76128_c(p_151540_8_ + d4) + 1;
/*     */           
/*  85 */           int n = MathHelper.func_76128_c(p_151540_10_ - d3) - p_151540_4_ * 16 - 1;
/*  86 */           int i1 = MathHelper.func_76128_c(p_151540_10_ + d3) - p_151540_4_ * 16 + 1;
/*     */           
/*  88 */           if (i < 0) i = 0; 
/*  89 */           if (j > 16) j = 16;
/*     */           
/*  91 */           if (k < 1) k = 1; 
/*  92 */           if (m > 248) m = 248;
/*     */           
/*  94 */           if (n < 0) n = 0; 
/*  95 */           if (i1 > 16) i1 = 16;
/*     */           
/*  97 */           boolean bool1 = false; int i2;
/*  98 */           for (i2 = i; !bool1 && i2 < j; i2++) {
/*  99 */             for (int i3 = n; !bool1 && i3 < i1; i3++) {
/* 100 */               for (int i4 = m + 1; !bool1 && i4 >= k - 1; i4--) {
/* 101 */                 int i5 = (i2 * 16 + i3) * 256 + i4;
/* 102 */                 if (i4 >= 0 && i4 < 256) {
/*     */                   
/* 104 */                   Block block = p_151540_5_[i5];
/* 105 */                   if (block == Blocks.field_150358_i || block == Blocks.field_150355_j) {
/* 106 */                     bool1 = true;
/*     */                   }
/* 108 */                   if (i4 != k - 1 && i2 != i && i2 != j - 1 && i3 != n && i3 != i1 - 1)
/* 109 */                     i4 = k; 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/* 114 */           if (!bool1) {
/*     */             
/* 116 */             for (i2 = i; i2 < j; i2++) {
/* 117 */               double d = ((i2 + p_151540_3_ * 16) + 0.5D - p_151540_6_) / d3;
/* 118 */               for (int i3 = n; i3 < i1; i3++) {
/* 119 */                 double d9 = ((i3 + p_151540_4_ * 16) + 0.5D - p_151540_10_) / d3;
/* 120 */                 int i4 = (i2 * 16 + i3) * 256 + m;
/* 121 */                 boolean bool2 = false;
/* 122 */                 if (d * d + d9 * d9 < 1.0D) {
/* 123 */                   for (int i5 = m - 1; i5 >= k; i5--) {
/* 124 */                     double d10 = (i5 + 0.5D - p_151540_8_) / d4;
/* 125 */                     if ((d * d + d9 * d9) * this.field_75046_d[i5] + d10 * d10 / 6.0D < 1.0D) {
/* 126 */                       Block block = p_151540_5_[i4];
/* 127 */                       if (block == Blocks.field_150349_c) bool2 = true; 
/* 128 */                       if (block == Blocks.field_150348_b || block == Blocks.field_150346_d || block == Blocks.field_150349_c)
/* 129 */                         if (i5 < 10) {
/* 130 */                           p_151540_5_[i4] = (Block)Blocks.field_150356_k;
/*     */                         } else {
/* 132 */                           p_151540_5_[i4] = null;
/* 133 */                           if (bool2 && p_151540_5_[i4 - 1] == Blocks.field_150346_d) {
/* 134 */                             p_151540_5_[i4 - 1] = (this.field_75039_c.func_72807_a(i2 + p_151540_3_ * 16, i3 + p_151540_4_ * 16)).field_76752_A;
/*     */                           }
/*     */                         }  
/*     */                     } 
/* 138 */                     i4--;
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */             } 
/* 143 */             if (bool)
/*     */               break; 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }  } protected void func_151538_a(World p_151538_1_, int p_151538_2_, int p_151538_3_, int p_151538_4_, int p_151538_5_, Block[] p_151538_6_) {
/* 149 */     if (this.field_75038_b.nextInt(50) != 0)
/* 150 */       return;  double d1 = (p_151538_2_ * 16 + this.field_75038_b.nextInt(16));
/* 151 */     double d2 = (this.field_75038_b.nextInt(this.field_75038_b.nextInt(40) + 8) + 20);
/* 152 */     double d3 = (p_151538_3_ * 16 + this.field_75038_b.nextInt(16));
/*     */     
/* 154 */     byte b1 = 1;
/*     */     
/* 156 */     for (byte b2 = 0; b2 < b1; b2++) {
/*     */       
/* 158 */       float f1 = this.field_75038_b.nextFloat() * 3.1415927F * 2.0F;
/* 159 */       float f2 = (this.field_75038_b.nextFloat() - 0.5F) * 2.0F / 8.0F;
/* 160 */       float f3 = (this.field_75038_b.nextFloat() * 2.0F + this.field_75038_b.nextFloat()) * 2.0F;
/*     */       
/* 162 */       func_151540_a(this.field_75038_b.nextLong(), p_151538_4_, p_151538_5_, p_151538_6_, d1, d2, d3, f3, f1, f2, 0, 0, 3.0D);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\MapGenRavine.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */