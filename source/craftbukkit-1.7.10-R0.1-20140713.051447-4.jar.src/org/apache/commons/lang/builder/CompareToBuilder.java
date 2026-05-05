/*      */ package org.apache.commons.lang.builder;
/*      */ 
/*      */ import java.lang.reflect.AccessibleObject;
/*      */ import java.lang.reflect.Field;
/*      */ import java.lang.reflect.Modifier;
/*      */ import java.util.Arrays;
/*      */ import java.util.Collection;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.List;
/*      */ import org.apache.commons.lang.math.NumberUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class CompareToBuilder
/*      */ {
/*  111 */   private int comparison = 0;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int reflectionCompare(Object lhs, Object rhs) {
/*  142 */     return reflectionCompare(lhs, rhs, false, null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int reflectionCompare(Object lhs, Object rhs, boolean compareTransients) {
/*  174 */     return reflectionCompare(lhs, rhs, compareTransients, null, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int reflectionCompare(Object lhs, Object rhs, Collection excludeFields) {
/*  207 */     return reflectionCompare(lhs, rhs, ReflectionToStringBuilder.toNoNullStringArray(excludeFields));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int reflectionCompare(Object lhs, Object rhs, String[] excludeFields) {
/*  240 */     return reflectionCompare(lhs, rhs, false, null, excludeFields);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int reflectionCompare(Object lhs, Object rhs, boolean compareTransients, Class reflectUpToClass) {
/*  277 */     return reflectionCompare(lhs, rhs, false, reflectUpToClass, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int reflectionCompare(Object lhs, Object rhs, boolean compareTransients, Class reflectUpToClass, String[] excludeFields) {
/*  319 */     if (lhs == rhs) {
/*  320 */       return 0;
/*      */     }
/*  322 */     if (lhs == null || rhs == null) {
/*  323 */       throw new NullPointerException();
/*      */     }
/*  325 */     Class lhsClazz = lhs.getClass();
/*  326 */     if (!lhsClazz.isInstance(rhs)) {
/*  327 */       throw new ClassCastException();
/*      */     }
/*  329 */     CompareToBuilder compareToBuilder = new CompareToBuilder();
/*  330 */     reflectionAppend(lhs, rhs, lhsClazz, compareToBuilder, compareTransients, excludeFields);
/*  331 */     while (lhsClazz.getSuperclass() != null && lhsClazz != reflectUpToClass) {
/*  332 */       lhsClazz = lhsClazz.getSuperclass();
/*  333 */       reflectionAppend(lhs, rhs, lhsClazz, compareToBuilder, compareTransients, excludeFields);
/*      */     } 
/*  335 */     return compareToBuilder.toComparison();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static void reflectionAppend(Object lhs, Object rhs, Class clazz, CompareToBuilder builder, boolean useTransients, String[] excludeFields) {
/*  357 */     Field[] fields = clazz.getDeclaredFields();
/*  358 */     List excludedFieldList = (excludeFields != null) ? Arrays.<String>asList(excludeFields) : Collections.EMPTY_LIST;
/*  359 */     AccessibleObject.setAccessible((AccessibleObject[])fields, true);
/*  360 */     for (int i = 0; i < fields.length && builder.comparison == 0; i++) {
/*  361 */       Field f = fields[i];
/*  362 */       if (!excludedFieldList.contains(f.getName()) && f.getName().indexOf('$') == -1 && (useTransients || !Modifier.isTransient(f.getModifiers())) && !Modifier.isStatic(f.getModifiers())) {
/*      */         
/*      */         try {
/*      */ 
/*      */           
/*  367 */           builder.append(f.get(lhs), f.get(rhs));
/*      */         }
/*      */         catch (IllegalAccessException e) {
/*      */           
/*  371 */           throw new InternalError("Unexpected IllegalAccessException");
/*      */         } 
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
/*      */   public CompareToBuilder appendSuper(int superCompareTo) {
/*  387 */     if (this.comparison != 0) {
/*  388 */       return this;
/*      */     }
/*  390 */     this.comparison = superCompareTo;
/*  391 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(Object lhs, Object rhs) {
/*  415 */     return append(lhs, rhs, (Comparator)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(Object lhs, Object rhs, Comparator comparator) {
/*  444 */     if (this.comparison != 0) {
/*  445 */       return this;
/*      */     }
/*  447 */     if (lhs == rhs) {
/*  448 */       return this;
/*      */     }
/*  450 */     if (lhs == null) {
/*  451 */       this.comparison = -1;
/*  452 */       return this;
/*      */     } 
/*  454 */     if (rhs == null) {
/*  455 */       this.comparison = 1;
/*  456 */       return this;
/*      */     } 
/*  458 */     if (lhs.getClass().isArray()) {
/*      */ 
/*      */ 
/*      */       
/*  462 */       if (lhs instanceof long[]) {
/*  463 */         append((long[])lhs, (long[])rhs);
/*  464 */       } else if (lhs instanceof int[]) {
/*  465 */         append((int[])lhs, (int[])rhs);
/*  466 */       } else if (lhs instanceof short[]) {
/*  467 */         append((short[])lhs, (short[])rhs);
/*  468 */       } else if (lhs instanceof char[]) {
/*  469 */         append((char[])lhs, (char[])rhs);
/*  470 */       } else if (lhs instanceof byte[]) {
/*  471 */         append((byte[])lhs, (byte[])rhs);
/*  472 */       } else if (lhs instanceof double[]) {
/*  473 */         append((double[])lhs, (double[])rhs);
/*  474 */       } else if (lhs instanceof float[]) {
/*  475 */         append((float[])lhs, (float[])rhs);
/*  476 */       } else if (lhs instanceof boolean[]) {
/*  477 */         append((boolean[])lhs, (boolean[])rhs);
/*      */       }
/*      */       else {
/*      */         
/*  481 */         append((Object[])lhs, (Object[])rhs, comparator);
/*      */       }
/*      */     
/*      */     }
/*  485 */     else if (comparator == null) {
/*  486 */       this.comparison = ((Comparable)lhs).compareTo(rhs);
/*      */     } else {
/*  488 */       this.comparison = comparator.compare(lhs, rhs);
/*      */     } 
/*      */     
/*  491 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(long lhs, long rhs) {
/*  504 */     if (this.comparison != 0) {
/*  505 */       return this;
/*      */     }
/*  507 */     this.comparison = (lhs < rhs) ? -1 : ((lhs > rhs) ? 1 : 0);
/*  508 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(int lhs, int rhs) {
/*  520 */     if (this.comparison != 0) {
/*  521 */       return this;
/*      */     }
/*  523 */     this.comparison = (lhs < rhs) ? -1 : ((lhs > rhs) ? 1 : 0);
/*  524 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(short lhs, short rhs) {
/*  536 */     if (this.comparison != 0) {
/*  537 */       return this;
/*      */     }
/*  539 */     this.comparison = (lhs < rhs) ? -1 : ((lhs > rhs) ? 1 : 0);
/*  540 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(char lhs, char rhs) {
/*  552 */     if (this.comparison != 0) {
/*  553 */       return this;
/*      */     }
/*  555 */     this.comparison = (lhs < rhs) ? -1 : ((lhs > rhs) ? 1 : 0);
/*  556 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(byte lhs, byte rhs) {
/*  568 */     if (this.comparison != 0) {
/*  569 */       return this;
/*      */     }
/*  571 */     this.comparison = (lhs < rhs) ? -1 : ((lhs > rhs) ? 1 : 0);
/*  572 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(double lhs, double rhs) {
/*  589 */     if (this.comparison != 0) {
/*  590 */       return this;
/*      */     }
/*  592 */     this.comparison = NumberUtils.compare(lhs, rhs);
/*  593 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(float lhs, float rhs) {
/*  610 */     if (this.comparison != 0) {
/*  611 */       return this;
/*      */     }
/*  613 */     this.comparison = NumberUtils.compare(lhs, rhs);
/*  614 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(boolean lhs, boolean rhs) {
/*  626 */     if (this.comparison != 0) {
/*  627 */       return this;
/*      */     }
/*  629 */     if (lhs == rhs) {
/*  630 */       return this;
/*      */     }
/*  632 */     if (!lhs) {
/*  633 */       this.comparison = -1;
/*      */     } else {
/*  635 */       this.comparison = 1;
/*      */     } 
/*  637 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(Object[] lhs, Object[] rhs) {
/*  662 */     return append(lhs, rhs, (Comparator)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(Object[] lhs, Object[] rhs, Comparator comparator) {
/*  689 */     if (this.comparison != 0) {
/*  690 */       return this;
/*      */     }
/*  692 */     if (lhs == rhs) {
/*  693 */       return this;
/*      */     }
/*  695 */     if (lhs == null) {
/*  696 */       this.comparison = -1;
/*  697 */       return this;
/*      */     } 
/*  699 */     if (rhs == null) {
/*  700 */       this.comparison = 1;
/*  701 */       return this;
/*      */     } 
/*  703 */     if (lhs.length != rhs.length) {
/*  704 */       this.comparison = (lhs.length < rhs.length) ? -1 : 1;
/*  705 */       return this;
/*      */     } 
/*  707 */     for (int i = 0; i < lhs.length && this.comparison == 0; i++) {
/*  708 */       append(lhs[i], rhs[i], comparator);
/*      */     }
/*  710 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(long[] lhs, long[] rhs) {
/*  729 */     if (this.comparison != 0) {
/*  730 */       return this;
/*      */     }
/*  732 */     if (lhs == rhs) {
/*  733 */       return this;
/*      */     }
/*  735 */     if (lhs == null) {
/*  736 */       this.comparison = -1;
/*  737 */       return this;
/*      */     } 
/*  739 */     if (rhs == null) {
/*  740 */       this.comparison = 1;
/*  741 */       return this;
/*      */     } 
/*  743 */     if (lhs.length != rhs.length) {
/*  744 */       this.comparison = (lhs.length < rhs.length) ? -1 : 1;
/*  745 */       return this;
/*      */     } 
/*  747 */     for (int i = 0; i < lhs.length && this.comparison == 0; i++) {
/*  748 */       append(lhs[i], rhs[i]);
/*      */     }
/*  750 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(int[] lhs, int[] rhs) {
/*  769 */     if (this.comparison != 0) {
/*  770 */       return this;
/*      */     }
/*  772 */     if (lhs == rhs) {
/*  773 */       return this;
/*      */     }
/*  775 */     if (lhs == null) {
/*  776 */       this.comparison = -1;
/*  777 */       return this;
/*      */     } 
/*  779 */     if (rhs == null) {
/*  780 */       this.comparison = 1;
/*  781 */       return this;
/*      */     } 
/*  783 */     if (lhs.length != rhs.length) {
/*  784 */       this.comparison = (lhs.length < rhs.length) ? -1 : 1;
/*  785 */       return this;
/*      */     } 
/*  787 */     for (int i = 0; i < lhs.length && this.comparison == 0; i++) {
/*  788 */       append(lhs[i], rhs[i]);
/*      */     }
/*  790 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(short[] lhs, short[] rhs) {
/*  809 */     if (this.comparison != 0) {
/*  810 */       return this;
/*      */     }
/*  812 */     if (lhs == rhs) {
/*  813 */       return this;
/*      */     }
/*  815 */     if (lhs == null) {
/*  816 */       this.comparison = -1;
/*  817 */       return this;
/*      */     } 
/*  819 */     if (rhs == null) {
/*  820 */       this.comparison = 1;
/*  821 */       return this;
/*      */     } 
/*  823 */     if (lhs.length != rhs.length) {
/*  824 */       this.comparison = (lhs.length < rhs.length) ? -1 : 1;
/*  825 */       return this;
/*      */     } 
/*  827 */     for (int i = 0; i < lhs.length && this.comparison == 0; i++) {
/*  828 */       append(lhs[i], rhs[i]);
/*      */     }
/*  830 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(char[] lhs, char[] rhs) {
/*  849 */     if (this.comparison != 0) {
/*  850 */       return this;
/*      */     }
/*  852 */     if (lhs == rhs) {
/*  853 */       return this;
/*      */     }
/*  855 */     if (lhs == null) {
/*  856 */       this.comparison = -1;
/*  857 */       return this;
/*      */     } 
/*  859 */     if (rhs == null) {
/*  860 */       this.comparison = 1;
/*  861 */       return this;
/*      */     } 
/*  863 */     if (lhs.length != rhs.length) {
/*  864 */       this.comparison = (lhs.length < rhs.length) ? -1 : 1;
/*  865 */       return this;
/*      */     } 
/*  867 */     for (int i = 0; i < lhs.length && this.comparison == 0; i++) {
/*  868 */       append(lhs[i], rhs[i]);
/*      */     }
/*  870 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(byte[] lhs, byte[] rhs) {
/*  889 */     if (this.comparison != 0) {
/*  890 */       return this;
/*      */     }
/*  892 */     if (lhs == rhs) {
/*  893 */       return this;
/*      */     }
/*  895 */     if (lhs == null) {
/*  896 */       this.comparison = -1;
/*  897 */       return this;
/*      */     } 
/*  899 */     if (rhs == null) {
/*  900 */       this.comparison = 1;
/*  901 */       return this;
/*      */     } 
/*  903 */     if (lhs.length != rhs.length) {
/*  904 */       this.comparison = (lhs.length < rhs.length) ? -1 : 1;
/*  905 */       return this;
/*      */     } 
/*  907 */     for (int i = 0; i < lhs.length && this.comparison == 0; i++) {
/*  908 */       append(lhs[i], rhs[i]);
/*      */     }
/*  910 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(double[] lhs, double[] rhs) {
/*  929 */     if (this.comparison != 0) {
/*  930 */       return this;
/*      */     }
/*  932 */     if (lhs == rhs) {
/*  933 */       return this;
/*      */     }
/*  935 */     if (lhs == null) {
/*  936 */       this.comparison = -1;
/*  937 */       return this;
/*      */     } 
/*  939 */     if (rhs == null) {
/*  940 */       this.comparison = 1;
/*  941 */       return this;
/*      */     } 
/*  943 */     if (lhs.length != rhs.length) {
/*  944 */       this.comparison = (lhs.length < rhs.length) ? -1 : 1;
/*  945 */       return this;
/*      */     } 
/*  947 */     for (int i = 0; i < lhs.length && this.comparison == 0; i++) {
/*  948 */       append(lhs[i], rhs[i]);
/*      */     }
/*  950 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(float[] lhs, float[] rhs) {
/*  969 */     if (this.comparison != 0) {
/*  970 */       return this;
/*      */     }
/*  972 */     if (lhs == rhs) {
/*  973 */       return this;
/*      */     }
/*  975 */     if (lhs == null) {
/*  976 */       this.comparison = -1;
/*  977 */       return this;
/*      */     } 
/*  979 */     if (rhs == null) {
/*  980 */       this.comparison = 1;
/*  981 */       return this;
/*      */     } 
/*  983 */     if (lhs.length != rhs.length) {
/*  984 */       this.comparison = (lhs.length < rhs.length) ? -1 : 1;
/*  985 */       return this;
/*      */     } 
/*  987 */     for (int i = 0; i < lhs.length && this.comparison == 0; i++) {
/*  988 */       append(lhs[i], rhs[i]);
/*      */     }
/*  990 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CompareToBuilder append(boolean[] lhs, boolean[] rhs) {
/* 1009 */     if (this.comparison != 0) {
/* 1010 */       return this;
/*      */     }
/* 1012 */     if (lhs == rhs) {
/* 1013 */       return this;
/*      */     }
/* 1015 */     if (lhs == null) {
/* 1016 */       this.comparison = -1;
/* 1017 */       return this;
/*      */     } 
/* 1019 */     if (rhs == null) {
/* 1020 */       this.comparison = 1;
/* 1021 */       return this;
/*      */     } 
/* 1023 */     if (lhs.length != rhs.length) {
/* 1024 */       this.comparison = (lhs.length < rhs.length) ? -1 : 1;
/* 1025 */       return this;
/*      */     } 
/* 1027 */     for (int i = 0; i < lhs.length && this.comparison == 0; i++) {
/* 1028 */       append(lhs[i], rhs[i]);
/*      */     }
/* 1030 */     return this;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int toComparison() {
/* 1043 */     return this.comparison;
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\builder\CompareToBuilder.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */