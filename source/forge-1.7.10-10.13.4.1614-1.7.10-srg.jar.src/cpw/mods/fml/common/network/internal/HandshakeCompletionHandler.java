/*    */ package cpw.mods.fml.common.network.internal;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import cpw.mods.fml.common.network.handshake.NetworkDispatcher;
/*    */ import io.netty.channel.ChannelHandler.Sharable;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.channel.SimpleChannelInboundHandler;
/*    */ import org.apache.logging.log4j.Level;
/*    */ 
/*    */ 
/*    */ @Sharable
/*    */ public class HandshakeCompletionHandler
/*    */   extends SimpleChannelInboundHandler<FMLMessage.CompleteHandshake>
/*    */ {
/*    */   protected void channelRead0(ChannelHandlerContext ctx, FMLMessage.CompleteHandshake msg) throws Exception {
/* 16 */     NetworkDispatcher dispatcher = (NetworkDispatcher)ctx.channel().attr(NetworkDispatcher.FML_DISPATCHER).getAndRemove();
/* 17 */     dispatcher.completeHandshake(msg.target);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
/* 23 */     FMLLog.log(Level.ERROR, cause, "HandshakeCompletionHandler exception", new Object[0]);
/* 24 */     super.exceptionCaught(ctx, cause);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\internal\HandshakeCompletionHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */