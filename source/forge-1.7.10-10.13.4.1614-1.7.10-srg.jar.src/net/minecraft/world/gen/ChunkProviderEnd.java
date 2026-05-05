/*     */ package net.minecraft.world.gen;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockFalling;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.EnumCreatureType;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.IProgressUpdate;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.ChunkPosition;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChunkProviderEnd
/*     */   implements IChunkProvider
/*     */ {
/*     */   private Random field_73204_i;
/*     */   private NoiseGeneratorOctaves field_73201_j;
/*     */   private NoiseGeneratorOctaves field_73202_k;
/*     */   private NoiseGeneratorOctaves field_73199_l;
/*     */   public NoiseGeneratorOctaves field_73196_a;
/*     */   public NoiseGeneratorOctaves field_73194_b;
/*     */   private World field_73200_m;
/*     */   private double[] field_73197_n;
/*     */   private BiomeGenBase[] field_73198_o;
/*     */   double[] field_73195_c;
/*     */   double[] field_73192_d;
/*     */   double[] field_73193_e;
/*     */   double[] field_73190_f;
/*     */   double[] field_73191_g;
/*     */   int[][] field_73203_h;
/*     */   private static final String __OBFID = "CL_00000397";
/*     */   
/*     */   public ChunkProviderEnd(World p_i2007_1_, long p_i2007_2_) {
/* 269 */     this.field_73203_h = new int[32][32]; this.field_73200_m = p_i2007_1_; this.field_73204_i = new Random(p_i2007_2_); this.field_73201_j = new NoiseGeneratorOctaves(this.field_73204_i, 16); this.field_73202_k = new NoiseGeneratorOctaves(this.field_73204_i, 16); this.field_73199_l = new NoiseGeneratorOctaves(this.field_73204_i, 8); this.field_73196_a = new NoiseGeneratorOctaves(this.field_73204_i, 10); this.field_73194_b = new NoiseGeneratorOctaves(this.field_73204_i, 16);
/*     */   } public void func_147420_a(int p_147420_1_, int p_147420_2_, Block[] p_147420_3_, BiomeGenBase[] p_147420_4_) { byte b1 = 2; int i = b1 + 1; byte b2 = 33; int j = b1 + 1; this.field_73197_n = func_73187_a(this.field_73197_n, p_147420_1_ * b1, 0, p_147420_2_ * b1, i, b2, j); for (byte b3 = 0; b3 < b1; b3++) {
/*     */       for (byte b = 0; b < b1; b++) {
/*     */         for (byte b4 = 0; b4 < 32; b4++) {
/*     */           double d1 = 0.25D; double d2 = this.field_73197_n[((b3 + 0) * j + b + 0) * b2 + b4 + 0]; double d3 = this.field_73197_n[((b3 + 0) * j + b + 1) * b2 + b4 + 0]; double d4 = this.field_73197_n[((b3 + 1) * j + b + 0) * b2 + b4 + 0]; double d5 = this.field_73197_n[((b3 + 1) * j + b + 1) * b2 + b4 + 0]; double d6 = (this.field_73197_n[((b3 + 0) * j + b + 0) * b2 + b4 + 1] - d2) * d1; double d7 = (this.field_73197_n[((b3 + 0) * j + b + 1) * b2 + b4 + 1] - d3) * d1; double d8 = (this.field_73197_n[((b3 + 1) * j + b + 0) * b2 + b4 + 1] - d4) * d1; double d9 = (this.field_73197_n[((b3 + 1) * j + b + 1) * b2 + b4 + 1] - d5) * d1; for (byte b5 = 0; b5 < 4; b5++) {
/*     */             double d10 = 0.125D; double d11 = d2; double d12 = d3; double d13 = (d4 - d2) * d10; double d14 = (d5 - d3) * d10; for (byte b6 = 0; b6 < 8; b6++) {
/*     */               int k = b6 + b3 * 8 << 11 | 0 + b * 8 << 7 | b4 * 4 + b5; char c = ''; double d15 = 0.125D; double d16 = d11; double d17 = (d12 - d11) * d15; for (byte b7 = 0; b7 < 8; b7++) {
/*     */                 Block block = null; if (d16 > 0.0D)
/*     */                   block = Blocks.field_150377_bs;  p_147420_3_[k] = block; k += c; d16 += d17;
/*     */               }  d11 += d13; d12 += d14;
/*     */             } 
/*     */             d2 += d6;
/*     */             d3 += d7;
/*     */             d4 += d8;
/*     */             d5 += d9;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }  } public void func_147421_b(int p_147421_1_, int p_147421_2_, Block[] p_147421_3_, BiomeGenBase[] p_147421_4_) { for (byte b = 0; b < 16; b++) {
/*     */       for (byte b1 = 0; b1 < 16; b1++) {
/*     */         boolean bool = true;
/*     */         byte b2 = -1;
/*     */         Block block1 = Blocks.field_150377_bs;
/*     */         Block block2 = Blocks.field_150377_bs;
/*     */         for (byte b3 = 127; b3 >= 0; b3--) {
/*     */           int i = (b1 * 16 + b) * 128 + b3;
/*     */           Block block = p_147421_3_[i];
/*     */           if (block == null || block.func_149688_o() == Material.field_151579_a) {
/*     */             b2 = -1;
/*     */           } else if (block == Blocks.field_150348_b) {
/*     */             if (b2 == -1) {
/*     */               if (bool) {
/*     */                 block1 = null;
/*     */                 block2 = Blocks.field_150377_bs;
/*     */               } 
/*     */               b2 = bool;
/*     */               if (b3 >= 0) {
/*     */                 p_147421_3_[i] = block1;
/*     */               } else {
/*     */                 p_147421_3_[i] = block2;
/*     */               } 
/*     */             } else if (b2 > 0) {
/*     */               b2--;
/*     */               p_147421_3_[i] = block2;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }  }
/*     */   public Chunk func_73158_c(int p_73158_1_, int p_73158_2_) { return func_73154_d(p_73158_1_, p_73158_2_); }
/* 319 */   public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) { BlockFalling.field_149832_M = true;
/* 320 */     int i = p_73153_2_ * 16;
/* 321 */     int j = p_73153_3_ * 16;
/*     */     
/* 323 */     BiomeGenBase biomeGenBase = this.field_73200_m.func_72807_a(i + 16, j + 16);
/* 324 */     biomeGenBase.func_76728_a(this.field_73200_m, this.field_73200_m.field_73012_v, i, j);
/*     */     
/* 326 */     BlockFalling.field_149832_M = false; } public Chunk func_73154_d(int p_73154_1_, int p_73154_2_) { this.field_73204_i.setSeed(p_73154_1_ * 341873128712L + p_73154_2_ * 132897987541L); Block[] arrayOfBlock = new Block[32768]; this.field_73198_o = this.field_73200_m.func_72959_q().func_76933_b(this.field_73198_o, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16); func_147420_a(p_73154_1_, p_73154_2_, arrayOfBlock, this.field_73198_o); func_147421_b(p_73154_1_, p_73154_2_, arrayOfBlock, this.field_73198_o); Chunk chunk = new Chunk(this.field_73200_m, arrayOfBlock, p_73154_1_, p_73154_2_); byte[] arrayOfByte = chunk.func_76605_m();
/*     */     for (byte b = 0; b < arrayOfByte.length; b++)
/*     */       arrayOfByte[b] = (byte)(this.field_73198_o[b]).field_76756_M; 
/*     */     chunk.func_76603_b();
/*     */     return chunk; }
/* 331 */   public boolean func_73151_a(boolean p_73151_1_, IProgressUpdate p_73151_2_) { return true; }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73156_b() {
/* 340 */     return false;
/*     */   }
/*     */   private double[] func_73187_a(double[] p_73187_1_, int p_73187_2_, int p_73187_3_, int p_73187_4_, int p_73187_5_, int p_73187_6_, int p_73187_7_) { if (p_73187_1_ == null) p_73187_1_ = new double[p_73187_5_ * p_73187_6_ * p_73187_7_];  double d1 = 684.412D; double d2 = 684.412D; this.field_73190_f = this.field_73196_a.func_76305_a(this.field_73190_f, p_73187_2_, p_73187_4_, p_73187_5_, p_73187_7_, 1.121D, 1.121D, 0.5D); this.field_73191_g = this.field_73194_b.func_76305_a(this.field_73191_g, p_73187_2_, p_73187_4_, p_73187_5_, p_73187_7_, 200.0D, 200.0D, 0.5D); d1 *= 2.0D; this.field_73195_c = this.field_73199_l.func_76304_a(this.field_73195_c, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, d1 / 80.0D, d2 / 160.0D, d1 / 80.0D); this.field_73192_d = this.field_73201_j.func_76304_a(this.field_73192_d, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, d1, d2, d1); this.field_73193_e = this.field_73202_k.func_76304_a(this.field_73193_e, p_73187_2_, p_73187_3_, p_73187_4_, p_73187_5_, p_73187_6_, p_73187_7_, d1, d2, d1); byte b1 = 0; byte b2 = 0; for (byte b3 = 0; b3 < p_73187_5_; b3++) { for (byte b = 0; b < p_73187_7_; b++) { double d3 = (this.field_73190_f[b2] + 256.0D) / 512.0D; if (d3 > 1.0D) d3 = 1.0D;  double d4 = this.field_73191_g[b2] / 8000.0D; if (d4 < 0.0D) d4 = -d4 * 0.3D;  d4 = d4 * 3.0D - 2.0D; float f1 = (b3 + p_73187_2_ - 0) / 1.0F; float f2 = (b + p_73187_4_ - 0) / 1.0F; float f3 = 100.0F - MathHelper.func_76129_c(f1 * f1 + f2 * f2) * 8.0F; if (f3 > 80.0F) f3 = 80.0F;  if (f3 < -100.0F) f3 = -100.0F;  if (d4 > 1.0D) d4 = 1.0D;  d4 /= 8.0D; d4 = 0.0D; if (d3 < 0.0D) d3 = 0.0D;  d3 += 0.5D; d4 = d4 * p_73187_6_ / 16.0D; b2++; double d5 = p_73187_6_ / 2.0D; for (byte b4 = 0; b4 < p_73187_6_; b4++) { double d6 = 0.0D; double d7 = (b4 - d5) * 8.0D / d3; if (d7 < 0.0D)
/*     */             d7 *= -1.0D;  double d8 = this.field_73192_d[b1] / 512.0D; double d9 = this.field_73193_e[b1] / 512.0D; double d10 = (this.field_73195_c[b1] / 10.0D + 1.0D) / 2.0D; if (d10 < 0.0D) { d6 = d8; } else if (d10 > 1.0D) { d6 = d9; } else { d6 = d8 + (d9 - d8) * d10; }  d6 -= 8.0D; d6 += f3; byte b5 = 2; if (b4 > p_73187_6_ / 2 - b5) { double d = ((b4 - p_73187_6_ / 2 - b5) / 64.0F); if (d < 0.0D)
/*     */               d = 0.0D;  if (d > 1.0D)
/* 345 */               d = 1.0D;  d6 = d6 * (1.0D - d) + -3000.0D * d; }  b5 = 8; if (b4 < b5) { double d = ((b5 - b4) / (b5 - 1.0F)); d6 = d6 * (1.0D - d) + -30.0D * d; }  p_73187_1_[b1] = d6; b1++; }  }  }  return p_73187_1_; } public boolean func_73149_a(int p_73149_1_, int p_73149_2_) { return true; } public void func_104112_b() {} public boolean func_73157_c() { return true; }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_73148_d() {
/* 351 */     return "RandomLevelSource";
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
/* 356 */     BiomeGenBase biomeGenBase = this.field_73200_m.func_72807_a(p_73155_2_, p_73155_4_);
/* 357 */     return biomeGenBase.func_76747_a(p_73155_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
/* 362 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_73152_e() {
/* 367 */     return 0;
/*     */   }
/*     */   
/*     */   public void func_82695_e(int p_82695_1_, int p_82695_2_) {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\ChunkProviderEnd.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */