/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutEntityVelocity
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private int b;
/*    */   private int c;
/*    */   private int d;
/*    */   
/*    */   public PacketPlayOutEntityVelocity() {}
/*    */   
/*    */   public PacketPlayOutEntityVelocity(Entity paramEntity) {
/* 19 */     this(paramEntity.getId(), paramEntity.motX, paramEntity.motY, paramEntity.motZ);
/*    */   }
/*    */   
/*    */   public PacketPlayOutEntityVelocity(int paramInt, double paramDouble1, double paramDouble2, double paramDouble3) {
/* 23 */     this.a = paramInt;
/* 24 */     double d = 3.9D;
/* 25 */     if (paramDouble1 < -d) paramDouble1 = -d; 
/* 26 */     if (paramDouble2 < -d) paramDouble2 = -d; 
/* 27 */     if (paramDouble3 < -d) paramDouble3 = -d; 
/* 28 */     if (paramDouble1 > d) paramDouble1 = d; 
/* 29 */     if (paramDouble2 > d) paramDouble2 = d; 
/* 30 */     if (paramDouble3 > d) paramDouble3 = d; 
/* 31 */     this.b = (int)(paramDouble1 * 8000.0D);
/* 32 */     this.c = (int)(paramDouble2 * 8000.0D);
/* 33 */     this.d = (int)(paramDouble3 * 8000.0D);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 38 */     this.a = paramPacketDataSerializer.readInt();
/* 39 */     this.b = paramPacketDataSerializer.readShort();
/* 40 */     this.c = paramPacketDataSerializer.readShort();
/* 41 */     this.d = paramPacketDataSerializer.readShort();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 46 */     paramPacketDataSerializer.writeInt(this.a);
/* 47 */     paramPacketDataSerializer.writeShort(this.b);
/* 48 */     paramPacketDataSerializer.writeShort(this.c);
/* 49 */     paramPacketDataSerializer.writeShort(this.d);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 54 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String b() {
/* 59 */     return String.format("id=%d, x=%.2f, y=%.2f, z=%.2f", new Object[] { Integer.valueOf(this.a), Float.valueOf(this.b / 8000.0F), Float.valueOf(this.c / 8000.0F), Float.valueOf(this.d / 8000.0F) });
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutEntityVelocity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */