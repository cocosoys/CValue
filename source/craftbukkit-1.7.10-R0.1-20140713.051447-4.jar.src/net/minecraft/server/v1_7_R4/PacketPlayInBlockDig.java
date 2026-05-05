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
/*    */ public class PacketPlayInBlockDig
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private int b;
/*    */   private int c;
/*    */   private int face;
/*    */   private int e;
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 35 */     this.e = paramPacketDataSerializer.readUnsignedByte();
/* 36 */     this.a = paramPacketDataSerializer.readInt();
/* 37 */     this.b = paramPacketDataSerializer.readUnsignedByte();
/* 38 */     this.c = paramPacketDataSerializer.readInt();
/* 39 */     this.face = paramPacketDataSerializer.readUnsignedByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 44 */     paramPacketDataSerializer.writeByte(this.e);
/* 45 */     paramPacketDataSerializer.writeInt(this.a);
/* 46 */     paramPacketDataSerializer.writeByte(this.b);
/* 47 */     paramPacketDataSerializer.writeInt(this.c);
/* 48 */     paramPacketDataSerializer.writeByte(this.face);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayInListener paramPacketPlayInListener) {
/* 53 */     paramPacketPlayInListener.a(this);
/*    */   }
/*    */   
/*    */   public int c() {
/* 57 */     return this.a;
/*    */   }
/*    */   
/*    */   public int d() {
/* 61 */     return this.b;
/*    */   }
/*    */   
/*    */   public int e() {
/* 65 */     return this.c;
/*    */   }
/*    */   
/*    */   public int f() {
/* 69 */     return this.face;
/*    */   }
/*    */   
/*    */   public int g() {
/* 73 */     return this.e;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayInBlockDig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */