/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ public class JYearsCH {
/*  6 */   public static String[] dayNames = new String[] { "Wolfsday", "Blazeday", "Witherday", "Ghastday", "Enderday" };
/*  7 */   public static String[] monthNames = new String[] { "Redstonary", "Gol'dar", "Diamondar", "Emeraldary" };
/*    */   
/*  9 */   public static String[] monthInDays = new String[] { "12", "13", "9", "12" };
/* 10 */   public static int[] mID = new int[] { 12, 13, 9, 12 };
/*    */   
/* 12 */   public static int y = 0;
/* 13 */   public static int m = 0;
/* 14 */   public static int d = 0;
/* 15 */   public static double py = 0.0D;
/*    */   
/* 17 */   static String cd = "JYearsC_d.jyc";
/*    */   
/* 19 */   public static void wcd(MinecraftServer server, String d, String id, boolean b) { String fd = "/data"; JRMCoreH.wd(server, d, id, fd, cd, b); } public static String rcd(MinecraftServer server, String id) {
/* 20 */     String fd = "/data"; return JRMCoreH.rd(server, id, fd, cd);
/*    */   }
/* 22 */   public static String[] p = null;
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JYearsCH.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */