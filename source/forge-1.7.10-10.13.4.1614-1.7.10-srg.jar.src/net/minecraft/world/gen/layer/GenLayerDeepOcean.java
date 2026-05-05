/*    */ package net.minecraft.world.gen.layer;
/*    */ 
/*    */ import net.minecraft.world.biome.BiomeGenBase;
/*    */ 
/*    */ public class GenLayerDeepOcean
/*    */   extends GenLayer {
/*    */   public GenLayerDeepOcean(long p_i45472_1_, GenLayer p_i45472_3_) {
/*  8 */     super(p_i45472_1_);
/*  9 */     this.field_75909_a = p_i45472_3_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000546";
/*    */   
/*    */   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
/* 14 */     int i = p_75904_1_ - 1;
/* 15 */     int j = p_75904_2_ - 1;
/* 16 */     int k = p_75904_3_ + 2;
/* 17 */     int m = p_75904_4_ + 2;
/* 18 */     int[] arrayOfInt1 = this.field_75909_a.func_75904_a(i, j, k, m);
/*    */     
/* 20 */     int[] arrayOfInt2 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
/* 21 */     for (byte b = 0; b < p_75904_4_; b++) {
/* 22 */       for (byte b1 = 0; b1 < p_75904_3_; b1++) {
/* 23 */         int n = arrayOfInt1[b1 + 1 + (b + 1 - 1) * (p_75904_3_ + 2)];
/* 24 */         int i1 = arrayOfInt1[b1 + 1 + 1 + (b + 1) * (p_75904_3_ + 2)];
/* 25 */         int i2 = arrayOfInt1[b1 + 1 - 1 + (b + 1) * (p_75904_3_ + 2)];
/* 26 */         int i3 = arrayOfInt1[b1 + 1 + (b + 1 + 1) * (p_75904_3_ + 2)];
/*    */         
/* 28 */         int i4 = arrayOfInt1[b1 + 1 + (b + 1) * k];
/* 29 */         byte b2 = 0;
/* 30 */         if (n == 0) b2++; 
/* 31 */         if (i1 == 0) b2++; 
/* 32 */         if (i2 == 0) b2++; 
/* 33 */         if (i3 == 0) b2++;
/*    */         
/* 35 */         if (i4 == 0 && b2 > 3) {
/* 36 */           arrayOfInt2[b1 + b * p_75904_3_] = BiomeGenBase.field_150575_M.field_76756_M;
/*    */         } else {
/* 38 */           arrayOfInt2[b1 + b * p_75904_3_] = i4;
/*    */         } 
/*    */       } 
/*    */     } 
/* 42 */     return arrayOfInt2;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\layer\GenLayerDeepOcean.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */