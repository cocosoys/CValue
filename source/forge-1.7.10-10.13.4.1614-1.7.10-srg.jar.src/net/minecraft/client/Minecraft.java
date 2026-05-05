/*      */ package net.minecraft.client;
/*      */ import com.google.common.collect.Lists;
/*      */ import com.google.common.collect.Multimap;
/*      */ import com.google.common.util.concurrent.ListenableFuture;
/*      */ import com.google.common.util.concurrent.ListenableFutureTask;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.awt.image.BufferedImage;
/*      */ import java.io.File;
/*      */ import java.io.IOException;
/*      */ import java.io.InputStream;
/*      */ import java.net.Proxy;
/*      */ import java.net.SocketAddress;
/*      */ import java.nio.ByteBuffer;
/*      */ import java.text.DecimalFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.HashSet;
/*      */ import java.util.List;
/*      */ import java.util.concurrent.Callable;
/*      */ import javax.imageio.ImageIO;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.material.Material;
/*      */ import net.minecraft.client.audio.MusicTicker;
/*      */ import net.minecraft.client.audio.SoundHandler;
/*      */ import net.minecraft.client.gui.FontRenderer;
/*      */ import net.minecraft.client.gui.GuiGameOver;
/*      */ import net.minecraft.client.gui.GuiMainMenu;
/*      */ import net.minecraft.client.gui.GuiScreen;
/*      */ import net.minecraft.client.gui.ScaledResolution;
/*      */ import net.minecraft.client.multiplayer.ServerData;
/*      */ import net.minecraft.client.multiplayer.WorldClient;
/*      */ import net.minecraft.client.network.NetHandlerPlayClient;
/*      */ import net.minecraft.client.renderer.OpenGlHelper;
/*      */ import net.minecraft.client.renderer.Tessellator;
/*      */ import net.minecraft.client.renderer.entity.RenderManager;
/*      */ import net.minecraft.client.renderer.texture.TextureMap;
/*      */ import net.minecraft.client.resources.IResourceManager;
/*      */ import net.minecraft.client.resources.IResourceManagerReloadListener;
/*      */ import net.minecraft.client.resources.IResourcePack;
/*      */ import net.minecraft.client.resources.LanguageManager;
/*      */ import net.minecraft.client.resources.ResourcePackRepository;
/*      */ import net.minecraft.client.resources.data.IMetadataSectionSerializer;
/*      */ import net.minecraft.client.settings.GameSettings;
/*      */ import net.minecraft.client.settings.KeyBinding;
/*      */ import net.minecraft.client.shader.Framebuffer;
/*      */ import net.minecraft.client.stream.IStream;
/*      */ import net.minecraft.crash.CrashReport;
/*      */ import net.minecraft.crash.CrashReportCategory;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.item.EntityItemFrame;
/*      */ import net.minecraft.entity.item.EntityMinecart;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Items;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.network.NetworkManager;
/*      */ import net.minecraft.network.Packet;
/*      */ import net.minecraft.profiler.PlayerUsageSnooper;
/*      */ import net.minecraft.profiler.Profiler;
/*      */ import net.minecraft.server.integrated.IntegratedServer;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.MovingObjectPosition;
/*      */ import net.minecraft.util.ReportedException;
/*      */ import net.minecraft.util.ResourceLocation;
/*      */ import net.minecraft.util.Session;
/*      */ import net.minecraft.util.Util;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraft.world.WorldSettings;
/*      */ import net.minecraft.world.storage.ISaveFormat;
/*      */ import net.minecraft.world.storage.ISaveHandler;
/*      */ import net.minecraft.world.storage.WorldInfo;
/*      */ import org.lwjgl.LWJGLException;
/*      */ import org.lwjgl.Sys;
/*      */ import org.lwjgl.input.Keyboard;
/*      */ import org.lwjgl.input.Mouse;
/*      */ import org.lwjgl.opengl.ContextCapabilities;
/*      */ import org.lwjgl.opengl.Display;
/*      */ import org.lwjgl.opengl.DisplayMode;
/*      */ import org.lwjgl.opengl.GL11;
/*      */ 
/*      */ @SideOnly(Side.CLIENT)
/*      */ public class Minecraft implements IPlayerUsage {
/*   84 */   private static final Logger field_147123_G = LogManager.getLogger();
/*   85 */   private static final ResourceLocation field_110444_H = new ResourceLocation("textures/gui/title/mojang.png");
/*   86 */   public static final boolean field_142025_a = (Util.func_110647_a() == Util.EnumOS.OSX);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   91 */   public static byte[] field_71444_a = new byte[10485760];
/*   92 */   private static final List field_110445_I = Lists.newArrayList((Object[])new DisplayMode[] { new DisplayMode(2560, 1600), new DisplayMode(2880, 1800) });
/*      */   
/*      */   private final File field_130070_K;
/*      */   
/*      */   private final Multimap field_152356_J;
/*      */   
/*      */   private ServerData field_71422_O;
/*      */   
/*      */   public TextureManager field_71446_o;
/*      */   
/*      */   private static Minecraft field_71432_P;
/*      */   public PlayerControllerMP field_71442_b;
/*      */   private boolean field_71431_Q;
/*      */   private boolean field_71434_R;
/*      */   private CrashReport field_71433_S;
/*      */   public int field_71443_c;
/*      */   public int field_71440_d;
/*  109 */   private Timer field_71428_T = new Timer(20.0F);
/*  110 */   private PlayerUsageSnooper field_71427_U = new PlayerUsageSnooper("client", this, MinecraftServer.func_130071_aq());
/*      */   
/*      */   public WorldClient field_71441_e;
/*      */   
/*      */   public RenderGlobal field_71438_f;
/*      */   
/*      */   public EntityClientPlayerMP field_71439_g;
/*      */   
/*      */   public EntityLivingBase field_71451_h;
/*      */   
/*      */   public Entity field_147125_j;
/*      */   
/*      */   public EffectRenderer field_71452_i;
/*      */   
/*      */   private final Session field_71449_j;
/*      */   
/*      */   private boolean field_71445_n;
/*      */   
/*      */   public FontRenderer field_71466_p;
/*      */   
/*      */   public FontRenderer field_71464_q;
/*      */   public GuiScreen field_71462_r;
/*      */   public LoadingScreenRenderer field_71461_s;
/*      */   public EntityRenderer field_71460_t;
/*      */   private int field_71429_W;
/*      */   private int field_71436_X;
/*      */   private int field_71435_Y;
/*      */   private IntegratedServer field_71437_Z;
/*      */   public GuiAchievement field_71458_u;
/*      */   public GuiIngame field_71456_v;
/*      */   public boolean field_71454_w;
/*      */   public MovingObjectPosition field_71476_x;
/*      */   public GameSettings field_71474_y;
/*      */   public MouseHelper field_71417_B;
/*      */   public final File field_71412_D;
/*      */   private final File field_110446_Y;
/*      */   private final String field_110447_Z;
/*      */   private final Proxy field_110453_aa;
/*      */   private ISaveFormat field_71469_aa;
/*      */   private static int field_71470_ab;
/*      */   private int field_71467_ac;
/*      */   private boolean field_71468_ad;
/*      */   private String field_71475_ae;
/*      */   private int field_71477_af;
/*      */   public boolean field_71415_G;
/*  155 */   long field_71423_H = func_71386_F();
/*      */   
/*      */   private int field_71457_ai;
/*      */   private final boolean field_147129_ai;
/*      */   private final boolean field_71459_aj;
/*      */   private NetworkManager field_71453_ak;
/*      */   private boolean field_71455_al;
/*  162 */   public final Profiler field_71424_I = new Profiler();
/*  163 */   private long field_83002_am = -1L;
/*      */   private IReloadableResourceManager field_110451_am;
/*  165 */   private final IMetadataSerializer field_110452_an = new IMetadataSerializer();
/*  166 */   private List field_110449_ao = Lists.newArrayList();
/*      */   
/*      */   public DefaultResourcePack field_110450_ap;
/*      */   
/*      */   private ResourcePackRepository field_110448_aq;
/*      */   
/*      */   private LanguageManager field_135017_as;
/*      */   private IStream field_152353_at;
/*      */   private Framebuffer field_147124_at;
/*      */   private TextureMap field_147128_au;
/*      */   private SoundHandler field_147127_av;
/*      */   private MusicTicker field_147126_aw;
/*      */   private ResourceLocation field_152354_ay;
/*      */   private final MinecraftSessionService field_152355_az;
/*      */   private SkinManager field_152350_aA;
/*  181 */   private final Queue field_152351_aB = Queues.newArrayDeque();
/*  182 */   private final Thread field_152352_aC = Thread.currentThread();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   volatile boolean field_71425_J;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String field_71426_K;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   long field_71419_L;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   int field_71420_M;
/*      */ 
/*      */ 
/*      */   
/*      */   long field_71421_N;
/*      */ 
/*      */ 
/*      */   
/*      */   private String field_71465_an;
/*      */ 
/*      */ 
/*      */   
/*      */   private static final String __OBFID = "CL_00000631";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean func_147122_X() {
/*  220 */     String[] arrayOfString = { "sun.arch.data.model", "com.ibm.vm.bitmode", "os.arch" };
/*      */ 
/*      */ 
/*      */     
/*  224 */     for (String str1 : arrayOfString) {
/*  225 */       String str2 = System.getProperty(str1);
/*  226 */       if (str2 != null && 
/*  227 */         str2.contains("64")) {
/*  228 */         return true;
/*      */       }
/*      */     } 
/*      */ 
/*      */     
/*  233 */     return false;
/*      */   }
/*      */   
/*      */   public Framebuffer func_147110_a() {
/*  237 */     return this.field_147124_at;
/*      */   }
/*      */ 
/*      */   
/*      */   private void func_71389_H() {
/*  242 */     Thread thread = new Thread(this, "Timer hack thread") { private static final String __OBFID = "CL_00000632";
/*      */         
/*      */         public void run() {
/*  245 */           while (this.field_74532_a.field_71425_J) {
/*      */             try {
/*  247 */               Thread.sleep(2147483647L);
/*  248 */             } catch (InterruptedException interruptedException) {}
/*      */           } 
/*      */         } }
/*      */       ;
/*      */     
/*  253 */     thread.setDaemon(true);
/*  254 */     thread.start();
/*      */   }
/*      */   
/*      */   public void func_71404_a(CrashReport p_71404_1_) {
/*  258 */     this.field_71434_R = true;
/*  259 */     this.field_71433_S = p_71404_1_;
/*      */   }
/*      */   
/*      */   public void func_71377_b(CrashReport p_71377_1_) {
/*  263 */     File file1 = new File((func_71410_x()).field_71412_D, "crash-reports");
/*  264 */     File file2 = new File(file1, "crash-" + (new SimpleDateFormat("yyyy-MM-dd_HH.mm.ss")).format(new Date()) + "-client.txt");
/*      */ 
/*      */     
/*  267 */     System.out.println(p_71377_1_.func_71502_e());
/*  268 */     if (p_71377_1_.func_71497_f() != null) {
/*  269 */       System.out.println("#@!@# Game crashed! Crash report saved to: #@!@# " + p_71377_1_.func_71497_f());
/*  270 */       System.exit(-1);
/*  271 */     } else if (p_71377_1_.func_147149_a(file2)) {
/*  272 */       System.out.println("#@!@# Game crashed! Crash report saved to: #@!@# " + file2.getAbsolutePath());
/*  273 */       System.exit(-1);
/*      */     } else {
/*  275 */       System.out.println("#@?@# Game crashed! Crash report could not be saved. #@?@#");
/*  276 */       System.exit(-2);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_71367_a(String p_71367_1_, int p_71367_2_) {
/*  281 */     this.field_71475_ae = p_71367_1_;
/*  282 */     this.field_71477_af = p_71367_2_;
/*      */   }
/*      */   
/*      */   private void func_71384_a() throws LWJGLException {
/*  286 */     this.field_71474_y = new GameSettings(this, this.field_71412_D);
/*  287 */     if (this.field_71474_y.field_92119_C > 0 && this.field_71474_y.field_92118_B > 0) {
/*  288 */       this.field_71443_c = this.field_71474_y.field_92118_B;
/*  289 */       this.field_71440_d = this.field_71474_y.field_92119_C;
/*      */     } 
/*      */     
/*  292 */     if (this.field_71431_Q) {
/*  293 */       Display.setFullscreen(true);
/*  294 */       this.field_71443_c = Display.getDisplayMode().getWidth();
/*  295 */       this.field_71440_d = Display.getDisplayMode().getHeight();
/*  296 */       if (this.field_71443_c <= 0) this.field_71443_c = 1; 
/*  297 */       if (this.field_71440_d <= 0) this.field_71440_d = 1; 
/*      */     } else {
/*  299 */       Display.setDisplayMode(new DisplayMode(this.field_71443_c, this.field_71440_d));
/*      */     } 
/*      */     
/*  302 */     Display.setResizable(true);
/*  303 */     Display.setTitle("Minecraft 1.7.10");
/*      */     
/*  305 */     field_147123_G.info("LWJGL Version: " + Sys.getVersion());
/*      */ 
/*      */     
/*  308 */     Util.EnumOS enumOS = Util.func_110647_a();
/*  309 */     if (enumOS != Util.EnumOS.OSX) {
/*      */       try {
/*  311 */         InputStream inputStream1 = this.field_110450_ap.func_152780_c(new ResourceLocation("icons/icon_16x16.png"));
/*  312 */         InputStream inputStream2 = this.field_110450_ap.func_152780_c(new ResourceLocation("icons/icon_32x32.png"));
/*      */         
/*  314 */         if (inputStream1 != null && inputStream2 != null) {
/*  315 */           Display.setIcon(new ByteBuffer[] { func_152340_a(inputStream1), func_152340_a(inputStream2) });
/*      */         
/*      */         }
/*      */       
/*      */       }
/*  320 */       catch (IOException iOException) {
/*  321 */         field_147123_G.error("Couldn't set icon", iOException);
/*      */       } 
/*      */     }
/*      */ 
/*      */     
/*      */     try {
/*  327 */       Display.create((new PixelFormat()).withDepthBits(24));
/*  328 */     } catch (LWJGLException lWJGLException) {
/*      */       
/*  330 */       field_147123_G.error("Couldn't set pixel format", (Throwable)lWJGLException);
/*      */       try {
/*  332 */         Thread.sleep(1000L);
/*  333 */       } catch (InterruptedException interruptedException) {}
/*      */ 
/*      */       
/*  336 */       if (this.field_71431_Q) {
/*  337 */         func_110441_Q();
/*      */       }
/*      */       
/*  340 */       Display.create();
/*      */     } 
/*      */ 
/*      */     
/*  344 */     OpenGlHelper.func_77474_a();
/*      */     
/*      */     try {
/*  347 */       this.field_152353_at = (IStream)new TwitchStream(this, (String)Iterables.getFirst(this.field_152356_J.get("twitch_access_token"), null));
/*  348 */     } catch (Throwable throwable) {
/*  349 */       this.field_152353_at = (IStream)new NullStream(throwable);
/*  350 */       field_147123_G.error("Couldn't initialize twitch stream");
/*      */     } 
/*      */     
/*  353 */     this.field_147124_at = new Framebuffer(this.field_71443_c, this.field_71440_d, true);
/*  354 */     this.field_147124_at.func_147604_a(0.0F, 0.0F, 0.0F, 0.0F);
/*      */     
/*  356 */     this.field_71458_u = new GuiAchievement(this);
/*      */     
/*  358 */     this.field_110452_an.func_110504_a((IMetadataSectionSerializer)new TextureMetadataSectionSerializer(), TextureMetadataSection.class);
/*  359 */     this.field_110452_an.func_110504_a((IMetadataSectionSerializer)new FontMetadataSectionSerializer(), FontMetadataSection.class);
/*  360 */     this.field_110452_an.func_110504_a((IMetadataSectionSerializer)new AnimationMetadataSectionSerializer(), AnimationMetadataSection.class);
/*  361 */     this.field_110452_an.func_110504_a((IMetadataSectionSerializer)new PackMetadataSectionSerializer(), PackMetadataSection.class);
/*  362 */     this.field_110452_an.func_110504_a((IMetadataSectionSerializer)new LanguageMetadataSectionSerializer(), LanguageMetadataSection.class);
/*      */     
/*  364 */     this.field_71469_aa = (ISaveFormat)new AnvilSaveConverter(new File(this.field_71412_D, "saves"));
/*      */     
/*  366 */     this.field_110448_aq = new ResourcePackRepository(this.field_130070_K, new File(this.field_71412_D, "server-resource-packs"), (IResourcePack)this.field_110450_ap, this.field_110452_an, this.field_71474_y);
/*  367 */     this.field_110451_am = (IReloadableResourceManager)new SimpleReloadableResourceManager(this.field_110452_an);
/*      */     
/*  369 */     this.field_135017_as = new LanguageManager(this.field_110452_an, this.field_71474_y.field_74363_ab);
/*  370 */     this.field_110451_am.func_110542_a((IResourceManagerReloadListener)this.field_135017_as);
/*      */     
/*  372 */     func_110436_a();
/*      */     
/*  374 */     this.field_71446_o = new TextureManager((IResourceManager)this.field_110451_am);
/*  375 */     this.field_110451_am.func_110542_a((IResourceManagerReloadListener)this.field_71446_o);
/*      */     
/*  377 */     this.field_152350_aA = new SkinManager(this.field_71446_o, new File(this.field_110446_Y, "skins"), this.field_152355_az);
/*      */     
/*  379 */     func_71357_I();
/*      */     
/*  381 */     this.field_147127_av = new SoundHandler((IResourceManager)this.field_110451_am, this.field_71474_y);
/*  382 */     this.field_110451_am.func_110542_a((IResourceManagerReloadListener)this.field_147127_av);
/*      */     
/*  384 */     this.field_147126_aw = new MusicTicker(this);
/*      */ 
/*      */     
/*  387 */     this.field_71466_p = new FontRenderer(this.field_71474_y, new ResourceLocation("textures/font/ascii.png"), this.field_71446_o, false);
/*  388 */     if (this.field_71474_y.field_74363_ab != null) {
/*  389 */       this.field_71466_p.func_78264_a(func_152349_b());
/*  390 */       this.field_71466_p.func_78275_b(this.field_135017_as.func_135044_b());
/*      */     } 
/*      */     
/*  393 */     this.field_71464_q = new FontRenderer(this.field_71474_y, new ResourceLocation("textures/font/ascii_sga.png"), this.field_71446_o, false);
/*      */     
/*  395 */     this.field_110451_am.func_110542_a((IResourceManagerReloadListener)this.field_71466_p);
/*  396 */     this.field_110451_am.func_110542_a((IResourceManagerReloadListener)this.field_71464_q);
/*      */     
/*  398 */     this.field_110451_am.func_110542_a((IResourceManagerReloadListener)new GrassColorReloadListener());
/*  399 */     this.field_110451_am.func_110542_a((IResourceManagerReloadListener)new FoliageColorReloadListener());
/*      */     
/*  401 */     RenderManager.field_78727_a.field_78721_f = new ItemRenderer(this);
/*  402 */     this.field_71460_t = new EntityRenderer(this, (IResourceManager)this.field_110451_am);
/*  403 */     this.field_110451_am.func_110542_a((IResourceManagerReloadListener)this.field_71460_t);
/*      */     
/*  405 */     AchievementList.field_76004_f.func_75988_a(new IStatStringFormat(this) { private static final String __OBFID = "CL_00000639";
/*      */           
/*      */           public String func_74535_a(String p_74535_1_) {
/*      */             try {
/*  409 */               return String.format(p_74535_1_, new Object[] { GameSettings.func_74298_c(this.field_74536_a.field_71474_y.field_151445_Q.func_151463_i()) });
/*  410 */             } catch (Exception exception) {
/*  411 */               return "Error: " + exception.getLocalizedMessage();
/*      */             } 
/*      */           } }
/*      */       );
/*      */     
/*  416 */     this.field_71417_B = new MouseHelper();
/*      */     
/*  418 */     func_71361_d("Pre startup");
/*      */     
/*  420 */     GL11.glEnable(3553);
/*  421 */     GL11.glShadeModel(7425);
/*  422 */     GL11.glClearDepth(1.0D);
/*  423 */     GL11.glEnable(2929);
/*  424 */     GL11.glDepthFunc(515);
/*  425 */     GL11.glEnable(3008);
/*  426 */     GL11.glAlphaFunc(516, 0.1F);
/*  427 */     GL11.glCullFace(1029);
/*      */     
/*  429 */     GL11.glMatrixMode(5889);
/*  430 */     GL11.glLoadIdentity();
/*  431 */     GL11.glMatrixMode(5888);
/*  432 */     func_71361_d("Startup");
/*      */     
/*  434 */     this.field_71438_f = new RenderGlobal(this);
/*      */     
/*  436 */     this.field_147128_au = new TextureMap(0, "textures/blocks");
/*  437 */     this.field_147128_au.func_147632_b(this.field_71474_y.field_151443_J);
/*  438 */     this.field_147128_au.func_147633_a(this.field_71474_y.field_151442_I);
/*  439 */     this.field_71446_o.func_130088_a(TextureMap.field_110575_b, this.field_147128_au);
/*  440 */     this.field_71446_o.func_130088_a(TextureMap.field_110576_c, new TextureMap(1, "textures/items"));
/*      */     
/*  442 */     GL11.glViewport(0, 0, this.field_71443_c, this.field_71440_d);
/*      */     
/*  444 */     this.field_71452_i = new EffectRenderer((World)this.field_71441_e, this.field_71446_o);
/*      */     
/*  446 */     func_71361_d("Post startup");
/*  447 */     this.field_71456_v = new GuiIngame(this);
/*      */     
/*  449 */     if (this.field_71475_ae != null) {
/*  450 */       func_147108_a((GuiScreen)new GuiConnecting((GuiScreen)new GuiMainMenu(), this, this.field_71475_ae, this.field_71477_af));
/*      */     } else {
/*  452 */       func_147108_a((GuiScreen)new GuiMainMenu());
/*      */     } 
/*      */ 
/*      */     
/*  456 */     this.field_71446_o.func_147645_c(this.field_152354_ay);
/*  457 */     this.field_152354_ay = null;
/*      */     
/*  459 */     this.field_71461_s = new LoadingScreenRenderer(this);
/*      */     
/*  461 */     if (this.field_71474_y.field_74353_u && !this.field_71431_Q) func_71352_k(); 
/*      */     try {
/*  463 */       Display.setVSyncEnabled(this.field_71474_y.field_74352_v);
/*  464 */     } catch (OpenGLException openGLException) {
/*  465 */       this.field_71474_y.field_74352_v = false;
/*  466 */       this.field_71474_y.func_74303_b();
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean func_152349_b() {
/*  471 */     return (this.field_135017_as.func_135042_a() || this.field_71474_y.field_151455_aw);
/*      */   }
/*      */   
/*      */   public void func_110436_a() {
/*  475 */     ArrayList<IResourcePack> arrayList = Lists.newArrayList(this.field_110449_ao);
/*      */     
/*  477 */     for (ResourcePackRepository.Entry entry : this.field_110448_aq.func_110613_c()) {
/*  478 */       arrayList.add(entry.func_110514_c());
/*      */     }
/*      */     
/*  481 */     if (this.field_110448_aq.func_148530_e() != null) {
/*  482 */       arrayList.add(this.field_110448_aq.func_148530_e());
/*      */     }
/*      */     
/*      */     try {
/*  486 */       this.field_110451_am.func_110541_a(arrayList);
/*  487 */     } catch (RuntimeException runtimeException) {
/*  488 */       field_147123_G.info("Caught error stitching, removing all assigned resourcepacks", runtimeException);
/*      */       
/*  490 */       arrayList.clear();
/*  491 */       arrayList.addAll(this.field_110449_ao);
/*  492 */       this.field_110448_aq.func_148527_a(Collections.emptyList());
/*      */       
/*  494 */       this.field_110451_am.func_110541_a(arrayList);
/*      */       
/*  496 */       this.field_71474_y.field_151453_l.clear();
/*  497 */       this.field_71474_y.func_74303_b();
/*      */     } 
/*  499 */     this.field_135017_as.func_135043_a(arrayList);
/*      */     
/*  501 */     if (this.field_71438_f != null) {
/*  502 */       this.field_71438_f.func_72712_a();
/*      */     }
/*      */   }
/*      */   
/*      */   private void func_110435_P() {
/*  507 */     this.field_110449_ao.add(this.field_110450_ap);
/*      */   }
/*      */   
/*      */   private ByteBuffer func_152340_a(InputStream p_152340_1_) throws IOException {
/*  511 */     BufferedImage bufferedImage = ImageIO.read(p_152340_1_);
/*  512 */     int[] arrayOfInt = bufferedImage.getRGB(0, 0, bufferedImage.getWidth(), bufferedImage.getHeight(), null, 0, bufferedImage.getWidth());
/*      */     
/*  514 */     ByteBuffer byteBuffer = ByteBuffer.allocate(4 * arrayOfInt.length);
/*  515 */     for (int i : arrayOfInt) {
/*  516 */       byteBuffer.putInt(i << 8 | i >> 24 & 0xFF);
/*      */     }
/*  518 */     byteBuffer.flip();
/*  519 */     return byteBuffer;
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
/*      */   private void func_110441_Q() throws LWJGLException {
/*  534 */     HashSet<? super DisplayMode> hashSet = new HashSet();
/*  535 */     Collections.addAll(hashSet, Display.getAvailableDisplayModes());
/*      */     
/*  537 */     DisplayMode displayMode = Display.getDesktopDisplayMode();
/*  538 */     if (!hashSet.contains(displayMode))
/*      */     {
/*  540 */       if (Util.func_110647_a() == Util.EnumOS.OSX) {
/*  541 */         for (DisplayMode displayMode1 : field_110445_I) {
/*      */           
/*  543 */           boolean bool = true;
/*  544 */           for (DisplayMode displayMode2 : hashSet) {
/*  545 */             if (displayMode2.getBitsPerPixel() == 32 && displayMode2.getWidth() == displayMode1.getWidth() && displayMode2.getHeight() == displayMode1.getHeight()) {
/*  546 */               bool = false;
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/*  551 */           if (bool) {
/*      */             continue;
/*      */           }
/*  554 */           for (DisplayMode displayMode2 : hashSet) {
/*  555 */             if (displayMode2.getBitsPerPixel() == 32 && displayMode2.getWidth() == displayMode1.getWidth() / 2 && displayMode2.getHeight() == displayMode1.getHeight() / 2) {
/*  556 */               displayMode = displayMode2;
/*      */             }
/*      */           } 
/*      */         } 
/*      */       }
/*      */     }
/*      */ 
/*      */     
/*  564 */     Display.setDisplayMode(displayMode);
/*  565 */     this.field_71443_c = displayMode.getWidth();
/*  566 */     this.field_71440_d = displayMode.getHeight();
/*      */   }
/*      */   
/*      */   public void func_71357_I() throws LWJGLException {
/*  570 */     ScaledResolution scaledResolution = new ScaledResolution(this, this.field_71443_c, this.field_71440_d);
/*  571 */     int i = scaledResolution.func_78325_e();
/*  572 */     Framebuffer framebuffer = new Framebuffer(scaledResolution.func_78326_a() * i, scaledResolution.func_78328_b() * i, true);
/*  573 */     framebuffer.func_147610_a(false);
/*      */     
/*  575 */     GL11.glMatrixMode(5889);
/*  576 */     GL11.glLoadIdentity();
/*  577 */     GL11.glOrtho(0.0D, scaledResolution.func_78326_a(), scaledResolution.func_78328_b(), 0.0D, 1000.0D, 3000.0D);
/*  578 */     GL11.glMatrixMode(5888);
/*  579 */     GL11.glLoadIdentity();
/*  580 */     GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
/*      */     
/*  582 */     GL11.glDisable(2896);
/*  583 */     GL11.glDisable(2912);
/*  584 */     GL11.glDisable(2929);
/*      */     
/*  586 */     GL11.glEnable(3553);
/*      */     
/*      */     try {
/*  589 */       this.field_152354_ay = this.field_71446_o.func_110578_a("logo", new DynamicTexture(ImageIO.read(this.field_110450_ap.func_110590_a(field_110444_H))));
/*  590 */       this.field_71446_o.func_110577_a(this.field_152354_ay);
/*  591 */     } catch (IOException iOException) {
/*  592 */       field_147123_G.error("Unable to load logo: " + field_110444_H, iOException);
/*      */     } 
/*      */     
/*  595 */     Tessellator tessellator = Tessellator.field_78398_a;
/*  596 */     tessellator.func_78382_b();
/*  597 */     tessellator.func_78378_d(16777215);
/*  598 */     tessellator.func_78374_a(0.0D, this.field_71440_d, 0.0D, 0.0D, 0.0D);
/*  599 */     tessellator.func_78374_a(this.field_71443_c, this.field_71440_d, 0.0D, 0.0D, 0.0D);
/*  600 */     tessellator.func_78374_a(this.field_71443_c, 0.0D, 0.0D, 0.0D, 0.0D);
/*  601 */     tessellator.func_78374_a(0.0D, 0.0D, 0.0D, 0.0D, 0.0D);
/*  602 */     tessellator.func_78381_a();
/*      */     
/*  604 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  605 */     tessellator.func_78378_d(16777215);
/*      */     
/*  607 */     char c1 = 'Ā';
/*  608 */     char c2 = 'Ā';
/*  609 */     func_71392_a((scaledResolution.func_78326_a() - c1) / 2, (scaledResolution.func_78328_b() - c2) / 2, 0, 0, c1, c2);
/*      */     
/*  611 */     GL11.glDisable(2896);
/*  612 */     GL11.glDisable(2912);
/*      */     
/*  614 */     framebuffer.func_147609_e();
/*  615 */     framebuffer.func_147615_c(scaledResolution.func_78326_a() * i, scaledResolution.func_78328_b() * i);
/*      */     
/*  617 */     GL11.glEnable(3008);
/*  618 */     GL11.glAlphaFunc(516, 0.1F);
/*  619 */     GL11.glFlush();
/*      */     
/*  621 */     func_147120_f();
/*      */   }
/*      */   
/*      */   public void func_71392_a(int p_71392_1_, int p_71392_2_, int p_71392_3_, int p_71392_4_, int p_71392_5_, int p_71392_6_) {
/*  625 */     float f1 = 0.00390625F;
/*  626 */     float f2 = 0.00390625F;
/*  627 */     Tessellator tessellator = Tessellator.field_78398_a;
/*  628 */     tessellator.func_78382_b();
/*  629 */     tessellator.func_78374_a((p_71392_1_ + 0), (p_71392_2_ + p_71392_6_), 0.0D, ((p_71392_3_ + 0) * f1), ((p_71392_4_ + p_71392_6_) * f2));
/*  630 */     tessellator.func_78374_a((p_71392_1_ + p_71392_5_), (p_71392_2_ + p_71392_6_), 0.0D, ((p_71392_3_ + p_71392_5_) * f1), ((p_71392_4_ + p_71392_6_) * f2));
/*  631 */     tessellator.func_78374_a((p_71392_1_ + p_71392_5_), (p_71392_2_ + 0), 0.0D, ((p_71392_3_ + p_71392_5_) * f1), ((p_71392_4_ + 0) * f2));
/*  632 */     tessellator.func_78374_a((p_71392_1_ + 0), (p_71392_2_ + 0), 0.0D, ((p_71392_3_ + 0) * f1), ((p_71392_4_ + 0) * f2));
/*  633 */     tessellator.func_78381_a();
/*      */   }
/*      */   
/*      */   public ISaveFormat func_71359_d() {
/*  637 */     return this.field_71469_aa;
/*      */   } public void func_147108_a(GuiScreen p_147108_1_) {
/*      */     GuiMainMenu guiMainMenu;
/*      */     GuiGameOver guiGameOver;
/*  641 */     if (this.field_71462_r != null) {
/*  642 */       this.field_71462_r.func_146281_b();
/*      */     }
/*      */     
/*  645 */     if (p_147108_1_ == null && this.field_71441_e == null) {
/*  646 */       guiMainMenu = new GuiMainMenu();
/*  647 */     } else if (guiMainMenu == null && this.field_71439_g.func_110143_aJ() <= 0.0F) {
/*  648 */       guiGameOver = new GuiGameOver();
/*      */     } 
/*      */     
/*  651 */     if (guiGameOver instanceof GuiMainMenu) {
/*  652 */       this.field_71474_y.field_74330_P = false;
/*  653 */       this.field_71456_v.func_146158_b().func_146231_a();
/*      */     } 
/*      */     
/*  656 */     this.field_71462_r = (GuiScreen)guiGameOver;
/*      */     
/*  658 */     if (guiGameOver != null) {
/*  659 */       func_71364_i();
/*  660 */       ScaledResolution scaledResolution = new ScaledResolution(this, this.field_71443_c, this.field_71440_d);
/*  661 */       int i = scaledResolution.func_78326_a();
/*  662 */       int j = scaledResolution.func_78328_b();
/*  663 */       guiGameOver.func_146280_a(this, i, j);
/*  664 */       this.field_71454_w = false;
/*      */     } else {
/*  666 */       this.field_147127_av.func_147687_e();
/*  667 */       func_71381_h();
/*      */     } 
/*      */   }
/*      */   
/*      */   private void func_71361_d(String p_71361_1_) {
/*  672 */     int i = GL11.glGetError();
/*  673 */     if (i != 0) {
/*  674 */       String str = GLU.gluErrorString(i);
/*  675 */       field_147123_G.error("########## GL ERROR ##########");
/*  676 */       field_147123_G.error("@ " + p_71361_1_);
/*  677 */       field_147123_G.error(i + ": " + str);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_71405_e() {
/*      */     try {
/*  683 */       this.field_152353_at.func_152923_i();
/*      */       
/*  685 */       field_147123_G.info("Stopping!");
/*      */       try {
/*  687 */         func_71403_a(null);
/*  688 */       } catch (Throwable throwable) {}
/*      */ 
/*      */       
/*      */       try {
/*  692 */         GLAllocation.func_74525_a();
/*  693 */       } catch (Throwable throwable) {}
/*      */ 
/*      */       
/*  696 */       this.field_147127_av.func_147685_d();
/*      */     } finally {
/*  698 */       Display.destroy();
/*  699 */       if (!this.field_71434_R) System.exit(0); 
/*      */     } 
/*  701 */     System.gc();
/*      */   }
/*      */   
/*  704 */   public Minecraft(Session p_i1103_1_, int p_i1103_2_, int p_i1103_3_, boolean p_i1103_4_, boolean p_i1103_5_, File p_i1103_6_, File p_i1103_7_, File p_i1103_8_, Proxy p_i1103_9_, String p_i1103_10_, Multimap p_i1103_11_, String p_i1103_12_) { this.field_71425_J = true;
/*  705 */     this.field_71426_K = "";
/*      */     
/*  707 */     this.field_71419_L = func_71386_F();
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
/*  989 */     this.field_71421_N = -1L;
/*      */     
/*  991 */     this.field_71465_an = "root"; field_71432_P = this; this.field_71412_D = p_i1103_6_; this.field_110446_Y = p_i1103_7_; this.field_130070_K = p_i1103_8_; this.field_110447_Z = p_i1103_10_; this.field_152356_J = p_i1103_11_; this.field_110450_ap = new DefaultResourcePack((new ResourceIndex(p_i1103_7_, p_i1103_12_)).func_152782_a()); func_110435_P(); this.field_110453_aa = (p_i1103_9_ == null) ? Proxy.NO_PROXY : p_i1103_9_; this.field_152355_az = (new YggdrasilAuthenticationService(p_i1103_9_, UUID.randomUUID().toString())).createMinecraftSessionService(); func_71389_H(); this.field_71449_j = p_i1103_1_; field_147123_G.info("Setting user: " + p_i1103_1_.func_111285_a()); field_147123_G.info("(Session ID is " + p_i1103_1_.func_111286_b() + ")"); this.field_71459_aj = p_i1103_5_; this.field_71443_c = p_i1103_2_; this.field_71440_d = p_i1103_3_; this.field_71436_X = p_i1103_2_; this.field_71435_Y = p_i1103_3_; this.field_71431_Q = p_i1103_4_; this.field_147129_ai = func_147122_X(); ImageIO.setUseCache(false); Bootstrap.func_151354_b(); }
/*      */   public void func_99999_d() { this.field_71425_J = true; try { func_71384_a(); } catch (Throwable throwable) { CrashReport crashReport = CrashReport.func_85055_a(throwable, "Initializing game"); crashReport.func_85058_a("Initialization"); func_71377_b(func_71396_d(crashReport)); return; }  try { while (this.field_71425_J) { if (this.field_71434_R && this.field_71433_S != null) { func_71377_b(this.field_71433_S); return; }  try { func_71411_J(); } catch (OutOfMemoryError outOfMemoryError) { func_71398_f(); func_147108_a((GuiScreen)new GuiMemoryErrorScreen()); System.gc(); }  }  } catch (MinecraftError minecraftError) {  } catch (ReportedException reportedException) { func_71396_d(reportedException.func_71575_a()); func_71398_f(); field_147123_G.fatal("Reported exception thrown!", (Throwable)reportedException); func_71377_b(reportedException.func_71575_a()); } catch (Throwable throwable) { CrashReport crashReport = func_71396_d(new CrashReport("Unexpected error", throwable)); func_71398_f(); field_147123_G.fatal("Unreported exception thrown!", throwable); func_71377_b(crashReport); } finally { func_71405_e(); }  }
/*      */   private void func_71411_J() { this.field_71424_I.func_76320_a("root"); if (Display.isCreated() && Display.isCloseRequested()) func_71400_g();  if (this.field_71445_n && this.field_71441_e != null) { float f = this.field_71428_T.field_74281_c; this.field_71428_T.func_74275_a(); this.field_71428_T.field_74281_c = f; } else { this.field_71428_T.func_74275_a(); }  if ((this.field_71441_e == null || this.field_71462_r == null) && this.field_71468_ad) { this.field_71468_ad = false; func_110436_a(); }  long l1 = System.nanoTime(); this.field_71424_I.func_76320_a("tick"); for (byte b = 0; b < this.field_71428_T.field_74280_b; b++) func_71407_l();  this.field_71424_I.func_76318_c("preRenderErrors"); long l2 = System.nanoTime() - l1; func_71361_d("Pre render"); RenderBlocks.field_147843_b = this.field_71474_y.field_74347_j; this.field_71424_I.func_76318_c("sound"); this.field_147127_av.func_147691_a((EntityPlayer)this.field_71439_g, this.field_71428_T.field_74281_c); this.field_71424_I.func_76319_b(); this.field_71424_I.func_76320_a("render"); GL11.glPushMatrix(); GL11.glClear(16640); this.field_147124_at.func_147610_a(true); this.field_71424_I.func_76320_a("display"); GL11.glEnable(3553); if (this.field_71439_g != null && this.field_71439_g.func_70094_T()) this.field_71474_y.field_74320_O = 0;  this.field_71424_I.func_76319_b(); if (!this.field_71454_w) { this.field_71424_I.func_76318_c("gameRenderer"); this.field_71460_t.func_78480_b(this.field_71428_T.field_74281_c); this.field_71424_I.func_76319_b(); }  GL11.glFlush(); this.field_71424_I.func_76319_b(); if (!Display.isActive() && this.field_71431_Q) func_71352_k();  if (this.field_71474_y.field_74330_P && this.field_71474_y.field_74329_Q) { if (!this.field_71424_I.field_76327_a) this.field_71424_I.func_76317_a();  this.field_71424_I.field_76327_a = true; func_71366_a(l2); } else { this.field_71424_I.field_76327_a = false; this.field_71421_N = System.nanoTime(); }  this.field_71458_u.func_146254_a(); this.field_147124_at.func_147609_e(); GL11.glPopMatrix(); GL11.glPushMatrix(); this.field_147124_at.func_147615_c(this.field_71443_c, this.field_71440_d); GL11.glPopMatrix(); GL11.glPushMatrix(); this.field_71460_t.func_152430_c(this.field_71428_T.field_74281_c); GL11.glPopMatrix(); this.field_71424_I.func_76320_a("root"); func_147120_f(); Thread.yield(); this.field_71424_I.func_76320_a("stream"); this.field_71424_I.func_76320_a("update"); this.field_152353_at.func_152935_j(); this.field_71424_I.func_76318_c("submit"); this.field_152353_at.func_152922_k(); this.field_71424_I.func_76319_b(); this.field_71424_I.func_76319_b(); func_71361_d("Post render"); this.field_71420_M++; this.field_71445_n = (func_71356_B() && this.field_71462_r != null && this.field_71462_r.func_73868_f() && !this.field_71437_Z.func_71344_c()); while (func_71386_F() >= this.field_71419_L + 1000L) { field_71470_ab = this.field_71420_M; this.field_71426_K = field_71470_ab + " fps, " + WorldRenderer.field_78922_b + " chunk updates"; WorldRenderer.field_78922_b = 0; this.field_71419_L += 1000L; this.field_71420_M = 0; this.field_71427_U.func_76471_b(); if (!this.field_71427_U.func_76468_d()) this.field_71427_U.func_76463_a();  }  this.field_71424_I.func_76319_b(); if (func_147107_h()) Display.sync(func_90020_K());  }
/*  994 */   public void func_147120_f() { Display.update(); if (!this.field_71431_Q && Display.wasResized()) { int i = this.field_71443_c; int j = this.field_71440_d; this.field_71443_c = Display.getWidth(); this.field_71440_d = Display.getHeight(); if (this.field_71443_c != i || this.field_71440_d != j) { if (this.field_71443_c <= 0) this.field_71443_c = 1;  if (this.field_71440_d <= 0) this.field_71440_d = 1;  func_71370_a(this.field_71443_c, this.field_71440_d); }  }  } private void func_71383_b(int p_71383_1_) { List<Profiler.Result> list = this.field_71424_I.func_76321_b(this.field_71465_an);
/*  995 */     if (list == null || list.isEmpty())
/*      */       return; 
/*  997 */     Profiler.Result result = list.remove(0);
/*  998 */     if (p_71383_1_ == 0)
/*  999 */     { if (result.field_76331_c.length() > 0) {
/* 1000 */         int i = this.field_71465_an.lastIndexOf(".");
/* 1001 */         if (i >= 0) this.field_71465_an = this.field_71465_an.substring(0, i); 
/*      */       }  }
/*      */     else
/* 1004 */     { p_71383_1_--;
/* 1005 */       if (p_71383_1_ < list.size() && !((Profiler.Result)list.get(p_71383_1_)).field_76331_c.equals("unspecified"))
/* 1006 */       { if (this.field_71465_an.length() > 0) this.field_71465_an += "."; 
/* 1007 */         this.field_71465_an += ((Profiler.Result)list.get(p_71383_1_)).field_76331_c; }  }  }
/*      */   public int func_90020_K() { if (this.field_71441_e == null && this.field_71462_r != null)
/*      */       return 30;  return this.field_71474_y.field_74350_i; }
/*      */   public boolean func_147107_h() { return (func_90020_K() < GameSettings.Options.FRAMERATE_LIMIT.func_148267_f()); }
/*      */   public void func_71398_f() { try { field_71444_a = new byte[0]; this.field_71438_f.func_72728_f(); } catch (Throwable throwable) {} try { System.gc(); }
/*      */     catch (Throwable throwable) {} try { System.gc(); func_71403_a(null); }
/* 1013 */     catch (Throwable throwable) {} System.gc(); } private void func_71366_a(long p_71366_1_) { if (!this.field_71424_I.field_76327_a)
/* 1014 */       return;  List<Profiler.Result> list = this.field_71424_I.func_76321_b(this.field_71465_an);
/* 1015 */     Profiler.Result result = list.remove(0);
/*      */     
/* 1017 */     GL11.glClear(256);
/* 1018 */     GL11.glMatrixMode(5889);
/* 1019 */     GL11.glEnable(2903);
/* 1020 */     GL11.glLoadIdentity();
/* 1021 */     GL11.glOrtho(0.0D, this.field_71443_c, this.field_71440_d, 0.0D, 1000.0D, 3000.0D);
/* 1022 */     GL11.glMatrixMode(5888);
/* 1023 */     GL11.glLoadIdentity();
/* 1024 */     GL11.glTranslatef(0.0F, 0.0F, -2000.0F);
/*      */     
/* 1026 */     GL11.glLineWidth(1.0F);
/* 1027 */     GL11.glDisable(3553);
/* 1028 */     Tessellator tessellator = Tessellator.field_78398_a;
/*      */     
/* 1030 */     char c = ' ';
/* 1031 */     int i = this.field_71443_c - c - 10;
/* 1032 */     int j = this.field_71440_d - c * 2;
/* 1033 */     GL11.glEnable(3042);
/* 1034 */     tessellator.func_78382_b();
/* 1035 */     tessellator.func_78384_a(0, 200);
/* 1036 */     tessellator.func_78377_a((i - c * 1.1F), (j - c * 0.6F - 16.0F), 0.0D);
/* 1037 */     tessellator.func_78377_a((i - c * 1.1F), (j + c * 2), 0.0D);
/* 1038 */     tessellator.func_78377_a((i + c * 1.1F), (j + c * 2), 0.0D);
/* 1039 */     tessellator.func_78377_a((i + c * 1.1F), (j - c * 0.6F - 16.0F), 0.0D);
/* 1040 */     tessellator.func_78381_a();
/* 1041 */     GL11.glDisable(3042);
/*      */     
/* 1043 */     double d = 0.0D;
/* 1044 */     for (byte b1 = 0; b1 < list.size(); b1++) {
/* 1045 */       Profiler.Result result1 = list.get(b1);
/*      */       
/* 1047 */       int m = MathHelper.func_76128_c(result1.field_76332_a / 4.0D) + 1;
/*      */       
/* 1049 */       tessellator.func_78371_b(6);
/* 1050 */       tessellator.func_78378_d(result1.func_76329_a());
/* 1051 */       tessellator.func_78377_a(i, j, 0.0D); int n;
/* 1052 */       for (n = m; n >= 0; n--) {
/* 1053 */         float f1 = (float)((d + result1.field_76332_a * n / m) * 3.1415927410125732D * 2.0D / 100.0D);
/* 1054 */         float f2 = MathHelper.func_76126_a(f1) * c;
/* 1055 */         float f3 = MathHelper.func_76134_b(f1) * c * 0.5F;
/* 1056 */         tessellator.func_78377_a((i + f2), (j - f3), 0.0D);
/*      */       } 
/* 1058 */       tessellator.func_78381_a();
/* 1059 */       tessellator.func_78371_b(5);
/* 1060 */       tessellator.func_78378_d((result1.func_76329_a() & 0xFEFEFE) >> 1);
/* 1061 */       for (n = m; n >= 0; n--) {
/* 1062 */         float f1 = (float)((d + result1.field_76332_a * n / m) * 3.1415927410125732D * 2.0D / 100.0D);
/* 1063 */         float f2 = MathHelper.func_76126_a(f1) * c;
/* 1064 */         float f3 = MathHelper.func_76134_b(f1) * c * 0.5F;
/* 1065 */         tessellator.func_78377_a((i + f2), (j - f3), 0.0D);
/* 1066 */         tessellator.func_78377_a((i + f2), (j - f3 + 10.0F), 0.0D);
/*      */       } 
/* 1068 */       tessellator.func_78381_a();
/*      */       
/* 1070 */       d += result1.field_76332_a;
/*      */     } 
/* 1072 */     DecimalFormat decimalFormat = new DecimalFormat("##0.00");
/*      */     
/* 1074 */     GL11.glEnable(3553);
/*      */ 
/*      */     
/* 1077 */     String str = "";
/* 1078 */     if (!result.field_76331_c.equals("unspecified")) {
/* 1079 */       str = str + "[0] ";
/*      */     }
/* 1081 */     if (result.field_76331_c.length() == 0) {
/* 1082 */       str = str + "ROOT ";
/*      */     } else {
/* 1084 */       str = str + result.field_76331_c + " ";
/*      */     } 
/* 1086 */     int k = 16777215;
/* 1087 */     this.field_71466_p.func_78261_a(str, i - c, j - c / 2 - 16, k);
/* 1088 */     this.field_71466_p.func_78261_a(str = decimalFormat.format(result.field_76330_b) + "%", i + c - this.field_71466_p.func_78256_a(str), j - c / 2 - 16, k);
/*      */ 
/*      */     
/* 1091 */     for (byte b2 = 0; b2 < list.size(); b2++) {
/* 1092 */       Profiler.Result result1 = list.get(b2);
/* 1093 */       String str1 = "";
/* 1094 */       if (result1.field_76331_c.equals("unspecified")) {
/* 1095 */         str1 = str1 + "[?] ";
/*      */       } else {
/* 1097 */         str1 = str1 + "[" + (b2 + 1) + "] ";
/*      */       } 
/*      */       
/* 1100 */       str1 = str1 + result1.field_76331_c;
/* 1101 */       this.field_71466_p.func_78261_a(str1, i - c, j + c / 2 + b2 * 8 + 20, result1.func_76329_a());
/* 1102 */       this.field_71466_p.func_78261_a(str1 = decimalFormat.format(result1.field_76332_a) + "%", i + c - 50 - this.field_71466_p.func_78256_a(str1), j + c / 2 + b2 * 8 + 20, result1.func_76329_a());
/* 1103 */       this.field_71466_p.func_78261_a(str1 = decimalFormat.format(result1.field_76330_b) + "%", i + c - this.field_71466_p.func_78256_a(str1), j + c / 2 + b2 * 8 + 20, result1.func_76329_a());
/*      */     }  }
/*      */ 
/*      */   
/*      */   public void func_71400_g() {
/* 1108 */     this.field_71425_J = false;
/*      */   }
/*      */   
/*      */   public void func_71381_h() {
/* 1112 */     if (!Display.isActive())
/* 1113 */       return;  if (this.field_71415_G)
/* 1114 */       return;  this.field_71415_G = true;
/* 1115 */     this.field_71417_B.func_74372_a();
/* 1116 */     func_147108_a(null);
/* 1117 */     this.field_71429_W = 10000;
/*      */   }
/*      */   
/*      */   public void func_71364_i() {
/* 1121 */     if (!this.field_71415_G)
/* 1122 */       return;  KeyBinding.func_74506_a();
/* 1123 */     this.field_71415_G = false;
/* 1124 */     this.field_71417_B.func_74373_b();
/*      */   }
/*      */   
/*      */   public void func_71385_j() {
/* 1128 */     if (this.field_71462_r != null)
/*      */       return; 
/* 1130 */     func_147108_a((GuiScreen)new GuiIngameMenu());
/* 1131 */     if (func_71356_B() && !this.field_71437_Z.func_71344_c()) {
/* 1132 */       this.field_147127_av.func_147689_b();
/*      */     }
/*      */   }
/*      */   
/*      */   private void func_147115_a(boolean p_147115_1_) {
/* 1137 */     if (!p_147115_1_) this.field_71429_W = 0; 
/* 1138 */     if (this.field_71429_W > 0)
/*      */       return; 
/* 1140 */     if (p_147115_1_ && this.field_71476_x != null && this.field_71476_x.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
/* 1141 */       int i = this.field_71476_x.field_72311_b;
/* 1142 */       int j = this.field_71476_x.field_72312_c;
/* 1143 */       int k = this.field_71476_x.field_72309_d;
/*      */       
/* 1145 */       if (this.field_71441_e.func_147439_a(i, j, k).func_149688_o() != Material.field_151579_a) {
/* 1146 */         this.field_71442_b.func_78759_c(i, j, k, this.field_71476_x.field_72310_e);
/* 1147 */         if (this.field_71439_g.func_82246_f(i, j, k)) {
/* 1148 */           this.field_71452_i.func_78867_a(i, j, k, this.field_71476_x.field_72310_e);
/* 1149 */           this.field_71439_g.func_71038_i();
/*      */         } 
/*      */       } 
/*      */       
/*      */       return;
/*      */     } 
/* 1155 */     this.field_71442_b.func_78767_c();
/*      */   }
/*      */   private void func_147116_af() {
/*      */     int i, j, k;
/* 1159 */     if (this.field_71429_W > 0)
/* 1160 */       return;  this.field_71439_g.func_71038_i();
/*      */     
/* 1162 */     if (this.field_71476_x == null) {
/* 1163 */       field_147123_G.error("Null returned as 'hitResult', this shouldn't happen!");
/* 1164 */       if (this.field_71442_b.func_78762_g()) {
/* 1165 */         this.field_71429_W = 10;
/*      */       }
/*      */       
/*      */       return;
/*      */     } 
/* 1170 */     switch (SwitchMovingObjectType.field_152390_a[this.field_71476_x.field_72313_a.ordinal()]) {
/*      */       case 1:
/* 1172 */         this.field_71442_b.func_78764_a((EntityPlayer)this.field_71439_g, this.field_71476_x.field_72308_g);
/*      */         break;
/*      */       case 2:
/* 1175 */         i = this.field_71476_x.field_72311_b;
/* 1176 */         j = this.field_71476_x.field_72312_c;
/* 1177 */         k = this.field_71476_x.field_72309_d;
/*      */         
/* 1179 */         if (this.field_71441_e.func_147439_a(i, j, k).func_149688_o() == Material.field_151579_a) {
/* 1180 */           if (this.field_71442_b.func_78762_g())
/* 1181 */             this.field_71429_W = 10; 
/*      */           break;
/*      */         } 
/* 1184 */         this.field_71442_b.func_78743_b(i, j, k, this.field_71476_x.field_72310_e);
/*      */         break;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void func_147121_ag() {
/* 1191 */     this.field_71467_ac = 4;
/* 1192 */     boolean bool = true;
/*      */     
/* 1194 */     ItemStack itemStack = this.field_71439_g.field_71071_by.func_70448_g();
/* 1195 */     if (this.field_71476_x == null) {
/* 1196 */       field_147123_G.warn("Null returned as 'hitResult', this shouldn't happen!");
/*      */     } else {
/* 1198 */       int i; int j; int k; switch (SwitchMovingObjectType.field_152390_a[this.field_71476_x.field_72313_a.ordinal()]) {
/*      */         case 1:
/* 1200 */           if (this.field_71442_b.func_78768_b((EntityPlayer)this.field_71439_g, this.field_71476_x.field_72308_g)) {
/* 1201 */             bool = false;
/*      */           }
/*      */           break;
/*      */         case 2:
/* 1205 */           i = this.field_71476_x.field_72311_b;
/* 1206 */           j = this.field_71476_x.field_72312_c;
/* 1207 */           k = this.field_71476_x.field_72309_d;
/*      */           
/* 1209 */           if (this.field_71441_e.func_147439_a(i, j, k).func_149688_o() != Material.field_151579_a) {
/* 1210 */             boolean bool1 = (itemStack != null) ? itemStack.field_77994_a : false;
/* 1211 */             if (this.field_71442_b.func_78760_a((EntityPlayer)this.field_71439_g, (World)this.field_71441_e, itemStack, i, j, k, this.field_71476_x.field_72310_e, this.field_71476_x.field_72307_f)) {
/* 1212 */               bool = false;
/* 1213 */               this.field_71439_g.func_71038_i();
/*      */             } 
/* 1215 */             if (itemStack == null) {
/*      */               return;
/*      */             }
/*      */             
/* 1219 */             if (itemStack.field_77994_a == 0) {
/* 1220 */               this.field_71439_g.field_71071_by.field_70462_a[this.field_71439_g.field_71071_by.field_70461_c] = null; break;
/* 1221 */             }  if (itemStack.field_77994_a != bool1 || this.field_71442_b.func_78758_h()) {
/* 1222 */               this.field_71460_t.field_78516_c.func_78444_b();
/*      */             }
/*      */           } 
/*      */           break;
/*      */       } 
/*      */     
/*      */     } 
/* 1229 */     if (bool) {
/* 1230 */       ItemStack itemStack1 = this.field_71439_g.field_71071_by.func_70448_g();
/* 1231 */       if (itemStack1 != null && 
/* 1232 */         this.field_71442_b.func_78769_a((EntityPlayer)this.field_71439_g, (World)this.field_71441_e, itemStack1)) {
/* 1233 */         this.field_71460_t.field_78516_c.func_78445_c();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_71352_k() {
/*      */     try {
/* 1241 */       this.field_71431_Q = !this.field_71431_Q;
/* 1242 */       if (this.field_71431_Q) {
/* 1243 */         func_110441_Q();
/* 1244 */         this.field_71443_c = Display.getDisplayMode().getWidth();
/* 1245 */         this.field_71440_d = Display.getDisplayMode().getHeight();
/* 1246 */         if (this.field_71443_c <= 0) this.field_71443_c = 1; 
/* 1247 */         if (this.field_71440_d <= 0) this.field_71440_d = 1; 
/*      */       } else {
/* 1249 */         Display.setDisplayMode(new DisplayMode(this.field_71436_X, this.field_71435_Y));
/* 1250 */         this.field_71443_c = this.field_71436_X;
/* 1251 */         this.field_71440_d = this.field_71435_Y;
/* 1252 */         if (this.field_71443_c <= 0) this.field_71443_c = 1; 
/* 1253 */         if (this.field_71440_d <= 0) this.field_71440_d = 1; 
/*      */       } 
/* 1255 */       if (this.field_71462_r != null) {
/* 1256 */         func_71370_a(this.field_71443_c, this.field_71440_d);
/*      */       } else {
/* 1258 */         func_147119_ah();
/*      */       } 
/* 1260 */       Display.setFullscreen(this.field_71431_Q);
/* 1261 */       Display.setVSyncEnabled(this.field_71474_y.field_74352_v);
/* 1262 */       func_147120_f();
/* 1263 */     } catch (Exception exception) {
/* 1264 */       field_147123_G.error("Couldn't toggle fullscreen", exception);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void func_71370_a(int p_71370_1_, int p_71370_2_) {
/* 1269 */     this.field_71443_c = (p_71370_1_ <= 0) ? 1 : p_71370_1_;
/* 1270 */     this.field_71440_d = (p_71370_2_ <= 0) ? 1 : p_71370_2_;
/*      */     
/* 1272 */     if (this.field_71462_r != null) {
/* 1273 */       ScaledResolution scaledResolution = new ScaledResolution(this, p_71370_1_, p_71370_2_);
/* 1274 */       int i = scaledResolution.func_78326_a();
/* 1275 */       int j = scaledResolution.func_78328_b();
/* 1276 */       this.field_71462_r.func_146280_a(this, i, j);
/*      */     } 
/* 1278 */     this.field_71461_s = new LoadingScreenRenderer(this);
/* 1279 */     func_147119_ah();
/*      */   }
/*      */   
/*      */   private void func_147119_ah() {
/* 1283 */     this.field_147124_at.func_147613_a(this.field_71443_c, this.field_71440_d);
/* 1284 */     if (this.field_71460_t != null) {
/* 1285 */       this.field_71460_t.func_147704_a(this.field_71443_c, this.field_71440_d);
/*      */     }
/*      */   }
/*      */   
/*      */   public void func_71407_l() {
/* 1290 */     this.field_71424_I.func_76320_a("scheduledExecutables");
/* 1291 */     synchronized (this.field_152351_aB) {
/* 1292 */       while (!this.field_152351_aB.isEmpty()) {
/* 1293 */         ((FutureTask)this.field_152351_aB.poll()).run();
/*      */       }
/*      */     } 
/* 1296 */     this.field_71424_I.func_76319_b();
/*      */     
/* 1298 */     if (this.field_71467_ac > 0) this.field_71467_ac--;
/*      */     
/* 1300 */     this.field_71424_I.func_76320_a("gui");
/* 1301 */     if (!this.field_71445_n) this.field_71456_v.func_73831_a(); 
/* 1302 */     this.field_71424_I.func_76318_c("pick");
/* 1303 */     this.field_71460_t.func_78473_a(1.0F);
/*      */     
/* 1305 */     this.field_71424_I.func_76318_c("gameMode");
/* 1306 */     if (!this.field_71445_n && this.field_71441_e != null) this.field_71442_b.func_78765_e(); 
/* 1307 */     this.field_71424_I.func_76318_c("textures");
/* 1308 */     if (!this.field_71445_n) {
/* 1309 */       this.field_71446_o.func_110550_d();
/*      */     }
/*      */     
/* 1312 */     if (this.field_71462_r == null && this.field_71439_g != null) {
/* 1313 */       if (this.field_71439_g.func_110143_aJ() <= 0.0F) {
/* 1314 */         func_147108_a(null);
/* 1315 */       } else if (this.field_71439_g.func_70608_bn() && this.field_71441_e != null) {
/* 1316 */         func_147108_a((GuiScreen)new GuiSleepMP());
/*      */       } 
/* 1318 */     } else if (this.field_71462_r != null && this.field_71462_r instanceof GuiSleepMP && !this.field_71439_g.func_70608_bn()) {
/* 1319 */       func_147108_a(null);
/*      */     } 
/*      */     
/* 1322 */     if (this.field_71462_r != null) {
/* 1323 */       this.field_71429_W = 10000;
/*      */     }
/*      */     
/* 1326 */     if (this.field_71462_r != null) {
/*      */       try {
/* 1328 */         this.field_71462_r.func_146269_k();
/* 1329 */       } catch (Throwable throwable) {
/* 1330 */         CrashReport crashReport = CrashReport.func_85055_a(throwable, "Updating screen events");
/* 1331 */         CrashReportCategory crashReportCategory = crashReport.func_85058_a("Affected screen");
/* 1332 */         crashReportCategory.func_71500_a("Screen name", new Callable(this) { private static final String __OBFID = "CL_00000640";
/*      */               
/*      */               public String call() {
/* 1335 */                 return this.field_90055_a.field_71462_r.getClass().getCanonicalName();
/*      */               } }
/*      */           );
/* 1338 */         throw new ReportedException(crashReport);
/*      */       } 
/*      */       
/* 1341 */       if (this.field_71462_r != null) {
/*      */         try {
/* 1343 */           this.field_71462_r.func_73876_c();
/* 1344 */         } catch (Throwable throwable) {
/* 1345 */           CrashReport crashReport = CrashReport.func_85055_a(throwable, "Ticking screen");
/* 1346 */           CrashReportCategory crashReportCategory = crashReport.func_85058_a("Affected screen");
/* 1347 */           crashReportCategory.func_71500_a("Screen name", new Callable(this) { private static final String __OBFID = "CL_00000642";
/*      */                 
/*      */                 public String call() {
/* 1350 */                   return this.field_90053_a.field_71462_r.getClass().getCanonicalName();
/*      */                 } }
/*      */             );
/* 1353 */           throw new ReportedException(crashReport);
/*      */         } 
/*      */       }
/*      */     } 
/*      */     
/* 1358 */     if (this.field_71462_r == null || this.field_71462_r.field_146291_p) {
/* 1359 */       this.field_71424_I.func_76318_c("mouse");
/*      */       
/* 1361 */       while (Mouse.next()) {
/* 1362 */         int i = Mouse.getEventButton();
/*      */         
/* 1364 */         KeyBinding.func_74510_a(i - 100, Mouse.getEventButtonState());
/* 1365 */         if (Mouse.getEventButtonState()) {
/* 1366 */           KeyBinding.func_74507_a(i - 100);
/*      */         }
/*      */         
/* 1369 */         long l = func_71386_F() - this.field_71423_H;
/* 1370 */         if (l > 200L)
/*      */           continue; 
/* 1372 */         int j = Mouse.getEventDWheel();
/* 1373 */         if (j != 0) {
/* 1374 */           this.field_71439_g.field_71071_by.func_70453_c(j);
/*      */           
/* 1376 */           if (this.field_71474_y.field_74331_S) {
/* 1377 */             if (j > 0) j = 1; 
/* 1378 */             if (j < 0) j = -1;
/*      */             
/* 1380 */             this.field_71474_y.field_74328_V += j * 0.25F;
/*      */           } 
/*      */         } 
/*      */         
/* 1384 */         if (this.field_71462_r == null) {
/* 1385 */           if (!this.field_71415_G && Mouse.getEventButtonState())
/* 1386 */             func_71381_h();  continue;
/*      */         } 
/* 1388 */         if (this.field_71462_r != null) {
/* 1389 */           this.field_71462_r.func_146274_d();
/*      */         }
/*      */       } 
/*      */       
/* 1393 */       if (this.field_71429_W > 0) this.field_71429_W--;
/*      */       
/* 1395 */       this.field_71424_I.func_76318_c("keyboard");
/* 1396 */       while (Keyboard.next()) {
/* 1397 */         KeyBinding.func_74510_a(Keyboard.getEventKey(), Keyboard.getEventKeyState());
/*      */         
/* 1399 */         if (Keyboard.getEventKeyState()) {
/* 1400 */           KeyBinding.func_74507_a(Keyboard.getEventKey());
/*      */         }
/*      */         
/* 1403 */         if (this.field_83002_am > 0L) {
/* 1404 */           if (func_71386_F() - this.field_83002_am >= 6000L) {
/* 1405 */             throw new ReportedException(new CrashReport("Manually triggered debug crash", new Throwable()));
/*      */           }
/*      */           
/* 1408 */           if (!Keyboard.isKeyDown(46) || !Keyboard.isKeyDown(61)) {
/* 1409 */             this.field_83002_am = -1L;
/*      */           }
/* 1411 */         } else if (Keyboard.isKeyDown(46) && Keyboard.isKeyDown(61)) {
/* 1412 */           this.field_83002_am = func_71386_F();
/*      */         } 
/*      */         
/* 1415 */         func_152348_aa();
/*      */         
/* 1417 */         if (Keyboard.getEventKeyState()) {
/* 1418 */           if (Keyboard.getEventKey() == 62 && 
/* 1419 */             this.field_71460_t != null) {
/* 1420 */             this.field_71460_t.func_147703_b();
/*      */           }
/*      */ 
/*      */           
/* 1424 */           if (this.field_71462_r != null) {
/* 1425 */             this.field_71462_r.func_146282_l();
/*      */           } else {
/* 1427 */             if (Keyboard.getEventKey() == 1) {
/* 1428 */               func_71385_j();
/*      */             }
/*      */             
/* 1431 */             if (Keyboard.getEventKey() == 31 && Keyboard.isKeyDown(61)) {
/* 1432 */               func_110436_a();
/*      */             }
/* 1434 */             if (Keyboard.getEventKey() == 20 && Keyboard.isKeyDown(61)) {
/* 1435 */               func_110436_a();
/*      */             }
/* 1437 */             if (Keyboard.getEventKey() == 33 && Keyboard.isKeyDown(61)) {
/* 1438 */               int i = Keyboard.isKeyDown(42) | Keyboard.isKeyDown(54);
/* 1439 */               this.field_71474_y.func_74306_a(GameSettings.Options.RENDER_DISTANCE, (i != 0) ? -1 : 1);
/*      */             } 
/* 1441 */             if (Keyboard.getEventKey() == 30 && Keyboard.isKeyDown(61)) {
/* 1442 */               this.field_71438_f.func_72712_a();
/*      */             }
/* 1444 */             if (Keyboard.getEventKey() == 35 && Keyboard.isKeyDown(61)) {
/* 1445 */               this.field_71474_y.field_82882_x = !this.field_71474_y.field_82882_x;
/* 1446 */               this.field_71474_y.func_74303_b();
/*      */             } 
/* 1448 */             if (Keyboard.getEventKey() == 48 && Keyboard.isKeyDown(61)) {
/* 1449 */               RenderManager.field_85095_o = !RenderManager.field_85095_o;
/*      */             }
/* 1451 */             if (Keyboard.getEventKey() == 25 && Keyboard.isKeyDown(61)) {
/* 1452 */               this.field_71474_y.field_82881_y = !this.field_71474_y.field_82881_y;
/* 1453 */               this.field_71474_y.func_74303_b();
/*      */             } 
/* 1455 */             if (Keyboard.getEventKey() == 59) {
/* 1456 */               this.field_71474_y.field_74319_N = !this.field_71474_y.field_74319_N;
/*      */             }
/* 1458 */             if (Keyboard.getEventKey() == 61) {
/* 1459 */               this.field_71474_y.field_74330_P = !this.field_71474_y.field_74330_P;
/* 1460 */               this.field_71474_y.field_74329_Q = GuiScreen.func_146272_n();
/*      */             } 
/* 1462 */             if (this.field_71474_y.field_151457_aa.func_151468_f()) {
/* 1463 */               this.field_71474_y.field_74320_O++;
/* 1464 */               if (this.field_71474_y.field_74320_O > 2) {
/* 1465 */                 this.field_71474_y.field_74320_O = 0;
/*      */               }
/*      */             } 
/* 1468 */             if (this.field_71474_y.field_151458_ab.func_151468_f()) {
/* 1469 */               this.field_71474_y.field_74326_T = !this.field_71474_y.field_74326_T;
/*      */             }
/*      */           } 
/*      */           
/* 1473 */           if (this.field_71474_y.field_74330_P && this.field_71474_y.field_74329_Q) {
/* 1474 */             if (Keyboard.getEventKey() == 11) {
/* 1475 */               func_71383_b(0);
/*      */             }
/* 1477 */             for (byte b1 = 0; b1 < 9; b1++) {
/* 1478 */               if (Keyboard.getEventKey() == 2 + b1) {
/* 1479 */                 func_71383_b(b1 + 1);
/*      */               }
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       byte b;
/* 1486 */       for (b = 0; b < 9; b++) {
/* 1487 */         if (this.field_71474_y.field_151456_ac[b].func_151468_f()) this.field_71439_g.field_71071_by.field_70461_c = b;
/*      */       
/*      */       } 
/* 1490 */       b = (this.field_71474_y.field_74343_n != EntityPlayer.EnumChatVisibility.HIDDEN) ? 1 : 0;
/*      */       
/* 1492 */       while (this.field_71474_y.field_151445_Q.func_151468_f()) {
/* 1493 */         if (this.field_71442_b.func_110738_j()) {
/* 1494 */           this.field_71439_g.func_110322_i(); continue;
/*      */         } 
/* 1496 */         func_147114_u().func_147297_a((Packet)new C16PacketClientStatus(C16PacketClientStatus.EnumState.OPEN_INVENTORY_ACHIEVEMENT));
/* 1497 */         func_147108_a((GuiScreen)new GuiInventory((EntityPlayer)this.field_71439_g));
/*      */       } 
/*      */       
/* 1500 */       while (this.field_71474_y.field_74316_C.func_151468_f())
/* 1501 */         this.field_71439_g.func_71040_bB(GuiScreen.func_146271_m()); 
/* 1502 */       while (this.field_71474_y.field_74310_D.func_151468_f() && b != 0)
/* 1503 */         func_147108_a((GuiScreen)new GuiChat()); 
/* 1504 */       if (this.field_71462_r == null && this.field_71474_y.field_74323_J.func_151468_f() && b != 0) func_147108_a((GuiScreen)new GuiChat("/"));
/*      */       
/* 1506 */       if (this.field_71439_g.func_71039_bw()) {
/* 1507 */         if (!this.field_71474_y.field_74313_G.func_151470_d()) {
/* 1508 */           this.field_71442_b.func_78766_c((EntityPlayer)this.field_71439_g);
/*      */         }
/*      */         
/* 1511 */         while (this.field_71474_y.field_74312_F.func_151468_f());
/*      */         
/* 1513 */         while (this.field_71474_y.field_74313_G.func_151468_f());
/*      */         
/* 1515 */         while (this.field_71474_y.field_74322_I.func_151468_f());
/*      */       } else {
/*      */         
/* 1518 */         while (this.field_71474_y.field_74312_F.func_151468_f()) {
/* 1519 */           func_147116_af();
/*      */         }
/* 1521 */         while (this.field_71474_y.field_74313_G.func_151468_f()) {
/* 1522 */           func_147121_ag();
/*      */         }
/* 1524 */         while (this.field_71474_y.field_74322_I.func_151468_f()) {
/* 1525 */           func_147112_ai();
/*      */         }
/*      */       } 
/*      */       
/* 1529 */       if (this.field_71474_y.field_74313_G.func_151470_d() && this.field_71467_ac == 0 && !this.field_71439_g.func_71039_bw()) {
/* 1530 */         func_147121_ag();
/*      */       }
/*      */       
/* 1533 */       func_147115_a((this.field_71462_r == null && this.field_71474_y.field_74312_F.func_151470_d() && this.field_71415_G));
/*      */     } 
/*      */     
/* 1536 */     if (this.field_71441_e != null) {
/* 1537 */       if (this.field_71439_g != null) {
/* 1538 */         this.field_71457_ai++;
/* 1539 */         if (this.field_71457_ai == 30) {
/* 1540 */           this.field_71457_ai = 0;
/* 1541 */           this.field_71441_e.func_72897_h((Entity)this.field_71439_g);
/*      */         } 
/*      */       } 
/*      */       
/* 1545 */       this.field_71424_I.func_76318_c("gameRenderer");
/* 1546 */       if (!this.field_71445_n) this.field_71460_t.func_78464_a(); 
/* 1547 */       this.field_71424_I.func_76318_c("levelRenderer");
/* 1548 */       if (!this.field_71445_n) this.field_71438_f.func_72734_e(); 
/* 1549 */       this.field_71424_I.func_76318_c("level");
/* 1550 */       if (!this.field_71445_n) {
/* 1551 */         if (this.field_71441_e.field_73016_r > 0) this.field_71441_e.field_73016_r--; 
/* 1552 */         this.field_71441_e.func_72939_s();
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/* 1557 */     if (!this.field_71445_n) {
/* 1558 */       this.field_147126_aw.func_73660_a();
/* 1559 */       this.field_147127_av.func_73660_a();
/*      */     } 
/*      */     
/* 1562 */     if (this.field_71441_e != null) {
/* 1563 */       if (!this.field_71445_n) {
/* 1564 */         this.field_71441_e.func_72891_a((this.field_71441_e.field_73013_u != EnumDifficulty.PEACEFUL), true);
/*      */         
/*      */         try {
/* 1567 */           this.field_71441_e.func_72835_b();
/* 1568 */         } catch (Throwable throwable) {
/* 1569 */           CrashReport crashReport = CrashReport.func_85055_a(throwable, "Exception in world tick");
/* 1570 */           if (this.field_71441_e == null) {
/* 1571 */             CrashReportCategory crashReportCategory = crashReport.func_85058_a("Affected level");
/* 1572 */             crashReportCategory.func_71507_a("Problem", "Level is null!");
/*      */           } else {
/* 1574 */             this.field_71441_e.func_72914_a(crashReport);
/*      */           } 
/* 1576 */           throw new ReportedException(crashReport);
/*      */         } 
/*      */       } 
/* 1579 */       this.field_71424_I.func_76318_c("animateTick");
/* 1580 */       if (!this.field_71445_n && this.field_71441_e != null) this.field_71441_e.func_73029_E(MathHelper.func_76128_c(this.field_71439_g.field_70165_t), MathHelper.func_76128_c(this.field_71439_g.field_70163_u), MathHelper.func_76128_c(this.field_71439_g.field_70161_v)); 
/* 1581 */       this.field_71424_I.func_76318_c("particles");
/* 1582 */       if (!this.field_71445_n) this.field_71452_i.func_78868_a(); 
/* 1583 */     } else if (this.field_71453_ak != null) {
/* 1584 */       this.field_71424_I.func_76318_c("pendingConnection");
/* 1585 */       this.field_71453_ak.func_74428_b();
/*      */     } 
/*      */     
/* 1588 */     this.field_71424_I.func_76319_b();
/*      */     
/* 1590 */     this.field_71423_H = func_71386_F();
/*      */   }
/*      */   
/*      */   public void func_71371_a(String p_71371_1_, String p_71371_2_, WorldSettings p_71371_3_) {
/* 1594 */     func_71403_a(null);
/* 1595 */     System.gc();
/*      */     
/* 1597 */     ISaveHandler iSaveHandler = this.field_71469_aa.func_75804_a(p_71371_1_, false);
/* 1598 */     WorldInfo worldInfo = iSaveHandler.func_75757_d();
/*      */     
/* 1600 */     if (worldInfo == null && p_71371_3_ != null) {
/* 1601 */       worldInfo = new WorldInfo(p_71371_3_, p_71371_1_);
/* 1602 */       iSaveHandler.func_75761_a(worldInfo);
/*      */     } 
/*      */     
/* 1605 */     if (p_71371_3_ == null) {
/* 1606 */       p_71371_3_ = new WorldSettings(worldInfo);
/*      */     }
/*      */     
/*      */     try {
/* 1610 */       this.field_71437_Z = new IntegratedServer(this, p_71371_1_, p_71371_2_, p_71371_3_);
/* 1611 */       this.field_71437_Z.func_71256_s();
/* 1612 */       this.field_71455_al = true;
/* 1613 */     } catch (Throwable throwable) {
/* 1614 */       CrashReport crashReport = CrashReport.func_85055_a(throwable, "Starting integrated server");
/* 1615 */       CrashReportCategory crashReportCategory = crashReport.func_85058_a("Starting integrated server");
/*      */       
/* 1617 */       crashReportCategory.func_71507_a("Level ID", p_71371_1_);
/* 1618 */       crashReportCategory.func_71507_a("Level Name", p_71371_2_);
/*      */       
/* 1620 */       throw new ReportedException(crashReport);
/*      */     } 
/*      */     
/* 1623 */     this.field_71461_s.func_73720_a(I18n.func_135052_a("menu.loadingLevel", new Object[0]));
/* 1624 */     while (!this.field_71437_Z.func_71200_ad()) {
/* 1625 */       String str = this.field_71437_Z.func_71195_b_();
/* 1626 */       if (str != null) {
/* 1627 */         this.field_71461_s.func_73719_c(I18n.func_135052_a(str, new Object[0]));
/*      */       } else {
/* 1629 */         this.field_71461_s.func_73719_c("");
/*      */       } 
/*      */       try {
/* 1632 */         Thread.sleep(200L);
/* 1633 */       } catch (InterruptedException interruptedException) {}
/*      */     } 
/*      */     
/* 1636 */     func_147108_a(null);
/*      */     
/* 1638 */     SocketAddress socketAddress = this.field_71437_Z.func_147137_ag().func_151270_a();
/* 1639 */     NetworkManager networkManager = NetworkManager.func_150722_a(socketAddress);
/* 1640 */     networkManager.func_150719_a((INetHandler)new NetHandlerLoginClient(networkManager, this, null));
/* 1641 */     networkManager.func_150725_a((Packet)new C00Handshake(5, socketAddress.toString(), 0, EnumConnectionState.LOGIN), new io.netty.util.concurrent.GenericFutureListener[0]);
/* 1642 */     networkManager.func_150725_a((Packet)new C00PacketLoginStart(func_110432_I().func_148256_e()), new io.netty.util.concurrent.GenericFutureListener[0]);
/* 1643 */     this.field_71453_ak = networkManager;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_71403_a(WorldClient p_71403_1_) {
/* 1652 */     func_71353_a(p_71403_1_, "");
/*      */   }
/*      */   
/*      */   public void func_71353_a(WorldClient p_71353_1_, String p_71353_2_) {
/* 1656 */     if (p_71353_1_ == null) {
/*      */       
/* 1658 */       NetHandlerPlayClient netHandlerPlayClient = func_147114_u();
/* 1659 */       if (netHandlerPlayClient != null) {
/* 1660 */         netHandlerPlayClient.func_147296_c();
/*      */       }
/*      */       
/* 1663 */       if (this.field_71437_Z != null) {
/* 1664 */         this.field_71437_Z.func_71263_m();
/*      */       }
/* 1666 */       this.field_71437_Z = null;
/* 1667 */       this.field_71458_u.func_146257_b();
/*      */       
/* 1669 */       this.field_71460_t.func_147701_i().func_148249_a();
/*      */     } 
/*      */     
/* 1672 */     this.field_71451_h = null;
/* 1673 */     this.field_71453_ak = null;
/*      */     
/* 1675 */     if (this.field_71461_s != null) {
/* 1676 */       this.field_71461_s.func_73721_b(p_71353_2_);
/* 1677 */       this.field_71461_s.func_73719_c("");
/*      */     } 
/*      */     
/* 1680 */     if (p_71353_1_ == null && this.field_71441_e != null) {
/* 1681 */       if (this.field_110448_aq.func_148530_e() != null) {
/* 1682 */         func_147106_B();
/*      */       }
/* 1684 */       this.field_110448_aq.func_148529_f();
/* 1685 */       func_71351_a(null);
/* 1686 */       this.field_71455_al = false;
/*      */     } 
/*      */     
/* 1689 */     this.field_147127_av.func_147690_c();
/*      */     
/* 1691 */     this.field_71441_e = p_71353_1_;
/*      */     
/* 1693 */     if (p_71353_1_ != null) {
/* 1694 */       if (this.field_71438_f != null) this.field_71438_f.func_72732_a(p_71353_1_); 
/* 1695 */       if (this.field_71452_i != null) this.field_71452_i.func_78870_a((World)p_71353_1_);
/*      */       
/* 1697 */       if (this.field_71439_g == null) {
/* 1698 */         this.field_71439_g = this.field_71442_b.func_147493_a((World)p_71353_1_, new StatFileWriter());
/* 1699 */         this.field_71442_b.func_78745_b((EntityPlayer)this.field_71439_g);
/*      */       } 
/*      */       
/* 1702 */       this.field_71439_g.func_70065_x();
/* 1703 */       p_71353_1_.func_72838_d((Entity)this.field_71439_g);
/*      */       
/* 1705 */       this.field_71439_g.field_71158_b = (MovementInput)new MovementInputFromOptions(this.field_71474_y);
/*      */       
/* 1707 */       this.field_71442_b.func_78748_a((EntityPlayer)this.field_71439_g);
/* 1708 */       this.field_71451_h = (EntityLivingBase)this.field_71439_g;
/*      */     } else {
/* 1710 */       this.field_71469_aa.func_75800_d();
/* 1711 */       this.field_71439_g = null;
/*      */     } 
/*      */     
/* 1714 */     System.gc();
/* 1715 */     this.field_71423_H = 0L;
/*      */   }
/*      */   
/*      */   public String func_71393_m() {
/* 1719 */     return this.field_71438_f.func_72735_c();
/*      */   }
/*      */   
/*      */   public String func_71408_n() {
/* 1723 */     return this.field_71438_f.func_72723_d();
/*      */   }
/*      */   
/*      */   public String func_71388_o() {
/* 1727 */     return this.field_71441_e.func_72827_u();
/*      */   }
/*      */   
/*      */   public String func_71374_p() {
/* 1731 */     return "P: " + this.field_71452_i.func_78869_b() + ". T: " + this.field_71441_e.func_72981_t();
/*      */   }
/*      */   
/*      */   public void func_71354_a(int p_71354_1_) {
/* 1735 */     this.field_71441_e.func_72974_f();
/* 1736 */     this.field_71441_e.func_73022_a();
/*      */     
/* 1738 */     int i = 0;
/* 1739 */     String str = null;
/* 1740 */     if (this.field_71439_g != null) {
/* 1741 */       i = this.field_71439_g.func_145782_y();
/* 1742 */       this.field_71441_e.func_72900_e((Entity)this.field_71439_g);
/* 1743 */       str = this.field_71439_g.func_142021_k();
/*      */     } 
/*      */     
/* 1746 */     this.field_71451_h = null;
/* 1747 */     this.field_71439_g = this.field_71442_b.func_147493_a((World)this.field_71441_e, (this.field_71439_g == null) ? new StatFileWriter() : this.field_71439_g.func_146107_m());
/* 1748 */     this.field_71439_g.field_71093_bK = p_71354_1_;
/* 1749 */     this.field_71451_h = (EntityLivingBase)this.field_71439_g;
/* 1750 */     this.field_71439_g.func_70065_x();
/* 1751 */     this.field_71439_g.func_142020_c(str);
/* 1752 */     this.field_71441_e.func_72838_d((Entity)this.field_71439_g);
/* 1753 */     this.field_71442_b.func_78745_b((EntityPlayer)this.field_71439_g);
/*      */     
/* 1755 */     this.field_71439_g.field_71158_b = (MovementInput)new MovementInputFromOptions(this.field_71474_y);
/* 1756 */     this.field_71439_g.func_145769_d(i);
/* 1757 */     this.field_71442_b.func_78748_a((EntityPlayer)this.field_71439_g);
/*      */     
/* 1759 */     if (this.field_71462_r instanceof GuiGameOver) func_147108_a(null); 
/*      */   }
/*      */   
/*      */   public final boolean func_71355_q() {
/* 1763 */     return this.field_71459_aj;
/*      */   }
/*      */   
/*      */   public NetHandlerPlayClient func_147114_u() {
/* 1767 */     if (this.field_71439_g != null) {
/* 1768 */       return this.field_71439_g.field_71174_a;
/*      */     }
/* 1770 */     return null;
/*      */   }
/*      */   
/*      */   public static boolean func_71382_s() {
/* 1774 */     return (field_71432_P == null || !field_71432_P.field_71474_y.field_74319_N);
/*      */   }
/*      */   
/*      */   public static boolean func_71375_t() {
/* 1778 */     return (field_71432_P != null && field_71432_P.field_71474_y.field_74347_j);
/*      */   }
/*      */   
/*      */   public static boolean func_71379_u() {
/* 1782 */     return (field_71432_P != null && field_71432_P.field_71474_y.field_74348_k != 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void func_147112_ai() {
/*      */     Item item;
/* 1794 */     if (this.field_71476_x == null) {
/*      */       return;
/*      */     }
/*      */     
/* 1798 */     boolean bool1 = this.field_71439_g.field_71075_bZ.field_75098_d;
/*      */     
/* 1800 */     int i = 0;
/* 1801 */     boolean bool2 = false;
/*      */     
/* 1803 */     if (this.field_71476_x.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
/* 1804 */       int j = this.field_71476_x.field_72311_b;
/* 1805 */       int k = this.field_71476_x.field_72312_c;
/* 1806 */       int m = this.field_71476_x.field_72309_d;
/*      */       
/* 1808 */       Block block1 = this.field_71441_e.func_147439_a(j, k, m);
/*      */       
/* 1810 */       if (block1.func_149688_o() == Material.field_151579_a) {
/*      */         return;
/*      */       }
/*      */       
/* 1814 */       item = block1.func_149694_d((World)this.field_71441_e, j, k, m);
/* 1815 */       if (item == null) {
/*      */         return;
/*      */       }
/*      */       
/* 1819 */       bool2 = item.func_77614_k();
/*      */       
/* 1821 */       Block block2 = (item instanceof net.minecraft.item.ItemBlock && !block1.func_149648_K()) ? Block.func_149634_a(item) : block1;
/*      */       
/* 1823 */       i = block2.func_149643_k((World)this.field_71441_e, j, k, m);
/* 1824 */     } else if (this.field_71476_x.field_72313_a == MovingObjectPosition.MovingObjectType.ENTITY && this.field_71476_x.field_72308_g != null && bool1) {
/* 1825 */       if (this.field_71476_x.field_72308_g instanceof net.minecraft.entity.item.EntityPainting) {
/* 1826 */         item = Items.field_151159_an;
/* 1827 */       } else if (this.field_71476_x.field_72308_g instanceof net.minecraft.entity.EntityLeashKnot) {
/* 1828 */         item = Items.field_151058_ca;
/* 1829 */       } else if (this.field_71476_x.field_72308_g instanceof EntityItemFrame) {
/* 1830 */         EntityItemFrame entityItemFrame = (EntityItemFrame)this.field_71476_x.field_72308_g;
/* 1831 */         ItemStack itemStack = entityItemFrame.func_82335_i();
/* 1832 */         if (itemStack == null) {
/* 1833 */           item = Items.field_151160_bD;
/*      */         } else {
/* 1835 */           item = itemStack.func_77973_b();
/* 1836 */           i = itemStack.func_77960_j();
/* 1837 */           bool2 = true;
/*      */         } 
/* 1839 */       } else if (this.field_71476_x.field_72308_g instanceof EntityMinecart) {
/* 1840 */         EntityMinecart entityMinecart = (EntityMinecart)this.field_71476_x.field_72308_g;
/*      */         
/* 1842 */         if (entityMinecart.func_94087_l() == 2) {
/* 1843 */           item = Items.field_151109_aJ;
/* 1844 */         } else if (entityMinecart.func_94087_l() == 1) {
/* 1845 */           item = Items.field_151108_aI;
/* 1846 */         } else if (entityMinecart.func_94087_l() == 3) {
/* 1847 */           item = Items.field_151142_bV;
/* 1848 */         } else if (entityMinecart.func_94087_l() == 5) {
/* 1849 */           item = Items.field_151140_bW;
/* 1850 */         } else if (entityMinecart.func_94087_l() == 6) {
/* 1851 */           item = Items.field_151095_cc;
/*      */         } else {
/* 1853 */           item = Items.field_151143_au;
/*      */         } 
/* 1855 */       } else if (this.field_71476_x.field_72308_g instanceof net.minecraft.entity.item.EntityBoat) {
/* 1856 */         item = Items.field_151124_az;
/*      */       } else {
/* 1858 */         item = Items.field_151063_bx;
/* 1859 */         i = EntityList.func_75619_a(this.field_71476_x.field_72308_g);
/* 1860 */         bool2 = true;
/*      */         
/* 1862 */         if (i <= 0 || !EntityList.field_75627_a.containsKey(Integer.valueOf(i))) {
/*      */           return;
/*      */         }
/*      */       } 
/*      */     } else {
/*      */       return;
/*      */     } 
/*      */     
/* 1870 */     this.field_71439_g.field_71071_by.func_146030_a(item, i, bool2, bool1);
/*      */     
/* 1872 */     if (bool1) {
/* 1873 */       int j = this.field_71439_g.field_71069_bz.field_75151_b.size() - 9 + this.field_71439_g.field_71071_by.field_70461_c;
/* 1874 */       this.field_71442_b.func_78761_a(this.field_71439_g.field_71071_by.func_70301_a(this.field_71439_g.field_71071_by.field_70461_c), j);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public CrashReport func_71396_d(CrashReport p_71396_1_) {
/* 1880 */     p_71396_1_.func_85056_g().func_71500_a("Launched Version", new Callable(this) { private static final String __OBFID = "CL_00000643";
/*      */           
/*      */           public String call() {
/* 1883 */             return this.field_74421_a.field_110447_Z;
/*      */           } }
/*      */       );
/*      */     
/* 1887 */     p_71396_1_.func_85056_g().func_71500_a("LWJGL", new Callable(this) { private static final String __OBFID = "CL_00000644";
/*      */           
/*      */           public String call() {
/* 1890 */             return Sys.getVersion();
/*      */           } }
/*      */       );
/*      */     
/* 1894 */     p_71396_1_.func_85056_g().func_71500_a("OpenGL", new Callable(this) { private static final String __OBFID = "CL_00000645";
/*      */           
/*      */           public String call() {
/* 1897 */             return GL11.glGetString(7937) + " GL version " + GL11.glGetString(7938) + ", " + GL11.glGetString(7936);
/*      */           } }
/*      */       );
/*      */     
/* 1901 */     p_71396_1_.func_85056_g().func_71500_a("GL Caps", new Callable(this) { private static final String __OBFID = "CL_00000646";
/*      */           
/*      */           public String call() {
/* 1904 */             return OpenGlHelper.func_153172_c();
/*      */           } }
/*      */       );
/*      */     
/* 1908 */     p_71396_1_.func_85056_g().func_71500_a("Is Modded", new Callable(this) { private static final String __OBFID = "CL_00000647";
/*      */           
/*      */           public String call() {
/* 1911 */             String str = ClientBrandRetriever.getClientModName();
/* 1912 */             if (!str.equals("vanilla")) return "Definitely; Client brand changed to '" + str + "'"; 
/* 1913 */             if (Minecraft.class.getSigners() == null) return "Very likely; Jar signature invalidated"; 
/* 1914 */             return "Probably not. Jar signature remains and client brand is untouched.";
/*      */           } }
/*      */       );
/*      */     
/* 1918 */     p_71396_1_.func_85056_g().func_71500_a("Type", new Callable(this) { private static final String __OBFID = "CL_00000633";
/*      */           
/*      */           public String call() {
/* 1921 */             return "Client (map_client.txt)";
/*      */           } }
/*      */       );
/*      */     
/* 1925 */     p_71396_1_.func_85056_g().func_71500_a("Resource Packs", new Callable(this) { private static final String __OBFID = "CL_00000634";
/*      */           
/*      */           public String call() {
/* 1928 */             return this.field_90046_a.field_71474_y.field_151453_l.toString();
/*      */           } }
/*      */       );
/*      */     
/* 1932 */     p_71396_1_.func_85056_g().func_71500_a("Current Language", new Callable(this) { private static final String __OBFID = "CL_00000635";
/*      */           
/*      */           public String call() {
/* 1935 */             return this.field_90048_a.field_135017_as.func_135041_c().toString();
/*      */           } }
/*      */       );
/*      */     
/* 1939 */     p_71396_1_.func_85056_g().func_71500_a("Profiler Position", new Callable(this) { private static final String __OBFID = "CL_00000636";
/*      */           
/*      */           public String call() {
/* 1942 */             return this.field_142056_a.field_71424_I.field_76327_a ? this.field_142056_a.field_71424_I.func_76322_c() : "N/A (disabled)";
/*      */           } }
/*      */       );
/*      */     
/* 1946 */     p_71396_1_.func_85056_g().func_71500_a("Vec3 Pool Size", new Callable(this) { private static final String __OBFID = "CL_00000637";
/*      */           
/*      */           public String call() {
/* 1949 */             byte b1 = 0;
/* 1950 */             int i = 56 * b1;
/* 1951 */             int j = i / 1024 / 1024;
/* 1952 */             byte b2 = 0;
/* 1953 */             int k = 56 * b2;
/* 1954 */             int m = k / 1024 / 1024;
/*      */             
/* 1956 */             return b1 + " (" + i + " bytes; " + j + " MB) allocated, " + b2 + " (" + k + " bytes; " + m + " MB) used";
/*      */           } }
/*      */       );
/*      */     
/* 1960 */     p_71396_1_.func_85056_g().func_71500_a("Anisotropic Filtering", new Callable(this) { private static final String __OBFID = "CL_00001853";
/*      */           
/*      */           public String func_152388_a() {
/* 1963 */             if (this.field_152389_a.field_71474_y.field_151443_J == 1) {
/* 1964 */               return "Off (1)";
/*      */             }
/* 1966 */             return "On (" + this.field_152389_a.field_71474_y.field_151443_J + ")";
/*      */           } }
/*      */       );
/*      */ 
/*      */     
/* 1971 */     if (this.field_71441_e != null) {
/* 1972 */       this.field_71441_e.func_72914_a(p_71396_1_);
/*      */     }
/*      */     
/* 1975 */     return p_71396_1_;
/*      */   }
/*      */   
/*      */   public static Minecraft func_71410_x() {
/* 1979 */     return field_71432_P;
/*      */   }
/*      */   
/*      */   public void func_147106_B() {
/* 1983 */     this.field_71468_ad = true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70000_a(PlayerUsageSnooper p_70000_1_) {
/* 1988 */     p_70000_1_.func_152768_a("fps", Integer.valueOf(field_71470_ab));
/* 1989 */     p_70000_1_.func_152768_a("vsync_enabled", Boolean.valueOf(this.field_71474_y.field_74352_v));
/* 1990 */     p_70000_1_.func_152768_a("display_frequency", Integer.valueOf(Display.getDisplayMode().getFrequency()));
/* 1991 */     p_70000_1_.func_152768_a("display_type", this.field_71431_Q ? "fullscreen" : "windowed");
/* 1992 */     p_70000_1_.func_152768_a("run_time", Long.valueOf((MinecraftServer.func_130071_aq() - p_70000_1_.func_130105_g()) / 60L * 1000L));
/*      */     
/* 1994 */     p_70000_1_.func_152768_a("resource_packs", Integer.valueOf(this.field_110448_aq.func_110613_c().size()));
/* 1995 */     byte b = 0;
/* 1996 */     for (ResourcePackRepository.Entry entry : this.field_110448_aq.func_110613_c()) {
/* 1997 */       p_70000_1_.func_152768_a("resource_pack[" + b++ + "]", entry.func_110515_d());
/*      */     }
/*      */     
/* 2000 */     if (this.field_71437_Z != null && this.field_71437_Z.func_80003_ah() != null) {
/* 2001 */       p_70000_1_.func_152768_a("snooper_partner", this.field_71437_Z.func_80003_ah().func_80006_f());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70001_b(PlayerUsageSnooper p_70001_1_) {
/* 2007 */     p_70001_1_.func_152767_b("opengl_version", GL11.glGetString(7938));
/* 2008 */     p_70001_1_.func_152767_b("opengl_vendor", GL11.glGetString(7936));
/* 2009 */     p_70001_1_.func_152767_b("client_brand", ClientBrandRetriever.getClientModName());
/* 2010 */     p_70001_1_.func_152767_b("launched_version", this.field_110447_Z);
/*      */     
/* 2012 */     ContextCapabilities contextCapabilities = GLContext.getCapabilities();
/* 2013 */     p_70001_1_.func_152767_b("gl_caps[ARB_arrays_of_arrays]", Boolean.valueOf(contextCapabilities.GL_ARB_arrays_of_arrays));
/* 2014 */     p_70001_1_.func_152767_b("gl_caps[ARB_base_instance]", Boolean.valueOf(contextCapabilities.GL_ARB_base_instance));
/* 2015 */     p_70001_1_.func_152767_b("gl_caps[ARB_blend_func_extended]", Boolean.valueOf(contextCapabilities.GL_ARB_blend_func_extended));
/* 2016 */     p_70001_1_.func_152767_b("gl_caps[ARB_clear_buffer_object]", Boolean.valueOf(contextCapabilities.GL_ARB_clear_buffer_object));
/* 2017 */     p_70001_1_.func_152767_b("gl_caps[ARB_color_buffer_float]", Boolean.valueOf(contextCapabilities.GL_ARB_color_buffer_float));
/* 2018 */     p_70001_1_.func_152767_b("gl_caps[ARB_compatibility]", Boolean.valueOf(contextCapabilities.GL_ARB_compatibility));
/* 2019 */     p_70001_1_.func_152767_b("gl_caps[ARB_compressed_texture_pixel_storage]", Boolean.valueOf(contextCapabilities.GL_ARB_compressed_texture_pixel_storage));
/* 2020 */     p_70001_1_.func_152767_b("gl_caps[ARB_compute_shader]", Boolean.valueOf(contextCapabilities.GL_ARB_compute_shader));
/* 2021 */     p_70001_1_.func_152767_b("gl_caps[ARB_copy_buffer]", Boolean.valueOf(contextCapabilities.GL_ARB_copy_buffer));
/* 2022 */     p_70001_1_.func_152767_b("gl_caps[ARB_copy_image]", Boolean.valueOf(contextCapabilities.GL_ARB_copy_image));
/* 2023 */     p_70001_1_.func_152767_b("gl_caps[ARB_depth_buffer_float]", Boolean.valueOf(contextCapabilities.GL_ARB_depth_buffer_float));
/* 2024 */     p_70001_1_.func_152767_b("gl_caps[ARB_compute_shader]", Boolean.valueOf(contextCapabilities.GL_ARB_compute_shader));
/* 2025 */     p_70001_1_.func_152767_b("gl_caps[ARB_copy_buffer]", Boolean.valueOf(contextCapabilities.GL_ARB_copy_buffer));
/* 2026 */     p_70001_1_.func_152767_b("gl_caps[ARB_copy_image]", Boolean.valueOf(contextCapabilities.GL_ARB_copy_image));
/* 2027 */     p_70001_1_.func_152767_b("gl_caps[ARB_depth_buffer_float]", Boolean.valueOf(contextCapabilities.GL_ARB_depth_buffer_float));
/* 2028 */     p_70001_1_.func_152767_b("gl_caps[ARB_depth_clamp]", Boolean.valueOf(contextCapabilities.GL_ARB_depth_clamp));
/* 2029 */     p_70001_1_.func_152767_b("gl_caps[ARB_depth_texture]", Boolean.valueOf(contextCapabilities.GL_ARB_depth_texture));
/* 2030 */     p_70001_1_.func_152767_b("gl_caps[ARB_draw_buffers]", Boolean.valueOf(contextCapabilities.GL_ARB_draw_buffers));
/* 2031 */     p_70001_1_.func_152767_b("gl_caps[ARB_draw_buffers_blend]", Boolean.valueOf(contextCapabilities.GL_ARB_draw_buffers_blend));
/* 2032 */     p_70001_1_.func_152767_b("gl_caps[ARB_draw_elements_base_vertex]", Boolean.valueOf(contextCapabilities.GL_ARB_draw_elements_base_vertex));
/* 2033 */     p_70001_1_.func_152767_b("gl_caps[ARB_draw_indirect]", Boolean.valueOf(contextCapabilities.GL_ARB_draw_indirect));
/* 2034 */     p_70001_1_.func_152767_b("gl_caps[ARB_draw_instanced]", Boolean.valueOf(contextCapabilities.GL_ARB_draw_instanced));
/* 2035 */     p_70001_1_.func_152767_b("gl_caps[ARB_explicit_attrib_location]", Boolean.valueOf(contextCapabilities.GL_ARB_explicit_attrib_location));
/* 2036 */     p_70001_1_.func_152767_b("gl_caps[ARB_explicit_uniform_location]", Boolean.valueOf(contextCapabilities.GL_ARB_explicit_uniform_location));
/* 2037 */     p_70001_1_.func_152767_b("gl_caps[ARB_fragment_layer_viewport]", Boolean.valueOf(contextCapabilities.GL_ARB_fragment_layer_viewport));
/* 2038 */     p_70001_1_.func_152767_b("gl_caps[ARB_fragment_program]", Boolean.valueOf(contextCapabilities.GL_ARB_fragment_program));
/* 2039 */     p_70001_1_.func_152767_b("gl_caps[ARB_fragment_shader]", Boolean.valueOf(contextCapabilities.GL_ARB_fragment_shader));
/* 2040 */     p_70001_1_.func_152767_b("gl_caps[ARB_fragment_program_shadow]", Boolean.valueOf(contextCapabilities.GL_ARB_fragment_program_shadow));
/* 2041 */     p_70001_1_.func_152767_b("gl_caps[ARB_framebuffer_object]", Boolean.valueOf(contextCapabilities.GL_ARB_framebuffer_object));
/* 2042 */     p_70001_1_.func_152767_b("gl_caps[ARB_framebuffer_sRGB]", Boolean.valueOf(contextCapabilities.GL_ARB_framebuffer_sRGB));
/* 2043 */     p_70001_1_.func_152767_b("gl_caps[ARB_geometry_shader4]", Boolean.valueOf(contextCapabilities.GL_ARB_geometry_shader4));
/* 2044 */     p_70001_1_.func_152767_b("gl_caps[ARB_gpu_shader5]", Boolean.valueOf(contextCapabilities.GL_ARB_gpu_shader5));
/* 2045 */     p_70001_1_.func_152767_b("gl_caps[ARB_half_float_pixel]", Boolean.valueOf(contextCapabilities.GL_ARB_half_float_pixel));
/* 2046 */     p_70001_1_.func_152767_b("gl_caps[ARB_half_float_vertex]", Boolean.valueOf(contextCapabilities.GL_ARB_half_float_vertex));
/* 2047 */     p_70001_1_.func_152767_b("gl_caps[ARB_instanced_arrays]", Boolean.valueOf(contextCapabilities.GL_ARB_instanced_arrays));
/* 2048 */     p_70001_1_.func_152767_b("gl_caps[ARB_map_buffer_alignment]", Boolean.valueOf(contextCapabilities.GL_ARB_map_buffer_alignment));
/* 2049 */     p_70001_1_.func_152767_b("gl_caps[ARB_map_buffer_range]", Boolean.valueOf(contextCapabilities.GL_ARB_map_buffer_range));
/* 2050 */     p_70001_1_.func_152767_b("gl_caps[ARB_multisample]", Boolean.valueOf(contextCapabilities.GL_ARB_multisample));
/* 2051 */     p_70001_1_.func_152767_b("gl_caps[ARB_multitexture]", Boolean.valueOf(contextCapabilities.GL_ARB_multitexture));
/* 2052 */     p_70001_1_.func_152767_b("gl_caps[ARB_occlusion_query2]", Boolean.valueOf(contextCapabilities.GL_ARB_occlusion_query2));
/* 2053 */     p_70001_1_.func_152767_b("gl_caps[ARB_pixel_buffer_object]", Boolean.valueOf(contextCapabilities.GL_ARB_pixel_buffer_object));
/* 2054 */     p_70001_1_.func_152767_b("gl_caps[ARB_seamless_cube_map]", Boolean.valueOf(contextCapabilities.GL_ARB_seamless_cube_map));
/* 2055 */     p_70001_1_.func_152767_b("gl_caps[ARB_shader_objects]", Boolean.valueOf(contextCapabilities.GL_ARB_shader_objects));
/* 2056 */     p_70001_1_.func_152767_b("gl_caps[ARB_shader_stencil_export]", Boolean.valueOf(contextCapabilities.GL_ARB_shader_stencil_export));
/* 2057 */     p_70001_1_.func_152767_b("gl_caps[ARB_shader_texture_lod]", Boolean.valueOf(contextCapabilities.GL_ARB_shader_texture_lod));
/* 2058 */     p_70001_1_.func_152767_b("gl_caps[ARB_shadow]", Boolean.valueOf(contextCapabilities.GL_ARB_shadow));
/* 2059 */     p_70001_1_.func_152767_b("gl_caps[ARB_shadow_ambient]", Boolean.valueOf(contextCapabilities.GL_ARB_shadow_ambient));
/* 2060 */     p_70001_1_.func_152767_b("gl_caps[ARB_stencil_texturing]", Boolean.valueOf(contextCapabilities.GL_ARB_stencil_texturing));
/* 2061 */     p_70001_1_.func_152767_b("gl_caps[ARB_sync]", Boolean.valueOf(contextCapabilities.GL_ARB_sync));
/* 2062 */     p_70001_1_.func_152767_b("gl_caps[ARB_tessellation_shader]", Boolean.valueOf(contextCapabilities.GL_ARB_tessellation_shader));
/* 2063 */     p_70001_1_.func_152767_b("gl_caps[ARB_texture_border_clamp]", Boolean.valueOf(contextCapabilities.GL_ARB_texture_border_clamp));
/* 2064 */     p_70001_1_.func_152767_b("gl_caps[ARB_texture_buffer_object]", Boolean.valueOf(contextCapabilities.GL_ARB_texture_buffer_object));
/* 2065 */     p_70001_1_.func_152767_b("gl_caps[ARB_texture_cube_map]", Boolean.valueOf(contextCapabilities.GL_ARB_texture_cube_map));
/* 2066 */     p_70001_1_.func_152767_b("gl_caps[ARB_texture_cube_map_array]", Boolean.valueOf(contextCapabilities.GL_ARB_texture_cube_map_array));
/* 2067 */     p_70001_1_.func_152767_b("gl_caps[ARB_texture_non_power_of_two]", Boolean.valueOf(contextCapabilities.GL_ARB_texture_non_power_of_two));
/* 2068 */     p_70001_1_.func_152767_b("gl_caps[ARB_uniform_buffer_object]", Boolean.valueOf(contextCapabilities.GL_ARB_uniform_buffer_object));
/* 2069 */     p_70001_1_.func_152767_b("gl_caps[ARB_vertex_blend]", Boolean.valueOf(contextCapabilities.GL_ARB_vertex_blend));
/* 2070 */     p_70001_1_.func_152767_b("gl_caps[ARB_vertex_buffer_object]", Boolean.valueOf(contextCapabilities.GL_ARB_vertex_buffer_object));
/* 2071 */     p_70001_1_.func_152767_b("gl_caps[ARB_vertex_program]", Boolean.valueOf(contextCapabilities.GL_ARB_vertex_program));
/* 2072 */     p_70001_1_.func_152767_b("gl_caps[ARB_vertex_shader]", Boolean.valueOf(contextCapabilities.GL_ARB_vertex_shader));
/*      */     
/* 2074 */     p_70001_1_.func_152767_b("gl_caps[EXT_bindable_uniform]", Boolean.valueOf(contextCapabilities.GL_EXT_bindable_uniform));
/* 2075 */     p_70001_1_.func_152767_b("gl_caps[EXT_blend_equation_separate]", Boolean.valueOf(contextCapabilities.GL_EXT_blend_equation_separate));
/* 2076 */     p_70001_1_.func_152767_b("gl_caps[EXT_blend_func_separate]", Boolean.valueOf(contextCapabilities.GL_EXT_blend_func_separate));
/* 2077 */     p_70001_1_.func_152767_b("gl_caps[EXT_blend_minmax]", Boolean.valueOf(contextCapabilities.GL_EXT_blend_minmax));
/* 2078 */     p_70001_1_.func_152767_b("gl_caps[EXT_blend_subtract]", Boolean.valueOf(contextCapabilities.GL_EXT_blend_subtract));
/* 2079 */     p_70001_1_.func_152767_b("gl_caps[EXT_draw_instanced]", Boolean.valueOf(contextCapabilities.GL_EXT_draw_instanced));
/* 2080 */     p_70001_1_.func_152767_b("gl_caps[EXT_framebuffer_multisample]", Boolean.valueOf(contextCapabilities.GL_EXT_framebuffer_multisample));
/* 2081 */     p_70001_1_.func_152767_b("gl_caps[EXT_framebuffer_object]", Boolean.valueOf(contextCapabilities.GL_EXT_framebuffer_object));
/* 2082 */     p_70001_1_.func_152767_b("gl_caps[EXT_framebuffer_sRGB]", Boolean.valueOf(contextCapabilities.GL_EXT_framebuffer_sRGB));
/* 2083 */     p_70001_1_.func_152767_b("gl_caps[EXT_geometry_shader4]", Boolean.valueOf(contextCapabilities.GL_EXT_geometry_shader4));
/* 2084 */     p_70001_1_.func_152767_b("gl_caps[EXT_gpu_program_parameters]", Boolean.valueOf(contextCapabilities.GL_EXT_gpu_program_parameters));
/* 2085 */     p_70001_1_.func_152767_b("gl_caps[EXT_gpu_shader4]", Boolean.valueOf(contextCapabilities.GL_EXT_gpu_shader4));
/* 2086 */     p_70001_1_.func_152767_b("gl_caps[EXT_multi_draw_arrays]", Boolean.valueOf(contextCapabilities.GL_EXT_multi_draw_arrays));
/* 2087 */     p_70001_1_.func_152767_b("gl_caps[EXT_packed_depth_stencil]", Boolean.valueOf(contextCapabilities.GL_EXT_packed_depth_stencil));
/* 2088 */     p_70001_1_.func_152767_b("gl_caps[EXT_paletted_texture]", Boolean.valueOf(contextCapabilities.GL_EXT_paletted_texture));
/* 2089 */     p_70001_1_.func_152767_b("gl_caps[EXT_rescale_normal]", Boolean.valueOf(contextCapabilities.GL_EXT_rescale_normal));
/* 2090 */     p_70001_1_.func_152767_b("gl_caps[EXT_separate_shader_objects]", Boolean.valueOf(contextCapabilities.GL_EXT_separate_shader_objects));
/* 2091 */     p_70001_1_.func_152767_b("gl_caps[EXT_shader_image_load_store]", Boolean.valueOf(contextCapabilities.GL_EXT_shader_image_load_store));
/* 2092 */     p_70001_1_.func_152767_b("gl_caps[EXT_shadow_funcs]", Boolean.valueOf(contextCapabilities.GL_EXT_shadow_funcs));
/* 2093 */     p_70001_1_.func_152767_b("gl_caps[EXT_shared_texture_palette]", Boolean.valueOf(contextCapabilities.GL_EXT_shared_texture_palette));
/* 2094 */     p_70001_1_.func_152767_b("gl_caps[EXT_stencil_clear_tag]", Boolean.valueOf(contextCapabilities.GL_EXT_stencil_clear_tag));
/* 2095 */     p_70001_1_.func_152767_b("gl_caps[EXT_stencil_two_side]", Boolean.valueOf(contextCapabilities.GL_EXT_stencil_two_side));
/* 2096 */     p_70001_1_.func_152767_b("gl_caps[EXT_stencil_wrap]", Boolean.valueOf(contextCapabilities.GL_EXT_stencil_wrap));
/* 2097 */     p_70001_1_.func_152767_b("gl_caps[EXT_texture_3d]", Boolean.valueOf(contextCapabilities.GL_EXT_texture_3d));
/* 2098 */     p_70001_1_.func_152767_b("gl_caps[EXT_texture_array]", Boolean.valueOf(contextCapabilities.GL_EXT_texture_array));
/* 2099 */     p_70001_1_.func_152767_b("gl_caps[EXT_texture_buffer_object]", Boolean.valueOf(contextCapabilities.GL_EXT_texture_buffer_object));
/* 2100 */     p_70001_1_.func_152767_b("gl_caps[EXT_texture_filter_anisotropic]", Boolean.valueOf(contextCapabilities.GL_EXT_texture_filter_anisotropic));
/* 2101 */     p_70001_1_.func_152767_b("gl_caps[EXT_texture_integer]", Boolean.valueOf(contextCapabilities.GL_EXT_texture_integer));
/* 2102 */     p_70001_1_.func_152767_b("gl_caps[EXT_texture_lod_bias]", Boolean.valueOf(contextCapabilities.GL_EXT_texture_lod_bias));
/* 2103 */     p_70001_1_.func_152767_b("gl_caps[EXT_texture_sRGB]", Boolean.valueOf(contextCapabilities.GL_EXT_texture_sRGB));
/* 2104 */     p_70001_1_.func_152767_b("gl_caps[EXT_vertex_shader]", Boolean.valueOf(contextCapabilities.GL_EXT_vertex_shader));
/* 2105 */     p_70001_1_.func_152767_b("gl_caps[EXT_vertex_weighting]", Boolean.valueOf(contextCapabilities.GL_EXT_vertex_weighting));
/*      */     
/* 2107 */     p_70001_1_.func_152767_b("gl_caps[gl_max_vertex_uniforms]", Integer.valueOf(GL11.glGetInteger(35658)));
/* 2108 */     GL11.glGetError();
/* 2109 */     p_70001_1_.func_152767_b("gl_caps[gl_max_fragment_uniforms]", Integer.valueOf(GL11.glGetInteger(35657)));
/* 2110 */     GL11.glGetError();
/* 2111 */     p_70001_1_.func_152767_b("gl_caps[gl_max_vertex_attribs]", Integer.valueOf(GL11.glGetInteger(34921)));
/* 2112 */     GL11.glGetError();
/* 2113 */     p_70001_1_.func_152767_b("gl_caps[gl_max_vertex_texture_image_units]", Integer.valueOf(GL11.glGetInteger(35660)));
/* 2114 */     GL11.glGetError();
/* 2115 */     p_70001_1_.func_152767_b("gl_caps[gl_max_texture_image_units]", Integer.valueOf(GL11.glGetInteger(34930)));
/* 2116 */     GL11.glGetError();
/* 2117 */     p_70001_1_.func_152767_b("gl_caps[gl_max_texture_image_units]", Integer.valueOf(GL11.glGetInteger(35071)));
/* 2118 */     GL11.glGetError();
/*      */     
/* 2120 */     p_70001_1_.func_152767_b("gl_max_texture_size", Integer.valueOf(func_71369_N()));
/*      */   }
/*      */   
/*      */   public static int func_71369_N() {
/* 2124 */     for (int i = 16384; i > 0; i >>= 1) {
/* 2125 */       GL11.glTexImage2D(32868, 0, 6408, i, i, 0, 6408, 5121, (ByteBuffer)null);
/* 2126 */       int j = GL11.glGetTexLevelParameteri(32868, 0, 4096);
/* 2127 */       if (j != 0) {
/* 2128 */         return i;
/*      */       }
/*      */     } 
/* 2131 */     return -1;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_70002_Q() {
/* 2136 */     return this.field_71474_y.field_74355_t;
/*      */   }
/*      */   
/*      */   public void func_71351_a(ServerData p_71351_1_) {
/* 2140 */     this.field_71422_O = p_71351_1_;
/*      */   }
/*      */   
/*      */   public ServerData func_147104_D() {
/* 2144 */     return this.field_71422_O;
/*      */   }
/*      */   
/*      */   public boolean func_71387_A() {
/* 2148 */     return this.field_71455_al;
/*      */   }
/*      */   
/*      */   public boolean func_71356_B() {
/* 2152 */     return (this.field_71455_al && this.field_71437_Z != null);
/*      */   }
/*      */   
/*      */   public IntegratedServer func_71401_C() {
/* 2156 */     return this.field_71437_Z;
/*      */   }
/*      */   
/*      */   public static void func_71363_D() {
/* 2160 */     if (field_71432_P == null)
/*      */       return; 
/* 2162 */     IntegratedServer integratedServer = field_71432_P.func_71401_C();
/* 2163 */     if (integratedServer != null) {
/* 2164 */       integratedServer.func_71260_j();
/*      */     }
/*      */   }
/*      */   
/*      */   public PlayerUsageSnooper func_71378_E() {
/* 2169 */     return this.field_71427_U;
/*      */   }
/*      */   
/*      */   public static long func_71386_F() {
/* 2173 */     return Sys.getTime() * 1000L / Sys.getTimerResolution();
/*      */   }
/*      */   
/*      */   public boolean func_71372_G() {
/* 2177 */     return this.field_71431_Q;
/*      */   }
/*      */   
/*      */   public Session func_110432_I() {
/* 2181 */     return this.field_71449_j;
/*      */   }
/*      */   
/*      */   public Multimap func_152341_N() {
/* 2185 */     return this.field_152356_J;
/*      */   }
/*      */   
/*      */   public Proxy func_110437_J() {
/* 2189 */     return this.field_110453_aa;
/*      */   }
/*      */   
/*      */   public TextureManager func_110434_K() {
/* 2193 */     return this.field_71446_o;
/*      */   }
/*      */   
/*      */   public IResourceManager func_110442_L() {
/* 2197 */     return (IResourceManager)this.field_110451_am;
/*      */   }
/*      */   
/*      */   public ResourcePackRepository func_110438_M() {
/* 2201 */     return this.field_110448_aq;
/*      */   }
/*      */   
/*      */   public LanguageManager func_135016_M() {
/* 2205 */     return this.field_135017_as;
/*      */   }
/*      */   
/*      */   public TextureMap func_147117_R() {
/* 2209 */     return this.field_147128_au;
/*      */   }
/*      */   
/*      */   public boolean func_147111_S() {
/* 2213 */     return this.field_147129_ai;
/*      */   }
/*      */   
/*      */   public boolean func_147113_T() {
/* 2217 */     return this.field_71445_n;
/*      */   }
/*      */   
/*      */   public SoundHandler func_147118_V() {
/* 2221 */     return this.field_147127_av;
/*      */   }
/*      */   
/*      */   public MusicTicker.MusicType func_147109_W() {
/* 2225 */     if (this.field_71462_r instanceof net.minecraft.client.gui.GuiWinGame) {
/* 2226 */       return MusicTicker.MusicType.CREDITS;
/*      */     }
/*      */     
/* 2229 */     if (this.field_71439_g != null) {
/* 2230 */       if (this.field_71439_g.field_70170_p.field_73011_w instanceof net.minecraft.world.WorldProviderHell)
/* 2231 */         return MusicTicker.MusicType.NETHER; 
/* 2232 */       if (this.field_71439_g.field_70170_p.field_73011_w instanceof net.minecraft.world.WorldProviderEnd) {
/* 2233 */         if (BossStatus.field_82827_c != null && BossStatus.field_82826_b > 0) {
/* 2234 */           return MusicTicker.MusicType.END_BOSS;
/*      */         }
/* 2236 */         return MusicTicker.MusicType.END;
/*      */       } 
/*      */ 
/*      */       
/* 2240 */       if (this.field_71439_g.field_71075_bZ.field_75098_d && this.field_71439_g.field_71075_bZ.field_75101_c) {
/* 2241 */         return MusicTicker.MusicType.CREATIVE;
/*      */       }
/*      */       
/* 2244 */       return MusicTicker.MusicType.GAME;
/*      */     } 
/*      */     
/* 2247 */     return MusicTicker.MusicType.MENU;
/*      */   }
/*      */   
/*      */   public IStream func_152346_Z() {
/* 2251 */     return this.field_152353_at;
/*      */   }
/*      */   
/*      */   public void func_152348_aa() {
/* 2255 */     int i = Keyboard.getEventKey();
/* 2256 */     if (i == 0 || Keyboard.isRepeatEvent())
/*      */       return; 
/* 2258 */     if (this.field_71462_r instanceof GuiControls && ((GuiControls)this.field_71462_r).field_152177_g > func_71386_F() - 20L)
/*      */       return; 
/* 2260 */     if (Keyboard.getEventKeyState()) {
/* 2261 */       if (i == this.field_71474_y.field_152396_an.func_151463_i()) {
/* 2262 */         if (func_152346_Z().func_152934_n()) {
/* 2263 */           func_152346_Z().func_152914_u();
/* 2264 */         } else if (func_152346_Z().func_152924_m()) {
/* 2265 */           func_147108_a((GuiScreen)new GuiYesNo(new GuiYesNoCallback(this) { private static final String __OBFID = "CL_00001852";
/*      */                   
/*      */                   public void func_73878_a(boolean p_73878_1_, int p_73878_2_) {
/* 2268 */                     if (p_73878_1_) {
/* 2269 */                       this.field_152128_a.func_152346_Z().func_152930_t();
/*      */                     }
/* 2271 */                     this.field_152128_a.func_147108_a(null);
/*      */                   }
/*      */                 },  I18n.func_135052_a("stream.confirm_start", new Object[0]), "", 0));
/* 2274 */         } else if (!func_152346_Z().func_152928_D() || !func_152346_Z().func_152936_l()) {
/* 2275 */           GuiStreamUnavailable.func_152321_a(this.field_71462_r);
/* 2276 */         } else if (this.field_71441_e != null) {
/* 2277 */           this.field_71456_v.func_146158_b().func_146227_a((IChatComponent)new ChatComponentText("Not ready to start streaming yet!"));
/*      */         } 
/* 2279 */       } else if (i == this.field_71474_y.field_152397_ao.func_151463_i()) {
/* 2280 */         if (func_152346_Z().func_152934_n()) {
/* 2281 */           if (func_152346_Z().func_152919_o()) {
/* 2282 */             func_152346_Z().func_152933_r();
/*      */           } else {
/* 2284 */             func_152346_Z().func_152916_q();
/*      */           } 
/*      */         }
/* 2287 */       } else if (i == this.field_71474_y.field_152398_ap.func_151463_i()) {
/* 2288 */         if (func_152346_Z().func_152934_n()) {
/* 2289 */           func_152346_Z().func_152931_p();
/*      */         }
/* 2291 */       } else if (i == this.field_71474_y.field_152399_aq.func_151463_i()) {
/* 2292 */         this.field_152353_at.func_152910_a(true);
/* 2293 */       } else if (i == this.field_71474_y.field_152395_am.func_151463_i()) {
/* 2294 */         func_71352_k();
/* 2295 */       } else if (i == this.field_71474_y.field_151447_Z.func_151463_i()) {
/* 2296 */         this.field_71456_v.func_146158_b().func_146227_a(ScreenShotHelper.func_148260_a(this.field_71412_D, this.field_71443_c, this.field_71440_d, this.field_147124_at));
/*      */       }
/*      */     
/* 2299 */     } else if (i == this.field_71474_y.field_152399_aq.func_151463_i()) {
/* 2300 */       this.field_152353_at.func_152910_a(false);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public ListenableFuture func_152343_a(Callable p_152343_1_) {
/* 2306 */     Validate.notNull(p_152343_1_);
/*      */     
/* 2308 */     if (!func_152345_ab()) {
/* 2309 */       ListenableFutureTask listenableFutureTask = ListenableFutureTask.create(p_152343_1_);
/* 2310 */       synchronized (this.field_152351_aB) {
/* 2311 */         this.field_152351_aB.add(listenableFutureTask);
/*      */       } 
/* 2313 */       return (ListenableFuture)listenableFutureTask;
/*      */     } 
/*      */     try {
/* 2316 */       return Futures.immediateFuture(p_152343_1_.call());
/* 2317 */     } catch (Exception exception) {
/* 2318 */       return (ListenableFuture)Futures.immediateFailedCheckedFuture(exception);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public ListenableFuture func_152344_a(Runnable p_152344_1_) {
/* 2324 */     Validate.notNull(p_152344_1_);
/*      */     
/* 2326 */     return func_152343_a(Executors.callable(p_152344_1_));
/*      */   }
/*      */   
/*      */   public boolean func_152345_ab() {
/* 2330 */     return (Thread.currentThread() == this.field_152352_aC);
/*      */   }
/*      */   
/*      */   public MinecraftSessionService func_152347_ac() {
/* 2334 */     return this.field_152355_az;
/*      */   }
/*      */   
/*      */   public SkinManager func_152342_ad() {
/* 2338 */     return this.field_152350_aA;
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\Minecraft.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */