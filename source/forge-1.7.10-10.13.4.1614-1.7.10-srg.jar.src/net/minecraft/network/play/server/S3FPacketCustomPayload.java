/*    */ package net.minecraft.network.play.server;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ import java.io.IOException;
/*    */ import net.minecraft.network.INetHandler;
/*    */ import net.minecraft.network.Packet;
/*    */ import net.minecraft.network.PacketBuffer;
/*    */ import net.minecraft.network.play.INetHandlerPlayClient;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class S3FPacketCustomPayload
/*    */   extends Packet
/*    */ {
/*    */   private String field_149172_a;
/*    */   private byte[] field_149171_b;
/*    */   private static final String __OBFID = "CL_00001297";
/*    */   
/*    */   public S3FPacketCustomPayload() {}
/*    */   
/*    */   public S3FPacketCustomPayload(String p_i45189_1_, ByteBuf p_i45189_2_) {
/* 27 */     this(p_i45189_1_, p_i45189_2_.array());
/*    */   }
/*    */   
/*    */   public S3FPacketCustomPayload(String p_i45190_1_, byte[] p_i45190_2_) {
/* 31 */     this.field_149172_a = p_i45190_1_;
/* 32 */     this.field_149171_b = p_i45190_2_;
/*    */     
/* 34 */     if (p_i45190_2_.length >= 1048576) {
/* 35 */       throw new IllegalArgumentException("Payload may not be larger than 1048576 bytes");
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 41 */     this.field_149172_a = p_148837_1_.func_150789_c(20);
/*    */     
/* 43 */     this.field_149171_b = new byte[p_148837_1_.readUnsignedShort()];
/* 44 */     p_148837_1_.readBytes(this.field_149171_b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 49 */     p_148840_1_.func_150785_a(this.field_149172_a);
/* 50 */     p_148840_1_.writeShort(this.field_149171_b.length);
/* 51 */     p_148840_1_.writeBytes(this.field_149171_b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 56 */     p_148833_1_.func_147240_a(this);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public String func_149169_c() {
/* 60 */     return this.field_149172_a;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public byte[] func_149168_d() {
/* 64 */     return this.field_149171_b;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S3FPacketCustomPayload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */