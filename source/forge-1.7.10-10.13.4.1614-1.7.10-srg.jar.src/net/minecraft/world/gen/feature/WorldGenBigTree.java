/*     */ package net.minecraft.world.gen.feature;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
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
/*     */ public class WorldGenBigTree
/*     */   extends WorldGenAbstractTree
/*     */ {
/*  31 */   static final byte[] field_76507_a = new byte[] { 2, 0, 0, 1, 2, 1 };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  36 */   Random field_76505_b = new Random();
/*     */ 
/*     */   
/*     */   World field_76506_c;
/*     */ 
/*     */   
/*  42 */   int[] field_76503_d = new int[] { 0, 0, 0 };
/*     */ 
/*     */   
/*     */   int field_76504_e;
/*     */   
/*     */   int field_76501_f;
/*     */   
/*  49 */   double field_76502_g = 0.618D;
/*  50 */   double field_76514_h = 1.0D;
/*  51 */   double field_76515_i = 0.381D;
/*  52 */   double field_76512_j = 1.0D;
/*  53 */   double field_76513_k = 1.0D;
/*  54 */   int field_76510_l = 1;
/*  55 */   int field_76511_m = 12;
/*  56 */   int field_76508_n = 4;
/*     */   int[][] field_76509_o;
/*     */   private static final String __OBFID = "CL_00000400";
/*     */   
/*     */   public WorldGenBigTree(boolean p_i2008_1_) {
/*  61 */     super(p_i2008_1_);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void func_76489_a() {
/*  69 */     this.field_76501_f = (int)(this.field_76504_e * this.field_76502_g);
/*  70 */     if (this.field_76501_f >= this.field_76504_e) this.field_76501_f = this.field_76504_e - 1; 
/*  71 */     int i = (int)(1.382D + Math.pow(this.field_76513_k * this.field_76504_e / 13.0D, 2.0D));
/*  72 */     if (i < 1) i = 1;
/*     */ 
/*     */     
/*  75 */     int[][] arrayOfInt = new int[i * this.field_76504_e][4];
/*  76 */     int j = this.field_76503_d[1] + this.field_76504_e - this.field_76508_n;
/*  77 */     byte b = 1;
/*  78 */     int k = this.field_76503_d[1] + this.field_76501_f;
/*  79 */     int m = j - this.field_76503_d[1];
/*  80 */     arrayOfInt[0][0] = this.field_76503_d[0];
/*  81 */     arrayOfInt[0][1] = j;
/*  82 */     arrayOfInt[0][2] = this.field_76503_d[2];
/*  83 */     arrayOfInt[0][3] = k;
/*  84 */     j--;
/*     */     
/*  86 */     while (m >= 0) {
/*  87 */       byte b1 = 0;
/*     */       
/*  89 */       float f = func_76490_a(m);
/*  90 */       if (f < 0.0F) {
/*  91 */         j--;
/*  92 */         m--;
/*     */         
/*     */         continue;
/*     */       } 
/*     */       
/*  97 */       double d = 0.5D;
/*  98 */       while (b1 < i) {
/*  99 */         double d1 = this.field_76512_j * f * (this.field_76505_b.nextFloat() + 0.328D);
/* 100 */         double d2 = this.field_76505_b.nextFloat() * 2.0D * 3.14159D;
/* 101 */         int n = MathHelper.func_76128_c(d1 * Math.sin(d2) + this.field_76503_d[0] + d);
/* 102 */         int i1 = MathHelper.func_76128_c(d1 * Math.cos(d2) + this.field_76503_d[2] + d);
/* 103 */         int[] arrayOfInt1 = { n, j, i1 };
/*     */ 
/*     */         
/* 106 */         int[] arrayOfInt2 = { n, j + this.field_76508_n, i1 };
/*     */ 
/*     */ 
/*     */         
/* 110 */         if (func_76496_a(arrayOfInt1, arrayOfInt2) == -1) {
/*     */ 
/*     */           
/* 113 */           int[] arrayOfInt3 = { this.field_76503_d[0], this.field_76503_d[1], this.field_76503_d[2] };
/*     */ 
/*     */           
/* 116 */           double d3 = Math.sqrt(Math.pow(Math.abs(this.field_76503_d[0] - arrayOfInt1[0]), 2.0D) + Math.pow(Math.abs(this.field_76503_d[2] - arrayOfInt1[2]), 2.0D));
/* 117 */           double d4 = d3 * this.field_76515_i;
/* 118 */           if (arrayOfInt1[1] - d4 > k) {
/* 119 */             arrayOfInt3[1] = k;
/*     */           } else {
/*     */             
/* 122 */             arrayOfInt3[1] = (int)(arrayOfInt1[1] - d4);
/*     */           } 
/*     */           
/* 125 */           if (func_76496_a(arrayOfInt3, arrayOfInt1) == -1) {
/*     */ 
/*     */             
/* 128 */             arrayOfInt[b][0] = n;
/* 129 */             arrayOfInt[b][1] = j;
/* 130 */             arrayOfInt[b][2] = i1;
/* 131 */             arrayOfInt[b][3] = arrayOfInt3[1];
/* 132 */             b++;
/*     */           } 
/*     */         } 
/* 135 */         b1++;
/*     */       } 
/* 137 */       j--;
/* 138 */       m--;
/*     */     } 
/* 140 */     this.field_76509_o = new int[b][4];
/* 141 */     System.arraycopy(arrayOfInt, 0, this.field_76509_o, 0, b);
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
/*     */   void func_150529_a(int p_150529_1_, int p_150529_2_, int p_150529_3_, float p_150529_4_, byte p_150529_5_, Block p_150529_6_) {
/* 156 */     int i = (int)(p_150529_4_ + 0.618D);
/* 157 */     byte b1 = field_76507_a[p_150529_5_];
/* 158 */     byte b2 = field_76507_a[p_150529_5_ + 3];
/* 159 */     int[] arrayOfInt1 = { p_150529_1_, p_150529_2_, p_150529_3_ };
/*     */ 
/*     */     
/* 162 */     int[] arrayOfInt2 = { 0, 0, 0 };
/*     */ 
/*     */     
/* 165 */     int j = -i;
/* 166 */     int k = -i;
/*     */     
/* 168 */     arrayOfInt2[p_150529_5_] = arrayOfInt1[p_150529_5_];
/* 169 */     while (j <= i) {
/* 170 */       arrayOfInt2[b1] = arrayOfInt1[b1] + j;
/* 171 */       k = -i;
/* 172 */       while (k <= i) {
/* 173 */         double d = Math.pow(Math.abs(j) + 0.5D, 2.0D) + Math.pow(Math.abs(k) + 0.5D, 2.0D);
/* 174 */         if (d > (p_150529_4_ * p_150529_4_)) {
/* 175 */           k++;
/*     */           continue;
/*     */         } 
/* 178 */         arrayOfInt2[b2] = arrayOfInt1[b2] + k;
/* 179 */         Block block = this.field_76506_c.func_147439_a(arrayOfInt2[0], arrayOfInt2[1], arrayOfInt2[2]);
/* 180 */         if (block.func_149688_o() != Material.field_151579_a && block.func_149688_o() != Material.field_151584_j) {
/*     */ 
/*     */           
/* 183 */           k++;
/*     */           continue;
/*     */         } 
/* 186 */         func_150516_a(this.field_76506_c, arrayOfInt2[0], arrayOfInt2[1], arrayOfInt2[2], p_150529_6_, 0);
/* 187 */         k++;
/*     */       } 
/* 189 */       j++;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   float func_76490_a(int p_76490_1_) {
/*     */     float f3;
/* 201 */     if (p_76490_1_ < this.field_76504_e * 0.3D) return -1.618F; 
/* 202 */     float f1 = this.field_76504_e / 2.0F;
/* 203 */     float f2 = this.field_76504_e / 2.0F - p_76490_1_;
/*     */     
/* 205 */     if (f2 == 0.0F) { f3 = f1; }
/* 206 */     else if (Math.abs(f2) >= f1) { f3 = 0.0F; }
/* 207 */     else { f3 = (float)Math.sqrt(Math.pow(Math.abs(f1), 2.0D) - Math.pow(Math.abs(f2), 2.0D)); }
/*     */     
/* 209 */     f3 *= 0.5F;
/* 210 */     return f3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   float func_76495_b(int p_76495_1_) {
/* 219 */     if (p_76495_1_ < 0 || p_76495_1_ >= this.field_76508_n) return -1.0F; 
/* 220 */     if (p_76495_1_ == 0 || p_76495_1_ == this.field_76508_n - 1) return 2.0F; 
/* 221 */     return 3.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void func_76491_a(int p_76491_1_, int p_76491_2_, int p_76491_3_) {
/* 228 */     int i = p_76491_2_;
/* 229 */     int j = p_76491_2_ + this.field_76508_n;
/*     */     
/* 231 */     while (i < j) {
/* 232 */       float f = func_76495_b(i - p_76491_2_);
/* 233 */       func_150529_a(p_76491_1_, i, p_76491_3_, f, (byte)1, (Block)Blocks.field_150362_t);
/* 234 */       i++;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void func_150530_a(int[] p_150530_1_, int[] p_150530_2_, Block p_150530_3_) {
/*     */     byte b5;
/* 245 */     int[] arrayOfInt1 = { 0, 0, 0 };
/*     */ 
/*     */     
/* 248 */     byte b1 = 0;
/* 249 */     byte b2 = 0;
/* 250 */     while (b1 < 3) {
/* 251 */       arrayOfInt1[b1] = p_150530_2_[b1] - p_150530_1_[b1];
/* 252 */       if (Math.abs(arrayOfInt1[b1]) > Math.abs(arrayOfInt1[b2])) {
/* 253 */         b2 = b1;
/*     */       }
/* 255 */       b1 = (byte)(b1 + 1);
/*     */     } 
/*     */     
/* 258 */     if (arrayOfInt1[b2] == 0)
/*     */       return; 
/* 260 */     byte b3 = field_76507_a[b2];
/* 261 */     byte b4 = field_76507_a[b2 + 3];
/*     */ 
/*     */ 
/*     */     
/* 265 */     if (arrayOfInt1[b2] > 0) { b5 = 1; }
/* 266 */     else { b5 = -1; }
/*     */     
/* 268 */     double d1 = arrayOfInt1[b3] / arrayOfInt1[b2];
/* 269 */     double d2 = arrayOfInt1[b4] / arrayOfInt1[b2];
/*     */     
/* 271 */     int[] arrayOfInt2 = { 0, 0, 0 };
/*     */ 
/*     */ 
/*     */     
/* 275 */     int i = 0;
/* 276 */     int j = arrayOfInt1[b2] + b5;
/* 277 */     while (i != j) {
/* 278 */       arrayOfInt2[b2] = MathHelper.func_76128_c((p_150530_1_[b2] + i) + 0.5D);
/* 279 */       arrayOfInt2[b3] = MathHelper.func_76128_c(p_150530_1_[b3] + i * d1 + 0.5D);
/* 280 */       arrayOfInt2[b4] = MathHelper.func_76128_c(p_150530_1_[b4] + i * d2 + 0.5D);
/*     */       
/* 282 */       byte b = 0;
/* 283 */       int k = Math.abs(arrayOfInt2[0] - p_150530_1_[0]);
/* 284 */       int m = Math.abs(arrayOfInt2[2] - p_150530_1_[2]);
/* 285 */       int n = Math.max(k, m);
/*     */       
/* 287 */       if (n > 0) {
/* 288 */         if (k == n) {
/* 289 */           b = 4;
/* 290 */         } else if (m == n) {
/* 291 */           b = 8;
/*     */         } 
/*     */       }
/*     */       
/* 295 */       func_150516_a(this.field_76506_c, arrayOfInt2[0], arrayOfInt2[1], arrayOfInt2[2], p_150530_3_, b);
/* 296 */       i += b5;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void func_76498_b() {
/* 304 */     byte b = 0;
/* 305 */     int i = this.field_76509_o.length;
/* 306 */     while (b < i) {
/* 307 */       int j = this.field_76509_o[b][0];
/* 308 */       int k = this.field_76509_o[b][1];
/* 309 */       int m = this.field_76509_o[b][2];
/* 310 */       func_76491_a(j, k, m);
/* 311 */       b++;
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
/*     */   boolean func_76493_c(int p_76493_1_) {
/* 323 */     if (p_76493_1_ < this.field_76504_e * 0.2D) return false; 
/* 324 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   void func_76499_c() {
/* 329 */     int i = this.field_76503_d[0];
/* 330 */     int j = this.field_76503_d[1];
/* 331 */     int k = this.field_76503_d[1] + this.field_76501_f;
/* 332 */     int m = this.field_76503_d[2];
/* 333 */     int[] arrayOfInt1 = { i, j, m };
/*     */ 
/*     */     
/* 336 */     int[] arrayOfInt2 = { i, k, m };
/*     */ 
/*     */     
/* 339 */     func_150530_a(arrayOfInt1, arrayOfInt2, Blocks.field_150364_r);
/* 340 */     if (this.field_76510_l == 2) {
/* 341 */       arrayOfInt1[0] = arrayOfInt1[0] + 1;
/* 342 */       arrayOfInt2[0] = arrayOfInt2[0] + 1;
/* 343 */       func_150530_a(arrayOfInt1, arrayOfInt2, Blocks.field_150364_r);
/* 344 */       arrayOfInt1[2] = arrayOfInt1[2] + 1;
/* 345 */       arrayOfInt2[2] = arrayOfInt2[2] + 1;
/* 346 */       func_150530_a(arrayOfInt1, arrayOfInt2, Blocks.field_150364_r);
/* 347 */       arrayOfInt1[0] = arrayOfInt1[0] + -1;
/* 348 */       arrayOfInt2[0] = arrayOfInt2[0] + -1;
/* 349 */       func_150530_a(arrayOfInt1, arrayOfInt2, Blocks.field_150364_r);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   void func_76494_d() {
/* 357 */     byte b = 0;
/* 358 */     int i = this.field_76509_o.length;
/* 359 */     int[] arrayOfInt = { this.field_76503_d[0], this.field_76503_d[1], this.field_76503_d[2] };
/*     */ 
/*     */     
/* 362 */     while (b < i) {
/* 363 */       int[] arrayOfInt1 = this.field_76509_o[b];
/* 364 */       int[] arrayOfInt2 = { arrayOfInt1[0], arrayOfInt1[1], arrayOfInt1[2] };
/*     */ 
/*     */       
/* 367 */       arrayOfInt[1] = arrayOfInt1[3];
/* 368 */       int j = arrayOfInt[1] - this.field_76503_d[1];
/* 369 */       if (func_76493_c(j)) {
/* 370 */         func_150530_a(arrayOfInt, arrayOfInt2, Blocks.field_150364_r);
/*     */       }
/* 372 */       b++;
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
/*     */   int func_76496_a(int[] p_76496_1_, int[] p_76496_2_) {
/*     */     byte b5;
/* 385 */     int[] arrayOfInt1 = { 0, 0, 0 };
/*     */ 
/*     */     
/* 388 */     byte b1 = 0;
/* 389 */     byte b2 = 0;
/* 390 */     while (b1 < 3) {
/* 391 */       arrayOfInt1[b1] = p_76496_2_[b1] - p_76496_1_[b1];
/* 392 */       if (Math.abs(arrayOfInt1[b1]) > Math.abs(arrayOfInt1[b2])) {
/* 393 */         b2 = b1;
/*     */       }
/* 395 */       b1 = (byte)(b1 + 1);
/*     */     } 
/*     */     
/* 398 */     if (arrayOfInt1[b2] == 0) return -1;
/*     */     
/* 400 */     byte b3 = field_76507_a[b2];
/* 401 */     byte b4 = field_76507_a[b2 + 3];
/*     */ 
/*     */ 
/*     */     
/* 405 */     if (arrayOfInt1[b2] > 0) { b5 = 1; }
/* 406 */     else { b5 = -1; }
/*     */     
/* 408 */     double d1 = arrayOfInt1[b3] / arrayOfInt1[b2];
/* 409 */     double d2 = arrayOfInt1[b4] / arrayOfInt1[b2];
/*     */     
/* 411 */     int[] arrayOfInt2 = { 0, 0, 0 };
/*     */ 
/*     */ 
/*     */     
/* 415 */     int i = 0;
/* 416 */     int j = arrayOfInt1[b2] + b5;
/*     */     
/* 418 */     while (i != j) {
/* 419 */       arrayOfInt2[b2] = p_76496_1_[b2] + i;
/* 420 */       arrayOfInt2[b3] = MathHelper.func_76128_c(p_76496_1_[b3] + i * d1);
/* 421 */       arrayOfInt2[b4] = MathHelper.func_76128_c(p_76496_1_[b4] + i * d2);
/* 422 */       Block block = this.field_76506_c.func_147439_a(arrayOfInt2[0], arrayOfInt2[1], arrayOfInt2[2]);
/* 423 */       if (!func_150523_a(block)) {
/*     */         break;
/*     */       }
/*     */ 
/*     */       
/* 428 */       i += b5;
/*     */     } 
/*     */     
/* 431 */     if (i == j) {
/* 432 */       return -1;
/*     */     }
/*     */ 
/*     */     
/* 436 */     return Math.abs(i);
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
/*     */   boolean func_76497_e() {
/* 449 */     int[] arrayOfInt1 = { this.field_76503_d[0], this.field_76503_d[1], this.field_76503_d[2] };
/*     */ 
/*     */     
/* 452 */     int[] arrayOfInt2 = { this.field_76503_d[0], this.field_76503_d[1] + this.field_76504_e - 1, this.field_76503_d[2] };
/*     */ 
/*     */ 
/*     */     
/* 456 */     Block block = this.field_76506_c.func_147439_a(this.field_76503_d[0], this.field_76503_d[1] - 1, this.field_76503_d[2]);
/* 457 */     if (block != Blocks.field_150346_d && block != Blocks.field_150349_c && block != Blocks.field_150458_ak) {
/* 458 */       return false;
/*     */     }
/* 460 */     int i = func_76496_a(arrayOfInt1, arrayOfInt2);
/*     */     
/* 462 */     if (i == -1) {
/* 463 */       return true;
/*     */     }
/*     */     
/* 466 */     if (i < 6) {
/* 467 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 472 */     this.field_76504_e = i;
/* 473 */     return true;
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
/*     */   public void func_76487_a(double p_76487_1_, double p_76487_3_, double p_76487_5_) {
/* 487 */     this.field_76511_m = (int)(p_76487_1_ * 12.0D);
/* 488 */     if (p_76487_1_ > 0.5D) this.field_76508_n = 5; 
/* 489 */     this.field_76512_j = p_76487_3_;
/* 490 */     this.field_76513_k = p_76487_5_;
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
/*     */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/* 504 */     this.field_76506_c = p_76484_1_;
/* 505 */     long l = p_76484_2_.nextLong();
/* 506 */     this.field_76505_b.setSeed(l);
/*     */     
/* 508 */     this.field_76503_d[0] = p_76484_3_;
/* 509 */     this.field_76503_d[1] = p_76484_4_;
/* 510 */     this.field_76503_d[2] = p_76484_5_;
/*     */     
/* 512 */     if (this.field_76504_e == 0) {
/* 513 */       this.field_76504_e = 5 + this.field_76505_b.nextInt(this.field_76511_m);
/*     */     }
/* 515 */     if (!func_76497_e()) {
/* 516 */       return false;
/*     */     }
/* 518 */     func_76489_a();
/* 519 */     func_76498_b();
/* 520 */     func_76499_c();
/* 521 */     func_76494_d();
/* 522 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenBigTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */