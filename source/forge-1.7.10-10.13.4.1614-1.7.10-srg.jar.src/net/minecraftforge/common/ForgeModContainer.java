/*     */ package net.minecraftforge.common;
/*     */ 
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.eventbus.EventBus;
/*     */ import com.google.common.eventbus.Subscribe;
/*     */ import cpw.mods.fml.client.FMLFileResourcePack;
/*     */ import cpw.mods.fml.client.FMLFolderResourcePack;
/*     */ import cpw.mods.fml.client.event.ConfigChangedEvent;
/*     */ import cpw.mods.fml.common.DummyModContainer;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.LoadController;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import cpw.mods.fml.common.ModMetadata;
/*     */ import cpw.mods.fml.common.WorldAccessContainer;
/*     */ import cpw.mods.fml.common.event.FMLConstructionEvent;
/*     */ import cpw.mods.fml.common.event.FMLLoadCompleteEvent;
/*     */ import cpw.mods.fml.common.event.FMLModIdMappingEvent;
/*     */ import cpw.mods.fml.common.event.FMLPostInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLServerStartingEvent;
/*     */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*     */ import cpw.mods.fml.common.gameevent.PlayerEvent;
/*     */ import cpw.mods.fml.common.network.NetworkRegistry;
/*     */ import java.io.File;
/*     */ import java.security.cert.Certificate;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.world.storage.SaveHandler;
/*     */ import net.minecraft.world.storage.WorldInfo;
/*     */ import net.minecraftforge.classloading.FMLForgePlugin;
/*     */ import net.minecraftforge.common.config.Configuration;
/*     */ import net.minecraftforge.common.config.Property;
/*     */ import net.minecraftforge.common.network.ForgeNetworkHandler;
/*     */ import net.minecraftforge.fluids.FluidRegistry;
/*     */ import net.minecraftforge.oredict.OreDictionary;
/*     */ import net.minecraftforge.oredict.RecipeSorter;
/*     */ import net.minecraftforge.server.command.ForgeCommand;
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
/*     */ 
/*     */ public class ForgeModContainer
/*     */   extends DummyModContainer
/*     */   implements WorldAccessContainer
/*     */ {
/*  61 */   public static int clumpingThreshold = 64;
/*     */   public static boolean removeErroringEntities = false;
/*     */   public static boolean removeErroringTileEntities = false;
/*     */   public static boolean disableStitchedFileSaving = false;
/*     */   public static boolean fullBoundingBoxLadders = false;
/*  66 */   public static double zombieSummonBaseChance = 0.1D;
/*  67 */   public static int[] blendRanges = new int[] { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34 };
/*  68 */   public static float zombieBabyChance = 0.05F;
/*     */   public static boolean shouldSortRecipies = true;
/*     */   public static boolean disableVersionCheck = false;
/*  71 */   public static int defaultSpawnFuzz = 20;
/*     */   
/*     */   public static boolean defaultHasSpawnFuzz = true;
/*     */   
/*     */   private static Configuration config;
/*     */   
/*     */   public ForgeModContainer() {
/*  78 */     super(new ModMetadata());
/*  79 */     ModMetadata meta = getMetadata();
/*  80 */     meta.modId = "Forge";
/*  81 */     meta.name = "Minecraft Forge";
/*  82 */     meta.version = String.format("%d.%d.%d.%d", new Object[] { Integer.valueOf(10), Integer.valueOf(13), Integer.valueOf(4), Integer.valueOf(1614) });
/*  83 */     meta.credits = "Made possible with help from many people";
/*  84 */     meta.authorList = Arrays.asList(new String[] { "LexManos", "Eloraam", "Spacetoad" });
/*  85 */     meta.description = "Minecraft Forge is a common open source API allowing a broad range of mods to work cooperatively together. It allows many mods to be created without them editing the main Minecraft code.";
/*     */ 
/*     */     
/*  88 */     meta.url = "http://MinecraftForge.net";
/*  89 */     meta.updateUrl = "http://MinecraftForge.net/forum/index.php/topic,5.0.html";
/*  90 */     meta.screenshots = new String[0];
/*  91 */     meta.logoFile = "/forge_logo.png";
/*     */     
/*  93 */     config = null;
/*  94 */     File cfgFile = new File(Loader.instance().getConfigDir(), "forge.cfg");
/*  95 */     config = new Configuration(cfgFile);
/*     */     
/*  97 */     syncConfig(true);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getGuiClassName() {
/* 103 */     return "net.minecraftforge.client.gui.ForgeGuiFactory";
/*     */   }
/*     */ 
/*     */   
/*     */   public static Configuration getConfig() {
/* 108 */     return config;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void syncConfig(boolean load) {
/* 118 */     List<String> propOrder = new ArrayList<String>();
/*     */     
/* 120 */     if (!config.isChild) {
/*     */       
/* 122 */       if (load)
/*     */       {
/* 124 */         config.load();
/*     */       }
/* 126 */       Property enableGlobalCfg = config.get("general", "enableGlobalConfig", false).setShowInGui(false);
/* 127 */       if (enableGlobalCfg.getBoolean(false))
/*     */       {
/* 129 */         Configuration.enableGlobalConfig();
/*     */       }
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 135 */     Property prop = config.get("general", "disableVersionCheck", false);
/* 136 */     prop.comment = "Set to true to disable Forge's version check mechanics. Forge queries a small json file on our server for version information. For more details see the ForgeVersion class in our github.";
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 141 */     prop.setLanguageKey("forge.configgui.disableVersionCheck");
/* 142 */     disableVersionCheck = prop.getBoolean(disableVersionCheck);
/* 143 */     propOrder.add(prop.getName());
/*     */     
/* 145 */     prop = config.get("general", "clumpingThreshold", 64, "Controls the number threshold at which Packet51 is preferred over Packet52, default and minimum 64, maximum 1024", 64, 1024);
/*     */     
/* 147 */     prop.setLanguageKey("forge.configgui.clumpingThreshold").setRequiresWorldRestart(true);
/* 148 */     clumpingThreshold = prop.getInt(64);
/* 149 */     if (clumpingThreshold > 1024 || clumpingThreshold < 64) {
/*     */       
/* 151 */       clumpingThreshold = 64;
/* 152 */       prop.set(64);
/*     */     } 
/* 154 */     propOrder.add(prop.getName());
/*     */     
/* 156 */     prop = config.get("general", "sortRecipies", true);
/* 157 */     prop.comment = "Set to true to enable the post initialization sorting of crafting recipes using Forge's sorter. May cause desyncing on conflicting recipies. MUST RESTART MINECRAFT IF CHANGED FROM THE CONFIG GUI.";
/* 158 */     prop.setLanguageKey("forge.configgui.sortRecipies").setRequiresMcRestart(true);
/* 159 */     shouldSortRecipies = prop.getBoolean(shouldSortRecipies);
/* 160 */     propOrder.add(prop.getName());
/*     */     
/* 162 */     prop = config.get("general", "removeErroringEntities", false);
/* 163 */     prop.comment = "Set this to true to remove any Entity that throws an error in its update method instead of closing the server and reporting a crash log. BE WARNED THIS COULD SCREW UP EVERYTHING USE SPARINGLY WE ARE NOT RESPONSIBLE FOR DAMAGES.";
/* 164 */     prop.setLanguageKey("forge.configgui.removeErroringEntities").setRequiresWorldRestart(true);
/* 165 */     removeErroringEntities = prop.getBoolean(false);
/* 166 */     propOrder.add(prop.getName());
/*     */     
/* 168 */     if (removeErroringEntities)
/*     */     {
/* 170 */       FMLLog.warning("Enabling removal of erroring Entities - USE AT YOUR OWN RISK", new Object[0]);
/*     */     }
/*     */     
/* 173 */     prop = config.get("general", "removeErroringTileEntities", false);
/* 174 */     prop.comment = "Set this to true to remove any TileEntity that throws an error in its update method instead of closing the server and reporting a crash log. BE WARNED THIS COULD SCREW UP EVERYTHING USE SPARINGLY WE ARE NOT RESPONSIBLE FOR DAMAGES.";
/* 175 */     prop.setLanguageKey("forge.configgui.removeErroringTileEntities").setRequiresWorldRestart(true);
/* 176 */     removeErroringTileEntities = prop.getBoolean(false);
/* 177 */     propOrder.add(prop.getName());
/*     */     
/* 179 */     if (removeErroringTileEntities)
/*     */     {
/* 181 */       FMLLog.warning("Enabling removal of erroring Tile Entities - USE AT YOUR OWN RISK", new Object[0]);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 188 */     prop = config.get("general", "fullBoundingBoxLadders", false);
/* 189 */     prop.comment = "Set this to true to check the entire entity's collision bounding box for ladders instead of just the block they are in. Causes noticable differences in mechanics so default is vanilla behavior. Default: false";
/* 190 */     prop.setLanguageKey("forge.configgui.fullBoundingBoxLadders").setRequiresWorldRestart(true);
/* 191 */     fullBoundingBoxLadders = prop.getBoolean(false);
/* 192 */     propOrder.add(prop.getName());
/*     */     
/* 194 */     prop = config.get("general", "biomeSkyBlendRange", new int[] { 2, 4, 6, 8, 10, 12, 14, 16, 18, 20, 22, 24, 26, 28, 30, 32, 34 });
/* 195 */     prop.comment = "Control the range of sky blending for colored skies in biomes.";
/* 196 */     prop.setLanguageKey("forge.configgui.biomeSkyBlendRange");
/* 197 */     blendRanges = prop.getIntList();
/* 198 */     propOrder.add(prop.getName());
/*     */     
/* 200 */     prop = config.get("general", "zombieBaseSummonChance", 0.1D, "Base zombie summoning spawn chance. Allows changing the bonus zombie summoning mechanic.", 0.0D, 1.0D);
/*     */     
/* 202 */     prop.setLanguageKey("forge.configgui.zombieBaseSummonChance").setRequiresWorldRestart(true);
/* 203 */     zombieSummonBaseChance = prop.getDouble(0.1D);
/* 204 */     propOrder.add(prop.getName());
/*     */     
/* 206 */     prop = config.get("general", "zombieBabyChance", 0.05D, "Chance that a zombie (or subclass) is a baby. Allows changing the zombie spawning mechanic.", 0.0D, 1.0D);
/*     */     
/* 208 */     prop.setLanguageKey("forge.configgui.zombieBabyChance").setRequiresWorldRestart(true);
/* 209 */     zombieBabyChance = (float)prop.getDouble(0.05D);
/* 210 */     propOrder.add(prop.getName());
/*     */     
/* 212 */     prop = config.get("general", "defaultSpawnFuzz", 20, "The spawn fuzz when a player respawns in the world, this is controlable by WorldType, this config option is for the default overworld.", 1, 2147483647);
/*     */ 
/*     */     
/* 215 */     prop.setLanguageKey("forge.configgui.spawnfuzz").setRequiresWorldRestart(false);
/* 216 */     defaultSpawnFuzz = prop.getInt(20);
/* 217 */     propOrder.add(prop.getName());
/*     */     
/* 219 */     prop = config.get("general", "spawnHasFuzz", Boolean.TRUE.booleanValue(), "If the overworld has ANY spawn fuzz at all. If not, the spawn will always be the exact same location.");
/*     */     
/* 221 */     prop.setLanguageKey("forge.configgui.hasspawnfuzz").setRequiresWorldRestart(false);
/* 222 */     defaultHasSpawnFuzz = prop.getBoolean(Boolean.TRUE.booleanValue());
/* 223 */     propOrder.add(prop.getName());
/*     */     
/* 225 */     config.setCategoryPropertyOrder("general", propOrder);
/*     */     
/* 227 */     if (config.hasChanged())
/*     */     {
/* 229 */       config.save();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent event) {
/* 240 */     if ((getMetadata()).modId.equals(event.modID) && !event.isWorldRunning)
/*     */     {
/* 242 */       if ("general".equals(event.configID)) {
/*     */         
/* 244 */         syncConfig(false);
/*     */       }
/* 246 */       else if ("chunkLoader".equals(event.configID)) {
/*     */         
/* 248 */         ForgeChunkManager.syncConfigDefaults();
/* 249 */         ForgeChunkManager.loadConfiguration();
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @SubscribeEvent
/*     */   public void playerLogin(PlayerEvent.PlayerLoggedInEvent event) {
/* 257 */     UsernameCache.setUsername(event.player.getGameProfile().getId(), event.player.getGameProfile().getName());
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean registerBus(EventBus bus, LoadController controller) {
/* 263 */     bus.register(this);
/* 264 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   @Subscribe
/*     */   public void modConstruction(FMLConstructionEvent evt) {
/* 270 */     NetworkRegistry.INSTANCE.register((ModContainer)this, getClass(), "*", evt.getASMHarvestedData());
/* 271 */     ForgeNetworkHandler.registerChannel(this, evt.getSide());
/*     */   }
/*     */ 
/*     */   
/*     */   @Subscribe
/*     */   public void preInit(FMLPreInitializationEvent evt) {
/* 277 */     MinecraftForge.EVENT_BUS.register(MinecraftForge.INTERNAL_HANDLER);
/* 278 */     ForgeChunkManager.captureConfig(evt.getModConfigurationDirectory());
/* 279 */     FMLCommonHandler.instance().bus().register(this);
/*     */     
/* 281 */     if (!disableVersionCheck)
/*     */     {
/* 283 */       ForgeVersion.startVersionCheck();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   @Subscribe
/*     */   public void postInit(FMLPostInitializationEvent evt) {
/* 290 */     BiomeDictionary.registerAllBiomesAndGenerateEvents();
/* 291 */     ForgeChunkManager.loadConfiguration();
/*     */   }
/*     */ 
/*     */   
/*     */   @Subscribe
/*     */   public void onAvailable(FMLLoadCompleteEvent evt) {
/* 297 */     if (shouldSortRecipies)
/*     */     {
/* 299 */       RecipeSorter.sortCraftManager();
/*     */     }
/* 301 */     FluidRegistry.validateFluidRegistry();
/*     */   }
/*     */ 
/*     */   
/*     */   @Subscribe
/*     */   public void serverStarting(FMLServerStartingEvent evt) {
/* 307 */     evt.registerServerCommand((ICommand)new ForgeCommand(evt.getServer()));
/*     */   }
/*     */ 
/*     */   
/*     */   public NBTTagCompound getDataForWriting(SaveHandler handler, WorldInfo info) {
/* 312 */     NBTTagCompound forgeData = new NBTTagCompound();
/* 313 */     NBTTagCompound dimData = DimensionManager.saveDimensionDataMap();
/* 314 */     forgeData.setTag("DimensionData", (NBTBase)dimData);
/* 315 */     FluidRegistry.writeDefaultFluidList(forgeData);
/* 316 */     return forgeData;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void readData(SaveHandler handler, WorldInfo info, Map<String, NBTBase> propertyMap, NBTTagCompound tag) {
/* 322 */     DimensionManager.loadDimensionDataMap(tag.hasKey("DimensionData") ? tag.getCompoundTag("DimensionData") : null);
/* 323 */     FluidRegistry.loadFluidDefaults(tag);
/*     */   }
/*     */ 
/*     */   
/*     */   @Subscribe
/*     */   public void mappingChanged(FMLModIdMappingEvent evt) {
/* 329 */     Blocks.fire.rebuildFireInfo();
/* 330 */     OreDictionary.rebakeMap();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public File getSource() {
/* 337 */     return FMLForgePlugin.forgeLocation;
/*     */   }
/*     */ 
/*     */   
/*     */   public Class<?> getCustomResourcePackClass() {
/* 342 */     if (getSource().isDirectory())
/*     */     {
/* 344 */       return FMLFolderResourcePack.class;
/*     */     }
/*     */ 
/*     */     
/* 348 */     return FMLFileResourcePack.class;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getOwnedPackages() {
/* 357 */     return (List<String>)ImmutableList.of("net.minecraftforge.classloading", "net.minecraftforge.client", "net.minecraftforge.client.event", "net.minecraftforge.client.event.sound", "net.minecraftforge.client.model", "net.minecraftforge.client.model.obj", "net.minecraftforge.client.model.techne", "net.minecraftforge.common", "net.minecraftforge.common.config", "net.minecraftforge.common.network", "net.minecraftforge.common.util", "net.minecraftforge.event", (Object[])new String[] { "net.minecraftforge.event.brewing", "net.minecraftforge.event.entity", "net.minecraftforge.event.entity.item", "net.minecraftforge.event.entity.living", "net.minecraftforge.event.entity.minecart", "net.minecraftforge.event.entity.player", "net.minecraftforge.event.terraingen", "net.minecraftforge.event.world", "net.minecraftforge.fluids", "net.minecraftforge.oredict", "net.minecraftforge.server", "net.minecraftforge.server.command", "net.minecraftforge.transformers" });
/*     */   }
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
/*     */   
/*     */   public Certificate getSigningCertificate() {
/* 391 */     Certificate[] certificates = getClass().getProtectionDomain().getCodeSource().getCertificates();
/* 392 */     return (certificates != null) ? certificates[0] : null;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\ForgeModContainer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */