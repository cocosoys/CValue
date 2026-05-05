/*      */ package net.minecraft.server.v1_7_R4;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.Collection;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.UUID;
/*      */ import org.bukkit.Bukkit;
/*      */ import org.bukkit.block.BlockState;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.block.CraftBlockState;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.util.CraftMagicNumbers;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.util.LongHash;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.util.LongHashSet;
/*      */ import org.bukkit.event.Cancellable;
/*      */ import org.bukkit.event.Event;
/*      */ import org.bukkit.event.block.BlockCanBuildEvent;
/*      */ import org.bukkit.event.block.BlockPhysicsEvent;
/*      */ import org.bukkit.event.entity.CreatureSpawnEvent;
/*      */ import org.bukkit.event.entity.ItemSpawnEvent;
/*      */ import org.bukkit.event.entity.ProjectileLaunchEvent;
/*      */ import org.bukkit.event.weather.ThunderChangeEvent;
/*      */ import org.bukkit.event.weather.WeatherChangeEvent;
/*      */ import org.bukkit.generator.ChunkGenerator;
/*      */ 
/*      */ public abstract class World implements IBlockAccess {
/*   33 */   public List entityList = new ArrayList(); public boolean d;
/*   34 */   protected List f = new ArrayList();
/*   35 */   public Set tileEntityList = new HashSet();
/*   36 */   private List a = new ArrayList();
/*   37 */   private List b = new ArrayList();
/*   38 */   public List players = new ArrayList();
/*   39 */   public List i = new ArrayList();
/*   40 */   private long c = 16777215L;
/*      */   public int j;
/*   42 */   protected int k = (new Random()).nextInt();
/*   43 */   protected final int l = 1013904223;
/*      */   protected float m;
/*      */   protected float n;
/*      */   protected float o;
/*      */   protected float p;
/*      */   public int q;
/*      */   public EnumDifficulty difficulty;
/*   50 */   public Random random = new Random();
/*      */   public WorldProvider worldProvider;
/*   52 */   protected List u = new ArrayList();
/*      */   public IChunkProvider chunkProvider;
/*      */   protected final IDataManager dataManager;
/*      */   public WorldData worldData;
/*      */   public boolean isLoading;
/*      */   public PersistentCollection worldMaps;
/*      */   public final PersistentVillage villages;
/*   59 */   protected final VillageSiege siegeManager = new VillageSiege(this);
/*      */   public final MethodProfiler methodProfiler;
/*   61 */   private final Calendar J = Calendar.getInstance();
/*   62 */   public Scoreboard scoreboard = new Scoreboard();
/*      */   
/*      */   public boolean isStatic;
/*   65 */   protected LongHashSet chunkTickList = new LongHashSet();
/*      */   
/*      */   private int K;
/*      */   public boolean allowMonsters;
/*      */   public boolean allowAnimals;
/*      */   public boolean captureBlockStates = false;
/*      */   public boolean captureTreeGeneration = false;
/*   72 */   public ArrayList<BlockState> capturedBlockStates = new ArrayList<BlockState>(); public long ticksPerAnimalSpawns;
/*      */   public long ticksPerMonsterSpawns;
/*      */   public boolean populating;
/*      */   private int tickPosition;
/*      */   private ArrayList L;
/*      */   private boolean M;
/*      */   int[] I;
/*      */   private final CraftWorld world;
/*      */   public boolean pvpMode;
/*      */   
/*      */   public BiomeBase getBiome(int i, int j) {
/*   83 */     if (isLoaded(i, 0, j)) {
/*   84 */       Chunk chunk = getChunkAtWorldCoords(i, j);
/*      */       
/*      */       try {
/*   87 */         return chunk.getBiome(i & 0xF, j & 0xF, this.worldProvider.e);
/*   88 */       } catch (Throwable throwable) {
/*   89 */         CrashReport crashreport = CrashReport.a(throwable, "Getting biome");
/*   90 */         CrashReportSystemDetails crashreportsystemdetails = crashreport.a("Coordinates of biome request");
/*      */         
/*   92 */         crashreportsystemdetails.a("Location", new CrashReportWorldLocation(this, i, j));
/*   93 */         throw new ReportedException(crashreport);
/*      */       } 
/*      */     } 
/*   96 */     return this.worldProvider.e.getBiome(i, j);
/*      */   }
/*      */ 
/*      */   
/*      */   public WorldChunkManager getWorldChunkManager() {
/*  101 */     return this.worldProvider.e;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean keepSpawnInMemory = true;
/*      */   
/*      */   public ChunkGenerator generator;
/*      */ 
/*      */   
/*      */   public CraftWorld getWorld() {
/*  111 */     return this.world;
/*      */   }
/*      */   
/*      */   public CraftServer getServer() {
/*  115 */     return (CraftServer)Bukkit.getServer();
/*      */   }
/*      */   
/*      */   public Chunk getChunkIfLoaded(int x, int z) {
/*  119 */     return ((ChunkProviderServer)this.chunkProvider).getChunkIfLoaded(x, z);
/*      */   }
/*      */ 
/*      */   
/*      */   public World(IDataManager idatamanager, String s, WorldSettings worldsettings, WorldProvider worldprovider, MethodProfiler methodprofiler, ChunkGenerator gen, org.bukkit.World.Environment env) {
/*  124 */     this.generator = gen;
/*  125 */     this.world = new CraftWorld((WorldServer)this, gen, env);
/*  126 */     this.ticksPerAnimalSpawns = getServer().getTicksPerAnimalSpawns();
/*  127 */     this.ticksPerMonsterSpawns = getServer().getTicksPerMonsterSpawns();
/*      */ 
/*      */     
/*  130 */     this.K = this.random.nextInt(12000);
/*  131 */     this.allowMonsters = true;
/*  132 */     this.allowAnimals = true;
/*  133 */     this.L = new ArrayList();
/*  134 */     this.I = new int[32768];
/*  135 */     this.dataManager = idatamanager;
/*  136 */     this.methodProfiler = methodprofiler;
/*  137 */     this.worldMaps = new PersistentCollection(idatamanager);
/*  138 */     this.worldData = idatamanager.getWorldData();
/*  139 */     if (worldprovider != null) {
/*  140 */       this.worldProvider = worldprovider;
/*  141 */     } else if (this.worldData != null && this.worldData.j() != 0) {
/*  142 */       this.worldProvider = WorldProvider.byDimension(this.worldData.j());
/*      */     } else {
/*  144 */       this.worldProvider = WorldProvider.byDimension(0);
/*      */     } 
/*      */     
/*  147 */     if (this.worldData == null) {
/*  148 */       this.worldData = new WorldData(worldsettings, s);
/*      */     } else {
/*  150 */       this.worldData.setName(s);
/*      */     } 
/*      */     
/*  153 */     this.worldProvider.a(this);
/*  154 */     this.chunkProvider = j();
/*  155 */     if (!this.worldData.isInitialized()) {
/*      */       try {
/*  157 */         a(worldsettings);
/*  158 */       } catch (Throwable throwable) {
/*  159 */         CrashReport crashreport = CrashReport.a(throwable, "Exception initializing level");
/*      */         
/*      */         try {
/*  162 */           a(crashreport);
/*  163 */         } catch (Throwable throwable1) {}
/*      */ 
/*      */ 
/*      */         
/*  167 */         throw new ReportedException(crashreport);
/*      */       } 
/*      */       
/*  170 */       this.worldData.d(true);
/*      */     } 
/*      */     
/*  173 */     PersistentVillage persistentvillage = (PersistentVillage)this.worldMaps.get(PersistentVillage.class, "villages");
/*      */     
/*  175 */     if (persistentvillage == null) {
/*  176 */       this.villages = new PersistentVillage(this);
/*  177 */       this.worldMaps.a("villages", this.villages);
/*      */     } else {
/*  179 */       this.villages = persistentvillage;
/*  180 */       this.villages.a(this);
/*      */     } 
/*      */     
/*  183 */     B();
/*  184 */     a();
/*      */     
/*  186 */     getServer().addWorld((org.bukkit.World)this.world);
/*      */   }
/*      */   
/*      */   protected abstract IChunkProvider j();
/*      */   
/*      */   protected void a(WorldSettings worldsettings) {
/*  192 */     this.worldData.d(true);
/*      */   }
/*      */ 
/*      */   
/*      */   public Block b(int i, int j) {
/*      */     int k;
/*  198 */     for (k = 63; !isEmpty(i, k + 1, j); k++);
/*      */ 
/*      */ 
/*      */     
/*  202 */     return getType(i, k, j);
/*      */   }
/*      */ 
/*      */   
/*      */   public Block getType(int i, int j, int k) {
/*  207 */     if (this.captureTreeGeneration) {
/*  208 */       Iterator<BlockState> it = this.capturedBlockStates.iterator();
/*  209 */       while (it.hasNext()) {
/*  210 */         BlockState previous = it.next();
/*  211 */         if (previous.getX() == i && previous.getY() == j && previous.getZ() == k) {
/*  212 */           return CraftMagicNumbers.getBlock(previous.getTypeId());
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  217 */     if (i >= -30000000 && k >= -30000000 && i < 30000000 && k < 30000000 && j >= 0 && j < 256) {
/*  218 */       Chunk chunk = null;
/*      */       
/*      */       try {
/*  221 */         chunk = getChunkAt(i >> 4, k >> 4);
/*  222 */         return chunk.getType(i & 0xF, j, k & 0xF);
/*  223 */       } catch (Throwable throwable) {
/*  224 */         CrashReport crashreport = CrashReport.a(throwable, "Exception getting block type in world");
/*  225 */         CrashReportSystemDetails crashreportsystemdetails = crashreport.a("Requested block coordinates");
/*      */         
/*  227 */         crashreportsystemdetails.a("Found chunk", Boolean.valueOf((chunk == null)));
/*  228 */         crashreportsystemdetails.a("Location", CrashReportSystemDetails.a(i, j, k));
/*  229 */         throw new ReportedException(crashreport);
/*      */       } 
/*      */     } 
/*  232 */     return Blocks.AIR;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isEmpty(int i, int j, int k) {
/*  237 */     return (getType(i, j, k).getMaterial() == Material.AIR);
/*      */   }
/*      */   
/*      */   public boolean isLoaded(int i, int j, int k) {
/*  241 */     return (j >= 0 && j < 256) ? isChunkLoaded(i >> 4, k >> 4) : false;
/*      */   }
/*      */   
/*      */   public boolean areChunksLoaded(int i, int j, int k, int l) {
/*  245 */     return b(i - l, j - l, k - l, i + l, j + l, k + l);
/*      */   }
/*      */   
/*      */   public boolean b(int i, int j, int k, int l, int i1, int j1) {
/*  249 */     if (i1 >= 0 && j < 256) {
/*  250 */       i >>= 4;
/*  251 */       k >>= 4;
/*  252 */       l >>= 4;
/*  253 */       j1 >>= 4;
/*      */       
/*  255 */       for (int k1 = i; k1 <= l; k1++) {
/*  256 */         for (int l1 = k; l1 <= j1; l1++) {
/*  257 */           if (!isChunkLoaded(k1, l1)) {
/*  258 */             return false;
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/*  263 */       return true;
/*      */     } 
/*  265 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean isChunkLoaded(int i, int j) {
/*  270 */     return this.chunkProvider.isChunkLoaded(i, j);
/*      */   }
/*      */   
/*      */   public Chunk getChunkAtWorldCoords(int i, int j) {
/*  274 */     return getChunkAt(i >> 4, j >> 4);
/*      */   }
/*      */   
/*      */   public Chunk getChunkAt(int i, int j) {
/*  278 */     return this.chunkProvider.getOrCreateChunk(i, j);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean setTypeAndData(int i, int j, int k, Block block, int l, int i1) {
/*  283 */     if (this.captureTreeGeneration) {
/*  284 */       CraftBlockState craftBlockState; BlockState blockstate = null;
/*  285 */       Iterator<BlockState> it = this.capturedBlockStates.iterator();
/*  286 */       while (it.hasNext()) {
/*  287 */         BlockState previous = it.next();
/*  288 */         if (previous.getX() == i && previous.getY() == j && previous.getZ() == k) {
/*  289 */           blockstate = previous;
/*  290 */           it.remove();
/*      */           break;
/*      */         } 
/*      */       } 
/*  294 */       if (blockstate == null) {
/*  295 */         craftBlockState = CraftBlockState.getBlockState(this, i, j, k, i1);
/*      */       }
/*  297 */       craftBlockState.setTypeId(CraftMagicNumbers.getId(block));
/*  298 */       craftBlockState.setRawData((byte)l);
/*  299 */       this.capturedBlockStates.add(craftBlockState);
/*  300 */       return true;
/*      */     } 
/*  302 */     if (i >= -30000000 && k >= -30000000 && i < 30000000 && k < 30000000) {
/*  303 */       CraftBlockState craftBlockState; if (j < 0)
/*  304 */         return false; 
/*  305 */       if (j >= 256) {
/*  306 */         return false;
/*      */       }
/*  308 */       Chunk chunk = getChunkAt(i >> 4, k >> 4);
/*  309 */       Block block1 = null;
/*      */       
/*  311 */       if ((i1 & 0x1) != 0) {
/*  312 */         block1 = chunk.getType(i & 0xF, j, k & 0xF);
/*      */       }
/*      */ 
/*      */       
/*  316 */       BlockState blockstate = null;
/*  317 */       if (this.captureBlockStates) {
/*  318 */         craftBlockState = CraftBlockState.getBlockState(this, i, j, k, i1);
/*  319 */         this.capturedBlockStates.add(craftBlockState);
/*      */       } 
/*      */ 
/*      */       
/*  323 */       boolean flag = chunk.a(i & 0xF, j, k & 0xF, block, l);
/*      */ 
/*      */       
/*  326 */       if (!flag && this.captureBlockStates) {
/*  327 */         this.capturedBlockStates.remove(craftBlockState);
/*      */       }
/*      */ 
/*      */       
/*  331 */       this.methodProfiler.a("checkLight");
/*  332 */       t(i, j, k);
/*  333 */       this.methodProfiler.b();
/*      */       
/*  335 */       if (flag && !this.captureBlockStates)
/*      */       {
/*  337 */         notifyAndUpdatePhysics(i, j, k, chunk, block1, block, i1);
/*      */       }
/*      */ 
/*      */       
/*  341 */       return flag;
/*      */     } 
/*      */     
/*  344 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void notifyAndUpdatePhysics(int i, int j, int k, Chunk chunk, Block oldBlock, Block newBlock, int flag) {
/*  352 */     if ((flag & 0x2) != 0 && (chunk == null || chunk.isReady())) {
/*  353 */       notify(i, j, k);
/*      */     }
/*      */     
/*  356 */     if ((flag & 0x1) != 0) {
/*  357 */       update(i, j, k, oldBlock);
/*  358 */       if (newBlock.isComplexRedstone()) {
/*  359 */         updateAdjacentComparators(i, j, k, newBlock);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getData(int i, int j, int k) {
/*  367 */     if (this.captureTreeGeneration) {
/*  368 */       Iterator<BlockState> it = this.capturedBlockStates.iterator();
/*  369 */       while (it.hasNext()) {
/*  370 */         BlockState previous = it.next();
/*  371 */         if (previous.getX() == i && previous.getY() == j && previous.getZ() == k) {
/*  372 */           return previous.getRawData();
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  377 */     if (i >= -30000000 && k >= -30000000 && i < 30000000 && k < 30000000) {
/*  378 */       if (j < 0)
/*  379 */         return 0; 
/*  380 */       if (j >= 256) {
/*  381 */         return 0;
/*      */       }
/*  383 */       Chunk chunk = getChunkAt(i >> 4, k >> 4);
/*      */       
/*  385 */       i &= 0xF;
/*  386 */       k &= 0xF;
/*  387 */       return chunk.getData(i, j, k);
/*      */     } 
/*      */     
/*  390 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean setData(int i, int j, int k, int l, int i1) {
/*  396 */     if (this.captureTreeGeneration) {
/*  397 */       CraftBlockState craftBlockState; BlockState blockstate = null;
/*  398 */       Iterator<BlockState> it = this.capturedBlockStates.iterator();
/*  399 */       while (it.hasNext()) {
/*  400 */         BlockState previous = it.next();
/*  401 */         if (previous.getX() == i && previous.getY() == j && previous.getZ() == k) {
/*  402 */           blockstate = previous;
/*  403 */           it.remove();
/*      */           break;
/*      */         } 
/*      */       } 
/*  407 */       if (blockstate == null) {
/*  408 */         craftBlockState = CraftBlockState.getBlockState(this, i, j, k, i1);
/*      */       }
/*  410 */       craftBlockState.setRawData((byte)l);
/*  411 */       this.capturedBlockStates.add(craftBlockState);
/*  412 */       return true;
/*      */     } 
/*      */     
/*  415 */     if (i >= -30000000 && k >= -30000000 && i < 30000000 && k < 30000000) {
/*  416 */       if (j < 0)
/*  417 */         return false; 
/*  418 */       if (j >= 256) {
/*  419 */         return false;
/*      */       }
/*  421 */       Chunk chunk = getChunkAt(i >> 4, k >> 4);
/*  422 */       int j1 = i & 0xF;
/*  423 */       int k1 = k & 0xF;
/*  424 */       boolean flag = chunk.a(j1, j, k1, l);
/*      */       
/*  426 */       if (flag) {
/*  427 */         Block block = chunk.getType(j1, j, k1);
/*      */         
/*  429 */         if ((i1 & 0x2) != 0 && (!this.isStatic || (i1 & 0x4) == 0) && chunk.isReady()) {
/*  430 */           notify(i, j, k);
/*      */         }
/*      */         
/*  433 */         if (!this.isStatic && (i1 & 0x1) != 0) {
/*  434 */           update(i, j, k, block);
/*  435 */           if (block.isComplexRedstone()) {
/*  436 */             updateAdjacentComparators(i, j, k, block);
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/*  441 */       return flag;
/*      */     } 
/*      */     
/*  444 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean setAir(int i, int j, int k) {
/*  449 */     return setTypeAndData(i, j, k, Blocks.AIR, 0, 3);
/*      */   }
/*      */   
/*      */   public boolean setAir(int i, int j, int k, boolean flag) {
/*  453 */     Block block = getType(i, j, k);
/*      */     
/*  455 */     if (block.getMaterial() == Material.AIR) {
/*  456 */       return false;
/*      */     }
/*  458 */     int l = getData(i, j, k);
/*      */     
/*  460 */     triggerEffect(2001, i, j, k, Block.getId(block) + (l << 12));
/*  461 */     if (flag) {
/*  462 */       block.b(this, i, j, k, l, 0);
/*      */     }
/*      */     
/*  465 */     return setTypeAndData(i, j, k, Blocks.AIR, 0, 3);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean setTypeUpdate(int i, int j, int k, Block block) {
/*  470 */     return setTypeAndData(i, j, k, block, 0, 3);
/*      */   }
/*      */   
/*      */   public void notify(int i, int j, int k) {
/*  474 */     for (int l = 0; l < this.u.size(); l++) {
/*  475 */       ((IWorldAccess)this.u.get(l)).a(i, j, k);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void update(int i, int j, int k, Block block) {
/*  481 */     if (this.populating) {
/*      */       return;
/*      */     }
/*      */     
/*  485 */     applyPhysics(i, j, k, block);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void b(int i, int j, int k, int l) {
/*  491 */     if (k > l) {
/*  492 */       int i1 = l;
/*  493 */       l = k;
/*  494 */       k = i1;
/*      */     } 
/*      */     
/*  497 */     if (!this.worldProvider.g) {
/*  498 */       for (int i1 = k; i1 <= l; i1++) {
/*  499 */         c(EnumSkyBlock.SKY, i, i1, j);
/*      */       }
/*      */     }
/*      */     
/*  503 */     c(i, k, j, i, l, j);
/*      */   }
/*      */   
/*      */   public void c(int i, int j, int k, int l, int i1, int j1) {
/*  507 */     for (int k1 = 0; k1 < this.u.size(); k1++) {
/*  508 */       ((IWorldAccess)this.u.get(k1)).a(i, j, k, l, i1, j1);
/*      */     }
/*      */   }
/*      */   
/*      */   public void applyPhysics(int i, int j, int k, Block block) {
/*  513 */     e(i - 1, j, k, block);
/*  514 */     e(i + 1, j, k, block);
/*  515 */     e(i, j - 1, k, block);
/*  516 */     e(i, j + 1, k, block);
/*  517 */     e(i, j, k - 1, block);
/*  518 */     e(i, j, k + 1, block);
/*      */   }
/*      */   
/*      */   public void b(int i, int j, int k, Block block, int l) {
/*  522 */     if (l != 4) {
/*  523 */       e(i - 1, j, k, block);
/*      */     }
/*      */     
/*  526 */     if (l != 5) {
/*  527 */       e(i + 1, j, k, block);
/*      */     }
/*      */     
/*  530 */     if (l != 0) {
/*  531 */       e(i, j - 1, k, block);
/*      */     }
/*      */     
/*  534 */     if (l != 1) {
/*  535 */       e(i, j + 1, k, block);
/*      */     }
/*      */     
/*  538 */     if (l != 2) {
/*  539 */       e(i, j, k - 1, block);
/*      */     }
/*      */     
/*  542 */     if (l != 3) {
/*  543 */       e(i, j, k + 1, block);
/*      */     }
/*      */   }
/*      */   
/*      */   public void e(int i, int j, int k, Block block) {
/*  548 */     if (!this.isStatic) {
/*  549 */       Block block1 = getType(i, j, k);
/*      */ 
/*      */       
/*      */       try {
/*  553 */         CraftWorld world = ((WorldServer)this).getWorld();
/*  554 */         if (world != null) {
/*  555 */           BlockPhysicsEvent event = new BlockPhysicsEvent(world.getBlockAt(i, j, k), CraftMagicNumbers.getId(block));
/*  556 */           getServer().getPluginManager().callEvent((Event)event);
/*      */           
/*  558 */           if (event.isCancelled()) {
/*      */             return;
/*      */           }
/*      */         } 
/*      */ 
/*      */         
/*  564 */         block1.doPhysics(this, i, j, k, block);
/*  565 */       } catch (Throwable throwable) {
/*  566 */         byte b; CrashReport crashreport = CrashReport.a(throwable, "Exception while updating neighbours");
/*  567 */         CrashReportSystemDetails crashreportsystemdetails = crashreport.a("Block being updated");
/*      */ 
/*      */ 
/*      */         
/*      */         try {
/*  572 */           b = getData(i, j, k);
/*  573 */         } catch (Throwable throwable1) {
/*  574 */           b = -1;
/*      */         } 
/*      */         
/*  577 */         crashreportsystemdetails.a("Source block type", new CrashReportSourceBlockType(this, block));
/*  578 */         CrashReportSystemDetails.a(crashreportsystemdetails, i, j, k, block1, b);
/*  579 */         throw new ReportedException(crashreport);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean a(int i, int j, int k, Block block) {
/*  585 */     return false;
/*      */   }
/*      */   
/*      */   public boolean i(int i, int j, int k) {
/*  589 */     return getChunkAt(i >> 4, k >> 4).d(i & 0xF, j, k & 0xF);
/*      */   }
/*      */   
/*      */   public int j(int i, int j, int k) {
/*  593 */     if (j < 0) {
/*  594 */       return 0;
/*      */     }
/*  596 */     if (j >= 256) {
/*  597 */       j = 255;
/*      */     }
/*      */     
/*  600 */     return getChunkAt(i >> 4, k >> 4).b(i & 0xF, j, k & 0xF, 0);
/*      */   }
/*      */ 
/*      */   
/*      */   public int getLightLevel(int i, int j, int k) {
/*  605 */     return b(i, j, k, true);
/*      */   }
/*      */   
/*      */   public int b(int i, int j, int k, boolean flag) {
/*  609 */     if (i >= -30000000 && k >= -30000000 && i < 30000000 && k < 30000000) {
/*  610 */       if (flag && getType(i, j, k).n()) {
/*  611 */         int l = b(i, j + 1, k, false);
/*  612 */         int i1 = b(i + 1, j, k, false);
/*  613 */         int j1 = b(i - 1, j, k, false);
/*  614 */         int k1 = b(i, j, k + 1, false);
/*  615 */         int l1 = b(i, j, k - 1, false);
/*      */         
/*  617 */         if (i1 > l) {
/*  618 */           l = i1;
/*      */         }
/*      */         
/*  621 */         if (j1 > l) {
/*  622 */           l = j1;
/*      */         }
/*      */         
/*  625 */         if (k1 > l) {
/*  626 */           l = k1;
/*      */         }
/*      */         
/*  629 */         if (l1 > l) {
/*  630 */           l = l1;
/*      */         }
/*      */         
/*  633 */         return l;
/*  634 */       }  if (j < 0) {
/*  635 */         return 0;
/*      */       }
/*  637 */       if (j >= 256) {
/*  638 */         j = 255;
/*      */       }
/*      */       
/*  641 */       Chunk chunk = getChunkAt(i >> 4, k >> 4);
/*      */       
/*  643 */       i &= 0xF;
/*  644 */       k &= 0xF;
/*  645 */       return chunk.b(i, j, k, this.j);
/*      */     } 
/*      */     
/*  648 */     return 15;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getHighestBlockYAt(int i, int j) {
/*  653 */     if (i >= -30000000 && j >= -30000000 && i < 30000000 && j < 30000000) {
/*  654 */       if (!isChunkLoaded(i >> 4, j >> 4)) {
/*  655 */         return 0;
/*      */       }
/*  657 */       Chunk chunk = getChunkAt(i >> 4, j >> 4);
/*      */       
/*  659 */       return chunk.b(i & 0xF, j & 0xF);
/*      */     } 
/*      */     
/*  662 */     return 64;
/*      */   }
/*      */ 
/*      */   
/*      */   public int g(int i, int j) {
/*  667 */     if (i >= -30000000 && j >= -30000000 && i < 30000000 && j < 30000000) {
/*  668 */       if (!isChunkLoaded(i >> 4, j >> 4)) {
/*  669 */         return 0;
/*      */       }
/*  671 */       Chunk chunk = getChunkAt(i >> 4, j >> 4);
/*      */       
/*  673 */       return chunk.r;
/*      */     } 
/*      */     
/*  676 */     return 64;
/*      */   }
/*      */ 
/*      */   
/*      */   public int b(EnumSkyBlock enumskyblock, int i, int j, int k) {
/*  681 */     if (j < 0) {
/*  682 */       j = 0;
/*      */     }
/*      */     
/*  685 */     if (j >= 256) {
/*  686 */       j = 255;
/*      */     }
/*      */     
/*  689 */     if (i >= -30000000 && k >= -30000000 && i < 30000000 && k < 30000000) {
/*  690 */       int l = i >> 4;
/*  691 */       int i1 = k >> 4;
/*      */       
/*  693 */       if (!isChunkLoaded(l, i1)) {
/*  694 */         return enumskyblock.c;
/*      */       }
/*  696 */       Chunk chunk = getChunkAt(l, i1);
/*      */       
/*  698 */       return chunk.getBrightness(enumskyblock, i & 0xF, j, k & 0xF);
/*      */     } 
/*      */     
/*  701 */     return enumskyblock.c;
/*      */   }
/*      */ 
/*      */   
/*      */   public void b(EnumSkyBlock enumskyblock, int i, int j, int k, int l) {
/*  706 */     if (i >= -30000000 && k >= -30000000 && i < 30000000 && k < 30000000 && 
/*  707 */       j >= 0 && 
/*  708 */       j < 256 && 
/*  709 */       isChunkLoaded(i >> 4, k >> 4)) {
/*  710 */       Chunk chunk = getChunkAt(i >> 4, k >> 4);
/*      */       
/*  712 */       chunk.a(enumskyblock, i & 0xF, j, k & 0xF, l);
/*      */       
/*  714 */       for (int i1 = 0; i1 < this.u.size(); i1++) {
/*  715 */         ((IWorldAccess)this.u.get(i1)).b(i, j, k);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void m(int i, int j, int k) {
/*  724 */     for (int l = 0; l < this.u.size(); l++) {
/*  725 */       ((IWorldAccess)this.u.get(l)).b(i, j, k);
/*      */     }
/*      */   }
/*      */   
/*      */   public float n(int i, int j, int k) {
/*  730 */     return this.worldProvider.h[getLightLevel(i, j, k)];
/*      */   }
/*      */   
/*      */   public boolean w() {
/*  734 */     return (this.j < 4);
/*      */   }
/*      */   
/*      */   public MovingObjectPosition a(Vec3D vec3d, Vec3D vec3d1) {
/*  738 */     return rayTrace(vec3d, vec3d1, false, false, false);
/*      */   }
/*      */   
/*      */   public MovingObjectPosition rayTrace(Vec3D vec3d, Vec3D vec3d1, boolean flag) {
/*  742 */     return rayTrace(vec3d, vec3d1, flag, false, false);
/*      */   }
/*      */   
/*      */   public MovingObjectPosition rayTrace(Vec3D vec3d, Vec3D vec3d1, boolean flag, boolean flag1, boolean flag2) {
/*  746 */     if (!Double.isNaN(vec3d.a) && !Double.isNaN(vec3d.b) && !Double.isNaN(vec3d.c)) {
/*  747 */       if (!Double.isNaN(vec3d1.a) && !Double.isNaN(vec3d1.b) && !Double.isNaN(vec3d1.c)) {
/*  748 */         int i = MathHelper.floor(vec3d1.a);
/*  749 */         int j = MathHelper.floor(vec3d1.b);
/*  750 */         int k = MathHelper.floor(vec3d1.c);
/*  751 */         int l = MathHelper.floor(vec3d.a);
/*  752 */         int i1 = MathHelper.floor(vec3d.b);
/*  753 */         int j1 = MathHelper.floor(vec3d.c);
/*  754 */         Block block = getType(l, i1, j1);
/*  755 */         int k1 = getData(l, i1, j1);
/*      */         
/*  757 */         if ((!flag1 || block.a(this, l, i1, j1) != null) && block.a(k1, flag)) {
/*  758 */           MovingObjectPosition movingobjectposition = block.a(this, l, i1, j1, vec3d, vec3d1);
/*      */           
/*  760 */           if (movingobjectposition != null) {
/*  761 */             return movingobjectposition;
/*      */           }
/*      */         } 
/*      */         
/*  765 */         MovingObjectPosition movingobjectposition1 = null;
/*      */         
/*  767 */         k1 = 200;
/*      */         
/*  769 */         while (k1-- >= 0) {
/*  770 */           byte b0; if (Double.isNaN(vec3d.a) || Double.isNaN(vec3d.b) || Double.isNaN(vec3d.c)) {
/*  771 */             return null;
/*      */           }
/*      */           
/*  774 */           if (l == i && i1 == j && j1 == k) {
/*  775 */             return flag2 ? movingobjectposition1 : null;
/*      */           }
/*      */           
/*  778 */           boolean flag3 = true;
/*  779 */           boolean flag4 = true;
/*  780 */           boolean flag5 = true;
/*  781 */           double d0 = 999.0D;
/*  782 */           double d1 = 999.0D;
/*  783 */           double d2 = 999.0D;
/*      */           
/*  785 */           if (i > l) {
/*  786 */             d0 = l + 1.0D;
/*  787 */           } else if (i < l) {
/*  788 */             d0 = l + 0.0D;
/*      */           } else {
/*  790 */             flag3 = false;
/*      */           } 
/*      */           
/*  793 */           if (j > i1) {
/*  794 */             d1 = i1 + 1.0D;
/*  795 */           } else if (j < i1) {
/*  796 */             d1 = i1 + 0.0D;
/*      */           } else {
/*  798 */             flag4 = false;
/*      */           } 
/*      */           
/*  801 */           if (k > j1) {
/*  802 */             d2 = j1 + 1.0D;
/*  803 */           } else if (k < j1) {
/*  804 */             d2 = j1 + 0.0D;
/*      */           } else {
/*  806 */             flag5 = false;
/*      */           } 
/*      */           
/*  809 */           double d3 = 999.0D;
/*  810 */           double d4 = 999.0D;
/*  811 */           double d5 = 999.0D;
/*  812 */           double d6 = vec3d1.a - vec3d.a;
/*  813 */           double d7 = vec3d1.b - vec3d.b;
/*  814 */           double d8 = vec3d1.c - vec3d.c;
/*      */           
/*  816 */           if (flag3) {
/*  817 */             d3 = (d0 - vec3d.a) / d6;
/*      */           }
/*      */           
/*  820 */           if (flag4) {
/*  821 */             d4 = (d1 - vec3d.b) / d7;
/*      */           }
/*      */           
/*  824 */           if (flag5) {
/*  825 */             d5 = (d2 - vec3d.c) / d8;
/*      */           }
/*      */           
/*  828 */           boolean flag6 = false;
/*      */ 
/*      */           
/*  831 */           if (d3 < d4 && d3 < d5) {
/*  832 */             if (i > l) {
/*  833 */               b0 = 4;
/*      */             } else {
/*  835 */               b0 = 5;
/*      */             } 
/*      */             
/*  838 */             vec3d.a = d0;
/*  839 */             vec3d.b += d7 * d3;
/*  840 */             vec3d.c += d8 * d3;
/*  841 */           } else if (d4 < d5) {
/*  842 */             if (j > i1) {
/*  843 */               b0 = 0;
/*      */             } else {
/*  845 */               b0 = 1;
/*      */             } 
/*      */             
/*  848 */             vec3d.a += d6 * d4;
/*  849 */             vec3d.b = d1;
/*  850 */             vec3d.c += d8 * d4;
/*      */           } else {
/*  852 */             if (k > j1) {
/*  853 */               b0 = 2;
/*      */             } else {
/*  855 */               b0 = 3;
/*      */             } 
/*      */             
/*  858 */             vec3d.a += d6 * d5;
/*  859 */             vec3d.b += d7 * d5;
/*  860 */             vec3d.c = d2;
/*      */           } 
/*      */           
/*  863 */           Vec3D vec3d2 = Vec3D.a(vec3d.a, vec3d.b, vec3d.c);
/*      */           
/*  865 */           l = (int)(vec3d2.a = MathHelper.floor(vec3d.a));
/*  866 */           if (b0 == 5) {
/*  867 */             l--;
/*  868 */             vec3d2.a++;
/*      */           } 
/*      */           
/*  871 */           i1 = (int)(vec3d2.b = MathHelper.floor(vec3d.b));
/*  872 */           if (b0 == 1) {
/*  873 */             i1--;
/*  874 */             vec3d2.b++;
/*      */           } 
/*      */           
/*  877 */           j1 = (int)(vec3d2.c = MathHelper.floor(vec3d.c));
/*  878 */           if (b0 == 3) {
/*  879 */             j1--;
/*  880 */             vec3d2.c++;
/*      */           } 
/*      */           
/*  883 */           Block block1 = getType(l, i1, j1);
/*  884 */           int l1 = getData(l, i1, j1);
/*      */           
/*  886 */           if (!flag1 || block1.a(this, l, i1, j1) != null) {
/*  887 */             if (block1.a(l1, flag)) {
/*  888 */               MovingObjectPosition movingobjectposition2 = block1.a(this, l, i1, j1, vec3d, vec3d1);
/*      */               
/*  890 */               if (movingobjectposition2 != null)
/*  891 */                 return movingobjectposition2; 
/*      */               continue;
/*      */             } 
/*  894 */             movingobjectposition1 = new MovingObjectPosition(l, i1, j1, b0, vec3d, false);
/*      */           } 
/*      */         } 
/*      */ 
/*      */         
/*  899 */         return flag2 ? movingobjectposition1 : null;
/*      */       } 
/*  901 */       return null;
/*      */     } 
/*      */     
/*  904 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public void makeSound(Entity entity, String s, float f, float f1) {
/*  909 */     for (int i = 0; i < this.u.size(); i++) {
/*  910 */       ((IWorldAccess)this.u.get(i)).a(s, entity.locX, entity.locY - entity.height, entity.locZ, f, f1);
/*      */     }
/*      */   }
/*      */   
/*      */   public void a(EntityHuman entityhuman, String s, float f, float f1) {
/*  915 */     for (int i = 0; i < this.u.size(); i++) {
/*  916 */       ((IWorldAccess)this.u.get(i)).a(entityhuman, s, entityhuman.locX, entityhuman.locY - entityhuman.height, entityhuman.locZ, f, f1);
/*      */     }
/*      */   }
/*      */   
/*      */   public void makeSound(double d0, double d1, double d2, String s, float f, float f1) {
/*  921 */     for (int i = 0; i < this.u.size(); i++) {
/*  922 */       ((IWorldAccess)this.u.get(i)).a(s, d0, d1, d2, f, f1);
/*      */     }
/*      */   }
/*      */   
/*      */   public void a(double d0, double d1, double d2, String s, float f, float f1, boolean flag) {}
/*      */   
/*      */   public void a(String s, int i, int j, int k) {
/*  929 */     for (int l = 0; l < this.u.size(); l++) {
/*  930 */       ((IWorldAccess)this.u.get(l)).a(s, i, j, k);
/*      */     }
/*      */   }
/*      */   
/*      */   public void addParticle(String s, double d0, double d1, double d2, double d3, double d4, double d5) {
/*  935 */     for (int i = 0; i < this.u.size(); i++) {
/*  936 */       ((IWorldAccess)this.u.get(i)).a(s, d0, d1, d2, d3, d4, d5);
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean strikeLightning(Entity entity) {
/*  941 */     this.i.add(entity);
/*  942 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean addEntity(Entity entity) {
/*  947 */     return addEntity(entity, CreatureSpawnEvent.SpawnReason.DEFAULT);
/*      */   }
/*      */   public boolean addEntity(Entity entity, CreatureSpawnEvent.SpawnReason spawnReason) {
/*      */     ProjectileLaunchEvent projectileLaunchEvent;
/*  951 */     if (entity == null) return false;
/*      */ 
/*      */     
/*  954 */     int i = MathHelper.floor(entity.locX / 16.0D);
/*  955 */     int j = MathHelper.floor(entity.locZ / 16.0D);
/*  956 */     boolean flag = entity.attachedToPlayer;
/*      */     
/*  958 */     if (entity instanceof EntityHuman) {
/*  959 */       flag = true;
/*      */     }
/*      */ 
/*      */     
/*  963 */     Cancellable event = null;
/*  964 */     if (entity instanceof EntityLiving && !(entity instanceof EntityPlayer)) {
/*  965 */       boolean isAnimal = (entity instanceof EntityAnimal || entity instanceof EntityWaterAnimal || entity instanceof EntityGolem);
/*  966 */       boolean isMonster = (entity instanceof EntityMonster || entity instanceof EntityGhast || entity instanceof EntitySlime);
/*      */       
/*  968 */       if (spawnReason != CreatureSpawnEvent.SpawnReason.CUSTOM && ((
/*  969 */         isAnimal && !this.allowAnimals) || (isMonster && !this.allowMonsters))) {
/*  970 */         entity.dead = true;
/*  971 */         return false;
/*      */       } 
/*      */ 
/*      */       
/*  975 */       CreatureSpawnEvent creatureSpawnEvent = CraftEventFactory.callCreatureSpawnEvent((EntityLiving)entity, spawnReason);
/*  976 */     } else if (entity instanceof EntityItem) {
/*  977 */       ItemSpawnEvent itemSpawnEvent = CraftEventFactory.callItemSpawnEvent((EntityItem)entity);
/*  978 */     } else if (entity.getBukkitEntity() instanceof org.bukkit.entity.Projectile) {
/*      */       
/*  980 */       projectileLaunchEvent = CraftEventFactory.callProjectileLaunchEvent(entity);
/*      */     } 
/*      */     
/*  983 */     if (projectileLaunchEvent != null && (projectileLaunchEvent.isCancelled() || entity.dead)) {
/*  984 */       entity.dead = true;
/*  985 */       return false;
/*      */     } 
/*      */ 
/*      */     
/*  989 */     if (!flag && !isChunkLoaded(i, j)) {
/*  990 */       entity.dead = true;
/*  991 */       return false;
/*      */     } 
/*  993 */     if (entity instanceof EntityHuman) {
/*  994 */       EntityHuman entityhuman = (EntityHuman)entity;
/*      */       
/*  996 */       this.players.add(entityhuman);
/*  997 */       everyoneSleeping();
/*  998 */       b(entity);
/*      */     } 
/*      */     
/* 1001 */     getChunkAt(i, j).a(entity);
/* 1002 */     this.entityList.add(entity);
/* 1003 */     a(entity);
/* 1004 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void a(Entity entity) {
/* 1009 */     for (int i = 0; i < this.u.size(); i++) {
/* 1010 */       ((IWorldAccess)this.u.get(i)).a(entity);
/*      */     }
/*      */     
/* 1013 */     entity.valid = true;
/*      */   }
/*      */   
/*      */   protected void b(Entity entity) {
/* 1017 */     for (int i = 0; i < this.u.size(); i++) {
/* 1018 */       ((IWorldAccess)this.u.get(i)).b(entity);
/*      */     }
/*      */     
/* 1021 */     entity.valid = false;
/*      */   }
/*      */   
/*      */   public void kill(Entity entity) {
/* 1025 */     if (entity.passenger != null) {
/* 1026 */       entity.passenger.mount((Entity)null);
/*      */     }
/*      */     
/* 1029 */     if (entity.vehicle != null) {
/* 1030 */       entity.mount((Entity)null);
/*      */     }
/*      */     
/* 1033 */     entity.die();
/* 1034 */     if (entity instanceof EntityHuman) {
/* 1035 */       this.players.remove(entity);
/* 1036 */       everyoneSleeping();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void removeEntity(Entity entity) {
/* 1041 */     entity.die();
/* 1042 */     if (entity instanceof EntityHuman) {
/* 1043 */       this.players.remove(entity);
/* 1044 */       everyoneSleeping();
/*      */     } 
/*      */     
/* 1047 */     int i = entity.ah;
/* 1048 */     int j = entity.aj;
/*      */     
/* 1050 */     if (entity.ag && isChunkLoaded(i, j)) {
/* 1051 */       getChunkAt(i, j).b(entity);
/*      */     }
/*      */ 
/*      */     
/* 1055 */     int index = this.entityList.indexOf(entity);
/* 1056 */     if (index != -1) {
/* 1057 */       if (index <= this.tickPosition) {
/* 1058 */         this.tickPosition--;
/*      */       }
/* 1060 */       this.entityList.remove(index);
/*      */     } 
/*      */ 
/*      */     
/* 1064 */     b(entity);
/*      */   }
/*      */   
/*      */   public void addIWorldAccess(IWorldAccess iworldaccess) {
/* 1068 */     this.u.add(iworldaccess);
/*      */   }
/*      */   
/*      */   public List getCubes(Entity entity, AxisAlignedBB axisalignedbb) {
/* 1072 */     this.L.clear();
/* 1073 */     int i = MathHelper.floor(axisalignedbb.a);
/* 1074 */     int j = MathHelper.floor(axisalignedbb.d + 1.0D);
/* 1075 */     int k = MathHelper.floor(axisalignedbb.b);
/* 1076 */     int l = MathHelper.floor(axisalignedbb.e + 1.0D);
/* 1077 */     int i1 = MathHelper.floor(axisalignedbb.c);
/* 1078 */     int j1 = MathHelper.floor(axisalignedbb.f + 1.0D);
/*      */     
/* 1080 */     for (int k1 = i; k1 < j; k1++) {
/* 1081 */       for (int l1 = i1; l1 < j1; l1++) {
/* 1082 */         if (isLoaded(k1, 64, l1)) {
/* 1083 */           for (int i2 = k - 1; i2 < l; i2++) {
/*      */             Block block;
/*      */             
/* 1086 */             if (k1 >= -30000000 && k1 < 30000000 && l1 >= -30000000 && l1 < 30000000) {
/* 1087 */               block = getType(k1, i2, l1);
/*      */             } else {
/* 1089 */               block = Blocks.STONE;
/*      */             } 
/*      */             
/* 1092 */             block.a(this, k1, i2, l1, axisalignedbb, this.L, entity);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1098 */     double d0 = 0.25D;
/* 1099 */     List<Entity> list = getEntities(entity, axisalignedbb.grow(d0, d0, d0));
/*      */     
/* 1101 */     for (int j2 = 0; j2 < list.size(); j2++) {
/* 1102 */       AxisAlignedBB axisalignedbb1 = ((Entity)list.get(j2)).J();
/*      */       
/* 1104 */       if (axisalignedbb1 != null && axisalignedbb1.b(axisalignedbb)) {
/* 1105 */         this.L.add(axisalignedbb1);
/*      */       }
/*      */       
/* 1108 */       axisalignedbb1 = entity.h(list.get(j2));
/* 1109 */       if (axisalignedbb1 != null && axisalignedbb1.b(axisalignedbb)) {
/* 1110 */         this.L.add(axisalignedbb1);
/*      */       }
/*      */     } 
/*      */     
/* 1114 */     return this.L;
/*      */   }
/*      */   
/*      */   public List a(AxisAlignedBB axisalignedbb) {
/* 1118 */     this.L.clear();
/* 1119 */     int i = MathHelper.floor(axisalignedbb.a);
/* 1120 */     int j = MathHelper.floor(axisalignedbb.d + 1.0D);
/* 1121 */     int k = MathHelper.floor(axisalignedbb.b);
/* 1122 */     int l = MathHelper.floor(axisalignedbb.e + 1.0D);
/* 1123 */     int i1 = MathHelper.floor(axisalignedbb.c);
/* 1124 */     int j1 = MathHelper.floor(axisalignedbb.f + 1.0D);
/*      */     
/* 1126 */     for (int k1 = i; k1 < j; k1++) {
/* 1127 */       for (int l1 = i1; l1 < j1; l1++) {
/* 1128 */         if (isLoaded(k1, 64, l1)) {
/* 1129 */           for (int i2 = k - 1; i2 < l; i2++) {
/*      */             Block block;
/*      */             
/* 1132 */             if (k1 >= -30000000 && k1 < 30000000 && l1 >= -30000000 && l1 < 30000000) {
/* 1133 */               block = getType(k1, i2, l1);
/*      */             } else {
/* 1135 */               block = Blocks.BEDROCK;
/*      */             } 
/*      */             
/* 1138 */             block.a(this, k1, i2, l1, axisalignedbb, this.L, (Entity)null);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 1144 */     return this.L;
/*      */   }
/*      */   
/*      */   public int a(float f) {
/* 1148 */     float f1 = c(f);
/* 1149 */     float f2 = 1.0F - MathHelper.cos(f1 * 3.1415927F * 2.0F) * 2.0F + 0.5F;
/*      */     
/* 1151 */     if (f2 < 0.0F) {
/* 1152 */       f2 = 0.0F;
/*      */     }
/*      */     
/* 1155 */     if (f2 > 1.0F) {
/* 1156 */       f2 = 1.0F;
/*      */     }
/*      */     
/* 1159 */     f2 = 1.0F - f2;
/* 1160 */     f2 = (float)(f2 * (1.0D - (j(f) * 5.0F) / 16.0D));
/* 1161 */     f2 = (float)(f2 * (1.0D - (h(f) * 5.0F) / 16.0D));
/* 1162 */     f2 = 1.0F - f2;
/* 1163 */     return (int)(f2 * 11.0F);
/*      */   }
/*      */   
/*      */   public float c(float f) {
/* 1167 */     return this.worldProvider.a(this.worldData.getDayTime(), f);
/*      */   }
/*      */   
/*      */   public float y() {
/* 1171 */     return WorldProvider.a[this.worldProvider.a(this.worldData.getDayTime())];
/*      */   }
/*      */   
/*      */   public float d(float f) {
/* 1175 */     float f1 = c(f);
/*      */     
/* 1177 */     return f1 * 3.1415927F * 2.0F;
/*      */   }
/*      */   
/*      */   public int h(int i, int j) {
/* 1181 */     return getChunkAtWorldCoords(i, j).d(i & 0xF, j & 0xF);
/*      */   }
/*      */   
/*      */   public int i(int i, int j) {
/* 1185 */     Chunk chunk = getChunkAtWorldCoords(i, j);
/* 1186 */     int k = chunk.h() + 15;
/*      */     
/* 1188 */     i &= 0xF;
/*      */     
/* 1190 */     for (j &= 0xF; k > 0; k--) {
/* 1191 */       Block block = chunk.getType(i, k, j);
/*      */       
/* 1193 */       if (block.getMaterial().isSolid() && block.getMaterial() != Material.LEAVES) {
/* 1194 */         return k + 1;
/*      */       }
/*      */     } 
/*      */     
/* 1198 */     return -1;
/*      */   }
/*      */   
/*      */   public void a(int i, int j, int k, Block block, int l) {}
/*      */   
/*      */   public void a(int i, int j, int k, Block block, int l, int i1) {}
/*      */   
/*      */   public void b(int i, int j, int k, Block block, int l, int i1) {}
/*      */   
/*      */   public void tickEntities() {
/* 1208 */     this.methodProfiler.a("entities");
/* 1209 */     this.methodProfiler.a("global");
/*      */ 
/*      */ 
/*      */     
/*      */     int i;
/*      */ 
/*      */     
/* 1216 */     for (i = 0; i < this.i.size(); i++) {
/* 1217 */       Entity entity = this.i.get(i);
/*      */       
/* 1219 */       if (entity != null) {
/*      */ 
/*      */         
/*      */         try {
/*      */ 
/*      */           
/* 1225 */           entity.ticksLived++;
/* 1226 */           entity.h();
/* 1227 */         } catch (Throwable throwable) {
/* 1228 */           CrashReport crashreport = CrashReport.a(throwable, "Ticking entity");
/* 1229 */           CrashReportSystemDetails crashreportsystemdetails = crashreport.a("Entity being ticked");
/* 1230 */           if (entity == null) {
/* 1231 */             crashreportsystemdetails.a("Entity", "~~NULL~~");
/*      */           } else {
/* 1233 */             entity.a(crashreportsystemdetails);
/*      */           } 
/*      */           
/* 1236 */           throw new ReportedException(crashreport);
/*      */         } 
/*      */         
/* 1239 */         if (entity.dead) {
/* 1240 */           this.i.remove(i--);
/*      */         }
/*      */       } 
/*      */     } 
/* 1244 */     this.methodProfiler.c("remove");
/* 1245 */     this.entityList.removeAll(this.f);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1250 */     for (i = 0; i < this.f.size(); i++) {
/* 1251 */       Entity entity = this.f.get(i);
/* 1252 */       int j = entity.ah;
/* 1253 */       int k = entity.aj;
/* 1254 */       if (entity.ag && isChunkLoaded(j, k)) {
/* 1255 */         getChunkAt(j, k).b(entity);
/*      */       }
/*      */     } 
/*      */     
/* 1259 */     for (i = 0; i < this.f.size(); i++) {
/* 1260 */       b(this.f.get(i));
/*      */     }
/*      */     
/* 1263 */     this.f.clear();
/* 1264 */     this.methodProfiler.c("regular");
/*      */ 
/*      */     
/* 1267 */     for (this.tickPosition = 0; this.tickPosition < this.entityList.size(); this.tickPosition++) {
/* 1268 */       Entity entity = this.entityList.get(this.tickPosition);
/* 1269 */       if (entity.vehicle != null) {
/* 1270 */         if (!entity.vehicle.dead && entity.vehicle.passenger == entity) {
/*      */           continue;
/*      */         }
/*      */         
/* 1274 */         entity.vehicle.passenger = null;
/* 1275 */         entity.vehicle = null;
/*      */       } 
/*      */       
/* 1278 */       this.methodProfiler.a("tick");
/* 1279 */       if (!entity.dead) {
/*      */         try {
/* 1281 */           playerJoinedWorld(entity);
/* 1282 */         } catch (Throwable throwable1) {
/* 1283 */           CrashReport crashreport = CrashReport.a(throwable1, "Ticking entity");
/* 1284 */           CrashReportSystemDetails crashreportsystemdetails = crashreport.a("Entity being ticked");
/* 1285 */           entity.a(crashreportsystemdetails);
/* 1286 */           throw new ReportedException(crashreport);
/*      */         } 
/*      */       }
/*      */       
/* 1290 */       this.methodProfiler.b();
/* 1291 */       this.methodProfiler.a("remove");
/* 1292 */       if (entity.dead) {
/* 1293 */         int j = entity.ah;
/* 1294 */         int k = entity.aj;
/* 1295 */         if (entity.ag && isChunkLoaded(j, k)) {
/* 1296 */           getChunkAt(j, k).b(entity);
/*      */         }
/*      */         
/* 1299 */         this.entityList.remove(this.tickPosition--);
/* 1300 */         b(entity);
/*      */       } 
/*      */       
/* 1303 */       this.methodProfiler.b();
/*      */       continue;
/*      */     } 
/* 1306 */     this.methodProfiler.c("blockEntities");
/* 1307 */     this.M = true;
/*      */     
/* 1309 */     if (!this.b.isEmpty()) {
/* 1310 */       this.tileEntityList.removeAll(this.b);
/* 1311 */       this.b.clear();
/*      */     } 
/*      */ 
/*      */     
/* 1315 */     Iterator<TileEntity> iterator = this.tileEntityList.iterator();
/*      */     
/* 1317 */     while (iterator.hasNext()) {
/* 1318 */       TileEntity tileentity = iterator.next();
/*      */       
/* 1320 */       if (!tileentity.r() && tileentity.o() && isLoaded(tileentity.x, tileentity.y, tileentity.z)) {
/*      */         try {
/* 1322 */           tileentity.h();
/* 1323 */         } catch (Throwable throwable2) {
/* 1324 */           CrashReport crashreport = CrashReport.a(throwable2, "Ticking block entity");
/* 1325 */           CrashReportSystemDetails crashreportsystemdetails = crashreport.a("Block entity being ticked");
/* 1326 */           tileentity.a(crashreportsystemdetails);
/* 1327 */           throw new ReportedException(crashreport);
/*      */         } 
/*      */       }
/*      */       
/* 1331 */       if (tileentity.r()) {
/* 1332 */         iterator.remove();
/* 1333 */         if (isChunkLoaded(tileentity.x >> 4, tileentity.z >> 4)) {
/* 1334 */           Chunk chunk = getChunkAt(tileentity.x >> 4, tileentity.z >> 4);
/*      */           
/* 1336 */           if (chunk != null) {
/* 1337 */             chunk.f(tileentity.x & 0xF, tileentity.y, tileentity.z & 0xF);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1343 */     this.M = false;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1351 */     this.methodProfiler.c("pendingBlockEntities");
/* 1352 */     if (!this.a.isEmpty()) {
/* 1353 */       for (int l = 0; l < this.a.size(); l++) {
/* 1354 */         TileEntity tileentity1 = this.a.get(l);
/*      */         
/* 1356 */         if (!tileentity1.r()) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 1363 */           if (isChunkLoaded(tileentity1.x >> 4, tileentity1.z >> 4)) {
/* 1364 */             Chunk chunk1 = getChunkAt(tileentity1.x >> 4, tileentity1.z >> 4);
/*      */             
/* 1366 */             if (chunk1 != null) {
/* 1367 */               chunk1.a(tileentity1.x & 0xF, tileentity1.y, tileentity1.z & 0xF, tileentity1);
/*      */               
/* 1369 */               if (!this.tileEntityList.contains(tileentity1)) {
/* 1370 */                 this.tileEntityList.add(tileentity1);
/*      */               }
/*      */             } 
/*      */           } 
/*      */ 
/*      */           
/* 1376 */           notify(tileentity1.x, tileentity1.y, tileentity1.z);
/*      */         } 
/*      */       } 
/*      */       
/* 1380 */       this.a.clear();
/*      */     } 
/*      */     
/* 1383 */     this.methodProfiler.b();
/* 1384 */     this.methodProfiler.b();
/*      */   }
/*      */   
/*      */   public void a(Collection collection) {
/* 1388 */     if (this.M) {
/* 1389 */       this.a.addAll(collection);
/*      */     } else {
/* 1391 */       this.tileEntityList.addAll(collection);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void playerJoinedWorld(Entity entity) {
/* 1396 */     entityJoinedWorld(entity, true);
/*      */   }
/*      */   
/*      */   public void entityJoinedWorld(Entity entity, boolean flag) {
/* 1400 */     int i = MathHelper.floor(entity.locX);
/* 1401 */     int j = MathHelper.floor(entity.locZ);
/* 1402 */     byte b0 = 32;
/*      */ 
/*      */     
/* 1405 */     Chunk startingChunk = getChunkIfLoaded(i >> 4, j >> 4);
/* 1406 */     if (!flag || (startingChunk != null && startingChunk.areNeighborsLoaded(2))) {
/*      */       
/* 1408 */       entity.S = entity.locX;
/* 1409 */       entity.T = entity.locY;
/* 1410 */       entity.U = entity.locZ;
/* 1411 */       entity.lastYaw = entity.yaw;
/* 1412 */       entity.lastPitch = entity.pitch;
/* 1413 */       if (flag && entity.ag) {
/* 1414 */         entity.ticksLived++;
/* 1415 */         if (entity.vehicle != null) {
/* 1416 */           entity.ab();
/*      */         } else {
/* 1418 */           entity.h();
/*      */         } 
/*      */       } 
/*      */       
/* 1422 */       this.methodProfiler.a("chunkCheck");
/* 1423 */       if (Double.isNaN(entity.locX) || Double.isInfinite(entity.locX)) {
/* 1424 */         entity.locX = entity.S;
/*      */       }
/*      */       
/* 1427 */       if (Double.isNaN(entity.locY) || Double.isInfinite(entity.locY)) {
/* 1428 */         entity.locY = entity.T;
/*      */       }
/*      */       
/* 1431 */       if (Double.isNaN(entity.locZ) || Double.isInfinite(entity.locZ)) {
/* 1432 */         entity.locZ = entity.U;
/*      */       }
/*      */       
/* 1435 */       if (Double.isNaN(entity.pitch) || Double.isInfinite(entity.pitch)) {
/* 1436 */         entity.pitch = entity.lastPitch;
/*      */       }
/*      */       
/* 1439 */       if (Double.isNaN(entity.yaw) || Double.isInfinite(entity.yaw)) {
/* 1440 */         entity.yaw = entity.lastYaw;
/*      */       }
/*      */       
/* 1443 */       int k = MathHelper.floor(entity.locX / 16.0D);
/* 1444 */       int l = MathHelper.floor(entity.locY / 16.0D);
/* 1445 */       int i1 = MathHelper.floor(entity.locZ / 16.0D);
/*      */       
/* 1447 */       if (!entity.ag || entity.ah != k || entity.ai != l || entity.aj != i1) {
/* 1448 */         if (entity.ag && isChunkLoaded(entity.ah, entity.aj)) {
/* 1449 */           getChunkAt(entity.ah, entity.aj).a(entity, entity.ai);
/*      */         }
/*      */         
/* 1452 */         if (isChunkLoaded(k, i1)) {
/* 1453 */           entity.ag = true;
/* 1454 */           getChunkAt(k, i1).a(entity);
/*      */         } else {
/* 1456 */           entity.ag = false;
/*      */         } 
/*      */       } 
/*      */       
/* 1460 */       this.methodProfiler.b();
/* 1461 */       if (flag && entity.ag && entity.passenger != null) {
/* 1462 */         if (!entity.passenger.dead && entity.passenger.vehicle == entity) {
/* 1463 */           playerJoinedWorld(entity.passenger);
/*      */         } else {
/* 1465 */           entity.passenger.vehicle = null;
/* 1466 */           entity.passenger = null;
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean b(AxisAlignedBB axisalignedbb) {
/* 1473 */     return a(axisalignedbb, (Entity)null);
/*      */   }
/*      */   
/*      */   public boolean a(AxisAlignedBB axisalignedbb, Entity entity) {
/* 1477 */     List<Entity> list = getEntities((Entity)null, axisalignedbb);
/*      */     
/* 1479 */     for (int i = 0; i < list.size(); i++) {
/* 1480 */       Entity entity1 = list.get(i);
/*      */       
/* 1482 */       if (!entity1.dead && entity1.k && entity1 != entity) {
/* 1483 */         return false;
/*      */       }
/*      */     } 
/*      */     
/* 1487 */     return true;
/*      */   }
/*      */   
/*      */   public boolean c(AxisAlignedBB axisalignedbb) {
/* 1491 */     int i = MathHelper.floor(axisalignedbb.a);
/* 1492 */     int j = MathHelper.floor(axisalignedbb.d + 1.0D);
/* 1493 */     int k = MathHelper.floor(axisalignedbb.b);
/* 1494 */     int l = MathHelper.floor(axisalignedbb.e + 1.0D);
/* 1495 */     int i1 = MathHelper.floor(axisalignedbb.c);
/* 1496 */     int j1 = MathHelper.floor(axisalignedbb.f + 1.0D);
/*      */     
/* 1498 */     if (axisalignedbb.a < 0.0D) {
/* 1499 */       i--;
/*      */     }
/*      */     
/* 1502 */     if (axisalignedbb.b < 0.0D) {
/* 1503 */       k--;
/*      */     }
/*      */     
/* 1506 */     if (axisalignedbb.c < 0.0D) {
/* 1507 */       i1--;
/*      */     }
/*      */     
/* 1510 */     for (int k1 = i; k1 < j; k1++) {
/* 1511 */       for (int l1 = k; l1 < l; l1++) {
/* 1512 */         for (int i2 = i1; i2 < j1; i2++) {
/* 1513 */           Block block = getType(k1, l1, i2);
/*      */           
/* 1515 */           if (block.getMaterial() != Material.AIR) {
/* 1516 */             return true;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1522 */     return false;
/*      */   }
/*      */   
/*      */   public boolean containsLiquid(AxisAlignedBB axisalignedbb) {
/* 1526 */     int i = MathHelper.floor(axisalignedbb.a);
/* 1527 */     int j = MathHelper.floor(axisalignedbb.d + 1.0D);
/* 1528 */     int k = MathHelper.floor(axisalignedbb.b);
/* 1529 */     int l = MathHelper.floor(axisalignedbb.e + 1.0D);
/* 1530 */     int i1 = MathHelper.floor(axisalignedbb.c);
/* 1531 */     int j1 = MathHelper.floor(axisalignedbb.f + 1.0D);
/*      */     
/* 1533 */     if (axisalignedbb.a < 0.0D) {
/* 1534 */       i--;
/*      */     }
/*      */     
/* 1537 */     if (axisalignedbb.b < 0.0D) {
/* 1538 */       k--;
/*      */     }
/*      */     
/* 1541 */     if (axisalignedbb.c < 0.0D) {
/* 1542 */       i1--;
/*      */     }
/*      */     
/* 1545 */     for (int k1 = i; k1 < j; k1++) {
/* 1546 */       for (int l1 = k; l1 < l; l1++) {
/* 1547 */         for (int i2 = i1; i2 < j1; i2++) {
/* 1548 */           Block block = getType(k1, l1, i2);
/*      */           
/* 1550 */           if (block.getMaterial().isLiquid()) {
/* 1551 */             return true;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1557 */     return false;
/*      */   }
/*      */   
/*      */   public boolean e(AxisAlignedBB axisalignedbb) {
/* 1561 */     int i = MathHelper.floor(axisalignedbb.a);
/* 1562 */     int j = MathHelper.floor(axisalignedbb.d + 1.0D);
/* 1563 */     int k = MathHelper.floor(axisalignedbb.b);
/* 1564 */     int l = MathHelper.floor(axisalignedbb.e + 1.0D);
/* 1565 */     int i1 = MathHelper.floor(axisalignedbb.c);
/* 1566 */     int j1 = MathHelper.floor(axisalignedbb.f + 1.0D);
/*      */     
/* 1568 */     if (b(i, k, i1, j, l, j1)) {
/* 1569 */       for (int k1 = i; k1 < j; k1++) {
/* 1570 */         for (int l1 = k; l1 < l; l1++) {
/* 1571 */           for (int i2 = i1; i2 < j1; i2++) {
/* 1572 */             Block block = getType(k1, l1, i2);
/*      */             
/* 1574 */             if (block == Blocks.FIRE || block == Blocks.LAVA || block == Blocks.STATIONARY_LAVA) {
/* 1575 */               return true;
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/* 1582 */     return false;
/*      */   }
/*      */   
/*      */   public boolean a(AxisAlignedBB axisalignedbb, Material material, Entity entity) {
/* 1586 */     int i = MathHelper.floor(axisalignedbb.a);
/* 1587 */     int j = MathHelper.floor(axisalignedbb.d + 1.0D);
/* 1588 */     int k = MathHelper.floor(axisalignedbb.b);
/* 1589 */     int l = MathHelper.floor(axisalignedbb.e + 1.0D);
/* 1590 */     int i1 = MathHelper.floor(axisalignedbb.c);
/* 1591 */     int j1 = MathHelper.floor(axisalignedbb.f + 1.0D);
/*      */     
/* 1593 */     if (!b(i, k, i1, j, l, j1)) {
/* 1594 */       return false;
/*      */     }
/* 1596 */     boolean flag = false;
/* 1597 */     Vec3D vec3d = Vec3D.a(0.0D, 0.0D, 0.0D);
/*      */     
/* 1599 */     for (int k1 = i; k1 < j; k1++) {
/* 1600 */       for (int l1 = k; l1 < l; l1++) {
/* 1601 */         for (int i2 = i1; i2 < j1; i2++) {
/* 1602 */           Block block = getType(k1, l1, i2);
/*      */           
/* 1604 */           if (block.getMaterial() == material) {
/* 1605 */             double d0 = ((l1 + 1) - BlockFluids.b(getData(k1, l1, i2)));
/*      */             
/* 1607 */             if (l >= d0) {
/* 1608 */               flag = true;
/* 1609 */               block.a(this, k1, l1, i2, entity, vec3d);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1616 */     if (vec3d.b() > 0.0D && entity.aC()) {
/* 1617 */       vec3d = vec3d.a();
/* 1618 */       double d1 = 0.014D;
/*      */       
/* 1620 */       entity.motX += vec3d.a * d1;
/* 1621 */       entity.motY += vec3d.b * d1;
/* 1622 */       entity.motZ += vec3d.c * d1;
/*      */     } 
/*      */     
/* 1625 */     return flag;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean a(AxisAlignedBB axisalignedbb, Material material) {
/* 1630 */     int i = MathHelper.floor(axisalignedbb.a);
/* 1631 */     int j = MathHelper.floor(axisalignedbb.d + 1.0D);
/* 1632 */     int k = MathHelper.floor(axisalignedbb.b);
/* 1633 */     int l = MathHelper.floor(axisalignedbb.e + 1.0D);
/* 1634 */     int i1 = MathHelper.floor(axisalignedbb.c);
/* 1635 */     int j1 = MathHelper.floor(axisalignedbb.f + 1.0D);
/*      */     
/* 1637 */     for (int k1 = i; k1 < j; k1++) {
/* 1638 */       for (int l1 = k; l1 < l; l1++) {
/* 1639 */         for (int i2 = i1; i2 < j1; i2++) {
/* 1640 */           if (getType(k1, l1, i2).getMaterial() == material) {
/* 1641 */             return true;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1647 */     return false;
/*      */   }
/*      */   
/*      */   public boolean b(AxisAlignedBB axisalignedbb, Material material) {
/* 1651 */     int i = MathHelper.floor(axisalignedbb.a);
/* 1652 */     int j = MathHelper.floor(axisalignedbb.d + 1.0D);
/* 1653 */     int k = MathHelper.floor(axisalignedbb.b);
/* 1654 */     int l = MathHelper.floor(axisalignedbb.e + 1.0D);
/* 1655 */     int i1 = MathHelper.floor(axisalignedbb.c);
/* 1656 */     int j1 = MathHelper.floor(axisalignedbb.f + 1.0D);
/*      */     
/* 1658 */     for (int k1 = i; k1 < j; k1++) {
/* 1659 */       for (int l1 = k; l1 < l; l1++) {
/* 1660 */         for (int i2 = i1; i2 < j1; i2++) {
/* 1661 */           Block block = getType(k1, l1, i2);
/*      */           
/* 1663 */           if (block.getMaterial() == material) {
/* 1664 */             int j2 = getData(k1, l1, i2);
/* 1665 */             double d0 = (l1 + 1);
/*      */             
/* 1667 */             if (j2 < 8) {
/* 1668 */               d0 = (l1 + 1) - j2 / 8.0D;
/*      */             }
/*      */             
/* 1671 */             if (d0 >= axisalignedbb.b) {
/* 1672 */               return true;
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1679 */     return false;
/*      */   }
/*      */   
/*      */   public Explosion explode(Entity entity, double d0, double d1, double d2, float f, boolean flag) {
/* 1683 */     return createExplosion(entity, d0, d1, d2, f, false, flag);
/*      */   }
/*      */   
/*      */   public Explosion createExplosion(Entity entity, double d0, double d1, double d2, float f, boolean flag, boolean flag1) {
/* 1687 */     Explosion explosion = new Explosion(this, entity, d0, d1, d2, f);
/*      */     
/* 1689 */     explosion.a = flag;
/* 1690 */     explosion.b = flag1;
/* 1691 */     explosion.a();
/* 1692 */     explosion.a(true);
/* 1693 */     return explosion;
/*      */   }
/*      */   
/*      */   public float a(Vec3D vec3d, AxisAlignedBB axisalignedbb) {
/* 1697 */     double d0 = 1.0D / ((axisalignedbb.d - axisalignedbb.a) * 2.0D + 1.0D);
/* 1698 */     double d1 = 1.0D / ((axisalignedbb.e - axisalignedbb.b) * 2.0D + 1.0D);
/* 1699 */     double d2 = 1.0D / ((axisalignedbb.f - axisalignedbb.c) * 2.0D + 1.0D);
/*      */     
/* 1701 */     if (d0 >= 0.0D && d1 >= 0.0D && d2 >= 0.0D) {
/* 1702 */       int i = 0;
/* 1703 */       int j = 0;
/*      */       
/* 1705 */       Vec3D vec3d2 = Vec3D.a(0.0D, 0.0D, 0.0D); float f;
/* 1706 */       for (f = 0.0F; f <= 1.0F; f = (float)(f + d0)) {
/* 1707 */         float f1; for (f1 = 0.0F; f1 <= 1.0F; f1 = (float)(f1 + d1)) {
/* 1708 */           float f2; for (f2 = 0.0F; f2 <= 1.0F; f2 = (float)(f2 + d2)) {
/* 1709 */             double d3 = axisalignedbb.a + (axisalignedbb.d - axisalignedbb.a) * f;
/* 1710 */             double d4 = axisalignedbb.b + (axisalignedbb.e - axisalignedbb.b) * f1;
/* 1711 */             double d5 = axisalignedbb.c + (axisalignedbb.f - axisalignedbb.c) * f2;
/*      */             
/* 1713 */             if (a(vec3d2.b(d3, d4, d5), vec3d) == null) {
/* 1714 */               i++;
/*      */             }
/*      */             
/* 1717 */             j++;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 1722 */       return i / j;
/*      */     } 
/* 1724 */     return 0.0F;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean douseFire(EntityHuman entityhuman, int i, int j, int k, int l) {
/* 1729 */     if (l == 0) {
/* 1730 */       j--;
/*      */     }
/*      */     
/* 1733 */     if (l == 1) {
/* 1734 */       j++;
/*      */     }
/*      */     
/* 1737 */     if (l == 2) {
/* 1738 */       k--;
/*      */     }
/*      */     
/* 1741 */     if (l == 3) {
/* 1742 */       k++;
/*      */     }
/*      */     
/* 1745 */     if (l == 4) {
/* 1746 */       i--;
/*      */     }
/*      */     
/* 1749 */     if (l == 5) {
/* 1750 */       i++;
/*      */     }
/*      */     
/* 1753 */     if (getType(i, j, k) == Blocks.FIRE) {
/* 1754 */       a(entityhuman, 1004, i, j, k, 0);
/* 1755 */       setAir(i, j, k);
/* 1756 */       return true;
/*      */     } 
/* 1758 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public TileEntity getTileEntity(int i, int j, int k) {
/* 1763 */     if (j >= 0 && j < 256) {
/* 1764 */       TileEntity tileentity = null;
/*      */ 
/*      */ 
/*      */       
/* 1768 */       if (this.M) {
/* 1769 */         for (int l = 0; l < this.a.size(); l++) {
/* 1770 */           TileEntity tileentity1 = this.a.get(l);
/* 1771 */           if (!tileentity1.r() && tileentity1.x == i && tileentity1.y == j && tileentity1.z == k) {
/* 1772 */             tileentity = tileentity1;
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/* 1778 */       if (tileentity == null) {
/* 1779 */         Chunk chunk = getChunkAt(i >> 4, k >> 4);
/*      */         
/* 1781 */         if (chunk != null) {
/* 1782 */           tileentity = chunk.e(i & 0xF, j, k & 0xF);
/*      */         }
/*      */       } 
/*      */       
/* 1786 */       if (tileentity == null) {
/* 1787 */         for (int l = 0; l < this.a.size(); l++) {
/* 1788 */           TileEntity tileentity1 = this.a.get(l);
/* 1789 */           if (!tileentity1.r() && tileentity1.x == i && tileentity1.y == j && tileentity1.z == k) {
/* 1790 */             tileentity = tileentity1;
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       }
/* 1796 */       return tileentity;
/*      */     } 
/* 1798 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setTileEntity(int i, int j, int k, TileEntity tileentity) {
/* 1803 */     if (tileentity != null && !tileentity.r()) {
/* 1804 */       if (this.M) {
/* 1805 */         tileentity.x = i;
/* 1806 */         tileentity.y = j;
/* 1807 */         tileentity.z = k;
/* 1808 */         Iterator<TileEntity> iterator = this.a.iterator();
/*      */         
/* 1810 */         while (iterator.hasNext()) {
/* 1811 */           TileEntity tileentity1 = iterator.next();
/*      */           
/* 1813 */           if (tileentity1.x == i && tileentity1.y == j && tileentity1.z == k) {
/* 1814 */             tileentity1.s();
/* 1815 */             iterator.remove();
/*      */           } 
/*      */         } 
/*      */         
/* 1819 */         this.a.add(tileentity);
/*      */       } else {
/* 1821 */         this.tileEntityList.add(tileentity);
/* 1822 */         Chunk chunk = getChunkAt(i >> 4, k >> 4);
/*      */         
/* 1824 */         if (chunk != null) {
/* 1825 */           chunk.a(i & 0xF, j, k & 0xF, tileentity);
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */   
/*      */   public void p(int i, int j, int k) {
/* 1832 */     TileEntity tileentity = getTileEntity(i, j, k);
/*      */     
/* 1834 */     if (tileentity != null && this.M) {
/* 1835 */       tileentity.s();
/* 1836 */       this.a.remove(tileentity);
/*      */     } else {
/* 1838 */       if (tileentity != null) {
/* 1839 */         this.a.remove(tileentity);
/* 1840 */         this.tileEntityList.remove(tileentity);
/*      */       } 
/*      */       
/* 1843 */       Chunk chunk = getChunkAt(i >> 4, k >> 4);
/*      */       
/* 1845 */       if (chunk != null) {
/* 1846 */         chunk.f(i & 0xF, j, k & 0xF);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(TileEntity tileentity) {
/* 1852 */     this.b.add(tileentity);
/*      */   }
/*      */   
/*      */   public boolean q(int i, int j, int k) {
/* 1856 */     AxisAlignedBB axisalignedbb = getType(i, j, k).a(this, i, j, k);
/*      */     
/* 1858 */     return (axisalignedbb != null && axisalignedbb.a() >= 1.0D);
/*      */   }
/*      */   
/*      */   public static boolean a(IBlockAccess iblockaccess, int i, int j, int k) {
/* 1862 */     Block block = iblockaccess.getType(i, j, k);
/* 1863 */     int l = iblockaccess.getData(i, j, k);
/*      */     
/* 1865 */     return (block.getMaterial().k() && block.d()) ? true : ((block instanceof BlockStairs) ? (((l & 0x4) == 4)) : ((block instanceof BlockStepAbstract) ? (((l & 0x8) == 8)) : ((block instanceof BlockHopper) ? true : ((block instanceof BlockSnow) ? (((l & 0x7) == 7)) : false))));
/*      */   }
/*      */   
/*      */   public boolean c(int i, int j, int k, boolean flag) {
/* 1869 */     if (i >= -30000000 && k >= -30000000 && i < 30000000 && k < 30000000) {
/* 1870 */       Chunk chunk = this.chunkProvider.getOrCreateChunk(i >> 4, k >> 4);
/*      */       
/* 1872 */       if (chunk != null && !chunk.isEmpty()) {
/* 1873 */         Block block = getType(i, j, k);
/*      */         
/* 1875 */         return (block.getMaterial().k() && block.d());
/*      */       } 
/* 1877 */       return flag;
/*      */     } 
/*      */     
/* 1880 */     return flag;
/*      */   }
/*      */ 
/*      */   
/*      */   public void B() {
/* 1885 */     int i = a(1.0F);
/*      */     
/* 1887 */     if (i != this.j) {
/* 1888 */       this.j = i;
/*      */     }
/*      */   }
/*      */   
/*      */   public void setSpawnFlags(boolean flag, boolean flag1) {
/* 1893 */     this.allowMonsters = flag;
/* 1894 */     this.allowAnimals = flag1;
/*      */   }
/*      */   
/*      */   public void doTick() {
/* 1898 */     o();
/*      */   }
/*      */   
/*      */   private void a() {
/* 1902 */     if (this.worldData.hasStorm()) {
/* 1903 */       this.n = 1.0F;
/* 1904 */       if (this.worldData.isThundering()) {
/* 1905 */         this.p = 1.0F;
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void o() {
/* 1911 */     if (!this.worldProvider.g && 
/* 1912 */       !this.isStatic) {
/* 1913 */       int i = this.worldData.getThunderDuration();
/*      */       
/* 1915 */       if (i <= 0) {
/* 1916 */         if (this.worldData.isThundering()) {
/* 1917 */           this.worldData.setThunderDuration(this.random.nextInt(12000) + 3600);
/*      */         } else {
/* 1919 */           this.worldData.setThunderDuration(this.random.nextInt(168000) + 12000);
/*      */         } 
/*      */       } else {
/* 1922 */         i--;
/* 1923 */         this.worldData.setThunderDuration(i);
/* 1924 */         if (i <= 0) {
/*      */           
/* 1926 */           ThunderChangeEvent thunder = new ThunderChangeEvent((org.bukkit.World)getWorld(), !this.worldData.isThundering());
/* 1927 */           getServer().getPluginManager().callEvent((Event)thunder);
/* 1928 */           if (!thunder.isCancelled()) {
/* 1929 */             this.worldData.setThundering(!this.worldData.isThundering());
/*      */           }
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1935 */       this.o = this.p;
/* 1936 */       if (this.worldData.isThundering()) {
/* 1937 */         this.p = (float)(this.p + 0.01D);
/*      */       } else {
/* 1939 */         this.p = (float)(this.p - 0.01D);
/*      */       } 
/*      */       
/* 1942 */       this.p = MathHelper.a(this.p, 0.0F, 1.0F);
/* 1943 */       int j = this.worldData.getWeatherDuration();
/*      */       
/* 1945 */       if (j <= 0) {
/* 1946 */         if (this.worldData.hasStorm()) {
/* 1947 */           this.worldData.setWeatherDuration(this.random.nextInt(12000) + 12000);
/*      */         } else {
/* 1949 */           this.worldData.setWeatherDuration(this.random.nextInt(168000) + 12000);
/*      */         } 
/*      */       } else {
/* 1952 */         j--;
/* 1953 */         this.worldData.setWeatherDuration(j);
/* 1954 */         if (j <= 0) {
/*      */           
/* 1956 */           WeatherChangeEvent weather = new WeatherChangeEvent((org.bukkit.World)getWorld(), !this.worldData.hasStorm());
/* 1957 */           getServer().getPluginManager().callEvent((Event)weather);
/*      */           
/* 1959 */           if (!weather.isCancelled()) {
/* 1960 */             this.worldData.setStorm(!this.worldData.hasStorm());
/*      */           }
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1966 */       this.m = this.n;
/* 1967 */       if (this.worldData.hasStorm()) {
/* 1968 */         this.n = (float)(this.n + 0.01D);
/*      */       } else {
/* 1970 */         this.n = (float)(this.n - 0.01D);
/*      */       } 
/*      */       
/* 1973 */       this.n = MathHelper.a(this.n, 0.0F, 1.0F);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void C() {
/* 1980 */     this.methodProfiler.a("buildList");
/*      */ 
/*      */ 
/*      */     
/*      */     int i;
/*      */ 
/*      */ 
/*      */     
/* 1988 */     for (i = 0; i < this.players.size(); i++) {
/* 1989 */       EntityHuman entityhuman = this.players.get(i);
/* 1990 */       int j = MathHelper.floor(entityhuman.locX / 16.0D);
/* 1991 */       int k = MathHelper.floor(entityhuman.locZ / 16.0D);
/* 1992 */       int l = p();
/*      */       
/* 1994 */       for (int i1 = -l; i1 <= l; i1++) {
/* 1995 */         for (int j1 = -l; j1 <= l; j1++) {
/* 1996 */           this.chunkTickList.add(LongHash.toLong(i1 + j, j1 + k));
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 2001 */     this.methodProfiler.b();
/* 2002 */     if (this.K > 0) {
/* 2003 */       this.K--;
/*      */     }
/*      */     
/* 2006 */     this.methodProfiler.a("playerCheckLight");
/* 2007 */     if (!this.players.isEmpty()) {
/* 2008 */       i = this.random.nextInt(this.players.size());
/* 2009 */       EntityHuman entityhuman = this.players.get(i);
/* 2010 */       int j = MathHelper.floor(entityhuman.locX) + this.random.nextInt(11) - 5;
/* 2011 */       int k = MathHelper.floor(entityhuman.locY) + this.random.nextInt(11) - 5;
/* 2012 */       int l = MathHelper.floor(entityhuman.locZ) + this.random.nextInt(11) - 5;
/* 2013 */       t(j, k, l);
/*      */     } 
/*      */     
/* 2016 */     this.methodProfiler.b();
/*      */   }
/*      */   
/*      */   protected abstract int p();
/*      */   
/*      */   protected void a(int i, int j, Chunk chunk) {
/* 2022 */     this.methodProfiler.c("moodSound");
/* 2023 */     if (this.K == 0 && !this.isStatic) {
/* 2024 */       this.k = this.k * 3 + 1013904223;
/* 2025 */       int k = this.k >> 2;
/* 2026 */       int l = k & 0xF;
/* 2027 */       int i1 = k >> 8 & 0xF;
/* 2028 */       int j1 = k >> 16 & 0xFF;
/* 2029 */       Block block = chunk.getType(l, j1, i1);
/*      */       
/* 2031 */       l += i;
/* 2032 */       i1 += j;
/* 2033 */       if (block.getMaterial() == Material.AIR && j(l, j1, i1) <= this.random.nextInt(8) && b(EnumSkyBlock.SKY, l, j1, i1) <= 0) {
/* 2034 */         EntityHuman entityhuman = findNearbyPlayer(l + 0.5D, j1 + 0.5D, i1 + 0.5D, 8.0D);
/*      */         
/* 2036 */         if (entityhuman != null && entityhuman.e(l + 0.5D, j1 + 0.5D, i1 + 0.5D) > 4.0D) {
/* 2037 */           makeSound(l + 0.5D, j1 + 0.5D, i1 + 0.5D, "ambient.cave.cave", 0.7F, 0.8F + this.random.nextFloat() * 0.2F);
/* 2038 */           this.K = this.random.nextInt(12000) + 6000;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 2043 */     this.methodProfiler.c("checkLight");
/* 2044 */     chunk.o();
/*      */   }
/*      */   
/*      */   protected void g() {
/* 2048 */     C();
/*      */   }
/*      */   
/*      */   public boolean r(int i, int j, int k) {
/* 2052 */     return d(i, j, k, false);
/*      */   }
/*      */   
/*      */   public boolean s(int i, int j, int k) {
/* 2056 */     return d(i, j, k, true);
/*      */   }
/*      */   
/*      */   public boolean d(int i, int j, int k, boolean flag) {
/* 2060 */     BiomeBase biomebase = getBiome(i, k);
/* 2061 */     float f = biomebase.a(i, j, k);
/*      */     
/* 2063 */     if (f > 0.15F) {
/* 2064 */       return false;
/*      */     }
/* 2066 */     if (j >= 0 && j < 256 && b(EnumSkyBlock.BLOCK, i, j, k) < 10) {
/* 2067 */       Block block = getType(i, j, k);
/*      */       
/* 2069 */       if ((block == Blocks.STATIONARY_WATER || block == Blocks.WATER) && getData(i, j, k) == 0) {
/* 2070 */         if (!flag) {
/* 2071 */           return true;
/*      */         }
/*      */         
/* 2074 */         boolean flag1 = true;
/*      */         
/* 2076 */         if (flag1 && getType(i - 1, j, k).getMaterial() != Material.WATER) {
/* 2077 */           flag1 = false;
/*      */         }
/*      */         
/* 2080 */         if (flag1 && getType(i + 1, j, k).getMaterial() != Material.WATER) {
/* 2081 */           flag1 = false;
/*      */         }
/*      */         
/* 2084 */         if (flag1 && getType(i, j, k - 1).getMaterial() != Material.WATER) {
/* 2085 */           flag1 = false;
/*      */         }
/*      */         
/* 2088 */         if (flag1 && getType(i, j, k + 1).getMaterial() != Material.WATER) {
/* 2089 */           flag1 = false;
/*      */         }
/*      */         
/* 2092 */         if (!flag1) {
/* 2093 */           return true;
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 2098 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean e(int i, int j, int k, boolean flag) {
/* 2103 */     BiomeBase biomebase = getBiome(i, k);
/* 2104 */     float f = biomebase.a(i, j, k);
/*      */     
/* 2106 */     if (f > 0.15F)
/* 2107 */       return false; 
/* 2108 */     if (!flag) {
/* 2109 */       return true;
/*      */     }
/* 2111 */     if (j >= 0 && j < 256 && b(EnumSkyBlock.BLOCK, i, j, k) < 10) {
/* 2112 */       Block block = getType(i, j, k);
/*      */       
/* 2114 */       if (block.getMaterial() == Material.AIR && Blocks.SNOW.canPlace(this, i, j, k)) {
/* 2115 */         return true;
/*      */       }
/*      */     } 
/*      */     
/* 2119 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean t(int i, int j, int k) {
/* 2124 */     boolean flag = false;
/*      */     
/* 2126 */     if (!this.worldProvider.g) {
/* 2127 */       flag |= c(EnumSkyBlock.SKY, i, j, k);
/*      */     }
/*      */     
/* 2130 */     flag |= c(EnumSkyBlock.BLOCK, i, j, k);
/* 2131 */     return flag;
/*      */   }
/*      */   
/*      */   private int a(int i, int j, int k, EnumSkyBlock enumskyblock) {
/* 2135 */     if (enumskyblock == EnumSkyBlock.SKY && i(i, j, k)) {
/* 2136 */       return 15;
/*      */     }
/* 2138 */     Block block = getType(i, j, k);
/* 2139 */     int l = (enumskyblock == EnumSkyBlock.SKY) ? 0 : block.m();
/* 2140 */     int i1 = block.k();
/*      */     
/* 2142 */     if (i1 >= 15 && block.m() > 0) {
/* 2143 */       i1 = 1;
/*      */     }
/*      */     
/* 2146 */     if (i1 < 1) {
/* 2147 */       i1 = 1;
/*      */     }
/*      */     
/* 2150 */     if (i1 >= 15)
/* 2151 */       return 0; 
/* 2152 */     if (l >= 14) {
/* 2153 */       return l;
/*      */     }
/* 2155 */     for (int j1 = 0; j1 < 6; j1++) {
/* 2156 */       int k1 = i + Facing.b[j1];
/* 2157 */       int l1 = j + Facing.c[j1];
/* 2158 */       int i2 = k + Facing.d[j1];
/* 2159 */       int j2 = b(enumskyblock, k1, l1, i2) - i1;
/*      */       
/* 2161 */       if (j2 > l) {
/* 2162 */         l = j2;
/*      */       }
/*      */       
/* 2165 */       if (l >= 14) {
/* 2166 */         return l;
/*      */       }
/*      */     } 
/*      */     
/* 2170 */     return l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean c(EnumSkyBlock enumskyblock, int i, int j, int k) {
/* 2177 */     Chunk chunk = getChunkIfLoaded(i >> 4, k >> 4);
/* 2178 */     if (chunk == null || !chunk.areNeighborsLoaded(1))
/*      */     {
/* 2180 */       return false;
/*      */     }
/* 2182 */     int l = 0;
/* 2183 */     int i1 = 0;
/*      */     
/* 2185 */     this.methodProfiler.a("getBrightness");
/* 2186 */     int j1 = b(enumskyblock, i, j, k);
/* 2187 */     int k1 = a(i, j, k, enumskyblock);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 2198 */     if (k1 > j1) {
/* 2199 */       this.I[i1++] = 133152;
/* 2200 */     } else if (k1 < j1) {
/* 2201 */       this.I[i1++] = 0x20820 | j1 << 18;
/*      */       
/* 2203 */       while (l < i1) {
/* 2204 */         int l1 = this.I[l++];
/* 2205 */         int i2 = (l1 & 0x3F) - 32 + i;
/* 2206 */         int j2 = (l1 >> 6 & 0x3F) - 32 + j;
/* 2207 */         int k2 = (l1 >> 12 & 0x3F) - 32 + k;
/* 2208 */         int l2 = l1 >> 18 & 0xF;
/* 2209 */         int i3 = b(enumskyblock, i2, j2, k2);
/* 2210 */         if (i3 == l2) {
/* 2211 */           b(enumskyblock, i2, j2, k2, 0);
/* 2212 */           if (l2 > 0) {
/* 2213 */             int j3 = MathHelper.a(i2 - i);
/* 2214 */             int l3 = MathHelper.a(j2 - j);
/* 2215 */             int k3 = MathHelper.a(k2 - k);
/* 2216 */             if (j3 + l3 + k3 < 17) {
/* 2217 */               for (int i4 = 0; i4 < 6; i4++) {
/* 2218 */                 int j4 = i2 + Facing.b[i4];
/* 2219 */                 int k4 = j2 + Facing.c[i4];
/* 2220 */                 int l4 = k2 + Facing.d[i4];
/* 2221 */                 int i5 = Math.max(1, getType(j4, k4, l4).k());
/*      */                 
/* 2223 */                 i3 = b(enumskyblock, j4, k4, l4);
/* 2224 */                 if (i3 == l2 - i5 && i1 < this.I.length) {
/* 2225 */                   this.I[i1++] = j4 - i + 32 | k4 - j + 32 << 6 | l4 - k + 32 << 12 | l2 - i5 << 18;
/*      */                 }
/*      */               } 
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 2233 */       l = 0;
/*      */     } 
/*      */     
/* 2236 */     this.methodProfiler.b();
/* 2237 */     this.methodProfiler.a("checkedPosition < toCheckCount");
/*      */     
/* 2239 */     while (l < i1) {
/* 2240 */       int l1 = this.I[l++];
/* 2241 */       int i2 = (l1 & 0x3F) - 32 + i;
/* 2242 */       int j2 = (l1 >> 6 & 0x3F) - 32 + j;
/* 2243 */       int k2 = (l1 >> 12 & 0x3F) - 32 + k;
/* 2244 */       int l2 = b(enumskyblock, i2, j2, k2);
/* 2245 */       int i3 = a(i2, j2, k2, enumskyblock);
/* 2246 */       if (i3 != l2) {
/* 2247 */         b(enumskyblock, i2, j2, k2, i3);
/* 2248 */         if (i3 > l2) {
/* 2249 */           int j3 = Math.abs(i2 - i);
/* 2250 */           int l3 = Math.abs(j2 - j);
/* 2251 */           int k3 = Math.abs(k2 - k);
/* 2252 */           boolean flag = (i1 < this.I.length - 6);
/*      */           
/* 2254 */           if (j3 + l3 + k3 < 17 && flag) {
/* 2255 */             if (b(enumskyblock, i2 - 1, j2, k2) < i3) {
/* 2256 */               this.I[i1++] = i2 - 1 - i + 32 + (j2 - j + 32 << 6) + (k2 - k + 32 << 12);
/*      */             }
/*      */             
/* 2259 */             if (b(enumskyblock, i2 + 1, j2, k2) < i3) {
/* 2260 */               this.I[i1++] = i2 + 1 - i + 32 + (j2 - j + 32 << 6) + (k2 - k + 32 << 12);
/*      */             }
/*      */             
/* 2263 */             if (b(enumskyblock, i2, j2 - 1, k2) < i3) {
/* 2264 */               this.I[i1++] = i2 - i + 32 + (j2 - 1 - j + 32 << 6) + (k2 - k + 32 << 12);
/*      */             }
/*      */             
/* 2267 */             if (b(enumskyblock, i2, j2 + 1, k2) < i3) {
/* 2268 */               this.I[i1++] = i2 - i + 32 + (j2 + 1 - j + 32 << 6) + (k2 - k + 32 << 12);
/*      */             }
/*      */             
/* 2271 */             if (b(enumskyblock, i2, j2, k2 - 1) < i3) {
/* 2272 */               this.I[i1++] = i2 - i + 32 + (j2 - j + 32 << 6) + (k2 - 1 - k + 32 << 12);
/*      */             }
/*      */             
/* 2275 */             if (b(enumskyblock, i2, j2, k2 + 1) < i3) {
/* 2276 */               this.I[i1++] = i2 - i + 32 + (j2 - j + 32 << 6) + (k2 + 1 - k + 32 << 12);
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 2283 */     this.methodProfiler.b();
/* 2284 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean a(boolean flag) {
/* 2289 */     return false;
/*      */   }
/*      */   
/*      */   public List a(Chunk chunk, boolean flag) {
/* 2293 */     return null;
/*      */   }
/*      */   
/*      */   public List getEntities(Entity entity, AxisAlignedBB axisalignedbb) {
/* 2297 */     return getEntities(entity, axisalignedbb, (IEntitySelector)null);
/*      */   }
/*      */   
/*      */   public List getEntities(Entity entity, AxisAlignedBB axisalignedbb, IEntitySelector ientityselector) {
/* 2301 */     ArrayList arraylist = new ArrayList();
/* 2302 */     int i = MathHelper.floor((axisalignedbb.a - 2.0D) / 16.0D);
/* 2303 */     int j = MathHelper.floor((axisalignedbb.d + 2.0D) / 16.0D);
/* 2304 */     int k = MathHelper.floor((axisalignedbb.c - 2.0D) / 16.0D);
/* 2305 */     int l = MathHelper.floor((axisalignedbb.f + 2.0D) / 16.0D);
/*      */     
/* 2307 */     for (int i1 = i; i1 <= j; i1++) {
/* 2308 */       for (int j1 = k; j1 <= l; j1++) {
/* 2309 */         if (isChunkLoaded(i1, j1)) {
/* 2310 */           getChunkAt(i1, j1).a(entity, axisalignedbb, arraylist, ientityselector);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 2315 */     return arraylist;
/*      */   }
/*      */   
/*      */   public List a(Class oclass, AxisAlignedBB axisalignedbb) {
/* 2319 */     return a(oclass, axisalignedbb, (IEntitySelector)null);
/*      */   }
/*      */   
/*      */   public List a(Class oclass, AxisAlignedBB axisalignedbb, IEntitySelector ientityselector) {
/* 2323 */     int i = MathHelper.floor((axisalignedbb.a - 2.0D) / 16.0D);
/* 2324 */     int j = MathHelper.floor((axisalignedbb.d + 2.0D) / 16.0D);
/* 2325 */     int k = MathHelper.floor((axisalignedbb.c - 2.0D) / 16.0D);
/* 2326 */     int l = MathHelper.floor((axisalignedbb.f + 2.0D) / 16.0D);
/* 2327 */     ArrayList arraylist = new ArrayList();
/*      */     
/* 2329 */     for (int i1 = i; i1 <= j; i1++) {
/* 2330 */       for (int j1 = k; j1 <= l; j1++) {
/* 2331 */         if (isChunkLoaded(i1, j1)) {
/* 2332 */           getChunkAt(i1, j1).a(oclass, axisalignedbb, arraylist, ientityselector);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 2337 */     return arraylist;
/*      */   }
/*      */   
/*      */   public Entity a(Class oclass, AxisAlignedBB axisalignedbb, Entity entity) {
/* 2341 */     List<Entity> list = a(oclass, axisalignedbb);
/* 2342 */     Entity entity1 = null;
/* 2343 */     double d0 = Double.MAX_VALUE;
/*      */     
/* 2345 */     for (int i = 0; i < list.size(); i++) {
/* 2346 */       Entity entity2 = list.get(i);
/*      */       
/* 2348 */       if (entity2 != entity) {
/* 2349 */         double d1 = entity.f(entity2);
/*      */         
/* 2351 */         if (d1 <= d0) {
/* 2352 */           entity1 = entity2;
/* 2353 */           d0 = d1;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 2358 */     return entity1;
/*      */   }
/*      */   
/*      */   public abstract Entity getEntity(int paramInt);
/*      */   
/*      */   public void b(int i, int j, int k, TileEntity tileentity) {
/* 2364 */     if (isLoaded(i, j, k)) {
/* 2365 */       getChunkAtWorldCoords(i, k).e();
/*      */     }
/*      */   }
/*      */   
/*      */   public int a(Class oclass) {
/* 2370 */     int i = 0;
/*      */     
/* 2372 */     for (int j = 0; j < this.entityList.size(); j++) {
/* 2373 */       Entity entity = this.entityList.get(j);
/*      */ 
/*      */       
/* 2376 */       if (entity instanceof EntityInsentient) {
/* 2377 */         EntityInsentient entityinsentient = (EntityInsentient)entity;
/* 2378 */         if (entityinsentient.isTypeNotPersistent() && entityinsentient.isPersistent()) {
/*      */           continue;
/*      */         }
/*      */       } 
/*      */       
/* 2383 */       if (oclass.isAssignableFrom(entity.getClass()))
/*      */       {
/*      */         
/* 2386 */         i++;
/*      */       }
/*      */       continue;
/*      */     } 
/* 2390 */     return i;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(List<Entity> list) {
/* 2396 */     Entity entity = null;
/*      */     
/* 2398 */     for (int i = 0; i < list.size(); i++) {
/* 2399 */       entity = list.get(i);
/* 2400 */       if (entity != null) {
/*      */ 
/*      */         
/* 2403 */         this.entityList.add(entity);
/*      */         
/* 2405 */         a(list.get(i));
/*      */       } 
/*      */     } 
/*      */   }
/*      */   public void b(List list) {
/* 2410 */     this.f.addAll(list);
/*      */   }
/*      */   
/*      */   public boolean mayPlace(Block block, int i, int j, int k, boolean flag, int l, Entity entity, ItemStack itemstack) {
/* 2414 */     Block block1 = getType(i, j, k);
/* 2415 */     AxisAlignedBB axisalignedbb = flag ? null : block.a(this, i, j, k);
/*      */ 
/*      */     
/* 2418 */     boolean defaultReturn = (axisalignedbb != null && !a(axisalignedbb, entity)) ? false : ((block1.getMaterial() == Material.ORIENTABLE && block == Blocks.ANVIL) ? true : ((block1.getMaterial().isReplaceable() && block.canPlace(this, i, j, k, l, itemstack))));
/*      */ 
/*      */     
/* 2421 */     BlockCanBuildEvent event = new BlockCanBuildEvent(getWorld().getBlockAt(i, j, k), CraftMagicNumbers.getId(block), defaultReturn);
/* 2422 */     getServer().getPluginManager().callEvent((Event)event);
/*      */     
/* 2424 */     return event.isBuildable();
/*      */   }
/*      */ 
/*      */   
/*      */   public PathEntity findPath(Entity entity, Entity entity1, float f, boolean flag, boolean flag1, boolean flag2, boolean flag3) {
/* 2429 */     this.methodProfiler.a("pathfind");
/* 2430 */     int i = MathHelper.floor(entity.locX);
/* 2431 */     int j = MathHelper.floor(entity.locY + 1.0D);
/* 2432 */     int k = MathHelper.floor(entity.locZ);
/* 2433 */     int l = (int)(f + 16.0F);
/* 2434 */     int i1 = i - l;
/* 2435 */     int j1 = j - l;
/* 2436 */     int k1 = k - l;
/* 2437 */     int l1 = i + l;
/* 2438 */     int i2 = j + l;
/* 2439 */     int j2 = k + l;
/* 2440 */     ChunkCache chunkcache = new ChunkCache(this, i1, j1, k1, l1, i2, j2, 0);
/* 2441 */     PathEntity pathentity = (new Pathfinder(chunkcache, flag, flag1, flag2, flag3)).a(entity, entity1, f);
/*      */     
/* 2443 */     this.methodProfiler.b();
/* 2444 */     return pathentity;
/*      */   }
/*      */   
/*      */   public PathEntity a(Entity entity, int i, int j, int k, float f, boolean flag, boolean flag1, boolean flag2, boolean flag3) {
/* 2448 */     this.methodProfiler.a("pathfind");
/* 2449 */     int l = MathHelper.floor(entity.locX);
/* 2450 */     int i1 = MathHelper.floor(entity.locY);
/* 2451 */     int j1 = MathHelper.floor(entity.locZ);
/* 2452 */     int k1 = (int)(f + 8.0F);
/* 2453 */     int l1 = l - k1;
/* 2454 */     int i2 = i1 - k1;
/* 2455 */     int j2 = j1 - k1;
/* 2456 */     int k2 = l + k1;
/* 2457 */     int l2 = i1 + k1;
/* 2458 */     int i3 = j1 + k1;
/* 2459 */     ChunkCache chunkcache = new ChunkCache(this, l1, i2, j2, k2, l2, i3, 0);
/* 2460 */     PathEntity pathentity = (new Pathfinder(chunkcache, flag, flag1, flag2, flag3)).a(entity, i, j, k, f);
/*      */     
/* 2462 */     this.methodProfiler.b();
/* 2463 */     return pathentity;
/*      */   }
/*      */   
/*      */   public int getBlockPower(int i, int j, int k, int l) {
/* 2467 */     return getType(i, j, k).c(this, i, j, k, l);
/*      */   }
/*      */   
/*      */   public int getBlockPower(int i, int j, int k) {
/* 2471 */     byte b0 = 0;
/* 2472 */     int l = Math.max(b0, getBlockPower(i, j - 1, k, 0));
/*      */     
/* 2474 */     if (l >= 15) {
/* 2475 */       return l;
/*      */     }
/* 2477 */     l = Math.max(l, getBlockPower(i, j + 1, k, 1));
/* 2478 */     if (l >= 15) {
/* 2479 */       return l;
/*      */     }
/* 2481 */     l = Math.max(l, getBlockPower(i, j, k - 1, 2));
/* 2482 */     if (l >= 15) {
/* 2483 */       return l;
/*      */     }
/* 2485 */     l = Math.max(l, getBlockPower(i, j, k + 1, 3));
/* 2486 */     if (l >= 15) {
/* 2487 */       return l;
/*      */     }
/* 2489 */     l = Math.max(l, getBlockPower(i - 1, j, k, 4));
/* 2490 */     if (l >= 15) {
/* 2491 */       return l;
/*      */     }
/* 2493 */     l = Math.max(l, getBlockPower(i + 1, j, k, 5));
/* 2494 */     return (l >= 15) ? l : l;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isBlockFacePowered(int i, int j, int k, int l) {
/* 2503 */     return (getBlockFacePower(i, j, k, l) > 0);
/*      */   }
/*      */   
/*      */   public int getBlockFacePower(int i, int j, int k, int l) {
/* 2507 */     return getType(i, j, k).r() ? getBlockPower(i, j, k) : getType(i, j, k).b(this, i, j, k, l);
/*      */   }
/*      */   
/*      */   public boolean isBlockIndirectlyPowered(int i, int j, int k) {
/* 2511 */     return (getBlockFacePower(i, j - 1, k, 0) > 0) ? true : ((getBlockFacePower(i, j + 1, k, 1) > 0) ? true : ((getBlockFacePower(i, j, k - 1, 2) > 0) ? true : ((getBlockFacePower(i, j, k + 1, 3) > 0) ? true : ((getBlockFacePower(i - 1, j, k, 4) > 0) ? true : ((getBlockFacePower(i + 1, j, k, 5) > 0))))));
/*      */   }
/*      */   
/*      */   public int getHighestNeighborSignal(int i, int j, int k) {
/* 2515 */     int l = 0;
/*      */     
/* 2517 */     for (int i1 = 0; i1 < 6; i1++) {
/* 2518 */       int j1 = getBlockFacePower(i + Facing.b[i1], j + Facing.c[i1], k + Facing.d[i1], i1);
/*      */       
/* 2520 */       if (j1 >= 15) {
/* 2521 */         return 15;
/*      */       }
/*      */       
/* 2524 */       if (j1 > l) {
/* 2525 */         l = j1;
/*      */       }
/*      */     } 
/*      */     
/* 2529 */     return l;
/*      */   }
/*      */   
/*      */   public EntityHuman findNearbyPlayer(Entity entity, double d0) {
/* 2533 */     return findNearbyPlayer(entity.locX, entity.locY, entity.locZ, d0);
/*      */   }
/*      */   
/*      */   public EntityHuman findNearbyPlayer(double d0, double d1, double d2, double d3) {
/* 2537 */     double d4 = -1.0D;
/* 2538 */     EntityHuman entityhuman = null;
/*      */     
/* 2540 */     for (int i = 0; i < this.players.size(); i++) {
/* 2541 */       EntityHuman entityhuman1 = this.players.get(i);
/*      */       
/* 2543 */       if (entityhuman1 != null && !entityhuman1.dead) {
/*      */ 
/*      */ 
/*      */         
/* 2547 */         double d5 = entityhuman1.e(d0, d1, d2);
/*      */         
/* 2549 */         if ((d3 < 0.0D || d5 < d3 * d3) && (d4 == -1.0D || d5 < d4)) {
/* 2550 */           d4 = d5;
/* 2551 */           entityhuman = entityhuman1;
/*      */         } 
/*      */       } 
/*      */     } 
/* 2555 */     return entityhuman;
/*      */   }
/*      */   
/*      */   public EntityHuman findNearbyVulnerablePlayer(Entity entity, double d0) {
/* 2559 */     return findNearbyVulnerablePlayer(entity.locX, entity.locY, entity.locZ, d0);
/*      */   }
/*      */   
/*      */   public EntityHuman findNearbyVulnerablePlayer(double d0, double d1, double d2, double d3) {
/* 2563 */     double d4 = -1.0D;
/* 2564 */     EntityHuman entityhuman = null;
/*      */     
/* 2566 */     for (int i = 0; i < this.players.size(); i++) {
/* 2567 */       EntityHuman entityhuman1 = this.players.get(i);
/*      */       
/* 2569 */       if (entityhuman1 != null && !entityhuman1.dead)
/*      */       {
/*      */ 
/*      */ 
/*      */         
/* 2574 */         if (!entityhuman1.abilities.isInvulnerable && entityhuman1.isAlive()) {
/* 2575 */           double d5 = entityhuman1.e(d0, d1, d2);
/* 2576 */           double d6 = d3;
/*      */           
/* 2578 */           if (entityhuman1.isSneaking()) {
/* 2579 */             d6 = d3 * 0.800000011920929D;
/*      */           }
/*      */           
/* 2582 */           if (entityhuman1.isInvisible()) {
/* 2583 */             float f = entityhuman1.bE();
/*      */             
/* 2585 */             if (f < 0.1F) {
/* 2586 */               f = 0.1F;
/*      */             }
/*      */             
/* 2589 */             d6 *= (0.7F * f);
/*      */           } 
/*      */           
/* 2592 */           if ((d3 < 0.0D || d5 < d6 * d6) && (d4 == -1.0D || d5 < d4)) {
/* 2593 */             d4 = d5;
/* 2594 */             entityhuman = entityhuman1;
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/* 2599 */     return entityhuman;
/*      */   }
/*      */   
/*      */   public EntityHuman a(String s) {
/* 2603 */     for (int i = 0; i < this.players.size(); i++) {
/* 2604 */       EntityHuman entityhuman = this.players.get(i);
/*      */       
/* 2606 */       if (s.equals(entityhuman.getName())) {
/* 2607 */         return entityhuman;
/*      */       }
/*      */     } 
/*      */     
/* 2611 */     return null;
/*      */   }
/*      */   
/*      */   public EntityHuman a(UUID uuid) {
/* 2615 */     for (int i = 0; i < this.players.size(); i++) {
/* 2616 */       EntityHuman entityhuman = this.players.get(i);
/*      */       
/* 2618 */       if (uuid.equals(entityhuman.getUniqueID())) {
/* 2619 */         return entityhuman;
/*      */       }
/*      */     } 
/*      */     
/* 2623 */     return null;
/*      */   }
/*      */   
/*      */   public void G() throws ExceptionWorldConflict {
/* 2627 */     this.dataManager.checkSession();
/*      */   }
/*      */   
/*      */   public long getSeed() {
/* 2631 */     return this.worldData.getSeed();
/*      */   }
/*      */   
/*      */   public long getTime() {
/* 2635 */     return this.worldData.getTime();
/*      */   }
/*      */   
/*      */   public long getDayTime() {
/* 2639 */     return this.worldData.getDayTime();
/*      */   }
/*      */   
/*      */   public void setDayTime(long i) {
/* 2643 */     this.worldData.setDayTime(i);
/*      */   }
/*      */   
/*      */   public ChunkCoordinates getSpawn() {
/* 2647 */     return new ChunkCoordinates(this.worldData.c(), this.worldData.d(), this.worldData.e());
/*      */   }
/*      */   
/*      */   public void x(int i, int j, int k) {
/* 2651 */     this.worldData.setSpawn(i, j, k);
/*      */   }
/*      */   
/*      */   public boolean a(EntityHuman entityhuman, int i, int j, int k) {
/* 2655 */     return true;
/*      */   }
/*      */   
/*      */   public void broadcastEntityEffect(Entity entity, byte b0) {}
/*      */   
/*      */   public IChunkProvider L() {
/* 2661 */     return this.chunkProvider;
/*      */   }
/*      */   
/*      */   public void playBlockAction(int i, int j, int k, Block block, int l, int i1) {
/* 2665 */     block.a(this, i, j, k, l, i1);
/*      */   }
/*      */   
/*      */   public IDataManager getDataManager() {
/* 2669 */     return this.dataManager;
/*      */   }
/*      */   
/*      */   public WorldData getWorldData() {
/* 2673 */     return this.worldData;
/*      */   }
/*      */   
/*      */   public GameRules getGameRules() {
/* 2677 */     return this.worldData.getGameRules();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void everyoneSleeping() {}
/*      */ 
/*      */   
/*      */   public void checkSleepStatus() {
/* 2686 */     if (!this.isStatic) {
/* 2687 */       everyoneSleeping();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public float h(float f) {
/* 2693 */     return (this.o + (this.p - this.o) * f) * j(f);
/*      */   }
/*      */   
/*      */   public float j(float f) {
/* 2697 */     return this.m + (this.n - this.m) * f;
/*      */   }
/*      */   
/*      */   public boolean P() {
/* 2701 */     return (h(1.0F) > 0.9D);
/*      */   }
/*      */   
/*      */   public boolean Q() {
/* 2705 */     return (j(1.0F) > 0.2D);
/*      */   }
/*      */   
/*      */   public boolean isRainingAt(int i, int j, int k) {
/* 2709 */     if (!Q())
/* 2710 */       return false; 
/* 2711 */     if (!i(i, j, k))
/* 2712 */       return false; 
/* 2713 */     if (h(i, k) > j) {
/* 2714 */       return false;
/*      */     }
/* 2716 */     BiomeBase biomebase = getBiome(i, k);
/*      */     
/* 2718 */     return biomebase.d() ? false : (e(i, j, k, false) ? false : biomebase.e());
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean z(int i, int j, int k) {
/* 2723 */     BiomeBase biomebase = getBiome(i, k);
/*      */     
/* 2725 */     return biomebase.f();
/*      */   }
/*      */   
/*      */   public void a(String s, PersistentBase persistentbase) {
/* 2729 */     this.worldMaps.a(s, persistentbase);
/*      */   }
/*      */   
/*      */   public PersistentBase a(Class oclass, String s) {
/* 2733 */     return this.worldMaps.get(oclass, s);
/*      */   }
/*      */   
/*      */   public int b(String s) {
/* 2737 */     return this.worldMaps.a(s);
/*      */   }
/*      */   
/*      */   public void b(int i, int j, int k, int l, int i1) {
/* 2741 */     for (int j1 = 0; j1 < this.u.size(); j1++) {
/* 2742 */       ((IWorldAccess)this.u.get(j1)).a(i, j, k, l, i1);
/*      */     }
/*      */   }
/*      */   
/*      */   public void triggerEffect(int i, int j, int k, int l, int i1) {
/* 2747 */     a((EntityHuman)null, i, j, k, l, i1);
/*      */   }
/*      */   
/*      */   public void a(EntityHuman entityhuman, int i, int j, int k, int l, int i1) {
/*      */     try {
/* 2752 */       for (int j1 = 0; j1 < this.u.size(); j1++) {
/* 2753 */         ((IWorldAccess)this.u.get(j1)).a(entityhuman, i, j, k, l, i1);
/*      */       }
/* 2755 */     } catch (Throwable throwable) {
/* 2756 */       CrashReport crashreport = CrashReport.a(throwable, "Playing level event");
/* 2757 */       CrashReportSystemDetails crashreportsystemdetails = crashreport.a("Level event being played");
/*      */       
/* 2759 */       crashreportsystemdetails.a("Block coordinates", CrashReportSystemDetails.a(j, k, l));
/* 2760 */       crashreportsystemdetails.a("Event source", entityhuman);
/* 2761 */       crashreportsystemdetails.a("Event type", Integer.valueOf(i));
/* 2762 */       crashreportsystemdetails.a("Event data", Integer.valueOf(i1));
/* 2763 */       throw new ReportedException(crashreport);
/*      */     } 
/*      */   }
/*      */   
/*      */   public int getHeight() {
/* 2768 */     return 256;
/*      */   }
/*      */   
/*      */   public int S() {
/* 2772 */     return this.worldProvider.g ? 128 : 256;
/*      */   }
/*      */   
/*      */   public Random A(int i, int j, int k) {
/* 2776 */     long l = i * 341873128712L + j * 132897987541L + getWorldData().getSeed() + k;
/*      */     
/* 2778 */     this.random.setSeed(l);
/* 2779 */     return this.random;
/*      */   }
/*      */   
/*      */   public ChunkPosition b(String s, int i, int j, int k) {
/* 2783 */     return L().findNearestMapFeature(this, s, i, j, k);
/*      */   }
/*      */   
/*      */   public CrashReportSystemDetails a(CrashReport crashreport) {
/* 2787 */     CrashReportSystemDetails crashreportsystemdetails = crashreport.a("Affected level", 1);
/*      */     
/* 2789 */     crashreportsystemdetails.a("Level name", (this.worldData == null) ? "????" : this.worldData.getName());
/* 2790 */     crashreportsystemdetails.a("All players", new CrashReportPlayers(this));
/* 2791 */     crashreportsystemdetails.a("Chunk stats", new CrashReportChunkStats(this));
/*      */     
/*      */     try {
/* 2794 */       this.worldData.a(crashreportsystemdetails);
/* 2795 */     } catch (Throwable throwable) {
/* 2796 */       crashreportsystemdetails.a("Level Data Unobtainable", throwable);
/*      */     } 
/*      */     
/* 2799 */     return crashreportsystemdetails;
/*      */   }
/*      */   
/*      */   public void d(int i, int j, int k, int l, int i1) {
/* 2803 */     for (int j1 = 0; j1 < this.u.size(); j1++) {
/* 2804 */       IWorldAccess iworldaccess = this.u.get(j1);
/*      */       
/* 2806 */       iworldaccess.b(i, j, k, l, i1);
/*      */     } 
/*      */   }
/*      */   
/*      */   public Calendar V() {
/* 2811 */     if (getTime() % 600L == 0L) {
/* 2812 */       this.J.setTimeInMillis(MinecraftServer.ar());
/*      */     }
/*      */     
/* 2815 */     return this.J;
/*      */   }
/*      */   
/*      */   public Scoreboard getScoreboard() {
/* 2819 */     return this.scoreboard;
/*      */   }
/*      */   
/*      */   public void updateAdjacentComparators(int i, int j, int k, Block block) {
/* 2823 */     for (int l = 0; l < 4; l++) {
/* 2824 */       int i1 = i + Direction.a[l];
/* 2825 */       int j1 = k + Direction.b[l];
/* 2826 */       Block block1 = getType(i1, j, j1);
/*      */       
/* 2828 */       if (Blocks.REDSTONE_COMPARATOR_OFF.e(block1)) {
/* 2829 */         block1.doPhysics(this, i1, j, j1, block);
/* 2830 */       } else if (block1.r()) {
/* 2831 */         i1 += Direction.a[l];
/* 2832 */         j1 += Direction.b[l];
/* 2833 */         Block block2 = getType(i1, j, j1);
/*      */         
/* 2835 */         if (Blocks.REDSTONE_COMPARATOR_OFF.e(block2)) {
/* 2836 */           block2.doPhysics(this, i1, j, j1, block);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public float b(double d0, double d1, double d2) {
/* 2843 */     return B(MathHelper.floor(d0), MathHelper.floor(d1), MathHelper.floor(d2));
/*      */   }
/*      */   
/*      */   public float B(int i, int j, int k) {
/* 2847 */     float f = 0.0F;
/* 2848 */     boolean flag = (this.difficulty == EnumDifficulty.HARD);
/*      */     
/* 2850 */     if (isLoaded(i, j, k)) {
/* 2851 */       float f1 = y();
/*      */       
/* 2853 */       f += MathHelper.a((float)(getChunkAtWorldCoords(i, k)).s / 3600000.0F, 0.0F, 1.0F) * (flag ? 1.0F : 0.75F);
/* 2854 */       f += f1 * 0.25F;
/*      */     } 
/*      */     
/* 2857 */     if (this.difficulty == EnumDifficulty.EASY || this.difficulty == EnumDifficulty.PEACEFUL) {
/* 2858 */       f *= this.difficulty.a() / 2.0F;
/*      */     }
/*      */     
/* 2861 */     return MathHelper.a(f, 0.0F, flag ? 1.5F : 1.0F);
/*      */   }
/*      */   
/*      */   public void X() {
/* 2865 */     Iterator<IWorldAccess> iterator = this.u.iterator();
/*      */     
/* 2867 */     while (iterator.hasNext()) {
/* 2868 */       IWorldAccess iworldaccess = iterator.next();
/*      */       
/* 2870 */       iworldaccess.b();
/*      */     } 
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\World.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */