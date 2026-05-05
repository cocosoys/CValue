/*    */ package net.minecraft.world.gen.layer;
/*    */ 
/*    */ public class GenLayerRiverInit extends GenLayer {
/*    */   public GenLayerRiverInit(long p_i2127_1_, GenLayer p_i2127_3_) {
/*  5 */     super(p_i2127_1_);
/*  6 */     this.field_75909_a = p_i2127_3_;
/*    */   }
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
/* 11 */     int[] arrayOfInt1 = this.field_75909_a.func_75904_a(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
/*    */     
/* 13 */     int[] arrayOfInt2 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
/* 14 */     for (byte b = 0; b < p_75904_4_; b++) {
/* 15 */       for (byte b1 = 0; b1 < p_75904_3_; b1++) {
/* 16 */         func_75903_a((b1 + p_75904_1_), (b + p_75904_2_));
/* 17 */         arrayOfInt2[b1 + b * p_75904_3_] = (arrayOfInt1[b1 + b * p_75904_3_] > 0) ? (func_75902_a(299999) + 2) : 0;
/*    */       } 
/*    */     } 
/*    */     
/* 21 */     return arrayOfInt2;
/*    */   }
/*    */   
/*    */   private static final String __OBFID = "CL_00000565";
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\layer\GenLayerRiverInit.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */