/*     */ package net.minecraft.network;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.bootstrap.ServerBootstrap;
/*     */ import io.netty.channel.Channel;
/*     */ import io.netty.channel.ChannelException;
/*     */ import io.netty.channel.ChannelFuture;
/*     */ import io.netty.channel.ChannelHandler;
/*     */ import io.netty.channel.ChannelInitializer;
/*     */ import io.netty.channel.ChannelOption;
/*     */ import io.netty.channel.EventLoopGroup;
/*     */ import io.netty.handler.timeout.ReadTimeoutHandler;
/*     */ import io.netty.util.concurrent.Future;
/*     */ import io.netty.util.concurrent.GenericFutureListener;
/*     */ import java.net.InetAddress;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.Callable;
/*     */ import net.minecraft.client.network.NetHandlerHandshakeMemory;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MessageDeserializer;
/*     */ import net.minecraft.util.MessageDeserializer2;
/*     */ import net.minecraft.util.MessageSerializer2;
/*     */ 
/*     */ public class NetworkSystem {
/*  30 */   private static final Logger field_151275_b = LogManager.getLogger();
/*  31 */   private static final NioEventLoopGroup field_151276_c = new NioEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty IO #%d").setDaemon(true).build());
/*     */   
/*     */   private final MinecraftServer field_151273_d;
/*     */   public volatile boolean field_151277_a;
/*  35 */   private final List field_151274_e = Collections.synchronizedList(new ArrayList());
/*  36 */   private final List field_151272_f = Collections.synchronizedList(new ArrayList()); private static final String __OBFID = "CL_00001447";
/*     */   
/*     */   public NetworkSystem(MinecraftServer p_i45292_1_) {
/*  39 */     this.field_151273_d = p_i45292_1_;
/*  40 */     this.field_151277_a = true;
/*     */   }
/*     */   
/*     */   public void func_151265_a(InetAddress p_151265_1_, int p_151265_2_) throws IOException {
/*  44 */     synchronized (this.field_151274_e) {
/*  45 */       this.field_151274_e.add(((ServerBootstrap)((ServerBootstrap)(new ServerBootstrap()).channel(NioServerSocketChannel.class)).childHandler((ChannelHandler)new ChannelInitializer(this)
/*     */             {
/*     */               private static final String __OBFID = "CL_00001448";
/*     */               
/*     */               protected void initChannel(Channel p_initChannel_1_) {
/*     */                 try {
/*  51 */                   p_initChannel_1_.config().setOption(ChannelOption.IP_TOS, Integer.valueOf(24));
/*  52 */                 } catch (ChannelException channelException) {}
/*     */ 
/*     */                 
/*     */                 try {
/*  56 */                   p_initChannel_1_.config().setOption(ChannelOption.TCP_NODELAY, Boolean.valueOf(false));
/*  57 */                 } catch (ChannelException channelException) {}
/*     */ 
/*     */                 
/*  60 */                 p_initChannel_1_.pipeline().addLast("timeout", (ChannelHandler)new ReadTimeoutHandler(30)).addLast("legacy_query", (ChannelHandler)new PingResponseHandler(this.field_151264_a)).addLast("splitter", (ChannelHandler)new MessageDeserializer2()).addLast("decoder", (ChannelHandler)new MessageDeserializer(NetworkManager.field_152462_h)).addLast("prepender", (ChannelHandler)new MessageSerializer2()).addLast("encoder", (ChannelHandler)new MessageSerializer(NetworkManager.field_152462_h));
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
/*  71 */                 NetworkManager networkManager = new NetworkManager(false);
/*  72 */                 this.field_151264_a.field_151272_f.add(networkManager);
/*  73 */                 p_initChannel_1_.pipeline().addLast("packet_handler", (ChannelHandler)networkManager);
/*  74 */                 networkManager.func_150719_a((INetHandler)new NetHandlerHandshakeTCP(this.field_151264_a.field_151273_d, networkManager));
/*     */               }
/*     */             }).group((EventLoopGroup)field_151276_c).localAddress(p_151265_1_, p_151265_2_)).bind().syncUninterruptibly());
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public SocketAddress func_151270_a() {
/*     */     ChannelFuture channelFuture;
/*  87 */     synchronized (this.field_151274_e) {
/*  88 */       channelFuture = ((ServerBootstrap)((ServerBootstrap)(new ServerBootstrap()).channel(LocalServerChannel.class)).childHandler((ChannelHandler)new ChannelInitializer(this)
/*     */           {
/*     */             private static final String __OBFID = "CL_00001449";
/*     */             
/*     */             protected void initChannel(Channel p_initChannel_1_) {
/*  93 */               NetworkManager networkManager = new NetworkManager(false);
/*  94 */               networkManager.func_150719_a((INetHandler)new NetHandlerHandshakeMemory(this.field_151281_a.field_151273_d, networkManager));
/*  95 */               this.field_151281_a.field_151272_f.add(networkManager);
/*  96 */               p_initChannel_1_.pipeline().addLast("packet_handler", (ChannelHandler)networkManager);
/*     */             }
/*     */           }).group((EventLoopGroup)field_151276_c).localAddress((SocketAddress)LocalAddress.ANY)).bind().syncUninterruptibly();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 103 */       this.field_151274_e.add(channelFuture);
/*     */     } 
/*     */     
/* 106 */     return channelFuture.channel().localAddress();
/*     */   }
/*     */   
/*     */   public void func_151268_b() {
/* 110 */     this.field_151277_a = false;
/*     */     
/* 112 */     for (ChannelFuture channelFuture : this.field_151274_e) {
/* 113 */       channelFuture.channel().close().syncUninterruptibly();
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_151269_c() {
/* 118 */     synchronized (this.field_151272_f) {
/* 119 */       Iterator<NetworkManager> iterator = this.field_151272_f.iterator();
/*     */       
/* 121 */       while (iterator.hasNext()) {
/* 122 */         NetworkManager networkManager = iterator.next();
/*     */         
/* 124 */         if (!networkManager.func_150724_d()) {
/* 125 */           iterator.remove();
/*     */           
/* 127 */           if (networkManager.func_150730_f() != null) {
/* 128 */             networkManager.func_150729_e().func_147231_a(networkManager.func_150730_f()); continue;
/* 129 */           }  if (networkManager.func_150729_e() != null)
/* 130 */             networkManager.func_150729_e().func_147231_a((IChatComponent)new ChatComponentText("Disconnected")); 
/*     */           continue;
/*     */         } 
/*     */         try {
/* 134 */           networkManager.func_74428_b();
/* 135 */         } catch (Exception exception) {
/* 136 */           if (networkManager.func_150731_c()) {
/* 137 */             CrashReport crashReport = CrashReport.func_85055_a(exception, "Ticking memory connection");
/* 138 */             CrashReportCategory crashReportCategory = crashReport.func_85058_a("Ticking connection");
/*     */             
/* 140 */             crashReportCategory.func_71500_a("Connection", new Callable(this, networkManager) { private static final String __OBFID = "CL_00001450";
/*     */                   
/*     */                   public String call() {
/* 143 */                     return this.field_151280_a.toString();
/*     */                   } }
/*     */               );
/*     */             
/* 147 */             throw new ReportedException(crashReport);
/*     */           } 
/* 149 */           field_151275_b.warn("Failed to handle packet for " + networkManager.func_74430_c(), exception);
/* 150 */           ChatComponentText chatComponentText = new ChatComponentText("Internal server error");
/* 151 */           networkManager.func_150725_a((Packet)new S40PacketDisconnect((IChatComponent)chatComponentText), new GenericFutureListener[] { new GenericFutureListener(this, networkManager, chatComponentText) { private static final String __OBFID = "CL_00001451";
/*     */                   
/*     */                   public void operationComplete(Future p_operationComplete_1_) {
/* 154 */                     this.field_151284_a.func_150718_a((IChatComponent)this.field_151282_b);
/*     */                   } }
/*     */                  });
/* 157 */           networkManager.func_150721_g();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MinecraftServer func_151267_d() {
/* 166 */     return this.field_151273_d;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\NetworkSystem.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */