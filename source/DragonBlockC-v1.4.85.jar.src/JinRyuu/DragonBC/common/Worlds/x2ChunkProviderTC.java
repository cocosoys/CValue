/*     */ package JinRyuu.DragonBC.common.Worlds;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
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
/*     */ public class x2ChunkProviderTC
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
/*  61 */   private double[] stoneNoise = new double[256];
/*  62 */   private MapGenBase caveGenerator = (MapGenBase)new MapGenCaves();
/*     */   
/*  64 */   private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
/*     */ 
/*     */   
/*  67 */   private MapGenBase ravineGenerator = (MapGenBase)new MapGenRavine();
/*     */   
/*     */   private BiomeGenBase[] biomesForGeneration;
/*     */   
/*     */   double[] noise3;
/*     */   
/*     */   double[] noise1;
/*     */   
/*     */   double[] noise2;
/*     */   double[] noise5;
/*  77 */   int[][] field_73219_j = new int[32][32];
/*     */ 
/*     */ 
/*     */   
/*     */   public x2ChunkProviderTC(World world, long seed, boolean mapFeaturesEnabled) {
/*  82 */     this.worldObj = world;
/*  83 */     this.mapFeaturesEnabled = mapFeaturesEnabled;
/*  84 */     this.worldType = world.func_72912_H().func_76067_t();
/*  85 */     this.rand = new Random(seed);
/*  86 */     this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
/*  87 */     this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
/*  88 */     this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
/*  89 */     this.noisePerl = new NoiseGeneratorPerlin(this.rand, 4);
/*  90 */     this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
/*  91 */     this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
/*  92 */     this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
/*  93 */     this.noiseArray = new double[825];
/*  94 */     this.parabolicField = new float[25];
/*  95 */     for (int j = -2; j <= 2; j++) {
/*  96 */       for (int k = -2; k <= 2; k++) {
/*  97 */         float f = 10.0F / MathHelper.func_76129_c((j * j + k * k) + 0.2F);
/*  98 */         this.parabolicField[j + 2 + (k + 2) * 5] = f;
/*     */       } 
/*     */     } 
/* 101 */     NoiseGenerator[] noiseGens = { (NoiseGenerator)this.noiseGen1, (NoiseGenerator)this.noiseGen2, (NoiseGenerator)this.noiseGen3, (NoiseGenerator)this.noisePerl, (NoiseGenerator)this.noiseGen5, (NoiseGenerator)this.noiseGen6, (NoiseGenerator)this.mobSpawnerNoise };
/* 102 */     noiseGens = TerrainGen.getModdedNoiseGenerators(world, this.rand, noiseGens);
/* 103 */     this.noiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
/* 104 */     this.noiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
/* 105 */     this.noiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
/* 106 */     this.noisePerl = (NoiseGeneratorPerlin)noiseGens[3];
/* 107 */     this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
/* 108 */     this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
/* 109 */     this.mobSpawnerNoise = (NoiseGeneratorOctaves)noiseGens[6];
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
/* 123 */     byte b0 = 63;
/* 124 */     this.biomesForGeneration = this.worldObj.func_72959_q().func_76937_a(this.biomesForGeneration, par1 * 4 - 2, par2 * 4 - 2, 10, 10);
/* 125 */     func_147423_a(par1 * 4, 0, par2 * 4);
/* 126 */     for (int k = 0; k < 4; k++) {
/* 127 */       int l = k * 5;
/* 128 */       int i1 = (k + 1) * 5;
/* 129 */       for (int j1 = 0; j1 < 4; j1++) {
/* 130 */         int k1 = (l + j1) * 33;
/* 131 */         int l1 = (l + j1 + 1) * 33;
/* 132 */         int i2 = (i1 + j1) * 33;
/* 133 */         int j2 = (i1 + j1 + 1) * 33;
/* 134 */         for (int k2 = 0; k2 < 32; k2++) {
/* 135 */           double d0 = 0.125D;
/* 136 */           double d1 = this.noiseArray[k1 + k2];
/* 137 */           double d2 = this.noiseArray[l1 + k2];
/* 138 */           double d3 = this.noiseArray[i2 + k2];
/* 139 */           double d4 = this.noiseArray[j2 + k2];
/* 140 */           double d5 = (this.noiseArray[k1 + k2 + 1] - d1) * d0;
/* 141 */           double d6 = (this.noiseArray[l1 + k2 + 1] - d2) * d0;
/* 142 */           double d7 = (this.noiseArray[i2 + k2 + 1] - d3) * d0;
/* 143 */           double d8 = (this.noiseArray[j2 + k2 + 1] - d4) * d0;
/* 144 */           for (int l2 = 0; l2 < 8; l2++) {
/* 145 */             double d9 = 0.25D;
/* 146 */             double d10 = d1;
/* 147 */             double d11 = d2;
/* 148 */             double d12 = (d3 - d1) * d9;
/* 149 */             double d13 = (d4 - d2) * d9;
/* 150 */             for (int i3 = 0; i3 < 4; i3++) {
/* 151 */               int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
/* 152 */               short short1 = 256;
/* 153 */               j3 -= short1;
/* 154 */               double d14 = 0.25D;
/* 155 */               double d16 = (d11 - d10) * d14;
/* 156 */               double d15 = d10 - d16;
/* 157 */               for (int k3 = 0; k3 < 4; k3++) {
/* 158 */                 if ((d15 += d16) > 0.0D) {
/* 159 */                   blocks[j3 += short1] = Blocks.field_150348_b;
/* 160 */                 } else if (k2 * 8 + l2 < b0) {
/* 161 */                   blocks[j3 += short1] = Blocks.field_150355_j;
/*     */                 } else {
/* 163 */                   blocks[j3 += short1] = null;
/*     */                 } 
/*     */               } 
/* 166 */               d10 += d12;
/* 167 */               d11 += d13;
/*     */             } 
/* 169 */             d1 += d5;
/* 170 */             d2 += d6;
/* 171 */             d3 += d7;
/* 172 */             d4 += d8;
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
/* 186 */     ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, par1, par2, blocks, par3ArrayOfByte, par4ArrayOfBiomeGenBase);
/* 187 */     MinecraftForge.EVENT_BUS.post((Event)event);
/* 188 */     if (event.getResult() == Event.Result.DENY)
/* 189 */       return;  double d0 = 0.03125D;
/* 190 */     this.stoneNoise = this.noisePerl.func_151599_a(this.stoneNoise, (par1 * 16), (par2 * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);
/* 191 */     for (int k = 0; k < 16; k++) {
/* 192 */       for (int l = 0; l < 16; l++) {
/* 193 */         BiomeGenBaseDBC biomegenbase = (BiomeGenBaseDBC)par4ArrayOfBiomeGenBase[l + k * 16];
/* 194 */         genTerrainBlocks(biomegenbase, this.worldObj, this.rand, blocks, par3ArrayOfByte, par1 * 16 + k, par2 * 16 + l, this.stoneNoise[l + k * 16]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public void genTerrainBlocks(BiomeGenBaseDBC biomegenbase, World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
/* 199 */     genBiomeModdedTerrain(biomegenbase, p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
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
/* 213 */     Block block = bgb.field_76752_A;
/* 214 */     byte b0 = (byte)(bgb.field_150604_aj & 0xFF);
/* 215 */     Block block1 = bgb.field_76753_B;
/* 216 */     int k = -1;
/* 217 */     int l = (int)(z / 3.0D + 3.0D + random.nextDouble() * 0.25D);
/* 218 */     int i1 = x & 0xF;
/* 219 */     int j1 = y & 0xF;
/* 220 */     int k1 = replacableBlock.length / 256;
/* 221 */     for (int l1 = 255; l1 >= 0; l1--) {
/*     */       
/* 223 */       int i2 = (j1 * 16 + i1) * k1 + l1;
/*     */       
/* 225 */       if (l1 <= 0 + random.nextInt(5)) {
/*     */         
/* 227 */         replacableBlock[i2] = Blocks.field_150357_h;
/*     */       }
/*     */       else {
/*     */         
/* 231 */         Block block2 = replacableBlock[i2];
/*     */         
/* 233 */         if (block2 != null && block2.func_149688_o() != Material.field_151579_a) {
/*     */           
/* 235 */           if (block2 == Blocks.field_150348_b)
/*     */           {
/* 237 */             if (k == -1) {
/*     */               
/* 239 */               if (l <= 0) {
/*     */                 
/* 241 */                 block = null;
/* 242 */                 b0 = 0;
/* 243 */                 block1 = Blocks.field_150348_b;
/*     */               }
/* 245 */               else if (l1 >= 59 && l1 <= 64) {
/*     */                 
/* 247 */                 block = bgb.field_76752_A;
/* 248 */                 b0 = (byte)(bgb.field_150604_aj & 0xFF);
/* 249 */                 block1 = bgb.field_76753_B;
/*     */               } 
/*     */               
/* 252 */               if (l1 < 63 && (block == null || block.func_149688_o() == Material.field_151579_a))
/*     */               {
/* 254 */                 if (bgb.func_150564_a(x, l1, y) < 0.15F) {
/*     */                   
/* 256 */                   block = Blocks.field_150432_aD;
/* 257 */                   b0 = 0;
/*     */                 }
/*     */                 else {
/*     */                   
/* 261 */                   block = Blocks.field_150355_j;
/* 262 */                   b0 = 0;
/*     */                 } 
/*     */               }
/*     */               
/* 266 */               k = l;
/*     */               
/* 268 */               if (l1 >= 62)
/*     */               {
/* 270 */                 replacableBlock[i2] = block;
/* 271 */                 aByte[i2] = b0;
/*     */               }
/* 273 */               else if (l1 < 56 - l)
/*     */               {
/* 275 */                 block = null;
/* 276 */                 block1 = Blocks.field_150348_b;
/* 277 */                 replacableBlock[i2] = Blocks.field_150351_n;
/*     */               }
/*     */               else
/*     */               {
/* 281 */                 replacableBlock[i2] = block1;
/*     */               }
/*     */             
/* 284 */             } else if (k > 0) {
/*     */               
/* 286 */               k--;
/* 287 */               replacableBlock[i2] = block1;
/*     */               
/* 289 */               if (k == 0 && block1 == Blocks.field_150354_m)
/*     */               {
/* 291 */                 k = random.nextInt(4) + Math.max(0, l1 - 63);
/* 292 */                 block1 = Blocks.field_150322_A;
/*     */               }
/*     */             
/*     */             } 
/*     */           }
/*     */         } else {
/*     */           
/* 299 */           k = -1;
/*     */         } 
/*     */       } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 320 */       Block var38 = replacableBlock[i2];
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 325 */       if (l1 > 31 && l1 < 200 && var38 == Blocks.field_150348_b) {
/* 326 */         replacableBlock[i2] = Blocks.field_150350_a;
/*     */       }
/* 328 */       if (l1 <= 31 && l1 > 0 && var38 == Blocks.field_150348_b) {
/* 329 */         replacableBlock[i2] = BlocksDBC.BlockTCFloor;
/*     */       }
/* 331 */       if (l1 < 200 && var38 == Blocks.field_150355_j) {
/* 332 */         replacableBlock[i2] = Blocks.field_150350_a;
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
/*     */   public Chunk func_73158_c(int par1, int par2) {
/* 346 */     return func_73154_d(par1, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk func_73154_d(int par1, int par2) {
/* 355 */     this.rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
/* 356 */     Block[] ablock = new Block[65536];
/* 357 */     byte[] abyte = new byte[65536];
/* 358 */     func_147424_a(par1, par2, ablock);
/* 359 */     this.biomesForGeneration = this.worldObj.func_72959_q().func_76933_b(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
/* 360 */     replaceBlocksForBiome(par1, par2, ablock, abyte, this.biomesForGeneration);
/* 361 */     this.caveGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
/* 362 */     this.ravineGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
/* 363 */     if (this.mapFeaturesEnabled) {
/* 364 */       this.scatteredFeatureGenerator.func_151539_a(this, this.worldObj, par1, par2, ablock);
/*     */     }
/* 366 */     Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
/* 367 */     byte[] abyte1 = chunk.func_76605_m();
/* 368 */     for (int k = 0; k < abyte1.length; k++) {
/* 369 */       abyte1[k] = (byte)(this.biomesForGeneration[k]).field_76756_M;
/*     */     }
/* 371 */     chunk.func_76603_b();
/* 372 */     return chunk;
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
/* 385 */     this.noise5 = this.noiseGen6.func_76305_a(this.noise5, p_147423_1_, p_147423_3_, 5, 5, 200.0D, 200.0D, 0.5D);
/* 386 */     this.noise3 = this.noiseGen3.func_76304_a(this.noise3, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
/* 387 */     this.noise1 = this.noiseGen1.func_76304_a(this.noise1, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
/* 388 */     this.noise2 = this.noiseGen2.func_76304_a(this.noise2, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
/* 389 */     int l = 0;
/* 390 */     int i1 = 0;
/* 391 */     for (int j1 = 0; j1 < 5; j1++) {
/* 392 */       for (int k1 = 0; k1 < 5; k1++) {
/* 393 */         float f = 0.0F;
/* 394 */         float f1 = 0.0F;
/* 395 */         float f2 = 0.0F;
/* 396 */         byte b0 = 2;
/* 397 */         BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];
/* 398 */         for (int l1 = -b0; l1 <= b0; l1++) {
/* 399 */           for (int i2 = -b0; i2 <= b0; i2++) {
/* 400 */             BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
/* 401 */             float f3 = biomegenbase1.field_76748_D;
/* 402 */             float f4 = biomegenbase1.field_76749_E;
/* 403 */             if (this.worldType == WorldType.field_151360_e && f3 > 0.0F) {
/* 404 */               f3 = 1.0F + f3 * 2.0F;
/* 405 */               f4 = 1.0F + f4 * 4.0F;
/*     */             } 
/* 407 */             float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);
/* 408 */             if (biomegenbase1.field_76748_D > biomegenbase.field_76748_D) {
/* 409 */               f5 /= 2.0F;
/*     */             }
/* 411 */             f += f4 * f5;
/* 412 */             f1 += f3 * f5;
/* 413 */             f2 += f5;
/*     */           } 
/*     */         } 
/* 416 */         f /= f2;
/* 417 */         f1 /= f2;
/* 418 */         f = f * 0.9F + 0.1F;
/* 419 */         f1 = (f1 * 4.0F - 1.0F) / 8.0F;
/* 420 */         double d12 = this.noise5[i1] / 8000.0D;
/* 421 */         if (d12 < 0.0D) {
/* 422 */           d12 = -d12 * 0.3D;
/*     */         }
/* 424 */         d12 = d12 * 3.0D - 2.0D;
/* 425 */         if (d12 < 0.0D) {
/* 426 */           d12 /= 2.0D;
/* 427 */           if (d12 < -1.0D) {
/* 428 */             d12 = -1.0D;
/*     */           }
/* 430 */           d12 /= 1.4D;
/* 431 */           d12 /= 2.0D;
/*     */         } else {
/* 433 */           if (d12 > 1.0D) {
/* 434 */             d12 = 1.0D;
/*     */           }
/* 436 */           d12 /= 8.0D;
/*     */         } 
/* 438 */         i1++;
/* 439 */         double d13 = f1;
/* 440 */         double d14 = f;
/* 441 */         d13 += d12 * 0.2D;
/* 442 */         d13 = d13 * 8.5D / 8.0D;
/* 443 */         double d5 = 8.5D + d13 * 4.0D;
/* 444 */         for (int j2 = 0; j2 < 33; j2++) {
/* 445 */           double d6 = (j2 - d5) * 12.0D * 128.0D / 256.0D / d14;
/* 446 */           if (d6 < 0.0D) {
/* 447 */             d6 *= 4.0D;
/*     */           }
/* 449 */           double d7 = this.noise1[l] / 512.0D;
/* 450 */           double d8 = this.noise2[l] / 512.0D;
/* 451 */           double d9 = (this.noise3[l] / 10.0D + 1.0D) / 2.0D;
/* 452 */           double d10 = MathHelper.func_151238_b(d7, d8, d9) - d6;
/* 453 */           if (j2 > 29) {
/* 454 */             double d11 = ((j2 - 29) / 3.0F);
/* 455 */             d10 = d10 * (1.0D - d11) + -10.0D * d11;
/*     */           } 
/* 457 */           this.noiseArray[l] = d10;
/* 458 */           l++;
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
/* 469 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73153_a(IChunkProvider par1IChunkProvider, int par2, int par3) {
/* 477 */     BlockFalling.field_149832_M = true;
/* 478 */     int k = par2 * 16;
/* 479 */     int l = par3 * 16;
/* 480 */     BiomeGenBase biomegenbase = this.worldObj.func_72807_a(k + 16, l + 16);
/* 481 */     this.rand.setSeed(this.worldObj.func_72905_C());
/* 482 */     long i1 = this.rand.nextLong() / 2L * 2L + 1L;
/* 483 */     long j1 = this.rand.nextLong() / 2L * 2L + 1L;
/* 484 */     this.rand.setSeed(par2 * i1 + par3 * j1 ^ this.worldObj.func_72905_C());
/* 485 */     boolean flag = false;
/* 486 */     MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Pre(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 548 */     MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Post(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag));
/* 549 */     BlockFalling.field_149832_M = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73151_a(boolean par1, IProgressUpdate par2IProgressUpdate) {
/* 558 */     return true;
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
/* 573 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73157_c() {
/* 581 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_73148_d() {
/* 589 */     return "RandomLevelSource";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_73155_a(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4) {
/* 598 */     BiomeGenBase biomegenbase = this.worldObj.func_72807_a(par2, par4);
/* 599 */     return (par1EnumCreatureType == EnumCreatureType.monster && this.scatteredFeatureGenerator.func_143030_a(par2, par3, par4)) ? this.scatteredFeatureGenerator.func_82667_a() : biomegenbase.func_76747_a(par1EnumCreatureType);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_73152_e() {
/* 604 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_82695_e(int par1, int par2) {
/* 609 */     if (this.mapFeaturesEnabled);
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
/* 621 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\x2ChunkProviderTC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */