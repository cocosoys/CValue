/*     */ package cpw.mods.fml.common.network.handshake;
/*     */ 
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.FMLLog;
/*     */ import cpw.mods.fml.common.eventhandler.Event;
/*     */ import cpw.mods.fml.common.network.FMLNetworkEvent;
/*     */ import cpw.mods.fml.common.network.FMLNetworkException;
/*     */ import cpw.mods.fml.common.network.FMLOutboundHandler;
/*     */ import cpw.mods.fml.common.network.NetworkRegistry;
/*     */ import cpw.mods.fml.common.network.internal.FMLMessage;
/*     */ import cpw.mods.fml.common.network.internal.FMLNetworkHandler;
/*     */ import cpw.mods.fml.common.network.internal.FMLProxyPacket;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import io.netty.channel.ChannelHandler;
/*     */ import io.netty.channel.ChannelHandlerContext;
/*     */ import io.netty.channel.ChannelInboundHandlerAdapter;
/*     */ import io.netty.channel.ChannelOutboundHandler;
/*     */ import io.netty.channel.ChannelPromise;
/*     */ import io.netty.channel.SimpleChannelInboundHandler;
/*     */ import io.netty.channel.embedded.EmbeddedChannel;
/*     */ import io.netty.util.AttributeKey;
/*     */ import io.netty.util.concurrent.Future;
/*     */ import io.netty.util.concurrent.GenericFutureListener;
/*     */ import io.netty.util.concurrent.ScheduledFuture;
/*     */ import java.net.SocketAddress;
/*     */ import java.util.List;
/*     */ import java.util.Locale;
/*     */ import java.util.concurrent.Callable;
/*     */ import java.util.concurrent.TimeUnit;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.network.EnumConnectionState;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.NetHandlerPlayServer;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.client.C17PacketCustomPayload;
/*     */ import net.minecraft.network.play.server.S01PacketJoinGame;
/*     */ import net.minecraft.network.play.server.S3FPacketCustomPayload;
/*     */ import net.minecraft.network.play.server.S40PacketDisconnect;
/*     */ import net.minecraft.server.management.ServerConfigurationManager;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import org.apache.logging.log4j.Level;
/*     */ 
/*     */ public class NetworkDispatcher
/*     */   extends SimpleChannelInboundHandler<Packet> implements ChannelOutboundHandler {
/*     */   private enum ConnectionState {
/*  49 */     OPENING, AWAITING_HANDSHAKE, HANDSHAKING, HANDSHAKECOMPLETE, CONNECTED;
/*     */   }
/*     */   
/*     */   private enum ConnectionType {
/*  53 */     MODDED, BUKKIT, VANILLA;
/*     */   }
/*     */ 
/*     */   
/*     */   public static NetworkDispatcher get(NetworkManager manager) {
/*  58 */     return (NetworkDispatcher)manager.channel().attr(FML_DISPATCHER).get();
/*     */   }
/*     */ 
/*     */   
/*     */   public static NetworkDispatcher allocAndSet(NetworkManager manager) {
/*  63 */     NetworkDispatcher net = new NetworkDispatcher(manager);
/*  64 */     manager.channel().attr(FML_DISPATCHER).getAndSet(net);
/*  65 */     return net;
/*     */   }
/*     */ 
/*     */   
/*     */   public static NetworkDispatcher allocAndSet(NetworkManager manager, ServerConfigurationManager scm) {
/*  70 */     NetworkDispatcher net = new NetworkDispatcher(manager, scm);
/*  71 */     manager.channel().attr(FML_DISPATCHER).getAndSet(net);
/*  72 */     return net;
/*     */   }
/*     */   
/*  75 */   public static final AttributeKey<NetworkDispatcher> FML_DISPATCHER = new AttributeKey("fml:dispatcher");
/*  76 */   public static final AttributeKey<Boolean> IS_LOCAL = new AttributeKey("fml:isLocal");
/*     */   
/*     */   public final NetworkManager manager;
/*     */   private final ServerConfigurationManager scm;
/*     */   private EntityPlayerMP player;
/*     */   private ConnectionState state;
/*     */   private ConnectionType connectionType;
/*     */   private final Side side;
/*     */   private final EmbeddedChannel handshakeChannel;
/*     */   private NetHandlerPlayServer serverHandler;
/*     */   private INetHandler netHandler;
/*     */   private int overrideLoginDim;
/*     */   
/*     */   public NetworkDispatcher(NetworkManager manager) {
/*  90 */     super(Packet.class, false);
/*  91 */     this.manager = manager;
/*  92 */     this.scm = null;
/*  93 */     this.side = Side.CLIENT;
/*  94 */     this.handshakeChannel = new EmbeddedChannel(new ChannelHandler[] { (ChannelHandler)new HandshakeInjector(this), (ChannelHandler)new ChannelRegistrationHandler(), (ChannelHandler)new FMLHandshakeCodec(), (ChannelHandler)new HandshakeMessageHandler<FMLHandshakeClientState>(FMLHandshakeClientState.class) });
/*  95 */     this.handshakeChannel.attr(FML_DISPATCHER).set(this);
/*  96 */     this.handshakeChannel.attr(NetworkRegistry.CHANNEL_SOURCE).set(Side.SERVER);
/*  97 */     this.handshakeChannel.attr(NetworkRegistry.FML_CHANNEL).set("FML|HS");
/*  98 */     this.handshakeChannel.attr(IS_LOCAL).set(Boolean.valueOf(manager.isLocalChannel()));
/*     */   }
/*     */ 
/*     */   
/*     */   public NetworkDispatcher(NetworkManager manager, ServerConfigurationManager scm) {
/* 103 */     super(Packet.class, false);
/* 104 */     this.manager = manager;
/* 105 */     this.scm = scm;
/* 106 */     this.side = Side.SERVER;
/* 107 */     this.handshakeChannel = new EmbeddedChannel(new ChannelHandler[] { (ChannelHandler)new HandshakeInjector(this), (ChannelHandler)new ChannelRegistrationHandler(), (ChannelHandler)new FMLHandshakeCodec(), (ChannelHandler)new HandshakeMessageHandler<FMLHandshakeServerState>(FMLHandshakeServerState.class) });
/* 108 */     this.handshakeChannel.attr(FML_DISPATCHER).set(this);
/* 109 */     this.handshakeChannel.attr(NetworkRegistry.CHANNEL_SOURCE).set(Side.CLIENT);
/* 110 */     this.handshakeChannel.attr(NetworkRegistry.FML_CHANNEL).set("FML|HS");
/* 111 */     this.handshakeChannel.attr(IS_LOCAL).set(Boolean.valueOf(manager.isLocalChannel()));
/*     */   }
/*     */ 
/*     */   
/*     */   public void serverToClientHandshake(EntityPlayerMP player) {
/* 116 */     this.player = player;
/* 117 */     insertIntoChannel();
/*     */   }
/*     */ 
/*     */   
/*     */   private void insertIntoChannel() {
/* 122 */     this.manager.channel().config().setAutoRead(false);
/*     */     
/* 124 */     this.manager.channel().pipeline().addBefore("packet_handler", "fml:packet_handler", (ChannelHandler)this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void clientToServerHandshake() {
/* 129 */     insertIntoChannel();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
/* 135 */     this.state = ConnectionState.OPENING;
/*     */     
/* 137 */     this.handshakeChannel.pipeline().fireUserEventTriggered(this);
/* 138 */     this.manager.channel().config().setAutoRead(true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   int serverInitiateHandshake() {
/* 145 */     this.state = ConnectionState.AWAITING_HANDSHAKE;
/* 146 */     this.manager.channel().pipeline().addFirst("fml:vanilla_detector", (ChannelHandler)new VanillaTimeoutWaiter());
/*     */     
/* 148 */     this.serverHandler = new NetHandlerPlayServer(this.scm.getServerInstance(), this.manager, this.player);
/* 149 */     this.netHandler = (INetHandler)this.serverHandler;
/*     */     
/* 151 */     this.player.playerNetServerHandler = null;
/*     */     
/* 153 */     this.manager.setConnectionState(EnumConnectionState.PLAY);
/*     */ 
/*     */ 
/*     */     
/* 157 */     NBTTagCompound playerNBT = this.scm.getPlayerNBT(this.player);
/* 158 */     if (playerNBT != null)
/*     */     {
/* 160 */       return playerNBT.getInteger("Dimension");
/*     */     }
/*     */ 
/*     */     
/* 164 */     return 0;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   void clientListenForServerHandshake() {
/* 170 */     this.manager.setConnectionState(EnumConnectionState.PLAY);
/* 171 */     FMLCommonHandler.instance().waitForPlayClient();
/* 172 */     this.netHandler = FMLCommonHandler.instance().getClientPlayHandler();
/* 173 */     this.state = ConnectionState.AWAITING_HANDSHAKE;
/*     */   }
/*     */ 
/*     */   
/*     */   private void completeClientSideConnection(ConnectionType type) {
/* 178 */     this.connectionType = type;
/* 179 */     FMLLog.info("[%s] Client side %s connection established", new Object[] { Thread.currentThread().getName(), this.connectionType.name().toLowerCase(Locale.ENGLISH) });
/* 180 */     this.state = ConnectionState.CONNECTED;
/* 181 */     FMLCommonHandler.instance().bus().post((Event)new FMLNetworkEvent.ClientConnectedToServerEvent(this.manager, this.connectionType.name()));
/*     */   }
/*     */ 
/*     */   
/*     */   private void completeServerSideConnection(ConnectionType type) {
/* 186 */     this.connectionType = type;
/* 187 */     FMLLog.info("[%s] Server side %s connection established", new Object[] { Thread.currentThread().getName(), this.connectionType.name().toLowerCase(Locale.ENGLISH) });
/* 188 */     this.state = ConnectionState.CONNECTED;
/* 189 */     FMLCommonHandler.instance().bus().post((Event)new FMLNetworkEvent.ServerConnectionFromClientEvent(this.manager));
/* 190 */     this.scm.initializeConnectionToPlayer(this.manager, this.player, this.serverHandler);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void channelRead0(ChannelHandlerContext ctx, Packet msg) throws Exception {
/* 195 */     boolean handled = false;
/* 196 */     if (msg instanceof C17PacketCustomPayload) {
/*     */       
/* 198 */       handled = handleServerSideCustomPacket((C17PacketCustomPayload)msg, ctx);
/*     */     }
/* 200 */     else if (msg instanceof S3FPacketCustomPayload) {
/*     */       
/* 202 */       handled = handleClientSideCustomPacket((S3FPacketCustomPayload)msg, ctx);
/*     */     }
/* 204 */     else if (this.state != ConnectionState.CONNECTED && this.state != ConnectionState.HANDSHAKECOMPLETE) {
/*     */       
/* 206 */       handled = handleVanilla(msg);
/*     */     } 
/* 208 */     if (!handled)
/*     */     {
/* 210 */       ctx.fireChannelRead(msg);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean handleVanilla(Packet msg) {
/* 216 */     if (this.state == ConnectionState.AWAITING_HANDSHAKE && msg instanceof S01PacketJoinGame) {
/*     */       
/* 218 */       this.handshakeChannel.pipeline().fireUserEventTriggered(msg);
/*     */     }
/*     */     else {
/*     */       
/* 222 */       FMLLog.info("Unexpected packet during modded negotiation - assuming vanilla or keepalives : %s", new Object[] { msg.getClass().getName() });
/*     */     } 
/* 224 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public INetHandler getNetHandler() {
/* 229 */     return this.netHandler;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
/* 235 */     if (evt instanceof ConnectionType && this.side == Side.SERVER) {
/*     */       
/* 237 */       FMLLog.info("Timeout occurred, assuming a vanilla client", new Object[0]);
/* 238 */       kickVanilla();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void kickVanilla() {
/* 244 */     kickWithMessage("This is modded. No modded response received. Bye!");
/*     */   }
/*     */   
/*     */   private void kickWithMessage(String message) {
/* 248 */     final ChatComponentText chatcomponenttext = new ChatComponentText(message);
/* 249 */     if (this.side == Side.CLIENT) {
/*     */       
/* 251 */       this.manager.closeChannel((IChatComponent)chatcomponenttext);
/*     */     }
/*     */     else {
/*     */       
/* 255 */       this.manager.scheduleOutboundPacket((Packet)new S40PacketDisconnect((IChatComponent)chatcomponenttext), new GenericFutureListener[] { new GenericFutureListener<Future<?>>()
/*     */             {
/*     */               
/*     */               public void operationComplete(Future<?> result)
/*     */               {
/* 260 */                 NetworkDispatcher.this.manager.closeChannel((IChatComponent)chatcomponenttext);
/*     */               }
/*     */             } });
/*     */     } 
/* 264 */     this.manager.channel().config().setAutoRead(false);
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean handleClientSideCustomPacket(S3FPacketCustomPayload msg, ChannelHandlerContext context) {
/* 269 */     String channelName = msg.func_149169_c();
/* 270 */     if ("FML|HS".equals(channelName) || "REGISTER".equals(channelName) || "UNREGISTER".equals(channelName)) {
/*     */       
/* 272 */       FMLProxyPacket proxy = new FMLProxyPacket(msg);
/* 273 */       proxy.setDispatcher(this);
/* 274 */       this.handshakeChannel.writeInbound(new Object[] { proxy });
/*     */       
/* 276 */       for (Object push : this.handshakeChannel.inboundMessages()) {
/*     */         
/* 278 */         List<FMLProxyPacket> messageResult = FMLNetworkHandler.forwardHandshake((FMLMessage.CompleteHandshake)push, this, Side.CLIENT);
/* 279 */         for (FMLProxyPacket result : messageResult) {
/*     */           
/* 281 */           result.setTarget(Side.CLIENT);
/* 282 */           result.payload().resetReaderIndex();
/* 283 */           context.fireChannelRead(result);
/*     */         } 
/*     */       } 
/* 286 */       this.handshakeChannel.inboundMessages().clear();
/* 287 */       return true;
/*     */     } 
/* 289 */     if (NetworkRegistry.INSTANCE.hasChannel(channelName, Side.CLIENT)) {
/*     */       
/* 291 */       FMLProxyPacket proxy = new FMLProxyPacket(msg);
/* 292 */       proxy.setDispatcher(this);
/* 293 */       context.fireChannelRead(proxy);
/* 294 */       return true;
/*     */     } 
/* 296 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   private boolean handleServerSideCustomPacket(C17PacketCustomPayload msg, ChannelHandlerContext context) {
/* 301 */     if (this.state == ConnectionState.AWAITING_HANDSHAKE) {
/*     */       
/* 303 */       this.manager.channel().pipeline().remove("fml:vanilla_detector");
/* 304 */       this.state = ConnectionState.HANDSHAKING;
/*     */     } 
/* 306 */     String channelName = msg.func_149559_c();
/* 307 */     if ("FML|HS".equals(channelName) || "REGISTER".equals(channelName) || "UNREGISTER".equals(channelName)) {
/*     */       
/* 309 */       FMLProxyPacket proxy = new FMLProxyPacket(msg);
/* 310 */       proxy.setDispatcher(this);
/* 311 */       this.handshakeChannel.writeInbound(new Object[] { proxy });
/* 312 */       for (Object push : this.handshakeChannel.inboundMessages()) {
/*     */         
/* 314 */         List<FMLProxyPacket> messageResult = FMLNetworkHandler.forwardHandshake((FMLMessage.CompleteHandshake)push, this, Side.SERVER);
/* 315 */         for (FMLProxyPacket result : messageResult) {
/*     */           
/* 317 */           result.setTarget(Side.SERVER);
/* 318 */           result.payload().resetReaderIndex();
/* 319 */           context.fireChannelRead(result);
/*     */         } 
/*     */       } 
/* 322 */       this.handshakeChannel.inboundMessages().clear();
/* 323 */       return true;
/*     */     } 
/* 325 */     if (NetworkRegistry.INSTANCE.hasChannel(channelName, Side.SERVER)) {
/*     */       
/* 327 */       FMLProxyPacket proxy = new FMLProxyPacket(msg);
/* 328 */       proxy.setDispatcher(this);
/* 329 */       context.fireChannelRead(proxy);
/* 330 */       return true;
/*     */     } 
/* 332 */     return false;
/*     */   }
/*     */   
/*     */   private class VanillaTimeoutWaiter
/*     */     extends ChannelInboundHandlerAdapter {
/*     */     private ScheduledFuture<Void> future;
/*     */     
/*     */     private VanillaTimeoutWaiter() {}
/*     */     
/*     */     public void handlerAdded(final ChannelHandlerContext ctx) throws Exception {
/* 342 */       this.future = ctx.executor().schedule(new Callable<Void>()
/*     */           {
/*     */             public Void call() throws Exception
/*     */             {
/* 346 */               if (NetworkDispatcher.this.state != NetworkDispatcher.ConnectionState.CONNECTED) {
/*     */                 
/* 348 */                 FMLLog.info("Timeout occurred waiting for response, assuming vanilla connection", new Object[0]);
/* 349 */                 ctx.fireUserEventTriggered(NetworkDispatcher.ConnectionType.VANILLA);
/*     */               } 
/* 351 */               return null;
/*     */             }
/*     */           }10L, TimeUnit.HOURS);
/*     */     }
/*     */ 
/*     */ 
/*     */     
/*     */     public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
/* 359 */       this.future.cancel(true);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void sendProxy(FMLProxyPacket msg) {
/* 365 */     this.manager.scheduleOutboundPacket((Packet)msg, new GenericFutureListener[0]);
/*     */   }
/*     */ 
/*     */   
/*     */   public void rejectHandshake(String result) {
/* 370 */     kickWithMessage(result);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void bind(ChannelHandlerContext ctx, SocketAddress localAddress, ChannelPromise promise) throws Exception {
/* 376 */     ctx.bind(localAddress, promise);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void connect(ChannelHandlerContext ctx, SocketAddress remoteAddress, SocketAddress localAddress, ChannelPromise promise) throws Exception {
/* 382 */     ctx.connect(remoteAddress, localAddress, promise);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void disconnect(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
/* 388 */     if (this.side == Side.CLIENT) {
/*     */       
/* 390 */       FMLCommonHandler.instance().bus().post((Event)new FMLNetworkEvent.ClientDisconnectionFromServerEvent(this.manager));
/*     */     }
/*     */     else {
/*     */       
/* 394 */       FMLCommonHandler.instance().bus().post((Event)new FMLNetworkEvent.ServerDisconnectionFromClientEvent(this.manager));
/*     */     } 
/* 396 */     cleanAttributes(ctx);
/* 397 */     ctx.disconnect(promise);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
/* 403 */     if (this.side == Side.CLIENT) {
/*     */       
/* 405 */       FMLCommonHandler.instance().bus().post((Event)new FMLNetworkEvent.ClientDisconnectionFromServerEvent(this.manager));
/*     */     }
/*     */     else {
/*     */       
/* 409 */       FMLCommonHandler.instance().bus().post((Event)new FMLNetworkEvent.ServerDisconnectionFromClientEvent(this.manager));
/*     */     } 
/* 411 */     cleanAttributes(ctx);
/* 412 */     ctx.close(promise);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @Deprecated
/*     */   public void deregister(ChannelHandlerContext ctx, ChannelPromise promise) throws Exception {
/* 419 */     ctx.deregister(promise);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void read(ChannelHandlerContext ctx) throws Exception {
/* 425 */     ctx.read();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
/* 431 */     if (msg instanceof FMLProxyPacket) {
/*     */       
/* 433 */       if (this.side == Side.CLIENT) {
/* 434 */         ctx.write(((FMLProxyPacket)msg).toC17Packet(), promise);
/*     */       } else {
/* 436 */         ctx.write(((FMLProxyPacket)msg).toS3FPacket(), promise);
/*     */       } 
/*     */     } else {
/*     */       
/* 440 */       ctx.write(msg, promise);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void flush(ChannelHandlerContext ctx) throws Exception {
/* 447 */     ctx.flush();
/*     */   }
/*     */ 
/*     */   
/*     */   public void completeHandshake(Side target) {
/* 452 */     if (this.state == ConnectionState.CONNECTED) {
/*     */       
/* 454 */       FMLLog.severe("Attempt to double complete the network connection!", new Object[0]);
/* 455 */       throw new FMLNetworkException("Attempt to double complete!");
/*     */     } 
/* 457 */     if (this.side == Side.CLIENT) {
/*     */       
/* 459 */       completeClientSideConnection(ConnectionType.MODDED);
/*     */     }
/*     */     else {
/*     */       
/* 463 */       completeServerSideConnection(ConnectionType.MODDED);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void completeClientHandshake() {
/* 469 */     this.state = ConnectionState.HANDSHAKECOMPLETE;
/*     */   }
/*     */ 
/*     */   
/*     */   public void abortClientHandshake(String type) {
/* 474 */     FMLLog.log(Level.INFO, "Aborting client handshake \"%s\"", new Object[] { type });
/* 475 */     FMLCommonHandler.instance().waitForPlayClient();
/* 476 */     completeClientSideConnection(ConnectionType.valueOf(type));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
/* 483 */     if (!(cause instanceof java.nio.channels.ClosedChannelException))
/*     */     {
/* 485 */       FMLLog.log(Level.ERROR, cause, "NetworkDispatcher exception", new Object[0]);
/*     */     }
/* 487 */     super.exceptionCaught(ctx, cause);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void cleanAttributes(ChannelHandlerContext ctx) {
/* 494 */     ctx.channel().attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).remove();
/* 495 */     ctx.channel().attr(NetworkRegistry.NET_HANDLER).remove();
/* 496 */     ctx.channel().attr(FML_DISPATCHER).remove();
/* 497 */     this.handshakeChannel.attr(FML_DISPATCHER).remove();
/* 498 */     this.manager.channel().attr(FML_DISPATCHER).remove();
/*     */   }
/*     */   
/*     */   public void setOverrideDimension(int overrideDim) {
/* 502 */     this.overrideLoginDim = overrideDim;
/* 503 */     FMLLog.fine("Received override dimension %d", new Object[] { Integer.valueOf(overrideDim) });
/*     */   }
/*     */   
/*     */   public int getOverrideDimension(S01PacketJoinGame p_147282_1_) {
/* 507 */     FMLLog.fine("Overriding dimension: using %d", new Object[] { Integer.valueOf(this.overrideLoginDim) });
/* 508 */     return (this.overrideLoginDim != 0) ? this.overrideLoginDim : p_147282_1_.func_149194_f();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\handshake\NetworkDispatcher.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */