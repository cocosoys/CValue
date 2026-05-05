/*      */ package org.apache.commons.lang.builder;
/*      */ 
/*      */ import org.apache.commons.lang.BooleanUtils;
/*      */ import org.apache.commons.lang.ObjectUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ToStringBuilder
/*      */ {
/*   98 */   private static ToStringStyle defaultStyle = ToStringStyle.DEFAULT_STYLE;
/*      */ 
/*      */ 
/*      */   
/*      */   private final StringBuffer buffer;
/*      */ 
/*      */ 
/*      */   
/*      */   private final Object object;
/*      */ 
/*      */ 
/*      */   
/*      */   private final ToStringStyle style;
/*      */ 
/*      */ 
/*      */   
/*      */   public static ToStringStyle getDefaultStyle() {
/*  115 */     return defaultStyle;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String reflectionToString(Object object) {
/*  126 */     return ReflectionToStringBuilder.toString(object);
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
/*      */   public static String reflectionToString(Object object, ToStringStyle style) {
/*  138 */     return ReflectionToStringBuilder.toString(object, style);
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
/*      */   public static String reflectionToString(Object object, ToStringStyle style, boolean outputTransients) {
/*  151 */     return ReflectionToStringBuilder.toString(object, style, outputTransients, false, null);
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
/*      */   public static String reflectionToString(Object object, ToStringStyle style, boolean outputTransients, Class reflectUpToClass) {
/*  170 */     return ReflectionToStringBuilder.toString(object, style, outputTransients, false, reflectUpToClass);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void setDefaultStyle(ToStringStyle style) {
/*  180 */     if (style == null) {
/*  181 */       throw new IllegalArgumentException("The style must not be null");
/*      */     }
/*  183 */     defaultStyle = style;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder(Object object) {
/*  212 */     this(object, getDefaultStyle(), null);
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
/*      */   public ToStringBuilder(Object object, ToStringStyle style) {
/*  228 */     this(object, style, null);
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
/*      */   public ToStringBuilder(Object object, ToStringStyle style, StringBuffer buffer) {
/*  245 */     if (style == null) {
/*  246 */       style = getDefaultStyle();
/*      */     }
/*  248 */     if (buffer == null) {
/*  249 */       buffer = new StringBuffer(512);
/*      */     }
/*  251 */     this.buffer = buffer;
/*  252 */     this.style = style;
/*  253 */     this.object = object;
/*      */     
/*  255 */     style.appendStart(buffer, object);
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
/*      */   public ToStringBuilder append(boolean value) {
/*  268 */     this.style.append(this.buffer, (String)null, value);
/*  269 */     return this;
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
/*      */   public ToStringBuilder append(boolean[] array) {
/*  282 */     this.style.append(this.buffer, (String)null, array, (Boolean)null);
/*  283 */     return this;
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
/*      */   public ToStringBuilder append(byte value) {
/*  296 */     this.style.append(this.buffer, (String)null, value);
/*  297 */     return this;
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
/*      */   public ToStringBuilder append(byte[] array) {
/*  310 */     this.style.append(this.buffer, (String)null, array, (Boolean)null);
/*  311 */     return this;
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
/*      */   public ToStringBuilder append(char value) {
/*  324 */     this.style.append(this.buffer, (String)null, value);
/*  325 */     return this;
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
/*      */   public ToStringBuilder append(char[] array) {
/*  338 */     this.style.append(this.buffer, (String)null, array, (Boolean)null);
/*  339 */     return this;
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
/*      */   public ToStringBuilder append(double value) {
/*  352 */     this.style.append(this.buffer, (String)null, value);
/*  353 */     return this;
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
/*      */   public ToStringBuilder append(double[] array) {
/*  366 */     this.style.append(this.buffer, (String)null, array, (Boolean)null);
/*  367 */     return this;
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
/*      */   public ToStringBuilder append(float value) {
/*  380 */     this.style.append(this.buffer, (String)null, value);
/*  381 */     return this;
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
/*      */   public ToStringBuilder append(float[] array) {
/*  394 */     this.style.append(this.buffer, (String)null, array, (Boolean)null);
/*  395 */     return this;
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
/*      */   public ToStringBuilder append(int value) {
/*  408 */     this.style.append(this.buffer, (String)null, value);
/*  409 */     return this;
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
/*      */   public ToStringBuilder append(int[] array) {
/*  422 */     this.style.append(this.buffer, (String)null, array, (Boolean)null);
/*  423 */     return this;
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
/*      */   public ToStringBuilder append(long value) {
/*  436 */     this.style.append(this.buffer, (String)null, value);
/*  437 */     return this;
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
/*      */   public ToStringBuilder append(long[] array) {
/*  450 */     this.style.append(this.buffer, (String)null, array, (Boolean)null);
/*  451 */     return this;
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
/*      */   public ToStringBuilder append(Object obj) {
/*  464 */     this.style.append(this.buffer, (String)null, obj, (Boolean)null);
/*  465 */     return this;
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
/*      */   public ToStringBuilder append(Object[] array) {
/*  478 */     this.style.append(this.buffer, (String)null, array, (Boolean)null);
/*  479 */     return this;
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
/*      */   public ToStringBuilder append(short value) {
/*  492 */     this.style.append(this.buffer, (String)null, value);
/*  493 */     return this;
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
/*      */   public ToStringBuilder append(short[] array) {
/*  506 */     this.style.append(this.buffer, (String)null, array, (Boolean)null);
/*  507 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, boolean value) {
/*  519 */     this.style.append(this.buffer, fieldName, value);
/*  520 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, boolean[] array) {
/*  532 */     this.style.append(this.buffer, fieldName, array, (Boolean)null);
/*  533 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, boolean[] array, boolean fullDetail) {
/*  552 */     this.style.append(this.buffer, fieldName, array, BooleanUtils.toBooleanObject(fullDetail));
/*  553 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, byte value) {
/*  565 */     this.style.append(this.buffer, fieldName, value);
/*  566 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder append(String fieldName, byte[] array) {
/*  577 */     this.style.append(this.buffer, fieldName, array, (Boolean)null);
/*  578 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, byte[] array, boolean fullDetail) {
/*  597 */     this.style.append(this.buffer, fieldName, array, BooleanUtils.toBooleanObject(fullDetail));
/*  598 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, char value) {
/*  610 */     this.style.append(this.buffer, fieldName, value);
/*  611 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, char[] array) {
/*  623 */     this.style.append(this.buffer, fieldName, array, (Boolean)null);
/*  624 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, char[] array, boolean fullDetail) {
/*  643 */     this.style.append(this.buffer, fieldName, array, BooleanUtils.toBooleanObject(fullDetail));
/*  644 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, double value) {
/*  656 */     this.style.append(this.buffer, fieldName, value);
/*  657 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, double[] array) {
/*  669 */     this.style.append(this.buffer, fieldName, array, (Boolean)null);
/*  670 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, double[] array, boolean fullDetail) {
/*  689 */     this.style.append(this.buffer, fieldName, array, BooleanUtils.toBooleanObject(fullDetail));
/*  690 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, float value) {
/*  702 */     this.style.append(this.buffer, fieldName, value);
/*  703 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, float[] array) {
/*  715 */     this.style.append(this.buffer, fieldName, array, (Boolean)null);
/*  716 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, float[] array, boolean fullDetail) {
/*  735 */     this.style.append(this.buffer, fieldName, array, BooleanUtils.toBooleanObject(fullDetail));
/*  736 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, int value) {
/*  748 */     this.style.append(this.buffer, fieldName, value);
/*  749 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, int[] array) {
/*  761 */     this.style.append(this.buffer, fieldName, array, (Boolean)null);
/*  762 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, int[] array, boolean fullDetail) {
/*  781 */     this.style.append(this.buffer, fieldName, array, BooleanUtils.toBooleanObject(fullDetail));
/*  782 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, long value) {
/*  794 */     this.style.append(this.buffer, fieldName, value);
/*  795 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, long[] array) {
/*  807 */     this.style.append(this.buffer, fieldName, array, (Boolean)null);
/*  808 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, long[] array, boolean fullDetail) {
/*  827 */     this.style.append(this.buffer, fieldName, array, BooleanUtils.toBooleanObject(fullDetail));
/*  828 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, Object obj) {
/*  840 */     this.style.append(this.buffer, fieldName, obj, (Boolean)null);
/*  841 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, Object obj, boolean fullDetail) {
/*  855 */     this.style.append(this.buffer, fieldName, obj, BooleanUtils.toBooleanObject(fullDetail));
/*  856 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, Object[] array) {
/*  868 */     this.style.append(this.buffer, fieldName, array, (Boolean)null);
/*  869 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, Object[] array, boolean fullDetail) {
/*  888 */     this.style.append(this.buffer, fieldName, array, BooleanUtils.toBooleanObject(fullDetail));
/*  889 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, short value) {
/*  901 */     this.style.append(this.buffer, fieldName, value);
/*  902 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, short[] array) {
/*  914 */     this.style.append(this.buffer, fieldName, array, (Boolean)null);
/*  915 */     return this;
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
/*      */   public ToStringBuilder append(String fieldName, short[] array, boolean fullDetail) {
/*  934 */     this.style.append(this.buffer, fieldName, array, BooleanUtils.toBooleanObject(fullDetail));
/*  935 */     return this;
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
/*      */   public ToStringBuilder appendAsObjectToString(Object object) {
/*  948 */     ObjectUtils.appendIdentityToString(getStringBuffer(), object);
/*  949 */     return this;
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
/*      */   public ToStringBuilder appendSuper(String superToString) {
/*  967 */     if (superToString != null) {
/*  968 */       this.style.appendSuper(this.buffer, superToString);
/*      */     }
/*  970 */     return this;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public ToStringBuilder appendToString(String toString) {
/* 1001 */     if (toString != null) {
/* 1002 */       this.style.appendToString(this.buffer, toString);
/*      */     }
/* 1004 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Object getObject() {
/* 1014 */     return this.object;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public StringBuffer getStringBuffer() {
/* 1023 */     return this.buffer;
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
/*      */   public ToStringStyle getStyle() {
/* 1035 */     return this.style;
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
/*      */   public String toString() {
/* 1049 */     if (getObject() == null) {
/* 1050 */       getStringBuffer().append(getStyle().getNullText());
/*      */     } else {
/* 1052 */       this.style.appendEnd(getStringBuffer(), getObject());
/*      */     } 
/* 1054 */     return getStringBuffer().toString();
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\builder\ToStringBuilder.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */