/*    */ package org.yaml.snakeyaml.scanner;
/*    */ 
/*    */ import java.util.Arrays;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public final class Constant
/*    */ {
/*    */   private static final String ALPHA_S = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_";
/*    */   private static final String LINEBR_S = "\n  ";
/*    */   private static final String FULL_LINEBR_S = "\r\n  ";
/*    */   private static final String NULL_OR_LINEBR_S = "\000\r\n  ";
/*    */   private static final String NULL_BL_LINEBR_S = " \000\r\n  ";
/*    */   private static final String NULL_BL_T_LINEBR_S = "\t \000\r\n  ";
/*    */   private static final String NULL_BL_T_S = "\000 \t";
/*    */   private static final String URI_CHARS_S = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_-;/?:@&=+$,_.!~*'()[]%";
/* 32 */   public static final Constant LINEBR = new Constant("\n  ");
/* 33 */   public static final Constant FULL_LINEBR = new Constant("\r\n  ");
/* 34 */   public static final Constant NULL_OR_LINEBR = new Constant("\000\r\n  ");
/* 35 */   public static final Constant NULL_BL_LINEBR = new Constant(" \000\r\n  ");
/* 36 */   public static final Constant NULL_BL_T_LINEBR = new Constant("\t \000\r\n  ");
/* 37 */   public static final Constant NULL_BL_T = new Constant("\000 \t");
/* 38 */   public static final Constant URI_CHARS = new Constant("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_-;/?:@&=+$,_.!~*'()[]%");
/*    */   
/* 40 */   public static final Constant ALPHA = new Constant("abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ-_");
/*    */   
/*    */   private String content;
/* 43 */   boolean[] contains = new boolean[128];
/*    */   boolean noASCII = false;
/*    */   
/*    */   private Constant(String content) {
/* 47 */     Arrays.fill(this.contains, false);
/* 48 */     StringBuilder sb = new StringBuilder();
/* 49 */     for (int i = 0; i < content.length(); i++) {
/* 50 */       char ch = content.charAt(i);
/* 51 */       if (ch < '') {
/* 52 */         this.contains[ch] = true;
/*    */       } else {
/* 54 */         sb.append(ch);
/*    */       } 
/* 56 */     }  if (sb.length() > 0) {
/* 57 */       this.noASCII = true;
/* 58 */       this.content = sb.toString();
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean has(char ch) {
/* 63 */     return (ch < '') ? this.contains[ch] : ((this.noASCII && this.content.indexOf(ch, 0) != -1));
/*    */   }
/*    */   
/*    */   public boolean hasNo(char ch) {
/* 67 */     return !has(ch);
/*    */   }
/*    */   
/*    */   public boolean has(char ch, String additional) {
/* 71 */     return (has(ch) || additional.indexOf(ch, 0) != -1);
/*    */   }
/*    */   
/*    */   public boolean hasNo(char ch, String additional) {
/* 75 */     return !has(ch, additional);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\yaml\snakeyaml\scanner\Constant.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */