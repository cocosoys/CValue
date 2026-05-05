/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.Collection;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.bukkit.World;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.chunkio.ChunkIOExecutor;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.util.LongHash;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.util.LongHashSet;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.util.LongObjectHashMap;
/*     */ import org.bukkit.event.Event;
/*     */ import org.bukkit.event.world.ChunkLoadEvent;
/*     */ import org.bukkit.event.world.ChunkPopulateEvent;
/*     */ import org.bukkit.event.world.ChunkUnloadEvent;
/*     */ import org.bukkit.generator.BlockPopulator;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ChunkProviderServer
/*     */   implements IChunkProvider
/*     */ {
/*  28 */   private static final Logger b = LogManager.getLogger();
/*     */   
/*  30 */   public LongHashSet unloadQueue = new LongHashSet();
/*     */   public Chunk emptyChunk;
/*     */   public IChunkProvider chunkProvider;
/*     */   private IChunkLoader f;
/*     */   public boolean forceChunkLoad = false;
/*  35 */   public LongObjectHashMap<Chunk> chunks = new LongObjectHashMap();
/*     */   
/*     */   public WorldServer world;
/*     */   
/*     */   public ChunkProviderServer(WorldServer worldserver, IChunkLoader ichunkloader, IChunkProvider ichunkprovider) {
/*  40 */     this.emptyChunk = new EmptyChunk(worldserver, 0, 0);
/*  41 */     this.world = worldserver;
/*  42 */     this.f = ichunkloader;
/*  43 */     this.chunkProvider = ichunkprovider;
/*     */   }
/*     */   
/*     */   public boolean isChunkLoaded(int i, int j) {
/*  47 */     return this.chunks.containsKey(LongHash.toLong(i, j));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Collection a() {
/*  53 */     return this.chunks.values();
/*     */   }
/*     */ 
/*     */   
/*     */   public void queueUnload(int i, int j) {
/*  58 */     if (this.world.worldProvider.e()) {
/*  59 */       ChunkCoordinates chunkcoordinates = this.world.getSpawn();
/*  60 */       int k = i * 16 + 8 - chunkcoordinates.x;
/*  61 */       int l = j * 16 + 8 - chunkcoordinates.z;
/*  62 */       short short1 = 128;
/*     */ 
/*     */       
/*  65 */       if (k < -short1 || k > short1 || l < -short1 || l > short1 || !this.world.keepSpawnInMemory) {
/*  66 */         this.unloadQueue.add(i, j);
/*     */         
/*  68 */         Chunk c = (Chunk)this.chunks.get(LongHash.toLong(i, j));
/*  69 */         if (c != null) {
/*  70 */           c.mustSave = true;
/*     */         }
/*     */       }
/*     */     
/*     */     } else {
/*     */       
/*  76 */       this.unloadQueue.add(i, j);
/*     */       
/*  78 */       Chunk c = (Chunk)this.chunks.get(LongHash.toLong(i, j));
/*  79 */       if (c != null) {
/*  80 */         c.mustSave = true;
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void b() {
/*  87 */     Iterator<Chunk> iterator = this.chunks.values().iterator();
/*     */     
/*  89 */     while (iterator.hasNext()) {
/*  90 */       Chunk chunk = iterator.next();
/*     */       
/*  92 */       queueUnload(chunk.locX, chunk.locZ);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Chunk getChunkIfLoaded(int x, int z) {
/*  98 */     return (Chunk)this.chunks.get(LongHash.toLong(x, z));
/*     */   }
/*     */   
/*     */   public Chunk getChunkAt(int i, int j) {
/* 102 */     return getChunkAt(i, j, (Runnable)null);
/*     */   }
/*     */   
/*     */   public Chunk getChunkAt(int i, int j, Runnable runnable) {
/* 106 */     this.unloadQueue.remove(i, j);
/* 107 */     Chunk chunk = (Chunk)this.chunks.get(LongHash.toLong(i, j));
/* 108 */     ChunkRegionLoader loader = null;
/*     */     
/* 110 */     if (this.f instanceof ChunkRegionLoader) {
/* 111 */       loader = (ChunkRegionLoader)this.f;
/*     */     }
/*     */ 
/*     */     
/* 115 */     if (chunk == null && loader != null && loader.chunkExists(this.world, i, j)) {
/* 116 */       if (runnable != null) {
/* 117 */         ChunkIOExecutor.queueChunkLoad(this.world, loader, this, i, j, runnable);
/* 118 */         return null;
/*     */       } 
/* 120 */       chunk = ChunkIOExecutor.syncChunkLoad(this.world, loader, this, i, j);
/*     */     }
/* 122 */     else if (chunk == null) {
/* 123 */       chunk = originalGetChunkAt(i, j);
/*     */     } 
/*     */ 
/*     */     
/* 127 */     if (runnable != null) {
/* 128 */       runnable.run();
/*     */     }
/*     */     
/* 131 */     return chunk;
/*     */   }
/*     */   
/*     */   public Chunk originalGetChunkAt(int i, int j) {
/* 135 */     this.unloadQueue.remove(i, j);
/* 136 */     Chunk chunk = (Chunk)this.chunks.get(LongHash.toLong(i, j));
/* 137 */     boolean newChunk = false;
/*     */     
/* 139 */     if (chunk == null) {
/* 140 */       chunk = loadChunk(i, j);
/* 141 */       if (chunk == null) {
/* 142 */         if (this.chunkProvider == null) {
/* 143 */           chunk = this.emptyChunk;
/*     */         } else {
/*     */           try {
/* 146 */             chunk = this.chunkProvider.getOrCreateChunk(i, j);
/* 147 */           } catch (Throwable throwable) {
/* 148 */             CrashReport crashreport = CrashReport.a(throwable, "Exception generating new chunk");
/* 149 */             CrashReportSystemDetails crashreportsystemdetails = crashreport.a("Chunk to be generated");
/*     */             
/* 151 */             crashreportsystemdetails.a("Location", String.format("%d,%d", new Object[] { Integer.valueOf(i), Integer.valueOf(j) }));
/* 152 */             crashreportsystemdetails.a("Position hash", Long.valueOf(LongHash.toLong(i, j)));
/* 153 */             crashreportsystemdetails.a("Generator", this.chunkProvider.getName());
/* 154 */             throw new ReportedException(crashreport);
/*     */           } 
/*     */         } 
/* 157 */         newChunk = true;
/*     */       } 
/*     */       
/* 160 */       this.chunks.put(LongHash.toLong(i, j), chunk);
/* 161 */       chunk.addEntities();
/*     */ 
/*     */       
/* 164 */       CraftServer craftServer = this.world.getServer();
/* 165 */       if (craftServer != null)
/*     */       {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 171 */         craftServer.getPluginManager().callEvent((Event)new ChunkLoadEvent(chunk.bukkitChunk, newChunk));
/*     */       }
/*     */ 
/*     */       
/* 175 */       for (int x = -2; x < 3; x++) {
/* 176 */         for (int z = -2; z < 3; z++) {
/* 177 */           if (x != 0 || z != 0) {
/*     */ 
/*     */ 
/*     */             
/* 181 */             Chunk neighbor = getChunkIfLoaded(chunk.locX + x, chunk.locZ + z);
/* 182 */             if (neighbor != null) {
/* 183 */               neighbor.setNeighborLoaded(-x, -z);
/* 184 */               chunk.setNeighborLoaded(x, z);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 189 */       chunk.loadNearby(this, this, i, j);
/*     */     } 
/*     */     
/* 192 */     return chunk;
/*     */   }
/*     */ 
/*     */   
/*     */   public Chunk getOrCreateChunk(int i, int j) {
/* 197 */     Chunk chunk = (Chunk)this.chunks.get(LongHash.toLong(i, j));
/*     */     
/* 199 */     chunk = (chunk == null) ? ((!this.world.isLoading && !this.forceChunkLoad) ? this.emptyChunk : getChunkAt(i, j)) : chunk;
/* 200 */     if (chunk == this.emptyChunk) return chunk; 
/* 201 */     if (i != chunk.locX || j != chunk.locZ) {
/* 202 */       b.error("Chunk (" + chunk.locX + ", " + chunk.locZ + ") stored at  (" + i + ", " + j + ") in world '" + this.world.getWorld().getName() + "'");
/* 203 */       b.error(chunk.getClass().getName());
/* 204 */       Throwable ex = new Throwable();
/* 205 */       ex.fillInStackTrace();
/* 206 */       ex.printStackTrace();
/*     */     } 
/* 208 */     return chunk;
/*     */   }
/*     */ 
/*     */   
/*     */   public Chunk loadChunk(int i, int j) {
/* 213 */     if (this.f == null) {
/* 214 */       return null;
/*     */     }
/*     */     try {
/* 217 */       Chunk chunk = this.f.a(this.world, i, j);
/*     */       
/* 219 */       if (chunk != null) {
/* 220 */         chunk.lastSaved = this.world.getTime();
/* 221 */         if (this.chunkProvider != null) {
/* 222 */           this.chunkProvider.recreateStructures(i, j);
/*     */         }
/*     */       } 
/*     */       
/* 226 */       return chunk;
/* 227 */     } catch (Exception exception) {
/* 228 */       b.error("Couldn't load chunk", exception);
/* 229 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void saveChunkNOP(Chunk chunk) {
/* 235 */     if (this.f != null) {
/*     */       try {
/* 237 */         this.f.b(this.world, chunk);
/* 238 */       } catch (Exception exception) {
/* 239 */         b.error("Couldn't save entities", exception);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public void saveChunk(Chunk chunk) {
/* 245 */     if (this.f != null) {
/*     */       try {
/* 247 */         chunk.lastSaved = this.world.getTime();
/* 248 */         this.f.a(this.world, chunk);
/*     */       }
/* 250 */       catch (Exception ioexception) {
/* 251 */         b.error("Couldn't save chunk", ioexception);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void getChunkAt(IChunkProvider ichunkprovider, int i, int j) {
/* 261 */     Chunk chunk = getOrCreateChunk(i, j);
/*     */     
/* 263 */     if (!chunk.done) {
/* 264 */       chunk.p();
/* 265 */       if (this.chunkProvider != null) {
/* 266 */         this.chunkProvider.getChunkAt(ichunkprovider, i, j);
/*     */ 
/*     */         
/* 269 */         BlockSand.instaFall = true;
/* 270 */         Random random = new Random();
/* 271 */         random.setSeed(this.world.getSeed());
/* 272 */         long xRand = random.nextLong() / 2L * 2L + 1L;
/* 273 */         long zRand = random.nextLong() / 2L * 2L + 1L;
/* 274 */         random.setSeed(i * xRand + j * zRand ^ this.world.getSeed());
/*     */         
/* 276 */         CraftWorld craftWorld = this.world.getWorld();
/* 277 */         if (craftWorld != null) {
/* 278 */           this.world.populating = true;
/*     */           try {
/* 280 */             for (BlockPopulator populator : craftWorld.getPopulators()) {
/* 281 */               populator.populate((World)craftWorld, random, chunk.bukkitChunk);
/*     */             }
/*     */           } finally {
/* 284 */             this.world.populating = false;
/*     */           } 
/*     */         } 
/* 287 */         BlockSand.instaFall = false;
/* 288 */         this.world.getServer().getPluginManager().callEvent((Event)new ChunkPopulateEvent(chunk.bukkitChunk));
/*     */ 
/*     */         
/* 291 */         chunk.e();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean saveChunks(boolean flag, IProgressUpdate iprogressupdate) {
/* 297 */     int i = 0;
/*     */     
/* 299 */     Iterator<Chunk> iterator = this.chunks.values().iterator();
/*     */     
/* 301 */     while (iterator.hasNext()) {
/* 302 */       Chunk chunk = iterator.next();
/*     */ 
/*     */       
/* 305 */       if (flag) {
/* 306 */         saveChunkNOP(chunk);
/*     */       }
/*     */       
/* 309 */       if (chunk.a(flag)) {
/* 310 */         saveChunk(chunk);
/* 311 */         chunk.n = false;
/* 312 */         i++;
/* 313 */         if (i == 24 && !flag) {
/* 314 */           return false;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 319 */     return true;
/*     */   }
/*     */   
/*     */   public void c() {
/* 323 */     if (this.f != null) {
/* 324 */       this.f.b();
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean unloadChunks() {
/* 329 */     if (!this.world.savingDisabled) {
/*     */       
/* 331 */       CraftServer craftServer = this.world.getServer();
/* 332 */       for (int i = 0; i < 100 && !this.unloadQueue.isEmpty(); i++) {
/* 333 */         long chunkcoordinates = this.unloadQueue.popFirst();
/* 334 */         Chunk chunk = (Chunk)this.chunks.get(chunkcoordinates);
/* 335 */         if (chunk != null) {
/*     */           
/* 337 */           ChunkUnloadEvent event = new ChunkUnloadEvent(chunk.bukkitChunk);
/* 338 */           craftServer.getPluginManager().callEvent((Event)event);
/* 339 */           if (!event.isCancelled()) {
/* 340 */             if (chunk != null) {
/* 341 */               chunk.removeEntities();
/* 342 */               saveChunk(chunk);
/* 343 */               saveChunkNOP(chunk);
/* 344 */               this.chunks.remove(chunkcoordinates);
/*     */             } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 351 */             for (int x = -2; x < 3; x++) {
/* 352 */               for (int z = -2; z < 3; z++) {
/* 353 */                 if (x != 0 || z != 0) {
/*     */ 
/*     */ 
/*     */                   
/* 357 */                   Chunk neighbor = getChunkIfLoaded(chunk.locX + x, chunk.locZ + z);
/* 358 */                   if (neighbor != null) {
/* 359 */                     neighbor.setNeighborUnloaded(-x, -z);
/* 360 */                     chunk.setNeighborUnloaded(x, z);
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 368 */       if (this.f != null) {
/* 369 */         this.f.a();
/*     */       }
/*     */     } 
/*     */     
/* 373 */     return this.chunkProvider.unloadChunks();
/*     */   }
/*     */   
/*     */   public boolean canSave() {
/* 377 */     return !this.world.savingDisabled;
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 382 */     return "ServerChunkCache: " + this.chunks.values().size() + " Drop: " + this.unloadQueue.size();
/*     */   }
/*     */   
/*     */   public List getMobsFor(EnumCreatureType enumcreaturetype, int i, int j, int k) {
/* 386 */     return this.chunkProvider.getMobsFor(enumcreaturetype, i, j, k);
/*     */   }
/*     */   
/*     */   public ChunkPosition findNearestMapFeature(World world, String s, int i, int j, int k) {
/* 390 */     return this.chunkProvider.findNearestMapFeature(world, s, i, j, k);
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLoadedChunks() {
/* 395 */     return this.chunks.size();
/*     */   }
/*     */   
/*     */   public void recreateStructures(int i, int j) {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ChunkProviderServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */