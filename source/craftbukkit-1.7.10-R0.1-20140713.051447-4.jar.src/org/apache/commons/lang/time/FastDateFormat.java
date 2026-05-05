/*      */ package org.apache.commons.lang.time;
/*      */ 
/*      */ import java.io.IOException;
/*      */ import java.io.ObjectInputStream;
/*      */ import java.text.DateFormat;
/*      */ import java.text.DateFormatSymbols;
/*      */ import java.text.FieldPosition;
/*      */ import java.text.Format;
/*      */ import java.text.ParsePosition;
/*      */ import java.text.SimpleDateFormat;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Calendar;
/*      */ import java.util.Date;
/*      */ import java.util.GregorianCalendar;
/*      */ import java.util.HashMap;
/*      */ import java.util.List;
/*      */ import java.util.Locale;
/*      */ import java.util.Map;
/*      */ import java.util.TimeZone;
/*      */ import org.apache.commons.lang.Validate;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class FastDateFormat
/*      */   extends Format
/*      */ {
/*      */   private static final long serialVersionUID = 1L;
/*      */   public static final int FULL = 0;
/*      */   public static final int LONG = 1;
/*      */   public static final int MEDIUM = 2;
/*      */   public static final int SHORT = 3;
/*      */   private static String cDefaultPattern;
/*  111 */   private static Map cInstanceCache = new HashMap(7);
/*  112 */   private static Map cDateInstanceCache = new HashMap(7);
/*  113 */   private static Map cTimeInstanceCache = new HashMap(7);
/*  114 */   private static Map cDateTimeInstanceCache = new HashMap(7);
/*  115 */   private static Map cTimeZoneDisplayCache = new HashMap(7);
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final String mPattern;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final TimeZone mTimeZone;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final boolean mTimeZoneForced;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final Locale mLocale;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private final boolean mLocaleForced;
/*      */ 
/*      */ 
/*      */   
/*      */   private transient Rule[] mRules;
/*      */ 
/*      */ 
/*      */   
/*      */   private transient int mMaxLengthEstimate;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getInstance() {
/*  154 */     return getInstance(getDefaultPattern(), null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getInstance(String pattern) {
/*  167 */     return getInstance(pattern, null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getInstance(String pattern, TimeZone timeZone) {
/*  182 */     return getInstance(pattern, timeZone, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getInstance(String pattern, Locale locale) {
/*  196 */     return getInstance(pattern, null, locale);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static synchronized FastDateFormat getInstance(String pattern, TimeZone timeZone, Locale locale) {
/*  213 */     FastDateFormat emptyFormat = new FastDateFormat(pattern, timeZone, locale);
/*  214 */     FastDateFormat format = (FastDateFormat)cInstanceCache.get(emptyFormat);
/*  215 */     if (format == null) {
/*  216 */       format = emptyFormat;
/*  217 */       format.init();
/*  218 */       cInstanceCache.put(format, format);
/*      */     } 
/*  220 */     return format;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getDateInstance(int style) {
/*  235 */     return getDateInstance(style, null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getDateInstance(int style, Locale locale) {
/*  250 */     return getDateInstance(style, null, locale);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getDateInstance(int style, TimeZone timeZone) {
/*  266 */     return getDateInstance(style, timeZone, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static synchronized FastDateFormat getDateInstance(int style, TimeZone timeZone, Locale locale) {
/*  281 */     Object key = new Integer(style);
/*  282 */     if (timeZone != null) {
/*  283 */       key = new Pair(key, timeZone);
/*      */     }
/*  285 */     if (locale != null) {
/*  286 */       key = new Pair(key, locale);
/*      */     }
/*      */     
/*  289 */     FastDateFormat format = (FastDateFormat)cDateInstanceCache.get(key);
/*  290 */     if (format == null) {
/*  291 */       if (locale == null) {
/*  292 */         locale = Locale.getDefault();
/*      */       }
/*      */       
/*      */       try {
/*  296 */         SimpleDateFormat formatter = (SimpleDateFormat)DateFormat.getDateInstance(style, locale);
/*  297 */         String pattern = formatter.toPattern();
/*  298 */         format = getInstance(pattern, timeZone, locale);
/*  299 */         cDateInstanceCache.put(key, format);
/*      */       } catch (ClassCastException ex) {
/*      */         
/*  302 */         throw new IllegalArgumentException("No date pattern for locale: " + locale);
/*      */       } 
/*      */     } 
/*  305 */     return format;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getTimeInstance(int style) {
/*  320 */     return getTimeInstance(style, null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getTimeInstance(int style, Locale locale) {
/*  335 */     return getTimeInstance(style, null, locale);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getTimeInstance(int style, TimeZone timeZone) {
/*  351 */     return getTimeInstance(style, timeZone, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static synchronized FastDateFormat getTimeInstance(int style, TimeZone timeZone, Locale locale) {
/*  367 */     Object key = new Integer(style);
/*  368 */     if (timeZone != null) {
/*  369 */       key = new Pair(key, timeZone);
/*      */     }
/*  371 */     if (locale != null) {
/*  372 */       key = new Pair(key, locale);
/*      */     }
/*      */     
/*  375 */     FastDateFormat format = (FastDateFormat)cTimeInstanceCache.get(key);
/*  376 */     if (format == null) {
/*  377 */       if (locale == null) {
/*  378 */         locale = Locale.getDefault();
/*      */       }
/*      */       
/*      */       try {
/*  382 */         SimpleDateFormat formatter = (SimpleDateFormat)DateFormat.getTimeInstance(style, locale);
/*  383 */         String pattern = formatter.toPattern();
/*  384 */         format = getInstance(pattern, timeZone, locale);
/*  385 */         cTimeInstanceCache.put(key, format);
/*      */       } catch (ClassCastException ex) {
/*      */         
/*  388 */         throw new IllegalArgumentException("No date pattern for locale: " + locale);
/*      */       } 
/*      */     } 
/*  391 */     return format;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getDateTimeInstance(int dateStyle, int timeStyle) {
/*  408 */     return getDateTimeInstance(dateStyle, timeStyle, null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getDateTimeInstance(int dateStyle, int timeStyle, Locale locale) {
/*  425 */     return getDateTimeInstance(dateStyle, timeStyle, null, locale);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static FastDateFormat getDateTimeInstance(int dateStyle, int timeStyle, TimeZone timeZone) {
/*  443 */     return getDateTimeInstance(dateStyle, timeStyle, timeZone, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static synchronized FastDateFormat getDateTimeInstance(int dateStyle, int timeStyle, TimeZone timeZone, Locale locale) {
/*  461 */     Object key = new Pair(new Integer(dateStyle), new Integer(timeStyle));
/*  462 */     if (timeZone != null) {
/*  463 */       key = new Pair(key, timeZone);
/*      */     }
/*  465 */     if (locale != null) {
/*  466 */       key = new Pair(key, locale);
/*      */     }
/*      */     
/*  469 */     FastDateFormat format = (FastDateFormat)cDateTimeInstanceCache.get(key);
/*  470 */     if (format == null) {
/*  471 */       if (locale == null) {
/*  472 */         locale = Locale.getDefault();
/*      */       }
/*      */       
/*      */       try {
/*  476 */         SimpleDateFormat formatter = (SimpleDateFormat)DateFormat.getDateTimeInstance(dateStyle, timeStyle, locale);
/*      */         
/*  478 */         String pattern = formatter.toPattern();
/*  479 */         format = getInstance(pattern, timeZone, locale);
/*  480 */         cDateTimeInstanceCache.put(key, format);
/*      */       } catch (ClassCastException ex) {
/*      */         
/*  483 */         throw new IllegalArgumentException("No date time pattern for locale: " + locale);
/*      */       } 
/*      */     } 
/*  486 */     return format;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static synchronized String getTimeZoneDisplay(TimeZone tz, boolean daylight, int style, Locale locale) {
/*  501 */     Object key = new TimeZoneDisplayKey(tz, daylight, style, locale);
/*  502 */     String value = (String)cTimeZoneDisplayCache.get(key);
/*  503 */     if (value == null) {
/*      */       
/*  505 */       value = tz.getDisplayName(daylight, style, locale);
/*  506 */       cTimeZoneDisplayCache.put(key, value);
/*      */     } 
/*  508 */     return value;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static synchronized String getDefaultPattern() {
/*  517 */     if (cDefaultPattern == null) {
/*  518 */       cDefaultPattern = (new SimpleDateFormat()).toPattern();
/*      */     }
/*  520 */     return cDefaultPattern;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected FastDateFormat(String pattern, TimeZone timeZone, Locale locale) {
/*  540 */     if (pattern == null) {
/*  541 */       throw new IllegalArgumentException("The pattern must not be null");
/*      */     }
/*  543 */     this.mPattern = pattern;
/*      */     
/*  545 */     this.mTimeZoneForced = (timeZone != null);
/*  546 */     if (timeZone == null) {
/*  547 */       timeZone = TimeZone.getDefault();
/*      */     }
/*  549 */     this.mTimeZone = timeZone;
/*      */     
/*  551 */     this.mLocaleForced = (locale != null);
/*  552 */     if (locale == null) {
/*  553 */       locale = Locale.getDefault();
/*      */     }
/*  555 */     this.mLocale = locale;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void init() {
/*  562 */     List rulesList = parsePattern();
/*  563 */     this.mRules = (Rule[])rulesList.toArray((Object[])new Rule[rulesList.size()]);
/*      */     
/*  565 */     int len = 0;
/*  566 */     for (int i = this.mRules.length; --i >= 0;) {
/*  567 */       len += this.mRules[i].estimateLength();
/*      */     }
/*      */     
/*  570 */     this.mMaxLengthEstimate = len;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected List parsePattern() {
/*  582 */     DateFormatSymbols symbols = new DateFormatSymbols(this.mLocale);
/*  583 */     List rules = new ArrayList();
/*      */     
/*  585 */     String[] ERAs = symbols.getEras();
/*  586 */     String[] months = symbols.getMonths();
/*  587 */     String[] shortMonths = symbols.getShortMonths();
/*  588 */     String[] weekdays = symbols.getWeekdays();
/*  589 */     String[] shortWeekdays = symbols.getShortWeekdays();
/*  590 */     String[] AmPmStrings = symbols.getAmPmStrings();
/*      */     
/*  592 */     int length = this.mPattern.length();
/*  593 */     int[] indexRef = new int[1];
/*      */     
/*  595 */     for (int i = 0; i < length; i++) {
/*  596 */       Rule rule; String sub; indexRef[0] = i;
/*  597 */       String token = parseToken(this.mPattern, indexRef);
/*  598 */       i = indexRef[0];
/*      */       
/*  600 */       int tokenLen = token.length();
/*  601 */       if (tokenLen == 0) {
/*      */         break;
/*      */       }
/*      */ 
/*      */       
/*  606 */       char c = token.charAt(0);
/*      */       
/*  608 */       switch (c) {
/*      */         case 'G':
/*  610 */           rule = new TextField(0, ERAs);
/*      */           break;
/*      */         case 'y':
/*  613 */           if (tokenLen >= 4) {
/*  614 */             rule = selectNumberRule(1, tokenLen); break;
/*      */           } 
/*  616 */           rule = TwoDigitYearField.INSTANCE;
/*      */           break;
/*      */         
/*      */         case 'M':
/*  620 */           if (tokenLen >= 4) {
/*  621 */             rule = new TextField(2, months); break;
/*  622 */           }  if (tokenLen == 3) {
/*  623 */             rule = new TextField(2, shortMonths); break;
/*  624 */           }  if (tokenLen == 2) {
/*  625 */             rule = TwoDigitMonthField.INSTANCE; break;
/*      */           } 
/*  627 */           rule = UnpaddedMonthField.INSTANCE;
/*      */           break;
/*      */         
/*      */         case 'd':
/*  631 */           rule = selectNumberRule(5, tokenLen);
/*      */           break;
/*      */         case 'h':
/*  634 */           rule = new TwelveHourField(selectNumberRule(10, tokenLen));
/*      */           break;
/*      */         case 'H':
/*  637 */           rule = selectNumberRule(11, tokenLen);
/*      */           break;
/*      */         case 'm':
/*  640 */           rule = selectNumberRule(12, tokenLen);
/*      */           break;
/*      */         case 's':
/*  643 */           rule = selectNumberRule(13, tokenLen);
/*      */           break;
/*      */         case 'S':
/*  646 */           rule = selectNumberRule(14, tokenLen);
/*      */           break;
/*      */         case 'E':
/*  649 */           rule = new TextField(7, (tokenLen < 4) ? shortWeekdays : weekdays);
/*      */           break;
/*      */         case 'D':
/*  652 */           rule = selectNumberRule(6, tokenLen);
/*      */           break;
/*      */         case 'F':
/*  655 */           rule = selectNumberRule(8, tokenLen);
/*      */           break;
/*      */         case 'w':
/*  658 */           rule = selectNumberRule(3, tokenLen);
/*      */           break;
/*      */         case 'W':
/*  661 */           rule = selectNumberRule(4, tokenLen);
/*      */           break;
/*      */         case 'a':
/*  664 */           rule = new TextField(9, AmPmStrings);
/*      */           break;
/*      */         case 'k':
/*  667 */           rule = new TwentyFourHourField(selectNumberRule(11, tokenLen));
/*      */           break;
/*      */         case 'K':
/*  670 */           rule = selectNumberRule(10, tokenLen);
/*      */           break;
/*      */         case 'z':
/*  673 */           if (tokenLen >= 4) {
/*  674 */             rule = new TimeZoneNameRule(this.mTimeZone, this.mTimeZoneForced, this.mLocale, 1); break;
/*      */           } 
/*  676 */           rule = new TimeZoneNameRule(this.mTimeZone, this.mTimeZoneForced, this.mLocale, 0);
/*      */           break;
/*      */         
/*      */         case 'Z':
/*  680 */           if (tokenLen == 1) {
/*  681 */             rule = TimeZoneNumberRule.INSTANCE_NO_COLON; break;
/*      */           } 
/*  683 */           rule = TimeZoneNumberRule.INSTANCE_COLON;
/*      */           break;
/*      */         
/*      */         case '\'':
/*  687 */           sub = token.substring(1);
/*  688 */           if (sub.length() == 1) {
/*  689 */             rule = new CharacterLiteral(sub.charAt(0)); break;
/*      */           } 
/*  691 */           rule = new StringLiteral(sub);
/*      */           break;
/*      */         
/*      */         default:
/*  695 */           throw new IllegalArgumentException("Illegal pattern component: " + token);
/*      */       } 
/*      */       
/*  698 */       rules.add(rule);
/*      */     } 
/*      */     
/*  701 */     return rules;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String parseToken(String pattern, int[] indexRef) {
/*  712 */     StringBuffer buf = new StringBuffer();
/*      */     
/*  714 */     int i = indexRef[0];
/*  715 */     int length = pattern.length();
/*      */     
/*  717 */     char c = pattern.charAt(i);
/*  718 */     if ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z')) {
/*      */ 
/*      */       
/*  721 */       buf.append(c);
/*      */       
/*  723 */       while (i + 1 < length) {
/*  724 */         char peek = pattern.charAt(i + 1);
/*  725 */         if (peek == c) {
/*  726 */           buf.append(c);
/*  727 */           i++;
/*      */           
/*      */           continue;
/*      */         } 
/*      */         break;
/*      */       } 
/*      */     } else {
/*  734 */       buf.append('\'');
/*      */       
/*  736 */       boolean inLiteral = false;
/*      */       
/*  738 */       for (; i < length; i++) {
/*  739 */         c = pattern.charAt(i);
/*      */         
/*  741 */         if (c == '\'')
/*  742 */         { if (i + 1 < length && pattern.charAt(i + 1) == '\'') {
/*      */             
/*  744 */             i++;
/*  745 */             buf.append(c);
/*      */           } else {
/*  747 */             inLiteral = !inLiteral;
/*      */           }  }
/*  749 */         else { if (!inLiteral && ((c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z'))) {
/*      */             
/*  751 */             i--;
/*      */             break;
/*      */           } 
/*  754 */           buf.append(c); }
/*      */       
/*      */       } 
/*      */     } 
/*      */     
/*  759 */     indexRef[0] = i;
/*  760 */     return buf.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected NumberRule selectNumberRule(int field, int padding) {
/*  771 */     switch (padding) {
/*      */       case 1:
/*  773 */         return new UnpaddedNumberField(field);
/*      */       case 2:
/*  775 */         return new TwoDigitNumberField(field);
/*      */     } 
/*  777 */     return new PaddedNumberField(field, padding);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer format(Object obj, StringBuffer toAppendTo, FieldPosition pos) {
/*  793 */     if (obj instanceof Date)
/*  794 */       return format((Date)obj, toAppendTo); 
/*  795 */     if (obj instanceof Calendar)
/*  796 */       return format((Calendar)obj, toAppendTo); 
/*  797 */     if (obj instanceof Long) {
/*  798 */       return format(((Long)obj).longValue(), toAppendTo);
/*      */     }
/*  800 */     throw new IllegalArgumentException("Unknown class: " + ((obj == null) ? "<null>" : obj.getClass().getName()));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String format(long millis) {
/*  813 */     return format(new Date(millis));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String format(Date date) {
/*  823 */     Calendar c = new GregorianCalendar(this.mTimeZone);
/*  824 */     c.setTime(date);
/*  825 */     return applyRules(c, new StringBuffer(this.mMaxLengthEstimate)).toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String format(Calendar calendar) {
/*  835 */     return format(calendar, new StringBuffer(this.mMaxLengthEstimate)).toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer format(long millis, StringBuffer buf) {
/*  848 */     return format(new Date(millis), buf);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer format(Date date, StringBuffer buf) {
/*  860 */     Calendar c = new GregorianCalendar(this.mTimeZone);
/*  861 */     c.setTime(date);
/*  862 */     return applyRules(c, buf);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer format(Calendar calendar, StringBuffer buf) {
/*  874 */     if (this.mTimeZoneForced) {
/*  875 */       calendar = (Calendar)calendar.clone();
/*  876 */       calendar.setTimeZone(this.mTimeZone);
/*      */     } 
/*  878 */     return applyRules(calendar, buf);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected StringBuffer applyRules(Calendar calendar, StringBuffer buf) {
/*  890 */     Rule[] rules = this.mRules;
/*  891 */     int len = this.mRules.length;
/*  892 */     for (int i = 0; i < len; i++) {
/*  893 */       rules[i].appendTo(buf, calendar);
/*      */     }
/*  895 */     return buf;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object parseObject(String source, ParsePosition pos) {
/*  908 */     pos.setIndex(0);
/*  909 */     pos.setErrorIndex(0);
/*  910 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String getPattern() {
/*  921 */     return this.mPattern;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public TimeZone getTimeZone() {
/*  935 */     return this.mTimeZone;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getTimeZoneOverridesCalendar() {
/*  946 */     return this.mTimeZoneForced;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Locale getLocale() {
/*  955 */     return this.mLocale;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getMaxLengthEstimate() {
/*  968 */     return this.mMaxLengthEstimate;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean equals(Object obj) {
/*  980 */     if (!(obj instanceof FastDateFormat)) {
/*  981 */       return false;
/*      */     }
/*  983 */     FastDateFormat other = (FastDateFormat)obj;
/*  984 */     if ((this.mPattern == other.mPattern || this.mPattern.equals(other.mPattern)) && (this.mTimeZone == other.mTimeZone || this.mTimeZone.equals(other.mTimeZone)) && (this.mLocale == other.mLocale || this.mLocale.equals(other.mLocale)) && this.mTimeZoneForced == other.mTimeZoneForced && this.mLocaleForced == other.mLocaleForced)
/*      */     {
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  991 */       return true;
/*      */     }
/*  993 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int hashCode() {
/* 1002 */     int total = 0;
/* 1003 */     total += this.mPattern.hashCode();
/* 1004 */     total += this.mTimeZone.hashCode();
/* 1005 */     total += this.mTimeZoneForced ? 1 : 0;
/* 1006 */     total += this.mLocale.hashCode();
/* 1007 */     total += this.mLocaleForced ? 1 : 0;
/* 1008 */     return total;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public String toString() {
/* 1017 */     return "FastDateFormat[" + this.mPattern + "]";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
/* 1031 */     in.defaultReadObject();
/* 1032 */     init();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static interface Rule
/*      */   {
/*      */     int estimateLength();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     void appendTo(StringBuffer param1StringBuffer, Calendar param1Calendar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static interface NumberRule
/*      */     extends Rule
/*      */   {
/*      */     void appendTo(StringBuffer param1StringBuffer, int param1Int);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class CharacterLiteral
/*      */     implements Rule
/*      */   {
/*      */     private final char mValue;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     CharacterLiteral(char value) {
/* 1083 */       this.mValue = value;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1090 */       return 1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer buffer, Calendar calendar) {
/* 1097 */       buffer.append(this.mValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class StringLiteral
/*      */     implements Rule
/*      */   {
/*      */     private final String mValue;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     StringLiteral(String value) {
/* 1114 */       this.mValue = value;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1121 */       return this.mValue.length();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer buffer, Calendar calendar) {
/* 1128 */       buffer.append(this.mValue);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TextField
/*      */     implements Rule
/*      */   {
/*      */     private final int mField;
/*      */ 
/*      */ 
/*      */     
/*      */     private final String[] mValues;
/*      */ 
/*      */ 
/*      */     
/*      */     TextField(int field, String[] values) {
/* 1147 */       this.mField = field;
/* 1148 */       this.mValues = values;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1155 */       int max = 0;
/* 1156 */       for (int i = this.mValues.length; --i >= 0; ) {
/* 1157 */         int len = this.mValues[i].length();
/* 1158 */         if (len > max) {
/* 1159 */           max = len;
/*      */         }
/*      */       } 
/* 1162 */       return max;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer buffer, Calendar calendar) {
/* 1169 */       buffer.append(this.mValues[calendar.get(this.mField)]);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class UnpaddedNumberField
/*      */     implements NumberRule
/*      */   {
/* 1177 */     static final UnpaddedNumberField INSTANCE_YEAR = new UnpaddedNumberField(1);
/*      */ 
/*      */ 
/*      */     
/*      */     private final int mField;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     UnpaddedNumberField(int field) {
/* 1187 */       this.mField = field;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1194 */       return 4;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer buffer, Calendar calendar) {
/* 1201 */       appendTo(buffer, calendar.get(this.mField));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(StringBuffer buffer, int value) {
/* 1208 */       if (value < 10) {
/* 1209 */         buffer.append((char)(value + 48));
/* 1210 */       } else if (value < 100) {
/* 1211 */         buffer.append((char)(value / 10 + 48));
/* 1212 */         buffer.append((char)(value % 10 + 48));
/*      */       } else {
/* 1214 */         buffer.append(Integer.toString(value));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class UnpaddedMonthField
/*      */     implements NumberRule
/*      */   {
/* 1223 */     static final UnpaddedMonthField INSTANCE = new UnpaddedMonthField();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1237 */       return 2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer buffer, Calendar calendar) {
/* 1244 */       appendTo(buffer, calendar.get(2) + 1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(StringBuffer buffer, int value) {
/* 1251 */       if (value < 10) {
/* 1252 */         buffer.append((char)(value + 48));
/*      */       } else {
/* 1254 */         buffer.append((char)(value / 10 + 48));
/* 1255 */         buffer.append((char)(value % 10 + 48));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class PaddedNumberField
/*      */     implements NumberRule
/*      */   {
/*      */     private final int mField;
/*      */ 
/*      */     
/*      */     private final int mSize;
/*      */ 
/*      */ 
/*      */     
/*      */     PaddedNumberField(int field, int size) {
/* 1274 */       if (size < 3)
/*      */       {
/* 1276 */         throw new IllegalArgumentException();
/*      */       }
/* 1278 */       this.mField = field;
/* 1279 */       this.mSize = size;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1286 */       return 4;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer buffer, Calendar calendar) {
/* 1293 */       appendTo(buffer, calendar.get(this.mField));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(StringBuffer buffer, int value) {
/* 1300 */       if (value < 100) {
/* 1301 */         for (int i = this.mSize; --i >= 2;) {
/* 1302 */           buffer.append('0');
/*      */         }
/* 1304 */         buffer.append((char)(value / 10 + 48));
/* 1305 */         buffer.append((char)(value % 10 + 48));
/*      */       } else {
/*      */         int j;
/* 1308 */         if (value < 1000) {
/* 1309 */           j = 3;
/*      */         } else {
/* 1311 */           Validate.isTrue((value > -1), "Negative values should not be possible", value);
/* 1312 */           j = Integer.toString(value).length();
/*      */         } 
/* 1314 */         for (int i = this.mSize; --i >= j;) {
/* 1315 */           buffer.append('0');
/*      */         }
/* 1317 */         buffer.append(Integer.toString(value));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TwoDigitNumberField
/*      */     implements NumberRule
/*      */   {
/*      */     private final int mField;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TwoDigitNumberField(int field) {
/* 1334 */       this.mField = field;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1341 */       return 2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer buffer, Calendar calendar) {
/* 1348 */       appendTo(buffer, calendar.get(this.mField));
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(StringBuffer buffer, int value) {
/* 1355 */       if (value < 100) {
/* 1356 */         buffer.append((char)(value / 10 + 48));
/* 1357 */         buffer.append((char)(value % 10 + 48));
/*      */       } else {
/* 1359 */         buffer.append(Integer.toString(value));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class TwoDigitYearField
/*      */     implements NumberRule
/*      */   {
/* 1368 */     static final TwoDigitYearField INSTANCE = new TwoDigitYearField();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1381 */       return 2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer buffer, Calendar calendar) {
/* 1388 */       appendTo(buffer, calendar.get(1) % 100);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(StringBuffer buffer, int value) {
/* 1395 */       buffer.append((char)(value / 10 + 48));
/* 1396 */       buffer.append((char)(value % 10 + 48));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private static class TwoDigitMonthField
/*      */     implements NumberRule
/*      */   {
/* 1404 */     static final TwoDigitMonthField INSTANCE = new TwoDigitMonthField();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1417 */       return 2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer buffer, Calendar calendar) {
/* 1424 */       appendTo(buffer, calendar.get(2) + 1);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public final void appendTo(StringBuffer buffer, int value) {
/* 1431 */       buffer.append((char)(value / 10 + 48));
/* 1432 */       buffer.append((char)(value % 10 + 48));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TwelveHourField
/*      */     implements NumberRule
/*      */   {
/*      */     private final FastDateFormat.NumberRule mRule;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TwelveHourField(FastDateFormat.NumberRule rule) {
/* 1449 */       this.mRule = rule;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1456 */       return this.mRule.estimateLength();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer buffer, Calendar calendar) {
/* 1463 */       int value = calendar.get(10);
/* 1464 */       if (value == 0) {
/* 1465 */         value = calendar.getLeastMaximum(10) + 1;
/*      */       }
/* 1467 */       this.mRule.appendTo(buffer, value);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer buffer, int value) {
/* 1474 */       this.mRule.appendTo(buffer, value);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TwentyFourHourField
/*      */     implements NumberRule
/*      */   {
/*      */     private final FastDateFormat.NumberRule mRule;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TwentyFourHourField(FastDateFormat.NumberRule rule) {
/* 1491 */       this.mRule = rule;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1498 */       return this.mRule.estimateLength();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer buffer, Calendar calendar) {
/* 1505 */       int value = calendar.get(11);
/* 1506 */       if (value == 0) {
/* 1507 */         value = calendar.getMaximum(11) + 1;
/*      */       }
/* 1509 */       this.mRule.appendTo(buffer, value);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer buffer, int value) {
/* 1516 */       this.mRule.appendTo(buffer, value);
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TimeZoneNameRule
/*      */     implements Rule
/*      */   {
/*      */     private final TimeZone mTimeZone;
/*      */ 
/*      */     
/*      */     private final boolean mTimeZoneForced;
/*      */     
/*      */     private final Locale mLocale;
/*      */     
/*      */     private final int mStyle;
/*      */     
/*      */     private final String mStandard;
/*      */     
/*      */     private final String mDaylight;
/*      */ 
/*      */     
/*      */     TimeZoneNameRule(TimeZone timeZone, boolean timeZoneForced, Locale locale, int style) {
/* 1540 */       this.mTimeZone = timeZone;
/* 1541 */       this.mTimeZoneForced = timeZoneForced;
/* 1542 */       this.mLocale = locale;
/* 1543 */       this.mStyle = style;
/*      */       
/* 1545 */       if (timeZoneForced) {
/* 1546 */         this.mStandard = FastDateFormat.getTimeZoneDisplay(timeZone, false, style, locale);
/* 1547 */         this.mDaylight = FastDateFormat.getTimeZoneDisplay(timeZone, true, style, locale);
/*      */       } else {
/* 1549 */         this.mStandard = null;
/* 1550 */         this.mDaylight = null;
/*      */       } 
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1558 */       if (this.mTimeZoneForced)
/* 1559 */         return Math.max(this.mStandard.length(), this.mDaylight.length()); 
/* 1560 */       if (this.mStyle == 0) {
/* 1561 */         return 4;
/*      */       }
/* 1563 */       return 40;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer buffer, Calendar calendar) {
/* 1571 */       if (this.mTimeZoneForced) {
/* 1572 */         if (this.mTimeZone.useDaylightTime() && calendar.get(16) != 0) {
/* 1573 */           buffer.append(this.mDaylight);
/*      */         } else {
/* 1575 */           buffer.append(this.mStandard);
/*      */         } 
/*      */       } else {
/* 1578 */         TimeZone timeZone = calendar.getTimeZone();
/* 1579 */         if (timeZone.useDaylightTime() && calendar.get(16) != 0) {
/* 1580 */           buffer.append(FastDateFormat.getTimeZoneDisplay(timeZone, true, this.mStyle, this.mLocale));
/*      */         } else {
/* 1582 */           buffer.append(FastDateFormat.getTimeZoneDisplay(timeZone, false, this.mStyle, this.mLocale));
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TimeZoneNumberRule
/*      */     implements Rule
/*      */   {
/* 1593 */     static final TimeZoneNumberRule INSTANCE_COLON = new TimeZoneNumberRule(true);
/* 1594 */     static final TimeZoneNumberRule INSTANCE_NO_COLON = new TimeZoneNumberRule(false);
/*      */ 
/*      */ 
/*      */     
/*      */     final boolean mColon;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TimeZoneNumberRule(boolean colon) {
/* 1604 */       this.mColon = colon;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int estimateLength() {
/* 1611 */       return 5;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public void appendTo(StringBuffer buffer, Calendar calendar) {
/* 1618 */       int offset = calendar.get(15) + calendar.get(16);
/*      */       
/* 1620 */       if (offset < 0) {
/* 1621 */         buffer.append('-');
/* 1622 */         offset = -offset;
/*      */       } else {
/* 1624 */         buffer.append('+');
/*      */       } 
/*      */       
/* 1627 */       int hours = offset / 3600000;
/* 1628 */       buffer.append((char)(hours / 10 + 48));
/* 1629 */       buffer.append((char)(hours % 10 + 48));
/*      */       
/* 1631 */       if (this.mColon) {
/* 1632 */         buffer.append(':');
/*      */       }
/*      */       
/* 1635 */       int minutes = offset / 60000 - 60 * hours;
/* 1636 */       buffer.append((char)(minutes / 10 + 48));
/* 1637 */       buffer.append((char)(minutes % 10 + 48));
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class TimeZoneDisplayKey
/*      */   {
/*      */     private final TimeZone mTimeZone;
/*      */ 
/*      */ 
/*      */     
/*      */     private final int mStyle;
/*      */ 
/*      */ 
/*      */     
/*      */     private final Locale mLocale;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     TimeZoneDisplayKey(TimeZone timeZone, boolean daylight, int style, Locale locale) {
/* 1660 */       this.mTimeZone = timeZone;
/* 1661 */       if (daylight) {
/* 1662 */         style |= Integer.MIN_VALUE;
/*      */       }
/* 1664 */       this.mStyle = style;
/* 1665 */       this.mLocale = locale;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/* 1672 */       return this.mStyle * 31 + this.mLocale.hashCode();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object obj) {
/* 1679 */       if (this == obj) {
/* 1680 */         return true;
/*      */       }
/* 1682 */       if (obj instanceof TimeZoneDisplayKey) {
/* 1683 */         TimeZoneDisplayKey other = (TimeZoneDisplayKey)obj;
/* 1684 */         return (this.mTimeZone.equals(other.mTimeZone) && this.mStyle == other.mStyle && this.mLocale.equals(other.mLocale));
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 1689 */       return false;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static class Pair
/*      */   {
/*      */     private final Object mObj1;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private final Object mObj2;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public Pair(Object obj1, Object obj2) {
/* 1710 */       this.mObj1 = obj1;
/* 1711 */       this.mObj2 = obj2;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public boolean equals(Object obj) {
/* 1718 */       if (this == obj) {
/* 1719 */         return true;
/*      */       }
/*      */       
/* 1722 */       if (!(obj instanceof Pair)) {
/* 1723 */         return false;
/*      */       }
/*      */       
/* 1726 */       Pair key = (Pair)obj;
/*      */       
/* 1728 */       if ((this.mObj1 == null) ? ((key.mObj1 == null)) : this.mObj1.equals(key.mObj1)) if ((this.mObj2 == null) ? ((key.mObj2 == null)) : this.mObj2.equals(key.mObj2));  return false;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public int hashCode() {
/* 1739 */       return ((this.mObj1 == null) ? 0 : this.mObj1.hashCode()) + ((this.mObj2 == null) ? 0 : this.mObj2.hashCode());
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     public String toString() {
/* 1748 */       return "[" + this.mObj1 + ':' + this.mObj2 + ']';
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\time\FastDateFormat.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */