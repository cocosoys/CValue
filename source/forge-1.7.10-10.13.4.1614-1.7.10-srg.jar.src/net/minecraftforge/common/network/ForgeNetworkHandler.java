/*    */ package net.minecraftforge.common.network;
/*    */ 
/*    */ import cpw.mods.fml.common.ModContainer;
/*    */ import cpw.mods.fml.common.network.FMLEmbeddedChannel;
/*    */ import cpw.mods.fml.common.network.FMLOutboundHandler;
/*    */ import cpw.mods.fml.common.network.NetworkRegistry;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import io.netty.channel.ChannelHandler;
/*    */ import java.util.EnumMap;
/*    */ import net.minecraftforge.common.ForgeModContainer;
/*    */ 
/*    */ public class ForgeNetworkHandler
/*    */ {
/*    */   private static EnumMap<Side, FMLEmbeddedChannel> channelPair;
/*    */   
/*    */   public static void registerChannel(ForgeModContainer forgeModContainer, Side side) {
/* 18 */     channelPair = NetworkRegistry.INSTANCE.newChannel((ModContainer)forgeModContainer, "FORGE", new ChannelHandler[] { (ChannelHandler)new ForgeRuntimeCodec() });
/* 19 */     if (side == Side.CLIENT)
/*    */     {
/* 21 */       addClientHandlers();
/*    */     }
/*    */     
/* 24 */     FMLEmbeddedChannel serverChannel = channelPair.get(Side.SERVER);
/* 25 */     serverChannel.attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.NOWHERE);
/* 26 */     String handlerName = serverChannel.findChannelHandlerNameForType(ForgeRuntimeCodec.class);
/* 27 */     serverChannel.pipeline().addAfter(handlerName, "ServerToClientConnection", (ChannelHandler)new ServerToClientConnectionEstablishedHandler());
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   private static void addClientHandlers() {
/* 33 */     FMLEmbeddedChannel clientChannel = channelPair.get(Side.CLIENT);
/* 34 */     String handlerName = clientChannel.findChannelHandlerNameForType(ForgeRuntimeCodec.class);
/* 35 */     clientChannel.pipeline().addAfter(handlerName, "DimensionHandler", (ChannelHandler)new DimensionMessageHandler());
/* 36 */     clientChannel.pipeline().addAfter(handlerName, "FluidIdRegistryHandler", (ChannelHandler)new FluidIdRegistryMessageHandler());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\net\minecraftforge\common\network\ForgeNetworkHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */