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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutRelEntityMove
/*    */   extends PacketPlayOutEntity
/*    */ {
/*    */   public PacketPlayOutRelEntityMove() {}
/*    */   
/*    */   public PacketPlayOutRelEntityMove(int paramInt, byte paramByte1, byte paramByte2, byte paramByte3) {
/* 67 */     super(paramInt);
/* 68 */     this.b = paramByte1;
/* 69 */     this.c = paramByte2;
/* 70 */     this.d = paramByte3;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 75 */     super.a(paramPacketDataSerializer);
/* 76 */     this.b = paramPacketDataSerializer.readByte();
/* 77 */     this.c = paramPacketDataSerializer.readByte();
/* 78 */     this.d = paramPacketDataSerializer.readByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 83 */     super.b(paramPacketDataSerializer);
/* 84 */     paramPacketDataSerializer.writeByte(this.b);
/* 85 */     paramPacketDataSerializer.writeByte(this.c);
/* 86 */     paramPacketDataSerializer.writeByte(this.d);
/*    */   }
/*    */ 
/*    */   
/*    */   public String b() {
/* 91 */     return super.b() + String.format(", xa=%d, ya=%d, za=%d", new Object[] { Byte.valueOf(this.b), Byte.valueOf(this.c), Byte.valueOf(this.d) });
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutRelEntityMove.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */