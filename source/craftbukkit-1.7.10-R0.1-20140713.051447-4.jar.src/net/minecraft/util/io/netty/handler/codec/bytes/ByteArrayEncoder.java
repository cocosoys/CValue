/*    */ package net.minecraft.util.io.netty.handler.codec.bytes;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.util.io.netty.buffer.Unpooled;
/*    */ import net.minecraft.util.io.netty.channel.ChannelHandler.Sharable;
/*    */ import net.minecraft.util.io.netty.channel.ChannelHandlerContext;
/*    */ import net.minecraft.util.io.netty.handler.codec.MessageToMessageEncoder;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ @Sharable
/*    */ public class ByteArrayEncoder
/*    */   extends MessageToMessageEncoder<byte[]>
/*    */ {
/*    */   protected void encode(ChannelHandlerContext ctx, byte[] msg, List<Object> out) throws Exception {
/* 57 */     out.add(Unpooled.wrappedBuffer(msg));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\handler\codec\bytes\ByteArrayEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */