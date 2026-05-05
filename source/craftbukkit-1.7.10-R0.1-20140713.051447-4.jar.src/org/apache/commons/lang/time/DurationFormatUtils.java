/*     */ package org.apache.commons.lang.time;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.TimeZone;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DurationFormatUtils
/*     */ {
/*     */   public static final String ISO_EXTENDED_FORMAT_PATTERN = "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'";
/*     */   
/*     */   public static String formatDurationHMS(long durationMillis) {
/*  81 */     return formatDuration(durationMillis, "H:mm:ss.SSS");
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
/*     */   public static String formatDurationISO(long durationMillis) {
/*  96 */     return formatDuration(durationMillis, "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'", false);
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
/*     */   public static String formatDuration(long durationMillis, String format) {
/* 111 */     return formatDuration(durationMillis, format, true);
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
/*     */   public static String formatDuration(long durationMillis, String format, boolean padWithZeros) {
/* 129 */     Token[] tokens = lexx(format);
/*     */     
/* 131 */     int days = 0;
/* 132 */     int hours = 0;
/* 133 */     int minutes = 0;
/* 134 */     int seconds = 0;
/* 135 */     int milliseconds = 0;
/*     */     
/* 137 */     if (Token.containsTokenWithValue(tokens, d)) {
/* 138 */       days = (int)(durationMillis / 86400000L);
/* 139 */       durationMillis -= days * 86400000L;
/*     */     } 
/* 141 */     if (Token.containsTokenWithValue(tokens, H)) {
/* 142 */       hours = (int)(durationMillis / 3600000L);
/* 143 */       durationMillis -= hours * 3600000L;
/*     */     } 
/* 145 */     if (Token.containsTokenWithValue(tokens, m)) {
/* 146 */       minutes = (int)(durationMillis / 60000L);
/* 147 */       durationMillis -= minutes * 60000L;
/*     */     } 
/* 149 */     if (Token.containsTokenWithValue(tokens, s)) {
/* 150 */       seconds = (int)(durationMillis / 1000L);
/* 151 */       durationMillis -= seconds * 1000L;
/*     */     } 
/* 153 */     if (Token.containsTokenWithValue(tokens, S)) {
/* 154 */       milliseconds = (int)durationMillis;
/*     */     }
/*     */     
/* 157 */     return format(tokens, 0, 0, days, hours, minutes, seconds, milliseconds, padWithZeros);
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
/*     */   public static String formatDurationWords(long durationMillis, boolean suppressLeadingZeroElements, boolean suppressTrailingZeroElements) {
/* 179 */     String duration = formatDuration(durationMillis, "d' days 'H' hours 'm' minutes 's' seconds'");
/* 180 */     if (suppressLeadingZeroElements) {
/*     */       
/* 182 */       duration = " " + duration;
/* 183 */       String tmp = StringUtils.replaceOnce(duration, " 0 days", "");
/* 184 */       if (tmp.length() != duration.length()) {
/* 185 */         duration = tmp;
/* 186 */         tmp = StringUtils.replaceOnce(duration, " 0 hours", "");
/* 187 */         if (tmp.length() != duration.length()) {
/* 188 */           duration = tmp;
/* 189 */           tmp = StringUtils.replaceOnce(duration, " 0 minutes", "");
/* 190 */           duration = tmp;
/* 191 */           if (tmp.length() != duration.length()) {
/* 192 */             duration = StringUtils.replaceOnce(tmp, " 0 seconds", "");
/*     */           }
/*     */         } 
/*     */       } 
/* 196 */       if (duration.length() != 0)
/*     */       {
/* 198 */         duration = duration.substring(1);
/*     */       }
/*     */     } 
/* 201 */     if (suppressTrailingZeroElements) {
/* 202 */       String tmp = StringUtils.replaceOnce(duration, " 0 seconds", "");
/* 203 */       if (tmp.length() != duration.length()) {
/* 204 */         duration = tmp;
/* 205 */         tmp = StringUtils.replaceOnce(duration, " 0 minutes", "");
/* 206 */         if (tmp.length() != duration.length()) {
/* 207 */           duration = tmp;
/* 208 */           tmp = StringUtils.replaceOnce(duration, " 0 hours", "");
/* 209 */           if (tmp.length() != duration.length()) {
/* 210 */             duration = StringUtils.replaceOnce(tmp, " 0 days", "");
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 216 */     duration = " " + duration;
/* 217 */     duration = StringUtils.replaceOnce(duration, " 1 seconds", " 1 second");
/* 218 */     duration = StringUtils.replaceOnce(duration, " 1 minutes", " 1 minute");
/* 219 */     duration = StringUtils.replaceOnce(duration, " 1 hours", " 1 hour");
/* 220 */     duration = StringUtils.replaceOnce(duration, " 1 days", " 1 day");
/* 221 */     return duration.trim();
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
/*     */   public static String formatPeriodISO(long startMillis, long endMillis) {
/* 235 */     return formatPeriod(startMillis, endMillis, "'P'yyyy'Y'M'M'd'DT'H'H'm'M's.S'S'", false, TimeZone.getDefault());
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
/*     */   public static String formatPeriod(long startMillis, long endMillis, String format) {
/* 248 */     return formatPeriod(startMillis, endMillis, format, true, TimeZone.getDefault());
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
/*     */   public static String formatPeriod(long startMillis, long endMillis, String format, boolean padWithZeros, TimeZone timezone) {
/* 283 */     Token[] tokens = lexx(format);
/*     */ 
/*     */ 
/*     */     
/* 287 */     Calendar start = Calendar.getInstance(timezone);
/* 288 */     start.setTime(new Date(startMillis));
/* 289 */     Calendar end = Calendar.getInstance(timezone);
/* 290 */     end.setTime(new Date(endMillis));
/*     */ 
/*     */     
/* 293 */     int milliseconds = end.get(14) - start.get(14);
/* 294 */     int seconds = end.get(13) - start.get(13);
/* 295 */     int minutes = end.get(12) - start.get(12);
/* 296 */     int hours = end.get(11) - start.get(11);
/* 297 */     int days = end.get(5) - start.get(5);
/* 298 */     int months = end.get(2) - start.get(2);
/* 299 */     int years = end.get(1) - start.get(1);
/*     */ 
/*     */     
/* 302 */     while (milliseconds < 0) {
/* 303 */       milliseconds += 1000;
/* 304 */       seconds--;
/*     */     } 
/* 306 */     while (seconds < 0) {
/* 307 */       seconds += 60;
/* 308 */       minutes--;
/*     */     } 
/* 310 */     while (minutes < 0) {
/* 311 */       minutes += 60;
/* 312 */       hours--;
/*     */     } 
/* 314 */     while (hours < 0) {
/* 315 */       hours += 24;
/* 316 */       days--;
/*     */     } 
/*     */     
/* 319 */     if (Token.containsTokenWithValue(tokens, M)) {
/* 320 */       while (days < 0) {
/* 321 */         days += start.getActualMaximum(5);
/* 322 */         months--;
/* 323 */         start.add(2, 1);
/*     */       } 
/*     */       
/* 326 */       while (months < 0) {
/* 327 */         months += 12;
/* 328 */         years--;
/*     */       } 
/*     */       
/* 331 */       if (!Token.containsTokenWithValue(tokens, y) && years != 0) {
/* 332 */         while (years != 0) {
/* 333 */           months += 12 * years;
/* 334 */           years = 0;
/*     */         }
/*     */       
/*     */       }
/*     */     } else {
/*     */       
/* 340 */       if (!Token.containsTokenWithValue(tokens, y)) {
/* 341 */         int target = end.get(1);
/* 342 */         if (months < 0)
/*     */         {
/* 344 */           target--;
/*     */         }
/*     */         
/* 347 */         while (start.get(1) != target) {
/* 348 */           days += start.getActualMaximum(6) - start.get(6);
/*     */ 
/*     */           
/* 351 */           if (start instanceof java.util.GregorianCalendar && 
/* 352 */             start.get(2) == 1 && start.get(5) == 29)
/*     */           {
/*     */             
/* 355 */             days++;
/*     */           }
/*     */ 
/*     */           
/* 359 */           start.add(1, 1);
/*     */           
/* 361 */           days += start.get(6);
/*     */         } 
/*     */         
/* 364 */         years = 0;
/*     */       } 
/*     */       
/* 367 */       while (start.get(2) != end.get(2)) {
/* 368 */         days += start.getActualMaximum(5);
/* 369 */         start.add(2, 1);
/*     */       } 
/*     */       
/* 372 */       months = 0;
/*     */       
/* 374 */       while (days < 0) {
/* 375 */         days += start.getActualMaximum(5);
/* 376 */         months--;
/* 377 */         start.add(2, 1);
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 386 */     if (!Token.containsTokenWithValue(tokens, d)) {
/* 387 */       hours += 24 * days;
/* 388 */       days = 0;
/*     */     } 
/* 390 */     if (!Token.containsTokenWithValue(tokens, H)) {
/* 391 */       minutes += 60 * hours;
/* 392 */       hours = 0;
/*     */     } 
/* 394 */     if (!Token.containsTokenWithValue(tokens, m)) {
/* 395 */       seconds += 60 * minutes;
/* 396 */       minutes = 0;
/*     */     } 
/* 398 */     if (!Token.containsTokenWithValue(tokens, s)) {
/* 399 */       milliseconds += 1000 * seconds;
/* 400 */       seconds = 0;
/*     */     } 
/*     */     
/* 403 */     return format(tokens, years, months, days, hours, minutes, seconds, milliseconds, padWithZeros);
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
/*     */   static String format(Token[] tokens, int years, int months, int days, int hours, int minutes, int seconds, int milliseconds, boolean padWithZeros) {
/* 423 */     StringBuffer buffer = new StringBuffer();
/* 424 */     boolean lastOutputSeconds = false;
/* 425 */     int sz = tokens.length;
/* 426 */     for (int i = 0; i < sz; i++) {
/* 427 */       Token token = tokens[i];
/* 428 */       Object value = token.getValue();
/* 429 */       int count = token.getCount();
/* 430 */       if (value instanceof StringBuffer) {
/* 431 */         buffer.append(value.toString());
/*     */       }
/* 433 */       else if (value == y) {
/* 434 */         buffer.append(padWithZeros ? StringUtils.leftPad(Integer.toString(years), count, '0') : Integer.toString(years));
/*     */         
/* 436 */         lastOutputSeconds = false;
/* 437 */       } else if (value == M) {
/* 438 */         buffer.append(padWithZeros ? StringUtils.leftPad(Integer.toString(months), count, '0') : Integer.toString(months));
/*     */         
/* 440 */         lastOutputSeconds = false;
/* 441 */       } else if (value == d) {
/* 442 */         buffer.append(padWithZeros ? StringUtils.leftPad(Integer.toString(days), count, '0') : Integer.toString(days));
/*     */         
/* 444 */         lastOutputSeconds = false;
/* 445 */       } else if (value == H) {
/* 446 */         buffer.append(padWithZeros ? StringUtils.leftPad(Integer.toString(hours), count, '0') : Integer.toString(hours));
/*     */         
/* 448 */         lastOutputSeconds = false;
/* 449 */       } else if (value == m) {
/* 450 */         buffer.append(padWithZeros ? StringUtils.leftPad(Integer.toString(minutes), count, '0') : Integer.toString(minutes));
/*     */         
/* 452 */         lastOutputSeconds = false;
/* 453 */       } else if (value == s) {
/* 454 */         buffer.append(padWithZeros ? StringUtils.leftPad(Integer.toString(seconds), count, '0') : Integer.toString(seconds));
/*     */         
/* 456 */         lastOutputSeconds = true;
/* 457 */       } else if (value == S) {
/* 458 */         if (lastOutputSeconds) {
/* 459 */           milliseconds += 1000;
/* 460 */           String str = padWithZeros ? StringUtils.leftPad(Integer.toString(milliseconds), count, '0') : Integer.toString(milliseconds);
/*     */ 
/*     */           
/* 463 */           buffer.append(str.substring(1));
/*     */         } else {
/* 465 */           buffer.append(padWithZeros ? StringUtils.leftPad(Integer.toString(milliseconds), count, '0') : Integer.toString(milliseconds));
/*     */         } 
/*     */ 
/*     */         
/* 469 */         lastOutputSeconds = false;
/*     */       } 
/*     */     } 
/*     */     
/* 473 */     return buffer.toString();
/*     */   }
/*     */   
/* 476 */   static final Object y = "y";
/* 477 */   static final Object M = "M";
/* 478 */   static final Object d = "d";
/* 479 */   static final Object H = "H";
/* 480 */   static final Object m = "m";
/* 481 */   static final Object s = "s";
/* 482 */   static final Object S = "S";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Token[] lexx(String format) {
/* 491 */     char[] array = format.toCharArray();
/* 492 */     ArrayList list = new ArrayList(array.length);
/*     */     
/* 494 */     boolean inLiteral = false;
/* 495 */     StringBuffer buffer = null;
/* 496 */     Token previous = null;
/* 497 */     int sz = array.length;
/* 498 */     for (int i = 0; i < sz; i++) {
/* 499 */       char ch = array[i];
/* 500 */       if (inLiteral && ch != '\'') {
/* 501 */         buffer.append(ch);
/*     */       } else {
/*     */         
/* 504 */         Object value = null;
/* 505 */         switch (ch) {
/*     */           
/*     */           case '\'':
/* 508 */             if (inLiteral) {
/* 509 */               buffer = null;
/* 510 */               inLiteral = false; break;
/*     */             } 
/* 512 */             buffer = new StringBuffer();
/* 513 */             list.add(new Token(buffer));
/* 514 */             inLiteral = true;
/*     */             break;
/*     */           case 'y':
/* 517 */             value = y; break;
/* 518 */           case 'M': value = M; break;
/* 519 */           case 'd': value = d; break;
/* 520 */           case 'H': value = H; break;
/* 521 */           case 'm': value = m; break;
/* 522 */           case 's': value = s; break;
/* 523 */           case 'S': value = S; break;
/*     */           default:
/* 525 */             if (buffer == null) {
/* 526 */               buffer = new StringBuffer();
/* 527 */               list.add(new Token(buffer));
/*     */             } 
/* 529 */             buffer.append(ch);
/*     */             break;
/*     */         } 
/* 532 */         if (value != null) {
/* 533 */           if (previous != null && previous.getValue() == value) {
/* 534 */             previous.increment();
/*     */           } else {
/* 536 */             Token token = new Token(value);
/* 537 */             list.add(token);
/* 538 */             previous = token;
/*     */           } 
/* 540 */           buffer = null;
/*     */         } 
/*     */       } 
/* 543 */     }  return list.<Token>toArray(new Token[list.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class Token
/*     */   {
/*     */     private Object value;
/*     */ 
/*     */     
/*     */     private int count;
/*     */ 
/*     */ 
/*     */     
/*     */     static boolean containsTokenWithValue(Token[] tokens, Object value) {
/* 559 */       int sz = tokens.length;
/* 560 */       for (int i = 0; i < sz; i++) {
/* 561 */         if (tokens[i].getValue() == value) {
/* 562 */           return true;
/*     */         }
/*     */       } 
/* 565 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Token(Object value) {
/* 577 */       this.value = value;
/* 578 */       this.count = 1;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Token(Object value, int count) {
/* 589 */       this.value = value;
/* 590 */       this.count = count;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     void increment() {
/* 597 */       this.count++;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     int getCount() {
/* 606 */       return this.count;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     Object getValue() {
/* 615 */       return this.value;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean equals(Object obj2) {
/* 625 */       if (obj2 instanceof Token) {
/* 626 */         Token tok2 = (Token)obj2;
/* 627 */         if (this.value.getClass() != tok2.value.getClass()) {
/* 628 */           return false;
/*     */         }
/* 630 */         if (this.count != tok2.count) {
/* 631 */           return false;
/*     */         }
/* 633 */         if (this.value instanceof StringBuffer)
/* 634 */           return this.value.toString().equals(tok2.value.toString()); 
/* 635 */         if (this.value instanceof Number) {
/* 636 */           return this.value.equals(tok2.value);
/*     */         }
/* 638 */         return (this.value == tok2.value);
/*     */       } 
/*     */       
/* 641 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int hashCode() {
/* 652 */       return this.value.hashCode();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String toString() {
/* 661 */       return StringUtils.repeat(this.value.toString(), this.count);
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\time\DurationFormatUtils.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */