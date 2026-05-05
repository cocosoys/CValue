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
/*    */ public class PacketPlayOutBed
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private int b;
/*    */   private int c;
/*    */   private int d;
/*    */   
/*    */   public PacketPlayOutBed() {}
/*    */   
/*    */   public PacketPlayOutBed(EntityHuman paramEntityHuman, int paramInt1, int paramInt2, int paramInt3) {
/* 23 */     this.b = paramInt1;
/* 24 */     this.c = paramInt2;
/* 25 */     this.d = paramInt3;
/* 26 */     this.a = paramEntityHuman.getId();
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 31 */     this.a = paramPacketDataSerializer.readInt();
/* 32 */     this.b = paramPacketDataSerializer.readInt();
/* 33 */     this.c = paramPacketDataSerializer.readByte();
/* 34 */     this.d = paramPacketDataSerializer.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 39 */     paramPacketDataSerializer.writeInt(this.a);
/* 40 */     paramPacketDataSerializer.writeInt(this.b);
/* 41 */     paramPacketDataSerializer.writeByte(this.c);
/* 42 */     paramPacketDataSerializer.writeInt(this.d);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 47 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutBed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */