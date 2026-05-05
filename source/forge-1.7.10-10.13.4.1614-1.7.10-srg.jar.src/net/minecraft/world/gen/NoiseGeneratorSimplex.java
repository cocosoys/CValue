/*     */ package net.minecraft.world.gen;
/*     */ 
/*     */ import java.util.Random;
/*     */ 
/*     */ public class NoiseGeneratorSimplex {
/*   6 */   private static int[][] field_151611_e = new int[][] { { 1, 1, 0 }, { -1, 1, 0 }, { 1, -1, 0 }, { -1, -1, 0 }, { 1, 0, 1 }, { -1, 0, 1 }, { 1, 0, -1 }, { -1, 0, -1 }, { 0, 1, 1 }, { 0, -1, 1 }, { 0, 1, -1 }, { 0, -1, -1 } };
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
/*  33 */   public static final double field_151614_a = Math.sqrt(3.0D);
/*     */   
/*  35 */   private int[] field_151608_f = new int[512];
/*     */   public double field_151612_b;
/*     */   public double field_151613_c;
/*     */   public double field_151610_d;
/*     */   
/*     */   public NoiseGeneratorSimplex() {
/*  41 */     this(new Random());
/*     */   }
/*     */   
/*     */   public NoiseGeneratorSimplex(Random p_i45471_1_) {
/*  45 */     this.field_151612_b = p_i45471_1_.nextDouble() * 256.0D;
/*  46 */     this.field_151613_c = p_i45471_1_.nextDouble() * 256.0D;
/*  47 */     this.field_151610_d = p_i45471_1_.nextDouble() * 256.0D; byte b;
/*  48 */     for (b = 0; b < 'Ā'; b++) {
/*  49 */       this.field_151608_f[b] = b;
/*     */     }
/*     */     
/*  52 */     for (b = 0; b < 'Ā'; b++) {
/*  53 */       int i = p_i45471_1_.nextInt(256 - b) + b;
/*  54 */       int j = this.field_151608_f[b];
/*  55 */       this.field_151608_f[b] = this.field_151608_f[i];
/*  56 */       this.field_151608_f[i] = j;
/*     */       
/*  58 */       this.field_151608_f[b + 256] = this.field_151608_f[b];
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static int func_151607_a(double p_151607_0_) {
/*  64 */     return (p_151607_0_ > 0.0D) ? (int)p_151607_0_ : ((int)p_151607_0_ - 1);
/*     */   }
/*     */   
/*     */   private static double func_151604_a(int[] p_151604_0_, double p_151604_1_, double p_151604_3_) {
/*  68 */     return p_151604_0_[0] * p_151604_1_ + p_151604_0_[1] * p_151604_3_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double func_151605_a(double p_151605_1_, double p_151605_3_) {
/*     */     double d1, d2, d3;
/*     */     byte b1, b2;
/*  79 */     double d4 = 0.5D * (field_151614_a - 1.0D);
/*  80 */     double d5 = (p_151605_1_ + p_151605_3_) * d4;
/*  81 */     int i = func_151607_a(p_151605_1_ + d5);
/*  82 */     int j = func_151607_a(p_151605_3_ + d5);
/*  83 */     double d6 = (3.0D - field_151614_a) / 6.0D;
/*  84 */     double d7 = (i + j) * d6;
/*  85 */     double d8 = i - d7;
/*  86 */     double d9 = j - d7;
/*  87 */     double d10 = p_151605_1_ - d8;
/*  88 */     double d11 = p_151605_3_ - d9;
/*     */ 
/*     */ 
/*     */     
/*  92 */     if (d10 > d11) {
/*  93 */       b1 = 1;
/*  94 */       b2 = 0;
/*     */     } else {
/*     */       
/*  97 */       b1 = 0;
/*  98 */       b2 = 1;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 103 */     double d12 = d10 - b1 + d6;
/* 104 */     double d13 = d11 - b2 + d6;
/* 105 */     double d14 = d10 - 1.0D + 2.0D * d6;
/* 106 */     double d15 = d11 - 1.0D + 2.0D * d6;
/*     */     
/* 108 */     int k = i & 0xFF;
/* 109 */     int m = j & 0xFF;
/* 110 */     int n = this.field_151608_f[k + this.field_151608_f[m]] % 12;
/* 111 */     int i1 = this.field_151608_f[k + b1 + this.field_151608_f[m + b2]] % 12;
/* 112 */     int i2 = this.field_151608_f[k + 1 + this.field_151608_f[m + 1]] % 12;
/*     */     
/* 114 */     double d16 = 0.5D - d10 * d10 - d11 * d11;
/* 115 */     if (d16 < 0.0D) { d1 = 0.0D; }
/*     */     else
/* 117 */     { d16 *= d16;
/* 118 */       d1 = d16 * d16 * func_151604_a(field_151611_e[n], d10, d11); }
/*     */     
/* 120 */     double d17 = 0.5D - d12 * d12 - d13 * d13;
/* 121 */     if (d17 < 0.0D) { d2 = 0.0D; }
/*     */     else
/* 123 */     { d17 *= d17;
/* 124 */       d2 = d17 * d17 * func_151604_a(field_151611_e[i1], d12, d13); }
/*     */     
/* 126 */     double d18 = 0.5D - d14 * d14 - d15 * d15;
/* 127 */     if (d18 < 0.0D) { d3 = 0.0D; }
/*     */     else
/* 129 */     { d18 *= d18;
/* 130 */       d3 = d18 * d18 * func_151604_a(field_151611_e[i2], d14, d15); }
/*     */ 
/*     */ 
/*     */     
/* 134 */     return 70.0D * (d1 + d2 + d3);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 258 */   private static final double field_151609_g = 0.5D * (field_151614_a - 1.0D);
/* 259 */   private static final double field_151615_h = (3.0D - field_151614_a) / 6.0D; private static final String __OBFID = "CL_00000537";
/*     */   
/*     */   public void func_151606_a(double[] p_151606_1_, double p_151606_2_, double p_151606_4_, int p_151606_6_, int p_151606_7_, double p_151606_8_, double p_151606_10_, double p_151606_12_) {
/* 262 */     byte b1 = 0;
/* 263 */     for (byte b2 = 0; b2 < p_151606_7_; b2++) {
/* 264 */       double d = (p_151606_4_ + b2) * p_151606_10_ + this.field_151613_c;
/* 265 */       for (byte b = 0; b < p_151606_6_; b++) {
/* 266 */         double d2, d3, d4; byte b3, b4; double d1 = (p_151606_2_ + b) * p_151606_8_ + this.field_151612_b;
/*     */ 
/*     */         
/* 269 */         double d5 = (d1 + d) * field_151609_g;
/* 270 */         int i = func_151607_a(d1 + d5);
/* 271 */         int j = func_151607_a(d + d5);
/* 272 */         double d6 = (i + j) * field_151615_h;
/* 273 */         double d7 = i - d6;
/* 274 */         double d8 = j - d6;
/* 275 */         double d9 = d1 - d7;
/* 276 */         double d10 = d - d8;
/*     */ 
/*     */ 
/*     */         
/* 280 */         if (d9 > d10) {
/* 281 */           b3 = 1;
/* 282 */           b4 = 0;
/*     */         } else {
/*     */           
/* 285 */           b3 = 0;
/* 286 */           b4 = 1;
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 291 */         double d11 = d9 - b3 + field_151615_h;
/* 292 */         double d12 = d10 - b4 + field_151615_h;
/* 293 */         double d13 = d9 - 1.0D + 2.0D * field_151615_h;
/* 294 */         double d14 = d10 - 1.0D + 2.0D * field_151615_h;
/*     */         
/* 296 */         int k = i & 0xFF;
/* 297 */         int m = j & 0xFF;
/* 298 */         int n = this.field_151608_f[k + this.field_151608_f[m]] % 12;
/* 299 */         int i1 = this.field_151608_f[k + b3 + this.field_151608_f[m + b4]] % 12;
/* 300 */         int i2 = this.field_151608_f[k + 1 + this.field_151608_f[m + 1]] % 12;
/*     */         
/* 302 */         double d15 = 0.5D - d9 * d9 - d10 * d10;
/* 303 */         if (d15 < 0.0D) { d2 = 0.0D; }
/*     */         else
/* 305 */         { d15 *= d15;
/* 306 */           d2 = d15 * d15 * func_151604_a(field_151611_e[n], d9, d10); }
/*     */         
/* 308 */         double d16 = 0.5D - d11 * d11 - d12 * d12;
/* 309 */         if (d16 < 0.0D) { d3 = 0.0D; }
/*     */         else
/* 311 */         { d16 *= d16;
/* 312 */           d3 = d16 * d16 * func_151604_a(field_151611_e[i1], d11, d12); }
/*     */         
/* 314 */         double d17 = 0.5D - d13 * d13 - d14 * d14;
/* 315 */         if (d17 < 0.0D) { d4 = 0.0D; }
/*     */         else
/* 317 */         { d17 *= d17;
/* 318 */           d4 = d17 * d17 * func_151604_a(field_151611_e[i2], d13, d14); }
/*     */ 
/*     */ 
/*     */         
/* 322 */         p_151606_1_[b1++] = p_151606_1_[b1++] + 70.0D * (d2 + d3 + d4) * p_151606_12_;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\NoiseGeneratorSimplex.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */