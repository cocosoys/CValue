/*     */ package net.minecraft.world.gen;public class ChunkProviderHell implements IChunkProvider { private Random field_73181_i; private NoiseGeneratorOctaves field_73178_j; private NoiseGeneratorOctaves field_73179_k; private NoiseGeneratorOctaves field_73176_l; private NoiseGeneratorOctaves field_73177_m; private NoiseGeneratorOctaves field_73174_n; public NoiseGeneratorOctaves field_73173_a; public NoiseGeneratorOctaves field_73171_b; private World field_73175_o; private double[] field_73186_p; public MapGenNetherBridge field_73172_c; private double[] field_73185_q; private double[] field_73184_r; private double[] field_73183_s; private MapGenBase field_73182_t; double[] field_73169_d; double[] field_73170_e; double[] field_73167_f; double[] field_73168_g; double[] field_73180_h; private static final String __OBFID = "CL_00000392";
/*     */   public void func_147419_a(int p_147419_1_, int p_147419_2_, Block[] p_147419_3_) {
/*     */     byte b1 = 4;
/*     */     byte b2 = 32;
/*     */     int i = b1 + 1;
/*     */     byte b3 = 17;
/*     */     int j = b1 + 1;
/*     */     this.field_73186_p = func_73164_a(this.field_73186_p, p_147419_1_ * b1, 0, p_147419_2_ * b1, i, b3, j);
/*     */     for (byte b4 = 0; b4 < b1; b4++) {
/*     */       for (byte b = 0; b < b1; b++) {
/*     */         for (byte b5 = 0; b5 < 16; b5++) {
/*     */           double d1 = 0.125D;
/*     */           double d2 = this.field_73186_p[((b4 + 0) * j + b + 0) * b3 + b5 + 0];
/*     */           double d3 = this.field_73186_p[((b4 + 0) * j + b + 1) * b3 + b5 + 0];
/*     */           double d4 = this.field_73186_p[((b4 + 1) * j + b + 0) * b3 + b5 + 0];
/*     */           double d5 = this.field_73186_p[((b4 + 1) * j + b + 1) * b3 + b5 + 0];
/*     */           double d6 = (this.field_73186_p[((b4 + 0) * j + b + 0) * b3 + b5 + 1] - d2) * d1;
/*     */           double d7 = (this.field_73186_p[((b4 + 0) * j + b + 1) * b3 + b5 + 1] - d3) * d1;
/*     */           double d8 = (this.field_73186_p[((b4 + 1) * j + b + 0) * b3 + b5 + 1] - d4) * d1;
/*     */           double d9 = (this.field_73186_p[((b4 + 1) * j + b + 1) * b3 + b5 + 1] - d5) * d1;
/*     */           for (byte b6 = 0; b6 < 8; b6++) {
/*     */             double d10 = 0.25D;
/*     */             double d11 = d2;
/*     */             double d12 = d3;
/*     */             double d13 = (d4 - d2) * d10;
/*     */             double d14 = (d5 - d3) * d10;
/*     */             for (byte b7 = 0; b7 < 4; b7++) {
/*     */               int k = b7 + b4 * 4 << 11 | 0 + b * 4 << 7 | b5 * 8 + b6;
/*     */               char c = '';
/*     */               double d15 = 0.25D;
/*     */               double d16 = d11;
/*     */               double d17 = (d12 - d11) * d15;
/*     */               for (byte b8 = 0; b8 < 4; b8++) {
/*     */                 Block block = null;
/*     */                 if (b5 * 8 + b6 < b2)
/*     */                   block = Blocks.field_150353_l; 
/*     */                 if (d16 > 0.0D)
/*     */                   block = Blocks.field_150424_aL; 
/*     */                 p_147419_3_[k] = block;
/*     */                 k += c;
/*     */                 d16 += d17;
/*     */               } 
/*     */               d11 += d13;
/*     */               d12 += d14;
/*     */             } 
/*     */             d2 += d6;
/*     */             d3 += d7;
/*     */             d4 += d8;
/*     */             d5 += d9;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*  55 */   public ChunkProviderHell(World p_i2005_1_, long p_i2005_2_) { this.field_73172_c = new MapGenNetherBridge();
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
/* 122 */     this.field_73185_q = new double[256];
/* 123 */     this.field_73184_r = new double[256];
/* 124 */     this.field_73183_s = new double[256];
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
/* 188 */     this.field_73182_t = new MapGenCavesHell(); this.field_73175_o = p_i2005_1_; this.field_73181_i = new Random(p_i2005_2_); this.field_73178_j = new NoiseGeneratorOctaves(this.field_73181_i, 16); this.field_73179_k = new NoiseGeneratorOctaves(this.field_73181_i, 16);
/*     */     this.field_73176_l = new NoiseGeneratorOctaves(this.field_73181_i, 8);
/*     */     this.field_73177_m = new NoiseGeneratorOctaves(this.field_73181_i, 4);
/*     */     this.field_73174_n = new NoiseGeneratorOctaves(this.field_73181_i, 4);
/*     */     this.field_73173_a = new NoiseGeneratorOctaves(this.field_73181_i, 10);
/* 193 */     this.field_73171_b = new NoiseGeneratorOctaves(this.field_73181_i, 16); } public Chunk func_73158_c(int p_73158_1_, int p_73158_2_) { return func_73154_d(p_73158_1_, p_73158_2_); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk func_73154_d(int p_73154_1_, int p_73154_2_) {
/* 199 */     this.field_73181_i.setSeed(p_73154_1_ * 341873128712L + p_73154_2_ * 132897987541L);
/*     */     
/* 201 */     Block[] arrayOfBlock = new Block[32768];
/*     */     
/* 203 */     func_147419_a(p_73154_1_, p_73154_2_, arrayOfBlock);
/* 204 */     func_147418_b(p_73154_1_, p_73154_2_, arrayOfBlock);
/*     */     
/* 206 */     this.field_73182_t.func_151539_a(this, this.field_73175_o, p_73154_1_, p_73154_2_, arrayOfBlock);
/* 207 */     this.field_73172_c.func_151539_a(this, this.field_73175_o, p_73154_1_, p_73154_2_, arrayOfBlock);
/*     */     
/* 209 */     Chunk chunk = new Chunk(this.field_73175_o, arrayOfBlock, p_73154_1_, p_73154_2_);
/* 210 */     BiomeGenBase[] arrayOfBiomeGenBase = this.field_73175_o.func_72959_q().func_76933_b(null, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16);
/* 211 */     byte[] arrayOfByte = chunk.func_76605_m();
/*     */     
/* 213 */     for (byte b = 0; b < arrayOfByte.length; b++) {
/* 214 */       arrayOfByte[b] = (byte)(arrayOfBiomeGenBase[b]).field_76756_M;
/*     */     }
/*     */     
/* 217 */     chunk.func_76613_n();
/*     */     
/* 219 */     return chunk;
/*     */   } public void func_147418_b(int p_147418_1_, int p_147418_2_, Block[] p_147418_3_) { byte b1 = 64; double d = 0.03125D; this.field_73185_q = this.field_73177_m.func_76304_a(this.field_73185_q, p_147418_1_ * 16, p_147418_2_ * 16, 0, 16, 16, 1, d, d, 1.0D); this.field_73184_r = this.field_73177_m.func_76304_a(this.field_73184_r, p_147418_1_ * 16, 109, p_147418_2_ * 16, 16, 1, 16, d, 1.0D, d); this.field_73183_s = this.field_73174_n.func_76304_a(this.field_73183_s, p_147418_1_ * 16, p_147418_2_ * 16, 0, 16, 16, 1, d * 2.0D, d * 2.0D, d * 2.0D); for (byte b2 = 0; b2 < 16; b2++) { for (byte b = 0; b < 16; b++) { boolean bool1 = (this.field_73185_q[b2 + b * 16] + this.field_73181_i.nextDouble() * 0.2D > 0.0D) ? true : false; boolean bool2 = (this.field_73184_r[b2 + b * 16] + this.field_73181_i.nextDouble() * 0.2D > 0.0D) ? true : false; int i = (int)(this.field_73183_s[b2 + b * 16] / 3.0D + 3.0D + this.field_73181_i.nextDouble() * 0.25D); int j = -1; Block block1 = Blocks.field_150424_aL; Block block2 = Blocks.field_150424_aL; for (byte b3 = 127; b3 >= 0; b3--) { int k = (b * 16 + b2) * 128 + b3; if (b3 >= 127 - this.field_73181_i.nextInt(5) || b3 <= 0 + this.field_73181_i.nextInt(5)) { p_147418_3_[k] = Blocks.field_150357_h; } else { Block block = p_147418_3_[k]; if (block == null || block.func_149688_o() == Material.field_151579_a) { j = -1; } else if (block == Blocks.field_150424_aL) { if (j == -1) { if (i <= 0) { block1 = null; block2 = Blocks.field_150424_aL; } else if (b3 >= b1 - 4 && b3 <= b1 + 1) { block1 = Blocks.field_150424_aL; block2 = Blocks.field_150424_aL; if (bool2) { block1 = Blocks.field_150351_n; block2 = Blocks.field_150424_aL; }  if (bool1) { block1 = Blocks.field_150425_aM; block2 = Blocks.field_150425_aM; }  }  if (b3 < b1 && (block1 == null || block1.func_149688_o() == Material.field_151579_a))
/*     */                   block1 = Blocks.field_150353_l;  j = i; if (b3 >= b1 - 1) { p_147418_3_[k] = block1; } else { p_147418_3_[k] = block2; }  } else if (j > 0) { j--; p_147418_3_[k] = block2; }  }  }
/*     */            }
/*     */          }
/*     */        }
/* 225 */      } private double[] func_73164_a(double[] p_73164_1_, int p_73164_2_, int p_73164_3_, int p_73164_4_, int p_73164_5_, int p_73164_6_, int p_73164_7_) { if (p_73164_1_ == null) {
/* 226 */       p_73164_1_ = new double[p_73164_5_ * p_73164_6_ * p_73164_7_];
/*     */     }
/*     */     
/* 229 */     double d1 = 684.412D;
/* 230 */     double d2 = 2053.236D;
/*     */     
/* 232 */     this.field_73168_g = this.field_73173_a.func_76304_a(this.field_73168_g, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, 1, p_73164_7_, 1.0D, 0.0D, 1.0D);
/* 233 */     this.field_73180_h = this.field_73171_b.func_76304_a(this.field_73180_h, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, 1, p_73164_7_, 100.0D, 0.0D, 100.0D);
/*     */     
/* 235 */     this.field_73169_d = this.field_73176_l.func_76304_a(this.field_73169_d, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, d1 / 80.0D, d2 / 60.0D, d1 / 80.0D);
/* 236 */     this.field_73170_e = this.field_73178_j.func_76304_a(this.field_73170_e, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, d1, d2, d1);
/* 237 */     this.field_73167_f = this.field_73179_k.func_76304_a(this.field_73167_f, p_73164_2_, p_73164_3_, p_73164_4_, p_73164_5_, p_73164_6_, p_73164_7_, d1, d2, d1);
/*     */     
/* 239 */     byte b1 = 0;
/* 240 */     byte b2 = 0;
/* 241 */     double[] arrayOfDouble = new double[p_73164_6_]; byte b3;
/* 242 */     for (b3 = 0; b3 < p_73164_6_; b3++) {
/* 243 */       arrayOfDouble[b3] = Math.cos(b3 * Math.PI * 6.0D / p_73164_6_) * 2.0D;
/*     */       
/* 245 */       double d = b3;
/* 246 */       if (b3 > p_73164_6_ / 2) {
/* 247 */         d = (p_73164_6_ - 1 - b3);
/*     */       }
/* 249 */       if (d < 4.0D) {
/* 250 */         d = 4.0D - d;
/* 251 */         arrayOfDouble[b3] = arrayOfDouble[b3] - d * d * d * 10.0D;
/*     */       } 
/*     */     } 
/*     */     
/* 255 */     for (b3 = 0; b3 < p_73164_5_; b3++) {
/*     */       
/* 257 */       for (byte b = 0; b < p_73164_7_; b++) {
/*     */         
/* 259 */         double d3 = (this.field_73168_g[b2] + 256.0D) / 512.0D;
/* 260 */         if (d3 > 1.0D) d3 = 1.0D;
/*     */         
/* 262 */         double d4 = 0.0D;
/*     */         
/* 264 */         double d5 = this.field_73180_h[b2] / 8000.0D;
/* 265 */         if (d5 < 0.0D) d5 = -d5; 
/* 266 */         d5 = d5 * 3.0D - 3.0D;
/*     */         
/* 268 */         if (d5 < 0.0D) {
/* 269 */           d5 /= 2.0D;
/* 270 */           if (d5 < -1.0D) d5 = -1.0D; 
/* 271 */           d5 /= 1.4D;
/* 272 */           d5 /= 2.0D;
/* 273 */           d3 = 0.0D;
/*     */         } else {
/* 275 */           if (d5 > 1.0D) d5 = 1.0D; 
/* 276 */           d5 /= 6.0D;
/*     */         } 
/* 278 */         d3 += 0.5D;
/* 279 */         d5 = d5 * p_73164_6_ / 16.0D;
/* 280 */         b2++;
/*     */         
/* 282 */         for (byte b4 = 0; b4 < p_73164_6_; b4++) {
/* 283 */           double d6 = 0.0D;
/*     */           
/* 285 */           double d7 = arrayOfDouble[b4];
/*     */           
/* 287 */           double d8 = this.field_73170_e[b1] / 512.0D;
/* 288 */           double d9 = this.field_73167_f[b1] / 512.0D;
/*     */           
/* 290 */           double d10 = (this.field_73169_d[b1] / 10.0D + 1.0D) / 2.0D;
/* 291 */           if (d10 < 0.0D) { d6 = d8; }
/* 292 */           else if (d10 > 1.0D) { d6 = d9; }
/* 293 */           else { d6 = d8 + (d9 - d8) * d10; }
/* 294 */            d6 -= d7;
/*     */           
/* 296 */           if (b4 > p_73164_6_ - 4) {
/* 297 */             double d = ((b4 - p_73164_6_ - 4) / 3.0F);
/* 298 */             d6 = d6 * (1.0D - d) + -10.0D * d;
/*     */           } 
/*     */           
/* 301 */           if (b4 < d4) {
/* 302 */             double d = (d4 - b4) / 4.0D;
/* 303 */             if (d < 0.0D) d = 0.0D; 
/* 304 */             if (d > 1.0D) d = 1.0D; 
/* 305 */             d6 = d6 * (1.0D - d) + -10.0D * d;
/*     */           } 
/*     */           
/* 308 */           p_73164_1_[b1] = d6;
/* 309 */           b1++;
/*     */         } 
/*     */       } 
/*     */     } 
/* 313 */     return p_73164_1_; }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73149_a(int p_73149_1_, int p_73149_2_) {
/* 318 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
/* 323 */     BlockFalling.field_149832_M = true;
/* 324 */     int i = p_73153_2_ * 16;
/* 325 */     int j = p_73153_3_ * 16;
/*     */     
/* 327 */     this.field_73172_c.func_75051_a(this.field_73175_o, this.field_73181_i, p_73153_2_, p_73153_3_);
/*     */     int k;
/* 329 */     for (k = 0; k < 8; k++) {
/* 330 */       int n = i + this.field_73181_i.nextInt(16) + 8;
/* 331 */       int i1 = this.field_73181_i.nextInt(120) + 4;
/* 332 */       int i2 = j + this.field_73181_i.nextInt(16) + 8;
/* 333 */       (new WorldGenHellLava((Block)Blocks.field_150356_k, false)).func_76484_a(this.field_73175_o, this.field_73181_i, n, i1, i2);
/*     */     } 
/*     */     
/* 336 */     k = this.field_73181_i.nextInt(this.field_73181_i.nextInt(10) + 1) + 1;
/*     */     int m;
/* 338 */     for (m = 0; m < k; m++) {
/* 339 */       int n = i + this.field_73181_i.nextInt(16) + 8;
/* 340 */       int i1 = this.field_73181_i.nextInt(120) + 4;
/* 341 */       int i2 = j + this.field_73181_i.nextInt(16) + 8;
/* 342 */       (new WorldGenFire()).func_76484_a(this.field_73175_o, this.field_73181_i, n, i1, i2);
/*     */     } 
/*     */     
/* 345 */     k = this.field_73181_i.nextInt(this.field_73181_i.nextInt(10) + 1);
/* 346 */     for (m = 0; m < k; m++) {
/* 347 */       int n = i + this.field_73181_i.nextInt(16) + 8;
/* 348 */       int i1 = this.field_73181_i.nextInt(120) + 4;
/* 349 */       int i2 = j + this.field_73181_i.nextInt(16) + 8;
/* 350 */       (new WorldGenGlowStone1()).func_76484_a(this.field_73175_o, this.field_73181_i, n, i1, i2);
/*     */     } 
/*     */     
/* 353 */     for (m = 0; m < 10; m++) {
/* 354 */       int n = i + this.field_73181_i.nextInt(16) + 8;
/* 355 */       int i1 = this.field_73181_i.nextInt(128);
/* 356 */       int i2 = j + this.field_73181_i.nextInt(16) + 8;
/* 357 */       (new WorldGenGlowStone2()).func_76484_a(this.field_73175_o, this.field_73181_i, n, i1, i2);
/*     */     } 
/*     */     
/* 360 */     if (this.field_73181_i.nextInt(1) == 0) {
/* 361 */       m = i + this.field_73181_i.nextInt(16) + 8;
/* 362 */       int n = this.field_73181_i.nextInt(128);
/* 363 */       int i1 = j + this.field_73181_i.nextInt(16) + 8;
/* 364 */       (new WorldGenFlowers((Block)Blocks.field_150338_P)).func_76484_a(this.field_73175_o, this.field_73181_i, m, n, i1);
/*     */     } 
/*     */     
/* 367 */     if (this.field_73181_i.nextInt(1) == 0) {
/* 368 */       m = i + this.field_73181_i.nextInt(16) + 8;
/* 369 */       int n = this.field_73181_i.nextInt(128);
/* 370 */       int i1 = j + this.field_73181_i.nextInt(16) + 8;
/* 371 */       (new WorldGenFlowers((Block)Blocks.field_150337_Q)).func_76484_a(this.field_73175_o, this.field_73181_i, m, n, i1);
/*     */     } 
/*     */     
/* 374 */     WorldGenMinable worldGenMinable = new WorldGenMinable(Blocks.field_150449_bY, 13, Blocks.field_150424_aL); byte b;
/* 375 */     for (b = 0; b < 16; b++) {
/* 376 */       int n = i + this.field_73181_i.nextInt(16);
/* 377 */       int i1 = this.field_73181_i.nextInt(108) + 10;
/* 378 */       int i2 = j + this.field_73181_i.nextInt(16);
/* 379 */       worldGenMinable.func_76484_a(this.field_73175_o, this.field_73181_i, n, i1, i2);
/*     */     } 
/*     */     
/* 382 */     for (b = 0; b < 16; b++) {
/* 383 */       int n = i + this.field_73181_i.nextInt(16);
/* 384 */       int i1 = this.field_73181_i.nextInt(108) + 10;
/* 385 */       int i2 = j + this.field_73181_i.nextInt(16);
/* 386 */       (new WorldGenHellLava((Block)Blocks.field_150356_k, true)).func_76484_a(this.field_73175_o, this.field_73181_i, n, i1, i2);
/*     */     } 
/*     */ 
/*     */     
/* 390 */     BlockFalling.field_149832_M = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73151_a(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
/* 395 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_104112_b() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73156_b() {
/* 405 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73157_c() {
/* 410 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_73148_d() {
/* 416 */     return "HellRandomLevelSource";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
/* 423 */     if (p_73155_1_ == EnumCreatureType.monster) {
/* 424 */       if (this.field_73172_c.func_75048_a(p_73155_2_, p_73155_3_, p_73155_4_)) {
/* 425 */         return this.field_73172_c.func_75059_a();
/*     */       }
/* 427 */       if (this.field_73172_c.func_142038_b(p_73155_2_, p_73155_3_, p_73155_4_) && this.field_73175_o.func_147439_a(p_73155_2_, p_73155_3_ - 1, p_73155_4_) == Blocks.field_150385_bj) {
/* 428 */         return this.field_73172_c.func_75059_a();
/*     */       }
/*     */     } 
/*     */     
/* 432 */     BiomeGenBase biomeGenBase = this.field_73175_o.func_72807_a(p_73155_2_, p_73155_4_);
/* 433 */     return biomeGenBase.func_76747_a(p_73155_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
/* 438 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_73152_e() {
/* 443 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_82695_e(int p_82695_1_, int p_82695_2_) {
/* 448 */     this.field_73172_c.func_151539_a(this, this.field_73175_o, p_82695_1_, p_82695_2_, null);
/*     */   } }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\ChunkProviderHell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */