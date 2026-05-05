/*    */ package net.minecraft.world.gen.layer;
/*    */ 
/*    */ public class GenLayerAddSnow
/*    */   extends GenLayer {
/*    */   public GenLayerAddSnow(long p_i2121_1_, GenLayer p_i2121_3_) {
/*  6 */     super(p_i2121_1_);
/*  7 */     this.field_75909_a = p_i2121_3_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000553";
/*    */   
/*    */   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
/* 12 */     int i = p_75904_1_ - 1;
/* 13 */     int j = p_75904_2_ - 1;
/* 14 */     int k = p_75904_3_ + 2;
/* 15 */     int m = p_75904_4_ + 2;
/* 16 */     int[] arrayOfInt1 = this.field_75909_a.func_75904_a(i, j, k, m);
/*    */     
/* 18 */     int[] arrayOfInt2 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
/* 19 */     for (byte b = 0; b < p_75904_4_; b++) {
/* 20 */       for (byte b1 = 0; b1 < p_75904_3_; b1++) {
/* 21 */         int n = arrayOfInt1[b1 + 1 + (b + 1) * k];
/* 22 */         func_75903_a((b1 + p_75904_1_), (b + p_75904_2_));
/* 23 */         if (n == 0) {
/* 24 */           arrayOfInt2[b1 + b * p_75904_3_] = 0;
/*    */         } else {
/* 26 */           int i1 = func_75902_a(6);
/* 27 */           if (i1 == 0) { i1 = 4; }
/* 28 */           else if (i1 <= 1) { i1 = 3; }
/* 29 */           else { i1 = 1; }
/* 30 */            arrayOfInt2[b1 + b * p_75904_3_] = i1;
/*    */         } 
/*    */       } 
/*    */     } 
/* 34 */     return arrayOfInt2;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\layer\GenLayerAddSnow.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */