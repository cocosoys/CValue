/*    */ package cpw.mods.fml.common.network.internal;
/*    */ 
/*    */ import cpw.mods.fml.client.FMLClientHandler;
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.channel.SimpleChannelInboundHandler;
/*    */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import org.apache.logging.log4j.Level;
/*    */ 
/*    */ public class OpenGuiHandler
/*    */   extends SimpleChannelInboundHandler<FMLMessage.OpenGui>
/*    */ {
/*    */   protected void channelRead0(ChannelHandlerContext ctx, FMLMessage.OpenGui msg) throws Exception {
/* 15 */     EntityClientPlayerMP entityClientPlayerMP = (FMLClientHandler.instance().getClient()).thePlayer;
/* 16 */     entityClientPlayerMP.openGui(msg.modId, msg.modGuiId, ((EntityPlayer)entityClientPlayerMP).worldObj, msg.x, msg.y, msg.z);
/* 17 */     ((EntityPlayer)entityClientPlayerMP).openContainer.windowId = msg.windowId;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
/* 23 */     FMLLog.log(Level.ERROR, cause, "OpenGuiHandler exception", new Object[0]);
/* 24 */     super.exceptionCaught(ctx, cause);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\internal\OpenGuiHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */