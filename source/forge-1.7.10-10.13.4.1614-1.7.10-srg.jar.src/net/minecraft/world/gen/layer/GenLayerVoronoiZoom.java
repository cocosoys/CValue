/*    */ package net.minecraft.world.gen.layer;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class GenLayerVoronoiZoom
/*    */   extends GenLayer
/*    */ {
/*    */   private static final String __OBFID = "CL_00000571";
/*    */   
/*    */   public GenLayerVoronoiZoom(long p_i2133_1_, GenLayer p_i2133_3_) {
/* 11 */     super(p_i2133_1_);
/* 12 */     this.field_75909_a = p_i2133_3_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
/* 17 */     p_75904_1_ -= 2;
/* 18 */     p_75904_2_ -= 2;
/* 19 */     int i = p_75904_1_ >> 2;
/* 20 */     int j = p_75904_2_ >> 2;
/* 21 */     int k = (p_75904_3_ >> 2) + 2;
/* 22 */     int m = (p_75904_4_ >> 2) + 2;
/* 23 */     int[] arrayOfInt1 = this.field_75909_a.func_75904_a(i, j, k, m);
/*    */     
/* 25 */     int n = k - 1 << 2;
/* 26 */     int i1 = m - 1 << 2;
/*    */     
/* 28 */     int[] arrayOfInt2 = IntCache.func_76445_a(n * i1);
/* 29 */     for (byte b1 = 0; b1 < m - 1; b1++) {
/*    */       
/* 31 */       byte b = 0;
/* 32 */       int i2 = arrayOfInt1[b + 0 + (b1 + 0) * k];
/* 33 */       int i3 = arrayOfInt1[b + 0 + (b1 + 1) * k];
/* 34 */       for (; b < k - 1; b++) {
/* 35 */         double d1 = 3.6D;
/* 36 */         func_75903_a((b + i << 2), (b1 + j << 2));
/* 37 */         double d2 = (func_75902_a(1024) / 1024.0D - 0.5D) * 3.6D;
/* 38 */         double d3 = (func_75902_a(1024) / 1024.0D - 0.5D) * 3.6D;
/*    */         
/* 40 */         func_75903_a((b + i + 1 << 2), (b1 + j << 2));
/* 41 */         double d4 = (func_75902_a(1024) / 1024.0D - 0.5D) * 3.6D + 4.0D;
/* 42 */         double d5 = (func_75902_a(1024) / 1024.0D - 0.5D) * 3.6D;
/*    */         
/* 44 */         func_75903_a((b + i << 2), (b1 + j + 1 << 2));
/* 45 */         double d6 = (func_75902_a(1024) / 1024.0D - 0.5D) * 3.6D;
/* 46 */         double d7 = (func_75902_a(1024) / 1024.0D - 0.5D) * 3.6D + 4.0D;
/*    */         
/* 48 */         func_75903_a((b + i + 1 << 2), (b1 + j + 1 << 2));
/* 49 */         double d8 = (func_75902_a(1024) / 1024.0D - 0.5D) * 3.6D + 4.0D;
/* 50 */         double d9 = (func_75902_a(1024) / 1024.0D - 0.5D) * 3.6D + 4.0D;
/*    */         
/* 52 */         int i4 = arrayOfInt1[b + 1 + (b1 + 0) * k] & 0xFF;
/* 53 */         int i5 = arrayOfInt1[b + 1 + (b1 + 1) * k] & 0xFF;
/*    */         
/* 55 */         for (byte b3 = 0; b3 < 4; b3++) {
/* 56 */           int i6 = ((b1 << 2) + b3) * n + (b << 2);
/* 57 */           for (byte b4 = 0; b4 < 4; b4++) {
/* 58 */             double d10 = (b3 - d3) * (b3 - d3) + (b4 - d2) * (b4 - d2);
/* 59 */             double d11 = (b3 - d5) * (b3 - d5) + (b4 - d4) * (b4 - d4);
/* 60 */             double d12 = (b3 - d7) * (b3 - d7) + (b4 - d6) * (b4 - d6);
/* 61 */             double d13 = (b3 - d9) * (b3 - d9) + (b4 - d8) * (b4 - d8);
/*    */             
/* 63 */             if (d10 < d11 && d10 < d12 && d10 < d13) {
/* 64 */               arrayOfInt2[i6++] = i2;
/* 65 */             } else if (d11 < d10 && d11 < d12 && d11 < d13) {
/* 66 */               arrayOfInt2[i6++] = i4;
/* 67 */             } else if (d12 < d10 && d12 < d11 && d12 < d13) {
/* 68 */               arrayOfInt2[i6++] = i3;
/*    */             } else {
/* 70 */               arrayOfInt2[i6++] = i5;
/*    */             } 
/*    */           } 
/*    */         } 
/*    */         
/* 75 */         i2 = i4;
/* 76 */         i3 = i5;
/*    */       } 
/*    */     } 
/*    */     
/* 80 */     int[] arrayOfInt3 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
/* 81 */     for (byte b2 = 0; b2 < p_75904_4_; b2++) {
/* 82 */       System.arraycopy(arrayOfInt2, (b2 + (p_75904_2_ & 0x3)) * n + (p_75904_1_ & 0x3), arrayOfInt3, b2 * p_75904_3_, p_75904_3_);
/*    */     }
/* 84 */     return arrayOfInt3;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\layer\GenLayerVoronoiZoom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */