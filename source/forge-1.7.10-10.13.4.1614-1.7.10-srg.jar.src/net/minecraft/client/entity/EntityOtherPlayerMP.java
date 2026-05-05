/*     */ package net.minecraft.client.entity;
/*     */ 
/*     */ import com.mojang.authlib.GameProfile;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.ChunkCoordinates;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class EntityOtherPlayerMP
/*     */   extends AbstractClientPlayer {
/*     */   private boolean field_71186_a;
/*     */   private int field_71184_b;
/*     */   private double field_71185_c;
/*     */   private double field_71182_d;
/*     */   
/*     */   public EntityOtherPlayerMP(World p_i45075_1_, GameProfile p_i45075_2_) {
/*  23 */     super(p_i45075_1_, p_i45075_2_);
/*     */     
/*  25 */     this.field_70129_M = 0.0F;
/*  26 */     this.field_70138_W = 0.0F;
/*  27 */     this.field_70145_X = true;
/*     */     
/*  29 */     this.field_71082_cx = 0.25F;
/*     */     
/*  31 */     this.field_70155_l = 10.0D;
/*     */   }
/*     */   private double field_71183_e; private double field_71180_f; private double field_71181_g; private static final String __OBFID = "CL_00000939";
/*     */   
/*     */   protected void func_71061_d_() {
/*  36 */     this.field_70129_M = 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/*  41 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70056_a(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
/*  46 */     this.field_71185_c = p_70056_1_;
/*  47 */     this.field_71182_d = p_70056_3_;
/*  48 */     this.field_71183_e = p_70056_5_;
/*  49 */     this.field_71180_f = p_70056_7_;
/*  50 */     this.field_71181_g = p_70056_8_;
/*     */     
/*  52 */     this.field_71184_b = p_70056_9_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/*  57 */     this.field_71082_cx = 0.0F;
/*  58 */     super.func_70071_h_();
/*     */     
/*  60 */     this.field_70722_aY = this.field_70721_aZ;
/*  61 */     double d1 = this.field_70165_t - this.field_70169_q;
/*  62 */     double d2 = this.field_70161_v - this.field_70166_s;
/*  63 */     float f = MathHelper.func_76133_a(d1 * d1 + d2 * d2) * 4.0F;
/*  64 */     if (f > 1.0F) f = 1.0F; 
/*  65 */     this.field_70721_aZ += (f - this.field_70721_aZ) * 0.4F;
/*  66 */     this.field_70754_ba += this.field_70721_aZ;
/*     */     
/*  68 */     if (!this.field_71186_a && func_70113_ah() && this.field_71071_by.field_70462_a[this.field_71071_by.field_70461_c] != null) {
/*  69 */       ItemStack itemStack = this.field_71071_by.field_70462_a[this.field_71071_by.field_70461_c];
/*  70 */       func_71008_a(this.field_71071_by.field_70462_a[this.field_71071_by.field_70461_c], itemStack.func_77973_b().func_77626_a(itemStack));
/*  71 */       this.field_71186_a = true;
/*  72 */     } else if (this.field_71186_a && !func_70113_ah()) {
/*  73 */       func_71041_bz();
/*  74 */       this.field_71186_a = false;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public float func_70053_R() {
/*  80 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/*  85 */     func_70626_be();
/*  86 */     if (this.field_71184_b > 0) {
/*  87 */       double d1 = this.field_70165_t + (this.field_71185_c - this.field_70165_t) / this.field_71184_b;
/*  88 */       double d2 = this.field_70163_u + (this.field_71182_d - this.field_70163_u) / this.field_71184_b;
/*  89 */       double d3 = this.field_70161_v + (this.field_71183_e - this.field_70161_v) / this.field_71184_b;
/*     */       
/*  91 */       double d4 = this.field_71180_f - this.field_70177_z;
/*  92 */       while (d4 < -180.0D)
/*  93 */         d4 += 360.0D; 
/*  94 */       while (d4 >= 180.0D) {
/*  95 */         d4 -= 360.0D;
/*     */       }
/*  97 */       this.field_70177_z = (float)(this.field_70177_z + d4 / this.field_71184_b);
/*  98 */       this.field_70125_A = (float)(this.field_70125_A + (this.field_71181_g - this.field_70125_A) / this.field_71184_b);
/*     */       
/* 100 */       this.field_71184_b--;
/* 101 */       func_70107_b(d1, d2, d3);
/* 102 */       func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */     } 
/* 104 */     this.field_71107_bF = this.field_71109_bG;
/*     */     
/* 106 */     float f1 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 107 */     float f2 = (float)Math.atan(-this.field_70181_x * 0.20000000298023224D) * 15.0F;
/* 108 */     if (f1 > 0.1F) f1 = 0.1F; 
/* 109 */     if (!this.field_70122_E || func_110143_aJ() <= 0.0F) f1 = 0.0F; 
/* 110 */     if (this.field_70122_E || func_110143_aJ() <= 0.0F) f2 = 0.0F; 
/* 111 */     this.field_71109_bG += (f1 - this.field_71109_bG) * 0.4F;
/* 112 */     this.field_70726_aT += (f2 - this.field_70726_aT) * 0.8F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70062_b(int p_70062_1_, ItemStack p_70062_2_) {
/* 117 */     if (p_70062_1_ == 0) {
/* 118 */       this.field_71071_by.field_70462_a[this.field_71071_by.field_70461_c] = p_70062_2_;
/*     */     } else {
/* 120 */       this.field_71071_by.field_70460_b[p_70062_1_ - 1] = p_70062_2_;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public float func_70047_e() {
/* 127 */     return 1.82F;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_145747_a(IChatComponent p_145747_1_) {
/* 132 */     (Minecraft.func_71410_x()).field_71456_v.func_146158_b().func_146227_a(p_145747_1_);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70003_b(int p_70003_1_, String p_70003_2_) {
/* 137 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public ChunkCoordinates func_82114_b() {
/* 142 */     return new ChunkCoordinates(MathHelper.func_76128_c(this.field_70165_t + 0.5D), MathHelper.func_76128_c(this.field_70163_u + 0.5D), MathHelper.func_76128_c(this.field_70161_v + 0.5D));
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\client\entity\EntityOtherPlayerMP.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */