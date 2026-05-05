/*    */ package net.minecraft.world.gen.layer;
/*    */ public class GenLayerAddIsland extends GenLayer {
/*    */   private static final String __OBFID = "CL_00000551";
/*    */   
/*    */   public GenLayerAddIsland(long p_i2119_1_, GenLayer p_i2119_3_) {
/*  6 */     super(p_i2119_1_);
/*  7 */     this.field_75909_a = p_i2119_3_;
/*    */   }
/*    */ 
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
/* 21 */         int n = arrayOfInt1[b1 + 0 + (b + 0) * k];
/* 22 */         int i1 = arrayOfInt1[b1 + 2 + (b + 0) * k];
/* 23 */         int i2 = arrayOfInt1[b1 + 0 + (b + 2) * k];
/* 24 */         int i3 = arrayOfInt1[b1 + 2 + (b + 2) * k];
/* 25 */         int i4 = arrayOfInt1[b1 + 1 + (b + 1) * k];
/* 26 */         func_75903_a((b1 + p_75904_1_), (b + p_75904_2_));
/* 27 */         if (i4 == 0 && (n != 0 || i1 != 0 || i2 != 0 || i3 != 0))
/* 28 */         { byte b2 = 1;
/* 29 */           int i5 = 1;
/* 30 */           if (n != 0 && func_75902_a(b2++) == 0) i5 = n; 
/* 31 */           if (i1 != 0 && func_75902_a(b2++) == 0) i5 = i1; 
/* 32 */           if (i2 != 0 && func_75902_a(b2++) == 0) i5 = i2; 
/* 33 */           if (i3 != 0 && func_75902_a(b2++) == 0) i5 = i3; 
/* 34 */           if (func_75902_a(3) == 0)
/* 35 */           { arrayOfInt2[b1 + b * p_75904_3_] = i5; }
/*    */           
/* 37 */           else if (i5 == 4) { arrayOfInt2[b1 + b * p_75904_3_] = 4; }
/* 38 */           else { arrayOfInt2[b1 + b * p_75904_3_] = 0; }
/*    */            }
/* 40 */         else if (i4 > 0 && (n == 0 || i1 == 0 || i2 == 0 || i3 == 0))
/* 41 */         { if (func_75902_a(5) == 0)
/* 42 */           { if (i4 == 4) { arrayOfInt2[b1 + b * p_75904_3_] = 4; }
/* 43 */             else { arrayOfInt2[b1 + b * p_75904_3_] = 0; }  }
/* 44 */           else { arrayOfInt2[b1 + b * p_75904_3_] = i4; }
/*    */            }
/* 46 */         else { arrayOfInt2[b1 + b * p_75904_3_] = i4; }
/*    */       
/*    */       } 
/*    */     } 
/* 50 */     return arrayOfInt2;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\layer\GenLayerAddIsland.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */