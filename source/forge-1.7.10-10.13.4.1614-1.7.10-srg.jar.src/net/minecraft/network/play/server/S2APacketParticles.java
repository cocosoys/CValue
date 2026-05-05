/*     */ package net.minecraft.network.play.server;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.network.play.INetHandlerPlayClient;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class S2APacketParticles
/*     */   extends Packet
/*     */ {
/*     */   private String field_149236_a;
/*     */   private float field_149234_b;
/*     */   private float field_149235_c;
/*     */   private float field_149232_d;
/*     */   private float field_149233_e;
/*     */   
/*     */   public S2APacketParticles(String p_i45199_1_, float p_i45199_2_, float p_i45199_3_, float p_i45199_4_, float p_i45199_5_, float p_i45199_6_, float p_i45199_7_, float p_i45199_8_, int p_i45199_9_) {
/*  25 */     this.field_149236_a = p_i45199_1_;
/*  26 */     this.field_149234_b = p_i45199_2_;
/*  27 */     this.field_149235_c = p_i45199_3_;
/*  28 */     this.field_149232_d = p_i45199_4_;
/*  29 */     this.field_149233_e = p_i45199_5_;
/*  30 */     this.field_149230_f = p_i45199_6_;
/*  31 */     this.field_149231_g = p_i45199_7_;
/*  32 */     this.field_149237_h = p_i45199_8_;
/*  33 */     this.field_149238_i = p_i45199_9_;
/*     */   }
/*     */   private float field_149230_f; private float field_149231_g; private float field_149237_h; private int field_149238_i; private static final String __OBFID = "CL_00001308";
/*     */   public S2APacketParticles() {}
/*     */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/*  38 */     this.field_149236_a = p_148837_1_.func_150789_c(64);
/*  39 */     this.field_149234_b = p_148837_1_.readFloat();
/*  40 */     this.field_149235_c = p_148837_1_.readFloat();
/*  41 */     this.field_149232_d = p_148837_1_.readFloat();
/*  42 */     this.field_149233_e = p_148837_1_.readFloat();
/*  43 */     this.field_149230_f = p_148837_1_.readFloat();
/*  44 */     this.field_149231_g = p_148837_1_.readFloat();
/*  45 */     this.field_149237_h = p_148837_1_.readFloat();
/*  46 */     this.field_149238_i = p_148837_1_.readInt();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/*  51 */     p_148840_1_.func_150785_a(this.field_149236_a);
/*  52 */     p_148840_1_.writeFloat(this.field_149234_b);
/*  53 */     p_148840_1_.writeFloat(this.field_149235_c);
/*  54 */     p_148840_1_.writeFloat(this.field_149232_d);
/*  55 */     p_148840_1_.writeFloat(this.field_149233_e);
/*  56 */     p_148840_1_.writeFloat(this.field_149230_f);
/*  57 */     p_148840_1_.writeFloat(this.field_149231_g);
/*  58 */     p_148840_1_.writeFloat(this.field_149237_h);
/*  59 */     p_148840_1_.writeInt(this.field_149238_i);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public String func_149228_c() {
/*  63 */     return this.field_149236_a;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public double func_149220_d() {
/*  68 */     return this.field_149234_b;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public double func_149226_e() {
/*  72 */     return this.field_149235_c;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public double func_149225_f() {
/*  76 */     return this.field_149232_d;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_149221_g() {
/*  80 */     return this.field_149233_e;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_149224_h() {
/*  84 */     return this.field_149230_f;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_149223_i() {
/*  88 */     return this.field_149231_g;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_149227_j() {
/*  92 */     return this.field_149237_h;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_149222_k() {
/*  96 */     return this.field_149238_i;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148833_a(INetHandlerPlayClient p_148833_1_) {
/* 101 */     p_148833_1_.func_147289_a(this);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\server\S2APacketParticles.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */