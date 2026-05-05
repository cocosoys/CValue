/*      */ package net.minecraft.server;
/*      */ import com.mojang.authlib.GameProfile;
/*      */ import com.mojang.authlib.GameProfileRepository;
/*      */ import com.mojang.authlib.minecraft.MinecraftSessionService;
/*      */ import com.mojang.authlib.yggdrasil.YggdrasilAuthenticationService;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import io.netty.buffer.ByteBuf;
/*      */ import java.awt.GraphicsEnvironment;
/*      */ import java.awt.image.BufferedImage;
/*      */ import java.io.File;
/*      */ import java.net.Proxy;
/*      */ import java.security.KeyPair;
/*      */ import java.util.ArrayList;
/*      */ import java.util.List;
/*      */ import java.util.Random;
/*      */ import java.util.concurrent.Callable;
/*      */ import javax.imageio.ImageIO;
/*      */ import net.minecraft.command.ICommandManager;
/*      */ import net.minecraft.command.ICommandSender;
/*      */ import net.minecraft.crash.CrashReport;
/*      */ import net.minecraft.network.NetworkSystem;
/*      */ import net.minecraft.network.ServerStatusResponse;
/*      */ import net.minecraft.network.rcon.RConConsoleSource;
/*      */ import net.minecraft.profiler.PlayerUsageSnooper;
/*      */ import net.minecraft.server.dedicated.DedicatedServer;
/*      */ import net.minecraft.server.gui.IUpdatePlayerListBox;
/*      */ import net.minecraft.server.management.PlayerProfileCache;
/*      */ import net.minecraft.server.management.ServerConfigurationManager;
/*      */ import net.minecraft.util.ChatComponentText;
/*      */ import net.minecraft.util.ChunkCoordinates;
/*      */ import net.minecraft.util.IChatComponent;
/*      */ import net.minecraft.util.IProgressUpdate;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.ReportedException;
/*      */ import net.minecraft.world.EnumDifficulty;
/*      */ import net.minecraft.world.MinecraftException;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraft.world.WorldServer;
/*      */ import net.minecraft.world.WorldSettings;
/*      */ import net.minecraft.world.WorldType;
/*      */ import net.minecraft.world.storage.ISaveFormat;
/*      */ import net.minecraft.world.storage.ISaveHandler;
/*      */ import net.minecraft.world.storage.WorldInfo;
/*      */ import org.apache.commons.lang3.Validate;
/*      */ import org.apache.logging.log4j.Logger;
/*      */ 
/*      */ public abstract class MinecraftServer implements ICommandSender, Runnable, IPlayerUsage {
/*   49 */   private static final Logger field_147145_h = LogManager.getLogger();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   58 */   public static final File field_152367_a = new File("usercache.json");
/*      */   
/*      */   private static MinecraftServer field_71309_l;
/*      */   
/*      */   private final ISaveFormat field_71310_m;
/*      */   
/*   64 */   private final PlayerUsageSnooper field_71307_n = new PlayerUsageSnooper("server", this, func_130071_aq());
/*      */   
/*      */   private final File field_71308_o;
/*   67 */   private final List field_71322_p = new ArrayList();
/*      */   private final ICommandManager field_71321_q;
/*   69 */   public final Profiler field_71304_b = new Profiler();
/*      */   private final NetworkSystem field_147144_o;
/*   71 */   private final ServerStatusResponse field_147147_p = new ServerStatusResponse();
/*   72 */   private final Random field_147146_q = new Random();
/*      */   @SideOnly(Side.SERVER)
/*      */   private String field_71320_r;
/*   75 */   private int field_71319_s = -1;
/*      */   
/*      */   public WorldServer[] field_71305_c;
/*      */   
/*      */   private ServerConfigurationManager field_71318_t;
/*      */   private boolean field_71317_u = true;
/*      */   private boolean field_71316_v;
/*      */   private int field_71315_w;
/*      */   protected final Proxy field_110456_c;
/*      */   public String field_71302_d;
/*      */   public int field_71303_e;
/*      */   private boolean field_71325_x;
/*      */   private boolean field_71324_y;
/*      */   private boolean field_71323_z;
/*      */   private boolean field_71284_A;
/*      */   private boolean field_71285_B;
/*      */   private String field_71286_C;
/*      */   private int field_71280_D;
/*   93 */   private int field_143008_E = 0;
/*   94 */   public final long[] field_71311_j = new long[100];
/*      */   public long[][] field_71312_k;
/*      */   private KeyPair field_71292_I;
/*      */   private String field_71293_J;
/*      */   private String field_71294_K;
/*      */   @SideOnly(Side.CLIENT)
/*      */   private String field_71287_L;
/*      */   private boolean field_71288_M;
/*      */   private boolean field_71289_N;
/*      */   private boolean field_71290_O;
/*  104 */   private String field_147141_M = "";
/*      */   private boolean field_71296_Q;
/*      */   private long field_71299_R;
/*      */   private String field_71298_S;
/*      */   private boolean field_71295_T;
/*      */   private boolean field_104057_T;
/*      */   private final YggdrasilAuthenticationService field_152364_T;
/*      */   private final MinecraftSessionService field_147143_S;
/*  112 */   private long field_147142_T = 0L;
/*      */   private final GameProfileRepository field_152365_W;
/*  114 */   private final PlayerProfileCache field_152366_X = new PlayerProfileCache(this, field_152367_a); private static final String __OBFID = "CL_00001462";
/*      */   
/*      */   public MinecraftServer(File p_i45281_1_, Proxy p_i45281_2_) {
/*  117 */     field_71309_l = this;
/*  118 */     this.field_110456_c = p_i45281_2_;
/*  119 */     this.field_71308_o = p_i45281_1_;
/*  120 */     this.field_147144_o = new NetworkSystem(this);
/*  121 */     this.field_71321_q = (ICommandManager)new ServerCommandManager();
/*  122 */     this.field_71310_m = (ISaveFormat)new AnvilSaveConverter(p_i45281_1_);
/*  123 */     this.field_152364_T = new YggdrasilAuthenticationService(p_i45281_2_, UUID.randomUUID().toString());
/*  124 */     this.field_147143_S = this.field_152364_T.createMinecraftSessionService();
/*  125 */     this.field_152365_W = this.field_152364_T.createProfileRepository();
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_71237_c(String p_71237_1_) {
/*  131 */     if (func_71254_M().func_75801_b(p_71237_1_)) {
/*  132 */       field_147145_h.info("Converting map!");
/*  133 */       func_71192_d("menu.convertingLevel");
/*  134 */       func_71254_M().func_75805_a(p_71237_1_, new IProgressUpdate(this) {
/*  135 */             private long field_96245_b = MinecraftServer.func_130071_aq();
/*      */             
/*      */             private static final String __OBFID = "CL_00001417";
/*      */ 
/*      */             
/*      */             public void func_73720_a(String p_73720_1_) {}
/*      */ 
/*      */             
/*      */             @SideOnly(Side.CLIENT)
/*      */             public void func_73721_b(String p_73721_1_) {}
/*      */             
/*      */             public void func_73718_a(int p_73718_1_) {
/*  147 */               if (MinecraftServer.func_130071_aq() - this.field_96245_b >= 1000L) {
/*  148 */                 this.field_96245_b = MinecraftServer.func_130071_aq();
/*  149 */                 MinecraftServer.field_147145_h.info("Converting... " + p_73718_1_ + "%");
/*      */               } 
/*      */             }
/*      */ 
/*      */             
/*      */             @SideOnly(Side.CLIENT)
/*      */             public void func_146586_a() {}
/*      */ 
/*      */             
/*      */             public void func_73719_c(String p_73719_1_) {}
/*      */           });
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected synchronized void func_71192_d(String p_71192_1_) {
/*  165 */     this.field_71298_S = p_71192_1_;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public synchronized String func_71195_b_() {
/*  169 */     return this.field_71298_S;
/*      */   }
/*      */   protected void func_71247_a(String p_71247_1_, String p_71247_2_, long p_71247_3_, WorldType p_71247_5_, String p_71247_6_) {
/*      */     WorldSettings worldSettings;
/*  173 */     func_71237_c(p_71247_1_);
/*  174 */     func_71192_d("menu.loadingLevel");
/*      */     
/*  176 */     this.field_71305_c = new WorldServer[3];
/*  177 */     this.field_71312_k = new long[this.field_71305_c.length][100];
/*      */     
/*  179 */     ISaveHandler iSaveHandler = this.field_71310_m.func_75804_a(p_71247_1_, true);
/*      */ 
/*      */     
/*  182 */     WorldInfo worldInfo = iSaveHandler.func_75757_d();
/*  183 */     if (worldInfo == null) {
/*  184 */       worldSettings = new WorldSettings(p_71247_3_, func_71265_f(), func_71225_e(), func_71199_h(), p_71247_5_);
/*  185 */       worldSettings.func_82750_a(p_71247_6_);
/*      */     } else {
/*  187 */       worldSettings = new WorldSettings(worldInfo);
/*      */     } 
/*  189 */     if (this.field_71289_N) {
/*  190 */       worldSettings.func_77159_a();
/*      */     }
/*      */     
/*  193 */     for (byte b = 0; b < this.field_71305_c.length; b++) {
/*      */       
/*  195 */       byte b1 = 0;
/*  196 */       if (b == 1) b1 = -1; 
/*  197 */       if (b == 2) b1 = 1;
/*      */       
/*  199 */       if (b == 0) {
/*  200 */         if (func_71242_L()) {
/*  201 */           this.field_71305_c[b] = (WorldServer)new DemoWorldServer(this, iSaveHandler, p_71247_2_, b1, this.field_71304_b);
/*      */         } else {
/*  203 */           this.field_71305_c[b] = new WorldServer(this, iSaveHandler, p_71247_2_, b1, worldSettings, this.field_71304_b);
/*      */         } 
/*      */       } else {
/*  206 */         this.field_71305_c[b] = (WorldServer)new WorldServerMulti(this, iSaveHandler, p_71247_2_, b1, worldSettings, this.field_71305_c[0], this.field_71304_b);
/*      */       } 
/*      */       
/*  209 */       this.field_71305_c[b].func_72954_a((IWorldAccess)new WorldManager(this, this.field_71305_c[b]));
/*      */       
/*  211 */       if (!func_71264_H()) {
/*  212 */         this.field_71305_c[b].func_72912_H().func_76060_a(func_71265_f());
/*      */       }
/*      */       
/*  215 */       this.field_71318_t.func_72364_a(this.field_71305_c);
/*      */     } 
/*      */     
/*  218 */     func_147139_a(func_147135_j());
/*      */     
/*  220 */     func_71222_d();
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_71222_d() {
/*  225 */     byte b1 = 16;
/*  226 */     byte b2 = 4;
/*      */     
/*  228 */     char c1 = 'À';
/*  229 */     char c2 = 'ɱ';
/*  230 */     byte b3 = 0;
/*      */     
/*  232 */     func_71192_d("menu.generatingTerrain");
/*      */     
/*  234 */     boolean bool = false;
/*  235 */     field_147145_h.info("Preparing start region for level " + bool);
/*  236 */     WorldServer worldServer = this.field_71305_c[bool];
/*  237 */     ChunkCoordinates chunkCoordinates = worldServer.func_72861_E();
/*      */     
/*  239 */     long l = func_130071_aq();
/*  240 */     for (short s = -192; s <= 192 && func_71278_l(); s += 16) {
/*  241 */       for (short s1 = -192; s1 <= 192 && func_71278_l(); s1 += 16) {
/*      */         
/*  243 */         long l1 = func_130071_aq();
/*  244 */         if (l1 - l > 1000L) {
/*  245 */           func_71216_a_("Preparing spawn area", b3 * 100 / 625);
/*  246 */           l = l1;
/*      */         } 
/*  248 */         b3++;
/*      */         
/*  250 */         worldServer.field_73059_b.func_73158_c(chunkCoordinates.field_71574_a + s >> 4, chunkCoordinates.field_71573_c + s1 >> 4);
/*      */       } 
/*      */     } 
/*      */     
/*  254 */     func_71243_i();
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
/*      */   protected void func_71216_a_(String p_71216_1_, int p_71216_2_) {
/*  270 */     this.field_71302_d = p_71216_1_;
/*  271 */     this.field_71303_e = p_71216_2_;
/*  272 */     field_147145_h.info(p_71216_1_ + ": " + p_71216_2_ + "%");
/*      */   }
/*      */   
/*      */   protected void func_71243_i() {
/*  276 */     this.field_71302_d = null;
/*  277 */     this.field_71303_e = 0;
/*      */   }
/*      */   
/*      */   protected void func_71267_a(boolean p_71267_1_) {
/*  281 */     if (this.field_71290_O)
/*  282 */       return;  for (WorldServer worldServer : this.field_71305_c) {
/*  283 */       if (worldServer != null) {
/*  284 */         if (!p_71267_1_)
/*  285 */           field_147145_h.info("Saving chunks for level '" + worldServer.func_72912_H().func_76065_j() + "'/" + worldServer.field_73011_w.func_80007_l()); 
/*      */         try {
/*  287 */           worldServer.func_73044_a(true, null);
/*  288 */         } catch (MinecraftException minecraftException) {
/*  289 */           field_147145_h.warn(minecraftException.getMessage());
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_71260_j() {
/*  296 */     if (this.field_71290_O)
/*  297 */       return;  field_147145_h.info("Stopping server");
/*  298 */     if (func_147137_ag() != null) {
/*  299 */       func_147137_ag().func_151268_b();
/*      */     }
/*  301 */     if (this.field_71318_t != null) {
/*  302 */       field_147145_h.info("Saving players");
/*  303 */       this.field_71318_t.func_72389_g();
/*  304 */       this.field_71318_t.func_72392_r();
/*      */     } 
/*  306 */     if (this.field_71305_c != null) {
/*  307 */       field_147145_h.info("Saving worlds");
/*  308 */       func_71267_a(false);
/*  309 */       for (byte b = 0; b < this.field_71305_c.length; b++) {
/*  310 */         WorldServer worldServer = this.field_71305_c[b];
/*  311 */         worldServer.func_73041_k();
/*      */       } 
/*      */     } 
/*      */     
/*  315 */     if (this.field_71307_n.func_76468_d())
/*  316 */       this.field_71307_n.func_76470_e(); 
/*      */   }
/*      */   
/*      */   @SideOnly(Side.SERVER)
/*      */   public String func_71211_k() {
/*  321 */     return this.field_71320_r;
/*      */   }
/*      */   @SideOnly(Side.SERVER)
/*      */   public void func_71189_e(String p_71189_1_) {
/*  325 */     this.field_71320_r = p_71189_1_;
/*      */   }
/*      */   
/*      */   public boolean func_71278_l() {
/*  329 */     return this.field_71317_u;
/*      */   }
/*      */   
/*      */   public void func_71263_m() {
/*  333 */     this.field_71317_u = false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void run() {
/*      */     try {
/*  339 */       if (func_71197_b()) {
/*  340 */         long l1 = func_130071_aq();
/*  341 */         long l2 = 0L;
/*      */         
/*  343 */         this.field_147147_p.func_151315_a((IChatComponent)new ChatComponentText(this.field_71286_C));
/*  344 */         this.field_147147_p.func_151321_a(new ServerStatusResponse.MinecraftProtocolVersionIdentifier("1.7.10", 5));
/*      */         
/*  346 */         func_147138_a(this.field_147147_p);
/*      */         
/*  348 */         while (this.field_71317_u) {
/*  349 */           long l3 = func_130071_aq();
/*  350 */           long l4 = l3 - l1;
/*  351 */           if (l4 > 2000L && l1 - this.field_71299_R >= 15000L) {
/*  352 */             field_147145_h.warn("Can't keep up! Did the system time change, or is the server overloaded? Running {}ms behind, skipping {} tick(s)", new Object[] { Long.valueOf(l4), Long.valueOf(l4 / 50L) });
/*  353 */             l4 = 2000L;
/*  354 */             this.field_71299_R = l1;
/*      */           } 
/*  356 */           if (l4 < 0L) {
/*  357 */             field_147145_h.warn("Time ran backwards! Did the system time change?");
/*  358 */             l4 = 0L;
/*      */           } 
/*  360 */           l2 += l4;
/*  361 */           l1 = l3;
/*      */           
/*  363 */           if (this.field_71305_c[0].func_73056_e()) {
/*  364 */             func_71217_p();
/*  365 */             l2 = 0L;
/*      */           } else {
/*  367 */             while (l2 > 50L) {
/*  368 */               l2 -= 50L;
/*  369 */               func_71217_p();
/*      */             } 
/*      */           } 
/*      */           
/*  373 */           Thread.sleep(Math.max(1L, 50L - l2));
/*  374 */           this.field_71296_Q = true;
/*      */         } 
/*      */       } else {
/*  377 */         func_71228_a(null);
/*      */       } 
/*  379 */     } catch (Throwable throwable) {
/*  380 */       field_147145_h.error("Encountered an unexpected exception", throwable);
/*      */       
/*  382 */       CrashReport crashReport = null;
/*      */       
/*  384 */       if (throwable instanceof ReportedException) {
/*  385 */         crashReport = func_71230_b(((ReportedException)throwable).func_71575_a());
/*      */       } else {
/*  387 */         crashReport = func_71230_b(new CrashReport("Exception in server tick loop", throwable));
/*      */       } 
/*      */       
/*  390 */       File file = new File(new File(func_71238_n(), "crash-reports"), "crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-server.txt");
/*      */       
/*  392 */       if (crashReport.func_147149_a(file)) {
/*  393 */         field_147145_h.error("This crash report has been saved to: " + file.getAbsolutePath());
/*      */       } else {
/*  395 */         field_147145_h.error("We were unable to save this crash report to disk.");
/*      */       } 
/*      */       
/*  398 */       func_71228_a(crashReport);
/*      */     } finally {
/*      */       try {
/*  401 */         func_71260_j();
/*  402 */         this.field_71316_v = true;
/*  403 */       } catch (Throwable throwable) {
/*  404 */         field_147145_h.error("Exception stopping the server", throwable);
/*      */       } finally {
/*  406 */         func_71240_o();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   private void func_147138_a(ServerStatusResponse p_147138_1_) {
/*  412 */     File file = func_71209_f("server-icon.png");
/*  413 */     if (file.isFile()) {
/*  414 */       ByteBuf byteBuf = Unpooled.buffer();
/*      */       
/*      */       try {
/*  417 */         BufferedImage bufferedImage = ImageIO.read(file);
/*  418 */         Validate.validState((bufferedImage.getWidth() == 64), "Must be 64 pixels wide", new Object[0]);
/*  419 */         Validate.validState((bufferedImage.getHeight() == 64), "Must be 64 pixels high", new Object[0]);
/*  420 */         ImageIO.write(bufferedImage, "PNG", (OutputStream)new ByteBufOutputStream(byteBuf));
/*  421 */         ByteBuf byteBuf1 = Base64.encode(byteBuf);
/*  422 */         p_147138_1_.func_151320_a("data:image/png;base64," + byteBuf1.toString(Charsets.UTF_8));
/*  423 */       } catch (Exception exception) {
/*  424 */         field_147145_h.error("Couldn't load server icon", exception);
/*      */       } finally {
/*  426 */         byteBuf.release();
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   protected File func_71238_n() {
/*  432 */     return new File(".");
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_71228_a(CrashReport p_71228_1_) {}
/*      */ 
/*      */   
/*      */   protected void func_71240_o() {}
/*      */   
/*      */   public void func_71217_p() {
/*  442 */     long l = System.nanoTime();
/*      */     
/*  444 */     this.field_71315_w++;
/*      */     
/*  446 */     if (this.field_71295_T) {
/*  447 */       this.field_71295_T = false;
/*  448 */       this.field_71304_b.field_76327_a = true;
/*  449 */       this.field_71304_b.func_76317_a();
/*      */     } 
/*      */     
/*  452 */     this.field_71304_b.func_76320_a("root");
/*  453 */     func_71190_q();
/*      */     
/*  455 */     if (l - this.field_147142_T >= 5000000000L) {
/*  456 */       this.field_147142_T = l;
/*  457 */       this.field_147147_p.func_151319_a(new ServerStatusResponse.PlayerCountData(func_71275_y(), func_71233_x()));
/*      */       
/*  459 */       GameProfile[] arrayOfGameProfile = new GameProfile[Math.min(func_71233_x(), 12)];
/*  460 */       int i = MathHelper.func_76136_a(this.field_147146_q, 0, func_71233_x() - arrayOfGameProfile.length);
/*  461 */       for (byte b = 0; b < arrayOfGameProfile.length; b++) {
/*  462 */         arrayOfGameProfile[b] = ((EntityPlayerMP)this.field_71318_t.field_72404_b.get(i + b)).func_146103_bH();
/*      */       }
/*  464 */       Collections.shuffle(Arrays.asList((Object[])arrayOfGameProfile));
/*  465 */       this.field_147147_p.func_151318_b().func_151330_a(arrayOfGameProfile);
/*      */     } 
/*      */     
/*  468 */     if (this.field_71315_w % 900 == 0) {
/*  469 */       this.field_71304_b.func_76320_a("save");
/*  470 */       this.field_71318_t.func_72389_g();
/*  471 */       func_71267_a(true);
/*  472 */       this.field_71304_b.func_76319_b();
/*      */     } 
/*      */     
/*  475 */     this.field_71304_b.func_76320_a("tallying");
/*  476 */     this.field_71311_j[this.field_71315_w % 100] = System.nanoTime() - l;
/*      */     
/*  478 */     this.field_71304_b.func_76319_b();
/*      */     
/*  480 */     this.field_71304_b.func_76320_a("snooper");
/*  481 */     if (!this.field_71307_n.func_76468_d() && this.field_71315_w > 100) {
/*  482 */       this.field_71307_n.func_76463_a();
/*      */     }
/*      */     
/*  485 */     if (this.field_71315_w % 6000 == 0) {
/*  486 */       this.field_71307_n.func_76471_b();
/*      */     }
/*  488 */     this.field_71304_b.func_76319_b();
/*      */     
/*  490 */     this.field_71304_b.func_76319_b();
/*      */   }
/*      */   
/*      */   public void func_71190_q() {
/*  494 */     this.field_71304_b.func_76320_a("levels");
/*      */     byte b;
/*  496 */     for (b = 0; b < this.field_71305_c.length; b++) {
/*  497 */       long l = System.nanoTime();
/*      */       
/*  499 */       if (b == 0 || func_71255_r()) {
/*  500 */         WorldServer worldServer = this.field_71305_c[b];
/*  501 */         this.field_71304_b.func_76320_a(worldServer.func_72912_H().func_76065_j());
/*      */         
/*  503 */         this.field_71304_b.func_76320_a("pools");
/*  504 */         this.field_71304_b.func_76319_b();
/*      */         
/*  506 */         if (this.field_71315_w % 20 == 0) {
/*  507 */           this.field_71304_b.func_76320_a("timeSync");
/*  508 */           this.field_71318_t.func_148537_a((Packet)new S03PacketTimeUpdate(worldServer.func_82737_E(), worldServer.func_72820_D(), worldServer.func_82736_K().func_82766_b("doDaylightCycle")), worldServer.field_73011_w.field_76574_g);
/*  509 */           this.field_71304_b.func_76319_b();
/*      */         } 
/*      */         
/*  512 */         this.field_71304_b.func_76320_a("tick");
/*      */         try {
/*  514 */           worldServer.func_72835_b();
/*  515 */         } catch (Throwable throwable) {
/*  516 */           CrashReport crashReport = CrashReport.func_85055_a(throwable, "Exception ticking world");
/*  517 */           worldServer.func_72914_a(crashReport);
/*  518 */           throw new ReportedException(crashReport);
/*      */         } 
/*      */         
/*      */         try {
/*  522 */           worldServer.func_72939_s();
/*  523 */         } catch (Throwable throwable) {
/*  524 */           CrashReport crashReport = CrashReport.func_85055_a(throwable, "Exception ticking world entities");
/*  525 */           worldServer.func_72914_a(crashReport);
/*  526 */           throw new ReportedException(crashReport);
/*      */         } 
/*  528 */         this.field_71304_b.func_76319_b();
/*  529 */         this.field_71304_b.func_76320_a("tracker");
/*  530 */         worldServer.func_73039_n().func_72788_a();
/*  531 */         this.field_71304_b.func_76319_b();
/*      */         
/*  533 */         this.field_71304_b.func_76319_b();
/*      */       } 
/*      */       
/*  536 */       this.field_71312_k[b][this.field_71315_w % 100] = System.nanoTime() - l;
/*      */     } 
/*      */     
/*  539 */     this.field_71304_b.func_76318_c("connection");
/*  540 */     func_147137_ag().func_151269_c();
/*  541 */     this.field_71304_b.func_76318_c("players");
/*  542 */     this.field_71318_t.func_72374_b();
/*      */     
/*  544 */     this.field_71304_b.func_76318_c("tickables");
/*  545 */     for (b = 0; b < this.field_71322_p.size(); b++) {
/*  546 */       ((IUpdatePlayerListBox)this.field_71322_p.get(b)).func_73660_a();
/*      */     }
/*  548 */     this.field_71304_b.func_76319_b();
/*      */   }
/*      */   
/*      */   public boolean func_71255_r() {
/*  552 */     return true;
/*      */   }
/*      */   @SideOnly(Side.SERVER)
/*      */   public void func_82010_a(IUpdatePlayerListBox p_82010_1_) {
/*  556 */     this.field_71322_p.add(p_82010_1_);
/*      */   }
/*      */   @SideOnly(Side.SERVER)
/*      */   public static void main(String[] p_main_0_) {
/*  560 */     Bootstrap.func_151354_b();
/*      */     
/*      */     try {
/*  563 */       boolean bool1 = true;
/*  564 */       String str1 = null;
/*  565 */       String str2 = ".";
/*  566 */       String str3 = null;
/*  567 */       boolean bool2 = false;
/*  568 */       boolean bool3 = false;
/*  569 */       int i = -1;
/*      */       
/*  571 */       for (byte b = 0; b < p_main_0_.length; b++) {
/*  572 */         String str4 = p_main_0_[b];
/*  573 */         String str5 = (b == p_main_0_.length - 1) ? null : p_main_0_[b + 1];
/*  574 */         boolean bool = false;
/*      */         
/*  576 */         if (str4.equals("nogui") || str4.equals("--nogui")) {
/*  577 */           bool1 = false;
/*  578 */         } else if (str4.equals("--port") && str5 != null) {
/*  579 */           bool = true;
/*      */           try {
/*  581 */             i = Integer.parseInt(str5);
/*  582 */           } catch (NumberFormatException numberFormatException) {}
/*      */         }
/*  584 */         else if (str4.equals("--singleplayer") && str5 != null) {
/*  585 */           bool = true;
/*  586 */           str1 = str5;
/*  587 */         } else if (str4.equals("--universe") && str5 != null) {
/*  588 */           bool = true;
/*  589 */           str2 = str5;
/*  590 */         } else if (str4.equals("--world") && str5 != null) {
/*  591 */           bool = true;
/*  592 */           str3 = str5;
/*  593 */         } else if (str4.equals("--demo")) {
/*  594 */           bool2 = true;
/*  595 */         } else if (str4.equals("--bonusChest")) {
/*  596 */           bool3 = true;
/*      */         } 
/*      */         
/*  599 */         if (bool) b++;
/*      */       
/*      */       } 
/*  602 */       DedicatedServer dedicatedServer = new DedicatedServer(new File(str2));
/*      */       
/*  604 */       if (str1 != null) dedicatedServer.func_71224_l(str1); 
/*  605 */       if (str3 != null) dedicatedServer.func_71261_m(str3); 
/*  606 */       if (i >= 0) dedicatedServer.func_71208_b(i); 
/*  607 */       if (bool2) dedicatedServer.func_71204_b(true); 
/*  608 */       if (bool3) dedicatedServer.func_71194_c(true); 
/*  609 */       if (bool1 && !GraphicsEnvironment.isHeadless()) dedicatedServer.func_120011_ar();
/*      */       
/*  611 */       dedicatedServer.func_71256_s();
/*      */       
/*  613 */       Runtime.getRuntime().addShutdownHook(new Thread("Server Shutdown Thread", dedicatedServer) { private static final String __OBFID = "CL_00001806";
/*      */             
/*      */             public void run() {
/*  616 */               this.field_96244_a.func_71260_j();
/*      */             } }
/*      */         );
/*  619 */     } catch (Exception exception) {
/*  620 */       field_147145_h.fatal("Failed to start the minecraft server", exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_71256_s() {
/*  625 */     (new Thread(this, "Server thread") { private static final String __OBFID = "CL_00001418";
/*      */         
/*      */         public void run() {
/*  628 */           this.field_73716_a.run();
/*      */         } }
/*      */       ).start();
/*      */   }
/*      */   
/*      */   public File func_71209_f(String p_71209_1_) {
/*  634 */     return new File(func_71238_n(), p_71209_1_);
/*      */   }
/*      */   @SideOnly(Side.SERVER)
/*      */   public void func_71244_g(String p_71244_1_) {
/*  638 */     field_147145_h.info(p_71244_1_);
/*      */   }
/*      */   
/*      */   public void func_71236_h(String p_71236_1_) {
/*  642 */     field_147145_h.warn(p_71236_1_);
/*      */   }
/*      */   
/*      */   public WorldServer func_71218_a(int p_71218_1_) {
/*  646 */     if (p_71218_1_ == -1) return this.field_71305_c[1]; 
/*  647 */     if (p_71218_1_ == 1) return this.field_71305_c[2]; 
/*  648 */     return this.field_71305_c[0];
/*      */   }
/*      */   @SideOnly(Side.SERVER)
/*      */   public String func_71277_t() {
/*  652 */     return this.field_71320_r;
/*      */   }
/*      */   @SideOnly(Side.SERVER)
/*      */   public int func_71234_u() {
/*  656 */     return this.field_71319_s;
/*      */   }
/*      */   @SideOnly(Side.SERVER)
/*      */   public String func_71274_v() {
/*  660 */     return this.field_71286_C;
/*      */   }
/*      */   
/*      */   public String func_71249_w() {
/*  664 */     return "1.7.10";
/*      */   }
/*      */   
/*      */   public int func_71233_x() {
/*  668 */     return this.field_71318_t.func_72394_k();
/*      */   }
/*      */   
/*      */   public int func_71275_y() {
/*  672 */     return this.field_71318_t.func_72352_l();
/*      */   }
/*      */   
/*      */   public String[] func_71213_z() {
/*  676 */     return this.field_71318_t.func_72369_d();
/*      */   }
/*      */   
/*      */   public GameProfile[] func_152357_F() {
/*  680 */     return this.field_71318_t.func_152600_g();
/*      */   }
/*      */   @SideOnly(Side.SERVER)
/*      */   public String func_71258_A() {
/*  684 */     return "";
/*      */   }
/*      */   @SideOnly(Side.SERVER)
/*      */   public String func_71252_i(String p_71252_1_) {
/*  688 */     RConConsoleSource.field_70010_a.func_70007_b();
/*  689 */     this.field_71321_q.func_71556_a((ICommandSender)RConConsoleSource.field_70010_a, p_71252_1_);
/*  690 */     return RConConsoleSource.field_70010_a.func_70008_c();
/*      */   }
/*      */   @SideOnly(Side.SERVER)
/*      */   public boolean func_71239_B() {
/*  694 */     return false;
/*      */   }
/*      */   @SideOnly(Side.SERVER)
/*      */   public void func_71201_j(String p_71201_1_) {
/*  698 */     field_147145_h.error(p_71201_1_);
/*      */   }
/*      */   @SideOnly(Side.SERVER)
/*      */   public void func_71198_k(String p_71198_1_) {
/*  702 */     if (func_71239_B()) {
/*  703 */       field_147145_h.info(p_71198_1_);
/*      */     }
/*      */   }
/*      */   
/*      */   public String getServerModName() {
/*  708 */     return "vanilla";
/*      */   }
/*      */ 
/*      */   
/*      */   public CrashReport func_71230_b(CrashReport p_71230_1_) {
/*  713 */     p_71230_1_.func_85056_g().func_71500_a("Profiler Position", new Callable(this) { private static final String __OBFID = "CL_00001419";
/*      */           
/*      */           public String call() {
/*  716 */             return this.field_74274_a.field_71304_b.field_76327_a ? this.field_74274_a.field_71304_b.func_76322_c() : "N/A (disabled)";
/*      */           } }
/*      */       );
/*      */     
/*  720 */     if (this.field_71305_c != null && this.field_71305_c.length > 0 && this.field_71305_c[0] != null) {
/*  721 */       p_71230_1_.func_85056_g().func_71500_a("Vec3 Pool Size", new Callable(this) { private static final String __OBFID = "CL_00001420";
/*      */             
/*      */             public String call() {
/*  724 */               byte b1 = 0;
/*  725 */               int i = 56 * b1;
/*  726 */               int j = i / 1024 / 1024;
/*  727 */               byte b2 = 0;
/*  728 */               int k = 56 * b2;
/*  729 */               int m = k / 1024 / 1024;
/*      */               
/*  731 */               return b1 + " (" + i + " bytes; " + j + " MB) allocated, " + b2 + " (" + k + " bytes; " + m + " MB) used";
/*      */             } }
/*      */         );
/*      */     }
/*      */     
/*  736 */     if (this.field_71318_t != null) {
/*  737 */       p_71230_1_.func_85056_g().func_71500_a("Player Count", new Callable(this) { private static final String __OBFID = "CL_00001780";
/*      */             
/*      */             public String call() {
/*  740 */               return this.field_74270_a.field_71318_t.func_72394_k() + " / " + this.field_74270_a.field_71318_t.func_72352_l() + "; " + this.field_74270_a.field_71318_t.field_72404_b;
/*      */             } }
/*      */         );
/*      */     }
/*      */     
/*  745 */     return p_71230_1_;
/*      */   }
/*      */   
/*      */   public List func_71248_a(ICommandSender p_71248_1_, String p_71248_2_) {
/*  749 */     ArrayList<String> arrayList = new ArrayList();
/*      */     
/*  751 */     if (p_71248_2_.startsWith("/")) {
/*  752 */       p_71248_2_ = p_71248_2_.substring(1);
/*  753 */       boolean bool = !p_71248_2_.contains(" ") ? true : false;
/*      */       
/*  755 */       List list = this.field_71321_q.func_71558_b(p_71248_1_, p_71248_2_);
/*      */       
/*  757 */       if (list != null) {
/*  758 */         for (String str1 : list) {
/*  759 */           if (bool) {
/*  760 */             arrayList.add("/" + str1); continue;
/*      */           } 
/*  762 */           arrayList.add(str1);
/*      */         } 
/*      */       }
/*      */ 
/*      */       
/*  767 */       return arrayList;
/*      */     } 
/*  769 */     String[] arrayOfString = p_71248_2_.split(" ", -1);
/*  770 */     String str = arrayOfString[arrayOfString.length - 1];
/*      */     
/*  772 */     for (String str1 : this.field_71318_t.func_72369_d()) {
/*  773 */       if (CommandBase.func_71523_a(str, str1)) {
/*  774 */         arrayList.add(str1);
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  779 */     return arrayList;
/*      */   }
/*      */   
/*      */   public static MinecraftServer func_71276_C() {
/*  783 */     return field_71309_l;
/*      */   }
/*      */ 
/*      */   
/*      */   public String func_70005_c_() {
/*  788 */     return "Server";
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_145747_a(IChatComponent p_145747_1_) {
/*  793 */     field_147145_h.info(p_145747_1_.func_150260_c());
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_70003_b(int p_70003_1_, String p_70003_2_) {
/*  798 */     return true;
/*      */   }
/*      */   
/*      */   public ICommandManager func_71187_D() {
/*  802 */     return this.field_71321_q;
/*      */   }
/*      */   
/*      */   public KeyPair func_71250_E() {
/*  806 */     return this.field_71292_I;
/*      */   }
/*      */   @SideOnly(Side.SERVER)
/*      */   public int func_71215_F() {
/*  810 */     return this.field_71319_s;
/*      */   }
/*      */   @SideOnly(Side.SERVER)
/*      */   public void func_71208_b(int p_71208_1_) {
/*  814 */     this.field_71319_s = p_71208_1_;
/*      */   }
/*      */   
/*      */   public String func_71214_G() {
/*  818 */     return this.field_71293_J;
/*      */   }
/*      */   
/*      */   public void func_71224_l(String p_71224_1_) {
/*  822 */     this.field_71293_J = p_71224_1_;
/*      */   }
/*      */   
/*      */   public boolean func_71264_H() {
/*  826 */     return (this.field_71293_J != null);
/*      */   }
/*      */   
/*      */   public String func_71270_I() {
/*  830 */     return this.field_71294_K;
/*      */   }
/*      */   
/*      */   public void func_71261_m(String p_71261_1_) {
/*  834 */     this.field_71294_K = p_71261_1_;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void func_71246_n(String p_71246_1_) {
/*  838 */     this.field_71287_L = p_71246_1_;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public String func_71221_J() {
/*  842 */     return this.field_71287_L;
/*      */   }
/*      */   
/*      */   public void func_71253_a(KeyPair p_71253_1_) {
/*  846 */     this.field_71292_I = p_71253_1_;
/*      */   }
/*      */   
/*      */   public void func_147139_a(EnumDifficulty p_147139_1_) {
/*  850 */     for (byte b = 0; b < this.field_71305_c.length; b++) {
/*  851 */       WorldServer worldServer = this.field_71305_c[b];
/*      */       
/*  853 */       if (worldServer != null) {
/*  854 */         if (worldServer.func_72912_H().func_76093_s()) {
/*  855 */           ((World)worldServer).field_73013_u = EnumDifficulty.HARD;
/*  856 */           worldServer.func_72891_a(true, true);
/*  857 */         } else if (func_71264_H()) {
/*  858 */           ((World)worldServer).field_73013_u = p_147139_1_;
/*  859 */           worldServer.func_72891_a((((World)worldServer).field_73013_u != EnumDifficulty.PEACEFUL), true);
/*      */         } else {
/*  861 */           ((World)worldServer).field_73013_u = p_147139_1_;
/*  862 */           worldServer.func_72891_a(func_71193_K(), this.field_71324_y);
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */   
/*      */   protected boolean func_71193_K() {
/*  869 */     return true;
/*      */   }
/*      */   
/*      */   public boolean func_71242_L() {
/*  873 */     return this.field_71288_M;
/*      */   }
/*      */   
/*      */   public void func_71204_b(boolean p_71204_1_) {
/*  877 */     this.field_71288_M = p_71204_1_;
/*      */   }
/*      */   
/*      */   public void func_71194_c(boolean p_71194_1_) {
/*  881 */     this.field_71289_N = p_71194_1_;
/*      */   }
/*      */   
/*      */   public ISaveFormat func_71254_M() {
/*  885 */     return this.field_71310_m;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_71272_O() {
/*  893 */     this.field_71290_O = true;
/*      */     
/*  895 */     func_71254_M().func_75800_d();
/*      */     
/*  897 */     for (byte b = 0; b < this.field_71305_c.length; b++) {
/*  898 */       WorldServer worldServer = this.field_71305_c[b];
/*      */       
/*  900 */       if (worldServer != null) {
/*  901 */         worldServer.func_73041_k();
/*      */       }
/*      */     } 
/*      */     
/*  905 */     func_71254_M().func_75802_e(this.field_71305_c[0].func_72860_G().func_75760_g());
/*  906 */     func_71263_m();
/*      */   }
/*      */   
/*      */   public String func_147133_T() {
/*  910 */     return this.field_147141_M;
/*      */   }
/*      */   @SideOnly(Side.SERVER)
/*      */   public void func_155759_m(String p_155759_1_) {
/*  914 */     this.field_147141_M = p_155759_1_;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70000_a(PlayerUsageSnooper p_70000_1_) {
/*  919 */     p_70000_1_.func_152768_a("whitelist_enabled", Boolean.valueOf(false));
/*  920 */     p_70000_1_.func_152768_a("whitelist_count", Integer.valueOf(0));
/*  921 */     p_70000_1_.func_152768_a("players_current", Integer.valueOf(func_71233_x()));
/*  922 */     p_70000_1_.func_152768_a("players_max", Integer.valueOf(func_71275_y()));
/*  923 */     p_70000_1_.func_152768_a("players_seen", Integer.valueOf((this.field_71318_t.func_72373_m()).length));
/*  924 */     p_70000_1_.func_152768_a("uses_auth", Boolean.valueOf(this.field_71325_x));
/*  925 */     p_70000_1_.func_152768_a("gui_state", func_71279_ae() ? "enabled" : "disabled");
/*  926 */     p_70000_1_.func_152768_a("run_time", Long.valueOf((func_130071_aq() - p_70000_1_.func_130105_g()) / 60L * 1000L));
/*      */     
/*  928 */     p_70000_1_.func_152768_a("avg_tick_ms", Integer.valueOf((int)(MathHelper.func_76127_a(this.field_71311_j) * 1.0E-6D)));
/*      */     
/*  930 */     byte b1 = 0;
/*  931 */     for (byte b2 = 0; b2 < this.field_71305_c.length; b2++) {
/*  932 */       if (this.field_71305_c[b2] != null) {
/*  933 */         WorldServer worldServer = this.field_71305_c[b2];
/*  934 */         WorldInfo worldInfo = worldServer.func_72912_H();
/*      */         
/*  936 */         p_70000_1_.func_152768_a("world[" + b1 + "][dimension]", Integer.valueOf(worldServer.field_73011_w.field_76574_g));
/*  937 */         p_70000_1_.func_152768_a("world[" + b1 + "][mode]", worldInfo.func_76077_q());
/*  938 */         p_70000_1_.func_152768_a("world[" + b1 + "][difficulty]", worldServer.field_73013_u);
/*  939 */         p_70000_1_.func_152768_a("world[" + b1 + "][hardcore]", Boolean.valueOf(worldInfo.func_76093_s()));
/*  940 */         p_70000_1_.func_152768_a("world[" + b1 + "][generator_name]", worldInfo.func_76067_t().func_77127_a());
/*  941 */         p_70000_1_.func_152768_a("world[" + b1 + "][generator_version]", Integer.valueOf(worldInfo.func_76067_t().func_77131_c()));
/*  942 */         p_70000_1_.func_152768_a("world[" + b1 + "][height]", Integer.valueOf(this.field_71280_D));
/*  943 */         p_70000_1_.func_152768_a("world[" + b1 + "][chunks_loaded]", Integer.valueOf(worldServer.func_72863_F().func_73152_e()));
/*      */         
/*  945 */         b1++;
/*      */       } 
/*      */     } 
/*      */     
/*  949 */     p_70000_1_.func_152768_a("worlds", Integer.valueOf(b1));
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70001_b(PlayerUsageSnooper p_70001_1_) {
/*  954 */     p_70001_1_.func_152767_b("singleplayer", Boolean.valueOf(func_71264_H()));
/*  955 */     p_70001_1_.func_152767_b("server_brand", getServerModName());
/*  956 */     p_70001_1_.func_152767_b("gui_supported", GraphicsEnvironment.isHeadless() ? "headless" : "supported");
/*  957 */     p_70001_1_.func_152767_b("dedicated", Boolean.valueOf(func_71262_S()));
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_70002_Q() {
/*  962 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean func_71266_T() {
/*  968 */     return this.field_71325_x;
/*      */   }
/*      */   
/*      */   public void func_71229_d(boolean p_71229_1_) {
/*  972 */     this.field_71325_x = p_71229_1_;
/*      */   }
/*      */   
/*      */   public boolean func_71268_U() {
/*  976 */     return this.field_71324_y;
/*      */   }
/*      */   
/*      */   public void func_71251_e(boolean p_71251_1_) {
/*  980 */     this.field_71324_y = p_71251_1_;
/*      */   }
/*      */   
/*      */   public boolean func_71220_V() {
/*  984 */     return this.field_71323_z;
/*      */   }
/*      */   
/*      */   public void func_71257_f(boolean p_71257_1_) {
/*  988 */     this.field_71323_z = p_71257_1_;
/*      */   }
/*      */   
/*      */   public boolean func_71219_W() {
/*  992 */     return this.field_71284_A;
/*      */   }
/*      */   
/*      */   public void func_71188_g(boolean p_71188_1_) {
/*  996 */     this.field_71284_A = p_71188_1_;
/*      */   }
/*      */   
/*      */   public boolean func_71231_X() {
/* 1000 */     return this.field_71285_B;
/*      */   }
/*      */   
/*      */   public void func_71245_h(boolean p_71245_1_) {
/* 1004 */     this.field_71285_B = p_71245_1_;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String func_71273_Y() {
/* 1010 */     return this.field_71286_C;
/*      */   }
/*      */   
/*      */   public void func_71205_p(String p_71205_1_) {
/* 1014 */     this.field_71286_C = p_71205_1_;
/*      */   }
/*      */   
/*      */   public int func_71207_Z() {
/* 1018 */     return this.field_71280_D;
/*      */   }
/*      */   
/*      */   public void func_71191_d(int p_71191_1_) {
/* 1022 */     this.field_71280_D = p_71191_1_;
/*      */   }
/*      */   @SideOnly(Side.SERVER)
/*      */   public boolean func_71241_aa() {
/* 1026 */     return this.field_71316_v;
/*      */   }
/*      */   
/*      */   public ServerConfigurationManager func_71203_ab() {
/* 1030 */     return this.field_71318_t;
/*      */   }
/*      */   
/*      */   public void func_152361_a(ServerConfigurationManager p_152361_1_) {
/* 1034 */     this.field_71318_t = p_152361_1_;
/*      */   }
/*      */   
/*      */   public void func_71235_a(WorldSettings.GameType p_71235_1_) {
/* 1038 */     for (byte b = 0; b < this.field_71305_c.length; b++) {
/* 1039 */       (func_71276_C()).field_71305_c[b].func_72912_H().func_76060_a(p_71235_1_);
/*      */     }
/*      */   }
/*      */   
/*      */   public NetworkSystem func_147137_ag() {
/* 1044 */     return this.field_147144_o;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public boolean func_71200_ad() {
/* 1048 */     return this.field_71296_Q;
/*      */   }
/*      */   
/*      */   public boolean func_71279_ae() {
/* 1052 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int func_71259_af() {
/* 1058 */     return this.field_71315_w;
/*      */   }
/*      */   
/*      */   public void func_71223_ag() {
/* 1062 */     this.field_71295_T = true;
/*      */   }
/*      */   @SideOnly(Side.CLIENT)
/*      */   public PlayerUsageSnooper func_80003_ah() {
/* 1066 */     return this.field_71307_n;
/*      */   }
/*      */ 
/*      */   
/*      */   public ChunkCoordinates func_82114_b() {
/* 1071 */     return new ChunkCoordinates(0, 0, 0);
/*      */   }
/*      */ 
/*      */   
/*      */   public World func_130014_f_() {
/* 1076 */     return (World)this.field_71305_c[0];
/*      */   }
/*      */   
/*      */   public int func_82357_ak() {
/* 1080 */     return 16;
/*      */   }
/*      */   
/*      */   public boolean func_96290_a(World p_96290_1_, int p_96290_2_, int p_96290_3_, int p_96290_4_, EntityPlayer p_96290_5_) {
/* 1084 */     return false;
/*      */   }
/*      */   @SideOnly(Side.SERVER)
/*      */   public void func_104055_i(boolean p_104055_1_) {
/* 1088 */     this.field_104057_T = p_104055_1_;
/*      */   }
/*      */   
/*      */   public boolean func_104056_am() {
/* 1092 */     return this.field_104057_T;
/*      */   }
/*      */   
/*      */   public Proxy func_110454_ao() {
/* 1096 */     return this.field_110456_c;
/*      */   }
/*      */   
/*      */   public static long func_130071_aq() {
/* 1100 */     return System.currentTimeMillis();
/*      */   }
/*      */   
/*      */   public int func_143007_ar() {
/* 1104 */     return this.field_143008_E;
/*      */   }
/*      */   
/*      */   public void func_143006_e(int p_143006_1_) {
/* 1108 */     this.field_143008_E = p_143006_1_;
/*      */   }
/*      */ 
/*      */   
/*      */   public IChatComponent func_145748_c_() {
/* 1113 */     return (IChatComponent)new ChatComponentText(func_70005_c_());
/*      */   }
/*      */   
/*      */   public boolean func_147136_ar() {
/* 1117 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public MinecraftSessionService func_147130_as() {
/* 1125 */     return this.field_147143_S;
/*      */   }
/*      */   
/*      */   public GameProfileRepository func_152359_aw() {
/* 1129 */     return this.field_152365_W;
/*      */   }
/*      */   
/*      */   public PlayerProfileCache func_152358_ax() {
/* 1133 */     return this.field_152366_X;
/*      */   }
/*      */   
/*      */   public ServerStatusResponse func_147134_at() {
/* 1137 */     return this.field_147147_p;
/*      */   }
/*      */   
/*      */   public void func_147132_au() {
/* 1141 */     this.field_147142_T = 0L;
/*      */   }
/*      */   
/*      */   protected abstract boolean func_71197_b() throws IOException;
/*      */   
/*      */   public abstract boolean func_71225_e();
/*      */   
/*      */   public abstract WorldSettings.GameType func_71265_f();
/*      */   
/*      */   public abstract EnumDifficulty func_147135_j();
/*      */   
/*      */   public abstract boolean func_71199_h();
/*      */   
/*      */   public abstract int func_110455_j();
/*      */   
/*      */   public abstract boolean func_152363_m();
/*      */   
/*      */   public abstract boolean func_71262_S();
/*      */   
/*      */   public abstract boolean func_82356_Z();
/*      */   
/*      */   public abstract String func_71206_a(WorldSettings.GameType paramGameType, boolean paramBoolean);
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\server\MinecraftServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */