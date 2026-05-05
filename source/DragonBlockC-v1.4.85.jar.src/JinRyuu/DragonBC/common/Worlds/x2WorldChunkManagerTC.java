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
/*     */ 
/*     */ public class x2WorldChunkManagerTC
/*     */   extends WorldChunkManager
/*     */ {
/*     */   private GenLayer genBiomes;
/*     */   private GenLayer biomeIndexLayer;
/*     */   private BiomeCache biomeCache;
/*     */   private List<BiomeGenBase> biomesToSpawnIn;
/*     */   
/*     */   public x2WorldChunkManagerTC() {
/*  35 */     this.biomeCache = new BiomeCache(this);
/*  36 */     this.biomesToSpawnIn = new ArrayList<BiomeGenBase>();
/*  37 */     this.biomesToSpawnIn.addAll(allowedBiomes);
/*     */   }
/*     */ 
/*     */   
/*     */   public x2WorldChunkManagerTC(long seed, WorldType worldType) {
/*  42 */     this();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public x2WorldChunkManagerTC(World world) {
/*  52 */     this(world.func_72905_C(), world.func_72912_H().func_76067_t());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<BiomeGenBase> func_76932_a() {
/*  61 */     return this.biomesToSpawnIn;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BiomeGenBase func_76935_a(int x, int z) {
/*  70 */     return this.biomeCache.func_76837_b(x, z);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float[] func_76936_a(float[] listToReuse, int x, int z, int width, int length) {
/*  79 */     IntCache.func_76446_a();
/*     */     
/*  81 */     if (listToReuse == null || listToReuse.length < width * length)
/*     */     {
/*  83 */       listToReuse = new float[width * length];
/*     */     }
/*     */     
/*  86 */     int[] aint = this.biomeIndexLayer.func_75904_a(x, z, width, length);
/*     */     
/*  88 */     for (int i1 = 0; i1 < width * length; i1++) {
/*     */ 
/*     */       
/*     */       try {
/*  92 */         float f = BiomeGenBase.func_150568_d(aint[i1]).func_76744_g() / 65536.0F;
/*     */         
/*  94 */         if (f > 1.0F)
/*     */         {
/*  96 */           f = 1.0F;
/*     */         }
/*     */         
/*  99 */         listToReuse[i1] = f;
/*     */       }
/* 101 */       catch (Throwable throwable) {
/*     */         
/* 103 */         CrashReport crashreport = CrashReport.func_85055_a(throwable, "Invalid Biome id");
/* 104 */         CrashReportCategory crashreportcategory = crashreport.func_85058_a("DownfallBlock");
/* 105 */         crashreportcategory.func_71507_a("biome id", Integer.valueOf(i1));
/* 106 */         crashreportcategory.func_71507_a("downfalls[] size", Integer.valueOf(listToReuse.length));
/* 107 */         crashreportcategory.func_71507_a("x", Integer.valueOf(x));
/* 108 */         crashreportcategory.func_71507_a("z", Integer.valueOf(z));
/* 109 */         crashreportcategory.func_71507_a("w", Integer.valueOf(width));
/* 110 */         crashreportcategory.func_71507_a("h", Integer.valueOf(length));
/* 111 */         throw new ReportedException(crashreport);
/*     */       } 
/*     */     } 
/*     */     
/* 115 */     return listToReuse;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_76939_a(float par1, int par2) {
/* 125 */     return par1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BiomeGenBase[] func_76937_a(BiomeGenBase[] par1ArrayOfBiomeGenBase, int par2, int par3, int par4, int par5) {
/* 134 */     IntCache.func_76446_a();
/*     */     
/* 136 */     if (par1ArrayOfBiomeGenBase == null || par1ArrayOfBiomeGenBase.length < par4 * par5)
/*     */     {
/* 138 */       par1ArrayOfBiomeGenBase = new BiomeGenBase[par4 * par5];
/*     */     }
/*     */     
/* 141 */     int[] aint = this.genBiomes.func_75904_a(par2, par3, par4, par5);
/*     */ 
/*     */     
/*     */     try {
/* 145 */       for (int i = 0; i < par4 * par5; i++)
/*     */       {
/* 147 */         par1ArrayOfBiomeGenBase[i] = BiomeGenBase.func_150568_d(aint[i]);
/*     */       }
/*     */       
/* 150 */       return par1ArrayOfBiomeGenBase;
/*     */     }
/* 152 */     catch (Throwable throwable) {
/*     */       
/* 154 */       CrashReport crashreport = CrashReport.func_85055_a(throwable, "Invalid Biome id");
/* 155 */       CrashReportCategory crashreportcategory = crashreport.func_85058_a("RawBiomeBlock");
/* 156 */       crashreportcategory.func_71507_a("biomes[] size", Integer.valueOf(par1ArrayOfBiomeGenBase.length));
/* 157 */       crashreportcategory.func_71507_a("x", Integer.valueOf(par2));
/* 158 */       crashreportcategory.func_71507_a("z", Integer.valueOf(par3));
/* 159 */       crashreportcategory.func_71507_a("w", Integer.valueOf(par4));
/* 160 */       crashreportcategory.func_71507_a("h", Integer.valueOf(par5));
/* 161 */       throw new ReportedException(crashreport);
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
/* 172 */     return func_76931_a(oldBiomeList, x, z, width, depth, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public BiomeGenBase[] func_76931_a(BiomeGenBase[] listToReuse, int x, int y, int width, int length, boolean cacheFlag) {
/* 182 */     IntCache.func_76446_a();
/*     */     
/* 184 */     if (listToReuse == null || listToReuse.length < width * length)
/*     */     {
/* 186 */       listToReuse = new BiomeGenBase[width * length];
/*     */     }
/*     */     
/* 189 */     if (cacheFlag && width == 16 && length == 16 && (x & 0xF) == 0 && (y & 0xF) == 0) {
/*     */       
/* 191 */       BiomeGenBase[] abiomegenbase1 = this.biomeCache.func_76839_e(x, y);
/* 192 */       System.arraycopy(abiomegenbase1, 0, listToReuse, 0, width * length);
/* 193 */       return listToReuse;
/*     */     } 
/*     */ 
/*     */     
/* 197 */     int[] aint = this.biomeIndexLayer.func_75904_a(x, y, width, length);
/*     */     
/* 199 */     for (int i = 0; i < width * length; i++)
/*     */     {
/* 201 */       listToReuse[i] = BiomeGenBase.func_150568_d(aint[i]);
/*     */     }
/* 203 */     return listToReuse;
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
/* 214 */     IntCache.func_76446_a();
/* 215 */     int l = x - z >> 2;
/* 216 */     int i1 = y - z >> 2;
/* 217 */     int j1 = x + z >> 2;
/* 218 */     int k1 = y + z >> 2;
/* 219 */     int l1 = j1 - l + 1;
/* 220 */     int i2 = k1 - i1 + 1;
/* 221 */     int[] aint = this.genBiomes.func_75904_a(l, i1, l1, i2);
/*     */ 
/*     */     
/*     */     try {
/* 225 */       for (int j2 = 0; j2 < l1 * i2; j2++) {
/*     */         
/* 227 */         BiomeGenBase biomegenbase = BiomeGenBase.func_150568_d(aint[j2]);
/*     */         
/* 229 */         if (!par4List.contains(biomegenbase))
/*     */         {
/* 231 */           return false;
/*     */         }
/*     */       } 
/*     */       
/* 235 */       return true;
/*     */     }
/* 237 */     catch (Throwable throwable) {
/*     */       
/* 239 */       CrashReport crashreport = CrashReport.func_85055_a(throwable, "Invalid Biome id");
/* 240 */       CrashReportCategory crashreportcategory = crashreport.func_85058_a("Layer");
/* 241 */       crashreportcategory.func_71507_a("Layer", this.genBiomes.toString());
/* 242 */       crashreportcategory.func_71507_a("x", Integer.valueOf(x));
/* 243 */       crashreportcategory.func_71507_a("z", Integer.valueOf(y));
/* 244 */       crashreportcategory.func_71507_a("radius", Integer.valueOf(z));
/* 245 */       crashreportcategory.func_71507_a("allowed", par4List);
/* 246 */       throw new ReportedException(crashreport);
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
/* 259 */     IntCache.func_76446_a();
/* 260 */     int l = x - z >> 2;
/* 261 */     int i1 = y - z >> 2;
/* 262 */     int j1 = x + z >> 2;
/* 263 */     int k1 = y + z >> 2;
/* 264 */     int l1 = j1 - l + 1;
/* 265 */     int i2 = k1 - i1 + 1;
/* 266 */     int[] aint = this.genBiomes.func_75904_a(l, i1, l1, i2);
/* 267 */     ChunkPosition chunkposition = null;
/* 268 */     int j2 = 0;
/*     */     
/* 270 */     for (int k2 = 0; k2 < l1 * i2; k2++) {
/*     */       
/* 272 */       int l2 = l + k2 % l1 << 2;
/* 273 */       int i3 = i1 + k2 / l1 << 2;
/* 274 */       BiomeGenBase biomegenbase = BiomeGenBase.func_150568_d(aint[k2]);
/*     */       
/* 276 */       if (par4List.contains(biomegenbase) && (chunkposition == null || random.nextInt(j2 + 1) == 0)) {
/*     */         
/* 278 */         chunkposition = new ChunkPosition(l2, 0, i3);
/* 279 */         j2++;
/*     */       } 
/*     */     } 
/*     */     
/* 283 */     return chunkposition;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_76938_b() {
/* 292 */     this.biomeCache.func_76838_a();
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\x2WorldChunkManagerTC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */