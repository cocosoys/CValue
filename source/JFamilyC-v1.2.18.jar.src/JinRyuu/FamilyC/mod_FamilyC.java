/*    */ package JinRyuu.FamilyC;
/*    */ 
/*    */ import cpw.mods.fml.common.Mod;
/*    */ import cpw.mods.fml.common.Mod.EventHandler;
/*    */ import cpw.mods.fml.common.Mod.Instance;
/*    */ import cpw.mods.fml.common.SidedProxy;
/*    */ import cpw.mods.fml.common.event.FMLInitializationEvent;
/*    */ import cpw.mods.fml.common.event.FMLPostInitializationEvent;
/*    */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*    */ import cpw.mods.fml.common.event.FMLServerStartingEvent;
/*    */ import cpw.mods.fml.common.network.NetworkRegistry;
/*    */ import cpw.mods.fml.common.registry.EntityRegistry;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import java.util.Properties;
/*    */ import net.minecraft.command.ICommand;
/*    */ import net.minecraft.command.ServerCommandManager;
/*    */ import net.minecraftforge.common.config.Configuration;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Mod(modid = "jinryuufamilyc", name = "JinRyuu's Family C", version = "1.2.18", dependencies = "required-after:jinryuujrmcore")
/*    */ public class mod_FamilyC
/*    */ {
/*    */   public static final String MOD = "JinRyuu's Family C";
/*    */   @SidedProxy(clientSide = "JinRyuu.FamilyC.FamilyCClient", serverSide = "JinRyuu.FamilyC.FamilyC")
/*    */   public static FamilyC proxy;
/*    */   
/*    */   private String getVersion() {
/* 37 */     return "1.2.18";
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @Instance("mod_FamilyC")
/* 46 */   public static mod_FamilyC instance = new mod_FamilyC();
/* 47 */   private FamilyCGuiHandler guiHandler = new FamilyCGuiHandler();
/*    */   
/*    */   @EventHandler
/*    */   public void ServerStarting(FMLServerStartingEvent event) {
/* 51 */     ServerCommandManager manager = (ServerCommandManager)event.getServer().func_71187_D();
/* 52 */     manager.func_71560_a((ICommand)new FamilyCComJFCGen());
/* 53 */     manager.func_71560_a((ICommand)new FamilyCComJFCsoc());
/*    */   }
/*    */   
/* 56 */   public static Properties runtimeIdProperties = new Properties();
/*    */ 
/*    */ 
/*    */   
/*    */   public static Logger logger;
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void PreLoad(FMLPreInitializationEvent event) {
/* 66 */     logger = event.getModLog();
/* 67 */     logger.info("Current Version " + getVersion());
/* 68 */     logger.info("Copyright (c) Tamas 'JinRyuu' Nagy,  2012-" + (new SimpleDateFormat("yyyy")).format(new Date()) + "");
/* 69 */     logger.info("https://jingames.net");
/*    */     
/* 71 */     proxy.registerKeys();
/* 72 */     proxy.registerTicks();
/*    */ 
/*    */     
/* 75 */     Configuration config = new Configuration(event.getSuggestedConfigurationFile());
/* 76 */     FamilyCConfig.init(config);
/*    */ 
/*    */     
/* 79 */     instance = this;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void load(FMLInitializationEvent event) {
/* 87 */     EntityRegistry.registerModEntity(EntityNPC.class, "Child", 1, instance, 80, 5, true);
/*    */     
/* 89 */     NetworkRegistry.INSTANCE.registerGuiHandler(this, this.guiHandler);
/* 90 */     proxy.registerRenderThings();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @EventHandler
/*    */   public void PostLoad(FMLPostInitializationEvent event) {
/* 98 */     proxy.postInit();
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JFamilyC-v1.2.18.jar!\JinRyuu\FamilyC\mod_FamilyC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */