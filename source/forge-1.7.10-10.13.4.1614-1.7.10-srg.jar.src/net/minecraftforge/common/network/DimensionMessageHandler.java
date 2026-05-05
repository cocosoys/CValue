/*    */ package net.minecraftforge.common.network;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.channel.SimpleChannelInboundHandler;
/*    */ import net.minecraftforge.common.DimensionManager;
/*    */ import org.apache.logging.log4j.Level;
/*    */ 
/*    */ 
/*    */ public class DimensionMessageHandler
/*    */   extends SimpleChannelInboundHandler<ForgeMessage.DimensionRegisterMessage>
/*    */ {
/*    */   protected void channelRead0(ChannelHandlerContext ctx, ForgeMessage.DimensionRegisterMessage msg) throws Exception {
/* 14 */     if (!DimensionManager.isDimensionRegistered(msg.dimensionId))
/*    */     {
/* 16 */       DimensionManager.registerDimension(msg.dimensionId, msg.providerId);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
/* 22 */     FMLLog.log(Level.ERROR, cause, "DimensionMessageHandler exception", new Object[0]);
/* 23 */     super.exceptionCaught(ctx, cause);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\network\DimensionMessageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */