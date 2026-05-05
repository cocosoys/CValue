/*     */ package net.minecraft.network.play.client;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.network.play.INetHandlerPlayServer;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class C13PacketPlayerAbilities
/*     */   extends Packet
/*     */ {
/*     */   private boolean field_149500_a;
/*     */   private boolean field_149498_b;
/*     */   private boolean field_149499_c;
/*     */   private boolean field_149496_d;
/*     */   private float field_149497_e;
/*     */   private float field_149495_f;
/*     */   private static final String __OBFID = "CL_00001364";
/*     */   
/*     */   public C13PacketPlayerAbilities() {}
/*     */   
/*     */   public C13PacketPlayerAbilities(PlayerCapabilities p_i45257_1_) {
/*  26 */     func_149490_a(p_i45257_1_.field_75102_a);
/*  27 */     func_149483_b(p_i45257_1_.field_75100_b);
/*  28 */     func_149491_c(p_i45257_1_.field_75101_c);
/*  29 */     func_149493_d(p_i45257_1_.field_75098_d);
/*  30 */     func_149485_a(p_i45257_1_.func_75093_a());
/*  31 */     func_149492_b(p_i45257_1_.func_75094_b());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/*  36 */     byte b = p_148837_1_.readByte();
/*     */     
/*  38 */     func_149490_a(((b & 0x1) > 0));
/*  39 */     func_149483_b(((b & 0x2) > 0));
/*  40 */     func_149491_c(((b & 0x4) > 0));
/*  41 */     func_149493_d(((b & 0x8) > 0));
/*  42 */     func_149485_a(p_148837_1_.readFloat());
/*  43 */     func_149492_b(p_148837_1_.readFloat());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/*  48 */     byte b = 0;
/*     */     
/*  50 */     if (func_149494_c()) b = (byte)(b | 0x1); 
/*  51 */     if (func_149488_d()) b = (byte)(b | 0x2); 
/*  52 */     if (func_149486_e()) b = (byte)(b | 0x4); 
/*  53 */     if (func_149484_f()) b = (byte)(b | 0x8);
/*     */     
/*  55 */     p_148840_1_.writeByte(b);
/*  56 */     p_148840_1_.writeFloat(this.field_149497_e);
/*  57 */     p_148840_1_.writeFloat(this.field_149495_f);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
/*  62 */     p_148833_1_.func_147348_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_148835_b() {
/*  67 */     return String.format("invuln=%b, flying=%b, canfly=%b, instabuild=%b, flyspeed=%.4f, walkspped=%.4f", new Object[] { Boolean.valueOf(func_149494_c()), Boolean.valueOf(func_149488_d()), Boolean.valueOf(func_149486_e()), Boolean.valueOf(func_149484_f()), Float.valueOf(func_149482_g()), Float.valueOf(func_149489_h()) });
/*     */   }
/*     */   
/*     */   public boolean func_149494_c() {
/*  71 */     return this.field_149500_a;
/*     */   }
/*     */   
/*     */   public void func_149490_a(boolean p_149490_1_) {
/*  75 */     this.field_149500_a = p_149490_1_;
/*     */   }
/*     */   
/*     */   public boolean func_149488_d() {
/*  79 */     return this.field_149498_b;
/*     */   }
/*     */   
/*     */   public void func_149483_b(boolean p_149483_1_) {
/*  83 */     this.field_149498_b = p_149483_1_;
/*     */   }
/*     */   
/*     */   public boolean func_149486_e() {
/*  87 */     return this.field_149499_c;
/*     */   }
/*     */   
/*     */   public void func_149491_c(boolean p_149491_1_) {
/*  91 */     this.field_149499_c = p_149491_1_;
/*     */   }
/*     */   
/*     */   public boolean func_149484_f() {
/*  95 */     return this.field_149496_d;
/*     */   }
/*     */   
/*     */   public void func_149493_d(boolean p_149493_1_) {
/*  99 */     this.field_149496_d = p_149493_1_;
/*     */   }
/*     */   
/*     */   public float func_149482_g() {
/* 103 */     return this.field_149497_e;
/*     */   }
/*     */   
/*     */   public void func_149485_a(float p_149485_1_) {
/* 107 */     this.field_149497_e = p_149485_1_;
/*     */   }
/*     */   
/*     */   public float func_149489_h() {
/* 111 */     return this.field_149495_f;
/*     */   }
/*     */   
/*     */   public void func_149492_b(float p_149492_1_) {
/* 115 */     this.field_149495_f = p_149492_1_;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\client\C13PacketPlayerAbilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */