/*      */ package cpw.mods.fml.client;
/*      */ 
/*      */ import com.google.common.base.CharMatcher;
/*      */ import com.google.common.base.Strings;
/*      */ import com.google.common.base.Throwables;
/*      */ import com.google.common.collect.BiMap;
/*      */ import com.google.common.collect.HashBasedTable;
/*      */ import com.google.common.collect.HashBiMap;
/*      */ import com.google.common.collect.HashMultimap;
/*      */ import com.google.common.collect.ImmutableList;
/*      */ import com.google.common.collect.ImmutableMap;
/*      */ import com.google.common.collect.Maps;
/*      */ import com.google.common.collect.SetMultimap;
/*      */ import com.google.common.collect.Sets;
/*      */ import com.google.common.collect.Table;
/*      */ import com.google.gson.JsonArray;
/*      */ import com.google.gson.JsonElement;
/*      */ import com.google.gson.JsonObject;
/*      */ import cpw.mods.fml.client.registry.RenderingRegistry;
/*      */ import cpw.mods.fml.common.DummyModContainer;
/*      */ import cpw.mods.fml.common.DuplicateModsFoundException;
/*      */ import cpw.mods.fml.common.FMLCommonHandler;
/*      */ import cpw.mods.fml.common.FMLContainerHolder;
/*      */ import cpw.mods.fml.common.FMLLog;
/*      */ import cpw.mods.fml.common.IFMLSidedHandler;
/*      */ import cpw.mods.fml.common.Loader;
/*      */ import cpw.mods.fml.common.LoaderException;
/*      */ import cpw.mods.fml.common.MetadataCollection;
/*      */ import cpw.mods.fml.common.MissingModsException;
/*      */ import cpw.mods.fml.common.ModContainer;
/*      */ import cpw.mods.fml.common.ModMetadata;
/*      */ import cpw.mods.fml.common.ObfuscationReflectionHelper;
/*      */ import cpw.mods.fml.common.StartupQuery;
/*      */ import cpw.mods.fml.common.WrongMinecraftVersionException;
/*      */ import cpw.mods.fml.common.eventhandler.Event;
/*      */ import cpw.mods.fml.common.eventhandler.EventBus;
/*      */ import cpw.mods.fml.common.network.FMLNetworkEvent;
/*      */ import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
/*      */ import cpw.mods.fml.common.registry.GameData;
/*      */ import cpw.mods.fml.common.registry.LanguageRegistry;
/*      */ import cpw.mods.fml.common.toposort.ModSortingException;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import java.io.File;
/*      */ import java.io.FileInputStream;
/*      */ import java.lang.ref.WeakReference;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collections;
/*      */ import java.util.List;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import java.util.concurrent.CountDownLatch;
/*      */ import java.util.concurrent.TimeUnit;
/*      */ import net.minecraft.client.Minecraft;
/*      */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*      */ import net.minecraft.client.gui.Gui;
/*      */ import net.minecraft.client.gui.GuiIngameMenu;
/*      */ import net.minecraft.client.gui.GuiMainMenu;
/*      */ import net.minecraft.client.gui.GuiScreen;
/*      */ import net.minecraft.client.gui.GuiSelectWorld;
/*      */ import net.minecraft.client.gui.ScaledResolution;
/*      */ import net.minecraft.client.gui.ServerListEntryNormal;
/*      */ import net.minecraft.client.multiplayer.GuiConnecting;
/*      */ import net.minecraft.client.multiplayer.ServerData;
/*      */ import net.minecraft.client.multiplayer.WorldClient;
/*      */ import net.minecraft.client.network.NetHandlerPlayClient;
/*      */ import net.minecraft.client.network.OldServerPinger;
/*      */ import net.minecraft.client.renderer.entity.RenderManager;
/*      */ import net.minecraft.client.resources.AbstractResourcePack;
/*      */ import net.minecraft.client.resources.FallbackResourceManager;
/*      */ import net.minecraft.client.resources.IReloadableResourceManager;
/*      */ import net.minecraft.client.resources.IResourcePack;
/*      */ import net.minecraft.client.resources.SimpleReloadableResourceManager;
/*      */ import net.minecraft.crash.CrashReport;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.launchwrapper.Launch;
/*      */ import net.minecraft.nbt.CompressedStreamTools;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.network.INetHandler;
/*      */ import net.minecraft.network.NetHandlerPlayServer;
/*      */ import net.minecraft.network.NetworkManager;
/*      */ import net.minecraft.network.ServerStatusResponse;
/*      */ import net.minecraft.server.MinecraftServer;
/*      */ import net.minecraft.util.ResourceLocation;
/*      */ import net.minecraft.util.StringUtils;
/*      */ import net.minecraft.world.WorldSettings;
/*      */ import net.minecraft.world.storage.SaveFormatOld;
/*      */ import org.apache.logging.log4j.Level;
/*      */ import org.apache.logging.log4j.LogManager;
/*      */ import org.apache.logging.log4j.Logger;
/*      */ import org.lwjgl.LWJGLUtil;
/*      */ import org.lwjgl.input.Mouse;
/*      */ import org.lwjgl.opengl.Display;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class FMLClientHandler
/*      */   implements IFMLSidedHandler
/*      */ {
/*  139 */   private static final FMLClientHandler INSTANCE = new FMLClientHandler();
/*      */ 
/*      */   
/*      */   private Minecraft client;
/*      */ 
/*      */   
/*      */   private DummyModContainer optifineContainer;
/*      */ 
/*      */   
/*      */   private boolean guiLoaded;
/*      */ 
/*      */   
/*      */   private boolean serverIsRunning;
/*      */ 
/*      */   
/*      */   private MissingModsException modsMissing;
/*      */ 
/*      */   
/*      */   private ModSortingException modSorting;
/*      */ 
/*      */   
/*      */   private boolean loading = true;
/*      */ 
/*      */   
/*      */   private WrongMinecraftVersionException wrongMC;
/*      */ 
/*      */   
/*      */   private CustomModLoadingErrorDisplayException customError;
/*      */ 
/*      */   
/*      */   private DuplicateModsFoundException dupesFound;
/*      */ 
/*      */   
/*      */   private boolean serverShouldBeKilledQuietly;
/*      */ 
/*      */   
/*      */   private List<IResourcePack> resourcePackList;
/*      */ 
/*      */   
/*      */   private IReloadableResourceManager resourceManager;
/*      */   
/*      */   private Map<String, IResourcePack> resourcePackMap;
/*      */   
/*      */   private BiMap<ModContainer, IModGuiFactory> guiFactories;
/*      */   
/*      */   private Map<ServerStatusResponse, JsonObject> extraServerListData;
/*      */   
/*      */   private Map<ServerData, ExtendedServerListData> serverDataTag;
/*      */   
/*      */   private WeakReference<NetHandlerPlayClient> currentPlayClient;
/*      */ 
/*      */   
/*      */   public void beginMinecraftLoading(Minecraft minecraft, List<IResourcePack> resourcePackList, IReloadableResourceManager resourceManager) {
/*  192 */     detectOptifine();
/*  193 */     SplashProgress.start();
/*  194 */     this.client = minecraft;
/*  195 */     this.resourcePackList = resourcePackList;
/*  196 */     this.resourceManager = resourceManager;
/*  197 */     this.resourcePackMap = Maps.newHashMap();
/*  198 */     if (minecraft.isDemo()) {
/*      */       
/*  200 */       FMLLog.severe("DEMO MODE DETECTED, FML will not work. Finishing now.", new Object[0]);
/*  201 */       haltGame("FML will not run in demo mode", new RuntimeException());
/*      */       
/*      */       return;
/*      */     } 
/*  205 */     FMLCommonHandler.instance().beginLoading(this);
/*      */     
/*      */     try {
/*  208 */       Loader.instance().loadMods();
/*      */     }
/*  210 */     catch (WrongMinecraftVersionException wrong) {
/*      */       
/*  212 */       this.wrongMC = wrong;
/*      */     }
/*  214 */     catch (DuplicateModsFoundException dupes) {
/*      */       
/*  216 */       this.dupesFound = dupes;
/*      */     }
/*  218 */     catch (MissingModsException missing) {
/*      */       
/*  220 */       this.modsMissing = missing;
/*      */     }
/*  222 */     catch (ModSortingException sorting) {
/*      */       
/*  224 */       this.modSorting = sorting;
/*      */     }
/*  226 */     catch (CustomModLoadingErrorDisplayException custom) {
/*      */       
/*  228 */       FMLLog.log(Level.ERROR, (Throwable)custom, "A custom exception was thrown by a mod, the game will now halt", new Object[0]);
/*  229 */       this.customError = custom;
/*      */     }
/*  231 */     catch (LoaderException le) {
/*      */       
/*  233 */       haltGame("There was a severe problem during mod loading that has caused the game to fail", (Throwable)le);
/*      */ 
/*      */       
/*      */       return;
/*      */     } finally {
/*  238 */       this.client.refreshResources();
/*      */     } 
/*      */ 
/*      */     
/*      */     try {
/*  243 */       Loader.instance().preinitializeMods();
/*      */     }
/*  245 */     catch (CustomModLoadingErrorDisplayException custom) {
/*      */       
/*  247 */       FMLLog.log(Level.ERROR, (Throwable)custom, "A custom exception was thrown by a mod, the game will now halt", new Object[0]);
/*  248 */       this.customError = custom;
/*      */     }
/*  250 */     catch (LoaderException le) {
/*      */       
/*  252 */       haltGame("There was a severe problem during mod loading that has caused the game to fail", (Throwable)le);
/*      */       return;
/*      */     } 
/*  255 */     Map<String, Map<String, String>> sharedModList = (Map<String, Map<String, String>>)Launch.blackboard.get("modList");
/*  256 */     if (sharedModList == null) {
/*      */       
/*  258 */       sharedModList = Maps.newHashMap();
/*  259 */       Launch.blackboard.put("modList", sharedModList);
/*      */     } 
/*  261 */     for (ModContainer mc : Loader.instance().getActiveModList()) {
/*      */       
/*  263 */       Map<String, String> sharedModDescriptor = mc.getSharedModDescriptor();
/*  264 */       if (sharedModDescriptor != null) {
/*      */         
/*  266 */         String sharedModId = "fml:" + mc.getModId();
/*  267 */         sharedModList.put(sharedModId, sharedModDescriptor);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void detectOptifine() {
/*      */     try {
/*  276 */       Class<?> optifineConfig = Class.forName("Config", false, Loader.instance().getModClassLoader());
/*  277 */       String optifineVersion = (String)optifineConfig.getField("VERSION").get(null);
/*  278 */       ImmutableMap immutableMap = ImmutableMap.builder().put("name", "Optifine").put("version", optifineVersion).build();
/*  279 */       ModMetadata optifineMetadata = MetadataCollection.from(getClass().getResourceAsStream("optifinemod.info"), "optifine").getMetadataForId("optifine", (Map)immutableMap);
/*  280 */       this.optifineContainer = new DummyModContainer(optifineMetadata);
/*  281 */       FMLLog.info("Forge Mod Loader has detected optifine %s, enabling compatibility features", new Object[] { this.optifineContainer.getVersion() });
/*      */     }
/*  283 */     catch (Exception e) {
/*      */       
/*  285 */       this.optifineContainer = null;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void haltGame(String message, Throwable t) {
/*  292 */     SplashProgress.finish();
/*  293 */     this.client.displayCrashReport(new CrashReport(message, t));
/*  294 */     throw Throwables.propagate(t);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void finishMinecraftLoading() {
/*  304 */     if (this.modsMissing != null || this.wrongMC != null || this.customError != null || this.dupesFound != null || this.modSorting != null) {
/*      */       
/*  306 */       SplashProgress.finish();
/*      */       
/*      */       return;
/*      */     } 
/*      */     try {
/*  311 */       Loader.instance().initializeMods();
/*      */     }
/*  313 */     catch (CustomModLoadingErrorDisplayException custom) {
/*      */       
/*  315 */       FMLLog.log(Level.ERROR, (Throwable)custom, "A custom exception was thrown by a mod, the game will now halt", new Object[0]);
/*  316 */       this.customError = custom;
/*  317 */       SplashProgress.finish();
/*      */       
/*      */       return;
/*  320 */     } catch (LoaderException le) {
/*      */       
/*  322 */       haltGame("There was a severe problem during mod loading that has caused the game to fail", (Throwable)le);
/*      */       
/*      */       return;
/*      */     } 
/*      */     
/*  327 */     this.client.refreshResources();
/*  328 */     RenderingRegistry.instance().loadEntityRenderers(RenderManager.instance.entityRenderMap);
/*  329 */     this.guiFactories = (BiMap<ModContainer, IModGuiFactory>)HashBiMap.create();
/*  330 */     for (ModContainer mc : Loader.instance().getActiveModList()) {
/*      */       
/*  332 */       String className = mc.getGuiClassName();
/*  333 */       if (Strings.isNullOrEmpty(className)) {
/*      */         continue;
/*      */       }
/*      */ 
/*      */       
/*      */       try {
/*  339 */         Class<?> clazz = Class.forName(className, true, Loader.instance().getModClassLoader());
/*  340 */         Class<? extends IModGuiFactory> guiClassFactory = clazz.asSubclass(IModGuiFactory.class);
/*  341 */         IModGuiFactory guiFactory = guiClassFactory.newInstance();
/*  342 */         guiFactory.initialize(this.client);
/*  343 */         this.guiFactories.put(mc, guiFactory);
/*  344 */       } catch (Exception e) {
/*      */         
/*  346 */         FMLLog.log(Level.ERROR, e, "A critical error occurred instantiating the gui factory for mod %s", new Object[] { mc.getModId() });
/*      */       } 
/*      */     } 
/*  349 */     this.loading = false;
/*  350 */     this.client.gameSettings.loadOptions();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void extendModList() {
/*  357 */     Map<String, Map<String, String>> modList = (Map<String, Map<String, String>>)Launch.blackboard.get("modList");
/*  358 */     if (modList != null)
/*      */     {
/*  360 */       for (Map.Entry<String, Map<String, String>> modEntry : modList.entrySet()) {
/*      */         
/*  362 */         String sharedModId = modEntry.getKey();
/*  363 */         String system = sharedModId.split(":")[0];
/*  364 */         if ("fml".equals(system)) {
/*      */           continue;
/*      */         }
/*      */         
/*  368 */         Map<String, String> mod = modEntry.getValue();
/*  369 */         String modSystem = mod.get("modsystem");
/*  370 */         String modId = mod.get("id");
/*  371 */         String modVersion = mod.get("version");
/*  372 */         String modName = mod.get("name");
/*  373 */         String modURL = mod.get("url");
/*  374 */         String modAuthors = mod.get("authors");
/*  375 */         String str1 = mod.get("description");
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void onInitializationComplete() {
/*  382 */     if (this.wrongMC != null) {
/*      */       
/*  384 */       showGuiScreen(new GuiWrongMinecraft(this.wrongMC));
/*      */     }
/*  386 */     else if (this.modsMissing != null) {
/*      */       
/*  388 */       showGuiScreen(new GuiModsMissing(this.modsMissing));
/*      */     }
/*  390 */     else if (this.dupesFound != null) {
/*      */       
/*  392 */       showGuiScreen(new GuiDupesFound(this.dupesFound));
/*      */     }
/*  394 */     else if (this.modSorting != null) {
/*      */       
/*  396 */       showGuiScreen(new GuiSortingProblem(this.modSorting));
/*      */     }
/*  398 */     else if (this.customError != null) {
/*      */       
/*  400 */       showGuiScreen(new GuiCustomModLoadingErrorScreen(this.customError));
/*      */     }
/*      */     else {
/*      */       
/*  404 */       Loader.instance().loadingComplete();
/*  405 */       SplashProgress.finish();
/*      */     } 
/*  407 */     logMissingTextureErrors();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Minecraft getClient() {
/*  414 */     return this.client;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FMLClientHandler instance() {
/*  422 */     return INSTANCE;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void displayGuiScreen(EntityPlayer player, GuiScreen gui) {
/*  431 */     if (this.client.thePlayer == player && gui != null) {
/*  432 */       this.client.displayGuiScreen(gui);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addSpecialModEntries(ArrayList<ModContainer> mods) {
/*  441 */     if (this.optifineContainer != null) {
/*  442 */       mods.add(this.optifineContainer);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public List<String> getAdditionalBrandingInformation() {
/*  449 */     if (this.optifineContainer != null)
/*      */     {
/*  451 */       return Arrays.asList(new String[] { String.format("Optifine %s", new Object[] { this.optifineContainer.getVersion() }) });
/*      */     }
/*  453 */     return (List<String>)ImmutableList.of();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Side getSide() {
/*  460 */     return Side.CLIENT;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean hasOptifine() {
/*  465 */     return (this.optifineContainer != null);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void showGuiScreen(Object clientGuiElement) {
/*  471 */     GuiScreen gui = (GuiScreen)clientGuiElement;
/*  472 */     this.client.displayGuiScreen(gui);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void queryUser(StartupQuery query) throws InterruptedException {
/*  478 */     if (query.getResult() == null) {
/*      */       
/*  480 */       this.client.displayGuiScreen(new GuiNotification(query));
/*      */     }
/*      */     else {
/*      */       
/*  484 */       this.client.displayGuiScreen(new GuiConfirmation(query));
/*      */     } 
/*      */     
/*  487 */     if (query.isSynchronous()) {
/*      */       
/*  489 */       while (this.client.currentScreen instanceof GuiNotification) {
/*      */         
/*  491 */         if (Thread.interrupted()) throw new InterruptedException();
/*      */         
/*  493 */         this.client.loadingScreen.resetProgresAndWorkingMessage("");
/*      */         
/*  495 */         Thread.sleep(50L);
/*      */       } 
/*      */       
/*  498 */       this.client.loadingScreen.resetProgresAndWorkingMessage("");
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean handleLoadingScreen(ScaledResolution scaledResolution) {
/*  504 */     if (this.client.currentScreen instanceof GuiNotification) {
/*      */       
/*  506 */       int width = scaledResolution.getScaledWidth();
/*  507 */       int height = scaledResolution.getScaledHeight();
/*  508 */       int mouseX = Mouse.getX() * width / this.client.displayWidth;
/*  509 */       int mouseZ = height - Mouse.getY() * height / this.client.displayHeight - 1;
/*      */       
/*  511 */       this.client.currentScreen.drawScreen(mouseX, mouseZ, 0.0F);
/*  512 */       this.client.currentScreen.handleInput();
/*      */       
/*  514 */       return true;
/*      */     } 
/*      */ 
/*      */     
/*  518 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public WorldClient getWorldClient() {
/*  524 */     return this.client.theWorld;
/*      */   }
/*      */ 
/*      */   
/*      */   public EntityClientPlayerMP getClientPlayerEntity() {
/*  529 */     return this.client.thePlayer;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void beginServerLoading(MinecraftServer server) {
/*  535 */     this.serverShouldBeKilledQuietly = false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void finishServerLoading() {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public File getSavesDirectory() {
/*  548 */     return ((SaveFormatOld)this.client.getSaveLoader()).savesDirectory;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public MinecraftServer getServer() {
/*  554 */     return (MinecraftServer)this.client.getIntegratedServer();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void displayMissingMods(Object modMissingPacket) {}
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isLoading() {
/*  567 */     return this.loading;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean shouldServerShouldBeKilledQuietly() {
/*  573 */     return this.serverShouldBeKilledQuietly;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isGUIOpen(Class<? extends GuiScreen> gui) {
/*  584 */     return (this.client.currentScreen != null && this.client.currentScreen.getClass().equals(gui));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void addModAsResource(ModContainer container) {
/*  591 */     LanguageRegistry.instance().loadLanguagesFor(container, Side.CLIENT);
/*  592 */     Class<?> resourcePackType = container.getCustomResourcePackClass();
/*  593 */     if (resourcePackType != null) {
/*      */       
/*      */       try {
/*      */         
/*  597 */         IResourcePack pack = resourcePackType.getConstructor(new Class[] { ModContainer.class }).newInstance(new Object[] { container });
/*  598 */         this.resourcePackList.add(pack);
/*  599 */         this.resourcePackMap.put(container.getModId(), pack);
/*      */       }
/*  601 */       catch (NoSuchMethodException e) {
/*      */         
/*  603 */         FMLLog.log(Level.ERROR, "The container %s (type %s) returned an invalid class for it's resource pack.", new Object[] { container.getName(), container.getClass().getName() });
/*      */         
/*      */         return;
/*  606 */       } catch (Exception e) {
/*      */         
/*  608 */         FMLLog.log(Level.ERROR, e, "An unexpected exception occurred constructing the custom resource pack for %s", new Object[] { container.getName() });
/*  609 */         throw Throwables.propagate(e);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public IResourcePack getResourcePackFor(String modId) {
/*  616 */     return this.resourcePackMap.get(modId);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public String getCurrentLanguage() {
/*  622 */     return this.client.getLanguageManager().getCurrentLanguage().getLanguageCode();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void serverStopped() {
/*  629 */     MinecraftServer server = getServer();
/*      */     
/*  631 */     if (server != null && !server.serverIsInRunLoop())
/*      */     {
/*  633 */       ObfuscationReflectionHelper.setPrivateValue(MinecraftServer.class, server, Boolean.valueOf(true), new String[] { "field_71296_Q", "serverIsRunning" });
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public INetHandler getClientPlayHandler() {
/*  640 */     return (this.currentPlayClient == null) ? null : (INetHandler)this.currentPlayClient.get();
/*      */   }
/*      */ 
/*      */   
/*      */   public NetworkManager getClientToServerNetworkManager() {
/*  645 */     return (this.client.getNetHandler() != null) ? this.client.getNetHandler().getNetworkManager() : null;
/*      */   }
/*      */ 
/*      */   
/*      */   public void handleClientWorldClosing(WorldClient world) {
/*  650 */     NetworkManager client = getClientToServerNetworkManager();
/*      */     
/*  652 */     if (client != null && !client.isLocalChannel())
/*      */     {
/*  654 */       GameData.revertToFrozen();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void startIntegratedServer(String id, String name, WorldSettings settings) {
/*  660 */     this.playClientBlock = new CountDownLatch(1);
/*      */   }
/*      */ 
/*      */   
/*      */   public File getSavesDir() {
/*  665 */     return new File(this.client.mcDataDir, "saves");
/*      */   }
/*      */   public void tryLoadExistingWorld(GuiSelectWorld selectWorldGUI, String dirName, String saveName) {
/*      */     NBTTagCompound leveldat;
/*  669 */     File dir = new File(getSavesDir(), dirName);
/*      */ 
/*      */     
/*      */     try {
/*  673 */       leveldat = CompressedStreamTools.readCompressed(new FileInputStream(new File(dir, "level.dat")));
/*      */     }
/*  675 */     catch (Exception e) {
/*      */ 
/*      */       
/*      */       try {
/*  679 */         leveldat = CompressedStreamTools.readCompressed(new FileInputStream(new File(dir, "level.dat_old")));
/*      */       }
/*  681 */       catch (Exception e1) {
/*      */         
/*  683 */         FMLLog.warning("There appears to be a problem loading the save %s, both level files are unreadable.", new Object[] { dirName });
/*      */         return;
/*      */       } 
/*      */     } 
/*  687 */     NBTTagCompound fmlData = leveldat.getCompoundTag("FML");
/*  688 */     if (fmlData.hasKey("ModItemData")) {
/*      */       
/*  690 */       showGuiScreen(new GuiOldSaveLoadConfirm(dirName, saveName, (GuiScreen)selectWorldGUI));
/*      */     } else {
/*      */ 
/*      */       
/*      */       try {
/*      */         
/*  696 */         this.client.launchIntegratedServer(dirName, saveName, (WorldSettings)null);
/*      */       }
/*  698 */       catch (cpw.mods.fml.common.StartupQuery.AbortedException abortedException) {}
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void showInGameModOptions(GuiIngameMenu guiIngameMenu) {
/*  707 */     showGuiScreen(new GuiIngameModOptions((GuiScreen)guiIngameMenu));
/*      */   }
/*      */ 
/*      */   
/*      */   public IModGuiFactory getGuiFactoryFor(ModContainer selectedMod) {
/*  712 */     return (IModGuiFactory)this.guiFactories.get(selectedMod);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void setupServerList() {
/*  718 */     this.extraServerListData = Collections.synchronizedMap(Maps.newHashMap());
/*  719 */     this.serverDataTag = Collections.synchronizedMap(Maps.newHashMap());
/*      */   }
/*      */ 
/*      */   
/*      */   public void captureAdditionalData(ServerStatusResponse serverstatusresponse, JsonObject jsonobject) {
/*  724 */     if (jsonobject.has("modinfo")) {
/*      */       
/*  726 */       JsonObject fmlData = jsonobject.get("modinfo").getAsJsonObject();
/*  727 */       this.extraServerListData.put(serverstatusresponse, fmlData);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void bindServerListData(ServerData data, ServerStatusResponse originalResponse) {
/*  732 */     if (this.extraServerListData.containsKey(originalResponse)) {
/*      */       
/*  734 */       JsonObject jsonData = this.extraServerListData.get(originalResponse);
/*  735 */       String type = jsonData.get("type").getAsString();
/*  736 */       JsonArray modDataArray = jsonData.get("modList").getAsJsonArray();
/*  737 */       boolean moddedClientAllowed = jsonData.has("clientModsAllowed") ? jsonData.get("clientModsAllowed").getAsBoolean() : true;
/*  738 */       ImmutableMap.Builder<String, String> modListBldr = ImmutableMap.builder();
/*  739 */       for (JsonElement obj : modDataArray) {
/*      */         
/*  741 */         JsonObject modObj = obj.getAsJsonObject();
/*  742 */         modListBldr.put(modObj.get("modid").getAsString(), modObj.get("version").getAsString());
/*      */       } 
/*      */       
/*  745 */       ImmutableMap immutableMap = modListBldr.build();
/*  746 */       this.serverDataTag.put(data, new ExtendedServerListData(type, (FMLNetworkHandler.checkModList((Map)immutableMap, Side.SERVER) == null), (Map<String, String>)immutableMap, !moddedClientAllowed));
/*      */     }
/*      */     else {
/*      */       
/*  750 */       String serverDescription = data.serverMOTD;
/*  751 */       boolean moddedClientAllowed = true;
/*  752 */       if (!Strings.isNullOrEmpty(serverDescription))
/*      */       {
/*  754 */         moddedClientAllowed = !serverDescription.endsWith(":NOFML搂r");
/*      */       }
/*  756 */       this.serverDataTag.put(data, new ExtendedServerListData("VANILLA", false, (Map<String, String>)ImmutableMap.of(), !moddedClientAllowed));
/*      */     } 
/*  758 */     startupConnectionData.countDown();
/*      */   }
/*      */   
/*  761 */   private static final ResourceLocation iconSheet = new ResourceLocation("fml:textures/gui/icons.png");
/*  762 */   private static final CountDownLatch startupConnectionData = new CountDownLatch(1);
/*      */   private CountDownLatch playClientBlock;
/*      */   
/*      */   public String enhanceServerListEntry(ServerListEntryNormal serverListEntry, ServerData serverEntry, int x, int width, int y, int relativeMouseX, int relativeMouseY) {
/*      */     String tooltip;
/*      */     int idx;
/*  768 */     boolean blocked = false;
/*  769 */     if (this.serverDataTag.containsKey(serverEntry)) {
/*      */       
/*  771 */       ExtendedServerListData extendedData = this.serverDataTag.get(serverEntry);
/*  772 */       if ("FML".equals(extendedData.type) && extendedData.isCompatible) {
/*      */         
/*  774 */         idx = 0;
/*  775 */         tooltip = String.format("Compatible FML modded server\n%d mods present", new Object[] { Integer.valueOf(extendedData.modData.size()) });
/*      */       }
/*  777 */       else if ("FML".equals(extendedData.type) && !extendedData.isCompatible) {
/*      */         
/*  779 */         idx = 16;
/*  780 */         tooltip = String.format("Incompatible FML modded server\n%d mods present", new Object[] { Integer.valueOf(extendedData.modData.size()) });
/*      */       }
/*  782 */       else if ("BUKKIT".equals(extendedData.type)) {
/*      */         
/*  784 */         idx = 32;
/*  785 */         tooltip = String.format("Bukkit modded server", new Object[0]);
/*      */       }
/*  787 */       else if ("VANILLA".equals(extendedData.type)) {
/*      */         
/*  789 */         idx = 48;
/*  790 */         tooltip = String.format("Vanilla server", new Object[0]);
/*      */       }
/*      */       else {
/*      */         
/*  794 */         idx = 64;
/*  795 */         tooltip = String.format("Unknown server data", new Object[0]);
/*      */       } 
/*  797 */       blocked = extendedData.isBlocked;
/*      */     }
/*      */     else {
/*      */       
/*  801 */       return null;
/*      */     } 
/*  803 */     this.client.getTextureManager().bindTexture(iconSheet);
/*  804 */     Gui.func_146110_a(x + width - 18, y + 10, 0.0F, idx, 16, 16, 256.0F, 256.0F);
/*  805 */     if (blocked)
/*      */     {
/*  807 */       Gui.func_146110_a(x + width - 18, y + 10, 0.0F, 80.0F, 16, 16, 256.0F, 256.0F);
/*      */     }
/*      */     
/*  810 */     return (relativeMouseX > width - 15 && relativeMouseX < width && relativeMouseY > 10 && relativeMouseY < 26) ? tooltip : null;
/*      */   }
/*      */ 
/*      */   
/*      */   public String fixDescription(String description) {
/*  815 */     return description.endsWith(":NOFML搂r") ? (description.substring(0, description.length() - 8) + "搂r") : description;
/*      */   }
/*      */ 
/*      */   
/*      */   public void connectToServerAtStartup(String host, int port) {
/*  820 */     setupServerList();
/*  821 */     OldServerPinger osp = new OldServerPinger();
/*  822 */     ServerData serverData = new ServerData("Command Line", host + ":" + port);
/*      */     
/*      */     try {
/*  825 */       osp.func_147224_a(serverData);
/*  826 */       startupConnectionData.await(30L, TimeUnit.SECONDS);
/*      */     }
/*  828 */     catch (Exception e) {
/*      */       
/*  830 */       showGuiScreen(new GuiConnecting((GuiScreen)new GuiMainMenu(), this.client, host, port));
/*      */       return;
/*      */     } 
/*  833 */     connectToServer((GuiScreen)new GuiMainMenu(), serverData);
/*      */   }
/*      */ 
/*      */   
/*      */   public void connectToServer(GuiScreen guiMultiplayer, ServerData serverEntry) {
/*  838 */     ExtendedServerListData extendedData = this.serverDataTag.get(serverEntry);
/*  839 */     if (extendedData != null && extendedData.isBlocked) {
/*      */       
/*  841 */       showGuiScreen(new GuiAccessDenied(guiMultiplayer, serverEntry));
/*      */     }
/*      */     else {
/*      */       
/*  845 */       showGuiScreen(new GuiConnecting(guiMultiplayer, this.client, serverEntry));
/*      */     } 
/*  847 */     this.playClientBlock = new CountDownLatch(1);
/*      */   }
/*      */ 
/*      */   
/*      */   public void connectToRealmsServer(String host, int port) {
/*  852 */     this.playClientBlock = new CountDownLatch(1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void setPlayClient(NetHandlerPlayClient netHandlerPlayClient) {
/*  859 */     if (this.playClientBlock == null)
/*  860 */       this.playClientBlock = new CountDownLatch(1); 
/*  861 */     this.playClientBlock.countDown();
/*  862 */     this.currentPlayClient = new WeakReference<NetHandlerPlayClient>(netHandlerPlayClient);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void waitForPlayClient() {
/*  868 */     boolean gotIt = false;
/*      */     
/*      */     try {
/*  871 */       gotIt = this.playClientBlock.await(5L, TimeUnit.SECONDS);
/*  872 */     } catch (InterruptedException interruptedException) {}
/*      */ 
/*      */     
/*  875 */     if (!gotIt)
/*      */     {
/*  877 */       throw new RuntimeException("Timeout waiting for client thread to catch up!");
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void fireNetRegistrationEvent(EventBus bus, NetworkManager manager, Set<String> channelSet, String channel, Side side) {
/*  884 */     if (side == Side.CLIENT) {
/*      */       
/*  886 */       waitForPlayClient();
/*  887 */       bus.post((Event)new FMLNetworkEvent.CustomPacketRegistrationEvent(manager, channelSet, channel, side, NetHandlerPlayClient.class));
/*      */     }
/*      */     else {
/*      */       
/*  891 */       bus.post((Event)new FMLNetworkEvent.CustomPacketRegistrationEvent(manager, channelSet, channel, side, NetHandlerPlayServer.class));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean shouldAllowPlayerLogins() {
/*  898 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void allowLogins() {}
/*      */ 
/*      */ 
/*      */   
/*  907 */   private SetMultimap<String, ResourceLocation> missingTextures = (SetMultimap<String, ResourceLocation>)HashMultimap.create();
/*  908 */   private Set<String> badTextureDomains = Sets.newHashSet();
/*  909 */   private Table<String, String, Set<ResourceLocation>> brokenTextures = (Table<String, String, Set<ResourceLocation>>)HashBasedTable.create();
/*      */   private static final String ALLOWED_CHARS = "ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\000\000\000\000\000\000\000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\000";
/*      */   
/*      */   public void trackMissingTexture(ResourceLocation resourceLocation) {
/*  913 */     this.badTextureDomains.add(resourceLocation.getResourceDomain());
/*  914 */     this.missingTextures.put(resourceLocation.getResourceDomain(), resourceLocation);
/*      */   }
/*      */ 
/*      */   
/*      */   public void trackBrokenTexture(ResourceLocation resourceLocation, String error) {
/*  919 */     this.badTextureDomains.add(resourceLocation.getResourceDomain());
/*  920 */     Set<ResourceLocation> badType = (Set<ResourceLocation>)this.brokenTextures.get(resourceLocation.getResourceDomain(), error);
/*  921 */     if (badType == null) {
/*      */       
/*  923 */       badType = Sets.newHashSet();
/*  924 */       this.brokenTextures.put(resourceLocation.getResourceDomain(), error, badType);
/*      */     } 
/*  926 */     badType.add(resourceLocation);
/*      */   }
/*      */ 
/*      */   
/*      */   public void logMissingTextureErrors() {
/*  931 */     if (this.missingTextures.isEmpty() && this.brokenTextures.isEmpty()) {
/*      */       return;
/*      */     }
/*      */     
/*  935 */     Logger logger = LogManager.getLogger("TEXTURE ERRORS");
/*  936 */     logger.error(Strings.repeat("+=", 25));
/*  937 */     logger.error("The following texture errors were found.");
/*  938 */     Map<String, FallbackResourceManager> resManagers = (Map<String, FallbackResourceManager>)ObfuscationReflectionHelper.getPrivateValue(SimpleReloadableResourceManager.class, Minecraft.getMinecraft().getResourceManager(), new String[] { "domainResourceManagers", "field_110548_a" });
/*  939 */     for (String resourceDomain : this.missingTextures.keySet()) {
/*      */       
/*  941 */       Set<ResourceLocation> missing = this.missingTextures.get(resourceDomain);
/*  942 */       logger.error(Strings.repeat("=", 50));
/*  943 */       logger.error("  DOMAIN {}", new Object[] { resourceDomain });
/*  944 */       logger.error(Strings.repeat("-", 50));
/*  945 */       logger.error("  domain {} is missing {} texture{}", new Object[] { resourceDomain, Integer.valueOf(missing.size()), (missing.size() != 1) ? "s" : "" });
/*  946 */       FallbackResourceManager fallbackResourceManager = resManagers.get(resourceDomain);
/*  947 */       if (fallbackResourceManager == null) {
/*      */         
/*  949 */         logger.error("    domain {} is missing a resource manager - it is probably a side-effect of automatic texture processing", new Object[] { resourceDomain });
/*      */       }
/*      */       else {
/*      */         
/*  953 */         List<IResourcePack> resPacks = (List<IResourcePack>)ObfuscationReflectionHelper.getPrivateValue(FallbackResourceManager.class, fallbackResourceManager, new String[] { "resourcePacks", "field_110540_a" });
/*  954 */         logger.error("    domain {} has {} location{}:", new Object[] { resourceDomain, Integer.valueOf(resPacks.size()), (resPacks.size() != 1) ? "s" : "" });
/*  955 */         for (IResourcePack resPack : resPacks) {
/*      */           
/*  957 */           if (resPack instanceof FMLContainerHolder) {
/*  958 */             FMLContainerHolder containerHolder = (FMLContainerHolder)resPack;
/*  959 */             ModContainer fmlContainer = containerHolder.getFMLContainer();
/*  960 */             logger.error("      mod {} resources at {}", new Object[] { fmlContainer.getModId(), fmlContainer.getSource().getPath() }); continue;
/*      */           } 
/*  962 */           if (resPack instanceof AbstractResourcePack) {
/*      */             
/*  964 */             AbstractResourcePack resourcePack = (AbstractResourcePack)resPack;
/*  965 */             File resPath = (File)ObfuscationReflectionHelper.getPrivateValue(AbstractResourcePack.class, resourcePack, new String[] { "resourcePackFile", "field_110597_b" });
/*  966 */             logger.error("      resource pack at path {}", new Object[] { resPath.getPath() });
/*      */             
/*      */             continue;
/*      */           } 
/*  970 */           logger.error("      unknown resourcepack type {} : {}", new Object[] { resPack.getClass().getName(), resPack.getPackName() });
/*      */         } 
/*      */       } 
/*      */       
/*  974 */       logger.error(Strings.repeat("-", 25));
/*  975 */       logger.error("    The missing resources for domain {} are:", new Object[] { resourceDomain });
/*  976 */       for (ResourceLocation rl : missing) {
/*      */         
/*  978 */         logger.error("      {}", new Object[] { rl.getResourcePath() });
/*      */       } 
/*  980 */       logger.error(Strings.repeat("-", 25));
/*  981 */       if (!this.brokenTextures.containsRow(resourceDomain)) {
/*      */         
/*  983 */         logger.error("    No other errors exist for domain {}", new Object[] { resourceDomain });
/*      */       }
/*      */       else {
/*      */         
/*  987 */         logger.error("    The following other errors were reported for domain {}:", new Object[] { resourceDomain });
/*  988 */         Map<String, Set<ResourceLocation>> resourceErrs = this.brokenTextures.row(resourceDomain);
/*  989 */         for (String error : resourceErrs.keySet()) {
/*      */           
/*  991 */           logger.error(Strings.repeat("-", 25));
/*  992 */           logger.error("    Problem: {}", new Object[] { error });
/*  993 */           for (ResourceLocation rl : resourceErrs.get(error)) {
/*      */             
/*  995 */             logger.error("      {}", new Object[] { rl.getResourcePath() });
/*      */           } 
/*      */         } 
/*      */       } 
/*  999 */       logger.error(Strings.repeat("=", 50));
/*      */     } 
/* 1001 */     logger.error(Strings.repeat("+=", 25));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void processWindowMessages() {
/* 1008 */     if (LWJGLUtil.getPlatform() != 3) {
/*      */       return;
/*      */     }
/* 1011 */     if (!SplashProgress.mutex.tryAcquire())
/* 1012 */       return;  Display.processMessages();
/* 1013 */     SplashProgress.mutex.release();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String stripSpecialChars(String message) {
/* 1021 */     return CharMatcher.anyOf("ÀÁÂÈÊËÍÓÔÕÚßãõğİıŒœŞşŴŵžȇ\000\000\000\000\000\000\000 !\"#$%&'()*+,-./0123456789:;<=>?@ABCDEFGHIJKLMNOPQRSTUVWXYZ[\\]^_`abcdefghijklmnopqrstuvwxyz{|}~\000ÇüéâäàåçêëèïîìÄÅÉæÆôöòûùÿÖÜø£Ø×ƒáíóúñÑªº¿®¬½¼¡«»░▒▓│┤╡╢╖╕╣║╗╝╜╛┐└┴┬├─┼╞╟╚╔╩╦╠═╬╧╨╤╥╙╘╒╓╫╪┘┌█▄▌▐▀αβΓπΣσμτΦΘΩδ∞∅∈∩≡±≥≤⌠⌡÷≈°∙·√ⁿ²■\000").retainFrom(StringUtils.stripControlCodes(message));
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\client\FMLClientHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */