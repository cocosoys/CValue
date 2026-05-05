/*    */ package net.minecraft.world.gen.layer;
/*    */ 
/*    */ import net.minecraft.world.biome.BiomeGenBase;
/*    */ 
/*    */ public class GenLayerRiver
/*    */   extends GenLayer {
/*    */   public GenLayerRiver(long p_i2128_1_, GenLayer p_i2128_3_) {
/*  8 */     super(p_i2128_1_);
/*  9 */     this.field_75909_a = p_i2128_3_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000566";
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
/* 23 */         int n = func_151630_c(arrayOfInt1[b1 + 0 + (b + 1) * k]);
/* 24 */         int i1 = func_151630_c(arrayOfInt1[b1 + 2 + (b + 1) * k]);
/* 25 */         int i2 = func_151630_c(arrayOfInt1[b1 + 1 + (b + 0) * k]);
/* 26 */         int i3 = func_151630_c(arrayOfInt1[b1 + 1 + (b + 2) * k]);
/* 27 */         int i4 = func_151630_c(arrayOfInt1[b1 + 1 + (b + 1) * k]);
/* 28 */         if (i4 != n || i4 != i2 || i4 != i1 || i4 != i3) {
/* 29 */           arrayOfInt2[b1 + b * p_75904_3_] = BiomeGenBase.field_76781_i.field_76756_M;
/*    */         } else {
/* 31 */           arrayOfInt2[b1 + b * p_75904_3_] = -1;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 36 */     return arrayOfInt2;
/*    */   }
/*    */   
/*    */   private int func_151630_c(int p_151630_1_) {
/* 40 */     if (p_151630_1_ >= 2) {
/* 41 */       return 2 + (p_151630_1_ & 0x1);
/*    */     }
/* 43 */     return p_151630_1_;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\layer\GenLayerRiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */