/*     */ package net.minecraft.client.entity;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.audio.ISound;
/*     */ import net.minecraft.client.audio.MovingSoundMinecartRiding;
/*     */ import net.minecraft.client.network.NetHandlerPlayClient;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityItem;
/*     */ import net.minecraft.entity.item.EntityMinecart;
/*     */ import net.minecraft.network.Packet;
/*     */ import net.minecraft.network.play.client.C01PacketChatMessage;
/*     */ import net.minecraft.network.play.client.C03PacketPlayer;
/*     */ import net.minecraft.network.play.client.C07PacketPlayerDigging;
/*     */ import net.minecraft.network.play.client.C0APacketAnimation;
/*     */ import net.minecraft.network.play.client.C0BPacketEntityAction;
/*     */ import net.minecraft.network.play.client.C0CPacketInput;
/*     */ import net.minecraft.network.play.client.C0DPacketCloseWindow;
/*     */ import net.minecraft.network.play.client.C16PacketClientStatus;
/*     */ import net.minecraft.stats.StatBase;
/*     */ import net.minecraft.stats.StatFileWriter;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Session;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class EntityClientPlayerMP extends EntityPlayerSP {
/*     */   public final NetHandlerPlayClient field_71174_a;
/*     */   private final StatFileWriter field_146108_bO;
/*     */   private double field_71179_j;
/*     */   private double field_71177_cg;
/*     */   private double field_71178_ch;
/*     */   private double field_71175_ci;
/*     */   private float field_71176_cj;
/*     */   
/*     */   public EntityClientPlayerMP(Minecraft p_i45064_1_, World p_i45064_2_, Session p_i45064_3_, NetHandlerPlayClient p_i45064_4_, StatFileWriter p_i45064_5_) {
/*  36 */     super(p_i45064_1_, p_i45064_2_, p_i45064_3_, 0);
/*  37 */     this.field_71174_a = p_i45064_4_;
/*  38 */     this.field_146108_bO = p_i45064_5_;
/*     */   }
/*     */   private float field_71172_ck; private boolean field_71173_cl; private boolean field_71170_cm; private boolean field_71171_cn; private int field_71168_co; private boolean field_71169_cp; private String field_142022_ce; private static final String __OBFID = "CL_00000887";
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/*  43 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70691_i(float p_70691_1_) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70078_a(Entity p_70078_1_) {
/*  53 */     super.func_70078_a(p_70078_1_);
/*     */     
/*  55 */     if (p_70078_1_ instanceof EntityMinecart) {
/*  56 */       this.field_71159_c.func_147118_V().func_147682_a((ISound)new MovingSoundMinecartRiding(this, (EntityMinecart)p_70078_1_));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  62 */     if (!this.field_70170_p.func_72899_e(MathHelper.func_76128_c(this.field_70165_t), 0, MathHelper.func_76128_c(this.field_70161_v)))
/*  63 */       return;  super.func_70071_h_();
/*     */     
/*  65 */     if (func_70115_ae()) {
/*  66 */       this.field_71174_a.func_147297_a((Packet)new C03PacketPlayer.C05PacketPlayerLook(this.field_70177_z, this.field_70125_A, this.field_70122_E));
/*  67 */       this.field_71174_a.func_147297_a((Packet)new C0CPacketInput(this.field_70702_br, this.field_70701_bs, this.field_71158_b.field_78901_c, this.field_71158_b.field_78899_d));
/*     */     } else {
/*  69 */       func_71166_b();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_71166_b() {
/*  74 */     boolean bool1 = func_70051_ag();
/*  75 */     if (bool1 != this.field_71171_cn) {
/*  76 */       if (bool1) { this.field_71174_a.func_147297_a((Packet)new C0BPacketEntityAction((Entity)this, 4)); }
/*  77 */       else { this.field_71174_a.func_147297_a((Packet)new C0BPacketEntityAction((Entity)this, 5)); }
/*     */       
/*  79 */       this.field_71171_cn = bool1;
/*     */     } 
/*     */     
/*  82 */     boolean bool2 = func_70093_af();
/*  83 */     if (bool2 != this.field_71170_cm) {
/*  84 */       if (bool2) { this.field_71174_a.func_147297_a((Packet)new C0BPacketEntityAction((Entity)this, 1)); }
/*  85 */       else { this.field_71174_a.func_147297_a((Packet)new C0BPacketEntityAction((Entity)this, 2)); }
/*     */       
/*  87 */       this.field_71170_cm = bool2;
/*     */     } 
/*     */     
/*  90 */     double d1 = this.field_70165_t - this.field_71179_j;
/*  91 */     double d2 = this.field_70121_D.field_72338_b - this.field_71177_cg;
/*  92 */     double d3 = this.field_70161_v - this.field_71175_ci;
/*     */     
/*  94 */     double d4 = (this.field_70177_z - this.field_71176_cj);
/*  95 */     double d5 = (this.field_70125_A - this.field_71172_ck);
/*     */     
/*  97 */     boolean bool3 = (d1 * d1 + d2 * d2 + d3 * d3 > 9.0E-4D || this.field_71168_co >= 20) ? true : false;
/*  98 */     boolean bool4 = (d4 != 0.0D || d5 != 0.0D) ? true : false;
/*     */     
/* 100 */     if (this.field_70154_o != null) {
/* 101 */       this.field_71174_a.func_147297_a((Packet)new C03PacketPlayer.C06PacketPlayerPosLook(this.field_70159_w, -999.0D, -999.0D, this.field_70179_y, this.field_70177_z, this.field_70125_A, this.field_70122_E));
/* 102 */       bool3 = false;
/*     */     }
/* 104 */     else if (bool3 && bool4) {
/* 105 */       this.field_71174_a.func_147297_a((Packet)new C03PacketPlayer.C06PacketPlayerPosLook(this.field_70165_t, this.field_70121_D.field_72338_b, this.field_70163_u, this.field_70161_v, this.field_70177_z, this.field_70125_A, this.field_70122_E));
/* 106 */     } else if (bool3) {
/* 107 */       this.field_71174_a.func_147297_a((Packet)new C03PacketPlayer.C04PacketPlayerPosition(this.field_70165_t, this.field_70121_D.field_72338_b, this.field_70163_u, this.field_70161_v, this.field_70122_E));
/* 108 */     } else if (bool4) {
/* 109 */       this.field_71174_a.func_147297_a((Packet)new C03PacketPlayer.C05PacketPlayerLook(this.field_70177_z, this.field_70125_A, this.field_70122_E));
/*     */     } else {
/* 111 */       this.field_71174_a.func_147297_a((Packet)new C03PacketPlayer(this.field_70122_E));
/*     */     } 
/*     */ 
/*     */     
/* 115 */     this.field_71168_co++;
/* 116 */     this.field_71173_cl = this.field_70122_E;
/*     */     
/* 118 */     if (bool3) {
/* 119 */       this.field_71179_j = this.field_70165_t;
/* 120 */       this.field_71177_cg = this.field_70121_D.field_72338_b;
/* 121 */       this.field_71178_ch = this.field_70163_u;
/* 122 */       this.field_71175_ci = this.field_70161_v;
/* 123 */       this.field_71168_co = 0;
/*     */     } 
/* 125 */     if (bool4) {
/* 126 */       this.field_71176_cj = this.field_70177_z;
/* 127 */       this.field_71172_ck = this.field_70125_A;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public EntityItem func_71040_bB(boolean p_71040_1_) {
/* 133 */     byte b = p_71040_1_ ? 3 : 4;
/* 134 */     this.field_71174_a.func_147297_a((Packet)new C07PacketPlayerDigging(b, 0, 0, 0, 0));
/* 135 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71012_a(EntityItem p_71012_1_) {}
/*     */ 
/*     */   
/*     */   public void func_71165_d(String p_71165_1_) {
/* 143 */     this.field_71174_a.func_147297_a((Packet)new C01PacketChatMessage(p_71165_1_));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71038_i() {
/* 148 */     super.func_71038_i();
/* 149 */     this.field_71174_a.func_147297_a((Packet)new C0APacketAnimation((Entity)this, 1));
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71004_bE() {
/* 154 */     this.field_71174_a.func_147297_a((Packet)new C16PacketClientStatus(C16PacketClientStatus.EnumState.PERFORM_RESPAWN));
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70665_d(DamageSource p_70665_1_, float p_70665_2_) {
/* 159 */     if (func_85032_ar())
/* 160 */       return;  func_70606_j(func_110143_aJ() - p_70665_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71053_j() {
/* 165 */     this.field_71174_a.func_147297_a((Packet)new C0DPacketCloseWindow(this.field_71070_bA.field_75152_c));
/* 166 */     func_92015_f();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_92015_f() {
/* 171 */     this.field_71071_by.func_70437_b(null);
/* 172 */     super.func_71053_j();
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71150_b(float p_71150_1_) {
/* 177 */     if (this.field_71169_cp) {
/* 178 */       super.func_71150_b(p_71150_1_);
/*     */     } else {
/* 180 */       func_70606_j(p_71150_1_);
/* 181 */       this.field_71169_cp = true;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_71064_a(StatBase p_71064_1_, int p_71064_2_) {
/* 187 */     if (p_71064_1_ == null) {
/*     */       return;
/*     */     }
/*     */     
/* 191 */     if (p_71064_1_.field_75972_f) super.func_71064_a(p_71064_1_, p_71064_2_);
/*     */   
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
/*     */   public void func_71016_p() {
/* 204 */     this.field_71174_a.func_147297_a((Packet)new C13PacketPlayerAbilities(this.field_71075_bZ));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_110318_g() {
/* 214 */     this.field_71174_a.func_147297_a((Packet)new C0BPacketEntityAction((Entity)this, 6, (int)(func_110319_bJ() * 100.0F)));
/*     */   }
/*     */   
/*     */   public void func_110322_i() {
/* 218 */     this.field_71174_a.func_147297_a((Packet)new C0BPacketEntityAction((Entity)this, 7));
/*     */   }
/*     */   
/*     */   public void func_142020_c(String p_142020_1_) {
/* 222 */     this.field_142022_ce = p_142020_1_;
/*     */   }
/*     */   
/*     */   public String func_142021_k() {
/* 226 */     return this.field_142022_ce;
/*     */   }
/*     */   
/*     */   public StatFileWriter func_146107_m() {
/* 230 */     return this.field_146108_bO;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\entity\EntityClientPlayerMP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */