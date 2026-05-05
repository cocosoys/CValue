/*      */ package org.apache.commons.lang.builder;
/*      */ 
/*      */ import java.io.Serializable;
/*      */ import java.lang.reflect.Array;
/*      */ import java.util.Collection;
/*      */ import java.util.HashSet;
/*      */ import java.util.Map;
/*      */ import java.util.Set;
/*      */ import org.apache.commons.lang.ClassUtils;
/*      */ import org.apache.commons.lang.ObjectUtils;
/*      */ import org.apache.commons.lang.SystemUtils;
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
/*      */ public abstract class ToStringStyle
/*      */   implements Serializable
/*      */ {
/*   76 */   public static final ToStringStyle DEFAULT_STYLE = new DefaultToStringStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   81 */   public static final ToStringStyle MULTI_LINE_STYLE = new MultiLineToStringStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   86 */   public static final ToStringStyle NO_FIELD_NAMES_STYLE = new NoFieldNameToStringStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   92 */   public static final ToStringStyle SHORT_PREFIX_STYLE = new ShortPrefixToStringStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*   97 */   public static final ToStringStyle SIMPLE_STYLE = new SimpleToStringStyle();
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  105 */   private static ThreadLocal registry = new ThreadLocal()
/*      */     {
/*      */       protected synchronized Object initialValue()
/*      */       {
/*  109 */         return new HashSet();
/*      */       }
/*      */     };
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   static Set getRegistry() {
/*  122 */     return registry.get();
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
/*      */   static boolean isRegistered(Object value) {
/*  137 */     return getRegistry().contains(value);
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
/*      */   static void register(Object value) {
/*  150 */     if (value != null) {
/*  151 */       getRegistry().add(value);
/*      */     }
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
/*      */   static void unregister(Object value) {
/*  168 */     getRegistry().remove(value);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean useFieldNames = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean useClassName = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean useShortClassName = false;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean useIdentityHashCode = true;
/*      */ 
/*      */ 
/*      */   
/*  194 */   private String contentStart = "[";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  199 */   private String contentEnd = "]";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  204 */   private String fieldNameValueSeparator = "=";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean fieldSeparatorAtStart = false;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean fieldSeparatorAtEnd = false;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  219 */   private String fieldSeparator = ",";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  224 */   private String arrayStart = "{";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  229 */   private String arraySeparator = ",";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean arrayContentDetail = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  239 */   private String arrayEnd = "}";
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private boolean defaultFullDetail = true;
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  250 */   private String nullText = "<null>";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  255 */   private String sizeStartText = "<size=";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  260 */   private String sizeEndText = ">";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  265 */   private String summaryObjectStartText = "<";
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*  270 */   private String summaryObjectEndText = ">";
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
/*      */   public void appendSuper(StringBuffer buffer, String superToString) {
/*  293 */     appendToString(buffer, superToString);
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
/*      */   public void appendToString(StringBuffer buffer, String toString) {
/*  306 */     if (toString != null) {
/*  307 */       int pos1 = toString.indexOf(this.contentStart) + this.contentStart.length();
/*  308 */       int pos2 = toString.lastIndexOf(this.contentEnd);
/*  309 */       if (pos1 != pos2 && pos1 >= 0 && pos2 >= 0) {
/*  310 */         String data = toString.substring(pos1, pos2);
/*  311 */         if (this.fieldSeparatorAtStart) {
/*  312 */           removeLastFieldSeparator(buffer);
/*      */         }
/*  314 */         buffer.append(data);
/*  315 */         appendFieldSeparator(buffer);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void appendStart(StringBuffer buffer, Object object) {
/*  327 */     if (object != null) {
/*  328 */       appendClassName(buffer, object);
/*  329 */       appendIdentityHashCode(buffer, object);
/*  330 */       appendContentStart(buffer);
/*  331 */       if (this.fieldSeparatorAtStart) {
/*  332 */         appendFieldSeparator(buffer);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void appendEnd(StringBuffer buffer, Object object) {
/*  345 */     if (!this.fieldSeparatorAtEnd) {
/*  346 */       removeLastFieldSeparator(buffer);
/*      */     }
/*  348 */     appendContentEnd(buffer);
/*  349 */     unregister(object);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void removeLastFieldSeparator(StringBuffer buffer) {
/*  359 */     int len = buffer.length();
/*  360 */     int sepLen = this.fieldSeparator.length();
/*  361 */     if (len > 0 && sepLen > 0 && len >= sepLen) {
/*  362 */       boolean match = true;
/*  363 */       for (int i = 0; i < sepLen; i++) {
/*  364 */         if (buffer.charAt(len - 1 - i) != this.fieldSeparator.charAt(sepLen - 1 - i)) {
/*  365 */           match = false;
/*      */           break;
/*      */         } 
/*      */       } 
/*  369 */       if (match) {
/*  370 */         buffer.setLength(len - sepLen);
/*      */       }
/*      */     } 
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
/*      */   public void append(StringBuffer buffer, String fieldName, Object value, Boolean fullDetail) {
/*  389 */     appendFieldStart(buffer, fieldName);
/*      */     
/*  391 */     if (value == null) {
/*  392 */       appendNullText(buffer, fieldName);
/*      */     } else {
/*      */       
/*  395 */       appendInternal(buffer, fieldName, value, isFullDetail(fullDetail));
/*      */     } 
/*      */     
/*  398 */     appendFieldEnd(buffer, fieldName);
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
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendInternal(StringBuffer buffer, String fieldName, Object value, boolean detail) {
/*  421 */     if (isRegistered(value) && !(value instanceof Number) && !(value instanceof Boolean) && !(value instanceof Character)) {
/*      */       
/*  423 */       appendCyclicObject(buffer, fieldName, value);
/*      */       
/*      */       return;
/*      */     } 
/*  427 */     register(value);
/*      */     
/*      */     try {
/*  430 */       if (value instanceof Collection) {
/*  431 */         if (detail) {
/*  432 */           appendDetail(buffer, fieldName, (Collection)value);
/*      */         } else {
/*  434 */           appendSummarySize(buffer, fieldName, ((Collection)value).size());
/*      */         }
/*      */       
/*  437 */       } else if (value instanceof Map) {
/*  438 */         if (detail) {
/*  439 */           appendDetail(buffer, fieldName, (Map)value);
/*      */         } else {
/*  441 */           appendSummarySize(buffer, fieldName, ((Map)value).size());
/*      */         }
/*      */       
/*  444 */       } else if (value instanceof long[]) {
/*  445 */         if (detail) {
/*  446 */           appendDetail(buffer, fieldName, (long[])value);
/*      */         } else {
/*  448 */           appendSummary(buffer, fieldName, (long[])value);
/*      */         }
/*      */       
/*  451 */       } else if (value instanceof int[]) {
/*  452 */         if (detail) {
/*  453 */           appendDetail(buffer, fieldName, (int[])value);
/*      */         } else {
/*  455 */           appendSummary(buffer, fieldName, (int[])value);
/*      */         }
/*      */       
/*  458 */       } else if (value instanceof short[]) {
/*  459 */         if (detail) {
/*  460 */           appendDetail(buffer, fieldName, (short[])value);
/*      */         } else {
/*  462 */           appendSummary(buffer, fieldName, (short[])value);
/*      */         }
/*      */       
/*  465 */       } else if (value instanceof byte[]) {
/*  466 */         if (detail) {
/*  467 */           appendDetail(buffer, fieldName, (byte[])value);
/*      */         } else {
/*  469 */           appendSummary(buffer, fieldName, (byte[])value);
/*      */         }
/*      */       
/*  472 */       } else if (value instanceof char[]) {
/*  473 */         if (detail) {
/*  474 */           appendDetail(buffer, fieldName, (char[])value);
/*      */         } else {
/*  476 */           appendSummary(buffer, fieldName, (char[])value);
/*      */         }
/*      */       
/*  479 */       } else if (value instanceof double[]) {
/*  480 */         if (detail) {
/*  481 */           appendDetail(buffer, fieldName, (double[])value);
/*      */         } else {
/*  483 */           appendSummary(buffer, fieldName, (double[])value);
/*      */         }
/*      */       
/*  486 */       } else if (value instanceof float[]) {
/*  487 */         if (detail) {
/*  488 */           appendDetail(buffer, fieldName, (float[])value);
/*      */         } else {
/*  490 */           appendSummary(buffer, fieldName, (float[])value);
/*      */         }
/*      */       
/*  493 */       } else if (value instanceof boolean[]) {
/*  494 */         if (detail) {
/*  495 */           appendDetail(buffer, fieldName, (boolean[])value);
/*      */         } else {
/*  497 */           appendSummary(buffer, fieldName, (boolean[])value);
/*      */         }
/*      */       
/*  500 */       } else if (value.getClass().isArray()) {
/*  501 */         if (detail) {
/*  502 */           appendDetail(buffer, fieldName, (Object[])value);
/*      */         } else {
/*  504 */           appendSummary(buffer, fieldName, (Object[])value);
/*      */         }
/*      */       
/*      */       }
/*  508 */       else if (detail) {
/*  509 */         appendDetail(buffer, fieldName, value);
/*      */       } else {
/*  511 */         appendSummary(buffer, fieldName, value);
/*      */       } 
/*      */     } finally {
/*      */       
/*  515 */       unregister(value);
/*      */     } 
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
/*      */   protected void appendCyclicObject(StringBuffer buffer, String fieldName, Object value) {
/*  532 */     ObjectUtils.appendIdentityToString(buffer, value);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, Object value) {
/*  545 */     buffer.append(value);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, Collection coll) {
/*  557 */     buffer.append(coll);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, Map map) {
/*  569 */     buffer.append(map);
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
/*      */   protected void appendSummary(StringBuffer buffer, String fieldName, Object value) {
/*  582 */     buffer.append(this.summaryObjectStartText);
/*  583 */     buffer.append(getShortClassName(value.getClass()));
/*  584 */     buffer.append(this.summaryObjectEndText);
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
/*      */   public void append(StringBuffer buffer, String fieldName, long value) {
/*  598 */     appendFieldStart(buffer, fieldName);
/*  599 */     appendDetail(buffer, fieldName, value);
/*  600 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, long value) {
/*  612 */     buffer.append(value);
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
/*      */   public void append(StringBuffer buffer, String fieldName, int value) {
/*  626 */     appendFieldStart(buffer, fieldName);
/*  627 */     appendDetail(buffer, fieldName, value);
/*  628 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, int value) {
/*  640 */     buffer.append(value);
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
/*      */   public void append(StringBuffer buffer, String fieldName, short value) {
/*  654 */     appendFieldStart(buffer, fieldName);
/*  655 */     appendDetail(buffer, fieldName, value);
/*  656 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, short value) {
/*  668 */     buffer.append(value);
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
/*      */   public void append(StringBuffer buffer, String fieldName, byte value) {
/*  682 */     appendFieldStart(buffer, fieldName);
/*  683 */     appendDetail(buffer, fieldName, value);
/*  684 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, byte value) {
/*  696 */     buffer.append(value);
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
/*      */   public void append(StringBuffer buffer, String fieldName, char value) {
/*  710 */     appendFieldStart(buffer, fieldName);
/*  711 */     appendDetail(buffer, fieldName, value);
/*  712 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, char value) {
/*  724 */     buffer.append(value);
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
/*      */   public void append(StringBuffer buffer, String fieldName, double value) {
/*  738 */     appendFieldStart(buffer, fieldName);
/*  739 */     appendDetail(buffer, fieldName, value);
/*  740 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, double value) {
/*  752 */     buffer.append(value);
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
/*      */   public void append(StringBuffer buffer, String fieldName, float value) {
/*  766 */     appendFieldStart(buffer, fieldName);
/*  767 */     appendDetail(buffer, fieldName, value);
/*  768 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, float value) {
/*  780 */     buffer.append(value);
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
/*      */   public void append(StringBuffer buffer, String fieldName, boolean value) {
/*  794 */     appendFieldStart(buffer, fieldName);
/*  795 */     appendDetail(buffer, fieldName, value);
/*  796 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, boolean value) {
/*  808 */     buffer.append(value);
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
/*      */   public void append(StringBuffer buffer, String fieldName, Object[] array, Boolean fullDetail) {
/*  822 */     appendFieldStart(buffer, fieldName);
/*      */     
/*  824 */     if (array == null) {
/*  825 */       appendNullText(buffer, fieldName);
/*      */     }
/*  827 */     else if (isFullDetail(fullDetail)) {
/*  828 */       appendDetail(buffer, fieldName, array);
/*      */     } else {
/*      */       
/*  831 */       appendSummary(buffer, fieldName, array);
/*      */     } 
/*      */     
/*  834 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, Object[] array) {
/*  849 */     buffer.append(this.arrayStart);
/*  850 */     for (int i = 0; i < array.length; i++) {
/*  851 */       Object item = array[i];
/*  852 */       if (i > 0) {
/*  853 */         buffer.append(this.arraySeparator);
/*      */       }
/*  855 */       if (item == null) {
/*  856 */         appendNullText(buffer, fieldName);
/*      */       } else {
/*      */         
/*  859 */         appendInternal(buffer, fieldName, item, this.arrayContentDetail);
/*      */       } 
/*      */     } 
/*  862 */     buffer.append(this.arrayEnd);
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
/*      */   protected void reflectionAppendArrayDetail(StringBuffer buffer, String fieldName, Object array) {
/*  875 */     buffer.append(this.arrayStart);
/*  876 */     int length = Array.getLength(array);
/*  877 */     for (int i = 0; i < length; i++) {
/*  878 */       Object item = Array.get(array, i);
/*  879 */       if (i > 0) {
/*  880 */         buffer.append(this.arraySeparator);
/*      */       }
/*  882 */       if (item == null) {
/*  883 */         appendNullText(buffer, fieldName);
/*      */       } else {
/*      */         
/*  886 */         appendInternal(buffer, fieldName, item, this.arrayContentDetail);
/*      */       } 
/*      */     } 
/*  889 */     buffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer buffer, String fieldName, Object[] array) {
/*  902 */     appendSummarySize(buffer, fieldName, array.length);
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
/*      */   public void append(StringBuffer buffer, String fieldName, long[] array, Boolean fullDetail) {
/*  918 */     appendFieldStart(buffer, fieldName);
/*      */     
/*  920 */     if (array == null) {
/*  921 */       appendNullText(buffer, fieldName);
/*      */     }
/*  923 */     else if (isFullDetail(fullDetail)) {
/*  924 */       appendDetail(buffer, fieldName, array);
/*      */     } else {
/*      */       
/*  927 */       appendSummary(buffer, fieldName, array);
/*      */     } 
/*      */     
/*  930 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, long[] array) {
/*  943 */     buffer.append(this.arrayStart);
/*  944 */     for (int i = 0; i < array.length; i++) {
/*  945 */       if (i > 0) {
/*  946 */         buffer.append(this.arraySeparator);
/*      */       }
/*  948 */       appendDetail(buffer, fieldName, array[i]);
/*      */     } 
/*  950 */     buffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer buffer, String fieldName, long[] array) {
/*  963 */     appendSummarySize(buffer, fieldName, array.length);
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
/*      */   public void append(StringBuffer buffer, String fieldName, int[] array, Boolean fullDetail) {
/*  979 */     appendFieldStart(buffer, fieldName);
/*      */     
/*  981 */     if (array == null) {
/*  982 */       appendNullText(buffer, fieldName);
/*      */     }
/*  984 */     else if (isFullDetail(fullDetail)) {
/*  985 */       appendDetail(buffer, fieldName, array);
/*      */     } else {
/*      */       
/*  988 */       appendSummary(buffer, fieldName, array);
/*      */     } 
/*      */     
/*  991 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, int[] array) {
/* 1004 */     buffer.append(this.arrayStart);
/* 1005 */     for (int i = 0; i < array.length; i++) {
/* 1006 */       if (i > 0) {
/* 1007 */         buffer.append(this.arraySeparator);
/*      */       }
/* 1009 */       appendDetail(buffer, fieldName, array[i]);
/*      */     } 
/* 1011 */     buffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer buffer, String fieldName, int[] array) {
/* 1024 */     appendSummarySize(buffer, fieldName, array.length);
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
/*      */   public void append(StringBuffer buffer, String fieldName, short[] array, Boolean fullDetail) {
/* 1040 */     appendFieldStart(buffer, fieldName);
/*      */     
/* 1042 */     if (array == null) {
/* 1043 */       appendNullText(buffer, fieldName);
/*      */     }
/* 1045 */     else if (isFullDetail(fullDetail)) {
/* 1046 */       appendDetail(buffer, fieldName, array);
/*      */     } else {
/*      */       
/* 1049 */       appendSummary(buffer, fieldName, array);
/*      */     } 
/*      */     
/* 1052 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, short[] array) {
/* 1065 */     buffer.append(this.arrayStart);
/* 1066 */     for (int i = 0; i < array.length; i++) {
/* 1067 */       if (i > 0) {
/* 1068 */         buffer.append(this.arraySeparator);
/*      */       }
/* 1070 */       appendDetail(buffer, fieldName, array[i]);
/*      */     } 
/* 1072 */     buffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer buffer, String fieldName, short[] array) {
/* 1085 */     appendSummarySize(buffer, fieldName, array.length);
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
/*      */   public void append(StringBuffer buffer, String fieldName, byte[] array, Boolean fullDetail) {
/* 1101 */     appendFieldStart(buffer, fieldName);
/*      */     
/* 1103 */     if (array == null) {
/* 1104 */       appendNullText(buffer, fieldName);
/*      */     }
/* 1106 */     else if (isFullDetail(fullDetail)) {
/* 1107 */       appendDetail(buffer, fieldName, array);
/*      */     } else {
/*      */       
/* 1110 */       appendSummary(buffer, fieldName, array);
/*      */     } 
/*      */     
/* 1113 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, byte[] array) {
/* 1126 */     buffer.append(this.arrayStart);
/* 1127 */     for (int i = 0; i < array.length; i++) {
/* 1128 */       if (i > 0) {
/* 1129 */         buffer.append(this.arraySeparator);
/*      */       }
/* 1131 */       appendDetail(buffer, fieldName, array[i]);
/*      */     } 
/* 1133 */     buffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer buffer, String fieldName, byte[] array) {
/* 1146 */     appendSummarySize(buffer, fieldName, array.length);
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
/*      */   public void append(StringBuffer buffer, String fieldName, char[] array, Boolean fullDetail) {
/* 1162 */     appendFieldStart(buffer, fieldName);
/*      */     
/* 1164 */     if (array == null) {
/* 1165 */       appendNullText(buffer, fieldName);
/*      */     }
/* 1167 */     else if (isFullDetail(fullDetail)) {
/* 1168 */       appendDetail(buffer, fieldName, array);
/*      */     } else {
/*      */       
/* 1171 */       appendSummary(buffer, fieldName, array);
/*      */     } 
/*      */     
/* 1174 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, char[] array) {
/* 1187 */     buffer.append(this.arrayStart);
/* 1188 */     for (int i = 0; i < array.length; i++) {
/* 1189 */       if (i > 0) {
/* 1190 */         buffer.append(this.arraySeparator);
/*      */       }
/* 1192 */       appendDetail(buffer, fieldName, array[i]);
/*      */     } 
/* 1194 */     buffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer buffer, String fieldName, char[] array) {
/* 1207 */     appendSummarySize(buffer, fieldName, array.length);
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
/*      */   public void append(StringBuffer buffer, String fieldName, double[] array, Boolean fullDetail) {
/* 1223 */     appendFieldStart(buffer, fieldName);
/*      */     
/* 1225 */     if (array == null) {
/* 1226 */       appendNullText(buffer, fieldName);
/*      */     }
/* 1228 */     else if (isFullDetail(fullDetail)) {
/* 1229 */       appendDetail(buffer, fieldName, array);
/*      */     } else {
/*      */       
/* 1232 */       appendSummary(buffer, fieldName, array);
/*      */     } 
/*      */     
/* 1235 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, double[] array) {
/* 1248 */     buffer.append(this.arrayStart);
/* 1249 */     for (int i = 0; i < array.length; i++) {
/* 1250 */       if (i > 0) {
/* 1251 */         buffer.append(this.arraySeparator);
/*      */       }
/* 1253 */       appendDetail(buffer, fieldName, array[i]);
/*      */     } 
/* 1255 */     buffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer buffer, String fieldName, double[] array) {
/* 1268 */     appendSummarySize(buffer, fieldName, array.length);
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
/*      */   public void append(StringBuffer buffer, String fieldName, float[] array, Boolean fullDetail) {
/* 1284 */     appendFieldStart(buffer, fieldName);
/*      */     
/* 1286 */     if (array == null) {
/* 1287 */       appendNullText(buffer, fieldName);
/*      */     }
/* 1289 */     else if (isFullDetail(fullDetail)) {
/* 1290 */       appendDetail(buffer, fieldName, array);
/*      */     } else {
/*      */       
/* 1293 */       appendSummary(buffer, fieldName, array);
/*      */     } 
/*      */     
/* 1296 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, float[] array) {
/* 1309 */     buffer.append(this.arrayStart);
/* 1310 */     for (int i = 0; i < array.length; i++) {
/* 1311 */       if (i > 0) {
/* 1312 */         buffer.append(this.arraySeparator);
/*      */       }
/* 1314 */       appendDetail(buffer, fieldName, array[i]);
/*      */     } 
/* 1316 */     buffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer buffer, String fieldName, float[] array) {
/* 1329 */     appendSummarySize(buffer, fieldName, array.length);
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
/*      */   public void append(StringBuffer buffer, String fieldName, boolean[] array, Boolean fullDetail) {
/* 1345 */     appendFieldStart(buffer, fieldName);
/*      */     
/* 1347 */     if (array == null) {
/* 1348 */       appendNullText(buffer, fieldName);
/*      */     }
/* 1350 */     else if (isFullDetail(fullDetail)) {
/* 1351 */       appendDetail(buffer, fieldName, array);
/*      */     } else {
/*      */       
/* 1354 */       appendSummary(buffer, fieldName, array);
/*      */     } 
/*      */     
/* 1357 */     appendFieldEnd(buffer, fieldName);
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
/*      */   protected void appendDetail(StringBuffer buffer, String fieldName, boolean[] array) {
/* 1370 */     buffer.append(this.arrayStart);
/* 1371 */     for (int i = 0; i < array.length; i++) {
/* 1372 */       if (i > 0) {
/* 1373 */         buffer.append(this.arraySeparator);
/*      */       }
/* 1375 */       appendDetail(buffer, fieldName, array[i]);
/*      */     } 
/* 1377 */     buffer.append(this.arrayEnd);
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
/*      */   protected void appendSummary(StringBuffer buffer, String fieldName, boolean[] array) {
/* 1390 */     appendSummarySize(buffer, fieldName, array.length);
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
/*      */   protected void appendClassName(StringBuffer buffer, Object object) {
/* 1402 */     if (this.useClassName && object != null) {
/* 1403 */       register(object);
/* 1404 */       if (this.useShortClassName) {
/* 1405 */         buffer.append(getShortClassName(object.getClass()));
/*      */       } else {
/* 1407 */         buffer.append(object.getClass().getName());
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendIdentityHashCode(StringBuffer buffer, Object object) {
/* 1419 */     if (isUseIdentityHashCode() && object != null) {
/* 1420 */       register(object);
/* 1421 */       buffer.append('@');
/* 1422 */       buffer.append(Integer.toHexString(System.identityHashCode(object)));
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendContentStart(StringBuffer buffer) {
/* 1432 */     buffer.append(this.contentStart);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendContentEnd(StringBuffer buffer) {
/* 1441 */     buffer.append(this.contentEnd);
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
/*      */   protected void appendNullText(StringBuffer buffer, String fieldName) {
/* 1453 */     buffer.append(this.nullText);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendFieldSeparator(StringBuffer buffer) {
/* 1462 */     buffer.append(this.fieldSeparator);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendFieldStart(StringBuffer buffer, String fieldName) {
/* 1472 */     if (this.useFieldNames && fieldName != null) {
/* 1473 */       buffer.append(fieldName);
/* 1474 */       buffer.append(this.fieldNameValueSeparator);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void appendFieldEnd(StringBuffer buffer, String fieldName) {
/* 1485 */     appendFieldSeparator(buffer);
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
/*      */   protected void appendSummarySize(StringBuffer buffer, String fieldName, int size) {
/* 1504 */     buffer.append(this.sizeStartText);
/* 1505 */     buffer.append(size);
/* 1506 */     buffer.append(this.sizeEndText);
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
/*      */   protected boolean isFullDetail(Boolean fullDetailRequest) {
/* 1524 */     if (fullDetailRequest == null) {
/* 1525 */       return this.defaultFullDetail;
/*      */     }
/* 1527 */     return fullDetailRequest.booleanValue();
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
/*      */   protected String getShortClassName(Class cls) {
/* 1540 */     return ClassUtils.getShortClassName(cls);
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
/*      */   protected boolean isUseClassName() {
/* 1554 */     return this.useClassName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setUseClassName(boolean useClassName) {
/* 1563 */     this.useClassName = useClassName;
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
/*      */   protected boolean isUseShortClassName() {
/* 1575 */     return this.useShortClassName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isShortClassName() {
/* 1586 */     return this.useShortClassName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setUseShortClassName(boolean useShortClassName) {
/* 1596 */     this.useShortClassName = useShortClassName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setShortClassName(boolean shortClassName) {
/* 1607 */     this.useShortClassName = shortClassName;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isUseIdentityHashCode() {
/* 1618 */     return this.useIdentityHashCode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setUseIdentityHashCode(boolean useIdentityHashCode) {
/* 1627 */     this.useIdentityHashCode = useIdentityHashCode;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isUseFieldNames() {
/* 1638 */     return this.useFieldNames;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setUseFieldNames(boolean useFieldNames) {
/* 1647 */     this.useFieldNames = useFieldNames;
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
/*      */   protected boolean isDefaultFullDetail() {
/* 1659 */     return this.defaultFullDetail;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setDefaultFullDetail(boolean defaultFullDetail) {
/* 1669 */     this.defaultFullDetail = defaultFullDetail;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected boolean isArrayContentDetail() {
/* 1680 */     return this.arrayContentDetail;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setArrayContentDetail(boolean arrayContentDetail) {
/* 1689 */     this.arrayContentDetail = arrayContentDetail;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getArrayStart() {
/* 1700 */     return this.arrayStart;
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
/*      */   protected void setArrayStart(String arrayStart) {
/* 1712 */     if (arrayStart == null) {
/* 1713 */       arrayStart = "";
/*      */     }
/* 1715 */     this.arrayStart = arrayStart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getArrayEnd() {
/* 1726 */     return this.arrayEnd;
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
/*      */   protected void setArrayEnd(String arrayEnd) {
/* 1738 */     if (arrayEnd == null) {
/* 1739 */       arrayEnd = "";
/*      */     }
/* 1741 */     this.arrayEnd = arrayEnd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getArraySeparator() {
/* 1752 */     return this.arraySeparator;
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
/*      */   protected void setArraySeparator(String arraySeparator) {
/* 1764 */     if (arraySeparator == null) {
/* 1765 */       arraySeparator = "";
/*      */     }
/* 1767 */     this.arraySeparator = arraySeparator;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getContentStart() {
/* 1778 */     return this.contentStart;
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
/*      */   protected void setContentStart(String contentStart) {
/* 1790 */     if (contentStart == null) {
/* 1791 */       contentStart = "";
/*      */     }
/* 1793 */     this.contentStart = contentStart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getContentEnd() {
/* 1804 */     return this.contentEnd;
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
/*      */   protected void setContentEnd(String contentEnd) {
/* 1816 */     if (contentEnd == null) {
/* 1817 */       contentEnd = "";
/*      */     }
/* 1819 */     this.contentEnd = contentEnd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getFieldNameValueSeparator() {
/* 1830 */     return this.fieldNameValueSeparator;
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
/*      */   protected void setFieldNameValueSeparator(String fieldNameValueSeparator) {
/* 1842 */     if (fieldNameValueSeparator == null) {
/* 1843 */       fieldNameValueSeparator = "";
/*      */     }
/* 1845 */     this.fieldNameValueSeparator = fieldNameValueSeparator;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getFieldSeparator() {
/* 1856 */     return this.fieldSeparator;
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
/*      */   protected void setFieldSeparator(String fieldSeparator) {
/* 1868 */     if (fieldSeparator == null) {
/* 1869 */       fieldSeparator = "";
/*      */     }
/* 1871 */     this.fieldSeparator = fieldSeparator;
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
/*      */   protected boolean isFieldSeparatorAtStart() {
/* 1884 */     return this.fieldSeparatorAtStart;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setFieldSeparatorAtStart(boolean fieldSeparatorAtStart) {
/* 1895 */     this.fieldSeparatorAtStart = fieldSeparatorAtStart;
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
/*      */   protected boolean isFieldSeparatorAtEnd() {
/* 1908 */     return this.fieldSeparatorAtEnd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected void setFieldSeparatorAtEnd(boolean fieldSeparatorAtEnd) {
/* 1919 */     this.fieldSeparatorAtEnd = fieldSeparatorAtEnd;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   protected String getNullText() {
/* 1930 */     return this.nullText;
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
/*      */   protected void setNullText(String nullText) {
/* 1942 */     if (nullText == null) {
/* 1943 */       nullText = "";
/*      */     }
/* 1945 */     this.nullText = nullText;
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
/*      */   protected String getSizeStartText() {
/* 1959 */     return this.sizeStartText;
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
/*      */   protected void setSizeStartText(String sizeStartText) {
/* 1974 */     if (sizeStartText == null) {
/* 1975 */       sizeStartText = "";
/*      */     }
/* 1977 */     this.sizeStartText = sizeStartText;
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
/*      */   protected String getSizeEndText() {
/* 1991 */     return this.sizeEndText;
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
/*      */   protected void setSizeEndText(String sizeEndText) {
/* 2006 */     if (sizeEndText == null) {
/* 2007 */       sizeEndText = "";
/*      */     }
/* 2009 */     this.sizeEndText = sizeEndText;
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
/*      */   protected String getSummaryObjectStartText() {
/* 2023 */     return this.summaryObjectStartText;
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
/*      */   protected void setSummaryObjectStartText(String summaryObjectStartText) {
/* 2038 */     if (summaryObjectStartText == null) {
/* 2039 */       summaryObjectStartText = "";
/*      */     }
/* 2041 */     this.summaryObjectStartText = summaryObjectStartText;
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
/*      */   protected String getSummaryObjectEndText() {
/* 2055 */     return this.summaryObjectEndText;
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
/*      */   protected void setSummaryObjectEndText(String summaryObjectEndText) {
/* 2070 */     if (summaryObjectEndText == null) {
/* 2071 */       summaryObjectEndText = "";
/*      */     }
/* 2073 */     this.summaryObjectEndText = summaryObjectEndText;
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
/*      */   private static final class DefaultToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
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
/*      */     private Object readResolve() {
/* 2108 */       return ToStringStyle.DEFAULT_STYLE;
/*      */     }
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
/*      */   private static final class NoFieldNameToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     NoFieldNameToStringStyle() {
/* 2133 */       setUseFieldNames(false);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object readResolve() {
/* 2142 */       return ToStringStyle.NO_FIELD_NAMES_STYLE;
/*      */     }
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
/*      */   private static final class ShortPrefixToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     ShortPrefixToStringStyle() {
/* 2167 */       setUseShortClassName(true);
/* 2168 */       setUseIdentityHashCode(false);
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object readResolve() {
/* 2176 */       return ToStringStyle.SHORT_PREFIX_STYLE;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class SimpleToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     SimpleToStringStyle() {
/* 2199 */       setUseClassName(false);
/* 2200 */       setUseIdentityHashCode(false);
/* 2201 */       setUseFieldNames(false);
/* 2202 */       setContentStart("");
/* 2203 */       setContentEnd("");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object readResolve() {
/* 2211 */       return ToStringStyle.SIMPLE_STYLE;
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static final class MultiLineToStringStyle
/*      */     extends ToStringStyle
/*      */   {
/*      */     private static final long serialVersionUID = 1L;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     MultiLineToStringStyle() {
/* 2235 */       setContentStart("[");
/* 2236 */       setFieldSeparator(SystemUtils.LINE_SEPARATOR + "  ");
/* 2237 */       setFieldSeparatorAtStart(true);
/* 2238 */       setContentEnd(SystemUtils.LINE_SEPARATOR + "]");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     private Object readResolve() {
/* 2247 */       return ToStringStyle.MULTI_LINE_STYLE;
/*      */     }
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\builder\ToStringStyle.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */