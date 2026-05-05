/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChunkProviderFlat
/*     */   implements IChunkProvider
/*     */ {
/*     */   private World a;
/*     */   private Random b;
/*  25 */   private final Block[] c = new Block[256];
/*  26 */   private final byte[] d = new byte[256];
/*     */   private final WorldGenFlatInfo e;
/*  28 */   private final List f = new ArrayList();
/*     */   private final boolean g;
/*     */   private final boolean h;
/*     */   private WorldGenLakes i;
/*     */   private WorldGenLakes j;
/*     */   
/*     */   public ChunkProviderFlat(World paramWorld, long paramLong, boolean paramBoolean, String paramString) {
/*  35 */     this.a = paramWorld;
/*  36 */     this.b = new Random(paramLong);
/*  37 */     this.e = WorldGenFlatInfo.a(paramString);
/*     */     
/*  39 */     if (paramBoolean) {
/*  40 */       Map map = this.e.b();
/*     */       
/*  42 */       if (map.containsKey("village")) {
/*  43 */         Map<String, String> map1 = (Map)map.get("village");
/*  44 */         if (!map1.containsKey("size")) map1.put("size", "1"); 
/*  45 */         this.f.add(new WorldGenVillage(map1));
/*     */       } 
/*     */       
/*  48 */       if (map.containsKey("biome_1")) this.f.add(new WorldGenLargeFeature((Map)map.get("biome_1"))); 
/*  49 */       if (map.containsKey("mineshaft")) this.f.add(new WorldGenMineshaft((Map)map.get("mineshaft"))); 
/*  50 */       if (map.containsKey("stronghold")) this.f.add(new WorldGenStronghold((Map)map.get("stronghold")));
/*     */     
/*     */     } 
/*  53 */     this.g = this.e.b().containsKey("decoration");
/*  54 */     if (this.e.b().containsKey("lake")) this.i = new WorldGenLakes(Blocks.STATIONARY_WATER); 
/*  55 */     if (this.e.b().containsKey("lava_lake")) this.j = new WorldGenLakes(Blocks.STATIONARY_LAVA); 
/*  56 */     this.h = this.e.b().containsKey("dungeon");
/*     */     
/*  58 */     for (WorldGenFlatLayerInfo worldGenFlatLayerInfo : this.e.c()) {
/*  59 */       for (int i = worldGenFlatLayerInfo.d(); i < worldGenFlatLayerInfo.d() + worldGenFlatLayerInfo.a(); i++) {
/*  60 */         this.c[i] = worldGenFlatLayerInfo.b();
/*  61 */         this.d[i] = (byte)worldGenFlatLayerInfo.c();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk getChunkAt(int paramInt1, int paramInt2) {
/*  69 */     return getOrCreateChunk(paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk getOrCreateChunk(int paramInt1, int paramInt2) {
/*  75 */     Chunk chunk = new Chunk(this.a, paramInt1, paramInt2);
/*     */     
/*  77 */     for (byte b1 = 0; b1 < this.c.length; b1++) {
/*  78 */       Block block = this.c[b1];
/*  79 */       if (block != null) {
/*  80 */         int i = b1 >> 4;
/*  81 */         ChunkSection chunkSection = chunk.getSections()[i];
/*     */         
/*  83 */         if (chunkSection == null) {
/*  84 */           chunkSection = new ChunkSection(b1, !this.a.worldProvider.g);
/*  85 */           chunk.getSections()[i] = chunkSection;
/*     */         } 
/*     */         
/*  88 */         for (byte b = 0; b < 16; b++) {
/*  89 */           for (byte b3 = 0; b3 < 16; b3++) {
/*  90 */             chunkSection.setTypeId(b, b1 & 0xF, b3, block);
/*  91 */             chunkSection.setData(b, b1 & 0xF, b3, this.d[b1]);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*  96 */     chunk.initLighting();
/*     */     
/*  98 */     BiomeBase[] arrayOfBiomeBase = this.a.getWorldChunkManager().getBiomeBlock(null, paramInt1 * 16, paramInt2 * 16, 16, 16);
/*  99 */     byte[] arrayOfByte = chunk.m();
/*     */     
/* 101 */     for (byte b2 = 0; b2 < arrayOfByte.length; b2++) {
/* 102 */       arrayOfByte[b2] = (byte)(arrayOfBiomeBase[b2]).id;
/*     */     }
/*     */     
/* 105 */     for (WorldGenBase worldGenBase : this.f) {
/* 106 */       worldGenBase.a(this, this.a, paramInt1, paramInt2, null);
/*     */     }
/*     */     
/* 109 */     chunk.initLighting();
/*     */     
/* 111 */     return chunk;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isChunkLoaded(int paramInt1, int paramInt2) {
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void getChunkAt(IChunkProvider paramIChunkProvider, int paramInt1, int paramInt2) {
/* 121 */     int i = paramInt1 * 16;
/* 122 */     int j = paramInt2 * 16;
/* 123 */     BiomeBase biomeBase = this.a.getBiome(i + 16, j + 16);
/* 124 */     boolean bool = false;
/*     */     
/* 126 */     this.b.setSeed(this.a.getSeed());
/* 127 */     long l1 = this.b.nextLong() / 2L * 2L + 1L;
/* 128 */     long l2 = this.b.nextLong() / 2L * 2L + 1L;
/* 129 */     this.b.setSeed(paramInt1 * l1 + paramInt2 * l2 ^ this.a.getSeed());
/*     */     
/* 131 */     for (StructureGenerator structureGenerator : this.f) {
/* 132 */       boolean bool1 = structureGenerator.a(this.a, this.b, paramInt1, paramInt2);
/* 133 */       if (structureGenerator instanceof WorldGenVillage) bool |= bool1;
/*     */     
/*     */     } 
/* 136 */     if (this.i != null && !bool && this.b.nextInt(4) == 0) {
/* 137 */       int k = i + this.b.nextInt(16) + 8;
/* 138 */       int m = this.b.nextInt(256);
/* 139 */       int n = j + this.b.nextInt(16) + 8;
/* 140 */       this.i.generate(this.a, this.b, k, m, n);
/*     */     } 
/*     */     
/* 143 */     if (this.j != null && !bool && this.b.nextInt(8) == 0) {
/* 144 */       int k = i + this.b.nextInt(16) + 8;
/* 145 */       int m = this.b.nextInt(this.b.nextInt(248) + 8);
/* 146 */       int n = j + this.b.nextInt(16) + 8;
/* 147 */       if (m < 63 || this.b.nextInt(10) == 0) {
/* 148 */         this.j.generate(this.a, this.b, k, m, n);
/*     */       }
/*     */     } 
/*     */     
/* 152 */     if (this.h) {
/* 153 */       for (byte b = 0; b < 8; b++) {
/* 154 */         int k = i + this.b.nextInt(16) + 8;
/* 155 */         int m = this.b.nextInt(256);
/* 156 */         int n = j + this.b.nextInt(16) + 8;
/* 157 */         (new WorldGenDungeons()).generate(this.a, this.b, k, m, n);
/*     */       } 
/*     */     }
/*     */     
/* 161 */     if (this.g) {
/* 162 */       biomeBase.a(this.a, this.b, i, j);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean saveChunks(boolean paramBoolean, IProgressUpdate paramIProgressUpdate) {
/* 168 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void c() {}
/*     */ 
/*     */   
/*     */   public boolean unloadChunks() {
/* 177 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canSave() {
/* 182 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 188 */     return "FlatLevelSource";
/*     */   }
/*     */ 
/*     */   
/*     */   public List getMobsFor(EnumCreatureType paramEnumCreatureType, int paramInt1, int paramInt2, int paramInt3) {
/* 193 */     BiomeBase biomeBase = this.a.getBiome(paramInt1, paramInt3);
/* 194 */     return biomeBase.getMobs(paramEnumCreatureType);
/*     */   }
/*     */ 
/*     */   
/*     */   public ChunkPosition findNearestMapFeature(World paramWorld, String paramString, int paramInt1, int paramInt2, int paramInt3) {
/* 199 */     if ("Stronghold".equals(paramString)) {
/* 200 */       for (StructureGenerator structureGenerator : this.f) {
/* 201 */         if (structureGenerator instanceof WorldGenStronghold) {
/* 202 */           return structureGenerator.getNearestGeneratedFeature(paramWorld, paramInt1, paramInt2, paramInt3);
/*     */         }
/*     */       } 
/*     */     }
/* 206 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLoadedChunks() {
/* 211 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void recreateStructures(int paramInt1, int paramInt2) {
/* 216 */     for (StructureGenerator structureGenerator : this.f)
/* 217 */       structureGenerator.a(this, this.a, paramInt1, paramInt2, null); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ChunkProviderFlat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */