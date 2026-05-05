/*     */ package net.minecraft.server.dedicated;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.IOException;
/*     */ import java.io.InputStreamReader;
/*     */ import java.net.InetAddress;
/*     */ import java.net.Proxy;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.minecraft.command.ICommandSender;
/*     */ import net.minecraft.command.ServerCommand;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.network.rcon.IServer;
/*     */ import net.minecraft.network.rcon.RConThreadMain;
/*     */ import net.minecraft.network.rcon.RConThreadQuery;
/*     */ import net.minecraft.profiler.PlayerUsageSnooper;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.ServerEula;
/*     */ import net.minecraft.server.gui.MinecraftServerGui;
/*     */ import net.minecraft.server.management.PreYggdrasilConverter;
/*     */ import net.minecraft.server.management.ServerConfigurationManager;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.CryptManager;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.EnumDifficulty;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.WorldSettings;
/*     */ import net.minecraft.world.WorldType;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ @SideOnly(Side.SERVER)
/*     */ public class DedicatedServer extends MinecraftServer implements IServer {
/*  38 */   private static final Logger field_155771_h = LogManager.getLogger();
/*     */ 
/*     */   
/*  41 */   public final List field_71341_l = Collections.synchronizedList(new ArrayList()); private RConThreadQuery field_71342_m;
/*     */   private RConThreadMain field_71339_n;
/*     */   private PropertyManager field_71340_o;
/*     */   private ServerEula field_154332_n;
/*     */   private boolean field_71338_p;
/*     */   private WorldSettings.GameType field_71337_q;
/*     */   private boolean field_71335_s;
/*     */   private static final String __OBFID = "CL_00001784";
/*     */   
/*     */   public DedicatedServer(File p_i1508_1_) {
/*  51 */     super(p_i1508_1_, Proxy.NO_PROXY);
/*     */     
/*  53 */     new Thread(this, "Server Infinisleeper")
/*     */       {
/*     */         private static final String __OBFID = "CL_00001787";
/*     */ 
/*     */ 
/*     */         
/*     */         public void run() {
/*     */           while (true) {
/*     */             try {
/*     */               while (true)
/*  63 */                 Thread.sleep(2147483647L);  break;
/*  64 */             } catch (InterruptedException interruptedException) {}
/*     */           } 
/*     */         }
/*     */       };
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_71197_b() throws IOException {
/*  73 */     Thread thread = new Thread(this, "Server console handler") { private static final String __OBFID = "CL_00001786";
/*     */         
/*     */         public void run() {
/*  76 */           BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
/*     */           try {
/*     */             String str;
/*  79 */             while (!this.field_72428_a.func_71241_aa() && this.field_72428_a.func_71278_l() && (str = bufferedReader.readLine()) != null) {
/*  80 */               this.field_72428_a.func_71331_a(str, (ICommandSender)this.field_72428_a);
/*     */             }
/*  82 */           } catch (IOException iOException) {
/*  83 */             DedicatedServer.field_155771_h.error("Exception handling console input", iOException);
/*     */           } 
/*     */         } }
/*     */       ;
/*  87 */     thread.setDaemon(true);
/*  88 */     thread.start();
/*     */     
/*  90 */     field_155771_h.info("Starting minecraft server version 1.7.10");
/*     */     
/*  92 */     if (Runtime.getRuntime().maxMemory() / 1024L / 1024L < 512L) {
/*  93 */       field_155771_h.warn("To start the server with more ram, launch it as \"java -Xmx1024M -Xms1024M -jar minecraft_server.jar\"");
/*     */     }
/*     */     
/*  96 */     field_155771_h.info("Loading properties");
/*  97 */     this.field_71340_o = new PropertyManager(new File("server.properties"));
/*  98 */     this.field_154332_n = new ServerEula(new File("eula.txt"));
/*     */ 
/*     */     
/* 101 */     if (!this.field_154332_n.func_154346_a()) {
/* 102 */       field_155771_h.info("You need to agree to the EULA in order to run the server. Go to eula.txt for more info.");
/* 103 */       this.field_154332_n.func_154348_b();
/* 104 */       return false;
/*     */     } 
/*     */     
/* 107 */     if (func_71264_H()) {
/* 108 */       func_71189_e("127.0.0.1");
/*     */     } else {
/* 110 */       func_71229_d(this.field_71340_o.func_73670_a("online-mode", true));
/* 111 */       func_71189_e(this.field_71340_o.func_73671_a("server-ip", ""));
/*     */     } 
/*     */     
/* 114 */     func_71251_e(this.field_71340_o.func_73670_a("spawn-animals", true));
/* 115 */     func_71257_f(this.field_71340_o.func_73670_a("spawn-npcs", true));
/* 116 */     func_71188_g(this.field_71340_o.func_73670_a("pvp", true));
/* 117 */     func_71245_h(this.field_71340_o.func_73670_a("allow-flight", false));
/* 118 */     func_155759_m(this.field_71340_o.func_73671_a("resource-pack", ""));
/* 119 */     func_71205_p(this.field_71340_o.func_73671_a("motd", "A Minecraft Server"));
/* 120 */     func_104055_i(this.field_71340_o.func_73670_a("force-gamemode", false));
/* 121 */     func_143006_e(this.field_71340_o.func_73669_a("player-idle-timeout", 0));
/*     */ 
/*     */     
/* 124 */     if (this.field_71340_o.func_73669_a("difficulty", 1) < 0) {
/* 125 */       this.field_71340_o.func_73667_a("difficulty", Integer.valueOf(0));
/* 126 */     } else if (this.field_71340_o.func_73669_a("difficulty", 1) > 3) {
/* 127 */       this.field_71340_o.func_73667_a("difficulty", Integer.valueOf(3));
/*     */     } 
/*     */     
/* 130 */     this.field_71338_p = this.field_71340_o.func_73670_a("generate-structures", true);
/* 131 */     int i = this.field_71340_o.func_73669_a("gamemode", WorldSettings.GameType.SURVIVAL.func_77148_a());
/* 132 */     this.field_71337_q = WorldSettings.func_77161_a(i);
/* 133 */     field_155771_h.info("Default game type: " + this.field_71337_q);
/*     */     
/* 135 */     InetAddress inetAddress = null;
/* 136 */     if (func_71211_k().length() > 0) inetAddress = InetAddress.getByName(func_71211_k()); 
/* 137 */     if (func_71215_F() < 0) func_71208_b(this.field_71340_o.func_73669_a("server-port", 25565));
/*     */     
/* 139 */     field_155771_h.info("Generating keypair");
/* 140 */     func_71253_a(CryptManager.func_75891_b());
/*     */     
/* 142 */     field_155771_h.info("Starting Minecraft server on " + ((func_71211_k().length() == 0) ? "*" : func_71211_k()) + ":" + func_71215_F());
/*     */     try {
/* 144 */       func_147137_ag().func_151265_a(inetAddress, func_71215_F());
/* 145 */     } catch (IOException iOException) {
/* 146 */       field_155771_h.warn("**** FAILED TO BIND TO PORT!");
/* 147 */       field_155771_h.warn("The exception was: {}", new Object[] { iOException.toString() });
/* 148 */       field_155771_h.warn("Perhaps a server is already running on that port?");
/* 149 */       return false;
/*     */     } 
/*     */     
/* 152 */     if (!func_71266_T()) {
/* 153 */       field_155771_h.warn("**** SERVER IS RUNNING IN OFFLINE/INSECURE MODE!");
/* 154 */       field_155771_h.warn("The server will make no attempt to authenticate usernames. Beware.");
/* 155 */       field_155771_h.warn("While this makes the game possible to play without internet access, it also opens up the ability for hackers to connect with any username they choose.");
/* 156 */       field_155771_h.warn("To change this, set \"online-mode\" to \"true\" in the server.properties file.");
/*     */     } 
/*     */     
/* 159 */     if (func_152368_aE()) {
/* 160 */       func_152358_ax().func_152658_c();
/*     */     }
/* 162 */     if (!PreYggdrasilConverter.func_152714_a(this.field_71340_o)) {
/* 163 */       return false;
/*     */     }
/*     */     
/* 166 */     func_152361_a(new DedicatedPlayerList(this));
/*     */     
/* 168 */     long l1 = System.nanoTime();
/*     */     
/* 170 */     if (func_71270_I() == null) func_71261_m(this.field_71340_o.func_73671_a("level-name", "world")); 
/* 171 */     String str1 = this.field_71340_o.func_73671_a("level-seed", "");
/* 172 */     String str2 = this.field_71340_o.func_73671_a("level-type", "DEFAULT");
/* 173 */     String str3 = this.field_71340_o.func_73671_a("generator-settings", "");
/* 174 */     long l2 = (new Random()).nextLong();
/* 175 */     if (str1.length() > 0) {
/*     */       try {
/* 177 */         long l = Long.parseLong(str1);
/* 178 */         if (l != 0L) {
/* 179 */           l2 = l;
/*     */         }
/* 181 */       } catch (NumberFormatException numberFormatException) {
/* 182 */         l2 = str1.hashCode();
/*     */       } 
/*     */     }
/* 185 */     WorldType worldType = WorldType.func_77130_a(str2);
/* 186 */     if (worldType == null) {
/* 187 */       worldType = WorldType.field_77137_b;
/*     */     }
/*     */ 
/*     */     
/* 191 */     func_147136_ar();
/* 192 */     func_82356_Z();
/* 193 */     func_110455_j();
/* 194 */     func_70002_Q();
/*     */     
/* 196 */     func_71191_d(this.field_71340_o.func_73669_a("max-build-height", 256));
/* 197 */     func_71191_d((func_71207_Z() + 8) / 16 * 16);
/* 198 */     func_71191_d(MathHelper.func_76125_a(func_71207_Z(), 64, 256));
/* 199 */     this.field_71340_o.func_73667_a("max-build-height", Integer.valueOf(func_71207_Z()));
/*     */     
/* 201 */     field_155771_h.info("Preparing level \"" + func_71270_I() + "\"");
/* 202 */     func_71247_a(func_71270_I(), func_71270_I(), l2, worldType, str3);
/* 203 */     long l3 = System.nanoTime() - l1;
/* 204 */     String str4 = String.format("%.3fs", new Object[] { Double.valueOf(l3 / 1.0E9D) });
/* 205 */     field_155771_h.info("Done (" + str4 + ")! For help, type \"help\" or \"?\"");
/*     */     
/* 207 */     if (this.field_71340_o.func_73670_a("enable-query", false)) {
/* 208 */       field_155771_h.info("Starting GS4 status listener");
/* 209 */       this.field_71342_m = new RConThreadQuery(this);
/* 210 */       this.field_71342_m.func_72602_a();
/*     */     } 
/* 212 */     if (this.field_71340_o.func_73670_a("enable-rcon", false)) {
/* 213 */       field_155771_h.info("Starting remote control listener");
/* 214 */       this.field_71339_n = new RConThreadMain(this);
/* 215 */       this.field_71339_n.func_72602_a();
/*     */     } 
/*     */     
/* 218 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_71225_e() {
/* 223 */     return this.field_71338_p;
/*     */   }
/*     */ 
/*     */   
/*     */   public WorldSettings.GameType func_71265_f() {
/* 228 */     return this.field_71337_q;
/*     */   }
/*     */ 
/*     */   
/*     */   public EnumDifficulty func_147135_j() {
/* 233 */     return EnumDifficulty.func_151523_a(this.field_71340_o.func_73669_a("difficulty", 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_71199_h() {
/* 238 */     return this.field_71340_o.func_73670_a("hardcore", false);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_71228_a(CrashReport p_71228_1_) {}
/*     */ 
/*     */   
/*     */   public CrashReport func_71230_b(CrashReport p_71230_1_) {
/* 247 */     p_71230_1_ = super.func_71230_b(p_71230_1_);
/*     */     
/* 249 */     p_71230_1_.func_85056_g().func_71500_a("Is Modded", new Callable(this) { private static final String __OBFID = "CL_00001785";
/*     */           
/*     */           public String call() {
/* 252 */             String str = this.field_71743_a.getServerModName();
/* 253 */             if (!str.equals("vanilla")) return "Definitely; Server brand changed to '" + str + "'"; 
/* 254 */             return "Unknown (can't tell)";
/*     */           } }
/*     */       );
/*     */     
/* 258 */     p_71230_1_.func_85056_g().func_71500_a("Type", new Callable(this) { private static final String __OBFID = "CL_00001788";
/*     */           
/*     */           public String call() {
/* 261 */             return "Dedicated Server (map_server.txt)";
/*     */           } }
/*     */       );
/*     */     
/* 265 */     return p_71230_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_71240_o() {
/* 270 */     System.exit(0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71190_q() {
/* 275 */     super.func_71190_q();
/* 276 */     func_71333_ah();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_71255_r() {
/* 281 */     return this.field_71340_o.func_73670_a("allow-nether", true);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_71193_K() {
/* 286 */     return this.field_71340_o.func_73670_a("spawn-monsters", true);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70000_a(PlayerUsageSnooper p_70000_1_) {
/* 291 */     p_70000_1_.func_152768_a("whitelist_enabled", Boolean.valueOf(func_71203_ab().func_72383_n()));
/* 292 */     p_70000_1_.func_152768_a("whitelist_count", Integer.valueOf((func_71203_ab().func_152598_l()).length));
/* 293 */     super.func_70000_a(p_70000_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70002_Q() {
/* 298 */     return this.field_71340_o.func_73670_a("snooper-enabled", true);
/*     */   }
/*     */   
/*     */   public void func_71331_a(String p_71331_1_, ICommandSender p_71331_2_) {
/* 302 */     this.field_71341_l.add(new ServerCommand(p_71331_1_, p_71331_2_));
/*     */   }
/*     */   
/*     */   public void func_71333_ah() {
/* 306 */     while (!this.field_71341_l.isEmpty()) {
/* 307 */       ServerCommand serverCommand = this.field_71341_l.remove(0);
/* 308 */       func_71187_D().func_71556_a(serverCommand.field_73701_b, serverCommand.field_73702_a);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_71262_S() {
/* 314 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public DedicatedPlayerList func_71203_ab() {
/* 319 */     return (DedicatedPlayerList)super.func_71203_ab();
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_71327_a(String p_71327_1_, int p_71327_2_) {
/* 324 */     return this.field_71340_o.func_73669_a(p_71327_1_, p_71327_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71330_a(String p_71330_1_, String p_71330_2_) {
/* 329 */     return this.field_71340_o.func_73671_a(p_71330_1_, p_71330_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_71332_a(String p_71332_1_, boolean p_71332_2_) {
/* 334 */     return this.field_71340_o.func_73670_a(p_71332_1_, p_71332_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71328_a(String p_71328_1_, Object p_71328_2_) {
/* 339 */     this.field_71340_o.func_73667_a(p_71328_1_, p_71328_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71326_a() {
/* 344 */     this.field_71340_o.func_73668_b();
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71329_c() {
/* 349 */     File file = this.field_71340_o.func_73665_c();
/* 350 */     if (file != null) {
/* 351 */       return file.getAbsolutePath();
/*     */     }
/* 353 */     return "No settings file";
/*     */   }
/*     */   
/*     */   public void func_120011_ar() {
/* 357 */     MinecraftServerGui.func_120016_a(this);
/* 358 */     this.field_71335_s = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_71279_ae() {
/* 363 */     return this.field_71335_s;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_71206_a(WorldSettings.GameType p_71206_1_, boolean p_71206_2_) {
/* 368 */     return "";
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_82356_Z() {
/* 373 */     return this.field_71340_o.func_73670_a("enable-command-block", false);
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_82357_ak() {
/* 378 */     return this.field_71340_o.func_73669_a("spawn-protection", super.func_82357_ak());
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_96290_a(World p_96290_1_, int p_96290_2_, int p_96290_3_, int p_96290_4_, EntityPlayer p_96290_5_) {
/* 383 */     if (p_96290_1_.field_73011_w.field_76574_g != 0) return false; 
/* 384 */     if (func_71203_ab().func_152603_m().func_152690_d()) return false; 
/* 385 */     if (func_71203_ab().func_152596_g(p_96290_5_.func_146103_bH())) return false; 
/* 386 */     if (func_82357_ak() <= 0) return false;
/*     */ 
/*     */     
/* 389 */     ChunkCoordinates chunkCoordinates = p_96290_1_.func_72861_E();
/* 390 */     int i = MathHelper.func_76130_a(p_96290_2_ - chunkCoordinates.field_71574_a);
/* 391 */     int j = MathHelper.func_76130_a(p_96290_4_ - chunkCoordinates.field_71573_c);
/* 392 */     int k = Math.max(i, j);
/*     */     
/* 394 */     return (k <= func_82357_ak());
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_110455_j() {
/* 399 */     return this.field_71340_o.func_73669_a("op-permission-level", 4);
/*     */   }
/*     */   
/*     */   public void func_143006_e(int p_143006_1_) {
/* 403 */     super.func_143006_e(p_143006_1_);
/* 404 */     this.field_71340_o.func_73667_a("player-idle-timeout", Integer.valueOf(p_143006_1_));
/* 405 */     func_71326_a();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_152363_m() {
/* 410 */     return this.field_71340_o.func_73670_a("broadcast-rcon-to-ops", true);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_147136_ar() {
/* 415 */     return this.field_71340_o.func_73670_a("announce-player-achievements", true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_152368_aE() throws IOException {
/* 421 */     boolean bool1 = false;
/* 422 */     byte b = 0;
/* 423 */     while (!bool1 && b <= 2) {
/* 424 */       if (b > 0) {
/* 425 */         field_155771_h.warn("Encountered a problem while converting the user banlist, retrying in a few seconds");
/* 426 */         func_152369_aG();
/*     */       } 
/* 428 */       bool1 = PreYggdrasilConverter.func_152724_a(this);
/* 429 */       b++;
/*     */     } 
/*     */     
/* 432 */     boolean bool2 = false;
/* 433 */     b = 0;
/* 434 */     while (!bool2 && b <= 2) {
/* 435 */       if (b > 0) {
/* 436 */         field_155771_h.warn("Encountered a problem while converting the ip banlist, retrying in a few seconds");
/* 437 */         func_152369_aG();
/*     */       } 
/* 439 */       bool2 = PreYggdrasilConverter.func_152722_b(this);
/* 440 */       b++;
/*     */     } 
/*     */     
/* 443 */     boolean bool3 = false;
/* 444 */     b = 0;
/* 445 */     while (!bool3 && b <= 2) {
/* 446 */       if (b > 0) {
/* 447 */         field_155771_h.warn("Encountered a problem while converting the op list, retrying in a few seconds");
/* 448 */         func_152369_aG();
/*     */       } 
/* 450 */       bool3 = PreYggdrasilConverter.func_152718_c(this);
/* 451 */       b++;
/*     */     } 
/*     */     
/* 454 */     boolean bool4 = false;
/* 455 */     b = 0;
/* 456 */     while (!bool4 && b <= 2) {
/* 457 */       if (b > 0) {
/* 458 */         field_155771_h.warn("Encountered a problem while converting the whitelist, retrying in a few seconds");
/* 459 */         func_152369_aG();
/*     */       } 
/* 461 */       bool4 = PreYggdrasilConverter.func_152710_d(this);
/* 462 */       b++;
/*     */     } 
/*     */     
/* 465 */     boolean bool5 = false;
/* 466 */     b = 0;
/* 467 */     while (!bool5 && b <= 2) {
/* 468 */       if (b > 0) {
/* 469 */         field_155771_h.warn("Encountered a problem while converting the player save files, retrying in a few seconds");
/* 470 */         func_152369_aG();
/*     */       } 
/* 472 */       bool5 = PreYggdrasilConverter.func_152723_a(this, this.field_71340_o);
/* 473 */       b++;
/*     */     } 
/*     */     
/* 476 */     return (bool1 || bool2 || bool3 || bool4 || bool5);
/*     */   }
/*     */   
/*     */   private void func_152369_aG() {
/*     */     try {
/* 481 */       Thread.sleep(5000L);
/* 482 */     } catch (InterruptedException interruptedException) {
/*     */       return;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\dedicated\DedicatedServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */