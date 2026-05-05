/*     */ package net.minecraftforge.event;
/*     */ 
/*     */ import cpw.mods.fml.common.ObfuscationReflectionHelper;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import java.io.File;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.EnumCreatureType;
/*     */ import net.minecraft.entity.effect.EntityLightningBolt;
/*     */ import net.minecraft.entity.monster.EntityZombie;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.world.Explosion;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldServer;
/*     */ import net.minecraft.world.WorldSettings;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.storage.IPlayerFileData;
/*     */ import net.minecraft.world.storage.SaveHandler;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.common.util.BlockSnapshot;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ import net.minecraftforge.event.brewing.PotionBrewEvent;
/*     */ import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingHealEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingPackSizeEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingSpawnEvent;
/*     */ import net.minecraftforge.event.entity.living.ZombieEvent;
/*     */ import net.minecraftforge.event.entity.player.ItemTooltipEvent;
/*     */ import net.minecraftforge.event.entity.player.PlayerDestroyItemEvent;
/*     */ import net.minecraftforge.event.entity.player.PlayerEvent;
/*     */ import net.minecraftforge.event.entity.player.PlayerInteractEvent;
/*     */ import net.minecraftforge.event.entity.player.PlayerUseItemEvent;
/*     */ import net.minecraftforge.event.world.BlockEvent;
/*     */ import net.minecraftforge.event.world.ExplosionEvent;
/*     */ import net.minecraftforge.event.world.WorldEvent;
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
/*     */ 
/*     */ public class ForgeEventFactory
/*     */ {
/*     */   public static BlockEvent.MultiPlaceEvent onPlayerMultiBlockPlace(EntityPlayer player, List<BlockSnapshot> blockSnapshots, ForgeDirection direction) {
/*  57 */     Block placedAgainst = ((BlockSnapshot)blockSnapshots.get(0)).world.getBlock(((BlockSnapshot)blockSnapshots.get(0)).x + (direction.getOpposite()).offsetX, ((BlockSnapshot)blockSnapshots.get(0)).y + (direction.getOpposite()).offsetY, ((BlockSnapshot)blockSnapshots.get(0)).z + (direction.getOpposite()).offsetZ);
/*     */     
/*  59 */     BlockEvent.MultiPlaceEvent event = new BlockEvent.MultiPlaceEvent(blockSnapshots, placedAgainst, player);
/*  60 */     MinecraftForge.EVENT_BUS.post((Event)event);
/*  61 */     return event;
/*     */   }
/*     */ 
/*     */   
/*     */   public static BlockEvent.PlaceEvent onPlayerBlockPlace(EntityPlayer player, BlockSnapshot blockSnapshot, ForgeDirection direction) {
/*  66 */     Block placedAgainst = blockSnapshot.world.getBlock(blockSnapshot.x + (direction.getOpposite()).offsetX, blockSnapshot.y + (direction.getOpposite()).offsetY, blockSnapshot.z + (direction.getOpposite()).offsetZ);
/*     */     
/*  68 */     BlockEvent.PlaceEvent event = new BlockEvent.PlaceEvent(blockSnapshot, placedAgainst, player);
/*  69 */     MinecraftForge.EVENT_BUS.post((Event)event);
/*  70 */     return event;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean doPlayerHarvestCheck(EntityPlayer player, Block block, boolean success) {
/*  75 */     PlayerEvent.HarvestCheck event = new PlayerEvent.HarvestCheck(player, block, success);
/*  76 */     MinecraftForge.EVENT_BUS.post((Event)event);
/*  77 */     return event.success;
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static float getBreakSpeed(EntityPlayer player, Block block, int metadata, float original) {
/*  83 */     return getBreakSpeed(player, block, metadata, original, 0, -1, 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getBreakSpeed(EntityPlayer player, Block block, int metadata, float original, int x, int y, int z) {
/*  88 */     PlayerEvent.BreakSpeed event = new PlayerEvent.BreakSpeed(player, block, metadata, original, x, y, z);
/*  89 */     return MinecraftForge.EVENT_BUS.post((Event)event) ? -1.0F : event.newSpeed;
/*     */   }
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public static PlayerInteractEvent onPlayerInteract(EntityPlayer player, PlayerInteractEvent.Action action, int x, int y, int z, int face) {
/*  95 */     return onPlayerInteract(player, action, x, y, z, face, null);
/*     */   }
/*     */   
/*     */   public static PlayerInteractEvent onPlayerInteract(EntityPlayer player, PlayerInteractEvent.Action action, int x, int y, int z, int face, World world) {
/*  99 */     PlayerInteractEvent event = new PlayerInteractEvent(player, action, x, y, z, face, world);
/* 100 */     MinecraftForge.EVENT_BUS.post((Event)event);
/* 101 */     return event;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onPlayerDestroyItem(EntityPlayer player, ItemStack stack) {
/* 106 */     MinecraftForge.EVENT_BUS.post((Event)new PlayerDestroyItemEvent(player, stack));
/*     */   }
/*     */ 
/*     */   
/*     */   public static Event.Result canEntitySpawn(EntityLiving entity, World world, float x, float y, float z) {
/* 111 */     LivingSpawnEvent.CheckSpawn event = new LivingSpawnEvent.CheckSpawn(entity, world, x, y, z);
/* 112 */     MinecraftForge.EVENT_BUS.post((Event)event);
/* 113 */     return event.getResult();
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean doSpecialSpawn(EntityLiving entity, World world, float x, float y, float z) {
/* 118 */     return MinecraftForge.EVENT_BUS.post((Event)new LivingSpawnEvent.SpecialSpawn(entity, world, x, y, z));
/*     */   }
/*     */ 
/*     */   
/*     */   public static Event.Result canEntityDespawn(EntityLiving entity) {
/* 123 */     LivingSpawnEvent.AllowDespawn event = new LivingSpawnEvent.AllowDespawn(entity);
/* 124 */     MinecraftForge.EVENT_BUS.post((Event)event);
/* 125 */     return event.getResult();
/*     */   }
/*     */ 
/*     */   
/*     */   public static List<BiomeGenBase.SpawnListEntry> getPotentialSpawns(WorldServer world, EnumCreatureType type, int x, int y, int z, List<BiomeGenBase.SpawnListEntry> oldList) {
/* 130 */     WorldEvent.PotentialSpawns event = new WorldEvent.PotentialSpawns((World)world, type, x, y, z, oldList);
/* 131 */     if (MinecraftForge.EVENT_BUS.post((Event)event))
/*     */     {
/* 133 */       return null;
/*     */     }
/* 135 */     return event.list;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getFuelBurnTime(ItemStack fuel) {
/* 140 */     FuelBurnTimeEvent event = new FuelBurnTimeEvent(fuel);
/* 141 */     MinecraftForge.EVENT_BUS.post(event);
/* 142 */     return (event.getResult() == Event.Result.DEFAULT) ? -1 : event.burnTime;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getMaxSpawnPackSize(EntityLiving entity) {
/* 147 */     LivingPackSizeEvent maxCanSpawnEvent = new LivingPackSizeEvent(entity);
/* 148 */     MinecraftForge.EVENT_BUS.post((Event)maxCanSpawnEvent);
/* 149 */     return (maxCanSpawnEvent.getResult() == Event.Result.ALLOW) ? maxCanSpawnEvent.maxPackSize : entity.getMaxSpawnedInChunk();
/*     */   }
/*     */ 
/*     */   
/*     */   public static String getPlayerDisplayName(EntityPlayer player, String username) {
/* 154 */     PlayerEvent.NameFormat event = new PlayerEvent.NameFormat(player, username);
/* 155 */     MinecraftForge.EVENT_BUS.post((Event)event);
/* 156 */     return event.displayname;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float fireBlockHarvesting(ArrayList<ItemStack> drops, World world, Block block, int x, int y, int z, int meta, int fortune, float dropChance, boolean silkTouch, EntityPlayer player) {
/* 161 */     BlockEvent.HarvestDropsEvent event = new BlockEvent.HarvestDropsEvent(x, y, z, world, block, meta, fortune, dropChance, drops, player, silkTouch);
/* 162 */     MinecraftForge.EVENT_BUS.post((Event)event);
/* 163 */     return event.dropChance;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ItemTooltipEvent onItemTooltip(ItemStack itemStack, EntityPlayer entityPlayer, List<String> toolTip, boolean showAdvancedItemTooltips) {
/* 168 */     ItemTooltipEvent event = new ItemTooltipEvent(itemStack, entityPlayer, toolTip, showAdvancedItemTooltips);
/* 169 */     MinecraftForge.EVENT_BUS.post((Event)event);
/* 170 */     return event;
/*     */   }
/*     */ 
/*     */   
/*     */   public static ZombieEvent.SummonAidEvent fireZombieSummonAid(EntityZombie zombie, World world, int x, int y, int z, EntityLivingBase attacker, double summonChance) {
/* 175 */     ZombieEvent.SummonAidEvent summonEvent = new ZombieEvent.SummonAidEvent(zombie, world, x, y, z, attacker, summonChance);
/* 176 */     MinecraftForge.EVENT_BUS.post((Event)summonEvent);
/* 177 */     return summonEvent;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean onEntityStruckByLightning(Entity entity, EntityLightningBolt bolt) {
/* 182 */     return MinecraftForge.EVENT_BUS.post((Event)new EntityStruckByLightningEvent(entity, bolt));
/*     */   }
/*     */ 
/*     */   
/*     */   public static int onItemUseStart(EntityPlayer player, ItemStack item, int duration) {
/* 187 */     PlayerUseItemEvent.Start start = new PlayerUseItemEvent.Start(player, item, duration);
/* 188 */     return MinecraftForge.EVENT_BUS.post((Event)start) ? -1 : ((PlayerUseItemEvent)start).duration;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int onItemUseTick(EntityPlayer player, ItemStack item, int duration) {
/* 193 */     PlayerUseItemEvent.Tick tick = new PlayerUseItemEvent.Tick(player, item, duration);
/* 194 */     return MinecraftForge.EVENT_BUS.post((Event)tick) ? -1 : ((PlayerUseItemEvent)tick).duration;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean onUseItemStop(EntityPlayer player, ItemStack item, int duration) {
/* 199 */     return MinecraftForge.EVENT_BUS.post((Event)new PlayerUseItemEvent.Stop(player, item, duration));
/*     */   }
/*     */ 
/*     */   
/*     */   public static ItemStack onItemUseFinish(EntityPlayer player, ItemStack item, int duration, ItemStack result) {
/* 204 */     PlayerUseItemEvent.Finish event = new PlayerUseItemEvent.Finish(player, item, duration, result);
/* 205 */     MinecraftForge.EVENT_BUS.post((Event)event);
/* 206 */     return event.result;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onStartEntityTracking(Entity entity, EntityPlayer player) {
/* 211 */     MinecraftForge.EVENT_BUS.post((Event)new PlayerEvent.StartTracking(player, entity));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onStopEntityTracking(Entity entity, EntityPlayer player) {
/* 216 */     MinecraftForge.EVENT_BUS.post((Event)new PlayerEvent.StopTracking(player, entity));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void firePlayerLoadingEvent(EntityPlayer player, File playerDirectory, String uuidString) {
/* 221 */     MinecraftForge.EVENT_BUS.post((Event)new PlayerEvent.LoadFromFile(player, playerDirectory, uuidString));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void firePlayerSavingEvent(EntityPlayer player, File playerDirectory, String uuidString) {
/* 226 */     MinecraftForge.EVENT_BUS.post((Event)new PlayerEvent.SaveToFile(player, playerDirectory, uuidString));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void firePlayerLoadingEvent(EntityPlayer player, IPlayerFileData playerFileData, String uuidString) {
/* 231 */     SaveHandler sh = (SaveHandler)playerFileData;
/* 232 */     File dir = (File)ObfuscationReflectionHelper.getPrivateValue(SaveHandler.class, sh, new String[] { "playersDirectory", "field_75771_c" });
/* 233 */     MinecraftForge.EVENT_BUS.post((Event)new PlayerEvent.LoadFromFile(player, dir, uuidString));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean onExplosionStart(World world, Explosion explosion) {
/* 238 */     return MinecraftForge.EVENT_BUS.post((Event)new ExplosionEvent.Start(world, explosion));
/*     */   }
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
/*     */   public static void onExplosionDetonate(World world, Explosion explosion, List<Entity> list, double diameter) {
/* 253 */     MinecraftForge.EVENT_BUS.post((Event)new ExplosionEvent.Detonate(world, explosion, list));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean onCreateWorldSpawn(World world, WorldSettings settings) {
/* 258 */     return MinecraftForge.EVENT_BUS.post((Event)new WorldEvent.CreateSpawnPosition(world, settings));
/*     */   }
/*     */ 
/*     */   
/*     */   public static float onLivingHeal(EntityLivingBase entity, float amount) {
/* 263 */     LivingHealEvent event = new LivingHealEvent(entity, amount);
/* 264 */     return MinecraftForge.EVENT_BUS.post((Event)event) ? 0.0F : event.amount;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean onPotionAttemptBreaw(ItemStack[] stacks) {
/* 269 */     ItemStack[] tmp = new ItemStack[stacks.length];
/* 270 */     for (int x = 0; x < tmp.length; x++) {
/* 271 */       tmp[x] = ItemStack.copyItemStack(stacks[x]);
/*     */     }
/* 273 */     PotionBrewEvent.Pre event = new PotionBrewEvent.Pre(tmp);
/* 274 */     if (MinecraftForge.EVENT_BUS.post((Event)event)) {
/*     */       
/* 276 */       boolean changed = false;
/* 277 */       for (int i = 0; i < stacks.length; i++) {
/*     */         
/* 279 */         changed |= ItemStack.areItemStacksEqual(tmp[i], stacks[i]);
/* 280 */         stacks[i] = event.getItem(i);
/*     */       } 
/* 282 */       if (changed)
/* 283 */         onPotionBrewed(stacks); 
/* 284 */       return true;
/*     */     } 
/* 286 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onPotionBrewed(ItemStack[] brewingItemStacks) {
/* 291 */     MinecraftForge.EVENT_BUS.post((Event)new PotionBrewEvent.Post(brewingItemStacks));
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\event\ForgeEventFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */