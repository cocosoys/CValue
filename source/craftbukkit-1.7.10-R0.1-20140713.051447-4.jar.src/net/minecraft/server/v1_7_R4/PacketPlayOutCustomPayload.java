/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import net.minecraft.util.io.netty.buffer.ByteBuf;
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
/*    */ public class PacketPlayOutCustomPayload
/*    */   extends Packet
/*    */ {
/*    */   private String tag;
/*    */   private byte[] data;
/*    */   
/*    */   public PacketPlayOutCustomPayload() {}
/*    */   
/*    */   public PacketPlayOutCustomPayload(String paramString, ByteBuf paramByteBuf) {
/* 27 */     this(paramString, paramByteBuf.array());
/*    */   }
/*    */   
/*    */   public PacketPlayOutCustomPayload(String paramString, byte[] paramArrayOfbyte) {
/* 31 */     this.tag = paramString;
/* 32 */     this.data = paramArrayOfbyte;
/*    */     
/* 34 */     if (paramArrayOfbyte.length >= 1048576) {
/* 35 */       throw new IllegalArgumentException("Payload may not be larger than 1048576 bytes");
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 41 */     this.tag = paramPacketDataSerializer.c(20);
/*    */     
/* 43 */     this.data = new byte[paramPacketDataSerializer.readUnsignedShort()];
/* 44 */     paramPacketDataSerializer.readBytes(this.data);
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 49 */     paramPacketDataSerializer.a(this.tag);
/* 50 */     paramPacketDataSerializer.writeShort(this.data.length);
/* 51 */     paramPacketDataSerializer.writeBytes(this.data);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 56 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutCustomPayload.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */