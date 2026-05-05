/*     */ package JinRyuu.DragonBC.common.Worlds;
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
/*     */ import net.minecraft.world.biome.BiomeCache;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.biome.WorldChunkManager;
/*     */ import net.minecraft.world.gen.layer.GenLayer;
/*     */ import net.minecraft.world.gen.layer.IntCache;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class x0WorldChunkManagerNamek
/*     */   extends WorldChunkManager
/*     */ {
/*     */   private GenLayer genBiomes;
/*     */   private GenLayer biomeIndexLayer;
/*     */   private BiomeCache biomeCache;
/*     */   private List<BiomeGenBase> biomesToSpawnIn;
/*     */   
/*     */   public x0WorldChunkManagerNamek() {
/*  34 */     this.biomeCache = new BiomeCache(this);
/*  35 */     this.biomesToSpawnIn = new ArrayList<BiomeGenBase>();
/*  36 */     this.biomesToSpawnIn.addAll(allowedBiomes);
/*     */   }
/*     */ 
/*     */   
/*     */   public x0WorldChunkManagerNamek(long seed, WorldType worldType) {
/*  41 */     this();
/*     */     
/*  43 */     GenLayer[] agenlayer = x0GenLayerDBCNamek.makeTheWorld(seed, worldType);
/*  44 */     agenlayer = getModdedBiomeGenerators(worldType, seed, agenlayer);
/*  45 */     this.genBiomes = agenlayer[0];
/*  46 */     this.biomeIndexLayer = agenlayer[1];
/*     */   }
/*     */ 
/*     */   
/*     */   public x0WorldChunkManagerNamek(World world) {
/*  51 */     this(world.func_72905_C(), world.func_72912_H().func_76067_t());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<BiomeGenBase> func_76932_a() {
/*  60 */     return this.biomesToSpawnIn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BiomeGenBase func_76935_a(int x, int z) {
/*  69 */     return this.biomeCache.func_76837_b(x, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float[] func_76936_a(float[] listToReuse, int x, int z, int width, int length) {
/*  78 */     IntCache.func_76446_a();
/*     */     
/*  80 */     if (listToReuse == null || listToReuse.length < width * length)
/*     */     {
/*  82 */       listToReuse = new float[width * length];
/*     */     }
/*     */     
/*  85 */     int[] aint = this.biomeIndexLayer.func_75904_a(x, z, width, length);
/*     */     
/*  87 */     for (int i1 = 0; i1 < width * length; i1++) {
/*     */ 
/*     */       
/*     */       try {
/*  91 */         float f = BiomeGenBase.func_150568_d(aint[i1]).func_76744_g() / 65536.0F;
/*     */         
/*  93 */         if (f > 1.0F)
/*     */         {
/*  95 */           f = 1.0F;
/*     */         }
/*     */         
/*  98 */         listToReuse[i1] = f;
/*     */       }
/* 100 */       catch (Throwable throwable) {
/*     */         
/* 102 */         CrashReport crashreport = CrashReport.func_85055_a(throwable, "Invalid Biome id");
/* 103 */         CrashReportCategory crashreportcategory = crashreport.func_85058_a("DownfallBlock");
/* 104 */         crashreportcategory.func_71507_a("biome id", Integer.valueOf(i1));
/* 105 */         crashreportcategory.func_71507_a("downfalls[] size", Integer.valueOf(listToReuse.length));
/* 106 */         crashreportcategory.func_71507_a("x", Integer.valueOf(x));
/* 107 */         crashreportcategory.func_71507_a("z", Integer.valueOf(z));
/* 108 */         crashreportcategory.func_71507_a("w", Integer.valueOf(width));
/* 109 */         crashreportcategory.func_71507_a("h", Integer.valueOf(length));
/* 110 */         throw new ReportedException(crashreport);
/*     */       } 
/*     */     } 
/*     */     
/* 114 */     return listToReuse;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_76939_a(float par1, int par2) {
/* 124 */     return par1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BiomeGenBase[] func_76937_a(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5) {
/* 133 */     IntCache.func_76446_a();
/*     */     
/* 135 */     if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5)
/*     */     {
/* 137 */       par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
/*     */     }
/*     */     
/* 140 */     int[] aint = this.genBiomes.func_75904_a(par2, par3, par4, par5);
/*     */ 
/*     */     
/*     */     try {
/* 144 */       for (int i = 0; i < par4 * par5; i++)
/*     */       {
/* 146 */         par1ArrayOfBiomeGenBase[i] = BiomeGenBase.func_150568_d(aint[i]);
/*     */       }
/*     */       
/* 149 */       return par1ArrayOfBiomeGenBase;
/*     */     }
/* 151 */     catch (Throwable throwable) {
/*     */       
/* 153 */       CrashReport crashreport = CrashReport.func_85055_a(throwable, "Invalid Biome id");
/* 154 */       CrashReportCategory crashreportcategory = crashreport.func_85058_a("RawBiomeBlock");
/* 155 */       crashreportcategory.func_71507_a("biomes[] size", Integer.valueOf(par1ArrayOfBiomeGenBase.length));
/* 156 */       crashreportcategory.func_71507_a("x", Integer.valueOf(par2));
/* 157 */       crashreportcategory.func_71507_a("z", Integer.valueOf(par3));
/* 158 */       crashreportcategory.func_71507_a("w", Integer.valueOf(par4));
/* 159 */       crashreportcategory.func_71507_a("h", Integer.valueOf(par5));
/* 160 */       throw new ReportedException(crashreport);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BiomeGenBase[] func_76933_b(BiomeGenBase[] oldBiomeList, int x, int z, int width, int depth) {
/* 171 */     return func_76931_a(oldBiomeList, x, z, width, depth, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BiomeGenBase[] func_76931_a(BiomeGenBase[] listToReuse, int x, int y, int width, int length, boolean cacheFlag) {
/* 181 */     IntCache.func_76446_a();
/*     */     
/* 183 */     if (listToReuse == null || listToReuse.length < width * length)
/*     */     {
/* 185 */       listToReuse = new BiomeGenBase[width * length];
/*     */     }
/*     */     
/* 188 */     if (cacheFlag && width == 16 && length == 16 && (x & 0xF) == 0 && (y & 0xF) == 0) {
/*     */       
/* 190 */       BiomeGenBase[] abiomegenbase1 = this.biomeCache.func_76839_e(x, y);
/* 191 */       System.arraycopy(abiomegenbase1, 0, listToReuse, 0, width * length);
/* 192 */       return listToReuse;
/*     */     } 
/*     */ 
/*     */     
/* 196 */     int[] aint = this.biomeIndexLayer.func_75904_a(x, y, width, length);
/*     */     
/* 198 */     for (int i = 0; i < width * length; i++)
/*     */     {
/* 200 */       listToReuse[i] = BiomeGenBase.func_150568_d(aint[i]);
/*     */     }
/* 202 */     return listToReuse;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76940_a(int x, int y, int z, List par4List) {
/* 213 */     IntCache.func_76446_a();
/* 214 */     int l = x - z >> 2;
/* 215 */     int i1 = y - z >> 2;
/* 216 */     int j1 = x + z >> 2;
/* 217 */     int k1 = y + z >> 2;
/* 218 */     int l1 = j1 - l + 1;
/* 219 */     int i2 = k1 - i1 + 1;
/* 220 */     int[] aint = this.genBiomes.func_75904_a(l, i1, l1, i2);
/*     */ 
/*     */     
/*     */     try {
/* 224 */       for (int j2 = 0; j2 < l1 * i2; j2++) {
/*     */         
/* 226 */         BiomeGenBase biomegenbase = BiomeGenBase.func_150568_d(aint[j2]);
/*     */         
/* 228 */         if (!par4List.contains(biomegenbase))
/*     */         {
/* 230 */           return false;
/*     */         }
/*     */       } 
/*     */       
/* 234 */       return true;
/*     */     }
/* 236 */     catch (Throwable throwable) {
/*     */       
/* 238 */       CrashReport crashreport = CrashReport.func_85055_a(throwable, "Invalid Biome id");
/* 239 */       CrashReportCategory crashreportcategory = crashreport.func_85058_a("Layer");
/* 240 */       crashreportcategory.func_71507_a("Layer", this.genBiomes.toString());
/* 241 */       crashreportcategory.func_71507_a("x", Integer.valueOf(x));
/* 242 */       crashreportcategory.func_71507_a("z", Integer.valueOf(y));
/* 243 */       crashreportcategory.func_71507_a("radius", Integer.valueOf(z));
/* 244 */       crashreportcategory.func_71507_a("allowed", par4List);
/* 245 */       throw new ReportedException(crashreport);
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
/*     */   public ChunkPosition func_150795_a(int x, int y, int z, List par4List, Random random) {
/* 258 */     IntCache.func_76446_a();
/* 259 */     int l = x - z >> 2;
/* 260 */     int i1 = y - z >> 2;
/* 261 */     int j1 = x + z >> 2;
/* 262 */     int k1 = y + z >> 2;
/* 263 */     int l1 = j1 - l + 1;
/* 264 */     int i2 = k1 - i1 + 1;
/* 265 */     int[] aint = this.genBiomes.func_75904_a(l, i1, l1, i2);
/* 266 */     ChunkPosition chunkposition = null;
/* 267 */     int j2 = 0;
/*     */     
/* 269 */     for (int k2 = 0; k2 < l1 * i2; k2++) {
/*     */       
/* 271 */       int l2 = l + k2 % l1 << 2;
/* 272 */       int i3 = i1 + k2 / l1 << 2;
/* 273 */       BiomeGenBase biomegenbase = BiomeGenBase.func_150568_d(aint[k2]);
/*     */       
/* 275 */       if (par4List.contains(biomegenbase) && (chunkposition == null || random.nextInt(j2 + 1) == 0)) {
/*     */         
/* 277 */         chunkposition = new ChunkPosition(l2, 0, i3);
/* 278 */         j2++;
/*     */       } 
/*     */     } 
/*     */     
/* 282 */     return chunkposition;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76938_b() {
/* 291 */     this.biomeCache.func_76838_a();
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\x0WorldChunkManagerNamek.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */