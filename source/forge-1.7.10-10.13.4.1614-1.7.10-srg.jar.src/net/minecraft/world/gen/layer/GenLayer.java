/*     */ package net.minecraft.world.gen.layer;
/*     */ 
/*     */ import java.util.concurrent.Callable;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.util.ReportedException;
/*     */ import net.minecraft.world.WorldType;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class GenLayer
/*     */ {
/*     */   private long field_75907_b;
/*     */   protected GenLayer field_75909_a;
/*     */   private long field_75908_c;
/*     */   protected long field_75906_d;
/*     */   private static final String __OBFID = "CL_00000559";
/*     */   
/*     */   public static GenLayer[] func_75901_a(long p_75901_0_, WorldType p_75901_2_) {
/*  29 */     boolean bool = false;
/*     */     
/*  31 */     GenLayerIsland genLayerIsland = new GenLayerIsland(1L);
/*  32 */     GenLayerFuzzyZoom genLayerFuzzyZoom = new GenLayerFuzzyZoom(2000L, genLayerIsland);
/*  33 */     GenLayerAddIsland genLayerAddIsland4 = new GenLayerAddIsland(1L, genLayerFuzzyZoom);
/*  34 */     GenLayerZoom genLayerZoom2 = new GenLayerZoom(2001L, genLayerAddIsland4);
/*  35 */     GenLayerAddIsland genLayerAddIsland3 = new GenLayerAddIsland(2L, genLayerZoom2);
/*  36 */     genLayerAddIsland3 = new GenLayerAddIsland(50L, genLayerAddIsland3);
/*  37 */     genLayerAddIsland3 = new GenLayerAddIsland(70L, genLayerAddIsland3);
/*  38 */     GenLayerRemoveTooMuchOcean genLayerRemoveTooMuchOcean = new GenLayerRemoveTooMuchOcean(2L, genLayerAddIsland3);
/*  39 */     GenLayerAddSnow genLayerAddSnow = new GenLayerAddSnow(2L, genLayerRemoveTooMuchOcean);
/*  40 */     GenLayerAddIsland genLayerAddIsland2 = new GenLayerAddIsland(3L, genLayerAddSnow);
/*  41 */     GenLayerEdge genLayerEdge = new GenLayerEdge(2L, genLayerAddIsland2, GenLayerEdge.Mode.COOL_WARM);
/*  42 */     genLayerEdge = new GenLayerEdge(2L, genLayerEdge, GenLayerEdge.Mode.HEAT_ICE);
/*  43 */     genLayerEdge = new GenLayerEdge(3L, genLayerEdge, GenLayerEdge.Mode.SPECIAL);
/*  44 */     GenLayerZoom genLayerZoom1 = new GenLayerZoom(2002L, genLayerEdge);
/*  45 */     genLayerZoom1 = new GenLayerZoom(2003L, genLayerZoom1);
/*  46 */     GenLayerAddIsland genLayerAddIsland1 = new GenLayerAddIsland(4L, genLayerZoom1);
/*  47 */     GenLayerAddMushroomIsland genLayerAddMushroomIsland = new GenLayerAddMushroomIsland(5L, genLayerAddIsland1);
/*  48 */     GenLayerDeepOcean genLayerDeepOcean = new GenLayerDeepOcean(4L, genLayerAddMushroomIsland);
/*  49 */     GenLayer genLayer1 = GenLayerZoom.func_75915_a(1000L, genLayerDeepOcean, 0);
/*     */ 
/*     */ 
/*     */     
/*  53 */     byte b1 = 4;
/*  54 */     if (p_75901_2_ == WorldType.field_77135_d) {
/*  55 */       b1 = 6;
/*     */     }
/*  57 */     if (bool) {
/*  58 */       b1 = 4;
/*     */     }
/*     */     
/*  61 */     GenLayer genLayer2 = genLayer1;
/*  62 */     genLayer2 = GenLayerZoom.func_75915_a(1000L, genLayer2, 0);
/*  63 */     genLayer2 = new GenLayerRiverInit(100L, genLayer2);
/*     */     
/*  65 */     GenLayer genLayer3 = genLayer1;
/*  66 */     genLayer3 = new GenLayerBiome(200L, genLayer3, p_75901_2_);
/*  67 */     if (!bool) {
/*  68 */       genLayer3 = GenLayerZoom.func_75915_a(1000L, genLayer3, 2);
/*  69 */       genLayer3 = new GenLayerBiomeEdge(1000L, genLayer3);
/*     */     } 
/*  71 */     GenLayer genLayer4 = genLayer2;
/*  72 */     genLayer4 = GenLayerZoom.func_75915_a(1000L, genLayer4, 2);
/*  73 */     genLayer3 = new GenLayerHills(1000L, genLayer3, genLayer4);
/*     */     
/*  75 */     genLayer2 = GenLayerZoom.func_75915_a(1000L, genLayer2, 2);
/*  76 */     genLayer2 = GenLayerZoom.func_75915_a(1000L, genLayer2, b1);
/*  77 */     genLayer2 = new GenLayerRiver(1L, genLayer2);
/*  78 */     genLayer2 = new GenLayerSmooth(1000L, genLayer2);
/*     */     
/*  80 */     genLayer3 = new GenLayerRareBiome(1001L, genLayer3);
/*  81 */     for (byte b2 = 0; b2 < b1; b2++) {
/*  82 */       genLayer3 = new GenLayerZoom((1000 + b2), genLayer3);
/*  83 */       if (b2 == 0) {
/*  84 */         genLayer3 = new GenLayerAddIsland(3L, genLayer3);
/*     */       }
/*     */       
/*  87 */       if (b2 == 1) {
/*  88 */         genLayer3 = new GenLayerShore(1000L, genLayer3);
/*     */       }
/*     */     } 
/*     */     
/*  92 */     genLayer3 = new GenLayerSmooth(1000L, genLayer3);
/*     */     
/*  94 */     genLayer3 = new GenLayerRiverMix(100L, genLayer3, genLayer2);
/*     */     
/*  96 */     GenLayer genLayer5 = genLayer3;
/*  97 */     GenLayerVoronoiZoom genLayerVoronoiZoom = new GenLayerVoronoiZoom(10L, genLayer3);
/*     */     
/*  99 */     genLayer3.func_75905_a(p_75901_0_);
/* 100 */     genLayerVoronoiZoom.func_75905_a(p_75901_0_);
/*     */     
/* 102 */     return new GenLayer[] { genLayer3, genLayerVoronoiZoom, genLayer5 };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public GenLayer(long p_i2125_1_) {
/* 108 */     this.field_75906_d = p_i2125_1_;
/* 109 */     this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
/* 110 */     this.field_75906_d += p_i2125_1_;
/* 111 */     this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
/* 112 */     this.field_75906_d += p_i2125_1_;
/* 113 */     this.field_75906_d *= this.field_75906_d * 6364136223846793005L + 1442695040888963407L;
/* 114 */     this.field_75906_d += p_i2125_1_;
/*     */   }
/*     */   
/*     */   public void func_75905_a(long p_75905_1_) {
/* 118 */     this.field_75907_b = p_75905_1_;
/* 119 */     if (this.field_75909_a != null) this.field_75909_a.func_75905_a(p_75905_1_); 
/* 120 */     this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
/* 121 */     this.field_75907_b += this.field_75906_d;
/* 122 */     this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
/* 123 */     this.field_75907_b += this.field_75906_d;
/* 124 */     this.field_75907_b *= this.field_75907_b * 6364136223846793005L + 1442695040888963407L;
/* 125 */     this.field_75907_b += this.field_75906_d;
/*     */   }
/*     */   
/*     */   public void func_75903_a(long p_75903_1_, long p_75903_3_) {
/* 129 */     this.field_75908_c = this.field_75907_b;
/* 130 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 131 */     this.field_75908_c += p_75903_1_;
/* 132 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 133 */     this.field_75908_c += p_75903_3_;
/* 134 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 135 */     this.field_75908_c += p_75903_1_;
/* 136 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 137 */     this.field_75908_c += p_75903_3_;
/*     */   }
/*     */   
/*     */   protected int func_75902_a(int p_75902_1_) {
/* 141 */     int i = (int)((this.field_75908_c >> 24L) % p_75902_1_);
/* 142 */     if (i < 0) i += p_75902_1_; 
/* 143 */     this.field_75908_c *= this.field_75908_c * 6364136223846793005L + 1442695040888963407L;
/* 144 */     this.field_75908_c += this.field_75907_b;
/* 145 */     return i;
/*     */   }
/*     */   
/*     */   public abstract int[] func_75904_a(int paramInt1, int paramInt2, int paramInt3, int paramInt4);
/*     */   
/*     */   protected static boolean func_151616_a(int p_151616_0_, int p_151616_1_) {
/* 151 */     if (p_151616_0_ == p_151616_1_) {
/* 152 */       return true;
/*     */     }
/* 154 */     if (p_151616_0_ == BiomeGenBase.field_150607_aa.field_76756_M || p_151616_0_ == BiomeGenBase.field_150608_ab.field_76756_M) {
/* 155 */       return (p_151616_1_ == BiomeGenBase.field_150607_aa.field_76756_M || p_151616_1_ == BiomeGenBase.field_150608_ab.field_76756_M);
/*     */     }
/*     */     
/*     */     try {
/* 159 */       if (BiomeGenBase.func_150568_d(p_151616_0_) != null && BiomeGenBase.func_150568_d(p_151616_1_) != null) {
/* 160 */         return BiomeGenBase.func_150568_d(p_151616_0_).func_150569_a(BiomeGenBase.func_150568_d(p_151616_1_));
/*     */       }
/* 162 */     } catch (Throwable throwable) {
/* 163 */       CrashReport crashReport = CrashReport.func_85055_a(throwable, "Comparing biomes");
/* 164 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("Biomes being compared");
/*     */       
/* 166 */       crashReportCategory.func_71507_a("Biome A ID", Integer.valueOf(p_151616_0_));
/* 167 */       crashReportCategory.func_71507_a("Biome B ID", Integer.valueOf(p_151616_1_));
/*     */       
/* 169 */       crashReportCategory.func_71500_a("Biome A", new Callable(p_151616_0_) { private static final String __OBFID = "CL_00000560";
/*     */             
/*     */             public String call() {
/* 172 */               return String.valueOf(BiomeGenBase.func_150568_d(this.field_151684_a));
/*     */             } }
/*     */         );
/* 175 */       crashReportCategory.func_71500_a("Biome B", new Callable(p_151616_1_) { private static final String __OBFID = "CL_00000561";
/*     */             
/*     */             public String call() {
/* 178 */               return String.valueOf(BiomeGenBase.func_150568_d(this.field_151682_a));
/*     */             } }
/*     */         );
/*     */       
/* 182 */       throw new ReportedException(crashReport);
/*     */     } 
/*     */     
/* 185 */     return false;
/*     */   }
/*     */   
/*     */   protected static boolean func_151618_b(int p_151618_0_) {
/* 189 */     return (p_151618_0_ == BiomeGenBase.field_76771_b.field_76756_M || p_151618_0_ == BiomeGenBase.field_150575_M.field_76756_M || p_151618_0_ == BiomeGenBase.field_76776_l.field_76756_M);
/*     */   }
/*     */   
/*     */   protected int func_151619_a(int... p_151619_1_) {
/* 193 */     return p_151619_1_[func_75902_a(p_151619_1_.length)];
/*     */   }
/*     */   
/*     */   protected int func_151617_b(int p_151617_1_, int p_151617_2_, int p_151617_3_, int p_151617_4_) {
/* 197 */     if (p_151617_2_ == p_151617_3_ && p_151617_3_ == p_151617_4_) return p_151617_2_; 
/* 198 */     if (p_151617_1_ == p_151617_2_ && p_151617_1_ == p_151617_3_) return p_151617_1_; 
/* 199 */     if (p_151617_1_ == p_151617_2_ && p_151617_1_ == p_151617_4_) return p_151617_1_; 
/* 200 */     if (p_151617_1_ == p_151617_3_ && p_151617_1_ == p_151617_4_) return p_151617_1_;
/*     */     
/* 202 */     if (p_151617_1_ == p_151617_2_ && p_151617_3_ != p_151617_4_) return p_151617_1_; 
/* 203 */     if (p_151617_1_ == p_151617_3_ && p_151617_2_ != p_151617_4_) return p_151617_1_; 
/* 204 */     if (p_151617_1_ == p_151617_4_ && p_151617_2_ != p_151617_3_) return p_151617_1_;
/*     */ 
/*     */     
/* 207 */     if (p_151617_2_ == p_151617_3_ && p_151617_1_ != p_151617_4_) return p_151617_2_; 
/* 208 */     if (p_151617_2_ == p_151617_4_ && p_151617_1_ != p_151617_3_) return p_151617_2_;
/*     */ 
/*     */ 
/*     */     
/* 212 */     if (p_151617_3_ == p_151617_4_ && p_151617_1_ != p_151617_2_) return p_151617_3_;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 218 */     return func_151619_a(new int[] { p_151617_1_, p_151617_2_, p_151617_3_, p_151617_4_ });
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\layer\GenLayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */