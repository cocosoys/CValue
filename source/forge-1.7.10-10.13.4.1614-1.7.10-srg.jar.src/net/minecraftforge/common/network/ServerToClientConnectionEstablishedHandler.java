/*    */ package net.minecraftforge.common.network;
/*    */ 
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.channel.ChannelInboundHandlerAdapter;
/*    */ 
/*    */ 
/*    */ public class ServerToClientConnectionEstablishedHandler
/*    */   extends ChannelInboundHandlerAdapter
/*    */ {
/*    */   public void userEventTriggered(ChannelHandlerContext ctx, Object evt) throws Exception {
/* 11 */     if (evt instanceof cpw.mods.fml.common.network.NetworkHandshakeEstablished) {
/*    */       
/* 13 */       ctx.writeAndFlush(new ForgeMessage.FluidIdMapMessage());
/*    */       
/*    */       return;
/*    */     } 
/* 17 */     ctx.fireUserEventTriggered(evt);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\network\ServerToClientConnectionEstablishedHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */