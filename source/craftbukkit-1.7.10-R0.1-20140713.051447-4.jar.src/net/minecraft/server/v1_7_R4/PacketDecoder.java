/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import net.minecraft.util.com.google.common.collect.BiMap;
/*    */ import net.minecraft.util.io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.util.io.netty.channel.ChannelHandlerContext;
/*    */ import net.minecraft.util.io.netty.handler.codec.ByteToMessageDecoder;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ import org.apache.logging.log4j.Marker;
/*    */ import org.apache.logging.log4j.MarkerManager;
/*    */ 
/*    */ public class PacketDecoder
/*    */   extends ByteToMessageDecoder {
/* 16 */   private static final Logger a = LogManager.getLogger();
/* 17 */   private static final Marker b = MarkerManager.getMarker("PACKET_RECEIVED", NetworkManager.b);
/*    */   
/*    */   private final NetworkStatistics c;
/*    */   
/*    */   public PacketDecoder(NetworkStatistics paramNetworkStatistics) {
/* 22 */     this.c = paramNetworkStatistics;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void decode(ChannelHandlerContext paramChannelHandlerContext, ByteBuf paramByteBuf, List<Packet> paramList) {
/* 27 */     int i = paramByteBuf.readableBytes();
/* 28 */     if (i == 0) {
/*    */       return;
/*    */     }
/*    */     
/* 32 */     PacketDataSerializer packetDataSerializer = new PacketDataSerializer(paramByteBuf);
/* 33 */     int j = packetDataSerializer.a();
/* 34 */     Packet packet = Packet.a((BiMap)paramChannelHandlerContext.channel().attr(NetworkManager.e).get(), j);
/*    */     
/* 36 */     if (packet == null) {
/* 37 */       throw new IOException("Bad packet id " + j);
/*    */     }
/*    */     
/* 40 */     packet.a(packetDataSerializer);
/* 41 */     if (packetDataSerializer.readableBytes() > 0) {
/* 42 */       throw new IOException("Packet was larger than I expected, found " + packetDataSerializer.readableBytes() + " bytes extra whilst reading packet " + j);
/*    */     }
/* 44 */     paramList.add(packet);
/*    */     
/* 46 */     this.c.a(j, i);
/*    */ 
/*    */     
/* 49 */     if (a.isDebugEnabled())
/* 50 */       a.debug(b, " IN: [{}:{}] {}[{}]", new Object[] { paramChannelHandlerContext.channel().attr(NetworkManager.d).get(), Integer.valueOf(j), packet.getClass().getName(), packet.b() }); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */