/*    */ package JinRyuu.DragonBC.common;public class Version { public static final String MOD_ID = "jinryuudragonblockc";
/*    */   public static final String MOD_NAME = "Dragon Block C";
/*    */   public static final String VERSION = "1.4.85";
/*    */   public static final String CHANNEL_NAME = "jinryuudragonblockc";
/*    */   public static final String BUILD_NUMBER = "@BUILD_NUMBER@";
/*    */   
/*  7 */   public enum EnumUpdateState { CURRENT, OUTDATED, CONNECTION_ERROR; }
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
/* 19 */   public static EnumUpdateState currentVersion = EnumUpdateState.CURRENT;
/*    */   
/*    */   private static String recommendedVersion;
/*    */   
/*    */   public static String getVersion() {
/* 24 */     return "1.4.85 (:@BUILD_NUMBER@)";
/*    */   }
/*    */   
/*    */   public static String getRecommendedVersion() {
/* 28 */     return recommendedVersion;
/*    */   } }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Version.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */