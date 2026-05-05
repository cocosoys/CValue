/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutBlockBreakAnimation
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private int b;
/*    */   private int c;
/*    */   private int d;
/*    */   private int e;
/*    */   
/*    */   public PacketPlayOutBlockBreakAnimation() {}
/*    */   
/*    */   public PacketPlayOutBlockBreakAnimation(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5) {
/* 20 */     this.a = paramInt1;
/* 21 */     this.b = paramInt2;
/* 22 */     this.c = paramInt3;
/* 23 */     this.d = paramInt4;
/* 24 */     this.e = paramInt5;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 29 */     this.a = paramPacketDataSerializer.a();
/* 30 */     this.b = paramPacketDataSerializer.readInt();
/* 31 */     this.c = paramPacketDataSerializer.readInt();
/* 32 */     this.d = paramPacketDataSerializer.readInt();
/* 33 */     this.e = paramPacketDataSerializer.readUnsignedByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 38 */     paramPacketDataSerializer.b(this.a);
/* 39 */     paramPacketDataSerializer.writeInt(this.b);
/* 40 */     paramPacketDataSerializer.writeInt(this.c);
/* 41 */     paramPacketDataSerializer.writeInt(this.d);
/* 42 */     paramPacketDataSerializer.writeByte(this.e);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 47 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutBlockBreakAnimation.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */