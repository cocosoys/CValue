/*    */ package net.minecraft.pathfinding;
/*    */ import net.minecraft.util.MathHelper;
/*    */ 
/*    */ public class PathPoint {
/*    */   public final int field_75839_a;
/*    */   public final int field_75837_b;
/*    */   public final int field_75838_c;
/*    */   private final int field_75840_j;
/*  9 */   int field_75835_d = -1;
/*    */   float field_75836_e;
/*    */   float field_75833_f;
/*    */   float field_75834_g;
/*    */   
/*    */   public PathPoint(int p_i2135_1_, int p_i2135_2_, int p_i2135_3_) {
/* 15 */     this.field_75839_a = p_i2135_1_;
/* 16 */     this.field_75837_b = p_i2135_2_;
/* 17 */     this.field_75838_c = p_i2135_3_;
/*    */     
/* 19 */     this.field_75840_j = func_75830_a(p_i2135_1_, p_i2135_2_, p_i2135_3_);
/*    */   }
/*    */   PathPoint field_75841_h; public boolean field_75842_i; private static final String __OBFID = "CL_00000574";
/*    */   public static int func_75830_a(int p_75830_0_, int p_75830_1_, int p_75830_2_) {
/* 23 */     return p_75830_1_ & 0xFF | (p_75830_0_ & 0x7FFF) << 8 | (p_75830_2_ & 0x7FFF) << 24 | ((p_75830_0_ < 0) ? Integer.MIN_VALUE : 0) | ((p_75830_2_ < 0) ? 32768 : 0);
/*    */   }
/*    */   
/*    */   public float func_75829_a(PathPoint p_75829_1_) {
/* 27 */     float f1 = (p_75829_1_.field_75839_a - this.field_75839_a);
/* 28 */     float f2 = (p_75829_1_.field_75837_b - this.field_75837_b);
/* 29 */     float f3 = (p_75829_1_.field_75838_c - this.field_75838_c);
/* 30 */     return MathHelper.func_76129_c(f1 * f1 + f2 * f2 + f3 * f3);
/*    */   }
/*    */   
/*    */   public float func_75832_b(PathPoint p_75832_1_) {
/* 34 */     float f1 = (p_75832_1_.field_75839_a - this.field_75839_a);
/* 35 */     float f2 = (p_75832_1_.field_75837_b - this.field_75837_b);
/* 36 */     float f3 = (p_75832_1_.field_75838_c - this.field_75838_c);
/* 37 */     return f1 * f1 + f2 * f2 + f3 * f3;
/*    */   }
/*    */   
/*    */   public boolean equals(Object p_equals_1_) {
/* 41 */     if (p_equals_1_ instanceof PathPoint) {
/* 42 */       PathPoint pathPoint = (PathPoint)p_equals_1_;
/* 43 */       return (this.field_75840_j == pathPoint.field_75840_j && this.field_75839_a == pathPoint.field_75839_a && this.field_75837_b == pathPoint.field_75837_b && this.field_75838_c == pathPoint.field_75838_c);
/*    */     } 
/* 45 */     return false;
/*    */   }
/*    */   
/*    */   public int hashCode() {
/* 49 */     return this.field_75840_j;
/*    */   }
/*    */   
/*    */   public boolean func_75831_a() {
/* 53 */     return (this.field_75835_d >= 0);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 57 */     return this.field_75839_a + ", " + this.field_75837_b + ", " + this.field_75838_c;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\pathfinding\PathPoint.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */