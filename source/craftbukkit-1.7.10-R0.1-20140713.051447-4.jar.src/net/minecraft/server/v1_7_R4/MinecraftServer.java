/*      */ package net.minecraft.server.v1_7_R4;
/*      */ import java.awt.GraphicsEnvironment;
/*      */ import java.awt.image.BufferedImage;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.net.Proxy;
/*      */ import java.net.UnknownHostException;
/*      */ import java.security.KeyPair;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.List;
/*      */ import java.util.Queue;
/*      */ import java.util.Random;
/*      */ import java.util.UUID;
/*      */ import java.util.concurrent.ConcurrentLinkedQueue;
/*      */ import java.util.concurrent.ExecutionException;
/*      */ import javax.imageio.ImageIO;
/*      */ import net.minecraft.util.com.google.common.base.Charsets;
/*      */ import net.minecraft.util.com.mojang.authlib.GameProfile;
/*      */ import net.minecraft.util.com.mojang.authlib.GameProfileRepository;
/*      */ import net.minecraft.util.com.mojang.authlib.minecraft.MinecraftSessionService;
/*      */ import net.minecraft.util.com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
/*      */ import net.minecraft.util.io.netty.buffer.ByteBuf;
/*      */ import net.minecraft.util.io.netty.buffer.ByteBufOutputStream;
/*      */ import net.minecraft.util.io.netty.handler.codec.base64.Base64;
/*      */ import net.minecraft.util.org.apache.commons.lang3.Validate;
/*      */ import org.apache.logging.log4j.LogManager;
/*      */ import org.apache.logging.log4j.Logger;
/*      */ import org.bukkit.World;
/*      */ import org.bukkit.command.CommandSender;
/*      */ import org.bukkit.craftbukkit.Main;
/*      */ import org.bukkit.craftbukkit.libs.jline.console.ConsoleReader;
/*      */ import org.bukkit.craftbukkit.libs.joptsimple.OptionSet;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.CraftServer;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.chunkio.ChunkIOExecutor;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.scoreboard.CraftScoreboardManager;
/*      */ import org.bukkit.craftbukkit.v1_7_R4.util.Waitable;
/*      */ import org.bukkit.event.Event;
/*      */ import org.bukkit.event.server.RemoteServerCommandEvent;
/*      */ import org.bukkit.event.world.WorldLoadEvent;
/*      */ import org.bukkit.event.world.WorldSaveEvent;
/*      */ import org.bukkit.generator.ChunkGenerator;
/*      */ import org.bukkit.plugin.Plugin;
/*      */ 
/*      */ public abstract class MinecraftServer implements ICommandListener, Runnable, IMojangStatistics {
/*   47 */   private static final Logger i = LogManager.getLogger();
/*   48 */   private static final File a = new File("usercache.json");
/*      */   private static MinecraftServer j;
/*      */   public Convertable convertable;
/*   51 */   private final MojangStatisticsGenerator l = new MojangStatisticsGenerator("server", this, ar());
/*      */   public File universe;
/*   53 */   private final List n = new ArrayList();
/*      */   private final ICommandHandler o;
/*   55 */   public final MethodProfiler methodProfiler = new MethodProfiler();
/*      */   private final ServerConnection p;
/*   57 */   private final ServerPing q = new ServerPing();
/*   58 */   private final Random r = new Random();
/*      */   private String serverIp;
/*   60 */   private int t = -1;
/*      */   public WorldServer[] worldServer;
/*      */   private PlayerList u;
/*      */   private boolean isRunning = true;
/*      */   private boolean isStopped;
/*      */   private int ticks;
/*      */   protected final Proxy d;
/*      */   public String e;
/*      */   public int f;
/*      */   private boolean onlineMode;
/*      */   private boolean spawnAnimals;
/*      */   private boolean spawnNPCs;
/*      */   private boolean pvpMode;
/*      */   private boolean allowFlight;
/*      */   private String motd;
/*      */   private int E;
/*   76 */   private int F = 0;
/*   77 */   public final long[] g = new long[100];
/*      */   public long[][] h;
/*      */   private KeyPair G;
/*      */   private String H;
/*      */   private String I;
/*      */   private boolean demoMode;
/*      */   private boolean L;
/*      */   private boolean M;
/*   85 */   private String N = "";
/*      */   private boolean O;
/*      */   private long P;
/*      */   private String Q;
/*      */   private boolean R;
/*      */   private boolean S;
/*      */   private final YggdrasilAuthenticationService T;
/*      */   private final MinecraftSessionService U;
/*   93 */   private long V = 0L;
/*      */   
/*      */   private final GameProfileRepository W;
/*      */   
/*      */   private final UserCache X;
/*   98 */   public List<WorldServer> worlds = new ArrayList<WorldServer>();
/*      */   public CraftServer server;
/*      */   public OptionSet options;
/*      */   public ConsoleCommandSender console;
/*      */   public RemoteConsoleCommandSender remoteConsole;
/*      */   public ConsoleReader reader;
/*  104 */   public static int currentTick = (int)(System.currentTimeMillis() / 50L);
/*      */   public final Thread primaryThread;
/*  106 */   public Queue<Runnable> processQueue = new ConcurrentLinkedQueue<Runnable>();
/*      */   
/*      */   public int autosavePeriod;
/*      */   
/*      */   public MinecraftServer(OptionSet options, Proxy proxy) {
/*  111 */     this.X = new UserCache(this, a);
/*  112 */     j = this;
/*  113 */     this.d = proxy;
/*      */     
/*  115 */     this.p = new ServerConnection(this);
/*  116 */     this.o = new CommandDispatcher();
/*      */     
/*  118 */     this.T = new YggdrasilAuthenticationService(proxy, UUID.randomUUID().toString());
/*  119 */     this.U = this.T.createMinecraftSessionService();
/*  120 */     this.W = this.T.createProfileRepository();
/*      */     
/*  122 */     this.options = options;
/*      */     
/*  124 */     if (System.console() == null) {
/*  125 */       System.setProperty("org.bukkit.craftbukkit.libs.jline.terminal", "org.bukkit.craftbukkit.libs.jline.UnsupportedTerminal");
/*  126 */       Main.useJline = false;
/*      */     } 
/*      */     
/*      */     try {
/*  130 */       this.reader = new ConsoleReader(System.in, System.out);
/*  131 */       this.reader.setExpandEvents(false);
/*  132 */     } catch (Throwable e) {
/*      */       
/*      */       try {
/*  135 */         System.setProperty("org.bukkit.craftbukkit.libs.jline.terminal", "org.bukkit.craftbukkit.libs.jline.UnsupportedTerminal");
/*  136 */         System.setProperty("user.language", "en");
/*  137 */         Main.useJline = false;
/*  138 */         this.reader = new ConsoleReader(System.in, System.out);
/*  139 */         this.reader.setExpandEvents(false);
/*  140 */       } catch (IOException ex) {
/*  141 */         i.warn((String)null, ex);
/*      */       } 
/*      */     } 
/*  144 */     Runtime.getRuntime().addShutdownHook((Thread)new ServerShutdownThread(this));
/*      */     
/*  146 */     this.primaryThread = new ThreadServerApplication(this, "Server thread");
/*      */   }
/*      */ 
/*      */   
/*      */   public abstract PropertyManager getPropertyManager();
/*      */   
/*      */   protected abstract boolean init() throws UnknownHostException;
/*      */   
/*      */   protected void a(String s) {
/*  155 */     if (getConvertable().isConvertable(s)) {
/*  156 */       i.info("Converting map!");
/*  157 */       b("menu.convertingLevel");
/*  158 */       getConvertable().convert(s, new ConvertProgressUpdater(this));
/*      */     } 
/*      */   }
/*      */   
/*      */   protected synchronized void b(String s) {
/*  163 */     this.Q = s;
/*      */   }
/*      */   
/*      */   protected void a(String s, String s1, long i, WorldType worldtype, String s2) {
/*  167 */     a(s);
/*  168 */     b("menu.loadingLevel");
/*  169 */     this.worldServer = new WorldServer[3];
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
/*  187 */     int worldCount = 3;
/*      */     
/*  189 */     for (int j = 0; j < worldCount; j++) {
/*      */       WorldServer world;
/*  191 */       int dimension = 0;
/*      */       
/*  193 */       if (j == 1) {
/*  194 */         if (getAllowNether()) {
/*  195 */           dimension = -1;
/*      */         } else {
/*      */           continue;
/*      */         } 
/*      */       }
/*      */       
/*  201 */       if (j == 2) {
/*  202 */         if (this.server.getAllowEnd()) {
/*  203 */           dimension = 1;
/*      */         } else {
/*      */           continue;
/*      */         } 
/*      */       }
/*      */       
/*  209 */       String worldType = World.Environment.getEnvironment(dimension).toString().toLowerCase();
/*  210 */       String name = (dimension == 0) ? s : (s + "_" + worldType);
/*      */       
/*  212 */       ChunkGenerator gen = this.server.getGenerator(name);
/*  213 */       WorldSettings worldsettings = new WorldSettings(i, getGamemode(), getGenerateStructures(), isHardcore(), worldtype);
/*  214 */       worldsettings.a(s2);
/*      */       
/*  216 */       if (j == 0) {
/*  217 */         IDataManager idatamanager = new ServerNBTManager(this.server.getWorldContainer(), s1, true);
/*  218 */         if (R()) {
/*  219 */           world = new DemoWorldServer(this, idatamanager, s1, dimension, this.methodProfiler);
/*      */         } else {
/*      */           
/*  222 */           world = new WorldServer(this, idatamanager, s1, dimension, worldsettings, this.methodProfiler, World.Environment.getEnvironment(dimension), gen);
/*      */         } 
/*  224 */         this.server.scoreboardManager = new CraftScoreboardManager(this, world.getScoreboard());
/*      */       } else {
/*  226 */         String dim = "DIM" + dimension;
/*      */         
/*  228 */         File newWorld = new File(new File(name), dim);
/*  229 */         File oldWorld = new File(new File(s), dim);
/*      */         
/*  231 */         if (!newWorld.isDirectory() && oldWorld.isDirectory()) {
/*  232 */           MinecraftServer.i.info("---- Migration of old " + worldType + " folder required ----");
/*  233 */           MinecraftServer.i.info("Unfortunately due to the way that Minecraft implemented multiworld support in 1.6, Bukkit requires that you move your " + worldType + " folder to a new location in order to operate correctly.");
/*  234 */           MinecraftServer.i.info("We will move this folder for you, but it will mean that you need to move it back should you wish to stop using Bukkit in the future.");
/*  235 */           MinecraftServer.i.info("Attempting to move " + oldWorld + " to " + newWorld + "...");
/*      */           
/*  237 */           if (newWorld.exists()) {
/*  238 */             MinecraftServer.i.warn("A file or folder already exists at " + newWorld + "!");
/*  239 */             MinecraftServer.i.info("---- Migration of old " + worldType + " folder failed ----");
/*  240 */           } else if (newWorld.getParentFile().mkdirs()) {
/*  241 */             if (oldWorld.renameTo(newWorld)) {
/*  242 */               MinecraftServer.i.info("Success! To restore " + worldType + " in the future, simply move " + newWorld + " to " + oldWorld);
/*      */               
/*      */               try {
/*  245 */                 Files.copy(new File(new File(s), "level.dat"), new File(new File(name), "level.dat"));
/*  246 */               } catch (IOException exception) {
/*  247 */                 MinecraftServer.i.warn("Unable to migrate world data.");
/*      */               } 
/*  249 */               MinecraftServer.i.info("---- Migration of old " + worldType + " folder complete ----");
/*      */             } else {
/*  251 */               MinecraftServer.i.warn("Could not move folder " + oldWorld + " to " + newWorld + "!");
/*  252 */               MinecraftServer.i.info("---- Migration of old " + worldType + " folder failed ----");
/*      */             } 
/*      */           } else {
/*  255 */             MinecraftServer.i.warn("Could not create path for " + newWorld + "!");
/*  256 */             MinecraftServer.i.info("---- Migration of old " + worldType + " folder failed ----");
/*      */           } 
/*      */         } 
/*      */         
/*  260 */         IDataManager idatamanager = new ServerNBTManager(this.server.getWorldContainer(), name, true);
/*      */         
/*  262 */         world = new SecondaryWorldServer(this, idatamanager, name, dimension, worldsettings, this.worlds.get(0), this.methodProfiler, World.Environment.getEnvironment(dimension), gen);
/*      */       } 
/*      */       
/*  265 */       if (gen != null) {
/*  266 */         world.getWorld().getPopulators().addAll(gen.getDefaultPopulators((World)world.getWorld()));
/*      */       }
/*      */       
/*  269 */       this.server.getPluginManager().callEvent((Event)new WorldInitEvent((World)world.getWorld()));
/*      */       
/*  271 */       world.addIWorldAccess(new WorldManager(this, world));
/*  272 */       if (!N()) {
/*  273 */         world.getWorldData().setGameType(getGamemode());
/*      */       }
/*      */       
/*  276 */       this.worlds.add(world);
/*  277 */       this.u.setPlayerFileData(this.worlds.<WorldServer>toArray(new WorldServer[this.worlds.size()]));
/*      */       
/*      */       continue;
/*      */     } 
/*  281 */     a(getDifficulty());
/*  282 */     g();
/*      */   }
/*      */   
/*      */   protected void g() {
/*  286 */     boolean flag = true;
/*  287 */     boolean flag1 = true;
/*  288 */     boolean flag2 = true;
/*  289 */     boolean flag3 = true;
/*  290 */     int i = 0;
/*      */     
/*  292 */     b("menu.generatingTerrain");
/*  293 */     byte b0 = 0;
/*      */ 
/*      */     
/*  296 */     for (int m = 0; m < this.worlds.size(); m++) {
/*  297 */       WorldServer worldserver = this.worlds.get(m);
/*  298 */       MinecraftServer.i.info("Preparing start region for level " + m + " (Seed: " + worldserver.getSeed() + ")");
/*  299 */       if (worldserver.getWorld().getKeepSpawnInMemory()) {
/*      */ 
/*      */ 
/*      */         
/*  303 */         ChunkCoordinates chunkcoordinates = worldserver.getSpawn();
/*  304 */         long j = ar();
/*  305 */         i = 0;
/*      */         
/*  307 */         for (int k = -192; k <= 192 && isRunning(); k += 16) {
/*  308 */           for (int l = -192; l <= 192 && isRunning(); l += 16) {
/*  309 */             long i1 = ar();
/*      */             
/*  311 */             if (i1 - j > 1000L) {
/*  312 */               a_("Preparing spawn area", i * 100 / 625);
/*  313 */               j = i1;
/*      */             } 
/*      */             
/*  316 */             i++;
/*  317 */             worldserver.chunkProviderServer.getChunkAt(chunkcoordinates.x + k >> 4, chunkcoordinates.z + l >> 4);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*  322 */     for (WorldServer world : this.worlds) {
/*  323 */       this.server.getPluginManager().callEvent((Event)new WorldLoadEvent((World)world.getWorld()));
/*      */     }
/*      */     
/*  326 */     n();
/*      */   }
/*      */   
/*      */   public abstract boolean getGenerateStructures();
/*      */   
/*      */   public abstract EnumGamemode getGamemode();
/*      */   
/*      */   public abstract EnumDifficulty getDifficulty();
/*      */   
/*      */   public abstract boolean isHardcore();
/*      */   
/*      */   public abstract int l();
/*      */   
/*      */   public abstract boolean m();
/*      */   
/*      */   protected void a_(String s, int i) {
/*  342 */     this.e = s;
/*  343 */     this.f = i;
/*      */     
/*  345 */     MinecraftServer.i.info(s + ": " + i + "%");
/*      */   }
/*      */   
/*      */   protected void n() {
/*  349 */     this.e = null;
/*  350 */     this.f = 0;
/*      */     
/*  352 */     this.server.enablePlugins(PluginLoadOrder.POSTWORLD);
/*      */   }
/*      */   
/*      */   protected void saveChunks(boolean flag) throws ExceptionWorldConflict {
/*  356 */     if (!this.M) {
/*      */ 
/*      */       
/*  359 */       int i = this.worlds.size();
/*      */       
/*  361 */       for (int j = 0; j < i; j++) {
/*  362 */         WorldServer worldserver = this.worlds.get(j);
/*      */         
/*  364 */         if (worldserver != null) {
/*  365 */           if (!flag) {
/*  366 */             MinecraftServer.i.info("Saving chunks for level '" + worldserver.getWorldData().getName() + "'/" + worldserver.worldProvider.getName());
/*      */           }
/*      */           
/*  369 */           worldserver.save(true, (IProgressUpdate)null);
/*  370 */           worldserver.saveLevel();
/*      */           
/*  372 */           WorldSaveEvent event = new WorldSaveEvent((World)worldserver.getWorld());
/*  373 */           this.server.getPluginManager().callEvent((Event)event);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void stop() throws ExceptionWorldConflict {
/*  381 */     if (!this.M) {
/*  382 */       i.info("Stopping server");
/*      */       
/*  384 */       if (this.server != null) {
/*  385 */         this.server.disablePlugins();
/*      */       }
/*      */ 
/*      */       
/*  389 */       if (ai() != null) {
/*  390 */         ai().b();
/*      */       }
/*      */       
/*  393 */       if (this.u != null) {
/*  394 */         i.info("Saving players");
/*  395 */         this.u.savePlayers();
/*  396 */         this.u.u();
/*      */       } 
/*      */       
/*  399 */       if (this.worldServer != null) {
/*  400 */         i.info("Saving worlds");
/*  401 */         saveChunks(false);
/*      */       } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  412 */       if (this.l.d()) {
/*  413 */         this.l.e();
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   public String getServerIp() {
/*  419 */     return this.serverIp;
/*      */   }
/*      */   
/*      */   public void c(String s) {
/*  423 */     this.serverIp = s;
/*      */   }
/*      */   
/*      */   public boolean isRunning() {
/*  427 */     return this.isRunning;
/*      */   }
/*      */   
/*      */   public void safeShutdown() {
/*  431 */     this.isRunning = false;
/*      */   }
/*      */   
/*      */   public void run() {
/*      */     try {
/*  436 */       if (init()) {
/*  437 */         long i = ar();
/*  438 */         long j = 0L;
/*      */         
/*  440 */         this.q.setMOTD(new ChatComponentText(this.motd));
/*  441 */         this.q.setServerInfo(new ServerPingServerData("1.7.10", 5));
/*  442 */         a(this.q);
/*      */         
/*  444 */         while (this.isRunning) {
/*  445 */           long k = ar();
/*  446 */           long l = k - i;
/*      */           
/*  448 */           if (l > 2000L && i - this.P >= 15000L) {
/*  449 */             if (this.server.getWarnOnOverload())
/*  450 */               MinecraftServer.i.warn("Can't keep up! Did the system time change, or is the server overloaded? Running {}ms behind, skipping {} tick(s)", new Object[] { Long.valueOf(l), Long.valueOf(l / 50L) }); 
/*  451 */             l = 2000L;
/*  452 */             this.P = i;
/*      */           } 
/*      */           
/*  455 */           if (l < 0L) {
/*  456 */             MinecraftServer.i.warn("Time ran backwards! Did the system time change?");
/*  457 */             l = 0L;
/*      */           } 
/*      */           
/*  460 */           j += l;
/*  461 */           i = k;
/*  462 */           if (((WorldServer)this.worlds.get(0)).everyoneDeeplySleeping()) {
/*  463 */             u();
/*  464 */             j = 0L;
/*      */           } else {
/*  466 */             while (j > 50L) {
/*  467 */               currentTick = (int)(System.currentTimeMillis() / 50L);
/*  468 */               j -= 50L;
/*  469 */               u();
/*      */             } 
/*      */           } 
/*      */           
/*  473 */           Thread.sleep(Math.max(1L, 50L - j));
/*  474 */           this.O = true;
/*      */         } 
/*      */       } else {
/*  477 */         a((CrashReport)null);
/*      */       } 
/*  479 */     } catch (Throwable throwable) {
/*  480 */       MinecraftServer.i.error("Encountered an unexpected exception", throwable);
/*  481 */       CrashReport crashreport = null;
/*      */       
/*  483 */       if (throwable instanceof ReportedException) {
/*  484 */         crashreport = b(((ReportedException)throwable).a());
/*      */       } else {
/*  486 */         crashreport = b(new CrashReport("Exception in server tick loop", throwable));
/*      */       } 
/*      */       
/*  489 */       File file1 = new File(new File(s(), "crash-reports"), "crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-server.txt");
/*      */       
/*  491 */       if (crashreport.a(file1)) {
/*  492 */         MinecraftServer.i.error("This crash report has been saved to: " + file1.getAbsolutePath());
/*      */       } else {
/*  494 */         MinecraftServer.i.error("We were unable to save this crash report to disk.");
/*      */       } 
/*      */       
/*  497 */       a(crashreport);
/*      */     } finally {
/*      */       try {
/*  500 */         stop();
/*  501 */         this.isStopped = true;
/*  502 */       } catch (Throwable throwable1) {
/*  503 */         MinecraftServer.i.error("Exception stopping the server", throwable1);
/*      */       } finally {
/*      */         
/*      */         try {
/*  507 */           this.reader.getTerminal().restore();
/*  508 */         } catch (Exception e) {}
/*      */ 
/*      */         
/*  511 */         t();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void a(ServerPing serverping) {
/*  517 */     File file1 = d("server-icon.png");
/*      */     
/*  519 */     if (file1.isFile()) {
/*  520 */       ByteBuf bytebuf = Unpooled.buffer();
/*      */       
/*      */       try {
/*  523 */         BufferedImage bufferedimage = ImageIO.read(file1);
/*      */         
/*  525 */         Validate.validState((bufferedimage.getWidth() == 64), "Must be 64 pixels wide", new Object[0]);
/*  526 */         Validate.validState((bufferedimage.getHeight() == 64), "Must be 64 pixels high", new Object[0]);
/*  527 */         ImageIO.write(bufferedimage, "PNG", (OutputStream)new ByteBufOutputStream(bytebuf));
/*  528 */         ByteBuf bytebuf1 = Base64.encode(bytebuf);
/*      */         
/*  530 */         serverping.setFavicon("data:image/png;base64," + bytebuf1.toString(Charsets.UTF_8));
/*  531 */       } catch (Exception exception) {
/*  532 */         i.error("Couldn't load server icon", exception);
/*      */       } finally {
/*  534 */         bytebuf.release();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   protected File s() {
/*  540 */     return new File(".");
/*      */   }
/*      */   
/*      */   protected void a(CrashReport crashreport) {}
/*      */   
/*      */   protected void t() {}
/*      */   
/*      */   protected void u() throws ExceptionWorldConflict {
/*  548 */     long i = System.nanoTime();
/*      */     
/*  550 */     this.ticks++;
/*  551 */     if (this.R) {
/*  552 */       this.R = false;
/*  553 */       this.methodProfiler.a = true;
/*  554 */       this.methodProfiler.a();
/*      */     } 
/*      */     
/*  557 */     this.methodProfiler.a("root");
/*  558 */     v();
/*  559 */     if (i - this.V >= 5000000000L) {
/*  560 */       this.V = i;
/*  561 */       this.q.setPlayerSample(new ServerPingPlayerSample(D(), C()));
/*  562 */       GameProfile[] agameprofile = new GameProfile[Math.min(C(), 12)];
/*  563 */       int j = MathHelper.nextInt(this.r, 0, C() - agameprofile.length);
/*      */       
/*  565 */       for (int k = 0; k < agameprofile.length; k++) {
/*  566 */         agameprofile[k] = ((EntityPlayer)this.u.players.get(j + k)).getProfile();
/*      */       }
/*      */       
/*  569 */       Collections.shuffle(Arrays.asList((Object[])agameprofile));
/*  570 */       this.q.b().a(agameprofile);
/*      */     } 
/*      */     
/*  573 */     if (this.autosavePeriod > 0 && this.ticks % this.autosavePeriod == 0) {
/*  574 */       this.methodProfiler.a("save");
/*  575 */       this.u.savePlayers();
/*  576 */       saveChunks(true);
/*  577 */       this.methodProfiler.b();
/*      */     } 
/*      */     
/*  580 */     this.methodProfiler.a("tallying");
/*  581 */     this.g[this.ticks % 100] = System.nanoTime() - i;
/*  582 */     this.methodProfiler.b();
/*  583 */     this.methodProfiler.a("snooper");
/*  584 */     if (!this.l.d() && this.ticks > 100) {
/*  585 */       this.l.a();
/*      */     }
/*      */     
/*  588 */     if (this.ticks % 6000 == 0) {
/*  589 */       this.l.b();
/*      */     }
/*      */     
/*  592 */     this.methodProfiler.b();
/*  593 */     this.methodProfiler.b();
/*      */   }
/*      */   
/*      */   public void v() {
/*  597 */     this.methodProfiler.a("levels");
/*      */ 
/*      */     
/*  600 */     this.server.getScheduler().mainThreadHeartbeat(this.ticks);
/*      */ 
/*      */     
/*  603 */     while (!this.processQueue.isEmpty()) {
/*  604 */       ((Runnable)this.processQueue.remove()).run();
/*      */     }
/*      */     
/*  607 */     ChunkIOExecutor.tick();
/*      */ 
/*      */     
/*  610 */     if (this.ticks % 20 == 0) {
/*  611 */       for (int j = 0; j < (getPlayerList()).players.size(); j++) {
/*  612 */         EntityPlayer entityplayer = (getPlayerList()).players.get(j);
/*  613 */         entityplayer.playerConnection.sendPacket(new PacketPlayOutUpdateTime(entityplayer.world.getTime(), entityplayer.getPlayerTime(), entityplayer.world.getGameRules().getBoolean("doDaylightCycle")));
/*      */       } 
/*      */     }
/*      */     
/*      */     int i;
/*      */     
/*  619 */     for (i = 0; i < this.worlds.size(); i++) {
/*  620 */       long j = System.nanoTime();
/*      */ 
/*      */       
/*  623 */       WorldServer worldserver = this.worlds.get(i);
/*      */       
/*  625 */       this.methodProfiler.a(worldserver.getWorldData().getName());
/*  626 */       this.methodProfiler.a("pools");
/*  627 */       this.methodProfiler.b();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  636 */       this.methodProfiler.a("tick");
/*      */ 
/*      */ 
/*      */       
/*      */       try {
/*  641 */         worldserver.doTick();
/*  642 */       } catch (Throwable throwable) {
/*  643 */         CrashReport crashreport = CrashReport.a(throwable, "Exception ticking world");
/*  644 */         worldserver.a(crashreport);
/*  645 */         throw new ReportedException(crashreport);
/*      */       } 
/*      */       
/*      */       try {
/*  649 */         worldserver.tickEntities();
/*  650 */       } catch (Throwable throwable1) {
/*  651 */         CrashReport crashreport = CrashReport.a(throwable1, "Exception ticking world entities");
/*  652 */         worldserver.a(crashreport);
/*  653 */         throw new ReportedException(crashreport);
/*      */       } 
/*      */       
/*  656 */       this.methodProfiler.b();
/*  657 */       this.methodProfiler.a("tracker");
/*  658 */       worldserver.getTracker().updatePlayers();
/*  659 */       this.methodProfiler.b();
/*  660 */       this.methodProfiler.b();
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  666 */     this.methodProfiler.c("connection");
/*  667 */     ai().c();
/*  668 */     this.methodProfiler.c("players");
/*  669 */     this.u.tick();
/*  670 */     this.methodProfiler.c("tickables");
/*      */     
/*  672 */     for (i = 0; i < this.n.size(); i++) {
/*  673 */       ((IUpdatePlayerListBox)this.n.get(i)).a();
/*      */     }
/*      */     
/*  676 */     this.methodProfiler.b();
/*      */   }
/*      */   
/*      */   public boolean getAllowNether() {
/*  680 */     return true;
/*      */   }
/*      */   
/*      */   public void a(IUpdatePlayerListBox iupdateplayerlistbox) {
/*  684 */     this.n.add(iupdateplayerlistbox);
/*      */   }
/*      */   
/*      */   public static void main(OptionSet options) {
/*  688 */     DispenserRegistry.b();
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
/*      */     try {
/*  764 */       DedicatedServer dedicatedserver = new DedicatedServer(options);
/*      */       
/*  766 */       if (options.has("port")) {
/*  767 */         int port = ((Integer)options.valueOf("port")).intValue();
/*  768 */         if (port > 0) {
/*  769 */           dedicatedserver.setPort(port);
/*      */         }
/*      */       } 
/*      */       
/*  773 */       if (options.has("universe")) {
/*  774 */         dedicatedserver.universe = (File)options.valueOf("universe");
/*      */       }
/*      */       
/*  777 */       if (options.has("world")) {
/*  778 */         dedicatedserver.k((String)options.valueOf("world"));
/*      */       }
/*      */       
/*  781 */       dedicatedserver.primaryThread.start();
/*      */     
/*      */     }
/*  784 */     catch (Exception exception) {
/*  785 */       i.fatal("Failed to start the minecraft server", exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void x() {}
/*      */ 
/*      */   
/*      */   public File d(String s) {
/*  794 */     return new File(s(), s);
/*      */   }
/*      */   
/*      */   public void info(String s) {
/*  798 */     i.info(s);
/*      */   }
/*      */   
/*      */   public void warning(String s) {
/*  802 */     i.warn(s);
/*      */   }
/*      */ 
/*      */   
/*      */   public WorldServer getWorldServer(int i) {
/*  807 */     for (WorldServer world : this.worlds) {
/*  808 */       if (world.dimension == i) {
/*  809 */         return world;
/*      */       }
/*      */     } 
/*      */     
/*  813 */     return this.worlds.get(0);
/*      */   }
/*      */ 
/*      */   
/*      */   public String y() {
/*  818 */     return this.serverIp;
/*      */   }
/*      */   
/*      */   public int z() {
/*  822 */     return this.t;
/*      */   }
/*      */   
/*      */   public String A() {
/*  826 */     return this.motd;
/*      */   }
/*      */   
/*      */   public String getVersion() {
/*  830 */     return "1.7.10";
/*      */   }
/*      */   
/*      */   public int C() {
/*  834 */     return this.u.getPlayerCount();
/*      */   }
/*      */   
/*      */   public int D() {
/*  838 */     return this.u.getMaxPlayers();
/*      */   }
/*      */   
/*      */   public String[] getPlayers() {
/*  842 */     return this.u.f();
/*      */   }
/*      */   
/*      */   public GameProfile[] F() {
/*  846 */     return this.u.g();
/*      */   }
/*      */ 
/*      */   
/*      */   public String getPlugins() {
/*  851 */     StringBuilder result = new StringBuilder();
/*  852 */     Plugin[] plugins = this.server.getPluginManager().getPlugins();
/*      */     
/*  854 */     result.append(this.server.getName());
/*  855 */     result.append(" on Bukkit ");
/*  856 */     result.append(this.server.getBukkitVersion());
/*      */     
/*  858 */     if (plugins.length > 0 && this.server.getQueryPlugins()) {
/*  859 */       result.append(": ");
/*      */       
/*  861 */       for (int i = 0; i < plugins.length; i++) {
/*  862 */         if (i > 0) {
/*  863 */           result.append("; ");
/*      */         }
/*      */         
/*  866 */         result.append(plugins[i].getDescription().getName());
/*  867 */         result.append(" ");
/*  868 */         result.append(plugins[i].getDescription().getVersion().replaceAll(";", ","));
/*      */       } 
/*      */     } 
/*      */     
/*  872 */     return result.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String g(final String s) {
/*  878 */     Waitable<String> waitable = new Waitable<String>()
/*      */       {
/*      */         protected String evaluate() {
/*  881 */           RemoteControlCommandListener.instance.e();
/*      */           
/*  883 */           RemoteServerCommandEvent event = new RemoteServerCommandEvent((CommandSender)MinecraftServer.this.remoteConsole, s);
/*  884 */           MinecraftServer.this.server.getPluginManager().callEvent((Event)event);
/*      */           
/*  886 */           ServerCommand servercommand = new ServerCommand(event.getCommand(), RemoteControlCommandListener.instance);
/*  887 */           MinecraftServer.this.server.dispatchServerCommand((CommandSender)MinecraftServer.this.remoteConsole, servercommand);
/*      */           
/*  889 */           return RemoteControlCommandListener.instance.f(); }
/*      */       };
/*  891 */     this.processQueue.add(waitable);
/*      */     try {
/*  893 */       return (String)waitable.get();
/*  894 */     } catch (ExecutionException e) {
/*  895 */       throw new RuntimeException("Exception processing rcon command " + s, e.getCause());
/*  896 */     } catch (InterruptedException e) {
/*  897 */       Thread.currentThread().interrupt();
/*  898 */       throw new RuntimeException("Interrupted processing rcon command " + s, e);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isDebugging() {
/*  904 */     return getPropertyManager().getBoolean("debug", false);
/*      */   }
/*      */   
/*      */   public void h(String s) {
/*  908 */     i.error(s);
/*      */   }
/*      */   
/*      */   public void i(String s) {
/*  912 */     if (isDebugging()) {
/*  913 */       i.info(s);
/*      */     }
/*      */   }
/*      */   
/*      */   public String getServerModName() {
/*  918 */     return this.server.getName();
/*      */   }
/*      */   
/*      */   public CrashReport b(CrashReport crashreport) {
/*  922 */     crashreport.g().a("Profiler Position", new CrashReportProfilerPosition(this));
/*  923 */     if (this.worlds != null && this.worlds.size() > 0 && this.worlds.get(0) != null) {
/*  924 */       crashreport.g().a("Vec3 Pool Size", new CrashReportVec3DPoolSize(this));
/*      */     }
/*      */     
/*  927 */     if (this.u != null) {
/*  928 */       crashreport.g().a("Player Count", new CrashReportPlayerCount(this));
/*      */     }
/*      */     
/*  931 */     return crashreport;
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
/*      */   public List a(ICommandListener icommandlistener, String s) {
/*  976 */     return this.server.tabComplete(icommandlistener, s);
/*      */   }
/*      */ 
/*      */   
/*      */   public static MinecraftServer getServer() {
/*  981 */     return j;
/*      */   }
/*      */   
/*      */   public String getName() {
/*  985 */     return "Server";
/*      */   }
/*      */   
/*      */   public void sendMessage(IChatBaseComponent ichatbasecomponent) {
/*  989 */     i.info(ichatbasecomponent.c());
/*      */   }
/*      */   
/*      */   public boolean a(int i, String s) {
/*  993 */     return true;
/*      */   }
/*      */   
/*      */   public ICommandHandler getCommandHandler() {
/*  997 */     return this.o;
/*      */   }
/*      */   
/*      */   public KeyPair K() {
/* 1001 */     return this.G;
/*      */   }
/*      */   
/*      */   public int L() {
/* 1005 */     return this.t;
/*      */   }
/*      */   
/*      */   public void setPort(int i) {
/* 1009 */     this.t = i;
/*      */   }
/*      */   
/*      */   public String M() {
/* 1013 */     return this.H;
/*      */   }
/*      */   
/*      */   public void j(String s) {
/* 1017 */     this.H = s;
/*      */   }
/*      */   
/*      */   public boolean N() {
/* 1021 */     return (this.H != null);
/*      */   }
/*      */   
/*      */   public String O() {
/* 1025 */     return this.I;
/*      */   }
/*      */   
/*      */   public void k(String s) {
/* 1029 */     this.I = s;
/*      */   }
/*      */   
/*      */   public void a(KeyPair keypair) {
/* 1033 */     this.G = keypair;
/*      */   }
/*      */ 
/*      */   
/*      */   public void a(EnumDifficulty enumdifficulty) {
/* 1038 */     for (int j = 0; j < this.worlds.size(); j++) {
/* 1039 */       WorldServer worldserver = this.worlds.get(j);
/*      */ 
/*      */       
/* 1042 */       if (worldserver != null) {
/* 1043 */         if (worldserver.getWorldData().isHardcore()) {
/* 1044 */           worldserver.difficulty = EnumDifficulty.HARD;
/* 1045 */           worldserver.setSpawnFlags(true, true);
/* 1046 */         } else if (N()) {
/* 1047 */           worldserver.difficulty = enumdifficulty;
/* 1048 */           worldserver.setSpawnFlags((worldserver.difficulty != EnumDifficulty.PEACEFUL), true);
/*      */         } else {
/* 1050 */           worldserver.difficulty = enumdifficulty;
/* 1051 */           worldserver.setSpawnFlags(getSpawnMonsters(), this.spawnAnimals);
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   protected boolean getSpawnMonsters() {
/* 1058 */     return true;
/*      */   }
/*      */   
/*      */   public boolean R() {
/* 1062 */     return this.demoMode;
/*      */   }
/*      */   
/*      */   public void b(boolean flag) {
/* 1066 */     this.demoMode = flag;
/*      */   }
/*      */   
/*      */   public void c(boolean flag) {
/* 1070 */     this.L = flag;
/*      */   }
/*      */   
/*      */   public Convertable getConvertable() {
/* 1074 */     return this.convertable;
/*      */   }
/*      */   
/*      */   public void U() {
/* 1078 */     this.M = true;
/* 1079 */     getConvertable().d();
/*      */ 
/*      */     
/* 1082 */     for (int i = 0; i < this.worlds.size(); i++) {
/* 1083 */       WorldServer worldserver = this.worlds.get(i);
/*      */ 
/*      */       
/* 1086 */       if (worldserver != null) {
/* 1087 */         worldserver.saveLevel();
/*      */       }
/*      */     } 
/*      */     
/* 1091 */     getConvertable().e(((WorldServer)this.worlds.get(0)).getDataManager().g());
/* 1092 */     safeShutdown();
/*      */   }
/*      */   
/*      */   public String getResourcePack() {
/* 1096 */     return this.N;
/*      */   }
/*      */   
/*      */   public void setTexturePack(String s) {
/* 1100 */     this.N = s;
/*      */   }
/*      */   
/*      */   public void a(MojangStatisticsGenerator mojangstatisticsgenerator) {
/* 1104 */     mojangstatisticsgenerator.a("whitelist_enabled", Boolean.valueOf(false));
/* 1105 */     mojangstatisticsgenerator.a("whitelist_count", Integer.valueOf(0));
/* 1106 */     mojangstatisticsgenerator.a("players_current", Integer.valueOf(C()));
/* 1107 */     mojangstatisticsgenerator.a("players_max", Integer.valueOf(D()));
/* 1108 */     mojangstatisticsgenerator.a("players_seen", Integer.valueOf((this.u.getSeenPlayers()).length));
/* 1109 */     mojangstatisticsgenerator.a("uses_auth", Boolean.valueOf(this.onlineMode));
/* 1110 */     mojangstatisticsgenerator.a("gui_state", ak() ? "enabled" : "disabled");
/* 1111 */     mojangstatisticsgenerator.a("run_time", Long.valueOf((ar() - mojangstatisticsgenerator.g()) / 60L * 1000L));
/* 1112 */     mojangstatisticsgenerator.a("avg_tick_ms", Integer.valueOf((int)(MathHelper.a(this.g) * 1.0E-6D)));
/* 1113 */     int i = 0;
/*      */ 
/*      */     
/* 1116 */     for (int j = 0; j < this.worlds.size(); j++) {
/* 1117 */       WorldServer worldserver = this.worlds.get(j);
/* 1118 */       if (this.worldServer != null) {
/*      */         
/* 1120 */         WorldData worlddata = worldserver.getWorldData();
/*      */         
/* 1122 */         mojangstatisticsgenerator.a("world[" + i + "][dimension]", Integer.valueOf(worldserver.worldProvider.dimension));
/* 1123 */         mojangstatisticsgenerator.a("world[" + i + "][mode]", worlddata.getGameType());
/* 1124 */         mojangstatisticsgenerator.a("world[" + i + "][difficulty]", worldserver.difficulty);
/* 1125 */         mojangstatisticsgenerator.a("world[" + i + "][hardcore]", Boolean.valueOf(worlddata.isHardcore()));
/* 1126 */         mojangstatisticsgenerator.a("world[" + i + "][generator_name]", worlddata.getType().name());
/* 1127 */         mojangstatisticsgenerator.a("world[" + i + "][generator_version]", Integer.valueOf(worlddata.getType().getVersion()));
/* 1128 */         mojangstatisticsgenerator.a("world[" + i + "][height]", Integer.valueOf(this.E));
/* 1129 */         mojangstatisticsgenerator.a("world[" + i + "][chunks_loaded]", Integer.valueOf(worldserver.L().getLoadedChunks()));
/* 1130 */         i++;
/*      */       } 
/*      */     } 
/*      */     
/* 1134 */     mojangstatisticsgenerator.a("worlds", Integer.valueOf(i));
/*      */   }
/*      */   
/*      */   public void b(MojangStatisticsGenerator mojangstatisticsgenerator) {
/* 1138 */     mojangstatisticsgenerator.b("singleplayer", Boolean.valueOf(N()));
/* 1139 */     mojangstatisticsgenerator.b("server_brand", getServerModName());
/* 1140 */     mojangstatisticsgenerator.b("gui_supported", GraphicsEnvironment.isHeadless() ? "headless" : "supported");
/* 1141 */     mojangstatisticsgenerator.b("dedicated", Boolean.valueOf(X()));
/*      */   }
/*      */   
/*      */   public boolean getSnooperEnabled() {
/* 1145 */     return true;
/*      */   }
/*      */   
/*      */   public abstract boolean X();
/*      */   
/*      */   public boolean getOnlineMode() {
/* 1151 */     return this.server.getOnlineMode();
/*      */   }
/*      */   
/*      */   public void setOnlineMode(boolean flag) {
/* 1155 */     this.onlineMode = flag;
/*      */   }
/*      */   
/*      */   public boolean getSpawnAnimals() {
/* 1159 */     return this.spawnAnimals;
/*      */   }
/*      */   
/*      */   public void setSpawnAnimals(boolean flag) {
/* 1163 */     this.spawnAnimals = flag;
/*      */   }
/*      */   
/*      */   public boolean getSpawnNPCs() {
/* 1167 */     return this.spawnNPCs;
/*      */   }
/*      */   
/*      */   public void setSpawnNPCs(boolean flag) {
/* 1171 */     this.spawnNPCs = flag;
/*      */   }
/*      */   
/*      */   public boolean getPvP() {
/* 1175 */     return this.pvpMode;
/*      */   }
/*      */   
/*      */   public void setPvP(boolean flag) {
/* 1179 */     this.pvpMode = flag;
/*      */   }
/*      */   
/*      */   public boolean getAllowFlight() {
/* 1183 */     return this.allowFlight;
/*      */   }
/*      */   
/*      */   public void setAllowFlight(boolean flag) {
/* 1187 */     this.allowFlight = flag;
/*      */   }
/*      */   
/*      */   public abstract boolean getEnableCommandBlock();
/*      */   
/*      */   public String getMotd() {
/* 1193 */     return this.motd;
/*      */   }
/*      */   
/*      */   public void setMotd(String s) {
/* 1197 */     this.motd = s;
/*      */   }
/*      */   
/*      */   public int getMaxBuildHeight() {
/* 1201 */     return this.E;
/*      */   }
/*      */   
/*      */   public void c(int i) {
/* 1205 */     this.E = i;
/*      */   }
/*      */   
/*      */   public boolean isStopped() {
/* 1209 */     return this.isStopped;
/*      */   }
/*      */   
/*      */   public PlayerList getPlayerList() {
/* 1213 */     return this.u;
/*      */   }
/*      */   
/*      */   public void a(PlayerList playerlist) {
/* 1217 */     this.u = playerlist;
/*      */   }
/*      */ 
/*      */   
/*      */   public void a(EnumGamemode enumgamemode) {
/* 1222 */     for (int i = 0; i < this.worlds.size(); i++) {
/* 1223 */       ((WorldServer)(getServer()).worlds.get(i)).getWorldData().setGameType(enumgamemode);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public ServerConnection ai() {
/* 1229 */     return this.p;
/*      */   }
/*      */   
/*      */   public boolean ak() {
/* 1233 */     return false;
/*      */   }
/*      */   
/*      */   public abstract String a(EnumGamemode paramEnumGamemode, boolean paramBoolean);
/*      */   
/*      */   public int al() {
/* 1239 */     return this.ticks;
/*      */   }
/*      */   
/*      */   public void am() {
/* 1243 */     this.R = true;
/*      */   }
/*      */   
/*      */   public ChunkCoordinates getChunkCoordinates() {
/* 1247 */     return new ChunkCoordinates(0, 0, 0);
/*      */   }
/*      */   
/*      */   public World getWorld() {
/* 1251 */     return this.worlds.get(0);
/*      */   }
/*      */   
/*      */   public int getSpawnProtection() {
/* 1255 */     return 16;
/*      */   }
/*      */   
/*      */   public boolean a(World world, int i, int j, int k, EntityHuman entityhuman) {
/* 1259 */     return false;
/*      */   }
/*      */   
/*      */   public void setForceGamemode(boolean flag) {
/* 1263 */     this.S = flag;
/*      */   }
/*      */   
/*      */   public boolean getForceGamemode() {
/* 1267 */     return this.S;
/*      */   }
/*      */   
/*      */   public Proxy aq() {
/* 1271 */     return this.d;
/*      */   }
/*      */   
/*      */   public static long ar() {
/* 1275 */     return System.currentTimeMillis();
/*      */   }
/*      */   
/*      */   public int getIdleTimeout() {
/* 1279 */     return this.F;
/*      */   }
/*      */   
/*      */   public void setIdleTimeout(int i) {
/* 1283 */     this.F = i;
/*      */   }
/*      */   
/*      */   public IChatBaseComponent getScoreboardDisplayName() {
/* 1287 */     return new ChatComponentText(getName());
/*      */   }
/*      */   
/*      */   public boolean at() {
/* 1291 */     return true;
/*      */   }
/*      */   
/*      */   public MinecraftSessionService av() {
/* 1295 */     return this.U;
/*      */   }
/*      */   
/*      */   public GameProfileRepository getGameProfileRepository() {
/* 1299 */     return this.W;
/*      */   }
/*      */   
/*      */   public UserCache getUserCache() {
/* 1303 */     return this.X;
/*      */   }
/*      */   
/*      */   public ServerPing ay() {
/* 1307 */     return this.q;
/*      */   }
/*      */   
/*      */   public void az() {
/* 1311 */     this.V = 0L;
/*      */   }
/*      */   
/*      */   public static Logger getLogger() {
/* 1315 */     return i;
/*      */   }
/*      */   
/*      */   public static PlayerList a(MinecraftServer minecraftserver) {
/* 1319 */     return minecraftserver.u;
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\MinecraftServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */