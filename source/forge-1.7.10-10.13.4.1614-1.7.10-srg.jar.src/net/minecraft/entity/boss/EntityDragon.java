/*     */ package net.minecraft.entity.boss;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockEndPortal;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLiving;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.IEntityMultiPart;
/*     */ import net.minecraft.entity.SharedMonsterAttributes;
/*     */ import net.minecraft.entity.item.EntityEnderCrystal;
/*     */ import net.minecraft.entity.item.EntityXPOrb;
/*     */ import net.minecraft.entity.monster.IMob;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class EntityDragon extends EntityLiving implements IBossDisplayData, IEntityMultiPart, IMob {
/*     */   public double field_70980_b;
/*  23 */   public double[][] field_70979_e = new double[64][3]; public double field_70981_c; public double field_70978_d;
/*  24 */   public int field_70976_f = -1;
/*     */   
/*     */   public EntityDragonPart[] field_70977_g;
/*     */   
/*     */   public EntityDragonPart field_70986_h;
/*     */   public EntityDragonPart field_70987_i;
/*     */   public EntityDragonPart field_70985_j;
/*     */   public EntityDragonPart field_70984_by;
/*     */   public EntityDragonPart field_70982_bz;
/*     */   public EntityDragonPart field_70983_bA;
/*     */   public EntityDragonPart field_70990_bB;
/*     */   public float field_70991_bC;
/*     */   public float field_70988_bD;
/*     */   public boolean field_70989_bE;
/*     */   public boolean field_70994_bF;
/*     */   private Entity field_70993_bI;
/*     */   public int field_70995_bG;
/*     */   public EntityEnderCrystal field_70992_bH;
/*     */   private static final String __OBFID = "CL_00001659";
/*     */   
/*     */   public EntityDragon(World p_i1700_1_) {
/*  45 */     super(p_i1700_1_);
/*     */     
/*  47 */     this.field_70977_g = new EntityDragonPart[] { this.field_70986_h = new EntityDragonPart(this, "head", 6.0F, 6.0F), this.field_70987_i = new EntityDragonPart(this, "body", 8.0F, 8.0F), this.field_70985_j = new EntityDragonPart(this, "tail", 4.0F, 4.0F), this.field_70984_by = new EntityDragonPart(this, "tail", 4.0F, 4.0F), this.field_70982_bz = new EntityDragonPart(this, "tail", 4.0F, 4.0F), this.field_70983_bA = new EntityDragonPart(this, "wing", 4.0F, 4.0F), this.field_70990_bB = new EntityDragonPart(this, "wing", 4.0F, 4.0F) };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  57 */     func_70606_j(func_110138_aP());
/*     */     
/*  59 */     func_70105_a(16.0F, 8.0F);
/*     */     
/*  61 */     this.field_70145_X = true;
/*  62 */     this.field_70178_ae = true;
/*     */     
/*  64 */     this.field_70981_c = 100.0D;
/*     */     
/*  66 */     this.field_70158_ak = true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_110147_ax() {
/*  71 */     super.func_110147_ax();
/*     */     
/*  73 */     func_110148_a(SharedMonsterAttributes.field_111267_a).func_111128_a(200.0D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  78 */     super.func_70088_a();
/*     */   }
/*     */   
/*     */   public double[] func_70974_a(int p_70974_1_, float p_70974_2_) {
/*  82 */     if (func_110143_aJ() <= 0.0F) {
/*  83 */       p_70974_2_ = 0.0F;
/*     */     }
/*     */     
/*  86 */     p_70974_2_ = 1.0F - p_70974_2_;
/*     */     
/*  88 */     int i = this.field_70976_f - p_70974_1_ * 1 & 0x3F;
/*  89 */     int j = this.field_70976_f - p_70974_1_ * 1 - 1 & 0x3F;
/*  90 */     double[] arrayOfDouble = new double[3];
/*  91 */     double d1 = this.field_70979_e[i][0];
/*  92 */     double d2 = MathHelper.func_76138_g(this.field_70979_e[j][0] - d1);
/*  93 */     arrayOfDouble[0] = d1 + d2 * p_70974_2_;
/*     */     
/*  95 */     d1 = this.field_70979_e[i][1];
/*  96 */     d2 = this.field_70979_e[j][1] - d1;
/*     */     
/*  98 */     arrayOfDouble[1] = d1 + d2 * p_70974_2_;
/*  99 */     arrayOfDouble[2] = this.field_70979_e[i][2] + (this.field_70979_e[j][2] - this.field_70979_e[i][2]) * p_70974_2_;
/* 100 */     return arrayOfDouble;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70636_d() {
/* 105 */     if (this.field_70170_p.field_72995_K) {
/* 106 */       float f10 = MathHelper.func_76134_b(this.field_70988_bD * 3.1415927F * 2.0F);
/* 107 */       float f11 = MathHelper.func_76134_b(this.field_70991_bC * 3.1415927F * 2.0F);
/* 108 */       if (f11 <= -0.3F && f10 >= -0.3F) {
/* 109 */         this.field_70170_p.func_72980_b(this.field_70165_t, this.field_70163_u, this.field_70161_v, "mob.enderdragon.wings", 5.0F, 0.8F + this.field_70146_Z.nextFloat() * 0.3F, false);
/*     */       }
/*     */     } 
/*     */     
/* 113 */     this.field_70991_bC = this.field_70988_bD;
/*     */ 
/*     */     
/* 116 */     if (func_110143_aJ() <= 0.0F) {
/* 117 */       float f10 = (this.field_70146_Z.nextFloat() - 0.5F) * 8.0F;
/* 118 */       float f11 = (this.field_70146_Z.nextFloat() - 0.5F) * 4.0F;
/* 119 */       float f12 = (this.field_70146_Z.nextFloat() - 0.5F) * 8.0F;
/* 120 */       this.field_70170_p.func_72869_a("largeexplode", this.field_70165_t + f10, this.field_70163_u + 2.0D + f11, this.field_70161_v + f12, 0.0D, 0.0D, 0.0D);
/*     */       
/*     */       return;
/*     */     } 
/* 124 */     func_70969_j();
/*     */     
/* 126 */     float f1 = 0.2F / (MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y) * 10.0F + 1.0F);
/* 127 */     f1 *= (float)Math.pow(2.0D, this.field_70181_x);
/* 128 */     if (this.field_70994_bF) { this.field_70988_bD += f1 * 0.5F; }
/* 129 */     else { this.field_70988_bD += f1; }
/*     */     
/* 131 */     this.field_70177_z = MathHelper.func_76142_g(this.field_70177_z);
/*     */     
/* 133 */     if (this.field_70976_f < 0) {
/* 134 */       for (byte b1 = 0; b1 < this.field_70979_e.length; b1++) {
/* 135 */         this.field_70979_e[b1][0] = this.field_70177_z;
/* 136 */         this.field_70979_e[b1][1] = this.field_70163_u;
/*     */       } 
/*     */     }
/*     */     
/* 140 */     if (++this.field_70976_f == this.field_70979_e.length) this.field_70976_f = 0; 
/* 141 */     this.field_70979_e[this.field_70976_f][0] = this.field_70177_z;
/* 142 */     this.field_70979_e[this.field_70976_f][1] = this.field_70163_u;
/*     */     
/* 144 */     if (this.field_70170_p.field_72995_K) {
/* 145 */       if (this.field_70716_bi > 0) {
/* 146 */         double d1 = this.field_70165_t + (this.field_70709_bj - this.field_70165_t) / this.field_70716_bi;
/* 147 */         double d2 = this.field_70163_u + (this.field_70710_bk - this.field_70163_u) / this.field_70716_bi;
/* 148 */         double d3 = this.field_70161_v + (this.field_110152_bk - this.field_70161_v) / this.field_70716_bi;
/*     */         
/* 150 */         double d4 = MathHelper.func_76138_g(this.field_70712_bm - this.field_70177_z);
/*     */         
/* 152 */         this.field_70177_z = (float)(this.field_70177_z + d4 / this.field_70716_bi);
/* 153 */         this.field_70125_A = (float)(this.field_70125_A + (this.field_70705_bn - this.field_70125_A) / this.field_70716_bi);
/*     */         
/* 155 */         this.field_70716_bi--;
/* 156 */         func_70107_b(d1, d2, d3);
/* 157 */         func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */       }
/*     */     
/*     */     }
/*     */     else {
/*     */       
/* 163 */       double d1 = this.field_70980_b - this.field_70165_t;
/* 164 */       double d2 = this.field_70981_c - this.field_70163_u;
/* 165 */       double d3 = this.field_70978_d - this.field_70161_v;
/*     */       
/* 167 */       double d4 = d1 * d1 + d2 * d2 + d3 * d3;
/* 168 */       if (this.field_70993_bI != null) {
/* 169 */         this.field_70980_b = this.field_70993_bI.field_70165_t;
/* 170 */         this.field_70978_d = this.field_70993_bI.field_70161_v;
/*     */         
/* 172 */         double d8 = this.field_70980_b - this.field_70165_t;
/* 173 */         double d9 = this.field_70978_d - this.field_70161_v;
/* 174 */         double d10 = Math.sqrt(d8 * d8 + d9 * d9);
/* 175 */         double d11 = 0.4000000059604645D + d10 / 80.0D - 1.0D;
/* 176 */         if (d11 > 10.0D) d11 = 10.0D; 
/* 177 */         this.field_70981_c = this.field_70993_bI.field_70121_D.field_72338_b + d11;
/*     */       } else {
/* 179 */         this.field_70980_b += this.field_70146_Z.nextGaussian() * 2.0D;
/* 180 */         this.field_70978_d += this.field_70146_Z.nextGaussian() * 2.0D;
/*     */       } 
/* 182 */       if (this.field_70989_bE || d4 < 100.0D || d4 > 22500.0D || this.field_70123_F || this.field_70124_G) {
/* 183 */         func_70967_k();
/*     */       }
/* 185 */       d2 /= MathHelper.func_76133_a(d1 * d1 + d3 * d3);
/* 186 */       float f10 = 0.6F;
/* 187 */       if (d2 < -f10) d2 = -f10; 
/* 188 */       if (d2 > f10) d2 = f10; 
/* 189 */       this.field_70181_x += d2 * 0.10000000149011612D;
/* 190 */       this.field_70177_z = MathHelper.func_76142_g(this.field_70177_z);
/*     */       
/* 192 */       double d5 = 180.0D - Math.atan2(d1, d3) * 180.0D / 3.1415927410125732D;
/* 193 */       double d6 = MathHelper.func_76138_g(d5 - this.field_70177_z);
/*     */       
/* 195 */       if (d6 > 50.0D) d6 = 50.0D; 
/* 196 */       if (d6 < -50.0D) d6 = -50.0D;
/*     */       
/* 198 */       Vec3 vec31 = Vec3.func_72443_a(this.field_70980_b - this.field_70165_t, this.field_70981_c - this.field_70163_u, this.field_70978_d - this.field_70161_v).func_72432_b();
/* 199 */       Vec3 vec32 = Vec3.func_72443_a(MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F), this.field_70181_x, -MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F)).func_72432_b();
/* 200 */       float f11 = (float)(vec32.func_72430_b(vec31) + 0.5D) / 1.5F;
/* 201 */       if (f11 < 0.0F) f11 = 0.0F;
/*     */       
/* 203 */       this.field_70704_bt *= 0.8F;
/*     */       
/* 205 */       float f12 = MathHelper.func_76133_a(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y) * 1.0F + 1.0F;
/* 206 */       double d7 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y) * 1.0D + 1.0D;
/* 207 */       if (d7 > 40.0D) d7 = 40.0D; 
/* 208 */       this.field_70704_bt = (float)(this.field_70704_bt + d6 * 0.699999988079071D / d7 / f12);
/* 209 */       this.field_70177_z += this.field_70704_bt * 0.1F;
/*     */       
/* 211 */       float f13 = (float)(2.0D / (d7 + 1.0D));
/* 212 */       float f14 = 0.06F;
/* 213 */       func_70060_a(0.0F, -1.0F, f14 * (f11 * f13 + 1.0F - f13));
/* 214 */       if (this.field_70994_bF) {
/* 215 */         func_70091_d(this.field_70159_w * 0.800000011920929D, this.field_70181_x * 0.800000011920929D, this.field_70179_y * 0.800000011920929D);
/*     */       } else {
/* 217 */         func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */       } 
/*     */ 
/*     */       
/* 221 */       Vec3 vec33 = Vec3.func_72443_a(this.field_70159_w, this.field_70181_x, this.field_70179_y).func_72432_b();
/* 222 */       float f15 = (float)(vec33.func_72430_b(vec32) + 1.0D) / 2.0F;
/* 223 */       f15 = 0.8F + 0.15F * f15;
/*     */       
/* 225 */       this.field_70159_w *= f15;
/* 226 */       this.field_70179_y *= f15;
/* 227 */       this.field_70181_x *= 0.9100000262260437D;
/*     */     } 
/*     */     
/* 230 */     this.field_70761_aq = this.field_70177_z;
/*     */     
/* 232 */     this.field_70986_h.field_70130_N = this.field_70986_h.field_70131_O = 3.0F;
/* 233 */     this.field_70985_j.field_70130_N = this.field_70985_j.field_70131_O = 2.0F;
/* 234 */     this.field_70984_by.field_70130_N = this.field_70984_by.field_70131_O = 2.0F;
/* 235 */     this.field_70982_bz.field_70130_N = this.field_70982_bz.field_70131_O = 2.0F;
/* 236 */     this.field_70987_i.field_70131_O = 3.0F;
/* 237 */     this.field_70987_i.field_70130_N = 5.0F;
/* 238 */     this.field_70983_bA.field_70131_O = 2.0F;
/* 239 */     this.field_70983_bA.field_70130_N = 4.0F;
/* 240 */     this.field_70990_bB.field_70131_O = 3.0F;
/* 241 */     this.field_70990_bB.field_70130_N = 4.0F;
/*     */     
/* 243 */     float f2 = (float)(func_70974_a(5, 1.0F)[1] - func_70974_a(10, 1.0F)[1]) * 10.0F / 180.0F * 3.1415927F;
/* 244 */     float f3 = MathHelper.func_76134_b(f2);
/* 245 */     float f4 = -MathHelper.func_76126_a(f2);
/*     */     
/* 247 */     float f5 = this.field_70177_z * 3.1415927F / 180.0F;
/* 248 */     float f6 = MathHelper.func_76126_a(f5);
/* 249 */     float f7 = MathHelper.func_76134_b(f5);
/*     */     
/* 251 */     this.field_70987_i.func_70071_h_();
/* 252 */     this.field_70987_i.func_70012_b(this.field_70165_t + (f6 * 0.5F), this.field_70163_u, this.field_70161_v - (f7 * 0.5F), 0.0F, 0.0F);
/* 253 */     this.field_70983_bA.func_70071_h_();
/* 254 */     this.field_70983_bA.func_70012_b(this.field_70165_t + (f7 * 4.5F), this.field_70163_u + 2.0D, this.field_70161_v + (f6 * 4.5F), 0.0F, 0.0F);
/* 255 */     this.field_70990_bB.func_70071_h_();
/* 256 */     this.field_70990_bB.func_70012_b(this.field_70165_t - (f7 * 4.5F), this.field_70163_u + 2.0D, this.field_70161_v - (f6 * 4.5F), 0.0F, 0.0F);
/*     */     
/* 258 */     if (!this.field_70170_p.field_72995_K && this.field_70737_aN == 0) {
/* 259 */       func_70970_a(this.field_70170_p.func_72839_b((Entity)this, this.field_70983_bA.field_70121_D.func_72314_b(4.0D, 2.0D, 4.0D).func_72317_d(0.0D, -2.0D, 0.0D)));
/* 260 */       func_70970_a(this.field_70170_p.func_72839_b((Entity)this, this.field_70990_bB.field_70121_D.func_72314_b(4.0D, 2.0D, 4.0D).func_72317_d(0.0D, -2.0D, 0.0D)));
/* 261 */       func_70971_b(this.field_70170_p.func_72839_b((Entity)this, this.field_70986_h.field_70121_D.func_72314_b(1.0D, 1.0D, 1.0D)));
/*     */     } 
/*     */     
/* 264 */     double[] arrayOfDouble1 = func_70974_a(5, 1.0F);
/*     */     
/* 266 */     double[] arrayOfDouble2 = func_70974_a(0, 1.0F);
/* 267 */     float f8 = MathHelper.func_76126_a(this.field_70177_z * 3.1415927F / 180.0F - this.field_70704_bt * 0.01F);
/* 268 */     float f9 = MathHelper.func_76134_b(this.field_70177_z * 3.1415927F / 180.0F - this.field_70704_bt * 0.01F);
/* 269 */     this.field_70986_h.func_70071_h_();
/* 270 */     this.field_70986_h.func_70012_b(this.field_70165_t + (f8 * 5.5F * f3), this.field_70163_u + (arrayOfDouble2[1] - arrayOfDouble1[1]) * 1.0D + (f4 * 5.5F), this.field_70161_v - (f9 * 5.5F * f3), 0.0F, 0.0F);
/*     */ 
/*     */     
/* 273 */     for (byte b = 0; b < 3; b++) {
/* 274 */       EntityDragonPart entityDragonPart = null;
/*     */       
/* 276 */       if (b == 0) entityDragonPart = this.field_70985_j; 
/* 277 */       if (b == 1) entityDragonPart = this.field_70984_by; 
/* 278 */       if (b == 2) entityDragonPart = this.field_70982_bz;
/*     */       
/* 280 */       double[] arrayOfDouble = func_70974_a(12 + b * 2, 1.0F);
/*     */       
/* 282 */       float f10 = this.field_70177_z * 3.1415927F / 180.0F + func_70973_b(arrayOfDouble[0] - arrayOfDouble1[0]) * 3.1415927F / 180.0F * 1.0F;
/* 283 */       float f11 = MathHelper.func_76126_a(f10);
/* 284 */       float f12 = MathHelper.func_76134_b(f10);
/*     */       
/* 286 */       float f13 = 1.5F;
/* 287 */       float f14 = (b + 1) * 2.0F;
/* 288 */       entityDragonPart.func_70071_h_();
/* 289 */       entityDragonPart.func_70012_b(this.field_70165_t - ((f6 * f13 + f11 * f14) * f3), this.field_70163_u + (arrayOfDouble[1] - arrayOfDouble1[1]) * 1.0D - ((f14 + f13) * f4) + 1.5D, this.field_70161_v + ((f7 * f13 + f12 * f14) * f3), 0.0F, 0.0F);
/*     */     } 
/*     */     
/* 292 */     if (!this.field_70170_p.field_72995_K) {
/* 293 */       this.field_70994_bF = func_70972_a(this.field_70986_h.field_70121_D) | func_70972_a(this.field_70987_i.field_70121_D);
/*     */     }
/*     */   }
/*     */   
/*     */   private void func_70969_j() {
/* 298 */     if (this.field_70992_bH != null) {
/* 299 */       if (this.field_70992_bH.field_70128_L)
/* 300 */       { if (!this.field_70170_p.field_72995_K) {
/* 301 */           func_70965_a(this.field_70986_h, DamageSource.func_94539_a(null), 10.0F);
/*     */         }
/*     */         
/* 304 */         this.field_70992_bH = null; }
/* 305 */       else if (this.field_70173_aa % 10 == 0 && 
/* 306 */         func_110143_aJ() < func_110138_aP()) { func_70606_j(func_110143_aJ() + 1.0F); }
/*     */     
/*     */     }
/*     */     
/* 310 */     if (this.field_70146_Z.nextInt(10) == 0) {
/* 311 */       float f = 32.0F;
/* 312 */       List list = this.field_70170_p.func_72872_a(EntityEnderCrystal.class, this.field_70121_D.func_72314_b(f, f, f));
/*     */       
/* 314 */       EntityEnderCrystal entityEnderCrystal = null;
/* 315 */       double d = Double.MAX_VALUE;
/* 316 */       for (EntityEnderCrystal entityEnderCrystal1 : list) {
/* 317 */         double d1 = entityEnderCrystal1.func_70068_e((Entity)this);
/* 318 */         if (d1 < d) {
/* 319 */           d = d1;
/* 320 */           entityEnderCrystal = entityEnderCrystal1;
/*     */         } 
/*     */       } 
/*     */       
/* 324 */       this.field_70992_bH = entityEnderCrystal;
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_70970_a(List p_70970_1_) {
/* 329 */     double d1 = (this.field_70987_i.field_70121_D.field_72340_a + this.field_70987_i.field_70121_D.field_72336_d) / 2.0D;
/* 330 */     double d2 = (this.field_70987_i.field_70121_D.field_72339_c + this.field_70987_i.field_70121_D.field_72334_f) / 2.0D;
/*     */     
/* 332 */     for (Entity entity : p_70970_1_) {
/* 333 */       if (entity instanceof EntityLivingBase) {
/* 334 */         double d3 = entity.field_70165_t - d1;
/* 335 */         double d4 = entity.field_70161_v - d2;
/* 336 */         double d5 = d3 * d3 + d4 * d4;
/* 337 */         entity.func_70024_g(d3 / d5 * 4.0D, 0.20000000298023224D, d4 / d5 * 4.0D);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_70971_b(List<Entity> p_70971_1_) {
/* 343 */     for (byte b = 0; b < p_70971_1_.size(); b++) {
/* 344 */       Entity entity = p_70971_1_.get(b);
/* 345 */       if (entity instanceof EntityLivingBase) {
/* 346 */         entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this), 10.0F);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_70967_k() {
/* 352 */     this.field_70989_bE = false;
/* 353 */     if (this.field_70146_Z.nextInt(2) == 0 && !this.field_70170_p.field_73010_i.isEmpty()) {
/* 354 */       this.field_70993_bI = this.field_70170_p.field_73010_i.get(this.field_70146_Z.nextInt(this.field_70170_p.field_73010_i.size()));
/*     */     } else {
/* 356 */       boolean bool = false;
/*     */       while (true) {
/* 358 */         this.field_70980_b = 0.0D;
/* 359 */         this.field_70981_c = (70.0F + this.field_70146_Z.nextFloat() * 50.0F);
/* 360 */         this.field_70978_d = 0.0D;
/* 361 */         this.field_70980_b += (this.field_70146_Z.nextFloat() * 120.0F - 60.0F);
/* 362 */         this.field_70978_d += (this.field_70146_Z.nextFloat() * 120.0F - 60.0F);
/* 363 */         double d1 = this.field_70165_t - this.field_70980_b;
/* 364 */         double d2 = this.field_70163_u - this.field_70981_c;
/* 365 */         double d3 = this.field_70161_v - this.field_70978_d;
/* 366 */         bool = (d1 * d1 + d2 * d2 + d3 * d3 > 100.0D) ? true : false;
/* 367 */         if (bool) {
/* 368 */           this.field_70993_bI = null;
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     }  } private float func_70973_b(double p_70973_1_) {
/* 373 */     return (float)MathHelper.func_76138_g(p_70973_1_);
/*     */   }
/*     */   
/*     */   private boolean func_70972_a(AxisAlignedBB p_70972_1_) {
/* 377 */     int i = MathHelper.func_76128_c(p_70972_1_.field_72340_a);
/* 378 */     int j = MathHelper.func_76128_c(p_70972_1_.field_72338_b);
/* 379 */     int k = MathHelper.func_76128_c(p_70972_1_.field_72339_c);
/* 380 */     int m = MathHelper.func_76128_c(p_70972_1_.field_72336_d);
/* 381 */     int n = MathHelper.func_76128_c(p_70972_1_.field_72337_e);
/* 382 */     int i1 = MathHelper.func_76128_c(p_70972_1_.field_72334_f);
/* 383 */     boolean bool1 = false;
/* 384 */     boolean bool2 = false;
/* 385 */     for (int i2 = i; i2 <= m; i2++) {
/* 386 */       for (int i3 = j; i3 <= n; i3++) {
/* 387 */         for (int i4 = k; i4 <= i1; i4++) {
/* 388 */           Block block = this.field_70170_p.func_147439_a(i2, i3, i4);
/* 389 */           if (block.func_149688_o() != Material.field_151579_a)
/*     */           {
/* 391 */             if (block == Blocks.field_150343_Z || block == Blocks.field_150377_bs || block == Blocks.field_150357_h || !this.field_70170_p.func_82736_K().func_82766_b("mobGriefing")) {
/* 392 */               bool1 = true;
/*     */             } else {
/* 394 */               bool2 = (this.field_70170_p.func_147468_f(i2, i3, i4) || bool2) ? true : false;
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 400 */     if (bool2) {
/* 401 */       double d1 = p_70972_1_.field_72340_a + (p_70972_1_.field_72336_d - p_70972_1_.field_72340_a) * this.field_70146_Z.nextFloat();
/* 402 */       double d2 = p_70972_1_.field_72338_b + (p_70972_1_.field_72337_e - p_70972_1_.field_72338_b) * this.field_70146_Z.nextFloat();
/* 403 */       double d3 = p_70972_1_.field_72339_c + (p_70972_1_.field_72334_f - p_70972_1_.field_72339_c) * this.field_70146_Z.nextFloat();
/* 404 */       this.field_70170_p.func_72869_a("largeexplode", d1, d2, d3, 0.0D, 0.0D, 0.0D);
/*     */     } 
/*     */     
/* 407 */     return bool1;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70965_a(EntityDragonPart p_70965_1_, DamageSource p_70965_2_, float p_70965_3_) {
/* 412 */     if (p_70965_1_ != this.field_70986_h) {
/* 413 */       p_70965_3_ = p_70965_3_ / 4.0F + 1.0F;
/*     */     }
/*     */     
/* 416 */     float f1 = this.field_70177_z * 3.1415927F / 180.0F;
/* 417 */     float f2 = MathHelper.func_76126_a(f1);
/* 418 */     float f3 = MathHelper.func_76134_b(f1);
/*     */     
/* 420 */     this.field_70980_b = this.field_70165_t + (f2 * 5.0F) + ((this.field_70146_Z.nextFloat() - 0.5F) * 2.0F);
/* 421 */     this.field_70981_c = this.field_70163_u + (this.field_70146_Z.nextFloat() * 3.0F) + 1.0D;
/* 422 */     this.field_70978_d = this.field_70161_v - (f3 * 5.0F) + ((this.field_70146_Z.nextFloat() - 0.5F) * 2.0F);
/* 423 */     this.field_70993_bI = null;
/* 424 */     if (p_70965_2_.func_76346_g() instanceof net.minecraft.entity.player.EntityPlayer || p_70965_2_.func_94541_c()) {
/* 425 */       func_82195_e(p_70965_2_, p_70965_3_);
/*     */     }
/* 427 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/* 432 */     return false;
/*     */   }
/*     */   
/*     */   protected boolean func_82195_e(DamageSource p_82195_1_, float p_82195_2_) {
/* 436 */     return super.func_70097_a(p_82195_1_, p_82195_2_);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70609_aI() {
/* 441 */     this.field_70995_bG++;
/* 442 */     if (this.field_70995_bG >= 180 && this.field_70995_bG <= 200) {
/* 443 */       float f1 = (this.field_70146_Z.nextFloat() - 0.5F) * 8.0F;
/* 444 */       float f2 = (this.field_70146_Z.nextFloat() - 0.5F) * 4.0F;
/* 445 */       float f3 = (this.field_70146_Z.nextFloat() - 0.5F) * 8.0F;
/* 446 */       this.field_70170_p.func_72869_a("hugeexplosion", this.field_70165_t + f1, this.field_70163_u + 2.0D + f2, this.field_70161_v + f3, 0.0D, 0.0D, 0.0D);
/*     */     } 
/* 448 */     if (!this.field_70170_p.field_72995_K) {
/* 449 */       if (this.field_70995_bG > 150 && this.field_70995_bG % 5 == 0) {
/* 450 */         int i = 1000;
/* 451 */         while (i > 0) {
/* 452 */           int j = EntityXPOrb.func_70527_a(i);
/* 453 */           i -= j;
/* 454 */           this.field_70170_p.func_72838_d((Entity)new EntityXPOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, j));
/*     */         } 
/*     */       } 
/* 457 */       if (this.field_70995_bG == 1) {
/* 458 */         this.field_70170_p.func_82739_e(1018, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0);
/*     */       }
/*     */     } 
/*     */     
/* 462 */     func_70091_d(0.0D, 0.10000000149011612D, 0.0D);
/* 463 */     this.field_70761_aq = this.field_70177_z += 20.0F;
/*     */     
/* 465 */     if (this.field_70995_bG == 200 && !this.field_70170_p.field_72995_K) {
/* 466 */       int i = 2000;
/* 467 */       while (i > 0) {
/* 468 */         int j = EntityXPOrb.func_70527_a(i);
/* 469 */         i -= j;
/* 470 */         this.field_70170_p.func_72838_d((Entity)new EntityXPOrb(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, j));
/*     */       } 
/* 472 */       func_70975_a(MathHelper.func_76128_c(this.field_70165_t), MathHelper.func_76128_c(this.field_70161_v));
/* 473 */       func_70106_y();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void func_70975_a(int p_70975_1_, int p_70975_2_) {
/* 478 */     byte b1 = 64;
/*     */     
/* 480 */     BlockEndPortal.field_149948_a = true;
/*     */     
/* 482 */     byte b2 = 4;
/* 483 */     for (int i = b1 - 1; i <= b1 + 32; i++) {
/* 484 */       for (int j = p_70975_1_ - b2; j <= p_70975_1_ + b2; j++) {
/* 485 */         for (int k = p_70975_2_ - b2; k <= p_70975_2_ + b2; k++) {
/* 486 */           double d1 = (j - p_70975_1_);
/* 487 */           double d2 = (k - p_70975_2_);
/* 488 */           double d3 = d1 * d1 + d2 * d2;
/* 489 */           if (d3 <= (b2 - 0.5D) * (b2 - 0.5D)) {
/* 490 */             if (i < b1) {
/* 491 */               if (d3 <= ((b2 - 1) - 0.5D) * ((b2 - 1) - 0.5D)) {
/* 492 */                 this.field_70170_p.func_147449_b(j, i, k, Blocks.field_150357_h);
/*     */               }
/* 494 */             } else if (i > b1) {
/* 495 */               this.field_70170_p.func_147449_b(j, i, k, Blocks.field_150350_a);
/*     */             }
/* 497 */             else if (d3 > ((b2 - 1) - 0.5D) * ((b2 - 1) - 0.5D)) {
/* 498 */               this.field_70170_p.func_147449_b(j, i, k, Blocks.field_150357_h);
/*     */             } else {
/* 500 */               this.field_70170_p.func_147449_b(j, i, k, Blocks.field_150384_bq);
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/* 506 */     this.field_70170_p.func_147449_b(p_70975_1_, b1 + 0, p_70975_2_, Blocks.field_150357_h);
/* 507 */     this.field_70170_p.func_147449_b(p_70975_1_, b1 + 1, p_70975_2_, Blocks.field_150357_h);
/* 508 */     this.field_70170_p.func_147449_b(p_70975_1_, b1 + 2, p_70975_2_, Blocks.field_150357_h);
/* 509 */     this.field_70170_p.func_147449_b(p_70975_1_ - 1, b1 + 2, p_70975_2_, Blocks.field_150478_aa);
/* 510 */     this.field_70170_p.func_147449_b(p_70975_1_ + 1, b1 + 2, p_70975_2_, Blocks.field_150478_aa);
/* 511 */     this.field_70170_p.func_147449_b(p_70975_1_, b1 + 2, p_70975_2_ - 1, Blocks.field_150478_aa);
/* 512 */     this.field_70170_p.func_147449_b(p_70975_1_, b1 + 2, p_70975_2_ + 1, Blocks.field_150478_aa);
/* 513 */     this.field_70170_p.func_147449_b(p_70975_1_, b1 + 3, p_70975_2_, Blocks.field_150357_h);
/* 514 */     this.field_70170_p.func_147449_b(p_70975_1_, b1 + 4, p_70975_2_, Blocks.field_150380_bt);
/*     */     
/* 516 */     BlockEndPortal.field_149948_a = false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70623_bb() {}
/*     */ 
/*     */   
/*     */   public Entity[] func_70021_al() {
/* 525 */     return (Entity[])this.field_70977_g;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70067_L() {
/* 530 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public World func_82194_d() {
/* 535 */     return this.field_70170_p;
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70639_aQ() {
/* 540 */     return "mob.enderdragon.growl";
/*     */   }
/*     */ 
/*     */   
/*     */   protected String func_70621_aR() {
/* 545 */     return "mob.enderdragon.hit";
/*     */   }
/*     */ 
/*     */   
/*     */   protected float func_70599_aP() {
/* 550 */     return 5.0F;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\boss\EntityDragon.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */