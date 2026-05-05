/*     */ package net.minecraft.server.v1_7_R4;public class ChunkProviderHell implements IChunkProvider { private Random i; private NoiseGeneratorOctaves j; private NoiseGeneratorOctaves k; private NoiseGeneratorOctaves l; private NoiseGeneratorOctaves m; private NoiseGeneratorOctaves n; public NoiseGeneratorOctaves a; public NoiseGeneratorOctaves b; private World o; private double[] p; public WorldGenNether c; private double[] q; private double[] r; private double[] s; private WorldGenBase t; double[] d; double[] e; double[] f; double[] g; double[] h;
/*     */   public void a(int paramInt1, int paramInt2, Block[] paramArrayOfBlock) {
/*     */     byte b1 = 4;
/*     */     byte b2 = 32;
/*     */     int i = b1 + 1;
/*     */     byte b3 = 17;
/*     */     int j = b1 + 1;
/*     */     this.p = a(this.p, paramInt1 * b1, 0, paramInt2 * b1, i, b3, j);
/*     */     for (byte b4 = 0; b4 < b1; b4++) {
/*     */       for (byte b = 0; b < b1; b++) {
/*     */         for (byte b5 = 0; b5 < 16; b5++) {
/*     */           double d1 = 0.125D;
/*     */           double d2 = this.p[((b4 + 0) * j + b + 0) * b3 + b5 + 0];
/*     */           double d3 = this.p[((b4 + 0) * j + b + 1) * b3 + b5 + 0];
/*     */           double d4 = this.p[((b4 + 1) * j + b + 0) * b3 + b5 + 0];
/*     */           double d5 = this.p[((b4 + 1) * j + b + 1) * b3 + b5 + 0];
/*     */           double d6 = (this.p[((b4 + 0) * j + b + 0) * b3 + b5 + 1] - d2) * d1;
/*     */           double d7 = (this.p[((b4 + 0) * j + b + 1) * b3 + b5 + 1] - d3) * d1;
/*     */           double d8 = (this.p[((b4 + 1) * j + b + 0) * b3 + b5 + 1] - d4) * d1;
/*     */           double d9 = (this.p[((b4 + 1) * j + b + 1) * b3 + b5 + 1] - d5) * d1;
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
/*     */                   block = Blocks.STATIONARY_LAVA; 
/*     */                 if (d16 > 0.0D)
/*     */                   block = Blocks.NETHERRACK; 
/*     */                 paramArrayOfBlock[k] = block;
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
/*  55 */   public ChunkProviderHell(World paramWorld, long paramLong) { this.c = new WorldGenNether();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 122 */     this.q = new double[256];
/* 123 */     this.r = new double[256];
/* 124 */     this.s = new double[256];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 188 */     this.t = new WorldGenCavesHell(); this.o = paramWorld; this.i = new Random(paramLong); this.j = new NoiseGeneratorOctaves(this.i, 16); this.k = new NoiseGeneratorOctaves(this.i, 16);
/*     */     this.l = new NoiseGeneratorOctaves(this.i, 8);
/*     */     this.m = new NoiseGeneratorOctaves(this.i, 4);
/*     */     this.n = new NoiseGeneratorOctaves(this.i, 4);
/*     */     this.a = new NoiseGeneratorOctaves(this.i, 10);
/* 193 */     this.b = new NoiseGeneratorOctaves(this.i, 16); } public Chunk getChunkAt(int paramInt1, int paramInt2) { return getOrCreateChunk(paramInt1, paramInt2); }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk getOrCreateChunk(int paramInt1, int paramInt2) {
/* 199 */     this.i.setSeed(paramInt1 * 341873128712L + paramInt2 * 132897987541L);
/*     */     
/* 201 */     Block[] arrayOfBlock = new Block[32768];
/*     */     
/* 203 */     a(paramInt1, paramInt2, arrayOfBlock);
/* 204 */     b(paramInt1, paramInt2, arrayOfBlock);
/*     */     
/* 206 */     this.t.a(this, this.o, paramInt1, paramInt2, arrayOfBlock);
/* 207 */     this.c.a(this, this.o, paramInt1, paramInt2, arrayOfBlock);
/*     */     
/* 209 */     Chunk chunk = new Chunk(this.o, arrayOfBlock, paramInt1, paramInt2);
/* 210 */     BiomeBase[] arrayOfBiomeBase = this.o.getWorldChunkManager().getBiomeBlock(null, paramInt1 * 16, paramInt2 * 16, 16, 16);
/* 211 */     byte[] arrayOfByte = chunk.m();
/*     */     
/* 213 */     for (byte b = 0; b < arrayOfByte.length; b++) {
/* 214 */       arrayOfByte[b] = (byte)(arrayOfBiomeBase[b]).id;
/*     */     }
/*     */     
/* 217 */     chunk.n();
/*     */     
/* 219 */     return chunk;
/*     */   } public void b(int paramInt1, int paramInt2, Block[] paramArrayOfBlock) { byte b1 = 64; double d = 0.03125D; this.q = this.m.a(this.q, paramInt1 * 16, paramInt2 * 16, 0, 16, 16, 1, d, d, 1.0D); this.r = this.m.a(this.r, paramInt1 * 16, 109, paramInt2 * 16, 16, 1, 16, d, 1.0D, d); this.s = this.n.a(this.s, paramInt1 * 16, paramInt2 * 16, 0, 16, 16, 1, d * 2.0D, d * 2.0D, d * 2.0D); for (byte b2 = 0; b2 < 16; b2++) { for (byte b = 0; b < 16; b++) { boolean bool1 = (this.q[b2 + b * 16] + this.i.nextDouble() * 0.2D > 0.0D) ? true : false; boolean bool2 = (this.r[b2 + b * 16] + this.i.nextDouble() * 0.2D > 0.0D) ? true : false; int i = (int)(this.s[b2 + b * 16] / 3.0D + 3.0D + this.i.nextDouble() * 0.25D); int j = -1; Block block1 = Blocks.NETHERRACK; Block block2 = Blocks.NETHERRACK; for (byte b3 = 127; b3 >= 0; b3--) { int k = (b * 16 + b2) * 128 + b3; if (b3 >= 127 - this.i.nextInt(5) || b3 <= 0 + this.i.nextInt(5)) { paramArrayOfBlock[k] = Blocks.BEDROCK; } else { Block block = paramArrayOfBlock[k]; if (block == null || block.getMaterial() == Material.AIR) { j = -1; } else if (block == Blocks.NETHERRACK) { if (j == -1) { if (i <= 0) { block1 = null; block2 = Blocks.NETHERRACK; } else if (b3 >= b1 - 4 && b3 <= b1 + 1) { block1 = Blocks.NETHERRACK; block2 = Blocks.NETHERRACK; if (bool2) { block1 = Blocks.GRAVEL; block2 = Blocks.NETHERRACK; }  if (bool1) { block1 = Blocks.SOUL_SAND; block2 = Blocks.SOUL_SAND; }  }  if (b3 < b1 && (block1 == null || block1.getMaterial() == Material.AIR))
/*     */                   block1 = Blocks.STATIONARY_LAVA;  j = i; if (b3 >= b1 - 1) { paramArrayOfBlock[k] = block1; } else { paramArrayOfBlock[k] = block2; }  } else if (j > 0) { j--; paramArrayOfBlock[k] = block2; }  }  }
/*     */            }
/*     */          }
/*     */        }
/* 225 */      } private double[] a(double[] paramArrayOfdouble, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, int paramInt6) { if (paramArrayOfdouble == null) {
/* 226 */       paramArrayOfdouble = new double[paramInt4 * paramInt5 * paramInt6];
/*     */     }
/*     */     
/* 229 */     double d1 = 684.412D;
/* 230 */     double d2 = 2053.236D;
/*     */     
/* 232 */     this.g = this.a.a(this.g, paramInt1, paramInt2, paramInt3, paramInt4, 1, paramInt6, 1.0D, 0.0D, 1.0D);
/* 233 */     this.h = this.b.a(this.h, paramInt1, paramInt2, paramInt3, paramInt4, 1, paramInt6, 100.0D, 0.0D, 100.0D);
/*     */     
/* 235 */     this.d = this.l.a(this.d, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, d1 / 80.0D, d2 / 60.0D, d1 / 80.0D);
/* 236 */     this.e = this.j.a(this.e, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, d1, d2, d1);
/* 237 */     this.f = this.k.a(this.f, paramInt1, paramInt2, paramInt3, paramInt4, paramInt5, paramInt6, d1, d2, d1);
/*     */     
/* 239 */     byte b1 = 0;
/* 240 */     byte b2 = 0;
/* 241 */     double[] arrayOfDouble = new double[paramInt5]; byte b3;
/* 242 */     for (b3 = 0; b3 < paramInt5; b3++) {
/* 243 */       arrayOfDouble[b3] = Math.cos(b3 * Math.PI * 6.0D / paramInt5) * 2.0D;
/*     */       
/* 245 */       double d = b3;
/* 246 */       if (b3 > paramInt5 / 2) {
/* 247 */         d = (paramInt5 - 1 - b3);
/*     */       }
/* 249 */       if (d < 4.0D) {
/* 250 */         d = 4.0D - d;
/* 251 */         arrayOfDouble[b3] = arrayOfDouble[b3] - d * d * d * 10.0D;
/*     */       } 
/*     */     } 
/*     */     
/* 255 */     for (b3 = 0; b3 < paramInt4; b3++) {
/*     */       
/* 257 */       for (byte b = 0; b < paramInt6; b++) {
/*     */         
/* 259 */         double d3 = (this.g[b2] + 256.0D) / 512.0D;
/* 260 */         if (d3 > 1.0D) d3 = 1.0D;
/*     */         
/* 262 */         double d4 = 0.0D;
/*     */         
/* 264 */         double d5 = this.h[b2] / 8000.0D;
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
/* 279 */         d5 = d5 * paramInt5 / 16.0D;
/* 280 */         b2++;
/*     */         
/* 282 */         for (byte b4 = 0; b4 < paramInt5; b4++) {
/* 283 */           double d6 = 0.0D;
/*     */           
/* 285 */           double d7 = arrayOfDouble[b4];
/*     */           
/* 287 */           double d8 = this.e[b1] / 512.0D;
/* 288 */           double d9 = this.f[b1] / 512.0D;
/*     */           
/* 290 */           double d10 = (this.d[b1] / 10.0D + 1.0D) / 2.0D;
/* 291 */           if (d10 < 0.0D) { d6 = d8; }
/* 292 */           else if (d10 > 1.0D) { d6 = d9; }
/* 293 */           else { d6 = d8 + (d9 - d8) * d10; }
/* 294 */            d6 -= d7;
/*     */           
/* 296 */           if (b4 > paramInt5 - 4) {
/* 297 */             double d = ((b4 - paramInt5 - 4) / 3.0F);
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
/* 308 */           paramArrayOfdouble[b1] = d6;
/* 309 */           b1++;
/*     */         } 
/*     */       } 
/*     */     } 
/* 313 */     return paramArrayOfdouble; }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isChunkLoaded(int paramInt1, int paramInt2) {
/* 318 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void getChunkAt(IChunkProvider paramIChunkProvider, int paramInt1, int paramInt2) {
/* 323 */     BlockFalling.instaFall = true;
/* 324 */     int i = paramInt1 * 16;
/* 325 */     int j = paramInt2 * 16;
/*     */     
/* 327 */     this.c.a(this.o, this.i, paramInt1, paramInt2);
/*     */     int k;
/* 329 */     for (k = 0; k < 8; k++) {
/* 330 */       int n = i + this.i.nextInt(16) + 8;
/* 331 */       int i1 = this.i.nextInt(120) + 4;
/* 332 */       int i2 = j + this.i.nextInt(16) + 8;
/* 333 */       (new WorldGenHellLava(Blocks.LAVA, false)).generate(this.o, this.i, n, i1, i2);
/*     */     } 
/*     */     
/* 336 */     k = this.i.nextInt(this.i.nextInt(10) + 1) + 1;
/*     */     int m;
/* 338 */     for (m = 0; m < k; m++) {
/* 339 */       int n = i + this.i.nextInt(16) + 8;
/* 340 */       int i1 = this.i.nextInt(120) + 4;
/* 341 */       int i2 = j + this.i.nextInt(16) + 8;
/* 342 */       (new WorldGenFire()).generate(this.o, this.i, n, i1, i2);
/*     */     } 
/*     */     
/* 345 */     k = this.i.nextInt(this.i.nextInt(10) + 1);
/* 346 */     for (m = 0; m < k; m++) {
/* 347 */       int n = i + this.i.nextInt(16) + 8;
/* 348 */       int i1 = this.i.nextInt(120) + 4;
/* 349 */       int i2 = j + this.i.nextInt(16) + 8;
/* 350 */       (new WorldGenLightStone1()).generate(this.o, this.i, n, i1, i2);
/*     */     } 
/*     */     
/* 353 */     for (m = 0; m < 10; m++) {
/* 354 */       int n = i + this.i.nextInt(16) + 8;
/* 355 */       int i1 = this.i.nextInt(128);
/* 356 */       int i2 = j + this.i.nextInt(16) + 8;
/* 357 */       (new WorldGenLightStone2()).generate(this.o, this.i, n, i1, i2);
/*     */     } 
/*     */     
/* 360 */     if (this.i.nextInt(1) == 0) {
/* 361 */       m = i + this.i.nextInt(16) + 8;
/* 362 */       int n = this.i.nextInt(128);
/* 363 */       int i1 = j + this.i.nextInt(16) + 8;
/* 364 */       (new WorldGenFlowers(Blocks.BROWN_MUSHROOM)).generate(this.o, this.i, m, n, i1);
/*     */     } 
/*     */     
/* 367 */     if (this.i.nextInt(1) == 0) {
/* 368 */       m = i + this.i.nextInt(16) + 8;
/* 369 */       int n = this.i.nextInt(128);
/* 370 */       int i1 = j + this.i.nextInt(16) + 8;
/* 371 */       (new WorldGenFlowers(Blocks.RED_MUSHROOM)).generate(this.o, this.i, m, n, i1);
/*     */     } 
/*     */     
/* 374 */     WorldGenMinable worldGenMinable = new WorldGenMinable(Blocks.QUARTZ_ORE, 13, Blocks.NETHERRACK); byte b;
/* 375 */     for (b = 0; b < 16; b++) {
/* 376 */       int n = i + this.i.nextInt(16);
/* 377 */       int i1 = this.i.nextInt(108) + 10;
/* 378 */       int i2 = j + this.i.nextInt(16);
/* 379 */       worldGenMinable.generate(this.o, this.i, n, i1, i2);
/*     */     } 
/*     */     
/* 382 */     for (b = 0; b < 16; b++) {
/* 383 */       int n = i + this.i.nextInt(16);
/* 384 */       int i1 = this.i.nextInt(108) + 10;
/* 385 */       int i2 = j + this.i.nextInt(16);
/* 386 */       (new WorldGenHellLava(Blocks.LAVA, true)).generate(this.o, this.i, n, i1, i2);
/*     */     } 
/*     */ 
/*     */     
/* 390 */     BlockFalling.instaFall = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean saveChunks(boolean paramBoolean, IProgressUpdate paramIProgressUpdate) {
/* 395 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void c() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unloadChunks() {
/* 405 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canSave() {
/* 410 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 416 */     return "HellRandomLevelSource";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List getMobsFor(EnumCreatureType paramEnumCreatureType, int paramInt1, int paramInt2, int paramInt3) {
/* 423 */     if (paramEnumCreatureType == EnumCreatureType.MONSTER) {
/* 424 */       if (this.c.b(paramInt1, paramInt2, paramInt3)) {
/* 425 */         return this.c.b();
/*     */       }
/* 427 */       if (this.c.d(paramInt1, paramInt2, paramInt3) && this.o.getType(paramInt1, paramInt2 - 1, paramInt3) == Blocks.NETHER_BRICK) {
/* 428 */         return this.c.b();
/*     */       }
/*     */     } 
/*     */     
/* 432 */     BiomeBase biomeBase = this.o.getBiome(paramInt1, paramInt3);
/* 433 */     return biomeBase.getMobs(paramEnumCreatureType);
/*     */   }
/*     */ 
/*     */   
/*     */   public ChunkPosition findNearestMapFeature(World paramWorld, String paramString, int paramInt1, int paramInt2, int paramInt3) {
/* 438 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLoadedChunks() {
/* 443 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void recreateStructures(int paramInt1, int paramInt2) {
/* 448 */     this.c.a(this, this.o, paramInt1, paramInt2, null);
/*     */   } }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ChunkProviderHell.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */