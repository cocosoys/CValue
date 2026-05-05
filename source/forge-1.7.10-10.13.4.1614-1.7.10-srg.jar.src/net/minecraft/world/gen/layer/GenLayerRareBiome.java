/*    */ package net.minecraft.world.gen.layer;
/*    */ 
/*    */ import net.minecraft.world.biome.BiomeGenBase;
/*    */ 
/*    */ public class GenLayerRareBiome extends GenLayer {
/*    */   public GenLayerRareBiome(long p_i45478_1_, GenLayer p_i45478_3_) {
/*  7 */     super(p_i45478_1_);
/*  8 */     this.field_75909_a = p_i45478_3_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
/* 13 */     int[] arrayOfInt1 = this.field_75909_a.func_75904_a(p_75904_1_ - 1, p_75904_2_ - 1, p_75904_3_ + 2, p_75904_4_ + 2);
/*    */     
/* 15 */     int[] arrayOfInt2 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
/* 16 */     for (byte b = 0; b < p_75904_4_; b++) {
/* 17 */       for (byte b1 = 0; b1 < p_75904_3_; b1++) {
/* 18 */         func_75903_a((b1 + p_75904_1_), (b + p_75904_2_));
/* 19 */         int i = arrayOfInt1[b1 + 1 + (b + 1) * (p_75904_3_ + 2)];
/* 20 */         if (func_75902_a(57) == 0) {
/* 21 */           if (i == BiomeGenBase.field_76772_c.field_76756_M) {
/* 22 */             arrayOfInt2[b1 + b * p_75904_3_] = BiomeGenBase.field_76772_c.field_76756_M + 128;
/*    */           } else {
/* 24 */             arrayOfInt2[b1 + b * p_75904_3_] = i;
/*    */           } 
/*    */         } else {
/* 27 */           arrayOfInt2[b1 + b * p_75904_3_] = i;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 32 */     return arrayOfInt2;
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000562";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\layer\GenLayerRareBiome.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */