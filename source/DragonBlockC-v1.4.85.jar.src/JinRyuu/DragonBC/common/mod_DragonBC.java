/*     */ package JinRyuu.DragonBC.common;
/*     */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*     */ import JinRyuu.DragonBC.common.Gui.ComDbc;
/*     */ import JinRyuu.DragonBC.common.Gui.ComDbcSpawn;
/*     */ import JinRyuu.DragonBC.common.Gui.ComDbcSpawnKi;
/*     */ import JinRyuu.DragonBC.common.Gui.ComReincarnate;
/*     */ import JinRyuu.DragonBC.common.Gui.ComRespCon;
/*     */ import JinRyuu.DragonBC.common.Gui.ComRevive;
/*     */ import JinRyuu.DragonBC.common.Gui.ComSkill;
/*     */ import JinRyuu.DragonBC.common.Gui.ComStrain;
/*     */ import JinRyuu.DragonBC.common.Gui.DBCGuiHandler;
/*     */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*     */ import JinRyuu.DragonBC.common.Npcs.EntitiesDBC;
/*     */ import JinRyuu.DragonBC.common.Worlds.BiomeGenBaseDBC;
/*     */ import JinRyuu.DragonBC.common.Worlds.Dimension.NullRealm.x2WorldProviderNullRealm;
/*     */ import JinRyuu.DragonBC.common.Worlds.WorldGeneratorDB;
/*     */ import JinRyuu.DragonBC.common.Worlds.x0WorldProviderNamek;
/*     */ import JinRyuu.DragonBC.common.Worlds.x1WorldProviderOW;
/*     */ import JinRyuu.DragonBC.common.Worlds.x2WorldProviderTC;
/*     */ import JinRyuu.DragonBC.common.Worlds.x3WorldProviderVegeta;
/*     */ import JinRyuu.JRMCore.entity.EntityEnergyAtt;
/*     */ import JinRyuu.JRMCore.entity.EntityPrjtls_1;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.IWorldGenerator;
/*     */ import cpw.mods.fml.common.Mod;
/*     */ import cpw.mods.fml.common.Mod.EventHandler;
/*     */ import cpw.mods.fml.common.Mod.Instance;
/*     */ import cpw.mods.fml.common.ModMetadata;
/*     */ import cpw.mods.fml.common.SidedProxy;
/*     */ import cpw.mods.fml.common.event.FMLInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLPostInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLServerStartingEvent;
/*     */ import cpw.mods.fml.common.network.IGuiHandler;
/*     */ import cpw.mods.fml.common.network.NetworkRegistry;
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Date;
/*     */ import java.util.Properties;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.command.ServerCommandManager;
/*     */ import net.minecraft.creativetab.CreativeTabs;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EntityDamageSourceIndirect;
/*     */ import net.minecraftforge.common.DimensionManager;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ import net.minecraftforge.common.config.Configuration;
/*     */ import net.minecraftforge.fluids.FluidContainerRegistry;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ @Mod(modid = "jinryuudragonblockc", name = "Dragon Block C", version = "1.4.85", dependencies = "required-after:jinryuujrmcore")
/*     */ public class mod_DragonBC {
/*     */   private String getVersion() {
/*  58 */     return "1.4.85";
/*     */   }
/*     */   
/*     */   public static final String MOD = "Dragon Block C";
/*  62 */   public static CreativeTabs DragonBlockC = new DBCTab("DragonBlockC");
/*     */   
/*     */   @SidedProxy(clientSide = "JinRyuu.DragonBC.common.DBCClient", serverSide = "JinRyuu.DragonBC.common.DBC")
/*     */   public static DBC proxy;
/*     */   
/*     */   @Instance("mod_DragonBC")
/*  68 */   public static mod_DragonBC instance = new mod_DragonBC();
/*  69 */   private DBCGuiHandler guiHandler = new DBCGuiHandler();
/*     */   
/*     */   public static boolean DeathSystemOff = false;
/*     */   
/*  73 */   public static int DBSpawnChance = 4;
/*     */   public static boolean DBSpawnEnabled = true;
/*  75 */   public static String DBSpawnTime = "daytime";
/*     */   
/*     */   public static boolean SagaSystemOn = true;
/*     */   public static boolean SagaSysSpawnPods = true;
/*     */   public static boolean cDeathSystemOff = false;
/*  80 */   public static int cDBSpawnChance = 4;
/*     */   public static boolean cDBSpawnEnabled = true;
/*  82 */   public static String cDBSpawnTime = "daytime";
/*     */   public static boolean cSagaSystemOn = true;
/*     */   public static boolean cSagaSysSpawnPods = true;
/*  85 */   public static int cwfb = 0;
/*  86 */   public static int chfb = 0;
/*  87 */   public static int cwfn = 0;
/*  88 */   public static int chfn = 0;
/*     */   
/*     */   public static boolean ConsSizeChangeOn = true;
/*     */   
/*     */   public static boolean TransSizeChangeOn = true;
/*     */   
/*     */   public static DamageSource causePrjctlsDamage(EntityPrjtls_1 entityEnergyAtt, Entity par1Entity) {
/*  95 */     return (new EntityDamageSourceIndirect("dbcprojectile_1", (Entity)entityEnergyAtt, par1Entity)).func_76349_b();
/*     */   }
/*     */   
/*     */   public static DamageSource causeEntityEnergyAttDamage(EntityEnergyAtt entityEnergyAtt, Entity par1Entity) {
/*  99 */     return (new EntityDamageSourceIndirect("Energy Attack", (Entity)entityEnergyAtt, par1Entity)).func_76349_b();
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void ServerStarting(FMLServerStartingEvent event) {
/* 105 */     ServerCommandManager manager = (ServerCommandManager)event.getServer().func_71187_D();
/* 106 */     manager.func_71560_a((ICommand)new ComRespCon());
/* 107 */     manager.func_71560_a((ICommand)new ComDbc());
/* 108 */     manager.func_71560_a((ICommand)new ComDbcSpawn());
/* 109 */     manager.func_71560_a((ICommand)new ComRevive());
/* 110 */     manager.func_71560_a((ICommand)new ComSkill());
/* 111 */     manager.func_71560_a((ICommand)new ComStrain());
/* 112 */     manager.func_71560_a((ICommand)new ComReincarnate());
/* 113 */     manager.func_71560_a((ICommand)new ComDbcSpawnKi());
/*     */   }
/*     */   
/* 116 */   public static Properties runtimeIdProperties = new Properties(); public static Logger logger;
/*     */   
/*     */   private void modMeta(FMLPreInitializationEvent event) {
/* 119 */     ModMetadata meta = event.getModMetadata();
/* 120 */     meta.name = "Dragon Block C";
/* 121 */     meta.description = "A Dragon Ball mod for Minecraft.";
/* 122 */     meta.authorList.clear();
/* 123 */     meta.authorList.add("JinRyuu Nagy");
/*     */     
/* 125 */     meta.modId = "jinryuudragonblockc";
/* 126 */     meta.version = "1.4.85";
/* 127 */     meta.autogenerated = false;
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void PreLoad(FMLPreInitializationEvent event) {
/* 133 */     modMeta(event);
/*     */     
/* 135 */     logger = event.getModLog();
/* 136 */     logger.info("Current Version " + getVersion());
/* 137 */     logger.info("Copyright (c) Tamas 'JinRyuu' Nagy,  2012-2018");
/* 138 */     logger.info("Copyright (c) Benjamin 'JinGames_Ben' Nagy,  2018-" + (new SimpleDateFormat("yyyy")).format(new Date()) + "");
/*     */     
/* 140 */     logger.info("https://jingames.net");
/*     */     
/* 142 */     Configuration config = new Configuration(event.getSuggestedConfigurationFile());
/* 143 */     DBCConfig.init(config);
/*     */     
/* 145 */     proxy.registerKeys();
/* 146 */     proxy.registerTicks();
/* 147 */     proxy.registerDBCRender();
/* 148 */     proxy.initialize();
/*     */ 
/*     */     
/* 151 */     logger.info("Pre Initialization Complated");
/*     */     
/* 153 */     instance = this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void load(FMLInitializationEvent event) {
/* 161 */     BlocksDBC.init();
/* 162 */     BlocksDBC.register();
/* 163 */     ItemsDBC.init();
/* 164 */     RecipesDBC.init();
/*     */     
/* 166 */     DBCEH events = new DBCEH();
/* 167 */     MinecraftForge.EVENT_BUS.register(events);
/* 168 */     FMLCommonHandler.instance().bus().register(events);
/*     */     
/* 170 */     GameRegistry.registerFuelHandler(new DBCHandlerFuel());
/* 171 */     FluidContainerRegistry.registerFluidContainer(BlocksDBC.medicalLiquid, new ItemStack(ItemsDBC.ItemBucketMedLiq), new ItemStack(Items.field_151133_ar));
/*     */     
/* 173 */     DBCHandlerBucket.INSTANCE.buckets.put(BlocksDBC.BlockHealingPods, ItemsDBC.ItemBucketMedLiq);
/* 174 */     MinecraftForge.EVENT_BUS.register(DBCHandlerBucket.INSTANCE);
/*     */     
/* 176 */     BiomeGenBaseDBC.init();
/* 177 */     GameRegistry.registerWorldGenerator((IWorldGenerator)new WorldGeneratorDB(), 0);
/* 178 */     DimensionManager.registerProviderType(DBCConfig.planetNamek, x0WorldProviderNamek.class, true);
/* 179 */     DimensionManager.registerDimension(DBCConfig.planetNamek, DBCConfig.planetNamek);
/*     */     
/* 181 */     Side side = event.getSide();
/* 182 */     if (side == Side.CLIENT || DBCConfig.plntVegeta) {
/* 183 */       DimensionManager.registerProviderType(DBCConfig.planetVegeta, x3WorldProviderVegeta.class, true);
/* 184 */       DimensionManager.registerDimension(DBCConfig.planetVegeta, DBCConfig.planetVegeta);
/*     */     } 
/*     */     
/* 187 */     int dimID = DBCConfig.otherWorld;
/* 188 */     DimensionManager.registerProviderType(dimID, x1WorldProviderOW.class, true);
/* 189 */     DimensionManager.registerDimension(dimID, dimID);
/*     */     
/* 191 */     dimID = DBCConfig.dimTimeChamber;
/* 192 */     DimensionManager.registerProviderType(dimID, x2WorldProviderTC.class, true);
/* 193 */     DimensionManager.registerDimension(dimID, dimID);
/*     */     
/* 195 */     dimID = DBCConfig.dimNullRealm;
/* 196 */     DimensionManager.registerProviderType(dimID, x2WorldProviderNullRealm.class, true);
/* 197 */     DimensionManager.registerDimension(dimID, dimID);
/*     */     
/* 199 */     Lang.init();
/*     */     
/* 201 */     logger.info("Initialization Completed");
/*     */     
/* 203 */     EntitiesDBC.common();
/* 204 */     logger.info(" Entities Loaded!");
/*     */     
/* 206 */     NetworkRegistry.INSTANCE.registerGuiHandler(this, (IGuiHandler)this.guiHandler);
/*     */     
/* 208 */     proxy.registerRenderThings();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void PostLoad(FMLPostInitializationEvent event) {
/* 215 */     proxy.postInit();
/* 216 */     logger.info("Fully Loaded!");
/* 217 */     logger.info("Have a good game!");
/* 218 */     logger.info("Fight For Your Life ^^");
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\mod_DragonBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */