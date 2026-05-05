/*      */ package net.minecraft.server.v1_7_R4;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import java.util.TreeSet;
/*      */ import org.apache.logging.log4j.LogManager;
/*      */ import org.bukkit.Location;
/*      */ import org.bukkit.Material;
/*      */ import org.bukkit.WeatherType;
/*      */ import org.bukkit.World;
/*      */ import org.bukkit.block.BlockState;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.CraftTravelAgent;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.generator.CustomChunkGenerator;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.generator.NetherChunkGenerator;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.generator.NormalChunkGenerator;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.generator.SkyLandsChunkGenerator;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.util.LongHash;
/*      */ import org.bukkit.event.Event;
/*      */ import org.bukkit.event.block.BlockFormEvent;
/*      */ import org.bukkit.event.weather.LightningStrikeEvent;
/*      */ import org.bukkit.event.weather.ThunderChangeEvent;
/*      */ import org.bukkit.event.weather.WeatherChangeEvent;
/*      */ import org.bukkit.generator.ChunkGenerator;
/*      */ 
/*      */ public class WorldServer extends World {
/*   29 */   private static final Logger a = LogManager.getLogger();
/*      */   private final MinecraftServer server;
/*      */   public EntityTracker tracker;
/*      */   private final PlayerChunkMap manager;
/*      */   private Set M;
/*      */   private TreeSet N;
/*      */   public ChunkProviderServer chunkProviderServer;
/*      */   public boolean savingDisabled;
/*      */   private boolean O;
/*      */   private int emptyTime;
/*      */   private final PortalTravelAgent Q;
/*   40 */   private final SpawnerCreature R = new SpawnerCreature();
/*   41 */   private BlockActionDataList[] S = new BlockActionDataList[] { new BlockActionDataList((BananaAPI)null), new BlockActionDataList((BananaAPI)null) };
/*      */   private int T;
/*   43 */   private static final StructurePieceTreasure[] U = new StructurePieceTreasure[] { new StructurePieceTreasure(Items.STICK, 0, 1, 3, 10), new StructurePieceTreasure(Item.getItemOf(Blocks.WOOD), 0, 1, 3, 10), new StructurePieceTreasure(Item.getItemOf(Blocks.LOG), 0, 1, 3, 10), new StructurePieceTreasure(Items.STONE_AXE, 0, 1, 1, 3), new StructurePieceTreasure(Items.WOOD_AXE, 0, 1, 1, 5), new StructurePieceTreasure(Items.STONE_PICKAXE, 0, 1, 1, 3), new StructurePieceTreasure(Items.WOOD_PICKAXE, 0, 1, 1, 5), new StructurePieceTreasure(Items.APPLE, 0, 2, 3, 5), new StructurePieceTreasure(Items.BREAD, 0, 2, 3, 3), new StructurePieceTreasure(Item.getItemOf(Blocks.LOG2), 0, 1, 3, 10) };
/*   44 */   private List V = new ArrayList();
/*      */   
/*      */   private IntHashMap entitiesById;
/*      */   
/*      */   public final int dimension;
/*      */ 
/*      */   
/*      */   public WorldServer(MinecraftServer minecraftserver, IDataManager idatamanager, String s, int i, WorldSettings worldsettings, MethodProfiler methodprofiler, World.Environment env, ChunkGenerator gen) {
/*   52 */     super(idatamanager, s, worldsettings, WorldProvider.byDimension(env.getId()), methodprofiler, gen, env);
/*   53 */     this.dimension = i;
/*   54 */     this.pvpMode = minecraftserver.getPvP();
/*      */     
/*   56 */     this.server = minecraftserver;
/*   57 */     this.tracker = new EntityTracker(this);
/*   58 */     this.manager = new PlayerChunkMap(this);
/*   59 */     if (this.entitiesById == null) {
/*   60 */       this.entitiesById = new IntHashMap();
/*      */     }
/*      */     
/*   63 */     if (this.M == null) {
/*   64 */       this.M = new HashSet();
/*      */     }
/*      */     
/*   67 */     if (this.N == null) {
/*   68 */       this.N = new TreeSet();
/*      */     }
/*      */     
/*   71 */     this.Q = (PortalTravelAgent)new CraftTravelAgent(this);
/*   72 */     this.scoreboard = new ScoreboardServer(minecraftserver);
/*   73 */     PersistentScoreboard persistentscoreboard = (PersistentScoreboard)this.worldMaps.get(PersistentScoreboard.class, "scoreboard");
/*      */     
/*   75 */     if (persistentscoreboard == null) {
/*   76 */       persistentscoreboard = new PersistentScoreboard();
/*   77 */       this.worldMaps.a("scoreboard", persistentscoreboard);
/*      */     } 
/*      */     
/*   80 */     persistentscoreboard.a(this.scoreboard);
/*   81 */     ((ScoreboardServer)this.scoreboard).a(persistentscoreboard);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public TileEntity getTileEntity(int i, int j, int k) {
/*   87 */     TileEntity result = super.getTileEntity(i, j, k);
/*   88 */     Block type = getType(i, j, k);
/*      */     
/*   90 */     if (type == Blocks.CHEST) {
/*   91 */       if (!(result instanceof TileEntityChest)) {
/*   92 */         result = fixTileEntity(i, j, k, type, result);
/*      */       }
/*   94 */     } else if (type == Blocks.FURNACE) {
/*   95 */       if (!(result instanceof TileEntityFurnace)) {
/*   96 */         result = fixTileEntity(i, j, k, type, result);
/*      */       }
/*   98 */     } else if (type == Blocks.DROPPER) {
/*   99 */       if (!(result instanceof TileEntityDropper)) {
/*  100 */         result = fixTileEntity(i, j, k, type, result);
/*      */       }
/*  102 */     } else if (type == Blocks.DISPENSER) {
/*  103 */       if (!(result instanceof TileEntityDispenser)) {
/*  104 */         result = fixTileEntity(i, j, k, type, result);
/*      */       }
/*  106 */     } else if (type == Blocks.JUKEBOX) {
/*  107 */       if (!(result instanceof TileEntityRecordPlayer)) {
/*  108 */         result = fixTileEntity(i, j, k, type, result);
/*      */       }
/*  110 */     } else if (type == Blocks.NOTE_BLOCK) {
/*  111 */       if (!(result instanceof TileEntityNote)) {
/*  112 */         result = fixTileEntity(i, j, k, type, result);
/*      */       }
/*  114 */     } else if (type == Blocks.MOB_SPAWNER) {
/*  115 */       if (!(result instanceof TileEntityMobSpawner)) {
/*  116 */         result = fixTileEntity(i, j, k, type, result);
/*      */       }
/*  118 */     } else if (type == Blocks.SIGN_POST || type == Blocks.WALL_SIGN) {
/*  119 */       if (!(result instanceof TileEntitySign)) {
/*  120 */         result = fixTileEntity(i, j, k, type, result);
/*      */       }
/*  122 */     } else if (type == Blocks.ENDER_CHEST) {
/*  123 */       if (!(result instanceof TileEntityEnderChest)) {
/*  124 */         result = fixTileEntity(i, j, k, type, result);
/*      */       }
/*  126 */     } else if (type == Blocks.BREWING_STAND) {
/*  127 */       if (!(result instanceof TileEntityBrewingStand)) {
/*  128 */         result = fixTileEntity(i, j, k, type, result);
/*      */       }
/*  130 */     } else if (type == Blocks.BEACON) {
/*  131 */       if (!(result instanceof TileEntityBeacon)) {
/*  132 */         result = fixTileEntity(i, j, k, type, result);
/*      */       }
/*  134 */     } else if (type == Blocks.HOPPER && 
/*  135 */       !(result instanceof TileEntityHopper)) {
/*  136 */       result = fixTileEntity(i, j, k, type, result);
/*      */     } 
/*      */ 
/*      */     
/*  140 */     return result;
/*      */   }
/*      */   
/*      */   private TileEntity fixTileEntity(int x, int y, int z, Block type, TileEntity found) {
/*  144 */     getServer().getLogger().severe("Block at " + x + "," + y + "," + z + " is " + Material.getMaterial(Block.getId(type)).toString() + " but has " + found + ". " + "Bukkit will attempt to fix this, but there may be additional damage that we cannot recover.");
/*      */ 
/*      */     
/*  147 */     if (type instanceof IContainer) {
/*  148 */       TileEntity replacement = ((IContainer)type).a(this, getData(x, y, z));
/*  149 */       replacement.world = this;
/*  150 */       setTileEntity(x, y, z, replacement);
/*  151 */       return replacement;
/*      */     } 
/*  153 */     getServer().getLogger().severe("Don't know how to fix for this type... Can't do anything! :(");
/*  154 */     return found;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean canSpawn(int x, int z) {
/*  159 */     if (this.generator != null) {
/*  160 */       return this.generator.canSpawn((World)getWorld(), x, z);
/*      */     }
/*  162 */     return this.worldProvider.canSpawn(x, z);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void doTick() {
/*  168 */     super.doTick();
/*  169 */     if (getWorldData().isHardcore() && this.difficulty != EnumDifficulty.HARD) {
/*  170 */       this.difficulty = EnumDifficulty.HARD;
/*      */     }
/*      */     
/*  173 */     this.worldProvider.e.b();
/*  174 */     if (everyoneDeeplySleeping()) {
/*  175 */       if (getGameRules().getBoolean("doDaylightCycle")) {
/*  176 */         long i = this.worldData.getDayTime() + 24000L;
/*      */         
/*  178 */         this.worldData.setDayTime(i - i % 24000L);
/*      */       } 
/*      */       
/*  181 */       d();
/*      */     } 
/*      */     
/*  184 */     this.methodProfiler.a("mobSpawner");
/*      */     
/*  186 */     long time = this.worldData.getTime();
/*  187 */     if (getGameRules().getBoolean("doMobSpawning") && (this.allowMonsters || this.allowAnimals) && this instanceof WorldServer && this.players.size() > 0) {
/*  188 */       this.R.spawnEntities(this, (this.allowMonsters && this.ticksPerMonsterSpawns != 0L && time % this.ticksPerMonsterSpawns == 0L), (this.allowAnimals && this.ticksPerAnimalSpawns != 0L && time % this.ticksPerAnimalSpawns == 0L), (this.worldData.getTime() % 400L == 0L));
/*      */     }
/*      */ 
/*      */     
/*  192 */     this.methodProfiler.c("chunkSource");
/*  193 */     this.chunkProvider.unloadChunks();
/*  194 */     int j = a(1.0F);
/*      */     
/*  196 */     if (j != this.j) {
/*  197 */       this.j = j;
/*      */     }
/*      */     
/*  200 */     this.worldData.setTime(this.worldData.getTime() + 1L);
/*  201 */     if (getGameRules().getBoolean("doDaylightCycle")) {
/*  202 */       this.worldData.setDayTime(this.worldData.getDayTime() + 1L);
/*      */     }
/*      */     
/*  205 */     this.methodProfiler.c("tickPending");
/*  206 */     a(false);
/*  207 */     this.methodProfiler.c("tickBlocks");
/*  208 */     g();
/*  209 */     this.methodProfiler.c("chunkMap");
/*  210 */     this.manager.flush();
/*  211 */     this.methodProfiler.c("village");
/*  212 */     this.villages.tick();
/*  213 */     this.siegeManager.a();
/*  214 */     this.methodProfiler.c("portalForcer");
/*  215 */     this.Q.a(getTime());
/*  216 */     this.methodProfiler.b();
/*  217 */     Z();
/*      */     
/*  219 */     getWorld().processChunkGC();
/*      */   }
/*      */   
/*      */   public BiomeMeta a(EnumCreatureType enumcreaturetype, int i, int j, int k) {
/*  223 */     List list = L().getMobsFor(enumcreaturetype, i, j, k);
/*      */     
/*  225 */     return (list != null && !list.isEmpty()) ? (BiomeMeta)WeightedRandom.a(this.random, list) : null;
/*      */   }
/*      */   
/*      */   public void everyoneSleeping() {
/*  229 */     this.O = !this.players.isEmpty();
/*  230 */     Iterator<EntityHuman> iterator = this.players.iterator();
/*      */     
/*  232 */     while (iterator.hasNext()) {
/*  233 */       EntityHuman entityhuman = iterator.next();
/*      */       
/*  235 */       if (!entityhuman.isSleeping() && !entityhuman.fauxSleeping) {
/*  236 */         this.O = false;
/*      */         break;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void d() {
/*  243 */     this.O = false;
/*  244 */     Iterator<EntityHuman> iterator = this.players.iterator();
/*      */     
/*  246 */     while (iterator.hasNext()) {
/*  247 */       EntityHuman entityhuman = iterator.next();
/*      */       
/*  249 */       if (entityhuman.isSleeping()) {
/*  250 */         entityhuman.a(false, false, true);
/*      */       }
/*      */     } 
/*      */     
/*  254 */     Y();
/*      */   }
/*      */ 
/*      */   
/*      */   private void Y() {
/*  259 */     WeatherChangeEvent weather = new WeatherChangeEvent((World)getWorld(), false);
/*  260 */     getServer().getPluginManager().callEvent((Event)weather);
/*      */     
/*  262 */     ThunderChangeEvent thunder = new ThunderChangeEvent((World)getWorld(), false);
/*  263 */     getServer().getPluginManager().callEvent((Event)thunder);
/*  264 */     if (!weather.isCancelled()) {
/*  265 */       this.worldData.setWeatherDuration(0);
/*  266 */       this.worldData.setStorm(false);
/*      */     } 
/*  268 */     if (!thunder.isCancelled()) {
/*  269 */       this.worldData.setThunderDuration(0);
/*  270 */       this.worldData.setThundering(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean everyoneDeeplySleeping() {
/*  276 */     if (this.O && !this.isStatic) {
/*  277 */       EntityHuman entityhuman; Iterator<EntityHuman> iterator = this.players.iterator();
/*      */ 
/*      */       
/*  280 */       boolean foundActualSleepers = false;
/*      */ 
/*      */ 
/*      */       
/*      */       do {
/*  285 */         if (!iterator.hasNext()) {
/*  286 */           return foundActualSleepers;
/*      */         }
/*      */         
/*  289 */         entityhuman = iterator.next();
/*      */         
/*  291 */         if (!entityhuman.isDeeplySleeping())
/*  292 */           continue;  foundActualSleepers = true;
/*      */       }
/*  294 */       while (entityhuman.isDeeplySleeping() || entityhuman.fauxSleeping);
/*      */ 
/*      */       
/*  297 */       return false;
/*      */     } 
/*  299 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void g() {
/*  304 */     super.g();
/*  305 */     int i = 0;
/*  306 */     int j = 0;
/*      */ 
/*      */ 
/*      */     
/*  310 */     for (long chunkCoord : this.chunkTickList.popAll()) {
/*      */       
/*  312 */       int chunkX = LongHash.msw(chunkCoord);
/*  313 */       int chunkZ = LongHash.lsw(chunkCoord);
/*  314 */       int k = chunkX * 16;
/*  315 */       int l = chunkZ * 16;
/*      */       
/*  317 */       this.methodProfiler.a("getChunk");
/*  318 */       Chunk chunk = getChunkAt(chunkX, chunkZ);
/*      */ 
/*      */       
/*  321 */       a(k, l, chunk);
/*  322 */       this.methodProfiler.c("tickChunk");
/*  323 */       chunk.b(false);
/*  324 */       this.methodProfiler.c("thunder");
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  330 */       if (this.random.nextInt(100000) == 0 && Q() && P()) {
/*  331 */         this.k = this.k * 3 + 1013904223;
/*  332 */         int i1 = this.k >> 2;
/*  333 */         int m = k + (i1 & 0xF);
/*  334 */         int n = l + (i1 >> 8 & 0xF);
/*  335 */         int l1 = h(m, n);
/*  336 */         if (isRainingAt(m, l1, n)) {
/*  337 */           strikeLightning(new EntityLightning(this, m, l1, n));
/*      */         }
/*      */       } 
/*      */       
/*  341 */       this.methodProfiler.c("iceandsnow");
/*  342 */       if (this.random.nextInt(16) == 0) {
/*  343 */         this.k = this.k * 3 + 1013904223;
/*  344 */         int i1 = this.k >> 2;
/*  345 */         int m = i1 & 0xF;
/*  346 */         int n = i1 >> 8 & 0xF;
/*  347 */         int l1 = h(m + k, n + l);
/*  348 */         if (s(m + k, l1 - 1, n + l)) {
/*      */           
/*  350 */           BlockState blockState = getWorld().getBlockAt(m + k, l1 - 1, n + l).getState();
/*  351 */           blockState.setTypeId(Block.getId(Blocks.ICE));
/*      */           
/*  353 */           BlockFormEvent iceBlockForm = new BlockFormEvent(blockState.getBlock(), blockState);
/*  354 */           getServer().getPluginManager().callEvent((Event)iceBlockForm);
/*  355 */           if (!iceBlockForm.isCancelled()) {
/*  356 */             blockState.update(true);
/*      */           }
/*      */         } 
/*      */ 
/*      */         
/*  361 */         if (Q() && e(m + k, l1, n + l, true)) {
/*      */           
/*  363 */           BlockState blockState = getWorld().getBlockAt(m + k, l1, n + l).getState();
/*  364 */           blockState.setTypeId(Block.getId(Blocks.SNOW));
/*      */           
/*  366 */           BlockFormEvent snow = new BlockFormEvent(blockState.getBlock(), blockState);
/*  367 */           getServer().getPluginManager().callEvent((Event)snow);
/*  368 */           if (!snow.isCancelled()) {
/*  369 */             blockState.update(true);
/*      */           }
/*      */         } 
/*      */ 
/*      */         
/*  374 */         if (Q()) {
/*  375 */           BiomeBase biomebase = getBiome(m + k, n + l);
/*      */           
/*  377 */           if (biomebase.e()) {
/*  378 */             getType(m + k, l1 - 1, n + l).l(this, m + k, l1 - 1, n + l);
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/*  383 */       this.methodProfiler.c("tickBlocks");
/*  384 */       ChunkSection[] achunksection = chunk.getSections();
/*      */       
/*  386 */       int j1 = achunksection.length;
/*      */       
/*  388 */       for (int k1 = 0; k1 < j1; k1++) {
/*  389 */         ChunkSection chunksection = achunksection[k1];
/*      */         
/*  391 */         if (chunksection != null && chunksection.shouldTick()) {
/*  392 */           for (int i2 = 0; i2 < 3; i2++) {
/*  393 */             this.k = this.k * 3 + 1013904223;
/*  394 */             int j2 = this.k >> 2;
/*  395 */             int k2 = j2 & 0xF;
/*  396 */             int l2 = j2 >> 8 & 0xF;
/*  397 */             int i3 = j2 >> 16 & 0xF;
/*      */             
/*  399 */             j++;
/*  400 */             Block block = chunksection.getTypeId(k2, i3, l2);
/*      */             
/*  402 */             if (block.isTicking()) {
/*  403 */               i++;
/*  404 */               block.a(this, k2 + k, i3 + chunksection.getYPosition(), l2 + l, this.random);
/*      */             } 
/*      */           } 
/*      */         }
/*      */       } 
/*      */       
/*  410 */       this.methodProfiler.b();
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean a(int i, int j, int k, Block block) {
/*  415 */     NextTickListEntry nextticklistentry = new NextTickListEntry(i, j, k, block);
/*      */     
/*  417 */     return this.V.contains(nextticklistentry);
/*      */   }
/*      */   
/*      */   public void a(int i, int j, int k, Block block, int l) {
/*  421 */     a(i, j, k, block, l, 0);
/*      */   }
/*      */   
/*      */   public void a(int i, int j, int k, Block block, int l, int i1) {
/*  425 */     NextTickListEntry nextticklistentry = new NextTickListEntry(i, j, k, block);
/*  426 */     byte b0 = 0;
/*      */     
/*  428 */     if (this.d && block.getMaterial() != Material.AIR) {
/*  429 */       if (block.L()) {
/*  430 */         b0 = 8;
/*  431 */         if (b(nextticklistentry.a - b0, nextticklistentry.b - b0, nextticklistentry.c - b0, nextticklistentry.a + b0, nextticklistentry.b + b0, nextticklistentry.c + b0)) {
/*  432 */           Block block1 = getType(nextticklistentry.a, nextticklistentry.b, nextticklistentry.c);
/*      */           
/*  434 */           if (block1.getMaterial() != Material.AIR && block1 == nextticklistentry.a()) {
/*  435 */             block1.a(this, nextticklistentry.a, nextticklistentry.b, nextticklistentry.c, this.random);
/*      */           }
/*      */         } 
/*      */         
/*      */         return;
/*      */       } 
/*      */       
/*  442 */       l = 1;
/*      */     } 
/*      */     
/*  445 */     if (b(i - b0, j - b0, k - b0, i + b0, j + b0, k + b0)) {
/*  446 */       if (block.getMaterial() != Material.AIR) {
/*  447 */         nextticklistentry.a(l + this.worldData.getTime());
/*  448 */         nextticklistentry.a(i1);
/*      */       } 
/*      */       
/*  451 */       if (!this.M.contains(nextticklistentry)) {
/*  452 */         this.M.add(nextticklistentry);
/*  453 */         this.N.add(nextticklistentry);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void b(int i, int j, int k, Block block, int l, int i1) {
/*  459 */     NextTickListEntry nextticklistentry = new NextTickListEntry(i, j, k, block);
/*      */     
/*  461 */     nextticklistentry.a(i1);
/*  462 */     if (block.getMaterial() != Material.AIR) {
/*  463 */       nextticklistentry.a(l + this.worldData.getTime());
/*      */     }
/*      */     
/*  466 */     if (!this.M.contains(nextticklistentry)) {
/*  467 */       this.M.add(nextticklistentry);
/*  468 */       this.N.add(nextticklistentry);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void tickEntities() {
/*  478 */     i();
/*      */ 
/*      */     
/*  481 */     super.tickEntities();
/*      */   }
/*      */   
/*      */   public void i() {
/*  485 */     this.emptyTime = 0;
/*      */   }
/*      */   
/*      */   public boolean a(boolean flag) {
/*  489 */     int i = this.N.size();
/*      */     
/*  491 */     if (i != this.M.size()) {
/*  492 */       throw new IllegalStateException("TickNextTick list out of synch");
/*      */     }
/*  494 */     if (i > 1000)
/*      */     {
/*  496 */       if (i > 20000) {
/*  497 */         i /= 20;
/*      */       } else {
/*  499 */         i = 1000;
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*  504 */     this.methodProfiler.a("cleaning");
/*      */ 
/*      */ 
/*      */     
/*  508 */     for (int j = 0; j < i; j++) {
/*  509 */       NextTickListEntry nextticklistentry = this.N.first();
/*  510 */       if (!flag && nextticklistentry.d > this.worldData.getTime()) {
/*      */         break;
/*      */       }
/*      */       
/*  514 */       this.N.remove(nextticklistentry);
/*  515 */       this.M.remove(nextticklistentry);
/*  516 */       this.V.add(nextticklistentry);
/*      */     } 
/*      */     
/*  519 */     this.methodProfiler.b();
/*  520 */     this.methodProfiler.a("ticking");
/*  521 */     Iterator<NextTickListEntry> iterator = this.V.iterator();
/*      */     
/*  523 */     while (iterator.hasNext()) {
/*  524 */       NextTickListEntry nextticklistentry = iterator.next();
/*  525 */       iterator.remove();
/*  526 */       byte b0 = 0;
/*      */       
/*  528 */       if (b(nextticklistentry.a - b0, nextticklistentry.b - b0, nextticklistentry.c - b0, nextticklistentry.a + b0, nextticklistentry.b + b0, nextticklistentry.c + b0)) {
/*  529 */         Block block = getType(nextticklistentry.a, nextticklistentry.b, nextticklistentry.c);
/*      */         
/*  531 */         if (block.getMaterial() != Material.AIR && Block.a(block, nextticklistentry.a()))
/*      */           try {
/*  533 */             block.a(this, nextticklistentry.a, nextticklistentry.b, nextticklistentry.c, this.random);
/*  534 */           } catch (Throwable throwable) {
/*  535 */             byte b; CrashReport crashreport = CrashReport.a(throwable, "Exception while ticking a block");
/*  536 */             CrashReportSystemDetails crashreportsystemdetails = crashreport.a("Block being ticked");
/*      */ 
/*      */ 
/*      */             
/*      */             try {
/*  541 */               b = getData(nextticklistentry.a, nextticklistentry.b, nextticklistentry.c);
/*  542 */             } catch (Throwable throwable1) {
/*  543 */               b = -1;
/*      */             } 
/*      */             
/*  546 */             CrashReportSystemDetails.a(crashreportsystemdetails, nextticklistentry.a, nextticklistentry.b, nextticklistentry.c, block, b);
/*  547 */             throw new ReportedException(crashreport);
/*      */           }  
/*      */         continue;
/*      */       } 
/*  551 */       a(nextticklistentry.a, nextticklistentry.b, nextticklistentry.c, nextticklistentry.a(), 0);
/*      */     } 
/*      */ 
/*      */     
/*  555 */     this.methodProfiler.b();
/*  556 */     this.V.clear();
/*  557 */     return !this.N.isEmpty();
/*      */   }
/*      */ 
/*      */   
/*      */   public List a(Chunk chunk, boolean flag) {
/*  562 */     ArrayList<NextTickListEntry> arraylist = null;
/*  563 */     ChunkCoordIntPair chunkcoordintpair = chunk.l();
/*  564 */     int i = (chunkcoordintpair.x << 4) - 2;
/*  565 */     int j = i + 16 + 2;
/*  566 */     int k = (chunkcoordintpair.z << 4) - 2;
/*  567 */     int l = k + 16 + 2;
/*      */     
/*  569 */     for (int i1 = 0; i1 < 2; i1++) {
/*      */       Iterator<NextTickListEntry> iterator;
/*      */       
/*  572 */       if (i1 == 0) {
/*  573 */         iterator = this.N.iterator();
/*      */       } else {
/*  575 */         iterator = this.V.iterator();
/*  576 */         if (!this.V.isEmpty()) {
/*  577 */           a.debug("toBeTicked = " + this.V.size());
/*      */         }
/*      */       } 
/*      */       
/*  581 */       while (iterator.hasNext()) {
/*  582 */         NextTickListEntry nextticklistentry = iterator.next();
/*      */         
/*  584 */         if (nextticklistentry.a >= i && nextticklistentry.a < j && nextticklistentry.c >= k && nextticklistentry.c < l) {
/*  585 */           if (flag) {
/*  586 */             this.M.remove(nextticklistentry);
/*  587 */             iterator.remove();
/*      */           } 
/*      */           
/*  590 */           if (arraylist == null) {
/*  591 */             arraylist = new ArrayList();
/*      */           }
/*      */           
/*  594 */           arraylist.add(nextticklistentry);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  599 */     return arraylist;
/*      */   }
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
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected IChunkProvider j() {
/*      */     NormalChunkGenerator normalChunkGenerator;
/*  617 */     IChunkLoader ichunkloader = this.dataManager.createChunkLoader(this.worldProvider);
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  622 */     if (this.generator != null) {
/*  623 */       CustomChunkGenerator customChunkGenerator = new CustomChunkGenerator(this, getSeed(), this.generator);
/*  624 */     } else if (this.worldProvider instanceof WorldProviderHell) {
/*  625 */       NetherChunkGenerator netherChunkGenerator = new NetherChunkGenerator(this, getSeed());
/*  626 */     } else if (this.worldProvider instanceof WorldProviderTheEnd) {
/*  627 */       SkyLandsChunkGenerator skyLandsChunkGenerator = new SkyLandsChunkGenerator(this, getSeed());
/*      */     } else {
/*  629 */       normalChunkGenerator = new NormalChunkGenerator(this, getSeed());
/*      */     } 
/*      */     
/*  632 */     this.chunkProviderServer = new ChunkProviderServer(this, ichunkloader, (IChunkProvider)normalChunkGenerator);
/*      */ 
/*      */     
/*  635 */     return this.chunkProviderServer;
/*      */   }
/*      */   
/*      */   public List getTileEntities(int i, int j, int k, int l, int i1, int j1) {
/*  639 */     ArrayList<TileEntity> arraylist = new ArrayList();
/*      */ 
/*      */     
/*  642 */     for (int chunkX = i >> 4; chunkX <= l - 1 >> 4; chunkX++) {
/*  643 */       for (int chunkZ = k >> 4; chunkZ <= j1 - 1 >> 4; chunkZ++) {
/*  644 */         Chunk chunk = getChunkAt(chunkX, chunkZ);
/*  645 */         if (chunk != null)
/*      */         {
/*      */ 
/*      */           
/*  649 */           for (Object te : chunk.tileEntities.values()) {
/*  650 */             TileEntity tileentity = (TileEntity)te;
/*  651 */             if (tileentity.x >= i && tileentity.y >= j && tileentity.z >= k && tileentity.x < l && tileentity.y < i1 && tileentity.z < j1) {
/*  652 */               arraylist.add(tileentity);
/*      */             }
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  659 */     return arraylist;
/*      */   }
/*      */   
/*      */   public boolean a(EntityHuman entityhuman, int i, int j, int k) {
/*  663 */     return !this.server.a(this, i, j, k, entityhuman);
/*      */   }
/*      */   
/*      */   protected void a(WorldSettings worldsettings) {
/*  667 */     if (this.entitiesById == null) {
/*  668 */       this.entitiesById = new IntHashMap();
/*      */     }
/*      */     
/*  671 */     if (this.M == null) {
/*  672 */       this.M = new HashSet();
/*      */     }
/*      */     
/*  675 */     if (this.N == null) {
/*  676 */       this.N = new TreeSet();
/*      */     }
/*      */     
/*  679 */     b(worldsettings);
/*  680 */     super.a(worldsettings);
/*      */   }
/*      */   
/*      */   protected void b(WorldSettings worldsettings) {
/*  684 */     if (!this.worldProvider.e()) {
/*  685 */       this.worldData.setSpawn(0, this.worldProvider.getSeaLevel(), 0);
/*      */     } else {
/*  687 */       this.isLoading = true;
/*  688 */       WorldChunkManager worldchunkmanager = this.worldProvider.e;
/*  689 */       List list = worldchunkmanager.a();
/*  690 */       Random random = new Random(getSeed());
/*  691 */       ChunkPosition chunkposition = worldchunkmanager.a(0, 0, 256, list, random);
/*  692 */       int i = 0;
/*  693 */       int j = this.worldProvider.getSeaLevel();
/*  694 */       int k = 0;
/*      */ 
/*      */       
/*  697 */       if (this.generator != null) {
/*  698 */         Random rand = new Random(getSeed());
/*  699 */         Location spawn = this.generator.getFixedSpawnLocation((World)getWorld(), rand);
/*      */         
/*  701 */         if (spawn != null) {
/*  702 */           if (spawn.getWorld() != getWorld()) {
/*  703 */             throw new IllegalStateException("Cannot set spawn point for " + this.worldData.getName() + " to be in another world (" + spawn.getWorld().getName() + ")");
/*      */           }
/*  705 */           this.worldData.setSpawn(spawn.getBlockX(), spawn.getBlockY(), spawn.getBlockZ());
/*  706 */           this.isLoading = false;
/*      */ 
/*      */           
/*      */           return;
/*      */         } 
/*      */       } 
/*      */       
/*  713 */       if (chunkposition != null) {
/*  714 */         i = chunkposition.x;
/*  715 */         k = chunkposition.z;
/*      */       } else {
/*  717 */         a.warn("Unable to find spawn biome");
/*      */       } 
/*      */       
/*  720 */       int l = 0;
/*      */       
/*  722 */       while (!canSpawn(i, k)) {
/*  723 */         i += random.nextInt(64) - random.nextInt(64);
/*  724 */         k += random.nextInt(64) - random.nextInt(64);
/*  725 */         l++;
/*  726 */         if (l == 1000) {
/*      */           break;
/*      */         }
/*      */       } 
/*      */       
/*  731 */       this.worldData.setSpawn(i, j, k);
/*  732 */       this.isLoading = false;
/*  733 */       if (worldsettings.c()) {
/*  734 */         k();
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void k() {
/*  740 */     WorldGenBonusChest worldgenbonuschest = new WorldGenBonusChest(U, 10);
/*      */     
/*  742 */     for (int i = 0; i < 10; i++) {
/*  743 */       int j = this.worldData.c() + this.random.nextInt(6) - this.random.nextInt(6);
/*  744 */       int k = this.worldData.e() + this.random.nextInt(6) - this.random.nextInt(6);
/*  745 */       int l = i(j, k) + 1;
/*      */       
/*  747 */       if (worldgenbonuschest.generate(this, this.random, j, l, k)) {
/*      */         break;
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public ChunkCoordinates getDimensionSpawn() {
/*  754 */     return this.worldProvider.h();
/*      */   }
/*      */   
/*      */   public void save(boolean flag, IProgressUpdate iprogressupdate) throws ExceptionWorldConflict {
/*  758 */     if (this.chunkProvider.canSave()) {
/*  759 */       if (iprogressupdate != null) {
/*  760 */         iprogressupdate.a("Saving level");
/*      */       }
/*      */       
/*  763 */       a();
/*  764 */       if (iprogressupdate != null) {
/*  765 */         iprogressupdate.c("Saving chunks");
/*      */       }
/*      */       
/*  768 */       this.chunkProvider.saveChunks(flag, iprogressupdate);
/*      */       
/*  770 */       Collection arraylist = this.chunkProviderServer.a();
/*  771 */       Iterator<Chunk> iterator = arraylist.iterator();
/*      */       
/*  773 */       while (iterator.hasNext()) {
/*  774 */         Chunk chunk = iterator.next();
/*      */         
/*  776 */         if (chunk != null && !this.manager.a(chunk.locX, chunk.locZ)) {
/*  777 */           this.chunkProviderServer.queueUnload(chunk.locX, chunk.locZ);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void flushSave() {
/*  784 */     if (this.chunkProvider.canSave()) {
/*  785 */       this.chunkProvider.c();
/*      */     }
/*      */   }
/*      */   
/*      */   protected void a() throws ExceptionWorldConflict {
/*  790 */     G();
/*  791 */     this.dataManager.saveWorldData(this.worldData, this.server.getPlayerList().t());
/*      */     
/*  793 */     if (!(this instanceof SecondaryWorldServer)) {
/*  794 */       this.worldMaps.a();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   protected void a(Entity entity) {
/*  800 */     super.a(entity);
/*  801 */     this.entitiesById.a(entity.getId(), entity);
/*  802 */     Entity[] aentity = entity.at();
/*      */     
/*  804 */     if (aentity != null) {
/*  805 */       for (int i = 0; i < aentity.length; i++) {
/*  806 */         this.entitiesById.a(aentity[i].getId(), aentity[i]);
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   protected void b(Entity entity) {
/*  812 */     super.b(entity);
/*  813 */     this.entitiesById.d(entity.getId());
/*  814 */     Entity[] aentity = entity.at();
/*      */     
/*  816 */     if (aentity != null) {
/*  817 */       for (int i = 0; i < aentity.length; i++) {
/*  818 */         this.entitiesById.d(aentity[i].getId());
/*      */       }
/*      */     }
/*      */   }
/*      */   
/*      */   public Entity getEntity(int i) {
/*  824 */     return (Entity)this.entitiesById.get(i);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean strikeLightning(Entity entity) {
/*  829 */     LightningStrikeEvent lightning = new LightningStrikeEvent((World)getWorld(), (LightningStrike)entity.getBukkitEntity());
/*  830 */     getServer().getPluginManager().callEvent((Event)lightning);
/*      */     
/*  832 */     if (lightning.isCancelled()) {
/*  833 */       return false;
/*      */     }
/*      */     
/*  836 */     if (super.strikeLightning(entity)) {
/*  837 */       this.server.getPlayerList().sendPacketNearby(entity.locX, entity.locY, entity.locZ, 512.0D, this.dimension, new PacketPlayOutSpawnEntityWeather(entity));
/*      */       
/*  839 */       return true;
/*      */     } 
/*  841 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void broadcastEntityEffect(Entity entity, byte b0) {
/*  846 */     getTracker().sendPacketToEntity(entity, new PacketPlayOutEntityStatus(entity, b0));
/*      */   }
/*      */ 
/*      */   
/*      */   public Explosion createExplosion(Entity entity, double d0, double d1, double d2, float f, boolean flag, boolean flag1) {
/*  851 */     Explosion explosion = super.createExplosion(entity, d0, d1, d2, f, flag, flag1);
/*      */     
/*  853 */     if (explosion.wasCanceled) {
/*  854 */       return explosion;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  865 */     if (!flag1) {
/*  866 */       explosion.blocks.clear();
/*      */     }
/*      */     
/*  869 */     Iterator<EntityHuman> iterator = this.players.iterator();
/*      */     
/*  871 */     while (iterator.hasNext()) {
/*  872 */       EntityHuman entityhuman = iterator.next();
/*      */       
/*  874 */       if (entityhuman.e(d0, d1, d2) < 4096.0D) {
/*  875 */         ((EntityPlayer)entityhuman).playerConnection.sendPacket(new PacketPlayOutExplosion(d0, d1, d2, f, explosion.blocks, (Vec3D)explosion.b().get(entityhuman)));
/*      */       }
/*      */     } 
/*      */     
/*  879 */     return explosion;
/*      */   }
/*      */   
/*      */   public void playBlockAction(int i, int j, int k, Block block, int l, int i1) {
/*  883 */     BlockActionData blockactiondata1, blockactiondata = new BlockActionData(i, j, k, block, l, i1);
/*  884 */     Iterator<E> iterator = this.S[this.T].iterator();
/*      */ 
/*      */ 
/*      */     
/*      */     do {
/*  889 */       if (!iterator.hasNext()) {
/*  890 */         this.S[this.T].add((E)blockactiondata);
/*      */         
/*      */         return;
/*      */       } 
/*  894 */       blockactiondata1 = (BlockActionData)iterator.next();
/*  895 */     } while (!blockactiondata1.equals(blockactiondata));
/*      */   }
/*      */ 
/*      */   
/*      */   private void Z() {
/*  900 */     while (!this.S[this.T].isEmpty()) {
/*  901 */       int i = this.T;
/*      */       
/*  903 */       this.T ^= 0x1;
/*  904 */       Iterator<E> iterator = this.S[i].iterator();
/*      */       
/*  906 */       while (iterator.hasNext()) {
/*  907 */         BlockActionData blockactiondata = (BlockActionData)iterator.next();
/*      */         
/*  909 */         if (a(blockactiondata))
/*      */         {
/*  911 */           this.server.getPlayerList().sendPacketNearby(blockactiondata.a(), blockactiondata.b(), blockactiondata.c(), 64.0D, this.dimension, new PacketPlayOutBlockAction(blockactiondata.a(), blockactiondata.b(), blockactiondata.c(), blockactiondata.f(), blockactiondata.d(), blockactiondata.e()));
/*      */         }
/*      */       } 
/*      */       
/*  915 */       this.S[i].clear();
/*      */     } 
/*      */   }
/*      */   
/*      */   private boolean a(BlockActionData blockactiondata) {
/*  920 */     Block block = getType(blockactiondata.a(), blockactiondata.b(), blockactiondata.c());
/*      */     
/*  922 */     return (block == blockactiondata.f()) ? block.a(this, blockactiondata.a(), blockactiondata.b(), blockactiondata.c(), blockactiondata.d(), blockactiondata.e()) : false;
/*      */   }
/*      */   
/*      */   public void saveLevel() {
/*  926 */     this.dataManager.a();
/*      */   }
/*      */   
/*      */   protected void o() {
/*  930 */     boolean flag = Q();
/*      */     
/*  932 */     super.o();
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
/*  953 */     if (flag != Q())
/*      */     {
/*  955 */       for (int i = 0; i < this.players.size(); i++) {
/*  956 */         if (((EntityPlayer)this.players.get(i)).world == this) {
/*  957 */           ((EntityPlayer)this.players.get(i)).setPlayerWeather(!flag ? WeatherType.DOWNFALL : WeatherType.CLEAR, false);
/*      */         }
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   protected int p() {
/*  965 */     return this.server.getPlayerList().s();
/*      */   }
/*      */   
/*      */   public MinecraftServer getMinecraftServer() {
/*  969 */     return this.server;
/*      */   }
/*      */   
/*      */   public EntityTracker getTracker() {
/*  973 */     return this.tracker;
/*      */   }
/*      */   
/*      */   public PlayerChunkMap getPlayerChunkMap() {
/*  977 */     return this.manager;
/*      */   }
/*      */   
/*      */   public PortalTravelAgent getTravelAgent() {
/*  981 */     return this.Q;
/*      */   }
/*      */   
/*      */   public void a(String s, double d0, double d1, double d2, int i, double d3, double d4, double d5, double d6) {
/*  985 */     PacketPlayOutWorldParticles packetplayoutworldparticles = new PacketPlayOutWorldParticles(s, (float)d0, (float)d1, (float)d2, (float)d3, (float)d4, (float)d5, (float)d6, i);
/*      */     
/*  987 */     for (int j = 0; j < this.players.size(); j++) {
/*  988 */       EntityPlayer entityplayer = this.players.get(j);
/*  989 */       ChunkCoordinates chunkcoordinates = entityplayer.getChunkCoordinates();
/*  990 */       double d7 = d0 - chunkcoordinates.x;
/*  991 */       double d8 = d1 - chunkcoordinates.y;
/*  992 */       double d9 = d2 - chunkcoordinates.z;
/*  993 */       double d10 = d7 * d7 + d8 * d8 + d9 * d9;
/*      */       
/*  995 */       if (d10 <= 256.0D) {
/*  996 */         entityplayer.playerConnection.sendPacket(packetplayoutworldparticles);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public int getTypeId(int x, int y, int z) {
/* 1003 */     return Block.getId(getType(x, y, z));
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\WorldServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */