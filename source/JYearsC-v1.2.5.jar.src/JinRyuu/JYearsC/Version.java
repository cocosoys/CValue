/*    */ package JinRyuu.JYearsC;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.URL;
/*    */ 
/*    */ public class Version
/*    */ {
/*    */   public static final String MOD_ID = "jinryuuyearsc";
/*    */   public static final String MOD_NAME = "JinRyuu's Years C";
/*    */   public static final String VERSION = "1.2.5";
/*    */   public static final String REMOTE_VERSION_FILE = "http://jingames.net/public/JYearsC.txt";
/*    */   public static final String REMOTE_MASSAGE_FILE = "http://jingames.net/public/JYearsCmassage.txt";
/*    */   public static final byte UNINITIALIZED = 0;
/*    */   public static final byte CURRENT = 1;
/*    */   public static final byte OUTDATED = 2;
/*    */   public static final byte CONNECTION_ERROR = 3;
/*    */   private static final String VERSION_CHECK_INIT_LOG_MESSAGE = "version init_log_message";
/*    */   private static final String UNINITIALIZED_MESSAGE = "Version Check was Uninitialized!";
/*    */   private static final String CONNECTION_ERROR_MESSAGE = "Connection Error when trying to get latest version!";
/* 21 */   public static byte result = 0;
/* 22 */   public static String line = null;
/*    */   public static void checkVersion() {
/*    */     try {
/* 25 */       URL url = new URL("http://jingames.net/public/JYearsC.txt");
/* 26 */       InputStreamReader isr = new InputStreamReader(url.openStream());
/* 27 */       BufferedReader reader = new BufferedReader(isr);
/* 28 */       while ((line = reader.readLine()) != null) {
/* 29 */         if (line.startsWith("jinryuuyearsc") && 
/* 30 */           line.endsWith("1.2.5")) {
/* 31 */           result = 1;
/* 32 */           reader.close();
/* 33 */           isr.close();
/*    */           
/*    */           return;
/*    */         } 
/*    */       } 
/* 38 */       result = 2;
/* 39 */       reader.close();
/* 40 */       isr.close();
/* 41 */     } catch (Exception e) {
/* 42 */       e.printStackTrace(System.err);
/* 43 */       result = 3;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static String getResultMessage() {
/* 48 */     if (result == 0)
/* 49 */       return "Version Check was Uninitialized!"; 
/* 50 */     if (result == 1)
/* 51 */       return "Your Version Is Updated"; 
/* 52 */     if (result == 2)
/* 53 */       return "There is a New Version Available!"; 
/* 54 */     if (result == 3) {
/* 55 */       return "Connection Error when trying to get latest version!";
/*    */     }
/* 57 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JYearsC-v1.2.5.jar!\JinRyuu\JYearsC\Version.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */