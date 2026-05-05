/*     */ package JinRyuu.DragonBC.common.Worlds;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import java.util.ArrayList;
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
/*     */ import net.minecraft.world.WorldType;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraft.world.gen.MapGenBase;
/*     */ import net.minecraft.world.gen.NoiseGenerator;
/*     */ import net.minecraft.world.gen.NoiseGeneratorOctaves;
/*     */ import net.minecraft.world.gen.NoiseGeneratorPerlin;
/*     */ import net.minecraft.world.gen.structure.MapGenScatteredFeature;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.event.terraingen.ChunkProviderEvent;
/*     */ import net.minecraftforge.event.terraingen.PopulateChunkEvent;
/*     */ import net.minecraftforge.event.terraingen.TerrainGen;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class x1ChunkProviderOW
/*     */   implements IChunkProvider
/*     */ {
/*     */   private Random rand;
/*     */   private NoiseGeneratorOctaves noiseGen1;
/*     */   private NoiseGeneratorOctaves noiseGen2;
/*     */   private NoiseGeneratorOctaves noiseGen3;
/*     */   private NoiseGeneratorPerlin noisePerl;
/*     */   public NoiseGeneratorOctaves noiseGen5;
/*     */   public NoiseGeneratorOctaves noiseGen6;
/*     */   public NoiseGeneratorOctaves mobSpawnerNoise;
/*     */   private World worldObj;
/*     */   private final boolean mapFeaturesEnabled;
/*     */   private WorldType worldType;
/*     */   private final double[] noiseArray;
/*     */   private final float[] parabolicField;
/*  59 */   private double[] stoneNoise = new double[256];
/*  60 */   private MapGenBase caveGenerator = new x1MapGenCavesOW();
/*     */   
/*  62 */   private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
/*     */ 
/*     */   
/*  65 */   private MapGenBase ravineGenerator = new x1MapGenRavineOW();
/*     */   
/*     */   private BiomeGenBase[] biomesForGeneration;
/*     */   
/*     */   double[] noise3;
/*     */   
/*     */   double[] noise1;
/*     */   
/*     */   double[] noise2;
/*     */   double[] noise5;
/*  75 */   int[][] field_73219_j = new int[32][32];
/*     */ 
/*     */ 
/*     */   
/*     */   public x1ChunkProviderOW(World world, long seed, boolean mapFeaturesEnabled) {
/*  80 */     this.worldObj = world;
/*  81 */     this.mapFeaturesEnabled = mapFeaturesEnabled;
/*  82 */     this.worldType = world.func_72912_H().func_76067_t();
/*  83 */     this.rand = new Random(seed);
/*  84 */     this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
/*  85 */     this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
/*  86 */     this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
/*  87 */     this.noisePerl = new NoiseGeneratorPerlin(this.rand, 4);
/*  88 */     this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
/*  89 */     this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
/*  90 */     this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 4);
/*  91 */     this.noiseArray = new double[825];
/*  92 */     this.parabolicField = new float[25];
/*  93 */     for (int j = -2; j <= 2; j++) {
/*  94 */       for (int k = -2; k <= 2; k++) {
/*  95 */         float f = 10.0F / MathHelper.func_76129_c((j * j + k * k) + 0.2F);
/*  96 */         this.parabolicField[j + 2 + (k + 2) * 5] = f;
/*     */       } 
/*     */     } 
/*  99 */     NoiseGenerator[] noiseGens = { (NoiseGenerator)this.noiseGen1, (NoiseGenerator)this.noiseGen2, (NoiseGenerator)this.noiseGen3, (NoiseGenerator)this.noisePerl, (NoiseGenerator)this.noiseGen5, (NoiseGenerator)this.noiseGen6, (NoiseGenerator)this.mobSpawnerNoise };
/* 100 */     noiseGens = TerrainGen.getModdedNoiseGenerators(world, this.rand, noiseGens);
/* 101 */     this.noiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
/* 102 */     this.noiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
/* 103 */     this.noiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
/* 104 */     this.noisePerl = (NoiseGeneratorPerlin)noiseGens[3];
/* 105 */     this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
/* 106 */     this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
/* 107 */     this.mobSpawnerNoise = (NoiseGeneratorOctaves)noiseGens[6];
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
/*     */   public void func_147424_a(int par1, int par2, Block[] blocks) {
/* 121 */     byte b0 = 63;
/* 122 */     this.biomesForGeneration = this.worldObj.func_72959_q().func_76937_a(this.biomesForGeneration, par1 * 4 - 2, par2 * 4 - 2, 10, 10);
/* 123 */     func_147423_a(par1 * 4, 0, par2 * 4);
/* 124 */     for (int k = 0; k < 4; k++) {
/* 125 */       int l = k * 5;
/* 126 */       int i1 = (k + 1) * 5;
/* 127 */       for (int j1 = 0; j1 < 4; j1++) {
/* 128 */         int k1 = (l + j1) * 33;
/* 129 */         int l1 = (l + j1 + 1) * 33;
/* 130 */         int i2 = (i1 + j1) * 33;
/* 131 */         int j2 = (i1 + j1 + 1) * 33;
/* 132 */         for (int k2 = 0; k2 < 32; k2++) {
/* 133 */           double d0 = 0.125D;
/* 134 */           double d1 = this.noiseArray[k1 + k2];
/* 135 */           double d2 = this.noiseArray[l1 + k2];
/* 136 */           double d3 = this.noiseArray[i2 + k2];
/* 137 */           double d4 = this.noiseArray[j2 + k2];
/* 138 */           double d5 = (this.noiseArray[k1 + k2 + 1] - d1) * d0;
/* 139 */           double d6 = (this.noiseArray[l1 + k2 + 1] - d2) * d0;
/* 140 */           double d7 = (this.noiseArray[i2 + k2 + 1] - d3) * d0;
/* 141 */           double d8 = (this.noiseArray[j2 + k2 + 1] - d4) * d0;
/* 142 */           for (int l2 = 0; l2 < 8; l2++) {
/* 143 */             double d9 = 0.25D;
/* 144 */             double d10 = d1;
/* 145 */             double d11 = d2;
/* 146 */             double d12 = (d3 - d1) * d9;
/* 147 */             double d13 = (d4 - d2) * d9;
/* 148 */             for (int i3 = 0; i3 < 4; i3++) {
/* 149 */               int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
/* 150 */               short short1 = 256;
/* 151 */               j3 -= short1;
/* 152 */               double d14 = 0.25D;
/* 153 */               double d16 = (d11 - d10) * d14;
/* 154 */               double d15 = d10 - d16;
/* 155 */               for (int k3 = 0; k3 < 4; k3++) {
/* 156 */                 if ((d15 += d16) > 0.0D) {
/* 157 */                   blocks[j3 += short1] = Blocks.field_150348_b;
/* 158 */                 } else if (k2 * 8 + l2 < b0) {
/* 159 */                   blocks[j3 += short1] = Blocks.field_150355_j;
/*     */                 } else {
/* 161 */                   blocks[j3 += short1] = null;
/*     */                 } 
/*     */               } 
/* 164 */               d10 += d12;
/* 165 */               d11 += d13;
/*     */             } 
/* 167 */             d1 += d5;
/* 168 */             d2 += d6;
/* 169 */             d3 += d7;
/* 170 */             d4 += d8;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void replaceBlocksForBiome(int par1, int par2, Block[] blocks, byte[] par3ArrayOfByte, BiomeGenBase[] par4ArrayOfBiomeGenBase) {
/* 184 */     ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, par1, par2, blocks, par3ArrayOfByte, par4ArrayOfBiomeGenBase);
/* 185 */     MinecraftForge.EVENT_BUS.post((Event)event);
/* 186 */     if (event.getResult() == Event.Result.DENY)
/* 187 */       return;  double d0 = 0.03125D;
/* 188 */     this.stoneNoise = this.noisePerl.func_151599_a(this.stoneNoise, (par1 * 16), (par2 * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);
/* 189 */     for (int k = 0; k < 16; k++) {
/* 190 */       for (int l = 0; l < 16; l++) {
/* 191 */         BiomeGenBaseDBC biomegenbase = (BiomeGenBaseDBC)par4ArrayOfBiomeGenBase[l + k * 16];
/* 192 */         genTerrainBlocks(biomegenbase, this.worldObj, this.rand, blocks, par3ArrayOfByte, par1 * 16 + k, par2 * 16 + l, this.stoneNoise[l + k * 16]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public void genTerrainBlocks(BiomeGenBaseDBC biomegenbase, World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
/* 197 */     genBiomeModdedTerrain(biomegenbase, p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
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
/*     */   public void genBiomeModdedTerrain(BiomeGenBaseDBC bgb, World world, Random random, Block[] replacableBlock, byte[] aByte, int x, int y, double z) {
/* 211 */     Block block = BlocksDBC.BlockYellowCloud;
/* 212 */     byte b0 = (byte)(bgb.field_150604_aj & 0xFF);
/* 213 */     Block block1 = BlocksDBC.BlockYellowCloud;
/* 214 */     int k = -1;
/* 215 */     int l = (int)(z / 3.0D + 3.0D + random.nextDouble() * 0.25D);
/* 216 */     int i1 = x & 0xF;
/* 217 */     int j1 = y & 0xF;
/* 218 */     int k1 = replacableBlock.length / 256;
/* 219 */     int height = 0;
/* 220 */     boolean o85 = false;
/* 221 */     for (int l1 = 255; l1 >= 0; l1--) {
/*     */       
/* 223 */       int i2 = (j1 * 16 + i1) * k1 + l1;
/* 224 */       if (l1 == 1) {
/*     */         
/* 226 */         replacableBlock[i2] = Blocks.field_150353_l;
/*     */       }
/* 228 */       else if (l1 <= 0 + random.nextInt(5)) {
/*     */         
/* 230 */         replacableBlock[i2] = Blocks.field_150357_h;
/*     */       }
/*     */       else {
/*     */         
/* 234 */         Block block2 = replacableBlock[i2];
/*     */         
/* 236 */         if (block2 != null && block2.func_149688_o() != Material.field_151579_a) {
/*     */           
/* 238 */           if (block2 == Blocks.field_150348_b) {
/*     */             
/* 240 */             if (k == -1) {
/*     */               
/* 242 */               if (l <= 0) {
/*     */                 
/* 244 */                 block = null;
/* 245 */                 b0 = 0;
/* 246 */                 block1 = Blocks.field_150348_b;
/*     */               }
/* 248 */               else if (l1 >= 59 && l1 <= 64) {
/*     */                 
/* 250 */                 block = BlocksDBC.BlockYellowCloud;
/* 251 */                 b0 = (byte)(bgb.field_150604_aj & 0xFF);
/* 252 */                 block1 = BlocksDBC.BlockYellowCloud;
/*     */               } 
/*     */               
/* 255 */               if (l1 < 40 && (block == null || block.func_149688_o() == Material.field_151579_a)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */                 
/* 264 */                 block = Blocks.field_150355_j;
/* 265 */                 b0 = 0;
/*     */               } 
/*     */ 
/*     */               
/* 269 */               k = l;
/*     */               
/* 271 */               if (l1 > 80) {
/* 272 */                 o85 = true;
/*     */               }
/* 274 */               if (l1 >= 62)
/*     */               {
/* 276 */                 replacableBlock[i2] = block;
/* 277 */                 aByte[i2] = b0;
/*     */               }
/* 279 */               else if (l1 < 56 - l)
/*     */               {
/* 281 */                 block = null;
/* 282 */                 block1 = Blocks.field_150348_b;
/* 283 */                 replacableBlock[i2] = Blocks.field_150351_n;
/*     */               }
/*     */               else
/*     */               {
/* 287 */                 replacableBlock[i2] = block1;
/*     */               }
/*     */             
/* 290 */             } else if (k > 0) {
/*     */               
/* 292 */               k--;
/* 293 */               replacableBlock[i2] = block1;
/*     */               
/* 295 */               if (k == 0 && block1 == Blocks.field_150354_m) {
/*     */                 
/* 297 */                 k = random.nextInt(4) + Math.max(0, l1 - 63);
/* 298 */                 block1 = Blocks.field_150322_A;
/*     */               } 
/*     */             } 
/*     */             
/* 302 */             if (l1 > 80) replacableBlock[i2] = Blocks.field_150350_a; 
/* 303 */             if (height == 0) { height = l1; }
/* 304 */             else if (height != 0 && height - hch < l1)
/* 305 */             { if (o85 && l1 >= 80 && 80 + (height - 80) / 10 == l1) { replacableBlock[i2] = BlocksDBC.BlockYellowCloud;
/*     */                  }
/*     */               
/* 308 */               else if (height - hch + 1 >= l1 && height - hch + 1 <= l1) { replacableBlock[i2] = bgb.field_76753_B; }
/* 309 */               else { replacableBlock[i2] = Blocks.field_150350_a; }
/*     */                }
/*     */           
/*     */           } 
/*     */         } else {
/*     */           
/* 315 */           k = -1;
/*     */         } 
/*     */       } 
/*     */       
/* 319 */       Block var38 = replacableBlock[i2];
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 327 */       if (l1 < 200 && var38 == Blocks.field_150355_j) {
/* 328 */         replacableBlock[i2] = Blocks.field_150350_a;
/*     */       }
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
/* 355 */   private static int hch = 50;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk func_73158_c(int par1, int par2) {
/* 362 */     return func_73154_d(par1, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk func_73154_d(int par1, int par2) {
/* 371 */     this.rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
/* 372 */     Block[] ablock = new Block[65536];
/* 373 */     byte[] abyte = new byte[65536];
/* 374 */     func_147424_a(par1, par2, ablock);
/* 375 */     this.biomesForGeneration = this.worldObj.func_72959_q().func_76933_b(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
/* 376 */     replaceBlocksForBiome(par1, par2, ablock, abyte, this.biomesForGeneration);
/* 377 */     this.caveGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
/* 378 */     this.ravineGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
/*     */ 
/*     */ 
/*     */     
/* 382 */     Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
/* 383 */     byte[] abyte1 = chunk.func_76605_m();
/* 384 */     for (int k = 0; k < abyte1.length; k++) {
/* 385 */       abyte1[k] = (byte)(this.biomesForGeneration[k]).field_76756_M;
/*     */     }
/* 387 */     chunk.func_76603_b();
/* 388 */     return chunk;
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
/*     */   private void func_147423_a(int p_147423_1_, int p_147423_2_, int p_147423_3_) {
/* 401 */     this.noise5 = this.noiseGen6.func_76305_a(this.noise5, p_147423_1_, p_147423_3_, 5, 5, 200.0D, 200.0D, 0.5D);
/* 402 */     this.noise3 = this.noiseGen3.func_76304_a(this.noise3, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
/* 403 */     this.noise1 = this.noiseGen1.func_76304_a(this.noise1, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
/* 404 */     this.noise2 = this.noiseGen2.func_76304_a(this.noise2, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
/* 405 */     int l = 0;
/* 406 */     int i1 = 0;
/* 407 */     for (int j1 = 0; j1 < 5; j1++) {
/* 408 */       for (int k1 = 0; k1 < 5; k1++) {
/* 409 */         float f = 0.0F;
/* 410 */         float f1 = 0.0F;
/* 411 */         float f2 = 0.0F;
/* 412 */         byte b0 = 2;
/* 413 */         BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];
/* 414 */         for (int l1 = -b0; l1 <= b0; l1++) {
/* 415 */           for (int i2 = -b0; i2 <= b0; i2++) {
/* 416 */             BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
/* 417 */             float f3 = biomegenbase1.field_76748_D;
/* 418 */             float f4 = biomegenbase1.field_76749_E;
/* 419 */             if (this.worldType == WorldType.field_151360_e && f3 > 0.0F) {
/* 420 */               f3 = 1.0F + f3 * 2.0F;
/* 421 */               f4 = 1.0F + f4 * 4.0F;
/*     */             } 
/* 423 */             float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);
/* 424 */             if (biomegenbase1.field_76748_D > biomegenbase.field_76748_D) {
/* 425 */               f5 /= 2.0F;
/*     */             }
/* 427 */             f += f4 * f5;
/* 428 */             f1 += f3 * f5;
/* 429 */             f2 += f5;
/*     */           } 
/*     */         } 
/* 432 */         f /= f2;
/* 433 */         f1 /= f2;
/* 434 */         f = f * 0.9F + 0.1F;
/* 435 */         f1 = (f1 * 4.0F - 1.0F) / 8.0F;
/* 436 */         double d12 = this.noise5[i1] / 8000.0D;
/* 437 */         if (d12 < 0.0D) {
/* 438 */           d12 = -d12 * 0.3D;
/*     */         }
/* 440 */         d12 = d12 * 3.0D - 2.0D;
/* 441 */         if (d12 < 0.0D) {
/* 442 */           d12 /= 2.0D;
/* 443 */           if (d12 < -1.0D) {
/* 444 */             d12 = -1.0D;
/*     */           }
/* 446 */           d12 /= 1.4D;
/* 447 */           d12 /= 2.0D;
/*     */         } else {
/* 449 */           if (d12 > 1.0D) {
/* 450 */             d12 = 1.0D;
/*     */           }
/* 452 */           d12 /= 8.0D;
/*     */         } 
/* 454 */         i1++;
/* 455 */         double d13 = f1;
/* 456 */         double d14 = f;
/* 457 */         d13 += d12 * 0.2D;
/* 458 */         d13 = d13 * 8.5D / 8.0D;
/* 459 */         double d5 = 8.5D + d13 * 4.0D;
/* 460 */         for (int j2 = 0; j2 < 33; j2++) {
/* 461 */           double d6 = (j2 - d5) * 12.0D * 128.0D / 256.0D / d14;
/* 462 */           if (d6 < 0.0D) {
/* 463 */             d6 *= 4.0D;
/*     */           }
/* 465 */           double d7 = this.noise1[l] / 512.0D;
/* 466 */           double d8 = this.noise2[l] / 512.0D;
/* 467 */           double d9 = (this.noise3[l] / 10.0D + 1.0D) / 2.0D;
/* 468 */           double d10 = MathHelper.func_151238_b(d7, d8, d9) - d6;
/* 469 */           if (j2 > 29) {
/* 470 */             double d11 = ((j2 - 29) / 3.0F);
/* 471 */             d10 = d10 * (1.0D - d11) + -10.0D * d11;
/*     */           } 
/* 473 */           this.noiseArray[l] = d10;
/* 474 */           l++;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73149_a(int par1, int par2) {
/* 485 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73153_a(IChunkProvider par1IChunkProvider, int par2, int par3) {
/* 493 */     BlockFalling.field_149832_M = true;
/* 494 */     int k = par2 * 16;
/* 495 */     int l = par3 * 16;
/* 496 */     BiomeGenBase biomegenbase = this.worldObj.func_72807_a(k + 16, l + 16);
/* 497 */     this.rand.setSeed(this.worldObj.func_72905_C());
/* 498 */     long i1 = this.rand.nextLong() / 2L * 2L + 1L;
/* 499 */     long j1 = this.rand.nextLong() / 2L * 2L + 1L;
/* 500 */     this.rand.setSeed(par2 * i1 + par3 * j1 ^ this.worldObj.func_72905_C());
/* 501 */     boolean flag = false;
/* 502 */     MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Pre(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 516 */     biomegenbase.func_76728_a(this.worldObj, this.rand, k, l);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 570 */     MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Post(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag));
/* 571 */     BlockFalling.field_149832_M = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73151_a(boolean par1, IProgressUpdate par2IProgressUpdate) {
/* 580 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_104112_b() {}
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73156_b() {
/* 595 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73157_c() {
/* 603 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_73148_d() {
/* 611 */     return "RandomLevelSource";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_73155_a(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4) {
/* 620 */     BiomeGenBase biomegenbase = this.worldObj.func_72807_a(par2, par4);
/* 621 */     int r = (new Random()).nextInt(50);
/* 622 */     return (par1EnumCreatureType == EnumCreatureType.monster && this.scatteredFeatureGenerator.func_143030_a(par2, par3, par4)) ? this.scatteredFeatureGenerator.func_82667_a() : ((r == 0) ? biomegenbase.func_76747_a(par1EnumCreatureType) : new ArrayList());
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_73152_e() {
/* 627 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_82695_e(int par1, int par2) {
/* 632 */     if (this.mapFeaturesEnabled);
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
/*     */   public ChunkPosition func_147416_a(World world, String arg1, int arg2, int arg3, int arg4) {
/* 644 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\x1ChunkProviderOW.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */