/*    */ package net.minecraft.util.io.netty.handler.codec.base64;
/*    */ 
/*    */ import java.util.List;
/*    */ import net.minecraft.util.io.netty.buffer.ByteBuf;
/*    */ import net.minecraft.util.io.netty.channel.ChannelHandler.Sharable;
/*    */ import net.minecraft.util.io.netty.channel.ChannelHandlerContext;
/*    */ import net.minecraft.util.io.netty.handler.codec.MessageToMessageDecoder;
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
/*    */ public class Base64Decoder
/*    */   extends MessageToMessageDecoder<ByteBuf>
/*    */ {
/*    */   private final Base64Dialect dialect;
/*    */   
/*    */   public Base64Decoder() {
/* 52 */     this(Base64Dialect.STANDARD);
/*    */   }
/*    */   
/*    */   public Base64Decoder(Base64Dialect dialect) {
/* 56 */     if (dialect == null) {
/* 57 */       throw new NullPointerException("dialect");
/*    */     }
/* 59 */     this.dialect = dialect;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void decode(ChannelHandlerContext ctx, ByteBuf msg, List<Object> out) throws Exception {
/* 64 */     out.add(Base64.decode(msg, msg.readerIndex(), msg.readableBytes(), this.dialect));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\handler\codec\base64\Base64Decoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */