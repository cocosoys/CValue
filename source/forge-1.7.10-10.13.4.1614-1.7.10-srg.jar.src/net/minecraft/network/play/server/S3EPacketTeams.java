/*     */ package net.minecraft.network.play.server;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.network.play.INetHandlerPlayClient;
/*     */ import net.minecraft.scoreboard.ScorePlayerTeam;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class S3EPacketTeams
/*     */   extends Packet
/*     */ {
/*  21 */   private String field_149320_a = "";
/*  22 */   private String field_149318_b = "";
/*  23 */   private String field_149319_c = "";
/*  24 */   private String field_149316_d = "";
/*  25 */   private Collection field_149317_e = new ArrayList();
/*     */   
/*     */   private int field_149314_f;
/*     */   
/*     */   private int field_149315_g;
/*     */   private static final String __OBFID = "CL_00001334";
/*     */   
/*     */   public S3EPacketTeams(ScorePlayerTeam p_i45225_1_, int p_i45225_2_) {
/*  33 */     this.field_149320_a = p_i45225_1_.func_96661_b();
/*  34 */     this.field_149314_f = p_i45225_2_;
/*     */     
/*  36 */     if (p_i45225_2_ == 0 || p_i45225_2_ == 2) {
/*  37 */       this.field_149318_b = p_i45225_1_.func_96669_c();
/*  38 */       this.field_149319_c = p_i45225_1_.func_96668_e();
/*  39 */       this.field_149316_d = p_i45225_1_.func_96663_f();
/*  40 */       this.field_149315_g = p_i45225_1_.func_98299_i();
/*     */     } 
/*  42 */     if (p_i45225_2_ == 0) {
/*  43 */       this.field_149317_e.addAll(p_i45225_1_.func_96670_d());
/*     */     }
/*     */   }
/*     */   
/*     */   public S3EPacketTeams(ScorePlayerTeam p_i45226_1_, Collection p_i45226_2_, int p_i45226_3_) {
/*  48 */     if (p_i45226_3_ != 3 && p_i45226_3_ != 4) throw new IllegalArgumentException("Method must be join or leave for player constructor"); 
/*  49 */     if (p_i45226_2_ == null || p_i45226_2_.isEmpty()) throw new IllegalArgumentException("Players cannot be null/empty");
/*     */     
/*  51 */     this.field_149314_f = p_i45226_3_;
/*  52 */     this.field_149320_a = p_i45226_1_.func_96661_b();
/*  53 */     this.field_149317_e.addAll(p_i45226_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/*  58 */     this.field_149320_a = p_148837_1_.func_150789_c(16);
/*  59 */     this.field_149314_f = p_148837_1_.readByte();
/*     */     
/*  61 */     if (this.field_149314_f == 0 || this.field_149314_f == 2) {
/*  62 */       this.field_149318_b = p_148837_1_.func_150789_c(32);
/*  63 */       this.field_149319_c = p_148837_1_.func_150789_c(16);
/*  64 */       this.field_149316_d = p_148837_1_.func_150789_c(16);
/*  65 */       this.field_149315_g = p_148837_1_.readByte();
/*     */     } 
/*     */     
/*  68 */     if (this.field_149314_f == 0 || this.field_149314_f == 3 || this.field_149314_f == 4) {
/*  69 */       short s = p_148837_1_.readShort();
/*     */       
/*  71 */       for (byte b = 0; b < s; b++) {
/*  72 */         this.field_149317_e.add(p_148837_1_.func_150789_c(40));
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/*  79 */     p_148840_1_.func_150785_a(this.field_149320_a);
/*  80 */     p_148840_1_.writeByte(this.field_149314_f);
/*     */     
/*  82 */     if (this.field_149314_f == 0 || this.field_149314_f == 2) {
/*  83 */       p_148840_1_.func_150785_a(this.field_149318_b);
/*  84 */       p_148840_1_.func_150785_a(this.field_149319_c);
/*  85 */       p_148840_1_.func_150785_a(this.field_149316_d);
/*  86 */       p_148840_1_.writeByte(this.field_149315_g);
/*     */     } 
/*     */     
/*  89 */     if (this.field_149314_f == 0 || this.field_149314_f == 3 || this.field_149314_f == 4) {
/*  90 */       p_148840_1_.writeShort(this.field_149317_e.size());
/*     */       
/*  92 */       for (String str : this.field_149317_e) {
/*  93 */         p_148840_1_.func_150785_a(str);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 100 */     p_148833_1_.func_147247_a(this);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String func_149312_c() {
/* 104 */     return this.field_149320_a;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String func_149306_d() {
/* 108 */     return this.field_149318_b;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String func_149311_e() {
/* 112 */     return this.field_149319_c;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String func_149309_f() {
/* 116 */     return this.field_149316_d;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Collection func_149310_g() {
/* 120 */     return this.field_149317_e;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149307_h() {
/* 124 */     return this.field_149314_f;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149308_i() {
/* 128 */     return this.field_149315_g;
/*     */   }
/*     */   
/*     */   public S3EPacketTeams() {}
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S3EPacketTeams.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */