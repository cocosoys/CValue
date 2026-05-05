/*     */ package JinRyuu.JRMCore;
/*     */ 
/*     */ import JinRyuu.JRMCore.blocks.BlocksJRMC;
/*     */ import JinRyuu.JRMCore.client.config.jrmc.JGConfigsClient;
/*     */ import JinRyuu.JRMCore.entity.EntitiesJRMC;
/*     */ import JinRyuu.JRMCore.items.ItemsJRMC;
/*     */ import JinRyuu.JRMCore.items.RecipesJRMC;
/*     */ import JinRyuu.JRMCore.p.PD;
/*     */ import JinRyuu.JRMCore.server.commands.CommandNotification;
/*     */ import JinRyuu.JRMCore.server.config.JGConfigsServer;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.Mod;
/*     */ import cpw.mods.fml.common.Mod.EventHandler;
/*     */ import cpw.mods.fml.common.Mod.Instance;
/*     */ import cpw.mods.fml.common.SidedProxy;
/*     */ import cpw.mods.fml.common.event.FMLInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLPostInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLServerStartingEvent;
/*     */ import cpw.mods.fml.common.network.NetworkRegistry;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ServerCommandManager;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.lwjgl.opengl.Display;
/*     */ 
/*     */ @Mod(modid = "jinryuujrmcore", name = "JinRyuu's JRMCore", version = "1.3.51")
/*     */ public class mod_JRMCore
/*     */ {
/*     */   @SidedProxy(clientSide = "JinRyuu.JRMCore.JRMCoreClient", serverSide = "JinRyuu.JRMCore.JRMCore")
/*     */   public static JRMCore proxy;
/*     */   
/*     */   private String getVersion() {
/*  38 */     return "1.3.51";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Instance("mod_JRMCore")
/*  44 */   public static mod_JRMCore instance = new mod_JRMCore();
/*  45 */   private JRMCoreGuiHandler guiHandler = new JRMCoreGuiHandler();
/*     */ 
/*     */   
/*  48 */   private static int modGuiIndex = -10;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  53 */   public static CreativeTabs JRMCore = new JRMCTab("JRMCore");
/*     */ 
/*     */ 
/*     */   
/*  57 */   public static final int GUI_CUSTOM_INV = modGuiIndex--;
/*  58 */   public static final int GUI_ITEM_INV = modGuiIndex--;
/*     */   public static Logger logger;
/*     */   
/*     */   @EventHandler
/*     */   public void ServerStarting(FMLServerStartingEvent event) {
/*  63 */     ServerCommandManager manager = (ServerCommandManager)event.getServer().func_71187_D();
/*  64 */     manager.func_71560_a((ICommand)new ComJrmctp());
/*  65 */     manager.func_71560_a((ICommand)new ComJrmca());
/*  66 */     manager.func_71560_a((ICommand)new ComJrmc());
/*  67 */     manager.func_71560_a((ICommand)new ComJrmcpvp());
/*  68 */     manager.func_71560_a((ICommand)new ComJrmcpvpcheck());
/*  69 */     manager.func_71560_a((ICommand)new ComJrmcKills());
/*  70 */     manager.func_71560_a((ICommand)new ComJrmcCheck());
/*  71 */     manager.func_71560_a((ICommand)new ComJrmcHeal());
/*  72 */     manager.func_71560_a((ICommand)new ComJrmcStatusEffect());
/*  73 */     manager.func_71560_a((ICommand)new ComJrmcTech());
/*  74 */     manager.func_71560_a((ICommand)new ComJrmcm());
/*  75 */     manager.func_71560_a((ICommand)new ComJrmctexp());
/*  76 */     manager.func_71560_a((ICommand)new ComJrmcRep());
/*  77 */     manager.func_71560_a((ICommand)new ComJrmcRei());
/*  78 */     manager.func_71560_a((ICommand)new ComJrmcDebug());
/*  79 */     manager.func_71560_a((ICommand)new ComJrmcRacialSkill());
/*  80 */     manager.func_71560_a((ICommand)new ComJrmcaBonus());
/*  81 */     manager.func_71560_a((ICommand)new ComJrmcaBonusCheck());
/*  82 */     manager.func_71560_a((ICommand)new CommandNotification());
/*  83 */     manager.func_71560_a((ICommand)new ComJrmcSafeZone());
/*  84 */     manager.func_71560_a((ICommand)new ComJrmcFormMastery());
/*  85 */     manager.func_71560_a((ICommand)new ComJrmcFormMasteryCheck());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void PreLoad(FMLPreInitializationEvent event) {
/*  93 */     if (System.getProperty("posX") != null && System.getProperty("posY") != null)
/*  94 */       Display.setLocation(Integer.parseInt(System.getProperty("posX")), Integer.parseInt(System.getProperty("posY"))); 
/*  95 */     if (System.getProperty("title") != null) {
/*  96 */       Display.setTitle(System.getProperty("title"));
/*     */     }
/*  98 */     if (event.getSide() == Side.CLIENT) JGConfigsClient.preInitClient(event);
/*     */     
/* 100 */     logger = event.getModLog();
/* 101 */     logger.info("Current Version " + getVersion()); String thisYear = (new SimpleDateFormat("yyyy")).format(new Date());
/* 102 */     logger.info("Copyright (c) Tamas 'JinRyuu' Nagy,  2012-2018");
/* 103 */     logger.info("Copyright (c) Benjamin 'JinGames_Ben' Nagy,  2018-" + (new SimpleDateFormat("yyyy")).format(new Date()) + "");
/* 104 */     logger.info("https://jingames.net");
/* 105 */     proxy.registerKeys();
/* 106 */     proxy.registerTicks();
/* 107 */     proxy.initialize();
/*     */     
/* 109 */     JRMCoreH.init();
/* 110 */     PD.registerPackets();
/*     */     
/* 112 */     JGConfigsServer.preInitServer(event);
/*     */     
/* 114 */     logger.info("Pre Initialization Complated");
/* 115 */     instance = this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void load(FMLInitializationEvent event) {
/* 122 */     BlocksJRMC.init();
/* 123 */     BlocksJRMC.register();
/* 124 */     ItemsJRMC.init();
/* 125 */     RecipesJRMC.init();
/*     */     
/* 127 */     proxy.registerRenderThings();
/*     */     
/* 129 */     if (event.getSide() == Side.CLIENT) {
/* 130 */       JRMCoreGuiScreenE eventgs = new JRMCoreGuiScreenE();
/* 131 */       MinecraftForge.EVENT_BUS.register(eventgs);
/* 132 */       FMLCommonHandler.instance().bus().register(eventgs);
/*     */     } 
/*     */     
/* 135 */     JRMCoreEH events = new JRMCoreEH();
/* 136 */     MinecraftForge.EVENT_BUS.register(events);
/*     */     
/* 138 */     FMLCommonHandler.instance().bus().register(events);
/*     */     
/* 140 */     NetworkRegistry.INSTANCE.registerGuiHandler(this, this.guiHandler);
/*     */     
/* 142 */     EntitiesJRMC.common();
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void PostLoad(FMLPostInitializationEvent event) {
/* 148 */     proxy.postInit();
/*     */     
/* 150 */     long m = Runtime.getRuntime().maxMemory() / 1000000L;
/* 151 */     JRMCoreH.mem = m;
/* 152 */     logger.info("Max Memory: " + m + "M");
/*     */     
/* 154 */     logger.info("Initialization Completed");
/* 155 */     logger.info("Fully Loaded!");
/* 156 */     logger.info("Enjoy ^^");
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\mod_JRMCore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */