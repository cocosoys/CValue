/*    */ package net.minecraft.network.login.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.io.IOException;
/*    */ import java.security.PublicKey;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.login.INetHandlerLoginClient;
/*    */ import net.minecraft.util.CryptManager;
/*    */ 
/*    */ public class S01PacketEncryptionRequest
/*    */   extends Packet {
/*    */   private String field_149612_a;
/*    */   private PublicKey field_149610_b;
/*    */   
/*    */   public S01PacketEncryptionRequest(String p_i45268_1_, PublicKey p_i45268_2_, byte[] p_i45268_3_) {
/* 20 */     this.field_149612_a = p_i45268_1_;
/* 21 */     this.field_149610_b = p_i45268_2_;
/* 22 */     this.field_149611_c = p_i45268_3_;
/*    */   }
/*    */   private byte[] field_149611_c; private static final String __OBFID = "CL_00001376";
/*    */   public S01PacketEncryptionRequest() {}
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 27 */     this.field_149612_a = p_148837_1_.func_150789_c(20);
/* 28 */     this.field_149610_b = CryptManager.func_75896_a(func_148834_a((ByteBuf)p_148837_1_));
/* 29 */     this.field_149611_c = func_148834_a((ByteBuf)p_148837_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 34 */     p_148840_1_.func_150785_a(this.field_149612_a);
/* 35 */     func_148838_a((ByteBuf)p_148840_1_, this.field_149610_b.getEncoded());
/* 36 */     func_148838_a((ByteBuf)p_148840_1_, this.field_149611_c);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerLoginClient p_148833_1_) {
/* 41 */     p_148833_1_.func_147389_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String func_149609_c() {
/* 45 */     return this.field_149612_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public PublicKey func_149608_d() {
/* 49 */     return this.field_149610_b;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public byte[] func_149607_e() {
/* 53 */     return this.field_149611_c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\login\server\S01PacketEncryptionRequest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */