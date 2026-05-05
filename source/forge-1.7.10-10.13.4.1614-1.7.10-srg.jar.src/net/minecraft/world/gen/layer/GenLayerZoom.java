/*    */ package net.minecraft.world.gen.layer;
/*    */ 
/*    */ 
/*    */ public class GenLayerZoom
/*    */   extends GenLayer
/*    */ {
/*    */   private static final String __OBFID = "CL_00000572";
/*    */   
/*    */   public GenLayerZoom(long p_i2134_1_, GenLayer p_i2134_3_) {
/* 10 */     super(p_i2134_1_);
/* 11 */     this.field_75909_a = p_i2134_3_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
/* 16 */     int i = p_75904_1_ >> 1;
/* 17 */     int j = p_75904_2_ >> 1;
/* 18 */     int k = (p_75904_3_ >> 1) + 2;
/* 19 */     int m = (p_75904_4_ >> 1) + 2;
/* 20 */     int[] arrayOfInt1 = this.field_75909_a.func_75904_a(i, j, k, m);
/*    */     
/* 22 */     int n = k - 1 << 1;
/* 23 */     int i1 = m - 1 << 1;
/*    */     
/* 25 */     int[] arrayOfInt2 = IntCache.func_76445_a(n * i1);
/*    */     
/* 27 */     for (byte b1 = 0; b1 < m - 1; b1++) {
/* 28 */       int i2 = (b1 << 1) * n;
/*    */       
/* 30 */       byte b = 0;
/* 31 */       int i3 = arrayOfInt1[b + 0 + (b1 + 0) * k];
/* 32 */       int i4 = arrayOfInt1[b + 0 + (b1 + 1) * k];
/* 33 */       for (; b < k - 1; b++) {
/* 34 */         func_75903_a((b + i << 1), (b1 + j << 1));
/*    */         
/* 36 */         int i5 = arrayOfInt1[b + 1 + (b1 + 0) * k];
/* 37 */         int i6 = arrayOfInt1[b + 1 + (b1 + 1) * k];
/*    */         
/* 39 */         arrayOfInt2[i2] = i3;
/* 40 */         arrayOfInt2[i2++ + n] = func_151619_a(new int[] { i3, i4 });
/* 41 */         arrayOfInt2[i2] = func_151619_a(new int[] { i3, i5 });
/* 42 */         arrayOfInt2[i2++ + n] = func_151617_b(i3, i5, i4, i6);
/*    */         
/* 44 */         i3 = i5;
/* 45 */         i4 = i6;
/*    */       } 
/*    */     } 
/*    */     
/* 49 */     int[] arrayOfInt3 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
/* 50 */     for (byte b2 = 0; b2 < p_75904_4_; b2++) {
/* 51 */       System.arraycopy(arrayOfInt2, (b2 + (p_75904_2_ & 0x1)) * n + (p_75904_1_ & 0x1), arrayOfInt3, b2 * p_75904_3_, p_75904_3_);
/*    */     }
/* 53 */     return arrayOfInt3;
/*    */   }
/*    */   
/*    */   public static GenLayer func_75915_a(long p_75915_0_, GenLayer p_75915_2_, int p_75915_3_) {
/* 57 */     GenLayer genLayer = p_75915_2_;
/* 58 */     for (byte b = 0; b < p_75915_3_; b++) {
/* 59 */       genLayer = new GenLayerZoom(p_75915_0_ + b, genLayer);
/*    */     }
/* 61 */     return genLayer;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\layer\GenLayerZoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */