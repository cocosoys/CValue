/*    */ package net.minecraft.world.gen.layer;
/*    */ 
/*    */ public class GenLayerIsland extends GenLayer {
/*    */   public GenLayerIsland(long p_i2124_1_) {
/*  5 */     super(p_i2124_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
/* 10 */     int[] arrayOfInt = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
/* 11 */     for (byte b = 0; b < p_75904_4_; b++) {
/* 12 */       for (byte b1 = 0; b1 < p_75904_3_; b1++) {
/* 13 */         func_75903_a((p_75904_1_ + b1), (p_75904_2_ + b));
/* 14 */         arrayOfInt[b1 + b * p_75904_3_] = (func_75902_a(10) == 0) ? 1 : 0;
/*    */       } 
/*    */     } 
/*    */     
/* 18 */     if (p_75904_1_ > -p_75904_3_ && p_75904_1_ <= 0 && p_75904_2_ > -p_75904_4_ && p_75904_2_ <= 0) {
/* 19 */       arrayOfInt[-p_75904_1_ + -p_75904_2_ * p_75904_3_] = 1;
/*    */     }
/* 21 */     return arrayOfInt;
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000558";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\layer\GenLayerIsland.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */