/*     */ package JinRyuu.JYearsC;
/*     */ 
/*     */ import cpw.mods.fml.common.Mod;
/*     */ import cpw.mods.fml.common.Mod.EventHandler;
/*     */ import cpw.mods.fml.common.Mod.Instance;
/*     */ import cpw.mods.fml.common.SidedProxy;
/*     */ import cpw.mods.fml.common.event.FMLInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLPostInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLServerStartingEvent;
/*     */ import cpw.mods.fml.common.network.NetworkRegistry;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Properties;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ServerCommandManager;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraftforge.common.config.Configuration;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ @Mod(modid = "jinryuuyearsc", name = "JinRyuu's Years C", version = "1.2.5", dependencies = "required-after:jinryuujrmcore")
/*     */ public class mod_JYearsC
/*     */ {
/*     */   public static final String MOD = "JinRyuu's Years C";
/*     */   
/*     */   private String getVersion() {
/*  36 */     return "1.2.5";
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  41 */   public static CreativeTabs JYearsC = new JYCTab("JYearsC");
/*     */   
/*     */   @SidedProxy(clientSide = "JinRyuu.JYearsC.JYearsCClient", serverSide = "JinRyuu.JYearsC.JYearsC")
/*     */   public static JYearsC proxy;
/*     */   
/*     */   @Instance("mod_JYearsC")
/*  47 */   public static mod_JYearsC instance = new mod_JYearsC();
/*  48 */   private JYearsCGuiHandler guiHandler = new JYearsCGuiHandler();
/*     */ 
/*     */   
/*     */   public static Logger logger;
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void ServerStarting(FMLServerStartingEvent event) {
/*  56 */     ServerCommandManager manager = (ServerCommandManager)event.getServer().func_71187_D();
/*  57 */     manager.func_71560_a((ICommand)new ComJycage());
/*  58 */     manager.func_71560_a((ICommand)new ComJycdate());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*  63 */   public static Properties runtimeIdProperties = new Properties();
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void PreLoad(FMLPreInitializationEvent event) {
/*  68 */     logger = event.getModLog();
/*     */     
/*  70 */     logger.info("Current Version " + getVersion());
/*  71 */     logger.info("Copyright (c) Tamas 'JinRyuu' Nagy,  2012-" + (new SimpleDateFormat("yyyy")).format(new Date()) + "");
/*  72 */     logger.info("http://jingames.net/");
/*     */ 
/*     */     
/*  75 */     Configuration config = new Configuration(event.getSuggestedConfigurationFile());
/*  76 */     JYearsCConfig.init(config);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  84 */     proxy.registerKeys();
/*     */     
/*  86 */     proxy.initialize();
/*  87 */     logger.info("Pre Initialization Complated");
/*  88 */     instance = this;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void load(FMLInitializationEvent event) {
/*  95 */     JYearsCItems.init();
/*  96 */     JYearsCRecipes.init();
/*     */     
/*  98 */     NetworkRegistry.INSTANCE.registerGuiHandler(this, this.guiHandler);
/*  99 */     proxy.registerRenderThings();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void PostLoad(FMLPostInitializationEvent event) {
/* 106 */     proxy.postInit();
/*     */ 
/*     */     
/* 109 */     logger.info("Initialization Completed");
/* 110 */     logger.info("Fully Loaded!");
/* 111 */     logger.info("Enjoy ^^");
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JYearsC-v1.2.5.jar!\JinRyuu\JYearsC\mod_JYearsC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */