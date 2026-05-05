/*     */ package net.minecraft.world.biome;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.util.ReportedException;
/*     */ import net.minecraft.world.ChunkPosition;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldType;
/*     */ import net.minecraft.world.gen.layer.GenLayer;
/*     */ import net.minecraft.world.gen.layer.IntCache;
/*     */ 
/*     */ public class WorldChunkManager {
/*     */   private GenLayer field_76944_d;
/*  19 */   private BiomeCache field_76942_f = new BiomeCache(this);
/*     */   private GenLayer field_76945_e;
/*     */   private List field_76943_g;
/*     */   private static final String __OBFID = "CL_00000166";
/*     */   
/*     */   protected WorldChunkManager() {
/*  25 */     this.field_76943_g = new ArrayList();
/*  26 */     this.field_76943_g.add(BiomeGenBase.field_76767_f);
/*  27 */     this.field_76943_g.add(BiomeGenBase.field_76772_c);
/*  28 */     this.field_76943_g.add(BiomeGenBase.field_76768_g);
/*  29 */     this.field_76943_g.add(BiomeGenBase.field_76784_u);
/*  30 */     this.field_76943_g.add(BiomeGenBase.field_76785_t);
/*  31 */     this.field_76943_g.add(BiomeGenBase.field_76782_w);
/*  32 */     this.field_76943_g.add(BiomeGenBase.field_76792_x);
/*     */   }
/*     */   
/*     */   public WorldChunkManager(long p_i1975_1_, WorldType p_i1975_3_) {
/*  36 */     this();
/*     */     
/*  38 */     GenLayer[] arrayOfGenLayer = GenLayer.func_75901_a(p_i1975_1_, p_i1975_3_);
/*  39 */     this.field_76944_d = arrayOfGenLayer[0];
/*  40 */     this.field_76945_e = arrayOfGenLayer[1];
/*     */   }
/*     */   
/*     */   public WorldChunkManager(World p_i1976_1_) {
/*  44 */     this(p_i1976_1_.func_72905_C(), p_i1976_1_.func_72912_H().func_76067_t());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List func_76932_a() {
/*  53 */     return this.field_76943_g;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BiomeGenBase func_76935_a(int p_76935_1_, int p_76935_2_) {
/*  61 */     return this.field_76942_f.func_76837_b(p_76935_1_, p_76935_2_);
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
/*     */   public float[] func_76936_a(float[] p_76936_1_, int p_76936_2_, int p_76936_3_, int p_76936_4_, int p_76936_5_) {
/*  74 */     IntCache.func_76446_a();
/*  75 */     if (p_76936_1_ == null || p_76936_1_.length < p_76936_4_ * p_76936_5_) {
/*  76 */       p_76936_1_ = new float[p_76936_4_ * p_76936_5_];
/*     */     }
/*     */     
/*  79 */     int[] arrayOfInt = this.field_76945_e.func_75904_a(p_76936_2_, p_76936_3_, p_76936_4_, p_76936_5_);
/*  80 */     for (byte b = 0; b < p_76936_4_ * p_76936_5_; b++) {
/*     */       try {
/*  82 */         float f = BiomeGenBase.func_150568_d(arrayOfInt[b]).func_76744_g() / 65536.0F;
/*  83 */         if (f > 1.0F) f = 1.0F; 
/*  84 */         p_76936_1_[b] = f;
/*  85 */       } catch (Throwable throwable) {
/*  86 */         CrashReport crashReport = CrashReport.func_85055_a(throwable, "Invalid Biome id");
/*  87 */         CrashReportCategory crashReportCategory = crashReport.func_85058_a("DownfallBlock");
/*  88 */         crashReportCategory.func_71507_a("biome id", Integer.valueOf(b));
/*  89 */         crashReportCategory.func_71507_a("downfalls[] size", Integer.valueOf(p_76936_1_.length));
/*  90 */         crashReportCategory.func_71507_a("x", Integer.valueOf(p_76936_2_));
/*  91 */         crashReportCategory.func_71507_a("z", Integer.valueOf(p_76936_3_));
/*  92 */         crashReportCategory.func_71507_a("w", Integer.valueOf(p_76936_4_));
/*  93 */         crashReportCategory.func_71507_a("h", Integer.valueOf(p_76936_5_));
/*     */         
/*  95 */         throw new ReportedException(crashReport);
/*     */       } 
/*     */     } 
/*     */     
/*  99 */     return p_76936_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_76939_a(float p_76939_1_, int p_76939_2_) {
/* 107 */     return p_76939_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BiomeGenBase[] func_76937_a(BiomeGenBase[] p_76937_1_, int p_76937_2_, int p_76937_3_, int p_76937_4_, int p_76937_5_) {
/* 116 */     IntCache.func_76446_a();
/* 117 */     if (p_76937_1_ == null || p_76937_1_.length < p_76937_4_ * p_76937_5_) {
/* 118 */       p_76937_1_ = new BiomeGenBase[p_76937_4_ * p_76937_5_];
/*     */     }
/*     */     
/* 121 */     int[] arrayOfInt = this.field_76944_d.func_75904_a(p_76937_2_, p_76937_3_, p_76937_4_, p_76937_5_);
/*     */     try {
/* 123 */       for (byte b = 0; b < p_76937_4_ * p_76937_5_; b++) {
/* 124 */         p_76937_1_[b] = BiomeGenBase.func_150568_d(arrayOfInt[b]);
/*     */       }
/* 126 */     } catch (Throwable throwable) {
/* 127 */       CrashReport crashReport = CrashReport.func_85055_a(throwable, "Invalid Biome id");
/* 128 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("RawBiomeBlock");
/* 129 */       crashReportCategory.func_71507_a("biomes[] size", Integer.valueOf(p_76937_1_.length));
/* 130 */       crashReportCategory.func_71507_a("x", Integer.valueOf(p_76937_2_));
/* 131 */       crashReportCategory.func_71507_a("z", Integer.valueOf(p_76937_3_));
/* 132 */       crashReportCategory.func_71507_a("w", Integer.valueOf(p_76937_4_));
/* 133 */       crashReportCategory.func_71507_a("h", Integer.valueOf(p_76937_5_));
/*     */       
/* 135 */       throw new ReportedException(crashReport);
/*     */     } 
/*     */     
/* 138 */     return p_76937_1_;
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
/*     */   public BiomeGenBase[] func_76933_b(BiomeGenBase[] p_76933_1_, int p_76933_2_, int p_76933_3_, int p_76933_4_, int p_76933_5_) {
/* 151 */     return func_76931_a(p_76933_1_, p_76933_2_, p_76933_3_, p_76933_4_, p_76933_5_, true);
/*     */   }
/*     */   
/*     */   public BiomeGenBase[] func_76931_a(BiomeGenBase[] p_76931_1_, int p_76931_2_, int p_76931_3_, int p_76931_4_, int p_76931_5_, boolean p_76931_6_) {
/* 155 */     IntCache.func_76446_a();
/* 156 */     if (p_76931_1_ == null || p_76931_1_.length < p_76931_4_ * p_76931_5_) {
/* 157 */       p_76931_1_ = new BiomeGenBase[p_76931_4_ * p_76931_5_];
/*     */     }
/*     */     
/* 160 */     if (p_76931_6_ && p_76931_4_ == 16 && p_76931_5_ == 16 && (p_76931_2_ & 0xF) == 0 && (p_76931_3_ & 0xF) == 0) {
/* 161 */       BiomeGenBase[] arrayOfBiomeGenBase = this.field_76942_f.func_76839_e(p_76931_2_, p_76931_3_);
/* 162 */       System.arraycopy(arrayOfBiomeGenBase, 0, p_76931_1_, 0, p_76931_4_ * p_76931_5_);
/* 163 */       return p_76931_1_;
/*     */     } 
/*     */     
/* 166 */     int[] arrayOfInt = this.field_76945_e.func_75904_a(p_76931_2_, p_76931_3_, p_76931_4_, p_76931_5_);
/* 167 */     for (byte b = 0; b < p_76931_4_ * p_76931_5_; b++) {
/* 168 */       p_76931_1_[b] = BiomeGenBase.func_150568_d(arrayOfInt[b]);
/*     */     }
/*     */     
/* 171 */     return p_76931_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76940_a(int p_76940_1_, int p_76940_2_, int p_76940_3_, List p_76940_4_) {
/* 182 */     IntCache.func_76446_a();
/* 183 */     int i = p_76940_1_ - p_76940_3_ >> 2;
/* 184 */     int j = p_76940_2_ - p_76940_3_ >> 2;
/* 185 */     int k = p_76940_1_ + p_76940_3_ >> 2;
/* 186 */     int m = p_76940_2_ + p_76940_3_ >> 2;
/*     */     
/* 188 */     int n = k - i + 1;
/* 189 */     int i1 = m - j + 1;
/*     */     
/* 191 */     int[] arrayOfInt = this.field_76944_d.func_75904_a(i, j, n, i1);
/*     */     try {
/* 193 */       for (byte b = 0; b < n * i1; b++) {
/* 194 */         BiomeGenBase biomeGenBase = BiomeGenBase.func_150568_d(arrayOfInt[b]);
/* 195 */         if (!p_76940_4_.contains(biomeGenBase)) return false; 
/*     */       } 
/* 197 */     } catch (Throwable throwable) {
/* 198 */       CrashReport crashReport = CrashReport.func_85055_a(throwable, "Invalid Biome id");
/* 199 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("Layer");
/* 200 */       crashReportCategory.func_71507_a("Layer", this.field_76944_d.toString());
/* 201 */       crashReportCategory.func_71507_a("x", Integer.valueOf(p_76940_1_));
/* 202 */       crashReportCategory.func_71507_a("z", Integer.valueOf(p_76940_2_));
/* 203 */       crashReportCategory.func_71507_a("radius", Integer.valueOf(p_76940_3_));
/* 204 */       crashReportCategory.func_71507_a("allowed", p_76940_4_);
/*     */       
/* 206 */       throw new ReportedException(crashReport);
/*     */     } 
/*     */     
/* 209 */     return true;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ChunkPosition func_150795_a(int p_150795_1_, int p_150795_2_, int p_150795_3_, List p_150795_4_, Random p_150795_5_) {
/* 275 */     IntCache.func_76446_a();
/* 276 */     int i = p_150795_1_ - p_150795_3_ >> 2;
/* 277 */     int j = p_150795_2_ - p_150795_3_ >> 2;
/* 278 */     int k = p_150795_1_ + p_150795_3_ >> 2;
/* 279 */     int m = p_150795_2_ + p_150795_3_ >> 2;
/*     */     
/* 281 */     int n = k - i + 1;
/* 282 */     int i1 = m - j + 1;
/* 283 */     int[] arrayOfInt = this.field_76944_d.func_75904_a(i, j, n, i1);
/* 284 */     ChunkPosition chunkPosition = null;
/* 285 */     byte b1 = 0;
/* 286 */     for (byte b2 = 0; b2 < n * i1; b2++) {
/* 287 */       int i2 = i + b2 % n << 2;
/* 288 */       int i3 = j + b2 / n << 2;
/* 289 */       BiomeGenBase biomeGenBase = BiomeGenBase.func_150568_d(arrayOfInt[b2]);
/* 290 */       if (p_150795_4_.contains(biomeGenBase) && (
/* 291 */         chunkPosition == null || p_150795_5_.nextInt(b1 + 1) == 0)) {
/* 292 */         chunkPosition = new ChunkPosition(i2, 0, i3);
/* 293 */         b1++;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 298 */     return chunkPosition;
/*     */   }
/*     */   
/*     */   public void func_76938_b() {
/* 302 */     this.field_76942_f.func_76838_a();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\WorldChunkManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */