/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutEntityTeleport
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private int b;
/*    */   private int c;
/*    */   private int d;
/*    */   private byte e;
/*    */   private byte f;
/*    */   
/*    */   public PacketPlayOutEntityTeleport() {}
/*    */   
/*    */   public PacketPlayOutEntityTeleport(Entity paramEntity) {
/* 22 */     this.a = paramEntity.getId();
/* 23 */     this.b = MathHelper.floor(paramEntity.locX * 32.0D);
/* 24 */     this.c = MathHelper.floor(paramEntity.locY * 32.0D);
/* 25 */     this.d = MathHelper.floor(paramEntity.locZ * 32.0D);
/* 26 */     this.e = (byte)(int)(paramEntity.yaw * 256.0F / 360.0F);
/* 27 */     this.f = (byte)(int)(paramEntity.pitch * 256.0F / 360.0F);
/*    */   }
/*    */   
/*    */   public PacketPlayOutEntityTeleport(int paramInt1, int paramInt2, int paramInt3, int paramInt4, byte paramByte1, byte paramByte2) {
/* 31 */     this.a = paramInt1;
/* 32 */     this.b = paramInt2;
/* 33 */     this.c = paramInt3;
/* 34 */     this.d = paramInt4;
/* 35 */     this.e = paramByte1;
/* 36 */     this.f = paramByte2;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 41 */     this.a = paramPacketDataSerializer.readInt();
/* 42 */     this.b = paramPacketDataSerializer.readInt();
/* 43 */     this.c = paramPacketDataSerializer.readInt();
/* 44 */     this.d = paramPacketDataSerializer.readInt();
/* 45 */     this.e = paramPacketDataSerializer.readByte();
/* 46 */     this.f = paramPacketDataSerializer.readByte();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 51 */     paramPacketDataSerializer.writeInt(this.a);
/* 52 */     paramPacketDataSerializer.writeInt(this.b);
/* 53 */     paramPacketDataSerializer.writeInt(this.c);
/* 54 */     paramPacketDataSerializer.writeInt(this.d);
/* 55 */     paramPacketDataSerializer.writeByte(this.e);
/* 56 */     paramPacketDataSerializer.writeByte(this.f);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 61 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutEntityTeleport.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */