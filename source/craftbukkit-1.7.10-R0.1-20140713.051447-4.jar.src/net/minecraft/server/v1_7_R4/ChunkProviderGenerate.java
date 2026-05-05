/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChunkProviderGenerate
/*     */   implements IChunkProvider
/*     */ {
/*     */   private Random i;
/*     */   private NoiseGeneratorOctaves j;
/*     */   private NoiseGeneratorOctaves k;
/*     */   private NoiseGeneratorOctaves l;
/*     */   private NoiseGenerator3 m;
/*     */   public NoiseGeneratorOctaves a;
/*     */   public NoiseGeneratorOctaves b;
/*     */   public NoiseGeneratorOctaves c;
/*     */   private World n;
/*     */   private final boolean o;
/*     */   private WorldType p;
/*     */   private final double[] q;
/*     */   private final float[] r;
/*     */   private double[] s;
/*     */   private WorldGenBase t;
/*     */   private WorldGenStronghold u;
/*     */   private WorldGenVillage v;
/*     */   private WorldGenMineshaft w;
/*     */   private WorldGenLargeFeature x;
/*     */   private WorldGenBase y;
/*     */   private BiomeBase[] z;
/*     */   double[] d;
/*     */   double[] e;
/*     */   double[] f;
/*     */   double[] g;
/*     */   int[][] h;
/*     */   
/*     */   public ChunkProviderGenerate(World paramWorld, long paramLong, boolean paramBoolean) {
/* 155 */     this.s = new double[256];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 170 */     this.t = new WorldGenCaves();
/* 171 */     this.u = new WorldGenStronghold();
/* 172 */     this.v = new WorldGenVillage();
/* 173 */     this.w = new WorldGenMineshaft();
/* 174 */     this.x = new WorldGenLargeFeature();
/* 175 */     this.y = new WorldGenCanyon();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 337 */     this.h = new int[32][32]; this.n = paramWorld; this.o = paramBoolean; this.p = paramWorld.getWorldData().getType(); this.i = new Random(paramLong); this.j = new NoiseGeneratorOctaves(this.i, 16); this.k = new NoiseGeneratorOctaves(this.i, 16); this.l = new NoiseGeneratorOctaves(this.i, 8); this.m = new NoiseGenerator3(this.i, 4); this.a = new NoiseGeneratorOctaves(this.i, 10); this.b = new NoiseGeneratorOctaves(this.i, 16); this.c = new NoiseGeneratorOctaves(this.i, 8); this.q = new double[825]; this.r = new float[25]; for (byte b = -2; b <= 2; b++) {
/*     */       for (byte b1 = -2; b1 <= 2; b1++) {
/*     */         float f = 10.0F / MathHelper.c((b * b + b1 * b1) + 0.2F); this.r[b + 2 + (b1 + 2) * 5] = f;
/*     */       } 
/*     */     } 
/*     */   } public void a(int paramInt1, int paramInt2, Block[] paramArrayOfBlock) { byte b1 = 63; this.z = this.n.getWorldChunkManager().getBiomes(this.z, paramInt1 * 4 - 2, paramInt2 * 4 - 2, 10, 10); a(paramInt1 * 4, 0, paramInt2 * 4); for (byte b2 = 0; b2 < 4; b2++) {
/*     */       int i = b2 * 5; int j = (b2 + 1) * 5; for (byte b = 0; b < 4; b++) {
/*     */         int k = (i + b) * 33; int m = (i + b + 1) * 33; int n = (j + b) * 33; int i1 = (j + b + 1) * 33; for (byte b3 = 0; b3 < 32; b3++) {
/*     */           double d1 = 0.125D; double d2 = this.q[k + b3]; double d3 = this.q[m + b3]; double d4 = this.q[n + b3]; double d5 = this.q[i1 + b3]; double d6 = (this.q[k + b3 + 1] - d2) * d1; double d7 = (this.q[m + b3 + 1] - d3) * d1; double d8 = (this.q[n + b3 + 1] - d4) * d1; double d9 = (this.q[i1 + b3 + 1] - d5) * d1; for (byte b4 = 0; b4 < 8; b4++) {
/*     */             double d10 = 0.25D; double d11 = d2;
/*     */             double d12 = d3;
/*     */             double d13 = (d4 - d2) * d10;
/*     */             double d14 = (d5 - d3) * d10;
/*     */             for (byte b5 = 0; b5 < 4; b5++) {
/*     */               int i2 = b5 + b2 * 4 << 12 | 0 + b * 4 << 8 | b3 * 8 + b4;
/*     */               char c = 'Ā';
/*     */               i2 -= c;
/*     */               double d15 = 0.25D;
/*     */               double d16 = d11;
/*     */               double d17 = (d12 - d11) * d15;
/*     */               d16 -= d17;
/*     */               for (byte b6 = 0; b6 < 4; b6++) {
/*     */                 if ((d16 += d17) > 0.0D) {
/*     */                   paramArrayOfBlock[i2 += c] = Blocks.STONE;
/*     */                 } else if (b3 * 8 + b4 < b1) {
/*     */                   paramArrayOfBlock[i2 += c] = Blocks.STATIONARY_WATER;
/*     */                 } else {
/*     */                   paramArrayOfBlock[i2 += c] = null;
/*     */                 } 
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
/*     */     }  } public void a(int paramInt1, int paramInt2, Block[] paramArrayOfBlock, byte[] paramArrayOfbyte, BiomeBase[] paramArrayOfBiomeBase) { double d = 0.03125D;
/*     */     this.s = this.m.a(this.s, (paramInt1 * 16), (paramInt2 * 16), 16, 16, d * 2.0D, d * 2.0D, 1.0D);
/*     */     for (byte b = 0; b < 16; b++) {
/*     */       for (byte b1 = 0; b1 < 16; b1++) {
/*     */         BiomeBase biomeBase = paramArrayOfBiomeBase[b1 + b * 16];
/*     */         biomeBase.a(this.n, this.i, paramArrayOfBlock, paramArrayOfbyte, paramInt1 * 16 + b, paramInt2 * 16 + b1, this.s[b1 + b * 16]);
/*     */       } 
/*     */     }  }
/*     */   public Chunk getChunkAt(int paramInt1, int paramInt2) { return getOrCreateChunk(paramInt1, paramInt2); }
/* 386 */   public void getChunkAt(IChunkProvider paramIChunkProvider, int paramInt1, int paramInt2) { BlockFalling.instaFall = true;
/* 387 */     int i = paramInt1 * 16;
/* 388 */     int j = paramInt2 * 16;
/* 389 */     BiomeBase biomeBase = this.n.getBiome(i + 16, j + 16);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 395 */     this.i.setSeed(this.n.getSeed());
/* 396 */     long l1 = this.i.nextLong() / 2L * 2L + 1L;
/* 397 */     long l2 = this.i.nextLong() / 2L * 2L + 1L;
/* 398 */     this.i.setSeed(paramInt1 * l1 + paramInt2 * l2 ^ this.n.getSeed());
/*     */     
/* 400 */     boolean bool = false;
/*     */     
/* 402 */     if (this.o) {
/* 403 */       this.w.a(this.n, this.i, paramInt1, paramInt2);
/* 404 */       bool = this.v.a(this.n, this.i, paramInt1, paramInt2);
/* 405 */       this.u.a(this.n, this.i, paramInt1, paramInt2);
/* 406 */       this.x.a(this.n, this.i, paramInt1, paramInt2);
/*     */     } 
/*     */     
/* 409 */     if (biomeBase != BiomeBase.DESERT && biomeBase != BiomeBase.DESERT_HILLS && 
/* 410 */       !bool && this.i.nextInt(4) == 0) {
/* 411 */       int k = i + this.i.nextInt(16) + 8;
/* 412 */       int m = this.i.nextInt(256);
/* 413 */       int n = j + this.i.nextInt(16) + 8;
/* 414 */       (new WorldGenLakes(Blocks.STATIONARY_WATER)).generate(this.n, this.i, k, m, n);
/*     */     } 
/*     */ 
/*     */     
/* 418 */     if (!bool && this.i.nextInt(8) == 0) {
/* 419 */       int k = i + this.i.nextInt(16) + 8;
/* 420 */       int m = this.i.nextInt(this.i.nextInt(248) + 8);
/* 421 */       int n = j + this.i.nextInt(16) + 8;
/* 422 */       if (m < 63 || this.i.nextInt(10) == 0) (new WorldGenLakes(Blocks.STATIONARY_LAVA)).generate(this.n, this.i, k, m, n); 
/*     */     } 
/*     */     byte b;
/* 425 */     for (b = 0; b < 8; b++) {
/* 426 */       int k = i + this.i.nextInt(16) + 8;
/* 427 */       int m = this.i.nextInt(256);
/* 428 */       int n = j + this.i.nextInt(16) + 8;
/* 429 */       (new WorldGenDungeons()).generate(this.n, this.i, k, m, n);
/*     */     } 
/*     */     
/* 432 */     biomeBase.a(this.n, this.i, i, j);
/*     */     
/* 434 */     SpawnerCreature.a(this.n, biomeBase, i + 8, j + 8, 16, 16, this.i);
/*     */     
/* 436 */     i += 8;
/* 437 */     j += 8;
/* 438 */     for (b = 0; b < 16; b++) {
/* 439 */       for (byte b1 = 0; b1 < 16; b1++) {
/* 440 */         int k = this.n.h(i + b, j + b1);
/*     */         
/* 442 */         if (this.n.r(b + i, k - 1, b1 + j)) {
/* 443 */           this.n.setTypeAndData(b + i, k - 1, b1 + j, Blocks.ICE, 0, 2);
/*     */         }
/* 445 */         if (this.n.e(b + i, k, b1 + j, true)) {
/* 446 */           this.n.setTypeAndData(b + i, k, b1 + j, Blocks.SNOW, 0, 2);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 451 */     BlockFalling.instaFall = false; } public Chunk getOrCreateChunk(int paramInt1, int paramInt2) { this.i.setSeed(paramInt1 * 341873128712L + paramInt2 * 132897987541L); Block[] arrayOfBlock = new Block[65536]; byte[] arrayOfByte1 = new byte[65536]; a(paramInt1, paramInt2, arrayOfBlock); this.z = this.n.getWorldChunkManager().getBiomeBlock(this.z, paramInt1 * 16, paramInt2 * 16, 16, 16); a(paramInt1, paramInt2, arrayOfBlock, arrayOfByte1, this.z); this.t.a(this, this.n, paramInt1, paramInt2, arrayOfBlock); this.y.a(this, this.n, paramInt1, paramInt2, arrayOfBlock); if (this.o) {
/*     */       this.w.a(this, this.n, paramInt1, paramInt2, arrayOfBlock); this.v.a(this, this.n, paramInt1, paramInt2, arrayOfBlock); this.u.a(this, this.n, paramInt1, paramInt2, arrayOfBlock); this.x.a(this, this.n, paramInt1, paramInt2, arrayOfBlock);
/*     */     }  Chunk chunk = new Chunk(this.n, arrayOfBlock, arrayOfByte1, paramInt1, paramInt2); byte[] arrayOfByte2 = chunk.m(); for (byte b = 0; b < arrayOfByte2.length; b++)
/*     */       arrayOfByte2[b] = (byte)(this.z[b]).id;  chunk.initLighting();
/*     */     return chunk; }
/* 456 */   public boolean saveChunks(boolean paramBoolean, IProgressUpdate paramIProgressUpdate) { return true; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean unloadChunks() {
/* 465 */     return false;
/*     */   }
/*     */   private void a(int paramInt1, int paramInt2, int paramInt3) { double d1 = 684.412D; double d2 = 684.412D; double d3 = 512.0D; double d4 = 512.0D; this.g = this.b.a(this.g, paramInt1, paramInt3, 5, 5, 200.0D, 200.0D, 0.5D); this.d = this.l.a(this.d, paramInt1, paramInt2, paramInt3, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D); this.e = this.j.a(this.e, paramInt1, paramInt2, paramInt3, 5, 33, 5, 684.412D, 684.412D, 684.412D); this.f = this.k.a(this.f, paramInt1, paramInt2, paramInt3, 5, 33, 5, 684.412D, 684.412D, 684.412D); paramInt1 = paramInt3 = 0; byte b1 = 0; byte b2 = 0; double d5 = 8.5D; for (byte b3 = 0; b3 < 5; b3++) { for (byte b = 0; b < 5; b++) { float f1 = 0.0F; float f2 = 0.0F; float f3 = 0.0F; byte b4 = 2; BiomeBase biomeBase = this.z[b3 + 2 + (b + 2) * 10]; for (byte b5 = -b4; b5 <= b4; b5++) { for (byte b7 = -b4; b7 <= b4; b7++) { BiomeBase biomeBase1 = this.z[b3 + b5 + 2 + (b + b7 + 2) * 10]; float f4 = biomeBase1.am; float f5 = biomeBase1.an; if (this.p == WorldType.AMPLIFIED && f4 > 0.0F) { f4 = 1.0F + f4 * 2.0F; f5 = 1.0F + f5 * 4.0F; }  float f6 = this.r[b5 + 2 + (b7 + 2) * 5] / (f4 + 2.0F); if (biomeBase1.am > biomeBase.am) f6 /= 2.0F;  f1 += f5 * f6; f2 += f4 * f6; f3 += f6; }  }  f1 /= f3; f2 /= f3; f1 = f1 * 0.9F + 0.1F; f2 = (f2 * 4.0F - 1.0F) / 8.0F; double d6 = this.g[b2] / 8000.0D; if (d6 < 0.0D) d6 = -d6 * 0.3D;  d6 = d6 * 3.0D - 2.0D; if (d6 < 0.0D) { d6 /= 2.0D; if (d6 < -1.0D)
/*     */             d6 = -1.0D;  d6 /= 1.4D; d6 /= 2.0D; } else { if (d6 > 1.0D)
/*     */             d6 = 1.0D;  d6 /= 8.0D; }  b2++; double d7 = f2; double d8 = f1; d7 += d6 * 0.2D; d7 = d7 * 8.5D / 8.0D; double d9 = 8.5D + d7 * 4.0D; for (byte b6 = 0; b6 < 33; b6++) { double d10 = (b6 - d9) * 12.0D * 128.0D / 256.0D / d8; if (d10 < 0.0D)
/* 470 */             d10 *= 4.0D;  double d11 = this.e[b1] / 512.0D; double d12 = this.f[b1] / 512.0D; double d13 = (this.d[b1] / 10.0D + 1.0D) / 2.0D; double d14 = MathHelper.b(d11, d12, d13) - d10; if (b6 > 29) { double d = ((b6 - 29) / 3.0F); d14 = d14 * (1.0D - d) + -10.0D * d; }  this.q[b1] = d14; b1++; }  }  }  } public boolean isChunkLoaded(int paramInt1, int paramInt2) { return true; } public void c() {} public boolean canSave() { return true; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 476 */     return "RandomLevelSource";
/*     */   }
/*     */ 
/*     */   
/*     */   public List getMobsFor(EnumCreatureType paramEnumCreatureType, int paramInt1, int paramInt2, int paramInt3) {
/* 481 */     BiomeBase biomeBase = this.n.getBiome(paramInt1, paramInt3);
/* 482 */     if (paramEnumCreatureType == EnumCreatureType.MONSTER && this.x.a(paramInt1, paramInt2, paramInt3)) {
/* 483 */       return this.x.b();
/*     */     }
/* 485 */     return biomeBase.getMobs(paramEnumCreatureType);
/*     */   }
/*     */ 
/*     */   
/*     */   public ChunkPosition findNearestMapFeature(World paramWorld, String paramString, int paramInt1, int paramInt2, int paramInt3) {
/* 490 */     if ("Stronghold".equals(paramString) && this.u != null) {
/* 491 */       return this.u.getNearestGeneratedFeature(paramWorld, paramInt1, paramInt2, paramInt3);
/*     */     }
/* 493 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLoadedChunks() {
/* 498 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void recreateStructures(int paramInt1, int paramInt2) {
/* 503 */     if (this.o) {
/* 504 */       this.w.a(this, this.n, paramInt1, paramInt2, null);
/* 505 */       this.v.a(this, this.n, paramInt1, paramInt2, null);
/* 506 */       this.u.a(this, this.n, paramInt1, paramInt2, null);
/* 507 */       this.x.a(this, this.n, paramInt1, paramInt2, null);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ChunkProviderGenerate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */