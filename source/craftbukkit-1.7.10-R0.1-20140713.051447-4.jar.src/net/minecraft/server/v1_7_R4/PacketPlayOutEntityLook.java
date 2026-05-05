/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PacketPlayOutEntityLook
/*     */   extends PacketPlayOutEntity
/*     */ {
/*     */   public PacketPlayOutEntityLook() {
/*  98 */     this.g = true;
/*     */   }
/*     */   
/*     */   public PacketPlayOutEntityLook(int paramInt, byte paramByte1, byte paramByte2) {
/* 102 */     super(paramInt);
/* 103 */     this.e = paramByte1;
/* 104 */     this.f = paramByte2;
/* 105 */     this.g = true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/* 110 */     super.a(paramPacketDataSerializer);
/* 111 */     this.e = paramPacketDataSerializer.readByte();
/* 112 */     this.f = paramPacketDataSerializer.readByte();
/*     */   }
/*     */ 
/*     */   
/*     */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/* 117 */     super.b(paramPacketDataSerializer);
/* 118 */     paramPacketDataSerializer.writeByte(this.e);
/* 119 */     paramPacketDataSerializer.writeByte(this.f);
/*     */   }
/*     */ 
/*     */   
/*     */   public String b() {
/* 124 */     return super.b() + String.format(", yRot=%d, xRot=%d", new Object[] { Byte.valueOf(this.e), Byte.valueOf(this.f) });
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutEntityLook.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */