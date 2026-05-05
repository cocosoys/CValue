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
/*     */ public class x1WorldChunkManagerOW
/*     */   extends WorldChunkManager
/*     */ {
/*     */   private GenLayer genBiomes;
/*     */   private GenLayer biomeIndexLayer;
/*     */   private BiomeCache biomeCache;
/*     */   private List<BiomeGenBase> biomesToSpawnIn;
/*     */   
/*     */   public x1WorldChunkManagerOW() {
/*  33 */     this.biomeCache = new BiomeCache(this);
/*  34 */     this.biomesToSpawnIn = new ArrayList<BiomeGenBase>();
/*  35 */     this.biomesToSpawnIn.addAll(allowedBiomes);
/*     */   }
/*     */ 
/*     */   
/*     */   public x1WorldChunkManagerOW(long seed, WorldType worldType) {
/*  40 */     this();
/*     */     
/*  42 */     GenLayer[] agenlayer = x1GenLayerOW.makeTheWorld(seed, worldType);
/*  43 */     agenlayer = getModdedBiomeGenerators(worldType, seed, agenlayer);
/*  44 */     this.genBiomes = agenlayer[0];
/*  45 */     this.biomeIndexLayer = agenlayer[1];
/*     */   }
/*     */ 
/*     */   
/*     */   public x1WorldChunkManagerOW(World world) {
/*  50 */     this(world.func_72905_C(), world.func_72912_H().func_76067_t());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<BiomeGenBase> func_76932_a() {
/*  59 */     return this.biomesToSpawnIn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BiomeGenBase func_76935_a(int x, int z) {
/*  68 */     return this.biomeCache.func_76837_b(x, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float[] func_76936_a(float[] listToReuse, int x, int z, int width, int length) {
/*  77 */     IntCache.func_76446_a();
/*     */     
/*  79 */     if (listToReuse == null || listToReuse.length < width * length)
/*     */     {
/*  81 */       listToReuse = new float[width * length];
/*     */     }
/*     */     
/*  84 */     int[] aint = this.biomeIndexLayer.func_75904_a(x, z, width, length);
/*     */     
/*  86 */     for (int i1 = 0; i1 < width * length; i1++) {
/*     */ 
/*     */       
/*     */       try {
/*  90 */         float f = BiomeGenBase.func_150568_d(aint[i1]).func_76744_g() / 65536.0F;
/*     */         
/*  92 */         if (f > 1.0F)
/*     */         {
/*  94 */           f = 1.0F;
/*     */         }
/*     */         
/*  97 */         listToReuse[i1] = f;
/*     */       }
/*  99 */       catch (Throwable throwable) {
/*     */         
/* 101 */         CrashReport crashreport = CrashReport.func_85055_a(throwable, "Invalid Biome id");
/* 102 */         CrashReportCategory crashreportcategory = crashreport.func_85058_a("DownfallBlock");
/* 103 */         crashreportcategory.func_71507_a("biome id", Integer.valueOf(i1));
/* 104 */         crashreportcategory.func_71507_a("downfalls[] size", Integer.valueOf(listToReuse.length));
/* 105 */         crashreportcategory.func_71507_a("x", Integer.valueOf(x));
/* 106 */         crashreportcategory.func_71507_a("z", Integer.valueOf(z));
/* 107 */         crashreportcategory.func_71507_a("w", Integer.valueOf(width));
/* 108 */         crashreportcategory.func_71507_a("h", Integer.valueOf(length));
/* 109 */         throw new ReportedException(crashreport);
/*     */       } 
/*     */     } 
/*     */     
/* 113 */     return listToReuse;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_76939_a(float par1, int par2) {
/* 123 */     return par1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BiomeGenBase[] func_76937_a(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5) {
/* 132 */     IntCache.func_76446_a();
/*     */     
/* 134 */     if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5)
/*     */     {
/* 136 */       par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
/*     */     }
/*     */     
/* 139 */     int[] aint = this.genBiomes.func_75904_a(par2, par3, par4, par5);
/*     */ 
/*     */     
/*     */     try {
/* 143 */       for (int i = 0; i < par4 * par5; i++)
/*     */       {
/* 145 */         par1ArrayOfBiomeGenBase[i] = BiomeGenBase.func_150568_d(aint[i]);
/*     */       }
/*     */       
/* 148 */       return par1ArrayOfBiomeGenBase;
/*     */     }
/* 150 */     catch (Throwable throwable) {
/*     */       
/* 152 */       CrashReport crashreport = CrashReport.func_85055_a(throwable, "Invalid Biome id");
/* 153 */       CrashReportCategory crashreportcategory = crashreport.func_85058_a("RawBiomeBlock");
/* 154 */       crashreportcategory.func_71507_a("biomes[] size", Integer.valueOf(par1ArrayOfBiomeGenBase.length));
/* 155 */       crashreportcategory.func_71507_a("x", Integer.valueOf(par2));
/* 156 */       crashreportcategory.func_71507_a("z", Integer.valueOf(par3));
/* 157 */       crashreportcategory.func_71507_a("w", Integer.valueOf(par4));
/* 158 */       crashreportcategory.func_71507_a("h", Integer.valueOf(par5));
/* 159 */       throw new ReportedException(crashreport);
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
/* 170 */     return func_76931_a(oldBiomeList, x, z, width, depth, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BiomeGenBase[] func_76931_a(BiomeGenBase[] listToReuse, int x, int y, int width, int length, boolean cacheFlag) {
/* 180 */     IntCache.func_76446_a();
/*     */     
/* 182 */     if (listToReuse == null || listToReuse.length < width * length)
/*     */     {
/* 184 */       listToReuse = new BiomeGenBase[width * length];
/*     */     }
/*     */     
/* 187 */     if (cacheFlag && width == 16 && length == 16 && (x & 0xF) == 0 && (y & 0xF) == 0) {
/*     */       
/* 189 */       BiomeGenBase[] abiomegenbase1 = this.biomeCache.func_76839_e(x, y);
/* 190 */       System.arraycopy(abiomegenbase1, 0, listToReuse, 0, width * length);
/* 191 */       return listToReuse;
/*     */     } 
/*     */ 
/*     */     
/* 195 */     int[] aint = this.biomeIndexLayer.func_75904_a(x, y, width, length);
/*     */     
/* 197 */     for (int i = 0; i < width * length; i++)
/*     */     {
/* 199 */       listToReuse[i] = BiomeGenBase.func_150568_d(aint[i]);
/*     */     }
/* 201 */     return listToReuse;
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
/* 212 */     IntCache.func_76446_a();
/* 213 */     int l = x - z >> 2;
/* 214 */     int i1 = y - z >> 2;
/* 215 */     int j1 = x + z >> 2;
/* 216 */     int k1 = y + z >> 2;
/* 217 */     int l1 = j1 - l + 1;
/* 218 */     int i2 = k1 - i1 + 1;
/* 219 */     int[] aint = this.genBiomes.func_75904_a(l, i1, l1, i2);
/*     */ 
/*     */     
/*     */     try {
/* 223 */       for (int j2 = 0; j2 < l1 * i2; j2++) {
/*     */         
/* 225 */         BiomeGenBase biomegenbase = BiomeGenBase.func_150568_d(aint[j2]);
/*     */         
/* 227 */         if (!par4List.contains(biomegenbase))
/*     */         {
/* 229 */           return false;
/*     */         }
/*     */       } 
/*     */       
/* 233 */       return true;
/*     */     }
/* 235 */     catch (Throwable throwable) {
/*     */       
/* 237 */       CrashReport crashreport = CrashReport.func_85055_a(throwable, "Invalid Biome id");
/* 238 */       CrashReportCategory crashreportcategory = crashreport.func_85058_a("Layer");
/* 239 */       crashreportcategory.func_71507_a("Layer", this.genBiomes.toString());
/* 240 */       crashreportcategory.func_71507_a("x", Integer.valueOf(x));
/* 241 */       crashreportcategory.func_71507_a("z", Integer.valueOf(y));
/* 242 */       crashreportcategory.func_71507_a("radius", Integer.valueOf(z));
/* 243 */       crashreportcategory.func_71507_a("allowed", par4List);
/* 244 */       throw new ReportedException(crashreport);
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
/* 257 */     IntCache.func_76446_a();
/* 258 */     int l = x - z >> 2;
/* 259 */     int i1 = y - z >> 2;
/* 260 */     int j1 = x + z >> 2;
/* 261 */     int k1 = y + z >> 2;
/* 262 */     int l1 = j1 - l + 1;
/* 263 */     int i2 = k1 - i1 + 1;
/* 264 */     int[] aint = this.genBiomes.func_75904_a(l, i1, l1, i2);
/* 265 */     ChunkPosition chunkposition = null;
/* 266 */     int j2 = 0;
/*     */     
/* 268 */     for (int k2 = 0; k2 < l1 * i2; k2++) {
/*     */       
/* 270 */       int l2 = l + k2 % l1 << 2;
/* 271 */       int i3 = i1 + k2 / l1 << 2;
/* 272 */       BiomeGenBase biomegenbase = BiomeGenBase.func_150568_d(aint[k2]);
/*     */       
/* 274 */       if (par4List.contains(biomegenbase) && (chunkposition == null || random.nextInt(j2 + 1) == 0)) {
/*     */         
/* 276 */         chunkposition = new ChunkPosition(l2, 0, i3);
/* 277 */         j2++;
/*     */       } 
/*     */     } 
/*     */     
/* 281 */     return chunkposition;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76938_b() {
/* 290 */     this.biomeCache.func_76838_a();
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\x1WorldChunkManagerOW.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */