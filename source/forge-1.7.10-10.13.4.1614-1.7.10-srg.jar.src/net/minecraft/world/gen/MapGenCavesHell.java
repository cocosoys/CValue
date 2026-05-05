/*     */ package net.minecraft.world.gen;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MapGenCavesHell extends MapGenBase {
/*     */   private static final String __OBFID = "CL_00000395";
/*     */   
/*     */   protected void func_151544_a(long p_151544_1_, int p_151544_3_, int p_151544_4_, Block[] p_151544_5_, double p_151544_6_, double p_151544_8_, double p_151544_10_) {
/*  13 */     func_151543_a(p_151544_1_, p_151544_3_, p_151544_4_, p_151544_5_, p_151544_6_, p_151544_8_, p_151544_10_, 1.0F + this.field_75038_b.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
/*     */   }
/*     */   
/*     */   protected void func_151543_a(long p_151543_1_, int p_151543_3_, int p_151543_4_, Block[] p_151543_5_, double p_151543_6_, double p_151543_8_, double p_151543_10_, float p_151543_12_, float p_151543_13_, float p_151543_14_, int p_151543_15_, int p_151543_16_, double p_151543_17_) {
/*  17 */     double d1 = (p_151543_3_ * 16 + 8);
/*  18 */     double d2 = (p_151543_4_ * 16 + 8);
/*     */     
/*  20 */     float f1 = 0.0F;
/*  21 */     float f2 = 0.0F;
/*  22 */     Random random = new Random(p_151543_1_);
/*     */     
/*  24 */     if (p_151543_16_ <= 0) {
/*  25 */       int j = this.field_75040_a * 16 - 16;
/*  26 */       p_151543_16_ = j - random.nextInt(j / 4);
/*     */     } 
/*  28 */     boolean bool1 = false;
/*     */     
/*  30 */     if (p_151543_15_ == -1) {
/*  31 */       p_151543_15_ = p_151543_16_ / 2;
/*  32 */       bool1 = true;
/*     */     } 
/*     */     
/*  35 */     int i = random.nextInt(p_151543_16_ / 2) + p_151543_16_ / 4;
/*  36 */     boolean bool2 = (random.nextInt(6) == 0) ? true : false;
/*     */     
/*  38 */     for (; p_151543_15_ < p_151543_16_; p_151543_15_++) {
/*  39 */       double d3 = 1.5D + (MathHelper.func_76126_a(p_151543_15_ * 3.1415927F / p_151543_16_) * p_151543_12_ * 1.0F);
/*  40 */       double d4 = d3 * p_151543_17_;
/*     */       
/*  42 */       float f3 = MathHelper.func_76134_b(p_151543_14_);
/*  43 */       float f4 = MathHelper.func_76126_a(p_151543_14_);
/*  44 */       p_151543_6_ += (MathHelper.func_76134_b(p_151543_13_) * f3);
/*  45 */       p_151543_8_ += f4;
/*  46 */       p_151543_10_ += (MathHelper.func_76126_a(p_151543_13_) * f3);
/*     */       
/*  48 */       if (bool2) {
/*  49 */         p_151543_14_ *= 0.92F;
/*     */       } else {
/*  51 */         p_151543_14_ *= 0.7F;
/*     */       } 
/*  53 */       p_151543_14_ += f2 * 0.1F;
/*  54 */       p_151543_13_ += f1 * 0.1F;
/*     */       
/*  56 */       f2 *= 0.9F;
/*  57 */       f1 *= 0.75F;
/*  58 */       f2 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
/*  59 */       f1 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;
/*     */       
/*  61 */       if (!bool1 && p_151543_15_ == i && p_151543_12_ > 1.0F) {
/*  62 */         func_151543_a(random.nextLong(), p_151543_3_, p_151543_4_, p_151543_5_, p_151543_6_, p_151543_8_, p_151543_10_, random.nextFloat() * 0.5F + 0.5F, p_151543_13_ - 1.5707964F, p_151543_14_ / 3.0F, p_151543_15_, p_151543_16_, 1.0D);
/*  63 */         func_151543_a(random.nextLong(), p_151543_3_, p_151543_4_, p_151543_5_, p_151543_6_, p_151543_8_, p_151543_10_, random.nextFloat() * 0.5F + 0.5F, p_151543_13_ + 1.5707964F, p_151543_14_ / 3.0F, p_151543_15_, p_151543_16_, 1.0D);
/*     */         return;
/*     */       } 
/*  66 */       if (bool1 || random.nextInt(4) != 0) {
/*     */ 
/*     */         
/*  69 */         double d5 = p_151543_6_ - d1;
/*  70 */         double d6 = p_151543_10_ - d2;
/*  71 */         double d7 = (p_151543_16_ - p_151543_15_);
/*  72 */         double d8 = (p_151543_12_ + 2.0F + 16.0F);
/*  73 */         if (d5 * d5 + d6 * d6 - d7 * d7 > d8 * d8) {
/*     */           return;
/*     */         }
/*     */ 
/*     */         
/*  78 */         if (p_151543_6_ >= d1 - 16.0D - d3 * 2.0D && p_151543_10_ >= d2 - 16.0D - d3 * 2.0D && p_151543_6_ <= d1 + 16.0D + d3 * 2.0D && p_151543_10_ <= d2 + 16.0D + d3 * 2.0D) {
/*     */           
/*  80 */           int j = MathHelper.func_76128_c(p_151543_6_ - d3) - p_151543_3_ * 16 - 1;
/*  81 */           int k = MathHelper.func_76128_c(p_151543_6_ + d3) - p_151543_3_ * 16 + 1;
/*     */           
/*  83 */           int m = MathHelper.func_76128_c(p_151543_8_ - d4) - 1;
/*  84 */           int n = MathHelper.func_76128_c(p_151543_8_ + d4) + 1;
/*     */           
/*  86 */           int i1 = MathHelper.func_76128_c(p_151543_10_ - d3) - p_151543_4_ * 16 - 1;
/*  87 */           int i2 = MathHelper.func_76128_c(p_151543_10_ + d3) - p_151543_4_ * 16 + 1;
/*     */           
/*  89 */           if (j < 0) j = 0; 
/*  90 */           if (k > 16) k = 16;
/*     */           
/*  92 */           if (m < 1) m = 1; 
/*  93 */           if (n > 120) n = 120;
/*     */           
/*  95 */           if (i1 < 0) i1 = 0; 
/*  96 */           if (i2 > 16) i2 = 16;
/*     */           
/*  98 */           boolean bool = false; int i3;
/*  99 */           for (i3 = j; !bool && i3 < k; i3++) {
/* 100 */             for (int i4 = i1; !bool && i4 < i2; i4++) {
/* 101 */               for (int i5 = n + 1; !bool && i5 >= m - 1; i5--) {
/* 102 */                 int i6 = (i3 * 16 + i4) * 128 + i5;
/* 103 */                 if (i5 >= 0 && i5 < 128) {
/*     */                   
/* 105 */                   Block block = p_151543_5_[i6];
/* 106 */                   if (block == Blocks.field_150356_k || block == Blocks.field_150353_l) {
/* 107 */                     bool = true;
/*     */                   }
/* 109 */                   if (i5 != m - 1 && i3 != j && i3 != k - 1 && i4 != i1 && i4 != i2 - 1)
/* 110 */                     i5 = m; 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/* 115 */           if (!bool) {
/*     */             
/* 117 */             for (i3 = j; i3 < k; i3++) {
/* 118 */               double d = ((i3 + p_151543_3_ * 16) + 0.5D - p_151543_6_) / d3;
/* 119 */               for (int i4 = i1; i4 < i2; i4++) {
/* 120 */                 double d9 = ((i4 + p_151543_4_ * 16) + 0.5D - p_151543_10_) / d3;
/* 121 */                 int i5 = (i3 * 16 + i4) * 128 + n;
/* 122 */                 for (int i6 = n - 1; i6 >= m; i6--) {
/* 123 */                   double d10 = (i6 + 0.5D - p_151543_8_) / d4;
/* 124 */                   if (d10 > -0.7D && d * d + d10 * d10 + d9 * d9 < 1.0D) {
/* 125 */                     Block block = p_151543_5_[i5];
/* 126 */                     if (block == Blocks.field_150424_aL || block == Blocks.field_150346_d || block == Blocks.field_150349_c) {
/* 127 */                       p_151543_5_[i5] = null;
/*     */                     }
/*     */                   } 
/* 130 */                   i5--;
/*     */                 } 
/*     */               } 
/*     */             } 
/* 134 */             if (bool1)
/*     */               break; 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }  } protected void func_151538_a(World p_151538_1_, int p_151538_2_, int p_151538_3_, int p_151538_4_, int p_151538_5_, Block[] p_151538_6_) {
/* 140 */     int i = this.field_75038_b.nextInt(this.field_75038_b.nextInt(this.field_75038_b.nextInt(10) + 1) + 1);
/* 141 */     if (this.field_75038_b.nextInt(5) != 0) i = 0;
/*     */     
/* 143 */     for (byte b = 0; b < i; b++) {
/* 144 */       double d1 = (p_151538_2_ * 16 + this.field_75038_b.nextInt(16));
/* 145 */       double d2 = this.field_75038_b.nextInt(128);
/* 146 */       double d3 = (p_151538_3_ * 16 + this.field_75038_b.nextInt(16));
/*     */       
/* 148 */       int j = 1;
/* 149 */       if (this.field_75038_b.nextInt(4) == 0) {
/* 150 */         func_151544_a(this.field_75038_b.nextLong(), p_151538_4_, p_151538_5_, p_151538_6_, d1, d2, d3);
/* 151 */         j += this.field_75038_b.nextInt(4);
/*     */       } 
/*     */       
/* 154 */       for (byte b1 = 0; b1 < j; b1++) {
/*     */         
/* 156 */         float f1 = this.field_75038_b.nextFloat() * 3.1415927F * 2.0F;
/* 157 */         float f2 = (this.field_75038_b.nextFloat() - 0.5F) * 2.0F / 8.0F;
/* 158 */         float f3 = this.field_75038_b.nextFloat() * 2.0F + this.field_75038_b.nextFloat();
/*     */         
/* 160 */         func_151543_a(this.field_75038_b.nextLong(), p_151538_4_, p_151538_5_, p_151538_6_, d1, d2, d3, f3 * 2.0F, f1, f2, 0, 0, 0.5D);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\MapGenCavesHell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */