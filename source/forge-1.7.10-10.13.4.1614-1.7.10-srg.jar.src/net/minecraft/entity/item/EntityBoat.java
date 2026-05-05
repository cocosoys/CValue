/*     */ package net.minecraft.entity.item;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
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
/*     */ public class EntityBoat
/*     */   extends Entity
/*     */ {
/*     */   private boolean field_70279_a = true;
/*  33 */   private double field_70276_b = 0.07D; private int field_70277_c; private double field_70274_d; private double field_70275_e; private double field_70272_f; private double field_70273_g;
/*     */   
/*     */   public EntityBoat(World p_i1704_1_) {
/*  36 */     super(p_i1704_1_);
/*  37 */     this.field_70156_m = true;
/*  38 */     func_70105_a(1.5F, 0.6F);
/*  39 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*     */   } private double field_70281_h; @SideOnly(Side.CLIENT)
/*     */   private double field_70282_i; @SideOnly(Side.CLIENT)
/*     */   private double field_70280_j; @SideOnly(Side.CLIENT)
/*     */   private double field_70278_an; private static final String __OBFID = "CL_00001667"; protected boolean func_70041_e_() {
/*  44 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70088_a() {
/*  50 */     this.field_70180_af.func_75682_a(17, new Integer(0));
/*  51 */     this.field_70180_af.func_75682_a(18, new Integer(1));
/*  52 */     this.field_70180_af.func_75682_a(19, new Float(0.0F));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_70114_g(Entity p_70114_1_) {
/*  58 */     return p_70114_1_.field_70121_D;
/*     */   }
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_70046_E() {
/*  63 */     return this.field_70121_D;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70104_M() {
/*  68 */     return true;
/*     */   }
/*     */   
/*     */   public EntityBoat(World p_i1705_1_, double p_i1705_2_, double p_i1705_4_, double p_i1705_6_) {
/*  72 */     this(p_i1705_1_);
/*  73 */     func_70107_b(p_i1705_2_, p_i1705_4_ + this.field_70129_M, p_i1705_6_);
/*     */     
/*  75 */     this.field_70159_w = 0.0D;
/*  76 */     this.field_70181_x = 0.0D;
/*  77 */     this.field_70179_y = 0.0D;
/*     */     
/*  79 */     this.field_70169_q = p_i1705_2_;
/*  80 */     this.field_70167_r = p_i1705_4_;
/*  81 */     this.field_70166_s = p_i1705_6_;
/*     */   }
/*     */ 
/*     */   
/*     */   public double func_70042_X() {
/*  86 */     return this.field_70131_O * 0.0D - 0.30000001192092896D;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70097_a(DamageSource p_70097_1_, float p_70097_2_) {
/*  91 */     if (func_85032_ar()) return false; 
/*  92 */     if (this.field_70170_p.field_72995_K || this.field_70128_L) return true; 
/*  93 */     func_70269_c(-func_70267_i());
/*  94 */     func_70265_b(10);
/*  95 */     func_70266_a(func_70271_g() + p_70097_2_ * 10.0F);
/*  96 */     func_70018_K();
/*  97 */     boolean bool = (p_70097_1_.func_76346_g() instanceof EntityPlayer && ((EntityPlayer)p_70097_1_.func_76346_g()).field_71075_bZ.field_75098_d) ? true : false;
/*  98 */     if (bool || func_70271_g() > 40.0F) {
/*  99 */       if (this.field_70153_n != null) this.field_70153_n.func_70078_a(this); 
/* 100 */       if (!bool) func_145778_a(Items.field_151124_az, 1, 0.0F); 
/* 101 */       func_70106_y();
/*     */     } 
/* 103 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70057_ab() {
/* 108 */     func_70269_c(-func_70267_i());
/* 109 */     func_70265_b(10);
/* 110 */     func_70266_a(func_70271_g() * 11.0F);
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_70067_L() {
/* 115 */     return !this.field_70128_L;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70056_a(double p_70056_1_, double p_70056_3_, double p_70056_5_, float p_70056_7_, float p_70056_8_, int p_70056_9_) {
/* 124 */     if (this.field_70279_a) {
/* 125 */       this.field_70277_c = p_70056_9_ + 5;
/*     */     } else {
/* 127 */       double d1 = p_70056_1_ - this.field_70165_t;
/* 128 */       double d2 = p_70056_3_ - this.field_70163_u;
/* 129 */       double d3 = p_70056_5_ - this.field_70161_v;
/* 130 */       double d4 = d1 * d1 + d2 * d2 + d3 * d3;
/*     */       
/* 132 */       if (d4 > 1.0D) {
/* 133 */         this.field_70277_c = 3;
/*     */       } else {
/*     */         return;
/*     */       } 
/*     */     } 
/*     */     
/* 139 */     this.field_70274_d = p_70056_1_;
/* 140 */     this.field_70275_e = p_70056_3_;
/* 141 */     this.field_70272_f = p_70056_5_;
/* 142 */     this.field_70273_g = p_70056_7_;
/* 143 */     this.field_70281_h = p_70056_8_;
/*     */     
/* 145 */     this.field_70159_w = this.field_70282_i;
/* 146 */     this.field_70181_x = this.field_70280_j;
/* 147 */     this.field_70179_y = this.field_70278_an;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double p_70016_1_, double p_70016_3_, double p_70016_5_) {
/* 152 */     this.field_70282_i = this.field_70159_w = p_70016_1_;
/* 153 */     this.field_70280_j = this.field_70181_x = p_70016_3_;
/* 154 */     this.field_70278_an = this.field_70179_y = p_70016_5_;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 159 */     super.func_70071_h_();
/* 160 */     if (func_70268_h() > 0) func_70265_b(func_70268_h() - 1); 
/* 161 */     if (func_70271_g() > 0.0F) func_70266_a(func_70271_g() - 1.0F); 
/* 162 */     this.field_70169_q = this.field_70165_t;
/* 163 */     this.field_70167_r = this.field_70163_u;
/* 164 */     this.field_70166_s = this.field_70161_v;
/*     */     
/* 166 */     byte b1 = 5;
/* 167 */     double d1 = 0.0D;
/* 168 */     for (byte b2 = 0; b2 < b1; b2++) {
/* 169 */       double d8 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (b2 + 0) / b1 - 0.125D;
/* 170 */       double d9 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (b2 + 1) / b1 - 0.125D;
/* 171 */       AxisAlignedBB axisAlignedBB = AxisAlignedBB.func_72330_a(this.field_70121_D.field_72340_a, d8, this.field_70121_D.field_72339_c, this.field_70121_D.field_72336_d, d9, this.field_70121_D.field_72334_f);
/* 172 */       if (this.field_70170_p.func_72830_b(axisAlignedBB, Material.field_151586_h)) {
/* 173 */         d1 += 1.0D / b1;
/*     */       }
/*     */     } 
/*     */     
/* 177 */     double d2 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*     */     
/* 179 */     if (d2 > 0.26249999999999996D) {
/* 180 */       double d8 = Math.cos(this.field_70177_z * Math.PI / 180.0D);
/* 181 */       double d9 = Math.sin(this.field_70177_z * Math.PI / 180.0D);
/*     */       
/* 183 */       for (byte b = 0; b < 1.0D + d2 * 60.0D; b++) {
/*     */         
/* 185 */         double d10 = (this.field_70146_Z.nextFloat() * 2.0F - 1.0F);
/*     */         
/* 187 */         double d11 = (this.field_70146_Z.nextInt(2) * 2 - 1) * 0.7D;
/* 188 */         if (this.field_70146_Z.nextBoolean()) {
/* 189 */           double d12 = this.field_70165_t - d8 * d10 * 0.8D + d9 * d11;
/* 190 */           double d13 = this.field_70161_v - d9 * d10 * 0.8D - d8 * d11;
/* 191 */           this.field_70170_p.func_72869_a("splash", d12, this.field_70163_u - 0.125D, d13, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */         } else {
/* 193 */           double d12 = this.field_70165_t + d8 + d9 * d10 * 0.7D;
/* 194 */           double d13 = this.field_70161_v + d9 - d8 * d10 * 0.7D;
/* 195 */           this.field_70170_p.func_72869_a("splash", d12, this.field_70163_u - 0.125D, d13, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 200 */     if (this.field_70170_p.field_72995_K && this.field_70279_a) {
/* 201 */       if (this.field_70277_c > 0) {
/* 202 */         double d8 = this.field_70165_t + (this.field_70274_d - this.field_70165_t) / this.field_70277_c;
/* 203 */         double d9 = this.field_70163_u + (this.field_70275_e - this.field_70163_u) / this.field_70277_c;
/* 204 */         double d10 = this.field_70161_v + (this.field_70272_f - this.field_70161_v) / this.field_70277_c;
/*     */         
/* 206 */         double d11 = MathHelper.func_76138_g(this.field_70273_g - this.field_70177_z);
/*     */         
/* 208 */         this.field_70177_z = (float)(this.field_70177_z + d11 / this.field_70277_c);
/* 209 */         this.field_70125_A = (float)(this.field_70125_A + (this.field_70281_h - this.field_70125_A) / this.field_70277_c);
/*     */         
/* 211 */         this.field_70277_c--;
/* 212 */         func_70107_b(d8, d9, d10);
/* 213 */         func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */       } else {
/* 215 */         double d8 = this.field_70165_t + this.field_70159_w;
/* 216 */         double d9 = this.field_70163_u + this.field_70181_x;
/* 217 */         double d10 = this.field_70161_v + this.field_70179_y;
/* 218 */         func_70107_b(d8, d9, d10);
/* 219 */         if (this.field_70122_E) {
/* 220 */           this.field_70159_w *= 0.5D;
/* 221 */           this.field_70181_x *= 0.5D;
/* 222 */           this.field_70179_y *= 0.5D;
/*     */         } 
/* 224 */         this.field_70159_w *= 0.9900000095367432D;
/* 225 */         this.field_70181_x *= 0.949999988079071D;
/* 226 */         this.field_70179_y *= 0.9900000095367432D;
/*     */       } 
/*     */       
/*     */       return;
/*     */     } 
/*     */     
/* 232 */     if (d1 < 1.0D) {
/* 233 */       double d = d1 * 2.0D - 1.0D;
/* 234 */       this.field_70181_x += 0.03999999910593033D * d;
/*     */     } else {
/* 236 */       if (this.field_70181_x < 0.0D) this.field_70181_x /= 2.0D; 
/* 237 */       this.field_70181_x += 0.007000000216066837D;
/*     */     } 
/*     */     
/* 240 */     if (this.field_70153_n != null && this.field_70153_n instanceof EntityLivingBase) {
/* 241 */       EntityLivingBase entityLivingBase = (EntityLivingBase)this.field_70153_n;
/* 242 */       float f = this.field_70153_n.field_70177_z + -entityLivingBase.field_70702_br * 90.0F;
/* 243 */       this.field_70159_w += -Math.sin((f * 3.1415927F / 180.0F)) * this.field_70276_b * entityLivingBase.field_70701_bs * 0.05000000074505806D;
/* 244 */       this.field_70179_y += Math.cos((f * 3.1415927F / 180.0F)) * this.field_70276_b * entityLivingBase.field_70701_bs * 0.05000000074505806D;
/*     */     } 
/*     */     
/* 247 */     double d3 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*     */     
/* 249 */     if (d3 > 0.35D) {
/* 250 */       double d = 0.35D / d3;
/*     */       
/* 252 */       this.field_70159_w *= d;
/* 253 */       this.field_70179_y *= d;
/* 254 */       d3 = 0.35D;
/*     */     } 
/*     */     
/* 257 */     if (d3 > d2 && this.field_70276_b < 0.35D) {
/* 258 */       this.field_70276_b += (0.35D - this.field_70276_b) / 35.0D;
/* 259 */       if (this.field_70276_b > 0.35D) this.field_70276_b = 0.35D; 
/*     */     } else {
/* 261 */       this.field_70276_b -= (this.field_70276_b - 0.07D) / 35.0D;
/* 262 */       if (this.field_70276_b < 0.07D) this.field_70276_b = 0.07D; 
/*     */     } 
/*     */     byte b3;
/* 265 */     for (b3 = 0; b3 < 4; b3++) {
/* 266 */       int i = MathHelper.func_76128_c(this.field_70165_t + ((b3 % 2) - 0.5D) * 0.8D);
/* 267 */       int j = MathHelper.func_76128_c(this.field_70161_v + ((b3 / 2) - 0.5D) * 0.8D);
/*     */       
/* 269 */       for (byte b = 0; b < 2; b++) {
/* 270 */         int k = MathHelper.func_76128_c(this.field_70163_u) + b;
/*     */         
/* 272 */         Block block = this.field_70170_p.func_147439_a(i, k, j);
/* 273 */         if (block == Blocks.field_150431_aC) {
/* 274 */           this.field_70170_p.func_147468_f(i, k, j);
/* 275 */           this.field_70123_F = false;
/* 276 */         } else if (block == Blocks.field_150392_bi) {
/* 277 */           this.field_70170_p.func_147480_a(i, k, j, true);
/* 278 */           this.field_70123_F = false;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 283 */     if (this.field_70122_E) {
/* 284 */       this.field_70159_w *= 0.5D;
/* 285 */       this.field_70181_x *= 0.5D;
/* 286 */       this.field_70179_y *= 0.5D;
/*     */     } 
/* 288 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */     
/* 290 */     if (this.field_70123_F && d2 > 0.2D) {
/* 291 */       if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
/* 292 */         func_70106_y();
/* 293 */         for (b3 = 0; b3 < 3; b3++) {
/* 294 */           func_145778_a(Item.func_150898_a(Blocks.field_150344_f), 1, 0.0F);
/*     */         }
/* 296 */         for (b3 = 0; b3 < 2; b3++) {
/* 297 */           func_145778_a(Items.field_151055_y, 1, 0.0F);
/*     */         }
/*     */       } 
/*     */     } else {
/* 301 */       this.field_70159_w *= 0.9900000095367432D;
/* 302 */       this.field_70181_x *= 0.949999988079071D;
/* 303 */       this.field_70179_y *= 0.9900000095367432D;
/*     */     } 
/*     */     
/* 306 */     this.field_70125_A = 0.0F;
/* 307 */     double d4 = this.field_70177_z;
/* 308 */     double d5 = this.field_70169_q - this.field_70165_t;
/* 309 */     double d6 = this.field_70166_s - this.field_70161_v;
/* 310 */     if (d5 * d5 + d6 * d6 > 0.001D) {
/* 311 */       d4 = (float)(Math.atan2(d6, d5) * 180.0D / Math.PI);
/*     */     }
/*     */     
/* 314 */     double d7 = MathHelper.func_76138_g(d4 - this.field_70177_z);
/*     */     
/* 316 */     if (d7 > 20.0D) d7 = 20.0D; 
/* 317 */     if (d7 < -20.0D) d7 = -20.0D;
/*     */     
/* 319 */     this.field_70177_z = (float)(this.field_70177_z + d7);
/* 320 */     func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */     
/* 322 */     if (this.field_70170_p.field_72995_K)
/*     */       return; 
/* 324 */     List<Entity> list = this.field_70170_p.func_72839_b(this, this.field_70121_D.func_72314_b(0.20000000298023224D, 0.0D, 0.20000000298023224D));
/* 325 */     if (list != null && !list.isEmpty()) {
/* 326 */       for (byte b = 0; b < list.size(); b++) {
/* 327 */         Entity entity = list.get(b);
/* 328 */         if (entity != this.field_70153_n && entity.func_70104_M() && entity instanceof EntityBoat) {
/* 329 */           entity.func_70108_f(this);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 334 */     if (this.field_70153_n != null && 
/* 335 */       this.field_70153_n.field_70128_L) this.field_70153_n = null;
/*     */   
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70043_V() {
/* 341 */     if (this.field_70153_n == null)
/*     */       return; 
/* 343 */     double d1 = Math.cos(this.field_70177_z * Math.PI / 180.0D) * 0.4D;
/* 344 */     double d2 = Math.sin(this.field_70177_z * Math.PI / 180.0D) * 0.4D;
/* 345 */     this.field_70153_n.func_70107_b(this.field_70165_t + d1, this.field_70163_u + func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v + d2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound p_70014_1_) {}
/*     */ 
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound p_70037_1_) {}
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 358 */     return 0.0F;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean func_130002_c(EntityPlayer p_130002_1_) {
/* 363 */     if (this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer && this.field_70153_n != p_130002_1_) return true; 
/* 364 */     if (!this.field_70170_p.field_72995_K) {
/* 365 */       p_130002_1_.func_70078_a(this);
/*     */     }
/* 367 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70064_a(double p_70064_1_, boolean p_70064_3_) {
/* 372 */     int i = MathHelper.func_76128_c(this.field_70165_t);
/* 373 */     int j = MathHelper.func_76128_c(this.field_70163_u);
/* 374 */     int k = MathHelper.func_76128_c(this.field_70161_v);
/* 375 */     if (p_70064_3_)
/* 376 */     { if (this.field_70143_R > 3.0F) {
/* 377 */         func_70069_a(this.field_70143_R);
/* 378 */         if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
/* 379 */           func_70106_y(); byte b;
/* 380 */           for (b = 0; b < 3; b++) {
/* 381 */             func_145778_a(Item.func_150898_a(Blocks.field_150344_f), 1, 0.0F);
/*     */           }
/* 383 */           for (b = 0; b < 2; b++) {
/* 384 */             func_145778_a(Items.field_151055_y, 1, 0.0F);
/*     */           }
/*     */         } 
/* 387 */         this.field_70143_R = 0.0F;
/*     */       }  }
/* 389 */     else if (this.field_70170_p.func_147439_a(i, j - 1, k).func_149688_o() != Material.field_151586_h && 
/* 390 */       p_70064_1_ < 0.0D) { this.field_70143_R = (float)(this.field_70143_R - p_70064_1_); }
/*     */   
/*     */   }
/*     */   
/*     */   public void func_70266_a(float p_70266_1_) {
/* 395 */     this.field_70180_af.func_75692_b(19, Float.valueOf(p_70266_1_));
/*     */   }
/*     */   
/*     */   public float func_70271_g() {
/* 399 */     return this.field_70180_af.func_111145_d(19);
/*     */   }
/*     */   
/*     */   public void func_70265_b(int p_70265_1_) {
/* 403 */     this.field_70180_af.func_75692_b(17, Integer.valueOf(p_70265_1_));
/*     */   }
/*     */   
/*     */   public int func_70268_h() {
/* 407 */     return this.field_70180_af.func_75679_c(17);
/*     */   }
/*     */   
/*     */   public void func_70269_c(int p_70269_1_) {
/* 411 */     this.field_70180_af.func_75692_b(18, Integer.valueOf(p_70269_1_));
/*     */   }
/*     */   
/*     */   public int func_70267_i() {
/* 415 */     return this.field_70180_af.func_75679_c(18);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70270_d(boolean p_70270_1_) {
/* 423 */     this.field_70279_a = p_70270_1_;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\entity\item\EntityBoat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */