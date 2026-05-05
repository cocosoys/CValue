/*     */ package org.apache.commons.lang;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class NumberUtils
/*     */ {
/*     */   public static int stringToInt(String str) {
/*  61 */     return stringToInt(str, 0);
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
/*     */   public static int stringToInt(String str, int defaultValue) {
/*     */     try {
/*  74 */       return Integer.parseInt(str);
/*     */     } catch (NumberFormatException nfe) {
/*  76 */       return defaultValue;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Number createNumber(String val) throws NumberFormatException {
/*     */     Object object;
/*     */     String str1, str2;
/* 139 */     if (val == null) {
/* 140 */       return null;
/*     */     }
/* 142 */     if (val.length() == 0) {
/* 143 */       throw new NumberFormatException("\"\" is not a valid number.");
/*     */     }
/* 145 */     if (val.startsWith("--"))
/*     */     {
/*     */ 
/*     */ 
/*     */       
/* 150 */       return null;
/*     */     }
/* 152 */     if (val.startsWith("0x") || val.startsWith("-0x")) {
/* 153 */       return createInteger(val);
/*     */     }
/* 155 */     char lastChar = val.charAt(val.length() - 1);
/*     */ 
/*     */ 
/*     */     
/* 159 */     int decPos = val.indexOf('.');
/* 160 */     int expPos = val.indexOf('e') + val.indexOf('E') + 1;
/*     */     
/* 162 */     if (decPos > -1) {
/*     */       
/* 164 */       if (expPos > -1) {
/* 165 */         if (expPos < decPos) {
/* 166 */           throw new NumberFormatException(val + " is not a valid number.");
/*     */         }
/* 168 */         object = val.substring(decPos + 1, expPos);
/*     */       } else {
/* 170 */         object = val.substring(decPos + 1);
/*     */       } 
/* 172 */       str1 = val.substring(0, decPos);
/*     */     } else {
/* 174 */       if (expPos > -1) {
/* 175 */         str1 = val.substring(0, expPos);
/*     */       } else {
/* 177 */         str1 = val;
/*     */       } 
/* 179 */       object = null;
/*     */     } 
/* 181 */     if (!Character.isDigit(lastChar)) {
/* 182 */       if (expPos > -1 && expPos < val.length() - 1) {
/* 183 */         str2 = val.substring(expPos + 1, val.length() - 1);
/*     */       } else {
/* 185 */         str2 = null;
/*     */       } 
/*     */       
/* 188 */       String numeric = val.substring(0, val.length() - 1);
/* 189 */       boolean bool = (isAllZeros(str1) && isAllZeros(str2));
/* 190 */       switch (lastChar) {
/*     */         case 'L':
/*     */         case 'l':
/* 193 */           if (object == null && str2 == null && ((numeric.charAt(0) == '-' && isDigits(numeric.substring(1))) || isDigits(numeric))) {
/*     */             
/*     */             try {
/*     */               
/* 197 */               return createLong(numeric);
/* 198 */             } catch (NumberFormatException nfe) {
/*     */ 
/*     */               
/* 201 */               return createBigInteger(numeric);
/*     */             } 
/*     */           }
/* 204 */           throw new NumberFormatException(val + " is not a valid number.");
/*     */         case 'F':
/*     */         case 'f':
/*     */           try {
/* 208 */             Float f = createFloat(numeric);
/* 209 */             if (!f.isInfinite() && (f.floatValue() != 0.0F || bool))
/*     */             {
/*     */               
/* 212 */               return f;
/*     */             }
/*     */           }
/* 215 */           catch (NumberFormatException e) {}
/*     */ 
/*     */ 
/*     */         
/*     */         case 'D':
/*     */         case 'd':
/*     */           try {
/* 222 */             Double d = createDouble(numeric);
/* 223 */             if (!d.isInfinite() && (d.floatValue() != 0.0D || bool)) {
/* 224 */               return d;
/*     */             }
/* 226 */           } catch (NumberFormatException nfe) {}
/*     */ 
/*     */           
/*     */           try {
/* 230 */             return createBigDecimal(numeric);
/* 231 */           } catch (NumberFormatException e) {
/*     */             break;
/*     */           } 
/*     */       } 
/*     */       
/* 236 */       throw new NumberFormatException(val + " is not a valid number.");
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 242 */     if (expPos > -1 && expPos < val.length() - 1) {
/* 243 */       str2 = val.substring(expPos + 1, val.length());
/*     */     } else {
/* 245 */       str2 = null;
/*     */     } 
/* 247 */     if (object == null && str2 == null) {
/*     */       
/*     */       try {
/* 250 */         return createInteger(val);
/* 251 */       } catch (NumberFormatException nfe) {
/*     */ 
/*     */         
/*     */         try {
/* 255 */           return createLong(val);
/* 256 */         } catch (NumberFormatException numberFormatException) {
/*     */ 
/*     */           
/* 259 */           return createBigInteger(val);
/*     */         } 
/*     */       } 
/*     */     }
/* 263 */     boolean allZeros = (isAllZeros(str1) && isAllZeros(str2));
/*     */     try {
/* 265 */       Float f = createFloat(val);
/* 266 */       if (!f.isInfinite() && (f.floatValue() != 0.0F || allZeros)) {
/* 267 */         return f;
/*     */       }
/* 269 */     } catch (NumberFormatException nfe) {}
/*     */ 
/*     */     
/*     */     try {
/* 273 */       Double d = createDouble(val);
/* 274 */       if (!d.isInfinite() && (d.doubleValue() != 0.0D || allZeros)) {
/* 275 */         return d;
/*     */       }
/* 277 */     } catch (NumberFormatException nfe) {}
/*     */ 
/*     */ 
/*     */     
/* 281 */     return createBigDecimal(val);
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
/*     */   private static boolean isAllZeros(String s) {
/* 297 */     if (s == null) {
/* 298 */       return true;
/*     */     }
/* 300 */     for (int i = s.length() - 1; i >= 0; i--) {
/* 301 */       if (s.charAt(i) != '0') {
/* 302 */         return false;
/*     */       }
/*     */     } 
/* 305 */     return (s.length() > 0);
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
/*     */   public static Float createFloat(String val) {
/* 318 */     return Float.valueOf(val);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Double createDouble(String val) {
/* 329 */     return Double.valueOf(val);
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
/*     */   public static Integer createInteger(String val) {
/* 342 */     return Integer.decode(val);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Long createLong(String val) {
/* 353 */     return Long.valueOf(val);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BigInteger createBigInteger(String val) {
/* 364 */     BigInteger bi = new BigInteger(val);
/* 365 */     return bi;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static BigDecimal createBigDecimal(String val) {
/* 376 */     BigDecimal bd = new BigDecimal(val);
/* 377 */     return bd;
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
/*     */   public static long minimum(long a, long b, long c) {
/* 391 */     if (b < a) {
/* 392 */       a = b;
/*     */     }
/* 394 */     if (c < a) {
/* 395 */       a = c;
/*     */     }
/* 397 */     return a;
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
/*     */   public static int minimum(int a, int b, int c) {
/* 409 */     if (b < a) {
/* 410 */       a = b;
/*     */     }
/* 412 */     if (c < a) {
/* 413 */       a = c;
/*     */     }
/* 415 */     return a;
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
/*     */   public static long maximum(long a, long b, long c) {
/* 427 */     if (b > a) {
/* 428 */       a = b;
/*     */     }
/* 430 */     if (c > a) {
/* 431 */       a = c;
/*     */     }
/* 433 */     return a;
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
/*     */   public static int maximum(int a, int b, int c) {
/* 445 */     if (b > a) {
/* 446 */       a = b;
/*     */     }
/* 448 */     if (c > a) {
/* 449 */       a = c;
/*     */     }
/* 451 */     return a;
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
/*     */ 
/*     */   
/*     */   public static int compare(double lhs, double rhs) {
/* 491 */     if (lhs < rhs) {
/* 492 */       return -1;
/*     */     }
/* 494 */     if (lhs > rhs) {
/* 495 */       return 1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 501 */     long lhsBits = Double.doubleToLongBits(lhs);
/* 502 */     long rhsBits = Double.doubleToLongBits(rhs);
/* 503 */     if (lhsBits == rhsBits) {
/* 504 */       return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 512 */     if (lhsBits < rhsBits) {
/* 513 */       return -1;
/*     */     }
/* 515 */     return 1;
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
/*     */   public static int compare(float lhs, float rhs) {
/* 552 */     if (lhs < rhs) {
/* 553 */       return -1;
/*     */     }
/* 555 */     if (lhs > rhs) {
/* 556 */       return 1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 562 */     int lhsBits = Float.floatToIntBits(lhs);
/* 563 */     int rhsBits = Float.floatToIntBits(rhs);
/* 564 */     if (lhsBits == rhsBits) {
/* 565 */       return 0;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 573 */     if (lhsBits < rhsBits) {
/* 574 */       return -1;
/*     */     }
/* 576 */     return 1;
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
/*     */   public static boolean isDigits(String str) {
/* 593 */     if (str == null || str.length() == 0) {
/* 594 */       return false;
/*     */     }
/* 596 */     for (int i = 0; i < str.length(); i++) {
/* 597 */       if (!Character.isDigit(str.charAt(i))) {
/* 598 */         return false;
/*     */       }
/*     */     } 
/* 601 */     return true;
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
/*     */   public static boolean isNumber(String str) {
/* 618 */     if (StringUtils.isEmpty(str)) {
/* 619 */       return false;
/*     */     }
/* 621 */     char[] chars = str.toCharArray();
/* 622 */     int sz = chars.length;
/* 623 */     boolean hasExp = false;
/* 624 */     boolean hasDecPoint = false;
/* 625 */     boolean allowSigns = false;
/* 626 */     boolean foundDigit = false;
/*     */     
/* 628 */     int start = (chars[0] == '-') ? 1 : 0;
/* 629 */     if (sz > start + 1 && 
/* 630 */       chars[start] == '0' && chars[start + 1] == 'x') {
/* 631 */       int j = start + 2;
/* 632 */       if (j == sz) {
/* 633 */         return false;
/*     */       }
/*     */       
/* 636 */       for (; j < chars.length; j++) {
/* 637 */         if ((chars[j] < '0' || chars[j] > '9') && (chars[j] < 'a' || chars[j] > 'f') && (chars[j] < 'A' || chars[j] > 'F'))
/*     */         {
/*     */           
/* 640 */           return false;
/*     */         }
/*     */       } 
/* 643 */       return true;
/*     */     } 
/*     */     
/* 646 */     sz--;
/*     */     
/* 648 */     int i = start;
/*     */ 
/*     */     
/* 651 */     while (i < sz || (i < sz + 1 && allowSigns && !foundDigit)) {
/* 652 */       if (chars[i] >= '0' && chars[i] <= '9') {
/* 653 */         foundDigit = true;
/* 654 */         allowSigns = false;
/*     */       }
/* 656 */       else if (chars[i] == '.') {
/* 657 */         if (hasDecPoint || hasExp)
/*     */         {
/* 659 */           return false;
/*     */         }
/* 661 */         hasDecPoint = true;
/* 662 */       } else if (chars[i] == 'e' || chars[i] == 'E') {
/*     */         
/* 664 */         if (hasExp)
/*     */         {
/* 666 */           return false;
/*     */         }
/* 668 */         if (!foundDigit) {
/* 669 */           return false;
/*     */         }
/* 671 */         hasExp = true;
/* 672 */         allowSigns = true;
/* 673 */       } else if (chars[i] == '+' || chars[i] == '-') {
/* 674 */         if (!allowSigns) {
/* 675 */           return false;
/*     */         }
/* 677 */         allowSigns = false;
/* 678 */         foundDigit = false;
/*     */       } else {
/* 680 */         return false;
/*     */       } 
/* 682 */       i++;
/*     */     } 
/* 684 */     if (i < chars.length) {
/* 685 */       if (chars[i] >= '0' && chars[i] <= '9')
/*     */       {
/* 687 */         return true;
/*     */       }
/* 689 */       if (chars[i] == 'e' || chars[i] == 'E')
/*     */       {
/* 691 */         return false;
/*     */       }
/* 693 */       if (!allowSigns && (chars[i] == 'd' || chars[i] == 'D' || chars[i] == 'f' || chars[i] == 'F'))
/*     */       {
/*     */ 
/*     */ 
/*     */         
/* 698 */         return foundDigit;
/*     */       }
/* 700 */       if (chars[i] == 'l' || chars[i] == 'L')
/*     */       {
/*     */         
/* 703 */         return (foundDigit && !hasExp);
/*     */       }
/*     */       
/* 706 */       return false;
/*     */     } 
/*     */ 
/*     */     
/* 710 */     return (!allowSigns && foundDigit);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\NumberUtils.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */