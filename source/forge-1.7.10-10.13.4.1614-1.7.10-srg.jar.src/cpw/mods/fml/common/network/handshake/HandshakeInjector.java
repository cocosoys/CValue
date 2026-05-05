/*    */ package cpw.mods.fml.common.network.handshake;
/*    */ 
/*    */ import cpw.mods.fml.common.network.internal.FMLProxyPacket;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.channel.ChannelOutboundHandlerAdapter;
/*    */ import io.netty.channel.ChannelPromise;
/*    */ 
/*    */ public class HandshakeInjector
/*    */   extends ChannelOutboundHandlerAdapter {
/*    */   private NetworkDispatcher dispatcher;
/*    */   
/*    */   public HandshakeInjector(NetworkDispatcher networkDispatcher) {
/* 13 */     this.dispatcher = networkDispatcher;
/*    */   }
/*    */ 
/*    */   
/*    */   public void write(ChannelHandlerContext ctx, Object msg, ChannelPromise promise) throws Exception {
/* 18 */     if (msg instanceof FMLProxyPacket)
/*    */     {
/* 20 */       this.dispatcher.sendProxy((FMLProxyPacket)msg);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\handshake\HandshakeInjector.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */