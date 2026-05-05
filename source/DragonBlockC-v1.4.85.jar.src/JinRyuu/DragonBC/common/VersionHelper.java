/*    */ package JinRyuu.DragonBC.common;
/*    */ 
/*    */ 
/*    */ public class VersionHelper
/*    */ {
/*    */   public static final byte UNINITIALIZED = 0;
/*    */   public static final byte CURRENT = 1;
/*    */   public static final byte OUTDATED = 2;
/*    */   public static final byte CONNECTION_ERROR = 3;
/*    */   private static final String VERSION_CHECK_DISABLED = "version check_disabled";
/*    */   private static final String VERSION_CHECK_INIT_LOG_MESSAGE = "version init_log_message";
/*    */   private static final String UNINITIALIZED_MESSAGE = "version uninitialized";
/*    */   private static final String CURRENT_MESSAGE = "version current";
/*    */   private static final String OUTDATED_MESSAGE = "version outdated";
/*    */   private static final String CONNECTION_ERROR_MESSAGE = "version connection_error";
/* 16 */   public static byte result = 0;
/* 17 */   public static String line = null;
/*    */ 
/*    */   
/*    */   public static String getResultMessage() {
/* 21 */     if (result == 0) {
/* 22 */       return "version uninitialized";
/*    */     }
/* 24 */     if (result == 1) {
/* 25 */       return "Your Version Is Updated";
/*    */     }
/* 27 */     if (result == 2) {
/* 28 */       return "There is a New Version Available!";
/*    */     }
/* 30 */     if (result == 3) {
/* 31 */       return "Cannot connect to server!";
/*    */     }
/*    */     
/* 34 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\VersionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */