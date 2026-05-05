/*     */ package org.apache.commons.lang;
/*     */ 
/*     */ import org.apache.commons.lang.math.NumberUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BooleanUtils
/*     */ {
/*     */   public static Boolean negate(Boolean bool) {
/*  64 */     if (bool == null) {
/*  65 */       return null;
/*     */     }
/*  67 */     return bool.booleanValue() ? Boolean.FALSE : Boolean.TRUE;
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
/*     */   public static boolean isTrue(Boolean bool) {
/*  87 */     if (bool == null) {
/*  88 */       return false;
/*     */     }
/*  90 */     return bool.booleanValue();
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
/*     */   public static boolean isNotTrue(Boolean bool) {
/* 108 */     return !isTrue(bool);
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
/*     */   public static boolean isFalse(Boolean bool) {
/* 126 */     if (bool == null) {
/* 127 */       return false;
/*     */     }
/* 129 */     return !bool.booleanValue();
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
/*     */   public static boolean isNotFalse(Boolean bool) {
/* 147 */     return !isFalse(bool);
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
/*     */   public static Boolean toBooleanObject(boolean bool) {
/* 165 */     return bool ? Boolean.TRUE : Boolean.FALSE;
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
/*     */   public static boolean toBoolean(Boolean bool) {
/* 183 */     if (bool == null) {
/* 184 */       return false;
/*     */     }
/* 186 */     return bool.booleanValue();
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
/*     */   public static boolean toBooleanDefaultIfNull(Boolean bool, boolean valueIfNull) {
/* 203 */     if (bool == null) {
/* 204 */       return valueIfNull;
/*     */     }
/* 206 */     return bool.booleanValue();
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
/*     */   public static boolean toBoolean(int value) {
/* 226 */     return !(value == 0);
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
/*     */   public static Boolean toBooleanObject(int value) {
/* 244 */     return (value == 0) ? Boolean.FALSE : Boolean.TRUE;
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
/*     */   public static Boolean toBooleanObject(Integer value) {
/* 264 */     if (value == null) {
/* 265 */       return null;
/*     */     }
/* 267 */     return (value.intValue() == 0) ? Boolean.FALSE : Boolean.TRUE;
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
/*     */   public static boolean toBoolean(int value, int trueValue, int falseValue) {
/* 287 */     if (value == trueValue)
/* 288 */       return true; 
/* 289 */     if (value == falseValue) {
/* 290 */       return false;
/*     */     }
/*     */     
/* 293 */     throw new IllegalArgumentException("The Integer did not match either specified value");
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
/*     */   public static boolean toBoolean(Integer value, Integer trueValue, Integer falseValue) {
/* 316 */     if (value == null) {
/* 317 */       if (trueValue == null)
/* 318 */         return true; 
/* 319 */       if (falseValue == null)
/* 320 */         return false; 
/*     */     } else {
/* 322 */       if (value.equals(trueValue))
/* 323 */         return true; 
/* 324 */       if (value.equals(falseValue)) {
/* 325 */         return false;
/*     */       }
/*     */     } 
/* 328 */     throw new IllegalArgumentException("The Integer did not match either specified value");
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
/*     */   public static Boolean toBooleanObject(int value, int trueValue, int falseValue, int nullValue) {
/* 348 */     if (value == trueValue)
/* 349 */       return Boolean.TRUE; 
/* 350 */     if (value == falseValue)
/* 351 */       return Boolean.FALSE; 
/* 352 */     if (value == nullValue) {
/* 353 */       return null;
/*     */     }
/*     */     
/* 356 */     throw new IllegalArgumentException("The Integer did not match any specified value");
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
/*     */   public static Boolean toBooleanObject(Integer value, Integer trueValue, Integer falseValue, Integer nullValue) {
/* 379 */     if (value == null) {
/* 380 */       if (trueValue == null)
/* 381 */         return Boolean.TRUE; 
/* 382 */       if (falseValue == null)
/* 383 */         return Boolean.FALSE; 
/* 384 */       if (nullValue == null)
/* 385 */         return null; 
/*     */     } else {
/* 387 */       if (value.equals(trueValue))
/* 388 */         return Boolean.TRUE; 
/* 389 */       if (value.equals(falseValue))
/* 390 */         return Boolean.FALSE; 
/* 391 */       if (value.equals(nullValue)) {
/* 392 */         return null;
/*     */       }
/*     */     } 
/* 395 */     throw new IllegalArgumentException("The Integer did not match any specified value");
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
/*     */   public static int toInteger(boolean bool) {
/* 413 */     return bool ? 1 : 0;
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
/*     */   public static Integer toIntegerObject(boolean bool) {
/* 429 */     return bool ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
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
/*     */   public static Integer toIntegerObject(Boolean bool) {
/* 447 */     if (bool == null) {
/* 448 */       return null;
/*     */     }
/* 450 */     return bool.booleanValue() ? NumberUtils.INTEGER_ONE : NumberUtils.INTEGER_ZERO;
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
/*     */   public static int toInteger(boolean bool, int trueValue, int falseValue) {
/* 467 */     return bool ? trueValue : falseValue;
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
/*     */   public static int toInteger(Boolean bool, int trueValue, int falseValue, int nullValue) {
/* 486 */     if (bool == null) {
/* 487 */       return nullValue;
/*     */     }
/* 489 */     return bool.booleanValue() ? trueValue : falseValue;
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
/*     */   public static Integer toIntegerObject(boolean bool, Integer trueValue, Integer falseValue) {
/* 508 */     return bool ? trueValue : falseValue;
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
/*     */   public static Integer toIntegerObject(Boolean bool, Integer trueValue, Integer falseValue, Integer nullValue) {
/* 530 */     if (bool == null) {
/* 531 */       return nullValue;
/*     */     }
/* 533 */     return bool.booleanValue() ? trueValue : falseValue;
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
/*     */   public static Boolean toBooleanObject(String str) {
/* 563 */     if ("true".equalsIgnoreCase(str))
/* 564 */       return Boolean.TRUE; 
/* 565 */     if ("false".equalsIgnoreCase(str))
/* 566 */       return Boolean.FALSE; 
/* 567 */     if ("on".equalsIgnoreCase(str))
/* 568 */       return Boolean.TRUE; 
/* 569 */     if ("off".equalsIgnoreCase(str))
/* 570 */       return Boolean.FALSE; 
/* 571 */     if ("yes".equalsIgnoreCase(str))
/* 572 */       return Boolean.TRUE; 
/* 573 */     if ("no".equalsIgnoreCase(str)) {
/* 574 */       return Boolean.FALSE;
/*     */     }
/*     */     
/* 577 */     return null;
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
/*     */   public static Boolean toBooleanObject(String str, String trueString, String falseString, String nullString) {
/* 600 */     if (str == null) {
/* 601 */       if (trueString == null)
/* 602 */         return Boolean.TRUE; 
/* 603 */       if (falseString == null)
/* 604 */         return Boolean.FALSE; 
/* 605 */       if (nullString == null)
/* 606 */         return null; 
/*     */     } else {
/* 608 */       if (str.equals(trueString))
/* 609 */         return Boolean.TRUE; 
/* 610 */       if (str.equals(falseString))
/* 611 */         return Boolean.FALSE; 
/* 612 */       if (str.equals(nullString)) {
/* 613 */         return null;
/*     */       }
/*     */     } 
/* 616 */     throw new IllegalArgumentException("The String did not match any specified value");
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
/*     */   public static boolean toBoolean(String str) {
/*     */     char ch0;
/*     */     char ch;
/*     */     char ch1;
/* 653 */     if (str == "true") {
/* 654 */       return true;
/*     */     }
/* 656 */     if (str == null) {
/* 657 */       return false;
/*     */     }
/* 659 */     switch (str.length()) {
/*     */       case 2:
/* 661 */         ch0 = str.charAt(0);
/* 662 */         ch1 = str.charAt(1);
/* 663 */         return ((ch0 == 'o' || ch0 == 'O') && (ch1 == 'n' || ch1 == 'N'));
/*     */ 
/*     */ 
/*     */       
/*     */       case 3:
/* 668 */         ch = str.charAt(0);
/* 669 */         if (ch == 'y') {
/* 670 */           return ((str.charAt(1) == 'e' || str.charAt(1) == 'E') && (str.charAt(2) == 's' || str.charAt(2) == 'S'));
/*     */         }
/*     */ 
/*     */         
/* 674 */         if (ch == 'Y') {
/* 675 */           return ((str.charAt(1) == 'E' || str.charAt(1) == 'e') && (str.charAt(2) == 'S' || str.charAt(2) == 's'));
/*     */         }
/*     */ 
/*     */ 
/*     */       
/*     */       case 4:
/* 681 */         ch = str.charAt(0);
/* 682 */         if (ch == 't') {
/* 683 */           return ((str.charAt(1) == 'r' || str.charAt(1) == 'R') && (str.charAt(2) == 'u' || str.charAt(2) == 'U') && (str.charAt(3) == 'e' || str.charAt(3) == 'E'));
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 688 */         if (ch == 'T') {
/* 689 */           return ((str.charAt(1) == 'R' || str.charAt(1) == 'r') && (str.charAt(2) == 'U' || str.charAt(2) == 'u') && (str.charAt(3) == 'E' || str.charAt(3) == 'e'));
/*     */         }
/*     */         break;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 696 */     return false;
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
/*     */   public static boolean toBoolean(String str, String trueString, String falseString) {
/* 729 */     if (str == null) {
/* 730 */       if (trueString == null)
/* 731 */         return true; 
/* 732 */       if (falseString == null)
/* 733 */         return false; 
/*     */     } else {
/* 735 */       if (str.equals(trueString))
/* 736 */         return true; 
/* 737 */       if (str.equals(falseString)) {
/* 738 */         return false;
/*     */       }
/*     */     } 
/* 741 */     throw new IllegalArgumentException("The String did not match either specified value");
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
/*     */   public static String toStringTrueFalse(Boolean bool) {
/* 761 */     return toString(bool, "true", "false", null);
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
/*     */   public static String toStringOnOff(Boolean bool) {
/* 779 */     return toString(bool, "on", "off", null);
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
/*     */   public static String toStringYesNo(Boolean bool) {
/* 797 */     return toString(bool, "yes", "no", null);
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
/*     */   public static String toString(Boolean bool, String trueString, String falseString, String nullString) {
/* 819 */     if (bool == null) {
/* 820 */       return nullString;
/*     */     }
/* 822 */     return bool.booleanValue() ? trueString : falseString;
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
/*     */   public static String toStringTrueFalse(boolean bool) {
/* 841 */     return toString(bool, "true", "false");
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
/*     */   public static String toStringOnOff(boolean bool) {
/* 858 */     return toString(bool, "on", "off");
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
/*     */   public static String toStringYesNo(boolean bool) {
/* 875 */     return toString(bool, "yes", "no");
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
/*     */   public static String toString(boolean bool, String trueString, String falseString) {
/* 894 */     return bool ? trueString : falseString;
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
/*     */   public static boolean xor(boolean[] array) {
/* 915 */     if (array == null)
/* 916 */       throw new IllegalArgumentException("The Array must not be null"); 
/* 917 */     if (array.length == 0) {
/* 918 */       throw new IllegalArgumentException("Array is empty");
/*     */     }
/*     */ 
/*     */     
/* 922 */     int trueCount = 0;
/* 923 */     for (int i = 0; i < array.length; i++) {
/*     */ 
/*     */       
/* 926 */       if (array[i]) {
/* 927 */         if (trueCount < 1) {
/* 928 */           trueCount++;
/*     */         } else {
/* 930 */           return false;
/*     */         } 
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 936 */     return (trueCount == 1);
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
/*     */   public static Boolean xor(Boolean[] array) {
/* 955 */     if (array == null)
/* 956 */       throw new IllegalArgumentException("The Array must not be null"); 
/* 957 */     if (array.length == 0) {
/* 958 */       throw new IllegalArgumentException("Array is empty");
/*     */     }
/* 960 */     boolean[] primitive = null;
/*     */     try {
/* 962 */       primitive = ArrayUtils.toPrimitive(array);
/*     */     } catch (NullPointerException ex) {
/* 964 */       throw new IllegalArgumentException("The array must not contain any null elements");
/*     */     } 
/* 966 */     return xor(primitive) ? Boolean.TRUE : Boolean.FALSE;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\BooleanUtils.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */