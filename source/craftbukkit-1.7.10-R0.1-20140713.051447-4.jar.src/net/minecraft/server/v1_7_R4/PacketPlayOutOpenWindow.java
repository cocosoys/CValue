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
/*    */ public class PacketPlayOutOpenWindow
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private int b;
/*    */   private String c;
/*    */   private int d;
/*    */   private boolean e;
/*    */   private int f;
/*    */   
/*    */   public PacketPlayOutOpenWindow() {}
/*    */   
/*    */   public PacketPlayOutOpenWindow(int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean) {
/* 37 */     this.a = paramInt1;
/* 38 */     this.b = paramInt2;
/* 39 */     this.c = paramString;
/* 40 */     this.d = paramInt3;
/* 41 */     this.e = paramBoolean;
/*    */   }
/*    */   
/*    */   public PacketPlayOutOpenWindow(int paramInt1, int paramInt2, String paramString, int paramInt3, boolean paramBoolean, int paramInt4) {
/* 45 */     this(paramInt1, paramInt2, paramString, paramInt3, paramBoolean);
/* 46 */     this.f = paramInt4;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 51 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 56 */     this.a = paramPacketDataSerializer.readUnsignedByte();
/* 57 */     this.b = paramPacketDataSerializer.readUnsignedByte();
/* 58 */     this.c = paramPacketDataSerializer.c(32);
/* 59 */     this.d = paramPacketDataSerializer.readUnsignedByte();
/* 60 */     this.e = paramPacketDataSerializer.readBoolean();
/* 61 */     if (this.b == 11) {
/* 62 */       this.f = paramPacketDataSerializer.readInt();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 68 */     paramPacketDataSerializer.writeByte(this.a);
/* 69 */     paramPacketDataSerializer.writeByte(this.b);
/* 70 */     paramPacketDataSerializer.a(this.c);
/* 71 */     paramPacketDataSerializer.writeByte(this.d);
/* 72 */     paramPacketDataSerializer.writeBoolean(this.e);
/* 73 */     if (this.b == 11)
/* 74 */       paramPacketDataSerializer.writeInt(this.f); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutOpenWindow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */