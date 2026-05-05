/*     */ package cpw.mods.fml.common;
/*     */ 
/*     */ import com.google.common.base.Joiner;
/*     */ import com.google.common.base.Strings;
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import com.google.common.collect.Lists;
/*     */ import com.google.common.collect.MapMaker;
/*     */ import com.google.common.collect.Maps;
/*     */ import com.google.common.collect.Sets;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.common.eventhandler.EventBus;
/*     */ import cpw.mods.fml.common.gameevent.InputEvent;
/*     */ import cpw.mods.fml.common.gameevent.PlayerEvent;
/*     */ import cpw.mods.fml.common.gameevent.TickEvent;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.server.FMLServerHandler;
/*     */ import java.io.File;
/*     */ import java.lang.ref.WeakReference;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.Set;
/*     */ import java.util.concurrent.CountDownLatch;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.inventory.IInventory;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.storage.SaveHandler;
/*     */ import net.minecraft.world.storage.WorldInfo;
/*     */ import org.apache.logging.log4j.Level;
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
/*     */ public class FMLCommonHandler
/*     */ {
/*  77 */   private static final FMLCommonHandler INSTANCE = new FMLCommonHandler();
/*     */   
/*     */   private IFMLSidedHandler sidedDelegate;
/*     */   
/*     */   private Class<?> forge;
/*     */   
/*     */   private boolean noForge;
/*     */   
/*     */   private List<String> brandings;
/*     */   private List<String> brandingsNoMC;
/*  87 */   private List<ICrashCallable> crashCallables = Lists.newArrayList((Object[])new ICrashCallable[] { Loader.instance().getCallableCrashInformation() });
/*  88 */   private Set<SaveHandler> handlerSet = Sets.newSetFromMap((new MapMaker()).weakKeys().makeMap());
/*     */   private WeakReference<SaveHandler> handlerToCheck;
/*  90 */   private EventBus eventBus = new EventBus();
/*  91 */   private volatile CountDownLatch exitLatch = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EventBus bus() {
/*  99 */     return this.eventBus;
/*     */   }
/*     */ 
/*     */   
/*     */   public void beginLoading(IFMLSidedHandler handler) {
/* 104 */     this.sidedDelegate = handler;
/* 105 */     FMLLog.log("MinecraftForge", Level.INFO, "Attempting early MinecraftForge initialization", new Object[0]);
/* 106 */     callForgeMethod("initialize");
/* 107 */     callForgeMethod("registerCrashCallable");
/* 108 */     FMLLog.log("MinecraftForge", Level.INFO, "Completed early MinecraftForge initialization", new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FMLCommonHandler instance() {
/* 116 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ModContainer findContainerFor(Object mod) {
/* 124 */     if (mod instanceof String)
/*     */     {
/* 126 */       return Loader.instance().getIndexedModList().get(mod);
/*     */     }
/*     */ 
/*     */     
/* 130 */     return (ModContainer)Loader.instance().getReversedModObjectList().get(mod);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Logger getFMLLogger() {
/* 139 */     return FMLLog.getLogger();
/*     */   }
/*     */ 
/*     */   
/*     */   public Side getSide() {
/* 144 */     return this.sidedDelegate.getSide();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Side getEffectiveSide() {
/* 154 */     Thread thr = Thread.currentThread();
/* 155 */     if (thr.getName().equals("Server thread"))
/*     */     {
/* 157 */       return Side.SERVER;
/*     */     }
/*     */     
/* 160 */     return Side.CLIENT;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void raiseException(Throwable exception, String message, boolean stopGame) {
/* 167 */     FMLLog.log(Level.ERROR, exception, "Something raised an exception. The message was '%s'. 'stopGame' is %b", new Object[] { message, Boolean.valueOf(stopGame) });
/* 168 */     if (stopGame)
/*     */     {
/* 170 */       getSidedDelegate().haltGame(message, exception);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private Class<?> findMinecraftForge() {
/* 177 */     if (this.forge == null && !this.noForge) {
/*     */       
/*     */       try {
/* 180 */         this.forge = Class.forName("net.minecraftforge.common.MinecraftForge");
/* 181 */       } catch (Exception ex) {
/* 182 */         this.noForge = true;
/*     */       } 
/*     */     }
/* 185 */     return this.forge;
/*     */   }
/*     */ 
/*     */   
/*     */   private Object callForgeMethod(String method) {
/* 190 */     if (this.noForge) {
/* 191 */       return null;
/*     */     }
/*     */     try {
/* 194 */       return findMinecraftForge().getMethod(method, new Class[0]).invoke(null, new Object[0]);
/*     */     }
/* 196 */     catch (Exception e) {
/*     */ 
/*     */       
/* 199 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void computeBranding() {
/* 205 */     if (this.brandings == null) {
/*     */       
/* 207 */       ImmutableList.Builder<String> brd = ImmutableList.builder();
/* 208 */       brd.add(Loader.instance().getMCVersionString());
/* 209 */       brd.add(Loader.instance().getMCPVersionString());
/* 210 */       brd.add("FML v" + Loader.instance().getFMLVersionString());
/* 211 */       String forgeBranding = (String)callForgeMethod("getBrandingVersion");
/* 212 */       if (!Strings.isNullOrEmpty(forgeBranding))
/*     */       {
/* 214 */         brd.add(forgeBranding);
/*     */       }
/* 216 */       if (this.sidedDelegate != null)
/*     */       {
/* 218 */         brd.addAll(this.sidedDelegate.getAdditionalBrandingInformation());
/*     */       }
/* 220 */       if (Loader.instance().getFMLBrandingProperties().containsKey("fmlbranding"))
/*     */       {
/* 222 */         brd.add(Loader.instance().getFMLBrandingProperties().get("fmlbranding"));
/*     */       }
/* 224 */       int tModCount = Loader.instance().getModList().size();
/* 225 */       int aModCount = Loader.instance().getActiveModList().size();
/* 226 */       brd.add(String.format("%d mod%s loaded, %d mod%s active", new Object[] { Integer.valueOf(tModCount), (tModCount != 1) ? "s" : "", Integer.valueOf(aModCount), (aModCount != 1) ? "s" : "" }));
/* 227 */       this.brandings = (List<String>)brd.build();
/* 228 */       this.brandingsNoMC = this.brandings.subList(1, this.brandings.size());
/*     */     } 
/*     */   }
/*     */   
/*     */   public List<String> getBrandings(boolean includeMC) {
/* 233 */     if (this.brandings == null)
/*     */     {
/* 235 */       computeBranding();
/*     */     }
/* 237 */     return includeMC ? (List<String>)ImmutableList.copyOf(this.brandings) : (List<String>)ImmutableList.copyOf(this.brandingsNoMC);
/*     */   }
/*     */ 
/*     */   
/*     */   public IFMLSidedHandler getSidedDelegate() {
/* 242 */     return this.sidedDelegate;
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPostServerTick() {
/* 247 */     bus().post((Event)new TickEvent.ServerTickEvent(TickEvent.Phase.END));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPostWorldTick(World world) {
/* 255 */     bus().post((Event)new TickEvent.WorldTickEvent(Side.SERVER, TickEvent.Phase.END, world));
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPreServerTick() {
/* 260 */     bus().post((Event)new TickEvent.ServerTickEvent(TickEvent.Phase.START));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPreWorldTick(World world) {
/* 268 */     bus().post((Event)new TickEvent.WorldTickEvent(Side.SERVER, TickEvent.Phase.START, world));
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean handleServerAboutToStart(MinecraftServer server) {
/* 273 */     return Loader.instance().serverAboutToStart(server);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean handleServerStarting(MinecraftServer server) {
/* 278 */     return Loader.instance().serverStarting(server);
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleServerStarted() {
/* 283 */     Loader.instance().serverStarted();
/* 284 */     this.sidedDelegate.allowLogins();
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleServerStopping() {
/* 289 */     Loader.instance().serverStopping();
/*     */   }
/*     */   
/*     */   public File getSavesDirectory() {
/* 293 */     return this.sidedDelegate.getSavesDirectory();
/*     */   }
/*     */ 
/*     */   
/*     */   public MinecraftServer getMinecraftServerInstance() {
/* 298 */     return this.sidedDelegate.getServer();
/*     */   }
/*     */ 
/*     */   
/*     */   public void showGuiScreen(Object clientGuiElement) {
/* 303 */     this.sidedDelegate.showGuiScreen(clientGuiElement);
/*     */   }
/*     */ 
/*     */   
/*     */   public void queryUser(StartupQuery query) throws InterruptedException {
/* 308 */     this.sidedDelegate.queryUser(query);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onServerStart(MinecraftServer dedicatedServer) {
/* 313 */     FMLServerHandler.instance();
/* 314 */     this.sidedDelegate.beginServerLoading(dedicatedServer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void onServerStarted() {
/* 319 */     this.sidedDelegate.finishServerLoading();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void onPreClientTick() {
/* 325 */     bus().post((Event)new TickEvent.ClientTickEvent(TickEvent.Phase.START));
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPostClientTick() {
/* 330 */     bus().post((Event)new TickEvent.ClientTickEvent(TickEvent.Phase.END));
/*     */   }
/*     */ 
/*     */   
/*     */   public void onRenderTickStart(float timer) {
/* 335 */     bus().post((Event)new TickEvent.RenderTickEvent(TickEvent.Phase.START, timer));
/*     */   }
/*     */ 
/*     */   
/*     */   public void onRenderTickEnd(float timer) {
/* 340 */     bus().post((Event)new TickEvent.RenderTickEvent(TickEvent.Phase.END, timer));
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerPreTick(EntityPlayer player) {
/* 345 */     bus().post((Event)new TickEvent.PlayerTickEvent(TickEvent.Phase.START, player));
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerPostTick(EntityPlayer player) {
/* 350 */     bus().post((Event)new TickEvent.PlayerTickEvent(TickEvent.Phase.END, player));
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerCrashCallable(ICrashCallable callable) {
/* 355 */     this.crashCallables.add(callable);
/*     */   }
/*     */ 
/*     */   
/*     */   public void enhanceCrashReport(CrashReport crashReport, CrashReportCategory category) {
/* 360 */     for (ICrashCallable call : this.crashCallables)
/*     */     {
/* 362 */       category.addCrashSectionCallable(call.getLabel(), call);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleWorldDataSave(SaveHandler handler, WorldInfo worldInfo, NBTTagCompound tagCompound) {
/* 368 */     for (ModContainer mc : Loader.instance().getModList()) {
/*     */       
/* 370 */       if (mc instanceof InjectedModContainer) {
/*     */         
/* 372 */         WorldAccessContainer wac = ((InjectedModContainer)mc).getWrappedWorldAccessContainer();
/* 373 */         if (wac != null) {
/*     */           
/* 375 */           NBTTagCompound dataForWriting = wac.getDataForWriting(handler, worldInfo);
/* 376 */           tagCompound.setTag(mc.getModId(), (NBTBase)dataForWriting);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleWorldDataLoad(SaveHandler handler, WorldInfo worldInfo, NBTTagCompound tagCompound) {
/* 384 */     if (getEffectiveSide() != Side.SERVER) {
/*     */       return;
/*     */     }
/*     */     
/* 388 */     if (this.handlerSet.contains(handler)) {
/*     */       return;
/*     */     }
/*     */     
/* 392 */     this.handlerSet.add(handler);
/* 393 */     this.handlerToCheck = new WeakReference<SaveHandler>(handler);
/* 394 */     Map<String, NBTBase> additionalProperties = Maps.newHashMap();
/* 395 */     worldInfo.setAdditionalProperties(additionalProperties);
/* 396 */     for (ModContainer mc : Loader.instance().getModList()) {
/*     */       
/* 398 */       if (mc instanceof InjectedModContainer) {
/*     */         
/* 400 */         WorldAccessContainer wac = ((InjectedModContainer)mc).getWrappedWorldAccessContainer();
/* 401 */         if (wac != null)
/*     */         {
/* 403 */           wac.readData(handler, worldInfo, additionalProperties, tagCompound.getCompoundTag(mc.getModId()));
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void confirmBackupLevelDatUse(SaveHandler handler) {
/* 411 */     if (this.handlerToCheck == null || this.handlerToCheck.get() != handler) {
/*     */       
/* 413 */       this.handlerToCheck = null;
/*     */       
/*     */       return;
/*     */     } 
/* 417 */     String text = "Forge Mod Loader detected that the backup level.dat is being used.\n\nThis may happen due to a bug or corruption, continuing can damage\nyour world beyond repair or lose data / progress.\n\nIt's recommended to create a world backup before continuing.";
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 422 */     boolean confirmed = StartupQuery.confirm(text);
/* 423 */     if (!confirmed) StartupQuery.abort();
/*     */   
/*     */   }
/*     */   
/*     */   public boolean shouldServerBeKilledQuietly() {
/* 428 */     if (this.sidedDelegate == null)
/*     */     {
/* 430 */       return false;
/*     */     }
/* 432 */     return this.sidedDelegate.shouldServerShouldBeKilledQuietly();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void expectServerStopped() {
/* 442 */     this.exitLatch = new CountDownLatch(1);
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
/*     */   public void handleExit(int retVal) {
/* 454 */     CountDownLatch latch = this.exitLatch;
/*     */     
/* 456 */     if (latch != null) {
/*     */       
/*     */       try {
/*     */         
/* 460 */         FMLLog.info("Waiting for the server to terminate/save.", new Object[0]);
/* 461 */         if (!latch.await(10L, TimeUnit.SECONDS))
/*     */         {
/* 463 */           FMLLog.warning("The server didn't stop within 10 seconds, exiting anyway.", new Object[0]);
/*     */         }
/*     */         else
/*     */         {
/* 467 */           FMLLog.info("Server terminated.", new Object[0]);
/*     */         }
/*     */       
/* 470 */       } catch (InterruptedException e) {
/*     */         
/* 472 */         FMLLog.warning("Interrupted wait, exiting.", new Object[0]);
/*     */       } 
/*     */     }
/*     */     
/* 476 */     System.exit(retVal);
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleServerStopped() {
/* 481 */     this.sidedDelegate.serverStopped();
/* 482 */     MinecraftServer server = getMinecraftServerInstance();
/* 483 */     Loader.instance().serverStopped();
/*     */     
/* 485 */     if (server != null) ObfuscationReflectionHelper.setPrivateValue(MinecraftServer.class, server, Boolean.valueOf(false), new String[] { "field_71316_v", "u", "serverStopped" });
/*     */ 
/*     */     
/* 488 */     CountDownLatch latch = this.exitLatch;
/*     */     
/* 490 */     if (latch != null) {
/*     */       
/* 492 */       latch.countDown();
/* 493 */       this.exitLatch = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getModName() {
/* 499 */     List<String> modNames = Lists.newArrayListWithExpectedSize(3);
/* 500 */     modNames.add("fml");
/* 501 */     if (!this.noForge)
/*     */     {
/* 503 */       modNames.add("forge");
/*     */     }
/*     */     
/* 506 */     if (Loader.instance().getFMLBrandingProperties().containsKey("snooperbranding"))
/*     */     {
/* 508 */       modNames.add(Loader.instance().getFMLBrandingProperties().get("snooperbranding"));
/*     */     }
/* 510 */     return Joiner.on(',').join(modNames);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addModToResourcePack(ModContainer container) {
/* 515 */     this.sidedDelegate.addModAsResource(container);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCurrentLanguage() {
/* 521 */     return this.sidedDelegate.getCurrentLanguage();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void bootstrap() {}
/*     */ 
/*     */   
/*     */   public NetworkManager getClientToServerNetworkManager() {
/* 530 */     return this.sidedDelegate.getClientToServerNetworkManager();
/*     */   }
/*     */ 
/*     */   
/*     */   public void fireMouseInput() {
/* 535 */     bus().post((Event)new InputEvent.MouseInputEvent());
/*     */   }
/*     */ 
/*     */   
/*     */   public void fireKeyInput() {
/* 540 */     bus().post((Event)new InputEvent.KeyInputEvent());
/*     */   }
/*     */ 
/*     */   
/*     */   public void firePlayerChangedDimensionEvent(EntityPlayer player, int fromDim, int toDim) {
/* 545 */     bus().post((Event)new PlayerEvent.PlayerChangedDimensionEvent(player, fromDim, toDim));
/*     */   }
/*     */ 
/*     */   
/*     */   public void firePlayerLoggedIn(EntityPlayer player) {
/* 550 */     bus().post((Event)new PlayerEvent.PlayerLoggedInEvent(player));
/*     */   }
/*     */ 
/*     */   
/*     */   public void firePlayerLoggedOut(EntityPlayer player) {
/* 555 */     bus().post((Event)new PlayerEvent.PlayerLoggedOutEvent(player));
/*     */   }
/*     */ 
/*     */   
/*     */   public void firePlayerRespawnEvent(EntityPlayer player) {
/* 560 */     bus().post((Event)new PlayerEvent.PlayerRespawnEvent(player));
/*     */   }
/*     */ 
/*     */   
/*     */   public void firePlayerItemPickupEvent(EntityPlayer player, EntityItem item) {
/* 565 */     bus().post((Event)new PlayerEvent.ItemPickupEvent(player, item));
/*     */   }
/*     */ 
/*     */   
/*     */   public void firePlayerCraftingEvent(EntityPlayer player, ItemStack crafted, IInventory craftMatrix) {
/* 570 */     bus().post((Event)new PlayerEvent.ItemCraftedEvent(player, crafted, craftMatrix));
/*     */   }
/*     */ 
/*     */   
/*     */   public void firePlayerSmeltedEvent(EntityPlayer player, ItemStack smelted) {
/* 575 */     bus().post((Event)new PlayerEvent.ItemSmeltedEvent(player, smelted));
/*     */   }
/*     */ 
/*     */   
/*     */   public INetHandler getClientPlayHandler() {
/* 580 */     return this.sidedDelegate.getClientPlayHandler();
/*     */   }
/*     */ 
/*     */   
/*     */   public void waitForPlayClient() {
/* 585 */     this.sidedDelegate.waitForPlayClient();
/*     */   }
/*     */ 
/*     */   
/*     */   public void fireNetRegistrationEvent(NetworkManager manager, Set<String> channelSet, String channel, Side side) {
/* 590 */     this.sidedDelegate.fireNetRegistrationEvent(bus(), manager, channelSet, channel, side);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shouldAllowPlayerLogins() {
/* 595 */     return this.sidedDelegate.shouldAllowPlayerLogins();
/*     */   }
/*     */ 
/*     */   
/*     */   public void processWindowMessages() {
/* 600 */     if (this.sidedDelegate == null)
/* 601 */       return;  this.sidedDelegate.processWindowMessages();
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
/*     */   public void exitJava(int exitCode, boolean hardExit) {
/* 613 */     FMLLog.log(Level.INFO, "Java has been asked to exit (code %d) by %s.", new Object[] { Integer.valueOf(exitCode), Thread.currentThread().getStackTrace()[1] });
/* 614 */     if (hardExit)
/*     */     {
/* 616 */       FMLLog.log(Level.INFO, "This is an abortive exit and could cause world corruption or other things", new Object[0]);
/*     */     }
/* 618 */     if (Boolean.parseBoolean(System.getProperty("fml.debugExit", "false"))) {
/*     */       
/* 620 */       FMLLog.log(Level.INFO, new Throwable(), "Exit trace", new Object[0]);
/*     */     }
/*     */     else {
/*     */       
/* 624 */       FMLLog.log(Level.INFO, "If this was an unexpected exit, use -Dfml.debugExit=true as a JVM argument to find out where it was called", new Object[0]);
/*     */     } 
/* 626 */     if (hardExit) {
/*     */       
/* 628 */       Runtime.getRuntime().halt(exitCode);
/*     */     }
/*     */     else {
/*     */       
/* 632 */       Runtime.getRuntime().exit(exitCode);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String stripSpecialChars(String message) {
/* 638 */     return (this.sidedDelegate != null) ? this.sidedDelegate.stripSpecialChars(message) : message;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\FMLCommonHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */