/*     */ package org.apache.commons.lang.time;
/*     */ 
/*     */ import java.text.ParseException;
/*     */ import java.text.ParsePosition;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ import java.util.Iterator;
/*     */ import java.util.NoSuchElementException;
/*     */ import java.util.TimeZone;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DateUtils
/*     */ {
/*  45 */   public static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("GMT");
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final long MILLIS_PER_SECOND = 1000L;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final long MILLIS_PER_MINUTE = 60000L;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final long MILLIS_PER_HOUR = 3600000L;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final long MILLIS_PER_DAY = 86400000L;
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int SEMI_MONTH = 1001;
/*     */ 
/*     */ 
/*     */   
/*  73 */   private static final int[][] fields = new int[][] { { 14 }, { 13 }, { 12 }, { 11, 10 }, { 5, 5, 9 }, { 2, 1001 }, { 1 }, { 0 } };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int RANGE_WEEK_SUNDAY = 1;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int RANGE_WEEK_MONDAY = 2;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int RANGE_WEEK_RELATIVE = 3;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int RANGE_WEEK_CENTER = 4;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int RANGE_MONTH_SUNDAY = 5;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int RANGE_MONTH_MONDAY = 6;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MILLIS_IN_SECOND = 1000;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MILLIS_IN_MINUTE = 60000;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MILLIS_IN_HOUR = 3600000;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final int MILLIS_IN_DAY = 86400000;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isSameDay(Date date1, Date date2) {
/* 142 */     if (date1 == null || date2 == null) {
/* 143 */       throw new IllegalArgumentException("The date must not be null");
/*     */     }
/* 145 */     Calendar cal1 = Calendar.getInstance();
/* 146 */     cal1.setTime(date1);
/* 147 */     Calendar cal2 = Calendar.getInstance();
/* 148 */     cal2.setTime(date2);
/* 149 */     return isSameDay(cal1, cal2);
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
/*     */   public static boolean isSameDay(Calendar cal1, Calendar cal2) {
/* 166 */     if (cal1 == null || cal2 == null) {
/* 167 */       throw new IllegalArgumentException("The date must not be null");
/*     */     }
/* 169 */     return (cal1.get(0) == cal2.get(0) && cal1.get(1) == cal2.get(1) && cal1.get(6) == cal2.get(6));
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
/*     */   public static boolean isSameInstant(Date date1, Date date2) {
/* 187 */     if (date1 == null || date2 == null) {
/* 188 */       throw new IllegalArgumentException("The date must not be null");
/*     */     }
/* 190 */     return (date1.getTime() == date2.getTime());
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
/*     */   public static boolean isSameInstant(Calendar cal1, Calendar cal2) {
/* 205 */     if (cal1 == null || cal2 == null) {
/* 206 */       throw new IllegalArgumentException("The date must not be null");
/*     */     }
/* 208 */     return (cal1.getTime().getTime() == cal2.getTime().getTime());
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
/*     */   public static boolean isSameLocalTime(Calendar cal1, Calendar cal2) {
/* 225 */     if (cal1 == null || cal2 == null) {
/* 226 */       throw new IllegalArgumentException("The date must not be null");
/*     */     }
/* 228 */     return (cal1.get(14) == cal2.get(14) && cal1.get(13) == cal2.get(13) && cal1.get(12) == cal2.get(12) && cal1.get(10) == cal2.get(10) && cal1.get(6) == cal2.get(6) && cal1.get(1) == cal2.get(1) && cal1.get(0) == cal2.get(0) && cal1.getClass() == cal2.getClass());
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
/*     */   public static Date parseDate(String str, String[] parsePatterns) throws ParseException {
/* 253 */     if (str == null || parsePatterns == null) {
/* 254 */       throw new IllegalArgumentException("Date and Patterns must not be null");
/*     */     }
/*     */     
/* 257 */     SimpleDateFormat parser = null;
/* 258 */     ParsePosition pos = new ParsePosition(0);
/* 259 */     for (int i = 0; i < parsePatterns.length; i++) {
/* 260 */       if (i == 0) {
/* 261 */         parser = new SimpleDateFormat(parsePatterns[0]);
/*     */       } else {
/* 263 */         parser.applyPattern(parsePatterns[i]);
/*     */       } 
/* 265 */       pos.setIndex(0);
/* 266 */       Date date = parser.parse(str, pos);
/* 267 */       if (date != null && pos.getIndex() == str.length()) {
/* 268 */         return date;
/*     */       }
/*     */     } 
/* 271 */     throw new ParseException("Unable to parse the date: " + str, -1);
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
/*     */   public static Date addYears(Date date, int amount) {
/* 285 */     return add(date, 1, amount);
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
/*     */   public static Date addMonths(Date date, int amount) {
/* 299 */     return add(date, 2, amount);
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
/*     */   public static Date addWeeks(Date date, int amount) {
/* 313 */     return add(date, 3, amount);
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
/*     */   public static Date addDays(Date date, int amount) {
/* 327 */     return add(date, 5, amount);
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
/*     */   public static Date addHours(Date date, int amount) {
/* 341 */     return add(date, 11, amount);
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
/*     */   public static Date addMinutes(Date date, int amount) {
/* 355 */     return add(date, 12, amount);
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
/*     */   public static Date addSeconds(Date date, int amount) {
/* 369 */     return add(date, 13, amount);
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
/*     */   public static Date addMilliseconds(Date date, int amount) {
/* 383 */     return add(date, 14, amount);
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
/*     */   public static Date add(Date date, int calendarField, int amount) {
/* 398 */     if (date == null) {
/* 399 */       throw new IllegalArgumentException("The date must not be null");
/*     */     }
/* 401 */     Calendar c = Calendar.getInstance();
/* 402 */     c.setTime(date);
/* 403 */     c.add(calendarField, amount);
/* 404 */     return c.getTime();
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
/*     */   public static Date round(Date date, int field) {
/* 437 */     if (date == null) {
/* 438 */       throw new IllegalArgumentException("The date must not be null");
/*     */     }
/* 440 */     Calendar gval = Calendar.getInstance();
/* 441 */     gval.setTime(date);
/* 442 */     modify(gval, field, true);
/* 443 */     return gval.getTime();
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
/*     */   public static Calendar round(Calendar date, int field) {
/* 475 */     if (date == null) {
/* 476 */       throw new IllegalArgumentException("The date must not be null");
/*     */     }
/* 478 */     Calendar rounded = (Calendar)date.clone();
/* 479 */     modify(rounded, field, true);
/* 480 */     return rounded;
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
/*     */   public static Date round(Object date, int field) {
/* 514 */     if (date == null) {
/* 515 */       throw new IllegalArgumentException("The date must not be null");
/*     */     }
/* 517 */     if (date instanceof Date)
/* 518 */       return round((Date)date, field); 
/* 519 */     if (date instanceof Calendar) {
/* 520 */       return round((Calendar)date, field).getTime();
/*     */     }
/* 522 */     throw new ClassCastException("Could not round " + date);
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
/*     */   public static Date truncate(Date date, int field) {
/* 544 */     if (date == null) {
/* 545 */       throw new IllegalArgumentException("The date must not be null");
/*     */     }
/* 547 */     Calendar gval = Calendar.getInstance();
/* 548 */     gval.setTime(date);
/* 549 */     modify(gval, field, false);
/* 550 */     return gval.getTime();
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
/*     */   public static Calendar truncate(Calendar date, int field) {
/* 570 */     if (date == null) {
/* 571 */       throw new IllegalArgumentException("The date must not be null");
/*     */     }
/* 573 */     Calendar truncated = (Calendar)date.clone();
/* 574 */     modify(truncated, field, false);
/* 575 */     return truncated;
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
/*     */   public static Date truncate(Object date, int field) {
/* 599 */     if (date == null) {
/* 600 */       throw new IllegalArgumentException("The date must not be null");
/*     */     }
/* 602 */     if (date instanceof Date)
/* 603 */       return truncate((Date)date, field); 
/* 604 */     if (date instanceof Calendar) {
/* 605 */       return truncate((Calendar)date, field).getTime();
/*     */     }
/* 607 */     throw new ClassCastException("Could not truncate " + date);
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
/*     */   private static void modify(Calendar val, int field, boolean round) {
/* 621 */     if (val.get(1) > 280000000) {
/* 622 */       throw new ArithmeticException("Calendar value too large for accurate calculations");
/*     */     }
/*     */     
/* 625 */     if (field == 14) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 635 */     Date date = val.getTime();
/* 636 */     long time = date.getTime();
/* 637 */     boolean done = false;
/*     */ 
/*     */     
/* 640 */     int millisecs = val.get(14);
/* 641 */     if (!round || millisecs < 500) {
/* 642 */       time -= millisecs;
/* 643 */       if (field == 13) {
/* 644 */         done = true;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 649 */     int seconds = val.get(13);
/* 650 */     if (!done && (!round || seconds < 30)) {
/* 651 */       time -= seconds * 1000L;
/* 652 */       if (field == 12) {
/* 653 */         done = true;
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 658 */     int minutes = val.get(12);
/* 659 */     if (!done && (!round || minutes < 30)) {
/* 660 */       time -= minutes * 60000L;
/*     */     }
/*     */ 
/*     */     
/* 664 */     if (date.getTime() != time) {
/* 665 */       date.setTime(time);
/* 666 */       val.setTime(date);
/*     */     } 
/*     */ 
/*     */     
/* 670 */     boolean roundUp = false;
/* 671 */     for (int i = 0; i < fields.length; i++) {
/* 672 */       for (int j = 0; j < (fields[i]).length; j++) {
/* 673 */         if (fields[i][j] == field) {
/*     */           
/* 675 */           if (round && roundUp) {
/* 676 */             if (field == 1001) {
/*     */ 
/*     */ 
/*     */               
/* 680 */               if (val.get(5) == 1) {
/* 681 */                 val.add(5, 15);
/*     */               } else {
/* 683 */                 val.add(5, -15);
/* 684 */                 val.add(2, 1);
/*     */               }
/*     */             
/*     */             } else {
/*     */               
/* 689 */               val.add(fields[i][0], 1);
/*     */             } 
/*     */           }
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/* 696 */       int offset = 0;
/* 697 */       boolean offsetSet = false;
/*     */       
/* 699 */       switch (field) {
/*     */         case 1001:
/* 701 */           if (fields[i][0] == 5) {
/*     */ 
/*     */ 
/*     */             
/* 705 */             offset = val.get(5) - 1;
/*     */ 
/*     */             
/* 708 */             if (offset >= 15) {
/* 709 */               offset -= 15;
/*     */             }
/*     */             
/* 712 */             roundUp = (offset > 7);
/* 713 */             offsetSet = true;
/*     */           } 
/*     */           break;
/*     */         case 9:
/* 717 */           if (fields[i][0] == 11) {
/*     */ 
/*     */             
/* 720 */             offset = val.get(11);
/* 721 */             if (offset >= 12) {
/* 722 */               offset -= 12;
/*     */             }
/* 724 */             roundUp = (offset > 6);
/* 725 */             offsetSet = true;
/*     */           } 
/*     */           break;
/*     */       } 
/* 729 */       if (!offsetSet) {
/* 730 */         int min = val.getActualMinimum(fields[i][0]);
/* 731 */         int max = val.getActualMaximum(fields[i][0]);
/*     */         
/* 733 */         offset = val.get(fields[i][0]) - min;
/*     */         
/* 735 */         roundUp = (offset > (max - min) / 2);
/*     */       } 
/*     */       
/* 738 */       if (offset != 0) {
/* 739 */         val.set(fields[i][0], val.get(fields[i][0]) - offset);
/*     */       }
/*     */     } 
/* 742 */     throw new IllegalArgumentException("The field " + field + " is not supported");
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
/*     */   public static Iterator iterator(Date focus, int rangeStyle) {
/* 772 */     if (focus == null) {
/* 773 */       throw new IllegalArgumentException("The date must not be null");
/*     */     }
/* 775 */     Calendar gval = Calendar.getInstance();
/* 776 */     gval.setTime(focus);
/* 777 */     return iterator(gval, rangeStyle);
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
/*     */   public static Iterator iterator(Calendar focus, int rangeStyle) {
/* 805 */     if (focus == null) {
/* 806 */       throw new IllegalArgumentException("The date must not be null");
/*     */     }
/* 808 */     Calendar start = null;
/* 809 */     Calendar end = null;
/* 810 */     int startCutoff = 1;
/* 811 */     int endCutoff = 7;
/* 812 */     switch (rangeStyle) {
/*     */       
/*     */       case 5:
/*     */       case 6:
/* 816 */         start = truncate(focus, 2);
/*     */         
/* 818 */         end = (Calendar)start.clone();
/* 819 */         end.add(2, 1);
/* 820 */         end.add(5, -1);
/*     */         
/* 822 */         if (rangeStyle == 6) {
/* 823 */           startCutoff = 2;
/* 824 */           endCutoff = 1;
/*     */         } 
/*     */         break;
/*     */       
/*     */       case 1:
/*     */       case 2:
/*     */       case 3:
/*     */       case 4:
/* 832 */         start = truncate(focus, 5);
/* 833 */         end = truncate(focus, 5);
/* 834 */         switch (rangeStyle) {
/*     */ 
/*     */ 
/*     */           
/*     */           case 2:
/* 839 */             startCutoff = 2;
/* 840 */             endCutoff = 1;
/*     */             break;
/*     */           case 3:
/* 843 */             startCutoff = focus.get(7);
/* 844 */             endCutoff = startCutoff - 1;
/*     */             break;
/*     */           case 4:
/* 847 */             startCutoff = focus.get(7) - 3;
/* 848 */             endCutoff = focus.get(7) + 3;
/*     */             break;
/*     */         } 
/*     */         break;
/*     */       default:
/* 853 */         throw new IllegalArgumentException("The range style " + rangeStyle + " is not valid.");
/*     */     } 
/* 855 */     if (startCutoff < 1) {
/* 856 */       startCutoff += 7;
/*     */     }
/* 858 */     if (startCutoff > 7) {
/* 859 */       startCutoff -= 7;
/*     */     }
/* 861 */     if (endCutoff < 1) {
/* 862 */       endCutoff += 7;
/*     */     }
/* 864 */     if (endCutoff > 7) {
/* 865 */       endCutoff -= 7;
/*     */     }
/* 867 */     while (start.get(7) != startCutoff) {
/* 868 */       start.add(5, -1);
/*     */     }
/* 870 */     while (end.get(7) != endCutoff) {
/* 871 */       end.add(5, 1);
/*     */     }
/* 873 */     return new DateIterator(start, end);
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
/*     */   public static Iterator iterator(Object focus, int rangeStyle) {
/* 896 */     if (focus == null) {
/* 897 */       throw new IllegalArgumentException("The date must not be null");
/*     */     }
/* 899 */     if (focus instanceof Date)
/* 900 */       return iterator((Date)focus, rangeStyle); 
/* 901 */     if (focus instanceof Calendar) {
/* 902 */       return iterator((Calendar)focus, rangeStyle);
/*     */     }
/* 904 */     throw new ClassCastException("Could not iterate based on " + focus);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class DateIterator
/*     */     implements Iterator
/*     */   {
/*     */     private final Calendar endFinal;
/*     */ 
/*     */ 
/*     */     
/*     */     private final Calendar spot;
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     DateIterator(Calendar startFinal, Calendar endFinal) {
/* 923 */       this.endFinal = endFinal;
/* 924 */       this.spot = startFinal;
/* 925 */       this.spot.add(5, -1);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public boolean hasNext() {
/* 934 */       return this.spot.before(this.endFinal);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public Object next() {
/* 943 */       if (this.spot.equals(this.endFinal)) {
/* 944 */         throw new NoSuchElementException();
/*     */       }
/* 946 */       this.spot.add(5, 1);
/* 947 */       return this.spot.clone();
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public void remove() {
/* 957 */       throw new UnsupportedOperationException();
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\time\DateUtils.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */