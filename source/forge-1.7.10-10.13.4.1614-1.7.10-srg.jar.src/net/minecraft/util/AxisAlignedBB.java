/*     */ package net.minecraft.util;
/*     */ 
/*     */ public class AxisAlignedBB {
/*     */   public double field_72340_a;
/*     */   public double field_72338_b;
/*     */   public double field_72339_c;
/*     */   
/*     */   public static AxisAlignedBB func_72330_a(double p_72330_0_, double p_72330_2_, double p_72330_4_, double p_72330_6_, double p_72330_8_, double p_72330_10_) {
/*   9 */     return new AxisAlignedBB(p_72330_0_, p_72330_2_, p_72330_4_, p_72330_6_, p_72330_8_, p_72330_10_);
/*     */   }
/*     */   public double field_72336_d; public double field_72337_e; public double field_72334_f; private static final String __OBFID = "CL_00000607";
/*     */   protected AxisAlignedBB(double p_i2300_1_, double p_i2300_3_, double p_i2300_5_, double p_i2300_7_, double p_i2300_9_, double p_i2300_11_) {
/*  13 */     this.field_72340_a = p_i2300_1_;
/*  14 */     this.field_72338_b = p_i2300_3_;
/*  15 */     this.field_72339_c = p_i2300_5_;
/*  16 */     this.field_72336_d = p_i2300_7_;
/*  17 */     this.field_72337_e = p_i2300_9_;
/*  18 */     this.field_72334_f = p_i2300_11_;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_72324_b(double p_72324_1_, double p_72324_3_, double p_72324_5_, double p_72324_7_, double p_72324_9_, double p_72324_11_) {
/*  22 */     this.field_72340_a = p_72324_1_;
/*  23 */     this.field_72338_b = p_72324_3_;
/*  24 */     this.field_72339_c = p_72324_5_;
/*  25 */     this.field_72336_d = p_72324_7_;
/*  26 */     this.field_72337_e = p_72324_9_;
/*  27 */     this.field_72334_f = p_72324_11_;
/*  28 */     return this;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_72321_a(double p_72321_1_, double p_72321_3_, double p_72321_5_) {
/*  32 */     double d1 = this.field_72340_a;
/*  33 */     double d2 = this.field_72338_b;
/*  34 */     double d3 = this.field_72339_c;
/*  35 */     double d4 = this.field_72336_d;
/*  36 */     double d5 = this.field_72337_e;
/*  37 */     double d6 = this.field_72334_f;
/*     */     
/*  39 */     if (p_72321_1_ < 0.0D) d1 += p_72321_1_; 
/*  40 */     if (p_72321_1_ > 0.0D) d4 += p_72321_1_;
/*     */     
/*  42 */     if (p_72321_3_ < 0.0D) d2 += p_72321_3_; 
/*  43 */     if (p_72321_3_ > 0.0D) d5 += p_72321_3_;
/*     */     
/*  45 */     if (p_72321_5_ < 0.0D) d3 += p_72321_5_; 
/*  46 */     if (p_72321_5_ > 0.0D) d6 += p_72321_5_;
/*     */     
/*  48 */     return func_72330_a(d1, d2, d3, d4, d5, d6);
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_72314_b(double p_72314_1_, double p_72314_3_, double p_72314_5_) {
/*  52 */     double d1 = this.field_72340_a - p_72314_1_;
/*  53 */     double d2 = this.field_72338_b - p_72314_3_;
/*  54 */     double d3 = this.field_72339_c - p_72314_5_;
/*  55 */     double d4 = this.field_72336_d + p_72314_1_;
/*  56 */     double d5 = this.field_72337_e + p_72314_3_;
/*  57 */     double d6 = this.field_72334_f + p_72314_5_;
/*     */     
/*  59 */     return func_72330_a(d1, d2, d3, d4, d5, d6);
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_111270_a(AxisAlignedBB p_111270_1_) {
/*  63 */     double d1 = Math.min(this.field_72340_a, p_111270_1_.field_72340_a);
/*  64 */     double d2 = Math.min(this.field_72338_b, p_111270_1_.field_72338_b);
/*  65 */     double d3 = Math.min(this.field_72339_c, p_111270_1_.field_72339_c);
/*  66 */     double d4 = Math.max(this.field_72336_d, p_111270_1_.field_72336_d);
/*  67 */     double d5 = Math.max(this.field_72337_e, p_111270_1_.field_72337_e);
/*  68 */     double d6 = Math.max(this.field_72334_f, p_111270_1_.field_72334_f);
/*     */     
/*  70 */     return func_72330_a(d1, d2, d3, d4, d5, d6);
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_72325_c(double p_72325_1_, double p_72325_3_, double p_72325_5_) {
/*  74 */     return func_72330_a(this.field_72340_a + p_72325_1_, this.field_72338_b + p_72325_3_, this.field_72339_c + p_72325_5_, this.field_72336_d + p_72325_1_, this.field_72337_e + p_72325_3_, this.field_72334_f + p_72325_5_);
/*     */   }
/*     */   
/*     */   public double func_72316_a(AxisAlignedBB p_72316_1_, double p_72316_2_) {
/*  78 */     if (p_72316_1_.field_72337_e <= this.field_72338_b || p_72316_1_.field_72338_b >= this.field_72337_e) return p_72316_2_; 
/*  79 */     if (p_72316_1_.field_72334_f <= this.field_72339_c || p_72316_1_.field_72339_c >= this.field_72334_f) return p_72316_2_;
/*     */     
/*  81 */     if (p_72316_2_ > 0.0D && p_72316_1_.field_72336_d <= this.field_72340_a) {
/*  82 */       double d = this.field_72340_a - p_72316_1_.field_72336_d;
/*  83 */       if (d < p_72316_2_) p_72316_2_ = d; 
/*     */     } 
/*  85 */     if (p_72316_2_ < 0.0D && p_72316_1_.field_72340_a >= this.field_72336_d) {
/*  86 */       double d = this.field_72336_d - p_72316_1_.field_72340_a;
/*  87 */       if (d > p_72316_2_) p_72316_2_ = d;
/*     */     
/*     */     } 
/*  90 */     return p_72316_2_;
/*     */   }
/*     */   
/*     */   public double func_72323_b(AxisAlignedBB p_72323_1_, double p_72323_2_) {
/*  94 */     if (p_72323_1_.field_72336_d <= this.field_72340_a || p_72323_1_.field_72340_a >= this.field_72336_d) return p_72323_2_; 
/*  95 */     if (p_72323_1_.field_72334_f <= this.field_72339_c || p_72323_1_.field_72339_c >= this.field_72334_f) return p_72323_2_;
/*     */     
/*  97 */     if (p_72323_2_ > 0.0D && p_72323_1_.field_72337_e <= this.field_72338_b) {
/*  98 */       double d = this.field_72338_b - p_72323_1_.field_72337_e;
/*  99 */       if (d < p_72323_2_) p_72323_2_ = d; 
/*     */     } 
/* 101 */     if (p_72323_2_ < 0.0D && p_72323_1_.field_72338_b >= this.field_72337_e) {
/* 102 */       double d = this.field_72337_e - p_72323_1_.field_72338_b;
/* 103 */       if (d > p_72323_2_) p_72323_2_ = d;
/*     */     
/*     */     } 
/* 106 */     return p_72323_2_;
/*     */   }
/*     */   
/*     */   public double func_72322_c(AxisAlignedBB p_72322_1_, double p_72322_2_) {
/* 110 */     if (p_72322_1_.field_72336_d <= this.field_72340_a || p_72322_1_.field_72340_a >= this.field_72336_d) return p_72322_2_; 
/* 111 */     if (p_72322_1_.field_72337_e <= this.field_72338_b || p_72322_1_.field_72338_b >= this.field_72337_e) return p_72322_2_;
/*     */     
/* 113 */     if (p_72322_2_ > 0.0D && p_72322_1_.field_72334_f <= this.field_72339_c) {
/* 114 */       double d = this.field_72339_c - p_72322_1_.field_72334_f;
/* 115 */       if (d < p_72322_2_) p_72322_2_ = d; 
/*     */     } 
/* 117 */     if (p_72322_2_ < 0.0D && p_72322_1_.field_72339_c >= this.field_72334_f) {
/* 118 */       double d = this.field_72334_f - p_72322_1_.field_72339_c;
/* 119 */       if (d > p_72322_2_) p_72322_2_ = d;
/*     */     
/*     */     } 
/* 122 */     return p_72322_2_;
/*     */   }
/*     */   
/*     */   public boolean func_72326_a(AxisAlignedBB p_72326_1_) {
/* 126 */     if (p_72326_1_.field_72336_d <= this.field_72340_a || p_72326_1_.field_72340_a >= this.field_72336_d) return false; 
/* 127 */     if (p_72326_1_.field_72337_e <= this.field_72338_b || p_72326_1_.field_72338_b >= this.field_72337_e) return false; 
/* 128 */     if (p_72326_1_.field_72334_f <= this.field_72339_c || p_72326_1_.field_72339_c >= this.field_72334_f) return false; 
/* 129 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public AxisAlignedBB func_72317_d(double p_72317_1_, double p_72317_3_, double p_72317_5_) {
/* 140 */     this.field_72340_a += p_72317_1_;
/* 141 */     this.field_72338_b += p_72317_3_;
/* 142 */     this.field_72339_c += p_72317_5_;
/* 143 */     this.field_72336_d += p_72317_1_;
/* 144 */     this.field_72337_e += p_72317_3_;
/* 145 */     this.field_72334_f += p_72317_5_;
/* 146 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_72318_a(Vec3 p_72318_1_) {
/* 157 */     if (p_72318_1_.field_72450_a <= this.field_72340_a || p_72318_1_.field_72450_a >= this.field_72336_d) return false; 
/* 158 */     if (p_72318_1_.field_72448_b <= this.field_72338_b || p_72318_1_.field_72448_b >= this.field_72337_e) return false; 
/* 159 */     if (p_72318_1_.field_72449_c <= this.field_72339_c || p_72318_1_.field_72449_c >= this.field_72334_f) return false; 
/* 160 */     return true;
/*     */   }
/*     */   
/*     */   public double func_72320_b() {
/* 164 */     double d1 = this.field_72336_d - this.field_72340_a;
/* 165 */     double d2 = this.field_72337_e - this.field_72338_b;
/* 166 */     double d3 = this.field_72334_f - this.field_72339_c;
/* 167 */     return (d1 + d2 + d3) / 3.0D;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_72331_e(double p_72331_1_, double p_72331_3_, double p_72331_5_) {
/* 171 */     double d1 = this.field_72340_a + p_72331_1_;
/* 172 */     double d2 = this.field_72338_b + p_72331_3_;
/* 173 */     double d3 = this.field_72339_c + p_72331_5_;
/* 174 */     double d4 = this.field_72336_d - p_72331_1_;
/* 175 */     double d5 = this.field_72337_e - p_72331_3_;
/* 176 */     double d6 = this.field_72334_f - p_72331_5_;
/*     */     
/* 178 */     return func_72330_a(d1, d2, d3, d4, d5, d6);
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_72329_c() {
/* 182 */     return func_72330_a(this.field_72340_a, this.field_72338_b, this.field_72339_c, this.field_72336_d, this.field_72337_e, this.field_72334_f);
/*     */   }
/*     */   
/*     */   public MovingObjectPosition func_72327_a(Vec3 p_72327_1_, Vec3 p_72327_2_) {
/* 186 */     Vec3 vec31 = p_72327_1_.func_72429_b(p_72327_2_, this.field_72340_a);
/* 187 */     Vec3 vec32 = p_72327_1_.func_72429_b(p_72327_2_, this.field_72336_d);
/*     */     
/* 189 */     Vec3 vec33 = p_72327_1_.func_72435_c(p_72327_2_, this.field_72338_b);
/* 190 */     Vec3 vec34 = p_72327_1_.func_72435_c(p_72327_2_, this.field_72337_e);
/*     */     
/* 192 */     Vec3 vec35 = p_72327_1_.func_72434_d(p_72327_2_, this.field_72339_c);
/* 193 */     Vec3 vec36 = p_72327_1_.func_72434_d(p_72327_2_, this.field_72334_f);
/*     */     
/* 195 */     if (!func_72333_b(vec31)) vec31 = null; 
/* 196 */     if (!func_72333_b(vec32)) vec32 = null; 
/* 197 */     if (!func_72315_c(vec33)) vec33 = null; 
/* 198 */     if (!func_72315_c(vec34)) vec34 = null; 
/* 199 */     if (!func_72319_d(vec35)) vec35 = null; 
/* 200 */     if (!func_72319_d(vec36)) vec36 = null;
/*     */     
/* 202 */     Vec3 vec37 = null;
/*     */     
/* 204 */     if (vec31 != null && (vec37 == null || p_72327_1_.func_72436_e(vec31) < p_72327_1_.func_72436_e(vec37))) vec37 = vec31; 
/* 205 */     if (vec32 != null && (vec37 == null || p_72327_1_.func_72436_e(vec32) < p_72327_1_.func_72436_e(vec37))) vec37 = vec32; 
/* 206 */     if (vec33 != null && (vec37 == null || p_72327_1_.func_72436_e(vec33) < p_72327_1_.func_72436_e(vec37))) vec37 = vec33; 
/* 207 */     if (vec34 != null && (vec37 == null || p_72327_1_.func_72436_e(vec34) < p_72327_1_.func_72436_e(vec37))) vec37 = vec34; 
/* 208 */     if (vec35 != null && (vec37 == null || p_72327_1_.func_72436_e(vec35) < p_72327_1_.func_72436_e(vec37))) vec37 = vec35; 
/* 209 */     if (vec36 != null && (vec37 == null || p_72327_1_.func_72436_e(vec36) < p_72327_1_.func_72436_e(vec37))) vec37 = vec36;
/*     */     
/* 211 */     if (vec37 == null) return null;
/*     */     
/* 213 */     byte b = -1;
/*     */     
/* 215 */     if (vec37 == vec31) b = 4; 
/* 216 */     if (vec37 == vec32) b = 5; 
/* 217 */     if (vec37 == vec33) b = 0; 
/* 218 */     if (vec37 == vec34) b = 1; 
/* 219 */     if (vec37 == vec35) b = 2; 
/* 220 */     if (vec37 == vec36) b = 3;
/*     */     
/* 222 */     return new MovingObjectPosition(0, 0, 0, b, vec37);
/*     */   }
/*     */   
/*     */   private boolean func_72333_b(Vec3 p_72333_1_) {
/* 226 */     if (p_72333_1_ == null) return false; 
/* 227 */     return (p_72333_1_.field_72448_b >= this.field_72338_b && p_72333_1_.field_72448_b <= this.field_72337_e && p_72333_1_.field_72449_c >= this.field_72339_c && p_72333_1_.field_72449_c <= this.field_72334_f);
/*     */   }
/*     */   
/*     */   private boolean func_72315_c(Vec3 p_72315_1_) {
/* 231 */     if (p_72315_1_ == null) return false; 
/* 232 */     return (p_72315_1_.field_72450_a >= this.field_72340_a && p_72315_1_.field_72450_a <= this.field_72336_d && p_72315_1_.field_72449_c >= this.field_72339_c && p_72315_1_.field_72449_c <= this.field_72334_f);
/*     */   }
/*     */   
/*     */   private boolean func_72319_d(Vec3 p_72319_1_) {
/* 236 */     if (p_72319_1_ == null) return false; 
/* 237 */     return (p_72319_1_.field_72450_a >= this.field_72340_a && p_72319_1_.field_72450_a <= this.field_72336_d && p_72319_1_.field_72448_b >= this.field_72338_b && p_72319_1_.field_72448_b <= this.field_72337_e);
/*     */   }
/*     */   
/*     */   public void func_72328_c(AxisAlignedBB p_72328_1_) {
/* 241 */     this.field_72340_a = p_72328_1_.field_72340_a;
/* 242 */     this.field_72338_b = p_72328_1_.field_72338_b;
/* 243 */     this.field_72339_c = p_72328_1_.field_72339_c;
/* 244 */     this.field_72336_d = p_72328_1_.field_72336_d;
/* 245 */     this.field_72337_e = p_72328_1_.field_72337_e;
/* 246 */     this.field_72334_f = p_72328_1_.field_72334_f;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 250 */     return "box[" + this.field_72340_a + ", " + this.field_72338_b + ", " + this.field_72339_c + " -> " + this.field_72336_d + ", " + this.field_72337_e + ", " + this.field_72334_f + "]";
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\AxisAlignedBB.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */