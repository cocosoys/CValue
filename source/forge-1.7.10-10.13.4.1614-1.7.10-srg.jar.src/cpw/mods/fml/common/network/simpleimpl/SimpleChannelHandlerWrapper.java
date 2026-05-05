/*    */ package cpw.mods.fml.common.network.simpleimpl;
/*    */ 
/*    */ import com.google.common.base.Preconditions;
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import cpw.mods.fml.common.network.FMLOutboundHandler;
/*    */ import cpw.mods.fml.common.network.NetworkRegistry;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import io.netty.channel.ChannelFutureListener;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.channel.SimpleChannelInboundHandler;
/*    */ import io.netty.util.concurrent.GenericFutureListener;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import org.apache.logging.log4j.Level;
/*    */ 
/*    */ 
/*    */ public class SimpleChannelHandlerWrapper<REQ extends IMessage, REPLY extends IMessage>
/*    */   extends SimpleChannelInboundHandler<REQ>
/*    */ {
/*    */   private final IMessageHandler<? super REQ, ? extends REPLY> messageHandler;
/*    */   private final Side side;
/*    */   
/*    */   public SimpleChannelHandlerWrapper(Class<? extends IMessageHandler<? super REQ, ? extends REPLY>> handler, Side side, Class<REQ> requestType) {
/* 23 */     this(SimpleNetworkWrapper.instantiate(handler), side, requestType);
/*    */   }
/*    */ 
/*    */   
/*    */   public SimpleChannelHandlerWrapper(IMessageHandler<? super REQ, ? extends REPLY> handler, Side side, Class<REQ> requestType) {
/* 28 */     super(requestType);
/* 29 */     this.messageHandler = (IMessageHandler<? super REQ, ? extends REPLY>)Preconditions.checkNotNull(handler, "IMessageHandler must not be null");
/* 30 */     this.side = side;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void channelRead0(ChannelHandlerContext ctx, REQ msg) throws Exception {
/* 35 */     INetHandler iNetHandler = (INetHandler)ctx.channel().attr(NetworkRegistry.NET_HANDLER).get();
/* 36 */     MessageContext context = new MessageContext(iNetHandler, this.side);
/* 37 */     REPLY result = this.messageHandler.onMessage(msg, context);
/* 38 */     if (result != null) {
/*    */       
/* 40 */       ctx.channel().attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.REPLY);
/* 41 */       ctx.writeAndFlush(result).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
/* 48 */     FMLLog.log(Level.ERROR, cause, "SimpleChannelHandlerWrapper exception", new Object[0]);
/* 49 */     super.exceptionCaught(ctx, cause);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\simpleimpl\SimpleChannelHandlerWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */