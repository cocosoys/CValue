/*    */ package net.minecraft.network;
/*    */ 
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import io.netty.channel.ChannelHandlerContext;
/*    */ import javax.crypto.Cipher;
/*    */ import javax.crypto.ShortBufferException;
/*    */ 
/*    */ public class NettyEncryptionTranslator
/*    */ {
/*    */   private final Cipher field_150507_a;
/* 11 */   private byte[] field_150505_b = new byte[0];
/* 12 */   private byte[] field_150506_c = new byte[0];
/*    */   
/*    */   protected NettyEncryptionTranslator(Cipher p_i45140_1_) {
/* 15 */     this.field_150507_a = p_i45140_1_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00001237";
/*    */   private byte[] func_150502_a(ByteBuf p_150502_1_) {
/* 19 */     int i = p_150502_1_.readableBytes();
/* 20 */     if (this.field_150505_b.length < i) {
/* 21 */       this.field_150505_b = new byte[i];
/*    */     }
/* 23 */     p_150502_1_.readBytes(this.field_150505_b, 0, i);
/* 24 */     return this.field_150505_b;
/*    */   }
/*    */   
/*    */   protected ByteBuf func_150503_a(ChannelHandlerContext p_150503_1_, ByteBuf p_150503_2_) throws ShortBufferException {
/* 28 */     int i = p_150503_2_.readableBytes();
/* 29 */     byte[] arrayOfByte = func_150502_a(p_150503_2_);
/*    */     
/* 31 */     ByteBuf byteBuf = p_150503_1_.alloc().heapBuffer(this.field_150507_a.getOutputSize(i));
/* 32 */     byteBuf.writerIndex(this.field_150507_a.update(arrayOfByte, 0, i, byteBuf.array(), byteBuf.arrayOffset()));
/*    */     
/* 34 */     return byteBuf;
/*    */   }
/*    */   
/*    */   protected void func_150504_a(ByteBuf p_150504_1_, ByteBuf p_150504_2_) throws ShortBufferException {
/* 38 */     int i = p_150504_1_.readableBytes();
/* 39 */     byte[] arrayOfByte = func_150502_a(p_150504_1_);
/*    */     
/* 41 */     int j = this.field_150507_a.getOutputSize(i);
/* 42 */     if (this.field_150506_c.length < j) {
/* 43 */       this.field_150506_c = new byte[j];
/*    */     }
/* 45 */     p_150504_2_.writeBytes(this.field_150506_c, 0, this.field_150507_a.update(arrayOfByte, 0, i, this.field_150506_c));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\NettyEncryptionTranslator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */