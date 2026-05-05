/*     */ package org.apache.commons.lang.builder;
/*     */ 
/*     */ import java.lang.reflect.AccessibleObject;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import org.apache.commons.lang.ArrayUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ReflectionToStringBuilder
/*     */   extends ToStringBuilder
/*     */ {
/*     */   public static String toString(Object object) {
/* 120 */     return toString(object, null, false, false, null);
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
/*     */   public static String toString(Object object, ToStringStyle style) {
/* 152 */     return toString(object, style, false, false, null);
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
/*     */   public static String toString(Object object, ToStringStyle style, boolean outputTransients) {
/* 190 */     return toString(object, style, outputTransients, false, null);
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
/*     */   public static String toString(Object object, ToStringStyle style, boolean outputTransients, boolean outputStatics) {
/* 236 */     return toString(object, style, outputTransients, outputStatics, null);
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
/*     */   public static String toString(Object object, ToStringStyle style, boolean outputTransients, boolean outputStatics, Class reflectUpToClass) {
/* 286 */     return (new ReflectionToStringBuilder(object, style, null, reflectUpToClass, outputTransients, outputStatics)).toString();
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
/*     */   public static String toString(Object object, ToStringStyle style, boolean outputTransients, Class reflectUpToClass) {
/* 333 */     return (new ReflectionToStringBuilder(object, style, null, reflectUpToClass, outputTransients)).toString();
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
/*     */   public static String toStringExclude(Object object, String excludeFieldName) {
/* 346 */     return toStringExclude(object, new String[] { excludeFieldName });
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
/*     */   public static String toStringExclude(Object object, Collection excludeFieldNames) {
/* 359 */     return toStringExclude(object, toNoNullStringArray(excludeFieldNames));
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
/*     */   static String[] toNoNullStringArray(Collection collection) {
/* 372 */     if (collection == null) {
/* 373 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*     */     }
/* 375 */     return toNoNullStringArray(collection.toArray());
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
/*     */   static String[] toNoNullStringArray(Object[] array) {
/* 388 */     ArrayList list = new ArrayList(array.length);
/* 389 */     for (int i = 0; i < array.length; i++) {
/* 390 */       Object e = array[i];
/* 391 */       if (e != null) {
/* 392 */         list.add(e.toString());
/*     */       }
/*     */     } 
/* 395 */     return list.<String>toArray(ArrayUtils.EMPTY_STRING_ARRAY);
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
/*     */   public static String toStringExclude(Object object, String[] excludeFieldNames) {
/* 409 */     return (new ReflectionToStringBuilder(object)).setExcludeFieldNames(excludeFieldNames).toString();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean appendStatics = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean appendTransients = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String[] excludeFieldNames;
/*     */ 
/*     */ 
/*     */   
/* 430 */   private Class upToClass = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReflectionToStringBuilder(Object object) {
/* 447 */     super(object);
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
/*     */   public ReflectionToStringBuilder(Object object, ToStringStyle style) {
/* 467 */     super(object, style);
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
/*     */   public ReflectionToStringBuilder(Object object, ToStringStyle style, StringBuffer buffer) {
/* 493 */     super(object, style, buffer);
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
/*     */   public ReflectionToStringBuilder(Object object, ToStringStyle style, StringBuffer buffer, Class reflectUpToClass, boolean outputTransients) {
/* 514 */     super(object, style, buffer);
/* 515 */     setUpToClass(reflectUpToClass);
/* 516 */     setAppendTransients(outputTransients);
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
/*     */   public ReflectionToStringBuilder(Object object, ToStringStyle style, StringBuffer buffer, Class reflectUpToClass, boolean outputTransients, boolean outputStatics) {
/* 538 */     super(object, style, buffer);
/* 539 */     setUpToClass(reflectUpToClass);
/* 540 */     setAppendTransients(outputTransients);
/* 541 */     setAppendStatics(outputStatics);
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
/*     */   protected boolean accept(Field field) {
/* 557 */     if (field.getName().indexOf('$') != -1)
/*     */     {
/* 559 */       return false;
/*     */     }
/* 561 */     if (Modifier.isTransient(field.getModifiers()) && !isAppendTransients())
/*     */     {
/* 563 */       return false;
/*     */     }
/* 565 */     if (Modifier.isStatic(field.getModifiers()) && !isAppendStatics())
/*     */     {
/* 567 */       return false;
/*     */     }
/* 569 */     if (getExcludeFieldNames() != null && Arrays.binarySearch((Object[])getExcludeFieldNames(), field.getName()) >= 0)
/*     */     {
/*     */       
/* 572 */       return false;
/*     */     }
/* 574 */     return true;
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
/*     */   protected void appendFieldsIn(Class clazz) {
/* 591 */     if (clazz.isArray()) {
/* 592 */       reflectionAppendArray(getObject());
/*     */       return;
/*     */     } 
/* 595 */     Field[] fields = clazz.getDeclaredFields();
/* 596 */     AccessibleObject.setAccessible((AccessibleObject[])fields, true);
/* 597 */     for (int i = 0; i < fields.length; i++) {
/* 598 */       Field field = fields[i];
/* 599 */       String fieldName = field.getName();
/* 600 */       if (accept(field)) {
/*     */         
/*     */         try {
/*     */           
/* 604 */           Object fieldValue = getValue(field);
/* 605 */           append(fieldName, fieldValue);
/*     */         
/*     */         }
/*     */         catch (IllegalAccessException ex) {
/*     */ 
/*     */           
/* 611 */           throw new InternalError("Unexpected IllegalAccessException: " + ex.getMessage());
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String[] getExcludeFieldNames() {
/* 621 */     return this.excludeFieldNames;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Class getUpToClass() {
/* 632 */     return this.upToClass;
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
/*     */   protected Object getValue(Field field) throws IllegalArgumentException, IllegalAccessException {
/* 652 */     return field.get(getObject());
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
/*     */   public boolean isAppendStatics() {
/* 664 */     return this.appendStatics;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAppendTransients() {
/* 675 */     return this.appendTransients;
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
/*     */   public ToStringBuilder reflectionAppendArray(Object array) {
/* 688 */     getStyle().reflectionAppendArrayDetail(getStringBuffer(), null, array);
/* 689 */     return this;
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
/*     */   public void setAppendStatics(boolean appendStatics) {
/* 702 */     this.appendStatics = appendStatics;
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
/*     */   public void setAppendTransients(boolean appendTransients) {
/* 714 */     this.appendTransients = appendTransients;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ReflectionToStringBuilder setExcludeFieldNames(String[] excludeFieldNamesParam) {
/* 725 */     if (excludeFieldNamesParam == null) {
/* 726 */       this.excludeFieldNames = null;
/*     */     } else {
/* 728 */       this.excludeFieldNames = toNoNullStringArray((Object[])excludeFieldNamesParam);
/* 729 */       Arrays.sort((Object[])this.excludeFieldNames);
/*     */     } 
/* 731 */     return this;
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
/*     */   public void setUpToClass(Class clazz) {
/* 743 */     this.upToClass = clazz;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 754 */     if (getObject() == null) {
/* 755 */       return getStyle().getNullText();
/*     */     }
/* 757 */     Class clazz = getObject().getClass();
/* 758 */     appendFieldsIn(clazz);
/* 759 */     while (clazz.getSuperclass() != null && clazz != getUpToClass()) {
/* 760 */       clazz = clazz.getSuperclass();
/* 761 */       appendFieldsIn(clazz);
/*     */     } 
/* 763 */     return super.toString();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\builder\ReflectionToStringBuilder.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */