/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.io.DataInputStream;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class ChunkRegionLoader
/*     */   implements IChunkLoader, IAsyncChunkSaver
/*     */ {
/*  18 */   private static final Logger a = LogManager.getLogger();
/*  19 */   private List b = new ArrayList();
/*  20 */   private Set c = new HashSet();
/*  21 */   private Object d = new Object();
/*     */   private final File e;
/*     */   
/*     */   public ChunkRegionLoader(File file1) {
/*  25 */     this.e = file1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean chunkExists(World world, int i, int j) {
/*  30 */     ChunkCoordIntPair chunkcoordintpair = new ChunkCoordIntPair(i, j);
/*     */     
/*  32 */     synchronized (this.d) {
/*  33 */       if (this.c.contains(chunkcoordintpair)) {
/*  34 */         for (int k = 0; k < this.b.size(); k++) {
/*  35 */           if (((PendingChunkToSave)this.b.get(k)).a.equals(chunkcoordintpair)) {
/*  36 */             return true;
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/*  42 */     return RegionFileCache.a(this.e, i, j).chunkExists(i & 0x1F, j & 0x1F);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Chunk a(World world, int i, int j) {
/*  48 */     Object[] data = loadChunk(world, i, j);
/*  49 */     if (data != null) {
/*  50 */       Chunk chunk = (Chunk)data[0];
/*  51 */       NBTTagCompound nbttagcompound = (NBTTagCompound)data[1];
/*  52 */       loadEntities(chunk, nbttagcompound.getCompound("Level"), world);
/*  53 */       return chunk;
/*     */     } 
/*     */     
/*  56 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public Object[] loadChunk(World world, int i, int j) {
/*  61 */     NBTTagCompound nbttagcompound = null;
/*  62 */     ChunkCoordIntPair chunkcoordintpair = new ChunkCoordIntPair(i, j);
/*  63 */     Object object = this.d;
/*     */     
/*  65 */     synchronized (this.d) {
/*  66 */       if (this.c.contains(chunkcoordintpair)) {
/*  67 */         for (int k = 0; k < this.b.size(); k++) {
/*  68 */           if (((PendingChunkToSave)this.b.get(k)).a.equals(chunkcoordintpair)) {
/*  69 */             nbttagcompound = ((PendingChunkToSave)this.b.get(k)).b;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*  76 */     if (nbttagcompound == null) {
/*  77 */       DataInputStream datainputstream = RegionFileCache.c(this.e, i, j);
/*     */       
/*  79 */       if (datainputstream == null) {
/*  80 */         return null;
/*     */       }
/*     */       
/*  83 */       nbttagcompound = NBTCompressedStreamTools.a(datainputstream);
/*     */     } 
/*     */     
/*  86 */     return a(world, i, j, nbttagcompound);
/*     */   }
/*     */   
/*     */   protected Object[] a(World world, int i, int j, NBTTagCompound nbttagcompound) {
/*  90 */     if (!nbttagcompound.hasKeyOfType("Level", 10)) {
/*  91 */       a.error("Chunk file at " + i + "," + j + " is missing level data, skipping");
/*  92 */       return null;
/*  93 */     }  if (!nbttagcompound.getCompound("Level").hasKeyOfType("Sections", 9)) {
/*  94 */       a.error("Chunk file at " + i + "," + j + " is missing block data, skipping");
/*  95 */       return null;
/*     */     } 
/*  97 */     Chunk chunk = a(world, nbttagcompound.getCompound("Level"));
/*     */     
/*  99 */     if (!chunk.a(i, j)) {
/* 100 */       a.error("Chunk file at " + i + "," + j + " is in the wrong location; relocating. (Expected " + i + ", " + j + ", got " + chunk.locX + ", " + chunk.locZ + ")");
/* 101 */       nbttagcompound.getCompound("Level").setInt("xPos", i);
/* 102 */       nbttagcompound.getCompound("Level").setInt("zPos", j);
/*     */ 
/*     */       
/* 105 */       NBTTagList tileEntities = nbttagcompound.getCompound("Level").getList("TileEntities", 10);
/* 106 */       if (tileEntities != null) {
/* 107 */         for (int te = 0; te < tileEntities.size(); te++) {
/* 108 */           NBTTagCompound tileEntity = tileEntities.get(te);
/* 109 */           int x = tileEntity.getInt("x") - chunk.locX * 16;
/* 110 */           int z = tileEntity.getInt("z") - chunk.locZ * 16;
/* 111 */           tileEntity.setInt("x", i * 16 + x);
/* 112 */           tileEntity.setInt("z", j * 16 + z);
/*     */         } 
/*     */       }
/*     */       
/* 116 */       chunk = a(world, nbttagcompound.getCompound("Level"));
/*     */     } 
/*     */ 
/*     */     
/* 120 */     Object[] data = new Object[2];
/* 121 */     data[0] = chunk;
/* 122 */     data[1] = nbttagcompound;
/* 123 */     return data;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(World world, Chunk chunk) {
/*     */     try {
/* 131 */       world.G();
/* 132 */     } catch (ExceptionWorldConflict ex) {
/* 133 */       ex.printStackTrace();
/*     */     } 
/*     */ 
/*     */     
/*     */     try {
/* 138 */       NBTTagCompound nbttagcompound = new NBTTagCompound();
/* 139 */       NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/*     */       
/* 141 */       nbttagcompound.set("Level", nbttagcompound1);
/* 142 */       a(chunk, world, nbttagcompound1);
/* 143 */       a(chunk.l(), nbttagcompound);
/* 144 */     } catch (Exception exception) {
/* 145 */       exception.printStackTrace();
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void a(ChunkCoordIntPair chunkcoordintpair, NBTTagCompound nbttagcompound) {
/* 150 */     Object object = this.d;
/*     */     
/* 152 */     synchronized (this.d) {
/* 153 */       if (this.c.contains(chunkcoordintpair)) {
/* 154 */         for (int i = 0; i < this.b.size(); i++) {
/* 155 */           if (((PendingChunkToSave)this.b.get(i)).a.equals(chunkcoordintpair)) {
/* 156 */             this.b.set(i, new PendingChunkToSave(chunkcoordintpair, nbttagcompound));
/*     */             
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       }
/* 162 */       this.b.add(new PendingChunkToSave(chunkcoordintpair, nbttagcompound));
/* 163 */       this.c.add(chunkcoordintpair);
/* 164 */       FileIOThread.a.a(this);
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean c() {
/* 169 */     PendingChunkToSave pendingchunktosave = null;
/* 170 */     Object object = this.d;
/*     */     
/* 172 */     synchronized (this.d) {
/* 173 */       if (this.b.isEmpty()) {
/* 174 */         return false;
/*     */       }
/*     */       
/* 177 */       pendingchunktosave = this.b.remove(0);
/* 178 */       this.c.remove(pendingchunktosave.a);
/*     */     } 
/*     */     
/* 181 */     if (pendingchunktosave != null) {
/*     */       try {
/* 183 */         a(pendingchunktosave);
/* 184 */       } catch (Exception exception) {
/* 185 */         exception.printStackTrace();
/*     */       } 
/*     */     }
/*     */     
/* 189 */     return true;
/*     */   }
/*     */   
/*     */   public void a(PendingChunkToSave pendingchunktosave) throws IOException {
/* 193 */     DataOutputStream dataoutputstream = RegionFileCache.d(this.e, pendingchunktosave.a.x, pendingchunktosave.a.z);
/*     */     
/* 195 */     NBTCompressedStreamTools.a(pendingchunktosave.b, dataoutputstream);
/* 196 */     dataoutputstream.close();
/*     */   }
/*     */   
/*     */   public void b(World world, Chunk chunk) {}
/*     */   
/*     */   public void a() {}
/*     */   
/*     */   public void b() {
/* 204 */     while (c());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void a(Chunk chunk, World world, NBTTagCompound nbttagcompound) {
/* 210 */     nbttagcompound.setByte("V", (byte)1);
/* 211 */     nbttagcompound.setInt("xPos", chunk.locX);
/* 212 */     nbttagcompound.setInt("zPos", chunk.locZ);
/* 213 */     nbttagcompound.setLong("LastUpdate", world.getTime());
/* 214 */     nbttagcompound.setIntArray("HeightMap", chunk.heightMap);
/* 215 */     nbttagcompound.setBoolean("TerrainPopulated", chunk.done);
/* 216 */     nbttagcompound.setBoolean("LightPopulated", chunk.lit);
/* 217 */     nbttagcompound.setLong("InhabitedTime", chunk.s);
/* 218 */     ChunkSection[] achunksection = chunk.getSections();
/* 219 */     NBTTagList nbttaglist = new NBTTagList();
/* 220 */     boolean flag = !world.worldProvider.g;
/* 221 */     ChunkSection[] achunksection1 = achunksection;
/* 222 */     int i = achunksection.length;
/*     */ 
/*     */ 
/*     */     
/* 226 */     for (int j = 0; j < i; j++) {
/* 227 */       ChunkSection chunksection = achunksection1[j];
/*     */       
/* 229 */       if (chunksection != null) {
/* 230 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 231 */         nbttagcompound1.setByte("Y", (byte)(chunksection.getYPosition() >> 4 & 0xFF));
/* 232 */         nbttagcompound1.setByteArray("Blocks", chunksection.getIdArray());
/* 233 */         if (chunksection.getExtendedIdArray() != null) {
/* 234 */           nbttagcompound1.setByteArray("Add", (chunksection.getExtendedIdArray()).a);
/*     */         }
/*     */         
/* 237 */         nbttagcompound1.setByteArray("Data", (chunksection.getDataArray()).a);
/* 238 */         nbttagcompound1.setByteArray("BlockLight", (chunksection.getEmittedLightArray()).a);
/* 239 */         if (flag) {
/* 240 */           nbttagcompound1.setByteArray("SkyLight", (chunksection.getSkyLightArray()).a);
/*     */         } else {
/* 242 */           nbttagcompound1.setByteArray("SkyLight", new byte[(chunksection.getEmittedLightArray()).a.length]);
/*     */         } 
/*     */         
/* 245 */         nbttaglist.add(nbttagcompound1);
/*     */       } 
/*     */     } 
/*     */     
/* 249 */     nbttagcompound.set("Sections", nbttaglist);
/* 250 */     nbttagcompound.setByteArray("Biomes", chunk.m());
/* 251 */     chunk.o = false;
/* 252 */     NBTTagList nbttaglist1 = new NBTTagList();
/*     */ 
/*     */ 
/*     */     
/* 256 */     for (i = 0; i < chunk.entitySlices.length; i++) {
/* 257 */       Iterator<?> iterator1 = chunk.entitySlices[i].iterator();
/*     */       
/* 259 */       while (iterator1.hasNext()) {
/* 260 */         Entity entity = (Entity)iterator1.next();
/*     */         
/* 262 */         NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 263 */         if (entity.d(nbttagcompound1)) {
/* 264 */           chunk.o = true;
/* 265 */           nbttaglist1.add(nbttagcompound1);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 270 */     nbttagcompound.set("Entities", nbttaglist1);
/* 271 */     NBTTagList nbttaglist2 = new NBTTagList();
/*     */     
/* 273 */     Iterator<TileEntity> iterator = chunk.tileEntities.values().iterator();
/*     */     
/* 275 */     while (iterator.hasNext()) {
/* 276 */       TileEntity tileentity = iterator.next();
/*     */       
/* 278 */       NBTTagCompound nbttagcompound1 = new NBTTagCompound();
/* 279 */       tileentity.b(nbttagcompound1);
/* 280 */       nbttaglist2.add(nbttagcompound1);
/*     */     } 
/*     */     
/* 283 */     nbttagcompound.set("TileEntities", nbttaglist2);
/* 284 */     List list = world.a(chunk, false);
/*     */     
/* 286 */     if (list != null) {
/* 287 */       long k = world.getTime();
/* 288 */       NBTTagList nbttaglist3 = new NBTTagList();
/* 289 */       Iterator<NextTickListEntry> iterator1 = list.iterator();
/*     */       
/* 291 */       while (iterator1.hasNext()) {
/* 292 */         NextTickListEntry nextticklistentry = iterator1.next();
/* 293 */         NBTTagCompound nbttagcompound2 = new NBTTagCompound();
/*     */         
/* 295 */         nbttagcompound2.setInt("i", Block.getId(nextticklistentry.a()));
/* 296 */         nbttagcompound2.setInt("x", nextticklistentry.a);
/* 297 */         nbttagcompound2.setInt("y", nextticklistentry.b);
/* 298 */         nbttagcompound2.setInt("z", nextticklistentry.c);
/* 299 */         nbttagcompound2.setInt("t", (int)(nextticklistentry.d - k));
/* 300 */         nbttagcompound2.setInt("p", nextticklistentry.e);
/* 301 */         nbttaglist3.add(nbttagcompound2);
/*     */       } 
/*     */       
/* 304 */       nbttagcompound.set("TileTicks", nbttaglist3);
/*     */     } 
/*     */   }
/*     */   
/*     */   private Chunk a(World world, NBTTagCompound nbttagcompound) {
/* 309 */     int i = nbttagcompound.getInt("xPos");
/* 310 */     int j = nbttagcompound.getInt("zPos");
/* 311 */     Chunk chunk = new Chunk(world, i, j);
/*     */     
/* 313 */     chunk.heightMap = nbttagcompound.getIntArray("HeightMap");
/* 314 */     chunk.done = nbttagcompound.getBoolean("TerrainPopulated");
/* 315 */     chunk.lit = nbttagcompound.getBoolean("LightPopulated");
/* 316 */     chunk.s = nbttagcompound.getLong("InhabitedTime");
/* 317 */     NBTTagList nbttaglist = nbttagcompound.getList("Sections", 10);
/* 318 */     byte b0 = 16;
/* 319 */     ChunkSection[] achunksection = new ChunkSection[b0];
/* 320 */     boolean flag = !world.worldProvider.g;
/*     */     
/* 322 */     for (int k = 0; k < nbttaglist.size(); k++) {
/* 323 */       NBTTagCompound nbttagcompound1 = nbttaglist.get(k);
/* 324 */       byte b1 = nbttagcompound1.getByte("Y");
/* 325 */       ChunkSection chunksection = new ChunkSection(b1 << 4, flag);
/*     */       
/* 327 */       chunksection.setIdArray(nbttagcompound1.getByteArray("Blocks"));
/* 328 */       if (nbttagcompound1.hasKeyOfType("Add", 7)) {
/* 329 */         chunksection.setExtendedIdArray(new NibbleArray(nbttagcompound1.getByteArray("Add"), 4));
/*     */       }
/*     */       
/* 332 */       chunksection.setDataArray(new NibbleArray(nbttagcompound1.getByteArray("Data"), 4));
/* 333 */       chunksection.setEmittedLightArray(new NibbleArray(nbttagcompound1.getByteArray("BlockLight"), 4));
/* 334 */       if (flag) {
/* 335 */         chunksection.setSkyLightArray(new NibbleArray(nbttagcompound1.getByteArray("SkyLight"), 4));
/*     */       }
/*     */       
/* 338 */       chunksection.recalcBlockCounts();
/* 339 */       achunksection[b1] = chunksection;
/*     */     } 
/*     */     
/* 342 */     chunk.a(achunksection);
/* 343 */     if (nbttagcompound.hasKeyOfType("Biomes", 7)) {
/* 344 */       chunk.a(nbttagcompound.getByteArray("Biomes"));
/*     */     }
/*     */ 
/*     */     
/* 348 */     return chunk;
/*     */   }
/*     */ 
/*     */   
/*     */   public void loadEntities(Chunk chunk, NBTTagCompound nbttagcompound, World world) {
/* 353 */     NBTTagList nbttaglist1 = nbttagcompound.getList("Entities", 10);
/*     */     
/* 355 */     if (nbttaglist1 != null) {
/* 356 */       for (int l = 0; l < nbttaglist1.size(); l++) {
/* 357 */         NBTTagCompound nbttagcompound2 = nbttaglist1.get(l);
/* 358 */         Entity entity = EntityTypes.a(nbttagcompound2, world);
/*     */         
/* 360 */         chunk.o = true;
/* 361 */         if (entity != null) {
/* 362 */           chunk.a(entity);
/* 363 */           Entity entity1 = entity;
/*     */           
/* 365 */           for (NBTTagCompound nbttagcompound3 = nbttagcompound2; nbttagcompound3.hasKeyOfType("Riding", 10); nbttagcompound3 = nbttagcompound3.getCompound("Riding")) {
/* 366 */             Entity entity2 = EntityTypes.a(nbttagcompound3.getCompound("Riding"), world);
/*     */             
/* 368 */             if (entity2 != null) {
/* 369 */               chunk.a(entity2);
/* 370 */               entity1.mount(entity2);
/*     */             } 
/*     */             
/* 373 */             entity1 = entity2;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 379 */     NBTTagList nbttaglist2 = nbttagcompound.getList("TileEntities", 10);
/*     */     
/* 381 */     if (nbttaglist2 != null) {
/* 382 */       for (int i1 = 0; i1 < nbttaglist2.size(); i1++) {
/* 383 */         NBTTagCompound nbttagcompound4 = nbttaglist2.get(i1);
/* 384 */         TileEntity tileentity = TileEntity.c(nbttagcompound4);
/*     */         
/* 386 */         if (tileentity != null) {
/* 387 */           chunk.a(tileentity);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 392 */     if (nbttagcompound.hasKeyOfType("TileTicks", 9)) {
/* 393 */       NBTTagList nbttaglist3 = nbttagcompound.getList("TileTicks", 10);
/*     */       
/* 395 */       if (nbttaglist3 != null)
/* 396 */         for (int j1 = 0; j1 < nbttaglist3.size(); j1++) {
/* 397 */           NBTTagCompound nbttagcompound5 = nbttaglist3.get(j1);
/*     */           
/* 399 */           world.b(nbttagcompound5.getInt("x"), nbttagcompound5.getInt("y"), nbttagcompound5.getInt("z"), Block.getById(nbttagcompound5.getInt("i")), nbttagcompound5.getInt("t"), nbttagcompound5.getInt("p"));
/*     */         }  
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ChunkRegionLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */