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
/*    */ public class PacketPlayInBlockPlace
/*    */   extends Packet
/*    */ {
/*    */   private int a;
/*    */   private int b;
/*    */   private int c;
/*    */   private int d;
/*    */   private ItemStack e;
/*    */   private float f;
/*    */   private float g;
/*    */   private float h;
/*    */   
/*    */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 36 */     this.a = paramPacketDataSerializer.readInt();
/* 37 */     this.b = paramPacketDataSerializer.readUnsignedByte();
/* 38 */     this.c = paramPacketDataSerializer.readInt();
/* 39 */     this.d = paramPacketDataSerializer.readUnsignedByte();
/* 40 */     this.e = paramPacketDataSerializer.c();
/* 41 */     this.f = paramPacketDataSerializer.readUnsignedByte() / 16.0F;
/* 42 */     this.g = paramPacketDataSerializer.readUnsignedByte() / 16.0F;
/* 43 */     this.h = paramPacketDataSerializer.readUnsignedByte() / 16.0F;
/*    */   }
/*    */ 
/*    */   
/*    */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 48 */     paramPacketDataSerializer.writeInt(this.a);
/* 49 */     paramPacketDataSerializer.writeByte(this.b);
/* 50 */     paramPacketDataSerializer.writeInt(this.c);
/* 51 */     paramPacketDataSerializer.writeByte(this.d);
/* 52 */     paramPacketDataSerializer.a(this.e);
/* 53 */     paramPacketDataSerializer.writeByte((int)(this.f * 16.0F));
/* 54 */     paramPacketDataSerializer.writeByte((int)(this.g * 16.0F));
/* 55 */     paramPacketDataSerializer.writeByte((int)(this.h * 16.0F));
/*    */   }
/*    */ 
/*    */   
/*    */   public void a(PacketPlayInListener paramPacketPlayInListener) {
/* 60 */     paramPacketPlayInListener.a(this);
/*    */   }
/*    */   
/*    */   public int c() {
/* 64 */     return this.a;
/*    */   }
/*    */   
/*    */   public int d() {
/* 68 */     return this.b;
/*    */   }
/*    */   
/*    */   public int e() {
/* 72 */     return this.c;
/*    */   }
/*    */   
/*    */   public int getFace() {
/* 76 */     return this.d;
/*    */   }
/*    */   
/*    */   public ItemStack getItemStack() {
/* 80 */     return this.e;
/*    */   }
/*    */   
/*    */   public float h() {
/* 84 */     return this.f;
/*    */   }
/*    */   
/*    */   public float i() {
/* 88 */     return this.g;
/*    */   }
/*    */   
/*    */   public float j() {
/* 92 */     return this.h;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayInBlockPlace.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */