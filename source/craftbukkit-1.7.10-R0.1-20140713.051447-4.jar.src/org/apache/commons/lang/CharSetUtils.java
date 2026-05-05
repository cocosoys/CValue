/*     */ package org.apache.commons.lang;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class CharSetUtils
/*     */ {
/*     */   public static CharSet evaluateSet(String[] set) {
/*  70 */     if (set == null) {
/*  71 */       return null;
/*     */     }
/*  73 */     return new CharSet(set);
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
/*     */   public static String squeeze(String str, String set) {
/*  97 */     if (StringUtils.isEmpty(str) || StringUtils.isEmpty(set)) {
/*  98 */       return str;
/*     */     }
/* 100 */     String[] strs = new String[1];
/* 101 */     strs[0] = set;
/* 102 */     return squeeze(str, strs);
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
/*     */   public static String squeeze(String str, String[] set) {
/* 120 */     if (StringUtils.isEmpty(str) || ArrayUtils.isEmpty((Object[])set)) {
/* 121 */       return str;
/*     */     }
/* 123 */     CharSet chars = evaluateSet(set);
/* 124 */     StringBuffer buffer = new StringBuffer(str.length());
/* 125 */     char[] chrs = str.toCharArray();
/* 126 */     int sz = chrs.length;
/* 127 */     char lastChar = ' ';
/* 128 */     char ch = ' ';
/* 129 */     for (int i = 0; i < sz; i++) {
/* 130 */       ch = chrs[i];
/* 131 */       if (!chars.contains(ch) || 
/* 132 */         ch != lastChar || i == 0) {
/*     */ 
/*     */ 
/*     */         
/* 136 */         buffer.append(ch);
/* 137 */         lastChar = ch;
/*     */       } 
/* 139 */     }  return buffer.toString();
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
/*     */   public static int count(String str, String set) {
/* 163 */     if (StringUtils.isEmpty(str) || StringUtils.isEmpty(set)) {
/* 164 */       return 0;
/*     */     }
/* 166 */     String[] strs = new String[1];
/* 167 */     strs[0] = set;
/* 168 */     return count(str, strs);
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
/*     */   public static int count(String str, String[] set) {
/* 186 */     if (StringUtils.isEmpty(str) || ArrayUtils.isEmpty((Object[])set)) {
/* 187 */       return 0;
/*     */     }
/* 189 */     CharSet chars = evaluateSet(set);
/* 190 */     int count = 0;
/* 191 */     char[] chrs = str.toCharArray();
/* 192 */     int sz = chrs.length;
/* 193 */     for (int i = 0; i < sz; i++) {
/* 194 */       if (chars.contains(chrs[i])) {
/* 195 */         count++;
/*     */       }
/*     */     } 
/* 198 */     return count;
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
/*     */   public static String keep(String str, String set) {
/* 223 */     if (str == null) {
/* 224 */       return null;
/*     */     }
/* 226 */     if (str.length() == 0 || StringUtils.isEmpty(set)) {
/* 227 */       return "";
/*     */     }
/* 229 */     String[] strs = new String[1];
/* 230 */     strs[0] = set;
/* 231 */     return keep(str, strs);
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
/*     */   public static String keep(String str, String[] set) {
/* 251 */     if (str == null) {
/* 252 */       return null;
/*     */     }
/* 254 */     if (str.length() == 0 || ArrayUtils.isEmpty((Object[])set)) {
/* 255 */       return "";
/*     */     }
/* 257 */     return modify(str, set, true);
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
/*     */   public static String delete(String str, String set) {
/* 281 */     if (StringUtils.isEmpty(str) || StringUtils.isEmpty(set)) {
/* 282 */       return str;
/*     */     }
/* 284 */     String[] strs = new String[1];
/* 285 */     strs[0] = set;
/* 286 */     return delete(str, strs);
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
/*     */   public static String delete(String str, String[] set) {
/* 305 */     if (StringUtils.isEmpty(str) || ArrayUtils.isEmpty((Object[])set)) {
/* 306 */       return str;
/*     */     }
/* 308 */     return modify(str, set, false);
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
/*     */   private static String modify(String str, String[] set, boolean expect) {
/* 321 */     CharSet chars = evaluateSet(set);
/* 322 */     StringBuffer buffer = new StringBuffer(str.length());
/* 323 */     char[] chrs = str.toCharArray();
/* 324 */     int sz = chrs.length;
/* 325 */     for (int i = 0; i < sz; i++) {
/* 326 */       if (chars.contains(chrs[i]) == expect) {
/* 327 */         buffer.append(chrs[i]);
/*     */       }
/*     */     } 
/* 330 */     return buffer.toString();
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
/*     */   public static String translate(String str, String searchChars, String replaceChars) {
/* 368 */     if (StringUtils.isEmpty(str)) {
/* 369 */       return str;
/*     */     }
/* 371 */     StringBuffer buffer = new StringBuffer(str.length());
/* 372 */     char[] chrs = str.toCharArray();
/* 373 */     char[] withChrs = replaceChars.toCharArray();
/* 374 */     int sz = chrs.length;
/* 375 */     int withMax = replaceChars.length() - 1;
/* 376 */     for (int i = 0; i < sz; i++) {
/* 377 */       int idx = searchChars.indexOf(chrs[i]);
/* 378 */       if (idx != -1) {
/* 379 */         if (idx > withMax) {
/* 380 */           idx = withMax;
/*     */         }
/* 382 */         buffer.append(withChrs[idx]);
/*     */       } else {
/* 384 */         buffer.append(chrs[i]);
/*     */       } 
/*     */     } 
/* 387 */     return buffer.toString();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\CharSetUtils.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */