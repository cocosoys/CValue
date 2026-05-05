/*     */ package cpw.mods.fml.common.network.simpleimpl;
/*     */ 
/*     */ import com.google.common.base.Throwables;
/*     */ import cpw.mods.fml.common.network.FMLEmbeddedChannel;
/*     */ import cpw.mods.fml.common.network.FMLOutboundHandler;
/*     */ import cpw.mods.fml.common.network.NetworkRegistry;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import io.netty.channel.ChannelFutureListener;
/*     */ import io.netty.channel.ChannelHandler;
/*     */ import io.netty.util.concurrent.GenericFutureListener;
/*     */ import java.util.EnumMap;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.network.Packet;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class SimpleNetworkWrapper
/*     */ {
/*     */   private EnumMap<Side, FMLEmbeddedChannel> channels;
/*     */   private SimpleIndexedCodec packetCodec;
/*     */   
/*     */   public SimpleNetworkWrapper(String channelName) {
/*  91 */     this.packetCodec = new SimpleIndexedCodec();
/*  92 */     this.channels = NetworkRegistry.INSTANCE.newChannel(channelName, new ChannelHandler[] { (ChannelHandler)this.packetCodec });
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <REQ extends IMessage, REPLY extends IMessage> void registerMessage(Class<? extends IMessageHandler<REQ, REPLY>> messageHandler, Class<REQ> requestMessageType, int discriminator, Side side) {
/* 106 */     registerMessage(instantiate(messageHandler), requestMessageType, discriminator, side);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   static <REQ extends IMessage, REPLY extends IMessage> IMessageHandler<? super REQ, ? extends REPLY> instantiate(Class<? extends IMessageHandler<? super REQ, ? extends REPLY>> handler) {
/*     */     try {
/* 113 */       return handler.newInstance();
/* 114 */     } catch (Exception e) {
/*     */       
/* 116 */       throw Throwables.propagate(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <REQ extends IMessage, REPLY extends IMessage> void registerMessage(IMessageHandler<? super REQ, ? extends REPLY> messageHandler, Class<REQ> requestMessageType, int discriminator, Side side) {
/* 131 */     this.packetCodec.addDiscriminator(discriminator, requestMessageType);
/* 132 */     FMLEmbeddedChannel channel = this.channels.get(side);
/* 133 */     String type = channel.findChannelHandlerNameForType(SimpleIndexedCodec.class);
/* 134 */     if (side == Side.SERVER) {
/*     */       
/* 136 */       addServerHandlerAfter(channel, type, messageHandler, requestMessageType);
/*     */     }
/*     */     else {
/*     */       
/* 140 */       addClientHandlerAfter(channel, type, messageHandler, requestMessageType);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private <REQ extends IMessage, REPLY extends IMessage, NH extends net.minecraft.network.INetHandler> void addServerHandlerAfter(FMLEmbeddedChannel channel, String type, IMessageHandler<? super REQ, ? extends REPLY> messageHandler, Class<REQ> requestType) {
/* 146 */     SimpleChannelHandlerWrapper<REQ, REPLY> handler = getHandlerWrapper(messageHandler, Side.SERVER, requestType);
/* 147 */     channel.pipeline().addAfter(type, messageHandler.getClass().getName(), (ChannelHandler)handler);
/*     */   }
/*     */ 
/*     */   
/*     */   private <REQ extends IMessage, REPLY extends IMessage, NH extends net.minecraft.network.INetHandler> void addClientHandlerAfter(FMLEmbeddedChannel channel, String type, IMessageHandler<? super REQ, ? extends REPLY> messageHandler, Class<REQ> requestType) {
/* 152 */     SimpleChannelHandlerWrapper<REQ, REPLY> handler = getHandlerWrapper(messageHandler, Side.CLIENT, requestType);
/* 153 */     channel.pipeline().addAfter(type, messageHandler.getClass().getName(), (ChannelHandler)handler);
/*     */   }
/*     */ 
/*     */   
/*     */   private <REPLY extends IMessage, REQ extends IMessage> SimpleChannelHandlerWrapper<REQ, REPLY> getHandlerWrapper(IMessageHandler<? super REQ, ? extends REPLY> messageHandler, Side side, Class<REQ> requestType) {
/* 158 */     return new SimpleChannelHandlerWrapper<REQ, REPLY>(messageHandler, side, requestType);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Packet getPacketFrom(IMessage message) {
/* 170 */     return ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).generatePacketFrom(message);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendToAll(IMessage message) {
/* 181 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALL);
/* 182 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).writeAndFlush(message).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendTo(IMessage message, EntityPlayerMP player) {
/* 194 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
/* 195 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
/* 196 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).writeAndFlush(message).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendToAllAround(IMessage message, NetworkRegistry.TargetPoint point) {
/* 208 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALLAROUNDPOINT);
/* 209 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(point);
/* 210 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).writeAndFlush(message).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendToDimension(IMessage message, int dimensionId) {
/* 222 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.DIMENSION);
/* 223 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(Integer.valueOf(dimensionId));
/* 224 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).writeAndFlush(message).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendToServer(IMessage message) {
/* 235 */     ((FMLEmbeddedChannel)this.channels.get(Side.CLIENT)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
/* 236 */     ((FMLEmbeddedChannel)this.channels.get(Side.CLIENT)).writeAndFlush(message).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\simpleimpl\SimpleNetworkWrapper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */