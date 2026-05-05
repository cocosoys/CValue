/*      */ package net.minecraftforge.common;
/*      */ 
/*      */ import com.google.common.cache.Cache;
/*      */ import com.google.common.cache.CacheBuilder;
/*      */ import com.google.common.collect.ArrayListMultimap;
/*      */ import com.google.common.collect.BiMap;
/*      */ import com.google.common.collect.HashBiMap;
/*      */ import com.google.common.collect.HashMultimap;
/*      */ import com.google.common.collect.ImmutableList;
/*      */ import com.google.common.collect.ImmutableListMultimap;
/*      */ import com.google.common.collect.ImmutableSet;
/*      */ import com.google.common.collect.ImmutableSetMultimap;
/*      */ import com.google.common.collect.LinkedHashMultimap;
/*      */ import com.google.common.collect.ListMultimap;
/*      */ import com.google.common.collect.MapMaker;
/*      */ import com.google.common.collect.Maps;
/*      */ import com.google.common.collect.Multimap;
/*      */ import com.google.common.collect.SetMultimap;
/*      */ import com.google.common.collect.Sets;
/*      */ import com.google.common.collect.UnmodifiableIterator;
/*      */ import cpw.mods.fml.common.FMLLog;
/*      */ import cpw.mods.fml.common.Loader;
/*      */ import cpw.mods.fml.common.ModContainer;
/*      */ import cpw.mods.fml.common.eventhandler.Event;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.LinkedHashSet;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.UUID;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.nbt.CompressedStreamTools;
/*      */ import net.minecraft.nbt.NBTBase;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.nbt.NBTTagList;
/*      */ import net.minecraft.server.MinecraftServer;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.world.ChunkCoordIntPair;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraft.world.WorldServer;
/*      */ import net.minecraft.world.chunk.Chunk;
/*      */ import net.minecraftforge.common.config.ConfigCategory;
/*      */ import net.minecraftforge.common.config.Configuration;
/*      */ import net.minecraftforge.common.config.Property;
/*      */ import org.apache.logging.log4j.Level;
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
/*      */ public class ForgeChunkManager
/*      */ {
/*      */   private static int defaultMaxCount;
/*      */   private static int defaultMaxChunks;
/*      */   private static boolean overridesEnabled;
/*   79 */   private static Map<World, Multimap<String, Ticket>> tickets = (new MapMaker()).weakKeys().makeMap();
/*   80 */   private static Map<String, Integer> ticketConstraints = Maps.newHashMap();
/*   81 */   private static Map<String, Integer> chunkConstraints = Maps.newHashMap();
/*      */   
/*   83 */   private static SetMultimap<String, Ticket> playerTickets = (SetMultimap<String, Ticket>)HashMultimap.create();
/*      */   
/*   85 */   private static Map<String, LoadingCallback> callbacks = Maps.newHashMap();
/*      */   
/*   87 */   private static Map<World, ImmutableSetMultimap<ChunkCoordIntPair, Ticket>> forcedChunks = (new MapMaker()).weakKeys().makeMap();
/*   88 */   private static BiMap<UUID, Ticket> pendingEntities = (BiMap<UUID, Ticket>)HashBiMap.create();
/*      */   
/*   90 */   private static Map<World, Cache<Long, Chunk>> dormantChunkCache = (new MapMaker()).weakKeys().makeMap();
/*      */   
/*      */   private static File cfgFile;
/*      */   
/*      */   private static Configuration config;
/*      */   private static int playerTicketLength;
/*      */   private static int dormantChunkCacheSize;
/*   97 */   public static final List<String> MOD_PROP_ORDER = new ArrayList<String>(2);
/*      */   
/*   99 */   private static Set<String> warnedMods = Sets.newHashSet();
/*      */ 
/*      */   
/*      */   static {
/*  103 */     MOD_PROP_ORDER.add("maximumTicketCount");
/*  104 */     MOD_PROP_ORDER.add("maximumChunksPerTicket");
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
/*      */ 
/*      */   
/*      */   public static interface LoadingCallback
/*      */   {
/*      */     void ticketsLoaded(List<ForgeChunkManager.Ticket> param1List, World param1World);
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
/*      */ 
/*      */   
/*      */   public static interface OrderedLoadingCallback
/*      */     extends LoadingCallback
/*      */   {
/*      */     List<ForgeChunkManager.Ticket> ticketsLoaded(List<ForgeChunkManager.Ticket> param1List, World param1World, int param1Int);
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
/*      */   
/*      */   public static interface PlayerOrderedLoadingCallback
/*      */     extends LoadingCallback
/*      */   {
/*      */     ListMultimap<String, ForgeChunkManager.Ticket> playerTicketsLoaded(ListMultimap<String, ForgeChunkManager.Ticket> param1ListMultimap, World param1World);
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
/*      */   
/*      */   public enum Type
/*      */   {
/*  184 */     NORMAL,
/*      */ 
/*      */ 
/*      */     
/*  188 */     ENTITY;
/*      */   }
/*      */ 
/*      */   
/*      */   public static class Ticket
/*      */   {
/*      */     private String modId;
/*      */     private ForgeChunkManager.Type ticketType;
/*      */     private LinkedHashSet<ChunkCoordIntPair> requestedChunks;
/*      */     private NBTTagCompound modData;
/*      */     public final World world;
/*      */     private int maxDepth;
/*      */     private int entityChunkX;
/*      */     private int entityChunkZ;
/*      */     private Entity entity;
/*      */     private String player;
/*      */     
/*      */     Ticket(String modId, ForgeChunkManager.Type type, World world) {
/*  206 */       this.modId = modId;
/*  207 */       this.ticketType = type;
/*  208 */       this.world = world;
/*  209 */       this.maxDepth = ForgeChunkManager.getMaxChunkDepthFor(modId);
/*  210 */       this.requestedChunks = Sets.newLinkedHashSet();
/*      */     }
/*      */ 
/*      */     
/*      */     Ticket(String modId, ForgeChunkManager.Type type, World world, String player) {
/*  215 */       this(modId, type, world);
/*  216 */       if (player != null) {
/*      */         
/*  218 */         this.player = player;
/*      */       }
/*      */       else {
/*      */         
/*  222 */         FMLLog.log(Level.ERROR, "Attempt to create a player ticket without a valid player", new Object[0]);
/*  223 */         throw new RuntimeException();
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void setChunkListDepth(int depth) {
/*  234 */       if (depth > ForgeChunkManager.getMaxChunkDepthFor(this.modId) || (depth <= 0 && ForgeChunkManager.getMaxChunkDepthFor(this.modId) > 0)) {
/*      */         
/*  236 */         FMLLog.warning("The mod %s tried to modify the chunk ticket depth to: %d, its allowed maximum is: %d", new Object[] { this.modId, Integer.valueOf(depth), Integer.valueOf(ForgeChunkManager.getMaxChunkDepthFor(this.modId)) });
/*      */       }
/*      */       else {
/*      */         
/*  240 */         this.maxDepth = depth;
/*      */       } 
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
/*      */     public int getChunkListDepth() {
/*  253 */       return this.maxDepth;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int getMaxChunkListDepth() {
/*  263 */       return ForgeChunkManager.getMaxChunkDepthFor(this.modId);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void bindEntity(Entity entity) {
/*  273 */       if (this.ticketType != ForgeChunkManager.Type.ENTITY)
/*      */       {
/*  275 */         throw new RuntimeException("Cannot bind an entity to a non-entity ticket");
/*      */       }
/*  277 */       this.entity = entity;
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
/*      */     
/*      */     public NBTTagCompound getModData() {
/*  290 */       if (this.modData == null)
/*      */       {
/*  292 */         this.modData = new NBTTagCompound();
/*      */       }
/*  294 */       return this.modData;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Entity getEntity() {
/*  303 */       return this.entity;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean isPlayerTicket() {
/*  311 */       return (this.player != null);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getPlayerName() {
/*  319 */       return this.player;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String getModId() {
/*  327 */       return this.modId;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ForgeChunkManager.Type getType() {
/*  335 */       return this.ticketType;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public ImmutableSet<ChunkCoordIntPair> getChunkList() {
/*  343 */       return ImmutableSet.copyOf(this.requestedChunks);
/*      */     }
/*      */   }
/*      */   
/*      */   public static class ForceChunkEvent
/*      */     extends Event {
/*      */     public final ForgeChunkManager.Ticket ticket;
/*      */     public final ChunkCoordIntPair location;
/*      */     
/*      */     public ForceChunkEvent(ForgeChunkManager.Ticket ticket, ChunkCoordIntPair location) {
/*  353 */       this.ticket = ticket;
/*  354 */       this.location = location;
/*      */     }
/*      */   }
/*      */   
/*      */   public static class UnforceChunkEvent
/*      */     extends Event {
/*      */     public final ForgeChunkManager.Ticket ticket;
/*      */     public final ChunkCoordIntPair location;
/*      */     
/*      */     public UnforceChunkEvent(ForgeChunkManager.Ticket ticket, ChunkCoordIntPair location) {
/*  364 */       this.ticket = ticket;
/*  365 */       this.location = location;
/*      */     }
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
/*      */   public static boolean savedWorldHasForcedChunkTickets(File chunkDir) {
/*  380 */     File chunkLoaderData = new File(chunkDir, "forcedchunks.dat");
/*      */     
/*  382 */     if (chunkLoaderData.exists() && chunkLoaderData.isFile()) {
/*      */       
/*      */       try {
/*      */ 
/*      */         
/*  387 */         NBTTagCompound forcedChunkData = CompressedStreamTools.read(chunkLoaderData);
/*  388 */         return (forcedChunkData.getTagList("TicketList", 10).tagCount() > 0);
/*      */       }
/*  390 */       catch (IOException iOException) {}
/*      */     }
/*      */ 
/*      */     
/*  394 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   static void loadWorld(World world) {
/*  399 */     ArrayListMultimap<String, Ticket> newTickets = ArrayListMultimap.create();
/*  400 */     ForgeChunkManager.tickets.put(world, newTickets);
/*      */     
/*  402 */     forcedChunks.put(world, ImmutableSetMultimap.of());
/*      */     
/*  404 */     if (!(world instanceof WorldServer)) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  409 */     dormantChunkCache.put(world, CacheBuilder.newBuilder().maximumSize(dormantChunkCacheSize).build());
/*  410 */     WorldServer worldServer = (WorldServer)world;
/*  411 */     File chunkDir = worldServer.getChunkSaveLocation();
/*  412 */     File chunkLoaderData = new File(chunkDir, "forcedchunks.dat");
/*      */     
/*  414 */     if (chunkLoaderData.exists() && chunkLoaderData.isFile()) {
/*      */       NBTTagCompound forcedChunkData;
/*  416 */       ArrayListMultimap<String, Ticket> loadedTickets = ArrayListMultimap.create();
/*  417 */       Map<String, ListMultimap<String, Ticket>> playerLoadedTickets = Maps.newHashMap();
/*      */ 
/*      */       
/*      */       try {
/*  421 */         forcedChunkData = CompressedStreamTools.read(chunkLoaderData);
/*      */       }
/*  423 */       catch (IOException e) {
/*      */         
/*  425 */         FMLLog.log(Level.WARN, e, "Unable to read forced chunk data at %s - it will be ignored", new Object[] { chunkLoaderData.getAbsolutePath() });
/*      */         return;
/*      */       } 
/*  428 */       NBTTagList ticketList = forcedChunkData.getTagList("TicketList", 10);
/*  429 */       for (int i = 0; i < ticketList.tagCount(); i++) {
/*      */         
/*  431 */         NBTTagCompound ticketHolder = ticketList.getCompoundTagAt(i);
/*  432 */         String modId = ticketHolder.getString("Owner");
/*  433 */         boolean isPlayer = "Forge".equals(modId);
/*      */         
/*  435 */         if (!isPlayer && !Loader.isModLoaded(modId)) {
/*      */           
/*  437 */           FMLLog.warning("Found chunkloading data for mod %s which is currently not available or active - it will be removed from the world save", new Object[] { modId });
/*      */ 
/*      */         
/*      */         }
/*  441 */         else if (!isPlayer && !callbacks.containsKey(modId)) {
/*      */           
/*  443 */           FMLLog.warning("The mod %s has registered persistent chunkloading data but doesn't seem to want to be called back with it - it will be removed from the world save", new Object[] { modId });
/*      */         }
/*      */         else {
/*      */           
/*  447 */           NBTTagList tickets = ticketHolder.getTagList("Tickets", 10);
/*  448 */           for (int j = 0; j < tickets.tagCount(); j++) {
/*      */             
/*  450 */             NBTTagCompound ticket = tickets.getCompoundTagAt(j);
/*  451 */             modId = ticket.hasKey("ModId") ? ticket.getString("ModId") : modId;
/*  452 */             Type type = Type.values()[ticket.getByte("Type")];
/*      */             
/*  454 */             Ticket tick = new Ticket(modId, type, world);
/*  455 */             if (ticket.hasKey("ModData"))
/*      */             {
/*  457 */               tick.modData = ticket.getCompoundTag("ModData");
/*      */             }
/*  459 */             if (ticket.hasKey("Player")) {
/*      */               
/*  461 */               tick.player = ticket.getString("Player");
/*  462 */               if (!playerLoadedTickets.containsKey(tick.modId))
/*      */               {
/*  464 */                 playerLoadedTickets.put(modId, ArrayListMultimap.create());
/*      */               }
/*  466 */               ((ListMultimap)playerLoadedTickets.get(tick.modId)).put(tick.player, tick);
/*      */             }
/*      */             else {
/*      */               
/*  470 */               loadedTickets.put(modId, tick);
/*      */             } 
/*  472 */             if (type == Type.ENTITY) {
/*      */               
/*  474 */               tick.entityChunkX = ticket.getInteger("chunkX");
/*  475 */               tick.entityChunkZ = ticket.getInteger("chunkZ");
/*  476 */               UUID uuid = new UUID(ticket.getLong("PersistentIDMSB"), ticket.getLong("PersistentIDLSB"));
/*      */               
/*  478 */               pendingEntities.put(uuid, tick);
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       }  UnmodifiableIterator<Ticket> unmodifiableIterator;
/*  483 */       for (unmodifiableIterator = ImmutableSet.copyOf(pendingEntities.values()).iterator(); unmodifiableIterator.hasNext(); ) { Ticket tick = unmodifiableIterator.next();
/*      */         
/*  485 */         if (tick.ticketType == Type.ENTITY && tick.entity == null)
/*      */         {
/*      */ 
/*      */ 
/*      */           
/*  490 */           world.getChunkFromChunkCoords(tick.entityChunkX, tick.entityChunkZ);
/*      */         } }
/*      */       
/*  493 */       for (unmodifiableIterator = ImmutableSet.copyOf(pendingEntities.values()).iterator(); unmodifiableIterator.hasNext(); ) { Ticket tick = unmodifiableIterator.next();
/*      */         
/*  495 */         if (tick.ticketType == Type.ENTITY && tick.entity == null) {
/*      */           
/*  497 */           FMLLog.warning("Failed to load persistent chunkloading entity %s from store.", new Object[] { pendingEntities.inverse().get(tick) });
/*  498 */           loadedTickets.remove(tick.modId, tick);
/*      */         }  }
/*      */       
/*  501 */       pendingEntities.clear();
/*      */       
/*  503 */       for (String modId : loadedTickets.keySet()) {
/*      */         
/*  505 */         LoadingCallback loadingCallback = callbacks.get(modId);
/*  506 */         if (loadingCallback == null) {
/*      */           continue;
/*      */         }
/*      */         
/*  510 */         int maxTicketLength = getMaxTicketLengthFor(modId);
/*  511 */         List<Ticket> tickets = loadedTickets.get(modId);
/*  512 */         if (loadingCallback instanceof OrderedLoadingCallback) {
/*      */           
/*  514 */           OrderedLoadingCallback orderedLoadingCallback = (OrderedLoadingCallback)loadingCallback;
/*  515 */           tickets = orderedLoadingCallback.ticketsLoaded((List<Ticket>)ImmutableList.copyOf(tickets), world, maxTicketLength);
/*      */         } 
/*  517 */         if (tickets.size() > maxTicketLength) {
/*      */           
/*  519 */           FMLLog.warning("The mod %s has too many open chunkloading tickets %d. Excess will be dropped", new Object[] { modId, Integer.valueOf(tickets.size()) });
/*  520 */           tickets.subList(maxTicketLength, tickets.size()).clear();
/*      */         } 
/*  522 */         ((Multimap)ForgeChunkManager.tickets.get(world)).putAll(modId, tickets);
/*  523 */         loadingCallback.ticketsLoaded((List<Ticket>)ImmutableList.copyOf(tickets), world);
/*      */       } 
/*  525 */       for (String modId : playerLoadedTickets.keySet()) {
/*      */         
/*  527 */         LoadingCallback loadingCallback = callbacks.get(modId);
/*  528 */         if (loadingCallback == null) {
/*      */           continue;
/*      */         }
/*      */         
/*  532 */         ListMultimap<String, Ticket> tickets = playerLoadedTickets.get(modId);
/*  533 */         if (loadingCallback instanceof PlayerOrderedLoadingCallback) {
/*      */           
/*  535 */           PlayerOrderedLoadingCallback orderedLoadingCallback = (PlayerOrderedLoadingCallback)loadingCallback;
/*  536 */           tickets = orderedLoadingCallback.playerTicketsLoaded((ListMultimap<String, Ticket>)ImmutableListMultimap.copyOf((Multimap)tickets), world);
/*  537 */           playerTickets.putAll((Multimap)tickets);
/*      */         } 
/*  539 */         ((Multimap)ForgeChunkManager.tickets.get(world)).putAll("Forge", tickets.values());
/*  540 */         loadingCallback.ticketsLoaded((List<Ticket>)ImmutableList.copyOf(tickets.values()), world);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static void unloadWorld(World world) {
/*  548 */     if (!(world instanceof WorldServer)) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  553 */     forcedChunks.remove(world);
/*  554 */     dormantChunkCache.remove(world);
/*      */     
/*  556 */     if (!MinecraftServer.getServer().isServerRunning()) {
/*      */       
/*  558 */       playerTickets.clear();
/*  559 */       tickets.clear();
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setForcedChunkLoadingCallback(Object mod, LoadingCallback callback) {
/*  571 */     ModContainer container = getContainer(mod);
/*  572 */     if (container == null) {
/*      */       
/*  574 */       FMLLog.warning("Unable to register a callback for an unknown mod %s (%s : %x)", new Object[] { mod, mod.getClass().getName(), Integer.valueOf(System.identityHashCode(mod)) });
/*      */       
/*      */       return;
/*      */     } 
/*  578 */     callbacks.put(container.getModId(), callback);
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
/*      */   public static int ticketCountAvailableFor(Object mod, World world) {
/*  590 */     ModContainer container = getContainer(mod);
/*  591 */     if (container != null) {
/*      */       
/*  593 */       String modId = container.getModId();
/*  594 */       int allowedCount = getMaxTicketLengthFor(modId);
/*  595 */       return allowedCount - ((Multimap)tickets.get(world)).get(modId).size();
/*      */     } 
/*      */ 
/*      */     
/*  599 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static ModContainer getContainer(Object mod) {
/*  605 */     ModContainer container = (ModContainer)Loader.instance().getModObjectList().inverse().get(mod);
/*  606 */     return container;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getMaxTicketLengthFor(String modId) {
/*  611 */     int allowedCount = (ticketConstraints.containsKey(modId) && overridesEnabled) ? ((Integer)ticketConstraints.get(modId)).intValue() : defaultMaxCount;
/*  612 */     return allowedCount;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int getMaxChunkDepthFor(String modId) {
/*  617 */     int allowedCount = (chunkConstraints.containsKey(modId) && overridesEnabled) ? ((Integer)chunkConstraints.get(modId)).intValue() : defaultMaxChunks;
/*  618 */     return allowedCount;
/*      */   }
/*      */ 
/*      */   
/*      */   public static int ticketCountAvailableFor(String username) {
/*  623 */     return playerTicketLength - playerTickets.get(username).size();
/*      */   }
/*      */ 
/*      */   
/*      */   public static Ticket requestPlayerTicket(Object mod, String player, World world, Type type) {
/*  628 */     ModContainer mc = getContainer(mod);
/*  629 */     if (mc == null) {
/*      */       
/*  631 */       FMLLog.log(Level.ERROR, "Failed to locate the container for mod instance %s (%s : %x)", new Object[] { mod, mod.getClass().getName(), Integer.valueOf(System.identityHashCode(mod)) });
/*  632 */       return null;
/*      */     } 
/*  634 */     if (playerTickets.get(player).size() > playerTicketLength) {
/*      */       
/*  636 */       FMLLog.warning("Unable to assign further chunkloading tickets to player %s (on behalf of mod %s)", new Object[] { player, mc.getModId() });
/*  637 */       return null;
/*      */     } 
/*  639 */     Ticket ticket = new Ticket(mc.getModId(), type, world, player);
/*  640 */     playerTickets.put(player, ticket);
/*  641 */     ((Multimap)tickets.get(world)).put("Forge", ticket);
/*  642 */     return ticket;
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
/*      */   public static Ticket requestTicket(Object mod, World world, Type type) {
/*  654 */     ModContainer container = getContainer(mod);
/*  655 */     if (container == null) {
/*      */       
/*  657 */       FMLLog.log(Level.ERROR, "Failed to locate the container for mod instance %s (%s : %x)", new Object[] { mod, mod.getClass().getName(), Integer.valueOf(System.identityHashCode(mod)) });
/*  658 */       return null;
/*      */     } 
/*  660 */     String modId = container.getModId();
/*  661 */     if (!callbacks.containsKey(modId)) {
/*      */       
/*  663 */       FMLLog.severe("The mod %s has attempted to request a ticket without a listener in place", new Object[] { modId });
/*  664 */       throw new RuntimeException("Invalid ticket request");
/*      */     } 
/*      */     
/*  667 */     int allowedCount = getMaxTicketLengthFor(modId);
/*      */     
/*  669 */     if (((Multimap)tickets.get(world)).get(modId).size() >= allowedCount) {
/*      */       
/*  671 */       if (!warnedMods.contains(modId)) {
/*      */         
/*  673 */         FMLLog.info("The mod %s has attempted to allocate a chunkloading ticket beyond it's currently allocated maximum : %d", new Object[] { modId, Integer.valueOf(allowedCount) });
/*  674 */         warnedMods.add(modId);
/*      */       } 
/*  676 */       return null;
/*      */     } 
/*  678 */     Ticket ticket = new Ticket(modId, type, world);
/*  679 */     ((Multimap)tickets.get(world)).put(modId, ticket);
/*      */     
/*  681 */     return ticket;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void releaseTicket(Ticket ticket) {
/*  691 */     if (ticket == null) {
/*      */       return;
/*      */     }
/*      */     
/*  695 */     if (ticket.isPlayerTicket() ? !playerTickets.containsValue(ticket) : !((Multimap)tickets.get(ticket.world)).containsEntry(ticket.modId, ticket)) {
/*      */       return;
/*      */     }
/*      */     
/*  699 */     if (ticket.requestedChunks != null)
/*      */     {
/*  701 */       for (UnmodifiableIterator<ChunkCoordIntPair> unmodifiableIterator = ImmutableSet.copyOf(ticket.requestedChunks).iterator(); unmodifiableIterator.hasNext(); ) { ChunkCoordIntPair chunk = unmodifiableIterator.next();
/*      */         
/*  703 */         unforceChunk(ticket, chunk); }
/*      */     
/*      */     }
/*  706 */     if (ticket.isPlayerTicket()) {
/*      */       
/*  708 */       playerTickets.remove(ticket.player, ticket);
/*  709 */       ((Multimap)tickets.get(ticket.world)).remove("Forge", ticket);
/*      */     }
/*      */     else {
/*      */       
/*  713 */       ((Multimap)tickets.get(ticket.world)).remove(ticket.modId, ticket);
/*      */     } 
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
/*      */   public static void forceChunk(Ticket ticket, ChunkCoordIntPair chunk) {
/*  727 */     if (ticket == null || chunk == null) {
/*      */       return;
/*      */     }
/*      */     
/*  731 */     if (ticket.ticketType == Type.ENTITY && ticket.entity == null)
/*      */     {
/*  733 */       throw new RuntimeException("Attempted to use an entity ticket to force a chunk, without an entity");
/*      */     }
/*  735 */     if (ticket.isPlayerTicket() ? !playerTickets.containsValue(ticket) : !((Multimap)tickets.get(ticket.world)).containsEntry(ticket.modId, ticket)) {
/*      */       
/*  737 */       FMLLog.severe("The mod %s attempted to force load a chunk with an invalid ticket. This is not permitted.", new Object[] { Ticket.access$200(ticket) });
/*      */       return;
/*      */     } 
/*  740 */     ticket.requestedChunks.add(chunk);
/*  741 */     MinecraftForge.EVENT_BUS.post(new ForceChunkEvent(ticket, chunk));
/*      */     
/*  743 */     ImmutableSetMultimap<ChunkCoordIntPair, Ticket> newMap = ImmutableSetMultimap.builder().putAll((Multimap)forcedChunks.get(ticket.world)).put(chunk, ticket).build();
/*  744 */     forcedChunks.put(ticket.world, newMap);
/*  745 */     if (ticket.maxDepth > 0 && ticket.requestedChunks.size() > ticket.maxDepth) {
/*      */       
/*  747 */       ChunkCoordIntPair removed = ticket.requestedChunks.iterator().next();
/*  748 */       unforceChunk(ticket, removed);
/*      */     } 
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
/*      */   public static void reorderChunk(Ticket ticket, ChunkCoordIntPair chunk) {
/*  762 */     if (ticket == null || chunk == null || !ticket.requestedChunks.contains(chunk)) {
/*      */       return;
/*      */     }
/*      */     
/*  766 */     ticket.requestedChunks.remove(chunk);
/*  767 */     ticket.requestedChunks.add(chunk);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void unforceChunk(Ticket ticket, ChunkCoordIntPair chunk) {
/*  777 */     if (ticket == null || chunk == null) {
/*      */       return;
/*      */     }
/*      */     
/*  781 */     ticket.requestedChunks.remove(chunk);
/*  782 */     MinecraftForge.EVENT_BUS.post(new UnforceChunkEvent(ticket, chunk));
/*  783 */     LinkedHashMultimap<ChunkCoordIntPair, Ticket> copy = LinkedHashMultimap.create((Multimap)forcedChunks.get(ticket.world));
/*  784 */     copy.remove(chunk, ticket);
/*  785 */     ImmutableSetMultimap<ChunkCoordIntPair, Ticket> newMap = ImmutableSetMultimap.copyOf((Multimap)copy);
/*  786 */     forcedChunks.put(ticket.world, newMap);
/*      */   }
/*      */ 
/*      */   
/*      */   static void loadConfiguration() {
/*  791 */     ticketConstraints.clear();
/*  792 */     chunkConstraints.clear();
/*  793 */     for (String mod : config.getCategoryNames()) {
/*      */       
/*  795 */       if (mod.equals("Forge") || mod.equals("defaults")) {
/*      */         continue;
/*      */       }
/*      */       
/*  799 */       Property modTC = config.get(mod, "maximumTicketCount", 200);
/*  800 */       Property modCPT = config.get(mod, "maximumChunksPerTicket", 25);
/*  801 */       ticketConstraints.put(mod, Integer.valueOf(modTC.getInt(200)));
/*  802 */       chunkConstraints.put(mod, Integer.valueOf(modCPT.getInt(25)));
/*      */     } 
/*  804 */     if (config.hasChanged())
/*      */     {
/*  806 */       config.save();
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static ImmutableSetMultimap<ChunkCoordIntPair, Ticket> getPersistentChunksFor(World world) {
/*  817 */     return forcedChunks.containsKey(world) ? forcedChunks.get(world) : ImmutableSetMultimap.of();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   static void saveWorld(World world) {
/*  823 */     if (!(world instanceof WorldServer)) {
/*      */       return;
/*      */     }
/*      */     
/*  827 */     WorldServer worldServer = (WorldServer)world;
/*  828 */     File chunkDir = worldServer.getChunkSaveLocation();
/*  829 */     File chunkLoaderData = new File(chunkDir, "forcedchunks.dat");
/*      */     
/*  831 */     NBTTagCompound forcedChunkData = new NBTTagCompound();
/*  832 */     NBTTagList ticketList = new NBTTagList();
/*  833 */     forcedChunkData.setTag("TicketList", (NBTBase)ticketList);
/*      */     
/*  835 */     Multimap<String, Ticket> ticketSet = ForgeChunkManager.tickets.get(worldServer);
/*  836 */     if (ticketSet == null)
/*  837 */       return;  for (String modId : ticketSet.keySet()) {
/*      */       
/*  839 */       NBTTagCompound ticketHolder = new NBTTagCompound();
/*  840 */       ticketList.appendTag((NBTBase)ticketHolder);
/*      */       
/*  842 */       ticketHolder.setString("Owner", modId);
/*  843 */       NBTTagList tickets = new NBTTagList();
/*  844 */       ticketHolder.setTag("Tickets", (NBTBase)tickets);
/*      */       
/*  846 */       for (Ticket tick : ticketSet.get(modId)) {
/*      */         
/*  848 */         NBTTagCompound ticket = new NBTTagCompound();
/*  849 */         ticket.setByte("Type", (byte)tick.ticketType.ordinal());
/*  850 */         ticket.setByte("ChunkListDepth", (byte)tick.maxDepth);
/*  851 */         if (tick.isPlayerTicket()) {
/*      */           
/*  853 */           ticket.setString("ModId", tick.modId);
/*  854 */           ticket.setString("Player", tick.player);
/*      */         } 
/*  856 */         if (tick.modData != null)
/*      */         {
/*  858 */           ticket.setTag("ModData", (NBTBase)tick.modData);
/*      */         }
/*  860 */         if (tick.ticketType == Type.ENTITY && tick.entity != null && tick.entity.writeToNBTOptional(new NBTTagCompound())) {
/*      */           
/*  862 */           ticket.setInteger("chunkX", MathHelper.floor_double(tick.entity.chunkCoordX));
/*  863 */           ticket.setInteger("chunkZ", MathHelper.floor_double(tick.entity.chunkCoordZ));
/*  864 */           ticket.setLong("PersistentIDMSB", tick.entity.getPersistentID().getMostSignificantBits());
/*  865 */           ticket.setLong("PersistentIDLSB", tick.entity.getPersistentID().getLeastSignificantBits());
/*  866 */           tickets.appendTag((NBTBase)ticket); continue;
/*      */         } 
/*  868 */         if (tick.ticketType != Type.ENTITY)
/*      */         {
/*  870 */           tickets.appendTag((NBTBase)ticket);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/*      */     try {
/*  876 */       CompressedStreamTools.write(forcedChunkData, chunkLoaderData);
/*      */     }
/*  878 */     catch (IOException e) {
/*      */       
/*  880 */       FMLLog.log(Level.WARN, e, "Unable to write forced chunk data to %s - chunkloading won't work", new Object[] { chunkLoaderData.getAbsolutePath() });
/*      */       return;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   static void loadEntity(Entity entity) {
/*  887 */     UUID id = entity.getPersistentID();
/*  888 */     Ticket tick = (Ticket)pendingEntities.get(id);
/*  889 */     if (tick != null) {
/*      */       
/*  891 */       tick.bindEntity(entity);
/*  892 */       pendingEntities.remove(id);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void putDormantChunk(long coords, Chunk chunk) {
/*  898 */     Cache<Long, Chunk> cache = dormantChunkCache.get(chunk.worldObj);
/*  899 */     if (cache != null)
/*      */     {
/*  901 */       cache.put(Long.valueOf(coords), chunk);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public static Chunk fetchDormantChunk(long coords, World world) {
/*  908 */     Cache<Long, Chunk> cache = dormantChunkCache.get(world);
/*  909 */     if (cache == null)
/*      */     {
/*  911 */       return null;
/*      */     }
/*  913 */     Chunk chunk = (Chunk)cache.getIfPresent(Long.valueOf(coords));
/*  914 */     if (chunk != null)
/*      */     {
/*  916 */       for (List<Entity> eList : chunk.entityLists) {
/*      */         
/*  918 */         for (Entity e : eList)
/*      */         {
/*  920 */           e.resetEntityId();
/*      */         }
/*      */       } 
/*      */     }
/*  924 */     return chunk;
/*      */   }
/*      */ 
/*      */   
/*      */   static void captureConfig(File configDir) {
/*  929 */     cfgFile = new File(configDir, "forgeChunkLoading.cfg");
/*  930 */     config = new Configuration(cfgFile, true);
/*      */     
/*      */     try {
/*  933 */       config.load();
/*      */     }
/*  935 */     catch (Exception e) {
/*      */       
/*  937 */       File dest = new File(cfgFile.getParentFile(), "forgeChunkLoading.cfg.bak");
/*  938 */       if (dest.exists())
/*      */       {
/*  940 */         dest.delete();
/*      */       }
/*  942 */       cfgFile.renameTo(dest);
/*  943 */       FMLLog.log(Level.ERROR, e, "A critical error occured reading the forgeChunkLoading.cfg file, defaults will be used - the invalid file is backed up at forgeChunkLoading.cfg.bak", new Object[0]);
/*      */     } 
/*  945 */     syncConfigDefaults();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void syncConfigDefaults() {
/*  955 */     List<String> propOrder = new ArrayList<String>();
/*      */     
/*  957 */     config.setCategoryComment("defaults", "Default configuration for forge chunk loading control")
/*  958 */       .setCategoryRequiresWorldRestart("defaults", true);
/*      */     
/*  960 */     Property temp = config.get("defaults", "enabled", true);
/*  961 */     temp.comment = "Are mod overrides enabled?";
/*  962 */     temp.setLanguageKey("forge.configgui.enableModOverrides");
/*  963 */     overridesEnabled = temp.getBoolean(true);
/*  964 */     propOrder.add("enabled");
/*      */     
/*  966 */     temp = config.get("defaults", "maximumChunksPerTicket", 25);
/*  967 */     temp.comment = "The default maximum number of chunks a mod can force, per ticket, \nfor a mod without an override. This is the maximum number of chunks a single ticket can force.";
/*      */     
/*  969 */     temp.setLanguageKey("forge.configgui.maximumChunksPerTicket");
/*  970 */     temp.setMinValue(0);
/*  971 */     defaultMaxChunks = temp.getInt(25);
/*  972 */     propOrder.add("maximumChunksPerTicket");
/*      */     
/*  974 */     temp = config.get("defaults", "maximumTicketCount", 200);
/*  975 */     temp.comment = "The default maximum ticket count for a mod which does not have an override\nin this file. This is the number of chunk loading requests a mod is allowed to make.";
/*      */     
/*  977 */     temp.setLanguageKey("forge.configgui.maximumTicketCount");
/*  978 */     temp.setMinValue(0);
/*  979 */     defaultMaxCount = temp.getInt(200);
/*  980 */     propOrder.add("maximumTicketCount");
/*      */     
/*  982 */     temp = config.get("defaults", "playerTicketCount", 500);
/*  983 */     temp.comment = "The number of tickets a player can be assigned instead of a mod. This is shared across all mods and it is up to the mods to use it.";
/*  984 */     temp.setLanguageKey("forge.configgui.playerTicketCount");
/*  985 */     temp.setMinValue(0);
/*  986 */     playerTicketLength = temp.getInt(500);
/*  987 */     propOrder.add("playerTicketCount");
/*      */     
/*  989 */     temp = config.get("defaults", "dormantChunkCacheSize", 0);
/*  990 */     temp.comment = "Unloaded chunks can first be kept in a dormant cache for quicker\nloading times. Specify the size (in chunks) of that cache here";
/*      */     
/*  992 */     temp.setLanguageKey("forge.configgui.dormantChunkCacheSize");
/*  993 */     temp.setMinValue(0);
/*  994 */     dormantChunkCacheSize = temp.getInt(0);
/*  995 */     propOrder.add("dormantChunkCacheSize");
/*  996 */     FMLLog.info("Configured a dormant chunk cache size of %d", new Object[] { Integer.valueOf(temp.getInt(0)) });
/*      */     
/*  998 */     config.setCategoryPropertyOrder("defaults", propOrder);
/*      */     
/* 1000 */     config.addCustomCategoryComment("Forge", "Sample mod specific control section.\nCopy this section and rename the with the modid for the mod you wish to override.\nA value of zero in either entry effectively disables any chunkloading capabilities\nfor that mod");
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1005 */     temp = config.get("Forge", "maximumTicketCount", 200);
/* 1006 */     temp.comment = "Maximum ticket count for the mod. Zero disables chunkloading capabilities.";
/* 1007 */     temp = config.get("Forge", "maximumChunksPerTicket", 25);
/* 1008 */     temp.comment = "Maximum chunks per ticket for the mod.";
/* 1009 */     for (String mod : config.getCategoryNames()) {
/*      */       
/* 1011 */       if (mod.equals("Forge") || mod.equals("defaults")) {
/*      */         continue;
/*      */       }
/*      */       
/* 1015 */       config.get(mod, "maximumTicketCount", 200).setLanguageKey("forge.configgui.maximumTicketCount").setMinValue(0);
/* 1016 */       config.get(mod, "maximumChunksPerTicket", 25).setLanguageKey("forge.configgui.maximumChunksPerTicket").setMinValue(0);
/*      */     } 
/*      */     
/* 1019 */     if (config.hasChanged())
/*      */     {
/* 1021 */       config.save();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static Configuration getConfig() {
/* 1027 */     return config;
/*      */   }
/*      */ 
/*      */   
/*      */   public static ConfigCategory getDefaultsCategory() {
/* 1032 */     return config.getCategory("defaults");
/*      */   }
/*      */ 
/*      */   
/*      */   public static List<ConfigCategory> getModCategories() {
/* 1037 */     List<ConfigCategory> list = new ArrayList<ConfigCategory>();
/* 1038 */     for (String mod : config.getCategoryNames()) {
/*      */       
/* 1040 */       if (mod.equals("Forge") || mod.equals("defaults")) {
/*      */         continue;
/*      */       }
/*      */       
/* 1044 */       list.add(config.getCategory(mod));
/*      */     } 
/* 1046 */     return list;
/*      */   }
/*      */ 
/*      */   
/*      */   public static ConfigCategory getConfigFor(Object mod) {
/* 1051 */     ModContainer container = getContainer(mod);
/* 1052 */     if (container != null)
/*      */     {
/* 1054 */       return config.getCategory(container.getModId());
/*      */     }
/*      */     
/* 1057 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public static void addConfigProperty(Object mod, String propertyName, String value, Property.Type type) {
/* 1062 */     ModContainer container = getContainer(mod);
/* 1063 */     if (container != null) {
/*      */       
/* 1065 */       ConfigCategory cat = config.getCategory(container.getModId());
/* 1066 */       Property prop = (new Property(propertyName, value, type)).setLanguageKey("forge.configgui." + propertyName);
/* 1067 */       if (type == Property.Type.INTEGER)
/*      */       {
/* 1069 */         prop.setMinValue(0);
/*      */       }
/* 1071 */       cat.put(propertyName, prop);
/*      */     } 
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\ForgeChunkManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */