/*    */ package net.minecraft.network.rcon;
/*    */ 
/*    */ import com.google.common.base.Charsets;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ 
/*    */ @SideOnly(Side.SERVER)
/*    */ public class RConUtils
/*    */ {
/* 10 */   public static char[] field_72666_a = new char[] { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b', 'c', 'd', 'e', 'f' };
/*    */ 
/*    */ 
/*    */   
/*    */   private static final String __OBFID = "CL_00001799";
/*    */ 
/*    */ 
/*    */   
/*    */   public static String func_72661_a(byte[] p_72661_0_, int p_72661_1_, int p_72661_2_) {
/* 19 */     int i = p_72661_2_ - 1;
/* 20 */     int j = (p_72661_1_ > i) ? i : p_72661_1_;
/* 21 */     while (0 != p_72661_0_[j] && j < i) {
/* 22 */       j++;
/*    */     }
/*    */     
/* 25 */     return new String(p_72661_0_, p_72661_1_, j - p_72661_1_, Charsets.UTF_8);
/*    */   }
/*    */   
/*    */   public static int func_72662_b(byte[] p_72662_0_, int p_72662_1_) {
/* 29 */     return func_72665_b(p_72662_0_, p_72662_1_, p_72662_0_.length);
/*    */   }
/*    */   
/*    */   public static int func_72665_b(byte[] p_72665_0_, int p_72665_1_, int p_72665_2_) {
/* 33 */     if (0 > p_72665_2_ - p_72665_1_ - 4)
/*    */     {
/*    */       
/* 36 */       return 0;
/*    */     }
/* 38 */     return p_72665_0_[p_72665_1_ + 3] << 24 | (p_72665_0_[p_72665_1_ + 2] & 0xFF) << 16 | (p_72665_0_[p_72665_1_ + 1] & 0xFF) << 8 | p_72665_0_[p_72665_1_] & 0xFF;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static int func_72664_c(byte[] p_72664_0_, int p_72664_1_, int p_72664_2_) {
/* 46 */     if (0 > p_72664_2_ - p_72664_1_ - 4)
/*    */     {
/*    */       
/* 49 */       return 0;
/*    */     }
/* 51 */     return p_72664_0_[p_72664_1_] << 24 | (p_72664_0_[p_72664_1_ + 1] & 0xFF) << 16 | (p_72664_0_[p_72664_1_ + 2] & 0xFF) << 8 | p_72664_0_[p_72664_1_ + 3] & 0xFF;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static String func_72663_a(byte p_72663_0_) {
/* 65 */     return "" + field_72666_a[(p_72663_0_ & 0xF0) >>> 4] + field_72666_a[p_72663_0_ & 0xF];
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\rcon\RConUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */