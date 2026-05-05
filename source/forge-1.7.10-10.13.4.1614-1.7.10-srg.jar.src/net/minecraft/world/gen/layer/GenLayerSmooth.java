/*    */ package net.minecraft.world.gen.layer;
/*    */ 
/*    */ public class GenLayerSmooth extends GenLayer {
/*    */   public GenLayerSmooth(long p_i2131_1_, GenLayer p_i2131_3_) {
/*  5 */     super(p_i2131_1_);
/*  6 */     this.field_75909_a = p_i2131_3_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
/* 11 */     int i = p_75904_1_ - 1;
/* 12 */     int j = p_75904_2_ - 1;
/* 13 */     int k = p_75904_3_ + 2;
/* 14 */     int m = p_75904_4_ + 2;
/* 15 */     int[] arrayOfInt1 = this.field_75909_a.func_75904_a(i, j, k, m);
/*    */     
/* 17 */     int[] arrayOfInt2 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
/* 18 */     for (byte b = 0; b < p_75904_4_; b++) {
/* 19 */       for (byte b1 = 0; b1 < p_75904_3_; b1++) {
/* 20 */         int n = arrayOfInt1[b1 + 0 + (b + 1) * k];
/* 21 */         int i1 = arrayOfInt1[b1 + 2 + (b + 1) * k];
/* 22 */         int i2 = arrayOfInt1[b1 + 1 + (b + 0) * k];
/* 23 */         int i3 = arrayOfInt1[b1 + 1 + (b + 2) * k];
/* 24 */         int i4 = arrayOfInt1[b1 + 1 + (b + 1) * k];
/* 25 */         if (n == i1 && i2 == i3) {
/* 26 */           func_75903_a((b1 + p_75904_1_), (b + p_75904_2_));
/* 27 */           if (func_75902_a(2) == 0) { i4 = n; }
/* 28 */           else { i4 = i2; }
/*    */         
/*    */         } else {
/* 31 */           if (n == i1) i4 = n; 
/* 32 */           if (i2 == i3) i4 = i2; 
/*    */         } 
/* 34 */         arrayOfInt2[b1 + b * p_75904_3_] = i4;
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 39 */     return arrayOfInt2;
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000569";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\layer\GenLayerSmooth.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */