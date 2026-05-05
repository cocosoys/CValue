/*      */ package net.minecraft.server.v1_7_R4;
/*      */ import java.io.ByteArrayInputStream;
/*      */ import java.io.DataInputStream;
/*      */ import java.io.IOException;
/*      */ import java.io.UnsupportedEncodingException;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Date;
/*      */ import java.util.HashSet;
/*      */ import java.util.Iterator;
/*      */ import java.util.Random;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.ExecutionException;
/*      */ import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
/*      */ import java.util.logging.Level;
/*      */ import net.minecraft.util.com.google.common.base.Charsets;
/*      */ import net.minecraft.util.com.google.common.collect.Lists;
/*      */ import net.minecraft.util.io.netty.buffer.Unpooled;
/*      */ import org.apache.logging.log4j.LogManager;
/*      */ import org.apache.logging.log4j.Logger;
/*      */ import org.bukkit.Bukkit;
/*      */ import org.bukkit.Location;
/*      */ import org.bukkit.Material;
/*      */ import org.bukkit.command.CommandException;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.entity.CraftPlayer;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.event.CraftEventFactory;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftInventoryView;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftItemStack;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.util.CraftChatMessage;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.util.LazyPlayerSet;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.util.Waitable;
/*      */ import org.bukkit.entity.Player;
/*      */ import org.bukkit.event.Event;
/*      */ import org.bukkit.event.block.Action;
/*      */ import org.bukkit.event.block.SignChangeEvent;
/*      */ import org.bukkit.event.inventory.ClickType;
/*      */ import org.bukkit.event.inventory.CraftItemEvent;
/*      */ import org.bukkit.event.inventory.InventoryAction;
/*      */ import org.bukkit.event.inventory.InventoryClickEvent;
/*      */ import org.bukkit.event.inventory.InventoryCreativeEvent;
/*      */ import org.bukkit.event.inventory.InventoryType;
/*      */ import org.bukkit.event.player.AsyncPlayerChatEvent;
/*      */ import org.bukkit.event.player.PlayerAnimationEvent;
/*      */ import org.bukkit.event.player.PlayerChatEvent;
/*      */ import org.bukkit.event.player.PlayerCommandPreprocessEvent;
/*      */ import org.bukkit.event.player.PlayerInteractEntityEvent;
/*      */ import org.bukkit.event.player.PlayerInteractEvent;
/*      */ import org.bukkit.event.player.PlayerItemHeldEvent;
/*      */ import org.bukkit.event.player.PlayerKickEvent;
/*      */ import org.bukkit.event.player.PlayerMoveEvent;
/*      */ import org.bukkit.event.player.PlayerTeleportEvent;
/*      */ import org.bukkit.event.player.PlayerToggleFlightEvent;
/*      */ import org.bukkit.event.player.PlayerToggleSneakEvent;
/*      */ import org.bukkit.event.player.PlayerToggleSprintEvent;
/*      */ import org.bukkit.inventory.CraftingInventory;
/*      */ import org.bukkit.inventory.Inventory;
/*      */ import org.bukkit.inventory.InventoryView;
/*      */ import org.bukkit.inventory.ItemStack;
/*      */ import org.bukkit.inventory.Recipe;
/*      */ import org.bukkit.util.NumberConversions;
/*      */ 
/*      */ public class PlayerConnection implements PacketPlayInListener {
/*   64 */   private static final Logger c = LogManager.getLogger();
/*      */   public final NetworkManager networkManager;
/*      */   private final MinecraftServer minecraftServer;
/*      */   public EntityPlayer player;
/*      */   private int e;
/*      */   private int f;
/*      */   private boolean g;
/*      */   private int h;
/*      */   private long i;
/*   73 */   private static Random j = new Random(); private long k;
/*      */   private volatile int chatThrottle;
/*   75 */   private static final AtomicIntegerFieldUpdater chatSpamField = AtomicIntegerFieldUpdater.newUpdater(PlayerConnection.class, "chatThrottle");
/*      */   private int x;
/*   77 */   private IntHashMap n = new IntHashMap(); private double y; private double z; private double q;
/*      */   public boolean checkMovement = true;
/*      */   private boolean processedDisconnect;
/*      */   private final CraftServer server;
/*      */   private int lastTick;
/*      */   private int lastDropTick;
/*      */   private int dropCount;
/*      */   private static final int SURVIVAL_PLACE_DISTANCE_SQUARED = 36;
/*      */   private static final int CREATIVE_PLACE_DISTANCE_SQUARED = 49;
/*      */   private double lastPosX;
/*      */   private double lastPosY;
/*      */   private double lastPosZ;
/*      */   private float lastPitch;
/*      */   private float lastYaw;
/*      */   private boolean justTeleported;
/*      */   Long lastPacket;
/*      */   private Item lastMaterial;
/*      */   
/*      */   public PlayerConnection(MinecraftServer minecraftserver, NetworkManager networkmanager, EntityPlayer entityplayer) {
/*   96 */     this.lastTick = MinecraftServer.currentTick;
/*   97 */     this.lastDropTick = MinecraftServer.currentTick;
/*   98 */     this.dropCount = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  103 */     this.lastPosX = Double.MAX_VALUE;
/*  104 */     this.lastPosY = Double.MAX_VALUE;
/*  105 */     this.lastPosZ = Double.MAX_VALUE;
/*  106 */     this.lastPitch = Float.MAX_VALUE;
/*  107 */     this.lastYaw = Float.MAX_VALUE;
/*  108 */     this.justTeleported = false;
/*      */     this.minecraftServer = minecraftserver;
/*      */     this.networkManager = networkmanager;
/*      */     networkmanager.a(this);
/*      */     this.player = entityplayer;
/*      */     entityplayer.playerConnection = this;
/*      */     this.server = minecraftserver.server;
/*      */   }
/*      */   public CraftPlayer getPlayer() {
/*  117 */     return (this.player == null) ? null : this.player.getBukkitEntity();
/*      */   }
/*  119 */   private static final HashSet<Integer> invalidItems = new HashSet<Integer>(Arrays.asList(new Integer[] { Integer.valueOf(8), Integer.valueOf(9), Integer.valueOf(10), Integer.valueOf(11), Integer.valueOf(26), Integer.valueOf(34), Integer.valueOf(36), Integer.valueOf(43), Integer.valueOf(51), Integer.valueOf(52), Integer.valueOf(55), Integer.valueOf(59), Integer.valueOf(60), Integer.valueOf(62), Integer.valueOf(63), Integer.valueOf(64), Integer.valueOf(68), Integer.valueOf(71), Integer.valueOf(74), Integer.valueOf(75), Integer.valueOf(83), Integer.valueOf(90), Integer.valueOf(92), Integer.valueOf(93), Integer.valueOf(94), Integer.valueOf(104), Integer.valueOf(105), Integer.valueOf(115), Integer.valueOf(117), Integer.valueOf(118), Integer.valueOf(119), Integer.valueOf(125), Integer.valueOf(127), Integer.valueOf(132), Integer.valueOf(137), Integer.valueOf(140), Integer.valueOf(141), Integer.valueOf(142), Integer.valueOf(144) }));
/*      */ 
/*      */   
/*      */   public void a() {
/*  123 */     this.g = false;
/*  124 */     this.e++;
/*  125 */     this.minecraftServer.methodProfiler.a("keepAlive");
/*  126 */     if (this.e - this.k > 40L) {
/*  127 */       this.k = this.e;
/*  128 */       this.i = d();
/*  129 */       this.h = (int)this.i;
/*  130 */       sendPacket(new PacketPlayOutKeepAlive(this.h));
/*      */     } 
/*      */     
/*      */     int spam;
/*  134 */     while ((spam = this.chatThrottle) > 0 && !chatSpamField.compareAndSet(this, spam, spam - 1));
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  142 */     if (this.x > 0) {
/*  143 */       this.x--;
/*      */     }
/*      */     
/*  146 */     if (this.player.x() > 0L && this.minecraftServer.getIdleTimeout() > 0 && MinecraftServer.ar() - this.player.x() > (this.minecraftServer.getIdleTimeout() * 1000 * 60)) {
/*  147 */       disconnect("You have been idle for too long!");
/*      */     }
/*      */   }
/*      */   
/*      */   public NetworkManager b() {
/*  152 */     return this.networkManager;
/*      */   }
/*      */ 
/*      */   
/*      */   public void disconnect(String s) {
/*  157 */     String leaveMessage = EnumChatFormat.YELLOW + this.player.getName() + " left the game.";
/*      */     
/*  159 */     PlayerKickEvent event = new PlayerKickEvent(this.server.getPlayer(this.player), s, leaveMessage);
/*      */     
/*  161 */     if (this.server.getServer().isRunning()) {
/*  162 */       this.server.getPluginManager().callEvent((Event)event);
/*      */     }
/*      */     
/*  165 */     if (event.isCancelled()) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/*  170 */     s = event.getReason();
/*      */     
/*  172 */     ChatComponentText chatcomponenttext = new ChatComponentText(s);
/*      */     
/*  174 */     this.networkManager.handle(new PacketPlayOutKickDisconnect(chatcomponenttext), new GenericFutureListener[] { new PlayerConnectionFuture(this, chatcomponenttext) });
/*  175 */     a(chatcomponenttext);
/*  176 */     this.networkManager.g();
/*      */   }
/*      */   
/*      */   public void a(PacketPlayInSteerVehicle packetplayinsteervehicle) {
/*  180 */     this.player.a(packetplayinsteervehicle.c(), packetplayinsteervehicle.d(), packetplayinsteervehicle.e(), packetplayinsteervehicle.f());
/*      */   }
/*      */ 
/*      */   
/*      */   public void a(PacketPlayInFlying packetplayinflying) {
/*  185 */     if (Double.isNaN(packetplayinflying.x) || Double.isNaN(packetplayinflying.y) || Double.isNaN(packetplayinflying.z) || Double.isNaN(packetplayinflying.stance)) {
/*  186 */       c.warn(this.player.getName() + " was caught trying to crash the server with an invalid position.");
/*  187 */       getPlayer().kickPlayer("Nope!");
/*      */       
/*      */       return;
/*      */     } 
/*  191 */     WorldServer worldserver = this.minecraftServer.getWorldServer(this.player.dimension);
/*      */     
/*  193 */     this.g = true;
/*  194 */     if (!this.player.viewingCredits) {
/*      */ 
/*      */       
/*  197 */       if (!this.checkMovement) {
/*  198 */         double d0 = packetplayinflying.d() - this.z;
/*  199 */         if (packetplayinflying.c() == this.y && d0 * d0 < 0.01D && packetplayinflying.e() == this.q) {
/*  200 */           this.checkMovement = true;
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/*  205 */       CraftPlayer craftPlayer = getPlayer();
/*  206 */       Location from = new Location(craftPlayer.getWorld(), this.lastPosX, this.lastPosY, this.lastPosZ, this.lastYaw, this.lastPitch);
/*  207 */       Location to = craftPlayer.getLocation().clone();
/*      */ 
/*      */       
/*  210 */       if (packetplayinflying.hasPos && (!packetplayinflying.hasPos || packetplayinflying.y != -999.0D || packetplayinflying.stance != -999.0D)) {
/*  211 */         to.setX(packetplayinflying.x);
/*  212 */         to.setY(packetplayinflying.y);
/*  213 */         to.setZ(packetplayinflying.z);
/*      */       } 
/*      */ 
/*      */       
/*  217 */       if (packetplayinflying.hasLook) {
/*  218 */         to.setYaw(packetplayinflying.yaw);
/*  219 */         to.setPitch(packetplayinflying.pitch);
/*      */       } 
/*      */ 
/*      */       
/*  223 */       double delta = Math.pow(this.lastPosX - to.getX(), 2.0D) + Math.pow(this.lastPosY - to.getY(), 2.0D) + Math.pow(this.lastPosZ - to.getZ(), 2.0D);
/*  224 */       float deltaAngle = Math.abs(this.lastYaw - to.getYaw()) + Math.abs(this.lastPitch - to.getPitch());
/*      */       
/*  226 */       if ((delta > 0.00390625D || deltaAngle > 10.0F) && this.checkMovement && !this.player.dead) {
/*  227 */         this.lastPosX = to.getX();
/*  228 */         this.lastPosY = to.getY();
/*  229 */         this.lastPosZ = to.getZ();
/*  230 */         this.lastYaw = to.getYaw();
/*  231 */         this.lastPitch = to.getPitch();
/*      */ 
/*      */         
/*  234 */         if (from.getX() != Double.MAX_VALUE) {
/*  235 */           PlayerMoveEvent event = new PlayerMoveEvent((Player)craftPlayer, from, to);
/*  236 */           this.server.getPluginManager().callEvent((Event)event);
/*      */ 
/*      */           
/*  239 */           if (event.isCancelled()) {
/*  240 */             this.player.playerConnection.sendPacket(new PacketPlayOutPosition(from.getX(), from.getY() + 1.6200000047683716D, from.getZ(), from.getYaw(), from.getPitch(), false));
/*      */ 
/*      */             
/*      */             return;
/*      */           } 
/*      */ 
/*      */           
/*  247 */           if (!to.equals(event.getTo()) && !event.isCancelled()) {
/*  248 */             this.player.getBukkitEntity().teleport(event.getTo(), PlayerTeleportEvent.TeleportCause.UNKNOWN);
/*      */ 
/*      */             
/*      */             return;
/*      */           } 
/*      */           
/*  254 */           if (!from.equals(getPlayer().getLocation()) && this.justTeleported) {
/*  255 */             this.justTeleported = false;
/*      */             
/*      */             return;
/*      */           } 
/*      */         } 
/*      */       } 
/*  261 */       if (this.checkMovement && !this.player.dead) {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */         
/*  267 */         if (this.player.vehicle != null) {
/*  268 */           float f = this.player.yaw;
/*  269 */           float f1 = this.player.pitch;
/*      */           
/*  271 */           this.player.vehicle.ac();
/*  272 */           double d12 = this.player.locX;
/*  273 */           double d13 = this.player.locY;
/*  274 */           double d14 = this.player.locZ;
/*  275 */           if (packetplayinflying.k()) {
/*  276 */             f = packetplayinflying.g();
/*  277 */             f1 = packetplayinflying.h();
/*      */           } 
/*      */           
/*  280 */           this.player.onGround = packetplayinflying.i();
/*  281 */           this.player.i();
/*  282 */           this.player.V = 0.0F;
/*  283 */           this.player.setLocation(d12, d13, d14, f, f1);
/*  284 */           if (this.player.vehicle != null) {
/*  285 */             this.player.vehicle.ac();
/*      */           }
/*      */           
/*  288 */           this.minecraftServer.getPlayerList().d(this.player);
/*  289 */           if (this.checkMovement) {
/*  290 */             this.y = this.player.locX;
/*  291 */             this.z = this.player.locY;
/*  292 */             this.q = this.player.locZ;
/*      */           } 
/*      */           
/*  295 */           worldserver.playerJoinedWorld(this.player);
/*      */           
/*      */           return;
/*      */         } 
/*  299 */         if (this.player.isSleeping()) {
/*  300 */           this.player.i();
/*  301 */           this.player.setLocation(this.y, this.z, this.q, this.player.yaw, this.player.pitch);
/*  302 */           worldserver.playerJoinedWorld(this.player);
/*      */           
/*      */           return;
/*      */         } 
/*  306 */         double d0 = this.player.locY;
/*  307 */         this.y = this.player.locX;
/*  308 */         this.z = this.player.locY;
/*  309 */         this.q = this.player.locZ;
/*  310 */         double d1 = this.player.locX;
/*  311 */         double d2 = this.player.locY;
/*  312 */         double d3 = this.player.locZ;
/*  313 */         float f2 = this.player.yaw;
/*  314 */         float f3 = this.player.pitch;
/*      */         
/*  316 */         if (packetplayinflying.j() && packetplayinflying.d() == -999.0D && packetplayinflying.f() == -999.0D) {
/*  317 */           packetplayinflying.a(false);
/*      */         }
/*      */ 
/*      */ 
/*      */         
/*  322 */         if (packetplayinflying.j()) {
/*  323 */           d1 = packetplayinflying.c();
/*  324 */           d2 = packetplayinflying.d();
/*  325 */           d3 = packetplayinflying.e();
/*  326 */           double d = packetplayinflying.f() - packetplayinflying.d();
/*  327 */           if (!this.player.isSleeping() && (d > 1.65D || d < 0.1D)) {
/*  328 */             disconnect("Illegal stance");
/*  329 */             c.warn(this.player.getName() + " had an illegal stance: " + d);
/*      */             
/*      */             return;
/*      */           } 
/*  333 */           if (Math.abs(packetplayinflying.c()) > 3.2E7D || Math.abs(packetplayinflying.e()) > 3.2E7D) {
/*  334 */             disconnect("Illegal position");
/*      */             
/*      */             return;
/*      */           } 
/*      */         } 
/*  339 */         if (packetplayinflying.k()) {
/*  340 */           f2 = packetplayinflying.g();
/*  341 */           f3 = packetplayinflying.h();
/*      */         } 
/*      */         
/*  344 */         this.player.i();
/*  345 */         this.player.V = 0.0F;
/*  346 */         this.player.setLocation(this.y, this.z, this.q, f2, f3);
/*  347 */         if (!this.checkMovement) {
/*      */           return;
/*      */         }
/*      */         
/*  351 */         double d4 = d1 - this.player.locX;
/*  352 */         double d5 = d2 - this.player.locY;
/*  353 */         double d6 = d3 - this.player.locZ;
/*      */         
/*  355 */         double d7 = Math.max(Math.abs(d4), Math.abs(this.player.motX));
/*  356 */         double d8 = Math.max(Math.abs(d5), Math.abs(this.player.motY));
/*  357 */         double d9 = Math.max(Math.abs(d6), Math.abs(this.player.motZ));
/*      */         
/*  359 */         double d10 = d7 * d7 + d8 * d8 + d9 * d9;
/*      */         
/*  361 */         if (d10 > 100.0D && this.checkMovement && (!this.minecraftServer.N() || !this.minecraftServer.M().equals(this.player.getName()))) {
/*  362 */           c.warn(this.player.getName() + " moved too quickly! " + d4 + "," + d5 + "," + d6 + " (" + d7 + ", " + d8 + ", " + d9 + ")");
/*  363 */           a(this.y, this.z, this.q, this.player.yaw, this.player.pitch);
/*      */           
/*      */           return;
/*      */         } 
/*  367 */         float f4 = 0.0625F;
/*  368 */         boolean flag = worldserver.getCubes(this.player, this.player.boundingBox.clone().shrink(f4, f4, f4)).isEmpty();
/*      */         
/*  370 */         if (this.player.onGround && !packetplayinflying.i() && d5 > 0.0D) {
/*  371 */           this.player.bj();
/*      */         }
/*      */         
/*  374 */         this.player.move(d4, d5, d6);
/*  375 */         this.player.onGround = packetplayinflying.i();
/*  376 */         this.player.checkMovement(d4, d5, d6);
/*  377 */         double d11 = d5;
/*      */         
/*  379 */         d4 = d1 - this.player.locX;
/*  380 */         d5 = d2 - this.player.locY;
/*  381 */         if (d5 > -0.5D || d5 < 0.5D) {
/*  382 */           d5 = 0.0D;
/*      */         }
/*      */         
/*  385 */         d6 = d3 - this.player.locZ;
/*  386 */         d10 = d4 * d4 + d5 * d5 + d6 * d6;
/*  387 */         boolean flag1 = false;
/*      */         
/*  389 */         if (d10 > 0.0625D && !this.player.isSleeping() && !this.player.playerInteractManager.isCreative()) {
/*  390 */           flag1 = true;
/*  391 */           c.warn(this.player.getName() + " moved wrongly!");
/*      */         } 
/*      */         
/*  394 */         this.player.setLocation(d1, d2, d3, f2, f3);
/*  395 */         boolean flag2 = worldserver.getCubes(this.player, this.player.boundingBox.clone().shrink(f4, f4, f4)).isEmpty();
/*      */         
/*  397 */         if (flag && (flag1 || !flag2) && !this.player.isSleeping()) {
/*  398 */           a(this.y, this.z, this.q, f2, f3);
/*      */           
/*      */           return;
/*      */         } 
/*  402 */         AxisAlignedBB axisalignedbb = this.player.boundingBox.clone().grow(f4, f4, f4).a(0.0D, -0.55D, 0.0D);
/*      */         
/*  404 */         if (!this.minecraftServer.getAllowFlight() && !this.player.abilities.canFly && !worldserver.c(axisalignedbb)) {
/*  405 */           if (d11 >= -0.03125D) {
/*  406 */             this.f++;
/*  407 */             if (this.f > 80) {
/*  408 */               c.warn(this.player.getName() + " was kicked for floating too long!");
/*  409 */               disconnect("Flying is not enabled on this server");
/*      */               return;
/*      */             } 
/*      */           } 
/*      */         } else {
/*  414 */           this.f = 0;
/*      */         } 
/*      */         
/*  417 */         this.player.onGround = packetplayinflying.i();
/*  418 */         this.minecraftServer.getPlayerList().d(this.player);
/*  419 */         this.player.b(this.player.locY - d0, packetplayinflying.i());
/*  420 */       } else if (this.e % 20 == 0) {
/*  421 */         a(this.y, this.z, this.q, this.player.yaw, this.player.pitch);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void a(double d0, double d1, double d2, float f, float f1) {
/*  428 */     CraftPlayer craftPlayer = getPlayer();
/*  429 */     Location from = craftPlayer.getLocation();
/*  430 */     Location to = new Location(getPlayer().getWorld(), d0, d1, d2, f, f1);
/*  431 */     PlayerTeleportEvent event = new PlayerTeleportEvent((Player)craftPlayer, from, to, PlayerTeleportEvent.TeleportCause.UNKNOWN);
/*  432 */     this.server.getPluginManager().callEvent((Event)event);
/*      */     
/*  434 */     from = event.getFrom();
/*  435 */     to = event.isCancelled() ? from : event.getTo();
/*      */     
/*  437 */     teleport(to);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void teleport(Location dest) {
/*  444 */     double d0 = dest.getX();
/*  445 */     double d1 = dest.getY();
/*  446 */     double d2 = dest.getZ();
/*  447 */     float f = dest.getYaw();
/*  448 */     float f1 = dest.getPitch();
/*      */ 
/*      */     
/*  451 */     if (Float.isNaN(f)) {
/*  452 */       f = 0.0F;
/*      */     }
/*      */     
/*  455 */     if (Float.isNaN(f1)) {
/*  456 */       f1 = 0.0F;
/*      */     }
/*      */     
/*  459 */     this.lastPosX = d0;
/*  460 */     this.lastPosY = d1;
/*  461 */     this.lastPosZ = d2;
/*  462 */     this.lastYaw = f;
/*  463 */     this.lastPitch = f1;
/*  464 */     this.justTeleported = true;
/*      */ 
/*      */     
/*  467 */     this.checkMovement = false;
/*  468 */     this.y = d0;
/*  469 */     this.z = d1;
/*  470 */     this.q = d2;
/*  471 */     this.player.setLocation(d0, d1, d2, f, f1);
/*  472 */     this.player.playerConnection.sendPacket(new PacketPlayOutPosition(d0, d1 + 1.6200000047683716D, d2, f, f1, false));
/*      */   }
/*      */   
/*      */   public void a(PacketPlayInBlockDig packetplayinblockdig) {
/*  476 */     if (this.player.dead)
/*  477 */       return;  WorldServer worldserver = this.minecraftServer.getWorldServer(this.player.dimension);
/*      */     
/*  479 */     this.player.v();
/*  480 */     if (packetplayinblockdig.g() == 4) {
/*      */ 
/*      */       
/*  483 */       if (this.lastDropTick != MinecraftServer.currentTick) {
/*  484 */         this.dropCount = 0;
/*  485 */         this.lastDropTick = MinecraftServer.currentTick;
/*      */       } else {
/*      */         
/*  488 */         this.dropCount++;
/*  489 */         if (this.dropCount >= 20) {
/*  490 */           this; c.warn(this.player.getName() + " dropped their items too quickly!");
/*  491 */           disconnect("You dropped your items too quickly (Hacking?)");
/*      */           
/*      */           return;
/*      */         } 
/*      */       } 
/*  496 */       this.player.a(false);
/*  497 */     } else if (packetplayinblockdig.g() == 3) {
/*  498 */       this.player.a(true);
/*  499 */     } else if (packetplayinblockdig.g() == 5) {
/*  500 */       this.player.bA();
/*      */     } else {
/*  502 */       boolean flag = false;
/*      */       
/*  504 */       if (packetplayinblockdig.g() == 0) {
/*  505 */         flag = true;
/*      */       }
/*      */       
/*  508 */       if (packetplayinblockdig.g() == 1) {
/*  509 */         flag = true;
/*      */       }
/*      */       
/*  512 */       if (packetplayinblockdig.g() == 2) {
/*  513 */         flag = true;
/*      */       }
/*      */       
/*  516 */       int i = packetplayinblockdig.c();
/*  517 */       int j = packetplayinblockdig.d();
/*  518 */       int k = packetplayinblockdig.e();
/*      */       
/*  520 */       if (flag) {
/*  521 */         double d0 = this.player.locX - i + 0.5D;
/*  522 */         double d1 = this.player.locY - j + 0.5D + 1.5D;
/*  523 */         double d2 = this.player.locZ - k + 0.5D;
/*  524 */         double d3 = d0 * d0 + d1 * d1 + d2 * d2;
/*      */         
/*  526 */         if (d3 > 36.0D) {
/*      */           return;
/*      */         }
/*      */         
/*  530 */         if (j >= this.minecraftServer.getMaxBuildHeight()) {
/*      */           return;
/*      */         }
/*      */       } 
/*      */       
/*  535 */       if (packetplayinblockdig.g() == 0) {
/*  536 */         if (!this.minecraftServer.a(worldserver, i, j, k, this.player)) {
/*  537 */           this.player.playerInteractManager.dig(i, j, k, packetplayinblockdig.f());
/*      */         } else {
/*      */           
/*  540 */           CraftEventFactory.callPlayerInteractEvent(this.player, Action.LEFT_CLICK_BLOCK, i, j, k, packetplayinblockdig.f(), this.player.inventory.getItemInHand());
/*  541 */           this.player.playerConnection.sendPacket(new PacketPlayOutBlockChange(i, j, k, worldserver));
/*      */           
/*  543 */           TileEntity tileentity = worldserver.getTileEntity(i, j, k);
/*  544 */           if (tileentity != null) {
/*  545 */             this.player.playerConnection.sendPacket(tileentity.getUpdatePacket());
/*      */           }
/*      */         }
/*      */       
/*  549 */       } else if (packetplayinblockdig.g() == 2) {
/*  550 */         this.player.playerInteractManager.a(i, j, k);
/*  551 */         if (worldserver.getType(i, j, k).getMaterial() != Material.AIR) {
/*  552 */           this.player.playerConnection.sendPacket(new PacketPlayOutBlockChange(i, j, k, worldserver));
/*      */         }
/*  554 */       } else if (packetplayinblockdig.g() == 1) {
/*  555 */         this.player.playerInteractManager.c(i, j, k);
/*  556 */         if (worldserver.getType(i, j, k).getMaterial() != Material.AIR) {
/*  557 */           this.player.playerConnection.sendPacket(new PacketPlayOutBlockChange(i, j, k, worldserver));
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(PacketPlayInBlockPlace packetplayinblockplace) {
/*  564 */     WorldServer worldserver = this.minecraftServer.getWorldServer(this.player.dimension);
/*      */ 
/*      */     
/*  567 */     if (this.player.dead) {
/*      */       return;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  576 */     if (packetplayinblockplace.getFace() == 255) {
/*  577 */       if (packetplayinblockplace.getItemStack() != null && packetplayinblockplace.getItemStack().getItem() == this.lastMaterial && this.lastPacket != null && packetplayinblockplace.timestamp - this.lastPacket.longValue() < 100L) {
/*  578 */         this.lastPacket = null;
/*      */         return;
/*      */       } 
/*      */     } else {
/*  582 */       this.lastMaterial = (packetplayinblockplace.getItemStack() == null) ? null : packetplayinblockplace.getItemStack().getItem();
/*  583 */       this.lastPacket = Long.valueOf(packetplayinblockplace.timestamp);
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/*  588 */     boolean always = false;
/*      */ 
/*      */     
/*  591 */     ItemStack itemstack = this.player.inventory.getItemInHand();
/*  592 */     boolean flag = false;
/*  593 */     int i = packetplayinblockplace.c();
/*  594 */     int j = packetplayinblockplace.d();
/*  595 */     int k = packetplayinblockplace.e();
/*  596 */     int l = packetplayinblockplace.getFace();
/*      */     
/*  598 */     this.player.v();
/*  599 */     if (packetplayinblockplace.getFace() == 255) {
/*  600 */       if (itemstack == null) {
/*      */         return;
/*      */       }
/*      */ 
/*      */       
/*  605 */       int itemstackAmount = itemstack.count;
/*  606 */       PlayerInteractEvent event = CraftEventFactory.callPlayerInteractEvent(this.player, Action.RIGHT_CLICK_AIR, itemstack);
/*  607 */       if (event.useItemInHand() != Event.Result.DENY) {
/*  608 */         this.player.playerInteractManager.useItem(this.player, this.player.world, itemstack);
/*      */       }
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  614 */       always = (itemstack.count != itemstackAmount || itemstack.getItem() == Item.getItemOf(Blocks.WATER_LILY));
/*      */     }
/*  616 */     else if (packetplayinblockplace.d() >= this.minecraftServer.getMaxBuildHeight() - 1 && (packetplayinblockplace.getFace() == 1 || packetplayinblockplace.d() >= this.minecraftServer.getMaxBuildHeight())) {
/*  617 */       ChatMessage chatmessage = new ChatMessage("build.tooHigh", new Object[] { Integer.valueOf(this.minecraftServer.getMaxBuildHeight()) });
/*      */       
/*  619 */       chatmessage.getChatModifier().setColor(EnumChatFormat.RED);
/*  620 */       this.player.playerConnection.sendPacket(new PacketPlayOutChat(chatmessage));
/*  621 */       flag = true;
/*      */     } else {
/*      */       
/*  624 */       Location eyeLoc = getPlayer().getEyeLocation();
/*  625 */       double reachDistance = NumberConversions.square(eyeLoc.getX() - i) + NumberConversions.square(eyeLoc.getY() - j) + NumberConversions.square(eyeLoc.getZ() - k);
/*  626 */       if (reachDistance > ((getPlayer().getGameMode() == GameMode.CREATIVE) ? 49 : 36)) {
/*      */         return;
/*      */       }
/*      */       
/*  630 */       if (!this.player.playerInteractManager.interact(this.player, worldserver, itemstack, i, j, k, l, packetplayinblockplace.h(), packetplayinblockplace.i(), packetplayinblockplace.j())) {
/*  631 */         always = true;
/*      */       }
/*      */ 
/*      */       
/*  635 */       flag = true;
/*      */     } 
/*      */     
/*  638 */     if (flag) {
/*  639 */       this.player.playerConnection.sendPacket(new PacketPlayOutBlockChange(i, j, k, worldserver));
/*  640 */       if (l == 0) {
/*  641 */         j--;
/*      */       }
/*      */       
/*  644 */       if (l == 1) {
/*  645 */         j++;
/*      */       }
/*      */       
/*  648 */       if (l == 2) {
/*  649 */         k--;
/*      */       }
/*      */       
/*  652 */       if (l == 3) {
/*  653 */         k++;
/*      */       }
/*      */       
/*  656 */       if (l == 4) {
/*  657 */         i--;
/*      */       }
/*      */       
/*  660 */       if (l == 5) {
/*  661 */         i++;
/*      */       }
/*      */       
/*  664 */       this.player.playerConnection.sendPacket(new PacketPlayOutBlockChange(i, j, k, worldserver));
/*      */     } 
/*      */     
/*  667 */     itemstack = this.player.inventory.getItemInHand();
/*  668 */     if (itemstack != null && itemstack.count == 0) {
/*  669 */       this.player.inventory.items[this.player.inventory.itemInHandIndex] = null;
/*  670 */       itemstack = null;
/*      */     } 
/*      */     
/*  673 */     if (itemstack == null || itemstack.n() == 0) {
/*  674 */       this.player.g = true;
/*  675 */       this.player.inventory.items[this.player.inventory.itemInHandIndex] = ItemStack.b(this.player.inventory.items[this.player.inventory.itemInHandIndex]);
/*  676 */       Slot slot = this.player.activeContainer.getSlot(this.player.inventory, this.player.inventory.itemInHandIndex);
/*      */       
/*  678 */       this.player.activeContainer.b();
/*  679 */       this.player.g = false;
/*      */       
/*  681 */       if (!ItemStack.matches(this.player.inventory.getItemInHand(), packetplayinblockplace.getItemStack()) || always) {
/*  682 */         sendPacket(new PacketPlayOutSetSlot(this.player.activeContainer.windowId, slot.rawSlotIndex, this.player.inventory.getItemInHand()));
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void a(IChatBaseComponent ichatbasecomponent) {
/*  689 */     if (this.processedDisconnect) {
/*      */       return;
/*      */     }
/*  692 */     this.processedDisconnect = true;
/*      */ 
/*      */     
/*  695 */     c.info(this.player.getName() + " lost connection: " + ichatbasecomponent.c());
/*  696 */     this.minecraftServer.az();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  705 */     this.player.n();
/*  706 */     String quitMessage = this.minecraftServer.getPlayerList().disconnect(this.player);
/*  707 */     if (quitMessage != null && quitMessage.length() > 0) {
/*  708 */       this.minecraftServer.getPlayerList().sendMessage(CraftChatMessage.fromString(quitMessage));
/*      */     }
/*      */     
/*  711 */     if (this.minecraftServer.N() && this.player.getName().equals(this.minecraftServer.M())) {
/*  712 */       c.info("Stopping singleplayer server as player logged out");
/*  713 */       this.minecraftServer.safeShutdown();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void sendPacket(Packet packet) {
/*  718 */     if (packet instanceof PacketPlayOutChat) {
/*  719 */       PacketPlayOutChat packetplayoutchat = (PacketPlayOutChat)packet;
/*  720 */       EnumChatVisibility enumchatvisibility = this.player.getChatFlags();
/*      */       
/*  722 */       if (enumchatvisibility == EnumChatVisibility.HIDDEN) {
/*      */         return;
/*      */       }
/*      */       
/*  726 */       if (enumchatvisibility == EnumChatVisibility.SYSTEM && !packetplayoutchat.d()) {
/*      */         return;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  732 */     if (packet == null)
/*      */       return; 
/*  734 */     if (packet instanceof PacketPlayOutSpawnPosition) {
/*  735 */       PacketPlayOutSpawnPosition packet6 = (PacketPlayOutSpawnPosition)packet;
/*  736 */       this.player.compassTarget = new Location(getPlayer().getWorld(), packet6.x, packet6.y, packet6.z);
/*      */     } 
/*      */ 
/*      */     
/*      */     try {
/*  741 */       this.networkManager.handle(packet, new GenericFutureListener[0]);
/*  742 */     } catch (Throwable throwable) {
/*  743 */       CrashReport crashreport = CrashReport.a(throwable, "Sending packet");
/*  744 */       CrashReportSystemDetails crashreportsystemdetails = crashreport.a("Packet being sent");
/*      */       
/*  746 */       crashreportsystemdetails.a("Packet class", new CrashReportConnectionPacketClass(this, packet));
/*  747 */       throw new ReportedException(crashreport);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void a(PacketPlayInHeldItemSlot packetplayinhelditemslot) {
/*  753 */     if (this.player.dead)
/*      */       return; 
/*  755 */     if (packetplayinhelditemslot.c() >= 0 && packetplayinhelditemslot.c() < PlayerInventory.getHotbarSize()) {
/*  756 */       PlayerItemHeldEvent event = new PlayerItemHeldEvent((Player)getPlayer(), this.player.inventory.itemInHandIndex, packetplayinhelditemslot.c());
/*  757 */       this.server.getPluginManager().callEvent((Event)event);
/*  758 */       if (event.isCancelled()) {
/*  759 */         sendPacket(new PacketPlayOutHeldItemSlot(this.player.inventory.itemInHandIndex));
/*  760 */         this.player.v();
/*      */         
/*      */         return;
/*      */       } 
/*      */       
/*  765 */       this.player.inventory.itemInHandIndex = packetplayinhelditemslot.c();
/*  766 */       this.player.v();
/*      */     } else {
/*  768 */       c.warn(this.player.getName() + " tried to set an invalid carried item");
/*  769 */       disconnect("Nope!");
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(PacketPlayInChat packetplayinchat) {
/*  774 */     if (this.player.dead || this.player.getChatFlags() == EnumChatVisibility.HIDDEN) {
/*  775 */       ChatMessage chatmessage = new ChatMessage("chat.cannotSend", new Object[0]);
/*      */       
/*  777 */       chatmessage.getChatModifier().setColor(EnumChatFormat.RED);
/*  778 */       sendPacket(new PacketPlayOutChat(chatmessage));
/*      */     } else {
/*  780 */       this.player.v();
/*  781 */       String s = packetplayinchat.c();
/*      */       
/*  783 */       s = StringUtils.normalizeSpace(s);
/*      */       
/*  785 */       for (int i = 0; i < s.length(); i++) {
/*  786 */         if (!SharedConstants.isAllowedChatCharacter(s.charAt(i))) {
/*      */           
/*  788 */           if (packetplayinchat.a()) {
/*  789 */             Waitable waitable = new Waitable()
/*      */               {
/*      */                 protected Object evaluate() {
/*  792 */                   PlayerConnection.this.disconnect("Illegal characters in chat");
/*  793 */                   return null;
/*      */                 }
/*      */               };
/*      */             
/*  797 */             this.minecraftServer.processQueue.add(waitable);
/*      */             
/*      */             try {
/*  800 */               waitable.get();
/*  801 */             } catch (InterruptedException e) {
/*  802 */               Thread.currentThread().interrupt();
/*  803 */             } catch (ExecutionException e) {
/*  804 */               throw new RuntimeException(e);
/*      */             } 
/*      */           } else {
/*  807 */             disconnect("Illegal characters in chat");
/*      */           } 
/*      */ 
/*      */           
/*      */           return;
/*      */         } 
/*      */       } 
/*      */       
/*  815 */       if (!packetplayinchat.a()) {
/*      */         try {
/*  817 */           this.minecraftServer.server.playerCommandState = true;
/*  818 */           handleCommand(s);
/*      */         } finally {
/*  820 */           this.minecraftServer.server.playerCommandState = false;
/*      */         } 
/*  822 */       } else if (s.isEmpty()) {
/*  823 */         c.warn(this.player.getName() + " tried to send an empty message");
/*  824 */       } else if (getPlayer().isConversing()) {
/*  825 */         getPlayer().acceptConversationInput(s);
/*  826 */       } else if (this.player.getChatFlags() == EnumChatVisibility.SYSTEM) {
/*  827 */         ChatMessage chatmessage = new ChatMessage("chat.cannotSend", new Object[0]);
/*      */         
/*  829 */         chatmessage.getChatModifier().setColor(EnumChatFormat.RED);
/*  830 */         sendPacket(new PacketPlayOutChat(chatmessage));
/*      */       } else {
/*  832 */         chat(s, true);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  842 */       if (chatSpamField.addAndGet((T)this, 20) > 200 && !this.minecraftServer.getPlayerList().isOp(this.player.getProfile())) {
/*  843 */         if (packetplayinchat.a()) {
/*  844 */           Waitable waitable = new Waitable()
/*      */             {
/*      */               protected Object evaluate() {
/*  847 */                 PlayerConnection.this.disconnect("disconnect.spam");
/*  848 */                 return null;
/*      */               }
/*      */             };
/*      */           
/*  852 */           this.minecraftServer.processQueue.add(waitable);
/*      */           
/*      */           try {
/*  855 */             waitable.get();
/*  856 */           } catch (InterruptedException e) {
/*  857 */             Thread.currentThread().interrupt();
/*  858 */           } catch (ExecutionException e) {
/*  859 */             throw new RuntimeException(e);
/*      */           } 
/*      */         } else {
/*  862 */           disconnect("disconnect.spam");
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void chat(String s, boolean async) {
/*  871 */     if (s.isEmpty() || this.player.getChatFlags() == EnumChatVisibility.HIDDEN) {
/*      */       return;
/*      */     }
/*      */     
/*  875 */     if (!async && s.startsWith("/")) {
/*  876 */       handleCommand(s);
/*  877 */     } else if (this.player.getChatFlags() != EnumChatVisibility.SYSTEM) {
/*      */ 
/*      */       
/*  880 */       CraftPlayer craftPlayer = getPlayer();
/*  881 */       AsyncPlayerChatEvent event = new AsyncPlayerChatEvent(async, (Player)craftPlayer, s, (Set)new LazyPlayerSet());
/*  882 */       this.server.getPluginManager().callEvent((Event)event);
/*      */       
/*  884 */       if ((PlayerChatEvent.getHandlerList().getRegisteredListeners()).length != 0) {
/*      */         
/*  886 */         final PlayerChatEvent queueEvent = new PlayerChatEvent((Player)craftPlayer, event.getMessage(), event.getFormat(), event.getRecipients());
/*  887 */         queueEvent.setCancelled(event.isCancelled());
/*  888 */         Waitable waitable = new Waitable()
/*      */           {
/*      */             protected Object evaluate() {
/*  891 */               Bukkit.getPluginManager().callEvent((Event)queueEvent);
/*      */               
/*  893 */               if (queueEvent.isCancelled()) {
/*  894 */                 return null;
/*      */               }
/*      */               
/*  897 */               String message = String.format(queueEvent.getFormat(), new Object[] { this.val$queueEvent.getPlayer().getDisplayName(), this.val$queueEvent.getMessage() });
/*  898 */               PlayerConnection.this.minecraftServer.console.sendMessage(message);
/*  899 */               if (((LazyPlayerSet)queueEvent.getRecipients()).isLazy()) {
/*  900 */                 for (Object player : (PlayerConnection.this.minecraftServer.getPlayerList()).players) {
/*  901 */                   ((EntityPlayer)player).sendMessage(CraftChatMessage.fromString(message));
/*      */                 }
/*      */               } else {
/*  904 */                 for (Player player : queueEvent.getRecipients()) {
/*  905 */                   player.sendMessage(message);
/*      */                 }
/*      */               } 
/*  908 */               return null; }
/*      */           };
/*  910 */         if (async) {
/*  911 */           this.minecraftServer.processQueue.add(waitable);
/*      */         } else {
/*  913 */           waitable.run();
/*      */         } 
/*      */         try {
/*  916 */           waitable.get();
/*  917 */         } catch (InterruptedException e) {
/*  918 */           Thread.currentThread().interrupt();
/*  919 */         } catch (ExecutionException e) {
/*  920 */           throw new RuntimeException("Exception processing chat event", e.getCause());
/*      */         } 
/*      */       } else {
/*  923 */         if (event.isCancelled()) {
/*      */           return;
/*      */         }
/*      */         
/*  927 */         s = String.format(event.getFormat(), new Object[] { event.getPlayer().getDisplayName(), event.getMessage() });
/*  928 */         this.minecraftServer.console.sendMessage(s);
/*  929 */         if (((LazyPlayerSet)event.getRecipients()).isLazy()) {
/*  930 */           for (Object recipient : (this.minecraftServer.getPlayerList()).players) {
/*  931 */             ((EntityPlayer)recipient).sendMessage(CraftChatMessage.fromString(s));
/*      */           }
/*      */         } else {
/*  934 */           for (Player recipient : event.getRecipients()) {
/*  935 */             recipient.sendMessage(s);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void handleCommand(String s) {
/*  945 */     this; c.info(this.player.getName() + " issued server command: " + s);
/*      */     
/*  947 */     CraftPlayer player = getPlayer();
/*      */     
/*  949 */     PlayerCommandPreprocessEvent event = new PlayerCommandPreprocessEvent((Player)player, s, (Set)new LazyPlayerSet());
/*  950 */     this.server.getPluginManager().callEvent((Event)event);
/*      */     
/*  952 */     if (event.isCancelled()) {
/*      */       return;
/*      */     }
/*      */     
/*      */     try {
/*  957 */       if (this.server.dispatchCommand((CommandSender)event.getPlayer(), event.getMessage().substring(1))) {
/*      */         return;
/*      */       }
/*  960 */     } catch (CommandException ex) {
/*  961 */       player.sendMessage(ChatColor.RED + "An internal error occurred while attempting to perform this command");
/*  962 */       Logger.getLogger(PlayerConnection.class.getName()).log(Level.SEVERE, (String)null, (Throwable)ex);
/*      */       return;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(PacketPlayInArmAnimation packetplayinarmanimation) {
/*  970 */     if (this.player.dead)
/*  971 */       return;  this.player.v();
/*  972 */     if (packetplayinarmanimation.d() == 1) {
/*      */       
/*  974 */       float f = 1.0F;
/*  975 */       float f1 = this.player.lastPitch + (this.player.pitch - this.player.lastPitch) * f;
/*  976 */       float f2 = this.player.lastYaw + (this.player.yaw - this.player.lastYaw) * f;
/*  977 */       double d0 = this.player.lastX + (this.player.locX - this.player.lastX) * f;
/*  978 */       double d1 = this.player.lastY + (this.player.locY - this.player.lastY) * f + 1.62D - this.player.height;
/*  979 */       double d2 = this.player.lastZ + (this.player.locZ - this.player.lastZ) * f;
/*  980 */       Vec3D vec3d = Vec3D.a(d0, d1, d2);
/*      */       
/*  982 */       float f3 = MathHelper.cos(-f2 * 0.017453292F - 3.1415927F);
/*  983 */       float f4 = MathHelper.sin(-f2 * 0.017453292F - 3.1415927F);
/*  984 */       float f5 = -MathHelper.cos(-f1 * 0.017453292F);
/*  985 */       float f6 = MathHelper.sin(-f1 * 0.017453292F);
/*  986 */       float f7 = f4 * f5;
/*  987 */       float f8 = f3 * f5;
/*  988 */       double d3 = 5.0D;
/*  989 */       Vec3D vec3d1 = vec3d.add(f7 * d3, f6 * d3, f8 * d3);
/*  990 */       MovingObjectPosition movingobjectposition = this.player.world.rayTrace(vec3d, vec3d1, false);
/*      */       
/*  992 */       if (movingobjectposition == null || movingobjectposition.type != EnumMovingObjectType.BLOCK) {
/*  993 */         CraftEventFactory.callPlayerInteractEvent(this.player, Action.LEFT_CLICK_AIR, this.player.inventory.getItemInHand());
/*      */       }
/*      */ 
/*      */       
/*  997 */       PlayerAnimationEvent event = new PlayerAnimationEvent((Player)getPlayer());
/*  998 */       this.server.getPluginManager().callEvent((Event)event);
/*      */       
/* 1000 */       if (event.isCancelled()) {
/*      */         return;
/*      */       }
/* 1003 */       this.player.ba();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void a(PacketPlayInEntityAction packetplayinentityaction) {
/* 1009 */     if (this.player.dead)
/*      */       return; 
/* 1011 */     this.player.v();
/* 1012 */     if (packetplayinentityaction.d() == 1 || packetplayinentityaction.d() == 2) {
/* 1013 */       PlayerToggleSneakEvent event = new PlayerToggleSneakEvent((Player)getPlayer(), (packetplayinentityaction.d() == 1));
/* 1014 */       this.server.getPluginManager().callEvent((Event)event);
/*      */       
/* 1016 */       if (event.isCancelled()) {
/*      */         return;
/*      */       }
/*      */     } 
/*      */     
/* 1021 */     if (packetplayinentityaction.d() == 4 || packetplayinentityaction.d() == 5) {
/* 1022 */       PlayerToggleSprintEvent event = new PlayerToggleSprintEvent((Player)getPlayer(), (packetplayinentityaction.d() == 4));
/* 1023 */       this.server.getPluginManager().callEvent((Event)event);
/*      */       
/* 1025 */       if (event.isCancelled()) {
/*      */         return;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/* 1031 */     if (packetplayinentityaction.d() == 1) {
/* 1032 */       this.player.setSneaking(true);
/* 1033 */     } else if (packetplayinentityaction.d() == 2) {
/* 1034 */       this.player.setSneaking(false);
/* 1035 */     } else if (packetplayinentityaction.d() == 4) {
/* 1036 */       this.player.setSprinting(true);
/* 1037 */     } else if (packetplayinentityaction.d() == 5) {
/* 1038 */       this.player.setSprinting(false);
/* 1039 */     } else if (packetplayinentityaction.d() == 3) {
/* 1040 */       this.player.a(false, true, true);
/*      */     }
/* 1042 */     else if (packetplayinentityaction.d() == 6) {
/* 1043 */       if (this.player.vehicle != null && this.player.vehicle instanceof EntityHorse) {
/* 1044 */         ((EntityHorse)this.player.vehicle).w(packetplayinentityaction.e());
/*      */       }
/* 1046 */     } else if (packetplayinentityaction.d() == 7 && this.player.vehicle != null && this.player.vehicle instanceof EntityHorse) {
/* 1047 */       ((EntityHorse)this.player.vehicle).g(this.player);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(PacketPlayInUseEntity packetplayinuseentity) {
/* 1052 */     if (this.player.dead)
/* 1053 */       return;  WorldServer worldserver = this.minecraftServer.getWorldServer(this.player.dimension);
/* 1054 */     Entity entity = packetplayinuseentity.a(worldserver);
/*      */     
/* 1056 */     this.player.v();
/* 1057 */     if (entity != null) {
/* 1058 */       boolean flag = this.player.hasLineOfSight(entity);
/* 1059 */       double d0 = 36.0D;
/*      */       
/* 1061 */       if (!flag) {
/* 1062 */         d0 = 9.0D;
/*      */       }
/*      */       
/* 1065 */       if (this.player.f(entity) < d0) {
/* 1066 */         ItemStack itemInHand = this.player.inventory.getItemInHand();
/* 1067 */         if (packetplayinuseentity.c() == EnumEntityUseAction.INTERACT) {
/*      */           
/* 1069 */           boolean triggerTagUpdate = (itemInHand != null && itemInHand.getItem() == Items.NAME_TAG && entity instanceof EntityInsentient);
/* 1070 */           boolean triggerChestUpdate = (itemInHand != null && itemInHand.getItem() == Item.getItemOf(Blocks.CHEST) && entity instanceof EntityHorse);
/* 1071 */           boolean triggerLeashUpdate = (itemInHand != null && itemInHand.getItem() == Items.LEASH && entity instanceof EntityInsentient);
/* 1072 */           PlayerInteractEntityEvent event = new PlayerInteractEntityEvent((Player)getPlayer(), (Entity)entity.getBukkitEntity());
/* 1073 */           this.server.getPluginManager().callEvent((Event)event);
/*      */           
/* 1075 */           if (triggerLeashUpdate && (event.isCancelled() || this.player.inventory.getItemInHand() == null || this.player.inventory.getItemInHand().getItem() != Items.LEASH))
/*      */           {
/* 1077 */             sendPacket(new PacketPlayOutAttachEntity(1, entity, ((EntityInsentient)entity).getLeashHolder()));
/*      */           }
/*      */           
/* 1080 */           if (triggerTagUpdate && (event.isCancelled() || this.player.inventory.getItemInHand() == null || this.player.inventory.getItemInHand().getItem() != Items.NAME_TAG))
/*      */           {
/* 1082 */             sendPacket(new PacketPlayOutEntityMetadata(entity.getId(), entity.datawatcher, true));
/*      */           }
/* 1084 */           if (triggerChestUpdate && (event.isCancelled() || this.player.inventory.getItemInHand() == null || this.player.inventory.getItemInHand().getItem() != Item.getItemOf(Blocks.CHEST))) {
/* 1085 */             sendPacket(new PacketPlayOutEntityMetadata(entity.getId(), entity.datawatcher, true));
/*      */           }
/*      */           
/* 1088 */           if (event.isCancelled()) {
/*      */             return;
/*      */           }
/*      */ 
/*      */           
/* 1093 */           this.player.q(entity);
/*      */ 
/*      */           
/* 1096 */           if (itemInHand != null && itemInHand.count <= -1) {
/* 1097 */             this.player.updateInventory(this.player.activeContainer);
/*      */           }
/*      */         }
/* 1100 */         else if (packetplayinuseentity.c() == EnumEntityUseAction.ATTACK) {
/* 1101 */           if (entity instanceof EntityItem || entity instanceof EntityExperienceOrb || entity instanceof EntityArrow || entity == this.player) {
/* 1102 */             disconnect("Attempting to attack an invalid entity");
/* 1103 */             this.minecraftServer.warning("Player " + this.player.getName() + " tried to attack an invalid entity");
/*      */             
/*      */             return;
/*      */           } 
/* 1107 */           this.player.attack(entity);
/*      */ 
/*      */           
/* 1110 */           if (itemInHand != null && itemInHand.count <= -1) {
/* 1111 */             this.player.updateInventory(this.player.activeContainer);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void a(PacketPlayInClientCommand packetplayinclientcommand) {
/* 1120 */     this.player.v();
/* 1121 */     EnumClientCommand enumclientcommand = packetplayinclientcommand.c();
/*      */     
/* 1123 */     switch (ClientCommandOrdinalWrapper.a[enumclientcommand.ordinal()]) {
/*      */       case 1:
/* 1125 */         if (this.player.viewingCredits) {
/* 1126 */           this.minecraftServer.getPlayerList().changeDimension(this.player, 0, PlayerTeleportEvent.TeleportCause.END_PORTAL); break;
/* 1127 */         }  if (this.player.r().getWorldData().isHardcore()) {
/* 1128 */           if (this.minecraftServer.N() && this.player.getName().equals(this.minecraftServer.M())) {
/* 1129 */             this.player.playerConnection.disconnect("You have died. Game over, man, it's game over!");
/* 1130 */             this.minecraftServer.U(); break;
/*      */           } 
/* 1132 */           GameProfileBanEntry gameprofilebanentry = new GameProfileBanEntry(this.player.getProfile(), (Date)null, "(You just lost the game)", (Date)null, "Death in Hardcore");
/*      */           
/* 1134 */           this.minecraftServer.getPlayerList().getProfileBans().add(gameprofilebanentry);
/* 1135 */           this.player.playerConnection.disconnect("You have died. Game over, man, it's game over!");
/*      */           break;
/*      */         } 
/* 1138 */         if (this.player.getHealth() > 0.0F) {
/*      */           return;
/*      */         }
/*      */         
/* 1142 */         this.player = this.minecraftServer.getPlayerList().moveToWorld(this.player, 0, false);
/*      */         break;
/*      */ 
/*      */       
/*      */       case 2:
/* 1147 */         this.player.getStatisticManager().a(this.player);
/*      */         break;
/*      */       
/*      */       case 3:
/* 1151 */         this.player.a(AchievementList.f);
/*      */         break;
/*      */     } 
/*      */   }
/*      */   public void a(PacketPlayInCloseWindow packetplayinclosewindow) {
/* 1156 */     if (this.player.dead)
/*      */       return; 
/* 1158 */     CraftEventFactory.handleInventoryCloseEvent(this.player);
/*      */     
/* 1160 */     this.player.m();
/*      */   }
/*      */   
/*      */   public void a(PacketPlayInWindowClick packetplayinwindowclick) {
/* 1164 */     if (this.player.dead)
/*      */       return; 
/* 1166 */     this.player.v();
/* 1167 */     if (this.player.activeContainer.windowId == packetplayinwindowclick.c() && this.player.activeContainer.c(this.player)) {
/*      */       
/* 1169 */       if (packetplayinwindowclick.d() < -1 && packetplayinwindowclick.d() != -999) {
/*      */         return;
/*      */       }
/*      */       
/* 1173 */       InventoryView inventory = this.player.activeContainer.getBukkitView();
/* 1174 */       InventoryType.SlotType type = CraftInventoryView.getSlotType(inventory, packetplayinwindowclick.d());
/*      */       
/* 1176 */       InventoryClickEvent event = null;
/* 1177 */       ClickType click = ClickType.UNKNOWN;
/* 1178 */       InventoryAction action = InventoryAction.UNKNOWN;
/*      */       
/* 1180 */       ItemStack itemstack = null;
/*      */       
/* 1182 */       if (packetplayinwindowclick.d() == -1) {
/* 1183 */         type = InventoryType.SlotType.OUTSIDE;
/* 1184 */         click = (packetplayinwindowclick.e() == 0) ? ClickType.WINDOW_BORDER_LEFT : ClickType.WINDOW_BORDER_RIGHT;
/* 1185 */         action = InventoryAction.NOTHING;
/* 1186 */       } else if (packetplayinwindowclick.h() == 0) {
/* 1187 */         if (packetplayinwindowclick.e() == 0) {
/* 1188 */           click = ClickType.LEFT;
/* 1189 */         } else if (packetplayinwindowclick.e() == 1) {
/* 1190 */           click = ClickType.RIGHT;
/*      */         } 
/* 1192 */         if (packetplayinwindowclick.e() == 0 || packetplayinwindowclick.e() == 1) {
/* 1193 */           action = InventoryAction.NOTHING;
/* 1194 */           if (packetplayinwindowclick.d() == -999) {
/* 1195 */             if (this.player.inventory.getCarried() != null) {
/* 1196 */               action = (packetplayinwindowclick.e() == 0) ? InventoryAction.DROP_ALL_CURSOR : InventoryAction.DROP_ONE_CURSOR;
/*      */             }
/*      */           } else {
/* 1199 */             Slot slot = this.player.activeContainer.getSlot(packetplayinwindowclick.d());
/* 1200 */             if (slot != null) {
/* 1201 */               ItemStack clickedItem = slot.getItem();
/* 1202 */               ItemStack cursor = this.player.inventory.getCarried();
/* 1203 */               if (clickedItem == null) {
/* 1204 */                 if (cursor != null) {
/* 1205 */                   action = (packetplayinwindowclick.e() == 0) ? InventoryAction.PLACE_ALL : InventoryAction.PLACE_ONE;
/*      */                 }
/* 1207 */               } else if (slot.isAllowed(this.player)) {
/* 1208 */                 if (cursor == null) {
/* 1209 */                   action = (packetplayinwindowclick.e() == 0) ? InventoryAction.PICKUP_ALL : InventoryAction.PICKUP_HALF;
/* 1210 */                 } else if (slot.isAllowed(cursor)) {
/* 1211 */                   if (clickedItem.doMaterialsMatch(cursor) && ItemStack.equals(clickedItem, cursor)) {
/* 1212 */                     int toPlace = (packetplayinwindowclick.e() == 0) ? cursor.count : 1;
/* 1213 */                     toPlace = Math.min(toPlace, clickedItem.getMaxStackSize() - clickedItem.count);
/* 1214 */                     toPlace = Math.min(toPlace, slot.inventory.getMaxStackSize() - clickedItem.count);
/* 1215 */                     if (toPlace == 1) {
/* 1216 */                       action = InventoryAction.PLACE_ONE;
/* 1217 */                     } else if (toPlace == cursor.count) {
/* 1218 */                       action = InventoryAction.PLACE_ALL;
/* 1219 */                     } else if (toPlace < 0) {
/* 1220 */                       action = (toPlace != -1) ? InventoryAction.PICKUP_SOME : InventoryAction.PICKUP_ONE;
/* 1221 */                     } else if (toPlace != 0) {
/* 1222 */                       action = InventoryAction.PLACE_SOME;
/*      */                     } 
/* 1224 */                   } else if (cursor.count <= slot.getMaxStackSize()) {
/* 1225 */                     action = InventoryAction.SWAP_WITH_CURSOR;
/*      */                   } 
/* 1227 */                 } else if (cursor.getItem() == clickedItem.getItem() && (!cursor.usesData() || cursor.getData() == clickedItem.getData()) && ItemStack.equals(cursor, clickedItem) && 
/* 1228 */                   clickedItem.count >= 0 && 
/* 1229 */                   clickedItem.count + cursor.count <= cursor.getMaxStackSize()) {
/*      */                   
/* 1231 */                   action = InventoryAction.PICKUP_ALL;
/*      */                 }
/*      */               
/*      */               }
/*      */             
/*      */             } 
/*      */           } 
/*      */         } 
/* 1239 */       } else if (packetplayinwindowclick.h() == 1) {
/* 1240 */         if (packetplayinwindowclick.e() == 0) {
/* 1241 */           click = ClickType.SHIFT_LEFT;
/* 1242 */         } else if (packetplayinwindowclick.e() == 1) {
/* 1243 */           click = ClickType.SHIFT_RIGHT;
/*      */         } 
/* 1245 */         if (packetplayinwindowclick.e() == 0 || packetplayinwindowclick.e() == 1) {
/* 1246 */           if (packetplayinwindowclick.d() < 0) {
/* 1247 */             action = InventoryAction.NOTHING;
/*      */           } else {
/* 1249 */             Slot slot = this.player.activeContainer.getSlot(packetplayinwindowclick.d());
/* 1250 */             if (slot != null && slot.isAllowed(this.player) && slot.hasItem()) {
/* 1251 */               action = InventoryAction.MOVE_TO_OTHER_INVENTORY;
/*      */             } else {
/* 1253 */               action = InventoryAction.NOTHING;
/*      */             } 
/*      */           } 
/*      */         }
/* 1257 */       } else if (packetplayinwindowclick.h() == 2) {
/* 1258 */         if (packetplayinwindowclick.e() >= 0 && packetplayinwindowclick.e() < 9) {
/* 1259 */           click = ClickType.NUMBER_KEY;
/* 1260 */           Slot clickedSlot = this.player.activeContainer.getSlot(packetplayinwindowclick.d());
/* 1261 */           if (clickedSlot.isAllowed(this.player)) {
/* 1262 */             ItemStack hotbar = this.player.inventory.getItem(packetplayinwindowclick.e());
/* 1263 */             boolean canCleanSwap = (hotbar == null || (clickedSlot.inventory == this.player.inventory && clickedSlot.isAllowed(hotbar)));
/* 1264 */             if (clickedSlot.hasItem()) {
/* 1265 */               if (canCleanSwap) {
/* 1266 */                 action = InventoryAction.HOTBAR_SWAP;
/*      */               } else {
/* 1268 */                 int firstEmptySlot = this.player.inventory.getFirstEmptySlotIndex();
/* 1269 */                 if (firstEmptySlot > -1) {
/* 1270 */                   action = InventoryAction.HOTBAR_MOVE_AND_READD;
/*      */                 } else {
/* 1272 */                   action = InventoryAction.NOTHING;
/*      */                 } 
/*      */               } 
/* 1275 */             } else if (!clickedSlot.hasItem() && hotbar != null && clickedSlot.isAllowed(hotbar)) {
/* 1276 */               action = InventoryAction.HOTBAR_SWAP;
/*      */             } else {
/* 1278 */               action = InventoryAction.NOTHING;
/*      */             } 
/*      */           } else {
/* 1281 */             action = InventoryAction.NOTHING;
/*      */           } 
/*      */           
/* 1284 */           event = new InventoryClickEvent(inventory, type, packetplayinwindowclick.d(), click, action, packetplayinwindowclick.e());
/*      */         } 
/* 1286 */       } else if (packetplayinwindowclick.h() == 3) {
/* 1287 */         if (packetplayinwindowclick.e() == 2) {
/* 1288 */           click = ClickType.MIDDLE;
/* 1289 */           if (packetplayinwindowclick.d() == -999) {
/* 1290 */             action = InventoryAction.NOTHING;
/*      */           } else {
/* 1292 */             Slot slot = this.player.activeContainer.getSlot(packetplayinwindowclick.d());
/* 1293 */             if (slot != null && slot.hasItem() && this.player.abilities.canInstantlyBuild && this.player.inventory.getCarried() == null) {
/* 1294 */               action = InventoryAction.CLONE_STACK;
/*      */             } else {
/* 1296 */               action = InventoryAction.NOTHING;
/*      */             } 
/*      */           } 
/*      */         } else {
/* 1300 */           click = ClickType.UNKNOWN;
/* 1301 */           action = InventoryAction.UNKNOWN;
/*      */         } 
/* 1303 */       } else if (packetplayinwindowclick.h() == 4) {
/* 1304 */         if (packetplayinwindowclick.d() >= 0) {
/* 1305 */           if (packetplayinwindowclick.e() == 0) {
/* 1306 */             click = ClickType.DROP;
/* 1307 */             Slot slot = this.player.activeContainer.getSlot(packetplayinwindowclick.d());
/* 1308 */             if (slot != null && slot.hasItem() && slot.isAllowed(this.player) && slot.getItem() != null && slot.getItem().getItem() != Item.getItemOf(Blocks.AIR)) {
/* 1309 */               action = InventoryAction.DROP_ONE_SLOT;
/*      */             } else {
/* 1311 */               action = InventoryAction.NOTHING;
/*      */             } 
/* 1313 */           } else if (packetplayinwindowclick.e() == 1) {
/* 1314 */             click = ClickType.CONTROL_DROP;
/* 1315 */             Slot slot = this.player.activeContainer.getSlot(packetplayinwindowclick.d());
/* 1316 */             if (slot != null && slot.hasItem() && slot.isAllowed(this.player) && slot.getItem() != null && slot.getItem().getItem() != Item.getItemOf(Blocks.AIR)) {
/* 1317 */               action = InventoryAction.DROP_ALL_SLOT;
/*      */             } else {
/* 1319 */               action = InventoryAction.NOTHING;
/*      */             } 
/*      */           } 
/*      */         } else {
/*      */           
/* 1324 */           click = ClickType.LEFT;
/* 1325 */           if (packetplayinwindowclick.e() == 1) {
/* 1326 */             click = ClickType.RIGHT;
/*      */           }
/* 1328 */           action = InventoryAction.NOTHING;
/*      */         } 
/* 1330 */       } else if (packetplayinwindowclick.h() == 5) {
/* 1331 */         itemstack = this.player.activeContainer.clickItem(packetplayinwindowclick.d(), packetplayinwindowclick.e(), 5, this.player);
/* 1332 */       } else if (packetplayinwindowclick.h() == 6) {
/* 1333 */         click = ClickType.DOUBLE_CLICK;
/* 1334 */         action = InventoryAction.NOTHING;
/* 1335 */         if (packetplayinwindowclick.d() >= 0 && this.player.inventory.getCarried() != null) {
/* 1336 */           ItemStack cursor = this.player.inventory.getCarried();
/* 1337 */           action = InventoryAction.NOTHING;
/*      */           
/* 1339 */           if (inventory.getTopInventory().contains(Material.getMaterial(Item.getId(cursor.getItem()))) || inventory.getBottomInventory().contains(Material.getMaterial(Item.getId(cursor.getItem())))) {
/* 1340 */             action = InventoryAction.COLLECT_TO_CURSOR;
/*      */           }
/*      */         } 
/*      */       } 
/*      */ 
/*      */       
/* 1346 */       if (packetplayinwindowclick.h() != 5) {
/* 1347 */         CraftItemEvent craftItemEvent; if (click == ClickType.NUMBER_KEY) {
/* 1348 */           event = new InventoryClickEvent(inventory, type, packetplayinwindowclick.d(), click, action, packetplayinwindowclick.e());
/*      */         } else {
/* 1350 */           event = new InventoryClickEvent(inventory, type, packetplayinwindowclick.d(), click, action);
/*      */         } 
/*      */         
/* 1353 */         Inventory top = inventory.getTopInventory();
/* 1354 */         if (packetplayinwindowclick.d() == 0 && top instanceof CraftingInventory) {
/* 1355 */           Recipe recipe = ((CraftingInventory)top).getRecipe();
/* 1356 */           if (recipe != null) {
/* 1357 */             if (click == ClickType.NUMBER_KEY) {
/* 1358 */               craftItemEvent = new CraftItemEvent(recipe, inventory, type, packetplayinwindowclick.d(), click, action, packetplayinwindowclick.e());
/*      */             } else {
/* 1360 */               craftItemEvent = new CraftItemEvent(recipe, inventory, type, packetplayinwindowclick.d(), click, action);
/*      */             } 
/*      */           }
/*      */         } 
/*      */         
/* 1365 */         this.server.getPluginManager().callEvent((Event)craftItemEvent);
/*      */         
/* 1367 */         switch (craftItemEvent.getResult()) {
/*      */           case ALLOW:
/*      */           case DEFAULT:
/* 1370 */             itemstack = this.player.activeContainer.clickItem(packetplayinwindowclick.d(), packetplayinwindowclick.e(), packetplayinwindowclick.h(), this.player);
/*      */             break;
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
/*      */           case DENY:
/* 1384 */             switch (action) {
/*      */               
/*      */               case ALLOW:
/*      */               case DEFAULT:
/*      */               case DENY:
/*      */               case null:
/*      */               case null:
/*      */               case null:
/* 1392 */                 this.player.updateInventory(this.player.activeContainer);
/*      */                 break;
/*      */               
/*      */               case null:
/*      */               case null:
/*      */               case null:
/*      */               case null:
/*      */               case null:
/*      */               case null:
/*      */               case null:
/* 1402 */                 this.player.playerConnection.sendPacket(new PacketPlayOutSetSlot(-1, -1, this.player.inventory.getCarried()));
/* 1403 */                 this.player.playerConnection.sendPacket(new PacketPlayOutSetSlot(this.player.activeContainer.windowId, packetplayinwindowclick.d(), this.player.activeContainer.getSlot(packetplayinwindowclick.d()).getItem()));
/*      */                 break;
/*      */               
/*      */               case null:
/*      */               case null:
/* 1408 */                 this.player.playerConnection.sendPacket(new PacketPlayOutSetSlot(this.player.activeContainer.windowId, packetplayinwindowclick.d(), this.player.activeContainer.getSlot(packetplayinwindowclick.d()).getItem()));
/*      */                 break;
/*      */               
/*      */               case null:
/*      */               case null:
/*      */               case null:
/* 1414 */                 this.player.playerConnection.sendPacket(new PacketPlayOutSetSlot(-1, -1, this.player.inventory.getCarried()));
/*      */                 break;
/*      */             } 
/*      */ 
/*      */ 
/*      */             
/*      */             return;
/*      */         } 
/*      */ 
/*      */       
/*      */       } 
/* 1425 */       if (ItemStack.matches(packetplayinwindowclick.g(), itemstack)) {
/* 1426 */         this.player.playerConnection.sendPacket(new PacketPlayOutTransaction(packetplayinwindowclick.c(), packetplayinwindowclick.f(), true));
/* 1427 */         this.player.g = true;
/* 1428 */         this.player.activeContainer.b();
/* 1429 */         this.player.broadcastCarriedItem();
/* 1430 */         this.player.g = false;
/*      */       } else {
/* 1432 */         this.n.a(this.player.activeContainer.windowId, Short.valueOf(packetplayinwindowclick.f()));
/* 1433 */         this.player.playerConnection.sendPacket(new PacketPlayOutTransaction(packetplayinwindowclick.c(), packetplayinwindowclick.f(), false));
/* 1434 */         this.player.activeContainer.a(this.player, false);
/* 1435 */         ArrayList<ItemStack> arraylist = new ArrayList();
/*      */         
/* 1437 */         for (int i = 0; i < this.player.activeContainer.c.size(); i++) {
/* 1438 */           arraylist.add(((Slot)this.player.activeContainer.c.get(i)).getItem());
/*      */         }
/*      */         
/* 1441 */         this.player.a(this.player.activeContainer, arraylist);
/*      */ 
/*      */         
/* 1444 */         if (type == InventoryType.SlotType.RESULT && itemstack != null) {
/* 1445 */           this.player.playerConnection.sendPacket(new PacketPlayOutSetSlot(this.player.activeContainer.windowId, 0, itemstack));
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void a(PacketPlayInEnchantItem packetplayinenchantitem) {
/* 1453 */     this.player.v();
/* 1454 */     if (this.player.activeContainer.windowId == packetplayinenchantitem.c() && this.player.activeContainer.c(this.player)) {
/* 1455 */       this.player.activeContainer.a(this.player, packetplayinenchantitem.d());
/* 1456 */       this.player.activeContainer.b();
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(PacketPlayInSetCreativeSlot packetplayinsetcreativeslot) {
/* 1461 */     if (this.player.playerInteractManager.isCreative()) {
/* 1462 */       boolean flag = (packetplayinsetcreativeslot.c() < 0);
/* 1463 */       ItemStack itemstack = packetplayinsetcreativeslot.getItemStack();
/* 1464 */       boolean flag1 = (packetplayinsetcreativeslot.c() >= 1 && packetplayinsetcreativeslot.c() < 36 + PlayerInventory.getHotbarSize());
/*      */       
/* 1466 */       boolean flag2 = (itemstack == null || (itemstack.getItem() != null && !invalidItems.contains(Integer.valueOf(Item.getId(itemstack.getItem())))));
/* 1467 */       boolean flag3 = (itemstack == null || (itemstack.getData() >= 0 && itemstack.count <= 64 && itemstack.count > 0));
/*      */ 
/*      */       
/* 1470 */       if (flag || (flag1 && !ItemStack.matches(this.player.defaultContainer.getSlot(packetplayinsetcreativeslot.c()).getItem(), packetplayinsetcreativeslot.getItemStack()))) {
/*      */         
/* 1472 */         CraftPlayer craftPlayer = this.player.getBukkitEntity();
/* 1473 */         CraftInventoryView craftInventoryView = new CraftInventoryView((HumanEntity)craftPlayer, (Inventory)craftPlayer.getInventory(), this.player.defaultContainer);
/* 1474 */         ItemStack item = CraftItemStack.asBukkitCopy(packetplayinsetcreativeslot.getItemStack());
/*      */         
/* 1476 */         InventoryType.SlotType type = InventoryType.SlotType.QUICKBAR;
/* 1477 */         if (flag) {
/* 1478 */           type = InventoryType.SlotType.OUTSIDE;
/* 1479 */         } else if (packetplayinsetcreativeslot.c() < 36) {
/* 1480 */           if (packetplayinsetcreativeslot.c() >= 5 && packetplayinsetcreativeslot.c() < 9) {
/* 1481 */             type = InventoryType.SlotType.ARMOR;
/*      */           } else {
/* 1483 */             type = InventoryType.SlotType.CONTAINER;
/*      */           } 
/*      */         } 
/* 1486 */         InventoryCreativeEvent event = new InventoryCreativeEvent((InventoryView)craftInventoryView, type, flag ? -999 : packetplayinsetcreativeslot.c(), item);
/* 1487 */         this.server.getPluginManager().callEvent((Event)event);
/*      */         
/* 1489 */         itemstack = CraftItemStack.asNMSCopy(event.getCursor());
/*      */         
/* 1491 */         switch (event.getResult()) {
/*      */           
/*      */           case ALLOW:
/* 1494 */             flag2 = flag3 = true;
/*      */             break;
/*      */ 
/*      */ 
/*      */           
/*      */           case DENY:
/* 1500 */             if (packetplayinsetcreativeslot.c() >= 0) {
/* 1501 */               this.player.playerConnection.sendPacket(new PacketPlayOutSetSlot(this.player.defaultContainer.windowId, packetplayinsetcreativeslot.c(), this.player.defaultContainer.getSlot(packetplayinsetcreativeslot.c()).getItem()));
/* 1502 */               this.player.playerConnection.sendPacket(new PacketPlayOutSetSlot(-1, -1, null));
/*      */             } 
/*      */             return;
/*      */         } 
/*      */ 
/*      */       
/*      */       } 
/* 1509 */       if (flag1 && flag2 && flag3) {
/* 1510 */         if (itemstack == null) {
/* 1511 */           this.player.defaultContainer.setItem(packetplayinsetcreativeslot.c(), (ItemStack)null);
/*      */         } else {
/* 1513 */           this.player.defaultContainer.setItem(packetplayinsetcreativeslot.c(), itemstack);
/*      */         } 
/*      */         
/* 1516 */         this.player.defaultContainer.a(this.player, true);
/* 1517 */       } else if (flag && flag2 && flag3 && this.x < 200) {
/* 1518 */         this.x += 20;
/* 1519 */         EntityItem entityitem = this.player.drop(itemstack, true);
/*      */         
/* 1521 */         if (entityitem != null) {
/* 1522 */           entityitem.e();
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(PacketPlayInTransaction packetplayintransaction) {
/* 1529 */     if (this.player.dead)
/* 1530 */       return;  Short oshort = (Short)this.n.get(this.player.activeContainer.windowId);
/*      */     
/* 1532 */     if (oshort != null && packetplayintransaction.d() == oshort.shortValue() && this.player.activeContainer.windowId == packetplayintransaction.c() && !this.player.activeContainer.c(this.player)) {
/* 1533 */       this.player.activeContainer.a(this.player, true);
/*      */     }
/*      */   }
/*      */   
/*      */   public void a(PacketPlayInUpdateSign packetplayinupdatesign) {
/* 1538 */     if (this.player.dead)
/*      */       return; 
/* 1540 */     this.player.v();
/* 1541 */     WorldServer worldserver = this.minecraftServer.getWorldServer(this.player.dimension);
/*      */     
/* 1543 */     if (worldserver.isLoaded(packetplayinupdatesign.c(), packetplayinupdatesign.d(), packetplayinupdatesign.e())) {
/* 1544 */       TileEntity tileentity = worldserver.getTileEntity(packetplayinupdatesign.c(), packetplayinupdatesign.d(), packetplayinupdatesign.e());
/*      */       
/* 1546 */       if (tileentity instanceof TileEntitySign) {
/* 1547 */         TileEntitySign tileentitysign = (TileEntitySign)tileentity;
/*      */         
/* 1549 */         if (!tileentitysign.a() || tileentitysign.b() != this.player) {
/* 1550 */           this.minecraftServer.warning("Player " + this.player.getName() + " just tried to change non-editable sign");
/* 1551 */           sendPacket(new PacketPlayOutUpdateSign(packetplayinupdatesign.c(), packetplayinupdatesign.d(), packetplayinupdatesign.e(), tileentitysign.lines));
/*      */           
/*      */           return;
/*      */         } 
/*      */       } 
/*      */       
/*      */       int j;
/*      */       
/* 1559 */       for (j = 0; j < 4; j++) {
/* 1560 */         boolean flag = true;
/*      */         
/* 1562 */         if (packetplayinupdatesign.f()[j].length() > 15) {
/* 1563 */           flag = false;
/*      */         } else {
/* 1565 */           for (int i = 0; i < packetplayinupdatesign.f()[j].length(); i++) {
/* 1566 */             if (!SharedConstants.isAllowedChatCharacter(packetplayinupdatesign.f()[j].charAt(i))) {
/* 1567 */               flag = false;
/*      */             }
/*      */           } 
/*      */         } 
/*      */         
/* 1572 */         if (!flag) {
/* 1573 */           packetplayinupdatesign.f()[j] = "!?";
/*      */         }
/*      */       } 
/*      */       
/* 1577 */       if (tileentity instanceof TileEntitySign) {
/* 1578 */         j = packetplayinupdatesign.c();
/* 1579 */         int k = packetplayinupdatesign.d();
/*      */         
/* 1581 */         int i = packetplayinupdatesign.e();
/* 1582 */         TileEntitySign tileentitysign1 = (TileEntitySign)tileentity;
/*      */ 
/*      */         
/* 1585 */         Player player = this.server.getPlayer(this.player);
/* 1586 */         SignChangeEvent event = new SignChangeEvent(player.getWorld().getBlockAt(j, k, i), this.server.getPlayer(this.player), packetplayinupdatesign.f());
/* 1587 */         this.server.getPluginManager().callEvent((Event)event);
/*      */         
/* 1589 */         if (!event.isCancelled()) {
/* 1590 */           tileentitysign1.lines = CraftSign.sanitizeLines(event.getLines());
/* 1591 */           tileentitysign1.isEditable = false;
/*      */         } 
/*      */ 
/*      */ 
/*      */         
/* 1596 */         tileentitysign1.update();
/* 1597 */         worldserver.notify(j, k, i);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void a(PacketPlayInKeepAlive packetplayinkeepalive) {
/* 1603 */     if (packetplayinkeepalive.c() == this.h) {
/* 1604 */       int i = (int)(d() - this.i);
/*      */       
/* 1606 */       this.player.ping = (this.player.ping * 3 + i) / 4;
/*      */     } 
/*      */   }
/*      */   
/*      */   private long d() {
/* 1611 */     return System.nanoTime() / 1000000L;
/*      */   }
/*      */ 
/*      */   
/*      */   public void a(PacketPlayInAbilities packetplayinabilities) {
/* 1616 */     if (this.player.abilities.canFly && this.player.abilities.isFlying != packetplayinabilities.isFlying()) {
/* 1617 */       PlayerToggleFlightEvent event = new PlayerToggleFlightEvent(this.server.getPlayer(this.player), packetplayinabilities.isFlying());
/* 1618 */       this.server.getPluginManager().callEvent((Event)event);
/* 1619 */       if (!event.isCancelled()) {
/* 1620 */         this.player.abilities.isFlying = packetplayinabilities.isFlying();
/*      */       } else {
/* 1622 */         this.player.updateAbilities();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void a(PacketPlayInTabComplete packetplayintabcomplete) {
/* 1629 */     ArrayList<String> arraylist = Lists.newArrayList();
/* 1630 */     Iterator<String> iterator = this.minecraftServer.a(this.player, packetplayintabcomplete.c()).iterator();
/*      */     
/* 1632 */     while (iterator.hasNext()) {
/* 1633 */       String s = iterator.next();
/*      */       
/* 1635 */       arraylist.add(s);
/*      */     } 
/*      */     
/* 1638 */     this.player.playerConnection.sendPacket(new PacketPlayOutTabComplete(arraylist.<String>toArray(new String[arraylist.size()])));
/*      */   }
/*      */   
/*      */   public void a(PacketPlayInSettings packetplayinsettings) {
/* 1642 */     this.player.a(packetplayinsettings);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(PacketPlayInCustomPayload packetplayincustompayload) {
/* 1651 */     if (packetplayincustompayload.length <= 0) {
/*      */       return;
/*      */     }
/*      */ 
/*      */     
/* 1656 */     if ("MC|BEdit".equals(packetplayincustompayload.c())) {
/* 1657 */       PacketDataSerializer packetdataserializer = new PacketDataSerializer(Unpooled.wrappedBuffer(packetplayincustompayload.e()));
/*      */       
/*      */       try {
/* 1660 */         ItemStack itemstack = packetdataserializer.c();
/* 1661 */         if (itemstack != null) {
/* 1662 */           if (!ItemBookAndQuill.a(itemstack.getTag())) {
/* 1663 */             throw new IOException("Invalid book tag!");
/*      */           }
/*      */           
/* 1666 */           ItemStack itemstack1 = this.player.inventory.getItemInHand();
/* 1667 */           if (itemstack1 == null) {
/*      */             return;
/*      */           }
/*      */           
/* 1671 */           if (itemstack.getItem() == Items.BOOK_AND_QUILL && itemstack.getItem() == itemstack1.getItem()) {
/* 1672 */             CraftEventFactory.handleEditBookEvent(this.player, itemstack);
/*      */           }
/*      */ 
/*      */           
/*      */           return;
/*      */         } 
/* 1678 */       } catch (Exception exception) {
/* 1679 */         c.error("Couldn't handle book info", exception);
/* 1680 */         disconnect("Invalid book data!");
/*      */         
/*      */         return;
/*      */       } finally {
/* 1684 */         packetdataserializer.release();
/*      */       } 
/*      */       return;
/*      */     } 
/* 1688 */     if ("MC|BSign".equals(packetplayincustompayload.c())) {
/* 1689 */       PacketDataSerializer packetdataserializer = new PacketDataSerializer(Unpooled.wrappedBuffer(packetplayincustompayload.e()));
/*      */       
/*      */       try {
/* 1692 */         ItemStack itemstack = packetdataserializer.c();
/* 1693 */         if (itemstack != null) {
/* 1694 */           if (!ItemWrittenBook.a(itemstack.getTag())) {
/* 1695 */             throw new IOException("Invalid book tag!");
/*      */           }
/*      */           
/* 1698 */           ItemStack itemstack1 = this.player.inventory.getItemInHand();
/* 1699 */           if (itemstack1 == null) {
/*      */             return;
/*      */           }
/*      */           
/* 1703 */           if (itemstack.getItem() == Items.WRITTEN_BOOK && itemstack1.getItem() == Items.BOOK_AND_QUILL) {
/* 1704 */             CraftEventFactory.handleEditBookEvent(this.player, itemstack);
/*      */           }
/*      */ 
/*      */           
/*      */           return;
/*      */         } 
/* 1710 */       } catch (Throwable exception1) {
/* 1711 */         c.error("Couldn't sign book", exception1);
/* 1712 */         disconnect("Invalid book data!");
/*      */         
/*      */         return;
/*      */       } finally {
/* 1716 */         packetdataserializer.release();
/*      */       } 
/*      */ 
/*      */       
/*      */       return;
/*      */     } 
/*      */ 
/*      */     
/* 1724 */     if ("MC|TrSel".equals(packetplayincustompayload.c())) {
/*      */       try {
/* 1726 */         DataInputStream datainputstream = new DataInputStream(new ByteArrayInputStream(packetplayincustompayload.e()));
/* 1727 */         int i = datainputstream.readInt();
/* 1728 */         Container container = this.player.activeContainer;
/*      */         
/* 1730 */         if (container instanceof ContainerMerchant) {
/* 1731 */           ((ContainerMerchant)container).e(i);
/*      */         }
/*      */       }
/* 1734 */       catch (Throwable exception2) {
/* 1735 */         c.error("Couldn't select trade", exception2);
/* 1736 */         disconnect("Invalid trade data!");
/*      */       }
/*      */     
/* 1739 */     } else if ("MC|AdvCdm".equals(packetplayincustompayload.c())) {
/* 1740 */       if (!this.minecraftServer.getEnableCommandBlock()) {
/* 1741 */         this.player.sendMessage(new ChatMessage("advMode.notEnabled", new Object[0]));
/* 1742 */       } else if (this.player.a(2, "") && this.player.abilities.canInstantlyBuild) {
/* 1743 */         PacketDataSerializer packetdataserializer = new PacketDataSerializer(Unpooled.wrappedBuffer(packetplayincustompayload.e()));
/*      */         
/*      */         try {
/* 1746 */           byte b0 = packetdataserializer.readByte();
/* 1747 */           CommandBlockListenerAbstract commandblocklistenerabstract = null;
/*      */           
/* 1749 */           if (b0 == 0) {
/* 1750 */             TileEntity tileentity = this.player.world.getTileEntity(packetdataserializer.readInt(), packetdataserializer.readInt(), packetdataserializer.readInt());
/*      */             
/* 1752 */             if (tileentity instanceof TileEntityCommand) {
/* 1753 */               commandblocklistenerabstract = ((TileEntityCommand)tileentity).getCommandBlock();
/*      */             }
/* 1755 */           } else if (b0 == 1) {
/* 1756 */             Entity entity = this.player.world.getEntity(packetdataserializer.readInt());
/*      */             
/* 1758 */             if (entity instanceof EntityMinecartCommandBlock) {
/* 1759 */               commandblocklistenerabstract = ((EntityMinecartCommandBlock)entity).getCommandBlock();
/*      */             }
/*      */           } 
/*      */           
/* 1763 */           String s = packetdataserializer.c(packetdataserializer.readableBytes());
/*      */           
/* 1765 */           if (commandblocklistenerabstract != null) {
/* 1766 */             commandblocklistenerabstract.setCommand(s);
/* 1767 */             commandblocklistenerabstract.e();
/* 1768 */             this.player.sendMessage(new ChatMessage("advMode.setCommand.success", new Object[] { s }));
/*      */           }
/*      */         
/* 1771 */         } catch (Throwable exception3) {
/* 1772 */           c.error("Couldn't set command block", exception3);
/* 1773 */           disconnect("Invalid CommandBlock data!");
/*      */         } finally {
/*      */           
/* 1776 */           packetdataserializer.release();
/*      */         } 
/*      */       } else {
/* 1779 */         this.player.sendMessage(new ChatMessage("advMode.notAllowed", new Object[0]));
/*      */       } 
/* 1781 */     } else if ("MC|Beacon".equals(packetplayincustompayload.c())) {
/* 1782 */       if (this.player.activeContainer instanceof ContainerBeacon) {
/*      */         try {
/* 1784 */           DataInputStream dataInputStream = new DataInputStream(new ByteArrayInputStream(packetplayincustompayload.e()));
/* 1785 */           int i = dataInputStream.readInt();
/* 1786 */           int j = dataInputStream.readInt();
/* 1787 */           ContainerBeacon containerbeacon = (ContainerBeacon)this.player.activeContainer;
/* 1788 */           Slot slot = containerbeacon.getSlot(0);
/*      */           
/* 1790 */           if (slot.hasItem()) {
/* 1791 */             slot.a(1);
/* 1792 */             TileEntityBeacon tileentitybeacon = containerbeacon.e();
/*      */             
/* 1794 */             tileentitybeacon.d(i);
/* 1795 */             tileentitybeacon.e(j);
/* 1796 */             tileentitybeacon.update();
/*      */           }
/*      */         
/* 1799 */         } catch (Throwable exception4) {
/* 1800 */           c.error("Couldn't set beacon", exception4);
/* 1801 */           disconnect("Invalid beacon data!");
/*      */         }
/*      */       
/*      */       }
/* 1805 */     } else if ("MC|ItemName".equals(packetplayincustompayload.c()) && this.player.activeContainer instanceof ContainerAnvil) {
/* 1806 */       ContainerAnvil containeranvil = (ContainerAnvil)this.player.activeContainer;
/*      */       
/* 1808 */       if (packetplayincustompayload.e() != null && (packetplayincustompayload.e()).length >= 1) {
/* 1809 */         String s1 = SharedConstants.a(new String(packetplayincustompayload.e(), Charsets.UTF_8));
/*      */         
/* 1811 */         if (s1.length() <= 30) {
/* 1812 */           containeranvil.a(s1);
/*      */         }
/*      */       } else {
/* 1815 */         containeranvil.a("");
/*      */       }
/*      */     
/*      */     }
/* 1819 */     else if (packetplayincustompayload.c().equals("REGISTER")) {
/*      */       try {
/* 1821 */         String channels = new String(packetplayincustompayload.e(), "UTF8");
/* 1822 */         for (String channel : channels.split("\000")) {
/* 1823 */           getPlayer().addChannel(channel);
/*      */         }
/* 1825 */       } catch (UnsupportedEncodingException ex) {
/* 1826 */         throw new AssertionError(ex);
/*      */       } 
/* 1828 */     } else if (packetplayincustompayload.c().equals("UNREGISTER")) {
/*      */       try {
/* 1830 */         String channels = new String(packetplayincustompayload.e(), "UTF8");
/* 1831 */         for (String channel : channels.split("\000")) {
/* 1832 */           getPlayer().removeChannel(channel);
/*      */         }
/* 1834 */       } catch (UnsupportedEncodingException ex) {
/* 1835 */         throw new AssertionError(ex);
/*      */       } 
/*      */     } else {
/* 1838 */       this.server.getMessenger().dispatchIncomingMessage((Player)this.player.getBukkitEntity(), packetplayincustompayload.c(), packetplayincustompayload.e());
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void a(EnumProtocol enumprotocol, EnumProtocol enumprotocol1) {
/* 1845 */     if (enumprotocol1 != EnumProtocol.PLAY) {
/* 1846 */       throw new IllegalStateException("Unexpected change in protocol!");
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public final boolean isDisconnected() {
/* 1852 */     return (!this.player.joining && !NetworkManager.a(this.networkManager).config().isAutoRead());
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PlayerConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */