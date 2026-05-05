/*    */ package net.minecraft.world.gen;
/*    */ 
/*    */ import java.util.Random;
/*    */ 
/*    */ 
/*    */ public class NoiseGeneratorPerlin
/*    */   extends NoiseGenerator
/*    */ {
/*    */   private NoiseGeneratorSimplex[] field_151603_a;
/*    */   private int field_151602_b;
/*    */   private static final String __OBFID = "CL_00000536";
/*    */   
/*    */   public NoiseGeneratorPerlin(Random p_i45470_1_, int p_i45470_2_) {
/* 14 */     this.field_151602_b = p_i45470_2_;
/* 15 */     this.field_151603_a = new NoiseGeneratorSimplex[p_i45470_2_];
/* 16 */     for (byte b = 0; b < p_i45470_2_; b++) {
/* 17 */       this.field_151603_a[b] = new NoiseGeneratorSimplex(p_i45470_1_);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public double func_151601_a(double p_151601_1_, double p_151601_3_) {
/* 23 */     double d1 = 0.0D;
/* 24 */     double d2 = 1.0D;
/*    */     
/* 26 */     for (byte b = 0; b < this.field_151602_b; b++) {
/* 27 */       d1 += this.field_151603_a[b].func_151605_a(p_151601_1_ * d2, p_151601_3_ * d2) / d2;
/* 28 */       d2 /= 2.0D;
/*    */     } 
/*    */     
/* 31 */     return d1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public double[] func_151599_a(double[] p_151599_1_, double p_151599_2_, double p_151599_4_, int p_151599_6_, int p_151599_7_, double p_151599_8_, double p_151599_10_, double p_151599_12_) {
/* 47 */     return func_151600_a(p_151599_1_, p_151599_2_, p_151599_4_, p_151599_6_, p_151599_7_, p_151599_8_, p_151599_10_, p_151599_12_, 0.5D);
/*    */   }
/*    */ 
/*    */   
/*    */   public double[] func_151600_a(double[] p_151600_1_, double p_151600_2_, double p_151600_4_, int p_151600_6_, int p_151600_7_, double p_151600_8_, double p_151600_10_, double p_151600_12_, double p_151600_14_) {
/* 52 */     if (p_151600_1_ == null || p_151600_1_.length < p_151600_6_ * p_151600_7_) { p_151600_1_ = new double[p_151600_6_ * p_151600_7_]; }
/* 53 */     else { for (byte b1 = 0; b1 < p_151600_1_.length; b1++)
/* 54 */         p_151600_1_[b1] = 0.0D;  }
/*    */     
/* 56 */     double d1 = 1.0D;
/* 57 */     double d2 = 1.0D;
/* 58 */     for (byte b = 0; b < this.field_151602_b; b++) {
/* 59 */       this.field_151603_a[b].func_151606_a(p_151600_1_, p_151600_2_, p_151600_4_, p_151600_6_, p_151600_7_, p_151600_8_ * d2 * d1, p_151600_10_ * d2 * d1, 0.55D / d1);
/* 60 */       d2 *= p_151600_12_;
/* 61 */       d1 *= p_151600_14_;
/*    */     } 
/*    */     
/* 64 */     return p_151600_1_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\NoiseGeneratorPerlin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */