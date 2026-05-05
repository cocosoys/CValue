/*    */ package net.minecraft.world.gen.layer;
/*    */ 
/*    */ public class GenLayerRemoveTooMuchOcean
/*    */   extends GenLayer
/*    */ {
/*    */   private static final String __OBFID = "CL_00000564";
/*    */   
/*    */   public GenLayerRemoveTooMuchOcean(long p_i45480_1_, GenLayer p_i45480_3_) {
/*  9 */     super(p_i45480_1_);
/* 10 */     this.field_75909_a = p_i45480_3_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
/* 15 */     int i = p_75904_1_ - 1;
/* 16 */     int j = p_75904_2_ - 1;
/* 17 */     int k = p_75904_3_ + 2;
/* 18 */     int m = p_75904_4_ + 2;
/* 19 */     int[] arrayOfInt1 = this.field_75909_a.func_75904_a(i, j, k, m);
/*    */     
/* 21 */     int[] arrayOfInt2 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
/* 22 */     for (byte b = 0; b < p_75904_4_; b++) {
/* 23 */       for (byte b1 = 0; b1 < p_75904_3_; b1++) {
/* 24 */         int n = arrayOfInt1[b1 + 1 + (b + 1 - 1) * (p_75904_3_ + 2)];
/* 25 */         int i1 = arrayOfInt1[b1 + 1 + 1 + (b + 1) * (p_75904_3_ + 2)];
/* 26 */         int i2 = arrayOfInt1[b1 + 1 - 1 + (b + 1) * (p_75904_3_ + 2)];
/* 27 */         int i3 = arrayOfInt1[b1 + 1 + (b + 1 + 1) * (p_75904_3_ + 2)];
/*    */         
/* 29 */         int i4 = arrayOfInt1[b1 + 1 + (b + 1) * k];
/* 30 */         arrayOfInt2[b1 + b * p_75904_3_] = i4;
/* 31 */         func_75903_a((b1 + p_75904_1_), (b + p_75904_2_));
/* 32 */         if (i4 == 0 && n == 0 && i1 == 0 && i2 == 0 && i3 == 0 && func_75902_a(2) == 0) {
/* 33 */           arrayOfInt2[b1 + b * p_75904_3_] = 1;
/*    */         }
/*    */       } 
/*    */     } 
/* 37 */     return arrayOfInt2;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\layer\GenLayerRemoveTooMuchOcean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */