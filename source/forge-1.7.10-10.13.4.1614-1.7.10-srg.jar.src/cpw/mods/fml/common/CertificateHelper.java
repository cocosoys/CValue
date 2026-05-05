/*    */ package cpw.mods.fml.common;
/*    */ 
/*    */ import java.nio.ByteBuffer;
/*    */ import java.security.MessageDigest;
/*    */ import java.security.cert.Certificate;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public class CertificateHelper
/*    */ {
/*    */   private static final String HEXES = "0123456789abcdef";
/*    */   
/*    */   public static String getFingerprint(Certificate certificate) {
/* 25 */     if (certificate == null)
/*    */     {
/* 27 */       return "NO VALID CERTIFICATE FOUND";
/*    */     }
/*    */     
/*    */     try {
/* 31 */       MessageDigest md = MessageDigest.getInstance("SHA-1");
/* 32 */       byte[] der = certificate.getEncoded();
/* 33 */       md.update(der);
/* 34 */       byte[] digest = md.digest();
/* 35 */       return hexify(digest);
/*    */     }
/* 37 */     catch (Exception e) {
/*    */       
/* 39 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public static String getFingerprint(ByteBuffer buffer) {
/*    */     try {
/* 47 */       MessageDigest digest = MessageDigest.getInstance("SHA-1");
/* 48 */       digest.update(buffer);
/* 49 */       byte[] chksum = digest.digest();
/* 50 */       return hexify(chksum);
/*    */     }
/* 52 */     catch (Exception e) {
/*    */       
/* 54 */       return null;
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   private static String hexify(byte[] chksum) {
/* 60 */     StringBuilder hex = new StringBuilder(2 * chksum.length);
/* 61 */     for (byte b : chksum) {
/* 62 */       hex.append("0123456789abcdef".charAt((b & 0xF0) >> 4))
/* 63 */         .append("0123456789abcdef".charAt(b & 0xF));
/*    */     }
/* 65 */     return hex.toString();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\CertificateHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */