/*    */ package JinRyuu.FamilyC;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.URL;
/*    */ 
/*    */ public class Version
/*    */ {
/*    */   public static final String MOD_ID = "jinryuufamilyc";
/*    */   public static final String MOD_NAME = "JinRyuu's Family C";
/*    */   public static final String VERSION = "1.2.18";
/*    */   public static final String REMOTE_VERSION_FILE = "http://jingames.net/public/FamilyC.txt";
/*    */   public static final String REMOTE_MASSAGE_FILE = "http://jingames.net/public/FamilyCmassage.txt";
/*    */   public static final byte UNINITIALIZED = 0;
/*    */   public static final byte CURRENT = 1;
/*    */   public static final byte OUTDATED = 2;
/*    */   public static final byte CONNECTION_ERROR = 3;
/*    */   private static final String UNINITIALIZED_MESSAGE = "Version Check was Uninitialized!";
/*    */   private static final String CONNECTION_ERROR_MESSAGE = "Connection Error when trying to get latest version!";
/* 20 */   public static byte result = 0;
/* 21 */   public static String line = null;
/*    */   public static void checkVersion() {
/*    */     try {
/* 24 */       URL url = new URL("http://jingames.net/public/FamilyC.txt");
/* 25 */       InputStreamReader isr = new InputStreamReader(url.openStream());
/* 26 */       BufferedReader reader = new BufferedReader(isr);
/* 27 */       while ((line = reader.readLine()) != null) {
/* 28 */         if (line.startsWith("jinryuufamilyc") && 
/* 29 */           line.endsWith("1.2.18")) {
/* 30 */           result = 1;
/* 31 */           reader.close();
/* 32 */           isr.close();
/*    */           
/*    */           return;
/*    */         } 
/*    */       } 
/* 37 */       result = 2;
/* 38 */       reader.close();
/* 39 */       isr.close();
/* 40 */     } catch (Exception e) {
/* 41 */       e.printStackTrace(System.err);
/* 42 */       result = 3;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static String getResultMessage() {
/* 47 */     if (result == 0)
/* 48 */       return "Version Check was Uninitialized!"; 
/* 49 */     if (result == 1)
/* 50 */       return "Your Version Is Updated"; 
/* 51 */     if (result == 2)
/* 52 */       return "There is a New Version Available!"; 
/* 53 */     if (result == 3) {
/* 54 */       return "Connection Error when trying to get latest version!";
/*    */     }
/* 56 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JFamilyC-v1.2.18.jar!\JinRyuu\FamilyC\Version.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */