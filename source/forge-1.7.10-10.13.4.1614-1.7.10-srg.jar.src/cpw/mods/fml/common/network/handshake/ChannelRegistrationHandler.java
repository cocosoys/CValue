/*    */ package cpw.mods.fml.common.network.handshake;
/*    */ 
/*    */ import com.google.common.base.Charsets;
/*    */ import com.google.common.collect.ImmutableSet;
/*    */ import cpw.mods.fml.common.FMLCommonHandler;
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import cpw.mods.fml.common.network.internal.FMLProxyPacket;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.channel.SimpleChannelInboundHandler;
/*    */ import java.util.Set;
/*    */ import net.minecraft.network.NetworkManager;
/*    */ import org.apache.logging.log4j.Level;
/*    */ 
/*    */ public class ChannelRegistrationHandler
/*    */   extends SimpleChannelInboundHandler<FMLProxyPacket>
/*    */ {
/*    */   protected void channelRead0(ChannelHandlerContext ctx, FMLProxyPacket msg) throws Exception {
/* 19 */     Side side = msg.getTarget();
/* 20 */     NetworkManager manager = msg.getOrigin();
/* 21 */     if (msg.channel().equals("REGISTER") || msg.channel().equals("UNREGISTER")) {
/*    */       
/* 23 */       byte[] data = new byte[msg.payload().readableBytes()];
/* 24 */       msg.payload().readBytes(data);
/* 25 */       String channels = new String(data, Charsets.UTF_8);
/* 26 */       String[] split = channels.split("\000");
/* 27 */       ImmutableSet immutableSet = ImmutableSet.copyOf((Object[])split);
/* 28 */       FMLCommonHandler.instance().fireNetRegistrationEvent(manager, (Set)immutableSet, msg.channel(), side);
/*    */     }
/*    */     else {
/*    */       
/* 32 */       ctx.fireChannelRead(msg);
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
/* 39 */     FMLLog.log(Level.ERROR, cause, "ChannelRegistrationHandler exception", new Object[0]);
/* 40 */     super.exceptionCaught(ctx, cause);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\handshake\ChannelRegistrationHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */