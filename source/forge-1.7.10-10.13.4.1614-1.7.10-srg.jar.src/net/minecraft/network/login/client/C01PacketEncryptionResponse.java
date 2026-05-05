/*    */ package net.minecraft.network.login.client;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.io.IOException;
/*    */ import java.security.PrivateKey;
/*    */ import java.security.PublicKey;
/*    */ import javax.crypto.SecretKey;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.login.INetHandlerLoginServer;
/*    */ import net.minecraft.util.CryptManager;
/*    */ 
/*    */ public class C01PacketEncryptionResponse extends Packet {
/* 13 */   private byte[] field_149302_a = new byte[0];
/* 14 */   private byte[] field_149301_b = new byte[0];
/*    */   
/*    */   private static final String __OBFID = "CL_00001380";
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public C01PacketEncryptionResponse(SecretKey p_i45271_1_, PublicKey p_i45271_2_, byte[] p_i45271_3_) {
/* 21 */     this.field_149302_a = CryptManager.func_75894_a(p_i45271_2_, p_i45271_1_.getEncoded());
/* 22 */     this.field_149301_b = CryptManager.func_75894_a(p_i45271_2_, p_i45271_3_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 27 */     this.field_149302_a = func_148834_a((ByteBuf)p_148837_1_);
/* 28 */     this.field_149301_b = func_148834_a((ByteBuf)p_148837_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 33 */     func_148838_a((ByteBuf)p_148840_1_, this.field_149302_a);
/* 34 */     func_148838_a((ByteBuf)p_148840_1_, this.field_149301_b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerLoginServer p_148833_1_) {
/* 39 */     p_148833_1_.func_147315_a(this);
/*    */   }
/*    */   
/*    */   public SecretKey func_149300_a(PrivateKey p_149300_1_) {
/* 43 */     return CryptManager.func_75887_a(p_149300_1_, this.field_149302_a);
/*    */   }
/*    */   
/*    */   public byte[] func_149299_b(PrivateKey p_149299_1_) {
/* 47 */     if (p_149299_1_ == null) {
/* 48 */       return this.field_149301_b;
/*    */     }
/* 50 */     return CryptManager.func_75889_b(p_149299_1_, this.field_149301_b);
/*    */   }
/*    */   
/*    */   public C01PacketEncryptionResponse() {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\login\client\C01PacketEncryptionResponse.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */