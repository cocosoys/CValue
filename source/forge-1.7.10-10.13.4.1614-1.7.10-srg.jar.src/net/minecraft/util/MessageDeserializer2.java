/*    */ package net.minecraft.util;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.buffer.Unpooled;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.handler.codec.ByteToMessageDecoder;
/*    */ import io.netty.handler.codec.CorruptedFrameException;
/*    */ import java.util.List;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ 
/*    */ public class MessageDeserializer2
/*    */   extends ByteToMessageDecoder {
/*    */   protected void decode(ChannelHandlerContext p_decode_1_, ByteBuf p_decode_2_, List<ByteBuf> p_decode_3_) {
/* 14 */     p_decode_2_.markReaderIndex();
/*    */     
/* 16 */     byte[] arrayOfByte = new byte[3];
/* 17 */     for (byte b = 0; b < arrayOfByte.length; b++) {
/* 18 */       if (!p_decode_2_.isReadable()) {
/* 19 */         p_decode_2_.resetReaderIndex();
/*    */         
/*    */         return;
/*    */       } 
/* 23 */       arrayOfByte[b] = p_decode_2_.readByte();
/* 24 */       if (arrayOfByte[b] >= 0) {
/* 25 */         PacketBuffer packetBuffer = new PacketBuffer(Unpooled.wrappedBuffer(arrayOfByte));
/*    */         try {
/* 27 */           int i = packetBuffer.func_150792_a();
/*    */           
/* 29 */           if (p_decode_2_.readableBytes() < i) {
/* 30 */             p_decode_2_.resetReaderIndex();
/*    */             return;
/*    */           } 
/* 33 */           p_decode_3_.add(p_decode_2_.readBytes(i));
/*    */           
/*    */           return;
/*    */         } finally {
/* 37 */           packetBuffer.release();
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 42 */     throw new CorruptedFrameException("length wider than 21-bit");
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00001255";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\MessageDeserializer2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */