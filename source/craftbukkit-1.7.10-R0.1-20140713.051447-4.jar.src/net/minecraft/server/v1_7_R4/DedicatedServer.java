/*     */ package net.minecraft.server.v1_7_R4;
/*     */ import java.io.File;
/*     */ import java.io.OutputStream;
/*     */ import java.io.PrintStream;
/*     */ import java.net.InetAddress;
/*     */ import java.net.Proxy;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import java.util.logging.Handler;
/*     */ import java.util.logging.Logger;
/*     */ import org.apache.logging.log4j.Level;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.apache.logging.log4j.core.Appender;
/*     */ import org.apache.logging.log4j.core.Logger;
/*     */ import org.bukkit.command.CommandSender;
/*     */ import org.bukkit.command.RemoteConsoleCommandSender;
/*     */ import org.bukkit.craftbukkit.libs.joptsimple.OptionSet;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.LoggerOutputStream;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.command.CraftRemoteConsoleCommandSender;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.util.ForwardLogHandler;
/*     */ import org.bukkit.craftbukkit.v1_7_R4.util.TerminalConsoleWriterThread;
/*     */ import org.bukkit.event.server.ServerCommandEvent;
/*     */ 
/*     */ public class DedicatedServer extends MinecraftServer implements IMinecraftServer {
/*  26 */   private static final Logger i = LogManager.getLogger();
/*  27 */   private final List j = Collections.synchronizedList(new ArrayList());
/*     */   
/*     */   private RemoteStatusListener k;
/*     */   private RemoteControlListener l;
/*     */   public PropertyManager propertyManager;
/*     */   private EULA n;
/*     */   private boolean generateStructures;
/*     */   private EnumGamemode p;
/*     */   private boolean q;
/*     */   
/*     */   public DedicatedServer(OptionSet options) {
/*  38 */     super(options, Proxy.NO_PROXY);
/*     */ 
/*     */     
/*  41 */     new ThreadSleepForever(this, "Server Infinisleeper");
/*     */   }
/*     */   
/*     */   protected boolean init() throws UnknownHostException {
/*  45 */     ThreadCommandReader threadcommandreader = new ThreadCommandReader(this, "Server console handler");
/*     */     
/*  47 */     threadcommandreader.setDaemon(true);
/*  48 */     threadcommandreader.start();
/*     */ 
/*     */     
/*  51 */     Logger global = Logger.getLogger("");
/*  52 */     global.setUseParentHandlers(false);
/*  53 */     for (Handler handler : global.getHandlers()) {
/*  54 */       global.removeHandler(handler);
/*     */     }
/*  56 */     global.addHandler((Handler)new ForwardLogHandler());
/*     */     
/*  58 */     Logger logger = (Logger)LogManager.getRootLogger();
/*  59 */     for (Appender appender : logger.getAppenders().values()) {
/*  60 */       if (appender instanceof org.apache.logging.log4j.core.appender.ConsoleAppender) {
/*  61 */         logger.removeAppender(appender);
/*     */       }
/*     */     } 
/*     */     
/*  65 */     (new Thread((Runnable)new TerminalConsoleWriterThread(System.out, this.reader))).start();
/*     */     
/*  67 */     System.setOut(new PrintStream((OutputStream)new LoggerOutputStream((Logger)logger, Level.INFO), true));
/*  68 */     System.setErr(new PrintStream((OutputStream)new LoggerOutputStream((Logger)logger, Level.WARN), true));
/*     */ 
/*     */     
/*  71 */     i.info("Starting minecraft server version 1.7.10");
/*  72 */     if (Runtime.getRuntime().maxMemory() / 1024L / 1024L < 512L) {
/*  73 */       i.warn("To start the server with more ram, launch it as \"java -Xmx1024M -Xms1024M -jar minecraft_server.jar\"");
/*     */     }
/*     */     
/*  76 */     i.info("Loading properties");
/*  77 */     this.propertyManager = new PropertyManager(this.options);
/*  78 */     this.n = new EULA(new File("eula.txt"));
/*  79 */     if (!this.n.a()) {
/*  80 */       i.info("You need to agree to the EULA in order to run the server. Go to eula.txt for more info.");
/*  81 */       this.n.b();
/*  82 */       return false;
/*     */     } 
/*  84 */     if (N()) {
/*  85 */       c("127.0.0.1");
/*     */     } else {
/*  87 */       setOnlineMode(this.propertyManager.getBoolean("online-mode", true));
/*  88 */       c(this.propertyManager.getString("server-ip", ""));
/*     */     } 
/*     */     
/*  91 */     setSpawnAnimals(this.propertyManager.getBoolean("spawn-animals", true));
/*  92 */     setSpawnNPCs(this.propertyManager.getBoolean("spawn-npcs", true));
/*  93 */     setPvP(this.propertyManager.getBoolean("pvp", true));
/*  94 */     setAllowFlight(this.propertyManager.getBoolean("allow-flight", false));
/*  95 */     setTexturePack(this.propertyManager.getString("resource-pack", ""));
/*  96 */     setMotd(this.propertyManager.getString("motd", "A Minecraft Server"));
/*  97 */     setForceGamemode(this.propertyManager.getBoolean("force-gamemode", false));
/*  98 */     setIdleTimeout(this.propertyManager.getInt("player-idle-timeout", 0));
/*  99 */     if (this.propertyManager.getInt("difficulty", 1) < 0) {
/* 100 */       this.propertyManager.setProperty("difficulty", Integer.valueOf(0));
/* 101 */     } else if (this.propertyManager.getInt("difficulty", 1) > 3) {
/* 102 */       this.propertyManager.setProperty("difficulty", Integer.valueOf(3));
/*     */     } 
/*     */     
/* 105 */     this.generateStructures = this.propertyManager.getBoolean("generate-structures", true);
/* 106 */     int gamemode = this.propertyManager.getInt("gamemode", EnumGamemode.SURVIVAL.getId());
/*     */     
/* 108 */     this.p = WorldSettings.a(gamemode);
/* 109 */     i.info("Default game type: " + this.p);
/* 110 */     InetAddress inetaddress = null;
/*     */     
/* 112 */     if (getServerIp().length() > 0) {
/* 113 */       inetaddress = InetAddress.getByName(getServerIp());
/*     */     }
/*     */     
/* 116 */     if (L() < 0) {
/* 117 */       setPort(this.propertyManager.getInt("server-port", 25565));
/*     */     }
/*     */     
/* 120 */     i.info("Generating keypair");
/* 121 */     a(MinecraftEncryption.b());
/* 122 */     i.info("Starting Minecraft server on " + ((getServerIp().length() == 0) ? "*" : getServerIp()) + ":" + L());
/*     */     
/*     */     try {
/* 125 */       ai().a(inetaddress, L());
/* 126 */     } catch (Throwable ioexception) {
/* 127 */       i.warn("**** FAILED TO BIND TO PORT!");
/* 128 */       i.warn("The exception was: {}", new Object[] { ioexception.toString() });
/* 129 */       i.warn("Perhaps a server is already running on that port?");
/* 130 */       return false;
/*     */     } 
/*     */     
/* 133 */     a(new DedicatedPlayerList(this));
/*     */     
/* 135 */     if (!getOnlineMode()) {
/* 136 */       i.warn("**** SERVER IS RUNNING IN OFFLINE/INSECURE MODE!");
/* 137 */       i.warn("The server will make no attempt to authenticate usernames. Beware.");
/* 138 */       i.warn("While this makes the game possible to play without internet access, it also opens up the ability for hackers to connect with any username they choose.");
/* 139 */       i.warn("To change this, set \"online-mode\" to \"true\" in the server.properties file.");
/*     */     } 
/*     */     
/* 142 */     if (aE()) {
/* 143 */       getUserCache().c();
/*     */     }
/*     */     
/* 146 */     if (!NameReferencingFileConverter.a(this.propertyManager)) {
/* 147 */       return false;
/*     */     }
/*     */     
/* 150 */     this.convertable = new WorldLoaderServer(this.server.getWorldContainer());
/* 151 */     long j = System.nanoTime();
/*     */     
/* 153 */     if (O() == null) {
/* 154 */       k(this.propertyManager.getString("level-name", "world"));
/*     */     }
/*     */     
/* 157 */     String s = this.propertyManager.getString("level-seed", "");
/* 158 */     String s1 = this.propertyManager.getString("level-type", "DEFAULT");
/* 159 */     String s2 = this.propertyManager.getString("generator-settings", "");
/* 160 */     long k = (new Random()).nextLong();
/*     */     
/* 162 */     if (s.length() > 0) {
/*     */       try {
/* 164 */         long l = Long.parseLong(s);
/*     */         
/* 166 */         if (l != 0L) {
/* 167 */           k = l;
/*     */         }
/* 169 */       } catch (NumberFormatException numberformatexception) {
/* 170 */         k = s.hashCode();
/*     */       } 
/*     */     }
/*     */     
/* 174 */     WorldType worldtype = WorldType.getType(s1);
/*     */     
/* 176 */     if (worldtype == null) {
/* 177 */       worldtype = WorldType.NORMAL;
/*     */     }
/*     */     
/* 180 */     at();
/* 181 */     getEnableCommandBlock();
/* 182 */     l();
/* 183 */     getSnooperEnabled();
/* 184 */     c(this.propertyManager.getInt("max-build-height", 256));
/* 185 */     c((getMaxBuildHeight() + 8) / 16 * 16);
/* 186 */     c(MathHelper.a(getMaxBuildHeight(), 64, 256));
/* 187 */     this.propertyManager.setProperty("max-build-height", Integer.valueOf(getMaxBuildHeight()));
/* 188 */     i.info("Preparing level \"" + O() + "\"");
/* 189 */     a(O(), O(), k, worldtype, s2);
/* 190 */     long i1 = System.nanoTime() - j;
/* 191 */     String s3 = String.format("%.3fs", new Object[] { Double.valueOf(i1 / 1.0E9D) });
/*     */     
/* 193 */     i.info("Done (" + s3 + ")! For help, type \"help\" or \"?\"");
/* 194 */     if (this.propertyManager.getBoolean("enable-query", false)) {
/* 195 */       i.info("Starting GS4 status listener");
/* 196 */       this.k = new RemoteStatusListener(this);
/* 197 */       this.k.a();
/*     */     } 
/*     */     
/* 200 */     if (this.propertyManager.getBoolean("enable-rcon", false)) {
/* 201 */       i.info("Starting remote control listener");
/* 202 */       this.l = new RemoteControlListener(this);
/* 203 */       this.l.a();
/* 204 */       this.remoteConsole = (RemoteConsoleCommandSender)new CraftRemoteConsoleCommandSender();
/*     */     } 
/*     */ 
/*     */     
/* 208 */     if (this.server.getBukkitSpawnRadius() > -1) {
/* 209 */       i.info("'settings.spawn-radius' in bukkit.yml has been moved to 'spawn-protection' in server.properties. I will move your config for you.");
/* 210 */       this.propertyManager.properties.remove("spawn-protection");
/* 211 */       this.propertyManager.getInt("spawn-protection", this.server.getBukkitSpawnRadius());
/* 212 */       this.server.removeBukkitSpawnRadius();
/* 213 */       this.propertyManager.savePropertiesFile();
/*     */     } 
/*     */ 
/*     */     
/* 217 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PropertyManager getPropertyManager() {
/* 224 */     return this.propertyManager;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean getGenerateStructures() {
/* 229 */     return this.generateStructures;
/*     */   }
/*     */   
/*     */   public EnumGamemode getGamemode() {
/* 233 */     return this.p;
/*     */   }
/*     */   
/*     */   public EnumDifficulty getDifficulty() {
/* 237 */     return EnumDifficulty.getById(this.propertyManager.getInt("difficulty", 1));
/*     */   }
/*     */   
/*     */   public boolean isHardcore() {
/* 241 */     return this.propertyManager.getBoolean("hardcore", false);
/*     */   }
/*     */   
/*     */   protected void a(CrashReport crashreport) {}
/*     */   
/*     */   public CrashReport b(CrashReport crashreport) {
/* 247 */     crashreport = super.b(crashreport);
/* 248 */     crashreport.g().a("Is Modded", new CrashReportModded(this));
/* 249 */     crashreport.g().a("Type", new CrashReportType(this));
/* 250 */     return crashreport;
/*     */   }
/*     */   
/*     */   protected void t() {
/* 254 */     System.exit(0);
/*     */   }
/*     */   
/*     */   public void v() {
/* 258 */     super.v();
/* 259 */     aB();
/*     */   }
/*     */   
/*     */   public boolean getAllowNether() {
/* 263 */     return this.propertyManager.getBoolean("allow-nether", true);
/*     */   }
/*     */   
/*     */   public boolean getSpawnMonsters() {
/* 267 */     return this.propertyManager.getBoolean("spawn-monsters", true);
/*     */   }
/*     */   
/*     */   public void a(MojangStatisticsGenerator mojangstatisticsgenerator) {
/* 271 */     mojangstatisticsgenerator.a("whitelist_enabled", Boolean.valueOf(aC().getHasWhitelist()));
/* 272 */     mojangstatisticsgenerator.a("whitelist_count", Integer.valueOf((aC().getWhitelisted()).length));
/* 273 */     super.a(mojangstatisticsgenerator);
/*     */   }
/*     */   
/*     */   public boolean getSnooperEnabled() {
/* 277 */     return this.propertyManager.getBoolean("snooper-enabled", true);
/*     */   }
/*     */   
/*     */   public void issueCommand(String s, ICommandListener icommandlistener) {
/* 281 */     this.j.add(new ServerCommand(s, icommandlistener));
/*     */   }
/*     */   
/*     */   public void aB() {
/* 285 */     while (!this.j.isEmpty()) {
/* 286 */       ServerCommand servercommand = this.j.remove(0);
/*     */ 
/*     */       
/* 289 */       ServerCommandEvent event = new ServerCommandEvent((CommandSender)this.console, servercommand.command);
/* 290 */       this.server.getPluginManager().callEvent((Event)event);
/* 291 */       servercommand = new ServerCommand(event.getCommand(), servercommand.source);
/*     */ 
/*     */       
/* 294 */       this.server.dispatchServerCommand((CommandSender)this.console, servercommand);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean X() {
/* 300 */     return true;
/*     */   }
/*     */   
/*     */   public DedicatedPlayerList aC() {
/* 304 */     return (DedicatedPlayerList)super.getPlayerList();
/*     */   }
/*     */   
/*     */   public int a(String s, int i) {
/* 308 */     return this.propertyManager.getInt(s, i);
/*     */   }
/*     */   
/*     */   public String a(String s, String s1) {
/* 312 */     return this.propertyManager.getString(s, s1);
/*     */   }
/*     */   
/*     */   public boolean a(String s, boolean flag) {
/* 316 */     return this.propertyManager.getBoolean(s, flag);
/*     */   }
/*     */   
/*     */   public void a(String s, Object object) {
/* 320 */     this.propertyManager.setProperty(s, object);
/*     */   }
/*     */   
/*     */   public void a() {
/* 324 */     this.propertyManager.savePropertiesFile();
/*     */   }
/*     */   
/*     */   public String b() {
/* 328 */     File file1 = this.propertyManager.c();
/*     */     
/* 330 */     return (file1 != null) ? file1.getAbsolutePath() : "No settings file";
/*     */   }
/*     */   
/*     */   public void aD() {
/* 334 */     ServerGUI.a(this);
/* 335 */     this.q = true;
/*     */   }
/*     */   
/*     */   public boolean ak() {
/* 339 */     return this.q;
/*     */   }
/*     */   
/*     */   public String a(EnumGamemode enumgamemode, boolean flag) {
/* 343 */     return "";
/*     */   }
/*     */   
/*     */   public boolean getEnableCommandBlock() {
/* 347 */     return this.propertyManager.getBoolean("enable-command-block", false);
/*     */   }
/*     */   
/*     */   public int getSpawnProtection() {
/* 351 */     return this.propertyManager.getInt("spawn-protection", super.getSpawnProtection());
/*     */   }
/*     */   
/*     */   public boolean a(World world, int i, int j, int k, EntityHuman entityhuman) {
/* 355 */     if (world.worldProvider.dimension != 0)
/* 356 */       return false; 
/* 357 */     if (aC().getOPs().isEmpty())
/* 358 */       return false; 
/* 359 */     if (aC().isOp(entityhuman.getProfile()))
/* 360 */       return false; 
/* 361 */     if (getSpawnProtection() <= 0) {
/* 362 */       return false;
/*     */     }
/* 364 */     ChunkCoordinates chunkcoordinates = world.getSpawn();
/* 365 */     int l = MathHelper.a(i - chunkcoordinates.x);
/* 366 */     int i1 = MathHelper.a(k - chunkcoordinates.z);
/* 367 */     int j1 = Math.max(l, i1);
/*     */     
/* 369 */     return (j1 <= getSpawnProtection());
/*     */   }
/*     */ 
/*     */   
/*     */   public int l() {
/* 374 */     return this.propertyManager.getInt("op-permission-level", 4);
/*     */   }
/*     */   
/*     */   public void setIdleTimeout(int i) {
/* 378 */     super.setIdleTimeout(i);
/* 379 */     this.propertyManager.setProperty("player-idle-timeout", Integer.valueOf(i));
/* 380 */     a();
/*     */   }
/*     */   
/*     */   public boolean m() {
/* 384 */     return this.propertyManager.getBoolean("broadcast-rcon-to-ops", true);
/*     */   }
/*     */   
/*     */   public boolean at() {
/* 388 */     return this.propertyManager.getBoolean("announce-player-achievements", true);
/*     */   }
/*     */   
/*     */   protected boolean aE() {
/* 392 */     boolean flag = false;
/*     */     
/*     */     int i;
/*     */     
/* 396 */     for (i = 0; !flag && i <= 2; i++) {
/* 397 */       if (i > 0) {
/*     */         
/* 399 */         DedicatedServer.i.warn("Encountered a problem while converting the user banlist, retrying in a few seconds");
/* 400 */         aG();
/*     */       } 
/*     */       
/* 403 */       flag = NameReferencingFileConverter.a(this);
/*     */     } 
/*     */     
/* 406 */     boolean flag1 = false;
/*     */     
/* 408 */     for (i = 0; !flag1 && i <= 2; i++) {
/* 409 */       if (i > 0) {
/*     */         
/* 411 */         DedicatedServer.i.warn("Encountered a problem while converting the ip banlist, retrying in a few seconds");
/* 412 */         aG();
/*     */       } 
/*     */       
/* 415 */       flag1 = NameReferencingFileConverter.b(this);
/*     */     } 
/*     */     
/* 418 */     boolean flag2 = false;
/*     */     
/* 420 */     for (i = 0; !flag2 && i <= 2; i++) {
/* 421 */       if (i > 0) {
/*     */         
/* 423 */         DedicatedServer.i.warn("Encountered a problem while converting the op list, retrying in a few seconds");
/* 424 */         aG();
/*     */       } 
/*     */       
/* 427 */       flag2 = NameReferencingFileConverter.c(this);
/*     */     } 
/*     */     
/* 430 */     boolean flag3 = false;
/*     */     
/* 432 */     for (i = 0; !flag3 && i <= 2; i++) {
/* 433 */       if (i > 0) {
/*     */         
/* 435 */         DedicatedServer.i.warn("Encountered a problem while converting the whitelist, retrying in a few seconds");
/* 436 */         aG();
/*     */       } 
/*     */       
/* 439 */       flag3 = NameReferencingFileConverter.d(this);
/*     */     } 
/*     */     
/* 442 */     boolean flag4 = false;
/*     */     
/* 444 */     for (i = 0; !flag4 && i <= 2; i++) {
/* 445 */       if (i > 0) {
/*     */         
/* 447 */         DedicatedServer.i.warn("Encountered a problem while converting the player save files, retrying in a few seconds");
/* 448 */         aG();
/*     */       } 
/*     */       
/* 451 */       flag4 = NameReferencingFileConverter.a(this, this.propertyManager);
/*     */     } 
/*     */     
/* 454 */     return (flag || flag1 || flag2 || flag3 || flag4);
/*     */   }
/*     */   
/*     */   private void aG() {
/*     */     try {
/* 459 */       Thread.sleep(5000L);
/* 460 */     } catch (InterruptedException interruptedexception) {}
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PlayerList getPlayerList() {
/* 466 */     return aC();
/*     */   }
/*     */   
/*     */   static Logger aF() {
/* 470 */     return i;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\DedicatedServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */