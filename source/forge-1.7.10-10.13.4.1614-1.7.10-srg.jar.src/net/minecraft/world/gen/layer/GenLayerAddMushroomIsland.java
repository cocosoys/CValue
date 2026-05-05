/*    */ package net.minecraft.world.gen.layer;
/*    */ 
/*    */ import net.minecraft.world.biome.BiomeGenBase;
/*    */ 
/*    */ public class GenLayerAddMushroomIsland extends GenLayer {
/*    */   public GenLayerAddMushroomIsland(long p_i2120_1_, GenLayer p_i2120_3_) {
/*  7 */     super(p_i2120_1_);
/*  8 */     this.field_75909_a = p_i2120_3_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
/* 13 */     int i = p_75904_1_ - 1;
/* 14 */     int j = p_75904_2_ - 1;
/* 15 */     int k = p_75904_3_ + 2;
/* 16 */     int m = p_75904_4_ + 2;
/* 17 */     int[] arrayOfInt1 = this.field_75909_a.func_75904_a(i, j, k, m);
/*    */     
/* 19 */     int[] arrayOfInt2 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
/* 20 */     for (byte b = 0; b < p_75904_4_; b++) {
/* 21 */       for (byte b1 = 0; b1 < p_75904_3_; b1++) {
/* 22 */         int n = arrayOfInt1[b1 + 0 + (b + 0) * k];
/* 23 */         int i1 = arrayOfInt1[b1 + 2 + (b + 0) * k];
/* 24 */         int i2 = arrayOfInt1[b1 + 0 + (b + 2) * k];
/* 25 */         int i3 = arrayOfInt1[b1 + 2 + (b + 2) * k];
/* 26 */         int i4 = arrayOfInt1[b1 + 1 + (b + 1) * k];
/* 27 */         func_75903_a((b1 + p_75904_1_), (b + p_75904_2_));
/* 28 */         if (i4 == 0 && n == 0 && i1 == 0 && i2 == 0 && i3 == 0 && func_75902_a(100) == 0) {
/* 29 */           arrayOfInt2[b1 + b * p_75904_3_] = BiomeGenBase.field_76789_p.field_76756_M;
/*    */         } else {
/* 31 */           arrayOfInt2[b1 + b * p_75904_3_] = i4;
/*    */         } 
/*    */       } 
/*    */     } 
/* 35 */     return arrayOfInt2;
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000552";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\layer\GenLayerAddMushroomIsland.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */