/*    */ package net.minecraft.server.v1_7_R4;
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
/*    */ public class PacketPlayOutRelEntityMoveLook
/*    */   extends PacketPlayOutEntity
/*    */ {
/*    */   public PacketPlayOutRelEntityMoveLook() {
/* 22 */     this.g = true;
/*    */   }
/*    */   
/*    */   public PacketPlayOutRelEntityMoveLook(int paramInt, byte paramByte1, byte paramByte2, byte paramByte3, byte paramByte4, byte paramByte5) {
/* 26 */     super(paramInt);
/* 27 */     this.b = paramByte1;
/* 28 */     this.c = paramByte2;
/* 29 */     this.d = paramByte3;
/* 30 */     this.e = paramByte4;
/* 31 */     this.f = paramByte5;
/* 32 */     this.g = true;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 37 */     super.a(paramPacketDataSerializer);
/* 38 */     this.b = paramPacketDataSerializer.readByte();
/* 39 */     this.c = paramPacketDataSerializer.readByte();
/* 40 */     this.d = paramPacketDataSerializer.readByte();
/* 41 */     this.e = paramPacketDataSerializer.readByte();
/* 42 */     this.f = paramPacketDataSerializer.readByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 47 */     super.b(paramPacketDataSerializer);
/* 48 */     paramPacketDataSerializer.writeByte(this.b);
/* 49 */     paramPacketDataSerializer.writeByte(this.c);
/* 50 */     paramPacketDataSerializer.writeByte(this.d);
/* 51 */     paramPacketDataSerializer.writeByte(this.e);
/* 52 */     paramPacketDataSerializer.writeByte(this.f);
/*    */   }
/*    */ 
/*    */   
/*    */   public String b() {
/* 57 */     return super.b() + String.format(", xa=%d, ya=%d, za=%d, yRot=%d, xRot=%d", new Object[] { Byte.valueOf(this.b), Byte.valueOf(this.c), Byte.valueOf(this.d), Byte.valueOf(this.e), Byte.valueOf(this.f) });
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutRelEntityMoveLook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */