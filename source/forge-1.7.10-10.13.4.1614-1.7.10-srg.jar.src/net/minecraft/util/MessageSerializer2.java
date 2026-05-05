/*    */ package net.minecraft.util;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.handler.codec.MessageToByteEncoder;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MessageSerializer2
/*    */   extends MessageToByteEncoder
/*    */ {
/*    */   private static final String __OBFID = "CL_00001256";
/*    */   
/*    */   protected void encode(ChannelHandlerContext p_encode_1_, ByteBuf p_encode_2_, ByteBuf p_encode_3_) {
/* 16 */     int i = p_encode_2_.readableBytes();
/* 17 */     int j = PacketBuffer.func_150790_a(i);
/*    */     
/* 19 */     if (j > 3) {
/* 20 */       throw new IllegalArgumentException("unable to fit " + i + " into " + '\003');
/*    */     }
/*    */     
/* 23 */     PacketBuffer packetBuffer = new PacketBuffer(p_encode_3_);
/*    */     
/* 25 */     packetBuffer.ensureWritable(j + i);
/*    */     
/* 27 */     packetBuffer.func_150787_b(i);
/* 28 */     packetBuffer.writeBytes(p_encode_2_, p_encode_2_.readerIndex(), i);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\MessageSerializer2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */