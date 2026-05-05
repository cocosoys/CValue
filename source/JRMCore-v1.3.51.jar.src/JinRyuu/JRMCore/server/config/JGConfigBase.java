/*    */ package JinRyuu.JRMCore.server.config;
/*    */ 
/*    */ 
/*    */ public class JGConfigBase
/*    */ {
/*    */   public static int getID(int id, int max) {
/*  7 */     return (id > max) ? max : id;
/*    */   }
/*    */ 
/*    */   
/*    */   public static String getDefault(String min, String max) {
/* 12 */     return ". (From " + min + " to " + max + ").";
/*    */   }
/*    */   
/*    */   public static String getDefault2(String min, String max) {
/* 16 */     return getDefault(min, max).substring(1);
/*    */   }
/*    */ 
/*    */   
/*    */   public static String getDefault(String value) {
/* 21 */     return ". (" + value + ").";
/*    */   }
/*    */ 
/*    */   
/*    */   public static String getDefaultValue(String value) {
/* 26 */     return ". (Default: " + value + ").";
/*    */   }
/*    */ 
/*    */   
/*    */   public static String getDefaultValue2(String value) {
/* 31 */     return getDefaultValue(value).substring(1);
/*    */   }
/*    */   
/*    */   public static int checkValue(int value, int min, int max) {
/* 35 */     if (value > max) value = max; 
/* 36 */     if (value < min) value = min; 
/* 37 */     return value;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\server\config\JGConfigBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */