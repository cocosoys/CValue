/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutMap
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private byte[] b;
/*    */   
/*    */   public PacketPlayOutMap() {}
/*    */   
/*    */   public PacketPlayOutMap(int paramInt, byte[] paramArrayOfbyte) {
/* 18 */     this.a = paramInt;
/* 19 */     this.b = paramArrayOfbyte;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 24 */     this.a = paramPacketDataSerializer.a();
/* 25 */     this.b = new byte[paramPacketDataSerializer.readUnsignedShort()];
/* 26 */     paramPacketDataSerializer.readBytes(this.b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 31 */     paramPacketDataSerializer.b(this.a);
/* 32 */     paramPacketDataSerializer.writeShort(this.b.length);
/* 33 */     paramPacketDataSerializer.writeBytes(this.b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 38 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String b() {
/* 43 */     return String.format("id=%d, length=%d", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b.length) });
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */