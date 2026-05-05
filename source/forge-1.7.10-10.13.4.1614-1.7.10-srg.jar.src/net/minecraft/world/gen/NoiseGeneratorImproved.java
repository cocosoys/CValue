/*     */ package net.minecraft.world.gen;
/*     */ 
/*     */ import java.util.Random;
/*     */ 
/*     */ public class NoiseGeneratorImproved extends NoiseGenerator {
/*   6 */   private int[] field_76312_d = new int[512];
/*     */   public double field_76315_a;
/*     */   public double field_76313_b;
/*     */   public double field_76314_c;
/*     */   
/*     */   public NoiseGeneratorImproved() {
/*  12 */     this(new Random());
/*     */   }
/*     */   
/*     */   public NoiseGeneratorImproved(Random p_i45469_1_) {
/*  16 */     this.field_76315_a = p_i45469_1_.nextDouble() * 256.0D;
/*  17 */     this.field_76313_b = p_i45469_1_.nextDouble() * 256.0D;
/*  18 */     this.field_76314_c = p_i45469_1_.nextDouble() * 256.0D; byte b;
/*  19 */     for (b = 0; b < 'Ā'; b++) {
/*  20 */       this.field_76312_d[b] = b;
/*     */     }
/*     */     
/*  23 */     for (b = 0; b < 'Ā'; b++) {
/*  24 */       int i = p_i45469_1_.nextInt(256 - b) + b;
/*  25 */       int j = this.field_76312_d[b];
/*  26 */       this.field_76312_d[b] = this.field_76312_d[i];
/*  27 */       this.field_76312_d[i] = j;
/*     */       
/*  29 */       this.field_76312_d[b + 256] = this.field_76312_d[b];
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final double func_76311_b(double p_76311_1_, double p_76311_3_, double p_76311_5_) {
/*  71 */     return p_76311_3_ + p_76311_1_ * (p_76311_5_ - p_76311_3_);
/*     */   }
/*     */   
/*  74 */   private static final double[] field_152381_e = new double[] { 1.0D, -1.0D, 1.0D, -1.0D, 1.0D, -1.0D, 1.0D, -1.0D, 0.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, -1.0D, 0.0D };
/*  75 */   private static final double[] field_152382_f = new double[] { 1.0D, 1.0D, -1.0D, -1.0D, 0.0D, 0.0D, 0.0D, 0.0D, 1.0D, -1.0D, 1.0D, -1.0D, 1.0D, -1.0D, 1.0D, -1.0D };
/*  76 */   private static final double[] field_152383_g = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 1.0D, 1.0D, -1.0D, -1.0D, 1.0D, 1.0D, -1.0D, -1.0D, 0.0D, 1.0D, 0.0D, -1.0D };
/*  77 */   private static final double[] field_152384_h = new double[] { 1.0D, -1.0D, 1.0D, -1.0D, 1.0D, -1.0D, 1.0D, -1.0D, 0.0D, 0.0D, 0.0D, 0.0D, 1.0D, 0.0D, -1.0D, 0.0D };
/*  78 */   private static final double[] field_152385_i = new double[] { 0.0D, 0.0D, 0.0D, 0.0D, 1.0D, 1.0D, -1.0D, -1.0D, 1.0D, 1.0D, -1.0D, -1.0D, 0.0D, 1.0D, 0.0D, -1.0D }; private static final String __OBFID = "CL_00000534";
/*     */   
/*     */   public final double func_76309_a(int p_76309_1_, double p_76309_2_, double p_76309_4_) {
/*  81 */     int i = p_76309_1_ & 0xF;
/*  82 */     return field_152384_h[i] * p_76309_2_ + field_152385_i[i] * p_76309_4_;
/*     */   }
/*     */   
/*     */   public final double func_76310_a(int p_76310_1_, double p_76310_2_, double p_76310_4_, double p_76310_6_) {
/*  86 */     int i = p_76310_1_ & 0xF;
/*  87 */     return field_152381_e[i] * p_76310_2_ + field_152382_f[i] * p_76310_4_ + field_152383_g[i] * p_76310_6_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76308_a(double[] p_76308_1_, double p_76308_2_, double p_76308_4_, double p_76308_6_, int p_76308_8_, int p_76308_9_, int p_76308_10_, double p_76308_11_, double p_76308_13_, double p_76308_15_, double p_76308_17_) {
/* 100 */     if (p_76308_9_ == 1) {
/* 101 */       int i3 = 0, i4 = 0, i5 = 0, i6 = 0;
/* 102 */       double d6 = 0.0D, d7 = 0.0D;
/* 103 */       byte b3 = 0;
/* 104 */       double d8 = 1.0D / p_76308_17_;
/* 105 */       for (byte b4 = 0; b4 < p_76308_8_; b4++) {
/* 106 */         double d9 = p_76308_2_ + b4 * p_76308_11_ + this.field_76315_a;
/* 107 */         int i7 = (int)d9;
/* 108 */         if (d9 < i7) i7--; 
/* 109 */         int i8 = i7 & 0xFF;
/* 110 */         d9 -= i7;
/* 111 */         double d10 = d9 * d9 * d9 * (d9 * (d9 * 6.0D - 15.0D) + 10.0D);
/*     */         
/* 113 */         for (byte b = 0; b < p_76308_10_; b++) {
/* 114 */           double d11 = p_76308_6_ + b * p_76308_15_ + this.field_76314_c;
/* 115 */           int i9 = (int)d11;
/* 116 */           if (d11 < i9) i9--; 
/* 117 */           int i10 = i9 & 0xFF;
/* 118 */           d11 -= i9;
/* 119 */           double d12 = d11 * d11 * d11 * (d11 * (d11 * 6.0D - 15.0D) + 10.0D);
/*     */           
/* 121 */           i3 = this.field_76312_d[i8] + 0;
/* 122 */           i4 = this.field_76312_d[i3] + i10;
/* 123 */           i5 = this.field_76312_d[i8 + 1] + 0;
/* 124 */           i6 = this.field_76312_d[i5] + i10;
/* 125 */           d6 = func_76311_b(d10, func_76309_a(this.field_76312_d[i4], d9, d11), func_76310_a(this.field_76312_d[i6], d9 - 1.0D, 0.0D, d11));
/* 126 */           d7 = func_76311_b(d10, func_76310_a(this.field_76312_d[i4 + 1], d9, 0.0D, d11 - 1.0D), func_76310_a(this.field_76312_d[i6 + 1], d9 - 1.0D, 0.0D, d11 - 1.0D));
/*     */           
/* 128 */           double d13 = func_76311_b(d12, d6, d7);
/*     */           
/* 130 */           p_76308_1_[b3++] = p_76308_1_[b3++] + d13 * d8;
/*     */         } 
/*     */       } 
/*     */       return;
/*     */     } 
/* 135 */     byte b1 = 0;
/* 136 */     double d1 = 1.0D / p_76308_17_;
/* 137 */     int i = -1;
/* 138 */     int j = 0, k = 0, m = 0, n = 0, i1 = 0, i2 = 0;
/* 139 */     double d2 = 0.0D, d3 = 0.0D, d4 = 0.0D, d5 = 0.0D;
/*     */     
/* 141 */     for (byte b2 = 0; b2 < p_76308_8_; b2++) {
/* 142 */       double d6 = p_76308_2_ + b2 * p_76308_11_ + this.field_76315_a;
/* 143 */       int i3 = (int)d6;
/* 144 */       if (d6 < i3) i3--; 
/* 145 */       int i4 = i3 & 0xFF;
/* 146 */       d6 -= i3;
/* 147 */       double d7 = d6 * d6 * d6 * (d6 * (d6 * 6.0D - 15.0D) + 10.0D);
/*     */       
/* 149 */       for (byte b = 0; b < p_76308_10_; b++) {
/* 150 */         double d8 = p_76308_6_ + b * p_76308_15_ + this.field_76314_c;
/* 151 */         int i5 = (int)d8;
/* 152 */         if (d8 < i5) i5--; 
/* 153 */         int i6 = i5 & 0xFF;
/* 154 */         d8 -= i5;
/* 155 */         double d9 = d8 * d8 * d8 * (d8 * (d8 * 6.0D - 15.0D) + 10.0D);
/*     */         
/* 157 */         for (byte b3 = 0; b3 < p_76308_9_; b3++) {
/* 158 */           double d10 = p_76308_4_ + b3 * p_76308_13_ + this.field_76313_b;
/* 159 */           int i7 = (int)d10;
/* 160 */           if (d10 < i7) i7--; 
/* 161 */           int i8 = i7 & 0xFF;
/* 162 */           d10 -= i7;
/* 163 */           double d11 = d10 * d10 * d10 * (d10 * (d10 * 6.0D - 15.0D) + 10.0D);
/*     */           
/* 165 */           if (b3 == 0 || i8 != i) {
/* 166 */             i = i8;
/* 167 */             j = this.field_76312_d[i4] + i8;
/* 168 */             k = this.field_76312_d[j] + i6;
/* 169 */             m = this.field_76312_d[j + 1] + i6;
/* 170 */             n = this.field_76312_d[i4 + 1] + i8;
/* 171 */             i1 = this.field_76312_d[n] + i6;
/* 172 */             i2 = this.field_76312_d[n + 1] + i6;
/* 173 */             d2 = func_76311_b(d7, func_76310_a(this.field_76312_d[k], d6, d10, d8), func_76310_a(this.field_76312_d[i1], d6 - 1.0D, d10, d8));
/* 174 */             d3 = func_76311_b(d7, func_76310_a(this.field_76312_d[m], d6, d10 - 1.0D, d8), func_76310_a(this.field_76312_d[i2], d6 - 1.0D, d10 - 1.0D, d8));
/* 175 */             d4 = func_76311_b(d7, func_76310_a(this.field_76312_d[k + 1], d6, d10, d8 - 1.0D), func_76310_a(this.field_76312_d[i1 + 1], d6 - 1.0D, d10, d8 - 1.0D));
/* 176 */             d5 = func_76311_b(d7, func_76310_a(this.field_76312_d[m + 1], d6, d10 - 1.0D, d8 - 1.0D), func_76310_a(this.field_76312_d[i2 + 1], d6 - 1.0D, d10 - 1.0D, d8 - 1.0D));
/*     */           } 
/*     */           
/* 179 */           double d12 = func_76311_b(d11, d2, d3);
/* 180 */           double d13 = func_76311_b(d11, d4, d5);
/* 181 */           double d14 = func_76311_b(d9, d12, d13);
/*     */           
/* 183 */           p_76308_1_[b1++] = p_76308_1_[b1++] + d14 * d1;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\NoiseGeneratorImproved.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */