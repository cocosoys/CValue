/*    */ package net.minecraft.util;
/*    */ import com.google.common.collect.BiMap;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.handler.codec.MessageToByteEncoder;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.NetworkManager;
/*    */ import net.minecraft.network.NetworkStatistics;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ import org.apache.logging.log4j.MarkerManager;
/*    */ 
/*    */ public class MessageSerializer extends MessageToByteEncoder {
/* 15 */   private static final Logger field_150798_a = LogManager.getLogger();
/* 16 */   private static final Marker field_150797_b = MarkerManager.getMarker("PACKET_SENT", NetworkManager.field_150738_b); private final NetworkStatistics field_152500_c;
/*    */   private static final String __OBFID = "CL_00001253";
/*    */   
/*    */   public MessageSerializer(NetworkStatistics p_i1182_1_) {
/* 20 */     this.field_152500_c = p_i1182_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void encode(ChannelHandlerContext p_encode_1_, Packet p_encode_2_, ByteBuf p_encode_3_) throws IOException {
/* 25 */     Integer integer = (Integer)((BiMap)p_encode_1_.channel().attr(NetworkManager.field_150737_e).get()).inverse().get(p_encode_2_.getClass());
/*    */ 
/*    */     
/* 28 */     if (field_150798_a.isDebugEnabled()) {
/* 29 */       field_150798_a.debug(field_150797_b, "OUT: [{}:{}] {}[{}]", new Object[] { p_encode_1_.channel().attr(NetworkManager.field_150739_c).get(), integer, p_encode_2_.getClass().getName(), p_encode_2_.func_148835_b() });
/*    */     }
/*    */     
/* 32 */     if (integer == null) {
/* 33 */       throw new IOException("Can't serialize unregistered packet");
/*    */     }
/*    */     
/* 36 */     PacketBuffer packetBuffer = new PacketBuffer(p_encode_3_);
/* 37 */     packetBuffer.func_150787_b(integer.intValue());
/* 38 */     p_encode_2_.func_148840_b(packetBuffer);
/*    */     
/* 40 */     this.field_152500_c.func_152464_b(integer.intValue(), packetBuffer.readableBytes());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\MessageSerializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */