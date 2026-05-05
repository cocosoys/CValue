/*     */ package net.minecraftforge.common;
/*     */ 
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.relauncher.ReflectionHelper;
/*     */ import java.net.URI;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import java.util.regex.Matcher;
/*     */ import java.util.regex.Pattern;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.event.ClickEvent;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.inventory.Container;
/*     */ import net.minecraft.inventory.ContainerRepair;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemArmor;
/*     */ import net.minecraft.item.ItemAxe;
/*     */ import net.minecraft.item.ItemPickaxe;
/*     */ import net.minecraft.item.ItemSpade;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.NetHandlerPlayServer;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.server.S23PacketBlockChange;
/*     */ import net.minecraft.stats.StatList;
/*     */ import net.minecraft.tileentity.TileEntity;
/*     */ import net.minecraft.tileentity.TileEntityNote;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.WeightedRandom;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldSettings;
/*     */ import net.minecraftforge.common.util.BlockSnapshot;
/*     */ import net.minecraftforge.common.util.ForgeDirection;
/*     */ import net.minecraftforge.event.AnvilUpdateEvent;
/*     */ import net.minecraftforge.event.ForgeEventFactory;
/*     */ import net.minecraftforge.event.ServerChatEvent;
/*     */ import net.minecraftforge.event.entity.item.ItemTossEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingAttackEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingDeathEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingDropsEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingFallEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingHurtEvent;
/*     */ import net.minecraftforge.event.entity.living.LivingSetAttackTargetEvent;
/*     */ import net.minecraftforge.event.entity.player.AnvilRepairEvent;
/*     */ import net.minecraftforge.event.entity.player.PlayerOpenContainerEvent;
/*     */ import net.minecraftforge.event.world.BlockEvent;
/*     */ import net.minecraftforge.event.world.NoteBlockEvent;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ForgeHooks
/*     */ {
/*     */   static class SeedEntry
/*     */     extends WeightedRandom.Item
/*     */   {
/*     */     public final ItemStack seed;
/*     */     
/*     */     public SeedEntry(ItemStack seed, int weight) {
/*  76 */       super(weight);
/*  77 */       this.seed = seed;
/*     */     }
/*     */   }
/*  80 */   static final List<SeedEntry> seedList = new ArrayList<SeedEntry>();
/*     */ 
/*     */   
/*     */   public static ItemStack getGrassSeed(World world) {
/*  84 */     SeedEntry entry = (SeedEntry)WeightedRandom.getRandomItem(world.rand, seedList);
/*  85 */     if (entry == null || entry.seed == null)
/*     */     {
/*  87 */       return null;
/*     */     }
/*  89 */     return entry.seed.copy();
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean toolInit = false;
/*     */ 
/*     */   
/*     */   public static boolean canHarvestBlock(Block block, EntityPlayer player, int metadata) {
/*  97 */     if (block.getMaterial().isToolNotRequired())
/*     */     {
/*  99 */       return true;
/*     */     }
/*     */     
/* 102 */     ItemStack stack = player.inventory.getCurrentItem();
/* 103 */     String tool = block.getHarvestTool(metadata);
/* 104 */     if (stack == null || tool == null)
/*     */     {
/* 106 */       return player.canHarvestBlock(block);
/*     */     }
/*     */     
/* 109 */     int toolLevel = stack.getItem().getHarvestLevel(stack, tool);
/* 110 */     if (toolLevel < 0)
/*     */     {
/* 112 */       return player.canHarvestBlock(block);
/*     */     }
/*     */     
/* 115 */     return (toolLevel >= block.getHarvestLevel(metadata));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean canToolHarvestBlock(Block block, int metadata, ItemStack stack) {
/* 120 */     String tool = block.getHarvestTool(metadata);
/* 121 */     if (stack == null || tool == null) return false; 
/* 122 */     return (stack.getItem().getHarvestLevel(stack, tool) >= block.getHarvestLevel(metadata));
/*     */   }
/*     */ 
/*     */   
/*     */   public static float blockStrength(Block block, EntityPlayer player, World world, int x, int y, int z) {
/* 127 */     int metadata = world.getBlockMetadata(x, y, z);
/* 128 */     float hardness = block.getBlockHardness(world, x, y, z);
/* 129 */     if (hardness < 0.0F)
/*     */     {
/* 131 */       return 0.0F;
/*     */     }
/*     */     
/* 134 */     if (!canHarvestBlock(block, player, metadata))
/*     */     {
/* 136 */       return player.getBreakSpeed(block, true, metadata, x, y, z) / hardness / 100.0F;
/*     */     }
/*     */ 
/*     */     
/* 140 */     return player.getBreakSpeed(block, false, metadata, x, y, z) / hardness / 30.0F;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isToolEffective(ItemStack stack, Block block, int metadata) {
/* 146 */     for (String type : stack.getItem().getToolClasses(stack)) {
/*     */       
/* 148 */       if (block.isToolEffective(type, metadata))
/* 149 */         return true; 
/*     */     } 
/* 151 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   static void initTools() {
/* 156 */     if (toolInit) {
/*     */       return;
/*     */     }
/*     */     
/* 160 */     toolInit = true;
/*     */     
/* 162 */     Set<Block> blocks = (Set<Block>)ReflectionHelper.getPrivateValue(ItemPickaxe.class, null, 0);
/* 163 */     for (Block block : blocks)
/*     */     {
/* 165 */       block.setHarvestLevel("pickaxe", 0);
/*     */     }
/*     */     
/* 168 */     blocks = (Set<Block>)ReflectionHelper.getPrivateValue(ItemSpade.class, null, 0);
/* 169 */     for (Block block : blocks)
/*     */     {
/* 171 */       block.setHarvestLevel("shovel", 0);
/*     */     }
/*     */     
/* 174 */     blocks = (Set<Block>)ReflectionHelper.getPrivateValue(ItemAxe.class, null, 0);
/* 175 */     for (Block block : blocks)
/*     */     {
/* 177 */       block.setHarvestLevel("axe", 0);
/*     */     }
/*     */     
/* 180 */     Blocks.obsidian.setHarvestLevel("pickaxe", 3);
/* 181 */     for (Block block : new Block[] { Blocks.emerald_ore, Blocks.emerald_block, Blocks.diamond_ore, Blocks.diamond_block, Blocks.gold_ore, Blocks.gold_block, Blocks.redstone_ore, Blocks.lit_redstone_ore })
/*     */     {
/* 183 */       block.setHarvestLevel("pickaxe", 2);
/*     */     }
/* 185 */     Blocks.iron_ore.setHarvestLevel("pickaxe", 1);
/* 186 */     Blocks.iron_block.setHarvestLevel("pickaxe", 1);
/* 187 */     Blocks.lapis_ore.setHarvestLevel("pickaxe", 1);
/* 188 */     Blocks.lapis_block.setHarvestLevel("pickaxe", 1);
/* 189 */     Blocks.quartz_ore.setHarvestLevel("pickaxe", 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getTotalArmorValue(EntityPlayer player) {
/* 194 */     int ret = 0;
/* 195 */     for (int x = 0; x < player.inventory.armorInventory.length; x++) {
/*     */       
/* 197 */       ItemStack stack = player.inventory.armorInventory[x];
/* 198 */       if (stack != null && stack.getItem() instanceof ISpecialArmor) {
/*     */         
/* 200 */         ret += ((ISpecialArmor)stack.getItem()).getArmorDisplay(player, stack, x);
/*     */       }
/* 202 */       else if (stack != null && stack.getItem() instanceof ItemArmor) {
/*     */         
/* 204 */         ret += ((ItemArmor)stack.getItem()).damageReduceAmount;
/*     */       } 
/*     */     } 
/* 207 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   static {
/* 212 */     seedList.add(new SeedEntry(new ItemStack(Items.wheat_seeds), 10));
/* 213 */     initTools();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean onPickBlock(MovingObjectPosition target, EntityPlayer player, World world) {
/* 221 */     ItemStack result = null;
/* 222 */     boolean isCreative = player.capabilities.isCreativeMode;
/*     */     
/* 224 */     if (target.typeOfHit == MovingObjectPosition.MovingObjectType.BLOCK) {
/*     */       
/* 226 */       int i = target.blockX;
/* 227 */       int y = target.blockY;
/* 228 */       int z = target.blockZ;
/* 229 */       Block block = world.getBlock(i, y, z);
/*     */       
/* 231 */       if (block.isAir((IBlockAccess)world, i, y, z))
/*     */       {
/* 233 */         return false;
/*     */       }
/*     */       
/* 236 */       result = block.getPickBlock(target, world, i, y, z, player);
/*     */     }
/*     */     else {
/*     */       
/* 240 */       if (target.typeOfHit != MovingObjectPosition.MovingObjectType.ENTITY || target.entityHit == null || !isCreative)
/*     */       {
/* 242 */         return false;
/*     */       }
/*     */       
/* 245 */       result = target.entityHit.getPickedResult(target);
/*     */     } 
/*     */     
/* 248 */     if (result == null)
/*     */     {
/* 250 */       return false;
/*     */     }
/*     */     
/* 253 */     for (int x = 0; x < 9; x++) {
/*     */       
/* 255 */       ItemStack stack = player.inventory.getStackInSlot(x);
/* 256 */       if (stack != null && stack.isItemEqual(result) && ItemStack.areItemStackTagsEqual(stack, result)) {
/*     */         
/* 258 */         player.inventory.currentItem = x;
/* 259 */         return true;
/*     */       } 
/*     */     } 
/*     */     
/* 263 */     if (!isCreative)
/*     */     {
/* 265 */       return false;
/*     */     }
/*     */     
/* 268 */     int slot = player.inventory.getFirstEmptyStack();
/* 269 */     if (slot < 0 || slot >= 9)
/*     */     {
/* 271 */       slot = player.inventory.currentItem;
/*     */     }
/*     */     
/* 274 */     player.inventory.setInventorySlotContents(slot, result);
/* 275 */     player.inventory.currentItem = slot;
/* 276 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void onLivingSetAttackTarget(EntityLivingBase entity, EntityLivingBase target) {
/* 284 */     MinecraftForge.EVENT_BUS.post((Event)new LivingSetAttackTargetEvent(entity, target));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean onLivingUpdate(EntityLivingBase entity) {
/* 289 */     return MinecraftForge.EVENT_BUS.post((Event)new LivingEvent.LivingUpdateEvent(entity));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean onLivingAttack(EntityLivingBase entity, DamageSource src, float amount) {
/* 294 */     return MinecraftForge.EVENT_BUS.post((Event)new LivingAttackEvent(entity, src, amount));
/*     */   }
/*     */ 
/*     */   
/*     */   public static float onLivingHurt(EntityLivingBase entity, DamageSource src, float amount) {
/* 299 */     LivingHurtEvent event = new LivingHurtEvent(entity, src, amount);
/* 300 */     return MinecraftForge.EVENT_BUS.post((Event)event) ? 0.0F : event.ammount;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean onLivingDeath(EntityLivingBase entity, DamageSource src) {
/* 305 */     return MinecraftForge.EVENT_BUS.post((Event)new LivingDeathEvent(entity, src));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean onLivingDrops(EntityLivingBase entity, DamageSource source, ArrayList<EntityItem> drops, int lootingLevel, boolean recentlyHit, int specialDropValue) {
/* 310 */     return MinecraftForge.EVENT_BUS.post((Event)new LivingDropsEvent(entity, source, drops, lootingLevel, recentlyHit, specialDropValue));
/*     */   }
/*     */ 
/*     */   
/*     */   public static float onLivingFall(EntityLivingBase entity, float distance) {
/* 315 */     LivingFallEvent event = new LivingFallEvent(entity, distance);
/* 316 */     return MinecraftForge.EVENT_BUS.post((Event)event) ? 0.0F : event.distance;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isLivingOnLadder(Block block, World world, int x, int y, int z, EntityLivingBase entity) {
/* 321 */     if (!ForgeModContainer.fullBoundingBoxLadders)
/*     */     {
/* 323 */       return (block != null && block.isLadder((IBlockAccess)world, x, y, z, entity));
/*     */     }
/*     */ 
/*     */     
/* 327 */     AxisAlignedBB bb = entity.boundingBox;
/* 328 */     int mX = MathHelper.floor_double(bb.minX);
/* 329 */     int mY = MathHelper.floor_double(bb.minY);
/* 330 */     int mZ = MathHelper.floor_double(bb.minZ);
/* 331 */     for (int y2 = mY; y2 < bb.maxY; y2++) {
/*     */       
/* 333 */       for (int x2 = mX; x2 < bb.maxX; x2++) {
/*     */         
/* 335 */         for (int z2 = mZ; z2 < bb.maxZ; z2++) {
/*     */           
/* 337 */           block = world.getBlock(x2, y2, z2);
/* 338 */           if (block != null && block.isLadder((IBlockAccess)world, x2, y2, z2, entity))
/*     */           {
/* 340 */             return true;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 345 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void onLivingJump(EntityLivingBase entity) {
/* 351 */     MinecraftForge.EVENT_BUS.post((Event)new LivingEvent.LivingJumpEvent(entity));
/*     */   }
/*     */ 
/*     */   
/*     */   public static EntityItem onPlayerTossEvent(EntityPlayer player, ItemStack item, boolean includeName) {
/* 356 */     player.captureDrops = true;
/* 357 */     EntityItem ret = player.func_146097_a(item, false, includeName);
/* 358 */     player.capturedDrops.clear();
/* 359 */     player.captureDrops = false;
/*     */     
/* 361 */     if (ret == null)
/*     */     {
/* 363 */       return null;
/*     */     }
/*     */     
/* 366 */     ItemTossEvent event = new ItemTossEvent(ret, player);
/* 367 */     if (MinecraftForge.EVENT_BUS.post((Event)event))
/*     */     {
/* 369 */       return null;
/*     */     }
/*     */     
/* 372 */     player.joinEntityItemWithWorld(event.entityItem);
/* 373 */     return event.entityItem;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getEnchantPower(World world, int x, int y, int z) {
/* 378 */     return world.getBlock(x, y, z).getEnchantPowerBonus(world, x, y, z);
/*     */   }
/*     */ 
/*     */   
/*     */   public static ChatComponentTranslation onServerChatEvent(NetHandlerPlayServer net, String raw, ChatComponentTranslation comp) {
/* 383 */     ServerChatEvent event = new ServerChatEvent(net.playerEntity, raw, comp);
/* 384 */     if (MinecraftForge.EVENT_BUS.post((Event)event))
/*     */     {
/* 386 */       return null;
/*     */     }
/* 388 */     return event.component;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static IChatComponent newChatWithLinks(String string) {
/* 396 */     Pattern URL_PATTERN = Pattern.compile("((?:[a-z0-9]{2,}:\\/\\/)?(?:(?:[0-9]{1,3}\\.){3}[0-9]{1,3}|(?:[-\\w_\\.]{1,}\\.[a-z]{2,}?))(?::[0-9]{1,5})?.*?(?=[!\"§ \n]|$))", 2);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 401 */     ChatComponentText chatComponentText = new ChatComponentText("");
/* 402 */     Matcher matcher = URL_PATTERN.matcher(string);
/* 403 */     int lastEnd = 0;
/* 404 */     String remaining = string;
/*     */ 
/*     */     
/* 407 */     while (matcher.find()) {
/*     */       
/* 409 */       int start = matcher.start();
/* 410 */       int end = matcher.end();
/*     */ 
/*     */       
/* 413 */       chatComponentText.appendText(string.substring(lastEnd, start));
/* 414 */       lastEnd = end;
/* 415 */       String url = string.substring(start, end);
/* 416 */       ChatComponentText chatComponentText1 = new ChatComponentText(url);
/*     */ 
/*     */       
/* 419 */       if (URI.create(url).getScheme() == null)
/*     */       {
/* 421 */         url = "http://" + url;
/*     */       }
/*     */ 
/*     */       
/* 425 */       ClickEvent click = new ClickEvent(ClickEvent.Action.OPEN_URL, url);
/* 426 */       chatComponentText1.getChatStyle().setChatClickEvent(click);
/* 427 */       chatComponentText.appendSibling((IChatComponent)chatComponentText1);
/*     */     } 
/*     */ 
/*     */     
/* 431 */     chatComponentText.appendText(string.substring(lastEnd));
/* 432 */     return (IChatComponent)chatComponentText;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean canInteractWith(EntityPlayer player, Container openContainer) {
/* 437 */     PlayerOpenContainerEvent event = new PlayerOpenContainerEvent(player, openContainer);
/* 438 */     MinecraftForge.EVENT_BUS.post((Event)event);
/* 439 */     return (event.getResult() == Event.Result.DEFAULT) ? event.canInteractWith : ((event.getResult() == Event.Result.ALLOW));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static BlockEvent.BreakEvent onBlockBreakEvent(World world, WorldSettings.GameType gameType, EntityPlayerMP entityPlayer, int x, int y, int z) {
/* 445 */     boolean preCancelEvent = false;
/* 446 */     if (gameType.isAdventure() && !entityPlayer.isCurrentToolAdventureModeExempt(x, y, z)) {
/*     */       
/* 448 */       preCancelEvent = true;
/*     */     }
/* 450 */     else if (gameType.isCreative() && entityPlayer.getHeldItem() != null && entityPlayer.getHeldItem().getItem() instanceof net.minecraft.item.ItemSword) {
/*     */       
/* 452 */       preCancelEvent = true;
/*     */     } 
/*     */ 
/*     */     
/* 456 */     if (world.getTileEntity(x, y, z) == null) {
/*     */       
/* 458 */       S23PacketBlockChange packet = new S23PacketBlockChange(x, y, z, world);
/* 459 */       packet.field_148883_d = Blocks.air;
/* 460 */       packet.field_148884_e = 0;
/* 461 */       entityPlayer.playerNetServerHandler.sendPacket((Packet)packet);
/*     */     } 
/*     */ 
/*     */     
/* 465 */     Block block = world.getBlock(x, y, z);
/* 466 */     int blockMetadata = world.getBlockMetadata(x, y, z);
/* 467 */     BlockEvent.BreakEvent event = new BlockEvent.BreakEvent(x, y, z, world, block, blockMetadata, (EntityPlayer)entityPlayer);
/* 468 */     event.setCanceled(preCancelEvent);
/* 469 */     MinecraftForge.EVENT_BUS.post((Event)event);
/*     */ 
/*     */     
/* 472 */     if (event.isCanceled()) {
/*     */ 
/*     */       
/* 475 */       entityPlayer.playerNetServerHandler.sendPacket((Packet)new S23PacketBlockChange(x, y, z, world));
/*     */ 
/*     */       
/* 478 */       TileEntity tileentity = world.getTileEntity(x, y, z);
/* 479 */       if (tileentity != null) {
/*     */         
/* 481 */         Packet pkt = tileentity.getDescriptionPacket();
/* 482 */         if (pkt != null)
/*     */         {
/* 484 */           entityPlayer.playerNetServerHandler.sendPacket(pkt);
/*     */         }
/*     */       } 
/*     */     } 
/* 488 */     return event;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean onPlaceItemIntoWorld(ItemStack itemstack, EntityPlayer player, World world, int x, int y, int z, int side, float hitX, float hitY, float hitZ) {
/* 494 */     int meta = itemstack.getItemDamage();
/* 495 */     int size = itemstack.stackSize;
/* 496 */     NBTTagCompound nbt = null;
/* 497 */     if (itemstack.getTagCompound() != null)
/*     */     {
/* 499 */       nbt = (NBTTagCompound)itemstack.getTagCompound().copy();
/*     */     }
/*     */     
/* 502 */     if (!(itemstack.getItem() instanceof net.minecraft.item.ItemBucket))
/*     */     {
/* 504 */       world.captureBlockSnapshots = true;
/*     */     }
/*     */     
/* 507 */     boolean flag = itemstack.getItem().onItemUse(itemstack, player, world, x, y, z, side, hitX, hitY, hitZ);
/* 508 */     world.captureBlockSnapshots = false;
/*     */     
/* 510 */     if (flag) {
/*     */ 
/*     */       
/* 513 */       int newMeta = itemstack.getItemDamage();
/* 514 */       int newSize = itemstack.stackSize;
/* 515 */       NBTTagCompound newNBT = null;
/* 516 */       if (itemstack.getTagCompound() != null)
/*     */       {
/* 518 */         newNBT = (NBTTagCompound)itemstack.getTagCompound().copy();
/*     */       }
/* 520 */       BlockEvent.PlaceEvent placeEvent = null;
/* 521 */       List<BlockSnapshot> blockSnapshots = (List<BlockSnapshot>)world.capturedBlockSnapshots.clone();
/* 522 */       world.capturedBlockSnapshots.clear();
/*     */ 
/*     */       
/* 525 */       itemstack.setItemDamage(meta);
/* 526 */       itemstack.stackSize = size;
/* 527 */       if (nbt != null)
/*     */       {
/* 529 */         itemstack.setTagCompound(nbt);
/*     */       }
/* 531 */       if (blockSnapshots.size() > 1) {
/*     */         
/* 533 */         BlockEvent.MultiPlaceEvent multiPlaceEvent = ForgeEventFactory.onPlayerMultiBlockPlace(player, blockSnapshots, ForgeDirection.getOrientation(side));
/*     */       }
/* 535 */       else if (blockSnapshots.size() == 1) {
/*     */         
/* 537 */         placeEvent = ForgeEventFactory.onPlayerBlockPlace(player, blockSnapshots.get(0), ForgeDirection.getOrientation(side));
/*     */       } 
/*     */       
/* 540 */       if (placeEvent != null && placeEvent.isCanceled()) {
/*     */         
/* 542 */         flag = false;
/*     */         
/* 544 */         for (BlockSnapshot blocksnapshot : blockSnapshots)
/*     */         {
/* 546 */           world.restoringBlockSnapshots = true;
/* 547 */           blocksnapshot.restore(true, false);
/* 548 */           world.restoringBlockSnapshots = false;
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 554 */         itemstack.setItemDamage(newMeta);
/* 555 */         itemstack.stackSize = newSize;
/* 556 */         if (nbt != null)
/*     */         {
/* 558 */           itemstack.setTagCompound(newNBT);
/*     */         }
/*     */         
/* 561 */         for (BlockSnapshot blocksnapshot : blockSnapshots) {
/*     */           
/* 563 */           int blockX = blocksnapshot.x;
/* 564 */           int blockY = blocksnapshot.y;
/* 565 */           int blockZ = blocksnapshot.z;
/* 566 */           int metadata = world.getBlockMetadata(blockX, blockY, blockZ);
/* 567 */           int updateFlag = blocksnapshot.flag;
/* 568 */           Block oldBlock = blocksnapshot.replacedBlock;
/* 569 */           Block newBlock = world.getBlock(blockX, blockY, blockZ);
/* 570 */           if (newBlock != null && !newBlock.hasTileEntity(metadata))
/*     */           {
/* 572 */             newBlock.onBlockAdded(world, blockX, blockY, blockZ);
/*     */           }
/*     */           
/* 575 */           world.markAndNotifyBlock(blockX, blockY, blockZ, null, oldBlock, newBlock, updateFlag);
/*     */         } 
/* 577 */         player.addStat(StatList.objectUseStats[Item.getIdFromItem(itemstack.getItem())], 1);
/*     */       } 
/*     */     } 
/* 580 */     world.capturedBlockSnapshots.clear();
/*     */     
/* 582 */     return flag;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean onAnvilChange(ContainerRepair container, ItemStack left, ItemStack right, IInventory outputSlot, String name, int baseCost) {
/* 587 */     AnvilUpdateEvent e = new AnvilUpdateEvent(left, right, name, baseCost);
/* 588 */     if (MinecraftForge.EVENT_BUS.post((Event)e)) return false; 
/* 589 */     if (e.output == null) return true;
/*     */     
/* 591 */     outputSlot.setInventorySlotContents(0, e.output);
/* 592 */     container.maximumCost = e.cost;
/* 593 */     container.stackSizeToBeUsedInRepair = e.materialCost;
/* 594 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float onAnvilRepair(EntityPlayer player, ItemStack output, ItemStack left, ItemStack right) {
/* 599 */     AnvilRepairEvent e = new AnvilRepairEvent(player, left, right, output);
/* 600 */     MinecraftForge.EVENT_BUS.post((Event)e);
/* 601 */     return e.breakChance;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean onNoteChange(TileEntityNote te, byte old) {
/* 606 */     NoteBlockEvent.Change e = new NoteBlockEvent.Change(te.getWorldObj(), te.xCoord, te.yCoord, te.zCoord, te.getBlockMetadata(), old, te.note);
/* 607 */     if (MinecraftForge.EVENT_BUS.post((Event)e)) {
/*     */       
/* 609 */       te.note = old;
/* 610 */       return false;
/*     */     } 
/* 612 */     te.note = (byte)e.getVanillaNoteId();
/* 613 */     return true;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\ForgeHooks.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */