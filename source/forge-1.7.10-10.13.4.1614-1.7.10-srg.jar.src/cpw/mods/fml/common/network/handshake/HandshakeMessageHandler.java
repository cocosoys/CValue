/*    */ package cpw.mods.fml.common.network.handshake;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.channel.SimpleChannelInboundHandler;
/*    */ import io.netty.util.AttributeKey;
/*    */ import org.apache.logging.log4j.Level;
/*    */ 
/*    */ public class HandshakeMessageHandler<S extends Enum<S> & IHandshakeState<S>> extends SimpleChannelInboundHandler<FMLHandshakeMessage> {
/* 10 */   private static final AttributeKey<IHandshakeState<?>> STATE = new AttributeKey("fml:handshake-state");
/*    */   
/*    */   private final AttributeKey<S> fmlHandshakeState;
/*    */   
/*    */   private S initialState;
/*    */   private Class<S> stateType;
/*    */   
/*    */   public HandshakeMessageHandler(Class<S> stateType) {
/* 18 */     this.fmlHandshakeState = (AttributeKey)STATE;
/* 19 */     this.initialState = Enum.valueOf(stateType, "START");
/* 20 */     this.stateType = stateType;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void channelRead0(ChannelHandlerContext ctx, FMLHandshakeMessage msg) throws Exception {
/* 25 */     Enum enum_1 = (Enum)ctx.attr(this.fmlHandshakeState).get();
/* 26 */     FMLLog.finer(msg.toString(this.stateType) + "->" + enum_1.getClass().getName().substring(enum_1.getClass().getName().lastIndexOf('.') + 1) + ":" + enum_1, new Object[0]);
/* 27 */     Enum enum_2 = ((IHandshakeState<Enum>)enum_1).accept(ctx, msg);
/* 28 */     ctx.attr(this.fmlHandshakeState).set(enum_2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void channelActive(ChannelHandlerContext ctx) throws Exception {
/* 34 */     ctx.attr(this.fmlHandshakeState).set(this.initialState);
/*    */   }
/*    */ 
/*    */   
/*    */   public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
/* 39 */     Enum enum_1 = (Enum)ctx.attr(this.fmlHandshakeState).get();
/* 40 */     Enum enum_2 = ((IHandshakeState<Enum>)enum_1).accept(ctx, null);
/* 41 */     ctx.attr(this.fmlHandshakeState).set(enum_2);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
/* 47 */     FMLLog.log(Level.ERROR, cause, "HandshakeMessageHandler exception", new Object[0]);
/* 48 */     super.exceptionCaught(ctx, cause);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\handshake\HandshakeMessageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */