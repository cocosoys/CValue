/*     */ package net.minecraft.network.play.server;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.network.play.INetHandlerPlayClient;
/*     */ import net.minecraft.util.MathHelper;
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
/*     */ public class S0EPacketSpawnObject
/*     */   extends Packet
/*     */ {
/*     */   private int field_149018_a;
/*     */   private int field_149016_b;
/*     */   private int field_149017_c;
/*     */   private int field_149014_d;
/*     */   private int field_149015_e;
/*     */   private int field_149012_f;
/*     */   private int field_149013_g;
/*     */   private int field_149021_h;
/*     */   private int field_149022_i;
/*     */   private int field_149019_j;
/*     */   private int field_149020_k;
/*     */   private static final String __OBFID = "CL_00001276";
/*     */   
/*     */   public S0EPacketSpawnObject() {}
/*     */   
/*     */   public S0EPacketSpawnObject(Entity p_i45165_1_, int p_i45165_2_) {
/*  50 */     this(p_i45165_1_, p_i45165_2_, 0);
/*     */   }
/*     */   
/*     */   public S0EPacketSpawnObject(Entity p_i45166_1_, int p_i45166_2_, int p_i45166_3_) {
/*  54 */     this.field_149018_a = p_i45166_1_.func_145782_y();
/*  55 */     this.field_149016_b = MathHelper.func_76128_c(p_i45166_1_.field_70165_t * 32.0D);
/*  56 */     this.field_149017_c = MathHelper.func_76128_c(p_i45166_1_.field_70163_u * 32.0D);
/*  57 */     this.field_149014_d = MathHelper.func_76128_c(p_i45166_1_.field_70161_v * 32.0D);
/*  58 */     this.field_149021_h = MathHelper.func_76141_d(p_i45166_1_.field_70125_A * 256.0F / 360.0F);
/*  59 */     this.field_149022_i = MathHelper.func_76141_d(p_i45166_1_.field_70177_z * 256.0F / 360.0F);
/*  60 */     this.field_149019_j = p_i45166_2_;
/*  61 */     this.field_149020_k = p_i45166_3_;
/*  62 */     if (p_i45166_3_ > 0) {
/*  63 */       double d1 = p_i45166_1_.field_70159_w;
/*  64 */       double d2 = p_i45166_1_.field_70181_x;
/*  65 */       double d3 = p_i45166_1_.field_70179_y;
/*  66 */       double d4 = 3.9D;
/*  67 */       if (d1 < -d4) d1 = -d4; 
/*  68 */       if (d2 < -d4) d2 = -d4; 
/*  69 */       if (d3 < -d4) d3 = -d4; 
/*  70 */       if (d1 > d4) d1 = d4; 
/*  71 */       if (d2 > d4) d2 = d4; 
/*  72 */       if (d3 > d4) d3 = d4; 
/*  73 */       this.field_149015_e = (int)(d1 * 8000.0D);
/*  74 */       this.field_149012_f = (int)(d2 * 8000.0D);
/*  75 */       this.field_149013_g = (int)(d3 * 8000.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/*  81 */     this.field_149018_a = p_148837_1_.func_150792_a();
/*  82 */     this.field_149019_j = p_148837_1_.readByte();
/*  83 */     this.field_149016_b = p_148837_1_.readInt();
/*  84 */     this.field_149017_c = p_148837_1_.readInt();
/*  85 */     this.field_149014_d = p_148837_1_.readInt();
/*  86 */     this.field_149021_h = p_148837_1_.readByte();
/*  87 */     this.field_149022_i = p_148837_1_.readByte();
/*  88 */     this.field_149020_k = p_148837_1_.readInt();
/*  89 */     if (this.field_149020_k > 0) {
/*  90 */       this.field_149015_e = p_148837_1_.readShort();
/*  91 */       this.field_149012_f = p_148837_1_.readShort();
/*  92 */       this.field_149013_g = p_148837_1_.readShort();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/*  98 */     p_148840_1_.func_150787_b(this.field_149018_a);
/*  99 */     p_148840_1_.writeByte(this.field_149019_j);
/* 100 */     p_148840_1_.writeInt(this.field_149016_b);
/* 101 */     p_148840_1_.writeInt(this.field_149017_c);
/* 102 */     p_148840_1_.writeInt(this.field_149014_d);
/* 103 */     p_148840_1_.writeByte(this.field_149021_h);
/* 104 */     p_148840_1_.writeByte(this.field_149022_i);
/* 105 */     p_148840_1_.writeInt(this.field_149020_k);
/* 106 */     if (this.field_149020_k > 0) {
/* 107 */       p_148840_1_.writeShort(this.field_149015_e);
/* 108 */       p_148840_1_.writeShort(this.field_149012_f);
/* 109 */       p_148840_1_.writeShort(this.field_149013_g);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 115 */     p_148833_1_.func_147235_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_148835_b() {
/* 120 */     return String.format("id=%d, type=%d, x=%.2f, y=%.2f, z=%.2f", new Object[] { Integer.valueOf(this.field_149018_a), Integer.valueOf(this.field_149019_j), Float.valueOf(this.field_149016_b / 32.0F), Float.valueOf(this.field_149017_c / 32.0F), Float.valueOf(this.field_149014_d / 32.0F) });
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149001_c() {
/* 124 */     return this.field_149018_a;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_148997_d() {
/* 128 */     return this.field_149016_b;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_148998_e() {
/* 132 */     return this.field_149017_c;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_148994_f() {
/* 136 */     return this.field_149014_d;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149010_g() {
/* 140 */     return this.field_149015_e;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149004_h() {
/* 144 */     return this.field_149012_f;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_148999_i() {
/* 148 */     return this.field_149013_g;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149008_j() {
/* 152 */     return this.field_149021_h;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149006_k() {
/* 156 */     return this.field_149022_i;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_148993_l() {
/* 160 */     return this.field_149019_j;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149009_m() {
/* 164 */     return this.field_149020_k;
/*     */   }
/*     */   
/*     */   public void func_148996_a(int p_148996_1_) {
/* 168 */     this.field_149016_b = p_148996_1_;
/*     */   }
/*     */   
/*     */   public void func_148995_b(int p_148995_1_) {
/* 172 */     this.field_149017_c = p_148995_1_;
/*     */   }
/*     */   
/*     */   public void func_149005_c(int p_149005_1_) {
/* 176 */     this.field_149014_d = p_149005_1_;
/*     */   }
/*     */   
/*     */   public void func_149003_d(int p_149003_1_) {
/* 180 */     this.field_149015_e = p_149003_1_;
/*     */   }
/*     */   
/*     */   public void func_149000_e(int p_149000_1_) {
/* 184 */     this.field_149012_f = p_149000_1_;
/*     */   }
/*     */   
/*     */   public void func_149007_f(int p_149007_1_) {
/* 188 */     this.field_149013_g = p_149007_1_;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_149002_g(int p_149002_1_) {
/* 192 */     this.field_149020_k = p_149002_1_;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S0EPacketSpawnObject.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */