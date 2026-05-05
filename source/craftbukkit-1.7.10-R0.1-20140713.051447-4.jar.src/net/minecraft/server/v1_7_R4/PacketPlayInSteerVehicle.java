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
/*    */ public class PacketPlayInSteerVehicle
/*    */   extends Packet
/*    */ {
/*    */   private float a;
/*    */   private float b;
/*    */   private boolean c;
/*    */   private boolean d;
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 26 */     this.a = paramPacketDataSerializer.readFloat();
/* 27 */     this.b = paramPacketDataSerializer.readFloat();
/* 28 */     this.c = paramPacketDataSerializer.readBoolean();
/* 29 */     this.d = paramPacketDataSerializer.readBoolean();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 34 */     paramPacketDataSerializer.writeFloat(this.a);
/* 35 */     paramPacketDataSerializer.writeFloat(this.b);
/* 36 */     paramPacketDataSerializer.writeBoolean(this.c);
/* 37 */     paramPacketDataSerializer.writeBoolean(this.d);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayInListener paramPacketPlayInListener) {
/* 42 */     paramPacketPlayInListener.a(this);
/*    */   }
/*    */   
/*    */   public float c() {
/* 46 */     return this.a;
/*    */   }
/*    */   
/*    */   public float d() {
/* 50 */     return this.b;
/*    */   }
/*    */   
/*    */   public boolean e() {
/* 54 */     return this.c;
/*    */   }
/*    */   
/*    */   public boolean f() {
/* 58 */     return this.d;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayInSteerVehicle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */