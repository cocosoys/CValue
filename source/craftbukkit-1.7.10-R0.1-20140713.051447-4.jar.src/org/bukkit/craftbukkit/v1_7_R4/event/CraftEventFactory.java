/*     */ package org.bukkit.craftbukkit.v1_7_R4.event;
/*     */ import com.google.common.base.Function;
/*     */ import java.util.EnumMap;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.server.v1_7_R4.Block;
/*     */ import net.minecraft.server.v1_7_R4.Container;
/*     */ import net.minecraft.server.v1_7_R4.DamageSource;
/*     */ import net.minecraft.server.v1_7_R4.Entity;
/*     */ import net.minecraft.server.v1_7_R4.EntityHuman;
/*     */ import net.minecraft.server.v1_7_R4.EntityInsentient;
/*     */ import net.minecraft.server.v1_7_R4.EntityLiving;
/*     */ import net.minecraft.server.v1_7_R4.EntityPlayer;
/*     */ import net.minecraft.server.v1_7_R4.Item;
/*     */ import net.minecraft.server.v1_7_R4.ItemStack;
/*     */ import net.minecraft.server.v1_7_R4.Items;
/*     */ import net.minecraft.server.v1_7_R4.Statistic;
/*     */ import net.minecraft.server.v1_7_R4.World;
/*     */ import org.bukkit.Bukkit;
/*     */ import org.bukkit.Material;
/*     */ import org.bukkit.Statistic;
/*     */ import org.bukkit.block.Block;
/*     */ import org.bukkit.block.BlockFace;
/*     */ import org.bukkit.block.BlockState;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.CraftStatistic;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.block.CraftBlockState;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftEntity;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftHumanEntity;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftLivingEntity;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftItemStack;
/*     */ import org.bukkit.entity.Entity;
/*     */ import org.bukkit.entity.EntityType;
/*     */ import org.bukkit.entity.Item;
/*     */ import org.bukkit.entity.LivingEntity;
/*     */ import org.bukkit.entity.Player;
/*     */ import org.bukkit.entity.Projectile;
/*     */ import org.bukkit.event.Event;
/*     */ import org.bukkit.event.block.Action;
/*     */ import org.bukkit.event.block.BlockDamageEvent;
/*     */ import org.bukkit.event.block.BlockFadeEvent;
/*     */ import org.bukkit.event.block.BlockIgniteEvent;
/*     */ import org.bukkit.event.block.BlockMultiPlaceEvent;
/*     */ import org.bukkit.event.block.BlockPlaceEvent;
/*     */ import org.bukkit.event.block.BlockRedstoneEvent;
/*     */ import org.bukkit.event.block.NotePlayEvent;
/*     */ import org.bukkit.event.entity.CreatureSpawnEvent;
/*     */ import org.bukkit.event.entity.CreeperPowerEvent;
/*     */ import org.bukkit.event.entity.EntityBreakDoorEvent;
/*     */ import org.bukkit.event.entity.EntityChangeBlockEvent;
/*     */ import org.bukkit.event.entity.EntityDamageByBlockEvent;
/*     */ import org.bukkit.event.entity.EntityDamageByEntityEvent;
/*     */ import org.bukkit.event.entity.EntityDamageEvent;
/*     */ import org.bukkit.event.entity.EntityDeathEvent;
/*     */ import org.bukkit.event.entity.EntityShootBowEvent;
/*     */ import org.bukkit.event.entity.EntityTameEvent;
/*     */ import org.bukkit.event.entity.EntityTargetEvent;
/*     */ import org.bukkit.event.entity.EntityTargetLivingEntityEvent;
/*     */ import org.bukkit.event.entity.ExpBottleEvent;
/*     */ import org.bukkit.event.entity.FoodLevelChangeEvent;
/*     */ import org.bukkit.event.entity.HorseJumpEvent;
/*     */ import org.bukkit.event.entity.ItemDespawnEvent;
/*     */ import org.bukkit.event.entity.ItemSpawnEvent;
/*     */ import org.bukkit.event.entity.PigZapEvent;
/*     */ import org.bukkit.event.entity.PlayerDeathEvent;
/*     */ import org.bukkit.event.entity.PlayerLeashEntityEvent;
/*     */ import org.bukkit.event.entity.PotionSplashEvent;
/*     */ import org.bukkit.event.entity.ProjectileHitEvent;
/*     */ import org.bukkit.event.entity.ProjectileLaunchEvent;
/*     */ import org.bukkit.event.inventory.PrepareItemCraftEvent;
/*     */ import org.bukkit.event.player.PlayerBucketEmptyEvent;
/*     */ import org.bukkit.event.player.PlayerBucketFillEvent;
/*     */ import org.bukkit.event.player.PlayerEditBookEvent;
/*     */ import org.bukkit.event.player.PlayerExpChangeEvent;
/*     */ import org.bukkit.event.player.PlayerInteractEvent;
/*     */ import org.bukkit.event.player.PlayerLevelChangeEvent;
/*     */ import org.bukkit.event.player.PlayerStatisticIncrementEvent;
/*     */ import org.bukkit.event.player.PlayerUnleashEntityEvent;
/*     */ import org.bukkit.event.server.ServerListPingEvent;
/*     */ import org.bukkit.inventory.ItemStack;
/*     */ 
/*     */ public class CraftEventFactory {
/*  85 */   public static final DamageSource MELTING = CraftDamageSource.copyOf(DamageSource.BURN);
/*  86 */   public static final DamageSource POISON = CraftDamageSource.copyOf(DamageSource.MAGIC);
/*     */   
/*     */   public static Block blockDamage;
/*     */   public static Entity entityDamage;
/*     */   
/*     */   private static boolean canBuild(CraftWorld world, Player player, int x, int z) {
/*  92 */     WorldServer worldServer = world.getHandle();
/*  93 */     int spawnSize = Bukkit.getServer().getSpawnRadius();
/*     */     
/*  95 */     if ((world.getHandle()).dimension != 0) return true; 
/*  96 */     if (spawnSize <= 0) return true; 
/*  97 */     if (((CraftServer)Bukkit.getServer()).getHandle().getOPs().isEmpty()) return true; 
/*  98 */     if (player.isOp()) return true;
/*     */     
/* 100 */     ChunkCoordinates chunkcoordinates = worldServer.getSpawn();
/*     */     
/* 102 */     int distanceFromSpawn = Math.max(Math.abs(x - chunkcoordinates.x), Math.abs(z - chunkcoordinates.z));
/* 103 */     return (distanceFromSpawn > spawnSize);
/*     */   }
/*     */   
/*     */   public static <T extends Event> T callEvent(T event) {
/* 107 */     Bukkit.getServer().getPluginManager().callEvent((Event)event);
/* 108 */     return event;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BlockMultiPlaceEvent callBlockMultiPlaceEvent(World world, EntityHuman who, List<BlockState> blockStates, int clickedX, int clickedY, int clickedZ) {
/* 115 */     CraftWorld craftWorld = world.getWorld();
/* 116 */     CraftServer craftServer = world.getServer();
/* 117 */     Player player = (who == null) ? null : (Player)who.getBukkitEntity();
/*     */     
/* 119 */     Block blockClicked = craftWorld.getBlockAt(clickedX, clickedY, clickedZ);
/*     */     
/* 121 */     boolean canBuild = true;
/* 122 */     for (int i = 0; i < blockStates.size(); i++) {
/* 123 */       if (!canBuild(craftWorld, player, ((BlockState)blockStates.get(i)).getX(), ((BlockState)blockStates.get(i)).getZ())) {
/* 124 */         canBuild = false;
/*     */         
/*     */         break;
/*     */       } 
/*     */     } 
/* 129 */     BlockMultiPlaceEvent event = new BlockMultiPlaceEvent(blockStates, blockClicked, player.getItemInHand(), player, canBuild);
/* 130 */     craftServer.getPluginManager().callEvent((Event)event);
/*     */     
/* 132 */     return event;
/*     */   }
/*     */   
/*     */   public static BlockPlaceEvent callBlockPlaceEvent(World world, EntityHuman who, BlockState replacedBlockState, int clickedX, int clickedY, int clickedZ) {
/* 136 */     CraftWorld craftWorld = world.getWorld();
/* 137 */     CraftServer craftServer = world.getServer();
/*     */     
/* 139 */     Player player = (who == null) ? null : (Player)who.getBukkitEntity();
/*     */     
/* 141 */     Block blockClicked = craftWorld.getBlockAt(clickedX, clickedY, clickedZ);
/* 142 */     Block placedBlock = replacedBlockState.getBlock();
/*     */     
/* 144 */     boolean canBuild = canBuild(craftWorld, player, placedBlock.getX(), placedBlock.getZ());
/*     */     
/* 146 */     BlockPlaceEvent event = new BlockPlaceEvent(placedBlock, replacedBlockState, blockClicked, player.getItemInHand(), player, canBuild);
/* 147 */     craftServer.getPluginManager().callEvent((Event)event);
/*     */     
/* 149 */     return event;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PlayerBucketEmptyEvent callPlayerBucketEmptyEvent(EntityHuman who, int clickedX, int clickedY, int clickedZ, int clickedFace, ItemStack itemInHand) {
/* 156 */     return (PlayerBucketEmptyEvent)getPlayerBucketEvent(false, who, clickedX, clickedY, clickedZ, clickedFace, itemInHand, Items.BUCKET);
/*     */   }
/*     */   
/*     */   public static PlayerBucketFillEvent callPlayerBucketFillEvent(EntityHuman who, int clickedX, int clickedY, int clickedZ, int clickedFace, ItemStack itemInHand, Item bucket) {
/* 160 */     return (PlayerBucketFillEvent)getPlayerBucketEvent(true, who, clickedX, clickedY, clickedZ, clickedFace, itemInHand, bucket);
/*     */   }
/*     */   private static PlayerEvent getPlayerBucketEvent(boolean isFilling, EntityHuman who, int clickedX, int clickedY, int clickedZ, int clickedFace, ItemStack itemstack, Item item) {
/*     */     PlayerBucketEmptyEvent playerBucketEmptyEvent;
/* 164 */     Player player = (who == null) ? null : (Player)who.getBukkitEntity();
/* 165 */     CraftItemStack itemInHand = CraftItemStack.asNewCraftStack(item);
/* 166 */     Material bucket = CraftMagicNumbers.getMaterial(itemstack.getItem());
/*     */     
/* 168 */     CraftWorld craftWorld = (CraftWorld)player.getWorld();
/* 169 */     CraftServer craftServer = (CraftServer)player.getServer();
/*     */     
/* 171 */     Block blockClicked = craftWorld.getBlockAt(clickedX, clickedY, clickedZ);
/* 172 */     BlockFace blockFace = CraftBlock.notchToBlockFace(clickedFace);
/*     */     
/* 174 */     PlayerEvent event = null;
/* 175 */     if (isFilling) {
/* 176 */       PlayerBucketFillEvent playerBucketFillEvent = new PlayerBucketFillEvent(player, blockClicked, blockFace, bucket, (ItemStack)itemInHand);
/* 177 */       playerBucketFillEvent.setCancelled(!canBuild(craftWorld, player, clickedX, clickedZ));
/*     */     } else {
/* 179 */       playerBucketEmptyEvent = new PlayerBucketEmptyEvent(player, blockClicked, blockFace, bucket, (ItemStack)itemInHand);
/* 180 */       playerBucketEmptyEvent.setCancelled(!canBuild(craftWorld, player, clickedX, clickedZ));
/*     */     } 
/*     */     
/* 183 */     craftServer.getPluginManager().callEvent((Event)playerBucketEmptyEvent);
/*     */     
/* 185 */     return (PlayerEvent)playerBucketEmptyEvent;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PlayerInteractEvent callPlayerInteractEvent(EntityHuman who, Action action, ItemStack itemstack) {
/* 192 */     if (action != Action.LEFT_CLICK_AIR && action != Action.RIGHT_CLICK_AIR) {
/* 193 */       throw new IllegalArgumentException();
/*     */     }
/* 195 */     return callPlayerInteractEvent(who, action, 0, 256, 0, 0, itemstack);
/*     */   }
/*     */   
/*     */   public static PlayerInteractEvent callPlayerInteractEvent(EntityHuman who, Action action, int clickedX, int clickedY, int clickedZ, int clickedFace, ItemStack itemstack) {
/* 199 */     Player player = (who == null) ? null : (Player)who.getBukkitEntity();
/* 200 */     CraftItemStack itemInHand = CraftItemStack.asCraftMirror(itemstack);
/*     */     
/* 202 */     CraftWorld craftWorld = (CraftWorld)player.getWorld();
/* 203 */     CraftServer craftServer = (CraftServer)player.getServer();
/*     */     
/* 205 */     Block blockClicked = craftWorld.getBlockAt(clickedX, clickedY, clickedZ);
/* 206 */     BlockFace blockFace = CraftBlock.notchToBlockFace(clickedFace);
/*     */     
/* 208 */     if (clickedY > 255) {
/* 209 */       blockClicked = null;
/* 210 */       switch (action) {
/*     */         case FALL_ONE_CM:
/* 212 */           action = Action.LEFT_CLICK_AIR;
/*     */           break;
/*     */         case BOAT_ONE_CM:
/* 215 */           action = Action.RIGHT_CLICK_AIR;
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/* 220 */     if (itemInHand.getType() == Material.AIR || itemInHand.getAmount() == 0) {
/* 221 */       itemInHand = null;
/*     */     }
/*     */     
/* 224 */     PlayerInteractEvent event = new PlayerInteractEvent(player, action, (ItemStack)itemInHand, blockClicked, blockFace);
/* 225 */     craftServer.getPluginManager().callEvent((Event)event);
/*     */     
/* 227 */     return event;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EntityShootBowEvent callEntityShootBowEvent(EntityLiving who, ItemStack itemstack, EntityArrow entityArrow, float force) {
/* 234 */     LivingEntity shooter = (LivingEntity)who.getBukkitEntity();
/* 235 */     CraftItemStack itemInHand = CraftItemStack.asCraftMirror(itemstack);
/* 236 */     Arrow arrow = (Arrow)entityArrow.getBukkitEntity();
/*     */     
/* 238 */     if (itemInHand != null && (itemInHand.getType() == Material.AIR || itemInHand.getAmount() == 0)) {
/* 239 */       itemInHand = null;
/*     */     }
/*     */     
/* 242 */     EntityShootBowEvent event = new EntityShootBowEvent(shooter, (ItemStack)itemInHand, (Projectile)arrow, force);
/* 243 */     Bukkit.getPluginManager().callEvent((Event)event);
/*     */     
/* 245 */     return event;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BlockDamageEvent callBlockDamageEvent(EntityHuman who, int x, int y, int z, ItemStack itemstack, boolean instaBreak) {
/* 252 */     Player player = (who == null) ? null : (Player)who.getBukkitEntity();
/* 253 */     CraftItemStack itemInHand = CraftItemStack.asCraftMirror(itemstack);
/*     */     
/* 255 */     CraftWorld craftWorld = (CraftWorld)player.getWorld();
/* 256 */     CraftServer craftServer = (CraftServer)player.getServer();
/*     */     
/* 258 */     Block blockClicked = craftWorld.getBlockAt(x, y, z);
/*     */     
/* 260 */     BlockDamageEvent event = new BlockDamageEvent(player, blockClicked, (ItemStack)itemInHand, instaBreak);
/* 261 */     craftServer.getPluginManager().callEvent((Event)event);
/*     */     
/* 263 */     return event;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static CreatureSpawnEvent callCreatureSpawnEvent(EntityLiving entityliving, CreatureSpawnEvent.SpawnReason spawnReason) {
/* 270 */     LivingEntity entity = (LivingEntity)entityliving.getBukkitEntity();
/* 271 */     CraftServer craftServer = (CraftServer)entity.getServer();
/*     */     
/* 273 */     CreatureSpawnEvent event = new CreatureSpawnEvent(entity, spawnReason);
/* 274 */     craftServer.getPluginManager().callEvent((Event)event);
/* 275 */     return event;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static EntityTameEvent callEntityTameEvent(EntityInsentient entity, EntityHuman tamer) {
/* 282 */     CraftEntity craftEntity = entity.getBukkitEntity();
/* 283 */     CraftHumanEntity craftHumanEntity = (tamer != null) ? tamer.getBukkitEntity() : null;
/* 284 */     CraftServer craftServer = (CraftServer)craftEntity.getServer();
/*     */     
/* 286 */     entity.persistent = true;
/*     */     
/* 288 */     EntityTameEvent event = new EntityTameEvent((LivingEntity)craftEntity, (AnimalTamer)craftHumanEntity);
/* 289 */     craftServer.getPluginManager().callEvent((Event)event);
/* 290 */     return event;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ItemSpawnEvent callItemSpawnEvent(EntityItem entityitem) {
/* 297 */     Item entity = (Item)entityitem.getBukkitEntity();
/* 298 */     CraftServer craftServer = (CraftServer)entity.getServer();
/*     */     
/* 300 */     ItemSpawnEvent event = new ItemSpawnEvent(entity, entity.getLocation());
/*     */     
/* 302 */     craftServer.getPluginManager().callEvent((Event)event);
/* 303 */     return event;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ItemDespawnEvent callItemDespawnEvent(EntityItem entityitem) {
/* 310 */     Item entity = (Item)entityitem.getBukkitEntity();
/*     */     
/* 312 */     ItemDespawnEvent event = new ItemDespawnEvent(entity, entity.getLocation());
/*     */     
/* 314 */     entity.getServer().getPluginManager().callEvent((Event)event);
/* 315 */     return event;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static PotionSplashEvent callPotionSplashEvent(EntityPotion potion, Map<LivingEntity, Double> affectedEntities) {
/* 322 */     ThrownPotion thrownPotion = (ThrownPotion)potion.getBukkitEntity();
/*     */     
/* 324 */     PotionSplashEvent event = new PotionSplashEvent(thrownPotion, affectedEntities);
/* 325 */     Bukkit.getPluginManager().callEvent((Event)event);
/* 326 */     return event;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BlockFadeEvent callBlockFadeEvent(Block block, Block type) {
/* 333 */     BlockState state = block.getState();
/* 334 */     state.setTypeId(Block.getId(type));
/*     */     
/* 336 */     BlockFadeEvent event = new BlockFadeEvent(block, state);
/* 337 */     Bukkit.getPluginManager().callEvent((Event)event);
/* 338 */     return event;
/*     */   }
/*     */   
/*     */   public static void handleBlockSpreadEvent(Block block, Block source, Block type, int data) {
/* 342 */     BlockState state = block.getState();
/* 343 */     state.setTypeId(Block.getId(type));
/* 344 */     state.setRawData((byte)data);
/*     */     
/* 346 */     BlockSpreadEvent event = new BlockSpreadEvent(block, source, state);
/* 347 */     Bukkit.getPluginManager().callEvent((Event)event);
/*     */     
/* 349 */     if (!event.isCancelled()) {
/* 350 */       state.update(true);
/*     */     }
/*     */   }
/*     */   
/*     */   public static EntityDeathEvent callEntityDeathEvent(EntityLiving victim) {
/* 355 */     return callEntityDeathEvent(victim, new ArrayList<ItemStack>(0));
/*     */   }
/*     */   
/*     */   public static EntityDeathEvent callEntityDeathEvent(EntityLiving victim, List<ItemStack> drops) {
/* 359 */     CraftLivingEntity entity = (CraftLivingEntity)victim.getBukkitEntity();
/* 360 */     EntityDeathEvent event = new EntityDeathEvent((LivingEntity)entity, drops, victim.getExpReward());
/* 361 */     CraftWorld world = (CraftWorld)entity.getWorld();
/* 362 */     Bukkit.getServer().getPluginManager().callEvent((Event)event);
/*     */     
/* 364 */     victim.expToDrop = event.getDroppedExp();
/*     */     
/* 366 */     for (ItemStack stack : event.getDrops()) {
/* 367 */       if (stack == null || stack.getType() == Material.AIR || stack.getAmount() == 0)
/*     */         continue; 
/* 369 */       world.dropItemNaturally(entity.getLocation(), stack);
/*     */     } 
/*     */     
/* 372 */     return event;
/*     */   }
/*     */   
/*     */   public static PlayerDeathEvent callPlayerDeathEvent(EntityPlayer victim, List<ItemStack> drops, String deathMessage) {
/* 376 */     CraftPlayer entity = victim.getBukkitEntity();
/* 377 */     PlayerDeathEvent event = new PlayerDeathEvent((Player)entity, drops, victim.getExpReward(), 0, deathMessage);
/* 378 */     World world = entity.getWorld();
/* 379 */     Bukkit.getServer().getPluginManager().callEvent((Event)event);
/*     */     
/* 381 */     victim.keepLevel = event.getKeepLevel();
/* 382 */     victim.newLevel = event.getNewLevel();
/* 383 */     victim.newTotalExp = event.getNewTotalExp();
/* 384 */     victim.expToDrop = event.getDroppedExp();
/* 385 */     victim.newExp = event.getNewExp();
/*     */     
/* 387 */     for (ItemStack stack : event.getDrops()) {
/* 388 */       if (stack == null || stack.getType() == Material.AIR)
/*     */         continue; 
/* 390 */       world.dropItemNaturally(entity.getLocation(), stack);
/*     */     } 
/*     */     
/* 393 */     return event;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static ServerListPingEvent callServerListPingEvent(Server craftServer, InetAddress address, String motd, int numPlayers, int maxPlayers) {
/* 400 */     ServerListPingEvent event = new ServerListPingEvent(address, motd, numPlayers, maxPlayers);
/* 401 */     craftServer.getPluginManager().callEvent((Event)event);
/* 402 */     return event;
/*     */   }
/*     */   
/*     */   private static EntityDamageEvent handleEntityDamageEvent(Entity entity, DamageSource source, Map<EntityDamageEvent.DamageModifier, Double> modifiers, Map<EntityDamageEvent.DamageModifier, Function<? super Double, Double>> modifierFunctions) {
/* 406 */     if (source.isExplosion()) {
/*     */       EntityDamageByEntityEvent entityDamageByEntityEvent;
/* 408 */       Entity damager = entityDamage;
/* 409 */       entityDamage = null;
/*     */       
/* 411 */       if (damager == null) {
/* 412 */         EntityDamageByBlockEvent entityDamageByBlockEvent = new EntityDamageByBlockEvent(null, (Entity)entity.getBukkitEntity(), EntityDamageEvent.DamageCause.BLOCK_EXPLOSION, modifiers, modifierFunctions);
/* 413 */       } else if (entity instanceof EntityEnderDragon && ((EntityEnderDragon)entity).bC == damager) {
/* 414 */         EntityDamageEvent event = new EntityDamageEvent((Entity)entity.getBukkitEntity(), EntityDamageEvent.DamageCause.ENTITY_EXPLOSION, modifiers, modifierFunctions);
/*     */       } else {
/* 416 */         EntityDamageEvent.DamageCause damageCause; if (damager instanceof org.bukkit.entity.TNTPrimed) {
/* 417 */           damageCause = EntityDamageEvent.DamageCause.BLOCK_EXPLOSION;
/*     */         } else {
/* 419 */           damageCause = EntityDamageEvent.DamageCause.ENTITY_EXPLOSION;
/*     */         } 
/* 421 */         entityDamageByEntityEvent = new EntityDamageByEntityEvent((Entity)damager.getBukkitEntity(), (Entity)entity.getBukkitEntity(), damageCause, modifiers, modifierFunctions);
/*     */       } 
/*     */       
/* 424 */       callEvent(entityDamageByEntityEvent);
/*     */       
/* 426 */       if (!entityDamageByEntityEvent.isCancelled()) {
/* 427 */         entityDamageByEntityEvent.getEntity().setLastDamageCause((EntityDamageEvent)entityDamageByEntityEvent);
/*     */       }
/* 429 */       return (EntityDamageEvent)entityDamageByEntityEvent;
/* 430 */     }  if (source instanceof net.minecraft.server.v1_7_R4.EntityDamageSource) {
/* 431 */       Entity damager = source.getEntity();
/* 432 */       EntityDamageEvent.DamageCause damageCause = EntityDamageEvent.DamageCause.ENTITY_ATTACK;
/*     */       
/* 434 */       if (source instanceof EntityDamageSourceIndirect) {
/* 435 */         damager = ((EntityDamageSourceIndirect)source).getProximateDamageSource();
/* 436 */         if (damager.getBukkitEntity() instanceof ThrownPotion) {
/* 437 */           damageCause = EntityDamageEvent.DamageCause.MAGIC;
/* 438 */         } else if (damager.getBukkitEntity() instanceof Projectile) {
/* 439 */           damageCause = EntityDamageEvent.DamageCause.PROJECTILE;
/*     */         } 
/* 441 */       } else if ("thorns".equals(source.translationIndex)) {
/* 442 */         damageCause = EntityDamageEvent.DamageCause.THORNS;
/*     */       } 
/*     */       
/* 445 */       return callEntityDamageEvent(damager, entity, damageCause, modifiers, modifierFunctions);
/* 446 */     }  if (source == DamageSource.OUT_OF_WORLD) {
/* 447 */       EntityDamageEvent event = (EntityDamageEvent)callEvent(new EntityDamageByBlockEvent(null, (Entity)entity.getBukkitEntity(), EntityDamageEvent.DamageCause.VOID, modifiers, modifierFunctions));
/* 448 */       if (!event.isCancelled()) {
/* 449 */         event.getEntity().setLastDamageCause(event);
/*     */       }
/* 451 */       return event;
/* 452 */     }  if (source == DamageSource.LAVA) {
/* 453 */       EntityDamageEvent event = (EntityDamageEvent)callEvent(new EntityDamageByBlockEvent(null, (Entity)entity.getBukkitEntity(), EntityDamageEvent.DamageCause.LAVA, modifiers, modifierFunctions));
/* 454 */       if (!event.isCancelled()) {
/* 455 */         event.getEntity().setLastDamageCause(event);
/*     */       }
/* 457 */       return event;
/* 458 */     }  if (blockDamage != null) {
/* 459 */       EntityDamageEvent.DamageCause damageCause = null;
/* 460 */       Block damager = blockDamage;
/* 461 */       blockDamage = null;
/* 462 */       if (source == DamageSource.CACTUS) {
/* 463 */         damageCause = EntityDamageEvent.DamageCause.CONTACT;
/*     */       } else {
/* 465 */         throw new RuntimeException("Unhandled entity damage");
/*     */       } 
/* 467 */       EntityDamageEvent event = (EntityDamageEvent)callEvent(new EntityDamageByBlockEvent(damager, (Entity)entity.getBukkitEntity(), damageCause, modifiers, modifierFunctions));
/* 468 */       if (!event.isCancelled()) {
/* 469 */         event.getEntity().setLastDamageCause(event);
/*     */       }
/* 471 */       return event;
/* 472 */     }  if (entityDamage != null) {
/* 473 */       EntityDamageEvent.DamageCause damageCause = null;
/* 474 */       CraftEntity damager = entityDamage.getBukkitEntity();
/* 475 */       entityDamage = null;
/* 476 */       if (source == DamageSource.ANVIL || source == DamageSource.FALLING_BLOCK) {
/* 477 */         damageCause = EntityDamageEvent.DamageCause.FALLING_BLOCK;
/* 478 */       } else if (damager instanceof LightningStrike) {
/* 479 */         damageCause = EntityDamageEvent.DamageCause.LIGHTNING;
/* 480 */       } else if (source == DamageSource.FALL) {
/* 481 */         damageCause = EntityDamageEvent.DamageCause.FALL;
/*     */       } else {
/* 483 */         throw new RuntimeException("Unhandled entity damage");
/*     */       } 
/* 485 */       EntityDamageEvent event = (EntityDamageEvent)callEvent(new EntityDamageByEntityEvent((Entity)damager, (Entity)entity.getBukkitEntity(), damageCause, modifiers, modifierFunctions));
/* 486 */       if (!event.isCancelled()) {
/* 487 */         event.getEntity().setLastDamageCause(event);
/*     */       }
/* 489 */       return event;
/*     */     } 
/*     */     
/* 492 */     EntityDamageEvent.DamageCause cause = null;
/* 493 */     if (source == DamageSource.FIRE) {
/* 494 */       cause = EntityDamageEvent.DamageCause.FIRE;
/* 495 */     } else if (source == DamageSource.STARVE) {
/* 496 */       cause = EntityDamageEvent.DamageCause.STARVATION;
/* 497 */     } else if (source == DamageSource.WITHER) {
/* 498 */       cause = EntityDamageEvent.DamageCause.WITHER;
/* 499 */     } else if (source == DamageSource.STUCK) {
/* 500 */       cause = EntityDamageEvent.DamageCause.SUFFOCATION;
/* 501 */     } else if (source == DamageSource.DROWN) {
/* 502 */       cause = EntityDamageEvent.DamageCause.DROWNING;
/* 503 */     } else if (source == DamageSource.BURN) {
/* 504 */       cause = EntityDamageEvent.DamageCause.FIRE_TICK;
/* 505 */     } else if (source == MELTING) {
/* 506 */       cause = EntityDamageEvent.DamageCause.MELTING;
/* 507 */     } else if (source == POISON) {
/* 508 */       cause = EntityDamageEvent.DamageCause.POISON;
/* 509 */     } else if (source == DamageSource.MAGIC) {
/* 510 */       cause = EntityDamageEvent.DamageCause.MAGIC;
/* 511 */     } else if (source == DamageSource.FALL) {
/* 512 */       cause = EntityDamageEvent.DamageCause.FALL;
/* 513 */     } else if (source == DamageSource.GENERIC) {
/* 514 */       return new EntityDamageEvent((Entity)entity.getBukkitEntity(), null, modifiers, modifierFunctions);
/*     */     } 
/*     */     
/* 517 */     if (cause != null) {
/* 518 */       return callEntityDamageEvent(null, entity, cause, modifiers, modifierFunctions);
/*     */     }
/*     */     
/* 521 */     throw new RuntimeException("Unhandled entity damage");
/*     */   }
/*     */   
/*     */   private static EntityDamageEvent callEntityDamageEvent(Entity damager, Entity damagee, EntityDamageEvent.DamageCause cause, Map<EntityDamageEvent.DamageModifier, Double> modifiers, Map<EntityDamageEvent.DamageModifier, Function<? super Double, Double>> modifierFunctions) {
/*     */     EntityDamageEvent event;
/* 526 */     if (damager != null) {
/* 527 */       EntityDamageByEntityEvent entityDamageByEntityEvent = new EntityDamageByEntityEvent((Entity)damager.getBukkitEntity(), (Entity)damagee.getBukkitEntity(), cause, modifiers, modifierFunctions);
/*     */     } else {
/* 529 */       event = new EntityDamageEvent((Entity)damagee.getBukkitEntity(), cause, modifiers, modifierFunctions);
/*     */     } 
/*     */     
/* 532 */     callEvent(event);
/*     */     
/* 534 */     if (!event.isCancelled()) {
/* 535 */       event.getEntity().setLastDamageCause(event);
/*     */     }
/*     */     
/* 538 */     return event;
/*     */   }
/*     */   
/* 541 */   private static final Function<? super Double, Double> ZERO = Functions.constant(Double.valueOf(-0.0D));
/*     */   
/*     */   public static EntityDamageEvent handleLivingEntityDamageEvent(Entity damagee, DamageSource source, double rawDamage, double hardHatModifier, double blockingModifier, double armorModifier, double resistanceModifier, double magicModifier, double absorptionModifier, Function<Double, Double> hardHat, Function<Double, Double> blocking, Function<Double, Double> armor, Function<Double, Double> resistance, Function<Double, Double> magic, Function<Double, Double> absorption) {
/* 544 */     Map<EntityDamageEvent.DamageModifier, Double> modifiers = new EnumMap<EntityDamageEvent.DamageModifier, Double>(EntityDamageEvent.DamageModifier.class);
/* 545 */     Map<EntityDamageEvent.DamageModifier, Function<? super Double, Double>> modifierFunctions = new EnumMap<EntityDamageEvent.DamageModifier, Function<? super Double, Double>>(EntityDamageEvent.DamageModifier.class);
/* 546 */     modifiers.put(EntityDamageEvent.DamageModifier.BASE, Double.valueOf(rawDamage));
/* 547 */     modifierFunctions.put(EntityDamageEvent.DamageModifier.BASE, ZERO);
/* 548 */     if (source == DamageSource.FALLING_BLOCK || source == DamageSource.ANVIL) {
/* 549 */       modifiers.put(EntityDamageEvent.DamageModifier.HARD_HAT, Double.valueOf(hardHatModifier));
/* 550 */       modifierFunctions.put(EntityDamageEvent.DamageModifier.HARD_HAT, hardHat);
/*     */     } 
/* 552 */     if (damagee instanceof EntityHuman) {
/* 553 */       modifiers.put(EntityDamageEvent.DamageModifier.BLOCKING, Double.valueOf(blockingModifier));
/* 554 */       modifierFunctions.put(EntityDamageEvent.DamageModifier.BLOCKING, blocking);
/*     */     } 
/* 556 */     modifiers.put(EntityDamageEvent.DamageModifier.ARMOR, Double.valueOf(armorModifier));
/* 557 */     modifierFunctions.put(EntityDamageEvent.DamageModifier.ARMOR, armor);
/* 558 */     modifiers.put(EntityDamageEvent.DamageModifier.RESISTANCE, Double.valueOf(resistanceModifier));
/* 559 */     modifierFunctions.put(EntityDamageEvent.DamageModifier.RESISTANCE, resistance);
/* 560 */     modifiers.put(EntityDamageEvent.DamageModifier.MAGIC, Double.valueOf(magicModifier));
/* 561 */     modifierFunctions.put(EntityDamageEvent.DamageModifier.MAGIC, magic);
/* 562 */     modifiers.put(EntityDamageEvent.DamageModifier.ABSORPTION, Double.valueOf(absorptionModifier));
/* 563 */     modifierFunctions.put(EntityDamageEvent.DamageModifier.ABSORPTION, absorption);
/* 564 */     return handleEntityDamageEvent(damagee, source, modifiers, modifierFunctions);
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean handleNonLivingEntityDamageEvent(Entity entity, DamageSource source, double damage) {
/* 569 */     if (entity instanceof net.minecraft.server.v1_7_R4.EntityEnderCrystal && !(source instanceof net.minecraft.server.v1_7_R4.EntityDamageSource)) {
/* 570 */       return false;
/*     */     }
/*     */     
/* 573 */     EnumMap<EntityDamageEvent.DamageModifier, Double> modifiers = new EnumMap<EntityDamageEvent.DamageModifier, Double>(EntityDamageEvent.DamageModifier.class);
/* 574 */     EnumMap<EntityDamageEvent.DamageModifier, Function<? super Double, Double>> functions = new EnumMap<EntityDamageEvent.DamageModifier, Function<? super Double, Double>>(EntityDamageEvent.DamageModifier.class);
/*     */     
/* 576 */     modifiers.put(EntityDamageEvent.DamageModifier.BASE, Double.valueOf(damage));
/* 577 */     functions.put(EntityDamageEvent.DamageModifier.BASE, ZERO);
/*     */     
/* 579 */     EntityDamageEvent event = handleEntityDamageEvent(entity, source, modifiers, functions);
/* 580 */     if (event == null) {
/* 581 */       return false;
/*     */     }
/* 583 */     return (event.isCancelled() || event.getDamage() == 0.0D);
/*     */   }
/*     */   
/*     */   public static PlayerLevelChangeEvent callPlayerLevelChangeEvent(Player player, int oldLevel, int newLevel) {
/* 587 */     PlayerLevelChangeEvent event = new PlayerLevelChangeEvent(player, oldLevel, newLevel);
/* 588 */     Bukkit.getPluginManager().callEvent((Event)event);
/* 589 */     return event;
/*     */   }
/*     */   
/*     */   public static PlayerExpChangeEvent callPlayerExpChangeEvent(EntityHuman entity, int expAmount) {
/* 593 */     Player player = (Player)entity.getBukkitEntity();
/* 594 */     PlayerExpChangeEvent event = new PlayerExpChangeEvent(player, expAmount);
/* 595 */     Bukkit.getPluginManager().callEvent((Event)event);
/* 596 */     return event;
/*     */   }
/*     */   
/*     */   public static void handleBlockGrowEvent(World world, int x, int y, int z, Block type, int data) {
/* 600 */     Block block = world.getWorld().getBlockAt(x, y, z);
/* 601 */     CraftBlockState state = (CraftBlockState)block.getState();
/* 602 */     state.setTypeId(Block.getId(type));
/* 603 */     state.setRawData((byte)data);
/*     */     
/* 605 */     BlockGrowEvent event = new BlockGrowEvent(block, (BlockState)state);
/* 606 */     Bukkit.getPluginManager().callEvent((Event)event);
/*     */     
/* 608 */     if (!event.isCancelled()) {
/* 609 */       state.update(true);
/*     */     }
/*     */   }
/*     */   
/*     */   public static FoodLevelChangeEvent callFoodLevelChangeEvent(EntityHuman entity, int level) {
/* 614 */     FoodLevelChangeEvent event = new FoodLevelChangeEvent((HumanEntity)entity.getBukkitEntity(), level);
/* 615 */     entity.getBukkitEntity().getServer().getPluginManager().callEvent((Event)event);
/* 616 */     return event;
/*     */   }
/*     */   
/*     */   public static PigZapEvent callPigZapEvent(Entity pig, Entity lightning, Entity pigzombie) {
/* 620 */     PigZapEvent event = new PigZapEvent((Pig)pig.getBukkitEntity(), (LightningStrike)lightning.getBukkitEntity(), (PigZombie)pigzombie.getBukkitEntity());
/* 621 */     pig.getBukkitEntity().getServer().getPluginManager().callEvent((Event)event);
/* 622 */     return event;
/*     */   }
/*     */   
/*     */   public static HorseJumpEvent callHorseJumpEvent(Entity horse, float power) {
/* 626 */     HorseJumpEvent event = new HorseJumpEvent((Horse)horse.getBukkitEntity(), power);
/* 627 */     horse.getBukkitEntity().getServer().getPluginManager().callEvent((Event)event);
/* 628 */     return event;
/*     */   }
/*     */   
/*     */   public static EntityChangeBlockEvent callEntityChangeBlockEvent(Entity entity, Block block, Material material) {
/* 632 */     return callEntityChangeBlockEvent(entity, block, material, 0);
/*     */   }
/*     */   
/*     */   public static EntityChangeBlockEvent callEntityChangeBlockEvent(Entity entity, Block block, Material material) {
/* 636 */     return callEntityChangeBlockEvent((Entity)entity.getBukkitEntity(), block, material, 0);
/*     */   }
/*     */   
/*     */   public static EntityChangeBlockEvent callEntityChangeBlockEvent(Entity entity, Block block, Material material, boolean cancelled) {
/* 640 */     return callEntityChangeBlockEvent((Entity)entity.getBukkitEntity(), block, material, 0, cancelled);
/*     */   }
/*     */   
/*     */   public static EntityChangeBlockEvent callEntityChangeBlockEvent(Entity entity, int x, int y, int z, Block type, int data) {
/* 644 */     Block block = entity.world.getWorld().getBlockAt(x, y, z);
/* 645 */     Material material = CraftMagicNumbers.getMaterial(type);
/*     */     
/* 647 */     return callEntityChangeBlockEvent((Entity)entity.getBukkitEntity(), block, material, data);
/*     */   }
/*     */   
/*     */   public static EntityChangeBlockEvent callEntityChangeBlockEvent(Entity entity, Block block, Material material, int data) {
/* 651 */     return callEntityChangeBlockEvent(entity, block, material, data, false);
/*     */   }
/*     */   
/*     */   public static EntityChangeBlockEvent callEntityChangeBlockEvent(Entity entity, Block block, Material material, int data, boolean cancelled) {
/* 655 */     EntityChangeBlockEvent event = new EntityChangeBlockEvent(entity, block, material, (byte)data);
/* 656 */     event.setCancelled(cancelled);
/* 657 */     entity.getServer().getPluginManager().callEvent((Event)event);
/* 658 */     return event;
/*     */   }
/*     */   
/*     */   public static CreeperPowerEvent callCreeperPowerEvent(Entity creeper, Entity lightning, CreeperPowerEvent.PowerCause cause) {
/* 662 */     CreeperPowerEvent event = new CreeperPowerEvent((Creeper)creeper.getBukkitEntity(), (LightningStrike)lightning.getBukkitEntity(), cause);
/* 663 */     creeper.getBukkitEntity().getServer().getPluginManager().callEvent((Event)event);
/* 664 */     return event;
/*     */   }
/*     */   
/*     */   public static EntityTargetEvent callEntityTargetEvent(Entity entity, Entity target, EntityTargetEvent.TargetReason reason) {
/* 668 */     EntityTargetEvent event = new EntityTargetEvent((Entity)entity.getBukkitEntity(), (target == null) ? null : (Entity)target.getBukkitEntity(), reason);
/* 669 */     entity.getBukkitEntity().getServer().getPluginManager().callEvent((Event)event);
/* 670 */     return event;
/*     */   }
/*     */   
/*     */   public static EntityTargetLivingEntityEvent callEntityTargetLivingEvent(Entity entity, EntityLiving target, EntityTargetEvent.TargetReason reason) {
/* 674 */     EntityTargetLivingEntityEvent event = new EntityTargetLivingEntityEvent((Entity)entity.getBukkitEntity(), (LivingEntity)target.getBukkitEntity(), reason);
/* 675 */     entity.getBukkitEntity().getServer().getPluginManager().callEvent((Event)event);
/* 676 */     return event;
/*     */   }
/*     */   
/*     */   public static EntityBreakDoorEvent callEntityBreakDoorEvent(Entity entity, int x, int y, int z) {
/* 680 */     CraftEntity craftEntity = entity.getBukkitEntity();
/* 681 */     Block block = craftEntity.getWorld().getBlockAt(x, y, z);
/*     */     
/* 683 */     EntityBreakDoorEvent event = new EntityBreakDoorEvent((LivingEntity)craftEntity, block);
/* 684 */     craftEntity.getServer().getPluginManager().callEvent((Event)event);
/*     */     
/* 686 */     return event;
/*     */   }
/*     */   
/*     */   public static Container callInventoryOpenEvent(EntityPlayer player, Container container) {
/* 690 */     if (player.activeContainer != player.defaultContainer) {
/* 691 */       player.playerConnection.a(new PacketPlayInCloseWindow(player.activeContainer.windowId));
/*     */     }
/*     */     
/* 694 */     CraftServer server = player.world.getServer();
/* 695 */     CraftPlayer craftPlayer = player.getBukkitEntity();
/* 696 */     player.activeContainer.transferTo(container, (CraftHumanEntity)craftPlayer);
/*     */     
/* 698 */     InventoryOpenEvent event = new InventoryOpenEvent(container.getBukkitView());
/* 699 */     server.getPluginManager().callEvent((Event)event);
/*     */     
/* 701 */     if (event.isCancelled()) {
/* 702 */       container.transferTo(player.activeContainer, (CraftHumanEntity)craftPlayer);
/* 703 */       return null;
/*     */     } 
/*     */     
/* 706 */     return container;
/*     */   }
/*     */   
/*     */   public static ItemStack callPreCraftEvent(InventoryCrafting matrix, ItemStack result, InventoryView lastCraftView, boolean isRepair) {
/* 710 */     CraftInventoryCrafting inventory = new CraftInventoryCrafting(matrix, matrix.resultInventory);
/* 711 */     inventory.setResult((ItemStack)CraftItemStack.asCraftMirror(result));
/*     */     
/* 713 */     PrepareItemCraftEvent event = new PrepareItemCraftEvent((CraftingInventory)inventory, lastCraftView, isRepair);
/* 714 */     Bukkit.getPluginManager().callEvent((Event)event);
/*     */     
/* 716 */     ItemStack bitem = event.getInventory().getResult();
/*     */     
/* 718 */     return CraftItemStack.asNMSCopy(bitem);
/*     */   }
/*     */   
/*     */   public static ProjectileLaunchEvent callProjectileLaunchEvent(Entity entity) {
/* 722 */     Projectile bukkitEntity = (Projectile)entity.getBukkitEntity();
/* 723 */     ProjectileLaunchEvent event = new ProjectileLaunchEvent((Entity)bukkitEntity);
/* 724 */     Bukkit.getPluginManager().callEvent((Event)event);
/* 725 */     return event;
/*     */   }
/*     */   
/*     */   public static ProjectileHitEvent callProjectileHitEvent(Entity entity) {
/* 729 */     ProjectileHitEvent event = new ProjectileHitEvent((Projectile)entity.getBukkitEntity());
/* 730 */     entity.world.getServer().getPluginManager().callEvent((Event)event);
/* 731 */     return event;
/*     */   }
/*     */   
/*     */   public static ExpBottleEvent callExpBottleEvent(Entity entity, int exp) {
/* 735 */     ThrownExpBottle bottle = (ThrownExpBottle)entity.getBukkitEntity();
/* 736 */     ExpBottleEvent event = new ExpBottleEvent(bottle, exp);
/* 737 */     Bukkit.getPluginManager().callEvent((Event)event);
/* 738 */     return event;
/*     */   }
/*     */   
/*     */   public static BlockRedstoneEvent callRedstoneChange(World world, int x, int y, int z, int oldCurrent, int newCurrent) {
/* 742 */     BlockRedstoneEvent event = new BlockRedstoneEvent(world.getWorld().getBlockAt(x, y, z), oldCurrent, newCurrent);
/* 743 */     world.getServer().getPluginManager().callEvent((Event)event);
/* 744 */     return event;
/*     */   }
/*     */   
/*     */   public static NotePlayEvent callNotePlayEvent(World world, int x, int y, int z, byte instrument, byte note) {
/* 748 */     NotePlayEvent event = new NotePlayEvent(world.getWorld().getBlockAt(x, y, z), Instrument.getByType(instrument), new Note(note));
/* 749 */     world.getServer().getPluginManager().callEvent((Event)event);
/* 750 */     return event;
/*     */   }
/*     */   
/*     */   public static void callPlayerItemBreakEvent(EntityHuman human, ItemStack brokenItem) {
/* 754 */     CraftItemStack item = CraftItemStack.asCraftMirror(brokenItem);
/* 755 */     PlayerItemBreakEvent event = new PlayerItemBreakEvent((Player)human.getBukkitEntity(), (ItemStack)item);
/* 756 */     Bukkit.getPluginManager().callEvent((Event)event);
/*     */   }
/*     */   
/*     */   public static BlockIgniteEvent callBlockIgniteEvent(World world, int x, int y, int z, int igniterX, int igniterY, int igniterZ) {
/* 760 */     CraftWorld craftWorld = world.getWorld();
/* 761 */     Block igniter = craftWorld.getBlockAt(igniterX, igniterY, igniterZ);
/*     */     
/* 763 */     switch (igniter.getType())
/*     */     { case FALL_ONE_CM:
/*     */       case BOAT_ONE_CM:
/* 766 */         cause = BlockIgniteEvent.IgniteCause.LAVA;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 776 */         event = new BlockIgniteEvent(craftWorld.getBlockAt(x, y, z), cause, igniter);
/* 777 */         world.getServer().getPluginManager().callEvent((Event)event);
/* 778 */         return event;case CLIMB_ONE_CM: cause = BlockIgniteEvent.IgniteCause.FLINT_AND_STEEL; event = new BlockIgniteEvent(craftWorld.getBlockAt(x, y, z), cause, igniter); world.getServer().getPluginManager().callEvent((Event)event); return event; }  BlockIgniteEvent.IgniteCause cause = BlockIgniteEvent.IgniteCause.SPREAD; BlockIgniteEvent event = new BlockIgniteEvent(craftWorld.getBlockAt(x, y, z), cause, igniter); world.getServer().getPluginManager().callEvent((Event)event); return event;
/*     */   }
/*     */   
/*     */   public static BlockIgniteEvent callBlockIgniteEvent(World world, int x, int y, int z, Entity igniter) {
/* 782 */     CraftWorld craftWorld = world.getWorld();
/* 783 */     CraftEntity craftEntity = igniter.getBukkitEntity();
/*     */     
/* 785 */     switch (craftEntity.getType())
/*     */     { case FALL_ONE_CM:
/* 787 */         cause = BlockIgniteEvent.IgniteCause.ENDER_CRYSTAL;
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
/* 800 */         event = new BlockIgniteEvent(craftWorld.getBlockAt(x, y, z), cause, (Entity)craftEntity);
/* 801 */         world.getServer().getPluginManager().callEvent((Event)event);
/* 802 */         return event;case BOAT_ONE_CM: cause = BlockIgniteEvent.IgniteCause.LIGHTNING; event = new BlockIgniteEvent(craftWorld.getBlockAt(x, y, z), cause, (Entity)craftEntity); world.getServer().getPluginManager().callEvent((Event)event); return event;case CLIMB_ONE_CM: case DIVE_ONE_CM: cause = BlockIgniteEvent.IgniteCause.FIREBALL; event = new BlockIgniteEvent(craftWorld.getBlockAt(x, y, z), cause, (Entity)craftEntity); world.getServer().getPluginManager().callEvent((Event)event); return event; }  BlockIgniteEvent.IgniteCause cause = BlockIgniteEvent.IgniteCause.FLINT_AND_STEEL; BlockIgniteEvent event = new BlockIgniteEvent(craftWorld.getBlockAt(x, y, z), cause, (Entity)craftEntity); world.getServer().getPluginManager().callEvent((Event)event); return event;
/*     */   }
/*     */   
/*     */   public static BlockIgniteEvent callBlockIgniteEvent(World world, int x, int y, int z, Explosion explosion) {
/* 806 */     CraftWorld craftWorld = world.getWorld();
/* 807 */     CraftEntity craftEntity = (explosion.source == null) ? null : explosion.source.getBukkitEntity();
/*     */     
/* 809 */     BlockIgniteEvent event = new BlockIgniteEvent(craftWorld.getBlockAt(x, y, z), BlockIgniteEvent.IgniteCause.EXPLOSION, (Entity)craftEntity);
/* 810 */     world.getServer().getPluginManager().callEvent((Event)event);
/* 811 */     return event;
/*     */   }
/*     */   
/*     */   public static BlockIgniteEvent callBlockIgniteEvent(World world, int x, int y, int z, BlockIgniteEvent.IgniteCause cause, Entity igniter) {
/* 815 */     BlockIgniteEvent event = new BlockIgniteEvent(world.getWorld().getBlockAt(x, y, z), cause, (Entity)igniter.getBukkitEntity());
/* 816 */     world.getServer().getPluginManager().callEvent((Event)event);
/* 817 */     return event;
/*     */   }
/*     */   
/*     */   public static void handleInventoryCloseEvent(EntityHuman human) {
/* 821 */     InventoryCloseEvent event = new InventoryCloseEvent(human.activeContainer.getBukkitView());
/* 822 */     human.world.getServer().getPluginManager().callEvent((Event)event);
/* 823 */     human.activeContainer.transferTo(human.defaultContainer, human.getBukkitEntity());
/*     */   }
/*     */   
/*     */   public static void handleEditBookEvent(EntityPlayer player, ItemStack newBookItem) {
/* 827 */     int itemInHandIndex = player.inventory.itemInHandIndex;
/*     */     
/* 829 */     PlayerEditBookEvent editBookEvent = new PlayerEditBookEvent((Player)player.getBukkitEntity(), player.inventory.itemInHandIndex, (BookMeta)CraftItemStack.getItemMeta(player.inventory.getItemInHand()), (BookMeta)CraftItemStack.getItemMeta(newBookItem), (newBookItem.getItem() == Items.WRITTEN_BOOK));
/* 830 */     player.world.getServer().getPluginManager().callEvent((Event)editBookEvent);
/* 831 */     ItemStack itemInHand = player.inventory.getItem(itemInHandIndex);
/*     */ 
/*     */     
/* 834 */     if (itemInHand != null && itemInHand.getItem() == Items.BOOK_AND_QUILL) {
/* 835 */       if (!editBookEvent.isCancelled()) {
/* 836 */         CraftItemStack.setItemMeta(itemInHand, (ItemMeta)editBookEvent.getNewBookMeta());
/* 837 */         if (editBookEvent.isSigning()) {
/* 838 */           itemInHand.setItem(Items.WRITTEN_BOOK);
/*     */         }
/*     */       } 
/*     */ 
/*     */       
/* 843 */       Slot slot = player.activeContainer.getSlot((IInventory)player.inventory, itemInHandIndex);
/* 844 */       player.playerConnection.sendPacket((Packet)new PacketPlayOutSetSlot(player.activeContainer.windowId, slot.rawSlotIndex, itemInHand));
/*     */     } 
/*     */   }
/*     */   
/*     */   public static PlayerUnleashEntityEvent callPlayerUnleashEntityEvent(EntityInsentient entity, EntityHuman player) {
/* 849 */     PlayerUnleashEntityEvent event = new PlayerUnleashEntityEvent((Entity)entity.getBukkitEntity(), (Player)player.getBukkitEntity());
/* 850 */     entity.world.getServer().getPluginManager().callEvent((Event)event);
/* 851 */     return event;
/*     */   }
/*     */   
/*     */   public static PlayerLeashEntityEvent callPlayerLeashEntityEvent(EntityInsentient entity, Entity leashHolder, EntityHuman player) {
/* 855 */     PlayerLeashEntityEvent event = new PlayerLeashEntityEvent((Entity)entity.getBukkitEntity(), (Entity)leashHolder.getBukkitEntity(), (Player)player.getBukkitEntity());
/* 856 */     entity.world.getServer().getPluginManager().callEvent((Event)event);
/* 857 */     return event;
/*     */   }
/*     */   public static Cancellable handleStatisticsIncrease(EntityHuman entityHuman, Statistic statistic, int current, int incrementation) {
/*     */     PlayerStatisticIncrementEvent playerStatisticIncrementEvent;
/* 861 */     CraftPlayer craftPlayer = ((EntityPlayer)entityHuman).getBukkitEntity();
/*     */     
/* 863 */     if (statistic instanceof Achievement) {
/* 864 */       if (current != 0) {
/* 865 */         return null;
/*     */       }
/* 867 */       PlayerAchievementAwardedEvent playerAchievementAwardedEvent = new PlayerAchievementAwardedEvent((Player)craftPlayer, CraftStatistic.getBukkitAchievement((Achievement)statistic));
/*     */     } else {
/* 869 */       Statistic stat = CraftStatistic.getBukkitStatistic(statistic);
/* 870 */       switch (stat) {
/*     */         
/*     */         case FALL_ONE_CM:
/*     */         case BOAT_ONE_CM:
/*     */         case CLIMB_ONE_CM:
/*     */         case DIVE_ONE_CM:
/*     */         case FLY_ONE_CM:
/*     */         case HORSE_ONE_CM:
/*     */         case MINECART_ONE_CM:
/*     */         case PIG_ONE_CM:
/*     */         case PLAY_ONE_TICK:
/*     */         case SWIM_ONE_CM:
/*     */         case WALK_ONE_CM:
/* 883 */           return null;
/*     */       } 
/*     */       
/* 886 */       if (stat.getType() == Statistic.Type.UNTYPED) {
/* 887 */         playerStatisticIncrementEvent = new PlayerStatisticIncrementEvent((Player)craftPlayer, stat, current, current + incrementation);
/* 888 */       } else if (stat.getType() == Statistic.Type.ENTITY) {
/* 889 */         EntityType entityType = CraftStatistic.getEntityTypeFromStatistic(statistic);
/* 890 */         playerStatisticIncrementEvent = new PlayerStatisticIncrementEvent((Player)craftPlayer, stat, current, current + incrementation, entityType);
/*     */       } else {
/* 892 */         Material material = CraftStatistic.getMaterialFromStatistic(statistic);
/* 893 */         playerStatisticIncrementEvent = new PlayerStatisticIncrementEvent((Player)craftPlayer, stat, current, current + incrementation, material);
/*     */       } 
/*     */     } 
/* 896 */     entityHuman.world.getServer().getPluginManager().callEvent((Event)playerStatisticIncrementEvent);
/* 897 */     return (Cancellable)playerStatisticIncrementEvent;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\v1_7_R4\event\CraftEventFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */