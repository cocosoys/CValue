/*     */ package net.minecraft.world.gen;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockFalling;
/*     */ import net.minecraft.entity.EnumCreatureType;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.IProgressUpdate;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.ChunkPosition;
/*     */ import net.minecraft.world.SpawnerAnimals;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldType;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraft.world.gen.feature.WorldGenDungeons;
/*     */ import net.minecraft.world.gen.feature.WorldGenLakes;
/*     */ import net.minecraft.world.gen.structure.MapGenMineshaft;
/*     */ import net.minecraft.world.gen.structure.MapGenScatteredFeature;
/*     */ import net.minecraft.world.gen.structure.MapGenStronghold;
/*     */ import net.minecraft.world.gen.structure.MapGenVillage;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */   private Random field_73220_k;
/*     */   private NoiseGeneratorOctaves field_147431_j;
/*     */   private NoiseGeneratorOctaves field_147432_k;
/*     */   private NoiseGeneratorOctaves field_147429_l;
/*     */   private NoiseGeneratorPerlin field_147430_m;
/*     */   public NoiseGeneratorOctaves field_73214_a;
/*     */   public NoiseGeneratorOctaves field_73212_b;
/*     */   public NoiseGeneratorOctaves field_73213_c;
/*     */   private World field_73230_p;
/*     */   private final boolean field_73229_q;
/*     */   private WorldType field_147435_p;
/*     */   private final double[] field_147434_q;
/*     */   private final float[] field_147433_r;
/*     */   private double[] field_73227_s;
/*     */   private MapGenBase field_73226_t;
/*     */   private MapGenStronghold field_73225_u;
/*     */   private MapGenVillage field_73224_v;
/*     */   private MapGenMineshaft field_73223_w;
/*     */   private MapGenScatteredFeature field_73233_x;
/*     */   private MapGenBase field_73232_y;
/*     */   private BiomeGenBase[] field_73231_z;
/*     */   double[] field_147427_d;
/*     */   double[] field_147428_e;
/*     */   double[] field_147425_f;
/*     */   double[] field_147426_g;
/*     */   int[][] field_73219_j;
/*     */   private static final String __OBFID = "CL_00000396";
/*     */   
/*     */   public ChunkProviderGenerate(World p_i2006_1_, long p_i2006_2_, boolean p_i2006_4_) {
/* 155 */     this.field_73227_s = new double[256];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 170 */     this.field_73226_t = new MapGenCaves();
/* 171 */     this.field_73225_u = new MapGenStronghold();
/* 172 */     this.field_73224_v = new MapGenVillage();
/* 173 */     this.field_73223_w = new MapGenMineshaft();
/* 174 */     this.field_73233_x = new MapGenScatteredFeature();
/* 175 */     this.field_73232_y = new MapGenRavine();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 337 */     this.field_73219_j = new int[32][32]; this.field_73230_p = p_i2006_1_; this.field_73229_q = p_i2006_4_; this.field_147435_p = p_i2006_1_.func_72912_H().func_76067_t(); this.field_73220_k = new Random(p_i2006_2_); this.field_147431_j = new NoiseGeneratorOctaves(this.field_73220_k, 16); this.field_147432_k = new NoiseGeneratorOctaves(this.field_73220_k, 16); this.field_147429_l = new NoiseGeneratorOctaves(this.field_73220_k, 8); this.field_147430_m = new NoiseGeneratorPerlin(this.field_73220_k, 4); this.field_73214_a = new NoiseGeneratorOctaves(this.field_73220_k, 10); this.field_73212_b = new NoiseGeneratorOctaves(this.field_73220_k, 16); this.field_73213_c = new NoiseGeneratorOctaves(this.field_73220_k, 8); this.field_147434_q = new double[825]; this.field_147433_r = new float[25]; for (byte b = -2; b <= 2; b++) {
/*     */       for (byte b1 = -2; b1 <= 2; b1++) {
/*     */         float f = 10.0F / MathHelper.func_76129_c((b * b + b1 * b1) + 0.2F); this.field_147433_r[b + 2 + (b1 + 2) * 5] = f;
/*     */       } 
/*     */     } 
/*     */   } public void func_147424_a(int p_147424_1_, int p_147424_2_, Block[] p_147424_3_) { byte b1 = 63; this.field_73231_z = this.field_73230_p.func_72959_q().func_76937_a(this.field_73231_z, p_147424_1_ * 4 - 2, p_147424_2_ * 4 - 2, 10, 10); func_147423_a(p_147424_1_ * 4, 0, p_147424_2_ * 4); for (byte b2 = 0; b2 < 4; b2++) {
/*     */       int i = b2 * 5; int j = (b2 + 1) * 5; for (byte b = 0; b < 4; b++) {
/*     */         int k = (i + b) * 33; int m = (i + b + 1) * 33; int n = (j + b) * 33; int i1 = (j + b + 1) * 33; for (byte b3 = 0; b3 < 32; b3++) {
/*     */           double d1 = 0.125D; double d2 = this.field_147434_q[k + b3]; double d3 = this.field_147434_q[m + b3]; double d4 = this.field_147434_q[n + b3]; double d5 = this.field_147434_q[i1 + b3]; double d6 = (this.field_147434_q[k + b3 + 1] - d2) * d1; double d7 = (this.field_147434_q[m + b3 + 1] - d3) * d1; double d8 = (this.field_147434_q[n + b3 + 1] - d4) * d1; double d9 = (this.field_147434_q[i1 + b3 + 1] - d5) * d1; for (byte b4 = 0; b4 < 8; b4++) {
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
/*     */                   p_147424_3_[i2 += c] = Blocks.field_150348_b;
/*     */                 } else if (b3 * 8 + b4 < b1) {
/*     */                   p_147424_3_[i2 += c] = Blocks.field_150355_j;
/*     */                 } else {
/*     */                   p_147424_3_[i2 += c] = null;
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
/*     */     }  } public void func_147422_a(int p_147422_1_, int p_147422_2_, Block[] p_147422_3_, byte[] p_147422_4_, BiomeGenBase[] p_147422_5_) { double d = 0.03125D;
/*     */     this.field_73227_s = this.field_147430_m.func_151599_a(this.field_73227_s, (p_147422_1_ * 16), (p_147422_2_ * 16), 16, 16, d * 2.0D, d * 2.0D, 1.0D);
/*     */     for (byte b = 0; b < 16; b++) {
/*     */       for (byte b1 = 0; b1 < 16; b1++) {
/*     */         BiomeGenBase biomeGenBase = p_147422_5_[b1 + b * 16];
/*     */         biomeGenBase.func_150573_a(this.field_73230_p, this.field_73220_k, p_147422_3_, p_147422_4_, p_147422_1_ * 16 + b, p_147422_2_ * 16 + b1, this.field_73227_s[b1 + b * 16]);
/*     */       } 
/*     */     }  }
/*     */   public Chunk func_73158_c(int p_73158_1_, int p_73158_2_) { return func_73154_d(p_73158_1_, p_73158_2_); }
/* 386 */   public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) { BlockFalling.field_149832_M = true;
/* 387 */     int i = p_73153_2_ * 16;
/* 388 */     int j = p_73153_3_ * 16;
/* 389 */     BiomeGenBase biomeGenBase = this.field_73230_p.func_72807_a(i + 16, j + 16);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 395 */     this.field_73220_k.setSeed(this.field_73230_p.func_72905_C());
/* 396 */     long l1 = this.field_73220_k.nextLong() / 2L * 2L + 1L;
/* 397 */     long l2 = this.field_73220_k.nextLong() / 2L * 2L + 1L;
/* 398 */     this.field_73220_k.setSeed(p_73153_2_ * l1 + p_73153_3_ * l2 ^ this.field_73230_p.func_72905_C());
/*     */     
/* 400 */     boolean bool = false;
/*     */     
/* 402 */     if (this.field_73229_q) {
/* 403 */       this.field_73223_w.func_75051_a(this.field_73230_p, this.field_73220_k, p_73153_2_, p_73153_3_);
/* 404 */       bool = this.field_73224_v.func_75051_a(this.field_73230_p, this.field_73220_k, p_73153_2_, p_73153_3_);
/* 405 */       this.field_73225_u.func_75051_a(this.field_73230_p, this.field_73220_k, p_73153_2_, p_73153_3_);
/* 406 */       this.field_73233_x.func_75051_a(this.field_73230_p, this.field_73220_k, p_73153_2_, p_73153_3_);
/*     */     } 
/*     */     
/* 409 */     if (biomeGenBase != BiomeGenBase.field_76769_d && biomeGenBase != BiomeGenBase.field_76786_s && 
/* 410 */       !bool && this.field_73220_k.nextInt(4) == 0) {
/* 411 */       int k = i + this.field_73220_k.nextInt(16) + 8;
/* 412 */       int m = this.field_73220_k.nextInt(256);
/* 413 */       int n = j + this.field_73220_k.nextInt(16) + 8;
/* 414 */       (new WorldGenLakes(Blocks.field_150355_j)).func_76484_a(this.field_73230_p, this.field_73220_k, k, m, n);
/*     */     } 
/*     */ 
/*     */     
/* 418 */     if (!bool && this.field_73220_k.nextInt(8) == 0) {
/* 419 */       int k = i + this.field_73220_k.nextInt(16) + 8;
/* 420 */       int m = this.field_73220_k.nextInt(this.field_73220_k.nextInt(248) + 8);
/* 421 */       int n = j + this.field_73220_k.nextInt(16) + 8;
/* 422 */       if (m < 63 || this.field_73220_k.nextInt(10) == 0) (new WorldGenLakes(Blocks.field_150353_l)).func_76484_a(this.field_73230_p, this.field_73220_k, k, m, n); 
/*     */     } 
/*     */     byte b;
/* 425 */     for (b = 0; b < 8; b++) {
/* 426 */       int k = i + this.field_73220_k.nextInt(16) + 8;
/* 427 */       int m = this.field_73220_k.nextInt(256);
/* 428 */       int n = j + this.field_73220_k.nextInt(16) + 8;
/* 429 */       (new WorldGenDungeons()).func_76484_a(this.field_73230_p, this.field_73220_k, k, m, n);
/*     */     } 
/*     */     
/* 432 */     biomeGenBase.func_76728_a(this.field_73230_p, this.field_73220_k, i, j);
/*     */     
/* 434 */     SpawnerAnimals.func_77191_a(this.field_73230_p, biomeGenBase, i + 8, j + 8, 16, 16, this.field_73220_k);
/*     */     
/* 436 */     i += 8;
/* 437 */     j += 8;
/* 438 */     for (b = 0; b < 16; b++) {
/* 439 */       for (byte b1 = 0; b1 < 16; b1++) {
/* 440 */         int k = this.field_73230_p.func_72874_g(i + b, j + b1);
/*     */         
/* 442 */         if (this.field_73230_p.func_72884_u(b + i, k - 1, b1 + j)) {
/* 443 */           this.field_73230_p.func_147465_d(b + i, k - 1, b1 + j, Blocks.field_150432_aD, 0, 2);
/*     */         }
/* 445 */         if (this.field_73230_p.func_147478_e(b + i, k, b1 + j, true)) {
/* 446 */           this.field_73230_p.func_147465_d(b + i, k, b1 + j, Blocks.field_150431_aC, 0, 2);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 451 */     BlockFalling.field_149832_M = false; } public Chunk func_73154_d(int p_73154_1_, int p_73154_2_) { this.field_73220_k.setSeed(p_73154_1_ * 341873128712L + p_73154_2_ * 132897987541L); Block[] arrayOfBlock = new Block[65536]; byte[] arrayOfByte1 = new byte[65536]; func_147424_a(p_73154_1_, p_73154_2_, arrayOfBlock); this.field_73231_z = this.field_73230_p.func_72959_q().func_76933_b(this.field_73231_z, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16); func_147422_a(p_73154_1_, p_73154_2_, arrayOfBlock, arrayOfByte1, this.field_73231_z); this.field_73226_t.func_151539_a(this, this.field_73230_p, p_73154_1_, p_73154_2_, arrayOfBlock); this.field_73232_y.func_151539_a(this, this.field_73230_p, p_73154_1_, p_73154_2_, arrayOfBlock); if (this.field_73229_q) {
/*     */       this.field_73223_w.func_151539_a(this, this.field_73230_p, p_73154_1_, p_73154_2_, arrayOfBlock); this.field_73224_v.func_151539_a(this, this.field_73230_p, p_73154_1_, p_73154_2_, arrayOfBlock); this.field_73225_u.func_151539_a(this, this.field_73230_p, p_73154_1_, p_73154_2_, arrayOfBlock); this.field_73233_x.func_151539_a(this, this.field_73230_p, p_73154_1_, p_73154_2_, arrayOfBlock);
/*     */     }  Chunk chunk = new Chunk(this.field_73230_p, arrayOfBlock, arrayOfByte1, p_73154_1_, p_73154_2_); byte[] arrayOfByte2 = chunk.func_76605_m(); for (byte b = 0; b < arrayOfByte2.length; b++)
/*     */       arrayOfByte2[b] = (byte)(this.field_73231_z[b]).field_76756_M;  chunk.func_76603_b();
/*     */     return chunk; }
/* 456 */   public boolean func_73151_a(boolean p_73151_1_, IProgressUpdate p_73151_2_) { return true; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73156_b() {
/* 465 */     return false;
/*     */   }
/*     */   private void func_147423_a(int p_147423_1_, int p_147423_2_, int p_147423_3_) { double d1 = 684.412D; double d2 = 684.412D; double d3 = 512.0D; double d4 = 512.0D; this.field_147426_g = this.field_73212_b.func_76305_a(this.field_147426_g, p_147423_1_, p_147423_3_, 5, 5, 200.0D, 200.0D, 0.5D); this.field_147427_d = this.field_147429_l.func_76304_a(this.field_147427_d, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D); this.field_147428_e = this.field_147431_j.func_76304_a(this.field_147428_e, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D); this.field_147425_f = this.field_147432_k.func_76304_a(this.field_147425_f, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D); p_147423_1_ = p_147423_3_ = 0; byte b1 = 0; byte b2 = 0; double d5 = 8.5D; for (byte b3 = 0; b3 < 5; b3++) { for (byte b = 0; b < 5; b++) { float f1 = 0.0F; float f2 = 0.0F; float f3 = 0.0F; byte b4 = 2; BiomeGenBase biomeGenBase = this.field_73231_z[b3 + 2 + (b + 2) * 10]; for (byte b5 = -b4; b5 <= b4; b5++) { for (byte b7 = -b4; b7 <= b4; b7++) { BiomeGenBase biomeGenBase1 = this.field_73231_z[b3 + b5 + 2 + (b + b7 + 2) * 10]; float f4 = biomeGenBase1.field_76748_D; float f5 = biomeGenBase1.field_76749_E; if (this.field_147435_p == WorldType.field_151360_e && f4 > 0.0F) { f4 = 1.0F + f4 * 2.0F; f5 = 1.0F + f5 * 4.0F; }  float f6 = this.field_147433_r[b5 + 2 + (b7 + 2) * 5] / (f4 + 2.0F); if (biomeGenBase1.field_76748_D > biomeGenBase.field_76748_D) f6 /= 2.0F;  f1 += f5 * f6; f2 += f4 * f6; f3 += f6; }  }  f1 /= f3; f2 /= f3; f1 = f1 * 0.9F + 0.1F; f2 = (f2 * 4.0F - 1.0F) / 8.0F; double d6 = this.field_147426_g[b2] / 8000.0D; if (d6 < 0.0D) d6 = -d6 * 0.3D;  d6 = d6 * 3.0D - 2.0D; if (d6 < 0.0D) { d6 /= 2.0D; if (d6 < -1.0D)
/*     */             d6 = -1.0D;  d6 /= 1.4D; d6 /= 2.0D; } else { if (d6 > 1.0D)
/*     */             d6 = 1.0D;  d6 /= 8.0D; }  b2++; double d7 = f2; double d8 = f1; d7 += d6 * 0.2D; d7 = d7 * 8.5D / 8.0D; double d9 = 8.5D + d7 * 4.0D; for (byte b6 = 0; b6 < 33; b6++) { double d10 = (b6 - d9) * 12.0D * 128.0D / 256.0D / d8; if (d10 < 0.0D)
/* 470 */             d10 *= 4.0D;  double d11 = this.field_147428_e[b1] / 512.0D; double d12 = this.field_147425_f[b1] / 512.0D; double d13 = (this.field_147427_d[b1] / 10.0D + 1.0D) / 2.0D; double d14 = MathHelper.func_151238_b(d11, d12, d13) - d10; if (b6 > 29) { double d = ((b6 - 29) / 3.0F); d14 = d14 * (1.0D - d) + -10.0D * d; }  this.field_147434_q[b1] = d14; b1++; }  }  }  } public boolean func_73149_a(int p_73149_1_, int p_73149_2_) { return true; } public void func_104112_b() {} public boolean func_73157_c() { return true; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_73148_d() {
/* 476 */     return "RandomLevelSource";
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
/* 481 */     BiomeGenBase biomeGenBase = this.field_73230_p.func_72807_a(p_73155_2_, p_73155_4_);
/* 482 */     if (p_73155_1_ == EnumCreatureType.monster && this.field_73233_x.func_143030_a(p_73155_2_, p_73155_3_, p_73155_4_)) {
/* 483 */       return this.field_73233_x.func_82667_a();
/*     */     }
/* 485 */     return biomeGenBase.func_76747_a(p_73155_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
/* 490 */     if ("Stronghold".equals(p_147416_2_) && this.field_73225_u != null) {
/* 491 */       return this.field_73225_u.func_151545_a(p_147416_1_, p_147416_3_, p_147416_4_, p_147416_5_);
/*     */     }
/* 493 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_73152_e() {
/* 498 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_82695_e(int p_82695_1_, int p_82695_2_) {
/* 503 */     if (this.field_73229_q) {
/* 504 */       this.field_73223_w.func_151539_a(this, this.field_73230_p, p_82695_1_, p_82695_2_, null);
/* 505 */       this.field_73224_v.func_151539_a(this, this.field_73230_p, p_82695_1_, p_82695_2_, null);
/* 506 */       this.field_73225_u.func_151539_a(this, this.field_73230_p, p_82695_1_, p_82695_2_, null);
/* 507 */       this.field_73233_x.func_151539_a(this, this.field_73230_p, p_82695_1_, p_82695_2_, null);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\ChunkProviderGenerate.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */