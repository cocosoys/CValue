/*    */ package JinRyuu.DragonBC.common;
/*    */ 
/*    */ import cpw.mods.fml.common.registry.LanguageRegistry;
/*    */ 
/*    */ public class DBCLocHlp {
/*    */   public static boolean isXMLLangFil(String filename) {
/*  7 */     return filename.endsWith(".xml");
/*    */   }
/*    */   
/*    */   public static String getLocFrmName(String filename) {
/* 11 */     return filename.substring(filename.lastIndexOf("/") + 1, filename.lastIndexOf("."));
/*    */   }
/*    */   
/*    */   public static String getLocStrng(String key) {
/* 15 */     return LanguageRegistry.instance().getStringLocalization(key);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\DBCLocHlp.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */