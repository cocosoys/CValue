/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.net.SocketAddress;
/*     */ import java.util.Queue;
/*     */ import javax.crypto.SecretKey;
/*     */ import net.minecraft.util.com.google.common.collect.Queues;
/*     */ import net.minecraft.util.com.google.common.util.concurrent.ThreadFactoryBuilder;
/*     */ import net.minecraft.util.io.netty.channel.Channel;
/*     */ import net.minecraft.util.io.netty.channel.ChannelFutureListener;
/*     */ import net.minecraft.util.io.netty.channel.ChannelHandler;
/*     */ import net.minecraft.util.io.netty.channel.ChannelHandlerContext;
/*     */ import net.minecraft.util.io.netty.channel.SimpleChannelInboundHandler;
/*     */ import net.minecraft.util.io.netty.channel.nio.NioEventLoopGroup;
/*     */ import net.minecraft.util.io.netty.util.AttributeKey;
/*     */ import net.minecraft.util.io.netty.util.concurrent.GenericFutureListener;
/*     */ import net.minecraft.util.org.apache.commons.lang3.Validate;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.apache.logging.log4j.Marker;
/*     */ import org.apache.logging.log4j.MarkerManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class NetworkManager
/*     */   extends SimpleChannelInboundHandler
/*     */ {
/*  27 */   private static final Logger i = LogManager.getLogger();
/*  28 */   public static final Marker a = MarkerManager.getMarker("NETWORK");
/*  29 */   public static final Marker b = MarkerManager.getMarker("NETWORK_PACKETS", a);
/*  30 */   public static final Marker c = MarkerManager.getMarker("NETWORK_STAT", a);
/*  31 */   public static final AttributeKey d = new AttributeKey("protocol");
/*  32 */   public static final AttributeKey e = new AttributeKey("receivable_packets");
/*  33 */   public static final AttributeKey f = new AttributeKey("sendable_packets");
/*  34 */   public static final NioEventLoopGroup g = new NioEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Client IO #%d").setDaemon(true).build());
/*  35 */   public static final NetworkStatistics h = new NetworkStatistics();
/*     */   private final boolean j;
/*  37 */   private final Queue k = Queues.newConcurrentLinkedQueue();
/*  38 */   private final Queue l = Queues.newConcurrentLinkedQueue();
/*     */   private Channel m;
/*     */   private SocketAddress n;
/*     */   private PacketListener o;
/*     */   private EnumProtocol p;
/*     */   private IChatBaseComponent q;
/*     */   private boolean r;
/*     */   
/*     */   public NetworkManager(boolean flag) {
/*  47 */     this.j = flag;
/*     */   }
/*     */   
/*     */   public void channelActive(ChannelHandlerContext channelhandlercontext) throws Exception {
/*  51 */     super.channelActive(channelhandlercontext);
/*  52 */     this.m = channelhandlercontext.channel();
/*  53 */     this.n = this.m.remoteAddress();
/*  54 */     a(EnumProtocol.HANDSHAKING);
/*     */   }
/*     */   
/*     */   public void a(EnumProtocol enumprotocol) {
/*  58 */     this.p = (EnumProtocol)this.m.attr(d).getAndSet(enumprotocol);
/*  59 */     this.m.attr(e).set(enumprotocol.a(this.j));
/*  60 */     this.m.attr(f).set(enumprotocol.b(this.j));
/*  61 */     this.m.config().setAutoRead(true);
/*  62 */     i.debug("Enabled auto read");
/*     */   }
/*     */   
/*     */   public void channelInactive(ChannelHandlerContext channelhandlercontext) {
/*  66 */     close(new ChatMessage("disconnect.endOfStream", new Object[0]));
/*     */   }
/*     */ 
/*     */   
/*     */   public void exceptionCaught(ChannelHandlerContext channelhandlercontext, Throwable throwable) {
/*     */     ChatMessage chatmessage;
/*  72 */     if (throwable instanceof net.minecraft.util.io.netty.handler.timeout.TimeoutException) {
/*  73 */       chatmessage = new ChatMessage("disconnect.timeout", new Object[0]);
/*     */     } else {
/*  75 */       chatmessage = new ChatMessage("disconnect.genericReason", new Object[] { "Internal Exception: " + throwable });
/*     */     } 
/*     */     
/*  78 */     close(chatmessage);
/*     */   }
/*     */   
/*     */   protected void a(ChannelHandlerContext channelhandlercontext, Packet packet) {
/*  82 */     if (this.m.isOpen()) {
/*  83 */       if (packet.a()) {
/*  84 */         packet.handle(this.o);
/*     */       } else {
/*  86 */         this.k.add(packet);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public void a(PacketListener packetlistener) {
/*  92 */     Validate.notNull(packetlistener, "packetListener", new Object[0]);
/*  93 */     i.debug("Set listener of {} to {}", new Object[] { this, packetlistener });
/*  94 */     this.o = packetlistener;
/*     */   }
/*     */   
/*     */   public void handle(Packet packet, GenericFutureListener... agenericfuturelistener) {
/*  98 */     if (this.m != null && this.m.isOpen()) {
/*  99 */       i();
/* 100 */       b(packet, agenericfuturelistener);
/*     */     } else {
/* 102 */       this.l.add(new QueuedPacket(packet, agenericfuturelistener));
/*     */     } 
/*     */   }
/*     */   
/*     */   private void b(Packet packet, GenericFutureListener[] agenericfuturelistener) {
/* 107 */     EnumProtocol enumprotocol = EnumProtocol.a(packet);
/* 108 */     EnumProtocol enumprotocol1 = (EnumProtocol)this.m.attr(d).get();
/*     */     
/* 110 */     if (enumprotocol1 != enumprotocol) {
/* 111 */       i.debug("Disabled auto read");
/* 112 */       this.m.config().setAutoRead(false);
/*     */     } 
/*     */     
/* 115 */     if (this.m.eventLoop().inEventLoop()) {
/* 116 */       if (enumprotocol != enumprotocol1) {
/* 117 */         a(enumprotocol);
/*     */       }
/*     */       
/* 120 */       this.m.writeAndFlush(packet).addListeners(agenericfuturelistener).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/*     */     } else {
/* 122 */       this.m.eventLoop().execute(new QueuedProtocolSwitch(this, enumprotocol, enumprotocol1, packet, agenericfuturelistener));
/*     */     } 
/*     */   }
/*     */   
/*     */   private void i() {
/* 127 */     if (this.m != null && this.m.isOpen()) {
/* 128 */       while (!this.l.isEmpty()) {
/* 129 */         QueuedPacket queuedpacket = this.l.poll();
/*     */         
/* 131 */         b(QueuedPacket.a(queuedpacket), QueuedPacket.b(queuedpacket));
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public void a() {
/* 137 */     i();
/* 138 */     EnumProtocol enumprotocol = (EnumProtocol)this.m.attr(d).get();
/*     */     
/* 140 */     if (this.p != enumprotocol) {
/* 141 */       if (this.p != null) {
/* 142 */         this.o.a(this.p, enumprotocol);
/*     */       }
/*     */       
/* 145 */       this.p = enumprotocol;
/*     */     } 
/*     */     
/* 148 */     if (this.o != null) {
/* 149 */       for (int i = 1000; !this.k.isEmpty() && i >= 0; i--) {
/* 150 */         Packet packet = this.k.poll();
/*     */ 
/*     */         
/* 153 */         if (isConnected() && this.m.config().isAutoRead())
/*     */         {
/*     */ 
/*     */           
/* 157 */           packet.handle(this.o);
/*     */         }
/*     */       } 
/* 160 */       this.o.a();
/*     */     } 
/*     */     
/* 163 */     this.m.flush();
/*     */   }
/*     */   
/*     */   public SocketAddress getSocketAddress() {
/* 167 */     return this.n;
/*     */   }
/*     */   
/*     */   public void close(IChatBaseComponent ichatbasecomponent) {
/* 171 */     if (this.m.isOpen()) {
/* 172 */       this.m.close();
/* 173 */       this.q = ichatbasecomponent;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean c() {
/* 178 */     return (this.m instanceof net.minecraft.util.io.netty.channel.local.LocalChannel || this.m instanceof net.minecraft.util.io.netty.channel.local.LocalServerChannel);
/*     */   }
/*     */   
/*     */   public void a(SecretKey secretkey) {
/* 182 */     this.m.pipeline().addBefore("splitter", "decrypt", (ChannelHandler)new PacketDecrypter(MinecraftEncryption.a(2, secretkey)));
/* 183 */     this.m.pipeline().addBefore("prepender", "encrypt", (ChannelHandler)new PacketEncrypter(MinecraftEncryption.a(1, secretkey)));
/* 184 */     this.r = true;
/*     */   }
/*     */   
/*     */   public boolean isConnected() {
/* 188 */     return (this.m != null && this.m.isOpen());
/*     */   }
/*     */   
/*     */   public PacketListener getPacketListener() {
/* 192 */     return this.o;
/*     */   }
/*     */   
/*     */   public IChatBaseComponent f() {
/* 196 */     return this.q;
/*     */   }
/*     */   
/*     */   public void g() {
/* 200 */     this.m.config().setAutoRead(false);
/*     */   }
/*     */   
/*     */   protected void channelRead0(ChannelHandlerContext channelhandlercontext, Object object) {
/* 204 */     a(channelhandlercontext, (Packet)object);
/*     */   }
/*     */   
/*     */   static Channel a(NetworkManager networkmanager) {
/* 208 */     return networkmanager.m;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\NetworkManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */