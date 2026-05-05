/*     */ package org.apache.commons.lang;
/*     */ 
/*     */ import java.io.IOException;
/*     */ import java.io.StringWriter;
/*     */ import java.io.Writer;
/*     */ import org.apache.commons.lang.exception.NestableRuntimeException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class StringEscapeUtils
/*     */ {
/*     */   public static String escapeJava(String str) {
/*  81 */     return escapeJavaStyleString(str, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void escapeJava(Writer out, String str) throws IOException {
/*  97 */     escapeJavaStyleString(out, str, false);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String escapeJavaScript(String str) {
/* 122 */     return escapeJavaStyleString(str, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void escapeJavaScript(Writer out, String str) throws IOException {
/* 138 */     escapeJavaStyleString(out, str, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String escapeJavaStyleString(String str, boolean escapeSingleQuotes) {
/* 149 */     if (str == null) {
/* 150 */       return null;
/*     */     }
/*     */     try {
/* 153 */       StringWriter writer = new StringWriter(str.length() * 2);
/* 154 */       escapeJavaStyleString(writer, str, escapeSingleQuotes);
/* 155 */       return writer.toString();
/*     */     } catch (IOException ioe) {
/*     */       
/* 158 */       ioe.printStackTrace();
/* 159 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static void escapeJavaStyleString(Writer out, String str, boolean escapeSingleQuote) throws IOException {
/* 172 */     if (out == null) {
/* 173 */       throw new IllegalArgumentException("The Writer must not be null");
/*     */     }
/* 175 */     if (str == null) {
/*     */       return;
/*     */     }
/*     */     
/* 179 */     int sz = str.length();
/* 180 */     for (int i = 0; i < sz; i++) {
/* 181 */       char ch = str.charAt(i);
/*     */ 
/*     */       
/* 184 */       if (ch > '࿿') {
/* 185 */         out.write("\\u" + hex(ch));
/* 186 */       } else if (ch > 'ÿ') {
/* 187 */         out.write("\\u0" + hex(ch));
/* 188 */       } else if (ch > '') {
/* 189 */         out.write("\\u00" + hex(ch));
/* 190 */       } else if (ch < ' ') {
/* 191 */         switch (ch) {
/*     */           case '\b':
/* 193 */             out.write(92);
/* 194 */             out.write(98);
/*     */             break;
/*     */           case '\n':
/* 197 */             out.write(92);
/* 198 */             out.write(110);
/*     */             break;
/*     */           case '\t':
/* 201 */             out.write(92);
/* 202 */             out.write(116);
/*     */             break;
/*     */           case '\f':
/* 205 */             out.write(92);
/* 206 */             out.write(102);
/*     */             break;
/*     */           case '\r':
/* 209 */             out.write(92);
/* 210 */             out.write(114);
/*     */             break;
/*     */           default:
/* 213 */             if (ch > '\017') {
/* 214 */               out.write("\\u00" + hex(ch)); break;
/*     */             } 
/* 216 */             out.write("\\u000" + hex(ch));
/*     */             break;
/*     */         } 
/*     */       
/*     */       } else {
/* 221 */         switch (ch) {
/*     */           case '\'':
/* 223 */             if (escapeSingleQuote) {
/* 224 */               out.write(92);
/*     */             }
/* 226 */             out.write(39);
/*     */             break;
/*     */           case '"':
/* 229 */             out.write(92);
/* 230 */             out.write(34);
/*     */             break;
/*     */           case '\\':
/* 233 */             out.write(92);
/* 234 */             out.write(92);
/*     */             break;
/*     */           default:
/* 237 */             out.write(ch);
/*     */             break;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String hex(char ch) {
/* 252 */     return Integer.toHexString(ch).toUpperCase();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String unescapeJava(String str) {
/* 265 */     if (str == null) {
/* 266 */       return null;
/*     */     }
/*     */     try {
/* 269 */       StringWriter writer = new StringWriter(str.length());
/* 270 */       unescapeJava(writer, str);
/* 271 */       return writer.toString();
/*     */     } catch (IOException ioe) {
/*     */       
/* 274 */       ioe.printStackTrace();
/* 275 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void unescapeJava(Writer out, String str) throws IOException {
/* 295 */     if (out == null) {
/* 296 */       throw new IllegalArgumentException("The Writer must not be null");
/*     */     }
/* 298 */     if (str == null) {
/*     */       return;
/*     */     }
/* 301 */     int sz = str.length();
/* 302 */     StringBuffer unicode = new StringBuffer(4);
/* 303 */     boolean hadSlash = false;
/* 304 */     boolean inUnicode = false;
/* 305 */     for (int i = 0; i < sz; i++) {
/* 306 */       char ch = str.charAt(i);
/* 307 */       if (inUnicode) {
/*     */ 
/*     */         
/* 310 */         unicode.append(ch);
/* 311 */         if (unicode.length() == 4) {
/*     */           
/*     */           try {
/*     */             
/* 315 */             int value = Integer.parseInt(unicode.toString(), 16);
/* 316 */             out.write((char)value);
/* 317 */             unicode.setLength(0);
/* 318 */             inUnicode = false;
/* 319 */             hadSlash = false;
/*     */           } catch (NumberFormatException nfe) {
/* 321 */             throw new NestableRuntimeException("Unable to parse unicode value: " + unicode, nfe);
/*     */           }
/*     */         
/*     */         }
/*     */       }
/* 326 */       else if (hadSlash) {
/*     */         
/* 328 */         hadSlash = false;
/* 329 */         switch (ch) {
/*     */           case '\\':
/* 331 */             out.write(92);
/*     */             break;
/*     */           case '\'':
/* 334 */             out.write(39);
/*     */             break;
/*     */           case '"':
/* 337 */             out.write(34);
/*     */             break;
/*     */           case 'r':
/* 340 */             out.write(13);
/*     */             break;
/*     */           case 'f':
/* 343 */             out.write(12);
/*     */             break;
/*     */           case 't':
/* 346 */             out.write(9);
/*     */             break;
/*     */           case 'n':
/* 349 */             out.write(10);
/*     */             break;
/*     */           case 'b':
/* 352 */             out.write(8);
/*     */             break;
/*     */ 
/*     */           
/*     */           case 'u':
/* 357 */             inUnicode = true;
/*     */             break;
/*     */           
/*     */           default:
/* 361 */             out.write(ch);
/*     */             break;
/*     */         } 
/*     */       
/* 365 */       } else if (ch == '\\') {
/* 366 */         hadSlash = true;
/*     */       } else {
/*     */         
/* 369 */         out.write(ch);
/*     */       } 
/* 371 */     }  if (hadSlash)
/*     */     {
/*     */       
/* 374 */       out.write(92);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String unescapeJavaScript(String str) {
/* 390 */     return unescapeJava(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void unescapeJavaScript(Writer out, String str) throws IOException {
/* 410 */     unescapeJava(out, str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String escapeHtml(String str) {
/* 442 */     if (str == null) {
/* 443 */       return null;
/*     */     }
/*     */     try {
/* 446 */       StringWriter writer = new StringWriter((int)(str.length() * 1.5D));
/* 447 */       escapeHtml(writer, str);
/* 448 */       return writer.toString();
/*     */     }
/*     */     catch (IOException e) {
/*     */       
/* 452 */       e.printStackTrace();
/* 453 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void escapeHtml(Writer writer, String string) throws IOException {
/* 487 */     if (writer == null) {
/* 488 */       throw new IllegalArgumentException("The Writer must not be null.");
/*     */     }
/* 490 */     if (string == null) {
/*     */       return;
/*     */     }
/* 493 */     Entities.HTML40.escape(writer, string);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String unescapeHtml(String str) {
/* 514 */     if (str == null) {
/* 515 */       return null;
/*     */     }
/*     */     try {
/* 518 */       StringWriter writer = new StringWriter((int)(str.length() * 1.5D));
/* 519 */       unescapeHtml(writer, str);
/* 520 */       return writer.toString();
/*     */     }
/*     */     catch (IOException e) {
/*     */       
/* 524 */       e.printStackTrace();
/* 525 */       return null;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void unescapeHtml(Writer writer, String string) throws IOException {
/* 548 */     if (writer == null) {
/* 549 */       throw new IllegalArgumentException("The Writer must not be null.");
/*     */     }
/* 551 */     if (string == null) {
/*     */       return;
/*     */     }
/* 554 */     Entities.HTML40.unescape(writer, string);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void escapeXml(Writer writer, String str) throws IOException {
/* 578 */     if (writer == null) {
/* 579 */       throw new IllegalArgumentException("The Writer must not be null.");
/*     */     }
/* 581 */     if (str == null) {
/*     */       return;
/*     */     }
/* 584 */     Entities.XML.escape(writer, str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String escapeXml(String str) {
/* 605 */     if (str == null) {
/* 606 */       return null;
/*     */     }
/* 608 */     return Entities.XML.escape(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void unescapeXml(Writer writer, String str) throws IOException {
/* 630 */     if (writer == null) {
/* 631 */       throw new IllegalArgumentException("The Writer must not be null.");
/*     */     }
/* 633 */     if (str == null) {
/*     */       return;
/*     */     }
/* 636 */     Entities.XML.unescape(writer, str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String unescapeXml(String str) {
/* 655 */     if (str == null) {
/* 656 */       return null;
/*     */     }
/* 658 */     return Entities.XML.unescape(str);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String escapeSql(String str) {
/* 681 */     if (str == null) {
/* 682 */       return null;
/*     */     }
/* 684 */     return StringUtils.replace(str, "'", "''");
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\StringEscapeUtils.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */