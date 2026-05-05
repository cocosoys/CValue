/*     */ package cpw.mods.fml.server;
/*     */ 
/*     */ import com.google.common.collect.ImmutableList;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.IFMLSidedHandler;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import cpw.mods.fml.common.ModContainer;
/*     */ import cpw.mods.fml.common.StartupQuery;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.common.eventhandler.EventBus;
/*     */ import cpw.mods.fml.common.functions.GenericIterableFactory;
/*     */ import cpw.mods.fml.common.network.FMLNetworkEvent;
/*     */ import cpw.mods.fml.common.registry.LanguageRegistry;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import java.io.File;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ import net.minecraft.command.ServerCommand;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.NetHandlerPlayServer;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.server.dedicated.DedicatedServer;
/*     */ import net.minecraft.world.storage.SaveFormatOld;
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
/*     */ 
/*     */ public class FMLServerHandler
/*     */   implements IFMLSidedHandler
/*     */ {
/*  66 */   private static final FMLServerHandler INSTANCE = new FMLServerHandler();
/*     */ 
/*     */ 
/*     */   
/*     */   private MinecraftServer server;
/*     */ 
/*     */ 
/*     */   
/*     */   private FMLServerHandler() {
/*  75 */     FMLCommonHandler.instance().beginLoading(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void beginServerLoading(MinecraftServer minecraftServer) {
/*  86 */     this.server = minecraftServer;
/*  87 */     Loader.instance().loadMods();
/*  88 */     Loader.instance().preinitializeMods();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void finishServerLoading() {
/*  97 */     Loader.instance().initializeMods();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void haltGame(String message, Throwable exception) {
/* 103 */     throw new RuntimeException(message, exception);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public File getSavesDirectory() {
/* 109 */     return ((SaveFormatOld)this.server.getActiveAnvilConverter()).savesDirectory;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public MinecraftServer getServer() {
/* 118 */     return this.server;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static FMLServerHandler instance() {
/* 126 */     return INSTANCE;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public List<String> getAdditionalBrandingInformation() {
/* 135 */     return (List<String>)ImmutableList.of();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Side getSide() {
/* 144 */     return Side.SERVER;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void showGuiScreen(Object clientGuiElement) {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void queryUser(StartupQuery query) throws InterruptedException {
/* 156 */     if (query.getResult() == null) {
/*     */       
/* 158 */       FMLLog.warning("%s", new Object[] { query.getText() });
/* 159 */       query.finish();
/*     */     }
/*     */     else {
/*     */       
/* 163 */       String text = query.getText() + "\n\nRun the command /fml confirm or or /fml cancel to proceed." + "\nAlternatively start the server with -Dfml.queryResult=confirm or -Dfml.queryResult=cancel to preselect the answer.";
/*     */ 
/*     */       
/* 166 */       FMLLog.warning("%s", new Object[] { text });
/*     */       
/* 168 */       if (!query.isSynchronous())
/*     */         return; 
/* 170 */       boolean done = false;
/*     */       
/* 172 */       while (!done && this.server.isServerRunning()) {
/*     */         
/* 174 */         if (Thread.interrupted()) throw new InterruptedException();
/*     */         
/* 176 */         DedicatedServer dedServer = (DedicatedServer)this.server;
/*     */ 
/*     */         
/* 179 */         synchronized (dedServer.pendingCommandList) {
/*     */           
/* 181 */           for (Iterator<ServerCommand> it = GenericIterableFactory.newCastingIterable(dedServer.pendingCommandList, ServerCommand.class).iterator(); it.hasNext(); ) {
/*     */             
/* 183 */             String cmd = ((ServerCommand)it.next()).command.trim().toLowerCase();
/*     */             
/* 185 */             if (cmd.equals("/fml confirm")) {
/*     */               
/* 187 */               FMLLog.info("confirmed", new Object[0]);
/* 188 */               query.setResult(true);
/* 189 */               done = true;
/* 190 */               it.remove(); continue;
/*     */             } 
/* 192 */             if (cmd.equals("/fml cancel")) {
/*     */               
/* 194 */               FMLLog.info("cancelled", new Object[0]);
/* 195 */               query.setResult(false);
/* 196 */               done = true;
/* 197 */               it.remove(); continue;
/*     */             } 
/* 199 */             if (cmd.equals("/stop"))
/*     */             {
/* 201 */               StartupQuery.abort();
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 206 */         Thread.sleep(10L);
/*     */       } 
/*     */       
/* 209 */       query.finish();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldServerShouldBeKilledQuietly() {
/* 216 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void addModAsResource(ModContainer container) {
/* 221 */     LanguageRegistry.instance().loadLanguagesFor(container, Side.SERVER);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCurrentLanguage() {
/* 227 */     return "en_US";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void serverStopped() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public NetworkManager getClientToServerNetworkManager() {
/* 238 */     throw new RuntimeException("Missing");
/*     */   }
/*     */ 
/*     */   
/*     */   public INetHandler getClientPlayHandler() {
/* 243 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void waitForPlayClient() {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void fireNetRegistrationEvent(EventBus bus, NetworkManager manager, Set<String> channelSet, String channel, Side side) {
/* 254 */     bus.post((Event)new FMLNetworkEvent.CustomPacketRegistrationEvent(manager, channelSet, channel, side, NetHandlerPlayServer.class));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean shouldAllowPlayerLogins() {
/* 260 */     return DedicatedServer.allowPlayerLogins;
/*     */   }
/*     */ 
/*     */   
/*     */   public void allowLogins() {
/* 265 */     DedicatedServer.allowPlayerLogins = true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void processWindowMessages() {}
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String stripSpecialChars(String message) {
/* 277 */     return message;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\server\FMLServerHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */