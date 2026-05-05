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
/*     */ public class PacketPlayOutSpawnEntity
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
/*     */   private int i;
/*     */   private int j;
/*     */   private int k;
/*     */   
/*     */   public PacketPlayOutSpawnEntity() {}
/*     */   
/*     */   public PacketPlayOutSpawnEntity(Entity paramEntity, int paramInt) {
/*  50 */     this(paramEntity, paramInt, 0);
/*     */   }
/*     */   
/*     */   public PacketPlayOutSpawnEntity(Entity paramEntity, int paramInt1, int paramInt2) {
/*  54 */     this.a = paramEntity.getId();
/*  55 */     this.b = MathHelper.floor(paramEntity.locX * 32.0D);
/*  56 */     this.c = MathHelper.floor(paramEntity.locY * 32.0D);
/*  57 */     this.d = MathHelper.floor(paramEntity.locZ * 32.0D);
/*  58 */     this.h = MathHelper.d(paramEntity.pitch * 256.0F / 360.0F);
/*  59 */     this.i = MathHelper.d(paramEntity.yaw * 256.0F / 360.0F);
/*  60 */     this.j = paramInt1;
/*  61 */     this.k = paramInt2;
/*  62 */     if (paramInt2 > 0) {
/*  63 */       double d1 = paramEntity.motX;
/*  64 */       double d2 = paramEntity.motY;
/*  65 */       double d3 = paramEntity.motZ;
/*  66 */       double d4 = 3.9D;
/*  67 */       if (d1 < -d4) d1 = -d4; 
/*  68 */       if (d2 < -d4) d2 = -d4; 
/*  69 */       if (d3 < -d4) d3 = -d4; 
/*  70 */       if (d1 > d4) d1 = d4; 
/*  71 */       if (d2 > d4) d2 = d4; 
/*  72 */       if (d3 > d4) d3 = d4; 
/*  73 */       this.e = (int)(d1 * 8000.0D);
/*  74 */       this.f = (int)(d2 * 8000.0D);
/*  75 */       this.g = (int)(d3 * 8000.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(PacketDataSerializer paramPacketDataSerializer) {
/*  81 */     this.a = paramPacketDataSerializer.a();
/*  82 */     this.j = paramPacketDataSerializer.readByte();
/*  83 */     this.b = paramPacketDataSerializer.readInt();
/*  84 */     this.c = paramPacketDataSerializer.readInt();
/*  85 */     this.d = paramPacketDataSerializer.readInt();
/*  86 */     this.h = paramPacketDataSerializer.readByte();
/*  87 */     this.i = paramPacketDataSerializer.readByte();
/*  88 */     this.k = paramPacketDataSerializer.readInt();
/*  89 */     if (this.k > 0) {
/*  90 */       this.e = paramPacketDataSerializer.readShort();
/*  91 */       this.f = paramPacketDataSerializer.readShort();
/*  92 */       this.g = paramPacketDataSerializer.readShort();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void b(PacketDataSerializer paramPacketDataSerializer) {
/*  98 */     paramPacketDataSerializer.b(this.a);
/*  99 */     paramPacketDataSerializer.writeByte(this.j);
/* 100 */     paramPacketDataSerializer.writeInt(this.b);
/* 101 */     paramPacketDataSerializer.writeInt(this.c);
/* 102 */     paramPacketDataSerializer.writeInt(this.d);
/* 103 */     paramPacketDataSerializer.writeByte(this.h);
/* 104 */     paramPacketDataSerializer.writeByte(this.i);
/* 105 */     paramPacketDataSerializer.writeInt(this.k);
/* 106 */     if (this.k > 0) {
/* 107 */       paramPacketDataSerializer.writeShort(this.e);
/* 108 */       paramPacketDataSerializer.writeShort(this.f);
/* 109 */       paramPacketDataSerializer.writeShort(this.g);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void a(PacketPlayOutListener paramPacketPlayOutListener) {
/* 115 */     paramPacketPlayOutListener.a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public String b() {
/* 120 */     return String.format("id=%d, type=%d, x=%.2f, y=%.2f, z=%.2f", new Object[] { Integer.valueOf(this.a), Integer.valueOf(this.j), Float.valueOf(this.b / 32.0F), Float.valueOf(this.c / 32.0F), Float.valueOf(this.d / 32.0F) });
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(int paramInt) {
/* 168 */     this.b = paramInt;
/*     */   }
/*     */   
/*     */   public void b(int paramInt) {
/* 172 */     this.c = paramInt;
/*     */   }
/*     */   
/*     */   public void c(int paramInt) {
/* 176 */     this.d = paramInt;
/*     */   }
/*     */   
/*     */   public void d(int paramInt) {
/* 180 */     this.e = paramInt;
/*     */   }
/*     */   
/*     */   public void e(int paramInt) {
/* 184 */     this.f = paramInt;
/*     */   }
/*     */   
/*     */   public void f(int paramInt) {
/* 188 */     this.g = paramInt;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\PacketPlayOutSpawnEntity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */