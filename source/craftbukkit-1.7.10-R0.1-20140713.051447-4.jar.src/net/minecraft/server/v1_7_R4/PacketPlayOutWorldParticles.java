/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class PacketPlayOutWorldParticles
/*     */   extends Packet
/*     */ {
/*     */   private String a;
/*     */   private float b;
/*     */   private float c;
/*     */   private float d;
/*     */   private float e;
/*     */   private float f;
/*     */   private float g;
/*     */   private float h;
/*     */   private int i;
/*     */   
/*     */   public PacketPlayOutWorldParticles() {}
/*     */   
/*     */   public PacketPlayOutWorldParticles(String paramString, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6, float paramFloat7, int paramInt) {
/*  25 */     this.a = paramString;
/*  26 */     this.b = paramFloat1;
/*  27 */     this.c = paramFloat2;
/*  28 */     this.d = paramFloat3;
/*  29 */     this.e = paramFloat4;
/*  30 */     this.f = paramFloat5;
/*  31 */     this.g = paramFloat6;
/*  32 */     this.h = paramFloat7;
/*  33 */     this.i = paramInt;
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/*  38 */     this.a = paramPacketDataSerializer.c(64);
/*  39 */     this.b = paramPacketDataSerializer.readFloat();
/*  40 */     this.c = paramPacketDataSerializer.readFloat();
/*  41 */     this.d = paramPacketDataSerializer.readFloat();
/*  42 */     this.e = paramPacketDataSerializer.readFloat();
/*  43 */     this.f = paramPacketDataSerializer.readFloat();
/*  44 */     this.g = paramPacketDataSerializer.readFloat();
/*  45 */     this.h = paramPacketDataSerializer.readFloat();
/*  46 */     this.i = paramPacketDataSerializer.readInt();
/*     */   }
/*     */ 
/*     */   
/*     */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/*  51 */     paramPacketDataSerializer.a(this.a);
/*  52 */     paramPacketDataSerializer.writeFloat(this.b);
/*  53 */     paramPacketDataSerializer.writeFloat(this.c);
/*  54 */     paramPacketDataSerializer.writeFloat(this.d);
/*  55 */     paramPacketDataSerializer.writeFloat(this.e);
/*  56 */     paramPacketDataSerializer.writeFloat(this.f);
/*  57 */     paramPacketDataSerializer.writeFloat(this.g);
/*  58 */     paramPacketDataSerializer.writeFloat(this.h);
/*  59 */     paramPacketDataSerializer.writeInt(this.i);
/*     */   }
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
/*     */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 101 */     paramPacketPlayOutListener.a(this);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutWorldParticles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */