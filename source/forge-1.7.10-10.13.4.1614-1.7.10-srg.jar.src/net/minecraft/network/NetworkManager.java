/*     */ package net.minecraft.network;
/*     */ import com.google.common.collect.Queues;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.bootstrap.Bootstrap;
/*     */ import io.netty.channel.Channel;
/*     */ import io.netty.channel.ChannelException;
/*     */ import io.netty.channel.ChannelFutureListener;
/*     */ import io.netty.channel.ChannelHandler;
/*     */ import io.netty.channel.ChannelHandlerContext;
/*     */ import io.netty.channel.ChannelInitializer;
/*     */ import io.netty.channel.ChannelOption;
/*     */ import io.netty.channel.EventLoopGroup;
/*     */ import io.netty.channel.SimpleChannelInboundHandler;
/*     */ import io.netty.channel.nio.NioEventLoopGroup;
/*     */ import io.netty.handler.timeout.ReadTimeoutHandler;
/*     */ import io.netty.util.AttributeKey;
/*     */ import io.netty.util.concurrent.GenericFutureListener;
/*     */ import java.net.InetAddress;
/*     */ import java.net.SocketAddress;
/*     */ import java.util.Queue;
/*     */ import javax.crypto.SecretKey;
/*     */ import net.minecraft.util.ChatComponentTranslation;
/*     */ import net.minecraft.util.CryptManager;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MessageDeserializer;
/*     */ import net.minecraft.util.MessageDeserializer2;
/*     */ import net.minecraft.util.MessageSerializer;
/*     */ import net.minecraft.util.MessageSerializer2;
/*     */ import org.apache.logging.log4j.Marker;
/*     */ import org.apache.logging.log4j.MarkerManager;
/*     */ 
/*     */ public class NetworkManager extends SimpleChannelInboundHandler {
/*  34 */   private static final Logger field_150735_g = LogManager.getLogger();
/*     */   
/*  36 */   public static final Marker field_150740_a = MarkerManager.getMarker("NETWORK");
/*     */   
/*  38 */   public static final Marker field_150738_b = MarkerManager.getMarker("NETWORK_PACKETS", field_150740_a);
/*  39 */   public static final Marker field_152461_c = MarkerManager.getMarker("NETWORK_STAT", field_150740_a);
/*  40 */   public static final AttributeKey field_150739_c = new AttributeKey("protocol");
/*  41 */   public static final AttributeKey field_150736_d = new AttributeKey("receivable_packets");
/*  42 */   public static final AttributeKey field_150737_e = new AttributeKey("sendable_packets");
/*  43 */   public static final NioEventLoopGroup field_150734_f = new NioEventLoopGroup(0, (new ThreadFactoryBuilder()).setNameFormat("Netty Client IO #%d").setDaemon(true).build());
/*  44 */   public static final NetworkStatistics field_152462_h = new NetworkStatistics();
/*     */ 
/*     */   
/*     */   private final boolean field_150747_h;
/*     */   
/*  49 */   private final Queue field_150748_i = Queues.newConcurrentLinkedQueue();
/*  50 */   private final Queue field_150745_j = Queues.newConcurrentLinkedQueue(); private Channel field_150746_k;
/*     */   private SocketAddress field_150743_l;
/*     */   private INetHandler field_150744_m;
/*     */   private EnumConnectionState field_150741_n;
/*     */   private IChatComponent field_150742_o;
/*     */   private boolean field_152463_r;
/*     */   private static final String __OBFID = "CL_00001240";
/*     */   
/*     */   public NetworkManager(boolean p_i45147_1_) {
/*  59 */     this.field_150747_h = p_i45147_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void channelActive(ChannelHandlerContext p_channelActive_1_) throws Exception {
/*  64 */     super.channelActive(p_channelActive_1_);
/*  65 */     this.field_150746_k = p_channelActive_1_.channel();
/*  66 */     this.field_150743_l = this.field_150746_k.remoteAddress();
/*  67 */     func_150723_a(EnumConnectionState.HANDSHAKING);
/*     */   }
/*     */   
/*     */   public void func_150723_a(EnumConnectionState p_150723_1_) {
/*  71 */     this.field_150741_n = (EnumConnectionState)this.field_150746_k.attr(field_150739_c).getAndSet(p_150723_1_);
/*  72 */     this.field_150746_k.attr(field_150736_d).set(p_150723_1_.func_150757_a(this.field_150747_h));
/*  73 */     this.field_150746_k.attr(field_150737_e).set(p_150723_1_.func_150754_b(this.field_150747_h));
/*  74 */     this.field_150746_k.config().setAutoRead(true);
/*  75 */     field_150735_g.debug("Enabled auto read");
/*     */   }
/*     */ 
/*     */   
/*     */   public void channelInactive(ChannelHandlerContext p_channelInactive_1_) {
/*  80 */     func_150718_a((IChatComponent)new ChatComponentTranslation("disconnect.endOfStream", new Object[0]));
/*     */   }
/*     */ 
/*     */   
/*     */   public void exceptionCaught(ChannelHandlerContext p_exceptionCaught_1_, Throwable p_exceptionCaught_2_) {
/*     */     ChatComponentTranslation chatComponentTranslation;
/*  86 */     if (p_exceptionCaught_2_ instanceof io.netty.handler.timeout.TimeoutException) {
/*  87 */       chatComponentTranslation = new ChatComponentTranslation("disconnect.timeout", new Object[0]);
/*     */     } else {
/*  89 */       chatComponentTranslation = new ChatComponentTranslation("disconnect.genericReason", new Object[] { "Internal Exception: " + p_exceptionCaught_2_ });
/*     */     } 
/*     */     
/*  92 */     func_150718_a((IChatComponent)chatComponentTranslation);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void channelRead0(ChannelHandlerContext p_channelRead0_1_, Packet p_channelRead0_2_) {
/*  98 */     if (this.field_150746_k.isOpen()) {
/*  99 */       if (p_channelRead0_2_.func_148836_a()) {
/* 100 */         p_channelRead0_2_.func_148833_a(this.field_150744_m);
/*     */       } else {
/* 102 */         this.field_150748_i.add(p_channelRead0_2_);
/*     */       } 
/*     */     }
/*     */   }
/*     */   
/*     */   public void func_150719_a(INetHandler p_150719_1_) {
/* 108 */     Validate.notNull(p_150719_1_, "packetListener", new Object[0]);
/* 109 */     field_150735_g.debug("Set listener of {} to {}", new Object[] { this, p_150719_1_ });
/* 110 */     this.field_150744_m = p_150719_1_;
/*     */   }
/*     */   
/*     */   public void func_150725_a(Packet p_150725_1_, GenericFutureListener... p_150725_2_) {
/* 114 */     if (this.field_150746_k != null && this.field_150746_k.isOpen()) {
/* 115 */       func_150733_h();
/* 116 */       func_150732_b(p_150725_1_, p_150725_2_);
/*     */     } else {
/* 118 */       this.field_150745_j.add(new InboundHandlerTuplePacketListener(p_150725_1_, p_150725_2_));
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_150732_b(Packet p_150732_1_, GenericFutureListener[] p_150732_2_) {
/* 123 */     EnumConnectionState enumConnectionState1 = EnumConnectionState.func_150752_a(p_150732_1_);
/* 124 */     EnumConnectionState enumConnectionState2 = (EnumConnectionState)this.field_150746_k.attr(field_150739_c).get();
/*     */     
/* 126 */     if (enumConnectionState2 != enumConnectionState1) {
/* 127 */       field_150735_g.debug("Disabled auto read");
/* 128 */       this.field_150746_k.config().setAutoRead(false);
/*     */     } 
/*     */     
/* 131 */     if (this.field_150746_k.eventLoop().inEventLoop()) {
/* 132 */       if (enumConnectionState1 != enumConnectionState2) {
/* 133 */         func_150723_a(enumConnectionState1);
/*     */       }
/* 135 */       this.field_150746_k.writeAndFlush(p_150732_1_).addListeners(p_150732_2_).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/*     */     } else {
/* 137 */       this.field_150746_k.eventLoop().execute(new Runnable(this, enumConnectionState1, enumConnectionState2, p_150732_1_, p_150732_2_) { private static final String __OBFID = "CL_00001241";
/*     */             
/*     */             public void run() {
/* 140 */               if (this.field_150717_a != this.field_150715_b) {
/* 141 */                 this.field_150714_e.func_150723_a(this.field_150717_a);
/*     */               }
/* 143 */               this.field_150714_e.field_150746_k.writeAndFlush(this.field_150716_c).addListeners(this.field_150713_d).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/*     */             } }
/*     */         );
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_150733_h() {
/* 150 */     if (this.field_150746_k == null || !this.field_150746_k.isOpen()) {
/*     */       return;
/*     */     }
/*     */     
/* 154 */     while (!this.field_150745_j.isEmpty()) {
/* 155 */       InboundHandlerTuplePacketListener inboundHandlerTuplePacketListener = this.field_150745_j.poll();
/* 156 */       func_150732_b(inboundHandlerTuplePacketListener.field_150774_a, inboundHandlerTuplePacketListener.field_150773_b);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_74428_b() {
/* 162 */     func_150733_h();
/*     */     
/* 164 */     EnumConnectionState enumConnectionState = (EnumConnectionState)this.field_150746_k.attr(field_150739_c).get();
/*     */     
/* 166 */     if (this.field_150741_n != enumConnectionState) {
/* 167 */       if (this.field_150741_n != null) this.field_150744_m.func_147232_a(this.field_150741_n, enumConnectionState); 
/* 168 */       this.field_150741_n = enumConnectionState;
/*     */     } 
/*     */     
/* 171 */     if (this.field_150744_m != null) {
/* 172 */       for (char c = 'Ϩ'; !this.field_150748_i.isEmpty() && c >= '\000'; c--) {
/* 173 */         Packet packet = this.field_150748_i.poll();
/* 174 */         packet.func_148833_a(this.field_150744_m);
/*     */       } 
/* 176 */       this.field_150744_m.func_147233_a();
/*     */     } 
/*     */     
/* 179 */     this.field_150746_k.flush();
/*     */   }
/*     */   
/*     */   public SocketAddress func_74430_c() {
/* 183 */     return this.field_150743_l;
/*     */   }
/*     */   
/*     */   public void func_150718_a(IChatComponent p_150718_1_) {
/* 187 */     if (this.field_150746_k.isOpen()) {
/* 188 */       this.field_150746_k.close();
/*     */       
/* 190 */       this.field_150742_o = p_150718_1_;
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean func_150731_c() {
/* 195 */     return (this.field_150746_k instanceof LocalChannel || this.field_150746_k instanceof io.netty.channel.local.LocalServerChannel);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static NetworkManager func_150726_a(InetAddress p_150726_0_, int p_150726_1_) {
/* 199 */     NetworkManager networkManager = new NetworkManager(true);
/*     */     
/* 201 */     ((Bootstrap)((Bootstrap)((Bootstrap)(new Bootstrap()).group((EventLoopGroup)field_150734_f)).handler((ChannelHandler)new ChannelInitializer(networkManager)
/*     */         {
/*     */           private static final String __OBFID = "CL_00001242";
/*     */           
/*     */           protected void initChannel(Channel p_initChannel_1_) {
/*     */             try {
/* 207 */               p_initChannel_1_.config().setOption(ChannelOption.IP_TOS, Integer.valueOf(24));
/* 208 */             } catch (ChannelException channelException) {}
/*     */             
/*     */             try {
/* 211 */               p_initChannel_1_.config().setOption(ChannelOption.TCP_NODELAY, Boolean.valueOf(false));
/* 212 */             } catch (ChannelException channelException) {}
/*     */             
/* 214 */             p_initChannel_1_.pipeline().addLast("timeout", (ChannelHandler)new ReadTimeoutHandler(20)).addLast("splitter", (ChannelHandler)new MessageDeserializer2()).addLast("decoder", (ChannelHandler)new MessageDeserializer(NetworkManager.field_152462_h)).addLast("prepender", (ChannelHandler)new MessageSerializer2()).addLast("encoder", (ChannelHandler)new MessageSerializer(NetworkManager.field_152462_h)).addLast("packet_handler", (ChannelHandler)this.field_150705_a);
/*     */           }
/*     */         })).channel(NioSocketChannel.class)).connect(p_150726_0_, p_150726_1_).syncUninterruptibly();
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
/* 232 */     return networkManager;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public static NetworkManager func_150722_a(SocketAddress p_150722_0_) {
/* 236 */     NetworkManager networkManager = new NetworkManager(true);
/*     */     
/* 238 */     ((Bootstrap)((Bootstrap)((Bootstrap)(new Bootstrap()).group((EventLoopGroup)field_150734_f)).handler((ChannelHandler)new ChannelInitializer(networkManager)
/*     */         {
/*     */           private static final String __OBFID = "CL_00001243";
/*     */           
/*     */           protected void initChannel(Channel p_initChannel_1_) {
/* 243 */             p_initChannel_1_.pipeline().addLast("packet_handler", (ChannelHandler)this.field_150778_a);
/*     */           }
/*     */         })).channel(LocalChannel.class)).connect(p_150722_0_).syncUninterruptibly();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 250 */     return networkManager;
/*     */   }
/*     */   
/*     */   public void func_150727_a(SecretKey p_150727_1_) {
/* 254 */     this.field_150746_k.pipeline().addBefore("splitter", "decrypt", (ChannelHandler)new NettyEncryptingDecoder(CryptManager.func_151229_a(2, p_150727_1_)));
/* 255 */     this.field_150746_k.pipeline().addBefore("prepender", "encrypt", (ChannelHandler)new NettyEncryptingEncoder(CryptManager.func_151229_a(1, p_150727_1_)));
/* 256 */     this.field_152463_r = true;
/*     */   }
/*     */   
/*     */   public boolean func_150724_d() {
/* 260 */     return (this.field_150746_k != null && this.field_150746_k.isOpen());
/*     */   }
/*     */   
/*     */   public INetHandler func_150729_e() {
/* 264 */     return this.field_150744_m;
/*     */   }
/*     */   
/*     */   public IChatComponent func_150730_f() {
/* 268 */     return this.field_150742_o;
/*     */   }
/*     */   
/*     */   public void func_150721_g() {
/* 272 */     this.field_150746_k.config().setAutoRead(false);
/*     */   }
/*     */ 
/*     */   
/*     */   static class InboundHandlerTuplePacketListener
/*     */   {
/*     */     private final Packet field_150774_a;
/*     */     
/*     */     private final GenericFutureListener[] field_150773_b;
/*     */     private static final String __OBFID = "CL_00001244";
/*     */     
/*     */     public InboundHandlerTuplePacketListener(Packet p_i45146_1_, GenericFutureListener... p_i45146_2_) {
/* 284 */       this.field_150774_a = p_i45146_1_;
/* 285 */       this.field_150773_b = p_i45146_2_;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\NetworkManager.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */