/*     */ package net.minecraft.world.gen;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.EnumCreatureType;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.IProgressUpdate;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.chunk.IChunkProvider;
/*     */ import net.minecraft.world.chunk.storage.ExtendedBlockStorage;
/*     */ import net.minecraft.world.gen.feature.WorldGenDungeons;
/*     */ import net.minecraft.world.gen.feature.WorldGenLakes;
/*     */ import net.minecraft.world.gen.structure.MapGenMineshaft;
/*     */ import net.minecraft.world.gen.structure.MapGenScatteredFeature;
/*     */ import net.minecraft.world.gen.structure.MapGenStronghold;
/*     */ import net.minecraft.world.gen.structure.MapGenStructure;
/*     */ import net.minecraft.world.gen.structure.MapGenVillage;
/*     */ 
/*     */ public class ChunkProviderFlat implements IChunkProvider {
/*     */   private World field_73163_a;
/*  25 */   private final Block[] field_82700_c = new Block[256]; private Random field_73161_b;
/*  26 */   private final byte[] field_82698_d = new byte[256];
/*     */   private final FlatGeneratorInfo field_82699_e;
/*  28 */   private final List field_82696_f = new ArrayList(); private final boolean field_82697_g;
/*     */   private final boolean field_82702_h;
/*     */   private WorldGenLakes field_82703_i;
/*     */   private WorldGenLakes field_82701_j;
/*     */   private static final String __OBFID = "CL_00000391";
/*     */   
/*     */   public ChunkProviderFlat(World p_i2004_1_, long p_i2004_2_, boolean p_i2004_4_, String p_i2004_5_) {
/*  35 */     this.field_73163_a = p_i2004_1_;
/*  36 */     this.field_73161_b = new Random(p_i2004_2_);
/*  37 */     this.field_82699_e = FlatGeneratorInfo.func_82651_a(p_i2004_5_);
/*     */     
/*  39 */     if (p_i2004_4_) {
/*  40 */       Map map = this.field_82699_e.func_82644_b();
/*     */       
/*  42 */       if (map.containsKey("village")) {
/*  43 */         Map<String, String> map1 = (Map)map.get("village");
/*  44 */         if (!map1.containsKey("size")) map1.put("size", "1"); 
/*  45 */         this.field_82696_f.add(new MapGenVillage(map1));
/*     */       } 
/*     */       
/*  48 */       if (map.containsKey("biome_1")) this.field_82696_f.add(new MapGenScatteredFeature((Map)map.get("biome_1"))); 
/*  49 */       if (map.containsKey("mineshaft")) this.field_82696_f.add(new MapGenMineshaft((Map)map.get("mineshaft"))); 
/*  50 */       if (map.containsKey("stronghold")) this.field_82696_f.add(new MapGenStronghold((Map)map.get("stronghold")));
/*     */     
/*     */     } 
/*  53 */     this.field_82697_g = this.field_82699_e.func_82644_b().containsKey("decoration");
/*  54 */     if (this.field_82699_e.func_82644_b().containsKey("lake")) this.field_82703_i = new WorldGenLakes(Blocks.field_150355_j); 
/*  55 */     if (this.field_82699_e.func_82644_b().containsKey("lava_lake")) this.field_82701_j = new WorldGenLakes(Blocks.field_150353_l); 
/*  56 */     this.field_82702_h = this.field_82699_e.func_82644_b().containsKey("dungeon");
/*     */     
/*  58 */     for (FlatLayerInfo flatLayerInfo : this.field_82699_e.func_82650_c()) {
/*  59 */       for (int i = flatLayerInfo.func_82656_d(); i < flatLayerInfo.func_82656_d() + flatLayerInfo.func_82657_a(); i++) {
/*  60 */         this.field_82700_c[i] = flatLayerInfo.func_151536_b();
/*  61 */         this.field_82698_d[i] = (byte)flatLayerInfo.func_82658_c();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk func_73158_c(int p_73158_1_, int p_73158_2_) {
/*  69 */     return func_73154_d(p_73158_1_, p_73158_2_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk func_73154_d(int p_73154_1_, int p_73154_2_) {
/*  75 */     Chunk chunk = new Chunk(this.field_73163_a, p_73154_1_, p_73154_2_);
/*     */     
/*  77 */     for (byte b1 = 0; b1 < this.field_82700_c.length; b1++) {
/*  78 */       Block block = this.field_82700_c[b1];
/*  79 */       if (block != null) {
/*  80 */         int i = b1 >> 4;
/*  81 */         ExtendedBlockStorage extendedBlockStorage = chunk.func_76587_i()[i];
/*     */         
/*  83 */         if (extendedBlockStorage == null) {
/*  84 */           extendedBlockStorage = new ExtendedBlockStorage(b1, !this.field_73163_a.field_73011_w.field_76576_e);
/*  85 */           chunk.func_76587_i()[i] = extendedBlockStorage;
/*     */         } 
/*     */         
/*  88 */         for (byte b = 0; b < 16; b++) {
/*  89 */           for (byte b3 = 0; b3 < 16; b3++) {
/*  90 */             extendedBlockStorage.func_150818_a(b, b1 & 0xF, b3, block);
/*  91 */             extendedBlockStorage.func_76654_b(b, b1 & 0xF, b3, this.field_82698_d[b1]);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*  96 */     chunk.func_76603_b();
/*     */     
/*  98 */     BiomeGenBase[] arrayOfBiomeGenBase = this.field_73163_a.func_72959_q().func_76933_b(null, p_73154_1_ * 16, p_73154_2_ * 16, 16, 16);
/*  99 */     byte[] arrayOfByte = chunk.func_76605_m();
/*     */     
/* 101 */     for (byte b2 = 0; b2 < arrayOfByte.length; b2++) {
/* 102 */       arrayOfByte[b2] = (byte)(arrayOfBiomeGenBase[b2]).field_76756_M;
/*     */     }
/*     */     
/* 105 */     for (MapGenBase mapGenBase : this.field_82696_f) {
/* 106 */       mapGenBase.func_151539_a(this, this.field_73163_a, p_73154_1_, p_73154_2_, null);
/*     */     }
/*     */     
/* 109 */     chunk.func_76603_b();
/*     */     
/* 111 */     return chunk;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73149_a(int p_73149_1_, int p_73149_2_) {
/* 116 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73153_a(IChunkProvider p_73153_1_, int p_73153_2_, int p_73153_3_) {
/* 121 */     int i = p_73153_2_ * 16;
/* 122 */     int j = p_73153_3_ * 16;
/* 123 */     BiomeGenBase biomeGenBase = this.field_73163_a.func_72807_a(i + 16, j + 16);
/* 124 */     boolean bool = false;
/*     */     
/* 126 */     this.field_73161_b.setSeed(this.field_73163_a.func_72905_C());
/* 127 */     long l1 = this.field_73161_b.nextLong() / 2L * 2L + 1L;
/* 128 */     long l2 = this.field_73161_b.nextLong() / 2L * 2L + 1L;
/* 129 */     this.field_73161_b.setSeed(p_73153_2_ * l1 + p_73153_3_ * l2 ^ this.field_73163_a.func_72905_C());
/*     */     
/* 131 */     for (MapGenStructure mapGenStructure : this.field_82696_f) {
/* 132 */       boolean bool1 = mapGenStructure.func_75051_a(this.field_73163_a, this.field_73161_b, p_73153_2_, p_73153_3_);
/* 133 */       if (mapGenStructure instanceof MapGenVillage) bool |= bool1;
/*     */     
/*     */     } 
/* 136 */     if (this.field_82703_i != null && !bool && this.field_73161_b.nextInt(4) == 0) {
/* 137 */       int k = i + this.field_73161_b.nextInt(16) + 8;
/* 138 */       int m = this.field_73161_b.nextInt(256);
/* 139 */       int n = j + this.field_73161_b.nextInt(16) + 8;
/* 140 */       this.field_82703_i.func_76484_a(this.field_73163_a, this.field_73161_b, k, m, n);
/*     */     } 
/*     */     
/* 143 */     if (this.field_82701_j != null && !bool && this.field_73161_b.nextInt(8) == 0) {
/* 144 */       int k = i + this.field_73161_b.nextInt(16) + 8;
/* 145 */       int m = this.field_73161_b.nextInt(this.field_73161_b.nextInt(248) + 8);
/* 146 */       int n = j + this.field_73161_b.nextInt(16) + 8;
/* 147 */       if (m < 63 || this.field_73161_b.nextInt(10) == 0) {
/* 148 */         this.field_82701_j.func_76484_a(this.field_73163_a, this.field_73161_b, k, m, n);
/*     */       }
/*     */     } 
/*     */     
/* 152 */     if (this.field_82702_h) {
/* 153 */       for (byte b = 0; b < 8; b++) {
/* 154 */         int k = i + this.field_73161_b.nextInt(16) + 8;
/* 155 */         int m = this.field_73161_b.nextInt(256);
/* 156 */         int n = j + this.field_73161_b.nextInt(16) + 8;
/* 157 */         (new WorldGenDungeons()).func_76484_a(this.field_73163_a, this.field_73161_b, k, m, n);
/*     */       } 
/*     */     }
/*     */     
/* 161 */     if (this.field_82697_g) {
/* 162 */       biomeGenBase.func_76728_a(this.field_73163_a, this.field_73161_b, i, j);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73151_a(boolean p_73151_1_, IProgressUpdate p_73151_2_) {
/* 168 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_104112_b() {}
/*     */ 
/*     */   
/*     */   public boolean func_73156_b() {
/* 177 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_73157_c() {
/* 182 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String func_73148_d() {
/* 188 */     return "FlatLevelSource";
/*     */   }
/*     */ 
/*     */   
/*     */   public List func_73155_a(EnumCreatureType p_73155_1_, int p_73155_2_, int p_73155_3_, int p_73155_4_) {
/* 193 */     BiomeGenBase biomeGenBase = this.field_73163_a.func_72807_a(p_73155_2_, p_73155_4_);
/* 194 */     return biomeGenBase.func_76747_a(p_73155_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public ChunkPosition func_147416_a(World p_147416_1_, String p_147416_2_, int p_147416_3_, int p_147416_4_, int p_147416_5_) {
/* 199 */     if ("Stronghold".equals(p_147416_2_)) {
/* 200 */       for (MapGenStructure mapGenStructure : this.field_82696_f) {
/* 201 */         if (mapGenStructure instanceof MapGenStronghold) {
/* 202 */           return mapGenStructure.func_151545_a(p_147416_1_, p_147416_3_, p_147416_4_, p_147416_5_);
/*     */         }
/*     */       } 
/*     */     }
/* 206 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_73152_e() {
/* 211 */     return 0;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_82695_e(int p_82695_1_, int p_82695_2_) {
/* 216 */     for (MapGenStructure mapGenStructure : this.field_82696_f)
/* 217 */       mapGenStructure.func_151539_a(this, this.field_73163_a, p_82695_1_, p_82695_2_, null); 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\ChunkProviderFlat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */