/*     */ package JinRyuu.DragonBC.common.Worlds;
/*     */ 
/*     */ import cpw.mods.fml.common.eventhandler.Event;
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
/*     */ import net.minecraft.world.SpawnerAnimals;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldType;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraft.world.gen.MapGenBase;
/*     */ import net.minecraft.world.gen.MapGenCaves;
/*     */ import net.minecraft.world.gen.MapGenRavine;
/*     */ import net.minecraft.world.gen.NoiseGenerator;
/*     */ import net.minecraft.world.gen.NoiseGeneratorOctaves;
/*     */ import net.minecraft.world.gen.NoiseGeneratorPerlin;
/*     */ import net.minecraft.world.gen.feature.WorldGenDungeons;
/*     */ import net.minecraft.world.gen.feature.WorldGenLakes;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class x0ChunkProviderNamek
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
/*  71 */   private double[] stoneNoise = new double[256];
/*  72 */   private MapGenBase caveGenerator = (MapGenBase)new MapGenCaves();
/*     */   
/*  74 */   private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
/*     */ 
/*     */   
/*  77 */   private MapGenBase ravineGenerator = (MapGenBase)new MapGenRavine();
/*     */   
/*     */   private BiomeGenBase[] biomesForGeneration;
/*     */   
/*     */   double[] noise3;
/*     */   
/*     */   double[] noise1;
/*     */   
/*     */   double[] noise2;
/*     */   double[] noise5;
/*  87 */   int[][] field_73219_j = new int[32][32];
/*     */ 
/*     */ 
/*     */   
/*     */   public x0ChunkProviderNamek(World world, long seed, boolean mapFeaturesEnabled) {
/*  92 */     this.worldObj = world;
/*  93 */     this.mapFeaturesEnabled = mapFeaturesEnabled;
/*  94 */     this.worldType = world.func_72912_H().func_76067_t();
/*  95 */     this.rand = new Random(seed);
/*  96 */     this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
/*  97 */     this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
/*  98 */     this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
/*  99 */     this.noisePerl = new NoiseGeneratorPerlin(this.rand, 4);
/* 100 */     this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
/* 101 */     this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
/* 102 */     this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
/* 103 */     this.noiseArray = new double[825];
/* 104 */     this.parabolicField = new float[25];
/* 105 */     for (int j = -2; j <= 2; j++) {
/* 106 */       for (int k = -2; k <= 2; k++) {
/* 107 */         float f = 10.0F / MathHelper.func_76129_c((j * j + k * k) + 0.2F);
/* 108 */         this.parabolicField[j + 2 + (k + 2) * 5] = f;
/*     */       } 
/*     */     } 
/* 111 */     NoiseGenerator[] noiseGens = { (NoiseGenerator)this.noiseGen1, (NoiseGenerator)this.noiseGen2, (NoiseGenerator)this.noiseGen3, (NoiseGenerator)this.noisePerl, (NoiseGenerator)this.noiseGen5, (NoiseGenerator)this.noiseGen6, (NoiseGenerator)this.mobSpawnerNoise };
/* 112 */     noiseGens = TerrainGen.getModdedNoiseGenerators(world, this.rand, noiseGens);
/* 113 */     this.noiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
/* 114 */     this.noiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
/* 115 */     this.noiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
/* 116 */     this.noisePerl = (NoiseGeneratorPerlin)noiseGens[3];
/* 117 */     this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
/* 118 */     this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
/* 119 */     this.mobSpawnerNoise = (NoiseGeneratorOctaves)noiseGens[6];
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
/* 133 */     byte b0 = 63;
/* 134 */     this.biomesForGeneration = this.worldObj.func_72959_q().func_76937_a(this.biomesForGeneration, par1 * 4 - 2, par2 * 4 - 2, 10, 10);
/* 135 */     func_147423_a(par1 * 4, 0, par2 * 4);
/* 136 */     for (int k = 0; k < 4; k++) {
/* 137 */       int l = k * 5;
/* 138 */       int i1 = (k + 1) * 5;
/* 139 */       for (int j1 = 0; j1 < 4; j1++) {
/* 140 */         int k1 = (l + j1) * 33;
/* 141 */         int l1 = (l + j1 + 1) * 33;
/* 142 */         int i2 = (i1 + j1) * 33;
/* 143 */         int j2 = (i1 + j1 + 1) * 33;
/* 144 */         for (int k2 = 0; k2 < 32; k2++) {
/* 145 */           double d0 = 0.125D;
/* 146 */           double d1 = this.noiseArray[k1 + k2];
/* 147 */           double d2 = this.noiseArray[l1 + k2];
/* 148 */           double d3 = this.noiseArray[i2 + k2];
/* 149 */           double d4 = this.noiseArray[j2 + k2];
/* 150 */           double d5 = (this.noiseArray[k1 + k2 + 1] - d1) * d0;
/* 151 */           double d6 = (this.noiseArray[l1 + k2 + 1] - d2) * d0;
/* 152 */           double d7 = (this.noiseArray[i2 + k2 + 1] - d3) * d0;
/* 153 */           double d8 = (this.noiseArray[j2 + k2 + 1] - d4) * d0;
/* 154 */           for (int l2 = 0; l2 < 8; l2++) {
/* 155 */             double d9 = 0.25D;
/* 156 */             double d10 = d1;
/* 157 */             double d11 = d2;
/* 158 */             double d12 = (d3 - d1) * d9;
/* 159 */             double d13 = (d4 - d2) * d9;
/* 160 */             for (int i3 = 0; i3 < 4; i3++) {
/* 161 */               int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
/* 162 */               short short1 = 256;
/* 163 */               j3 -= short1;
/* 164 */               double d14 = 0.25D;
/* 165 */               double d16 = (d11 - d10) * d14;
/* 166 */               double d15 = d10 - d16;
/* 167 */               for (int k3 = 0; k3 < 4; k3++) {
/* 168 */                 if ((d15 += d16) > 0.0D) {
/* 169 */                   blocks[j3 += short1] = Blocks.field_150348_b;
/* 170 */                 } else if (k2 * 8 + l2 < b0) {
/* 171 */                   blocks[j3 += short1] = Blocks.field_150355_j;
/*     */                 } else {
/* 173 */                   blocks[j3 += short1] = null;
/*     */                 } 
/*     */               } 
/* 176 */               d10 += d12;
/* 177 */               d11 += d13;
/*     */             } 
/* 179 */             d1 += d5;
/* 180 */             d2 += d6;
/* 181 */             d3 += d7;
/* 182 */             d4 += d8;
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
/* 196 */     ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, par1, par2, blocks, par3ArrayOfByte, par4ArrayOfBiomeGenBase);
/* 197 */     MinecraftForge.EVENT_BUS.post((Event)event);
/* 198 */     if (event.getResult() == Event.Result.DENY)
/* 199 */       return;  double d0 = 0.03125D;
/* 200 */     this.stoneNoise = this.noisePerl.func_151599_a(this.stoneNoise, (par1 * 16), (par2 * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);
/* 201 */     for (int k = 0; k < 16; k++) {
/* 202 */       for (int l = 0; l < 16; l++) {
/* 203 */         BiomeGenBaseDBC biomegenbase = (BiomeGenBaseDBC)par4ArrayOfBiomeGenBase[l + k * 16];
/* 204 */         genTerrainBlocks(biomegenbase, this.worldObj, this.rand, blocks, par3ArrayOfByte, par1 * 16 + k, par2 * 16 + l, this.stoneNoise[l + k * 16]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public void genTerrainBlocks(BiomeGenBaseDBC biomegenbase, World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
/* 209 */     genBiomeModdedTerrain(biomegenbase, p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
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
/* 223 */     Block block = bgb.field_76752_A;
/* 224 */     byte b0 = (byte)(bgb.field_150604_aj & 0xFF);
/* 225 */     Block block1 = bgb.field_76753_B;
/* 226 */     int k = -1;
/* 227 */     int l = (int)(z / 3.0D + 3.0D + random.nextDouble() * 0.25D);
/* 228 */     int i1 = x & 0xF;
/* 229 */     int j1 = y & 0xF;
/* 230 */     int k1 = replacableBlock.length / 256;
/* 231 */     for (int l1 = 255; l1 >= 0; l1--) {
/*     */       
/* 233 */       int i2 = (j1 * 16 + i1) * k1 + l1;
/*     */       
/* 235 */       if (l1 <= 0 + random.nextInt(5)) {
/*     */         
/* 237 */         replacableBlock[i2] = Blocks.field_150357_h;
/*     */       }
/*     */       else {
/*     */         
/* 241 */         Block block2 = replacableBlock[i2];
/*     */         
/* 243 */         if (block2 != null && block2.func_149688_o() != Material.field_151579_a) {
/*     */           
/* 245 */           if (block2 == Blocks.field_150348_b)
/*     */           {
/* 247 */             if (k == -1) {
/*     */               
/* 249 */               if (l <= 0) {
/*     */                 
/* 251 */                 block = null;
/* 252 */                 b0 = 0;
/* 253 */                 block1 = Blocks.field_150348_b;
/*     */               }
/* 255 */               else if (l1 >= 59 && l1 <= 64) {
/*     */                 
/* 257 */                 block = bgb.field_76752_A;
/* 258 */                 b0 = (byte)(bgb.field_150604_aj & 0xFF);
/* 259 */                 block1 = bgb.field_76753_B;
/*     */               } 
/*     */               
/* 262 */               if (l1 < 63 && (block == null || block.func_149688_o() == Material.field_151579_a))
/*     */               {
/* 264 */                 if (bgb.func_150564_a(x, l1, y) < 0.15F) {
/*     */                   
/* 266 */                   block = Blocks.field_150432_aD;
/* 267 */                   b0 = 0;
/*     */                 }
/*     */                 else {
/*     */                   
/* 271 */                   block = Blocks.field_150355_j;
/* 272 */                   b0 = 0;
/*     */                 } 
/*     */               }
/*     */               
/* 276 */               k = l;
/*     */               
/* 278 */               if (l1 >= 62)
/*     */               {
/* 280 */                 replacableBlock[i2] = block;
/* 281 */                 aByte[i2] = b0;
/*     */               }
/* 283 */               else if (l1 < 56 - l)
/*     */               {
/* 285 */                 block = null;
/* 286 */                 block1 = Blocks.field_150348_b;
/* 287 */                 replacableBlock[i2] = Blocks.field_150351_n;
/*     */               }
/*     */               else
/*     */               {
/* 291 */                 replacableBlock[i2] = block1;
/*     */               }
/*     */             
/* 294 */             } else if (k > 0) {
/*     */               
/* 296 */               k--;
/* 297 */               replacableBlock[i2] = block1;
/*     */               
/* 299 */               if (k == 0 && block1 == Blocks.field_150354_m)
/*     */               {
/* 301 */                 k = random.nextInt(4) + Math.max(0, l1 - 63);
/* 302 */                 block1 = Blocks.field_150322_A;
/*     */               }
/*     */             
/*     */             } 
/*     */           }
/*     */         } else {
/*     */           
/* 309 */           k = -1;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk func_73158_c(int par1, int par2) {
/* 355 */     return func_73154_d(par1, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk func_73154_d(int par1, int par2) {
/* 364 */     this.rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
/* 365 */     Block[] ablock = new Block[65536];
/* 366 */     byte[] abyte = new byte[65536];
/* 367 */     func_147424_a(par1, par2, ablock);
/* 368 */     this.biomesForGeneration = this.worldObj.func_72959_q().func_76933_b(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
/* 369 */     replaceBlocksForBiome(par1, par2, ablock, abyte, this.biomesForGeneration);
/* 370 */     this.caveGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
/* 371 */     this.ravineGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
/* 372 */     if (this.mapFeaturesEnabled) {
/* 373 */       this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
/*     */     }
/* 375 */     Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
/* 376 */     byte[] abyte1 = chunk.func_76605_m();
/* 377 */     for (int k = 0; k < abyte1.length; k++) {
/* 378 */       abyte1[k] = (byte)(this.biomesForGeneration[k]).field_76756_M;
/*     */     }
/* 380 */     chunk.func_76603_b();
/* 381 */     return chunk;
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
/* 394 */     this.noise5 = this.noiseGen6.func_76305_a(this.noise5, p_147423_1_, p_147423_3_, 5, 5, 200.0D, 200.0D, 0.5D);
/* 395 */     this.noise3 = this.noiseGen3.func_76304_a(this.noise3, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
/* 396 */     this.noise1 = this.noiseGen1.func_76304_a(this.noise1, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
/* 397 */     this.noise2 = this.noiseGen2.func_76304_a(this.noise2, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
/* 398 */     int l = 0;
/* 399 */     int i1 = 0;
/* 400 */     for (int j1 = 0; j1 < 5; j1++) {
/* 401 */       for (int k1 = 0; k1 < 5; k1++) {
/* 402 */         float f = 0.0F;
/* 403 */         float f1 = 0.0F;
/* 404 */         float f2 = 0.0F;
/* 405 */         byte b0 = 2;
/* 406 */         BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];
/* 407 */         for (int l1 = -b0; l1 <= b0; l1++) {
/* 408 */           for (int i2 = -b0; i2 <= b0; i2++) {
/* 409 */             BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
/* 410 */             float f3 = biomegenbase1.field_76748_D;
/* 411 */             float f4 = biomegenbase1.field_76749_E;
/* 412 */             if (this.worldType == WorldType.field_151360_e && f3 > 0.0F) {
/* 413 */               f3 = 1.0F + f3 * 2.0F;
/* 414 */               f4 = 1.0F + f4 * 4.0F;
/*     */             } 
/* 416 */             float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);
/* 417 */             if (biomegenbase1.field_76748_D > biomegenbase.field_76748_D) {
/* 418 */               f5 /= 2.0F;
/*     */             }
/* 420 */             f += f4 * f5;
/* 421 */             f1 += f3 * f5;
/* 422 */             f2 += f5;
/*     */           } 
/*     */         } 
/* 425 */         f /= f2;
/* 426 */         f1 /= f2;
/* 427 */         f = f * 0.9F + 0.1F;
/* 428 */         f1 = (f1 * 4.0F - 1.0F) / 8.0F;
/* 429 */         double d12 = this.noise5[i1] / 8000.0D;
/* 430 */         if (d12 < 0.0D) {
/* 431 */           d12 = -d12 * 0.3D;
/*     */         }
/* 433 */         d12 = d12 * 3.0D - 2.0D;
/* 434 */         if (d12 < 0.0D) {
/* 435 */           d12 /= 2.0D;
/* 436 */           if (d12 < -1.0D) {
/* 437 */             d12 = -1.0D;
/*     */           }
/* 439 */           d12 /= 1.4D;
/* 440 */           d12 /= 2.0D;
/*     */         } else {
/* 442 */           if (d12 > 1.0D) {
/* 443 */             d12 = 1.0D;
/*     */           }
/* 445 */           d12 /= 8.0D;
/*     */         } 
/* 447 */         i1++;
/* 448 */         double d13 = f1;
/* 449 */         double d14 = f;
/* 450 */         d13 += d12 * 0.2D;
/* 451 */         d13 = d13 * 8.5D / 8.0D;
/* 452 */         double d5 = 8.5D + d13 * 4.0D;
/* 453 */         for (int j2 = 0; j2 < 33; j2++) {
/* 454 */           double d6 = (j2 - d5) * 12.0D * 128.0D / 256.0D / d14;
/* 455 */           if (d6 < 0.0D) {
/* 456 */             d6 *= 4.0D;
/*     */           }
/* 458 */           double d7 = this.noise1[l] / 512.0D;
/* 459 */           double d8 = this.noise2[l] / 512.0D;
/* 460 */           double d9 = (this.noise3[l] / 10.0D + 1.0D) / 2.0D;
/* 461 */           double d10 = MathHelper.func_151238_b(d7, d8, d9) - d6;
/* 462 */           if (j2 > 29) {
/* 463 */             double d11 = ((j2 - 29) / 3.0F);
/* 464 */             d10 = d10 * (1.0D - d11) + -10.0D * d11;
/*     */           } 
/* 466 */           this.noiseArray[l] = d10;
/* 467 */           l++;
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
/* 478 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73153_a(IChunkProvider par1IChunkProvider, int par2, int par3) {
/* 486 */     BlockFalling.field_149832_M = true;
/* 487 */     int k = par2 * 16;
/* 488 */     int l = par3 * 16;
/* 489 */     BiomeGenBase biomegenbase = this.worldObj.func_72807_a(k + 16, l + 16);
/* 490 */     this.rand.setSeed(this.worldObj.func_72905_C());
/* 491 */     long i1 = this.rand.nextLong() / 2L * 2L + 1L;
/* 492 */     long j1 = this.rand.nextLong() / 2L * 2L + 1L;
/* 493 */     this.rand.setSeed(par2 * i1 + par3 * j1 ^ this.worldObj.func_72905_C());
/* 494 */     boolean flag = false;
/* 495 */     MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Pre(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag));
/*     */ 
/*     */     
/* 498 */     if (this.mapFeaturesEnabled) {
/* 499 */       this.scatteredFeatureGenerator.func_75051_a(this.worldObj, this.rand, par2, par3);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 506 */     if (biomegenbase != BiomeGenBase.field_76769_d && biomegenbase != BiomeGenBase.field_76786_s && !flag && this.rand.nextInt(4) == 0 && 
/* 507 */       TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.LAKE)) {
/* 508 */       int i = k + this.rand.nextInt(16) + 8;
/* 509 */       int l1 = this.rand.nextInt(256);
/* 510 */       int i2 = l + this.rand.nextInt(16) + 8;
/* 511 */       (new WorldGenLakes(Blocks.field_150355_j)).func_76484_a(this.worldObj, this.rand, i, l1, i2);
/*     */     } 
/*     */ 
/*     */     
/* 515 */     if (TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.LAVA) && !flag && this.rand.nextInt(8) == 0) {
/* 516 */       int i = k + this.rand.nextInt(16) + 8;
/* 517 */       int l1 = this.rand.nextInt(this.rand.nextInt(248) + 8);
/* 518 */       int i2 = l + this.rand.nextInt(16) + 8;
/*     */       
/* 520 */       if (l1 < 63 || this.rand.nextInt(10) == 0) {
/* 521 */         (new WorldGenLakes(Blocks.field_150353_l)).func_76484_a(this.worldObj, this.rand, i, l1, i2);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 526 */     boolean doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.DUNGEON); int k1;
/* 527 */     for (k1 = 0; doGen && k1 < 8; k1++) {
/* 528 */       int l1 = k + this.rand.nextInt(16) + 8;
/* 529 */       int i2 = this.rand.nextInt(256);
/* 530 */       int j2 = l + this.rand.nextInt(16) + 8;
/* 531 */       (new WorldGenDungeons()).func_76484_a(this.worldObj, this.rand, l1, i2, j2);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 536 */     biomegenbase.func_76728_a(this.worldObj, this.rand, k, l);
/*     */ 
/*     */     
/* 539 */     if (TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.ANIMALS)) {
/* 540 */       SpawnerAnimals.func_77191_a(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
/*     */     }
/* 542 */     k += 8;
/* 543 */     l += 8;
/*     */ 
/*     */     
/* 546 */     doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.ICE);
/* 547 */     for (k1 = 0; doGen && k1 < 16; k1++) {
/* 548 */       for (int l1 = 0; l1 < 16; l1++) {
/* 549 */         int i2 = this.worldObj.func_72874_g(k + k1, l + l1);
/*     */         
/* 551 */         if (this.worldObj.func_72884_u(k1 + k, i2 - 1, l1 + l)) {
/* 552 */           this.worldObj.func_147465_d(k1 + k, i2 - 1, l1 + l, Blocks.field_150432_aD, 0, 2);
/*     */         }
/*     */         
/* 555 */         if (this.worldObj.func_147478_e(k1 + k, i2, l1 + l, true)) {
/* 556 */           this.worldObj.func_147465_d(k1 + k, i2, l1 + l, Blocks.field_150431_aC, 0, 2);
/*     */         }
/*     */       } 
/*     */     } 
/* 560 */     MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Post(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag));
/* 561 */     BlockFalling.field_149832_M = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73151_a(boolean par1, IProgressUpdate par2IProgressUpdate) {
/* 570 */     return true;
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
/* 585 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73157_c() {
/* 593 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_73148_d() {
/* 601 */     return "RandomLevelSource";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_73155_a(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4) {
/* 610 */     BiomeGenBase biomegenbase = this.worldObj.func_72807_a(par2, par4);
/* 611 */     return (par1EnumCreatureType == EnumCreatureType.monster && this.scatteredFeatureGenerator.func_143030_a(par2, par3, par4)) ? this.scatteredFeatureGenerator.func_82667_a() : biomegenbase.func_76747_a(par1EnumCreatureType);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_73152_e() {
/* 616 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_82695_e(int par1, int par2) {
/* 621 */     if (this.mapFeaturesEnabled);
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
/* 633 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\x0ChunkProviderNamek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */