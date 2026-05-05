/*     */ package cpw.mods.fml.common.network;
/*     */ 
/*     */ import com.google.common.collect.ImmutableSet;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.common.network.internal.FMLProxyPacket;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import java.util.Set;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.play.INetHandlerPlayClient;
/*     */ import net.minecraft.network.play.INetHandlerPlayServer;
/*     */ 
/*     */ public class FMLNetworkEvent<T extends INetHandler>
/*     */   extends Event
/*     */ {
/*     */   public final T handler;
/*     */   public final NetworkManager manager;
/*     */   private final Class<T> type;
/*     */   
/*     */   FMLNetworkEvent(T thing, Class<T> type, NetworkManager manager) {
/*  21 */     this.handler = thing;
/*  22 */     this.type = type;
/*  23 */     this.manager = manager;
/*     */   }
/*     */ 
/*     */   
/*     */   public static class ClientConnectedToServerEvent
/*     */     extends FMLNetworkEvent<INetHandlerPlayClient>
/*     */   {
/*     */     public final boolean isLocal;
/*     */     
/*     */     public final String connectionType;
/*     */     
/*     */     public ClientConnectedToServerEvent(NetworkManager manager, String connectionType) {
/*  35 */       super((INetHandlerPlayClient)manager.getNetHandler(), INetHandlerPlayClient.class, manager);
/*  36 */       this.isLocal = manager.isLocalChannel();
/*  37 */       this.connectionType = connectionType;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ServerConnectionFromClientEvent
/*     */     extends FMLNetworkEvent<INetHandlerPlayServer>
/*     */   {
/*     */     public final boolean isLocal;
/*     */ 
/*     */ 
/*     */     
/*     */     public ServerConnectionFromClientEvent(NetworkManager manager) {
/*  51 */       super((INetHandlerPlayServer)manager.getNetHandler(), INetHandlerPlayServer.class, manager);
/*  52 */       this.isLocal = manager.isLocalChannel();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ServerDisconnectionFromClientEvent
/*     */     extends FMLNetworkEvent<INetHandlerPlayServer>
/*     */   {
/*     */     public ServerDisconnectionFromClientEvent(NetworkManager manager) {
/*  64 */       super((INetHandlerPlayServer)manager.getNetHandler(), INetHandlerPlayServer.class, manager);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ClientDisconnectionFromServerEvent
/*     */     extends FMLNetworkEvent<INetHandlerPlayClient>
/*     */   {
/*     */     public ClientDisconnectionFromServerEvent(NetworkManager manager) {
/*  76 */       super((INetHandlerPlayClient)manager.getNetHandler(), INetHandlerPlayClient.class, manager);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CustomPacketRegistrationEvent<S extends INetHandler>
/*     */     extends FMLNetworkEvent<S>
/*     */   {
/*     */     public final ImmutableSet<String> registrations;
/*     */     
/*     */     public final String operation;
/*     */     
/*     */     public final Side side;
/*     */ 
/*     */     
/*     */     public CustomPacketRegistrationEvent(NetworkManager manager, Set<String> registrations, String operation, Side side, Class<S> type) {
/*  93 */       super(type.cast(manager.getNetHandler()), type, manager);
/*  94 */       this.registrations = ImmutableSet.copyOf(registrations);
/*  95 */       this.side = side;
/*  96 */       this.operation = operation;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static abstract class CustomPacketEvent<S extends INetHandler>
/*     */     extends FMLNetworkEvent<S>
/*     */   {
/*     */     public final FMLProxyPacket packet;
/*     */ 
/*     */     
/*     */     public FMLProxyPacket reply;
/*     */ 
/*     */     
/*     */     CustomPacketEvent(S thing, Class<S> type, NetworkManager manager, FMLProxyPacket packet) {
/* 112 */       super(thing, type, manager);
/* 113 */       this.packet = packet;
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public abstract Side side();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ClientCustomPacketEvent
/*     */     extends CustomPacketEvent<INetHandlerPlayClient>
/*     */   {
/*     */     public ClientCustomPacketEvent(NetworkManager manager, FMLProxyPacket packet) {
/* 127 */       super((INetHandlerPlayClient)manager.getNetHandler(), INetHandlerPlayClient.class, manager, packet);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Side side() {
/* 133 */       return Side.CLIENT;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static class ServerCustomPacketEvent
/*     */     extends CustomPacketEvent<INetHandlerPlayServer>
/*     */   {
/*     */     public ServerCustomPacketEvent(NetworkManager manager, FMLProxyPacket packet) {
/* 145 */       super((INetHandlerPlayServer)manager.getNetHandler(), INetHandlerPlayServer.class, manager, packet);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public Side side() {
/* 151 */       return Side.SERVER;
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static class CustomNetworkEvent
/*     */     extends Event
/*     */   {
/*     */     public final Object wrappedEvent;
/*     */ 
/*     */ 
/*     */     
/*     */     public CustomNetworkEvent(Object wrappedEvent) {
/* 165 */       this.wrappedEvent = wrappedEvent;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\FMLNetworkEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */