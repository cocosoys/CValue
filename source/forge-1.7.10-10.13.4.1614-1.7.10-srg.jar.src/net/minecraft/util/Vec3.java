/*     */ package net.minecraft.util;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ 
/*     */ public class Vec3 {
/*     */   public double field_72450_a;
/*     */   
/*     */   public static Vec3 func_72443_a(double p_72443_0_, double p_72443_2_, double p_72443_4_) {
/*   8 */     return new Vec3(p_72443_0_, p_72443_2_, p_72443_4_);
/*     */   }
/*     */   public double field_72448_b; public double field_72449_c;
/*     */   private static final String __OBFID = "CL_00000612";
/*     */   
/*     */   protected Vec3(double p_i1108_1_, double p_i1108_3_, double p_i1108_5_) {
/*  14 */     if (p_i1108_1_ == -0.0D) p_i1108_1_ = 0.0D; 
/*  15 */     if (p_i1108_3_ == -0.0D) p_i1108_3_ = 0.0D; 
/*  16 */     if (p_i1108_5_ == -0.0D) p_i1108_5_ = 0.0D; 
/*  17 */     this.field_72450_a = p_i1108_1_;
/*  18 */     this.field_72448_b = p_i1108_3_;
/*  19 */     this.field_72449_c = p_i1108_5_;
/*     */   }
/*     */   
/*     */   protected Vec3 func_72439_b(double p_72439_1_, double p_72439_3_, double p_72439_5_) {
/*  23 */     this.field_72450_a = p_72439_1_;
/*  24 */     this.field_72448_b = p_72439_3_;
/*  25 */     this.field_72449_c = p_72439_5_;
/*  26 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Vec3 func_72444_a(Vec3 p_72444_1_) {
/*  38 */     return func_72443_a(p_72444_1_.field_72450_a - this.field_72450_a, p_72444_1_.field_72448_b - this.field_72448_b, p_72444_1_.field_72449_c - this.field_72449_c);
/*     */   }
/*     */   
/*     */   public Vec3 func_72432_b() {
/*  42 */     double d = MathHelper.func_76133_a(this.field_72450_a * this.field_72450_a + this.field_72448_b * this.field_72448_b + this.field_72449_c * this.field_72449_c);
/*  43 */     if (d < 1.0E-4D) return func_72443_a(0.0D, 0.0D, 0.0D); 
/*  44 */     return func_72443_a(this.field_72450_a / d, this.field_72448_b / d, this.field_72449_c / d);
/*     */   }
/*     */   
/*     */   public double func_72430_b(Vec3 p_72430_1_) {
/*  48 */     return this.field_72450_a * p_72430_1_.field_72450_a + this.field_72448_b * p_72430_1_.field_72448_b + this.field_72449_c * p_72430_1_.field_72449_c;
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public Vec3 func_72431_c(Vec3 p_72431_1_) {
/*  52 */     return func_72443_a(this.field_72448_b * p_72431_1_.field_72449_c - this.field_72449_c * p_72431_1_.field_72448_b, this.field_72449_c * p_72431_1_.field_72450_a - this.field_72450_a * p_72431_1_.field_72449_c, this.field_72450_a * p_72431_1_.field_72448_b - this.field_72448_b * p_72431_1_.field_72450_a);
/*     */   }
/*     */   
/*     */   public Vec3 func_72441_c(double p_72441_1_, double p_72441_3_, double p_72441_5_) {
/*  56 */     return func_72443_a(this.field_72450_a + p_72441_1_, this.field_72448_b + p_72441_3_, this.field_72449_c + p_72441_5_);
/*     */   }
/*     */   
/*     */   public double func_72438_d(Vec3 p_72438_1_) {
/*  60 */     double d1 = p_72438_1_.field_72450_a - this.field_72450_a;
/*  61 */     double d2 = p_72438_1_.field_72448_b - this.field_72448_b;
/*  62 */     double d3 = p_72438_1_.field_72449_c - this.field_72449_c;
/*  63 */     return MathHelper.func_76133_a(d1 * d1 + d2 * d2 + d3 * d3);
/*     */   }
/*     */   
/*     */   public double func_72436_e(Vec3 p_72436_1_) {
/*  67 */     double d1 = p_72436_1_.field_72450_a - this.field_72450_a;
/*  68 */     double d2 = p_72436_1_.field_72448_b - this.field_72448_b;
/*  69 */     double d3 = p_72436_1_.field_72449_c - this.field_72449_c;
/*  70 */     return d1 * d1 + d2 * d2 + d3 * d3;
/*     */   }
/*     */   
/*     */   public double func_72445_d(double p_72445_1_, double p_72445_3_, double p_72445_5_) {
/*  74 */     double d1 = p_72445_1_ - this.field_72450_a;
/*  75 */     double d2 = p_72445_3_ - this.field_72448_b;
/*  76 */     double d3 = p_72445_5_ - this.field_72449_c;
/*  77 */     return d1 * d1 + d2 * d2 + d3 * d3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double func_72433_c() {
/*  85 */     return MathHelper.func_76133_a(this.field_72450_a * this.field_72450_a + this.field_72448_b * this.field_72448_b + this.field_72449_c * this.field_72449_c);
/*     */   }
/*     */   
/*     */   public Vec3 func_72429_b(Vec3 p_72429_1_, double p_72429_2_) {
/*  89 */     double d1 = p_72429_1_.field_72450_a - this.field_72450_a;
/*  90 */     double d2 = p_72429_1_.field_72448_b - this.field_72448_b;
/*  91 */     double d3 = p_72429_1_.field_72449_c - this.field_72449_c;
/*     */     
/*  93 */     if (d1 * d1 < 1.0000000116860974E-7D) return null;
/*     */     
/*  95 */     double d4 = (p_72429_2_ - this.field_72450_a) / d1;
/*  96 */     if (d4 < 0.0D || d4 > 1.0D) return null; 
/*  97 */     return func_72443_a(this.field_72450_a + d1 * d4, this.field_72448_b + d2 * d4, this.field_72449_c + d3 * d4);
/*     */   }
/*     */   
/*     */   public Vec3 func_72435_c(Vec3 p_72435_1_, double p_72435_2_) {
/* 101 */     double d1 = p_72435_1_.field_72450_a - this.field_72450_a;
/* 102 */     double d2 = p_72435_1_.field_72448_b - this.field_72448_b;
/* 103 */     double d3 = p_72435_1_.field_72449_c - this.field_72449_c;
/*     */     
/* 105 */     if (d2 * d2 < 1.0000000116860974E-7D) return null;
/*     */     
/* 107 */     double d4 = (p_72435_2_ - this.field_72448_b) / d2;
/* 108 */     if (d4 < 0.0D || d4 > 1.0D) return null; 
/* 109 */     return func_72443_a(this.field_72450_a + d1 * d4, this.field_72448_b + d2 * d4, this.field_72449_c + d3 * d4);
/*     */   }
/*     */   
/*     */   public Vec3 func_72434_d(Vec3 p_72434_1_, double p_72434_2_) {
/* 113 */     double d1 = p_72434_1_.field_72450_a - this.field_72450_a;
/* 114 */     double d2 = p_72434_1_.field_72448_b - this.field_72448_b;
/* 115 */     double d3 = p_72434_1_.field_72449_c - this.field_72449_c;
/*     */     
/* 117 */     if (d3 * d3 < 1.0000000116860974E-7D) return null;
/*     */     
/* 119 */     double d4 = (p_72434_2_ - this.field_72449_c) / d3;
/* 120 */     if (d4 < 0.0D || d4 > 1.0D) return null; 
/* 121 */     return func_72443_a(this.field_72450_a + d1 * d4, this.field_72448_b + d2 * d4, this.field_72449_c + d3 * d4);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 125 */     return "(" + this.field_72450_a + ", " + this.field_72448_b + ", " + this.field_72449_c + ")";
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_72440_a(float p_72440_1_) {
/* 133 */     float f1 = MathHelper.func_76134_b(p_72440_1_);
/* 134 */     float f2 = MathHelper.func_76126_a(p_72440_1_);
/*     */     
/* 136 */     double d1 = this.field_72450_a;
/* 137 */     double d2 = this.field_72448_b * f1 + this.field_72449_c * f2;
/* 138 */     double d3 = this.field_72449_c * f1 - this.field_72448_b * f2;
/*     */     
/* 140 */     func_72439_b(d1, d2, d3);
/*     */   }
/*     */   
/*     */   public void func_72442_b(float p_72442_1_) {
/* 144 */     float f1 = MathHelper.func_76134_b(p_72442_1_);
/* 145 */     float f2 = MathHelper.func_76126_a(p_72442_1_);
/*     */     
/* 147 */     double d1 = this.field_72450_a * f1 + this.field_72449_c * f2;
/* 148 */     double d2 = this.field_72448_b;
/* 149 */     double d3 = this.field_72449_c * f1 - this.field_72450_a * f2;
/*     */     
/* 151 */     func_72439_b(d1, d2, d3);
/*     */   }
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_72446_c(float p_72446_1_) {
/* 155 */     float f1 = MathHelper.func_76134_b(p_72446_1_);
/* 156 */     float f2 = MathHelper.func_76126_a(p_72446_1_);
/*     */     
/* 158 */     double d1 = this.field_72450_a * f1 + this.field_72448_b * f2;
/* 159 */     double d2 = this.field_72448_b * f1 - this.field_72450_a * f2;
/* 160 */     double d3 = this.field_72449_c;
/*     */     
/* 162 */     func_72439_b(d1, d2, d3);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\Vec3.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */