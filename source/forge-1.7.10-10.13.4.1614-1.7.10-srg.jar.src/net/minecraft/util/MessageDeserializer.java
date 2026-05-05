/*    */ package net.minecraft.util;
/*    */ import com.google.common.collect.BiMap;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import java.io.IOException;
/*    */ import java.util.List;
/*    */ import net.minecraft.network.NetworkManager;
/*    */ import net.minecraft.network.NetworkStatistics;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import org.apache.logging.log4j.LogManager;
/*    */ import org.apache.logging.log4j.Logger;
/*    */ import org.apache.logging.log4j.MarkerManager;
/*    */ 
/*    */ public class MessageDeserializer extends ByteToMessageDecoder {
/* 16 */   private static final Logger field_150800_a = LogManager.getLogger();
/* 17 */   private static final Marker field_150799_b = MarkerManager.getMarker("PACKET_RECEIVED", NetworkManager.field_150738_b);
/*    */   private final NetworkStatistics field_152499_c;
/*    */   private static final String __OBFID = "CL_00001252";
/*    */   
/*    */   public MessageDeserializer(NetworkStatistics p_i1183_1_) {
/* 22 */     this.field_152499_c = p_i1183_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void decode(ChannelHandlerContext p_decode_1_, ByteBuf p_decode_2_, List<Packet> p_decode_3_) throws IOException {
/* 27 */     int i = p_decode_2_.readableBytes();
/* 28 */     if (i == 0) {
/*    */       return;
/*    */     }
/*    */     
/* 32 */     PacketBuffer packetBuffer = new PacketBuffer(p_decode_2_);
/* 33 */     int j = packetBuffer.func_150792_a();
/* 34 */     Packet packet = Packet.func_148839_a((BiMap)p_decode_1_.channel().attr(NetworkManager.field_150736_d).get(), j);
/*    */     
/* 36 */     if (packet == null) {
/* 37 */       throw new IOException("Bad packet id " + j);
/*    */     }
/*    */     
/* 40 */     packet.func_148837_a(packetBuffer);
/* 41 */     if (packetBuffer.readableBytes() > 0) {
/* 42 */       throw new IOException("Packet was larger than I expected, found " + packetBuffer.readableBytes() + " bytes extra whilst reading packet " + j);
/*    */     }
/* 44 */     p_decode_3_.add(packet);
/*    */     
/* 46 */     this.field_152499_c.func_152469_a(j, i);
/*    */ 
/*    */     
/* 49 */     if (field_150800_a.isDebugEnabled())
/* 50 */       field_150800_a.debug(field_150799_b, " IN: [{}:{}] {}[{}]", new Object[] { p_decode_1_.channel().attr(NetworkManager.field_150739_c).get(), Integer.valueOf(j), packet.getClass().getName(), packet.func_148835_b() }); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\MessageDeserializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */