/*    */ package net.minecraft.world;
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ColorizerFoliage {
/*  4 */   private static int[] field_77471_a = new int[65536]; private static final String __OBFID = "CL_00000135";
/*    */   
/*    */   public static void func_77467_a(int[] p_77467_0_) {
/*  7 */     field_77471_a = p_77467_0_;
/*    */   }
/*    */   
/*    */   public static int func_77470_a(double p_77470_0_, double p_77470_2_) {
/* 11 */     p_77470_2_ *= p_77470_0_;
/* 12 */     int i = (int)((1.0D - p_77470_0_) * 255.0D);
/* 13 */     int j = (int)((1.0D - p_77470_2_) * 255.0D);
/* 14 */     return field_77471_a[j << 8 | i];
/*    */   }
/*    */   
/*    */   public static int func_77466_a() {
/* 18 */     return 6396257;
/*    */   }
/*    */   
/*    */   public static int func_77469_b() {
/* 22 */     return 8431445;
/*    */   }
/*    */   
/*    */   public static int func_77468_c() {
/* 26 */     return 4764952;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\ColorizerFoliage.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */