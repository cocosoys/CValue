/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import java.io.BufferedReader;
/*    */ import java.io.InputStreamReader;
/*    */ import java.net.URL;
/*    */ 
/*    */ public class Version
/*    */ {
/*    */   public static final String MOD_ID = "jinryuujrmcore";
/*    */   public static final String MOD_NAME = "JinRyuu's JRMCore";
/*    */   public static final String VERSION = "1.3.51";
/*    */   public static final String REMOTE_VERSION_FILE = "http://jingames.net/public/JRMCore.txt";
/*    */   public static final String REMOTE_MASSAGE_FILE = "http://jingames.net/public/JRMCoremassage.txt";
/*    */   public static final byte UNINITIALIZED = 0;
/*    */   public static final byte CURRENT = 1;
/*    */   public static final byte OUTDATED = 2;
/*    */   public static final byte CONNECTION_ERROR = 3;
/*    */   private static final String UNINITIALIZED_MESSAGE = "Version Check was Uninitialized!";
/*    */   private static final String CONNECTION_ERROR_MESSAGE = "Connection Error when trying to get latest version!";
/* 20 */   public static byte result = 0;
/* 21 */   public static String line = null;
/*    */   
/* 23 */   public static String ammv = null;
/* 24 */   public static String news = null;
/*    */   
/*    */   public static void checkVersion() {
/*    */     try {
/* 28 */       URL url = new URL("http://jingames.net/public/JRMCore.txt");
/* 29 */       InputStreamReader isr = new InputStreamReader(url.openStream());
/* 30 */       BufferedReader reader = new BufferedReader(isr);
/* 31 */       while ((line = reader.readLine()) != null) {
/* 32 */         if (line.startsWith("jinryuujrmcore") && 
/* 33 */           line.endsWith("1.3.51")) {
/* 34 */           result = 1;
/* 35 */           reader.close();
/* 36 */           isr.close();
/*    */           
/*    */           return;
/*    */         } 
/*    */       } 
/* 41 */       result = 2;
/* 42 */       reader.close();
/* 43 */       isr.close();
/* 44 */     } catch (Exception e) {
/* 45 */       e.printStackTrace(System.err);
/* 46 */       result = 3;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static String getResultMessage() {
/* 51 */     if (result == 0)
/* 52 */       return "Version Check was Uninitialized!"; 
/* 53 */     if (result == 1)
/* 54 */       return "Your Version Is Updated"; 
/* 55 */     if (result == 2)
/* 56 */       return "There is a New Version Available!"; 
/* 57 */     if (result == 3) {
/* 58 */       return "Connection Error when trying to get latest version!";
/*    */     }
/* 60 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\Version.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */