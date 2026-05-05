/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class PacketPlayOutSpawnEntityPainting
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private int b;
/*    */   private int c;
/*    */   private int d;
/*    */   private int e;
/*    */   private String f;
/*    */   
/*    */   public PacketPlayOutSpawnEntityPainting() {}
/*    */   
/*    */   public PacketPlayOutSpawnEntityPainting(EntityPainting paramEntityPainting) {
/* 23 */     this.a = paramEntityPainting.getId();
/* 24 */     this.b = paramEntityPainting.x;
/* 25 */     this.c = paramEntityPainting.y;
/* 26 */     this.d = paramEntityPainting.z;
/* 27 */     this.e = paramEntityPainting.direction;
/* 28 */     this.f = paramEntityPainting.art.B;
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 33 */     this.a = paramPacketDataSerializer.a();
/* 34 */     this.f = paramPacketDataSerializer.c(EnumArt.A);
/* 35 */     this.b = paramPacketDataSerializer.readInt();
/* 36 */     this.c = paramPacketDataSerializer.readInt();
/* 37 */     this.d = paramPacketDataSerializer.readInt();
/* 38 */     this.e = paramPacketDataSerializer.readInt();
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 43 */     paramPacketDataSerializer.b(this.a);
/* 44 */     paramPacketDataSerializer.a(this.f);
/* 45 */     paramPacketDataSerializer.writeInt(this.b);
/* 46 */     paramPacketDataSerializer.writeInt(this.c);
/* 47 */     paramPacketDataSerializer.writeInt(this.d);
/* 48 */     paramPacketDataSerializer.writeInt(this.e);
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 53 */     paramPacketPlayOutListener.a(this);
/*    */   }
/*    */ 
/*    */   
/*    */   public String b() {
/* 58 */     return String.format("id=%d, type=%s, x=%d, y=%d, z=%d", new Object[] { Integer.valueOf(this.a), this.f, Integer.valueOf(this.b), Integer.valueOf(this.c), Integer.valueOf(this.d) });
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutSpawnEntityPainting.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */