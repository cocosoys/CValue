/*    */ package net.minecraft.util;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class Util {
/*    */   private static final String __OBFID = "CL_00001633";
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*  8 */   public enum EnumOS { LINUX,
/*  9 */     SOLARIS,
/* 10 */     WINDOWS,
/* 11 */     OSX,
/* 12 */     UNKNOWN;
/*    */     private static final String __OBFID = "CL_00001660"; }
/*    */   
/*    */   public static EnumOS func_110647_a() {
/* 16 */     String str = System.getProperty("os.name").toLowerCase();
/* 17 */     if (str.contains("win")) return EnumOS.WINDOWS; 
/* 18 */     if (str.contains("mac")) return EnumOS.OSX; 
/* 19 */     if (str.contains("solaris")) return EnumOS.SOLARIS; 
/* 20 */     if (str.contains("sunos")) return EnumOS.SOLARIS; 
/* 21 */     if (str.contains("linux")) return EnumOS.LINUX; 
/* 22 */     if (str.contains("unix")) return EnumOS.LINUX; 
/* 23 */     return EnumOS.UNKNOWN;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraf\\util\Util.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */