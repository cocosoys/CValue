/*    */ package cpw.mods.fml.common.network;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import cpw.mods.fml.common.network.internal.FMLProxyPacket;
/*    */ import io.netty.channel.ChannelHandler.Sharable;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.channel.SimpleChannelInboundHandler;
/*    */ import org.apache.logging.log4j.Level;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Sharable
/*    */ public class NetworkEventFiringHandler
/*    */   extends SimpleChannelInboundHandler<FMLProxyPacket>
/*    */ {
/*    */   private FMLEventChannel eventChannel;
/*    */   
/*    */   NetworkEventFiringHandler(FMLEventChannel fmlEventChannel) {
/* 24 */     this.eventChannel = fmlEventChannel;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void channelRead0(ChannelHandlerContext ctx, FMLProxyPacket msg) throws Exception {
/* 30 */     this.eventChannel.fireRead(msg, ctx);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
/* 36 */     this.eventChannel.fireUserEvent(evt, ctx);
/*    */   }
/*    */ 
/*    */   
/*    */   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
/* 41 */     FMLLog.log(Level.ERROR, cause, "NetworkEventFiringHandler exception", new Object[0]);
/* 42 */     super.exceptionCaught(ctx, cause);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\NetworkEventFiringHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */