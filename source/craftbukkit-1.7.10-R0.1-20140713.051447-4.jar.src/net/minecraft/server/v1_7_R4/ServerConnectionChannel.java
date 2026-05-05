/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import net.minecraft.util.io.netty.channel.Channel;
/*    */ import net.minecraft.util.io.netty.channel.ChannelException;
/*    */ import net.minecraft.util.io.netty.channel.ChannelHandler;
/*    */ import net.minecraft.util.io.netty.channel.ChannelInitializer;
/*    */ import net.minecraft.util.io.netty.channel.ChannelOption;
/*    */ import net.minecraft.util.io.netty.handler.timeout.ReadTimeoutHandler;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class ServerConnectionChannel
/*    */   extends ChannelInitializer
/*    */ {
/*    */   ServerConnectionChannel(ServerConnection paramServerConnection) {}
/*    */   
/*    */   protected void initChannel(Channel paramChannel) {
/*    */     try {
/* 51 */       paramChannel.config().setOption(ChannelOption.IP_TOS, Integer.valueOf(24));
/* 52 */     } catch (ChannelException channelException) {}
/*    */ 
/*    */     
/*    */     try {
/* 56 */       paramChannel.config().setOption(ChannelOption.TCP_NODELAY, Boolean.valueOf(false));
/* 57 */     } catch (ChannelException channelException) {}
/*    */ 
/*    */     
/* 60 */     paramChannel.pipeline().addLast("timeout", (ChannelHandler)new ReadTimeoutHandler(30)).addLast("legacy_query", (ChannelHandler)new LegacyPingHandler(this.a)).addLast("splitter", (ChannelHandler)new PacketSplitter()).addLast("decoder", (ChannelHandler)new PacketDecoder(NetworkManager.h)).addLast("prepender", (ChannelHandler)new PacketPrepender()).addLast("encoder", (ChannelHandler)new PacketEncoder(NetworkManager.h));
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 71 */     NetworkManager networkManager = new NetworkManager(false);
/* 72 */     ServerConnection.a(this.a).add(networkManager);
/* 73 */     paramChannel.pipeline().addLast("packet_handler", (ChannelHandler)networkManager);
/* 74 */     networkManager.a(new HandshakeListener(ServerConnection.b(this.a), networkManager));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ServerConnectionChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */