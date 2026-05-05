/*    */ package net.minecraft.world;
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class ColorizerGrass {
/*  4 */   private static int[] field_77481_a = new int[65536]; private static final String __OBFID = "CL_00000138";
/*    */   
/*    */   public static void func_77479_a(int[] p_77479_0_) {
/*  7 */     field_77481_a = p_77479_0_;
/*    */   }
/*    */   
/*    */   public static int func_77480_a(double p_77480_0_, double p_77480_2_) {
/* 11 */     p_77480_2_ *= p_77480_0_;
/* 12 */     int i = (int)((1.0D - p_77480_0_) * 255.0D);
/* 13 */     int j = (int)((1.0D - p_77480_2_) * 255.0D);
/* 14 */     return field_77481_a[j << 8 | i];
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\ColorizerGrass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */