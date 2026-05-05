/*      */ package net.minecraft.server.v1_7_R4;
/*      */ import java.io.File;
/*      */ import java.net.InetSocketAddress;
/*      */ import java.net.SocketAddress;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.UUID;
/*      */ import java.util.concurrent.CopyOnWriteArrayList;
/*      */ import net.minecraft.util.com.google.common.base.Charsets;
/*      */ import net.minecraft.util.com.google.common.collect.Lists;
/*      */ import net.minecraft.util.com.google.common.collect.Maps;
/*      */ import net.minecraft.util.com.mojang.authlib.GameProfile;
/*      */ import org.apache.logging.log4j.LogManager;
/*      */ import org.bukkit.Bukkit;
/*      */ import org.bukkit.Location;
/*      */ import org.bukkit.TravelAgent;
/*      */ import org.bukkit.WeatherType;
/*      */ import org.bukkit.World;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.CraftTravelAgent;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.CraftWorld;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.chunkio.ChunkIOExecutor;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.util.CraftChatMessage;
/*      */ import org.bukkit.entity.Player;
/*      */ import org.bukkit.event.Event;
/*      */ import org.bukkit.event.player.PlayerChangedWorldEvent;
/*      */ import org.bukkit.event.player.PlayerJoinEvent;
/*      */ import org.bukkit.event.player.PlayerLoginEvent;
/*      */ import org.bukkit.event.player.PlayerPortalEvent;
/*      */ import org.bukkit.event.player.PlayerQuitEvent;
/*      */ import org.bukkit.event.player.PlayerRespawnEvent;
/*      */ import org.bukkit.event.player.PlayerTeleportEvent;
/*      */ import org.bukkit.util.Vector;
/*      */ 
/*      */ public abstract class PlayerList {
/*   43 */   public static final File a = new File("banned-players.json");
/*   44 */   public static final File b = new File("banned-ips.json");
/*   45 */   public static final File c = new File("ops.json");
/*   46 */   public static final File d = new File("whitelist.json");
/*   47 */   private static final Logger g = LogManager.getLogger();
/*   48 */   private static final SimpleDateFormat h = new SimpleDateFormat("yyyy-MM-dd 'at' HH:mm:ss z");
/*      */   private final MinecraftServer server;
/*   50 */   public final List players = new CopyOnWriteArrayList();
/*      */   
/*      */   private final GameProfileBanList j;
/*      */   
/*      */   private final IpBanList k;
/*      */   private final OpList operators;
/*      */   private final WhiteList whitelist;
/*      */   private final Map n;
/*      */   public IPlayerFileData playerFileData;
/*      */   public boolean hasWhitelist;
/*      */   protected int maxPlayers;
/*      */   private int q;
/*      */   private EnumGamemode r;
/*      */   private boolean s;
/*      */   private int t;
/*      */   private CraftServer cserver;
/*      */   
/*      */   public PlayerList(MinecraftServer minecraftserver) {
/*   68 */     minecraftserver.server = new CraftServer(minecraftserver, this);
/*   69 */     minecraftserver.console = ColouredConsoleSender.getInstance();
/*   70 */     minecraftserver.reader.addCompleter((Completer)new ConsoleCommandCompleter(minecraftserver.server));
/*   71 */     this.cserver = minecraftserver.server;
/*      */ 
/*      */     
/*   74 */     this.j = new GameProfileBanList(a);
/*   75 */     this.k = new IpBanList(b);
/*   76 */     this.operators = new OpList(c);
/*   77 */     this.whitelist = new WhiteList(d);
/*   78 */     this.n = Maps.newHashMap();
/*   79 */     this.server = minecraftserver;
/*   80 */     this.j.a(false);
/*   81 */     this.k.a(false);
/*   82 */     this.maxPlayers = 8;
/*      */   }
/*      */   
/*      */   public void a(NetworkManager networkmanager, EntityPlayer entityplayer) {
/*   86 */     GameProfile gameprofile = entityplayer.getProfile();
/*   87 */     UserCache usercache = this.server.getUserCache();
/*   88 */     GameProfile gameprofile1 = usercache.a(gameprofile.getId());
/*   89 */     String s = (gameprofile1 == null) ? gameprofile.getName() : gameprofile1.getName();
/*      */     
/*   91 */     usercache.a(gameprofile);
/*   92 */     NBTTagCompound nbttagcompound = a(entityplayer);
/*      */     
/*   94 */     entityplayer.spawnIn(this.server.getWorldServer(entityplayer.dimension));
/*   95 */     entityplayer.playerInteractManager.a((WorldServer)entityplayer.world);
/*   96 */     String s1 = "local";
/*      */     
/*   98 */     if (networkmanager.getSocketAddress() != null) {
/*   99 */       s1 = networkmanager.getSocketAddress().toString();
/*      */     }
/*      */ 
/*      */ 
/*      */     
/*  104 */     WorldServer worldserver = this.server.getWorldServer(entityplayer.dimension);
/*  105 */     ChunkCoordinates chunkcoordinates = worldserver.getSpawn();
/*      */     
/*  107 */     a(entityplayer, (EntityPlayer)null, worldserver);
/*  108 */     PlayerConnection playerconnection = new PlayerConnection(this.server, networkmanager, entityplayer);
/*      */ 
/*      */     
/*  111 */     int maxPlayers = getMaxPlayers();
/*  112 */     if (maxPlayers > 60) {
/*  113 */       maxPlayers = 60;
/*      */     }
/*  115 */     playerconnection.sendPacket(new PacketPlayOutLogin(entityplayer.getId(), entityplayer.playerInteractManager.getGameMode(), worldserver.getWorldData().isHardcore(), worldserver.worldProvider.dimension, worldserver.difficulty, maxPlayers, worldserver.getWorldData().getType()));
/*  116 */     entityplayer.getBukkitEntity().sendSupportedChannels();
/*      */     
/*  118 */     playerconnection.sendPacket(new PacketPlayOutCustomPayload("MC|Brand", getServer().getServerModName().getBytes(Charsets.UTF_8)));
/*  119 */     playerconnection.sendPacket(new PacketPlayOutSpawnPosition(chunkcoordinates.x, chunkcoordinates.y, chunkcoordinates.z));
/*  120 */     playerconnection.sendPacket(new PacketPlayOutAbilities(entityplayer.abilities));
/*  121 */     playerconnection.sendPacket(new PacketPlayOutHeldItemSlot(entityplayer.inventory.itemInHandIndex));
/*  122 */     entityplayer.getStatisticManager().d();
/*  123 */     entityplayer.getStatisticManager().updateStatistics(entityplayer);
/*  124 */     sendScoreboard((ScoreboardServer)worldserver.getScoreboard(), entityplayer);
/*  125 */     this.server.az();
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
/*  138 */     c(entityplayer);
/*  139 */     worldserver = this.server.getWorldServer(entityplayer.dimension);
/*  140 */     playerconnection.a(entityplayer.locX, entityplayer.locY, entityplayer.locZ, entityplayer.yaw, entityplayer.pitch);
/*  141 */     b(entityplayer, worldserver);
/*  142 */     if (this.server.getResourcePack().length() > 0) {
/*  143 */       entityplayer.setResourcePack(this.server.getResourcePack());
/*      */     }
/*      */     
/*  146 */     Iterator<MobEffect> iterator = entityplayer.getEffects().iterator();
/*      */     
/*  148 */     while (iterator.hasNext()) {
/*  149 */       MobEffect mobeffect = iterator.next();
/*      */       
/*  151 */       playerconnection.sendPacket(new PacketPlayOutEntityEffect(entityplayer.getId(), mobeffect));
/*      */     } 
/*      */     
/*  154 */     entityplayer.syncInventory();
/*  155 */     if (nbttagcompound != null && nbttagcompound.hasKeyOfType("Riding", 10)) {
/*  156 */       Entity entity = EntityTypes.a(nbttagcompound.getCompound("Riding"), worldserver);
/*      */       
/*  158 */       if (entity != null) {
/*  159 */         entity.attachedToPlayer = true;
/*  160 */         worldserver.addEntity(entity);
/*  161 */         entityplayer.mount(entity);
/*  162 */         entity.attachedToPlayer = false;
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  167 */     g.info(entityplayer.getName() + "[" + s1 + "] logged in with entity id " + entityplayer.getId() + " at ([" + entityplayer.world.worldData.getName() + "] " + entityplayer.locX + ", " + entityplayer.locY + ", " + entityplayer.locZ + ")");
/*      */   }
/*      */   
/*      */   public void sendScoreboard(ScoreboardServer scoreboardserver, EntityPlayer entityplayer) {
/*  171 */     HashSet<ScoreboardObjective> hashset = new HashSet();
/*  172 */     Iterator<ScoreboardTeam> iterator = scoreboardserver.getTeams().iterator();
/*      */     
/*  174 */     while (iterator.hasNext()) {
/*  175 */       ScoreboardTeam scoreboardteam = iterator.next();
/*      */       
/*  177 */       entityplayer.playerConnection.sendPacket(new PacketPlayOutScoreboardTeam(scoreboardteam, 0));
/*      */     } 
/*      */     
/*  180 */     for (int i = 0; i < 3; i++) {
/*  181 */       ScoreboardObjective scoreboardobjective = scoreboardserver.getObjectiveForSlot(i);
/*      */       
/*  183 */       if (scoreboardobjective != null && !hashset.contains(scoreboardobjective)) {
/*  184 */         List list = scoreboardserver.getScoreboardScorePacketsForObjective(scoreboardobjective);
/*  185 */         Iterator<Packet> iterator1 = list.iterator();
/*      */         
/*  187 */         while (iterator1.hasNext()) {
/*  188 */           Packet packet = iterator1.next();
/*      */           
/*  190 */           entityplayer.playerConnection.sendPacket(packet);
/*      */         } 
/*      */         
/*  193 */         hashset.add(scoreboardobjective);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void setPlayerFileData(WorldServer[] aworldserver) {
/*  199 */     if (this.playerFileData != null)
/*  200 */       return;  this.playerFileData = aworldserver[0].getDataManager().getPlayerFileData();
/*      */   }
/*      */   
/*      */   public void a(EntityPlayer entityplayer, WorldServer worldserver) {
/*  204 */     WorldServer worldserver1 = entityplayer.r();
/*      */     
/*  206 */     if (worldserver != null) {
/*  207 */       worldserver.getPlayerChunkMap().removePlayer(entityplayer);
/*      */     }
/*      */     
/*  210 */     worldserver1.getPlayerChunkMap().addPlayer(entityplayer);
/*  211 */     worldserver1.chunkProviderServer.getChunkAt((int)entityplayer.locX >> 4, (int)entityplayer.locZ >> 4);
/*      */   }
/*      */   
/*      */   public int d() {
/*  215 */     return PlayerChunkMap.getFurthestViewableBlock(s());
/*      */   }
/*      */ 
/*      */   
/*      */   public NBTTagCompound a(EntityPlayer entityplayer) {
/*  220 */     NBTTagCompound nbttagcompound1, nbttagcompound = ((WorldServer)this.server.worlds.get(0)).getWorldData().i();
/*      */ 
/*      */     
/*  223 */     if (entityplayer.getName().equals(this.server.M()) && nbttagcompound != null) {
/*  224 */       entityplayer.f(nbttagcompound);
/*  225 */       nbttagcompound1 = nbttagcompound;
/*  226 */       g.debug("loading single player");
/*      */     } else {
/*  228 */       nbttagcompound1 = this.playerFileData.load(entityplayer);
/*      */     } 
/*      */     
/*  231 */     return nbttagcompound1;
/*      */   }
/*      */   
/*      */   protected void b(EntityPlayer entityplayer) {
/*  235 */     this.playerFileData.save(entityplayer);
/*  236 */     ServerStatisticManager serverstatisticmanager = (ServerStatisticManager)this.n.get(entityplayer.getUniqueID());
/*      */     
/*  238 */     if (serverstatisticmanager != null) {
/*  239 */       serverstatisticmanager.b();
/*      */     }
/*      */   }
/*      */   
/*      */   public void c(EntityPlayer entityplayer) {
/*  244 */     this.cserver.detectListNameConflict(entityplayer);
/*      */     
/*  246 */     this.players.add(entityplayer);
/*  247 */     WorldServer worldserver = this.server.getWorldServer(entityplayer.dimension);
/*      */ 
/*      */     
/*  250 */     PlayerJoinEvent playerJoinEvent = new PlayerJoinEvent(this.cserver.getPlayer(entityplayer), "§e" + entityplayer.getName() + " joined the game.");
/*  251 */     this.cserver.getPluginManager().callEvent((Event)playerJoinEvent);
/*      */     
/*  253 */     String joinMessage = playerJoinEvent.getJoinMessage();
/*      */     
/*  255 */     if (joinMessage != null && joinMessage.length() > 0) {
/*  256 */       for (IChatBaseComponent line : CraftChatMessage.fromString(joinMessage)) {
/*  257 */         this.server.getPlayerList().sendAll(new PacketPlayOutChat(line));
/*      */       }
/*      */     }
/*  260 */     this.cserver.onPlayerJoin(playerJoinEvent.getPlayer());
/*      */     
/*  262 */     ChunkIOExecutor.adjustPoolSize(getPlayerCount());
/*      */ 
/*      */ 
/*      */     
/*  266 */     if (entityplayer.world == worldserver && !worldserver.players.contains(entityplayer)) {
/*  267 */       worldserver.addEntity(entityplayer);
/*  268 */       a(entityplayer, (WorldServer)null);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  273 */     PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo(entityplayer.listName, true, 1000); int i;
/*  274 */     for (i = 0; i < this.players.size(); i++) {
/*  275 */       EntityPlayer entityplayer1 = this.players.get(i);
/*      */       
/*  277 */       if (entityplayer1.getBukkitEntity().canSee((Player)entityplayer.getBukkitEntity())) {
/*  278 */         entityplayer1.playerConnection.sendPacket(packet);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  283 */     for (i = 0; i < this.players.size(); i++) {
/*  284 */       EntityPlayer entityplayer1 = this.players.get(i);
/*      */ 
/*      */       
/*  287 */       if (entityplayer.getBukkitEntity().canSee((Player)entityplayer1.getBukkitEntity()))
/*      */       {
/*      */ 
/*      */         
/*  291 */         entityplayer.playerConnection.sendPacket(new PacketPlayOutPlayerInfo(entityplayer1.listName, true, entityplayer1.ping));
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void d(EntityPlayer entityplayer) {
/*  297 */     entityplayer.r().getPlayerChunkMap().movePlayer(entityplayer);
/*      */   }
/*      */   
/*      */   public String disconnect(EntityPlayer entityplayer) {
/*  301 */     entityplayer.a(StatisticList.f);
/*      */ 
/*      */     
/*  304 */     CraftEventFactory.handleInventoryCloseEvent(entityplayer);
/*      */     
/*  306 */     PlayerQuitEvent playerQuitEvent = new PlayerQuitEvent(this.cserver.getPlayer(entityplayer), "§e" + entityplayer.getName() + " left the game.");
/*  307 */     this.cserver.getPluginManager().callEvent((Event)playerQuitEvent);
/*  308 */     entityplayer.getBukkitEntity().disconnect(playerQuitEvent.getQuitMessage());
/*      */ 
/*      */     
/*  311 */     b(entityplayer);
/*  312 */     WorldServer worldserver = entityplayer.r();
/*      */     
/*  314 */     if (entityplayer.vehicle != null && !(entityplayer.vehicle instanceof EntityPlayer)) {
/*  315 */       worldserver.removeEntity(entityplayer.vehicle);
/*  316 */       g.debug("removing player mount");
/*      */     } 
/*      */     
/*  319 */     worldserver.kill(entityplayer);
/*  320 */     worldserver.getPlayerChunkMap().removePlayer(entityplayer);
/*  321 */     this.players.remove(entityplayer);
/*  322 */     this.n.remove(entityplayer.getUniqueID());
/*  323 */     ChunkIOExecutor.adjustPoolSize(getPlayerCount());
/*      */ 
/*      */ 
/*      */     
/*  327 */     PacketPlayOutPlayerInfo packet = new PacketPlayOutPlayerInfo(entityplayer.listName, false, 9999);
/*  328 */     for (int i = 0; i < this.players.size(); i++) {
/*  329 */       EntityPlayer entityplayer1 = this.players.get(i);
/*      */       
/*  331 */       if (entityplayer1.getBukkitEntity().canSee((Player)entityplayer.getBukkitEntity())) {
/*  332 */         entityplayer1.playerConnection.sendPacket(packet);
/*      */       } else {
/*  334 */         entityplayer1.getBukkitEntity().removeDisconnectingPlayer((Player)entityplayer.getBukkitEntity());
/*      */       } 
/*      */     } 
/*      */     
/*  338 */     this.cserver.getScoreboardManager().removePlayer((Player)entityplayer.getBukkitEntity());
/*      */     
/*  340 */     return playerQuitEvent.getQuitMessage();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityPlayer attemptLogin(LoginListener loginlistener, GameProfile gameprofile, String hostname) {
/*  349 */     SocketAddress socketaddress = loginlistener.networkManager.getSocketAddress();
/*      */     
/*  351 */     EntityPlayer entity = new EntityPlayer(this.server, this.server.getWorldServer(0), gameprofile, new PlayerInteractManager(this.server.getWorldServer(0)));
/*  352 */     CraftPlayer craftPlayer = entity.getBukkitEntity();
/*  353 */     PlayerLoginEvent event = new PlayerLoginEvent((Player)craftPlayer, hostname, ((InetSocketAddress)socketaddress).getAddress());
/*      */ 
/*      */     
/*  356 */     if (this.j.isBanned(gameprofile) && !this.j.get(gameprofile).hasExpired()) {
/*  357 */       GameProfileBanEntry gameprofilebanentry = (GameProfileBanEntry)this.j.get(gameprofile);
/*      */       
/*  359 */       String s = "You are banned from this server!\nReason: " + gameprofilebanentry.getReason();
/*  360 */       if (gameprofilebanentry.getExpires() != null) {
/*  361 */         s = s + "\nYour ban will be removed on " + h.format(gameprofilebanentry.getExpires());
/*      */       }
/*      */ 
/*      */       
/*  365 */       event.disallow(PlayerLoginEvent.Result.KICK_BANNED, s);
/*  366 */     } else if (!isWhitelisted(gameprofile)) {
/*      */       
/*  368 */       event.disallow(PlayerLoginEvent.Result.KICK_WHITELIST, "You are not white-listed on this server!");
/*  369 */     } else if (this.k.isBanned(socketaddress) && !this.k.get(gameprofile).hasExpired()) {
/*  370 */       IpBanEntry ipbanentry = this.k.get(socketaddress);
/*      */       
/*  372 */       String s = "Your IP address is banned from this server!\nReason: " + ipbanentry.getReason();
/*  373 */       if (ipbanentry.getExpires() != null) {
/*  374 */         s = s + "\nYour ban will be removed on " + h.format(ipbanentry.getExpires());
/*      */       }
/*      */ 
/*      */       
/*  378 */       event.disallow(PlayerLoginEvent.Result.KICK_BANNED, s);
/*      */     
/*      */     }
/*  381 */     else if (this.players.size() >= this.maxPlayers) {
/*  382 */       event.disallow(PlayerLoginEvent.Result.KICK_FULL, "The server is full!");
/*      */     } 
/*      */ 
/*      */     
/*  386 */     this.cserver.getPluginManager().callEvent((Event)event);
/*  387 */     if (event.getResult() != PlayerLoginEvent.Result.ALLOWED) {
/*  388 */       loginlistener.disconnect(event.getKickMessage());
/*  389 */       return null;
/*      */     } 
/*      */     
/*  392 */     return entity;
/*      */   }
/*      */ 
/*      */   
/*      */   public EntityPlayer processLogin(GameProfile gameprofile, EntityPlayer player) {
/*  397 */     UUID uuid = EntityHuman.a(gameprofile);
/*  398 */     ArrayList<EntityPlayer> arraylist = Lists.newArrayList();
/*      */ 
/*      */ 
/*      */     
/*  402 */     for (int i = 0; i < this.players.size(); i++) {
/*  403 */       EntityPlayer entityplayer = this.players.get(i);
/*  404 */       if (entityplayer.getUniqueID().equals(uuid)) {
/*  405 */         arraylist.add(entityplayer);
/*      */       }
/*      */     } 
/*      */     
/*  409 */     Iterator<EntityPlayer> iterator = arraylist.iterator();
/*      */     
/*  411 */     while (iterator.hasNext()) {
/*  412 */       EntityPlayer entityplayer = iterator.next();
/*  413 */       entityplayer.playerConnection.disconnect("You logged in from another location");
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
/*      */ 
/*      */     
/*  427 */     return player;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public EntityPlayer moveToWorld(EntityPlayer entityplayer, int i, boolean flag) {
/*  433 */     return moveToWorld(entityplayer, i, flag, null, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public EntityPlayer moveToWorld(EntityPlayer entityplayer, int i, boolean flag, Location location, boolean avoidSuffocation) {
/*  438 */     entityplayer.r().getTracker().untrackPlayer(entityplayer);
/*      */     
/*  440 */     entityplayer.r().getPlayerChunkMap().removePlayer(entityplayer);
/*  441 */     this.players.remove(entityplayer);
/*  442 */     this.server.getWorldServer(entityplayer.dimension).removeEntity(entityplayer);
/*  443 */     ChunkCoordinates chunkcoordinates = entityplayer.getBed();
/*  444 */     boolean flag1 = entityplayer.isRespawnForced();
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
/*  458 */     EntityPlayer entityplayer1 = entityplayer;
/*  459 */     World fromWorld = entityplayer1.getBukkitEntity().getWorld();
/*  460 */     entityplayer1.viewingCredits = false;
/*      */ 
/*      */     
/*  463 */     entityplayer1.playerConnection = entityplayer.playerConnection;
/*  464 */     entityplayer1.copyTo(entityplayer, flag);
/*  465 */     entityplayer1.d(entityplayer.getId());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  472 */     if (location == null) {
/*  473 */       boolean isBedSpawn = false;
/*  474 */       CraftWorld cworld = (CraftWorld)this.server.server.getWorld(entityplayer.spawnWorld);
/*  475 */       if (cworld != null && chunkcoordinates != null) {
/*  476 */         ChunkCoordinates chunkCoordinates = EntityHuman.getBed(cworld.getHandle(), chunkcoordinates, flag1);
/*  477 */         if (chunkCoordinates != null) {
/*  478 */           isBedSpawn = true;
/*  479 */           location = new Location((World)cworld, chunkCoordinates.x + 0.5D, chunkCoordinates.y, chunkCoordinates.z + 0.5D);
/*      */         } else {
/*  481 */           entityplayer1.setRespawnPosition((ChunkCoordinates)null, true);
/*  482 */           entityplayer1.playerConnection.sendPacket(new PacketPlayOutGameStateChange(0, 0.0F));
/*      */         } 
/*      */       } 
/*      */       
/*  486 */       if (location == null) {
/*  487 */         cworld = this.server.server.getWorlds().get(0);
/*  488 */         chunkcoordinates = cworld.getHandle().getSpawn();
/*  489 */         location = new Location((World)cworld, chunkcoordinates.x + 0.5D, chunkcoordinates.y, chunkcoordinates.z + 0.5D);
/*      */       } 
/*      */       
/*  492 */       Player respawnPlayer = this.cserver.getPlayer(entityplayer1);
/*  493 */       PlayerRespawnEvent respawnEvent = new PlayerRespawnEvent(respawnPlayer, location, isBedSpawn);
/*  494 */       this.cserver.getPluginManager().callEvent((Event)respawnEvent);
/*      */       
/*  496 */       location = respawnEvent.getRespawnLocation();
/*  497 */       entityplayer.reset();
/*      */     } else {
/*  499 */       location.setWorld((World)this.server.getWorldServer(i).getWorld());
/*      */     } 
/*  501 */     WorldServer worldserver = ((CraftWorld)location.getWorld()).getHandle();
/*  502 */     entityplayer1.setLocation(location.getX(), location.getY(), location.getZ(), location.getYaw(), location.getPitch());
/*      */ 
/*      */     
/*  505 */     worldserver.chunkProviderServer.getChunkAt((int)entityplayer1.locX >> 4, (int)entityplayer1.locZ >> 4);
/*      */     
/*  507 */     while (avoidSuffocation && !worldserver.getCubes(entityplayer1, entityplayer1.boundingBox).isEmpty()) {
/*  508 */       entityplayer1.setPosition(entityplayer1.locX, entityplayer1.locY + 1.0D, entityplayer1.locZ);
/*      */     }
/*      */ 
/*      */     
/*  512 */     byte actualDimension = (byte)worldserver.getWorld().getEnvironment().getId();
/*      */     
/*  514 */     entityplayer1.playerConnection.sendPacket(new PacketPlayOutRespawn((byte)((actualDimension >= 0) ? -1 : 0), worldserver.difficulty, worldserver.getWorldData().getType(), entityplayer.playerInteractManager.getGameMode()));
/*  515 */     entityplayer1.playerConnection.sendPacket(new PacketPlayOutRespawn(actualDimension, worldserver.difficulty, worldserver.getWorldData().getType(), entityplayer1.playerInteractManager.getGameMode()));
/*  516 */     entityplayer1.spawnIn(worldserver);
/*  517 */     entityplayer1.dead = false;
/*  518 */     entityplayer1.playerConnection.teleport(new Location((World)worldserver.getWorld(), entityplayer1.locX, entityplayer1.locY, entityplayer1.locZ, entityplayer1.yaw, entityplayer1.pitch));
/*  519 */     entityplayer1.setSneaking(false);
/*  520 */     ChunkCoordinates chunkcoordinates1 = worldserver.getSpawn();
/*      */ 
/*      */     
/*  523 */     entityplayer1.playerConnection.sendPacket(new PacketPlayOutSpawnPosition(chunkcoordinates1.x, chunkcoordinates1.y, chunkcoordinates1.z));
/*  524 */     entityplayer1.playerConnection.sendPacket(new PacketPlayOutExperience(entityplayer1.exp, entityplayer1.expTotal, entityplayer1.expLevel));
/*  525 */     b(entityplayer1, worldserver);
/*      */ 
/*      */     
/*  528 */     if (!entityplayer.playerConnection.isDisconnected()) {
/*  529 */       worldserver.getPlayerChunkMap().addPlayer(entityplayer1);
/*  530 */       worldserver.addEntity(entityplayer1);
/*  531 */       this.players.add(entityplayer1);
/*      */     } 
/*      */     
/*  534 */     updateClient(entityplayer1);
/*  535 */     entityplayer1.updateAbilities();
/*  536 */     Iterator<MobEffect> iterator = entityplayer1.getEffects().iterator();
/*      */     
/*  538 */     while (iterator.hasNext()) {
/*  539 */       MobEffect mobeffect = iterator.next();
/*      */       
/*  541 */       entityplayer1.playerConnection.sendPacket(new PacketPlayOutEntityEffect(entityplayer1.getId(), mobeffect));
/*      */     } 
/*      */ 
/*      */     
/*  545 */     entityplayer1.setHealth(entityplayer1.getHealth());
/*      */ 
/*      */ 
/*      */     
/*  549 */     if (fromWorld != location.getWorld()) {
/*  550 */       PlayerChangedWorldEvent event = new PlayerChangedWorldEvent((Player)entityplayer1.getBukkitEntity(), fromWorld);
/*  551 */       Bukkit.getServer().getPluginManager().callEvent((Event)event);
/*      */     } 
/*      */ 
/*      */     
/*  555 */     if (entityplayer.playerConnection.isDisconnected()) {
/*  556 */       b(entityplayer1);
/*      */     }
/*      */ 
/*      */     
/*  560 */     return entityplayer1;
/*      */   }
/*      */ 
/*      */   
/*      */   public void changeDimension(EntityPlayer entityplayer, int i, PlayerTeleportEvent.TeleportCause cause) {
/*  565 */     WorldServer exitWorld = null;
/*  566 */     if (entityplayer.dimension < 10)
/*      */     {
/*  568 */       for (WorldServer world : this.server.worlds) {
/*  569 */         if (world.dimension == i) {
/*  570 */           exitWorld = world;
/*      */         }
/*      */       } 
/*      */     }
/*      */     
/*  575 */     Location enter = entityplayer.getBukkitEntity().getLocation();
/*  576 */     Location exit = null;
/*  577 */     boolean useTravelAgent = false;
/*  578 */     if (exitWorld != null) {
/*  579 */       if (cause == PlayerTeleportEvent.TeleportCause.END_PORTAL && i == 0) {
/*      */         
/*  581 */         exit = entityplayer.getBukkitEntity().getBedSpawnLocation();
/*  582 */         if (exit == null || (((CraftWorld)exit.getWorld()).getHandle()).dimension != 0) {
/*  583 */           exit = exitWorld.getWorld().getSpawnLocation();
/*      */         }
/*      */       } else {
/*      */         
/*  587 */         exit = calculateTarget(enter, exitWorld);
/*  588 */         useTravelAgent = true;
/*      */       } 
/*      */     }
/*      */     
/*  592 */     TravelAgent agent = (exit != null) ? (TravelAgent)((CraftWorld)exit.getWorld()).getHandle().getTravelAgent() : CraftTravelAgent.DEFAULT;
/*  593 */     PlayerPortalEvent event = new PlayerPortalEvent((Player)entityplayer.getBukkitEntity(), enter, exit, agent, cause);
/*  594 */     event.useTravelAgent(useTravelAgent);
/*  595 */     Bukkit.getServer().getPluginManager().callEvent((Event)event);
/*  596 */     if (event.isCancelled() || event.getTo() == null) {
/*      */       return;
/*      */     }
/*      */     
/*  600 */     exit = event.useTravelAgent() ? event.getPortalTravelAgent().findOrCreate(event.getTo()) : event.getTo();
/*  601 */     if (exit == null) {
/*      */       return;
/*      */     }
/*  604 */     exitWorld = ((CraftWorld)exit.getWorld()).getHandle();
/*      */     
/*  606 */     Vector velocity = entityplayer.getBukkitEntity().getVelocity();
/*  607 */     boolean before = exitWorld.chunkProviderServer.forceChunkLoad;
/*  608 */     exitWorld.chunkProviderServer.forceChunkLoad = true;
/*  609 */     exitWorld.getTravelAgent().adjustExit(entityplayer, exit, velocity);
/*  610 */     exitWorld.chunkProviderServer.forceChunkLoad = before;
/*      */     
/*  612 */     moveToWorld(entityplayer, exitWorld.dimension, true, exit, false);
/*  613 */     if (entityplayer.motX != velocity.getX() || entityplayer.motY != velocity.getY() || entityplayer.motZ != velocity.getZ()) {
/*  614 */       entityplayer.getBukkitEntity().setVelocity(velocity);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(Entity entity, int i, WorldServer worldserver, WorldServer worldserver1) {
/*  621 */     Location exit = calculateTarget(entity.getBukkitEntity().getLocation(), worldserver1);
/*  622 */     repositionEntity(entity, exit, true);
/*      */   }
/*      */ 
/*      */   
/*      */   public Location calculateTarget(Location enter, World target) {
/*  627 */     WorldServer worldserver = ((CraftWorld)enter.getWorld()).getHandle();
/*  628 */     WorldServer worldserver1 = target.getWorld().getHandle();
/*  629 */     int i = worldserver.dimension;
/*      */     
/*  631 */     double y = enter.getY();
/*  632 */     float yaw = enter.getYaw();
/*  633 */     float pitch = enter.getPitch();
/*  634 */     double d0 = enter.getX();
/*  635 */     double d1 = enter.getZ();
/*  636 */     double d2 = 8.0D;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  645 */     if (worldserver1.dimension == -1) {
/*  646 */       d0 /= d2;
/*  647 */       d1 /= d2;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*  654 */     else if (worldserver1.dimension == 0) {
/*  655 */       d0 *= d2;
/*  656 */       d1 *= d2;
/*      */     } else {
/*      */       ChunkCoordinates chunkcoordinates;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  666 */       if (i == 1) {
/*      */         
/*  668 */         worldserver1 = this.server.worlds.get(0);
/*  669 */         chunkcoordinates = worldserver1.getSpawn();
/*      */       } else {
/*  671 */         chunkcoordinates = worldserver1.getDimensionSpawn();
/*      */       } 
/*      */       
/*  674 */       d0 = chunkcoordinates.x;
/*  675 */       y = chunkcoordinates.y;
/*  676 */       d1 = chunkcoordinates.z;
/*  677 */       yaw = 90.0F;
/*  678 */       pitch = 0.0F;
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  688 */     if (i != 1) {
/*      */       
/*  690 */       d0 = MathHelper.a((int)d0, -29999872, 29999872);
/*  691 */       d1 = MathHelper.a((int)d1, -29999872, 29999872);
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
/*      */ 
/*      */     
/*  705 */     return new Location((World)worldserver1.getWorld(), d0, y, d1, yaw, pitch);
/*      */   }
/*      */ 
/*      */   
/*      */   public void repositionEntity(Entity entity, Location exit, boolean portal) {
/*  710 */     int i = entity.dimension;
/*  711 */     WorldServer worldserver = (WorldServer)entity.world;
/*  712 */     WorldServer worldserver1 = ((CraftWorld)exit.getWorld()).getHandle();
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
/*  723 */     worldserver.methodProfiler.a("moving");
/*  724 */     entity.setPositionRotation(exit.getX(), exit.getY(), exit.getZ(), exit.getYaw(), exit.getPitch());
/*  725 */     if (entity.isAlive()) {
/*  726 */       worldserver.entityJoinedWorld(entity, false);
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
/*  762 */     worldserver.methodProfiler.b();
/*  763 */     if (i != 1) {
/*  764 */       worldserver.methodProfiler.a("placing");
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  769 */       if (entity.isAlive()) {
/*      */ 
/*      */         
/*  772 */         if (portal) {
/*  773 */           Vector velocity = entity.getBukkitEntity().getVelocity();
/*  774 */           worldserver1.getTravelAgent().adjustExit(entity, exit, velocity);
/*  775 */           entity.setPositionRotation(exit.getX(), exit.getY(), exit.getZ(), exit.getYaw(), exit.getPitch());
/*  776 */           if (entity.motX != velocity.getX() || entity.motY != velocity.getY() || entity.motZ != velocity.getZ()) {
/*  777 */             entity.getBukkitEntity().setVelocity(velocity);
/*      */           }
/*      */         } 
/*  780 */         worldserver1.addEntity(entity);
/*  781 */         worldserver1.entityJoinedWorld(entity, false);
/*      */       } 
/*      */       
/*  784 */       worldserver.methodProfiler.b();
/*      */     } 
/*      */     
/*  787 */     entity.spawnIn(worldserver1);
/*      */   }
/*      */ 
/*      */   
/*      */   public void tick() {
/*  792 */     if (++this.t > 600) {
/*  793 */       this.t = 0;
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
/*      */   public void sendAll(Packet packet) {
/*  806 */     for (int i = 0; i < this.players.size(); i++) {
/*  807 */       ((EntityPlayer)this.players.get(i)).playerConnection.sendPacket(packet);
/*      */     }
/*      */   }
/*      */   
/*      */   public void a(Packet packet, int i) {
/*  812 */     for (int j = 0; j < this.players.size(); j++) {
/*  813 */       EntityPlayer entityplayer = this.players.get(j);
/*      */       
/*  815 */       if (entityplayer.dimension == i) {
/*  816 */         entityplayer.playerConnection.sendPacket(packet);
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public String b(boolean flag) {
/*  822 */     String s = "";
/*  823 */     ArrayList<EntityPlayer> arraylist = Lists.newArrayList(this.players);
/*      */     
/*  825 */     for (int i = 0; i < arraylist.size(); i++) {
/*  826 */       if (i > 0) {
/*  827 */         s = s + ", ";
/*      */       }
/*      */       
/*  830 */       s = s + ((EntityPlayer)arraylist.get(i)).getName();
/*  831 */       if (flag) {
/*  832 */         s = s + " (" + ((EntityPlayer)arraylist.get(i)).getUniqueID().toString() + ")";
/*      */       }
/*      */     } 
/*      */     
/*  836 */     return s;
/*      */   }
/*      */   
/*      */   public String[] f() {
/*  840 */     String[] astring = new String[this.players.size()];
/*      */     
/*  842 */     for (int i = 0; i < this.players.size(); i++) {
/*  843 */       astring[i] = ((EntityPlayer)this.players.get(i)).getName();
/*      */     }
/*      */     
/*  846 */     return astring;
/*      */   }
/*      */   
/*      */   public GameProfile[] g() {
/*  850 */     GameProfile[] agameprofile = new GameProfile[this.players.size()];
/*      */     
/*  852 */     for (int i = 0; i < this.players.size(); i++) {
/*  853 */       agameprofile[i] = ((EntityPlayer)this.players.get(i)).getProfile();
/*      */     }
/*      */     
/*  856 */     return agameprofile;
/*      */   }
/*      */   
/*      */   public GameProfileBanList getProfileBans() {
/*  860 */     return this.j;
/*      */   }
/*      */   
/*      */   public IpBanList getIPBans() {
/*  864 */     return this.k;
/*      */   }
/*      */   
/*      */   public void addOp(GameProfile gameprofile) {
/*  868 */     this.operators.add(new OpListEntry(gameprofile, this.server.l()));
/*      */ 
/*      */     
/*  871 */     Player player = this.server.server.getPlayer(gameprofile.getId());
/*  872 */     if (player != null) {
/*  873 */       player.recalculatePermissions();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void removeOp(GameProfile gameprofile) {
/*  879 */     this.operators.remove(gameprofile);
/*      */ 
/*      */     
/*  882 */     Player player = this.server.server.getPlayer(gameprofile.getId());
/*  883 */     if (player != null) {
/*  884 */       player.recalculatePermissions();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isWhitelisted(GameProfile gameprofile) {
/*  890 */     return (!this.hasWhitelist || this.operators.d(gameprofile) || this.whitelist.d(gameprofile));
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isOp(GameProfile gameprofile) {
/*  895 */     return (this.operators.d(gameprofile) || (this.server.N() && ((WorldServer)this.server.worlds.get(0)).getWorldData().allowCommands() && this.server.M().equalsIgnoreCase(gameprofile.getName())) || this.s);
/*      */   }
/*      */   public EntityPlayer getPlayer(String s) {
/*      */     EntityPlayer entityplayer;
/*  899 */     Iterator<EntityPlayer> iterator = this.players.iterator();
/*      */ 
/*      */ 
/*      */     
/*      */     do {
/*  904 */       if (!iterator.hasNext()) {
/*  905 */         return null;
/*      */       }
/*      */       
/*  908 */       entityplayer = iterator.next();
/*  909 */     } while (!entityplayer.getName().equalsIgnoreCase(s));
/*      */     
/*  911 */     return entityplayer;
/*      */   }
/*      */   
/*      */   public List a(ChunkCoordinates chunkcoordinates, int i, int j, int k, int l, int i1, int j1, Map map, String s, String s1, World world) {
/*  915 */     if (this.players.isEmpty()) {
/*  916 */       return Collections.emptyList();
/*      */     }
/*  918 */     Object object = new ArrayList();
/*  919 */     boolean flag = (k < 0);
/*  920 */     boolean flag1 = (s != null && s.startsWith("!"));
/*  921 */     boolean flag2 = (s1 != null && s1.startsWith("!"));
/*  922 */     int k1 = i * i;
/*  923 */     int l1 = j * j;
/*      */     
/*  925 */     k = MathHelper.a(k);
/*  926 */     if (flag1) {
/*  927 */       s = s.substring(1);
/*      */     }
/*      */     
/*  930 */     if (flag2) {
/*  931 */       s1 = s1.substring(1);
/*      */     }
/*      */     
/*  934 */     for (int i2 = 0; i2 < this.players.size(); i2++) {
/*  935 */       EntityPlayer entityplayer = this.players.get(i2);
/*      */       
/*  937 */       if ((world == null || entityplayer.world == world) && (s == null || flag1 != s.equalsIgnoreCase(entityplayer.getName()))) {
/*  938 */         if (s1 != null) {
/*  939 */           ScoreboardTeamBase scoreboardteambase = entityplayer.getScoreboardTeam();
/*  940 */           String s2 = (scoreboardteambase == null) ? "" : scoreboardteambase.getName();
/*      */           
/*  942 */           if (flag2 == s1.equalsIgnoreCase(s2)) {
/*      */             continue;
/*      */           }
/*      */         } 
/*      */         
/*  947 */         if (chunkcoordinates != null && (i > 0 || j > 0)) {
/*  948 */           float f = chunkcoordinates.e(entityplayer.getChunkCoordinates());
/*      */           
/*  950 */           if ((i > 0 && f < k1) || (j > 0 && f > l1)) {
/*      */             continue;
/*      */           }
/*      */         } 
/*      */         
/*  955 */         if (a(entityplayer, map) && (l == EnumGamemode.NONE.getId() || l == entityplayer.playerInteractManager.getGameMode().getId()) && (i1 <= 0 || entityplayer.expLevel >= i1) && entityplayer.expLevel <= j1) {
/*  956 */           ((List<EntityPlayer>)object).add(entityplayer);
/*      */         }
/*      */       } 
/*      */       continue;
/*      */     } 
/*  961 */     if (chunkcoordinates != null) {
/*  962 */       Collections.sort((List)object, new PlayerDistanceComparator(chunkcoordinates));
/*      */     }
/*      */     
/*  965 */     if (flag) {
/*  966 */       Collections.reverse((List)object);
/*      */     }
/*      */     
/*  969 */     if (k > 0) {
/*  970 */       object = ((List)object).subList(0, Math.min(k, ((List)object).size()));
/*      */     }
/*      */     
/*  973 */     return (List)object;
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean a(EntityHuman entityhuman, Map map) {
/*  978 */     if (map != null && map.size() != 0) {
/*  979 */       Map.Entry entry; boolean flag; int i; Iterator<Map.Entry> iterator = map.entrySet().iterator();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*      */       do {
/*  986 */         if (!iterator.hasNext()) {
/*  987 */           return true;
/*      */         }
/*      */         
/*  990 */         entry = iterator.next();
/*  991 */         String s = (String)entry.getKey();
/*      */         
/*  993 */         flag = false;
/*  994 */         if (s.endsWith("_min") && s.length() > 4) {
/*  995 */           flag = true;
/*  996 */           s = s.substring(0, s.length() - 4);
/*      */         } 
/*      */         
/*  999 */         Scoreboard scoreboard = entityhuman.getScoreboard();
/* 1000 */         ScoreboardObjective scoreboardobjective = scoreboard.getObjective(s);
/*      */         
/* 1002 */         if (scoreboardobjective == null) {
/* 1003 */           return false;
/*      */         }
/*      */         
/* 1006 */         ScoreboardScore scoreboardscore = entityhuman.getScoreboard().getPlayerScoreForObjective(entityhuman.getName(), scoreboardobjective);
/*      */         
/* 1008 */         i = scoreboardscore.getScore();
/* 1009 */         if (i < ((Integer)entry.getValue()).intValue() && flag) {
/* 1010 */           return false;
/*      */         }
/* 1012 */       } while (i <= ((Integer)entry.getValue()).intValue() || flag);
/*      */       
/* 1014 */       return false;
/*      */     } 
/* 1016 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void sendPacketNearby(double d0, double d1, double d2, double d3, int i, Packet packet) {
/* 1021 */     sendPacketNearby((EntityHuman)null, d0, d1, d2, d3, i, packet);
/*      */   }
/*      */   
/*      */   public void sendPacketNearby(EntityHuman entityhuman, double d0, double d1, double d2, double d3, int i, Packet packet) {
/* 1025 */     for (int j = 0; j < this.players.size(); j++) {
/* 1026 */       EntityPlayer entityplayer = this.players.get(j);
/*      */ 
/*      */       
/* 1029 */       if (entityhuman == null || !(entityhuman instanceof EntityPlayer) || entityplayer.getBukkitEntity().canSee((Player)((EntityPlayer)entityhuman).getBukkitEntity()))
/*      */       {
/*      */ 
/*      */ 
/*      */         
/* 1034 */         if (entityplayer != entityhuman && entityplayer.dimension == i) {
/* 1035 */           double d4 = d0 - entityplayer.locX;
/* 1036 */           double d5 = d1 - entityplayer.locY;
/* 1037 */           double d6 = d2 - entityplayer.locZ;
/*      */           
/* 1039 */           if (d4 * d4 + d5 * d5 + d6 * d6 < d3 * d3)
/* 1040 */             entityplayer.playerConnection.sendPacket(packet); 
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public void savePlayers() {
/* 1047 */     for (int i = 0; i < this.players.size(); i++) {
/* 1048 */       b(this.players.get(i));
/*      */     }
/*      */   }
/*      */   
/*      */   public void addWhitelist(GameProfile gameprofile) {
/* 1053 */     this.whitelist.add(new WhiteListEntry(gameprofile));
/*      */   }
/*      */   
/*      */   public void removeWhitelist(GameProfile gameprofile) {
/* 1057 */     this.whitelist.remove(gameprofile);
/*      */   }
/*      */   
/*      */   public WhiteList getWhitelist() {
/* 1061 */     return this.whitelist;
/*      */   }
/*      */   
/*      */   public String[] getWhitelisted() {
/* 1065 */     return this.whitelist.getEntries();
/*      */   }
/*      */   
/*      */   public OpList getOPs() {
/* 1069 */     return this.operators;
/*      */   }
/*      */   
/*      */   public String[] n() {
/* 1073 */     return this.operators.getEntries();
/*      */   }
/*      */   
/*      */   public void reloadWhitelist() {}
/*      */   
/*      */   public void b(EntityPlayer entityplayer, WorldServer worldserver) {
/* 1079 */     entityplayer.playerConnection.sendPacket(new PacketPlayOutUpdateTime(worldserver.getTime(), worldserver.getDayTime(), worldserver.getGameRules().getBoolean("doDaylightCycle")));
/* 1080 */     if (worldserver.Q())
/*      */     {
/*      */ 
/*      */ 
/*      */       
/* 1085 */       entityplayer.setPlayerWeather(WeatherType.DOWNFALL, false);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateClient(EntityPlayer entityplayer) {
/* 1091 */     entityplayer.updateInventory(entityplayer.defaultContainer);
/* 1092 */     entityplayer.getBukkitEntity().updateScaledHealth();
/* 1093 */     entityplayer.playerConnection.sendPacket(new PacketPlayOutHeldItemSlot(entityplayer.inventory.itemInHandIndex));
/*      */   }
/*      */   
/*      */   public int getPlayerCount() {
/* 1097 */     return this.players.size();
/*      */   }
/*      */   
/*      */   public int getMaxPlayers() {
/* 1101 */     return this.maxPlayers;
/*      */   }
/*      */ 
/*      */   
/*      */   public String[] getSeenPlayers() {
/* 1106 */     return ((WorldServer)this.server.worlds.get(0)).getDataManager().getPlayerFileData().getSeenPlayers();
/*      */   }
/*      */   
/*      */   public boolean getHasWhitelist() {
/* 1110 */     return this.hasWhitelist;
/*      */   }
/*      */   
/*      */   public void setHasWhitelist(boolean flag) {
/* 1114 */     this.hasWhitelist = flag;
/*      */   }
/*      */   
/*      */   public List b(String s) {
/* 1118 */     ArrayList<EntityPlayer> arraylist = new ArrayList();
/* 1119 */     Iterator<EntityPlayer> iterator = this.players.iterator();
/*      */     
/* 1121 */     while (iterator.hasNext()) {
/* 1122 */       EntityPlayer entityplayer = iterator.next();
/*      */       
/* 1124 */       if (entityplayer.s().equals(s)) {
/* 1125 */         arraylist.add(entityplayer);
/*      */       }
/*      */     } 
/*      */     
/* 1129 */     return arraylist;
/*      */   }
/*      */   
/*      */   public int s() {
/* 1133 */     return this.q;
/*      */   }
/*      */   
/*      */   public MinecraftServer getServer() {
/* 1137 */     return this.server;
/*      */   }
/*      */   
/*      */   public NBTTagCompound t() {
/* 1141 */     return null;
/*      */   }
/*      */   
/*      */   private void a(EntityPlayer entityplayer, EntityPlayer entityplayer1, World world) {
/* 1145 */     if (entityplayer1 != null) {
/* 1146 */       entityplayer.playerInteractManager.setGameMode(entityplayer1.playerInteractManager.getGameMode());
/* 1147 */     } else if (this.r != null) {
/* 1148 */       entityplayer.playerInteractManager.setGameMode(this.r);
/*      */     } 
/*      */     
/* 1151 */     entityplayer.playerInteractManager.b(world.getWorldData().getGameType());
/*      */   }
/*      */   
/*      */   public void u() {
/* 1155 */     for (int i = 0; i < this.players.size(); i++) {
/* 1156 */       ((EntityPlayer)this.players.get(i)).playerConnection.disconnect(this.server.server.getShutdownMessage());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void sendMessage(IChatBaseComponent[] ichatbasecomponent) {
/* 1162 */     for (IChatBaseComponent component : ichatbasecomponent) {
/* 1163 */       sendMessage(component, true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void sendMessage(IChatBaseComponent ichatbasecomponent, boolean flag) {
/* 1169 */     this.server.sendMessage(ichatbasecomponent);
/* 1170 */     sendAll(new PacketPlayOutChat(ichatbasecomponent, flag));
/*      */   }
/*      */   
/*      */   public void sendMessage(IChatBaseComponent ichatbasecomponent) {
/* 1174 */     sendMessage(ichatbasecomponent, true);
/*      */   }
/*      */   
/*      */   public ServerStatisticManager a(EntityHuman entityhuman) {
/* 1178 */     UUID uuid = entityhuman.getUniqueID();
/* 1179 */     ServerStatisticManager serverstatisticmanager = (uuid == null) ? null : (ServerStatisticManager)this.n.get(uuid);
/*      */     
/* 1181 */     if (serverstatisticmanager == null) {
/* 1182 */       File file1 = new File(this.server.getWorldServer(0).getDataManager().getDirectory(), "stats");
/* 1183 */       File file2 = new File(file1, uuid.toString() + ".json");
/*      */       
/* 1185 */       if (!file2.exists()) {
/* 1186 */         File file3 = new File(file1, entityhuman.getName() + ".json");
/*      */         
/* 1188 */         if (file3.exists() && file3.isFile()) {
/* 1189 */           file3.renameTo(file2);
/*      */         }
/*      */       } 
/*      */       
/* 1193 */       serverstatisticmanager = new ServerStatisticManager(this.server, file2);
/* 1194 */       serverstatisticmanager.a();
/* 1195 */       this.n.put(uuid, serverstatisticmanager);
/*      */     } 
/*      */     
/* 1198 */     return serverstatisticmanager;
/*      */   }
/*      */   
/*      */   public void a(int i) {
/* 1202 */     this.q = i;
/* 1203 */     if (this.server.worldServer != null) {
/* 1204 */       WorldServer[] aworldserver = this.server.worldServer;
/* 1205 */       int j = aworldserver.length;
/*      */       
/* 1207 */       for (int k = 0; k < j; k++) {
/* 1208 */         WorldServer worldserver = aworldserver[k];
/*      */         
/* 1210 */         if (worldserver != null)
/* 1211 */           worldserver.getPlayerChunkMap().a(i); 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PlayerList.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */