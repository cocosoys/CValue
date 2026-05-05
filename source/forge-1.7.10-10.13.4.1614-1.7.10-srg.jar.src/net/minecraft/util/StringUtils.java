/*    */ package net.minecraft.util;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.regex.Pattern;
/*    */ 
/*    */ public class StringUtils {
/*    */   private static final String __OBFID = "CL_00001501";
/*  8 */   private static final Pattern field_76339_a = Pattern.compile("(?i)\\u00A7[0-9A-FK-OR]");
/*    */   @SideOnly(Side.CLIENT)
/*    */   public static String func_76337_a(int p_76337_0_) {
/* 11 */     int i = p_76337_0_ / 20;
/* 12 */     int j = i / 60;
/* 13 */     i %= 60;
/*    */     
/* 15 */     if (i < 10) {
/* 16 */       return j + ":0" + i;
/*    */     }
/* 18 */     return j + ":" + i;
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public static String func_76338_a(String p_76338_0_) {
/* 22 */     return field_76339_a.matcher(p_76338_0_).replaceAll("");
/*    */   }
/*    */   
/*    */   public static boolean func_151246_b(String p_151246_0_) {
/* 26 */     return (p_151246_0_ == null || "".equals(p_151246_0_));
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\StringUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */