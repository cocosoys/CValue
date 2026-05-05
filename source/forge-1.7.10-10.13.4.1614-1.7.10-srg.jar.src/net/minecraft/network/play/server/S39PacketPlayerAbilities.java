/*     */ package net.minecraft.network.play.server;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import net.minecraft.entity.player.PlayerCapabilities;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.network.play.INetHandlerPlayClient;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class S39PacketPlayerAbilities
/*     */   extends Packet
/*     */ {
/*     */   private boolean field_149119_a;
/*     */   private boolean field_149117_b;
/*     */   private boolean field_149118_c;
/*     */   private boolean field_149115_d;
/*     */   private float field_149116_e;
/*     */   private float field_149114_f;
/*     */   private static final String __OBFID = "CL_00001317";
/*     */   
/*     */   public S39PacketPlayerAbilities() {}
/*     */   
/*     */   public S39PacketPlayerAbilities(PlayerCapabilities p_i45208_1_) {
/*  28 */     func_149108_a(p_i45208_1_.field_75102_a);
/*  29 */     func_149102_b(p_i45208_1_.field_75100_b);
/*  30 */     func_149109_c(p_i45208_1_.field_75101_c);
/*  31 */     func_149111_d(p_i45208_1_.field_75098_d);
/*  32 */     func_149104_a(p_i45208_1_.func_75093_a());
/*  33 */     func_149110_b(p_i45208_1_.func_75094_b());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/*  38 */     byte b = p_148837_1_.readByte();
/*     */     
/*  40 */     func_149108_a(((b & 0x1) > 0));
/*  41 */     func_149102_b(((b & 0x2) > 0));
/*  42 */     func_149109_c(((b & 0x4) > 0));
/*  43 */     func_149111_d(((b & 0x8) > 0));
/*  44 */     func_149104_a(p_148837_1_.readFloat());
/*  45 */     func_149110_b(p_148837_1_.readFloat());
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/*  50 */     byte b = 0;
/*     */     
/*  52 */     if (func_149112_c()) b = (byte)(b | 0x1); 
/*  53 */     if (func_149106_d()) b = (byte)(b | 0x2); 
/*  54 */     if (func_149105_e()) b = (byte)(b | 0x4); 
/*  55 */     if (func_149103_f()) b = (byte)(b | 0x8);
/*     */     
/*  57 */     p_148840_1_.writeByte(b);
/*  58 */     p_148840_1_.writeFloat(this.field_149116_e);
/*  59 */     p_148840_1_.writeFloat(this.field_149114_f);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/*  64 */     p_148833_1_.func_147270_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public String func_148835_b() {
/*  69 */     return String.format("invuln=%b, flying=%b, canfly=%b, instabuild=%b, flyspeed=%.4f, walkspped=%.4f", new Object[] { Boolean.valueOf(func_149112_c()), Boolean.valueOf(func_149106_d()), Boolean.valueOf(func_149105_e()), Boolean.valueOf(func_149103_f()), Float.valueOf(func_149101_g()), Float.valueOf(func_149107_h()) });
/*     */   }
/*     */   
/*     */   public boolean func_149112_c() {
/*  73 */     return this.field_149119_a;
/*     */   }
/*     */   
/*     */   public void func_149108_a(boolean p_149108_1_) {
/*  77 */     this.field_149119_a = p_149108_1_;
/*     */   }
/*     */   
/*     */   public boolean func_149106_d() {
/*  81 */     return this.field_149117_b;
/*     */   }
/*     */   
/*     */   public void func_149102_b(boolean p_149102_1_) {
/*  85 */     this.field_149117_b = p_149102_1_;
/*     */   }
/*     */   
/*     */   public boolean func_149105_e() {
/*  89 */     return this.field_149118_c;
/*     */   }
/*     */   
/*     */   public void func_149109_c(boolean p_149109_1_) {
/*  93 */     this.field_149118_c = p_149109_1_;
/*     */   }
/*     */   
/*     */   public boolean func_149103_f() {
/*  97 */     return this.field_149115_d;
/*     */   }
/*     */   
/*     */   public void func_149111_d(boolean p_149111_1_) {
/* 101 */     this.field_149115_d = p_149111_1_;
/*     */   }
/*     */   
/*     */   public float func_149101_g() {
/* 105 */     return this.field_149116_e;
/*     */   }
/*     */   
/*     */   public void func_149104_a(float p_149104_1_) {
/* 109 */     this.field_149116_e = p_149104_1_;
/*     */   }
/*     */   
/*     */   public float func_149107_h() {
/* 113 */     return this.field_149114_f;
/*     */   }
/*     */   
/*     */   public void func_149110_b(float p_149110_1_) {
/* 117 */     this.field_149114_f = p_149110_1_;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S39PacketPlayerAbilities.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */