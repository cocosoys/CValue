/*      */ package org.bukkit.craftbukkit.v1_7_R4;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.List;
/*      */ import java.util.Set;
/*      */ import net.minecraft.server.v1_7_R4.Block;
/*      */ import net.minecraft.server.v1_7_R4.Chunk;
/*      */ import net.minecraft.server.v1_7_R4.ChunkCoordinates;
/*      */ import net.minecraft.server.v1_7_R4.Entity;
/*      */ import net.minecraft.server.v1_7_R4.EntityArrow;
/*      */ import net.minecraft.server.v1_7_R4.EntityBat;
/*      */ import net.minecraft.server.v1_7_R4.EntityFallingBlock;
/*      */ import net.minecraft.server.v1_7_R4.EntityFireworks;
/*      */ import net.minecraft.server.v1_7_R4.EntityItem;
/*      */ import net.minecraft.server.v1_7_R4.EntityLargeFireball;
/*      */ import net.minecraft.server.v1_7_R4.EntityLeash;
/*      */ import net.minecraft.server.v1_7_R4.EntityLightning;
/*      */ import net.minecraft.server.v1_7_R4.IChunkProvider;
/*      */ import net.minecraft.server.v1_7_R4.World;
/*      */ import net.minecraft.server.v1_7_R4.WorldGenAcaciaTree;
/*      */ import net.minecraft.server.v1_7_R4.WorldGenForest;
/*      */ import net.minecraft.server.v1_7_R4.WorldGenForestTree;
/*      */ import net.minecraft.server.v1_7_R4.WorldGenGroundBush;
/*      */ import net.minecraft.server.v1_7_R4.WorldGenHugeMushroom;
/*      */ import net.minecraft.server.v1_7_R4.WorldGenJungleTree;
/*      */ import net.minecraft.server.v1_7_R4.WorldGenMegaTree;
/*      */ import net.minecraft.server.v1_7_R4.WorldGenSwampTree;
/*      */ import net.minecraft.server.v1_7_R4.WorldGenTaiga1;
/*      */ import net.minecraft.server.v1_7_R4.WorldGenTaiga2;
/*      */ import net.minecraft.server.v1_7_R4.WorldGenTrees;
/*      */ import net.minecraft.server.v1_7_R4.WorldServer;
/*      */ import org.apache.commons.lang.Validate;
/*      */ import org.bukkit.Chunk;
/*      */ import org.bukkit.Difficulty;
/*      */ import org.bukkit.Effect;
/*      */ import org.bukkit.Location;
/*      */ import org.bukkit.Material;
/*      */ import org.bukkit.TreeType;
/*      */ import org.bukkit.World;
/*      */ import org.bukkit.block.Block;
/*      */ import org.bukkit.block.BlockFace;
/*      */ import org.bukkit.block.BlockState;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftEntity;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
/*      */ import org.bukkit.entity.Entity;
/*      */ import org.bukkit.entity.EntityType;
/*      */ import org.bukkit.entity.FallingBlock;
/*      */ import org.bukkit.entity.LightningStrike;
/*      */ import org.bukkit.entity.LivingEntity;
/*      */ import org.bukkit.entity.Player;
/*      */ import org.bukkit.event.entity.CreatureSpawnEvent;
/*      */ import org.bukkit.event.weather.ThunderChangeEvent;
/*      */ import org.bukkit.event.weather.WeatherChangeEvent;
/*      */ import org.bukkit.inventory.ItemStack;
/*      */ import org.bukkit.plugin.Plugin;
/*      */ import org.bukkit.util.Vector;
/*      */ 
/*      */ public class CraftWorld implements World {
/*      */   public static final int CUSTOM_DIMENSION_OFFSET = 10;
/*   60 */   private final CraftServer server = (CraftServer)Bukkit.getServer(); private final WorldServer world; private World.Environment environment;
/*      */   private final ChunkGenerator generator;
/*   62 */   private final List<BlockPopulator> populators = new ArrayList<BlockPopulator>();
/*   63 */   private final BlockMetadataStore blockMetadata = new BlockMetadataStore(this);
/*   64 */   private int monsterSpawn = -1;
/*   65 */   private int animalSpawn = -1;
/*   66 */   private int waterAnimalSpawn = -1;
/*   67 */   private int ambientSpawn = -1;
/*   68 */   private int chunkLoadCount = 0;
/*      */   
/*      */   private int chunkGCTickCount;
/*   71 */   private static final Random rand = new Random();
/*      */   
/*      */   public CraftWorld(WorldServer world, ChunkGenerator gen, World.Environment env) {
/*   74 */     this.world = world;
/*   75 */     this.generator = gen;
/*      */     
/*   77 */     this.environment = env;
/*      */     
/*   79 */     if (this.server.chunkGCPeriod > 0) {
/*   80 */       this.chunkGCTickCount = rand.nextInt(this.server.chunkGCPeriod);
/*      */     }
/*      */   }
/*      */   
/*      */   public Block getBlockAt(int x, int y, int z) {
/*   85 */     return getChunkAt(x >> 4, z >> 4).getBlock(x & 0xF, y & 0xFF, z & 0xF);
/*      */   }
/*      */   
/*      */   public int getBlockTypeIdAt(int x, int y, int z) {
/*   89 */     return this.world.getTypeId(x, y, z);
/*      */   }
/*      */   
/*      */   public int getHighestBlockYAt(int x, int z) {
/*   93 */     if (!isChunkLoaded(x >> 4, z >> 4)) {
/*   94 */       loadChunk(x >> 4, z >> 4);
/*      */     }
/*      */     
/*   97 */     return this.world.getHighestBlockYAt(x, z);
/*      */   }
/*      */   
/*      */   public Location getSpawnLocation() {
/*  101 */     ChunkCoordinates spawn = this.world.getSpawn();
/*  102 */     return new Location(this, spawn.x, spawn.y, spawn.z);
/*      */   }
/*      */   
/*      */   public boolean setSpawnLocation(int x, int y, int z) {
/*      */     try {
/*  107 */       Location previousLocation = getSpawnLocation();
/*  108 */       this.world.worldData.setSpawn(x, y, z);
/*      */ 
/*      */       
/*  111 */       SpawnChangeEvent event = new SpawnChangeEvent(this, previousLocation);
/*  112 */       this.server.getPluginManager().callEvent((Event)event);
/*      */       
/*  114 */       return true;
/*  115 */     } catch (Exception e) {
/*  116 */       return false;
/*      */     } 
/*      */   }
/*      */   
/*      */   public Chunk getChunkAt(int x, int z) {
/*  121 */     return (this.world.chunkProviderServer.getChunkAt(x, z)).bukkitChunk;
/*      */   }
/*      */   
/*      */   public Chunk getChunkAt(Block block) {
/*  125 */     return getChunkAt(block.getX() >> 4, block.getZ() >> 4);
/*      */   }
/*      */   
/*      */   public boolean isChunkLoaded(int x, int z) {
/*  129 */     return this.world.chunkProviderServer.isChunkLoaded(x, z);
/*      */   }
/*      */   
/*      */   public Chunk[] getLoadedChunks() {
/*  133 */     Object[] chunks = this.world.chunkProviderServer.chunks.values().toArray();
/*  134 */     CraftChunk[] arrayOfCraftChunk = new CraftChunk[chunks.length];
/*      */     
/*  136 */     for (int i = 0; i < chunks.length; i++) {
/*  137 */       Chunk chunk = (Chunk)chunks[i];
/*  138 */       arrayOfCraftChunk[i] = (CraftChunk)chunk.bukkitChunk;
/*      */     } 
/*      */     
/*  141 */     return (Chunk[])arrayOfCraftChunk;
/*      */   }
/*      */   
/*      */   public void loadChunk(int x, int z) {
/*  145 */     loadChunk(x, z, true);
/*      */   }
/*      */   
/*      */   public boolean unloadChunk(Chunk chunk) {
/*  149 */     return unloadChunk(chunk.getX(), chunk.getZ());
/*      */   }
/*      */   
/*      */   public boolean unloadChunk(int x, int z) {
/*  153 */     return unloadChunk(x, z, true);
/*      */   }
/*      */   
/*      */   public boolean unloadChunk(int x, int z, boolean save) {
/*  157 */     return unloadChunk(x, z, save, false);
/*      */   }
/*      */   
/*      */   public boolean unloadChunkRequest(int x, int z) {
/*  161 */     return unloadChunkRequest(x, z, true);
/*      */   }
/*      */   
/*      */   public boolean unloadChunkRequest(int x, int z, boolean safe) {
/*  165 */     if (safe && isChunkInUse(x, z)) {
/*  166 */       return false;
/*      */     }
/*      */     
/*  169 */     this.world.chunkProviderServer.queueUnload(x, z);
/*      */     
/*  171 */     return true;
/*      */   }
/*      */   
/*      */   public boolean unloadChunk(int x, int z, boolean save, boolean safe) {
/*  175 */     if (safe && isChunkInUse(x, z)) {
/*  176 */       return false;
/*      */     }
/*      */     
/*  179 */     Chunk chunk = this.world.chunkProviderServer.getOrCreateChunk(x, z);
/*  180 */     if (chunk.mustSave) {
/*  181 */       save = true;
/*      */     }
/*      */     
/*  184 */     chunk.removeEntities();
/*      */     
/*  186 */     if (save && !(chunk instanceof net.minecraft.server.v1_7_R4.EmptyChunk)) {
/*  187 */       this.world.chunkProviderServer.saveChunk(chunk);
/*  188 */       this.world.chunkProviderServer.saveChunkNOP(chunk);
/*      */     } 
/*      */     
/*  191 */     this.world.chunkProviderServer.unloadQueue.remove(x, z);
/*  192 */     this.world.chunkProviderServer.chunks.remove(LongHash.toLong(x, z));
/*      */     
/*  194 */     return true;
/*      */   }
/*      */   
/*      */   public boolean regenerateChunk(int x, int z) {
/*  198 */     unloadChunk(x, z, false, false);
/*      */     
/*  200 */     this.world.chunkProviderServer.unloadQueue.remove(x, z);
/*      */     
/*  202 */     Chunk chunk = null;
/*      */     
/*  204 */     if (this.world.chunkProviderServer.chunkProvider == null) {
/*  205 */       chunk = this.world.chunkProviderServer.emptyChunk;
/*      */     } else {
/*  207 */       chunk = this.world.chunkProviderServer.chunkProvider.getOrCreateChunk(x, z);
/*      */     } 
/*      */     
/*  210 */     chunkLoadPostProcess(chunk, x, z);
/*      */     
/*  212 */     refreshChunk(x, z);
/*      */     
/*  214 */     return (chunk != null);
/*      */   }
/*      */   
/*      */   public boolean refreshChunk(int x, int z) {
/*  218 */     if (!isChunkLoaded(x, z)) {
/*  219 */       return false;
/*      */     }
/*      */     
/*  222 */     int px = x << 4;
/*  223 */     int pz = z << 4;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  228 */     int height = getMaxHeight() / 16;
/*  229 */     for (int idx = 0; idx < 64; idx++) {
/*  230 */       this.world.notify(px + idx / height, idx % height * 16, pz);
/*      */     }
/*  232 */     this.world.notify(px + 15, height * 16 - 1, pz + 15);
/*      */     
/*  234 */     return true;
/*      */   }
/*      */   
/*      */   public boolean isChunkInUse(int x, int z) {
/*  238 */     return this.world.getPlayerChunkMap().isChunkInUse(x, z);
/*      */   }
/*      */   
/*      */   public boolean loadChunk(int x, int z, boolean generate) {
/*  242 */     this.chunkLoadCount++;
/*  243 */     if (generate)
/*      */     {
/*  245 */       return (this.world.chunkProviderServer.getChunkAt(x, z) != null);
/*      */     }
/*      */     
/*  248 */     this.world.chunkProviderServer.unloadQueue.remove(x, z);
/*  249 */     Chunk chunk = (Chunk)this.world.chunkProviderServer.chunks.get(LongHash.toLong(x, z));
/*      */     
/*  251 */     if (chunk == null) {
/*  252 */       chunk = this.world.chunkProviderServer.loadChunk(x, z);
/*      */       
/*  254 */       chunkLoadPostProcess(chunk, x, z);
/*      */     } 
/*  256 */     return (chunk != null);
/*      */   }
/*      */   
/*      */   private void chunkLoadPostProcess(Chunk chunk, int x, int z) {
/*  260 */     if (chunk != null) {
/*  261 */       this.world.chunkProviderServer.chunks.put(LongHash.toLong(x, z), chunk);
/*      */       
/*  263 */       chunk.addEntities();
/*      */       
/*  265 */       if (!chunk.done && this.world.chunkProviderServer.isChunkLoaded(x + 1, z + 1) && this.world.chunkProviderServer.isChunkLoaded(x, z + 1) && this.world.chunkProviderServer.isChunkLoaded(x + 1, z)) {
/*  266 */         this.world.chunkProviderServer.getChunkAt((IChunkProvider)this.world.chunkProviderServer, x, z);
/*      */       }
/*      */       
/*  269 */       if (this.world.chunkProviderServer.isChunkLoaded(x - 1, z) && !(this.world.chunkProviderServer.getOrCreateChunk(x - 1, z)).done && this.world.chunkProviderServer.isChunkLoaded(x - 1, z + 1) && this.world.chunkProviderServer.isChunkLoaded(x, z + 1) && this.world.chunkProviderServer.isChunkLoaded(x - 1, z)) {
/*  270 */         this.world.chunkProviderServer.getChunkAt((IChunkProvider)this.world.chunkProviderServer, x - 1, z);
/*      */       }
/*      */       
/*  273 */       if (this.world.chunkProviderServer.isChunkLoaded(x, z - 1) && !(this.world.chunkProviderServer.getOrCreateChunk(x, z - 1)).done && this.world.chunkProviderServer.isChunkLoaded(x + 1, z - 1) && this.world.chunkProviderServer.isChunkLoaded(x, z - 1) && this.world.chunkProviderServer.isChunkLoaded(x + 1, z)) {
/*  274 */         this.world.chunkProviderServer.getChunkAt((IChunkProvider)this.world.chunkProviderServer, x, z - 1);
/*      */       }
/*      */       
/*  277 */       if (this.world.chunkProviderServer.isChunkLoaded(x - 1, z - 1) && !(this.world.chunkProviderServer.getOrCreateChunk(x - 1, z - 1)).done && this.world.chunkProviderServer.isChunkLoaded(x - 1, z - 1) && this.world.chunkProviderServer.isChunkLoaded(x, z - 1) && this.world.chunkProviderServer.isChunkLoaded(x - 1, z)) {
/*  278 */         this.world.chunkProviderServer.getChunkAt((IChunkProvider)this.world.chunkProviderServer, x - 1, z - 1);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean isChunkLoaded(Chunk chunk) {
/*  284 */     return isChunkLoaded(chunk.getX(), chunk.getZ());
/*      */   }
/*      */   
/*      */   public void loadChunk(Chunk chunk) {
/*  288 */     loadChunk(chunk.getX(), chunk.getZ());
/*  289 */     (((CraftChunk)getChunkAt(chunk.getX(), chunk.getZ())).getHandle()).bukkitChunk = chunk;
/*      */   }
/*      */   
/*      */   public WorldServer getHandle() {
/*  293 */     return this.world;
/*      */   }
/*      */   
/*      */   public Item dropItem(Location loc, ItemStack item) {
/*  297 */     Validate.notNull(item, "Cannot drop a Null item.");
/*  298 */     Validate.isTrue((item.getTypeId() != 0), "Cannot drop AIR.");
/*  299 */     EntityItem entity = new EntityItem((World)this.world, loc.getX(), loc.getY(), loc.getZ(), CraftItemStack.asNMSCopy(item));
/*  300 */     entity.pickupDelay = 10;
/*  301 */     this.world.addEntity((Entity)entity);
/*      */ 
/*      */     
/*  304 */     return (Item)new CraftItem(this.world.getServer(), entity);
/*      */   }
/*      */   
/*      */   public Item dropItemNaturally(Location loc, ItemStack item) {
/*  308 */     double xs = (this.world.random.nextFloat() * 0.7F) + 0.15000000596046448D;
/*  309 */     double ys = (this.world.random.nextFloat() * 0.7F) + 0.15000000596046448D;
/*  310 */     double zs = (this.world.random.nextFloat() * 0.7F) + 0.15000000596046448D;
/*  311 */     loc = loc.clone();
/*  312 */     loc.setX(loc.getX() + xs);
/*  313 */     loc.setY(loc.getY() + ys);
/*  314 */     loc.setZ(loc.getZ() + zs);
/*  315 */     return dropItem(loc, item);
/*      */   }
/*      */   
/*      */   public Arrow spawnArrow(Location loc, Vector velocity, float speed, float spread) {
/*  319 */     Validate.notNull(loc, "Can not spawn arrow with a null location");
/*  320 */     Validate.notNull(velocity, "Can not spawn arrow with a null velocity");
/*      */     
/*  322 */     EntityArrow arrow = new EntityArrow((World)this.world);
/*  323 */     arrow.setPositionRotation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
/*  324 */     arrow.shoot(velocity.getX(), velocity.getY(), velocity.getZ(), speed, spread);
/*  325 */     this.world.addEntity((Entity)arrow);
/*  326 */     return (Arrow)arrow.getBukkitEntity();
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   public LivingEntity spawnCreature(Location loc, CreatureType creatureType) {
/*  331 */     return spawnCreature(loc, creatureType.toEntityType());
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   public LivingEntity spawnCreature(Location loc, EntityType creatureType) {
/*  336 */     Validate.isTrue(creatureType.isAlive(), "EntityType not instance of LivingEntity");
/*  337 */     return (LivingEntity)spawnEntity(loc, creatureType);
/*      */   }
/*      */   
/*      */   public Entity spawnEntity(Location loc, EntityType entityType) {
/*  341 */     return spawn(loc, entityType.getEntityClass());
/*      */   }
/*      */   
/*      */   public LightningStrike strikeLightning(Location loc) {
/*  345 */     EntityLightning lightning = new EntityLightning((World)this.world, loc.getX(), loc.getY(), loc.getZ());
/*  346 */     this.world.strikeLightning((Entity)lightning);
/*  347 */     return (LightningStrike)new CraftLightningStrike(this.server, lightning);
/*      */   }
/*      */   
/*      */   public LightningStrike strikeLightningEffect(Location loc) {
/*  351 */     EntityLightning lightning = new EntityLightning((World)this.world, loc.getX(), loc.getY(), loc.getZ(), true);
/*  352 */     this.world.strikeLightning((Entity)lightning);
/*  353 */     return (LightningStrike)new CraftLightningStrike(this.server, lightning); } public boolean generateTree(Location loc, TreeType type) { WorldGenBigTree worldGenBigTree; WorldGenForest worldGenForest2; WorldGenTaiga2 worldGenTaiga2; WorldGenTaiga1 worldGenTaiga1; WorldGenJungleTree worldGenJungleTree; WorldGenTrees worldGenTrees2; WorldGenGroundBush worldGenGroundBush; WorldGenHugeMushroom worldGenHugeMushroom; WorldGenSwampTree worldGenSwampTree;
/*      */     WorldGenAcaciaTree worldGenAcaciaTree;
/*      */     WorldGenForestTree worldGenForestTree;
/*      */     WorldGenMegaTree worldGenMegaTree;
/*      */     WorldGenForest worldGenForest1;
/*  358 */     switch (type)
/*      */     { case SOUTH:
/*  360 */         worldGenBigTree = new WorldGenBigTree(true);
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  410 */         return worldGenBigTree.generate((World)this.world, rand, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());case WEST: worldGenForest2 = new WorldGenForest(true, false); return worldGenForest2.generate((World)this.world, rand, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());case NORTH: worldGenTaiga2 = new WorldGenTaiga2(true); return worldGenTaiga2.generate((World)this.world, rand, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());case EAST: worldGenTaiga1 = new WorldGenTaiga1(); return worldGenTaiga1.generate((World)this.world, rand, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());case null: worldGenJungleTree = new WorldGenJungleTree(true, 10, 20, 3, 3); return worldGenJungleTree.generate((World)this.world, rand, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());case null: worldGenTrees2 = new WorldGenTrees(true, 4 + rand.nextInt(7), 3, 3, false); return worldGenTrees2.generate((World)this.world, rand, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());case null: worldGenTrees2 = new WorldGenTrees(true, 4 + rand.nextInt(7), 3, 3, true); return worldGenTrees2.generate((World)this.world, rand, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());case null: worldGenGroundBush = new WorldGenGroundBush(3, 0); return worldGenGroundBush.generate((World)this.world, rand, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());case null: worldGenHugeMushroom = new WorldGenHugeMushroom(1); return worldGenHugeMushroom.generate((World)this.world, rand, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());case null: worldGenHugeMushroom = new WorldGenHugeMushroom(0); return worldGenHugeMushroom.generate((World)this.world, rand, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());case null: worldGenSwampTree = new WorldGenSwampTree(); return worldGenSwampTree.generate((World)this.world, rand, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());case null: worldGenAcaciaTree = new WorldGenAcaciaTree(true); return worldGenAcaciaTree.generate((World)this.world, rand, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());case null: worldGenForestTree = new WorldGenForestTree(true); return worldGenForestTree.generate((World)this.world, rand, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());case null: worldGenMegaTree = new WorldGenMegaTree(false, rand.nextBoolean()); return worldGenMegaTree.generate((World)this.world, rand, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());case null: worldGenForest1 = new WorldGenForest(true, true); return worldGenForest1.generate((World)this.world, rand, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()); }  WorldGenTrees worldGenTrees1 = new WorldGenTrees(true); return worldGenTrees1.generate((World)this.world, rand, loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()); }
/*      */ 
/*      */   
/*      */   public boolean generateTree(Location loc, TreeType type, BlockChangeDelegate delegate) {
/*  414 */     this.world.captureTreeGeneration = true;
/*  415 */     this.world.captureBlockStates = true;
/*  416 */     boolean grownTree = generateTree(loc, type);
/*  417 */     this.world.captureBlockStates = false;
/*  418 */     this.world.captureTreeGeneration = false;
/*  419 */     if (grownTree) {
/*  420 */       for (BlockState blockstate : this.world.capturedBlockStates) {
/*  421 */         int x = blockstate.getX();
/*  422 */         int y = blockstate.getY();
/*  423 */         int z = blockstate.getZ();
/*  424 */         Block oldBlock = this.world.getType(x, y, z);
/*  425 */         int typeId = blockstate.getTypeId();
/*  426 */         int data = blockstate.getRawData();
/*  427 */         int flag = ((CraftBlockState)blockstate).getFlag();
/*  428 */         delegate.setTypeIdAndData(x, y, z, typeId, data);
/*  429 */         Block newBlock = this.world.getType(x, y, z);
/*  430 */         this.world.notifyAndUpdatePhysics(x, y, z, null, oldBlock, newBlock, flag);
/*      */       } 
/*  432 */       this.world.capturedBlockStates.clear();
/*  433 */       return true;
/*      */     } 
/*  435 */     this.world.capturedBlockStates.clear();
/*  436 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public TileEntity getTileEntityAt(int x, int y, int z) {
/*  441 */     return this.world.getTileEntity(x, y, z);
/*      */   }
/*      */   
/*      */   public String getName() {
/*  445 */     return this.world.worldData.getName();
/*      */   }
/*      */   
/*      */   @Deprecated
/*      */   public long getId() {
/*  450 */     return this.world.worldData.getSeed();
/*      */   }
/*      */   
/*      */   public UUID getUID() {
/*  454 */     return this.world.getDataManager().getUUID();
/*      */   }
/*      */ 
/*      */   
/*      */   public String toString() {
/*  459 */     return "CraftWorld{name=" + getName() + '}';
/*      */   }
/*      */   
/*      */   public long getTime() {
/*  463 */     long time = getFullTime() % 24000L;
/*  464 */     if (time < 0L) time += 24000L; 
/*  465 */     return time;
/*      */   }
/*      */   
/*      */   public void setTime(long time) {
/*  469 */     long margin = (time - getFullTime()) % 24000L;
/*  470 */     if (margin < 0L) margin += 24000L; 
/*  471 */     setFullTime(getFullTime() + margin);
/*      */   }
/*      */   
/*      */   public long getFullTime() {
/*  475 */     return this.world.getDayTime();
/*      */   }
/*      */   
/*      */   public void setFullTime(long time) {
/*  479 */     this.world.setDayTime(time);
/*      */ 
/*      */     
/*  482 */     for (Player p : getPlayers()) {
/*  483 */       CraftPlayer cp = (CraftPlayer)p;
/*  484 */       if ((cp.getHandle()).playerConnection == null)
/*      */         continue; 
/*  486 */       (cp.getHandle()).playerConnection.sendPacket((Packet)new PacketPlayOutUpdateTime((cp.getHandle()).world.getTime(), cp.getHandle().getPlayerTime(), (cp.getHandle()).world.getGameRules().getBoolean("doDaylightCycle")));
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean createExplosion(double x, double y, double z, float power) {
/*  491 */     return createExplosion(x, y, z, power, false, true);
/*      */   }
/*      */   
/*      */   public boolean createExplosion(double x, double y, double z, float power, boolean setFire) {
/*  495 */     return createExplosion(x, y, z, power, setFire, true);
/*      */   }
/*      */   
/*      */   public boolean createExplosion(double x, double y, double z, float power, boolean setFire, boolean breakBlocks) {
/*  499 */     return !(this.world.createExplosion(null, x, y, z, power, setFire, breakBlocks)).wasCanceled;
/*      */   }
/*      */   
/*      */   public boolean createExplosion(Location loc, float power) {
/*  503 */     return createExplosion(loc, power, false);
/*      */   }
/*      */   
/*      */   public boolean createExplosion(Location loc, float power, boolean setFire) {
/*  507 */     return createExplosion(loc.getX(), loc.getY(), loc.getZ(), power, setFire);
/*      */   }
/*      */   
/*      */   public World.Environment getEnvironment() {
/*  511 */     return this.environment;
/*      */   }
/*      */   
/*      */   public void setEnvironment(World.Environment env) {
/*  515 */     if (this.environment != env) {
/*  516 */       this.environment = env;
/*  517 */       this.world.worldProvider = WorldProvider.byDimension(this.environment.getId());
/*      */     } 
/*      */   }
/*      */   
/*      */   public Block getBlockAt(Location location) {
/*  522 */     return getBlockAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
/*      */   }
/*      */   
/*      */   public int getBlockTypeIdAt(Location location) {
/*  526 */     return getBlockTypeIdAt(location.getBlockX(), location.getBlockY(), location.getBlockZ());
/*      */   }
/*      */   
/*      */   public int getHighestBlockYAt(Location location) {
/*  530 */     return getHighestBlockYAt(location.getBlockX(), location.getBlockZ());
/*      */   }
/*      */   
/*      */   public Chunk getChunkAt(Location location) {
/*  534 */     return getChunkAt(location.getBlockX() >> 4, location.getBlockZ() >> 4);
/*      */   }
/*      */   
/*      */   public ChunkGenerator getGenerator() {
/*  538 */     return this.generator;
/*      */   }
/*      */   
/*      */   public List<BlockPopulator> getPopulators() {
/*  542 */     return this.populators;
/*      */   }
/*      */   
/*      */   public Block getHighestBlockAt(int x, int z) {
/*  546 */     return getBlockAt(x, getHighestBlockYAt(x, z), z);
/*      */   }
/*      */   
/*      */   public Block getHighestBlockAt(Location location) {
/*  550 */     return getHighestBlockAt(location.getBlockX(), location.getBlockZ());
/*      */   }
/*      */   
/*      */   public Biome getBiome(int x, int z) {
/*  554 */     return CraftBlock.biomeBaseToBiome(this.world.getBiome(x, z));
/*      */   }
/*      */   
/*      */   public void setBiome(int x, int z, Biome bio) {
/*  558 */     BiomeBase bb = CraftBlock.biomeToBiomeBase(bio);
/*  559 */     if (this.world.isLoaded(x, 0, z)) {
/*  560 */       Chunk chunk = this.world.getChunkAtWorldCoords(x, z);
/*      */       
/*  562 */       if (chunk != null) {
/*  563 */         byte[] biomevals = chunk.m();
/*  564 */         biomevals[(z & 0xF) << 4 | x & 0xF] = (byte)bb.id;
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public double getTemperature(int x, int z) {
/*  570 */     return (this.world.getBiome(x, z)).temperature;
/*      */   }
/*      */   
/*      */   public double getHumidity(int x, int z) {
/*  574 */     return (this.world.getBiome(x, z)).humidity;
/*      */   }
/*      */   
/*      */   public List<Entity> getEntities() {
/*  578 */     List<Entity> list = new ArrayList<Entity>();
/*      */     
/*  580 */     for (Object o : this.world.entityList) {
/*  581 */       if (o instanceof Entity) {
/*  582 */         Entity mcEnt = (Entity)o;
/*  583 */         CraftEntity craftEntity = mcEnt.getBukkitEntity();
/*      */ 
/*      */         
/*  586 */         if (craftEntity != null) {
/*  587 */           list.add(craftEntity);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  592 */     return list;
/*      */   }
/*      */   
/*      */   public List<LivingEntity> getLivingEntities() {
/*  596 */     List<LivingEntity> list = new ArrayList<LivingEntity>();
/*      */     
/*  598 */     for (Object o : this.world.entityList) {
/*  599 */       if (o instanceof Entity) {
/*  600 */         Entity mcEnt = (Entity)o;
/*  601 */         CraftEntity craftEntity = mcEnt.getBukkitEntity();
/*      */ 
/*      */         
/*  604 */         if (craftEntity != null && craftEntity instanceof LivingEntity) {
/*  605 */           list.add((LivingEntity)craftEntity);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  610 */     return list;
/*      */   }
/*      */ 
/*      */   
/*      */   @Deprecated
/*      */   public <T extends Entity> Collection<T> getEntitiesByClass(Class<T>... classes) {
/*  616 */     return (Collection)getEntitiesByClasses((Class<?>[])classes);
/*      */   }
/*      */ 
/*      */   
/*      */   public <T extends Entity> Collection<T> getEntitiesByClass(Class<T> clazz) {
/*  621 */     Collection<T> list = new ArrayList<T>();
/*      */     
/*  623 */     for (Object entity : this.world.entityList) {
/*  624 */       if (entity instanceof Entity) {
/*  625 */         CraftEntity craftEntity = ((Entity)entity).getBukkitEntity();
/*      */         
/*  627 */         if (craftEntity == null) {
/*      */           continue;
/*      */         }
/*      */         
/*  631 */         Class<?> bukkitClass = craftEntity.getClass();
/*      */         
/*  633 */         if (clazz.isAssignableFrom(bukkitClass)) {
/*  634 */           list.add((T)craftEntity);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  639 */     return list;
/*      */   }
/*      */   
/*      */   public Collection<Entity> getEntitiesByClasses(Class<?>... classes) {
/*  643 */     Collection<Entity> list = new ArrayList<Entity>();
/*      */     
/*  645 */     for (Object entity : this.world.entityList) {
/*  646 */       if (entity instanceof Entity) {
/*  647 */         CraftEntity craftEntity = ((Entity)entity).getBukkitEntity();
/*      */         
/*  649 */         if (craftEntity == null) {
/*      */           continue;
/*      */         }
/*      */         
/*  653 */         Class<?> bukkitClass = craftEntity.getClass();
/*      */         
/*  655 */         for (Class<?> clazz : classes) {
/*  656 */           if (clazz.isAssignableFrom(bukkitClass)) {
/*  657 */             list.add(craftEntity);
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  664 */     return list;
/*      */   }
/*      */   
/*      */   public List<Player> getPlayers() {
/*  668 */     List<Player> list = new ArrayList<Player>();
/*      */     
/*  670 */     for (Object o : this.world.entityList) {
/*  671 */       if (o instanceof Entity) {
/*  672 */         Entity mcEnt = (Entity)o;
/*  673 */         CraftEntity craftEntity = mcEnt.getBukkitEntity();
/*      */         
/*  675 */         if (craftEntity != null && craftEntity instanceof Player) {
/*  676 */           list.add((Player)craftEntity);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*  681 */     return list;
/*      */   }
/*      */   
/*      */   public void save() {
/*  685 */     this.server.checkSaveState();
/*      */     try {
/*  687 */       boolean oldSave = this.world.savingDisabled;
/*      */       
/*  689 */       this.world.savingDisabled = false;
/*  690 */       this.world.save(true, null);
/*      */       
/*  692 */       this.world.savingDisabled = oldSave;
/*  693 */     } catch (ExceptionWorldConflict ex) {
/*  694 */       ex.printStackTrace();
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean isAutoSave() {
/*  699 */     return !this.world.savingDisabled;
/*      */   }
/*      */   
/*      */   public void setAutoSave(boolean value) {
/*  703 */     this.world.savingDisabled = !value;
/*      */   }
/*      */   
/*      */   public void setDifficulty(Difficulty difficulty) {
/*  707 */     (getHandle()).difficulty = EnumDifficulty.getById(difficulty.getValue());
/*      */   }
/*      */   
/*      */   public Difficulty getDifficulty() {
/*  711 */     return Difficulty.getByValue((getHandle()).difficulty.ordinal());
/*      */   }
/*      */   
/*      */   public BlockMetadataStore getBlockMetadata() {
/*  715 */     return this.blockMetadata;
/*      */   }
/*      */   
/*      */   public boolean hasStorm() {
/*  719 */     return this.world.worldData.hasStorm();
/*      */   }
/*      */   
/*      */   public void setStorm(boolean hasStorm) {
/*  723 */     CraftServer server = this.world.getServer();
/*      */     
/*  725 */     WeatherChangeEvent weather = new WeatherChangeEvent(this, hasStorm);
/*  726 */     server.getPluginManager().callEvent((Event)weather);
/*  727 */     if (!weather.isCancelled()) {
/*  728 */       this.world.worldData.setStorm(hasStorm);
/*      */ 
/*      */       
/*  731 */       if (hasStorm) {
/*  732 */         setWeatherDuration(rand.nextInt(12000) + 12000);
/*      */       } else {
/*  734 */         setWeatherDuration(rand.nextInt(168000) + 12000);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public int getWeatherDuration() {
/*  740 */     return this.world.worldData.getWeatherDuration();
/*      */   }
/*      */   
/*      */   public void setWeatherDuration(int duration) {
/*  744 */     this.world.worldData.setWeatherDuration(duration);
/*      */   }
/*      */   
/*      */   public boolean isThundering() {
/*  748 */     return (hasStorm() && this.world.worldData.isThundering());
/*      */   }
/*      */   
/*      */   public void setThundering(boolean thundering) {
/*  752 */     if (thundering && !hasStorm()) setStorm(true); 
/*  753 */     CraftServer server = this.world.getServer();
/*      */     
/*  755 */     ThunderChangeEvent thunder = new ThunderChangeEvent(this, thundering);
/*  756 */     server.getPluginManager().callEvent((Event)thunder);
/*  757 */     if (!thunder.isCancelled()) {
/*  758 */       this.world.worldData.setThundering(thundering);
/*      */ 
/*      */       
/*  761 */       if (thundering) {
/*  762 */         setThunderDuration(rand.nextInt(12000) + 3600);
/*      */       } else {
/*  764 */         setThunderDuration(rand.nextInt(168000) + 12000);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public int getThunderDuration() {
/*  770 */     return this.world.worldData.getThunderDuration();
/*      */   }
/*      */   
/*      */   public void setThunderDuration(int duration) {
/*  774 */     this.world.worldData.setThunderDuration(duration);
/*      */   }
/*      */   
/*      */   public long getSeed() {
/*  778 */     return this.world.worldData.getSeed();
/*      */   }
/*      */   
/*      */   public boolean getPVP() {
/*  782 */     return this.world.pvpMode;
/*      */   }
/*      */   
/*      */   public void setPVP(boolean pvp) {
/*  786 */     this.world.pvpMode = pvp;
/*      */   }
/*      */   
/*      */   public void playEffect(Player player, Effect effect, int data) {
/*  790 */     playEffect(player.getLocation(), effect, data, 0);
/*      */   }
/*      */   
/*      */   public void playEffect(Location location, Effect effect, int data) {
/*  794 */     playEffect(location, effect, data, 64);
/*      */   }
/*      */   
/*      */   public <T> void playEffect(Location loc, Effect effect, T data) {
/*  798 */     playEffect(loc, effect, data, 64);
/*      */   }
/*      */   
/*      */   public <T> void playEffect(Location loc, Effect effect, T data, int radius) {
/*  802 */     if (data != null) {
/*  803 */       Validate.isTrue(data.getClass().equals(effect.getData()), "Wrong kind of data for this effect!");
/*      */     } else {
/*  805 */       Validate.isTrue((effect.getData() == null), "Wrong kind of data for this effect!");
/*      */     } 
/*      */     
/*  808 */     int datavalue = (data == null) ? 0 : CraftEffect.<T>getDataValue(effect, data);
/*  809 */     playEffect(loc, effect, datavalue, radius);
/*      */   }
/*      */   
/*      */   public void playEffect(Location location, Effect effect, int data, int radius) {
/*  813 */     Validate.notNull(location, "Location cannot be null");
/*  814 */     Validate.notNull(effect, "Effect cannot be null");
/*  815 */     Validate.notNull(location.getWorld(), "World cannot be null");
/*  816 */     int packetData = effect.getId();
/*  817 */     PacketPlayOutWorldEvent packet = new PacketPlayOutWorldEvent(packetData, location.getBlockX(), location.getBlockY(), location.getBlockZ(), data, false);
/*      */     
/*  819 */     radius *= radius;
/*      */     
/*  821 */     for (Player player : getPlayers()) {
/*  822 */       if ((((CraftPlayer)player).getHandle()).playerConnection == null || 
/*  823 */         !location.getWorld().equals(player.getWorld()))
/*      */         continue; 
/*  825 */       int distance = (int)player.getLocation().distanceSquared(location);
/*  826 */       if (distance <= radius) {
/*  827 */         (((CraftPlayer)player).getHandle()).playerConnection.sendPacket((Packet)packet);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public <T extends Entity> T spawn(Location location, Class<T> clazz) throws IllegalArgumentException {
/*  833 */     return spawn(location, clazz, CreatureSpawnEvent.SpawnReason.CUSTOM);
/*      */   }
/*      */   
/*      */   public FallingBlock spawnFallingBlock(Location location, Material material, byte data) throws IllegalArgumentException {
/*  837 */     Validate.notNull(location, "Location cannot be null");
/*  838 */     Validate.notNull(material, "Material cannot be null");
/*  839 */     Validate.isTrue(material.isBlock(), "Material must be a block");
/*      */     
/*  841 */     double x = location.getBlockX() + 0.5D;
/*  842 */     double y = location.getBlockY() + 0.5D;
/*  843 */     double z = location.getBlockZ() + 0.5D;
/*      */     
/*  845 */     EntityFallingBlock entity = new EntityFallingBlock((World)this.world, x, y, z, Block.getById(material.getId()), data);
/*  846 */     entity.ticksLived = 1;
/*      */     
/*  848 */     this.world.addEntity((Entity)entity, CreatureSpawnEvent.SpawnReason.CUSTOM);
/*  849 */     return (FallingBlock)entity.getBukkitEntity();
/*      */   }
/*      */   
/*      */   public FallingBlock spawnFallingBlock(Location location, int blockId, byte blockData) throws IllegalArgumentException {
/*  853 */     return spawnFallingBlock(location, Material.getMaterial(blockId), blockData);
/*      */   }
/*      */   
/*      */   public <T extends Entity> T spawn(Location location, Class<T> clazz, CreatureSpawnEvent.SpawnReason reason) throws IllegalArgumentException {
/*      */     EntityFireworks entityFireworks;
/*  858 */     if (location == null || clazz == null) {
/*  859 */       throw new IllegalArgumentException("Location or entity class cannot be null");
/*      */     }
/*      */     
/*  862 */     Entity entity = null;
/*      */     
/*  864 */     double x = location.getX();
/*  865 */     double y = location.getY();
/*  866 */     double z = location.getZ();
/*  867 */     float pitch = location.getPitch();
/*  868 */     float yaw = location.getYaw();
/*      */ 
/*      */     
/*  871 */     if (Boat.class.isAssignableFrom(clazz)) {
/*  872 */       EntityBoat entityBoat = new EntityBoat((World)this.world, x, y, z);
/*  873 */     } else if (FallingBlock.class.isAssignableFrom(clazz)) {
/*  874 */       x = location.getBlockX();
/*  875 */       y = location.getBlockY();
/*  876 */       z = location.getBlockZ();
/*  877 */       int type = this.world.getTypeId((int)x, (int)y, (int)z);
/*  878 */       int data = this.world.getData((int)x, (int)y, (int)z);
/*      */       
/*  880 */       EntityFallingBlock entityFallingBlock = new EntityFallingBlock((World)this.world, x + 0.5D, y + 0.5D, z + 0.5D, Block.getById(type), data);
/*  881 */     } else if (Projectile.class.isAssignableFrom(clazz)) {
/*  882 */       if (Snowball.class.isAssignableFrom(clazz)) {
/*  883 */         EntitySnowball entitySnowball = new EntitySnowball((World)this.world, x, y, z);
/*  884 */       } else if (Egg.class.isAssignableFrom(clazz)) {
/*  885 */         EntityEgg entityEgg = new EntityEgg((World)this.world, x, y, z);
/*  886 */       } else if (Arrow.class.isAssignableFrom(clazz)) {
/*  887 */         EntityArrow entityArrow = new EntityArrow((World)this.world);
/*  888 */         entityArrow.setPositionRotation(x, y, z, 0.0F, 0.0F);
/*  889 */       } else if (ThrownExpBottle.class.isAssignableFrom(clazz)) {
/*  890 */         EntityThrownExpBottle entityThrownExpBottle = new EntityThrownExpBottle((World)this.world);
/*  891 */         entityThrownExpBottle.setPositionRotation(x, y, z, 0.0F, 0.0F);
/*  892 */       } else if (EnderPearl.class.isAssignableFrom(clazz)) {
/*  893 */         EntityEnderPearl entityEnderPearl = new EntityEnderPearl((World)this.world);
/*  894 */         entityEnderPearl.setPositionRotation(x, y, z, 0.0F, 0.0F);
/*  895 */       } else if (ThrownPotion.class.isAssignableFrom(clazz)) {
/*  896 */         EntityPotion entityPotion = new EntityPotion((World)this.world, x, y, z, CraftItemStack.asNMSCopy(new ItemStack(Material.POTION, 1)));
/*  897 */       } else if (Fireball.class.isAssignableFrom(clazz)) {
/*  898 */         EntityLargeFireball entityLargeFireball; if (SmallFireball.class.isAssignableFrom(clazz)) {
/*  899 */           EntitySmallFireball entitySmallFireball = new EntitySmallFireball((World)this.world);
/*  900 */         } else if (WitherSkull.class.isAssignableFrom(clazz)) {
/*  901 */           EntityWitherSkull entityWitherSkull = new EntityWitherSkull((World)this.world);
/*      */         } else {
/*  903 */           entityLargeFireball = new EntityLargeFireball((World)this.world);
/*      */         } 
/*  905 */         entityLargeFireball.setPositionRotation(x, y, z, yaw, pitch);
/*  906 */         Vector direction = location.getDirection().multiply(10);
/*  907 */         ((EntityFireball)entityLargeFireball).setDirection(direction.getX(), direction.getY(), direction.getZ());
/*      */       } 
/*  909 */     } else if (Minecart.class.isAssignableFrom(clazz)) {
/*  910 */       if (PoweredMinecart.class.isAssignableFrom(clazz)) {
/*  911 */         EntityMinecartFurnace entityMinecartFurnace = new EntityMinecartFurnace((World)this.world, x, y, z);
/*  912 */       } else if (StorageMinecart.class.isAssignableFrom(clazz)) {
/*  913 */         EntityMinecartChest entityMinecartChest = new EntityMinecartChest((World)this.world, x, y, z);
/*  914 */       } else if (ExplosiveMinecart.class.isAssignableFrom(clazz)) {
/*  915 */         EntityMinecartTNT entityMinecartTNT = new EntityMinecartTNT((World)this.world, x, y, z);
/*  916 */       } else if (HopperMinecart.class.isAssignableFrom(clazz)) {
/*  917 */         EntityMinecartHopper entityMinecartHopper = new EntityMinecartHopper((World)this.world, x, y, z);
/*  918 */       } else if (SpawnerMinecart.class.isAssignableFrom(clazz)) {
/*  919 */         EntityMinecartMobSpawner entityMinecartMobSpawner = new EntityMinecartMobSpawner((World)this.world, x, y, z);
/*      */       } else {
/*  921 */         EntityMinecartRideable entityMinecartRideable = new EntityMinecartRideable((World)this.world, x, y, z);
/*      */       } 
/*  923 */     } else if (EnderSignal.class.isAssignableFrom(clazz)) {
/*  924 */       EntityEnderSignal entityEnderSignal = new EntityEnderSignal((World)this.world, x, y, z);
/*  925 */     } else if (EnderCrystal.class.isAssignableFrom(clazz)) {
/*  926 */       EntityEnderCrystal entityEnderCrystal = new EntityEnderCrystal((World)this.world);
/*  927 */       entityEnderCrystal.setPositionRotation(x, y, z, 0.0F, 0.0F);
/*  928 */     } else if (LivingEntity.class.isAssignableFrom(clazz)) {
/*  929 */       EntityBat entityBat; if (Chicken.class.isAssignableFrom(clazz)) {
/*  930 */         EntityChicken entityChicken = new EntityChicken((World)this.world);
/*  931 */       } else if (Cow.class.isAssignableFrom(clazz)) {
/*  932 */         if (MushroomCow.class.isAssignableFrom(clazz)) {
/*  933 */           EntityMushroomCow entityMushroomCow = new EntityMushroomCow((World)this.world);
/*      */         } else {
/*  935 */           EntityCow entityCow = new EntityCow((World)this.world);
/*      */         } 
/*  937 */       } else if (Golem.class.isAssignableFrom(clazz)) {
/*  938 */         if (Snowman.class.isAssignableFrom(clazz)) {
/*  939 */           EntitySnowman entitySnowman = new EntitySnowman((World)this.world);
/*  940 */         } else if (IronGolem.class.isAssignableFrom(clazz)) {
/*  941 */           EntityIronGolem entityIronGolem = new EntityIronGolem((World)this.world);
/*      */         } 
/*  943 */       } else if (Creeper.class.isAssignableFrom(clazz)) {
/*  944 */         EntityCreeper entityCreeper = new EntityCreeper((World)this.world);
/*  945 */       } else if (Ghast.class.isAssignableFrom(clazz)) {
/*  946 */         EntityGhast entityGhast = new EntityGhast((World)this.world);
/*  947 */       } else if (Pig.class.isAssignableFrom(clazz)) {
/*  948 */         EntityPig entityPig = new EntityPig((World)this.world);
/*  949 */       } else if (!Player.class.isAssignableFrom(clazz)) {
/*      */         
/*  951 */         if (Sheep.class.isAssignableFrom(clazz)) {
/*  952 */           EntitySheep entitySheep = new EntitySheep((World)this.world);
/*  953 */         } else if (Horse.class.isAssignableFrom(clazz)) {
/*  954 */           EntityHorse entityHorse = new EntityHorse((World)this.world);
/*  955 */         } else if (Skeleton.class.isAssignableFrom(clazz)) {
/*  956 */           EntitySkeleton entitySkeleton = new EntitySkeleton((World)this.world);
/*  957 */         } else if (Slime.class.isAssignableFrom(clazz)) {
/*  958 */           if (MagmaCube.class.isAssignableFrom(clazz)) {
/*  959 */             EntityMagmaCube entityMagmaCube = new EntityMagmaCube((World)this.world);
/*      */           } else {
/*  961 */             EntitySlime entitySlime = new EntitySlime((World)this.world);
/*      */           } 
/*  963 */         } else if (Spider.class.isAssignableFrom(clazz)) {
/*  964 */           if (CaveSpider.class.isAssignableFrom(clazz)) {
/*  965 */             EntityCaveSpider entityCaveSpider = new EntityCaveSpider((World)this.world);
/*      */           } else {
/*  967 */             EntitySpider entitySpider = new EntitySpider((World)this.world);
/*      */           } 
/*  969 */         } else if (Squid.class.isAssignableFrom(clazz)) {
/*  970 */           EntitySquid entitySquid = new EntitySquid((World)this.world);
/*  971 */         } else if (Tameable.class.isAssignableFrom(clazz)) {
/*  972 */           if (Wolf.class.isAssignableFrom(clazz)) {
/*  973 */             EntityWolf entityWolf = new EntityWolf((World)this.world);
/*  974 */           } else if (Ocelot.class.isAssignableFrom(clazz)) {
/*  975 */             EntityOcelot entityOcelot = new EntityOcelot((World)this.world);
/*      */           } 
/*  977 */         } else if (PigZombie.class.isAssignableFrom(clazz)) {
/*  978 */           EntityPigZombie entityPigZombie = new EntityPigZombie((World)this.world);
/*  979 */         } else if (Zombie.class.isAssignableFrom(clazz)) {
/*  980 */           EntityZombie entityZombie = new EntityZombie((World)this.world);
/*  981 */         } else if (Giant.class.isAssignableFrom(clazz)) {
/*  982 */           EntityGiantZombie entityGiantZombie = new EntityGiantZombie((World)this.world);
/*  983 */         } else if (Silverfish.class.isAssignableFrom(clazz)) {
/*  984 */           EntitySilverfish entitySilverfish = new EntitySilverfish((World)this.world);
/*  985 */         } else if (Enderman.class.isAssignableFrom(clazz)) {
/*  986 */           EntityEnderman entityEnderman = new EntityEnderman((World)this.world);
/*  987 */         } else if (Blaze.class.isAssignableFrom(clazz)) {
/*  988 */           EntityBlaze entityBlaze = new EntityBlaze((World)this.world);
/*  989 */         } else if (Villager.class.isAssignableFrom(clazz)) {
/*  990 */           EntityVillager entityVillager = new EntityVillager((World)this.world);
/*  991 */         } else if (Witch.class.isAssignableFrom(clazz)) {
/*  992 */           EntityWitch entityWitch = new EntityWitch((World)this.world);
/*  993 */         } else if (Wither.class.isAssignableFrom(clazz)) {
/*  994 */           EntityWither entityWither = new EntityWither((World)this.world);
/*  995 */         } else if (ComplexLivingEntity.class.isAssignableFrom(clazz)) {
/*  996 */           if (EnderDragon.class.isAssignableFrom(clazz)) {
/*  997 */             EntityEnderDragon entityEnderDragon = new EntityEnderDragon((World)this.world);
/*      */           }
/*  999 */         } else if (Ambient.class.isAssignableFrom(clazz) && 
/* 1000 */           Bat.class.isAssignableFrom(clazz)) {
/* 1001 */           entityBat = new EntityBat((World)this.world);
/*      */         } 
/*      */       } 
/*      */       
/* 1005 */       if (entityBat != null) {
/* 1006 */         entityBat.setLocation(x, y, z, yaw, pitch);
/*      */       }
/* 1008 */     } else if (Hanging.class.isAssignableFrom(clazz)) {
/* 1009 */       EntityLeash entityLeash; int dir; Block block = getBlockAt(location);
/* 1010 */       BlockFace face = BlockFace.SELF;
/* 1011 */       if (block.getRelative(BlockFace.EAST).getTypeId() == 0) {
/* 1012 */         face = BlockFace.EAST;
/* 1013 */       } else if (block.getRelative(BlockFace.NORTH).getTypeId() == 0) {
/* 1014 */         face = BlockFace.NORTH;
/* 1015 */       } else if (block.getRelative(BlockFace.WEST).getTypeId() == 0) {
/* 1016 */         face = BlockFace.WEST;
/* 1017 */       } else if (block.getRelative(BlockFace.SOUTH).getTypeId() == 0) {
/* 1018 */         face = BlockFace.SOUTH;
/*      */       } 
/*      */       
/* 1021 */       switch (face) {
/*      */         
/*      */         default:
/* 1024 */           dir = 0;
/*      */           break;
/*      */         case WEST:
/* 1027 */           dir = 1;
/*      */           break;
/*      */         case NORTH:
/* 1030 */           dir = 2;
/*      */           break;
/*      */         case EAST:
/* 1033 */           dir = 3;
/*      */           break;
/*      */       } 
/*      */       
/* 1037 */       if (Painting.class.isAssignableFrom(clazz)) {
/* 1038 */         EntityPainting entityPainting = new EntityPainting((World)this.world, (int)x, (int)y, (int)z, dir);
/* 1039 */       } else if (ItemFrame.class.isAssignableFrom(clazz)) {
/* 1040 */         EntityItemFrame entityItemFrame = new EntityItemFrame((World)this.world, (int)x, (int)y, (int)z, dir);
/* 1041 */       } else if (LeashHitch.class.isAssignableFrom(clazz)) {
/* 1042 */         entityLeash = new EntityLeash((World)this.world, (int)x, (int)y, (int)z);
/* 1043 */         ((Entity)entityLeash).attachedToPlayer = true;
/*      */       } 
/*      */       
/* 1046 */       if (entityLeash != null && !((EntityHanging)entityLeash).survives()) {
/* 1047 */         throw new IllegalArgumentException("Cannot spawn hanging entity for " + clazz.getName() + " at " + location);
/*      */       }
/* 1049 */     } else if (TNTPrimed.class.isAssignableFrom(clazz)) {
/* 1050 */       EntityTNTPrimed entityTNTPrimed = new EntityTNTPrimed((World)this.world, x, y, z, null);
/* 1051 */     } else if (ExperienceOrb.class.isAssignableFrom(clazz)) {
/* 1052 */       EntityExperienceOrb entityExperienceOrb = new EntityExperienceOrb((World)this.world, x, y, z, 0);
/* 1053 */     } else if (Weather.class.isAssignableFrom(clazz)) {
/*      */       
/* 1055 */       if (LightningStrike.class.isAssignableFrom(clazz)) {
/* 1056 */         EntityLightning entityLightning = new EntityLightning((World)this.world, x, y, z);
/*      */       }
/*      */     }
/* 1059 */     else if (Firework.class.isAssignableFrom(clazz)) {
/* 1060 */       entityFireworks = new EntityFireworks((World)this.world, x, y, z, null);
/*      */     } 
/*      */     
/* 1063 */     if (entityFireworks != null) {
/* 1064 */       if (entityFireworks instanceof EntityInsentient) {
/* 1065 */         ((EntityInsentient)entityFireworks).prepare((GroupDataEntity)null);
/*      */       }
/*      */       
/* 1068 */       this.world.addEntity((Entity)entityFireworks, reason);
/* 1069 */       return (T)entityFireworks.getBukkitEntity();
/*      */     } 
/*      */     
/* 1072 */     throw new IllegalArgumentException("Cannot spawn an entity for " + clazz.getName());
/*      */   }
/*      */   
/*      */   public ChunkSnapshot getEmptyChunkSnapshot(int x, int z, boolean includeBiome, boolean includeBiomeTempRain) {
/* 1076 */     return CraftChunk.getEmptyChunkSnapshot(x, z, this, includeBiome, includeBiomeTempRain);
/*      */   }
/*      */   
/*      */   public void setSpawnFlags(boolean allowMonsters, boolean allowAnimals) {
/* 1080 */     this.world.setSpawnFlags(allowMonsters, allowAnimals);
/*      */   }
/*      */   
/*      */   public boolean getAllowAnimals() {
/* 1084 */     return this.world.allowAnimals;
/*      */   }
/*      */   
/*      */   public boolean getAllowMonsters() {
/* 1088 */     return this.world.allowMonsters;
/*      */   }
/*      */   
/*      */   public int getMaxHeight() {
/* 1092 */     return this.world.getHeight();
/*      */   }
/*      */   
/*      */   public int getSeaLevel() {
/* 1096 */     return 64;
/*      */   }
/*      */   
/*      */   public boolean getKeepSpawnInMemory() {
/* 1100 */     return this.world.keepSpawnInMemory;
/*      */   }
/*      */   
/*      */   public void setKeepSpawnInMemory(boolean keepLoaded) {
/* 1104 */     this.world.keepSpawnInMemory = keepLoaded;
/*      */     
/* 1106 */     ChunkCoordinates chunkcoordinates = this.world.getSpawn();
/* 1107 */     int chunkCoordX = chunkcoordinates.x >> 4;
/* 1108 */     int chunkCoordZ = chunkcoordinates.z >> 4;
/*      */     
/* 1110 */     for (int x = -12; x <= 12; x++) {
/* 1111 */       for (int z = -12; z <= 12; z++) {
/* 1112 */         if (keepLoaded) {
/* 1113 */           loadChunk(chunkCoordX + x, chunkCoordZ + z);
/*      */         }
/* 1115 */         else if (isChunkLoaded(chunkCoordX + x, chunkCoordZ + z)) {
/* 1116 */           if (getHandle().getChunkAt(chunkCoordX + x, chunkCoordZ + z) instanceof net.minecraft.server.v1_7_R4.EmptyChunk) {
/* 1117 */             unloadChunk(chunkCoordX + x, chunkCoordZ + z, false);
/*      */           } else {
/* 1119 */             unloadChunk(chunkCoordX + x, chunkCoordZ + z);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 1129 */     return getUID().hashCode();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean equals(Object obj) {
/* 1134 */     if (obj == null) {
/* 1135 */       return false;
/*      */     }
/* 1137 */     if (getClass() != obj.getClass()) {
/* 1138 */       return false;
/*      */     }
/*      */     
/* 1141 */     CraftWorld other = (CraftWorld)obj;
/*      */     
/* 1143 */     return (getUID() == other.getUID());
/*      */   }
/*      */   
/*      */   public File getWorldFolder() {
/* 1147 */     return ((WorldNBTStorage)this.world.getDataManager()).getDirectory();
/*      */   }
/*      */   
/*      */   public void sendPluginMessage(Plugin source, String channel, byte[] message) {
/* 1151 */     StandardMessenger.validatePluginMessage(this.server.getMessenger(), source, channel, message);
/*      */     
/* 1153 */     for (Player player : getPlayers()) {
/* 1154 */       player.sendPluginMessage(source, channel, message);
/*      */     }
/*      */   }
/*      */   
/*      */   public Set<String> getListeningPluginChannels() {
/* 1159 */     Set<String> result = new HashSet<String>();
/*      */     
/* 1161 */     for (Player player : getPlayers()) {
/* 1162 */       result.addAll(player.getListeningPluginChannels());
/*      */     }
/*      */     
/* 1165 */     return result;
/*      */   }
/*      */   
/*      */   public WorldType getWorldType() {
/* 1169 */     return WorldType.getByName(this.world.getWorldData().getType().name());
/*      */   }
/*      */   
/*      */   public boolean canGenerateStructures() {
/* 1173 */     return this.world.getWorldData().shouldGenerateMapFeatures();
/*      */   }
/*      */   
/*      */   public long getTicksPerAnimalSpawns() {
/* 1177 */     return this.world.ticksPerAnimalSpawns;
/*      */   }
/*      */   
/*      */   public void setTicksPerAnimalSpawns(int ticksPerAnimalSpawns) {
/* 1181 */     this.world.ticksPerAnimalSpawns = ticksPerAnimalSpawns;
/*      */   }
/*      */   
/*      */   public long getTicksPerMonsterSpawns() {
/* 1185 */     return this.world.ticksPerMonsterSpawns;
/*      */   }
/*      */   
/*      */   public void setTicksPerMonsterSpawns(int ticksPerMonsterSpawns) {
/* 1189 */     this.world.ticksPerMonsterSpawns = ticksPerMonsterSpawns;
/*      */   }
/*      */   
/*      */   public void setMetadata(String metadataKey, MetadataValue newMetadataValue) {
/* 1193 */     this.server.getWorldMetadata().setMetadata(this, metadataKey, newMetadataValue);
/*      */   }
/*      */   
/*      */   public List<MetadataValue> getMetadata(String metadataKey) {
/* 1197 */     return this.server.getWorldMetadata().getMetadata(this, metadataKey);
/*      */   }
/*      */   
/*      */   public boolean hasMetadata(String metadataKey) {
/* 1201 */     return this.server.getWorldMetadata().hasMetadata(this, metadataKey);
/*      */   }
/*      */   
/*      */   public void removeMetadata(String metadataKey, Plugin owningPlugin) {
/* 1205 */     this.server.getWorldMetadata().removeMetadata(this, metadataKey, owningPlugin);
/*      */   }
/*      */   
/*      */   public int getMonsterSpawnLimit() {
/* 1209 */     if (this.monsterSpawn < 0) {
/* 1210 */       return this.server.getMonsterSpawnLimit();
/*      */     }
/*      */     
/* 1213 */     return this.monsterSpawn;
/*      */   }
/*      */   
/*      */   public void setMonsterSpawnLimit(int limit) {
/* 1217 */     this.monsterSpawn = limit;
/*      */   }
/*      */   
/*      */   public int getAnimalSpawnLimit() {
/* 1221 */     if (this.animalSpawn < 0) {
/* 1222 */       return this.server.getAnimalSpawnLimit();
/*      */     }
/*      */     
/* 1225 */     return this.animalSpawn;
/*      */   }
/*      */   
/*      */   public void setAnimalSpawnLimit(int limit) {
/* 1229 */     this.animalSpawn = limit;
/*      */   }
/*      */   
/*      */   public int getWaterAnimalSpawnLimit() {
/* 1233 */     if (this.waterAnimalSpawn < 0) {
/* 1234 */       return this.server.getWaterAnimalSpawnLimit();
/*      */     }
/*      */     
/* 1237 */     return this.waterAnimalSpawn;
/*      */   }
/*      */   
/*      */   public void setWaterAnimalSpawnLimit(int limit) {
/* 1241 */     this.waterAnimalSpawn = limit;
/*      */   }
/*      */   
/*      */   public int getAmbientSpawnLimit() {
/* 1245 */     if (this.ambientSpawn < 0) {
/* 1246 */       return this.server.getAmbientSpawnLimit();
/*      */     }
/*      */     
/* 1249 */     return this.ambientSpawn;
/*      */   }
/*      */   
/*      */   public void setAmbientSpawnLimit(int limit) {
/* 1253 */     this.ambientSpawn = limit;
/*      */   }
/*      */ 
/*      */   
/*      */   public void playSound(Location loc, Sound sound, float volume, float pitch) {
/* 1258 */     if (loc == null || sound == null)
/*      */       return; 
/* 1260 */     double x = loc.getX();
/* 1261 */     double y = loc.getY();
/* 1262 */     double z = loc.getZ();
/*      */     
/* 1264 */     getHandle().makeSound(x, y, z, CraftSound.getSound(sound), volume, pitch);
/*      */   }
/*      */   
/*      */   public String getGameRuleValue(String rule) {
/* 1268 */     return getHandle().getGameRules().get(rule);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean setGameRuleValue(String rule, String value) {
/* 1273 */     if (rule == null || value == null) return false;
/*      */     
/* 1275 */     if (!isGameRule(rule)) return false;
/*      */     
/* 1277 */     getHandle().getGameRules().set(rule, value);
/* 1278 */     return true;
/*      */   }
/*      */   
/*      */   public String[] getGameRules() {
/* 1282 */     return getHandle().getGameRules().getGameRules();
/*      */   }
/*      */   
/*      */   public boolean isGameRule(String rule) {
/* 1286 */     return getHandle().getGameRules().contains(rule);
/*      */   }
/*      */   
/*      */   public void processChunkGC() {
/* 1290 */     this.chunkGCTickCount++;
/*      */     
/* 1292 */     if (this.chunkLoadCount >= this.server.chunkGCLoadThresh && this.server.chunkGCLoadThresh > 0) {
/* 1293 */       this.chunkLoadCount = 0;
/* 1294 */     } else if (this.chunkGCTickCount >= this.server.chunkGCPeriod && this.server.chunkGCPeriod > 0) {
/* 1295 */       this.chunkGCTickCount = 0;
/*      */     } else {
/*      */       return;
/*      */     } 
/*      */     
/* 1300 */     ChunkProviderServer cps = this.world.chunkProviderServer;
/* 1301 */     for (Chunk chunk : cps.chunks.values()) {
/*      */       
/* 1303 */       if (isChunkInUse(chunk.locX, chunk.locZ)) {
/*      */         continue;
/*      */       }
/*      */ 
/*      */       
/* 1308 */       if (cps.unloadQueue.contains(chunk.locX, chunk.locZ)) {
/*      */         continue;
/*      */       }
/*      */ 
/*      */       
/* 1313 */       cps.queueUnload(chunk.locX, chunk.locZ);
/*      */     } 
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\CraftWorld.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */