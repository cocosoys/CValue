/*      */ package net.minecraft.server.v1_7_R4;
/*      */ 
/*      */ import java.util.Arrays;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Random;
/*      */ import org.apache.logging.log4j.LogManager;
/*      */ import org.apache.logging.log4j.Logger;
/*      */ import org.bukkit.Bukkit;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.CraftChunk;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.util.CraftMagicNumbers;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.util.UnsafeList;
/*      */ 
/*      */ 
/*      */ public class Chunk
/*      */ {
/*   19 */   private static final Logger t = LogManager.getLogger();
/*      */   
/*      */   public static boolean a;
/*      */   
/*      */   private ChunkSection[] sections;
/*      */   private byte[] v;
/*      */   public int[] b;
/*      */   public boolean[] c;
/*      */   public boolean d;
/*      */   public World world;
/*      */   public int[] heightMap;
/*      */   public final int locX;
/*      */   public final int locZ;
/*      */   private boolean w;
/*      */   public Map tileEntities;
/*      */   public List[] entitySlices;
/*      */   public boolean done;
/*      */   public boolean lit;
/*      */   public boolean m;
/*      */   public boolean n;
/*      */   public boolean o;
/*      */   public long lastSaved;
/*      */   public boolean q;
/*      */   public int r;
/*      */   public long s;
/*      */   private int x;
/*   45 */   private int neighbors = 4096; public org.bukkit.Chunk bukkitChunk;
/*      */   public boolean areNeighborsLoaded(int radius) {
/*      */     int mask;
/*   48 */     switch (radius) {
/*      */       case 2:
/*   50 */         return (this.neighbors == 33554431);
/*      */       case 1:
/*   52 */         mask = 473536;
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*   57 */         return ((this.neighbors & 0x739C0) == 473536);
/*      */     } 
/*   59 */     throw new UnsupportedOperationException(String.valueOf(radius));
/*      */   }
/*      */   public boolean mustSave;
/*      */   
/*      */   public void setNeighborLoaded(int x, int z) {
/*   64 */     this.neighbors |= 1 << x * 5 + 12 + z;
/*      */   }
/*      */   
/*      */   public void setNeighborUnloaded(int x, int z) {
/*   68 */     this.neighbors &= 1 << x * 5 + 12 + z ^ 0xFFFFFFFF;
/*      */   }
/*      */ 
/*      */   
/*      */   public Chunk(World world, int i, int j) {
/*   73 */     this.sections = new ChunkSection[16];
/*   74 */     this.v = new byte[256];
/*   75 */     this.b = new int[256];
/*   76 */     this.c = new boolean[256];
/*   77 */     this.tileEntities = new HashMap<Object, Object>();
/*   78 */     this.x = 4096;
/*   79 */     this.entitySlices = new List[16];
/*   80 */     this.world = world;
/*   81 */     this.locX = i;
/*   82 */     this.locZ = j;
/*   83 */     this.heightMap = new int[256];
/*      */     
/*   85 */     for (int k = 0; k < this.entitySlices.length; k++) {
/*   86 */       this.entitySlices[k] = (List)new UnsafeList();
/*      */     }
/*      */     
/*   89 */     Arrays.fill(this.b, -999);
/*   90 */     Arrays.fill(this.v, (byte)-1);
/*      */ 
/*      */     
/*   93 */     if (!(this instanceof EmptyChunk)) {
/*   94 */       this.bukkitChunk = (org.bukkit.Chunk)new CraftChunk(this);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Chunk(World world, Block[] ablock, int i, int j) {
/*  103 */     this(world, i, j);
/*  104 */     int k = ablock.length / 256;
/*  105 */     boolean flag = !world.worldProvider.g;
/*      */     
/*  107 */     for (int l = 0; l < 16; l++) {
/*  108 */       for (int i1 = 0; i1 < 16; i1++) {
/*  109 */         for (int j1 = 0; j1 < k; j1++) {
/*  110 */           Block block = ablock[l << 11 | i1 << 7 | j1];
/*      */           
/*  112 */           if (block != null && block.getMaterial() != Material.AIR) {
/*  113 */             int k1 = j1 >> 4;
/*      */             
/*  115 */             if (this.sections[k1] == null) {
/*  116 */               this.sections[k1] = new ChunkSection(k1 << 4, flag);
/*      */             }
/*      */             
/*  119 */             this.sections[k1].setTypeId(l, j1 & 0xF, i1, block);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public Chunk(World world, Block[] ablock, byte[] abyte, int i, int j) {
/*  127 */     this(world, i, j);
/*  128 */     int k = ablock.length / 256;
/*  129 */     boolean flag = !world.worldProvider.g;
/*      */     
/*  131 */     for (int l = 0; l < 16; l++) {
/*  132 */       for (int i1 = 0; i1 < 16; i1++) {
/*  133 */         for (int j1 = 0; j1 < k; j1++) {
/*  134 */           int k1 = l * k * 16 | i1 * k | j1;
/*  135 */           Block block = ablock[k1];
/*      */           
/*  137 */           if (block != null && block != Blocks.AIR) {
/*  138 */             int l1 = j1 >> 4;
/*      */             
/*  140 */             if (this.sections[l1] == null) {
/*  141 */               this.sections[l1] = new ChunkSection(l1 << 4, flag);
/*      */             }
/*      */             
/*  144 */             this.sections[l1].setTypeId(l, j1 & 0xF, i1, block);
/*  145 */             this.sections[l1].setData(l, j1 & 0xF, i1, abyte[k1]);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean a(int i, int j) {
/*  153 */     return (i == this.locX && j == this.locZ);
/*      */   }
/*      */   
/*      */   public int b(int i, int j) {
/*  157 */     return this.heightMap[j << 4 | i];
/*      */   }
/*      */   
/*      */   public int h() {
/*  161 */     for (int i = this.sections.length - 1; i >= 0; i--) {
/*  162 */       if (this.sections[i] != null) {
/*  163 */         return this.sections[i].getYPosition();
/*      */       }
/*      */     } 
/*      */     
/*  167 */     return 0;
/*      */   }
/*      */   
/*      */   public ChunkSection[] getSections() {
/*  171 */     return this.sections;
/*      */   }
/*      */   
/*      */   public void initLighting() {
/*  175 */     int i = h();
/*      */     
/*  177 */     this.r = Integer.MAX_VALUE;
/*      */     
/*  179 */     for (int j = 0; j < 16; j++) {
/*  180 */       int k = 0;
/*      */       
/*  182 */       while (k < 16) {
/*  183 */         this.b[j + (k << 4)] = -999;
/*  184 */         int l = i + 16 - 1;
/*      */ 
/*      */         
/*  187 */         while (l > 0) {
/*  188 */           if (b(j, l - 1, k) == 0) {
/*  189 */             l--;
/*      */             
/*      */             continue;
/*      */           } 
/*  193 */           this.heightMap[k << 4 | j] = l;
/*  194 */           if (l < this.r) {
/*  195 */             this.r = l;
/*      */           }
/*      */         } 
/*      */         
/*  199 */         if (!this.world.worldProvider.g) {
/*  200 */           l = 15;
/*  201 */           int i1 = i + 16 - 1;
/*      */           
/*      */           do {
/*  204 */             int j1 = b(j, i1, k);
/*      */             
/*  206 */             if (j1 == 0 && l != 15) {
/*  207 */               j1 = 1;
/*      */             }
/*      */             
/*  210 */             l -= j1;
/*  211 */             if (l <= 0)
/*  212 */               continue;  ChunkSection chunksection = this.sections[i1 >> 4];
/*      */             
/*  214 */             if (chunksection == null)
/*  215 */               continue;  chunksection.setSkyLight(j, i1 & 0xF, k, l);
/*  216 */             this.world.m((this.locX << 4) + j, i1, (this.locZ << 4) + k);
/*      */ 
/*      */ 
/*      */             
/*  220 */             --i1;
/*  221 */           } while (i1 > 0 && l > 0);
/*      */         } 
/*      */         
/*  224 */         k++;
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  230 */     this.n = true;
/*      */   }
/*      */   
/*      */   private void e(int i, int j) {
/*  234 */     this.c[i + j * 16] = true;
/*  235 */     this.w = true;
/*      */   }
/*      */   
/*      */   private void c(boolean flag) {
/*  239 */     this.world.methodProfiler.a("recheckGaps");
/*  240 */     if (this.world.areChunksLoaded(this.locX * 16 + 8, 0, this.locZ * 16 + 8, 16)) {
/*  241 */       for (int i = 0; i < 16; i++) {
/*  242 */         for (int j = 0; j < 16; j++) {
/*  243 */           if (this.c[i + j * 16]) {
/*  244 */             this.c[i + j * 16] = false;
/*  245 */             int k = b(i, j);
/*  246 */             int l = this.locX * 16 + i;
/*  247 */             int i1 = this.locZ * 16 + j;
/*  248 */             int j1 = this.world.g(l - 1, i1);
/*  249 */             int k1 = this.world.g(l + 1, i1);
/*  250 */             int l1 = this.world.g(l, i1 - 1);
/*  251 */             int i2 = this.world.g(l, i1 + 1);
/*      */             
/*  253 */             if (k1 < j1) {
/*  254 */               j1 = k1;
/*      */             }
/*      */             
/*  257 */             if (l1 < j1) {
/*  258 */               j1 = l1;
/*      */             }
/*      */             
/*  261 */             if (i2 < j1) {
/*  262 */               j1 = i2;
/*      */             }
/*      */             
/*  265 */             g(l, i1, j1);
/*  266 */             g(l - 1, i1, k);
/*  267 */             g(l + 1, i1, k);
/*  268 */             g(l, i1 - 1, k);
/*  269 */             g(l, i1 + 1, k);
/*  270 */             if (flag) {
/*  271 */               this.world.methodProfiler.b();
/*      */               
/*      */               return;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*  278 */       this.w = false;
/*      */     } 
/*      */     
/*  281 */     this.world.methodProfiler.b();
/*      */   }
/*      */   
/*      */   private void g(int i, int j, int k) {
/*  285 */     int l = this.world.getHighestBlockYAt(i, j);
/*      */     
/*  287 */     if (l > k) {
/*  288 */       c(i, j, k, l + 1);
/*  289 */     } else if (l < k) {
/*  290 */       c(i, j, l, k + 1);
/*      */     } 
/*      */   }
/*      */   
/*      */   private void c(int i, int j, int k, int l) {
/*  295 */     if (l > k && this.world.areChunksLoaded(i, 0, j, 16)) {
/*  296 */       for (int i1 = k; i1 < l; i1++) {
/*  297 */         this.world.c(EnumSkyBlock.SKY, i, i1, j);
/*      */       }
/*      */       
/*  300 */       this.n = true;
/*      */     } 
/*      */   }
/*      */   
/*      */   private void h(int i, int j, int k) {
/*  305 */     int l = this.heightMap[k << 4 | i] & 0xFF;
/*  306 */     int i1 = l;
/*      */     
/*  308 */     if (j > l) {
/*  309 */       i1 = j;
/*      */     }
/*      */     
/*  312 */     while (i1 > 0 && b(i, i1 - 1, k) == 0) {
/*  313 */       i1--;
/*      */     }
/*      */     
/*  316 */     if (i1 != l) {
/*  317 */       this.world.b(i + this.locX * 16, k + this.locZ * 16, i1, l);
/*  318 */       this.heightMap[k << 4 | i] = i1;
/*  319 */       int j1 = this.locX * 16 + i;
/*  320 */       int k1 = this.locZ * 16 + k;
/*      */ 
/*      */ 
/*      */       
/*  324 */       if (!this.world.worldProvider.g) {
/*      */ 
/*      */         
/*  327 */         if (i1 < l) {
/*  328 */           for (int n = i1; n < l; n++) {
/*  329 */             ChunkSection chunksection = this.sections[n >> 4];
/*  330 */             if (chunksection != null) {
/*  331 */               chunksection.setSkyLight(i, n & 0xF, k, 15);
/*  332 */               this.world.m((this.locX << 4) + i, n, (this.locZ << 4) + k);
/*      */             } 
/*      */           } 
/*      */         } else {
/*  336 */           for (int n = l; n < i1; n++) {
/*  337 */             ChunkSection chunksection = this.sections[n >> 4];
/*  338 */             if (chunksection != null) {
/*  339 */               chunksection.setSkyLight(i, n & 0xF, k, 0);
/*  340 */               this.world.m((this.locX << 4) + i, n, (this.locZ << 4) + k);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */         
/*  345 */         int m = 15;
/*      */         
/*  347 */         while (i1 > 0 && m > 0) {
/*  348 */           i1--;
/*  349 */           int n = b(i, i1, k);
/*  350 */           if (n == 0) {
/*  351 */             n = 1;
/*      */           }
/*      */           
/*  354 */           m -= n;
/*  355 */           if (m < 0) {
/*  356 */             m = 0;
/*      */           }
/*      */           
/*  359 */           ChunkSection chunksection1 = this.sections[i1 >> 4];
/*      */           
/*  361 */           if (chunksection1 != null) {
/*  362 */             chunksection1.setSkyLight(i, i1 & 0xF, k, m);
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/*  367 */       int l1 = this.heightMap[k << 4 | i];
/*  368 */       int i2 = l;
/*  369 */       int j2 = l1;
/*      */       
/*  371 */       if (l1 < l) {
/*  372 */         i2 = l1;
/*  373 */         j2 = l;
/*      */       } 
/*      */       
/*  376 */       if (l1 < this.r) {
/*  377 */         this.r = l1;
/*      */       }
/*      */       
/*  380 */       if (!this.world.worldProvider.g) {
/*  381 */         c(j1 - 1, k1, i2, j2);
/*  382 */         c(j1 + 1, k1, i2, j2);
/*  383 */         c(j1, k1 - 1, i2, j2);
/*  384 */         c(j1, k1 + 1, i2, j2);
/*  385 */         c(j1, k1, i2, j2);
/*      */       } 
/*      */       
/*  388 */       this.n = true;
/*      */     } 
/*      */   }
/*      */   
/*      */   public int b(int i, int j, int k) {
/*  393 */     return getType(i, j, k).k();
/*      */   }
/*      */   
/*      */   public Block getType(int i, int j, int k) {
/*  397 */     Block block = Blocks.AIR;
/*      */     
/*  399 */     if (j >> 4 < this.sections.length) {
/*  400 */       ChunkSection chunksection = this.sections[j >> 4];
/*      */       
/*  402 */       if (chunksection != null) {
/*      */         try {
/*  404 */           block = chunksection.getTypeId(i, j & 0xF, k);
/*  405 */         } catch (Throwable throwable) {
/*  406 */           CrashReport crashreport = CrashReport.a(throwable, "Getting block");
/*  407 */           CrashReportSystemDetails crashreportsystemdetails = crashreport.a("Block being got");
/*      */           
/*  409 */           crashreportsystemdetails.a("Location", new CrashReportLocation(this, i, j, k));
/*  410 */           throw new ReportedException(crashreport);
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/*  415 */     return block;
/*      */   }
/*      */   
/*      */   public int getData(int i, int j, int k) {
/*  419 */     if (j >> 4 >= this.sections.length) {
/*  420 */       return 0;
/*      */     }
/*  422 */     ChunkSection chunksection = this.sections[j >> 4];
/*      */     
/*  424 */     return (chunksection != null) ? chunksection.getData(i, j & 0xF, k) : 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean a(int i, int j, int k, Block block, int l) {
/*  429 */     int i1 = k << 4 | i;
/*      */     
/*  431 */     if (j >= this.b[i1] - 1) {
/*  432 */       this.b[i1] = -999;
/*      */     }
/*      */     
/*  435 */     int j1 = this.heightMap[i1];
/*  436 */     Block block1 = getType(i, j, k);
/*  437 */     int k1 = getData(i, j, k);
/*      */     
/*  439 */     if (block1 == block && k1 == l) {
/*  440 */       return false;
/*      */     }
/*  442 */     ChunkSection chunksection = this.sections[j >> 4];
/*  443 */     boolean flag = false;
/*      */     
/*  445 */     if (chunksection == null) {
/*  446 */       if (block == Blocks.AIR) {
/*  447 */         return false;
/*      */       }
/*      */       
/*  450 */       chunksection = this.sections[j >> 4] = new ChunkSection(j >> 4 << 4, !this.world.worldProvider.g);
/*  451 */       flag = (j >= j1);
/*      */     } 
/*      */     
/*  454 */     int l1 = this.locX * 16 + i;
/*  455 */     int i2 = this.locZ * 16 + k;
/*      */     
/*  457 */     if (!this.world.isStatic) {
/*  458 */       block1.f(this.world, l1, j, i2, k1);
/*      */     }
/*      */ 
/*      */     
/*  462 */     if (!(block1 instanceof IContainer)) {
/*  463 */       chunksection.setTypeId(i, j & 0xF, k, block);
/*      */     }
/*      */ 
/*      */     
/*  467 */     if (!this.world.isStatic) {
/*  468 */       block1.remove(this.world, l1, j, i2, block1, k1);
/*  469 */     } else if (block1 instanceof IContainer && block1 != block) {
/*  470 */       this.world.p(l1, j, i2);
/*      */     } 
/*      */ 
/*      */     
/*  474 */     if (block1 instanceof IContainer) {
/*  475 */       chunksection.setTypeId(i, j & 0xF, k, block);
/*      */     }
/*      */ 
/*      */     
/*  479 */     if (chunksection.getTypeId(i, j & 0xF, k) != block) {
/*  480 */       return false;
/*      */     }
/*  482 */     chunksection.setData(i, j & 0xF, k, l);
/*  483 */     if (flag) {
/*  484 */       initLighting();
/*      */     } else {
/*  486 */       int j2 = block.k();
/*  487 */       int k2 = block1.k();
/*      */       
/*  489 */       if (j2 > 0) {
/*  490 */         if (j >= j1) {
/*  491 */           h(i, j + 1, k);
/*      */         }
/*  493 */       } else if (j == j1 - 1) {
/*  494 */         h(i, j, k);
/*      */       } 
/*      */       
/*  497 */       if (j2 != k2 && (j2 < k2 || getBrightness(EnumSkyBlock.SKY, i, j, k) > 0 || getBrightness(EnumSkyBlock.BLOCK, i, j, k) > 0)) {
/*  498 */         e(i, k);
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  504 */     if (block1 instanceof IContainer) {
/*  505 */       TileEntity tileentity = e(i, j, k);
/*  506 */       if (tileentity != null) {
/*  507 */         tileentity.u();
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  512 */     if (!this.world.isStatic && (!this.world.captureBlockStates || block instanceof BlockContainer)) {
/*  513 */       block.onPlace(this.world, l1, j, i2);
/*      */     }
/*      */     
/*  516 */     if (block instanceof IContainer) {
/*      */       
/*  518 */       TileEntity tileentity = e(i, j, k);
/*  519 */       if (tileentity == null) {
/*  520 */         tileentity = ((IContainer)block).a(this.world, l);
/*  521 */         this.world.setTileEntity(l1, j, i2, tileentity);
/*      */       } 
/*      */       
/*  524 */       if (tileentity != null) {
/*  525 */         tileentity.u();
/*      */       }
/*      */     } 
/*      */     
/*  529 */     this.n = true;
/*  530 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean a(int i, int j, int k, int l) {
/*  536 */     ChunkSection chunksection = this.sections[j >> 4];
/*      */     
/*  538 */     if (chunksection == null) {
/*  539 */       return false;
/*      */     }
/*  541 */     int i1 = chunksection.getData(i, j & 0xF, k);
/*      */     
/*  543 */     if (i1 == l) {
/*  544 */       return false;
/*      */     }
/*  546 */     this.n = true;
/*  547 */     chunksection.setData(i, j & 0xF, k, l);
/*  548 */     if (chunksection.getTypeId(i, j & 0xF, k) instanceof IContainer) {
/*  549 */       TileEntity tileentity = e(i, j, k);
/*      */       
/*  551 */       if (tileentity != null) {
/*  552 */         tileentity.u();
/*  553 */         tileentity.g = l;
/*      */       } 
/*      */     } 
/*      */     
/*  557 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getBrightness(EnumSkyBlock enumskyblock, int i, int j, int k) {
/*  563 */     ChunkSection chunksection = this.sections[j >> 4];
/*      */     
/*  565 */     return (chunksection == null) ? (d(i, j, k) ? enumskyblock.c : 0) : ((enumskyblock == EnumSkyBlock.SKY) ? (this.world.worldProvider.g ? 0 : chunksection.getSkyLight(i, j & 0xF, k)) : ((enumskyblock == EnumSkyBlock.BLOCK) ? chunksection.getEmittedLight(i, j & 0xF, k) : enumskyblock.c));
/*      */   }
/*      */   
/*      */   public void a(EnumSkyBlock enumskyblock, int i, int j, int k, int l) {
/*  569 */     ChunkSection chunksection = this.sections[j >> 4];
/*      */     
/*  571 */     if (chunksection == null) {
/*  572 */       chunksection = this.sections[j >> 4] = new ChunkSection(j >> 4 << 4, !this.world.worldProvider.g);
/*  573 */       initLighting();
/*      */     } 
/*      */     
/*  576 */     this.n = true;
/*  577 */     if (enumskyblock == EnumSkyBlock.SKY) {
/*  578 */       if (!this.world.worldProvider.g) {
/*  579 */         chunksection.setSkyLight(i, j & 0xF, k, l);
/*      */       }
/*  581 */     } else if (enumskyblock == EnumSkyBlock.BLOCK) {
/*  582 */       chunksection.setEmittedLight(i, j & 0xF, k, l);
/*      */     } 
/*      */   }
/*      */   
/*      */   public int b(int i, int j, int k, int l) {
/*  587 */     ChunkSection chunksection = this.sections[j >> 4];
/*      */     
/*  589 */     if (chunksection == null) {
/*  590 */       return (!this.world.worldProvider.g && l < EnumSkyBlock.SKY.c) ? (EnumSkyBlock.SKY.c - l) : 0;
/*      */     }
/*  592 */     int i1 = this.world.worldProvider.g ? 0 : chunksection.getSkyLight(i, j & 0xF, k);
/*      */     
/*  594 */     if (i1 > 0) {
/*  595 */       a = true;
/*      */     }
/*      */     
/*  598 */     i1 -= l;
/*  599 */     int j1 = chunksection.getEmittedLight(i, j & 0xF, k);
/*      */     
/*  601 */     if (j1 > i1) {
/*  602 */       i1 = j1;
/*      */     }
/*      */     
/*  605 */     return i1;
/*      */   }
/*      */ 
/*      */   
/*      */   public void a(Entity entity) {
/*  610 */     this.o = true;
/*  611 */     int i = MathHelper.floor(entity.locX / 16.0D);
/*  612 */     int j = MathHelper.floor(entity.locZ / 16.0D);
/*      */     
/*  614 */     if (i != this.locX || j != this.locZ) {
/*      */       
/*  616 */       Bukkit.getLogger().warning("Wrong location for " + entity + " in world '" + this.world.getWorld().getName() + "'!");
/*      */ 
/*      */       
/*  619 */       Bukkit.getLogger().warning("Entity is at " + entity.locX + "," + entity.locZ + " (chunk " + i + "," + j + ") but was stored in chunk " + this.locX + "," + this.locZ);
/*      */     } 
/*      */ 
/*      */     
/*  623 */     int k = MathHelper.floor(entity.locY / 16.0D);
/*      */     
/*  625 */     if (k < 0) {
/*  626 */       k = 0;
/*      */     }
/*      */     
/*  629 */     if (k >= this.entitySlices.length) {
/*  630 */       k = this.entitySlices.length - 1;
/*      */     }
/*      */     
/*  633 */     entity.ag = true;
/*  634 */     entity.ah = this.locX;
/*  635 */     entity.ai = k;
/*  636 */     entity.aj = this.locZ;
/*  637 */     this.entitySlices[k].add(entity);
/*      */   }
/*      */   
/*      */   public void b(Entity entity) {
/*  641 */     a(entity, entity.ai);
/*      */   }
/*      */   
/*      */   public void a(Entity entity, int i) {
/*  645 */     if (i < 0) {
/*  646 */       i = 0;
/*      */     }
/*      */     
/*  649 */     if (i >= this.entitySlices.length) {
/*  650 */       i = this.entitySlices.length - 1;
/*      */     }
/*      */     
/*  653 */     this.entitySlices[i].remove(entity);
/*      */   }
/*      */   
/*      */   public boolean d(int i, int j, int k) {
/*  657 */     return (j >= this.heightMap[k << 4 | i]);
/*      */   }
/*      */   
/*      */   public TileEntity e(int i, int j, int k) {
/*  661 */     ChunkPosition chunkposition = new ChunkPosition(i, j, k);
/*  662 */     TileEntity tileentity = (TileEntity)this.tileEntities.get(chunkposition);
/*      */     
/*  664 */     if (tileentity == null) {
/*  665 */       Block block = getType(i, j, k);
/*      */       
/*  667 */       if (!block.isTileEntity()) {
/*  668 */         return null;
/*      */       }
/*      */       
/*  671 */       tileentity = ((IContainer)block).a(this.world, getData(i, j, k));
/*  672 */       this.world.setTileEntity(this.locX * 16 + i, j, this.locZ * 16 + k, tileentity);
/*      */     } 
/*      */     
/*  675 */     if (tileentity != null && tileentity.r()) {
/*  676 */       this.tileEntities.remove(chunkposition);
/*  677 */       return null;
/*      */     } 
/*  679 */     return tileentity;
/*      */   }
/*      */ 
/*      */   
/*      */   public void a(TileEntity tileentity) {
/*  684 */     int i = tileentity.x - this.locX * 16;
/*  685 */     int j = tileentity.y;
/*  686 */     int k = tileentity.z - this.locZ * 16;
/*      */     
/*  688 */     a(i, j, k, tileentity);
/*  689 */     if (this.d) {
/*  690 */       this.world.tileEntityList.add(tileentity);
/*      */     }
/*      */   }
/*      */   
/*      */   public void a(int i, int j, int k, TileEntity tileentity) {
/*  695 */     ChunkPosition chunkposition = new ChunkPosition(i, j, k);
/*      */     
/*  697 */     tileentity.a(this.world);
/*  698 */     tileentity.x = this.locX * 16 + i;
/*  699 */     tileentity.y = j;
/*  700 */     tileentity.z = this.locZ * 16 + k;
/*  701 */     if (getType(i, j, k) instanceof IContainer) {
/*  702 */       if (this.tileEntities.containsKey(chunkposition)) {
/*  703 */         ((TileEntity)this.tileEntities.get(chunkposition)).s();
/*      */       }
/*      */       
/*  706 */       tileentity.t();
/*  707 */       this.tileEntities.put(chunkposition, tileentity);
/*      */     } else {
/*      */       
/*  710 */       System.out.println("Attempted to place a tile entity (" + tileentity + ") at " + tileentity.x + "," + tileentity.y + "," + tileentity.z + " (" + CraftMagicNumbers.getMaterial(getType(i, j, k)) + ") where there was no entity tile!");
/*      */       
/*  712 */       System.out.println("Chunk coordinates: " + (this.locX * 16) + "," + (this.locZ * 16));
/*  713 */       (new Exception()).printStackTrace();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void f(int i, int j, int k) {
/*  719 */     ChunkPosition chunkposition = new ChunkPosition(i, j, k);
/*      */     
/*  721 */     if (this.d) {
/*  722 */       TileEntity tileentity = (TileEntity)this.tileEntities.remove(chunkposition);
/*      */       
/*  724 */       if (tileentity != null) {
/*  725 */         tileentity.s();
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void addEntities() {
/*  731 */     this.d = true;
/*  732 */     this.world.a(this.tileEntities.values());
/*      */     
/*  734 */     for (int i = 0; i < this.entitySlices.length; i++) {
/*  735 */       Iterator<?> iterator = this.entitySlices[i].iterator();
/*      */       
/*  737 */       while (iterator.hasNext()) {
/*  738 */         Entity entity = (Entity)iterator.next();
/*      */         
/*  740 */         entity.X();
/*      */       } 
/*      */       
/*  743 */       this.world.a(this.entitySlices[i]);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void removeEntities() {
/*  748 */     this.d = false;
/*  749 */     Iterator<TileEntity> iterator = this.tileEntities.values().iterator();
/*      */     
/*  751 */     while (iterator.hasNext()) {
/*  752 */       TileEntity tileentity = iterator.next();
/*      */       
/*  754 */       this.world.a(tileentity);
/*      */     } 
/*      */     
/*  757 */     for (int i = 0; i < this.entitySlices.length; i++) {
/*      */       
/*  759 */       Iterator<Object> iter = this.entitySlices[i].iterator();
/*  760 */       while (iter.hasNext()) {
/*  761 */         Entity entity = (Entity)iter.next();
/*      */ 
/*      */ 
/*      */         
/*  765 */         if (entity instanceof EntityPlayer) {
/*  766 */           iter.remove();
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/*  771 */       this.world.b(this.entitySlices[i]);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void e() {
/*  776 */     this.n = true;
/*      */   }
/*      */   
/*      */   public void a(Entity entity, AxisAlignedBB axisalignedbb, List<Entity> list, IEntitySelector ientityselector) {
/*  780 */     int i = MathHelper.floor((axisalignedbb.b - 2.0D) / 16.0D);
/*  781 */     int j = MathHelper.floor((axisalignedbb.e + 2.0D) / 16.0D);
/*      */     
/*  783 */     i = MathHelper.a(i, 0, this.entitySlices.length - 1);
/*  784 */     j = MathHelper.a(j, 0, this.entitySlices.length - 1);
/*      */     
/*  786 */     for (int k = i; k <= j; k++) {
/*  787 */       List<Entity> list1 = this.entitySlices[k];
/*      */       
/*  789 */       for (int l = 0; l < list1.size(); l++) {
/*  790 */         Entity entity1 = list1.get(l);
/*      */         
/*  792 */         if (entity1 != entity && entity1.boundingBox.b(axisalignedbb) && (ientityselector == null || ientityselector.a(entity1))) {
/*  793 */           list.add(entity1);
/*  794 */           Entity[] aentity = entity1.at();
/*      */           
/*  796 */           if (aentity != null) {
/*  797 */             for (int i1 = 0; i1 < aentity.length; i1++) {
/*  798 */               entity1 = aentity[i1];
/*  799 */               if (entity1 != entity && entity1.boundingBox.b(axisalignedbb) && (ientityselector == null || ientityselector.a(entity1))) {
/*  800 */                 list.add(entity1);
/*      */               }
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(Class oclass, AxisAlignedBB axisalignedbb, List<Entity> list, IEntitySelector ientityselector) {
/*  810 */     int i = MathHelper.floor((axisalignedbb.b - 2.0D) / 16.0D);
/*  811 */     int j = MathHelper.floor((axisalignedbb.e + 2.0D) / 16.0D);
/*      */     
/*  813 */     i = MathHelper.a(i, 0, this.entitySlices.length - 1);
/*  814 */     j = MathHelper.a(j, 0, this.entitySlices.length - 1);
/*      */     
/*  816 */     for (int k = i; k <= j; k++) {
/*  817 */       List<Entity> list1 = this.entitySlices[k];
/*      */       
/*  819 */       for (int l = 0; l < list1.size(); l++) {
/*  820 */         Entity entity = list1.get(l);
/*      */         
/*  822 */         if (oclass.isAssignableFrom(entity.getClass()) && entity.boundingBox.b(axisalignedbb) && (ientityselector == null || ientityselector.a(entity))) {
/*  823 */           list.add(entity);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean a(boolean flag) {
/*  830 */     if (flag) {
/*  831 */       if ((this.o && this.world.getTime() != this.lastSaved) || this.n) {
/*  832 */         return true;
/*      */       }
/*  834 */     } else if (this.o && this.world.getTime() >= this.lastSaved + 600L) {
/*  835 */       return true;
/*      */     } 
/*      */     
/*  838 */     return this.n;
/*      */   }
/*      */   
/*      */   public Random a(long i) {
/*  842 */     return new Random(this.world.getSeed() + (this.locX * this.locX * 4987142) + (this.locX * 5947611) + (this.locZ * this.locZ) * 4392871L + (this.locZ * 389711) ^ i);
/*      */   }
/*      */   
/*      */   public boolean isEmpty() {
/*  846 */     return false;
/*      */   }
/*      */   
/*      */   public void loadNearby(IChunkProvider ichunkprovider, IChunkProvider ichunkprovider1, int i, int j) {
/*  850 */     if (!this.done && ichunkprovider.isChunkLoaded(i + 1, j + 1) && ichunkprovider.isChunkLoaded(i, j + 1) && ichunkprovider.isChunkLoaded(i + 1, j)) {
/*  851 */       ichunkprovider.getChunkAt(ichunkprovider1, i, j);
/*      */     }
/*      */     
/*  854 */     if (ichunkprovider.isChunkLoaded(i - 1, j) && !(ichunkprovider.getOrCreateChunk(i - 1, j)).done && ichunkprovider.isChunkLoaded(i - 1, j + 1) && ichunkprovider.isChunkLoaded(i, j + 1) && ichunkprovider.isChunkLoaded(i - 1, j + 1)) {
/*  855 */       ichunkprovider.getChunkAt(ichunkprovider1, i - 1, j);
/*      */     }
/*      */     
/*  858 */     if (ichunkprovider.isChunkLoaded(i, j - 1) && !(ichunkprovider.getOrCreateChunk(i, j - 1)).done && ichunkprovider.isChunkLoaded(i + 1, j - 1) && ichunkprovider.isChunkLoaded(i + 1, j - 1) && ichunkprovider.isChunkLoaded(i + 1, j)) {
/*  859 */       ichunkprovider.getChunkAt(ichunkprovider1, i, j - 1);
/*      */     }
/*      */     
/*  862 */     if (ichunkprovider.isChunkLoaded(i - 1, j - 1) && !(ichunkprovider.getOrCreateChunk(i - 1, j - 1)).done && ichunkprovider.isChunkLoaded(i, j - 1) && ichunkprovider.isChunkLoaded(i - 1, j)) {
/*  863 */       ichunkprovider.getChunkAt(ichunkprovider1, i - 1, j - 1);
/*      */     }
/*      */   }
/*      */   
/*      */   public int d(int i, int j) {
/*  868 */     int k = i | j << 4;
/*  869 */     int l = this.b[k];
/*      */     
/*  871 */     if (l == -999) {
/*  872 */       int i1 = h() + 15;
/*      */       
/*  874 */       l = -1;
/*      */       
/*  876 */       while (i1 > 0 && l == -1) {
/*  877 */         Block block = getType(i, i1, j);
/*  878 */         Material material = block.getMaterial();
/*      */         
/*  880 */         if (!material.isSolid() && !material.isLiquid()) {
/*  881 */           i1--; continue;
/*      */         } 
/*  883 */         l = i1 + 1;
/*      */       } 
/*      */ 
/*      */       
/*  887 */       this.b[k] = l;
/*      */     } 
/*      */     
/*  890 */     return l;
/*      */   }
/*      */   
/*      */   public void b(boolean flag) {
/*  894 */     if (this.w && !this.world.worldProvider.g && !flag) {
/*  895 */       c(this.world.isStatic);
/*      */     }
/*      */     
/*  898 */     this.m = true;
/*  899 */     if (!this.lit && this.done) {
/*  900 */       p();
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean isReady() {
/*  905 */     return (this.m && this.done && this.lit);
/*      */   }
/*      */   
/*      */   public ChunkCoordIntPair l() {
/*  909 */     return new ChunkCoordIntPair(this.locX, this.locZ);
/*      */   }
/*      */   
/*      */   public boolean c(int i, int j) {
/*  913 */     if (i < 0) {
/*  914 */       i = 0;
/*      */     }
/*      */     
/*  917 */     if (j >= 256) {
/*  918 */       j = 255;
/*      */     }
/*      */     
/*  921 */     for (int k = i; k <= j; k += 16) {
/*  922 */       ChunkSection chunksection = this.sections[k >> 4];
/*      */       
/*  924 */       if (chunksection != null && !chunksection.isEmpty()) {
/*  925 */         return false;
/*      */       }
/*      */     } 
/*      */     
/*  929 */     return true;
/*      */   }
/*      */   
/*      */   public void a(ChunkSection[] achunksection) {
/*  933 */     this.sections = achunksection;
/*      */   }
/*      */   
/*      */   public BiomeBase getBiome(int i, int j, WorldChunkManager worldchunkmanager) {
/*  937 */     int k = this.v[j << 4 | i] & 0xFF;
/*      */     
/*  939 */     if (k == 255) {
/*  940 */       BiomeBase biomebase = worldchunkmanager.getBiome((this.locX << 4) + i, (this.locZ << 4) + j);
/*      */       
/*  942 */       k = biomebase.id;
/*  943 */       this.v[j << 4 | i] = (byte)(k & 0xFF);
/*      */     } 
/*      */     
/*  946 */     return (BiomeBase.getBiome(k) == null) ? BiomeBase.PLAINS : BiomeBase.getBiome(k);
/*      */   }
/*      */   
/*      */   public byte[] m() {
/*  950 */     return this.v;
/*      */   }
/*      */   
/*      */   public void a(byte[] abyte) {
/*  954 */     this.v = abyte;
/*      */   }
/*      */   
/*      */   public void n() {
/*  958 */     this.x = 0;
/*      */   }
/*      */   
/*      */   public void o() {
/*  962 */     for (int i = 0; i < 8; i++) {
/*  963 */       if (this.x >= 4096) {
/*      */         return;
/*      */       }
/*      */       
/*  967 */       int j = this.x % 16;
/*  968 */       int k = this.x / 16 % 16;
/*  969 */       int l = this.x / 256;
/*      */       
/*  971 */       this.x++;
/*  972 */       int i1 = (this.locX << 4) + k;
/*  973 */       int j1 = (this.locZ << 4) + l;
/*      */       
/*  975 */       for (int k1 = 0; k1 < 16; k1++) {
/*  976 */         int l1 = (j << 4) + k1;
/*      */         
/*  978 */         if ((this.sections[j] == null && (k1 == 0 || k1 == 15 || k == 0 || k == 15 || l == 0 || l == 15)) || (this.sections[j] != null && this.sections[j].getTypeId(k, k1, l).getMaterial() == Material.AIR)) {
/*  979 */           if (this.world.getType(i1, l1 - 1, j1).m() > 0) {
/*  980 */             this.world.t(i1, l1 - 1, j1);
/*      */           }
/*      */           
/*  983 */           if (this.world.getType(i1, l1 + 1, j1).m() > 0) {
/*  984 */             this.world.t(i1, l1 + 1, j1);
/*      */           }
/*      */           
/*  987 */           if (this.world.getType(i1 - 1, l1, j1).m() > 0) {
/*  988 */             this.world.t(i1 - 1, l1, j1);
/*      */           }
/*      */           
/*  991 */           if (this.world.getType(i1 + 1, l1, j1).m() > 0) {
/*  992 */             this.world.t(i1 + 1, l1, j1);
/*      */           }
/*      */           
/*  995 */           if (this.world.getType(i1, l1, j1 - 1).m() > 0) {
/*  996 */             this.world.t(i1, l1, j1 - 1);
/*      */           }
/*      */           
/*  999 */           if (this.world.getType(i1, l1, j1 + 1).m() > 0) {
/* 1000 */             this.world.t(i1, l1, j1 + 1);
/*      */           }
/*      */           
/* 1003 */           this.world.t(i1, l1, j1);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void p() {
/* 1010 */     this.done = true;
/* 1011 */     this.lit = true;
/* 1012 */     if (!this.world.worldProvider.g) {
/* 1013 */       if (this.world.b(this.locX * 16 - 1, 0, this.locZ * 16 - 1, this.locX * 16 + 1, 63, this.locZ * 16 + 1)) {
/* 1014 */         for (int i = 0; i < 16; i++) {
/* 1015 */           for (int j = 0; j < 16; j++) {
/* 1016 */             if (!f(i, j)) {
/* 1017 */               this.lit = false;
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/*      */         } 
/* 1023 */         if (this.lit) {
/* 1024 */           Chunk chunk = this.world.getChunkAtWorldCoords(this.locX * 16 - 1, this.locZ * 16);
/*      */           
/* 1026 */           chunk.a(3);
/* 1027 */           chunk = this.world.getChunkAtWorldCoords(this.locX * 16 + 16, this.locZ * 16);
/* 1028 */           chunk.a(1);
/* 1029 */           chunk = this.world.getChunkAtWorldCoords(this.locX * 16, this.locZ * 16 - 1);
/* 1030 */           chunk.a(0);
/* 1031 */           chunk = this.world.getChunkAtWorldCoords(this.locX * 16, this.locZ * 16 + 16);
/* 1032 */           chunk.a(2);
/*      */         } 
/*      */       } else {
/* 1035 */         this.lit = false;
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private void a(int i) {
/* 1041 */     if (this.done)
/*      */     {
/*      */       
/* 1044 */       if (i == 3) {
/* 1045 */         for (int j = 0; j < 16; j++) {
/* 1046 */           f(15, j);
/*      */         }
/* 1048 */       } else if (i == 1) {
/* 1049 */         for (int j = 0; j < 16; j++) {
/* 1050 */           f(0, j);
/*      */         }
/* 1052 */       } else if (i == 0) {
/* 1053 */         for (int j = 0; j < 16; j++) {
/* 1054 */           f(j, 15);
/*      */         }
/* 1056 */       } else if (i == 2) {
/* 1057 */         for (int j = 0; j < 16; j++) {
/* 1058 */           f(j, 0);
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   private boolean f(int i, int j) {
/* 1065 */     int k = h();
/* 1066 */     boolean flag = false;
/* 1067 */     boolean flag1 = false;
/*      */     
/*      */     int l;
/*      */     
/* 1071 */     for (l = k + 16 - 1; l > 63 || (l > 0 && !flag1); l--) {
/* 1072 */       int i1 = b(i, l, j);
/*      */       
/* 1074 */       if (i1 == 255 && l < 63) {
/* 1075 */         flag1 = true;
/*      */       }
/*      */       
/* 1078 */       if (!flag && i1 > 0) {
/* 1079 */         flag = true;
/* 1080 */       } else if (flag && i1 == 0 && !this.world.t(this.locX * 16 + i, l, this.locZ * 16 + j)) {
/* 1081 */         return false;
/*      */       } 
/*      */     } 
/*      */     
/* 1085 */     for (; l > 0; l--) {
/* 1086 */       if (getType(i, l, j).m() > 0) {
/* 1087 */         this.world.t(this.locX * 16 + i, l, this.locZ * 16 + j);
/*      */       }
/*      */     } 
/*      */     
/* 1091 */     return true;
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\Chunk.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */