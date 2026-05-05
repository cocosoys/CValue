/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.net.InetAddress;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import net.minecraft.util.com.google.common.util.concurrent.ThreadFactoryBuilder;
/*     */ import net.minecraft.util.io.netty.bootstrap.ServerBootstrap;
/*     */ import net.minecraft.util.io.netty.channel.ChannelFuture;
/*     */ import net.minecraft.util.io.netty.channel.ChannelHandler;
/*     */ import net.minecraft.util.io.netty.channel.EventLoopGroup;
/*     */ import net.minecraft.util.io.netty.channel.nio.NioEventLoopGroup;
/*     */ import net.minecraft.util.io.netty.channel.socket.nio.NioServerSocketChannel;
/*     */ import net.minecraft.util.io.netty.util.concurrent.GenericFutureListener;
/*     */ import org.apache.logging.log4j.LogManager;
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
/*     */ public class ServerConnection
/*     */ {
/*  30 */   private static final Logger b = LogManager.getLogger();
/*  31 */   private static final NioEventLoopGroup c = new NioEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty IO #%d").setDaemon(true).build());
/*     */   
/*     */   private final MinecraftServer d;
/*     */   public volatile boolean a;
/*  35 */   private final List e = Collections.synchronizedList(new ArrayList());
/*  36 */   private final List f = Collections.synchronizedList(new ArrayList());
/*     */   
/*     */   public ServerConnection(MinecraftServer paramMinecraftServer) {
/*  39 */     this.d = paramMinecraftServer;
/*  40 */     this.a = true;
/*     */   }
/*     */   
/*     */   public void a(InetAddress paramInetAddress, int paramInt) {
/*  44 */     synchronized (this.e) {
/*  45 */       this.e.add(((ServerBootstrap)((ServerBootstrap)(new ServerBootstrap()).channel(NioServerSocketChannel.class)).childHandler((ChannelHandler)new ServerConnectionChannel(this)).group((EventLoopGroup)c).localAddress(paramInetAddress, paramInt)).bind().syncUninterruptibly());
/*     */     } 
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
/*     */   public void b() {
/* 110 */     this.a = false;
/*     */     
/* 112 */     for (ChannelFuture channelFuture : this.e) {
/* 113 */       channelFuture.channel().close().syncUninterruptibly();
/*     */     }
/*     */   }
/*     */   
/*     */   public void c() {
/* 118 */     synchronized (this.f) {
/* 119 */       Iterator<NetworkManager> iterator = this.f.iterator();
/*     */       
/* 121 */       while (iterator.hasNext()) {
/* 122 */         NetworkManager networkManager = iterator.next();
/*     */         
/* 124 */         if (!networkManager.isConnected()) {
/* 125 */           iterator.remove();
/*     */           
/* 127 */           if (networkManager.f() != null) {
/* 128 */             networkManager.getPacketListener().a(networkManager.f()); continue;
/* 129 */           }  if (networkManager.getPacketListener() != null)
/* 130 */             networkManager.getPacketListener().a(new ChatComponentText("Disconnected")); 
/*     */           continue;
/*     */         } 
/*     */         try {
/* 134 */           networkManager.a();
/* 135 */         } catch (Exception exception) {
/* 136 */           if (networkManager.c()) {
/* 137 */             CrashReport crashReport = CrashReport.a(exception, "Ticking memory connection");
/* 138 */             CrashReportSystemDetails crashReportSystemDetails = crashReport.a("Ticking connection");
/*     */             
/* 140 */             crashReportSystemDetails.a("Connection", new CrashReportServerConnection(this, networkManager));
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 147 */             throw new ReportedException(crashReport);
/*     */           } 
/* 149 */           b.warn("Failed to handle packet for " + networkManager.getSocketAddress(), exception);
/* 150 */           ChatComponentText chatComponentText = new ChatComponentText("Internal server error");
/* 151 */           networkManager.handle(new PacketPlayOutKickDisconnect(chatComponentText), new GenericFutureListener[] { new ServerConnectionFuture(this, networkManager, chatComponentText) });
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 157 */           networkManager.g();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MinecraftServer d() {
/* 166 */     return this.d;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ServerConnection.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */