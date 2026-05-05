/*     */ package org.apache.commons.lang;
/*     */ 
/*     */ import java.util.Random;
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
/*     */ public class RandomStringUtils
/*     */ {
/*  45 */   private static final Random RANDOM = new Random();
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
/*     */   public static String random(int count) {
/*  71 */     return random(count, false, false);
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
/*     */   public static String randomAscii(int count) {
/*  85 */     return random(count, 32, 127, false, false);
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
/*     */   public static String randomAlphabetic(int count) {
/*  99 */     return random(count, true, false);
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
/*     */   public static String randomAlphanumeric(int count) {
/* 113 */     return random(count, true, true);
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
/*     */   public static String randomNumeric(int count) {
/* 127 */     return random(count, false, true);
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
/*     */   public static String random(int count, boolean letters, boolean numbers) {
/* 145 */     return random(count, 0, 0, letters, numbers);
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
/*     */   public static String random(int count, int start, int end, boolean letters, boolean numbers) {
/* 165 */     return random(count, start, end, letters, numbers, null, RANDOM);
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
/*     */   public static String random(int count, int start, int end, boolean letters, boolean numbers, char[] chars) {
/* 189 */     return random(count, start, end, letters, numbers, chars, RANDOM);
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String random(int count, int start, int end, boolean letters, boolean numbers, char[] chars, Random random) {
/* 227 */     if (count == 0)
/* 228 */       return ""; 
/* 229 */     if (count < 0) {
/* 230 */       throw new IllegalArgumentException("Requested random string length " + count + " is less than 0.");
/*     */     }
/* 232 */     if (start == 0 && end == 0) {
/* 233 */       end = 123;
/* 234 */       start = 32;
/* 235 */       if (!letters && !numbers) {
/* 236 */         start = 0;
/* 237 */         end = Integer.MAX_VALUE;
/*     */       } 
/*     */     } 
/*     */     
/* 241 */     char[] buffer = new char[count];
/* 242 */     int gap = end - start;
/*     */     
/* 244 */     while (count-- != 0) {
/*     */       char c;
/* 246 */       if (chars == null) {
/* 247 */         c = (char)(random.nextInt(gap) + start);
/*     */       } else {
/* 249 */         c = chars[random.nextInt(gap) + start];
/*     */       } 
/* 251 */       if ((letters && Character.isLetter(c)) || (numbers && Character.isDigit(c)) || (!letters && !numbers)) {
/*     */ 
/*     */ 
/*     */         
/* 255 */         if (c >= '?' && c <= '?') {
/* 256 */           if (count == 0) {
/* 257 */             count++;
/*     */             continue;
/*     */           } 
/* 260 */           buffer[count] = c;
/* 261 */           count--;
/* 262 */           buffer[count] = (char)(55296 + random.nextInt(128)); continue;
/*     */         } 
/* 264 */         if (c >= '?' && c <= '?') {
/* 265 */           if (count == 0) {
/* 266 */             count++;
/*     */             continue;
/*     */           } 
/* 269 */           buffer[count] = (char)(56320 + random.nextInt(128));
/* 270 */           count--;
/* 271 */           buffer[count] = c; continue;
/*     */         } 
/* 273 */         if (c >= '?' && c <= '?') {
/*     */           
/* 275 */           count++; continue;
/*     */         } 
/* 277 */         buffer[count] = c;
/*     */         continue;
/*     */       } 
/* 280 */       count++;
/*     */     } 
/*     */     
/* 283 */     return new String(buffer);
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
/*     */   public static String random(int count, String chars) {
/* 300 */     if (chars == null) {
/* 301 */       return random(count, 0, 0, false, false, null, RANDOM);
/*     */     }
/* 303 */     return random(count, chars.toCharArray());
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
/*     */   public static String random(int count, char[] chars) {
/* 319 */     if (chars == null) {
/* 320 */       return random(count, 0, 0, false, false, null, RANDOM);
/*     */     }
/* 322 */     return random(count, 0, chars.length, false, false, chars, RANDOM);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\RandomStringUtils.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */