/*      */ package org.apache.commons.lang;
/*      */ 
/*      */ import java.lang.reflect.Array;
/*      */ import java.util.HashMap;
/*      */ import java.util.Map;
/*      */ import org.apache.commons.lang.builder.EqualsBuilder;
/*      */ import org.apache.commons.lang.builder.HashCodeBuilder;
/*      */ import org.apache.commons.lang.builder.ToStringBuilder;
/*      */ import org.apache.commons.lang.builder.ToStringStyle;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class ArrayUtils
/*      */ {
/*   55 */   public static final Object[] EMPTY_OBJECT_ARRAY = new Object[0];
/*      */ 
/*      */ 
/*      */   
/*   59 */   public static final Class[] EMPTY_CLASS_ARRAY = new Class[0];
/*      */ 
/*      */ 
/*      */   
/*   63 */   public static final String[] EMPTY_STRING_ARRAY = new String[0];
/*      */ 
/*      */ 
/*      */   
/*   67 */   public static final long[] EMPTY_LONG_ARRAY = new long[0];
/*      */ 
/*      */ 
/*      */   
/*   71 */   public static final Long[] EMPTY_LONG_OBJECT_ARRAY = new Long[0];
/*      */ 
/*      */ 
/*      */   
/*   75 */   public static final int[] EMPTY_INT_ARRAY = new int[0];
/*      */ 
/*      */ 
/*      */   
/*   79 */   public static final Integer[] EMPTY_INTEGER_OBJECT_ARRAY = new Integer[0];
/*      */ 
/*      */ 
/*      */   
/*   83 */   public static final short[] EMPTY_SHORT_ARRAY = new short[0];
/*      */ 
/*      */ 
/*      */   
/*   87 */   public static final Short[] EMPTY_SHORT_OBJECT_ARRAY = new Short[0];
/*      */ 
/*      */ 
/*      */   
/*   91 */   public static final byte[] EMPTY_BYTE_ARRAY = new byte[0];
/*      */ 
/*      */ 
/*      */   
/*   95 */   public static final Byte[] EMPTY_BYTE_OBJECT_ARRAY = new Byte[0];
/*      */ 
/*      */ 
/*      */   
/*   99 */   public static final double[] EMPTY_DOUBLE_ARRAY = new double[0];
/*      */ 
/*      */ 
/*      */   
/*  103 */   public static final Double[] EMPTY_DOUBLE_OBJECT_ARRAY = new Double[0];
/*      */ 
/*      */ 
/*      */   
/*  107 */   public static final float[] EMPTY_FLOAT_ARRAY = new float[0];
/*      */ 
/*      */ 
/*      */   
/*  111 */   public static final Float[] EMPTY_FLOAT_OBJECT_ARRAY = new Float[0];
/*      */ 
/*      */ 
/*      */   
/*  115 */   public static final boolean[] EMPTY_BOOLEAN_ARRAY = new boolean[0];
/*      */ 
/*      */ 
/*      */   
/*  119 */   public static final Boolean[] EMPTY_BOOLEAN_OBJECT_ARRAY = new Boolean[0];
/*      */ 
/*      */ 
/*      */   
/*  123 */   public static final char[] EMPTY_CHAR_ARRAY = new char[0];
/*      */ 
/*      */ 
/*      */   
/*  127 */   public static final Character[] EMPTY_CHARACTER_OBJECT_ARRAY = new Character[0];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static final int INDEX_NOT_FOUND = -1;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String toString(Object array) {
/*  161 */     return toString(array, "{}");
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
/*      */   public static String toString(Object array, String stringIfNull) {
/*  177 */     if (array == null) {
/*  178 */       return stringIfNull;
/*      */     }
/*  180 */     return (new ToStringBuilder(array, ToStringStyle.SIMPLE_STYLE)).append(array).toString();
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
/*      */   public static int hashCode(Object array) {
/*  192 */     return (new HashCodeBuilder()).append(array).toHashCode();
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
/*      */   public static boolean isEquals(Object array1, Object array2) {
/*  206 */     return (new EqualsBuilder()).append(array1, array2).isEquals();
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
/*      */   public static Map toMap(Object[] array) {
/*  237 */     if (array == null) {
/*  238 */       return null;
/*      */     }
/*  240 */     Map map = new HashMap((int)(array.length * 1.5D));
/*  241 */     for (int i = 0; i < array.length; i++) {
/*  242 */       Object object = array[i];
/*  243 */       if (object instanceof Map.Entry) {
/*  244 */         Map.Entry entry = (Map.Entry)object;
/*  245 */         map.put(entry.getKey(), entry.getValue());
/*  246 */       } else if (object instanceof Object[]) {
/*  247 */         Object[] entry = (Object[])object;
/*  248 */         if (entry.length < 2) {
/*  249 */           throw new IllegalArgumentException("Array element " + i + ", '" + object + "', has a length less than 2");
/*      */         }
/*      */ 
/*      */         
/*  253 */         map.put(entry[0], entry[1]);
/*      */       } else {
/*  255 */         throw new IllegalArgumentException("Array element " + i + ", '" + object + "', is neither of type Map.Entry nor an Array");
/*      */       } 
/*      */     } 
/*      */ 
/*      */     
/*  260 */     return map;
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
/*      */   public static Object[] clone(Object[] array) {
/*  278 */     if (array == null) {
/*  279 */       return null;
/*      */     }
/*  281 */     return (Object[])array.clone();
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
/*      */   public static long[] clone(long[] array) {
/*  294 */     if (array == null) {
/*  295 */       return null;
/*      */     }
/*  297 */     return (long[])array.clone();
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
/*      */   public static int[] clone(int[] array) {
/*  310 */     if (array == null) {
/*  311 */       return null;
/*      */     }
/*  313 */     return (int[])array.clone();
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
/*      */   public static short[] clone(short[] array) {
/*  326 */     if (array == null) {
/*  327 */       return null;
/*      */     }
/*  329 */     return (short[])array.clone();
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
/*      */   public static char[] clone(char[] array) {
/*  342 */     if (array == null) {
/*  343 */       return null;
/*      */     }
/*  345 */     return (char[])array.clone();
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
/*      */   public static byte[] clone(byte[] array) {
/*  358 */     if (array == null) {
/*  359 */       return null;
/*      */     }
/*  361 */     return (byte[])array.clone();
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
/*      */   public static double[] clone(double[] array) {
/*  374 */     if (array == null) {
/*  375 */       return null;
/*      */     }
/*  377 */     return (double[])array.clone();
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
/*      */   public static float[] clone(float[] array) {
/*  390 */     if (array == null) {
/*  391 */       return null;
/*      */     }
/*  393 */     return (float[])array.clone();
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
/*      */   public static boolean[] clone(boolean[] array) {
/*  406 */     if (array == null) {
/*  407 */       return null;
/*      */     }
/*  409 */     return (boolean[])array.clone();
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
/*      */ 
/*      */   
/*      */   public static Object[] subarray(Object[] array, int startIndexInclusive, int endIndexExclusive) {
/*  442 */     if (array == null) {
/*  443 */       return null;
/*      */     }
/*  445 */     if (startIndexInclusive < 0) {
/*  446 */       startIndexInclusive = 0;
/*      */     }
/*  448 */     if (endIndexExclusive > array.length) {
/*  449 */       endIndexExclusive = array.length;
/*      */     }
/*  451 */     int newSize = endIndexExclusive - startIndexInclusive;
/*  452 */     Class type = array.getClass().getComponentType();
/*  453 */     if (newSize <= 0) {
/*  454 */       return (Object[])Array.newInstance(type, 0);
/*      */     }
/*  456 */     Object[] subarray = (Object[])Array.newInstance(type, newSize);
/*  457 */     System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
/*  458 */     return subarray;
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
/*      */   public static long[] subarray(long[] array, int startIndexInclusive, int endIndexExclusive) {
/*  481 */     if (array == null) {
/*  482 */       return null;
/*      */     }
/*  484 */     if (startIndexInclusive < 0) {
/*  485 */       startIndexInclusive = 0;
/*      */     }
/*  487 */     if (endIndexExclusive > array.length) {
/*  488 */       endIndexExclusive = array.length;
/*      */     }
/*  490 */     int newSize = endIndexExclusive - startIndexInclusive;
/*  491 */     if (newSize <= 0) {
/*  492 */       return EMPTY_LONG_ARRAY;
/*      */     }
/*      */     
/*  495 */     long[] subarray = new long[newSize];
/*  496 */     System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
/*  497 */     return subarray;
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
/*      */   public static int[] subarray(int[] array, int startIndexInclusive, int endIndexExclusive) {
/*  520 */     if (array == null) {
/*  521 */       return null;
/*      */     }
/*  523 */     if (startIndexInclusive < 0) {
/*  524 */       startIndexInclusive = 0;
/*      */     }
/*  526 */     if (endIndexExclusive > array.length) {
/*  527 */       endIndexExclusive = array.length;
/*      */     }
/*  529 */     int newSize = endIndexExclusive - startIndexInclusive;
/*  530 */     if (newSize <= 0) {
/*  531 */       return EMPTY_INT_ARRAY;
/*      */     }
/*      */     
/*  534 */     int[] subarray = new int[newSize];
/*  535 */     System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
/*  536 */     return subarray;
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
/*      */   public static short[] subarray(short[] array, int startIndexInclusive, int endIndexExclusive) {
/*  559 */     if (array == null) {
/*  560 */       return null;
/*      */     }
/*  562 */     if (startIndexInclusive < 0) {
/*  563 */       startIndexInclusive = 0;
/*      */     }
/*  565 */     if (endIndexExclusive > array.length) {
/*  566 */       endIndexExclusive = array.length;
/*      */     }
/*  568 */     int newSize = endIndexExclusive - startIndexInclusive;
/*  569 */     if (newSize <= 0) {
/*  570 */       return EMPTY_SHORT_ARRAY;
/*      */     }
/*      */     
/*  573 */     short[] subarray = new short[newSize];
/*  574 */     System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
/*  575 */     return subarray;
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
/*      */   public static char[] subarray(char[] array, int startIndexInclusive, int endIndexExclusive) {
/*  598 */     if (array == null) {
/*  599 */       return null;
/*      */     }
/*  601 */     if (startIndexInclusive < 0) {
/*  602 */       startIndexInclusive = 0;
/*      */     }
/*  604 */     if (endIndexExclusive > array.length) {
/*  605 */       endIndexExclusive = array.length;
/*      */     }
/*  607 */     int newSize = endIndexExclusive - startIndexInclusive;
/*  608 */     if (newSize <= 0) {
/*  609 */       return EMPTY_CHAR_ARRAY;
/*      */     }
/*      */     
/*  612 */     char[] subarray = new char[newSize];
/*  613 */     System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
/*  614 */     return subarray;
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
/*      */   public static byte[] subarray(byte[] array, int startIndexInclusive, int endIndexExclusive) {
/*  637 */     if (array == null) {
/*  638 */       return null;
/*      */     }
/*  640 */     if (startIndexInclusive < 0) {
/*  641 */       startIndexInclusive = 0;
/*      */     }
/*  643 */     if (endIndexExclusive > array.length) {
/*  644 */       endIndexExclusive = array.length;
/*      */     }
/*  646 */     int newSize = endIndexExclusive - startIndexInclusive;
/*  647 */     if (newSize <= 0) {
/*  648 */       return EMPTY_BYTE_ARRAY;
/*      */     }
/*      */     
/*  651 */     byte[] subarray = new byte[newSize];
/*  652 */     System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
/*  653 */     return subarray;
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
/*      */   public static double[] subarray(double[] array, int startIndexInclusive, int endIndexExclusive) {
/*  676 */     if (array == null) {
/*  677 */       return null;
/*      */     }
/*  679 */     if (startIndexInclusive < 0) {
/*  680 */       startIndexInclusive = 0;
/*      */     }
/*  682 */     if (endIndexExclusive > array.length) {
/*  683 */       endIndexExclusive = array.length;
/*      */     }
/*  685 */     int newSize = endIndexExclusive - startIndexInclusive;
/*  686 */     if (newSize <= 0) {
/*  687 */       return EMPTY_DOUBLE_ARRAY;
/*      */     }
/*      */     
/*  690 */     double[] subarray = new double[newSize];
/*  691 */     System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
/*  692 */     return subarray;
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
/*      */   public static float[] subarray(float[] array, int startIndexInclusive, int endIndexExclusive) {
/*  715 */     if (array == null) {
/*  716 */       return null;
/*      */     }
/*  718 */     if (startIndexInclusive < 0) {
/*  719 */       startIndexInclusive = 0;
/*      */     }
/*  721 */     if (endIndexExclusive > array.length) {
/*  722 */       endIndexExclusive = array.length;
/*      */     }
/*  724 */     int newSize = endIndexExclusive - startIndexInclusive;
/*  725 */     if (newSize <= 0) {
/*  726 */       return EMPTY_FLOAT_ARRAY;
/*      */     }
/*      */     
/*  729 */     float[] subarray = new float[newSize];
/*  730 */     System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
/*  731 */     return subarray;
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
/*      */   public static boolean[] subarray(boolean[] array, int startIndexInclusive, int endIndexExclusive) {
/*  754 */     if (array == null) {
/*  755 */       return null;
/*      */     }
/*  757 */     if (startIndexInclusive < 0) {
/*  758 */       startIndexInclusive = 0;
/*      */     }
/*  760 */     if (endIndexExclusive > array.length) {
/*  761 */       endIndexExclusive = array.length;
/*      */     }
/*  763 */     int newSize = endIndexExclusive - startIndexInclusive;
/*  764 */     if (newSize <= 0) {
/*  765 */       return EMPTY_BOOLEAN_ARRAY;
/*      */     }
/*      */     
/*  768 */     boolean[] subarray = new boolean[newSize];
/*  769 */     System.arraycopy(array, startIndexInclusive, subarray, 0, newSize);
/*  770 */     return subarray;
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
/*      */   public static boolean isSameLength(Object[] array1, Object[] array2) {
/*  787 */     if ((array1 == null && array2 != null && array2.length > 0) || (array2 == null && array1 != null && array1.length > 0) || (array1 != null && array2 != null && array1.length != array2.length))
/*      */     {
/*      */       
/*  790 */       return false;
/*      */     }
/*  792 */     return true;
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
/*      */   public static boolean isSameLength(long[] array1, long[] array2) {
/*  805 */     if ((array1 == null && array2 != null && array2.length > 0) || (array2 == null && array1 != null && array1.length > 0) || (array1 != null && array2 != null && array1.length != array2.length))
/*      */     {
/*      */       
/*  808 */       return false;
/*      */     }
/*  810 */     return true;
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
/*      */   public static boolean isSameLength(int[] array1, int[] array2) {
/*  823 */     if ((array1 == null && array2 != null && array2.length > 0) || (array2 == null && array1 != null && array1.length > 0) || (array1 != null && array2 != null && array1.length != array2.length))
/*      */     {
/*      */       
/*  826 */       return false;
/*      */     }
/*  828 */     return true;
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
/*      */   public static boolean isSameLength(short[] array1, short[] array2) {
/*  841 */     if ((array1 == null && array2 != null && array2.length > 0) || (array2 == null && array1 != null && array1.length > 0) || (array1 != null && array2 != null && array1.length != array2.length))
/*      */     {
/*      */       
/*  844 */       return false;
/*      */     }
/*  846 */     return true;
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
/*      */   public static boolean isSameLength(char[] array1, char[] array2) {
/*  859 */     if ((array1 == null && array2 != null && array2.length > 0) || (array2 == null && array1 != null && array1.length > 0) || (array1 != null && array2 != null && array1.length != array2.length))
/*      */     {
/*      */       
/*  862 */       return false;
/*      */     }
/*  864 */     return true;
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
/*      */   public static boolean isSameLength(byte[] array1, byte[] array2) {
/*  877 */     if ((array1 == null && array2 != null && array2.length > 0) || (array2 == null && array1 != null && array1.length > 0) || (array1 != null && array2 != null && array1.length != array2.length))
/*      */     {
/*      */       
/*  880 */       return false;
/*      */     }
/*  882 */     return true;
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
/*      */   public static boolean isSameLength(double[] array1, double[] array2) {
/*  895 */     if ((array1 == null && array2 != null && array2.length > 0) || (array2 == null && array1 != null && array1.length > 0) || (array1 != null && array2 != null && array1.length != array2.length))
/*      */     {
/*      */       
/*  898 */       return false;
/*      */     }
/*  900 */     return true;
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
/*      */   public static boolean isSameLength(float[] array1, float[] array2) {
/*  913 */     if ((array1 == null && array2 != null && array2.length > 0) || (array2 == null && array1 != null && array1.length > 0) || (array1 != null && array2 != null && array1.length != array2.length))
/*      */     {
/*      */       
/*  916 */       return false;
/*      */     }
/*  918 */     return true;
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
/*      */   public static boolean isSameLength(boolean[] array1, boolean[] array2) {
/*  931 */     if ((array1 == null && array2 != null && array2.length > 0) || (array2 == null && array1 != null && array1.length > 0) || (array1 != null && array2 != null && array1.length != array2.length))
/*      */     {
/*      */       
/*  934 */       return false;
/*      */     }
/*  936 */     return true;
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
/*      */   public static int getLength(Object array) {
/*  961 */     if (array == null) {
/*  962 */       return 0;
/*      */     }
/*  964 */     return Array.getLength(array);
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
/*      */   public static boolean isSameType(Object array1, Object array2) {
/*  977 */     if (array1 == null || array2 == null) {
/*  978 */       throw new IllegalArgumentException("The Array must not be null");
/*      */     }
/*  980 */     return array1.getClass().getName().equals(array2.getClass().getName());
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
/*      */   public static void reverse(Object[] array) {
/*  995 */     if (array == null) {
/*      */       return;
/*      */     }
/*  998 */     int i = 0;
/*  999 */     int j = array.length - 1;
/*      */     
/* 1001 */     while (j > i) {
/* 1002 */       Object tmp = array[j];
/* 1003 */       array[j] = array[i];
/* 1004 */       array[i] = tmp;
/* 1005 */       j--;
/* 1006 */       i++;
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
/*      */   public static void reverse(long[] array) {
/* 1018 */     if (array == null) {
/*      */       return;
/*      */     }
/* 1021 */     int i = 0;
/* 1022 */     int j = array.length - 1;
/*      */     
/* 1024 */     while (j > i) {
/* 1025 */       long tmp = array[j];
/* 1026 */       array[j] = array[i];
/* 1027 */       array[i] = tmp;
/* 1028 */       j--;
/* 1029 */       i++;
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
/*      */   public static void reverse(int[] array) {
/* 1041 */     if (array == null) {
/*      */       return;
/*      */     }
/* 1044 */     int i = 0;
/* 1045 */     int j = array.length - 1;
/*      */     
/* 1047 */     while (j > i) {
/* 1048 */       int tmp = array[j];
/* 1049 */       array[j] = array[i];
/* 1050 */       array[i] = tmp;
/* 1051 */       j--;
/* 1052 */       i++;
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
/*      */   public static void reverse(short[] array) {
/* 1064 */     if (array == null) {
/*      */       return;
/*      */     }
/* 1067 */     int i = 0;
/* 1068 */     int j = array.length - 1;
/*      */     
/* 1070 */     while (j > i) {
/* 1071 */       short tmp = array[j];
/* 1072 */       array[j] = array[i];
/* 1073 */       array[i] = tmp;
/* 1074 */       j--;
/* 1075 */       i++;
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
/*      */   public static void reverse(char[] array) {
/* 1087 */     if (array == null) {
/*      */       return;
/*      */     }
/* 1090 */     int i = 0;
/* 1091 */     int j = array.length - 1;
/*      */     
/* 1093 */     while (j > i) {
/* 1094 */       char tmp = array[j];
/* 1095 */       array[j] = array[i];
/* 1096 */       array[i] = tmp;
/* 1097 */       j--;
/* 1098 */       i++;
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
/*      */   public static void reverse(byte[] array) {
/* 1110 */     if (array == null) {
/*      */       return;
/*      */     }
/* 1113 */     int i = 0;
/* 1114 */     int j = array.length - 1;
/*      */     
/* 1116 */     while (j > i) {
/* 1117 */       byte tmp = array[j];
/* 1118 */       array[j] = array[i];
/* 1119 */       array[i] = tmp;
/* 1120 */       j--;
/* 1121 */       i++;
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
/*      */   public static void reverse(double[] array) {
/* 1133 */     if (array == null) {
/*      */       return;
/*      */     }
/* 1136 */     int i = 0;
/* 1137 */     int j = array.length - 1;
/*      */     
/* 1139 */     while (j > i) {
/* 1140 */       double tmp = array[j];
/* 1141 */       array[j] = array[i];
/* 1142 */       array[i] = tmp;
/* 1143 */       j--;
/* 1144 */       i++;
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
/*      */   public static void reverse(float[] array) {
/* 1156 */     if (array == null) {
/*      */       return;
/*      */     }
/* 1159 */     int i = 0;
/* 1160 */     int j = array.length - 1;
/*      */     
/* 1162 */     while (j > i) {
/* 1163 */       float tmp = array[j];
/* 1164 */       array[j] = array[i];
/* 1165 */       array[i] = tmp;
/* 1166 */       j--;
/* 1167 */       i++;
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
/*      */   public static void reverse(boolean[] array) {
/* 1179 */     if (array == null) {
/*      */       return;
/*      */     }
/* 1182 */     int i = 0;
/* 1183 */     int j = array.length - 1;
/*      */     
/* 1185 */     while (j > i) {
/* 1186 */       boolean tmp = array[j];
/* 1187 */       array[j] = array[i];
/* 1188 */       array[i] = tmp;
/* 1189 */       j--;
/* 1190 */       i++;
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
/*      */ 
/*      */   
/*      */   public static int indexOf(Object[] array, Object objectToFind) {
/* 1210 */     return indexOf(array, objectToFind, 0);
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
/*      */   public static int indexOf(Object[] array, Object objectToFind, int startIndex) {
/* 1228 */     if (array == null) {
/* 1229 */       return -1;
/*      */     }
/* 1231 */     if (startIndex < 0) {
/* 1232 */       startIndex = 0;
/*      */     }
/* 1234 */     if (objectToFind == null) {
/* 1235 */       for (int i = startIndex; i < array.length; i++) {
/* 1236 */         if (array[i] == null) {
/* 1237 */           return i;
/*      */         }
/*      */       } 
/*      */     } else {
/* 1241 */       for (int i = startIndex; i < array.length; i++) {
/* 1242 */         if (objectToFind.equals(array[i])) {
/* 1243 */           return i;
/*      */         }
/*      */       } 
/*      */     } 
/* 1247 */     return -1;
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
/*      */   public static int lastIndexOf(Object[] array, Object objectToFind) {
/* 1261 */     return lastIndexOf(array, objectToFind, 2147483647);
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
/*      */   public static int lastIndexOf(Object[] array, Object objectToFind, int startIndex) {
/* 1279 */     if (array == null) {
/* 1280 */       return -1;
/*      */     }
/* 1282 */     if (startIndex < 0)
/* 1283 */       return -1; 
/* 1284 */     if (startIndex >= array.length) {
/* 1285 */       startIndex = array.length - 1;
/*      */     }
/* 1287 */     if (objectToFind == null) {
/* 1288 */       for (int i = startIndex; i >= 0; i--) {
/* 1289 */         if (array[i] == null) {
/* 1290 */           return i;
/*      */         }
/*      */       } 
/*      */     } else {
/* 1294 */       for (int i = startIndex; i >= 0; i--) {
/* 1295 */         if (objectToFind.equals(array[i])) {
/* 1296 */           return i;
/*      */         }
/*      */       } 
/*      */     } 
/* 1300 */     return -1;
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
/*      */   public static boolean contains(Object[] array, Object objectToFind) {
/* 1313 */     return (indexOf(array, objectToFind) != -1);
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
/*      */   public static int indexOf(long[] array, long valueToFind) {
/* 1329 */     return indexOf(array, valueToFind, 0);
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
/*      */   public static int indexOf(long[] array, long valueToFind, int startIndex) {
/* 1347 */     if (array == null) {
/* 1348 */       return -1;
/*      */     }
/* 1350 */     if (startIndex < 0) {
/* 1351 */       startIndex = 0;
/*      */     }
/* 1353 */     for (int i = startIndex; i < array.length; i++) {
/* 1354 */       if (valueToFind == array[i]) {
/* 1355 */         return i;
/*      */       }
/*      */     } 
/* 1358 */     return -1;
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
/*      */   public static int lastIndexOf(long[] array, long valueToFind) {
/* 1372 */     return lastIndexOf(array, valueToFind, 2147483647);
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
/*      */   public static int lastIndexOf(long[] array, long valueToFind, int startIndex) {
/* 1390 */     if (array == null) {
/* 1391 */       return -1;
/*      */     }
/* 1393 */     if (startIndex < 0)
/* 1394 */       return -1; 
/* 1395 */     if (startIndex >= array.length) {
/* 1396 */       startIndex = array.length - 1;
/*      */     }
/* 1398 */     for (int i = startIndex; i >= 0; i--) {
/* 1399 */       if (valueToFind == array[i]) {
/* 1400 */         return i;
/*      */       }
/*      */     } 
/* 1403 */     return -1;
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
/*      */   public static boolean contains(long[] array, long valueToFind) {
/* 1416 */     return (indexOf(array, valueToFind) != -1);
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
/*      */   public static int indexOf(int[] array, int valueToFind) {
/* 1432 */     return indexOf(array, valueToFind, 0);
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
/*      */   public static int indexOf(int[] array, int valueToFind, int startIndex) {
/* 1450 */     if (array == null) {
/* 1451 */       return -1;
/*      */     }
/* 1453 */     if (startIndex < 0) {
/* 1454 */       startIndex = 0;
/*      */     }
/* 1456 */     for (int i = startIndex; i < array.length; i++) {
/* 1457 */       if (valueToFind == array[i]) {
/* 1458 */         return i;
/*      */       }
/*      */     } 
/* 1461 */     return -1;
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
/*      */   public static int lastIndexOf(int[] array, int valueToFind) {
/* 1475 */     return lastIndexOf(array, valueToFind, 2147483647);
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
/*      */   public static int lastIndexOf(int[] array, int valueToFind, int startIndex) {
/* 1493 */     if (array == null) {
/* 1494 */       return -1;
/*      */     }
/* 1496 */     if (startIndex < 0)
/* 1497 */       return -1; 
/* 1498 */     if (startIndex >= array.length) {
/* 1499 */       startIndex = array.length - 1;
/*      */     }
/* 1501 */     for (int i = startIndex; i >= 0; i--) {
/* 1502 */       if (valueToFind == array[i]) {
/* 1503 */         return i;
/*      */       }
/*      */     } 
/* 1506 */     return -1;
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
/*      */   public static boolean contains(int[] array, int valueToFind) {
/* 1519 */     return (indexOf(array, valueToFind) != -1);
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
/*      */   public static int indexOf(short[] array, short valueToFind) {
/* 1535 */     return indexOf(array, valueToFind, 0);
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
/*      */   public static int indexOf(short[] array, short valueToFind, int startIndex) {
/* 1553 */     if (array == null) {
/* 1554 */       return -1;
/*      */     }
/* 1556 */     if (startIndex < 0) {
/* 1557 */       startIndex = 0;
/*      */     }
/* 1559 */     for (int i = startIndex; i < array.length; i++) {
/* 1560 */       if (valueToFind == array[i]) {
/* 1561 */         return i;
/*      */       }
/*      */     } 
/* 1564 */     return -1;
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
/*      */   public static int lastIndexOf(short[] array, short valueToFind) {
/* 1578 */     return lastIndexOf(array, valueToFind, 2147483647);
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
/*      */   public static int lastIndexOf(short[] array, short valueToFind, int startIndex) {
/* 1596 */     if (array == null) {
/* 1597 */       return -1;
/*      */     }
/* 1599 */     if (startIndex < 0)
/* 1600 */       return -1; 
/* 1601 */     if (startIndex >= array.length) {
/* 1602 */       startIndex = array.length - 1;
/*      */     }
/* 1604 */     for (int i = startIndex; i >= 0; i--) {
/* 1605 */       if (valueToFind == array[i]) {
/* 1606 */         return i;
/*      */       }
/*      */     } 
/* 1609 */     return -1;
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
/*      */   public static boolean contains(short[] array, short valueToFind) {
/* 1622 */     return (indexOf(array, valueToFind) != -1);
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
/*      */   public static int indexOf(char[] array, char valueToFind) {
/* 1639 */     return indexOf(array, valueToFind, 0);
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
/*      */   public static int indexOf(char[] array, char valueToFind, int startIndex) {
/* 1658 */     if (array == null) {
/* 1659 */       return -1;
/*      */     }
/* 1661 */     if (startIndex < 0) {
/* 1662 */       startIndex = 0;
/*      */     }
/* 1664 */     for (int i = startIndex; i < array.length; i++) {
/* 1665 */       if (valueToFind == array[i]) {
/* 1666 */         return i;
/*      */       }
/*      */     } 
/* 1669 */     return -1;
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
/*      */   public static int lastIndexOf(char[] array, char valueToFind) {
/* 1684 */     return lastIndexOf(array, valueToFind, 2147483647);
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
/*      */   public static int lastIndexOf(char[] array, char valueToFind, int startIndex) {
/* 1703 */     if (array == null) {
/* 1704 */       return -1;
/*      */     }
/* 1706 */     if (startIndex < 0)
/* 1707 */       return -1; 
/* 1708 */     if (startIndex >= array.length) {
/* 1709 */       startIndex = array.length - 1;
/*      */     }
/* 1711 */     for (int i = startIndex; i >= 0; i--) {
/* 1712 */       if (valueToFind == array[i]) {
/* 1713 */         return i;
/*      */       }
/*      */     } 
/* 1716 */     return -1;
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
/*      */   public static boolean contains(char[] array, char valueToFind) {
/* 1730 */     return (indexOf(array, valueToFind) != -1);
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
/*      */   public static int indexOf(byte[] array, byte valueToFind) {
/* 1746 */     return indexOf(array, valueToFind, 0);
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
/*      */   public static int indexOf(byte[] array, byte valueToFind, int startIndex) {
/* 1764 */     if (array == null) {
/* 1765 */       return -1;
/*      */     }
/* 1767 */     if (startIndex < 0) {
/* 1768 */       startIndex = 0;
/*      */     }
/* 1770 */     for (int i = startIndex; i < array.length; i++) {
/* 1771 */       if (valueToFind == array[i]) {
/* 1772 */         return i;
/*      */       }
/*      */     } 
/* 1775 */     return -1;
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
/*      */   public static int lastIndexOf(byte[] array, byte valueToFind) {
/* 1789 */     return lastIndexOf(array, valueToFind, 2147483647);
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
/*      */   public static int lastIndexOf(byte[] array, byte valueToFind, int startIndex) {
/* 1807 */     if (array == null) {
/* 1808 */       return -1;
/*      */     }
/* 1810 */     if (startIndex < 0)
/* 1811 */       return -1; 
/* 1812 */     if (startIndex >= array.length) {
/* 1813 */       startIndex = array.length - 1;
/*      */     }
/* 1815 */     for (int i = startIndex; i >= 0; i--) {
/* 1816 */       if (valueToFind == array[i]) {
/* 1817 */         return i;
/*      */       }
/*      */     } 
/* 1820 */     return -1;
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
/*      */   public static boolean contains(byte[] array, byte valueToFind) {
/* 1833 */     return (indexOf(array, valueToFind) != -1);
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
/*      */   public static int indexOf(double[] array, double valueToFind) {
/* 1849 */     return indexOf(array, valueToFind, 0);
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
/*      */   public static int indexOf(double[] array, double valueToFind, double tolerance) {
/* 1866 */     return indexOf(array, valueToFind, 0, tolerance);
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
/*      */   public static int indexOf(double[] array, double valueToFind, int startIndex) {
/* 1884 */     if (isEmpty(array)) {
/* 1885 */       return -1;
/*      */     }
/* 1887 */     if (startIndex < 0) {
/* 1888 */       startIndex = 0;
/*      */     }
/* 1890 */     for (int i = startIndex; i < array.length; i++) {
/* 1891 */       if (valueToFind == array[i]) {
/* 1892 */         return i;
/*      */       }
/*      */     } 
/* 1895 */     return -1;
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
/*      */   public static int indexOf(double[] array, double valueToFind, int startIndex, double tolerance) {
/* 1916 */     if (isEmpty(array)) {
/* 1917 */       return -1;
/*      */     }
/* 1919 */     if (startIndex < 0) {
/* 1920 */       startIndex = 0;
/*      */     }
/* 1922 */     double min = valueToFind - tolerance;
/* 1923 */     double max = valueToFind + tolerance;
/* 1924 */     for (int i = startIndex; i < array.length; i++) {
/* 1925 */       if (array[i] >= min && array[i] <= max) {
/* 1926 */         return i;
/*      */       }
/*      */     } 
/* 1929 */     return -1;
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
/*      */   public static int lastIndexOf(double[] array, double valueToFind) {
/* 1943 */     return lastIndexOf(array, valueToFind, 2147483647);
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
/*      */   public static int lastIndexOf(double[] array, double valueToFind, double tolerance) {
/* 1960 */     return lastIndexOf(array, valueToFind, 2147483647, tolerance);
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
/*      */   public static int lastIndexOf(double[] array, double valueToFind, int startIndex) {
/* 1978 */     if (isEmpty(array)) {
/* 1979 */       return -1;
/*      */     }
/* 1981 */     if (startIndex < 0)
/* 1982 */       return -1; 
/* 1983 */     if (startIndex >= array.length) {
/* 1984 */       startIndex = array.length - 1;
/*      */     }
/* 1986 */     for (int i = startIndex; i >= 0; i--) {
/* 1987 */       if (valueToFind == array[i]) {
/* 1988 */         return i;
/*      */       }
/*      */     } 
/* 1991 */     return -1;
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
/*      */   public static int lastIndexOf(double[] array, double valueToFind, int startIndex, double tolerance) {
/* 2012 */     if (isEmpty(array)) {
/* 2013 */       return -1;
/*      */     }
/* 2015 */     if (startIndex < 0)
/* 2016 */       return -1; 
/* 2017 */     if (startIndex >= array.length) {
/* 2018 */       startIndex = array.length - 1;
/*      */     }
/* 2020 */     double min = valueToFind - tolerance;
/* 2021 */     double max = valueToFind + tolerance;
/* 2022 */     for (int i = startIndex; i >= 0; i--) {
/* 2023 */       if (array[i] >= min && array[i] <= max) {
/* 2024 */         return i;
/*      */       }
/*      */     } 
/* 2027 */     return -1;
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
/*      */   public static boolean contains(double[] array, double valueToFind) {
/* 2040 */     return (indexOf(array, valueToFind) != -1);
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
/*      */   public static boolean contains(double[] array, double valueToFind, double tolerance) {
/* 2057 */     return (indexOf(array, valueToFind, 0, tolerance) != -1);
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
/*      */   public static int indexOf(float[] array, float valueToFind) {
/* 2073 */     return indexOf(array, valueToFind, 0);
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
/*      */   public static int indexOf(float[] array, float valueToFind, int startIndex) {
/* 2091 */     if (isEmpty(array)) {
/* 2092 */       return -1;
/*      */     }
/* 2094 */     if (startIndex < 0) {
/* 2095 */       startIndex = 0;
/*      */     }
/* 2097 */     for (int i = startIndex; i < array.length; i++) {
/* 2098 */       if (valueToFind == array[i]) {
/* 2099 */         return i;
/*      */       }
/*      */     } 
/* 2102 */     return -1;
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
/*      */   public static int lastIndexOf(float[] array, float valueToFind) {
/* 2116 */     return lastIndexOf(array, valueToFind, 2147483647);
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
/*      */   public static int lastIndexOf(float[] array, float valueToFind, int startIndex) {
/* 2134 */     if (isEmpty(array)) {
/* 2135 */       return -1;
/*      */     }
/* 2137 */     if (startIndex < 0)
/* 2138 */       return -1; 
/* 2139 */     if (startIndex >= array.length) {
/* 2140 */       startIndex = array.length - 1;
/*      */     }
/* 2142 */     for (int i = startIndex; i >= 0; i--) {
/* 2143 */       if (valueToFind == array[i]) {
/* 2144 */         return i;
/*      */       }
/*      */     } 
/* 2147 */     return -1;
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
/*      */   public static boolean contains(float[] array, float valueToFind) {
/* 2160 */     return (indexOf(array, valueToFind) != -1);
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
/*      */   public static int indexOf(boolean[] array, boolean valueToFind) {
/* 2176 */     return indexOf(array, valueToFind, 0);
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
/*      */   public static int indexOf(boolean[] array, boolean valueToFind, int startIndex) {
/* 2195 */     if (isEmpty(array)) {
/* 2196 */       return -1;
/*      */     }
/* 2198 */     if (startIndex < 0) {
/* 2199 */       startIndex = 0;
/*      */     }
/* 2201 */     for (int i = startIndex; i < array.length; i++) {
/* 2202 */       if (valueToFind == array[i]) {
/* 2203 */         return i;
/*      */       }
/*      */     } 
/* 2206 */     return -1;
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
/*      */   public static int lastIndexOf(boolean[] array, boolean valueToFind) {
/* 2221 */     return lastIndexOf(array, valueToFind, 2147483647);
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
/*      */   public static int lastIndexOf(boolean[] array, boolean valueToFind, int startIndex) {
/* 2239 */     if (isEmpty(array)) {
/* 2240 */       return -1;
/*      */     }
/* 2242 */     if (startIndex < 0)
/* 2243 */       return -1; 
/* 2244 */     if (startIndex >= array.length) {
/* 2245 */       startIndex = array.length - 1;
/*      */     }
/* 2247 */     for (int i = startIndex; i >= 0; i--) {
/* 2248 */       if (valueToFind == array[i]) {
/* 2249 */         return i;
/*      */       }
/*      */     } 
/* 2252 */     return -1;
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
/*      */   public static boolean contains(boolean[] array, boolean valueToFind) {
/* 2265 */     return (indexOf(array, valueToFind) != -1);
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
/*      */   public static char[] toPrimitive(Character[] array) {
/* 2283 */     if (array == null)
/* 2284 */       return null; 
/* 2285 */     if (array.length == 0) {
/* 2286 */       return EMPTY_CHAR_ARRAY;
/*      */     }
/* 2288 */     char[] result = new char[array.length];
/* 2289 */     for (int i = 0; i < array.length; i++) {
/* 2290 */       result[i] = array[i].charValue();
/*      */     }
/* 2292 */     return result;
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
/*      */   public static char[] toPrimitive(Character[] array, char valueForNull) {
/* 2305 */     if (array == null)
/* 2306 */       return null; 
/* 2307 */     if (array.length == 0) {
/* 2308 */       return EMPTY_CHAR_ARRAY;
/*      */     }
/* 2310 */     char[] result = new char[array.length];
/* 2311 */     for (int i = 0; i < array.length; i++) {
/* 2312 */       Character b = array[i];
/* 2313 */       result[i] = (b == null) ? valueForNull : b.charValue();
/*      */     } 
/* 2315 */     return result;
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
/*      */   public static Character[] toObject(char[] array) {
/* 2327 */     if (array == null)
/* 2328 */       return null; 
/* 2329 */     if (array.length == 0) {
/* 2330 */       return EMPTY_CHARACTER_OBJECT_ARRAY;
/*      */     }
/* 2332 */     Character[] result = new Character[array.length];
/* 2333 */     for (int i = 0; i < array.length; i++) {
/* 2334 */       result[i] = new Character(array[i]);
/*      */     }
/* 2336 */     return result;
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
/*      */   public static long[] toPrimitive(Long[] array) {
/* 2351 */     if (array == null)
/* 2352 */       return null; 
/* 2353 */     if (array.length == 0) {
/* 2354 */       return EMPTY_LONG_ARRAY;
/*      */     }
/* 2356 */     long[] result = new long[array.length];
/* 2357 */     for (int i = 0; i < array.length; i++) {
/* 2358 */       result[i] = array[i].longValue();
/*      */     }
/* 2360 */     return result;
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
/*      */   public static long[] toPrimitive(Long[] array, long valueForNull) {
/* 2373 */     if (array == null)
/* 2374 */       return null; 
/* 2375 */     if (array.length == 0) {
/* 2376 */       return EMPTY_LONG_ARRAY;
/*      */     }
/* 2378 */     long[] result = new long[array.length];
/* 2379 */     for (int i = 0; i < array.length; i++) {
/* 2380 */       Long b = array[i];
/* 2381 */       result[i] = (b == null) ? valueForNull : b.longValue();
/*      */     } 
/* 2383 */     return result;
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
/*      */   public static Long[] toObject(long[] array) {
/* 2395 */     if (array == null)
/* 2396 */       return null; 
/* 2397 */     if (array.length == 0) {
/* 2398 */       return EMPTY_LONG_OBJECT_ARRAY;
/*      */     }
/* 2400 */     Long[] result = new Long[array.length];
/* 2401 */     for (int i = 0; i < array.length; i++) {
/* 2402 */       result[i] = new Long(array[i]);
/*      */     }
/* 2404 */     return result;
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
/*      */   public static int[] toPrimitive(Integer[] array) {
/* 2419 */     if (array == null)
/* 2420 */       return null; 
/* 2421 */     if (array.length == 0) {
/* 2422 */       return EMPTY_INT_ARRAY;
/*      */     }
/* 2424 */     int[] result = new int[array.length];
/* 2425 */     for (int i = 0; i < array.length; i++) {
/* 2426 */       result[i] = array[i].intValue();
/*      */     }
/* 2428 */     return result;
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
/*      */   public static int[] toPrimitive(Integer[] array, int valueForNull) {
/* 2441 */     if (array == null)
/* 2442 */       return null; 
/* 2443 */     if (array.length == 0) {
/* 2444 */       return EMPTY_INT_ARRAY;
/*      */     }
/* 2446 */     int[] result = new int[array.length];
/* 2447 */     for (int i = 0; i < array.length; i++) {
/* 2448 */       Integer b = array[i];
/* 2449 */       result[i] = (b == null) ? valueForNull : b.intValue();
/*      */     } 
/* 2451 */     return result;
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
/*      */   public static Integer[] toObject(int[] array) {
/* 2463 */     if (array == null)
/* 2464 */       return null; 
/* 2465 */     if (array.length == 0) {
/* 2466 */       return EMPTY_INTEGER_OBJECT_ARRAY;
/*      */     }
/* 2468 */     Integer[] result = new Integer[array.length];
/* 2469 */     for (int i = 0; i < array.length; i++) {
/* 2470 */       result[i] = new Integer(array[i]);
/*      */     }
/* 2472 */     return result;
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
/*      */   public static short[] toPrimitive(Short[] array) {
/* 2487 */     if (array == null)
/* 2488 */       return null; 
/* 2489 */     if (array.length == 0) {
/* 2490 */       return EMPTY_SHORT_ARRAY;
/*      */     }
/* 2492 */     short[] result = new short[array.length];
/* 2493 */     for (int i = 0; i < array.length; i++) {
/* 2494 */       result[i] = array[i].shortValue();
/*      */     }
/* 2496 */     return result;
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
/*      */   public static short[] toPrimitive(Short[] array, short valueForNull) {
/* 2509 */     if (array == null)
/* 2510 */       return null; 
/* 2511 */     if (array.length == 0) {
/* 2512 */       return EMPTY_SHORT_ARRAY;
/*      */     }
/* 2514 */     short[] result = new short[array.length];
/* 2515 */     for (int i = 0; i < array.length; i++) {
/* 2516 */       Short b = array[i];
/* 2517 */       result[i] = (b == null) ? valueForNull : b.shortValue();
/*      */     } 
/* 2519 */     return result;
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
/*      */   public static Short[] toObject(short[] array) {
/* 2531 */     if (array == null)
/* 2532 */       return null; 
/* 2533 */     if (array.length == 0) {
/* 2534 */       return EMPTY_SHORT_OBJECT_ARRAY;
/*      */     }
/* 2536 */     Short[] result = new Short[array.length];
/* 2537 */     for (int i = 0; i < array.length; i++) {
/* 2538 */       result[i] = new Short(array[i]);
/*      */     }
/* 2540 */     return result;
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
/*      */   public static byte[] toPrimitive(Byte[] array) {
/* 2555 */     if (array == null)
/* 2556 */       return null; 
/* 2557 */     if (array.length == 0) {
/* 2558 */       return EMPTY_BYTE_ARRAY;
/*      */     }
/* 2560 */     byte[] result = new byte[array.length];
/* 2561 */     for (int i = 0; i < array.length; i++) {
/* 2562 */       result[i] = array[i].byteValue();
/*      */     }
/* 2564 */     return result;
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
/*      */   public static byte[] toPrimitive(Byte[] array, byte valueForNull) {
/* 2577 */     if (array == null)
/* 2578 */       return null; 
/* 2579 */     if (array.length == 0) {
/* 2580 */       return EMPTY_BYTE_ARRAY;
/*      */     }
/* 2582 */     byte[] result = new byte[array.length];
/* 2583 */     for (int i = 0; i < array.length; i++) {
/* 2584 */       Byte b = array[i];
/* 2585 */       result[i] = (b == null) ? valueForNull : b.byteValue();
/*      */     } 
/* 2587 */     return result;
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
/*      */   public static Byte[] toObject(byte[] array) {
/* 2599 */     if (array == null)
/* 2600 */       return null; 
/* 2601 */     if (array.length == 0) {
/* 2602 */       return EMPTY_BYTE_OBJECT_ARRAY;
/*      */     }
/* 2604 */     Byte[] result = new Byte[array.length];
/* 2605 */     for (int i = 0; i < array.length; i++) {
/* 2606 */       result[i] = new Byte(array[i]);
/*      */     }
/* 2608 */     return result;
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
/*      */   public static double[] toPrimitive(Double[] array) {
/* 2623 */     if (array == null)
/* 2624 */       return null; 
/* 2625 */     if (array.length == 0) {
/* 2626 */       return EMPTY_DOUBLE_ARRAY;
/*      */     }
/* 2628 */     double[] result = new double[array.length];
/* 2629 */     for (int i = 0; i < array.length; i++) {
/* 2630 */       result[i] = array[i].doubleValue();
/*      */     }
/* 2632 */     return result;
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
/*      */   public static double[] toPrimitive(Double[] array, double valueForNull) {
/* 2645 */     if (array == null)
/* 2646 */       return null; 
/* 2647 */     if (array.length == 0) {
/* 2648 */       return EMPTY_DOUBLE_ARRAY;
/*      */     }
/* 2650 */     double[] result = new double[array.length];
/* 2651 */     for (int i = 0; i < array.length; i++) {
/* 2652 */       Double b = array[i];
/* 2653 */       result[i] = (b == null) ? valueForNull : b.doubleValue();
/*      */     } 
/* 2655 */     return result;
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
/*      */   public static Double[] toObject(double[] array) {
/* 2667 */     if (array == null)
/* 2668 */       return null; 
/* 2669 */     if (array.length == 0) {
/* 2670 */       return EMPTY_DOUBLE_OBJECT_ARRAY;
/*      */     }
/* 2672 */     Double[] result = new Double[array.length];
/* 2673 */     for (int i = 0; i < array.length; i++) {
/* 2674 */       result[i] = new Double(array[i]);
/*      */     }
/* 2676 */     return result;
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
/*      */   public static float[] toPrimitive(Float[] array) {
/* 2691 */     if (array == null)
/* 2692 */       return null; 
/* 2693 */     if (array.length == 0) {
/* 2694 */       return EMPTY_FLOAT_ARRAY;
/*      */     }
/* 2696 */     float[] result = new float[array.length];
/* 2697 */     for (int i = 0; i < array.length; i++) {
/* 2698 */       result[i] = array[i].floatValue();
/*      */     }
/* 2700 */     return result;
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
/*      */   public static float[] toPrimitive(Float[] array, float valueForNull) {
/* 2713 */     if (array == null)
/* 2714 */       return null; 
/* 2715 */     if (array.length == 0) {
/* 2716 */       return EMPTY_FLOAT_ARRAY;
/*      */     }
/* 2718 */     float[] result = new float[array.length];
/* 2719 */     for (int i = 0; i < array.length; i++) {
/* 2720 */       Float b = array[i];
/* 2721 */       result[i] = (b == null) ? valueForNull : b.floatValue();
/*      */     } 
/* 2723 */     return result;
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
/*      */   public static Float[] toObject(float[] array) {
/* 2735 */     if (array == null)
/* 2736 */       return null; 
/* 2737 */     if (array.length == 0) {
/* 2738 */       return EMPTY_FLOAT_OBJECT_ARRAY;
/*      */     }
/* 2740 */     Float[] result = new Float[array.length];
/* 2741 */     for (int i = 0; i < array.length; i++) {
/* 2742 */       result[i] = new Float(array[i]);
/*      */     }
/* 2744 */     return result;
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
/*      */   public static boolean[] toPrimitive(Boolean[] array) {
/* 2759 */     if (array == null)
/* 2760 */       return null; 
/* 2761 */     if (array.length == 0) {
/* 2762 */       return EMPTY_BOOLEAN_ARRAY;
/*      */     }
/* 2764 */     boolean[] result = new boolean[array.length];
/* 2765 */     for (int i = 0; i < array.length; i++) {
/* 2766 */       result[i] = array[i].booleanValue();
/*      */     }
/* 2768 */     return result;
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
/*      */   public static boolean[] toPrimitive(Boolean[] array, boolean valueForNull) {
/* 2781 */     if (array == null)
/* 2782 */       return null; 
/* 2783 */     if (array.length == 0) {
/* 2784 */       return EMPTY_BOOLEAN_ARRAY;
/*      */     }
/* 2786 */     boolean[] result = new boolean[array.length];
/* 2787 */     for (int i = 0; i < array.length; i++) {
/* 2788 */       Boolean b = array[i];
/* 2789 */       result[i] = (b == null) ? valueForNull : b.booleanValue();
/*      */     } 
/* 2791 */     return result;
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
/*      */   public static Boolean[] toObject(boolean[] array) {
/* 2803 */     if (array == null)
/* 2804 */       return null; 
/* 2805 */     if (array.length == 0) {
/* 2806 */       return EMPTY_BOOLEAN_OBJECT_ARRAY;
/*      */     }
/* 2808 */     Boolean[] result = new Boolean[array.length];
/* 2809 */     for (int i = 0; i < array.length; i++) {
/* 2810 */       result[i] = array[i] ? Boolean.TRUE : Boolean.FALSE;
/*      */     }
/* 2812 */     return result;
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
/*      */   public static boolean isEmpty(Object[] array) {
/* 2824 */     if (array == null || array.length == 0) {
/* 2825 */       return true;
/*      */     }
/* 2827 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(long[] array) {
/* 2838 */     if (array == null || array.length == 0) {
/* 2839 */       return true;
/*      */     }
/* 2841 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(int[] array) {
/* 2852 */     if (array == null || array.length == 0) {
/* 2853 */       return true;
/*      */     }
/* 2855 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(short[] array) {
/* 2866 */     if (array == null || array.length == 0) {
/* 2867 */       return true;
/*      */     }
/* 2869 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(char[] array) {
/* 2880 */     if (array == null || array.length == 0) {
/* 2881 */       return true;
/*      */     }
/* 2883 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(byte[] array) {
/* 2894 */     if (array == null || array.length == 0) {
/* 2895 */       return true;
/*      */     }
/* 2897 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(double[] array) {
/* 2908 */     if (array == null || array.length == 0) {
/* 2909 */       return true;
/*      */     }
/* 2911 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(float[] array) {
/* 2922 */     if (array == null || array.length == 0) {
/* 2923 */       return true;
/*      */     }
/* 2925 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isEmpty(boolean[] array) {
/* 2936 */     if (array == null || array.length == 0) {
/* 2937 */       return true;
/*      */     }
/* 2939 */     return false;
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
/*      */   public static Object[] addAll(Object[] array1, Object[] array2) {
/* 2964 */     if (array1 == null)
/* 2965 */       return clone(array2); 
/* 2966 */     if (array2 == null) {
/* 2967 */       return clone(array1);
/*      */     }
/* 2969 */     Object[] joinedArray = (Object[])Array.newInstance(array1.getClass().getComponentType(), array1.length + array2.length);
/*      */     
/* 2971 */     System.arraycopy(array1, 0, joinedArray, 0, array1.length);
/* 2972 */     System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
/* 2973 */     return joinedArray;
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
/*      */   public static boolean[] addAll(boolean[] array1, boolean[] array2) {
/* 2994 */     if (array1 == null)
/* 2995 */       return clone(array2); 
/* 2996 */     if (array2 == null) {
/* 2997 */       return clone(array1);
/*      */     }
/* 2999 */     boolean[] joinedArray = new boolean[array1.length + array2.length];
/* 3000 */     System.arraycopy(array1, 0, joinedArray, 0, array1.length);
/* 3001 */     System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
/* 3002 */     return joinedArray;
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
/*      */   public static char[] addAll(char[] array1, char[] array2) {
/* 3023 */     if (array1 == null)
/* 3024 */       return clone(array2); 
/* 3025 */     if (array2 == null) {
/* 3026 */       return clone(array1);
/*      */     }
/* 3028 */     char[] joinedArray = new char[array1.length + array2.length];
/* 3029 */     System.arraycopy(array1, 0, joinedArray, 0, array1.length);
/* 3030 */     System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
/* 3031 */     return joinedArray;
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
/*      */   public static byte[] addAll(byte[] array1, byte[] array2) {
/* 3052 */     if (array1 == null)
/* 3053 */       return clone(array2); 
/* 3054 */     if (array2 == null) {
/* 3055 */       return clone(array1);
/*      */     }
/* 3057 */     byte[] joinedArray = new byte[array1.length + array2.length];
/* 3058 */     System.arraycopy(array1, 0, joinedArray, 0, array1.length);
/* 3059 */     System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
/* 3060 */     return joinedArray;
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
/*      */   public static short[] addAll(short[] array1, short[] array2) {
/* 3081 */     if (array1 == null)
/* 3082 */       return clone(array2); 
/* 3083 */     if (array2 == null) {
/* 3084 */       return clone(array1);
/*      */     }
/* 3086 */     short[] joinedArray = new short[array1.length + array2.length];
/* 3087 */     System.arraycopy(array1, 0, joinedArray, 0, array1.length);
/* 3088 */     System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
/* 3089 */     return joinedArray;
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
/*      */   public static int[] addAll(int[] array1, int[] array2) {
/* 3110 */     if (array1 == null)
/* 3111 */       return clone(array2); 
/* 3112 */     if (array2 == null) {
/* 3113 */       return clone(array1);
/*      */     }
/* 3115 */     int[] joinedArray = new int[array1.length + array2.length];
/* 3116 */     System.arraycopy(array1, 0, joinedArray, 0, array1.length);
/* 3117 */     System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
/* 3118 */     return joinedArray;
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
/*      */   public static long[] addAll(long[] array1, long[] array2) {
/* 3139 */     if (array1 == null)
/* 3140 */       return clone(array2); 
/* 3141 */     if (array2 == null) {
/* 3142 */       return clone(array1);
/*      */     }
/* 3144 */     long[] joinedArray = new long[array1.length + array2.length];
/* 3145 */     System.arraycopy(array1, 0, joinedArray, 0, array1.length);
/* 3146 */     System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
/* 3147 */     return joinedArray;
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
/*      */   public static float[] addAll(float[] array1, float[] array2) {
/* 3168 */     if (array1 == null)
/* 3169 */       return clone(array2); 
/* 3170 */     if (array2 == null) {
/* 3171 */       return clone(array1);
/*      */     }
/* 3173 */     float[] joinedArray = new float[array1.length + array2.length];
/* 3174 */     System.arraycopy(array1, 0, joinedArray, 0, array1.length);
/* 3175 */     System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
/* 3176 */     return joinedArray;
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
/*      */   public static double[] addAll(double[] array1, double[] array2) {
/* 3197 */     if (array1 == null)
/* 3198 */       return clone(array2); 
/* 3199 */     if (array2 == null) {
/* 3200 */       return clone(array1);
/*      */     }
/* 3202 */     double[] joinedArray = new double[array1.length + array2.length];
/* 3203 */     System.arraycopy(array1, 0, joinedArray, 0, array1.length);
/* 3204 */     System.arraycopy(array2, 0, joinedArray, array1.length, array2.length);
/* 3205 */     return joinedArray;
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
/*      */   public static Object[] add(Object[] array, Object element) {
/* 3232 */     Class type = (array != null) ? array.getClass() : ((element != null) ? element.getClass() : Object.class);
/* 3233 */     Object[] newArray = (Object[])copyArrayGrow1(array, type);
/* 3234 */     newArray[newArray.length - 1] = element;
/* 3235 */     return newArray;
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
/*      */   public static boolean[] add(boolean[] array, boolean element) {
/* 3260 */     boolean[] newArray = (boolean[])copyArrayGrow1(array, boolean.class);
/* 3261 */     newArray[newArray.length - 1] = element;
/* 3262 */     return newArray;
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
/*      */   public static byte[] add(byte[] array, byte element) {
/* 3287 */     byte[] newArray = (byte[])copyArrayGrow1(array, byte.class);
/* 3288 */     newArray[newArray.length - 1] = element;
/* 3289 */     return newArray;
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
/*      */   public static char[] add(char[] array, char element) {
/* 3314 */     char[] newArray = (char[])copyArrayGrow1(array, char.class);
/* 3315 */     newArray[newArray.length - 1] = element;
/* 3316 */     return newArray;
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
/*      */   public static double[] add(double[] array, double element) {
/* 3341 */     double[] newArray = (double[])copyArrayGrow1(array, double.class);
/* 3342 */     newArray[newArray.length - 1] = element;
/* 3343 */     return newArray;
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
/*      */   public static float[] add(float[] array, float element) {
/* 3368 */     float[] newArray = (float[])copyArrayGrow1(array, float.class);
/* 3369 */     newArray[newArray.length - 1] = element;
/* 3370 */     return newArray;
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
/*      */   public static int[] add(int[] array, int element) {
/* 3395 */     int[] newArray = (int[])copyArrayGrow1(array, int.class);
/* 3396 */     newArray[newArray.length - 1] = element;
/* 3397 */     return newArray;
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
/*      */   public static long[] add(long[] array, long element) {
/* 3422 */     long[] newArray = (long[])copyArrayGrow1(array, long.class);
/* 3423 */     newArray[newArray.length - 1] = element;
/* 3424 */     return newArray;
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
/*      */   public static short[] add(short[] array, short element) {
/* 3449 */     short[] newArray = (short[])copyArrayGrow1(array, short.class);
/* 3450 */     newArray[newArray.length - 1] = element;
/* 3451 */     return newArray;
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
/*      */   private static Object copyArrayGrow1(Object array, Class newArrayComponentType) {
/* 3464 */     if (array != null) {
/* 3465 */       int arrayLength = Array.getLength(array);
/* 3466 */       Object newArray = Array.newInstance(array.getClass().getComponentType(), arrayLength + 1);
/* 3467 */       System.arraycopy(array, 0, newArray, 0, arrayLength);
/* 3468 */       return newArray;
/*      */     } 
/* 3470 */     return Array.newInstance(newArrayComponentType, 1);
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
/*      */   
/*      */   public static Object[] add(Object[] array, int index, Object element) {
/* 3502 */     Class clss = null;
/* 3503 */     if (array != null) {
/* 3504 */       clss = array.getClass().getComponentType();
/*      */     }
/* 3506 */     else if (element != null) {
/* 3507 */       clss = element.getClass();
/*      */     } else {
/* 3509 */       return new Object[] { null };
/*      */     } 
/* 3511 */     return (Object[])add(array, index, element, clss);
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
/*      */   public static boolean[] add(boolean[] array, int index, boolean element) {
/* 3542 */     return (boolean[])add(array, index, BooleanUtils.toBooleanObject(element), boolean.class);
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
/*      */   
/*      */   public static char[] add(char[] array, int index, char element) {
/* 3574 */     return (char[])add(array, index, new Character(element), char.class);
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
/*      */   public static byte[] add(byte[] array, int index, byte element) {
/* 3605 */     return (byte[])add(array, index, new Byte(element), byte.class);
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
/*      */   public static short[] add(short[] array, int index, short element) {
/* 3636 */     return (short[])add(array, index, new Short(element), short.class);
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
/*      */   public static int[] add(int[] array, int index, int element) {
/* 3667 */     return (int[])add(array, index, new Integer(element), int.class);
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
/*      */   public static long[] add(long[] array, int index, long element) {
/* 3698 */     return (long[])add(array, index, new Long(element), long.class);
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
/*      */   public static float[] add(float[] array, int index, float element) {
/* 3729 */     return (float[])add(array, index, new Float(element), float.class);
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
/*      */   public static double[] add(double[] array, int index, double element) {
/* 3760 */     return (double[])add(array, index, new Double(element), double.class);
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
/*      */   private static Object add(Object array, int index, Object element, Class clss) {
/* 3775 */     if (array == null) {
/* 3776 */       if (index != 0) {
/* 3777 */         throw new IndexOutOfBoundsException("Index: " + index + ", Length: 0");
/*      */       }
/* 3779 */       Object joinedArray = Array.newInstance(clss, 1);
/* 3780 */       Array.set(joinedArray, 0, element);
/* 3781 */       return joinedArray;
/*      */     } 
/* 3783 */     int length = Array.getLength(array);
/* 3784 */     if (index > length || index < 0) {
/* 3785 */       throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + length);
/*      */     }
/* 3787 */     Object result = Array.newInstance(clss, length + 1);
/* 3788 */     System.arraycopy(array, 0, result, 0, index);
/* 3789 */     Array.set(result, index, element);
/* 3790 */     if (index < length) {
/* 3791 */       System.arraycopy(array, index, result, index + 1, length - index);
/*      */     }
/* 3793 */     return result;
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
/*      */   
/*      */   public static Object[] remove(Object[] array, int index) {
/* 3825 */     return (Object[])remove(array, index);
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
/*      */   public static Object[] removeElement(Object[] array, Object element) {
/* 3854 */     int index = indexOf(array, element);
/* 3855 */     if (index == -1) {
/* 3856 */       return clone(array);
/*      */     }
/* 3858 */     return remove(array, index);
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
/*      */   
/*      */   public static boolean[] remove(boolean[] array, int index) {
/* 3890 */     return (boolean[])remove(array, index);
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
/*      */   public static boolean[] removeElement(boolean[] array, boolean element) {
/* 3919 */     int index = indexOf(array, element);
/* 3920 */     if (index == -1) {
/* 3921 */       return clone(array);
/*      */     }
/* 3923 */     return remove(array, index);
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
/*      */   
/*      */   public static byte[] remove(byte[] array, int index) {
/* 3955 */     return (byte[])remove(array, index);
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
/*      */   public static byte[] removeElement(byte[] array, byte element) {
/* 3984 */     int index = indexOf(array, element);
/* 3985 */     if (index == -1) {
/* 3986 */       return clone(array);
/*      */     }
/* 3988 */     return remove(array, index);
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
/*      */   
/*      */   public static char[] remove(char[] array, int index) {
/* 4020 */     return (char[])remove(array, index);
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
/*      */   public static char[] removeElement(char[] array, char element) {
/* 4049 */     int index = indexOf(array, element);
/* 4050 */     if (index == -1) {
/* 4051 */       return clone(array);
/*      */     }
/* 4053 */     return remove(array, index);
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
/*      */   
/*      */   public static double[] remove(double[] array, int index) {
/* 4085 */     return (double[])remove(array, index);
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
/*      */   public static double[] removeElement(double[] array, double element) {
/* 4114 */     int index = indexOf(array, element);
/* 4115 */     if (index == -1) {
/* 4116 */       return clone(array);
/*      */     }
/* 4118 */     return remove(array, index);
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
/*      */   
/*      */   public static float[] remove(float[] array, int index) {
/* 4150 */     return (float[])remove(array, index);
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
/*      */   public static float[] removeElement(float[] array, float element) {
/* 4179 */     int index = indexOf(array, element);
/* 4180 */     if (index == -1) {
/* 4181 */       return clone(array);
/*      */     }
/* 4183 */     return remove(array, index);
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
/*      */   
/*      */   public static int[] remove(int[] array, int index) {
/* 4215 */     return (int[])remove(array, index);
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
/*      */   public static int[] removeElement(int[] array, int element) {
/* 4244 */     int index = indexOf(array, element);
/* 4245 */     if (index == -1) {
/* 4246 */       return clone(array);
/*      */     }
/* 4248 */     return remove(array, index);
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
/*      */   
/*      */   public static long[] remove(long[] array, int index) {
/* 4280 */     return (long[])remove(array, index);
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
/*      */   public static long[] removeElement(long[] array, long element) {
/* 4309 */     int index = indexOf(array, element);
/* 4310 */     if (index == -1) {
/* 4311 */       return clone(array);
/*      */     }
/* 4313 */     return remove(array, index);
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
/*      */   
/*      */   public static short[] remove(short[] array, int index) {
/* 4345 */     return (short[])remove(array, index);
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
/*      */   public static short[] removeElement(short[] array, short element) {
/* 4374 */     int index = indexOf(array, element);
/* 4375 */     if (index == -1) {
/* 4376 */       return clone(array);
/*      */     }
/* 4378 */     return remove(array, index);
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
/*      */   private static Object remove(Object array, int index) {
/* 4403 */     int length = getLength(array);
/* 4404 */     if (index < 0 || index >= length) {
/* 4405 */       throw new IndexOutOfBoundsException("Index: " + index + ", Length: " + length);
/*      */     }
/*      */     
/* 4408 */     Object result = Array.newInstance(array.getClass().getComponentType(), length - 1);
/* 4409 */     System.arraycopy(array, 0, result, 0, index);
/* 4410 */     if (index < length - 1) {
/* 4411 */       System.arraycopy(array, index + 1, result, index, length - index - 1);
/*      */     }
/*      */     
/* 4414 */     return result;
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\ArrayUtils.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */