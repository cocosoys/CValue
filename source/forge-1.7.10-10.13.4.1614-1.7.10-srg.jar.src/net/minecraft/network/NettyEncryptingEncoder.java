/*    */ package net.minecraft.network;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.handler.codec.MessageToByteEncoder;
/*    */ import javax.crypto.Cipher;
/*    */ import javax.crypto.ShortBufferException;
/*    */ 
/*    */ public class NettyEncryptingEncoder extends MessageToByteEncoder {
/*    */   private final NettyEncryptionTranslator field_150750_a;
/*    */   
/*    */   public NettyEncryptingEncoder(Cipher p_i45142_1_) {
/* 13 */     this.field_150750_a = new NettyEncryptionTranslator(p_i45142_1_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001239";
/*    */   
/*    */   protected void encode(ChannelHandlerContext p_encode_1_, ByteBuf p_encode_2_, ByteBuf p_encode_3_) throws ShortBufferException {
/* 18 */     this.field_150750_a.func_150504_a(p_encode_2_, p_encode_3_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\NettyEncryptingEncoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */