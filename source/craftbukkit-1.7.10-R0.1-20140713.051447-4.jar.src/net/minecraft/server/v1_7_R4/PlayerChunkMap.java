/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Comparator;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedList;
/*     */ import java.util.List;
/*     */ import java.util.Queue;
/*     */ import java.util.concurrent.ConcurrentLinkedQueue;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PlayerChunkMap
/*     */ {
/*  18 */   private static final Logger a = LogManager.getLogger();
/*     */   private final WorldServer world;
/*  20 */   private final List managedPlayers = new ArrayList();
/*  21 */   private final LongHashMap d = new LongHashMap();
/*  22 */   private final Queue e = new ConcurrentLinkedQueue();
/*  23 */   private final Queue f = new ConcurrentLinkedQueue();
/*     */   private int g;
/*     */   private long h;
/*  26 */   private final int[][] i = new int[][] { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
/*     */   private boolean wasNotEmpty;
/*     */   
/*     */   public PlayerChunkMap(WorldServer worldserver) {
/*  30 */     this.world = worldserver;
/*  31 */     a(worldserver.getMinecraftServer().getPlayerList().s());
/*     */   }
/*     */   
/*     */   public WorldServer a() {
/*  35 */     return this.world;
/*     */   }
/*     */   
/*     */   public void flush() {
/*  39 */     long i = this.world.getTime();
/*     */ 
/*     */ 
/*     */     
/*  43 */     if (i - this.h > 8000L) {
/*  44 */       this.h = i;
/*     */ 
/*     */       
/*  47 */       Iterator<PlayerChunk> iterator = this.f.iterator();
/*  48 */       while (iterator.hasNext()) {
/*  49 */         PlayerChunk playerchunk = iterator.next();
/*  50 */         playerchunk.b();
/*  51 */         playerchunk.a();
/*     */       } 
/*     */     } else {
/*  54 */       Iterator<PlayerChunk> iterator = this.e.iterator();
/*     */       
/*  56 */       while (iterator.hasNext()) {
/*  57 */         PlayerChunk playerchunk = iterator.next();
/*  58 */         playerchunk.b();
/*  59 */         iterator.remove();
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  65 */     if (this.managedPlayers.isEmpty()) {
/*  66 */       if (!this.wasNotEmpty)
/*  67 */         return;  WorldProvider worldprovider = this.world.worldProvider;
/*     */       
/*  69 */       if (!worldprovider.e()) {
/*  70 */         this.world.chunkProviderServer.b();
/*     */       }
/*     */       
/*  73 */       this.wasNotEmpty = false;
/*     */     } else {
/*  75 */       this.wasNotEmpty = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(int i, int j) {
/*  81 */     long k = i + 2147483647L | j + 2147483647L << 32L;
/*     */     
/*  83 */     return (this.d.getEntry(k) != null);
/*     */   }
/*     */   
/*     */   private PlayerChunk a(int i, int j, boolean flag) {
/*  87 */     long k = i + 2147483647L | j + 2147483647L << 32L;
/*  88 */     PlayerChunk playerchunk = (PlayerChunk)this.d.getEntry(k);
/*     */     
/*  90 */     if (playerchunk == null && flag) {
/*  91 */       playerchunk = new PlayerChunk(this, i, j);
/*  92 */       this.d.put(k, playerchunk);
/*  93 */       this.f.add(playerchunk);
/*     */     } 
/*     */     
/*  96 */     return playerchunk;
/*     */   }
/*     */   
/*     */   public final boolean isChunkInUse(int x, int z) {
/* 100 */     PlayerChunk pi = a(x, z, false);
/* 101 */     if (pi != null) {
/* 102 */       return (PlayerChunk.b(pi).size() > 0);
/*     */     }
/* 104 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void flagDirty(int i, int j, int k) {
/* 109 */     int l = i >> 4;
/* 110 */     int i1 = k >> 4;
/* 111 */     PlayerChunk playerchunk = a(l, i1, false);
/*     */     
/* 113 */     if (playerchunk != null) {
/* 114 */       playerchunk.a(i & 0xF, j, k & 0xF);
/*     */     }
/*     */   }
/*     */   
/*     */   public void addPlayer(EntityPlayer entityplayer) {
/* 119 */     int i = (int)entityplayer.locX >> 4;
/* 120 */     int j = (int)entityplayer.locZ >> 4;
/*     */     
/* 122 */     entityplayer.d = entityplayer.locX;
/* 123 */     entityplayer.e = entityplayer.locZ;
/*     */ 
/*     */     
/* 126 */     List<ChunkCoordIntPair> chunkList = new LinkedList<ChunkCoordIntPair>();
/* 127 */     for (int k = i - this.g; k <= i + this.g; k++) {
/* 128 */       for (int l = j - this.g; l <= j + this.g; l++) {
/* 129 */         chunkList.add(new ChunkCoordIntPair(k, l));
/*     */       }
/*     */     } 
/*     */     
/* 133 */     Collections.sort(chunkList, new ChunkCoordComparator(entityplayer));
/* 134 */     for (ChunkCoordIntPair pair : chunkList) {
/* 135 */       a(pair.x, pair.z, true).a(entityplayer);
/*     */     }
/*     */ 
/*     */     
/* 139 */     this.managedPlayers.add(entityplayer);
/* 140 */     b(entityplayer);
/*     */   }
/*     */   
/*     */   public void b(EntityPlayer entityplayer) {
/* 144 */     ArrayList arraylist = new ArrayList(entityplayer.chunkCoordIntPairQueue);
/* 145 */     int i = 0;
/* 146 */     int j = this.g;
/* 147 */     int k = (int)entityplayer.locX >> 4;
/* 148 */     int l = (int)entityplayer.locZ >> 4;
/* 149 */     int i1 = 0;
/* 150 */     int j1 = 0;
/* 151 */     ChunkCoordIntPair chunkcoordintpair = PlayerChunk.a(a(k, l, true));
/*     */     
/* 153 */     entityplayer.chunkCoordIntPairQueue.clear();
/* 154 */     if (arraylist.contains(chunkcoordintpair)) {
/* 155 */       entityplayer.chunkCoordIntPairQueue.add(chunkcoordintpair);
/*     */     }
/*     */     
/*     */     int k1;
/*     */     
/* 160 */     for (k1 = 1; k1 <= j * 2; k1++) {
/* 161 */       for (int l1 = 0; l1 < 2; l1++) {
/* 162 */         int[] aint = this.i[i++ % 4];
/*     */         
/* 164 */         for (int i2 = 0; i2 < k1; i2++) {
/* 165 */           i1 += aint[0];
/* 166 */           j1 += aint[1];
/* 167 */           chunkcoordintpair = PlayerChunk.a(a(k + i1, l + j1, true));
/* 168 */           if (arraylist.contains(chunkcoordintpair)) {
/* 169 */             entityplayer.chunkCoordIntPairQueue.add(chunkcoordintpair);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 175 */     i %= 4;
/*     */     
/* 177 */     for (k1 = 0; k1 < j * 2; k1++) {
/* 178 */       i1 += this.i[i][0];
/* 179 */       j1 += this.i[i][1];
/* 180 */       chunkcoordintpair = PlayerChunk.a(a(k + i1, l + j1, true));
/* 181 */       if (arraylist.contains(chunkcoordintpair)) {
/* 182 */         entityplayer.chunkCoordIntPairQueue.add(chunkcoordintpair);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public void removePlayer(EntityPlayer entityplayer) {
/* 188 */     int i = (int)entityplayer.d >> 4;
/* 189 */     int j = (int)entityplayer.e >> 4;
/*     */     
/* 191 */     for (int k = i - this.g; k <= i + this.g; k++) {
/* 192 */       for (int l = j - this.g; l <= j + this.g; l++) {
/* 193 */         PlayerChunk playerchunk = a(k, l, false);
/*     */         
/* 195 */         if (playerchunk != null) {
/* 196 */           playerchunk.b(entityplayer);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 201 */     this.managedPlayers.remove(entityplayer);
/*     */   }
/*     */   
/*     */   private boolean a(int i, int j, int k, int l, int i1) {
/* 205 */     int j1 = i - k;
/* 206 */     int k1 = j - l;
/*     */     
/* 208 */     return (j1 >= -i1 && j1 <= i1) ? ((k1 >= -i1 && k1 <= i1)) : false;
/*     */   }
/*     */   
/*     */   public void movePlayer(EntityPlayer entityplayer) {
/* 212 */     int i = (int)entityplayer.locX >> 4;
/* 213 */     int j = (int)entityplayer.locZ >> 4;
/* 214 */     double d0 = entityplayer.d - entityplayer.locX;
/* 215 */     double d1 = entityplayer.e - entityplayer.locZ;
/* 216 */     double d2 = d0 * d0 + d1 * d1;
/*     */     
/* 218 */     if (d2 >= 64.0D) {
/* 219 */       int k = (int)entityplayer.d >> 4;
/* 220 */       int l = (int)entityplayer.e >> 4;
/* 221 */       int i1 = this.g;
/* 222 */       int j1 = i - k;
/* 223 */       int k1 = j - l;
/* 224 */       List<ChunkCoordIntPair> chunksToLoad = new LinkedList<ChunkCoordIntPair>();
/*     */       
/* 226 */       if (j1 != 0 || k1 != 0) {
/* 227 */         for (int l1 = i - i1; l1 <= i + i1; l1++) {
/* 228 */           for (int i2 = j - i1; i2 <= j + i1; i2++) {
/* 229 */             if (!a(l1, i2, k, l, i1)) {
/* 230 */               chunksToLoad.add(new ChunkCoordIntPair(l1, i2));
/*     */             }
/*     */             
/* 233 */             if (!a(l1 - j1, i2 - k1, i, j, i1)) {
/* 234 */               PlayerChunk playerchunk = a(l1 - j1, i2 - k1, false);
/*     */               
/* 236 */               if (playerchunk != null) {
/* 237 */                 playerchunk.b(entityplayer);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 243 */         b(entityplayer);
/* 244 */         entityplayer.d = entityplayer.locX;
/* 245 */         entityplayer.e = entityplayer.locZ;
/*     */ 
/*     */         
/* 248 */         Collections.sort(chunksToLoad, new ChunkCoordComparator(entityplayer));
/* 249 */         for (ChunkCoordIntPair pair : chunksToLoad) {
/* 250 */           a(pair.x, pair.z, true).a(entityplayer);
/*     */         }
/*     */         
/* 253 */         if (i1 > 1 || i1 < -1 || j1 > 1 || j1 < -1) {
/* 254 */           Collections.sort(entityplayer.chunkCoordIntPairQueue, new ChunkCoordComparator(entityplayer));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean a(EntityPlayer entityplayer, int i, int j) {
/* 262 */     PlayerChunk playerchunk = a(i, j, false);
/*     */     
/* 264 */     return (playerchunk != null && PlayerChunk.b(playerchunk).contains(entityplayer) && !entityplayer.chunkCoordIntPairQueue.contains(PlayerChunk.a(playerchunk)));
/*     */   }
/*     */   
/*     */   public void a(int i) {
/* 268 */     i = MathHelper.a(i, 3, 20);
/* 269 */     if (i != this.g) {
/* 270 */       int j = i - this.g;
/* 271 */       Iterator<EntityPlayer> iterator = this.managedPlayers.iterator();
/*     */       
/* 273 */       while (iterator.hasNext()) {
/* 274 */         EntityPlayer entityplayer = iterator.next();
/* 275 */         int k = (int)entityplayer.locX >> 4;
/* 276 */         int l = (int)entityplayer.locZ >> 4;
/*     */ 
/*     */ 
/*     */         
/* 280 */         if (j > 0) {
/* 281 */           for (int m = k - i; m <= k + i; m++) {
/* 282 */             for (int j1 = l - i; j1 <= l + i; j1++) {
/* 283 */               PlayerChunk playerchunk = a(m, j1, true);
/*     */               
/* 285 */               if (!PlayerChunk.b(playerchunk).contains(entityplayer))
/* 286 */                 playerchunk.a(entityplayer); 
/*     */             } 
/*     */           } 
/*     */           continue;
/*     */         } 
/* 291 */         for (int i1 = k - this.g; i1 <= k + this.g; i1++) {
/* 292 */           for (int j1 = l - this.g; j1 <= l + this.g; j1++) {
/* 293 */             if (!a(i1, j1, k, l, i)) {
/* 294 */               a(i1, j1, true).b(entityplayer);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 301 */       this.g = i;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static int getFurthestViewableBlock(int i) {
/* 306 */     return i * 16 - 16;
/*     */   }
/*     */   
/*     */   static Logger c() {
/* 310 */     return a;
/*     */   }
/*     */   
/*     */   static WorldServer a(PlayerChunkMap playerchunkmap) {
/* 314 */     return playerchunkmap.world;
/*     */   }
/*     */   
/*     */   static LongHashMap b(PlayerChunkMap playerchunkmap) {
/* 318 */     return playerchunkmap.d;
/*     */   }
/*     */   
/*     */   static Queue c(PlayerChunkMap playermanager) {
/* 322 */     return playermanager.f;
/*     */   }
/*     */   
/*     */   static Queue d(PlayerChunkMap playermanager) {
/* 326 */     return playermanager.e;
/*     */   }
/*     */   
/*     */   private static class ChunkCoordComparator
/*     */     implements Comparator<ChunkCoordIntPair> {
/*     */     private int x;
/*     */     private int z;
/*     */     
/*     */     public ChunkCoordComparator(EntityPlayer entityplayer) {
/* 335 */       this.x = (int)entityplayer.locX >> 4;
/* 336 */       this.z = (int)entityplayer.locZ >> 4;
/*     */     }
/*     */     
/*     */     public int compare(ChunkCoordIntPair a, ChunkCoordIntPair b) {
/* 340 */       if (a.equals(b)) {
/* 341 */         return 0;
/*     */       }
/*     */ 
/*     */       
/* 345 */       int ax = a.x - this.x;
/* 346 */       int az = a.z - this.z;
/* 347 */       int bx = b.x - this.x;
/* 348 */       int bz = b.z - this.z;
/*     */       
/* 350 */       int result = (ax - bx) * (ax + bx) + (az - bz) * (az + bz);
/* 351 */       if (result != 0) {
/* 352 */         return result;
/*     */       }
/*     */       
/* 355 */       if (ax < 0) {
/* 356 */         if (bx < 0) {
/* 357 */           return bz - az;
/*     */         }
/* 359 */         return -1;
/*     */       } 
/*     */       
/* 362 */       if (bx < 0) {
/* 363 */         return 1;
/*     */       }
/* 365 */       return az - bz;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PlayerChunkMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */