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
/*     */ public class x3ChunkProviderVegeta
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
/*  69 */   private double[] stoneNoise = new double[256];
/*  70 */   private MapGenBase caveGenerator = (MapGenBase)new MapGenCaves();
/*     */   
/*  72 */   private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
/*     */ 
/*     */   
/*  75 */   private MapGenBase ravineGenerator = (MapGenBase)new MapGenRavine();
/*     */   
/*     */   private BiomeGenBase[] biomesForGeneration;
/*     */   
/*     */   double[] noise3;
/*     */   
/*     */   double[] noise1;
/*     */   
/*     */   double[] noise2;
/*     */   double[] noise5;
/*  85 */   int[][] field_73219_j = new int[32][32];
/*     */ 
/*     */ 
/*     */   
/*     */   public x3ChunkProviderVegeta(World world, long seed, boolean mapFeaturesEnabled) {
/*  90 */     this.worldObj = world;
/*  91 */     this.mapFeaturesEnabled = mapFeaturesEnabled;
/*  92 */     this.worldType = world.func_72912_H().func_76067_t();
/*  93 */     this.rand = new Random(seed);
/*  94 */     this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
/*  95 */     this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
/*  96 */     this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
/*  97 */     this.noisePerl = new NoiseGeneratorPerlin(this.rand, 4);
/*  98 */     this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
/*  99 */     this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
/* 100 */     this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
/* 101 */     this.noiseArray = new double[825];
/* 102 */     this.parabolicField = new float[25];
/* 103 */     for (int j = -2; j <= 2; j++) {
/* 104 */       for (int k = -2; k <= 2; k++) {
/* 105 */         float f = 10.0F / MathHelper.func_76129_c((j * j + k * k) + 0.2F);
/* 106 */         this.parabolicField[j + 2 + (k + 2) * 5] = f;
/*     */       } 
/*     */     } 
/* 109 */     NoiseGenerator[] noiseGens = { (NoiseGenerator)this.noiseGen1, (NoiseGenerator)this.noiseGen2, (NoiseGenerator)this.noiseGen3, (NoiseGenerator)this.noisePerl, (NoiseGenerator)this.noiseGen5, (NoiseGenerator)this.noiseGen6, (NoiseGenerator)this.mobSpawnerNoise };
/* 110 */     noiseGens = TerrainGen.getModdedNoiseGenerators(world, this.rand, noiseGens);
/* 111 */     this.noiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
/* 112 */     this.noiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
/* 113 */     this.noiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
/* 114 */     this.noisePerl = (NoiseGeneratorPerlin)noiseGens[3];
/* 115 */     this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
/* 116 */     this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
/* 117 */     this.mobSpawnerNoise = (NoiseGeneratorOctaves)noiseGens[6];
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
/* 131 */     byte b0 = 63;
/* 132 */     this.biomesForGeneration = this.worldObj.func_72959_q().func_76937_a(this.biomesForGeneration, par1 * 4 - 2, par2 * 4 - 2, 10, 10);
/* 133 */     func_147423_a(par1 * 4, 0, par2 * 4);
/* 134 */     for (int k = 0; k < 4; k++) {
/* 135 */       int l = k * 5;
/* 136 */       int i1 = (k + 1) * 5;
/* 137 */       for (int j1 = 0; j1 < 4; j1++) {
/* 138 */         int k1 = (l + j1) * 33;
/* 139 */         int l1 = (l + j1 + 1) * 33;
/* 140 */         int i2 = (i1 + j1) * 33;
/* 141 */         int j2 = (i1 + j1 + 1) * 33;
/* 142 */         for (int k2 = 0; k2 < 32; k2++) {
/* 143 */           double d0 = 0.125D;
/* 144 */           double d1 = this.noiseArray[k1 + k2];
/* 145 */           double d2 = this.noiseArray[l1 + k2];
/* 146 */           double d3 = this.noiseArray[i2 + k2];
/* 147 */           double d4 = this.noiseArray[j2 + k2];
/* 148 */           double d5 = (this.noiseArray[k1 + k2 + 1] - d1) * d0;
/* 149 */           double d6 = (this.noiseArray[l1 + k2 + 1] - d2) * d0;
/* 150 */           double d7 = (this.noiseArray[i2 + k2 + 1] - d3) * d0;
/* 151 */           double d8 = (this.noiseArray[j2 + k2 + 1] - d4) * d0;
/* 152 */           for (int l2 = 0; l2 < 8; l2++) {
/* 153 */             double d9 = 0.25D;
/* 154 */             double d10 = d1;
/* 155 */             double d11 = d2;
/* 156 */             double d12 = (d3 - d1) * d9;
/* 157 */             double d13 = (d4 - d2) * d9;
/* 158 */             for (int i3 = 0; i3 < 4; i3++) {
/* 159 */               int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
/* 160 */               short short1 = 256;
/* 161 */               j3 -= short1;
/* 162 */               double d14 = 0.25D;
/* 163 */               double d16 = (d11 - d10) * d14;
/* 164 */               double d15 = d10 - d16;
/* 165 */               for (int k3 = 0; k3 < 4; k3++) {
/* 166 */                 if ((d15 += d16) > 0.0D) {
/* 167 */                   blocks[j3 += short1] = Blocks.field_150348_b;
/* 168 */                 } else if (k2 * 8 + l2 < b0) {
/* 169 */                   blocks[j3 += short1] = Blocks.field_150355_j;
/*     */                 } else {
/* 171 */                   blocks[j3 += short1] = null;
/*     */                 } 
/*     */               } 
/* 174 */               d10 += d12;
/* 175 */               d11 += d13;
/*     */             } 
/* 177 */             d1 += d5;
/* 178 */             d2 += d6;
/* 179 */             d3 += d7;
/* 180 */             d4 += d8;
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
/* 194 */     ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, par1, par2, blocks, par3ArrayOfByte, par4ArrayOfBiomeGenBase);
/* 195 */     MinecraftForge.EVENT_BUS.post((Event)event);
/* 196 */     if (event.getResult() == Event.Result.DENY)
/* 197 */       return;  double d0 = 0.03125D;
/* 198 */     this.stoneNoise = this.noisePerl.func_151599_a(this.stoneNoise, (par1 * 16), (par2 * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);
/* 199 */     for (int k = 0; k < 16; k++) {
/* 200 */       for (int l = 0; l < 16; l++) {
/* 201 */         BiomeGenBaseDBC biomegenbase = (BiomeGenBaseDBC)par4ArrayOfBiomeGenBase[l + k * 16];
/* 202 */         genTerrainBlocks(biomegenbase, this.worldObj, this.rand, blocks, par3ArrayOfByte, par1 * 16 + k, par2 * 16 + l, this.stoneNoise[l + k * 16]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public void genTerrainBlocks(BiomeGenBaseDBC biomegenbase, World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
/* 207 */     genBiomeModdedTerrain(biomegenbase, p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
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
/* 221 */     Block block = bgb.field_76752_A;
/* 222 */     byte b0 = (byte)(bgb.field_150604_aj & 0xFF);
/* 223 */     Block block1 = bgb.field_76753_B;
/* 224 */     int k = -1;
/* 225 */     int l = (int)(z / 3.0D + 3.0D + random.nextDouble() * 0.25D);
/* 226 */     int i1 = x & 0xF;
/* 227 */     int j1 = y & 0xF;
/* 228 */     int k1 = replacableBlock.length / 256;
/* 229 */     for (int l1 = 255; l1 >= 0; l1--) {
/*     */       
/* 231 */       int i2 = (j1 * 16 + i1) * k1 + l1;
/*     */       
/* 233 */       if (l1 <= 0 + random.nextInt(5)) {
/*     */         
/* 235 */         replacableBlock[i2] = Blocks.field_150357_h;
/*     */       }
/*     */       else {
/*     */         
/* 239 */         Block block2 = replacableBlock[i2];
/*     */         
/* 241 */         if (block2 != null && block2.func_149688_o() != Material.field_151579_a) {
/*     */           
/* 243 */           if (block2 == Blocks.field_150348_b)
/*     */           {
/* 245 */             if (k == -1) {
/*     */               
/* 247 */               if (l <= 0) {
/*     */                 
/* 249 */                 block = null;
/* 250 */                 b0 = 0;
/* 251 */                 block1 = Blocks.field_150348_b;
/*     */               }
/* 253 */               else if (l1 >= 59 && l1 <= 64) {
/*     */                 
/* 255 */                 block = bgb.field_76752_A;
/* 256 */                 b0 = (byte)(bgb.field_150604_aj & 0xFF);
/* 257 */                 block1 = bgb.field_76753_B;
/*     */               } 
/*     */               
/* 260 */               if (l1 < 63 && (block == null || block.func_149688_o() == Material.field_151579_a))
/*     */               {
/* 262 */                 if (bgb.func_150564_a(x, l1, y) < 0.15F) {
/*     */                   
/* 264 */                   block = Blocks.field_150432_aD;
/* 265 */                   b0 = 0;
/*     */                 }
/*     */                 else {
/*     */                   
/* 269 */                   block = Blocks.field_150355_j;
/* 270 */                   b0 = 0;
/*     */                 } 
/*     */               }
/*     */               
/* 274 */               k = l;
/*     */               
/* 276 */               if (l1 >= 62)
/*     */               {
/* 278 */                 replacableBlock[i2] = block;
/* 279 */                 aByte[i2] = b0;
/*     */               }
/* 281 */               else if (l1 < 56 - l)
/*     */               {
/* 283 */                 block = null;
/* 284 */                 block1 = Blocks.field_150348_b;
/* 285 */                 replacableBlock[i2] = Blocks.field_150351_n;
/*     */               }
/*     */               else
/*     */               {
/* 289 */                 replacableBlock[i2] = block1;
/*     */               }
/*     */             
/* 292 */             } else if (k > 0) {
/*     */               
/* 294 */               k--;
/* 295 */               replacableBlock[i2] = block1;
/*     */               
/* 297 */               if (k == 0 && block1 == Blocks.field_150354_m)
/*     */               {
/* 299 */                 k = random.nextInt(4) + Math.max(0, l1 - 63);
/* 300 */                 block1 = Blocks.field_150322_A;
/*     */               }
/*     */             
/*     */             } 
/*     */           }
/*     */         } else {
/*     */           
/* 307 */           k = -1;
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
/* 353 */     return func_73154_d(par1, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk func_73154_d(int par1, int par2) {
/* 362 */     this.rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
/* 363 */     Block[] ablock = new Block[65536];
/* 364 */     byte[] abyte = new byte[65536];
/* 365 */     func_147424_a(par1, par2, ablock);
/* 366 */     this.biomesForGeneration = this.worldObj.func_72959_q().func_76933_b(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
/* 367 */     replaceBlocksForBiome(par1, par2, ablock, abyte, this.biomesForGeneration);
/* 368 */     this.caveGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
/* 369 */     this.ravineGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
/* 370 */     if (this.mapFeaturesEnabled) {
/* 371 */       this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
/*     */     }
/* 373 */     Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
/* 374 */     byte[] abyte1 = chunk.func_76605_m();
/* 375 */     for (int k = 0; k < abyte1.length; k++) {
/* 376 */       abyte1[k] = (byte)(this.biomesForGeneration[k]).field_76756_M;
/*     */     }
/* 378 */     chunk.func_76603_b();
/* 379 */     return chunk;
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
/* 392 */     this.noise5 = this.noiseGen6.func_76305_a(this.noise5, p_147423_1_, p_147423_3_, 5, 5, 200.0D, 200.0D, 0.5D);
/* 393 */     this.noise3 = this.noiseGen3.func_76304_a(this.noise3, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
/* 394 */     this.noise1 = this.noiseGen1.func_76304_a(this.noise1, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
/* 395 */     this.noise2 = this.noiseGen2.func_76304_a(this.noise2, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
/* 396 */     int l = 0;
/* 397 */     int i1 = 0;
/* 398 */     for (int j1 = 0; j1 < 5; j1++) {
/* 399 */       for (int k1 = 0; k1 < 5; k1++) {
/* 400 */         float f = 0.0F;
/* 401 */         float f1 = 0.0F;
/* 402 */         float f2 = 0.0F;
/* 403 */         byte b0 = 2;
/* 404 */         BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];
/* 405 */         for (int l1 = -b0; l1 <= b0; l1++) {
/* 406 */           for (int i2 = -b0; i2 <= b0; i2++) {
/* 407 */             BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
/* 408 */             float f3 = biomegenbase1.field_76748_D;
/* 409 */             float f4 = biomegenbase1.field_76749_E;
/* 410 */             if (this.worldType == WorldType.field_151360_e && f3 > 0.0F) {
/* 411 */               f3 = 1.0F + f3 * 2.0F;
/* 412 */               f4 = 1.0F + f4 * 4.0F;
/*     */             } 
/* 414 */             float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);
/* 415 */             if (biomegenbase1.field_76748_D > biomegenbase.field_76748_D) {
/* 416 */               f5 /= 2.0F;
/*     */             }
/* 418 */             f += f4 * f5;
/* 419 */             f1 += f3 * f5;
/* 420 */             f2 += f5;
/*     */           } 
/*     */         } 
/* 423 */         f /= f2;
/* 424 */         f1 /= f2;
/* 425 */         f = f * 0.9F + 0.1F;
/* 426 */         f1 = (f1 * 4.0F - 1.0F) / 8.0F;
/* 427 */         double d12 = this.noise5[i1] / 8000.0D;
/* 428 */         if (d12 < 0.0D) {
/* 429 */           d12 = -d12 * 0.3D;
/*     */         }
/* 431 */         d12 = d12 * 3.0D - 2.0D;
/* 432 */         if (d12 < 0.0D) {
/* 433 */           d12 /= 2.0D;
/* 434 */           if (d12 < -1.0D) {
/* 435 */             d12 = -1.0D;
/*     */           }
/* 437 */           d12 /= 1.4D;
/* 438 */           d12 /= 2.0D;
/*     */         } else {
/* 440 */           if (d12 > 1.0D) {
/* 441 */             d12 = 1.0D;
/*     */           }
/* 443 */           d12 /= 8.0D;
/*     */         } 
/* 445 */         i1++;
/* 446 */         double d13 = f1;
/* 447 */         double d14 = f;
/* 448 */         d13 += d12 * 0.2D;
/* 449 */         d13 = d13 * 8.5D / 8.0D;
/* 450 */         double d5 = 8.5D + d13 * 4.0D;
/* 451 */         for (int j2 = 0; j2 < 33; j2++) {
/* 452 */           double d6 = (j2 - d5) * 12.0D * 128.0D / 256.0D / d14;
/* 453 */           if (d6 < 0.0D) {
/* 454 */             d6 *= 4.0D;
/*     */           }
/* 456 */           double d7 = this.noise1[l] / 512.0D;
/* 457 */           double d8 = this.noise2[l] / 512.0D;
/* 458 */           double d9 = (this.noise3[l] / 10.0D + 1.0D) / 2.0D;
/* 459 */           double d10 = MathHelper.func_151238_b(d7, d8, d9) - d6;
/* 460 */           if (j2 > 29) {
/* 461 */             double d11 = ((j2 - 29) / 3.0F);
/* 462 */             d10 = d10 * (1.0D - d11) + -10.0D * d11;
/*     */           } 
/* 464 */           this.noiseArray[l] = d10;
/* 465 */           l++;
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
/* 476 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73153_a(IChunkProvider par1IChunkProvider, int par2, int par3) {
/* 484 */     BlockFalling.field_149832_M = true;
/* 485 */     int k = par2 * 16;
/* 486 */     int l = par3 * 16;
/* 487 */     BiomeGenBase biomegenbase = this.worldObj.func_72807_a(k + 16, l + 16);
/* 488 */     this.rand.setSeed(this.worldObj.func_72905_C());
/* 489 */     long i1 = this.rand.nextLong() / 2L * 2L + 1L;
/* 490 */     long j1 = this.rand.nextLong() / 2L * 2L + 1L;
/* 491 */     this.rand.setSeed(par2 * i1 + par3 * j1 ^ this.worldObj.func_72905_C());
/* 492 */     boolean flag = false;
/* 493 */     MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Pre(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag));
/*     */ 
/*     */     
/* 496 */     if (this.mapFeaturesEnabled) {
/* 497 */       this.scatteredFeatureGenerator.func_75051_a(this.worldObj, this.rand, par2, par3);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 504 */     if (biomegenbase != BiomeGenBase.field_76769_d && biomegenbase != BiomeGenBase.field_76786_s && !flag && this.rand.nextInt(4) == 0 && 
/* 505 */       TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.LAKE)) {
/* 506 */       int i = k + this.rand.nextInt(16) + 8;
/* 507 */       int l1 = this.rand.nextInt(256);
/* 508 */       int i2 = l + this.rand.nextInt(16) + 8;
/* 509 */       (new WorldGenLakes(Blocks.field_150355_j)).func_76484_a(this.worldObj, this.rand, i, l1, i2);
/*     */     } 
/*     */ 
/*     */     
/* 513 */     if (TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.LAVA) && !flag && this.rand.nextInt(8) == 0) {
/* 514 */       int i = k + this.rand.nextInt(16) + 8;
/* 515 */       int l1 = this.rand.nextInt(this.rand.nextInt(248) + 8);
/* 516 */       int i2 = l + this.rand.nextInt(16) + 8;
/*     */       
/* 518 */       if (l1 < 63 || this.rand.nextInt(10) == 0) {
/* 519 */         (new WorldGenLakes(Blocks.field_150353_l)).func_76484_a(this.worldObj, this.rand, i, l1, i2);
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 524 */     boolean doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.DUNGEON); int k1;
/* 525 */     for (k1 = 0; doGen && k1 < 8; k1++) {
/* 526 */       int l1 = k + this.rand.nextInt(16) + 8;
/* 527 */       int i2 = this.rand.nextInt(256);
/* 528 */       int j2 = l + this.rand.nextInt(16) + 8;
/* 529 */       (new WorldGenDungeons()).func_76484_a(this.worldObj, this.rand, l1, i2, j2);
/*     */     } 
/*     */ 
/*     */     
/* 533 */     biomegenbase.func_76728_a(this.worldObj, this.rand, k, l);
/* 534 */     if (TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.ANIMALS)) {
/* 535 */       SpawnerAnimals.func_77191_a(this.worldObj, biomegenbase, k + 8, l + 8, 16, 16, this.rand);
/*     */     }
/* 537 */     k += 8;
/* 538 */     l += 8;
/*     */ 
/*     */     
/* 541 */     doGen = TerrainGen.populate(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag, PopulateChunkEvent.Populate.EventType.ICE);
/* 542 */     for (k1 = 0; doGen && k1 < 16; k1++) {
/* 543 */       for (int l1 = 0; l1 < 16; l1++) {
/* 544 */         int i2 = this.worldObj.func_72874_g(k + k1, l + l1);
/*     */         
/* 546 */         if (this.worldObj.func_72884_u(k1 + k, i2 - 1, l1 + l)) {
/* 547 */           this.worldObj.func_147465_d(k1 + k, i2 - 1, l1 + l, Blocks.field_150432_aD, 0, 2);
/*     */         }
/*     */         
/* 550 */         if (this.worldObj.func_147478_e(k1 + k, i2, l1 + l, true)) {
/* 551 */           this.worldObj.func_147465_d(k1 + k, i2, l1 + l, Blocks.field_150431_aC, 0, 2);
/*     */         }
/*     */       } 
/*     */     } 
/* 555 */     MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Post(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag));
/* 556 */     BlockFalling.field_149832_M = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73151_a(boolean par1, IProgressUpdate par2IProgressUpdate) {
/* 565 */     return true;
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
/* 580 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73157_c() {
/* 588 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_73148_d() {
/* 596 */     return "RandomLevelSource";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_73155_a(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4) {
/* 605 */     BiomeGenBase biomegenbase = this.worldObj.func_72807_a(par2, par4);
/* 606 */     return (par1EnumCreatureType == EnumCreatureType.monster && this.scatteredFeatureGenerator.func_143030_a(par2, par3, par4)) ? this.scatteredFeatureGenerator.func_82667_a() : biomegenbase.func_76747_a(par1EnumCreatureType);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_73152_e() {
/* 611 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_82695_e(int par1, int par2) {
/* 616 */     if (this.mapFeaturesEnabled);
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
/* 628 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\x3ChunkProviderVegeta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */