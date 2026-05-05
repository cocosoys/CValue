/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutCollect
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private int b;
/*    */   
/*    */   public PacketPlayOutCollect() {}
/*    */   
/*    */   public PacketPlayOutCollect(int paramInt1, int paramInt2) {
/* 16 */     this.a = paramInt1;
/* 17 */     this.b = paramInt2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 22 */     this.a = paramPacketDataSerializer.readInt();
/* 23 */     this.b = paramPacketDataSerializer.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 28 */     paramPacketDataSerializer.writeInt(this.a);
/* 29 */     paramPacketDataSerializer.writeInt(this.b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 34 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutCollect.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */