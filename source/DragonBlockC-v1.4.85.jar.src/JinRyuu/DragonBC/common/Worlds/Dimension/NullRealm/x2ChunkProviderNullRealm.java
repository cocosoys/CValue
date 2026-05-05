/*     */ package JinRyuu.DragonBC.common.Worlds.Dimension.NullRealm;
/*     */ 
/*     */ import JinRyuu.DragonBC.common.Worlds.BiomeGenBaseDBC;
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
/*     */ 
/*     */ public class x2ChunkProviderNullRealm
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
/*  62 */   private double[] stoneNoise = new double[256];
/*  63 */   private MapGenBase caveGenerator = (MapGenBase)new MapGenCaves();
/*     */   
/*  65 */   private MapGenScatteredFeature scatteredFeatureGenerator = new MapGenScatteredFeature();
/*     */ 
/*     */   
/*  68 */   private MapGenBase ravineGenerator = (MapGenBase)new MapGenRavine();
/*     */   
/*     */   private BiomeGenBase[] biomesForGeneration;
/*     */   
/*     */   double[] noise3;
/*     */   
/*     */   double[] noise1;
/*     */   
/*     */   double[] noise2;
/*     */   double[] noise5;
/*  78 */   int[][] field_73219_j = new int[32][32];
/*     */ 
/*     */ 
/*     */   
/*     */   public x2ChunkProviderNullRealm(World world, long seed, boolean mapFeaturesEnabled) {
/*  83 */     this.worldObj = world;
/*  84 */     this.mapFeaturesEnabled = mapFeaturesEnabled;
/*  85 */     this.worldType = world.func_72912_H().func_76067_t();
/*  86 */     this.rand = new Random(seed);
/*  87 */     this.noiseGen1 = new NoiseGeneratorOctaves(this.rand, 16);
/*  88 */     this.noiseGen2 = new NoiseGeneratorOctaves(this.rand, 16);
/*  89 */     this.noiseGen3 = new NoiseGeneratorOctaves(this.rand, 8);
/*  90 */     this.noisePerl = new NoiseGeneratorPerlin(this.rand, 4);
/*  91 */     this.noiseGen5 = new NoiseGeneratorOctaves(this.rand, 10);
/*  92 */     this.noiseGen6 = new NoiseGeneratorOctaves(this.rand, 16);
/*  93 */     this.mobSpawnerNoise = new NoiseGeneratorOctaves(this.rand, 8);
/*  94 */     this.noiseArray = new double[825];
/*  95 */     this.parabolicField = new float[25];
/*  96 */     for (int j = -2; j <= 2; j++) {
/*  97 */       for (int k = -2; k <= 2; k++) {
/*  98 */         float f = 10.0F / MathHelper.func_76129_c((j * j + k * k) + 0.2F);
/*  99 */         this.parabolicField[j + 2 + (k + 2) * 5] = f;
/*     */       } 
/*     */     } 
/* 102 */     NoiseGenerator[] noiseGens = { (NoiseGenerator)this.noiseGen1, (NoiseGenerator)this.noiseGen2, (NoiseGenerator)this.noiseGen3, (NoiseGenerator)this.noisePerl, (NoiseGenerator)this.noiseGen5, (NoiseGenerator)this.noiseGen6, (NoiseGenerator)this.mobSpawnerNoise };
/* 103 */     noiseGens = TerrainGen.getModdedNoiseGenerators(world, this.rand, noiseGens);
/* 104 */     this.noiseGen1 = (NoiseGeneratorOctaves)noiseGens[0];
/* 105 */     this.noiseGen2 = (NoiseGeneratorOctaves)noiseGens[1];
/* 106 */     this.noiseGen3 = (NoiseGeneratorOctaves)noiseGens[2];
/* 107 */     this.noisePerl = (NoiseGeneratorPerlin)noiseGens[3];
/* 108 */     this.noiseGen5 = (NoiseGeneratorOctaves)noiseGens[4];
/* 109 */     this.noiseGen6 = (NoiseGeneratorOctaves)noiseGens[5];
/* 110 */     this.mobSpawnerNoise = (NoiseGeneratorOctaves)noiseGens[6];
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
/* 124 */     byte b0 = 63;
/* 125 */     this.biomesForGeneration = this.worldObj.func_72959_q().func_76937_a(this.biomesForGeneration, par1 * 4 - 2, par2 * 4 - 2, 10, 10);
/* 126 */     func_147423_a(par1 * 4, 0, par2 * 4);
/* 127 */     for (int k = 0; k < 4; k++) {
/* 128 */       int l = k * 5;
/* 129 */       int i1 = (k + 1) * 5;
/* 130 */       for (int j1 = 0; j1 < 4; j1++) {
/* 131 */         int k1 = (l + j1) * 33;
/* 132 */         int l1 = (l + j1 + 1) * 33;
/* 133 */         int i2 = (i1 + j1) * 33;
/* 134 */         int j2 = (i1 + j1 + 1) * 33;
/* 135 */         for (int k2 = 0; k2 < 32; k2++) {
/* 136 */           double d0 = 0.125D;
/* 137 */           double d1 = this.noiseArray[k1 + k2];
/* 138 */           double d2 = this.noiseArray[l1 + k2];
/* 139 */           double d3 = this.noiseArray[i2 + k2];
/* 140 */           double d4 = this.noiseArray[j2 + k2];
/* 141 */           double d5 = (this.noiseArray[k1 + k2 + 1] - d1) * d0;
/* 142 */           double d6 = (this.noiseArray[l1 + k2 + 1] - d2) * d0;
/* 143 */           double d7 = (this.noiseArray[i2 + k2 + 1] - d3) * d0;
/* 144 */           double d8 = (this.noiseArray[j2 + k2 + 1] - d4) * d0;
/* 145 */           for (int l2 = 0; l2 < 8; l2++) {
/* 146 */             double d9 = 0.25D;
/* 147 */             double d10 = d1;
/* 148 */             double d11 = d2;
/* 149 */             double d12 = (d3 - d1) * d9;
/* 150 */             double d13 = (d4 - d2) * d9;
/* 151 */             for (int i3 = 0; i3 < 4; i3++) {
/* 152 */               int j3 = i3 + k * 4 << 12 | 0 + j1 * 4 << 8 | k2 * 8 + l2;
/* 153 */               short short1 = 256;
/* 154 */               j3 -= short1;
/* 155 */               double d14 = 0.25D;
/* 156 */               double d16 = (d11 - d10) * d14;
/* 157 */               double d15 = d10 - d16;
/* 158 */               for (int k3 = 0; k3 < 4; k3++) {
/* 159 */                 if ((d15 += d16) > 0.0D) {
/* 160 */                   blocks[j3 += short1] = Blocks.field_150348_b;
/* 161 */                 } else if (k2 * 8 + l2 < b0) {
/* 162 */                   blocks[j3 += short1] = Blocks.field_150355_j;
/*     */                 } else {
/* 164 */                   blocks[j3 += short1] = null;
/*     */                 } 
/*     */               } 
/* 167 */               d10 += d12;
/* 168 */               d11 += d13;
/*     */             } 
/* 170 */             d1 += d5;
/* 171 */             d2 += d6;
/* 172 */             d3 += d7;
/* 173 */             d4 += d8;
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
/* 187 */     ChunkProviderEvent.ReplaceBiomeBlocks event = new ChunkProviderEvent.ReplaceBiomeBlocks(this, par1, par2, blocks, par3ArrayOfByte, par4ArrayOfBiomeGenBase);
/* 188 */     MinecraftForge.EVENT_BUS.post((Event)event);
/* 189 */     if (event.getResult() == Event.Result.DENY)
/* 190 */       return;  double d0 = 0.03125D;
/* 191 */     this.stoneNoise = this.noisePerl.func_151599_a(this.stoneNoise, (par1 * 16), (par2 * 16), 16, 16, d0 * 2.0D, d0 * 2.0D, 1.0D);
/* 192 */     for (int k = 0; k < 16; k++) {
/* 193 */       for (int l = 0; l < 16; l++) {
/* 194 */         BiomeGenBaseDBC biomegenbase = (BiomeGenBaseDBC)par4ArrayOfBiomeGenBase[l + k * 16];
/* 195 */         genTerrainBlocks(biomegenbase, this.worldObj, this.rand, blocks, par3ArrayOfByte, par1 * 16 + k, par2 * 16 + l, this.stoneNoise[l + k * 16]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   public void genTerrainBlocks(BiomeGenBaseDBC biomegenbase, World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
/* 200 */     genBiomeModdedTerrain(biomegenbase, p_150573_1_, p_150573_2_, p_150573_3_, p_150573_4_, p_150573_5_, p_150573_6_, p_150573_7_);
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
/* 214 */     Block block = bgb.field_76752_A;
/* 215 */     byte b0 = (byte)(bgb.field_150604_aj & 0xFF);
/* 216 */     Block block1 = bgb.field_76753_B;
/* 217 */     int k = -1;
/* 218 */     int l = (int)(z / 3.0D + 3.0D + random.nextDouble() * 0.25D);
/* 219 */     int i1 = x & 0xF;
/* 220 */     int j1 = y & 0xF;
/* 221 */     int k1 = replacableBlock.length / 256;
/* 222 */     for (int l1 = 255; l1 >= 0; l1--) {
/*     */       
/* 224 */       int i2 = (j1 * 16 + i1) * k1 + l1;
/*     */       
/* 226 */       if (l1 <= 0 + random.nextInt(5)) {
/*     */         
/* 228 */         replacableBlock[i2] = Blocks.field_150350_a;
/*     */       }
/*     */       else {
/*     */         
/* 232 */         Block block2 = replacableBlock[i2];
/*     */         
/* 234 */         if (block2 != null && block2.func_149688_o() != Material.field_151579_a) {
/*     */           
/* 236 */           if (block2 == Blocks.field_150348_b)
/*     */           {
/* 238 */             if (k == -1) {
/*     */               
/* 240 */               if (l <= 0) {
/*     */                 
/* 242 */                 block = null;
/* 243 */                 b0 = 0;
/* 244 */                 block1 = Blocks.field_150348_b;
/*     */               }
/* 246 */               else if (l1 >= 59 && l1 <= 64) {
/*     */                 
/* 248 */                 block = bgb.field_76752_A;
/* 249 */                 b0 = (byte)(bgb.field_150604_aj & 0xFF);
/* 250 */                 block1 = bgb.field_76753_B;
/*     */               } 
/*     */               
/* 253 */               if (l1 < 63 && (block == null || block.func_149688_o() == Material.field_151579_a))
/*     */               {
/* 255 */                 if (bgb.func_150564_a(x, l1, y) < 0.15F) {
/*     */                   
/* 257 */                   block = Blocks.field_150432_aD;
/* 258 */                   b0 = 0;
/*     */                 }
/*     */                 else {
/*     */                   
/* 262 */                   block = Blocks.field_150355_j;
/* 263 */                   b0 = 0;
/*     */                 } 
/*     */               }
/*     */               
/* 267 */               k = l;
/*     */               
/* 269 */               if (l1 >= 62)
/*     */               {
/* 271 */                 replacableBlock[i2] = block;
/* 272 */                 aByte[i2] = b0;
/*     */               }
/* 274 */               else if (l1 < 56 - l)
/*     */               {
/* 276 */                 block = null;
/* 277 */                 block1 = Blocks.field_150348_b;
/* 278 */                 replacableBlock[i2] = Blocks.field_150351_n;
/*     */               }
/*     */               else
/*     */               {
/* 282 */                 replacableBlock[i2] = block1;
/*     */               }
/*     */             
/* 285 */             } else if (k > 0) {
/*     */               
/* 287 */               k--;
/* 288 */               replacableBlock[i2] = block1;
/*     */               
/* 290 */               if (k == 0 && block1 == Blocks.field_150354_m)
/*     */               {
/* 292 */                 k = random.nextInt(4) + Math.max(0, l1 - 63);
/* 293 */                 block1 = Blocks.field_150322_A;
/*     */               }
/*     */             
/*     */             } 
/*     */           }
/*     */         } else {
/*     */           
/* 300 */           k = -1;
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
/* 321 */       Block var38 = replacableBlock[i2];
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 326 */       if (l1 > 31 && l1 < 200 && var38 == Blocks.field_150348_b) {
/* 327 */         replacableBlock[i2] = Blocks.field_150350_a;
/*     */       }
/* 329 */       if (l1 <= 31 && l1 > 0 && var38 == Blocks.field_150348_b) {
/* 330 */         replacableBlock[i2] = Blocks.field_150350_a;
/*     */       }
/* 332 */       if (l1 < 200 && var38 == Blocks.field_150355_j) {
/* 333 */         replacableBlock[i2] = Blocks.field_150350_a;
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
/* 347 */     return func_73154_d(par1, par2);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk func_73154_d(int par1, int par2) {
/* 356 */     this.rand.setSeed(par1 * 341873128712L + par2 * 132897987541L);
/* 357 */     Block[] ablock = new Block[65536];
/* 358 */     byte[] abyte = new byte[65536];
/* 359 */     func_147424_a(par1, par2, ablock);
/* 360 */     this.biomesForGeneration = this.worldObj.func_72959_q().func_76933_b(this.biomesForGeneration, par1 * 16, par2 * 16, 16, 16);
/* 361 */     replaceBlocksForBiome(par1, par2, ablock, abyte, this.biomesForGeneration);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 367 */     Chunk chunk = new Chunk(this.worldObj, ablock, abyte, par1, par2);
/* 368 */     byte[] abyte1 = chunk.func_76605_m();
/* 369 */     for (int k = 0; k < abyte1.length; k++) {
/* 370 */       abyte1[k] = (byte)(this.biomesForGeneration[k]).field_76756_M;
/*     */     }
/* 372 */     chunk.func_76603_b();
/* 373 */     return chunk;
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
/* 386 */     this.noise5 = this.noiseGen6.func_76305_a(this.noise5, p_147423_1_, p_147423_3_, 5, 5, 200.0D, 200.0D, 0.5D);
/* 387 */     this.noise3 = this.noiseGen3.func_76304_a(this.noise3, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
/* 388 */     this.noise1 = this.noiseGen1.func_76304_a(this.noise1, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
/* 389 */     this.noise2 = this.noiseGen2.func_76304_a(this.noise2, p_147423_1_, p_147423_2_, p_147423_3_, 5, 33, 5, 684.412D, 684.412D, 684.412D);
/* 390 */     int l = 0;
/* 391 */     int i1 = 0;
/* 392 */     for (int j1 = 0; j1 < 5; j1++) {
/* 393 */       for (int k1 = 0; k1 < 5; k1++) {
/* 394 */         float f = 0.0F;
/* 395 */         float f1 = 0.0F;
/* 396 */         float f2 = 0.0F;
/* 397 */         byte b0 = 2;
/* 398 */         BiomeGenBase biomegenbase = this.biomesForGeneration[j1 + 2 + (k1 + 2) * 10];
/* 399 */         for (int l1 = -b0; l1 <= b0; l1++) {
/* 400 */           for (int i2 = -b0; i2 <= b0; i2++) {
/* 401 */             BiomeGenBase biomegenbase1 = this.biomesForGeneration[j1 + l1 + 2 + (k1 + i2 + 2) * 10];
/* 402 */             float f3 = biomegenbase1.field_76748_D;
/* 403 */             float f4 = biomegenbase1.field_76749_E;
/* 404 */             if (this.worldType == WorldType.field_151360_e && f3 > 0.0F) {
/* 405 */               f3 = 1.0F + f3 * 2.0F;
/* 406 */               f4 = 1.0F + f4 * 4.0F;
/*     */             } 
/* 408 */             float f5 = this.parabolicField[l1 + 2 + (i2 + 2) * 5] / (f3 + 2.0F);
/* 409 */             if (biomegenbase1.field_76748_D > biomegenbase.field_76748_D) {
/* 410 */               f5 /= 2.0F;
/*     */             }
/* 412 */             f += f4 * f5;
/* 413 */             f1 += f3 * f5;
/* 414 */             f2 += f5;
/*     */           } 
/*     */         } 
/* 417 */         f /= f2;
/* 418 */         f1 /= f2;
/* 419 */         f = f * 0.9F + 0.1F;
/* 420 */         f1 = (f1 * 4.0F - 1.0F) / 8.0F;
/* 421 */         double d12 = this.noise5[i1] / 8000.0D;
/* 422 */         if (d12 < 0.0D) {
/* 423 */           d12 = -d12 * 0.3D;
/*     */         }
/* 425 */         d12 = d12 * 3.0D - 2.0D;
/* 426 */         if (d12 < 0.0D) {
/* 427 */           d12 /= 2.0D;
/* 428 */           if (d12 < -1.0D) {
/* 429 */             d12 = -1.0D;
/*     */           }
/* 431 */           d12 /= 1.4D;
/* 432 */           d12 /= 2.0D;
/*     */         } else {
/* 434 */           if (d12 > 1.0D) {
/* 435 */             d12 = 1.0D;
/*     */           }
/* 437 */           d12 /= 8.0D;
/*     */         } 
/* 439 */         i1++;
/* 440 */         double d13 = f1;
/* 441 */         double d14 = f;
/* 442 */         d13 += d12 * 0.2D;
/* 443 */         d13 = d13 * 8.5D / 8.0D;
/* 444 */         double d5 = 8.5D + d13 * 4.0D;
/* 445 */         for (int j2 = 0; j2 < 33; j2++) {
/* 446 */           double d6 = (j2 - d5) * 12.0D * 128.0D / 256.0D / d14;
/* 447 */           if (d6 < 0.0D) {
/* 448 */             d6 *= 4.0D;
/*     */           }
/* 450 */           double d7 = this.noise1[l] / 512.0D;
/* 451 */           double d8 = this.noise2[l] / 512.0D;
/* 452 */           double d9 = (this.noise3[l] / 10.0D + 1.0D) / 2.0D;
/* 453 */           double d10 = MathHelper.func_151238_b(d7, d8, d9) - d6;
/* 454 */           if (j2 > 29) {
/* 455 */             double d11 = ((j2 - 29) / 3.0F);
/* 456 */             d10 = d10 * (1.0D - d11) + -10.0D * d11;
/*     */           } 
/* 458 */           this.noiseArray[l] = d10;
/* 459 */           l++;
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
/* 470 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73153_a(IChunkProvider par1IChunkProvider, int par2, int par3) {
/* 478 */     BlockFalling.field_149832_M = true;
/* 479 */     int k = par2 * 16;
/* 480 */     int l = par3 * 16;
/* 481 */     BiomeGenBase biomegenbase = this.worldObj.func_72807_a(k + 16, l + 16);
/* 482 */     this.rand.setSeed(this.worldObj.func_72905_C());
/* 483 */     long i1 = this.rand.nextLong() / 2L * 2L + 1L;
/* 484 */     long j1 = this.rand.nextLong() / 2L * 2L + 1L;
/* 485 */     this.rand.setSeed(par2 * i1 + par3 * j1 ^ this.worldObj.func_72905_C());
/* 486 */     boolean flag = false;
/* 487 */     MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Pre(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 549 */     MinecraftForge.EVENT_BUS.post((Event)new PopulateChunkEvent.Post(par1IChunkProvider, this.worldObj, this.rand, par2, par3, flag));
/* 550 */     BlockFalling.field_149832_M = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73151_a(boolean par1, IProgressUpdate par2IProgressUpdate) {
/* 559 */     return true;
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
/* 574 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73157_c() {
/* 582 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_73148_d() {
/* 590 */     return "RandomLevelSource";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_73155_a(EnumCreatureType par1EnumCreatureType, int par2, int par3, int par4) {
/* 599 */     BiomeGenBase biomegenbase = this.worldObj.func_72807_a(par2, par4);
/* 600 */     return (par1EnumCreatureType == EnumCreatureType.monster && this.scatteredFeatureGenerator.func_143030_a(par2, par3, par4)) ? this.scatteredFeatureGenerator.func_82667_a() : biomegenbase.func_76747_a(par1EnumCreatureType);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_73152_e() {
/* 605 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_82695_e(int par1, int par2) {
/* 610 */     if (this.mapFeaturesEnabled);
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
/* 622 */     return null;
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\Dimension\NullRealm\x2ChunkProviderNullRealm.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */