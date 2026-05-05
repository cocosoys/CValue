/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutExperience
/*    */   extends Packet
/*    */ {
/*    */   private float a;
/*    */   private int b;
/*    */   private int c;
/*    */   
/*    */   public PacketPlayOutExperience() {}
/*    */   
/*    */   public PacketPlayOutExperience(float paramFloat, int paramInt1, int paramInt2) {
/* 17 */     this.a = paramFloat;
/* 18 */     this.b = paramInt1;
/* 19 */     this.c = paramInt2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 24 */     this.a = paramPacketDataSerializer.readFloat();
/* 25 */     this.c = paramPacketDataSerializer.readShort();
/* 26 */     this.b = paramPacketDataSerializer.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 31 */     paramPacketDataSerializer.writeFloat(this.a);
/* 32 */     paramPacketDataSerializer.writeShort(this.c);
/* 33 */     paramPacketDataSerializer.writeShort(this.b);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 38 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutExperience.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */