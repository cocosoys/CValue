/*     */ package net.minecraft.client.network;
/*     */ import com.google.common.base.Charsets;
/*     */ import com.google.common.collect.Iterables;
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.bootstrap.Bootstrap;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import io.netty.buffer.Unpooled;
/*     */ import io.netty.channel.Channel;
/*     */ import io.netty.channel.ChannelException;
/*     */ import io.netty.channel.ChannelFutureListener;
/*     */ import io.netty.channel.ChannelHandler;
/*     */ import io.netty.channel.ChannelHandlerContext;
/*     */ import io.netty.channel.ChannelOption;
/*     */ import io.netty.channel.SimpleChannelInboundHandler;
/*     */ import io.netty.util.concurrent.GenericFutureListener;
/*     */ import java.util.Iterator;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.multiplayer.ServerAddress;
/*     */ import net.minecraft.client.multiplayer.ServerData;
/*     */ import net.minecraft.network.EnumConnectionState;
/*     */ import net.minecraft.network.NetworkManager;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.ServerStatusResponse;
/*     */ import net.minecraft.network.status.server.S00PacketServerInfo;
/*     */ import net.minecraft.network.status.server.S01PacketPong;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class OldServerPinger {
/*  34 */   private static final Splitter field_147230_a = Splitter.on(false).limit(6);
/*  35 */   private static final Logger field_147228_b = LogManager.getLogger();
/*     */   
/*  37 */   private final List field_147229_c = Collections.synchronizedList(new ArrayList()); private static final String __OBFID = "CL_00000892";
/*     */   
/*     */   public void func_147224_a(ServerData p_147224_1_) throws UnknownHostException {
/*  40 */     ServerAddress serverAddress = ServerAddress.func_78860_a(p_147224_1_.field_78845_b);
/*  41 */     NetworkManager networkManager = NetworkManager.func_150726_a(InetAddress.getByName(serverAddress.func_78861_a()), serverAddress.func_78864_b());
/*     */     
/*  43 */     this.field_147229_c.add(networkManager);
/*     */     
/*  45 */     p_147224_1_.field_78843_d = "Pinging...";
/*  46 */     p_147224_1_.field_78844_e = -1L;
/*  47 */     p_147224_1_.field_147412_i = null;
/*     */     
/*  49 */     networkManager.func_150719_a((INetHandler)new INetHandlerStatusClient(this, p_147224_1_, networkManager) { private boolean field_147403_d = false;
/*     */           private static final String __OBFID = "CL_00000893";
/*     */           
/*     */           public void func_147397_a(S00PacketServerInfo p_147397_1_) {
/*  53 */             ServerStatusResponse serverStatusResponse = p_147397_1_.func_149294_c();
/*     */             
/*  55 */             if (serverStatusResponse.func_151317_a() != null) {
/*  56 */               this.field_147406_a.field_78843_d = serverStatusResponse.func_151317_a().func_150254_d();
/*     */             } else {
/*  58 */               this.field_147406_a.field_78843_d = "";
/*     */             } 
/*     */             
/*  61 */             if (serverStatusResponse.func_151322_c() != null) {
/*  62 */               this.field_147406_a.field_82822_g = serverStatusResponse.func_151322_c().func_151303_a();
/*  63 */               this.field_147406_a.field_82821_f = serverStatusResponse.func_151322_c().func_151304_b();
/*     */             } else {
/*  65 */               this.field_147406_a.field_82822_g = "Old";
/*  66 */               this.field_147406_a.field_82821_f = 0;
/*     */             } 
/*     */             
/*  69 */             if (serverStatusResponse.func_151318_b() != null) {
/*  70 */               this.field_147406_a.field_78846_c = EnumChatFormatting.GRAY + "" + serverStatusResponse.func_151318_b().func_151333_b() + "" + EnumChatFormatting.DARK_GRAY + "/" + EnumChatFormatting.GRAY + serverStatusResponse.func_151318_b().func_151332_a();
/*     */               
/*  72 */               if (ArrayUtils.isNotEmpty((Object[])serverStatusResponse.func_151318_b().func_151331_c())) {
/*  73 */                 StringBuilder stringBuilder = new StringBuilder();
/*  74 */                 for (GameProfile gameProfile : serverStatusResponse.func_151318_b().func_151331_c()) {
/*  75 */                   if (stringBuilder.length() > 0) stringBuilder.append("\n"); 
/*  76 */                   stringBuilder.append(gameProfile.getName());
/*     */                 } 
/*  78 */                 if ((serverStatusResponse.func_151318_b().func_151331_c()).length < serverStatusResponse.func_151318_b().func_151333_b()) {
/*  79 */                   if (stringBuilder.length() > 0) stringBuilder.append("\n"); 
/*  80 */                   stringBuilder.append("... and ").append(serverStatusResponse.func_151318_b().func_151333_b() - (serverStatusResponse.func_151318_b().func_151331_c()).length).append(" more ...");
/*     */                 } 
/*  82 */                 this.field_147406_a.field_147412_i = stringBuilder.toString();
/*     */               } 
/*     */             } else {
/*  85 */               this.field_147406_a.field_78846_c = EnumChatFormatting.DARK_GRAY + "???";
/*     */             } 
/*     */             
/*  88 */             if (serverStatusResponse.func_151316_d() != null) {
/*  89 */               String str = serverStatusResponse.func_151316_d();
/*  90 */               if (str.startsWith("data:image/png;base64,")) {
/*  91 */                 this.field_147406_a.func_147407_a(str.substring("data:image/png;base64,".length()));
/*     */               } else {
/*  93 */                 OldServerPinger.field_147228_b.error("Invalid server icon (unknown format)");
/*     */               } 
/*     */             } else {
/*  96 */               this.field_147406_a.func_147407_a(null);
/*     */             } 
/*     */             
/*  99 */             this.field_147404_b.func_150725_a((Packet)new C01PacketPing(Minecraft.func_71386_F()), new GenericFutureListener[0]);
/* 100 */             this.field_147403_d = true;
/*     */           }
/*     */ 
/*     */           
/*     */           public void func_147398_a(S01PacketPong p_147398_1_) {
/* 105 */             long l1 = p_147398_1_.func_149292_c();
/* 106 */             long l2 = Minecraft.func_71386_F();
/* 107 */             this.field_147406_a.field_78844_e = l2 - l1;
/*     */             
/* 109 */             this.field_147404_b.func_150718_a((IChatComponent)new ChatComponentText("Finished"));
/*     */           }
/*     */ 
/*     */           
/*     */           public void func_147231_a(IChatComponent p_147231_1_) {
/* 114 */             if (!this.field_147403_d) {
/* 115 */               OldServerPinger.field_147228_b.error("Can't ping " + this.field_147406_a.field_78845_b + ": " + p_147231_1_.func_150260_c());
/* 116 */               this.field_147406_a.field_78843_d = EnumChatFormatting.DARK_RED + "Can't connect to server.";
/* 117 */               this.field_147406_a.field_78846_c = "";
/*     */               
/* 119 */               this.field_147405_c.func_147225_b(this.field_147406_a);
/*     */             } 
/*     */           }
/*     */ 
/*     */           
/*     */           public void func_147232_a(EnumConnectionState p_147232_1_, EnumConnectionState p_147232_2_) {
/* 125 */             if (p_147232_2_ != EnumConnectionState.STATUS) {
/* 126 */               throw new UnsupportedOperationException("Unexpected change in protocol to " + p_147232_2_);
/*     */             }
/*     */           }
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
/*     */           public void func_147233_a() {} }
/*     */       );
/*     */     try {
/* 142 */       networkManager.func_150725_a((Packet)new C00Handshake(5, serverAddress.func_78861_a(), serverAddress.func_78864_b(), EnumConnectionState.STATUS), new GenericFutureListener[0]);
/* 143 */       networkManager.func_150725_a((Packet)new C00PacketServerQuery(), new GenericFutureListener[0]);
/* 144 */     } catch (Throwable throwable) {
/* 145 */       field_147228_b.error(throwable);
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_147225_b(ServerData p_147225_1_) {
/* 150 */     ServerAddress serverAddress = ServerAddress.func_78860_a(p_147225_1_.field_78845_b);
/* 151 */     ((Bootstrap)((Bootstrap)((Bootstrap)(new Bootstrap()).group((EventLoopGroup)NetworkManager.field_150734_f)).handler((ChannelHandler)new ChannelInitializer(this, serverAddress, p_147225_1_)
/*     */         {
/*     */           private static final String __OBFID = "CL_00000894";
/*     */           
/*     */           protected void initChannel(Channel p_initChannel_1_) {
/*     */             try {
/* 157 */               p_initChannel_1_.config().setOption(ChannelOption.IP_TOS, Integer.valueOf(24));
/* 158 */             } catch (ChannelException channelException) {}
/*     */ 
/*     */             
/*     */             try {
/* 162 */               p_initChannel_1_.config().setOption(ChannelOption.TCP_NODELAY, Boolean.valueOf(false));
/* 163 */             } catch (ChannelException channelException) {}
/*     */ 
/*     */             
/* 166 */             p_initChannel_1_.pipeline().addLast(new ChannelHandler[] { (ChannelHandler)new SimpleChannelInboundHandler(this) { private static final String __OBFID = "CL_00000895";
/*     */                     
/*     */                     public void channelActive(ChannelHandlerContext p_channelActive_1_) throws Exception {
/* 169 */                       super.channelActive(p_channelActive_1_);
/* 170 */                       ByteBuf byteBuf = Unpooled.buffer();
/*     */                       try {
/* 172 */                         byteBuf.writeByte(254);
/* 173 */                         byteBuf.writeByte(1);
/* 174 */                         byteBuf.writeByte(250);
/*     */                         
/* 176 */                         char[] arrayOfChar = "MC|PingHost".toCharArray();
/* 177 */                         byteBuf.writeShort(arrayOfChar.length);
/* 178 */                         for (char c : arrayOfChar) {
/* 179 */                           byteBuf.writeChar(c);
/*     */                         }
/* 181 */                         byteBuf.writeShort(7 + 2 * this.field_147220_a.field_147218_a.func_78861_a().length());
/* 182 */                         byteBuf.writeByte(127);
/* 183 */                         arrayOfChar = this.field_147220_a.field_147218_a.func_78861_a().toCharArray();
/* 184 */                         byteBuf.writeShort(arrayOfChar.length);
/* 185 */                         for (char c : arrayOfChar) {
/* 186 */                           byteBuf.writeChar(c);
/*     */                         }
/* 188 */                         byteBuf.writeInt(this.field_147220_a.field_147218_a.func_78864_b());
/*     */                         
/* 190 */                         p_channelActive_1_.channel().writeAndFlush(byteBuf).addListener((GenericFutureListener)ChannelFutureListener.CLOSE_ON_FAILURE);
/*     */                       } finally {
/* 192 */                         byteBuf.release();
/*     */                       } 
/*     */                     }
/*     */ 
/*     */                     
/*     */                     protected void channelRead0(ChannelHandlerContext p_channelRead0_1_, ByteBuf p_channelRead0_2_) {
/* 198 */                       short s = p_channelRead0_2_.readUnsignedByte();
/*     */                       
/* 200 */                       if (s == 255) {
/* 201 */                         String str = new String(p_channelRead0_2_.readBytes(p_channelRead0_2_.readShort() * 2).array(), Charsets.UTF_16BE);
/* 202 */                         String[] arrayOfString = (String[])Iterables.toArray(OldServerPinger.field_147230_a.split(str), String.class);
/*     */                         
/* 204 */                         if ("§1".equals(arrayOfString[0])) {
/* 205 */                           int i = MathHelper.func_82715_a(arrayOfString[1], 0);
/* 206 */                           String str1 = arrayOfString[2];
/* 207 */                           String str2 = arrayOfString[3];
/* 208 */                           int j = MathHelper.func_82715_a(arrayOfString[4], -1);
/* 209 */                           int k = MathHelper.func_82715_a(arrayOfString[5], -1);
/*     */                           
/* 211 */                           this.field_147220_a.field_147216_b.field_82821_f = -1;
/* 212 */                           this.field_147220_a.field_147216_b.field_82822_g = str1;
/* 213 */                           this.field_147220_a.field_147216_b.field_78843_d = str2;
/* 214 */                           this.field_147220_a.field_147216_b.field_78846_c = EnumChatFormatting.GRAY + "" + j + "" + EnumChatFormatting.DARK_GRAY + "/" + EnumChatFormatting.GRAY + k;
/*     */                         } 
/*     */                       } 
/*     */                       
/* 218 */                       p_channelRead0_1_.close();
/*     */                     }
/*     */ 
/*     */                     
/*     */                     public void exceptionCaught(ChannelHandlerContext p_exceptionCaught_1_, Throwable p_exceptionCaught_2_) {
/* 223 */                       p_exceptionCaught_1_.close();
/*     */                     } }
/*     */                    });
/*     */           }
/*     */         })).channel(NioSocketChannel.class)).connect(serverAddress.func_78861_a(), serverAddress.func_78864_b());
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
/*     */   public void func_147223_a() {
/* 239 */     synchronized (this.field_147229_c) {
/* 240 */       Iterator<NetworkManager> iterator = this.field_147229_c.iterator();
/* 241 */       while (iterator.hasNext()) {
/* 242 */         NetworkManager networkManager = iterator.next();
/*     */         
/* 244 */         if (networkManager.func_150724_d()) {
/* 245 */           networkManager.func_74428_b(); continue;
/*     */         } 
/* 247 */         iterator.remove();
/* 248 */         if (networkManager.func_150730_f() != null) {
/* 249 */           networkManager.func_150729_e().func_147231_a(networkManager.func_150730_f());
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_147226_b() {
/* 257 */     synchronized (this.field_147229_c) {
/* 258 */       Iterator<NetworkManager> iterator = this.field_147229_c.iterator();
/* 259 */       while (iterator.hasNext()) {
/* 260 */         NetworkManager networkManager = iterator.next();
/*     */         
/* 262 */         if (networkManager.func_150724_d()) {
/* 263 */           iterator.remove();
/* 264 */           networkManager.func_150718_a((IChatComponent)new ChatComponentText("Cancelled"));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\network\OldServerPinger.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */