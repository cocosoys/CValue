/*    */ package net.minecraft.world.gen;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NoiseGeneratorOctaves
/*    */   extends NoiseGenerator
/*    */ {
/*    */   private NoiseGeneratorImproved[] field_76307_a;
/*    */   private int field_76306_b;
/*    */   private static final String __OBFID = "CL_00000535";
/*    */   
/*    */   public NoiseGeneratorOctaves(Random p_i2111_1_, int p_i2111_2_) {
/* 16 */     this.field_76306_b = p_i2111_2_;
/* 17 */     this.field_76307_a = new NoiseGeneratorImproved[p_i2111_2_];
/* 18 */     for (byte b = 0; b < p_i2111_2_; b++) {
/* 19 */       this.field_76307_a[b] = new NoiseGeneratorImproved(p_i2111_1_);
/*    */     }
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
/*    */   public double[] func_76304_a(double[] p_76304_1_, int p_76304_2_, int p_76304_3_, int p_76304_4_, int p_76304_5_, int p_76304_6_, int p_76304_7_, double p_76304_8_, double p_76304_10_, double p_76304_12_) {
/* 49 */     if (p_76304_1_ == null) { p_76304_1_ = new double[p_76304_5_ * p_76304_6_ * p_76304_7_]; }
/* 50 */     else { for (byte b1 = 0; b1 < p_76304_1_.length; b1++)
/* 51 */         p_76304_1_[b1] = 0.0D;  }
/*    */     
/* 53 */     double d = 1.0D;
/*    */     
/* 55 */     for (byte b = 0; b < this.field_76306_b; b++) {
/* 56 */       double d1 = p_76304_2_ * d * p_76304_8_;
/* 57 */       double d2 = p_76304_3_ * d * p_76304_10_;
/* 58 */       double d3 = p_76304_4_ * d * p_76304_12_;
/* 59 */       long l1 = MathHelper.func_76124_d(d1);
/* 60 */       long l2 = MathHelper.func_76124_d(d3);
/* 61 */       d1 -= l1;
/* 62 */       d3 -= l2;
/* 63 */       l1 %= 16777216L;
/* 64 */       l2 %= 16777216L;
/* 65 */       d1 += l1;
/* 66 */       d3 += l2;
/* 67 */       this.field_76307_a[b].func_76308_a(p_76304_1_, d1, d2, d3, p_76304_5_, p_76304_6_, p_76304_7_, p_76304_8_ * d, p_76304_10_ * d, p_76304_12_ * d, d);
/* 68 */       d /= 2.0D;
/*    */     } 
/*    */     
/* 71 */     return p_76304_1_;
/*    */   }
/*    */   
/*    */   public double[] func_76305_a(double[] p_76305_1_, int p_76305_2_, int p_76305_3_, int p_76305_4_, int p_76305_5_, double p_76305_6_, double p_76305_8_, double p_76305_10_) {
/* 75 */     return func_76304_a(p_76305_1_, p_76305_2_, 10, p_76305_3_, p_76305_4_, 1, p_76305_5_, p_76305_6_, 1.0D, p_76305_8_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\NoiseGeneratorOctaves.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */