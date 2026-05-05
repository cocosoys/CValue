/*    */ package net.minecraft.util;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class Direction
/*    */ {
/* 12 */   public static final int[] field_71583_a = new int[] { 0, -1, 0, 1 };
/*    */ 
/*    */   
/* 15 */   public static final int[] field_71581_b = new int[] { 1, 0, -1, 0 };
/*    */ 
/*    */ 
/*    */   
/* 19 */   public static final String[] field_82373_c = new String[] { "SOUTH", "WEST", "NORTH", "EAST" };
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 24 */   public static final int[] field_71582_c = new int[] { 3, 4, 2, 5 };
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 29 */   public static final int[] field_71579_d = new int[] { -1, -1, 2, 0, 1, 3 };
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 34 */   public static final int[] field_71580_e = new int[] { 2, 3, 0, 1 };
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 39 */   public static final int[] field_71577_f = new int[] { 1, 2, 3, 0 };
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 44 */   public static final int[] field_71578_g = new int[] { 3, 0, 1, 2 };
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 49 */   public static final int[][] field_71584_h = new int[][] { { 1, 0, 3, 2, 5, 4 }, { 1, 0, 5, 4, 2, 3 }, { 1, 0, 2, 3, 4, 5 }, { 1, 0, 4, 5, 3, 2 } };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private static final String __OBFID = "CL_00001506";
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int func_82372_a(double p_82372_0_, double p_82372_2_) {
/* 69 */     if (MathHelper.func_76135_e((float)p_82372_0_) > MathHelper.func_76135_e((float)p_82372_2_)) {
/* 70 */       if (p_82372_0_ > 0.0D) {
/* 71 */         return 1;
/*    */       }
/* 73 */       return 3;
/*    */     } 
/*    */     
/* 76 */     if (p_82372_2_ > 0.0D) {
/* 77 */       return 2;
/*    */     }
/* 79 */     return 0;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\Direction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */