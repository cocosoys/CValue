/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutUpdateHealth
/*    */   extends Packet
/*    */ {
/*    */   private float a;
/*    */   private int b;
/*    */   private float c;
/*    */   
/*    */   public PacketPlayOutUpdateHealth() {}
/*    */   
/*    */   public PacketPlayOutUpdateHealth(float paramFloat1, int paramInt, float paramFloat2) {
/* 17 */     this.a = paramFloat1;
/* 18 */     this.b = paramInt;
/* 19 */     this.c = paramFloat2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 24 */     this.a = paramPacketDataSerializer.readFloat();
/* 25 */     this.b = paramPacketDataSerializer.readShort();
/* 26 */     this.c = paramPacketDataSerializer.readFloat();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 31 */     paramPacketDataSerializer.writeFloat(this.a);
/* 32 */     paramPacketDataSerializer.writeShort(this.b);
/* 33 */     paramPacketDataSerializer.writeFloat(this.c);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 38 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutUpdateHealth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */