/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutWorldEvent
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private int b;
/*    */   private int c;
/*    */   private int d;
/*    */   private int e;
/*    */   private boolean f;
/*    */   
/*    */   public PacketPlayOutWorldEvent() {}
/*    */   
/*    */   public PacketPlayOutWorldEvent(int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5, boolean paramBoolean) {
/* 22 */     this.a = paramInt1;
/* 23 */     this.c = paramInt2;
/* 24 */     this.d = paramInt3;
/* 25 */     this.e = paramInt4;
/* 26 */     this.b = paramInt5;
/* 27 */     this.f = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 32 */     this.a = paramPacketDataSerializer.readInt();
/* 33 */     this.c = paramPacketDataSerializer.readInt();
/* 34 */     this.d = paramPacketDataSerializer.readByte() & 0xFF;
/* 35 */     this.e = paramPacketDataSerializer.readInt();
/* 36 */     this.b = paramPacketDataSerializer.readInt();
/* 37 */     this.f = paramPacketDataSerializer.readBoolean();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 42 */     paramPacketDataSerializer.writeInt(this.a);
/* 43 */     paramPacketDataSerializer.writeInt(this.c);
/* 44 */     paramPacketDataSerializer.writeByte(this.d & 0xFF);
/* 45 */     paramPacketDataSerializer.writeInt(this.e);
/* 46 */     paramPacketDataSerializer.writeInt(this.b);
/* 47 */     paramPacketDataSerializer.writeBoolean(this.f);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 52 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutWorldEvent.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */