/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutPosition
/*    */   extends Packet
/*    */ {
/*    */   private double a;
/*    */   private double b;
/*    */   private double c;
/*    */   private float d;
/*    */   private float e;
/*    */   private boolean f;
/*    */   
/*    */   public PacketPlayOutPosition() {}
/*    */   
/*    */   public PacketPlayOutPosition(double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, float paramFloat2, boolean paramBoolean) {
/* 21 */     this.a = paramDouble1;
/* 22 */     this.b = paramDouble2;
/* 23 */     this.c = paramDouble3;
/* 24 */     this.d = paramFloat1;
/* 25 */     this.e = paramFloat2;
/* 26 */     this.f = paramBoolean;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 31 */     this.a = paramPacketDataSerializer.readDouble();
/* 32 */     this.b = paramPacketDataSerializer.readDouble();
/* 33 */     this.c = paramPacketDataSerializer.readDouble();
/* 34 */     this.d = paramPacketDataSerializer.readFloat();
/* 35 */     this.e = paramPacketDataSerializer.readFloat();
/* 36 */     this.f = paramPacketDataSerializer.readBoolean();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 41 */     paramPacketDataSerializer.writeDouble(this.a);
/* 42 */     paramPacketDataSerializer.writeDouble(this.b);
/* 43 */     paramPacketDataSerializer.writeDouble(this.c);
/* 44 */     paramPacketDataSerializer.writeFloat(this.d);
/* 45 */     paramPacketDataSerializer.writeFloat(this.e);
/* 46 */     paramPacketDataSerializer.writeBoolean(this.f);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 51 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutPosition.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */