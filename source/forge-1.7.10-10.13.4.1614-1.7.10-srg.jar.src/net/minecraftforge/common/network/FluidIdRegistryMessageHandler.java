/*    */ package net.minecraftforge.common.network;
/*    */ 
/*    */ import cpw.mods.fml.common.FMLLog;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.channel.SimpleChannelInboundHandler;
/*    */ import net.minecraftforge.fluids.FluidRegistry;
/*    */ import org.apache.logging.log4j.Level;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FluidIdRegistryMessageHandler
/*    */   extends SimpleChannelInboundHandler<ForgeMessage.FluidIdMapMessage>
/*    */ {
/*    */   protected void channelRead0(ChannelHandlerContext ctx, ForgeMessage.FluidIdMapMessage msg) throws Exception {
/* 15 */     FluidRegistry.initFluidIDs(msg.fluidIds, msg.defaultFluids);
/*    */   }
/*    */ 
/*    */   
/*    */   public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
/* 20 */     FMLLog.log(Level.ERROR, cause, "FluidIdRegistryMessageHandler exception", new Object[0]);
/* 21 */     super.exceptionCaught(ctx, cause);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\network\FluidIdRegistryMessageHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */