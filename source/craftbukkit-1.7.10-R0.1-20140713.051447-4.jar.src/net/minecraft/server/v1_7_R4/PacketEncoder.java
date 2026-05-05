/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import net.minecraft.util.com.google.common.collect.BiMap;
/*    */ import net.minecraft.util.io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.util.io.netty.channel.ChannelHandlerContext;
/*    */ import net.minecraft.util.io.netty.handler.codec.MessageToByteEncoder;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ import org.apache.logging.log4j.Marker;
/*    */ import org.apache.logging.log4j.MarkerManager;
/*    */ 
/*    */ public class PacketEncoder
/*    */   extends MessageToByteEncoder {
/* 15 */   private static final Logger a = LogManager.getLogger();
/* 16 */   private static final Marker b = MarkerManager.getMarker("PACKET_SENT", NetworkManager.b);
/*    */   private final NetworkStatistics c;
/*    */   
/*    */   public PacketEncoder(NetworkStatistics paramNetworkStatistics) {
/* 20 */     this.c = paramNetworkStatistics;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void a(ChannelHandlerContext paramChannelHandlerContext, Packet paramPacket, ByteBuf paramByteBuf) {
/* 25 */     Integer integer = (Integer)((BiMap)paramChannelHandlerContext.channel().attr(NetworkManager.f).get()).inverse().get(paramPacket.getClass());
/*    */ 
/*    */     
/* 28 */     if (a.isDebugEnabled()) {
/* 29 */       a.debug(b, "OUT: [{}:{}] {}[{}]", new Object[] { paramChannelHandlerContext.channel().attr(NetworkManager.d).get(), integer, paramPacket.getClass().getName(), paramPacket.b() });
/*    */     }
/*    */     
/* 32 */     if (integer == null) {
/* 33 */       throw new IOException("Can't serialize unregistered packet");
/*    */     }
/*    */     
/* 36 */     PacketDataSerializer packetDataSerializer = new PacketDataSerializer(paramByteBuf);
/* 37 */     packetDataSerializer.b(integer.intValue());
/* 38 */     paramPacket.b(packetDataSerializer);
/*    */     
/* 40 */     this.c.b(integer.intValue(), packetDataSerializer.readableBytes());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */