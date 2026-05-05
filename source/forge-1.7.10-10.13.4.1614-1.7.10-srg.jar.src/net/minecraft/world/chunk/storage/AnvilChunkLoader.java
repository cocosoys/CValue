/*     */ package net.minecraft.world.chunk.storage;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.nbt.NBTTagList;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.world.ChunkCoordIntPair;
/*     */ import net.minecraft.world.NextTickListEntry;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.chunk.Chunk;
/*     */ import net.minecraft.world.chunk.NibbleArray;
/*     */ 
/*     */ public class AnvilChunkLoader implements IChunkLoader, IThreadedFileIO {
/*  17 */   private static final Logger field_151505_a = LogManager.getLogger();
/*     */   
/*     */   static class PendingChunk {
/*     */     public final ChunkCoordIntPair field_76548_a;
/*     */     public final NBTTagCompound field_76547_b;
/*     */     private static final String __OBFID = "CL_00000385";
/*     */     
/*     */     public PendingChunk(ChunkCoordIntPair p_i2002_1_, NBTTagCompound p_i2002_2_) {
/*  25 */       this.field_76548_a = p_i2002_1_;
/*  26 */       this.field_76547_b = p_i2002_2_;
/*     */     }
/*     */   }
/*     */   
/*  30 */   private List field_75828_a = new ArrayList();
/*  31 */   private Set field_75826_b = new HashSet();
/*  32 */   private Object field_75827_c = new Object();
/*     */   public final File field_75825_d;
/*     */   private static final String __OBFID = "CL_00000384";
/*     */   
/*     */   public AnvilChunkLoader(File p_i2003_1_) {
/*  37 */     this.field_75825_d = p_i2003_1_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk func_75815_a(World p_75815_1_, int p_75815_2_, int p_75815_3_) throws IOException {
/*  43 */     NBTTagCompound nBTTagCompound = null;
/*  44 */     ChunkCoordIntPair chunkCoordIntPair = new ChunkCoordIntPair(p_75815_2_, p_75815_3_);
/*     */     
/*  46 */     synchronized (this.field_75827_c) {
/*  47 */       if (this.field_75826_b.contains(chunkCoordIntPair)) {
/*  48 */         for (byte b = 0; b < this.field_75828_a.size(); b++) {
/*  49 */           if (((PendingChunk)this.field_75828_a.get(b)).field_76548_a.equals(chunkCoordIntPair)) {
/*  50 */             nBTTagCompound = ((PendingChunk)this.field_75828_a.get(b)).field_76547_b;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*  57 */     if (nBTTagCompound == null) {
/*  58 */       DataInputStream dataInputStream = RegionFileCache.func_76549_c(this.field_75825_d, p_75815_2_, p_75815_3_);
/*  59 */       if (dataInputStream != null) {
/*  60 */         nBTTagCompound = CompressedStreamTools.func_74794_a(dataInputStream);
/*     */       } else {
/*  62 */         return null;
/*     */       } 
/*     */     } 
/*     */     
/*  66 */     return func_75822_a(p_75815_1_, p_75815_2_, p_75815_3_, nBTTagCompound);
/*     */   }
/*     */   
/*     */   protected Chunk func_75822_a(World p_75822_1_, int p_75822_2_, int p_75822_3_, NBTTagCompound p_75822_4_) {
/*  70 */     if (!p_75822_4_.func_150297_b("Level", 10)) {
/*  71 */       field_151505_a.error("Chunk file at " + p_75822_2_ + "," + p_75822_3_ + " is missing level data, skipping");
/*  72 */       return null;
/*     */     } 
/*  74 */     if (!p_75822_4_.func_74775_l("Level").func_150297_b("Sections", 9)) {
/*  75 */       field_151505_a.error("Chunk file at " + p_75822_2_ + "," + p_75822_3_ + " is missing block data, skipping");
/*  76 */       return null;
/*     */     } 
/*  78 */     Chunk chunk = func_75823_a(p_75822_1_, p_75822_4_.func_74775_l("Level"));
/*  79 */     if (!chunk.func_76600_a(p_75822_2_, p_75822_3_)) {
/*  80 */       field_151505_a.error("Chunk file at " + p_75822_2_ + "," + p_75822_3_ + " is in the wrong location; relocating. (Expected " + p_75822_2_ + ", " + p_75822_3_ + ", got " + chunk.field_76635_g + ", " + chunk.field_76647_h + ")");
/*  81 */       p_75822_4_.func_74768_a("xPos", p_75822_2_);
/*  82 */       p_75822_4_.func_74768_a("zPos", p_75822_3_);
/*  83 */       chunk = func_75823_a(p_75822_1_, p_75822_4_.func_74775_l("Level"));
/*     */     } 
/*  85 */     return chunk;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_75816_a(World p_75816_1_, Chunk p_75816_2_) throws MinecraftException, IOException {
/*  90 */     p_75816_1_.func_72906_B();
/*     */     
/*     */     try {
/*  93 */       NBTTagCompound nBTTagCompound1 = new NBTTagCompound();
/*  94 */       NBTTagCompound nBTTagCompound2 = new NBTTagCompound();
/*  95 */       nBTTagCompound1.func_74782_a("Level", (NBTBase)nBTTagCompound2);
/*  96 */       func_75820_a(p_75816_2_, p_75816_1_, nBTTagCompound2);
/*  97 */       func_75824_a(p_75816_2_.func_76632_l(), nBTTagCompound1);
/*  98 */     } catch (Exception exception) {
/*  99 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_75824_a(ChunkCoordIntPair p_75824_1_, NBTTagCompound p_75824_2_) {
/* 104 */     synchronized (this.field_75827_c) {
/* 105 */       if (this.field_75826_b.contains(p_75824_1_)) {
/* 106 */         for (byte b = 0; b < this.field_75828_a.size(); b++) {
/* 107 */           if (((PendingChunk)this.field_75828_a.get(b)).field_76548_a.equals(p_75824_1_)) {
/* 108 */             this.field_75828_a.set(b, new PendingChunk(p_75824_1_, p_75824_2_));
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       }
/* 113 */       this.field_75828_a.add(new PendingChunk(p_75824_1_, p_75824_2_));
/* 114 */       this.field_75826_b.add(p_75824_1_);
/* 115 */       ThreadedFileIOBase.field_75741_a.func_75735_a(this);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_75814_c() {
/* 121 */     PendingChunk pendingChunk = null;
/*     */     
/* 123 */     synchronized (this.field_75827_c) {
/* 124 */       if (!this.field_75828_a.isEmpty()) {
/* 125 */         pendingChunk = this.field_75828_a.remove(0);
/* 126 */         this.field_75826_b.remove(pendingChunk.field_76548_a);
/*     */       } else {
/* 128 */         return false;
/*     */       } 
/*     */     } 
/* 131 */     if (pendingChunk != null) {
/*     */       try {
/* 133 */         func_75821_a(pendingChunk);
/* 134 */       } catch (Exception exception) {
/* 135 */         exception.printStackTrace();
/*     */       } 
/*     */     }
/*     */     
/* 139 */     return true;
/*     */   }
/*     */   
/*     */   private void func_75821_a(PendingChunk p_75821_1_) throws IOException {
/* 143 */     DataOutputStream dataOutputStream = RegionFileCache.func_76552_d(this.field_75825_d, p_75821_1_.field_76548_a.field_77276_a, p_75821_1_.field_76548_a.field_77275_b);
/* 144 */     CompressedStreamTools.func_74800_a(p_75821_1_.field_76547_b, dataOutputStream);
/* 145 */     dataOutputStream.close();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75819_b(World p_75819_1_, Chunk p_75819_2_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_75817_a() {}
/*     */ 
/*     */   
/*     */   public void func_75818_b() {
/* 158 */     while (func_75814_c());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void func_75820_a(Chunk p_75820_1_, World p_75820_2_, NBTTagCompound p_75820_3_) {
/* 164 */     p_75820_3_.func_74774_a("V", (byte)1);
/* 165 */     p_75820_3_.func_74768_a("xPos", p_75820_1_.field_76635_g);
/* 166 */     p_75820_3_.func_74768_a("zPos", p_75820_1_.field_76647_h);
/* 167 */     p_75820_3_.func_74772_a("LastUpdate", p_75820_2_.func_82737_E());
/* 168 */     p_75820_3_.func_74783_a("HeightMap", p_75820_1_.field_76634_f);
/* 169 */     p_75820_3_.func_74757_a("TerrainPopulated", p_75820_1_.field_76646_k);
/* 170 */     p_75820_3_.func_74757_a("LightPopulated", p_75820_1_.field_150814_l);
/* 171 */     p_75820_3_.func_74772_a("InhabitedTime", p_75820_1_.field_111204_q);
/*     */     
/* 173 */     ExtendedBlockStorage[] arrayOfExtendedBlockStorage = p_75820_1_.func_76587_i();
/* 174 */     NBTTagList nBTTagList1 = new NBTTagList();
/*     */     
/* 176 */     boolean bool = !p_75820_2_.field_73011_w.field_76576_e ? true : false;
/*     */     
/* 178 */     for (ExtendedBlockStorage extendedBlockStorage : arrayOfExtendedBlockStorage) {
/*     */       
/* 180 */       if (extendedBlockStorage != null) {
/*     */ 
/*     */         
/* 183 */         NBTTagCompound nBTTagCompound = new NBTTagCompound();
/*     */         
/* 185 */         nBTTagCompound.func_74774_a("Y", (byte)(extendedBlockStorage.func_76662_d() >> 4 & 0xFF));
/* 186 */         nBTTagCompound.func_74773_a("Blocks", extendedBlockStorage.func_76658_g());
/* 187 */         if (extendedBlockStorage.func_76660_i() != null) {
/* 188 */           nBTTagCompound.func_74773_a("Add", (extendedBlockStorage.func_76660_i()).field_76585_a);
/*     */         }
/* 190 */         nBTTagCompound.func_74773_a("Data", (extendedBlockStorage.func_76669_j()).field_76585_a);
/* 191 */         nBTTagCompound.func_74773_a("BlockLight", (extendedBlockStorage.func_76661_k()).field_76585_a);
/* 192 */         if (bool) {
/* 193 */           nBTTagCompound.func_74773_a("SkyLight", (extendedBlockStorage.func_76671_l()).field_76585_a);
/*     */         } else {
/*     */           
/* 196 */           nBTTagCompound.func_74773_a("SkyLight", new byte[(extendedBlockStorage.func_76661_k()).field_76585_a.length]);
/*     */         } 
/*     */         
/* 199 */         nBTTagList1.func_74742_a((NBTBase)nBTTagCompound);
/*     */       } 
/* 201 */     }  p_75820_3_.func_74782_a("Sections", (NBTBase)nBTTagList1);
/* 202 */     p_75820_3_.func_74773_a("Biomes", p_75820_1_.func_76605_m());
/*     */     
/* 204 */     p_75820_1_.field_76644_m = false;
/* 205 */     NBTTagList nBTTagList2 = new NBTTagList();
/* 206 */     for (byte b = 0; b < p_75820_1_.field_76645_j.length; b++) {
/* 207 */       for (Entity entity : p_75820_1_.field_76645_j[b]) {
/* 208 */         NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 209 */         if (entity.func_70039_c(nBTTagCompound)) {
/* 210 */           p_75820_1_.field_76644_m = true;
/* 211 */           nBTTagList2.func_74742_a((NBTBase)nBTTagCompound);
/*     */         } 
/*     */       } 
/*     */     } 
/* 215 */     p_75820_3_.func_74782_a("Entities", (NBTBase)nBTTagList2);
/*     */     
/* 217 */     NBTTagList nBTTagList3 = new NBTTagList();
/* 218 */     for (TileEntity tileEntity : p_75820_1_.field_150816_i.values()) {
/* 219 */       NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 220 */       tileEntity.func_145841_b(nBTTagCompound);
/* 221 */       nBTTagList3.func_74742_a((NBTBase)nBTTagCompound);
/*     */     } 
/* 223 */     p_75820_3_.func_74782_a("TileEntities", (NBTBase)nBTTagList3);
/*     */     
/* 225 */     List list = p_75820_2_.func_72920_a(p_75820_1_, false);
/* 226 */     if (list != null) {
/* 227 */       long l = p_75820_2_.func_82737_E();
/*     */       
/* 229 */       NBTTagList nBTTagList = new NBTTagList();
/* 230 */       for (NextTickListEntry nextTickListEntry : list) {
/* 231 */         NBTTagCompound nBTTagCompound = new NBTTagCompound();
/* 232 */         nBTTagCompound.func_74768_a("i", Block.func_149682_b(nextTickListEntry.func_151351_a()));
/* 233 */         nBTTagCompound.func_74768_a("x", nextTickListEntry.field_77183_a);
/* 234 */         nBTTagCompound.func_74768_a("y", nextTickListEntry.field_77181_b);
/* 235 */         nBTTagCompound.func_74768_a("z", nextTickListEntry.field_77182_c);
/* 236 */         nBTTagCompound.func_74768_a("t", (int)(nextTickListEntry.field_77180_e - l));
/* 237 */         nBTTagCompound.func_74768_a("p", nextTickListEntry.field_82754_f);
/*     */         
/* 239 */         nBTTagList.func_74742_a((NBTBase)nBTTagCompound);
/*     */       } 
/* 241 */       p_75820_3_.func_74782_a("TileTicks", (NBTBase)nBTTagList);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private Chunk func_75823_a(World p_75823_1_, NBTTagCompound p_75823_2_) {
/* 247 */     int i = p_75823_2_.func_74762_e("xPos");
/* 248 */     int j = p_75823_2_.func_74762_e("zPos");
/*     */     
/* 250 */     Chunk chunk = new Chunk(p_75823_1_, i, j);
/* 251 */     chunk.field_76634_f = p_75823_2_.func_74759_k("HeightMap");
/* 252 */     chunk.field_76646_k = p_75823_2_.func_74767_n("TerrainPopulated");
/* 253 */     chunk.field_150814_l = p_75823_2_.func_74767_n("LightPopulated");
/* 254 */     chunk.field_111204_q = p_75823_2_.func_74763_f("InhabitedTime");
/*     */     
/* 256 */     NBTTagList nBTTagList1 = p_75823_2_.func_150295_c("Sections", 10);
/* 257 */     byte b1 = 16;
/* 258 */     ExtendedBlockStorage[] arrayOfExtendedBlockStorage = new ExtendedBlockStorage[b1];
/*     */     
/* 260 */     boolean bool = !p_75823_1_.field_73011_w.field_76576_e ? true : false;
/*     */     
/* 262 */     for (byte b2 = 0; b2 < nBTTagList1.func_74745_c(); b2++) {
/* 263 */       NBTTagCompound nBTTagCompound = nBTTagList1.func_150305_b(b2);
/*     */       
/* 265 */       byte b = nBTTagCompound.func_74771_c("Y");
/* 266 */       ExtendedBlockStorage extendedBlockStorage = new ExtendedBlockStorage(b << 4, bool);
/* 267 */       extendedBlockStorage.func_76664_a(nBTTagCompound.func_74770_j("Blocks"));
/* 268 */       if (nBTTagCompound.func_150297_b("Add", 7)) {
/* 269 */         extendedBlockStorage.func_76673_a(new NibbleArray(nBTTagCompound.func_74770_j("Add"), 4));
/*     */       }
/* 271 */       extendedBlockStorage.func_76668_b(new NibbleArray(nBTTagCompound.func_74770_j("Data"), 4));
/* 272 */       extendedBlockStorage.func_76659_c(new NibbleArray(nBTTagCompound.func_74770_j("BlockLight"), 4));
/* 273 */       if (bool) {
/* 274 */         extendedBlockStorage.func_76666_d(new NibbleArray(nBTTagCompound.func_74770_j("SkyLight"), 4));
/*     */       }
/* 276 */       extendedBlockStorage.func_76672_e();
/*     */       
/* 278 */       arrayOfExtendedBlockStorage[b] = extendedBlockStorage;
/*     */     } 
/* 280 */     chunk.func_76602_a(arrayOfExtendedBlockStorage);
/* 281 */     if (p_75823_2_.func_150297_b("Biomes", 7)) {
/* 282 */       chunk.func_76616_a(p_75823_2_.func_74770_j("Biomes"));
/*     */     }
/*     */     
/* 285 */     NBTTagList nBTTagList2 = p_75823_2_.func_150295_c("Entities", 10);
/* 286 */     if (nBTTagList2 != null) {
/* 287 */       for (byte b = 0; b < nBTTagList2.func_74745_c(); b++) {
/* 288 */         NBTTagCompound nBTTagCompound = nBTTagList2.func_150305_b(b);
/* 289 */         Entity entity = EntityList.func_75615_a(nBTTagCompound, p_75823_1_);
/* 290 */         chunk.field_76644_m = true;
/* 291 */         if (entity != null) {
/* 292 */           chunk.func_76612_a(entity);
/*     */ 
/*     */           
/* 295 */           Entity entity1 = entity;
/* 296 */           NBTTagCompound nBTTagCompound1 = nBTTagCompound;
/* 297 */           while (nBTTagCompound1.func_150297_b("Riding", 10)) {
/* 298 */             Entity entity2 = EntityList.func_75615_a(nBTTagCompound1.func_74775_l("Riding"), p_75823_1_);
/* 299 */             if (entity2 != null) {
/* 300 */               chunk.func_76612_a(entity2);
/* 301 */               entity1.func_70078_a(entity2);
/*     */             } 
/* 303 */             entity1 = entity2;
/* 304 */             nBTTagCompound1 = nBTTagCompound1.func_74775_l("Riding");
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 310 */     NBTTagList nBTTagList3 = p_75823_2_.func_150295_c("TileEntities", 10);
/* 311 */     if (nBTTagList3 != null) {
/* 312 */       for (byte b = 0; b < nBTTagList3.func_74745_c(); b++) {
/* 313 */         NBTTagCompound nBTTagCompound = nBTTagList3.func_150305_b(b);
/* 314 */         TileEntity tileEntity = TileEntity.func_145827_c(nBTTagCompound);
/* 315 */         if (tileEntity != null) {
/* 316 */           chunk.func_150813_a(tileEntity);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 321 */     if (p_75823_2_.func_150297_b("TileTicks", 9)) {
/* 322 */       NBTTagList nBTTagList = p_75823_2_.func_150295_c("TileTicks", 10);
/*     */       
/* 324 */       if (nBTTagList != null) {
/* 325 */         for (byte b = 0; b < nBTTagList.func_74745_c(); b++) {
/* 326 */           NBTTagCompound nBTTagCompound = nBTTagList.func_150305_b(b);
/*     */           
/* 328 */           p_75823_1_.func_147446_b(nBTTagCompound.func_74762_e("x"), nBTTagCompound.func_74762_e("y"), nBTTagCompound.func_74762_e("z"), Block.func_149729_e(nBTTagCompound.func_74762_e("i")), nBTTagCompound.func_74762_e("t"), nBTTagCompound.func_74762_e("p"));
/*     */         } 
/*     */       }
/*     */     } 
/* 332 */     return chunk;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\chunk\storage\AnvilChunkLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */