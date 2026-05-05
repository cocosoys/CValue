/*     */ package cpw.mods.fml.common.network;
/*     */ 
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.eventhandler.EventBus;
/*     */ import cpw.mods.fml.common.network.internal.FMLProxyPacket;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import io.netty.channel.ChannelFutureListener;
/*     */ import io.netty.channel.ChannelHandler;
/*     */ import io.netty.channel.ChannelHandlerContext;
/*     */ import io.netty.util.concurrent.GenericFutureListener;
/*     */ import java.util.EnumMap;
/*     */ import net.minecraft.client.network.NetHandlerPlayClient;
/*     */ import net.minecraft.entity.player.EntityPlayerMP;
/*     */ import net.minecraft.network.NetHandlerPlayServer;
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
/*     */ public class FMLEventChannel
/*     */ {
/*     */   private EnumMap<Side, FMLEmbeddedChannel> channels;
/*     */   private EventBus eventBus;
/*     */   
/*     */   private enum EventFactory
/*     */   {
/*  36 */     SERVER
/*     */     {
/*     */       
/*     */       FMLNetworkEvent.CustomPacketEvent<?> make(FMLProxyPacket msg)
/*     */       {
/*  41 */         FMLNetworkEvent.CustomPacketEvent<?> event = null;
/*  42 */         if (msg.handler() instanceof NetHandlerPlayServer) {
/*     */           
/*  44 */           NetHandlerPlayServer server = (NetHandlerPlayServer)msg.handler();
/*  45 */           event = new FMLNetworkEvent.ServerCustomPacketEvent(server.func_147362_b(), msg);
/*     */         } 
/*  47 */         return event;
/*     */       }
/*     */     },
/*  50 */     CLIENT
/*     */     {
/*     */       
/*     */       FMLNetworkEvent.CustomPacketEvent<?> make(FMLProxyPacket msg)
/*     */       {
/*  55 */         FMLNetworkEvent.CustomPacketEvent<?> event = null;
/*  56 */         if (msg.handler() instanceof NetHandlerPlayClient) {
/*     */           
/*  58 */           NetHandlerPlayClient client = (NetHandlerPlayClient)msg.handler();
/*  59 */           event = new FMLNetworkEvent.ClientCustomPacketEvent(client.getNetworkManager(), msg);
/*     */         }
/*  61 */         else if (msg.handler() instanceof NetHandlerPlayServer) {
/*     */           
/*  63 */           NetHandlerPlayServer server = (NetHandlerPlayServer)msg.handler();
/*  64 */           event = new FMLNetworkEvent.ServerCustomPacketEvent(server.func_147362_b(), msg);
/*     */         } 
/*  66 */         return event;
/*     */       }
/*     */     };
/*     */     
/*     */     abstract FMLNetworkEvent.CustomPacketEvent<?> make(FMLProxyPacket param1FMLProxyPacket);
/*     */   }
/*  72 */   private static EventFactory factory = (FMLCommonHandler.instance().getSide() == Side.CLIENT) ? EventFactory.CLIENT : EventFactory.SERVER;
/*     */   
/*     */   FMLEventChannel(String name) {
/*  75 */     this.channels = NetworkRegistry.INSTANCE.newChannel(name, new ChannelHandler[] { (ChannelHandler)new NetworkEventFiringHandler(this) });
/*  76 */     this.eventBus = new EventBus();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void register(Object object) {
/*  86 */     this.eventBus.register(object);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregister(Object object) {
/*  95 */     this.eventBus.unregister(object);
/*     */   }
/*     */ 
/*     */   
/*     */   void fireRead(FMLProxyPacket msg, ChannelHandlerContext ctx) {
/* 100 */     FMLNetworkEvent.CustomPacketEvent<?> event = factory.make(msg);
/* 101 */     if (event != null) {
/*     */       
/* 103 */       this.eventBus.post(event);
/* 104 */       if (event.reply != null) {
/*     */         
/* 106 */         ctx.channel().attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.REPLY);
/* 107 */         ctx.writeAndFlush(event.reply).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void fireUserEvent(Object evt, ChannelHandlerContext ctx) {
/* 114 */     FMLNetworkEvent.CustomNetworkEvent event = new FMLNetworkEvent.CustomNetworkEvent(evt);
/* 115 */     this.eventBus.post(event);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendToAll(FMLProxyPacket pkt) {
/* 125 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALL);
/* 126 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).writeAndFlush(pkt).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendTo(FMLProxyPacket pkt, EntityPlayerMP player) {
/* 137 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.PLAYER);
/* 138 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(player);
/* 139 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).writeAndFlush(pkt).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendToAllAround(FMLProxyPacket pkt, NetworkRegistry.TargetPoint point) {
/* 149 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.ALLAROUNDPOINT);
/* 150 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(point);
/* 151 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).writeAndFlush(pkt).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendToDimension(FMLProxyPacket pkt, int dimensionId) {
/* 161 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.DIMENSION);
/* 162 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).attr(FMLOutboundHandler.FML_MESSAGETARGETARGS).set(Integer.valueOf(dimensionId));
/* 163 */     ((FMLEmbeddedChannel)this.channels.get(Side.SERVER)).writeAndFlush(pkt).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendToServer(FMLProxyPacket pkt) {
/* 172 */     ((FMLEmbeddedChannel)this.channels.get(Side.CLIENT)).attr(FMLOutboundHandler.FML_MESSAGETARGET).set(FMLOutboundHandler.OutboundTarget.TOSERVER);
/* 173 */     ((FMLEmbeddedChannel)this.channels.get(Side.CLIENT)).writeAndFlush(pkt).addListener((GenericFutureListener)ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\FMLEventChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */