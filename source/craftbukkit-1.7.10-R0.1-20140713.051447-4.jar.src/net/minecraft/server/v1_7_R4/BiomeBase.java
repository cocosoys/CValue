/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import java.util.Set;
/*     */ import net.minecraft.util.com.google.common.collect.Sets;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class BiomeBase
/*     */ {
/*  24 */   private static final Logger aC = LogManager.getLogger();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  46 */   protected static final BiomeTemperature a = new BiomeTemperature(0.1F, 0.2F);
/*  47 */   protected static final BiomeTemperature b = new BiomeTemperature(-0.5F, 0.0F);
/*  48 */   protected static final BiomeTemperature c = new BiomeTemperature(-1.0F, 0.1F);
/*  49 */   protected static final BiomeTemperature d = new BiomeTemperature(-1.8F, 0.1F);
/*  50 */   protected static final BiomeTemperature e = new BiomeTemperature(0.125F, 0.05F);
/*  51 */   protected static final BiomeTemperature f = new BiomeTemperature(0.2F, 0.2F);
/*  52 */   protected static final BiomeTemperature g = new BiomeTemperature(0.45F, 0.3F);
/*  53 */   protected static final BiomeTemperature h = new BiomeTemperature(1.5F, 0.025F);
/*  54 */   protected static final BiomeTemperature i = new BiomeTemperature(1.0F, 0.5F);
/*  55 */   protected static final BiomeTemperature j = new BiomeTemperature(0.0F, 0.025F);
/*  56 */   protected static final BiomeTemperature k = new BiomeTemperature(0.1F, 0.8F);
/*  57 */   protected static final BiomeTemperature l = new BiomeTemperature(0.2F, 0.3F);
/*  58 */   protected static final BiomeTemperature m = new BiomeTemperature(-0.2F, 0.1F);
/*     */   
/*  60 */   private static final BiomeBase[] biomes = new BiomeBase[256];
/*  61 */   public static final Set n = Sets.newHashSet();
/*     */   
/*  63 */   public static final BiomeBase OCEAN = (new BiomeOcean(0)).b(112).a("Ocean").a(c);
/*  64 */   public static final BiomeBase PLAINS = (new BiomePlains(1)).b(9286496).a("Plains");
/*  65 */   public static final BiomeBase DESERT = (new BiomeDesert(2)).b(16421912).a("Desert").b().a(2.0F, 0.0F).a(e);
/*     */   
/*  67 */   public static final BiomeBase EXTREME_HILLS = (new BiomeBigHills(3, false)).b(6316128).a("Extreme Hills").a(i).a(0.2F, 0.3F);
/*  68 */   public static final BiomeBase FOREST = (new BiomeForest(4, 0)).b(353825).a("Forest");
/*  69 */   public static final BiomeBase TAIGA = (new BiomeTaiga(5, 0)).b(747097).a("Taiga").a(5159473).a(0.25F, 0.8F).a(f);
/*     */ 
/*     */   
/*  72 */   public static final BiomeBase SWAMPLAND = (new BiomeSwamp(6)).b(522674).a("Swampland").a(9154376).a(m).a(0.8F, 0.9F);
/*  73 */   public static final BiomeBase RIVER = (new BiomeRiver(7)).b(255).a("River").a(b);
/*     */   
/*  75 */   public static final BiomeBase HELL = (new BiomeHell(8)).b(16711680).a("Hell").b().a(2.0F, 0.0F);
/*  76 */   public static final BiomeBase SKY = (new BiomeTheEnd(9)).b(8421631).a("Sky").b();
/*     */   
/*  78 */   public static final BiomeBase FROZEN_OCEAN = (new BiomeOcean(10)).b(9474208).a("FrozenOcean").c().a(c).a(0.0F, 0.5F);
/*  79 */   public static final BiomeBase FROZEN_RIVER = (new BiomeRiver(11)).b(10526975).a("FrozenRiver").c().a(b).a(0.0F, 0.5F);
/*  80 */   public static final BiomeBase ICE_PLAINS = (new BiomeIcePlains(12, false)).b(16777215).a("Ice Plains").c().a(0.0F, 0.5F).a(e);
/*  81 */   public static final BiomeBase ICE_MOUNTAINS = (new BiomeIcePlains(13, false)).b(10526880).a("Ice Mountains").c().a(g).a(0.0F, 0.5F);
/*     */ 
/*     */   
/*  84 */   public static final BiomeBase MUSHROOM_ISLAND = (new BiomeMushrooms(14)).b(16711935).a("MushroomIsland").a(0.9F, 1.0F).a(l);
/*  85 */   public static final BiomeBase MUSHROOM_SHORE = (new BiomeMushrooms(15)).b(10486015).a("MushroomIslandShore").a(0.9F, 1.0F).a(j);
/*     */   
/*  87 */   public static final BiomeBase BEACH = (new BiomeBeach(16)).b(16440917).a("Beach").a(0.8F, 0.4F).a(j);
/*  88 */   public static final BiomeBase DESERT_HILLS = (new BiomeDesert(17)).b(13786898).a("DesertHills").b().a(2.0F, 0.0F).a(g);
/*  89 */   public static final BiomeBase FOREST_HILLS = (new BiomeForest(18, 0)).b(2250012).a("ForestHills").a(g);
/*  90 */   public static final BiomeBase TAIGA_HILLS = (new BiomeTaiga(19, 0)).b(1456435).a("TaigaHills").a(5159473).a(0.25F, 0.8F).a(g);
/*     */   
/*  92 */   public static final BiomeBase SMALL_MOUNTAINS = (new BiomeBigHills(20, true)).b(7501978).a("Extreme Hills Edge").a(i.a()).a(0.2F, 0.3F);
/*     */ 
/*     */   
/*  95 */   public static final BiomeBase JUNGLE = (new BiomeJungle(21, false)).b(5470985).a("Jungle").a(5470985).a(0.95F, 0.9F);
/*  96 */   public static final BiomeBase JUNGLE_HILLS = (new BiomeJungle(22, false)).b(2900485).a("JungleHills").a(5470985).a(0.95F, 0.9F).a(g);
/*     */   
/*  98 */   public static final BiomeBase JUNGLE_EDGE = (new BiomeJungle(23, true)).b(6458135).a("JungleEdge").a(5470985).a(0.95F, 0.8F);
/*     */   
/* 100 */   public static final BiomeBase DEEP_OCEAN = (new BiomeOcean(24)).b(48).a("Deep Ocean").a(d);
/* 101 */   public static final BiomeBase STONE_BEACH = (new BiomeStoneBeach(25)).b(10658436).a("Stone Beach").a(0.2F, 0.3F).a(k);
/* 102 */   public static final BiomeBase COLD_BEACH = (new BiomeBeach(26)).b(16445632).a("Cold Beach").a(0.05F, 0.3F).a(j).c();
/*     */   
/* 104 */   public static final BiomeBase BIRCH_FOREST = (new BiomeForest(27, 2)).a("Birch Forest").b(3175492);
/* 105 */   public static final BiomeBase BIRCH_FOREST_HILLS = (new BiomeForest(28, 2)).a("Birch Forest Hills").b(2055986).a(g);
/* 106 */   public static final BiomeBase ROOFED_FOREST = (new BiomeForest(29, 3)).b(4215066).a("Roofed Forest");
/*     */   
/* 108 */   public static final BiomeBase COLD_TAIGA = (new BiomeTaiga(30, 0)).b(3233098).a("Cold Taiga").a(5159473).c().a(-0.5F, 0.4F).a(f).c(16777215);
/*     */   
/* 110 */   public static final BiomeBase COLD_TAIGA_HILLS = (new BiomeTaiga(31, 0)).b(2375478).a("Cold Taiga Hills").a(5159473).c().a(-0.5F, 0.4F).a(g).c(16777215);
/*     */   
/* 112 */   public static final BiomeBase MEGA_TAIGA = (new BiomeTaiga(32, 1)).b(5858897).a("Mega Taiga").a(5159473).a(0.3F, 0.8F).a(f);
/*     */   
/* 114 */   public static final BiomeBase MEGA_TAIGA_HILLS = (new BiomeTaiga(33, 1)).b(4542270).a("Mega Taiga Hills").a(5159473).a(0.3F, 0.8F).a(g);
/*     */ 
/*     */   
/* 117 */   public static final BiomeBase EXTREME_HILLS_PLUS = (new BiomeBigHills(34, true)).b(5271632).a("Extreme Hills+").a(i).a(0.2F, 0.3F);
/*     */ 
/*     */   
/* 120 */   public static final BiomeBase SAVANNA = (new BiomeSavanna(35)).b(12431967).a("Savanna").a(1.2F, 0.0F).b().a(e);
/* 121 */   public static final BiomeBase SAVANNA_PLATEAU = (new BiomeSavanna(36)).b(10984804).a("Savanna Plateau").a(1.0F, 0.0F).b().a(h);
/*     */   
/* 123 */   public static final BiomeBase MESA = (new BiomeMesa(37, false, false)).b(14238997).a("Mesa");
/* 124 */   public static final BiomeBase MESA_PLATEAU_F = (new BiomeMesa(38, false, true)).b(11573093).a("Mesa Plateau F").a(h);
/* 125 */   public static final BiomeBase MESA_PLATEAU = (new BiomeMesa(39, false, false)).b(13274213).a("Mesa Plateau").a(h);
/*     */ 
/*     */   
/*     */   static {
/* 129 */     PLAINS.k();
/* 130 */     DESERT.k();
/* 131 */     FOREST.k();
/* 132 */     TAIGA.k();
/* 133 */     SWAMPLAND.k();
/* 134 */     ICE_PLAINS.k();
/* 135 */     JUNGLE.k();
/* 136 */     JUNGLE_EDGE.k();
/* 137 */     COLD_TAIGA.k();
/* 138 */     SAVANNA.k();
/* 139 */     SAVANNA_PLATEAU.k();
/* 140 */     MESA.k();
/* 141 */     MESA_PLATEAU_F.k();
/* 142 */     MESA_PLATEAU.k();
/* 143 */     BIRCH_FOREST.k();
/* 144 */     BIRCH_FOREST_HILLS.k();
/* 145 */     ROOFED_FOREST.k();
/* 146 */     MEGA_TAIGA.k();
/* 147 */     EXTREME_HILLS.k();
/* 148 */     EXTREME_HILLS_PLUS.k();
/*     */ 
/*     */     
/* 151 */     biomes[MEGA_TAIGA_HILLS.id + 128] = biomes[MEGA_TAIGA.id + 128];
/*     */     
/* 153 */     for (BiomeBase biomeBase : biomes) {
/* 154 */       if (biomeBase != null && biomeBase.id < 128) {
/* 155 */         n.add(biomeBase);
/*     */       }
/*     */     } 
/*     */     
/* 159 */     n.remove(HELL);
/* 160 */     n.remove(SKY);
/* 161 */     n.remove(FROZEN_OCEAN);
/* 162 */     n.remove(SMALL_MOUNTAINS);
/*     */   }
/*     */   
/* 165 */   protected static final NoiseGenerator3 ac = new NoiseGenerator3(new Random(1234L), 1);
/* 166 */   protected static final NoiseGenerator3 ad = new NoiseGenerator3(new Random(2345L), 1);
/* 167 */   protected static final WorldGenTallPlant ae = new WorldGenTallPlant();
/*     */   public String af;
/*     */   public int ag;
/*     */   public int ah;
/* 171 */   public Block ai = Blocks.GRASS;
/* 172 */   public int aj = 0;
/* 173 */   public Block ak = Blocks.DIRT;
/* 174 */   public int al = 5169201;
/* 175 */   public float am = a.a;
/* 176 */   public float an = a.b;
/* 177 */   public float temperature = 0.5F;
/* 178 */   public float humidity = 0.5F;
/* 179 */   public int aq = 16777215;
/*     */   
/*     */   public BiomeDecorator ar;
/*     */   
/* 183 */   protected List as = new ArrayList();
/* 184 */   protected List at = new ArrayList();
/* 185 */   protected List au = new ArrayList();
/* 186 */   protected List av = new ArrayList();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean aw;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean ax = true;
/*     */ 
/*     */ 
/*     */   
/*     */   public final int id;
/*     */ 
/*     */ 
/*     */   
/*     */   protected WorldGenTrees az;
/*     */ 
/*     */ 
/*     */   
/*     */   protected WorldGenBigTree aA;
/*     */ 
/*     */ 
/*     */   
/*     */   protected WorldGenSwampTree aB;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected BiomeDecorator a() {
/* 218 */     return new BiomeDecorator();
/*     */   }
/*     */   
/*     */   protected BiomeBase a(float paramFloat1, float paramFloat2) {
/* 222 */     if (paramFloat1 > 0.1F && paramFloat1 < 0.2F) throw new IllegalArgumentException("Please avoid temperatures in the range 0.1 - 0.2 because of snow");
/*     */     
/* 224 */     this.temperature = paramFloat1;
/* 225 */     this.humidity = paramFloat2;
/* 226 */     return this;
/*     */   }
/*     */   
/*     */   protected final BiomeBase a(BiomeTemperature paramBiomeTemperature) {
/* 230 */     this.am = paramBiomeTemperature.a;
/* 231 */     this.an = paramBiomeTemperature.b;
/* 232 */     return this;
/*     */   }
/*     */   
/*     */   protected BiomeBase b() {
/* 236 */     this.ax = false;
/* 237 */     return this;
/*     */   }
/*     */   
/* 240 */   protected BiomeBase(int paramInt) { this.az = new WorldGenTrees(false);
/* 241 */     this.aA = new WorldGenBigTree(false);
/* 242 */     this.aB = new WorldGenSwampTree(); this.id = paramInt; biomes[paramInt] = this; this.ar = a(); this.at.add(new BiomeMeta(EntitySheep.class, 12, 4, 4)); this.at.add(new BiomeMeta(EntityPig.class, 10, 4, 4)); this.at.add(new BiomeMeta(EntityChicken.class, 10, 4, 4)); this.at.add(new BiomeMeta(EntityCow.class, 8, 4, 4)); this.as.add(new BiomeMeta(EntitySpider.class, 100, 4, 4)); this.as.add(new BiomeMeta(EntityZombie.class, 100, 4, 4)); this.as.add(new BiomeMeta(EntitySkeleton.class, 100, 4, 4)); this.as.add(new BiomeMeta(EntityCreeper.class, 100, 4, 4)); this.as.add(new BiomeMeta(EntitySlime.class, 100, 4, 4)); this.as.add(new BiomeMeta(EntityEnderman.class, 10, 1, 4));
/*     */     this.as.add(new BiomeMeta(EntityWitch.class, 5, 1, 1));
/*     */     this.au.add(new BiomeMeta(EntitySquid.class, 10, 4, 4));
/* 245 */     this.av.add(new BiomeMeta(EntityBat.class, 10, 8, 8)); } public WorldGenTreeAbstract a(Random paramRandom) { if (paramRandom.nextInt(10) == 0) {
/* 246 */       return this.aA;
/*     */     }
/* 248 */     return this.az; }
/*     */ 
/*     */   
/*     */   public WorldGenerator b(Random paramRandom) {
/* 252 */     return new WorldGenGrass(Blocks.LONG_GRASS, 1);
/*     */   }
/*     */   
/*     */   public String a(Random paramRandom, int paramInt1, int paramInt2, int paramInt3) {
/* 256 */     if (paramRandom.nextInt(3) > 0) {
/* 257 */       return BlockFlowers.b[0];
/*     */     }
/* 259 */     return BlockFlowers.a[0];
/*     */   }
/*     */   
/*     */   protected BiomeBase c() {
/* 263 */     this.aw = true;
/* 264 */     return this;
/*     */   }
/*     */   
/*     */   protected BiomeBase a(String paramString) {
/* 268 */     this.af = paramString;
/* 269 */     return this;
/*     */   }
/*     */   
/*     */   protected BiomeBase a(int paramInt) {
/* 273 */     this.al = paramInt;
/* 274 */     return this;
/*     */   }
/*     */   
/*     */   protected BiomeBase b(int paramInt) {
/* 278 */     a(paramInt, false);
/* 279 */     return this;
/*     */   }
/*     */   
/*     */   protected BiomeBase c(int paramInt) {
/* 283 */     this.ah = paramInt;
/* 284 */     return this;
/*     */   }
/*     */   
/*     */   protected BiomeBase a(int paramInt, boolean paramBoolean) {
/* 288 */     this.ag = paramInt;
/* 289 */     if (paramBoolean) {
/* 290 */       this.ah = (paramInt & 0xFEFEFE) >> 1;
/*     */     } else {
/* 292 */       this.ah = paramInt;
/*     */     } 
/* 294 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List getMobs(EnumCreatureType paramEnumCreatureType) {
/* 305 */     if (paramEnumCreatureType == EnumCreatureType.MONSTER) return this.as; 
/* 306 */     if (paramEnumCreatureType == EnumCreatureType.CREATURE) return this.at; 
/* 307 */     if (paramEnumCreatureType == EnumCreatureType.WATER_CREATURE) return this.au; 
/* 308 */     if (paramEnumCreatureType == EnumCreatureType.AMBIENT) return this.av; 
/* 309 */     return null;
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
/*     */   public boolean d() {
/* 331 */     return j();
/*     */   }
/*     */   
/*     */   public boolean e() {
/* 335 */     if (j()) return false; 
/* 336 */     return this.ax;
/*     */   }
/*     */   
/*     */   public boolean f() {
/* 340 */     return (this.humidity > 0.85F);
/*     */   }
/*     */   
/*     */   public float g() {
/* 344 */     return 0.1F;
/*     */   }
/*     */   
/*     */   public final int h() {
/* 348 */     return (int)(this.humidity * 65536.0F);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final float a(int paramInt1, int paramInt2, int paramInt3) {
/* 356 */     if (paramInt2 > 64) {
/* 357 */       float f = (float)ac.a(paramInt1 * 1.0D / 8.0D, paramInt3 * 1.0D / 8.0D) * 4.0F;
/* 358 */       return this.temperature - (f + paramInt2 - 64.0F) * 0.05F / 30.0F;
/*     */     } 
/* 360 */     return this.temperature;
/*     */   }
/*     */   
/*     */   public void a(World paramWorld, Random paramRandom, int paramInt1, int paramInt2) {
/* 364 */     this.ar.a(paramWorld, paramRandom, this, paramInt1, paramInt2);
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
/*     */   public boolean j() {
/* 382 */     return this.aw;
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(World paramWorld, Random paramRandom, Block[] paramArrayOfBlock, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, double paramDouble) {
/* 387 */     b(paramWorld, paramRandom, paramArrayOfBlock, paramArrayOfbyte, paramInt1, paramInt2, paramDouble);
/*     */   }
/*     */   
/*     */   public final void b(World paramWorld, Random paramRandom, Block[] paramArrayOfBlock, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, double paramDouble) {
/* 391 */     byte b = 63;
/* 392 */     Block block1 = this.ai;
/* 393 */     byte b1 = (byte)(this.aj & 0xFF);
/* 394 */     Block block2 = this.ak;
/* 395 */     int i = -1;
/* 396 */     int j = (int)(paramDouble / 3.0D + 3.0D + paramRandom.nextDouble() * 0.25D);
/*     */     
/* 398 */     int k = paramInt1 & 0xF;
/* 399 */     int m = paramInt2 & 0xF;
/* 400 */     int n = paramArrayOfBlock.length / 256;
/* 401 */     for (char c = 'ÿ'; c >= '\000'; c--) {
/* 402 */       int i1 = (m * 16 + k) * n + c;
/*     */       
/* 404 */       if (c <= 0 + paramRandom.nextInt(5)) {
/* 405 */         paramArrayOfBlock[i1] = Blocks.BEDROCK;
/*     */       } else {
/* 407 */         Block block = paramArrayOfBlock[i1];
/*     */         
/* 409 */         if (block == null || block.getMaterial() == Material.AIR) {
/* 410 */           i = -1;
/* 411 */         } else if (block == Blocks.STONE) {
/* 412 */           if (i == -1) {
/* 413 */             if (j <= 0) {
/* 414 */               block1 = null;
/* 415 */               b1 = 0;
/* 416 */               block2 = Blocks.STONE;
/* 417 */             } else if (c >= ';' && c <= '@') {
/* 418 */               block1 = this.ai;
/* 419 */               b1 = (byte)(this.aj & 0xFF);
/* 420 */               block2 = this.ak;
/*     */             } 
/*     */             
/* 423 */             if (c < '?' && (block1 == null || block1.getMaterial() == Material.AIR)) {
/* 424 */               if (a(paramInt1, c, paramInt2) < 0.15F) {
/* 425 */                 block1 = Blocks.ICE;
/* 426 */                 b1 = 0;
/*     */               } else {
/* 428 */                 block1 = Blocks.STATIONARY_WATER;
/* 429 */                 b1 = 0;
/*     */               } 
/*     */             }
/*     */             
/* 433 */             i = j;
/* 434 */             if (c >= '>')
/* 435 */             { paramArrayOfBlock[i1] = block1;
/* 436 */               paramArrayOfbyte[i1] = b1; }
/* 437 */             else if (c < 56 - j)
/* 438 */             { block1 = null;
/* 439 */               block2 = Blocks.STONE;
/* 440 */               paramArrayOfBlock[i1] = Blocks.GRAVEL; }
/* 441 */             else { paramArrayOfBlock[i1] = block2; } 
/* 442 */           } else if (i > 0) {
/* 443 */             i--;
/* 444 */             paramArrayOfBlock[i1] = block2;
/*     */ 
/*     */             
/* 447 */             if (i == 0 && block2 == Blocks.SAND) {
/* 448 */               i = paramRandom.nextInt(4) + Math.max(0, c - 63);
/* 449 */               block2 = Blocks.SANDSTONE;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected BiomeBase k() {
/* 458 */     return new BiomeBaseSub(this.id + 128, this);
/*     */   }
/*     */   
/*     */   public Class l() {
/* 462 */     return getClass();
/*     */   }
/*     */   
/*     */   public boolean a(BiomeBase paramBiomeBase) {
/* 466 */     if (paramBiomeBase == this) {
/* 467 */       return true;
/*     */     }
/* 469 */     if (paramBiomeBase == null) {
/* 470 */       return false;
/*     */     }
/* 472 */     return (l() == paramBiomeBase.l());
/*     */   }
/*     */   
/*     */   public EnumTemperature m() {
/* 476 */     if (this.temperature < 0.2D) {
/* 477 */       return EnumTemperature.COLD;
/*     */     }
/* 479 */     if (this.temperature < 1.0D) {
/* 480 */       return EnumTemperature.MEDIUM;
/*     */     }
/* 482 */     return EnumTemperature.WARM;
/*     */   }
/*     */   
/*     */   public static BiomeBase[] getBiomes() {
/* 486 */     return biomes;
/*     */   }
/*     */   
/*     */   public static BiomeBase getBiome(int paramInt) {
/* 490 */     if (paramInt < 0 || paramInt > biomes.length) {
/* 491 */       aC.warn("Biome ID is out of bounds: " + paramInt + ", defaulting to 0 (Ocean)");
/* 492 */       return OCEAN;
/*     */     } 
/* 494 */     return biomes[paramInt];
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BiomeBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */