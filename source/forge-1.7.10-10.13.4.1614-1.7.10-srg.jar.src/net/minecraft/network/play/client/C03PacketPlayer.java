/*     */ package net.minecraft.network.play.client;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.io.IOException;
/*     */ import net.minecraft.network.INetHandler;
/*     */ import net.minecraft.network.PacketBuffer;
/*     */ import net.minecraft.network.play.INetHandlerPlayServer;
/*     */ 
/*     */ public class C03PacketPlayer extends Packet {
/*     */   protected double field_149479_a;
/*     */   protected double field_149477_b;
/*     */   protected double field_149478_c;
/*     */   protected double field_149475_d;
/*     */   protected float field_149476_e;
/*     */   protected float field_149473_f;
/*     */   protected boolean field_149474_g;
/*     */   protected boolean field_149480_h;
/*     */   protected boolean field_149481_i;
/*     */   private static final String __OBFID = "CL_00001360";
/*     */   
/*     */   public static class C06PacketPlayerPosLook extends C03PacketPlayer {
/*     */     public C06PacketPlayerPosLook() {
/*  23 */       this.field_149480_h = true;
/*  24 */       this.field_149481_i = true;
/*     */     } private static final String __OBFID = "CL_00001362";
/*     */     @SideOnly(Side.CLIENT)
/*     */     public C06PacketPlayerPosLook(double p_i45254_1_, double p_i45254_3_, double p_i45254_5_, double p_i45254_7_, float p_i45254_9_, float p_i45254_10_, boolean p_i45254_11_) {
/*  28 */       this.field_149479_a = p_i45254_1_;
/*  29 */       this.field_149477_b = p_i45254_3_;
/*  30 */       this.field_149475_d = p_i45254_5_;
/*  31 */       this.field_149478_c = p_i45254_7_;
/*  32 */       this.field_149476_e = p_i45254_9_;
/*  33 */       this.field_149473_f = p_i45254_10_;
/*  34 */       this.field_149474_g = p_i45254_11_;
/*  35 */       this.field_149481_i = true;
/*  36 */       this.field_149480_h = true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/*  41 */       this.field_149479_a = p_148837_1_.readDouble();
/*  42 */       this.field_149477_b = p_148837_1_.readDouble();
/*  43 */       this.field_149475_d = p_148837_1_.readDouble();
/*  44 */       this.field_149478_c = p_148837_1_.readDouble();
/*  45 */       this.field_149476_e = p_148837_1_.readFloat();
/*  46 */       this.field_149473_f = p_148837_1_.readFloat();
/*  47 */       super.func_148837_a(p_148837_1_);
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/*  52 */       p_148840_1_.writeDouble(this.field_149479_a);
/*  53 */       p_148840_1_.writeDouble(this.field_149477_b);
/*  54 */       p_148840_1_.writeDouble(this.field_149475_d);
/*  55 */       p_148840_1_.writeDouble(this.field_149478_c);
/*  56 */       p_148840_1_.writeFloat(this.field_149476_e);
/*  57 */       p_148840_1_.writeFloat(this.field_149473_f);
/*  58 */       super.func_148840_b(p_148840_1_);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class C04PacketPlayerPosition extends C03PacketPlayer {
/*     */     private static final String __OBFID = "CL_00001361";
/*     */     
/*     */     public C04PacketPlayerPosition() {
/*  66 */       this.field_149480_h = true;
/*     */     }
/*     */     @SideOnly(Side.CLIENT)
/*     */     public C04PacketPlayerPosition(double p_i45253_1_, double p_i45253_3_, double p_i45253_5_, double p_i45253_7_, boolean p_i45253_9_) {
/*  70 */       this.field_149479_a = p_i45253_1_;
/*  71 */       this.field_149477_b = p_i45253_3_;
/*  72 */       this.field_149475_d = p_i45253_5_;
/*  73 */       this.field_149478_c = p_i45253_7_;
/*  74 */       this.field_149474_g = p_i45253_9_;
/*  75 */       this.field_149480_h = true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/*  80 */       this.field_149479_a = p_148837_1_.readDouble();
/*  81 */       this.field_149477_b = p_148837_1_.readDouble();
/*  82 */       this.field_149475_d = p_148837_1_.readDouble();
/*  83 */       this.field_149478_c = p_148837_1_.readDouble();
/*  84 */       super.func_148837_a(p_148837_1_);
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/*  89 */       p_148840_1_.writeDouble(this.field_149479_a);
/*  90 */       p_148840_1_.writeDouble(this.field_149477_b);
/*  91 */       p_148840_1_.writeDouble(this.field_149475_d);
/*  92 */       p_148840_1_.writeDouble(this.field_149478_c);
/*  93 */       super.func_148840_b(p_148840_1_);
/*     */     }
/*     */   }
/*     */   
/*     */   public static class C05PacketPlayerLook extends C03PacketPlayer {
/*     */     private static final String __OBFID = "CL_00001363";
/*     */     
/*     */     public C05PacketPlayerLook() {
/* 101 */       this.field_149481_i = true;
/*     */     }
/*     */     @SideOnly(Side.CLIENT)
/*     */     public C05PacketPlayerLook(float p_i45255_1_, float p_i45255_2_, boolean p_i45255_3_) {
/* 105 */       this.field_149476_e = p_i45255_1_;
/* 106 */       this.field_149473_f = p_i45255_2_;
/* 107 */       this.field_149474_g = p_i45255_3_;
/* 108 */       this.field_149481_i = true;
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 113 */       this.field_149476_e = p_148837_1_.readFloat();
/* 114 */       this.field_149473_f = p_148837_1_.readFloat();
/* 115 */       super.func_148837_a(p_148837_1_);
/*     */     }
/*     */ 
/*     */     
/*     */     public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 120 */       p_148840_1_.writeFloat(this.field_149476_e);
/* 121 */       p_148840_1_.writeFloat(this.field_149473_f);
/* 122 */       super.func_148840_b(p_148840_1_);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public C03PacketPlayer() {}
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public C03PacketPlayer(boolean p_i45256_1_) {
/* 132 */     this.field_149474_g = p_i45256_1_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148833_a(INetHandlerPlayServer p_148833_1_) {
/* 137 */     p_148833_1_.func_147347_a(this);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148837_a(PacketBuffer p_148837_1_) throws IOException {
/* 142 */     this.field_149474_g = (p_148837_1_.readUnsignedByte() != 0);
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_148840_b(PacketBuffer p_148840_1_) throws IOException {
/* 147 */     p_148840_1_.writeByte(this.field_149474_g ? 1 : 0);
/*     */   }
/*     */   
/*     */   public double func_149464_c() {
/* 151 */     return this.field_149479_a;
/*     */   }
/*     */   
/*     */   public double func_149467_d() {
/* 155 */     return this.field_149477_b;
/*     */   }
/*     */   
/*     */   public double func_149472_e() {
/* 159 */     return this.field_149478_c;
/*     */   }
/*     */   
/*     */   public double func_149471_f() {
/* 163 */     return this.field_149475_d;
/*     */   }
/*     */   
/*     */   public float func_149462_g() {
/* 167 */     return this.field_149476_e;
/*     */   }
/*     */   
/*     */   public float func_149470_h() {
/* 171 */     return this.field_149473_f;
/*     */   }
/*     */   
/*     */   public boolean func_149465_i() {
/* 175 */     return this.field_149474_g;
/*     */   }
/*     */   
/*     */   public boolean func_149466_j() {
/* 179 */     return this.field_149480_h;
/*     */   }
/*     */   
/*     */   public boolean func_149463_k() {
/* 183 */     return this.field_149481_i;
/*     */   }
/*     */   
/*     */   public void func_149469_a(boolean p_149469_1_) {
/* 187 */     this.field_149480_h = p_149469_1_;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\play\client\C03PacketPlayer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */