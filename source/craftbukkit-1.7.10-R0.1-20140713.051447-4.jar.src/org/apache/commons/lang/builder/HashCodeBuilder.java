/*     */ package org.apache.commons.lang.builder;
/*     */ 
/*     */ import java.lang.reflect.AccessibleObject;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.Set;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class HashCodeBuilder
/*     */ {
/* 105 */   private static ThreadLocal registry = new ThreadLocal()
/*     */     {
/*     */       protected synchronized Object initialValue()
/*     */       {
/* 109 */         return new HashSet();
/*     */       }
/*     */     };
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int iConstant;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static Set getRegistry() {
/* 122 */     return registry.get();
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
/*     */   static boolean isRegistered(Object value) {
/* 137 */     return getRegistry().contains(toIdentityHashCodeInteger(value));
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
/*     */   private static void reflectionAppend(Object object, Class clazz, HashCodeBuilder builder, boolean useTransients, String[] excludeFields) {
/* 158 */     if (isRegistered(object)) {
/*     */       return;
/*     */     }
/*     */     try {
/* 162 */       register(object);
/* 163 */       Field[] fields = clazz.getDeclaredFields();
/* 164 */       List excludedFieldList = (excludeFields != null) ? Arrays.<String>asList(excludeFields) : Collections.EMPTY_LIST;
/* 165 */       AccessibleObject.setAccessible((AccessibleObject[])fields, true);
/* 166 */       for (int i = 0; i < fields.length; i++) {
/* 167 */         Field field = fields[i];
/* 168 */         if (!excludedFieldList.contains(field.getName()) && field.getName().indexOf('$') == -1 && (useTransients || !Modifier.isTransient(field.getModifiers())) && !Modifier.isStatic(field.getModifiers())) {
/*     */           
/*     */           try {
/*     */ 
/*     */             
/* 173 */             Object fieldValue = field.get(object);
/* 174 */             builder.append(fieldValue);
/*     */           }
/*     */           catch (IllegalAccessException e) {
/*     */             
/* 178 */             throw new InternalError("Unexpected IllegalAccessException");
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } finally {
/* 183 */       unregister(object);
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
/*     */   public static int reflectionHashCode(int initialNonZeroOddNumber, int multiplierNonZeroOddNumber, Object object) {
/* 225 */     return reflectionHashCode(initialNonZeroOddNumber, multiplierNonZeroOddNumber, object, false, null, null);
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
/*     */   public static int reflectionHashCode(int initialNonZeroOddNumber, int multiplierNonZeroOddNumber, Object object, boolean testTransients) {
/* 269 */     return reflectionHashCode(initialNonZeroOddNumber, multiplierNonZeroOddNumber, object, testTransients, null, null);
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
/*     */   public static int reflectionHashCode(int initialNonZeroOddNumber, int multiplierNonZeroOddNumber, Object object, boolean testTransients, Class reflectUpToClass) {
/* 291 */     return reflectionHashCode(initialNonZeroOddNumber, multiplierNonZeroOddNumber, object, testTransients, reflectUpToClass, null);
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
/*     */   public static int reflectionHashCode(int initialNonZeroOddNumber, int multiplierNonZeroOddNumber, Object object, boolean testTransients, Class reflectUpToClass, String[] excludeFields) {
/* 343 */     if (object == null) {
/* 344 */       throw new IllegalArgumentException("The object to build a hash code for must not be null");
/*     */     }
/* 346 */     HashCodeBuilder builder = new HashCodeBuilder(initialNonZeroOddNumber, multiplierNonZeroOddNumber);
/* 347 */     Class clazz = object.getClass();
/* 348 */     reflectionAppend(object, clazz, builder, testTransients, excludeFields);
/* 349 */     while (clazz.getSuperclass() != null && clazz != reflectUpToClass) {
/* 350 */       clazz = clazz.getSuperclass();
/* 351 */       reflectionAppend(object, clazz, builder, testTransients, excludeFields);
/*     */     } 
/* 353 */     return builder.toHashCode();
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
/*     */   public static int reflectionHashCode(Object object) {
/* 387 */     return reflectionHashCode(17, 37, object, false, null, null);
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
/*     */   public static int reflectionHashCode(Object object, boolean testTransients) {
/* 423 */     return reflectionHashCode(17, 37, object, testTransients, null, null);
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
/*     */   public static int reflectionHashCode(Object object, Collection excludeFields) {
/* 459 */     return reflectionHashCode(object, ReflectionToStringBuilder.toNoNullStringArray(excludeFields));
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
/*     */   public static int reflectionHashCode(Object object, String[] excludeFields) {
/* 497 */     return reflectionHashCode(17, 37, object, false, null, excludeFields);
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
/*     */   static void register(Object value) {
/* 509 */     getRegistry().add(toIdentityHashCodeInteger(value));
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
/*     */   private static Integer toIdentityHashCodeInteger(Object value) {
/* 521 */     return new Integer(System.identityHashCode(value));
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
/*     */   static void unregister(Object value) {
/* 537 */     getRegistry().remove(toIdentityHashCodeInteger(value));
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
/* 548 */   private int iTotal = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public HashCodeBuilder() {
/* 556 */     this.iConstant = 37;
/* 557 */     this.iTotal = 17;
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
/*     */   public HashCodeBuilder(int initialNonZeroOddNumber, int multiplierNonZeroOddNumber) {
/* 578 */     if (initialNonZeroOddNumber == 0) {
/* 579 */       throw new IllegalArgumentException("HashCodeBuilder requires a non zero initial value");
/*     */     }
/* 581 */     if (initialNonZeroOddNumber % 2 == 0) {
/* 582 */       throw new IllegalArgumentException("HashCodeBuilder requires an odd initial value");
/*     */     }
/* 584 */     if (multiplierNonZeroOddNumber == 0) {
/* 585 */       throw new IllegalArgumentException("HashCodeBuilder requires a non zero multiplier");
/*     */     }
/* 587 */     if (multiplierNonZeroOddNumber % 2 == 0) {
/* 588 */       throw new IllegalArgumentException("HashCodeBuilder requires an odd multiplier");
/*     */     }
/* 590 */     this.iConstant = multiplierNonZeroOddNumber;
/* 591 */     this.iTotal = initialNonZeroOddNumber;
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
/*     */   public HashCodeBuilder append(boolean value) {
/* 609 */     this.iTotal = this.iTotal * this.iConstant + (value ? 0 : 1);
/* 610 */     return this;
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
/*     */   public HashCodeBuilder append(boolean[] array) {
/* 623 */     if (array == null) {
/* 624 */       this.iTotal *= this.iConstant;
/*     */     } else {
/* 626 */       for (int i = 0; i < array.length; i++) {
/* 627 */         append(array[i]);
/*     */       }
/*     */     } 
/* 630 */     return this;
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
/*     */   public HashCodeBuilder append(byte value) {
/* 645 */     this.iTotal = this.iTotal * this.iConstant + value;
/* 646 */     return this;
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
/*     */   public HashCodeBuilder append(byte[] array) {
/* 661 */     if (array == null) {
/* 662 */       this.iTotal *= this.iConstant;
/*     */     } else {
/* 664 */       for (int i = 0; i < array.length; i++) {
/* 665 */         append(array[i]);
/*     */       }
/*     */     } 
/* 668 */     return this;
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
/*     */   public HashCodeBuilder append(char value) {
/* 681 */     this.iTotal = this.iTotal * this.iConstant + value;
/* 682 */     return this;
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
/*     */   public HashCodeBuilder append(char[] array) {
/* 695 */     if (array == null) {
/* 696 */       this.iTotal *= this.iConstant;
/*     */     } else {
/* 698 */       for (int i = 0; i < array.length; i++) {
/* 699 */         append(array[i]);
/*     */       }
/*     */     } 
/* 702 */     return this;
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
/*     */   public HashCodeBuilder append(double value) {
/* 715 */     return append(Double.doubleToLongBits(value));
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
/*     */   public HashCodeBuilder append(double[] array) {
/* 728 */     if (array == null) {
/* 729 */       this.iTotal *= this.iConstant;
/*     */     } else {
/* 731 */       for (int i = 0; i < array.length; i++) {
/* 732 */         append(array[i]);
/*     */       }
/*     */     } 
/* 735 */     return this;
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
/*     */   public HashCodeBuilder append(float value) {
/* 748 */     this.iTotal = this.iTotal * this.iConstant + Float.floatToIntBits(value);
/* 749 */     return this;
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
/*     */   public HashCodeBuilder append(float[] array) {
/* 762 */     if (array == null) {
/* 763 */       this.iTotal *= this.iConstant;
/*     */     } else {
/* 765 */       for (int i = 0; i < array.length; i++) {
/* 766 */         append(array[i]);
/*     */       }
/*     */     } 
/* 769 */     return this;
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
/*     */   public HashCodeBuilder append(int value) {
/* 782 */     this.iTotal = this.iTotal * this.iConstant + value;
/* 783 */     return this;
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
/*     */   public HashCodeBuilder append(int[] array) {
/* 796 */     if (array == null) {
/* 797 */       this.iTotal *= this.iConstant;
/*     */     } else {
/* 799 */       for (int i = 0; i < array.length; i++) {
/* 800 */         append(array[i]);
/*     */       }
/*     */     } 
/* 803 */     return this;
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
/*     */   public HashCodeBuilder append(long value) {
/* 816 */     this.iTotal = this.iTotal * this.iConstant + (int)(value ^ value >> 32L);
/* 817 */     return this;
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
/*     */   public HashCodeBuilder append(long[] array) {
/* 830 */     if (array == null) {
/* 831 */       this.iTotal *= this.iConstant;
/*     */     } else {
/* 833 */       for (int i = 0; i < array.length; i++) {
/* 834 */         append(array[i]);
/*     */       }
/*     */     } 
/* 837 */     return this;
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
/*     */   public HashCodeBuilder append(Object object) {
/* 850 */     if (object == null) {
/* 851 */       this.iTotal *= this.iConstant;
/*     */     
/*     */     }
/* 854 */     else if (!object.getClass().isArray()) {
/*     */       
/* 856 */       this.iTotal = this.iTotal * this.iConstant + object.hashCode();
/*     */ 
/*     */ 
/*     */     
/*     */     }
/* 861 */     else if (object instanceof long[]) {
/* 862 */       append((long[])object);
/* 863 */     } else if (object instanceof int[]) {
/* 864 */       append((int[])object);
/* 865 */     } else if (object instanceof short[]) {
/* 866 */       append((short[])object);
/* 867 */     } else if (object instanceof char[]) {
/* 868 */       append((char[])object);
/* 869 */     } else if (object instanceof byte[]) {
/* 870 */       append((byte[])object);
/* 871 */     } else if (object instanceof double[]) {
/* 872 */       append((double[])object);
/* 873 */     } else if (object instanceof float[]) {
/* 874 */       append((float[])object);
/* 875 */     } else if (object instanceof boolean[]) {
/* 876 */       append((boolean[])object);
/*     */     } else {
/*     */       
/* 879 */       append((Object[])object);
/*     */     } 
/*     */ 
/*     */     
/* 883 */     return this;
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
/*     */   public HashCodeBuilder append(Object[] array) {
/* 896 */     if (array == null) {
/* 897 */       this.iTotal *= this.iConstant;
/*     */     } else {
/* 899 */       for (int i = 0; i < array.length; i++) {
/* 900 */         append(array[i]);
/*     */       }
/*     */     } 
/* 903 */     return this;
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
/*     */   public HashCodeBuilder append(short value) {
/* 916 */     this.iTotal = this.iTotal * this.iConstant + value;
/* 917 */     return this;
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
/*     */   public HashCodeBuilder append(short[] array) {
/* 930 */     if (array == null) {
/* 931 */       this.iTotal *= this.iConstant;
/*     */     } else {
/* 933 */       for (int i = 0; i < array.length; i++) {
/* 934 */         append(array[i]);
/*     */       }
/*     */     } 
/* 937 */     return this;
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
/*     */   public HashCodeBuilder appendSuper(int superHashCode) {
/* 951 */     this.iTotal = this.iTotal * this.iConstant + superHashCode;
/* 952 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int toHashCode() {
/* 963 */     return this.iTotal;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\builder\HashCodeBuilder.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */