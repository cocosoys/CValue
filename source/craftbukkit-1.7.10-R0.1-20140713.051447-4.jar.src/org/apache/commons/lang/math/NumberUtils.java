/*      */ package org.apache.commons.lang.math;
/*      */ 
/*      */ import java.math.BigDecimal;
/*      */ import java.math.BigInteger;
/*      */ import org.apache.commons.lang.StringUtils;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class NumberUtils
/*      */ {
/*   41 */   public static final Long LONG_ZERO = new Long(0L);
/*      */   
/*   43 */   public static final Long LONG_ONE = new Long(1L);
/*      */   
/*   45 */   public static final Long LONG_MINUS_ONE = new Long(-1L);
/*      */   
/*   47 */   public static final Integer INTEGER_ZERO = new Integer(0);
/*      */   
/*   49 */   public static final Integer INTEGER_ONE = new Integer(1);
/*      */   
/*   51 */   public static final Integer INTEGER_MINUS_ONE = new Integer(-1);
/*      */   
/*   53 */   public static final Short SHORT_ZERO = new Short((short)0);
/*      */   
/*   55 */   public static final Short SHORT_ONE = new Short((short)1);
/*      */   
/*   57 */   public static final Short SHORT_MINUS_ONE = new Short((short)-1);
/*      */   
/*   59 */   public static final Byte BYTE_ZERO = new Byte((byte)0);
/*      */   
/*   61 */   public static final Byte BYTE_ONE = new Byte((byte)1);
/*      */   
/*   63 */   public static final Byte BYTE_MINUS_ONE = new Byte((byte)-1);
/*      */   
/*   65 */   public static final Double DOUBLE_ZERO = new Double(0.0D);
/*      */   
/*   67 */   public static final Double DOUBLE_ONE = new Double(1.0D);
/*      */   
/*   69 */   public static final Double DOUBLE_MINUS_ONE = new Double(-1.0D);
/*      */   
/*   71 */   public static final Float FLOAT_ZERO = new Float(0.0F);
/*      */   
/*   73 */   public static final Float FLOAT_ONE = new Float(1.0F);
/*      */   
/*   75 */   public static final Float FLOAT_MINUS_ONE = new Float(-1.0F);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stringToInt(String str) {
/*  108 */     return toInt(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int toInt(String str) {
/*  129 */     return toInt(str, 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int stringToInt(String str, int defaultValue) {
/*  151 */     return toInt(str, defaultValue);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int toInt(String str, int defaultValue) {
/*  172 */     if (str == null) {
/*  173 */       return defaultValue;
/*      */     }
/*      */     try {
/*  176 */       return Integer.parseInt(str);
/*      */     } catch (NumberFormatException nfe) {
/*  178 */       return defaultValue;
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
/*      */ 
/*      */   
/*      */   public static long toLong(String str) {
/*  200 */     return toLong(str, 0L);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long toLong(String str, long defaultValue) {
/*  221 */     if (str == null) {
/*  222 */       return defaultValue;
/*      */     }
/*      */     try {
/*  225 */       return Long.parseLong(str);
/*      */     } catch (NumberFormatException nfe) {
/*  227 */       return defaultValue;
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static float toFloat(String str) {
/*  250 */     return toFloat(str, 0.0F);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float toFloat(String str, float defaultValue) {
/*  273 */     if (str == null) {
/*  274 */       return defaultValue;
/*      */     }
/*      */     try {
/*  277 */       return Float.parseFloat(str);
/*      */     } catch (NumberFormatException nfe) {
/*  279 */       return defaultValue;
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
/*      */ 
/*      */ 
/*      */   
/*      */   public static double toDouble(String str) {
/*  302 */     return toDouble(str, 0.0D);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static double toDouble(String str, double defaultValue) {
/*  325 */     if (str == null) {
/*  326 */       return defaultValue;
/*      */     }
/*      */     try {
/*  329 */       return Double.parseDouble(str);
/*      */     } catch (NumberFormatException nfe) {
/*  331 */       return defaultValue;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Number createNumber(String str) throws NumberFormatException {
/*      */     Object object;
/*      */     String str1, str2;
/*  398 */     if (str == null) {
/*  399 */       return null;
/*      */     }
/*  401 */     if (StringUtils.isBlank(str)) {
/*  402 */       throw new NumberFormatException("A blank string is not a valid number");
/*      */     }
/*  404 */     if (str.startsWith("--"))
/*      */     {
/*      */ 
/*      */ 
/*      */       
/*  409 */       return null;
/*      */     }
/*  411 */     if (str.startsWith("0x") || str.startsWith("-0x")) {
/*  412 */       return createInteger(str);
/*      */     }
/*  414 */     char lastChar = str.charAt(str.length() - 1);
/*      */ 
/*      */ 
/*      */     
/*  418 */     int decPos = str.indexOf('.');
/*  419 */     int expPos = str.indexOf('e') + str.indexOf('E') + 1;
/*      */     
/*  421 */     if (decPos > -1) {
/*      */       
/*  423 */       if (expPos > -1) {
/*  424 */         if (expPos < decPos) {
/*  425 */           throw new NumberFormatException(str + " is not a valid number.");
/*      */         }
/*  427 */         object = str.substring(decPos + 1, expPos);
/*      */       } else {
/*  429 */         object = str.substring(decPos + 1);
/*      */       } 
/*  431 */       str1 = str.substring(0, decPos);
/*      */     } else {
/*  433 */       if (expPos > -1) {
/*  434 */         str1 = str.substring(0, expPos);
/*      */       } else {
/*  436 */         str1 = str;
/*      */       } 
/*  438 */       object = null;
/*      */     } 
/*  440 */     if (!Character.isDigit(lastChar)) {
/*  441 */       if (expPos > -1 && expPos < str.length() - 1) {
/*  442 */         str2 = str.substring(expPos + 1, str.length() - 1);
/*      */       } else {
/*  444 */         str2 = null;
/*      */       } 
/*      */       
/*  447 */       String numeric = str.substring(0, str.length() - 1);
/*  448 */       boolean bool = (isAllZeros(str1) && isAllZeros(str2));
/*  449 */       switch (lastChar) {
/*      */         case 'L':
/*      */         case 'l':
/*  452 */           if (object == null && str2 == null && ((numeric.charAt(0) == '-' && isDigits(numeric.substring(1))) || isDigits(numeric))) {
/*      */             
/*      */             try {
/*      */               
/*  456 */               return createLong(numeric);
/*  457 */             } catch (NumberFormatException nfe) {
/*      */ 
/*      */               
/*  460 */               return createBigInteger(numeric);
/*      */             } 
/*      */           }
/*  463 */           throw new NumberFormatException(str + " is not a valid number.");
/*      */         case 'F':
/*      */         case 'f':
/*      */           try {
/*  467 */             Float f = createFloat(numeric);
/*  468 */             if (!f.isInfinite() && (f.floatValue() != 0.0F || bool))
/*      */             {
/*      */               
/*  471 */               return f;
/*      */             }
/*      */           }
/*  474 */           catch (NumberFormatException nfe) {}
/*      */ 
/*      */ 
/*      */         
/*      */         case 'D':
/*      */         case 'd':
/*      */           try {
/*  481 */             Double d = createDouble(numeric);
/*  482 */             if (!d.isInfinite() && (d.floatValue() != 0.0D || bool)) {
/*  483 */               return d;
/*      */             }
/*  485 */           } catch (NumberFormatException nfe) {}
/*      */ 
/*      */           
/*      */           try {
/*  489 */             return createBigDecimal(numeric);
/*  490 */           } catch (NumberFormatException e) {
/*      */             break;
/*      */           } 
/*      */       } 
/*      */       
/*  495 */       throw new NumberFormatException(str + " is not a valid number.");
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  501 */     if (expPos > -1 && expPos < str.length() - 1) {
/*  502 */       str2 = str.substring(expPos + 1, str.length());
/*      */     } else {
/*  504 */       str2 = null;
/*      */     } 
/*  506 */     if (object == null && str2 == null) {
/*      */       
/*      */       try {
/*  509 */         return createInteger(str);
/*  510 */       } catch (NumberFormatException nfe) {
/*      */ 
/*      */         
/*      */         try {
/*  514 */           return createLong(str);
/*  515 */         } catch (NumberFormatException numberFormatException) {
/*      */ 
/*      */           
/*  518 */           return createBigInteger(str);
/*      */         } 
/*      */       } 
/*      */     }
/*  522 */     boolean allZeros = (isAllZeros(str1) && isAllZeros(str2));
/*      */     try {
/*  524 */       Float f = createFloat(str);
/*  525 */       if (!f.isInfinite() && (f.floatValue() != 0.0F || allZeros)) {
/*  526 */         return f;
/*      */       }
/*  528 */     } catch (NumberFormatException nfe) {}
/*      */ 
/*      */     
/*      */     try {
/*  532 */       Double d = createDouble(str);
/*  533 */       if (!d.isInfinite() && (d.doubleValue() != 0.0D || allZeros)) {
/*  534 */         return d;
/*      */       }
/*  536 */     } catch (NumberFormatException nfe) {}
/*      */ 
/*      */ 
/*      */     
/*  540 */     return createBigDecimal(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static boolean isAllZeros(String str) {
/*  555 */     if (str == null) {
/*  556 */       return true;
/*      */     }
/*  558 */     for (int i = str.length() - 1; i >= 0; i--) {
/*  559 */       if (str.charAt(i) != '0') {
/*  560 */         return false;
/*      */       }
/*      */     } 
/*  563 */     return (str.length() > 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Float createFloat(String str) {
/*  577 */     if (str == null) {
/*  578 */       return null;
/*      */     }
/*  580 */     return Float.valueOf(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Double createDouble(String str) {
/*  593 */     if (str == null) {
/*  594 */       return null;
/*      */     }
/*  596 */     return Double.valueOf(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Integer createInteger(String str) {
/*  610 */     if (str == null) {
/*  611 */       return null;
/*      */     }
/*      */     
/*  614 */     return Integer.decode(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static Long createLong(String str) {
/*  627 */     if (str == null) {
/*  628 */       return null;
/*      */     }
/*  630 */     return Long.valueOf(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BigInteger createBigInteger(String str) {
/*  643 */     if (str == null) {
/*  644 */       return null;
/*      */     }
/*  646 */     return new BigInteger(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static BigDecimal createBigDecimal(String str) {
/*  659 */     if (str == null) {
/*  660 */       return null;
/*      */     }
/*      */     
/*  663 */     if (StringUtils.isBlank(str)) {
/*  664 */       throw new NumberFormatException("A blank string is not a valid number");
/*      */     }
/*  666 */     return new BigDecimal(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long min(long[] array) {
/*  681 */     if (array == null)
/*  682 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  683 */     if (array.length == 0) {
/*  684 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/*  688 */     long min = array[0];
/*  689 */     for (int i = 1; i < array.length; i++) {
/*  690 */       if (array[i] < min) {
/*  691 */         min = array[i];
/*      */       }
/*      */     } 
/*      */     
/*  695 */     return min;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int min(int[] array) {
/*  708 */     if (array == null)
/*  709 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  710 */     if (array.length == 0) {
/*  711 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/*  715 */     int min = array[0];
/*  716 */     for (int j = 1; j < array.length; j++) {
/*  717 */       if (array[j] < min) {
/*  718 */         min = array[j];
/*      */       }
/*      */     } 
/*      */     
/*  722 */     return min;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static short min(short[] array) {
/*  735 */     if (array == null)
/*  736 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  737 */     if (array.length == 0) {
/*  738 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/*  742 */     short min = array[0];
/*  743 */     for (int i = 1; i < array.length; i++) {
/*  744 */       if (array[i] < min) {
/*  745 */         min = array[i];
/*      */       }
/*      */     } 
/*      */     
/*  749 */     return min;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte min(byte[] array) {
/*  762 */     if (array == null)
/*  763 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  764 */     if (array.length == 0) {
/*  765 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/*  769 */     byte min = array[0];
/*  770 */     for (int i = 1; i < array.length; i++) {
/*  771 */       if (array[i] < min) {
/*  772 */         min = array[i];
/*      */       }
/*      */     } 
/*      */     
/*  776 */     return min;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static double min(double[] array) {
/*  789 */     if (array == null)
/*  790 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  791 */     if (array.length == 0) {
/*  792 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/*  796 */     double min = array[0];
/*  797 */     for (int i = 1; i < array.length; i++) {
/*  798 */       if (array[i] < min) {
/*  799 */         min = array[i];
/*      */       }
/*      */     } 
/*      */     
/*  803 */     return min;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float min(float[] array) {
/*  816 */     if (array == null)
/*  817 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  818 */     if (array.length == 0) {
/*  819 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/*  823 */     float min = array[0];
/*  824 */     for (int i = 1; i < array.length; i++) {
/*  825 */       if (array[i] < min) {
/*  826 */         min = array[i];
/*      */       }
/*      */     } 
/*      */     
/*  830 */     return min;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long max(long[] array) {
/*  845 */     if (array == null)
/*  846 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  847 */     if (array.length == 0) {
/*  848 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/*  852 */     long max = array[0];
/*  853 */     for (int j = 1; j < array.length; j++) {
/*  854 */       if (array[j] > max) {
/*  855 */         max = array[j];
/*      */       }
/*      */     } 
/*      */     
/*  859 */     return max;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int max(int[] array) {
/*  872 */     if (array == null)
/*  873 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  874 */     if (array.length == 0) {
/*  875 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/*  879 */     int max = array[0];
/*  880 */     for (int j = 1; j < array.length; j++) {
/*  881 */       if (array[j] > max) {
/*  882 */         max = array[j];
/*      */       }
/*      */     } 
/*      */     
/*  886 */     return max;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static short max(short[] array) {
/*  899 */     if (array == null)
/*  900 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  901 */     if (array.length == 0) {
/*  902 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/*  906 */     short max = array[0];
/*  907 */     for (int i = 1; i < array.length; i++) {
/*  908 */       if (array[i] > max) {
/*  909 */         max = array[i];
/*      */       }
/*      */     } 
/*      */     
/*  913 */     return max;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte max(byte[] array) {
/*  926 */     if (array == null)
/*  927 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  928 */     if (array.length == 0) {
/*  929 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/*  933 */     byte max = array[0];
/*  934 */     for (int i = 1; i < array.length; i++) {
/*  935 */       if (array[i] > max) {
/*  936 */         max = array[i];
/*      */       }
/*      */     } 
/*      */     
/*  940 */     return max;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static double max(double[] array) {
/*  953 */     if (array == null)
/*  954 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  955 */     if (array.length == 0) {
/*  956 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/*  960 */     double max = array[0];
/*  961 */     for (int j = 1; j < array.length; j++) {
/*  962 */       if (array[j] > max) {
/*  963 */         max = array[j];
/*      */       }
/*      */     } 
/*      */     
/*  967 */     return max;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float max(float[] array) {
/*  980 */     if (array == null)
/*  981 */       throw new IllegalArgumentException("The Array must not be null"); 
/*  982 */     if (array.length == 0) {
/*  983 */       throw new IllegalArgumentException("Array cannot be empty.");
/*      */     }
/*      */ 
/*      */     
/*  987 */     float max = array[0];
/*  988 */     for (int j = 1; j < array.length; j++) {
/*  989 */       if (array[j] > max) {
/*  990 */         max = array[j];
/*      */       }
/*      */     } 
/*      */     
/*  994 */     return max;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long min(long a, long b, long c) {
/* 1008 */     if (b < a) {
/* 1009 */       a = b;
/*      */     }
/* 1011 */     if (c < a) {
/* 1012 */       a = c;
/*      */     }
/* 1014 */     return a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int min(int a, int b, int c) {
/* 1026 */     if (b < a) {
/* 1027 */       a = b;
/*      */     }
/* 1029 */     if (c < a) {
/* 1030 */       a = c;
/*      */     }
/* 1032 */     return a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static short min(short a, short b, short c) {
/* 1044 */     if (b < a) {
/* 1045 */       a = b;
/*      */     }
/* 1047 */     if (c < a) {
/* 1048 */       a = c;
/*      */     }
/* 1050 */     return a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte min(byte a, byte b, byte c) {
/* 1062 */     if (b < a) {
/* 1063 */       a = b;
/*      */     }
/* 1065 */     if (c < a) {
/* 1066 */       a = c;
/*      */     }
/* 1068 */     return a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static double min(double a, double b, double c) {
/* 1083 */     return Math.min(Math.min(a, b), c);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float min(float a, float b, float c) {
/* 1098 */     return Math.min(Math.min(a, b), c);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static long max(long a, long b, long c) {
/* 1112 */     if (b > a) {
/* 1113 */       a = b;
/*      */     }
/* 1115 */     if (c > a) {
/* 1116 */       a = c;
/*      */     }
/* 1118 */     return a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int max(int a, int b, int c) {
/* 1130 */     if (b > a) {
/* 1131 */       a = b;
/*      */     }
/* 1133 */     if (c > a) {
/* 1134 */       a = c;
/*      */     }
/* 1136 */     return a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static short max(short a, short b, short c) {
/* 1148 */     if (b > a) {
/* 1149 */       a = b;
/*      */     }
/* 1151 */     if (c > a) {
/* 1152 */       a = c;
/*      */     }
/* 1154 */     return a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static byte max(byte a, byte b, byte c) {
/* 1166 */     if (b > a) {
/* 1167 */       a = b;
/*      */     }
/* 1169 */     if (c > a) {
/* 1170 */       a = c;
/*      */     }
/* 1172 */     return a;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static double max(double a, double b, double c) {
/* 1187 */     return Math.max(Math.max(a, b), c);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static float max(float a, float b, float c) {
/* 1202 */     return Math.max(Math.max(a, b), c);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int compare(double lhs, double rhs) {
/* 1241 */     if (lhs < rhs) {
/* 1242 */       return -1;
/*      */     }
/* 1244 */     if (lhs > rhs) {
/* 1245 */       return 1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1251 */     long lhsBits = Double.doubleToLongBits(lhs);
/* 1252 */     long rhsBits = Double.doubleToLongBits(rhs);
/* 1253 */     if (lhsBits == rhsBits) {
/* 1254 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1262 */     if (lhsBits < rhsBits) {
/* 1263 */       return -1;
/*      */     }
/* 1265 */     return 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int compare(float lhs, float rhs) {
/* 1302 */     if (lhs < rhs) {
/* 1303 */       return -1;
/*      */     }
/* 1305 */     if (lhs > rhs) {
/* 1306 */       return 1;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1312 */     int lhsBits = Float.floatToIntBits(lhs);
/* 1313 */     int rhsBits = Float.floatToIntBits(rhs);
/* 1314 */     if (lhsBits == rhsBits) {
/* 1315 */       return 0;
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1323 */     if (lhsBits < rhsBits) {
/* 1324 */       return -1;
/*      */     }
/* 1326 */     return 1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isDigits(String str) {
/* 1342 */     if (StringUtils.isEmpty(str)) {
/* 1343 */       return false;
/*      */     }
/* 1345 */     for (int i = 0; i < str.length(); i++) {
/* 1346 */       if (!Character.isDigit(str.charAt(i))) {
/* 1347 */         return false;
/*      */       }
/*      */     } 
/* 1350 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNumber(String str) {
/* 1367 */     if (StringUtils.isEmpty(str)) {
/* 1368 */       return false;
/*      */     }
/* 1370 */     char[] chars = str.toCharArray();
/* 1371 */     int sz = chars.length;
/* 1372 */     boolean hasExp = false;
/* 1373 */     boolean hasDecPoint = false;
/* 1374 */     boolean allowSigns = false;
/* 1375 */     boolean foundDigit = false;
/*      */     
/* 1377 */     int start = (chars[0] == '-') ? 1 : 0;
/* 1378 */     if (sz > start + 1 && 
/* 1379 */       chars[start] == '0' && chars[start + 1] == 'x') {
/* 1380 */       int j = start + 2;
/* 1381 */       if (j == sz) {
/* 1382 */         return false;
/*      */       }
/*      */       
/* 1385 */       for (; j < chars.length; j++) {
/* 1386 */         if ((chars[j] < '0' || chars[j] > '9') && (chars[j] < 'a' || chars[j] > 'f') && (chars[j] < 'A' || chars[j] > 'F'))
/*      */         {
/*      */           
/* 1389 */           return false;
/*      */         }
/*      */       } 
/* 1392 */       return true;
/*      */     } 
/*      */     
/* 1395 */     sz--;
/*      */     
/* 1397 */     int i = start;
/*      */ 
/*      */     
/* 1400 */     while (i < sz || (i < sz + 1 && allowSigns && !foundDigit)) {
/* 1401 */       if (chars[i] >= '0' && chars[i] <= '9') {
/* 1402 */         foundDigit = true;
/* 1403 */         allowSigns = false;
/*      */       }
/* 1405 */       else if (chars[i] == '.') {
/* 1406 */         if (hasDecPoint || hasExp)
/*      */         {
/* 1408 */           return false;
/*      */         }
/* 1410 */         hasDecPoint = true;
/* 1411 */       } else if (chars[i] == 'e' || chars[i] == 'E') {
/*      */         
/* 1413 */         if (hasExp)
/*      */         {
/* 1415 */           return false;
/*      */         }
/* 1417 */         if (!foundDigit) {
/* 1418 */           return false;
/*      */         }
/* 1420 */         hasExp = true;
/* 1421 */         allowSigns = true;
/* 1422 */       } else if (chars[i] == '+' || chars[i] == '-') {
/* 1423 */         if (!allowSigns) {
/* 1424 */           return false;
/*      */         }
/* 1426 */         allowSigns = false;
/* 1427 */         foundDigit = false;
/*      */       } else {
/* 1429 */         return false;
/*      */       } 
/* 1431 */       i++;
/*      */     } 
/* 1433 */     if (i < chars.length) {
/* 1434 */       if (chars[i] >= '0' && chars[i] <= '9')
/*      */       {
/* 1436 */         return true;
/*      */       }
/* 1438 */       if (chars[i] == 'e' || chars[i] == 'E')
/*      */       {
/* 1440 */         return false;
/*      */       }
/* 1442 */       if (!allowSigns && (chars[i] == 'd' || chars[i] == 'D' || chars[i] == 'f' || chars[i] == 'F'))
/*      */       {
/*      */ 
/*      */ 
/*      */         
/* 1447 */         return foundDigit;
/*      */       }
/* 1449 */       if (chars[i] == 'l' || chars[i] == 'L')
/*      */       {
/*      */         
/* 1452 */         return (foundDigit && !hasExp);
/*      */       }
/*      */       
/* 1455 */       return false;
/*      */     } 
/*      */ 
/*      */     
/* 1459 */     return (!allowSigns && foundDigit);
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\math\NumberUtils.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */