/*    */ package net.minecraft.network;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import io.netty.handler.codec.MessageToMessageDecoder;
/*    */ import java.util.List;
/*    */ import javax.crypto.Cipher;
/*    */ import javax.crypto.ShortBufferException;
/*    */ 
/*    */ public class NettyEncryptingDecoder extends MessageToMessageDecoder {
/*    */   private final NettyEncryptionTranslator field_150509_a;
/*    */   
/*    */   public NettyEncryptingDecoder(Cipher p_i45141_1_) {
/* 14 */     this.field_150509_a = new NettyEncryptionTranslator(p_i45141_1_);
/*    */   }
/*    */   private static final String __OBFID = "CL_00001238";
/*    */   
/*    */   protected void decode(ChannelHandlerContext p_decode_1_, ByteBuf p_decode_2_, List<ByteBuf> p_decode_3_) throws ShortBufferException {
/* 19 */     p_decode_3_.add(this.field_150509_a.func_150503_a(p_decode_1_, p_decode_2_));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\NettyEncryptingDecoder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */