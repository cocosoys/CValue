/*     */ package net.minecraft.network.play.server;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import java.util.List;
/*     */ import net.minecraft.entity.DataWatcher;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityList;
/*     */ import net.minecraft.entity.EntityLivingBase;
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
/*     */ public class S0FPacketSpawnMob
/*     */   extends Packet
/*     */ {
/*     */   private int field_149042_a;
/*     */   private int field_149040_b;
/*     */   private int field_149041_c;
/*     */   private int field_149038_d;
/*     */   private int field_149039_e;
/*     */   private int field_149036_f;
/*     */   private int field_149037_g;
/*     */   
/*     */   public S0FPacketSpawnMob(EntityLivingBase p_i45192_1_) {
/*  35 */     this.field_149042_a = p_i45192_1_.func_145782_y();
/*     */     
/*  37 */     this.field_149040_b = (byte)EntityList.func_75619_a((Entity)p_i45192_1_);
/*  38 */     this.field_149041_c = p_i45192_1_.field_70168_am.func_75630_a(p_i45192_1_.field_70165_t);
/*  39 */     this.field_149038_d = MathHelper.func_76128_c(p_i45192_1_.field_70163_u * 32.0D);
/*  40 */     this.field_149039_e = p_i45192_1_.field_70168_am.func_75630_a(p_i45192_1_.field_70161_v);
/*  41 */     this.field_149048_i = (byte)(int)(p_i45192_1_.field_70177_z * 256.0F / 360.0F);
/*  42 */     this.field_149045_j = (byte)(int)(p_i45192_1_.field_70125_A * 256.0F / 360.0F);
/*  43 */     this.field_149046_k = (byte)(int)(p_i45192_1_.field_70759_as * 256.0F / 360.0F);
/*     */ 
/*     */     
/*  46 */     double d1 = 3.9D;
/*  47 */     double d2 = p_i45192_1_.field_70159_w;
/*  48 */     double d3 = p_i45192_1_.field_70181_x;
/*  49 */     double d4 = p_i45192_1_.field_70179_y;
/*  50 */     if (d2 < -d1) d2 = -d1; 
/*  51 */     if (d3 < -d1) d3 = -d1; 
/*  52 */     if (d4 < -d1) d4 = -d1; 
/*  53 */     if (d2 > d1) d2 = d1; 
/*  54 */     if (d3 > d1) d3 = d1; 
/*  55 */     if (d4 > d1) d4 = d1; 
/*  56 */     this.field_149036_f = (int)(d2 * 8000.0D);
/*  57 */     this.field_149037_g = (int)(d3 * 8000.0D);
/*  58 */     this.field_149047_h = (int)(d4 * 8000.0D);
/*     */     
/*  60 */     this.field_149043_l = p_i45192_1_.func_70096_w();
/*     */   }
/*     */   private int field_149047_h; private byte field_149048_i; private byte field_149045_j; private byte field_149046_k; private DataWatcher field_149043_l; private List field_149044_m; private static final String __OBFID = "CL_00001279";
/*     */   public S0FPacketSpawnMob() {}
/*     */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/*  65 */     this.field_149042_a = p_148837_1_.func_150792_a();
/*  66 */     this.field_149040_b = p_148837_1_.readByte() & 0xFF;
/*  67 */     this.field_149041_c = p_148837_1_.readInt();
/*  68 */     this.field_149038_d = p_148837_1_.readInt();
/*  69 */     this.field_149039_e = p_148837_1_.readInt();
/*  70 */     this.field_149048_i = p_148837_1_.readByte();
/*  71 */     this.field_149045_j = p_148837_1_.readByte();
/*  72 */     this.field_149046_k = p_148837_1_.readByte();
/*  73 */     this.field_149036_f = p_148837_1_.readShort();
/*  74 */     this.field_149037_g = p_148837_1_.readShort();
/*  75 */     this.field_149047_h = p_148837_1_.readShort();
/*  76 */     this.field_149044_m = DataWatcher.func_151508_b(p_148837_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/*  81 */     p_148840_1_.func_150787_b(this.field_149042_a);
/*  82 */     p_148840_1_.writeByte(this.field_149040_b & 0xFF);
/*  83 */     p_148840_1_.writeInt(this.field_149041_c);
/*  84 */     p_148840_1_.writeInt(this.field_149038_d);
/*  85 */     p_148840_1_.writeInt(this.field_149039_e);
/*  86 */     p_148840_1_.writeByte(this.field_149048_i);
/*  87 */     p_148840_1_.writeByte(this.field_149045_j);
/*  88 */     p_148840_1_.writeByte(this.field_149046_k);
/*  89 */     p_148840_1_.writeShort(this.field_149036_f);
/*  90 */     p_148840_1_.writeShort(this.field_149037_g);
/*  91 */     p_148840_1_.writeShort(this.field_149047_h);
/*  92 */     this.field_149043_l.func_151509_a(p_148840_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/*  97 */     p_148833_1_.func_147281_a(this);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public List func_149027_c() {
/* 101 */     if (this.field_149044_m == null) {
/* 102 */       this.field_149044_m = this.field_149043_l.func_75685_c();
/*     */     }
/* 104 */     return this.field_149044_m;
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_148835_b() {
/* 109 */     return String.format("id=%d, type=%d, x=%.2f, y=%.2f, z=%.2f, xd=%.2f, yd=%.2f, zd=%.2f", new Object[] { Integer.valueOf(this.field_149042_a), Integer.valueOf(this.field_149040_b), Float.valueOf(this.field_149041_c / 32.0F), Float.valueOf(this.field_149038_d / 32.0F), Float.valueOf(this.field_149039_e / 32.0F), Float.valueOf(this.field_149036_f / 8000.0F), Float.valueOf(this.field_149037_g / 8000.0F), Float.valueOf(this.field_149047_h / 8000.0F) });
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149024_d() {
/* 113 */     return this.field_149042_a;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149025_e() {
/* 117 */     return this.field_149040_b;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149023_f() {
/* 121 */     return this.field_149041_c;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149034_g() {
/* 125 */     return this.field_149038_d;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149029_h() {
/* 129 */     return this.field_149039_e;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149026_i() {
/* 133 */     return this.field_149036_f;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149033_j() {
/* 137 */     return this.field_149037_g;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149031_k() {
/* 141 */     return this.field_149047_h;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public byte func_149028_l() {
/* 145 */     return this.field_149048_i;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public byte func_149030_m() {
/* 149 */     return this.field_149045_j;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public byte func_149032_n() {
/* 153 */     return this.field_149046_k;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S0FPacketSpawnMob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */