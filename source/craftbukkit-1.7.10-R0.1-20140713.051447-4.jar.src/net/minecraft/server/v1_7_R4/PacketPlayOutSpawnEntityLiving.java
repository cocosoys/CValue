/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.List;
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
/*     */ public class PacketPlayOutSpawnEntityLiving
/*     */   extends Packet
/*     */ {
/*     */   private int a;
/*     */   private int b;
/*     */   private int c;
/*     */   private int d;
/*     */   private int e;
/*     */   private int f;
/*     */   private int g;
/*     */   private int h;
/*     */   private byte i;
/*     */   private byte j;
/*     */   private byte k;
/*     */   private DataWatcher l;
/*     */   private List m;
/*     */   
/*     */   public PacketPlayOutSpawnEntityLiving() {}
/*     */   
/*     */   public PacketPlayOutSpawnEntityLiving(EntityLiving paramEntityLiving) {
/*  35 */     this.a = paramEntityLiving.getId();
/*     */     
/*  37 */     this.b = (byte)EntityTypes.a(paramEntityLiving);
/*  38 */     this.c = paramEntityLiving.as.a(paramEntityLiving.locX);
/*  39 */     this.d = MathHelper.floor(paramEntityLiving.locY * 32.0D);
/*  40 */     this.e = paramEntityLiving.as.a(paramEntityLiving.locZ);
/*  41 */     this.i = (byte)(int)(paramEntityLiving.yaw * 256.0F / 360.0F);
/*  42 */     this.j = (byte)(int)(paramEntityLiving.pitch * 256.0F / 360.0F);
/*  43 */     this.k = (byte)(int)(paramEntityLiving.aO * 256.0F / 360.0F);
/*     */ 
/*     */     
/*  46 */     double d1 = 3.9D;
/*  47 */     double d2 = paramEntityLiving.motX;
/*  48 */     double d3 = paramEntityLiving.motY;
/*  49 */     double d4 = paramEntityLiving.motZ;
/*  50 */     if (d2 < -d1) d2 = -d1; 
/*  51 */     if (d3 < -d1) d3 = -d1; 
/*  52 */     if (d4 < -d1) d4 = -d1; 
/*  53 */     if (d2 > d1) d2 = d1; 
/*  54 */     if (d3 > d1) d3 = d1; 
/*  55 */     if (d4 > d1) d4 = d1; 
/*  56 */     this.f = (int)(d2 * 8000.0D);
/*  57 */     this.g = (int)(d3 * 8000.0D);
/*  58 */     this.h = (int)(d4 * 8000.0D);
/*     */     
/*  60 */     this.l = paramEntityLiving.getDataWatcher();
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/*  65 */     this.a = paramPacketDataSerializer.a();
/*  66 */     this.b = paramPacketDataSerializer.readByte() & 0xFF;
/*  67 */     this.c = paramPacketDataSerializer.readInt();
/*  68 */     this.d = paramPacketDataSerializer.readInt();
/*  69 */     this.e = paramPacketDataSerializer.readInt();
/*  70 */     this.i = paramPacketDataSerializer.readByte();
/*  71 */     this.j = paramPacketDataSerializer.readByte();
/*  72 */     this.k = paramPacketDataSerializer.readByte();
/*  73 */     this.f = paramPacketDataSerializer.readShort();
/*  74 */     this.g = paramPacketDataSerializer.readShort();
/*  75 */     this.h = paramPacketDataSerializer.readShort();
/*  76 */     this.m = DataWatcher.b(paramPacketDataSerializer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/*  81 */     paramPacketDataSerializer.b(this.a);
/*  82 */     paramPacketDataSerializer.writeByte(this.b & 0xFF);
/*  83 */     paramPacketDataSerializer.writeInt(this.c);
/*  84 */     paramPacketDataSerializer.writeInt(this.d);
/*  85 */     paramPacketDataSerializer.writeInt(this.e);
/*  86 */     paramPacketDataSerializer.writeByte(this.i);
/*  87 */     paramPacketDataSerializer.writeByte(this.j);
/*  88 */     paramPacketDataSerializer.writeByte(this.k);
/*  89 */     paramPacketDataSerializer.writeShort(this.f);
/*  90 */     paramPacketDataSerializer.writeShort(this.g);
/*  91 */     paramPacketDataSerializer.writeShort(this.h);
/*  92 */     this.l.a(paramPacketDataSerializer);
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/*  97 */     paramPacketPlayOutListener.a(this);
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
/*     */   public String b() {
/* 109 */     return String.format("id=%d, type=%d, x=%.2f, y=%.2f, z=%.2f, xd=%.2f, yd=%.2f, zd=%.2f", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.b), Float.valueOf(this.c / 32.0F), Float.valueOf(this.d / 32.0F), Float.valueOf(this.e / 32.0F), Float.valueOf(this.f / 8000.0F), Float.valueOf(this.g / 8000.0F), Float.valueOf(this.h / 8000.0F) });
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutSpawnEntityLiving.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */