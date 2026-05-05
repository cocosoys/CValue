/*    */ package net.minecraft.util.io.netty.handler.codec;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.util.io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.util.io.netty.channel.ChannelHandlerContext;
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
/*    */ public class FixedLengthFrameDecoder
/*    */   extends ByteToMessageDecoder
/*    */ {
/*    */   private final int frameLength;
/*    */   
/*    */   public FixedLengthFrameDecoder(int frameLength) {
/* 49 */     if (frameLength <= 0) {
/* 50 */       throw new IllegalArgumentException("frameLength must be a positive integer: " + frameLength);
/*    */     }
/*    */     
/* 53 */     this.frameLength = frameLength;
/*    */   }
/*    */ 
/*    */   
/*    */   protected final void decode(ChannelHandlerContext ctx, ByteBuf in, List<Object> out) throws Exception {
/* 58 */     Object decoded = decode(ctx, in);
/* 59 */     if (decoded != null) {
/* 60 */       out.add(decoded);
/*    */     }
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
/*    */   protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
/* 74 */     if (in.readableBytes() < this.frameLength) {
/* 75 */       return null;
/*    */     }
/* 77 */     return in.readBytes(this.frameLength);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\handler\codec\FixedLengthFrameDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */