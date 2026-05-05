/*    */ package cpw.mods.fml.common.network;
/*    */ 
/*    */ import cpw.mods.fml.common.Loader;
/*    */ import cpw.mods.fml.common.ModContainer;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import io.netty.channel.ChannelHandler;
/*    */ import io.netty.channel.embedded.EmbeddedChannel;
/*    */ import java.util.Map;
/*    */ import net.minecraft.network.Packet;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class FMLEmbeddedChannel
/*    */   extends EmbeddedChannel
/*    */ {
/*    */   public FMLEmbeddedChannel(String channelName, Side source, ChannelHandler... handlers) {
/* 23 */     this(Loader.instance().activeModContainer(), channelName, source, handlers);
/*    */   }
/*    */   
/*    */   public FMLEmbeddedChannel(ModContainer container, String channelName, Side source, ChannelHandler... handlers) {
/* 27 */     super(handlers);
/* 28 */     attr(NetworkRegistry.FML_CHANNEL).set(channelName);
/* 29 */     attr(NetworkRegistry.CHANNEL_SOURCE).set(source);
/* 30 */     attr(NetworkRegistry.MOD_CONTAINER).setIfAbsent(container);
/* 31 */     pipeline().addFirst("fml:outbound", (ChannelHandler)new FMLOutboundHandler());
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Packet generatePacketFrom(Object object) {
/* 47 */     FMLOutboundHandler.OutboundTarget outboundTarget = (FMLOutboundHandler.OutboundTarget)attr(FMLOutboundHandler.FML_MESSAGETARGET).getAndSet(FMLOutboundHandler.OutboundTarget.NOWHERE);
/* 48 */     writeOutbound(new Object[] { object });
/* 49 */     Packet pkt = outboundMessages().poll();
/* 50 */     attr(FMLOutboundHandler.FML_MESSAGETARGET).set(outboundTarget);
/* 51 */     return pkt;
/*    */   }
/*    */ 
/*    */   
/*    */   public String findChannelHandlerNameForType(Class<? extends ChannelHandler> type) {
/* 56 */     String targetName = null;
/* 57 */     for (Map.Entry<String, ChannelHandler> entry : (Iterable<Map.Entry<String, ChannelHandler>>)pipeline()) {
/*    */       
/* 59 */       if (type.isInstance(entry.getValue())) {
/*    */         
/* 61 */         targetName = entry.getKey();
/*    */         break;
/*    */       } 
/*    */     } 
/* 65 */     return targetName;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\FMLEmbeddedChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */