/*      */ package org.apache.commons.lang;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collection;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public class StringUtils
/*      */ {
/*      */   public static final String EMPTY = "";
/*      */   public static final int INDEX_NOT_FOUND = -1;
/*      */   private static final int PAD_LIMIT = 8192;
/*      */   
/*      */   public static boolean isEmpty(String str) {
/*  185 */     return (str == null || str.length() == 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotEmpty(String str) {
/*  203 */     return !isEmpty(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isBlank(String str) {
/*      */     int strLen;
/*  223 */     if (str == null || (strLen = str.length()) == 0) {
/*  224 */       return true;
/*      */     }
/*  226 */     for (int i = 0; i < strLen; i++) {
/*  227 */       if (!Character.isWhitespace(str.charAt(i))) {
/*  228 */         return false;
/*      */       }
/*      */     } 
/*  231 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNotBlank(String str) {
/*  251 */     return !isBlank(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String clean(String str) {
/*  276 */     return (str == null) ? "" : str.trim();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String trim(String str) {
/*  303 */     return (str == null) ? null : str.trim();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String trimToNull(String str) {
/*  329 */     String ts = trim(str);
/*  330 */     return isEmpty(ts) ? null : ts;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String trimToEmpty(String str) {
/*  355 */     return (str == null) ? "" : str.trim();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String strip(String str) {
/*  383 */     return strip(str, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String stripToNull(String str) {
/*  410 */     if (str == null) {
/*  411 */       return null;
/*      */     }
/*  413 */     str = strip(str, null);
/*  414 */     return (str.length() == 0) ? null : str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String stripToEmpty(String str) {
/*  440 */     return (str == null) ? "" : strip(str, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String strip(String str, String stripChars) {
/*  470 */     if (isEmpty(str)) {
/*  471 */       return str;
/*      */     }
/*  473 */     str = stripStart(str, stripChars);
/*  474 */     return stripEnd(str, stripChars);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String stripStart(String str, String stripChars) {
/*      */     int strLen;
/*  503 */     if (str == null || (strLen = str.length()) == 0) {
/*  504 */       return str;
/*      */     }
/*  506 */     int start = 0;
/*  507 */     if (stripChars == null) {
/*  508 */       while (start != strLen && Character.isWhitespace(str.charAt(start)))
/*  509 */         start++; 
/*      */     } else {
/*  511 */       if (stripChars.length() == 0) {
/*  512 */         return str;
/*      */       }
/*  514 */       while (start != strLen && stripChars.indexOf(str.charAt(start)) != -1) {
/*  515 */         start++;
/*      */       }
/*      */     } 
/*  518 */     return str.substring(start);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String stripEnd(String str, String stripChars) {
/*      */     int end;
/*  547 */     if (str == null || (end = str.length()) == 0) {
/*  548 */       return str;
/*      */     }
/*      */     
/*  551 */     if (stripChars == null) {
/*  552 */       while (end != 0 && Character.isWhitespace(str.charAt(end - 1)))
/*  553 */         end--; 
/*      */     } else {
/*  555 */       if (stripChars.length() == 0) {
/*  556 */         return str;
/*      */       }
/*  558 */       while (end != 0 && stripChars.indexOf(str.charAt(end - 1)) != -1) {
/*  559 */         end--;
/*      */       }
/*      */     } 
/*  562 */     return str.substring(0, end);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] stripAll(String[] strs) {
/*  587 */     return stripAll(strs, null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] stripAll(String[] strs, String stripChars) {
/*      */     int strsLen;
/*  617 */     if (strs == null || (strsLen = strs.length) == 0) {
/*  618 */       return strs;
/*      */     }
/*  620 */     String[] newArr = new String[strsLen];
/*  621 */     for (int i = 0; i < strsLen; i++) {
/*  622 */       newArr[i] = strip(strs[i], stripChars);
/*      */     }
/*  624 */     return newArr;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean equals(String str1, String str2) {
/*  650 */     return (str1 == null) ? ((str2 == null)) : str1.equals(str2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean equalsIgnoreCase(String str1, String str2) {
/*  675 */     return (str1 == null) ? ((str2 == null)) : str1.equalsIgnoreCase(str2);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOf(String str, char searchChar) {
/*  700 */     if (isEmpty(str)) {
/*  701 */       return -1;
/*      */     }
/*  703 */     return str.indexOf(searchChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOf(String str, char searchChar, int startPos) {
/*  732 */     if (isEmpty(str)) {
/*  733 */       return -1;
/*      */     }
/*  735 */     return str.indexOf(searchChar, startPos);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOf(String str, String searchStr) {
/*  761 */     if (str == null || searchStr == null) {
/*  762 */       return -1;
/*      */     }
/*  764 */     return str.indexOf(searchStr);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int ordinalIndexOf(String str, String searchStr, int ordinal) {
/*  795 */     if (str == null || searchStr == null || ordinal <= 0) {
/*  796 */       return -1;
/*      */     }
/*  798 */     if (searchStr.length() == 0) {
/*  799 */       return 0;
/*      */     }
/*  801 */     int found = 0;
/*  802 */     int index = -1;
/*      */     while (true) {
/*  804 */       index = str.indexOf(searchStr, index + 1);
/*  805 */       if (index < 0) {
/*  806 */         return index;
/*      */       }
/*  808 */       found++;
/*  809 */       if (found >= ordinal) {
/*  810 */         return index;
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
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOf(String str, String searchStr, int startPos) {
/*  845 */     if (str == null || searchStr == null) {
/*  846 */       return -1;
/*      */     }
/*      */     
/*  849 */     if (searchStr.length() == 0 && startPos >= str.length()) {
/*  850 */       return str.length();
/*      */     }
/*  852 */     return str.indexOf(searchStr, startPos);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int lastIndexOf(String str, char searchChar) {
/*  877 */     if (isEmpty(str)) {
/*  878 */       return -1;
/*      */     }
/*  880 */     return str.lastIndexOf(searchChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int lastIndexOf(String str, char searchChar, int startPos) {
/*  911 */     if (isEmpty(str)) {
/*  912 */       return -1;
/*      */     }
/*  914 */     return str.lastIndexOf(searchChar, startPos);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int lastIndexOf(String str, String searchStr) {
/*  940 */     if (str == null || searchStr == null) {
/*  941 */       return -1;
/*      */     }
/*  943 */     return str.lastIndexOf(searchStr);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int lastIndexOf(String str, String searchStr, int startPos) {
/*  975 */     if (str == null || searchStr == null) {
/*  976 */       return -1;
/*      */     }
/*  978 */     return str.lastIndexOf(searchStr, startPos);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean contains(String str, char searchChar) {
/* 1003 */     if (isEmpty(str)) {
/* 1004 */       return false;
/*      */     }
/* 1006 */     return (str.indexOf(searchChar) >= 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean contains(String str, String searchStr) {
/* 1031 */     if (str == null || searchStr == null) {
/* 1032 */       return false;
/*      */     }
/* 1034 */     return (str.indexOf(searchStr) >= 0);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean containsIgnoreCase(String str, String searchStr) {
/* 1061 */     if (str == null || searchStr == null) {
/* 1062 */       return false;
/*      */     }
/* 1064 */     return contains(str.toUpperCase(), searchStr.toUpperCase());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOfAny(String str, char[] searchChars) {
/* 1092 */     if (isEmpty(str) || ArrayUtils.isEmpty(searchChars)) {
/* 1093 */       return -1;
/*      */     }
/* 1095 */     for (int i = 0; i < str.length(); i++) {
/* 1096 */       char ch = str.charAt(i);
/* 1097 */       for (int j = 0; j < searchChars.length; j++) {
/* 1098 */         if (searchChars[j] == ch) {
/* 1099 */           return i;
/*      */         }
/*      */       } 
/*      */     } 
/* 1103 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOfAny(String str, String searchChars) {
/* 1129 */     if (isEmpty(str) || isEmpty(searchChars)) {
/* 1130 */       return -1;
/*      */     }
/* 1132 */     return indexOfAny(str, searchChars.toCharArray());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOfAnyBut(String str, char[] searchChars) {
/* 1160 */     if (isEmpty(str) || ArrayUtils.isEmpty(searchChars)) {
/* 1161 */       return -1;
/*      */     }
/* 1163 */     for (int i = 0; i < str.length(); i++) {
/* 1164 */       char ch = str.charAt(i);
/* 1165 */       int j = 0; while (true) { if (j >= searchChars.length)
/*      */         {
/*      */ 
/*      */ 
/*      */           
/* 1170 */           return i; }  if (searchChars[j] == ch)
/*      */           break;  j++; } 
/* 1172 */     }  return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOfAnyBut(String str, String searchChars) {
/* 1198 */     if (isEmpty(str) || isEmpty(searchChars)) {
/* 1199 */       return -1;
/*      */     }
/* 1201 */     for (int i = 0; i < str.length(); i++) {
/* 1202 */       if (searchChars.indexOf(str.charAt(i)) < 0) {
/* 1203 */         return i;
/*      */       }
/*      */     } 
/* 1206 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean containsOnly(String str, char[] valid) {
/* 1234 */     if (valid == null || str == null) {
/* 1235 */       return false;
/*      */     }
/* 1237 */     if (str.length() == 0) {
/* 1238 */       return true;
/*      */     }
/* 1240 */     if (valid.length == 0) {
/* 1241 */       return false;
/*      */     }
/* 1243 */     return (indexOfAnyBut(str, valid) == -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean containsOnly(String str, String validChars) {
/* 1269 */     if (str == null || validChars == null) {
/* 1270 */       return false;
/*      */     }
/* 1272 */     return containsOnly(str, validChars.toCharArray());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean containsNone(String str, char[] invalidChars) {
/* 1300 */     if (str == null || invalidChars == null) {
/* 1301 */       return true;
/*      */     }
/* 1303 */     int strSize = str.length();
/* 1304 */     int validSize = invalidChars.length;
/* 1305 */     for (int i = 0; i < strSize; i++) {
/* 1306 */       char ch = str.charAt(i);
/* 1307 */       for (int j = 0; j < validSize; j++) {
/* 1308 */         if (invalidChars[j] == ch) {
/* 1309 */           return false;
/*      */         }
/*      */       } 
/*      */     } 
/* 1313 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean containsNone(String str, String invalidChars) {
/* 1339 */     if (str == null || invalidChars == null) {
/* 1340 */       return true;
/*      */     }
/* 1342 */     return containsNone(str, invalidChars.toCharArray());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOfAny(String str, String[] searchStrs) {
/* 1374 */     if (str == null || searchStrs == null) {
/* 1375 */       return -1;
/*      */     }
/* 1377 */     int sz = searchStrs.length;
/*      */ 
/*      */     
/* 1380 */     int ret = Integer.MAX_VALUE;
/*      */     
/* 1382 */     int tmp = 0;
/* 1383 */     for (int i = 0; i < sz; i++) {
/* 1384 */       String search = searchStrs[i];
/* 1385 */       if (search != null) {
/*      */ 
/*      */         
/* 1388 */         tmp = str.indexOf(search);
/* 1389 */         if (tmp != -1)
/*      */         {
/*      */ 
/*      */           
/* 1393 */           if (tmp < ret)
/* 1394 */             ret = tmp; 
/*      */         }
/*      */       } 
/*      */     } 
/* 1398 */     return (ret == Integer.MAX_VALUE) ? -1 : ret;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int lastIndexOfAny(String str, String[] searchStrs) {
/* 1427 */     if (str == null || searchStrs == null) {
/* 1428 */       return -1;
/*      */     }
/* 1430 */     int sz = searchStrs.length;
/* 1431 */     int ret = -1;
/* 1432 */     int tmp = 0;
/* 1433 */     for (int i = 0; i < sz; i++) {
/* 1434 */       String search = searchStrs[i];
/* 1435 */       if (search != null) {
/*      */ 
/*      */         
/* 1438 */         tmp = str.lastIndexOf(search);
/* 1439 */         if (tmp > ret)
/* 1440 */           ret = tmp; 
/*      */       } 
/*      */     } 
/* 1443 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String substring(String str, int start) {
/* 1473 */     if (str == null) {
/* 1474 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 1478 */     if (start < 0) {
/* 1479 */       start = str.length() + start;
/*      */     }
/*      */     
/* 1482 */     if (start < 0) {
/* 1483 */       start = 0;
/*      */     }
/* 1485 */     if (start > str.length()) {
/* 1486 */       return "";
/*      */     }
/*      */     
/* 1489 */     return str.substring(start);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String substring(String str, int start, int end) {
/* 1528 */     if (str == null) {
/* 1529 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 1533 */     if (end < 0) {
/* 1534 */       end = str.length() + end;
/*      */     }
/* 1536 */     if (start < 0) {
/* 1537 */       start = str.length() + start;
/*      */     }
/*      */ 
/*      */     
/* 1541 */     if (end > str.length()) {
/* 1542 */       end = str.length();
/*      */     }
/*      */ 
/*      */     
/* 1546 */     if (start > end) {
/* 1547 */       return "";
/*      */     }
/*      */     
/* 1550 */     if (start < 0) {
/* 1551 */       start = 0;
/*      */     }
/* 1553 */     if (end < 0) {
/* 1554 */       end = 0;
/*      */     }
/*      */     
/* 1557 */     return str.substring(start, end);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String left(String str, int len) {
/* 1583 */     if (str == null) {
/* 1584 */       return null;
/*      */     }
/* 1586 */     if (len < 0) {
/* 1587 */       return "";
/*      */     }
/* 1589 */     if (str.length() <= len) {
/* 1590 */       return str;
/*      */     }
/* 1592 */     return str.substring(0, len);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String right(String str, int len) {
/* 1617 */     if (str == null) {
/* 1618 */       return null;
/*      */     }
/* 1620 */     if (len < 0) {
/* 1621 */       return "";
/*      */     }
/* 1623 */     if (str.length() <= len) {
/* 1624 */       return str;
/*      */     }
/* 1626 */     return str.substring(str.length() - len);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String mid(String str, int pos, int len) {
/* 1655 */     if (str == null) {
/* 1656 */       return null;
/*      */     }
/* 1658 */     if (len < 0 || pos > str.length()) {
/* 1659 */       return "";
/*      */     }
/* 1661 */     if (pos < 0) {
/* 1662 */       pos = 0;
/*      */     }
/* 1664 */     if (str.length() <= pos + len) {
/* 1665 */       return str.substring(pos);
/*      */     }
/* 1667 */     return str.substring(pos, pos + len);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String substringBefore(String str, String separator) {
/* 1699 */     if (isEmpty(str) || separator == null) {
/* 1700 */       return str;
/*      */     }
/* 1702 */     if (separator.length() == 0) {
/* 1703 */       return "";
/*      */     }
/* 1705 */     int pos = str.indexOf(separator);
/* 1706 */     if (pos == -1) {
/* 1707 */       return str;
/*      */     }
/* 1709 */     return str.substring(0, pos);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String substringAfter(String str, String separator) {
/* 1739 */     if (isEmpty(str)) {
/* 1740 */       return str;
/*      */     }
/* 1742 */     if (separator == null) {
/* 1743 */       return "";
/*      */     }
/* 1745 */     int pos = str.indexOf(separator);
/* 1746 */     if (pos == -1) {
/* 1747 */       return "";
/*      */     }
/* 1749 */     return str.substring(pos + separator.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String substringBeforeLast(String str, String separator) {
/* 1778 */     if (isEmpty(str) || isEmpty(separator)) {
/* 1779 */       return str;
/*      */     }
/* 1781 */     int pos = str.lastIndexOf(separator);
/* 1782 */     if (pos == -1) {
/* 1783 */       return str;
/*      */     }
/* 1785 */     return str.substring(0, pos);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String substringAfterLast(String str, String separator) {
/* 1816 */     if (isEmpty(str)) {
/* 1817 */       return str;
/*      */     }
/* 1819 */     if (isEmpty(separator)) {
/* 1820 */       return "";
/*      */     }
/* 1822 */     int pos = str.lastIndexOf(separator);
/* 1823 */     if (pos == -1 || pos == str.length() - separator.length()) {
/* 1824 */       return "";
/*      */     }
/* 1826 */     return str.substring(pos + separator.length());
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String substringBetween(String str, String tag) {
/* 1853 */     return substringBetween(str, tag, tag);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String substringBetween(String str, String open, String close) {
/* 1884 */     if (str == null || open == null || close == null) {
/* 1885 */       return null;
/*      */     }
/* 1887 */     int start = str.indexOf(open);
/* 1888 */     if (start != -1) {
/* 1889 */       int end = str.indexOf(close, start + open.length());
/* 1890 */       if (end != -1) {
/* 1891 */         return str.substring(start + open.length(), end);
/*      */       }
/*      */     } 
/* 1894 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] substringsBetween(String str, String open, String close) {
/* 1920 */     if (str == null || isEmpty(open) || isEmpty(close)) {
/* 1921 */       return null;
/*      */     }
/* 1923 */     int strLen = str.length();
/* 1924 */     if (strLen == 0) {
/* 1925 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*      */     }
/* 1927 */     int closeLen = close.length();
/* 1928 */     int openLen = open.length();
/* 1929 */     List list = new ArrayList();
/* 1930 */     int pos = 0;
/* 1931 */     while (pos < strLen - closeLen) {
/* 1932 */       int start = str.indexOf(open, pos);
/* 1933 */       if (start < 0) {
/*      */         break;
/*      */       }
/* 1936 */       start += openLen;
/* 1937 */       int end = str.indexOf(close, start);
/* 1938 */       if (end < 0) {
/*      */         break;
/*      */       }
/* 1941 */       list.add(str.substring(start, end));
/* 1942 */       pos = end + closeLen;
/*      */     } 
/* 1944 */     if (list.size() > 0) {
/* 1945 */       return list.<String>toArray(new String[list.size()]);
/*      */     }
/* 1947 */     return null;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getNestedString(String str, String tag) {
/* 1976 */     return substringBetween(str, tag, tag);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getNestedString(String str, String open, String close) {
/* 2006 */     return substringBetween(str, open, close);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] split(String str) {
/* 2034 */     return split(str, null, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] split(String str, char separatorChar) {
/* 2064 */     return splitWorker(str, separatorChar, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] split(String str, String separatorChars) {
/* 2093 */     return splitWorker(str, separatorChars, -1, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] split(String str, String separatorChars, int max) {
/* 2127 */     return splitWorker(str, separatorChars, max, false);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] splitByWholeSeparator(String str, String separator) {
/* 2154 */     return splitByWholeSeparator(str, separator, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] splitByWholeSeparator(String str, String separator, int max) {
/* 2185 */     if (str == null) {
/* 2186 */       return null;
/*      */     }
/*      */     
/* 2189 */     int len = str.length();
/*      */     
/* 2191 */     if (len == 0) {
/* 2192 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*      */     }
/*      */     
/* 2195 */     if (separator == null || "".equals(separator))
/*      */     {
/* 2197 */       return split(str, null, max);
/*      */     }
/*      */ 
/*      */     
/* 2201 */     int separatorLength = separator.length();
/*      */     
/* 2203 */     ArrayList substrings = new ArrayList();
/* 2204 */     int numberOfSubstrings = 0;
/* 2205 */     int beg = 0;
/* 2206 */     int end = 0;
/* 2207 */     while (end < len) {
/* 2208 */       end = str.indexOf(separator, beg);
/*      */       
/* 2210 */       if (end > -1) {
/* 2211 */         if (end > beg) {
/* 2212 */           numberOfSubstrings++;
/*      */           
/* 2214 */           if (numberOfSubstrings == max) {
/* 2215 */             end = len;
/* 2216 */             substrings.add(str.substring(beg));
/*      */             
/*      */             continue;
/*      */           } 
/* 2220 */           substrings.add(str.substring(beg, end));
/*      */ 
/*      */ 
/*      */ 
/*      */           
/* 2225 */           beg = end + separatorLength;
/*      */           
/*      */           continue;
/*      */         } 
/* 2229 */         beg = end + separatorLength;
/*      */         
/*      */         continue;
/*      */       } 
/* 2233 */       substrings.add(str.substring(beg));
/* 2234 */       end = len;
/*      */     } 
/*      */ 
/*      */     
/* 2238 */     return substrings.<String>toArray(new String[substrings.size()]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] splitPreserveAllTokens(String str) {
/* 2268 */     return splitWorker(str, null, -1, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] splitPreserveAllTokens(String str, char separatorChar) {
/* 2304 */     return splitWorker(str, separatorChar, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String[] splitWorker(String str, char separatorChar, boolean preserveAllTokens) {
/* 2322 */     if (str == null) {
/* 2323 */       return null;
/*      */     }
/* 2325 */     int len = str.length();
/* 2326 */     if (len == 0) {
/* 2327 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*      */     }
/* 2329 */     List list = new ArrayList();
/* 2330 */     int i = 0, start = 0;
/* 2331 */     boolean match = false;
/* 2332 */     boolean lastMatch = false;
/* 2333 */     while (i < len) {
/* 2334 */       if (str.charAt(i) == separatorChar) {
/* 2335 */         if (match || preserveAllTokens) {
/* 2336 */           list.add(str.substring(start, i));
/* 2337 */           match = false;
/* 2338 */           lastMatch = true;
/*      */         } 
/* 2340 */         start = ++i;
/*      */         continue;
/*      */       } 
/* 2343 */       lastMatch = false;
/*      */       
/* 2345 */       match = true;
/* 2346 */       i++;
/*      */     } 
/* 2348 */     if (match || (preserveAllTokens && lastMatch)) {
/* 2349 */       list.add(str.substring(start, i));
/*      */     }
/* 2351 */     return list.<String>toArray(new String[list.size()]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] splitPreserveAllTokens(String str, String separatorChars) {
/* 2388 */     return splitWorker(str, separatorChars, -1, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String[] splitPreserveAllTokens(String str, String separatorChars, int max) {
/* 2428 */     return splitWorker(str, separatorChars, max, true);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String[] splitWorker(String str, String separatorChars, int max, boolean preserveAllTokens) {
/* 2450 */     if (str == null) {
/* 2451 */       return null;
/*      */     }
/* 2453 */     int len = str.length();
/* 2454 */     if (len == 0) {
/* 2455 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*      */     }
/* 2457 */     List list = new ArrayList();
/* 2458 */     int sizePlus1 = 1;
/* 2459 */     int i = 0, start = 0;
/* 2460 */     boolean match = false;
/* 2461 */     boolean lastMatch = false;
/* 2462 */     if (separatorChars == null) {
/*      */       
/* 2464 */       while (i < len) {
/* 2465 */         if (Character.isWhitespace(str.charAt(i))) {
/* 2466 */           if (match || preserveAllTokens) {
/* 2467 */             lastMatch = true;
/* 2468 */             if (sizePlus1++ == max) {
/* 2469 */               i = len;
/* 2470 */               lastMatch = false;
/*      */             } 
/* 2472 */             list.add(str.substring(start, i));
/* 2473 */             match = false;
/*      */           } 
/* 2475 */           start = ++i;
/*      */           continue;
/*      */         } 
/* 2478 */         lastMatch = false;
/*      */         
/* 2480 */         match = true;
/* 2481 */         i++;
/*      */       } 
/* 2483 */     } else if (separatorChars.length() == 1) {
/*      */       
/* 2485 */       char sep = separatorChars.charAt(0);
/* 2486 */       while (i < len) {
/* 2487 */         if (str.charAt(i) == sep) {
/* 2488 */           if (match || preserveAllTokens) {
/* 2489 */             lastMatch = true;
/* 2490 */             if (sizePlus1++ == max) {
/* 2491 */               i = len;
/* 2492 */               lastMatch = false;
/*      */             } 
/* 2494 */             list.add(str.substring(start, i));
/* 2495 */             match = false;
/*      */           } 
/* 2497 */           start = ++i;
/*      */           continue;
/*      */         } 
/* 2500 */         lastMatch = false;
/*      */         
/* 2502 */         match = true;
/* 2503 */         i++;
/*      */       } 
/*      */     } else {
/*      */       
/* 2507 */       while (i < len) {
/* 2508 */         if (separatorChars.indexOf(str.charAt(i)) >= 0) {
/* 2509 */           if (match || preserveAllTokens) {
/* 2510 */             lastMatch = true;
/* 2511 */             if (sizePlus1++ == max) {
/* 2512 */               i = len;
/* 2513 */               lastMatch = false;
/*      */             } 
/* 2515 */             list.add(str.substring(start, i));
/* 2516 */             match = false;
/*      */           } 
/* 2518 */           start = ++i;
/*      */           continue;
/*      */         } 
/* 2521 */         lastMatch = false;
/*      */         
/* 2523 */         match = true;
/* 2524 */         i++;
/*      */       } 
/*      */     } 
/* 2527 */     if (match || (preserveAllTokens && lastMatch)) {
/* 2528 */       list.add(str.substring(start, i));
/*      */     }
/* 2530 */     return list.<String>toArray(new String[list.size()]);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String concatenate(Object[] array) {
/* 2554 */     return join(array, (String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(Object[] array) {
/* 2578 */     return join(array, (String)null);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(Object[] array, char separator) {
/* 2604 */     if (array == null) {
/* 2605 */       return null;
/*      */     }
/*      */     
/* 2608 */     return join(array, separator, 0, array.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(Object[] array, char separator, int startIndex, int endIndex) {
/* 2638 */     if (array == null) {
/* 2639 */       return null;
/*      */     }
/* 2641 */     int bufSize = endIndex - startIndex;
/* 2642 */     if (bufSize <= 0) {
/* 2643 */       return "";
/*      */     }
/*      */     
/* 2646 */     bufSize *= ((array[startIndex] == null) ? 16 : array[startIndex].toString().length()) + 1;
/* 2647 */     StringBuffer buf = new StringBuffer(bufSize);
/*      */     
/* 2649 */     for (int i = startIndex; i < endIndex; i++) {
/* 2650 */       if (i > startIndex) {
/* 2651 */         buf.append(separator);
/*      */       }
/* 2653 */       if (array[i] != null) {
/* 2654 */         buf.append(array[i]);
/*      */       }
/*      */     } 
/* 2657 */     return buf.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(Object[] array, String separator) {
/* 2685 */     if (array == null) {
/* 2686 */       return null;
/*      */     }
/* 2688 */     return join(array, separator, 0, array.length);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(Object[] array, String separator, int startIndex, int endIndex) {
/* 2719 */     if (array == null) {
/* 2720 */       return null;
/*      */     }
/* 2722 */     if (separator == null) {
/* 2723 */       separator = "";
/*      */     }
/*      */ 
/*      */ 
/*      */     
/* 2728 */     int bufSize = endIndex - startIndex;
/* 2729 */     if (bufSize <= 0) {
/* 2730 */       return "";
/*      */     }
/*      */     
/* 2733 */     bufSize *= ((array[startIndex] == null) ? 16 : array[startIndex].toString().length()) + separator.length();
/*      */ 
/*      */     
/* 2736 */     StringBuffer buf = new StringBuffer(bufSize);
/*      */     
/* 2738 */     for (int i = startIndex; i < endIndex; i++) {
/* 2739 */       if (i > startIndex) {
/* 2740 */         buf.append(separator);
/*      */       }
/* 2742 */       if (array[i] != null) {
/* 2743 */         buf.append(array[i]);
/*      */       }
/*      */     } 
/* 2746 */     return buf.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(Iterator iterator, char separator) {
/* 2766 */     if (iterator == null) {
/* 2767 */       return null;
/*      */     }
/* 2769 */     if (!iterator.hasNext()) {
/* 2770 */       return "";
/*      */     }
/* 2772 */     Object first = iterator.next();
/* 2773 */     if (!iterator.hasNext()) {
/* 2774 */       return ObjectUtils.toString(first);
/*      */     }
/*      */ 
/*      */     
/* 2778 */     StringBuffer buf = new StringBuffer(256);
/* 2779 */     if (first != null) {
/* 2780 */       buf.append(first);
/*      */     }
/*      */     
/* 2783 */     while (iterator.hasNext()) {
/* 2784 */       buf.append(separator);
/* 2785 */       Object obj = iterator.next();
/* 2786 */       if (obj != null) {
/* 2787 */         buf.append(obj);
/*      */       }
/*      */     } 
/*      */     
/* 2791 */     return buf.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(Iterator iterator, String separator) {
/* 2810 */     if (iterator == null) {
/* 2811 */       return null;
/*      */     }
/* 2813 */     if (!iterator.hasNext()) {
/* 2814 */       return "";
/*      */     }
/* 2816 */     Object first = iterator.next();
/* 2817 */     if (!iterator.hasNext()) {
/* 2818 */       return ObjectUtils.toString(first);
/*      */     }
/*      */ 
/*      */     
/* 2822 */     StringBuffer buf = new StringBuffer(256);
/* 2823 */     if (first != null) {
/* 2824 */       buf.append(first);
/*      */     }
/*      */     
/* 2827 */     while (iterator.hasNext()) {
/* 2828 */       if (separator != null) {
/* 2829 */         buf.append(separator);
/*      */       }
/* 2831 */       Object obj = iterator.next();
/* 2832 */       if (obj != null) {
/* 2833 */         buf.append(obj);
/*      */       }
/*      */     } 
/* 2836 */     return buf.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(Collection collection, char separator) {
/* 2854 */     if (collection == null) {
/* 2855 */       return null;
/*      */     }
/* 2857 */     return join(collection.iterator(), separator);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String join(Collection collection, String separator) {
/* 2875 */     if (collection == null) {
/* 2876 */       return null;
/*      */     }
/* 2878 */     return join(collection.iterator(), separator);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String deleteSpaces(String str) {
/* 2910 */     if (str == null) {
/* 2911 */       return null;
/*      */     }
/* 2913 */     return CharSetUtils.delete(str, " \t\r\n\b");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String deleteWhitespace(String str) {
/* 2931 */     if (isEmpty(str)) {
/* 2932 */       return str;
/*      */     }
/* 2934 */     int sz = str.length();
/* 2935 */     char[] chs = new char[sz];
/* 2936 */     int count = 0;
/* 2937 */     for (int i = 0; i < sz; i++) {
/* 2938 */       if (!Character.isWhitespace(str.charAt(i))) {
/* 2939 */         chs[count++] = str.charAt(i);
/*      */       }
/*      */     } 
/* 2942 */     if (count == sz) {
/* 2943 */       return str;
/*      */     }
/* 2945 */     return new String(chs, 0, count);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String removeStart(String str, String remove) {
/* 2975 */     if (isEmpty(str) || isEmpty(remove)) {
/* 2976 */       return str;
/*      */     }
/* 2978 */     if (str.startsWith(remove)) {
/* 2979 */       return str.substring(remove.length());
/*      */     }
/* 2981 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String removeEnd(String str, String remove) {
/* 3009 */     if (isEmpty(str) || isEmpty(remove)) {
/* 3010 */       return str;
/*      */     }
/* 3012 */     if (str.endsWith(remove)) {
/* 3013 */       return str.substring(0, str.length() - remove.length());
/*      */     }
/* 3015 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String remove(String str, String remove) {
/* 3042 */     if (isEmpty(str) || isEmpty(remove)) {
/* 3043 */       return str;
/*      */     }
/* 3045 */     return replace(str, remove, "", -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String remove(String str, char remove) {
/* 3068 */     if (isEmpty(str) || str.indexOf(remove) == -1) {
/* 3069 */       return str;
/*      */     }
/* 3071 */     char[] chars = str.toCharArray();
/* 3072 */     int pos = 0;
/* 3073 */     for (int i = 0; i < chars.length; i++) {
/* 3074 */       if (chars[i] != remove) {
/* 3075 */         chars[pos++] = chars[i];
/*      */       }
/*      */     } 
/* 3078 */     return new String(chars, 0, pos);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String replaceOnce(String text, String repl, String with) {
/* 3107 */     return replace(text, repl, with, 1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String replace(String text, String repl, String with) {
/* 3134 */     return replace(text, repl, with, -1);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String replace(String text, String repl, String with, int max) {
/* 3166 */     if (isEmpty(text) || isEmpty(repl) || with == null || max == 0) {
/* 3167 */       return text;
/*      */     }
/* 3169 */     int start = 0;
/* 3170 */     int end = text.indexOf(repl, start);
/* 3171 */     if (end == -1) {
/* 3172 */       return text;
/*      */     }
/* 3174 */     int replLength = repl.length();
/* 3175 */     int increase = with.length() - replLength;
/* 3176 */     increase = (increase < 0) ? 0 : increase;
/* 3177 */     increase *= (max < 0) ? 16 : ((max > 64) ? 64 : max);
/* 3178 */     StringBuffer buf = new StringBuffer(text.length() + increase);
/* 3179 */     while (end != -1) {
/* 3180 */       buf.append(text.substring(start, end)).append(with);
/* 3181 */       start = end + replLength;
/* 3182 */       if (--max == 0) {
/*      */         break;
/*      */       }
/* 3185 */       end = text.indexOf(repl, start);
/*      */     } 
/* 3187 */     buf.append(text.substring(start));
/* 3188 */     return buf.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String replaceChars(String str, char searchChar, char replaceChar) {
/* 3214 */     if (str == null) {
/* 3215 */       return null;
/*      */     }
/* 3217 */     return str.replace(searchChar, replaceChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String replaceChars(String str, String searchChars, String replaceChars) {
/* 3257 */     if (isEmpty(str) || isEmpty(searchChars)) {
/* 3258 */       return str;
/*      */     }
/* 3260 */     if (replaceChars == null) {
/* 3261 */       replaceChars = "";
/*      */     }
/* 3263 */     boolean modified = false;
/* 3264 */     int replaceCharsLength = replaceChars.length();
/* 3265 */     int strLength = str.length();
/* 3266 */     StringBuffer buf = new StringBuffer(strLength);
/* 3267 */     for (int i = 0; i < strLength; i++) {
/* 3268 */       char ch = str.charAt(i);
/* 3269 */       int index = searchChars.indexOf(ch);
/* 3270 */       if (index >= 0) {
/* 3271 */         modified = true;
/* 3272 */         if (index < replaceCharsLength) {
/* 3273 */           buf.append(replaceChars.charAt(index));
/*      */         }
/*      */       } else {
/* 3276 */         buf.append(ch);
/*      */       } 
/*      */     } 
/* 3279 */     if (modified) {
/* 3280 */       return buf.toString();
/*      */     }
/* 3282 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String overlayString(String text, String overlay, int start, int end) {
/* 3314 */     return (new StringBuffer(start + overlay.length() + text.length() - end + 1)).append(text.substring(0, start)).append(overlay).append(text.substring(end)).toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String overlay(String str, String overlay, int start, int end) {
/* 3351 */     if (str == null) {
/* 3352 */       return null;
/*      */     }
/* 3354 */     if (overlay == null) {
/* 3355 */       overlay = "";
/*      */     }
/* 3357 */     int len = str.length();
/* 3358 */     if (start < 0) {
/* 3359 */       start = 0;
/*      */     }
/* 3361 */     if (start > len) {
/* 3362 */       start = len;
/*      */     }
/* 3364 */     if (end < 0) {
/* 3365 */       end = 0;
/*      */     }
/* 3367 */     if (end > len) {
/* 3368 */       end = len;
/*      */     }
/* 3370 */     if (start > end) {
/* 3371 */       int temp = start;
/* 3372 */       start = end;
/* 3373 */       end = temp;
/*      */     } 
/* 3375 */     return (new StringBuffer(len + start - end + overlay.length() + 1)).append(str.substring(0, start)).append(overlay).append(str.substring(end)).toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String chomp(String str) {
/* 3410 */     if (isEmpty(str)) {
/* 3411 */       return str;
/*      */     }
/*      */     
/* 3414 */     if (str.length() == 1) {
/* 3415 */       char ch = str.charAt(0);
/* 3416 */       if (ch == '\r' || ch == '\n') {
/* 3417 */         return "";
/*      */       }
/* 3419 */       return str;
/*      */     } 
/*      */ 
/*      */     
/* 3423 */     int lastIdx = str.length() - 1;
/* 3424 */     char last = str.charAt(lastIdx);
/*      */     
/* 3426 */     if (last == '\n') {
/* 3427 */       if (str.charAt(lastIdx - 1) == '\r') {
/* 3428 */         lastIdx--;
/*      */       }
/* 3430 */     } else if (last != '\r') {
/* 3431 */       lastIdx++;
/*      */     } 
/* 3433 */     return str.substring(0, lastIdx);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String chomp(String str, String separator) {
/* 3463 */     if (isEmpty(str) || separator == null) {
/* 3464 */       return str;
/*      */     }
/* 3466 */     if (str.endsWith(separator)) {
/* 3467 */       return str.substring(0, str.length() - separator.length());
/*      */     }
/* 3469 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String chompLast(String str) {
/* 3483 */     return chompLast(str, "\n");
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String chompLast(String str, String sep) {
/* 3497 */     if (str.length() == 0) {
/* 3498 */       return str;
/*      */     }
/* 3500 */     String sub = str.substring(str.length() - sep.length());
/* 3501 */     if (sep.equals(sub)) {
/* 3502 */       return str.substring(0, str.length() - sep.length());
/*      */     }
/* 3504 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getChomp(String str, String sep) {
/* 3521 */     int idx = str.lastIndexOf(sep);
/* 3522 */     if (idx == str.length() - sep.length())
/* 3523 */       return sep; 
/* 3524 */     if (idx != -1) {
/* 3525 */       return str.substring(idx);
/*      */     }
/* 3527 */     return "";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String prechomp(String str, String sep) {
/* 3543 */     int idx = str.indexOf(sep);
/* 3544 */     if (idx != -1) {
/* 3545 */       return str.substring(idx + sep.length());
/*      */     }
/* 3547 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String getPrechomp(String str, String sep) {
/* 3564 */     int idx = str.indexOf(sep);
/* 3565 */     if (idx != -1) {
/* 3566 */       return str.substring(0, idx + sep.length());
/*      */     }
/* 3568 */     return "";
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String chop(String str) {
/* 3598 */     if (str == null) {
/* 3599 */       return null;
/*      */     }
/* 3601 */     int strLen = str.length();
/* 3602 */     if (strLen < 2) {
/* 3603 */       return "";
/*      */     }
/* 3605 */     int lastIdx = strLen - 1;
/* 3606 */     String ret = str.substring(0, lastIdx);
/* 3607 */     char last = str.charAt(lastIdx);
/* 3608 */     if (last == '\n' && 
/* 3609 */       ret.charAt(lastIdx - 1) == '\r') {
/* 3610 */       return ret.substring(0, lastIdx - 1);
/*      */     }
/*      */     
/* 3613 */     return ret;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String chopNewline(String str) {
/* 3627 */     int lastIdx = str.length() - 1;
/* 3628 */     if (lastIdx <= 0) {
/* 3629 */       return "";
/*      */     }
/* 3631 */     char last = str.charAt(lastIdx);
/* 3632 */     if (last == '\n') {
/* 3633 */       if (str.charAt(lastIdx - 1) == '\r') {
/* 3634 */         lastIdx--;
/*      */       }
/*      */     } else {
/* 3637 */       lastIdx++;
/*      */     } 
/* 3639 */     return str.substring(0, lastIdx);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String escape(String str) {
/* 3661 */     return StringEscapeUtils.escapeJava(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String repeat(String str, int repeat) {
/*      */     char ch, output1[];
/*      */     int i;
/*      */     char ch0, ch1, output2[];
/*      */     int j;
/* 3687 */     if (str == null) {
/* 3688 */       return null;
/*      */     }
/* 3690 */     if (repeat <= 0) {
/* 3691 */       return "";
/*      */     }
/* 3693 */     int inputLength = str.length();
/* 3694 */     if (repeat == 1 || inputLength == 0) {
/* 3695 */       return str;
/*      */     }
/* 3697 */     if (inputLength == 1 && repeat <= 8192) {
/* 3698 */       return padding(repeat, str.charAt(0));
/*      */     }
/*      */     
/* 3701 */     int outputLength = inputLength * repeat;
/* 3702 */     switch (inputLength) {
/*      */       case 1:
/* 3704 */         ch = str.charAt(0);
/* 3705 */         output1 = new char[outputLength];
/* 3706 */         for (i = repeat - 1; i >= 0; i--) {
/* 3707 */           output1[i] = ch;
/*      */         }
/* 3709 */         return new String(output1);
/*      */       case 2:
/* 3711 */         ch0 = str.charAt(0);
/* 3712 */         ch1 = str.charAt(1);
/* 3713 */         output2 = new char[outputLength];
/* 3714 */         for (j = repeat * 2 - 2; j >= 0; j--, j--) {
/* 3715 */           output2[j] = ch0;
/* 3716 */           output2[j + 1] = ch1;
/*      */         } 
/* 3718 */         return new String(output2);
/*      */     } 
/* 3720 */     StringBuffer buf = new StringBuffer(outputLength);
/* 3721 */     for (int k = 0; k < repeat; k++) {
/* 3722 */       buf.append(str);
/*      */     }
/* 3724 */     return buf.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private static String padding(int repeat, char padChar) throws IndexOutOfBoundsException {
/* 3752 */     if (repeat < 0) {
/* 3753 */       throw new IndexOutOfBoundsException("Cannot pad a negative amount: " + repeat);
/*      */     }
/* 3755 */     char[] buf = new char[repeat];
/* 3756 */     for (int i = 0; i < buf.length; i++) {
/* 3757 */       buf[i] = padChar;
/*      */     }
/* 3759 */     return new String(buf);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String rightPad(String str, int size) {
/* 3782 */     return rightPad(str, size, ' ');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String rightPad(String str, int size, char padChar) {
/* 3807 */     if (str == null) {
/* 3808 */       return null;
/*      */     }
/* 3810 */     int pads = size - str.length();
/* 3811 */     if (pads <= 0) {
/* 3812 */       return str;
/*      */     }
/* 3814 */     if (pads > 8192) {
/* 3815 */       return rightPad(str, size, String.valueOf(padChar));
/*      */     }
/* 3817 */     return str.concat(padding(pads, padChar));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String rightPad(String str, int size, String padStr) {
/* 3844 */     if (str == null) {
/* 3845 */       return null;
/*      */     }
/* 3847 */     if (isEmpty(padStr)) {
/* 3848 */       padStr = " ";
/*      */     }
/* 3850 */     int padLen = padStr.length();
/* 3851 */     int strLen = str.length();
/* 3852 */     int pads = size - strLen;
/* 3853 */     if (pads <= 0) {
/* 3854 */       return str;
/*      */     }
/* 3856 */     if (padLen == 1 && pads <= 8192) {
/* 3857 */       return rightPad(str, size, padStr.charAt(0));
/*      */     }
/*      */     
/* 3860 */     if (pads == padLen)
/* 3861 */       return str.concat(padStr); 
/* 3862 */     if (pads < padLen) {
/* 3863 */       return str.concat(padStr.substring(0, pads));
/*      */     }
/* 3865 */     char[] padding = new char[pads];
/* 3866 */     char[] padChars = padStr.toCharArray();
/* 3867 */     for (int i = 0; i < pads; i++) {
/* 3868 */       padding[i] = padChars[i % padLen];
/*      */     }
/* 3870 */     return str.concat(new String(padding));
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String leftPad(String str, int size) {
/* 3894 */     return leftPad(str, size, ' ');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String leftPad(String str, int size, char padChar) {
/* 3919 */     if (str == null) {
/* 3920 */       return null;
/*      */     }
/* 3922 */     int pads = size - str.length();
/* 3923 */     if (pads <= 0) {
/* 3924 */       return str;
/*      */     }
/* 3926 */     if (pads > 8192) {
/* 3927 */       return leftPad(str, size, String.valueOf(padChar));
/*      */     }
/* 3929 */     return padding(pads, padChar).concat(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String leftPad(String str, int size, String padStr) {
/* 3956 */     if (str == null) {
/* 3957 */       return null;
/*      */     }
/* 3959 */     if (isEmpty(padStr)) {
/* 3960 */       padStr = " ";
/*      */     }
/* 3962 */     int padLen = padStr.length();
/* 3963 */     int strLen = str.length();
/* 3964 */     int pads = size - strLen;
/* 3965 */     if (pads <= 0) {
/* 3966 */       return str;
/*      */     }
/* 3968 */     if (padLen == 1 && pads <= 8192) {
/* 3969 */       return leftPad(str, size, padStr.charAt(0));
/*      */     }
/*      */     
/* 3972 */     if (pads == padLen)
/* 3973 */       return padStr.concat(str); 
/* 3974 */     if (pads < padLen) {
/* 3975 */       return padStr.substring(0, pads).concat(str);
/*      */     }
/* 3977 */     char[] padding = new char[pads];
/* 3978 */     char[] padChars = padStr.toCharArray();
/* 3979 */     for (int i = 0; i < pads; i++) {
/* 3980 */       padding[i] = padChars[i % padLen];
/*      */     }
/* 3982 */     return (new String(padding)).concat(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String center(String str, int size) {
/* 4012 */     return center(str, size, ' ');
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String center(String str, int size, char padChar) {
/* 4040 */     if (str == null || size <= 0) {
/* 4041 */       return str;
/*      */     }
/* 4043 */     int strLen = str.length();
/* 4044 */     int pads = size - strLen;
/* 4045 */     if (pads <= 0) {
/* 4046 */       return str;
/*      */     }
/* 4048 */     str = leftPad(str, strLen + pads / 2, padChar);
/* 4049 */     str = rightPad(str, size, padChar);
/* 4050 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String center(String str, int size, String padStr) {
/* 4080 */     if (str == null || size <= 0) {
/* 4081 */       return str;
/*      */     }
/* 4083 */     if (isEmpty(padStr)) {
/* 4084 */       padStr = " ";
/*      */     }
/* 4086 */     int strLen = str.length();
/* 4087 */     int pads = size - strLen;
/* 4088 */     if (pads <= 0) {
/* 4089 */       return str;
/*      */     }
/* 4091 */     str = leftPad(str, strLen + pads / 2, padStr);
/* 4092 */     str = rightPad(str, size, padStr);
/* 4093 */     return str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String upperCase(String str) {
/* 4113 */     if (str == null) {
/* 4114 */       return null;
/*      */     }
/* 4116 */     return str.toUpperCase();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String lowerCase(String str) {
/* 4134 */     if (str == null) {
/* 4135 */       return null;
/*      */     }
/* 4137 */     return str.toLowerCase();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String capitalize(String str) {
/*      */     int strLen;
/* 4162 */     if (str == null || (strLen = str.length()) == 0) {
/* 4163 */       return str;
/*      */     }
/* 4165 */     return (new StringBuffer(strLen)).append(Character.toTitleCase(str.charAt(0))).append(str.substring(1)).toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String capitalise(String str) {
/* 4181 */     return capitalize(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String uncapitalize(String str) {
/*      */     int strLen;
/* 4206 */     if (str == null || (strLen = str.length()) == 0) {
/* 4207 */       return str;
/*      */     }
/* 4209 */     return (new StringBuffer(strLen)).append(Character.toLowerCase(str.charAt(0))).append(str.substring(1)).toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String uncapitalise(String str) {
/* 4225 */     return uncapitalize(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String swapCase(String str) {
/*      */     int strLen;
/* 4257 */     if (str == null || (strLen = str.length()) == 0) {
/* 4258 */       return str;
/*      */     }
/* 4260 */     StringBuffer buffer = new StringBuffer(strLen);
/*      */     
/* 4262 */     char ch = Character.MIN_VALUE;
/* 4263 */     for (int i = 0; i < strLen; i++) {
/* 4264 */       ch = str.charAt(i);
/* 4265 */       if (Character.isUpperCase(ch)) {
/* 4266 */         ch = Character.toLowerCase(ch);
/* 4267 */       } else if (Character.isTitleCase(ch)) {
/* 4268 */         ch = Character.toLowerCase(ch);
/* 4269 */       } else if (Character.isLowerCase(ch)) {
/* 4270 */         ch = Character.toUpperCase(ch);
/*      */       } 
/* 4272 */       buffer.append(ch);
/*      */     } 
/* 4274 */     return buffer.toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String capitaliseAllWords(String str) {
/* 4290 */     return WordUtils.capitalize(str);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int countMatches(String str, String sub) {
/* 4315 */     if (isEmpty(str) || isEmpty(sub)) {
/* 4316 */       return 0;
/*      */     }
/* 4318 */     int count = 0;
/* 4319 */     int idx = 0;
/* 4320 */     while ((idx = str.indexOf(sub, idx)) != -1) {
/* 4321 */       count++;
/* 4322 */       idx += sub.length();
/*      */     } 
/* 4324 */     return count;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAlpha(String str) {
/* 4348 */     if (str == null) {
/* 4349 */       return false;
/*      */     }
/* 4351 */     int sz = str.length();
/* 4352 */     for (int i = 0; i < sz; i++) {
/* 4353 */       if (!Character.isLetter(str.charAt(i))) {
/* 4354 */         return false;
/*      */       }
/*      */     } 
/* 4357 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAlphaSpace(String str) {
/* 4382 */     if (str == null) {
/* 4383 */       return false;
/*      */     }
/* 4385 */     int sz = str.length();
/* 4386 */     for (int i = 0; i < sz; i++) {
/* 4387 */       if (!Character.isLetter(str.charAt(i)) && str.charAt(i) != ' ') {
/* 4388 */         return false;
/*      */       }
/*      */     } 
/* 4391 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAlphanumeric(String str) {
/* 4415 */     if (str == null) {
/* 4416 */       return false;
/*      */     }
/* 4418 */     int sz = str.length();
/* 4419 */     for (int i = 0; i < sz; i++) {
/* 4420 */       if (!Character.isLetterOrDigit(str.charAt(i))) {
/* 4421 */         return false;
/*      */       }
/*      */     } 
/* 4424 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAlphanumericSpace(String str) {
/* 4449 */     if (str == null) {
/* 4450 */       return false;
/*      */     }
/* 4452 */     int sz = str.length();
/* 4453 */     for (int i = 0; i < sz; i++) {
/* 4454 */       if (!Character.isLetterOrDigit(str.charAt(i)) && str.charAt(i) != ' ') {
/* 4455 */         return false;
/*      */       }
/*      */     } 
/* 4458 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isAsciiPrintable(String str) {
/* 4487 */     if (str == null) {
/* 4488 */       return false;
/*      */     }
/* 4490 */     int sz = str.length();
/* 4491 */     for (int i = 0; i < sz; i++) {
/* 4492 */       if (!CharUtils.isAsciiPrintable(str.charAt(i))) {
/* 4493 */         return false;
/*      */       }
/*      */     } 
/* 4496 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNumeric(String str) {
/* 4521 */     if (str == null) {
/* 4522 */       return false;
/*      */     }
/* 4524 */     int sz = str.length();
/* 4525 */     for (int i = 0; i < sz; i++) {
/* 4526 */       if (!Character.isDigit(str.charAt(i))) {
/* 4527 */         return false;
/*      */       }
/*      */     } 
/* 4530 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isNumericSpace(String str) {
/* 4557 */     if (str == null) {
/* 4558 */       return false;
/*      */     }
/* 4560 */     int sz = str.length();
/* 4561 */     for (int i = 0; i < sz; i++) {
/* 4562 */       if (!Character.isDigit(str.charAt(i)) && str.charAt(i) != ' ') {
/* 4563 */         return false;
/*      */       }
/*      */     } 
/* 4566 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static boolean isWhitespace(String str) {
/* 4589 */     if (str == null) {
/* 4590 */       return false;
/*      */     }
/* 4592 */     int sz = str.length();
/* 4593 */     for (int i = 0; i < sz; i++) {
/* 4594 */       if (!Character.isWhitespace(str.charAt(i))) {
/* 4595 */         return false;
/*      */       }
/*      */     } 
/* 4598 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String defaultString(String str) {
/* 4620 */     return (str == null) ? "" : str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String defaultString(String str, String defaultStr) {
/* 4641 */     return (str == null) ? defaultStr : str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String defaultIfEmpty(String str, String defaultStr) {
/* 4661 */     return isEmpty(str) ? defaultStr : str;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String reverse(String str) {
/* 4681 */     if (str == null) {
/* 4682 */       return null;
/*      */     }
/* 4684 */     return (new StringBuffer(str)).reverse().toString();
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String reverseDelimited(String str, char separatorChar) {
/* 4707 */     if (str == null) {
/* 4708 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 4712 */     String[] strs = split(str, separatorChar);
/* 4713 */     ArrayUtils.reverse((Object[])strs);
/* 4714 */     return join((Object[])strs, separatorChar);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String reverseDelimitedString(String str, String separatorChars) {
/* 4740 */     if (str == null) {
/* 4741 */       return null;
/*      */     }
/*      */ 
/*      */     
/* 4745 */     String[] strs = split(str, separatorChars);
/* 4746 */     ArrayUtils.reverse((Object[])strs);
/* 4747 */     if (separatorChars == null) {
/* 4748 */       return join((Object[])strs, ' ');
/*      */     }
/* 4750 */     return join((Object[])strs, separatorChars);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String abbreviate(String str, int maxWidth) {
/* 4788 */     return abbreviate(str, 0, maxWidth);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String abbreviate(String str, int offset, int maxWidth) {
/* 4827 */     if (str == null) {
/* 4828 */       return null;
/*      */     }
/* 4830 */     if (maxWidth < 4) {
/* 4831 */       throw new IllegalArgumentException("Minimum abbreviation width is 4");
/*      */     }
/* 4833 */     if (str.length() <= maxWidth) {
/* 4834 */       return str;
/*      */     }
/* 4836 */     if (offset > str.length()) {
/* 4837 */       offset = str.length();
/*      */     }
/* 4839 */     if (str.length() - offset < maxWidth - 3) {
/* 4840 */       offset = str.length() - maxWidth - 3;
/*      */     }
/* 4842 */     if (offset <= 4) {
/* 4843 */       return str.substring(0, maxWidth - 3) + "...";
/*      */     }
/* 4845 */     if (maxWidth < 7) {
/* 4846 */       throw new IllegalArgumentException("Minimum abbreviation width with offset is 7");
/*      */     }
/* 4848 */     if (offset + maxWidth - 3 < str.length()) {
/* 4849 */       return "..." + abbreviate(str.substring(offset), maxWidth - 3);
/*      */     }
/* 4851 */     return "..." + str.substring(str.length() - maxWidth - 3);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static String difference(String str1, String str2) {
/* 4882 */     if (str1 == null) {
/* 4883 */       return str2;
/*      */     }
/* 4885 */     if (str2 == null) {
/* 4886 */       return str1;
/*      */     }
/* 4888 */     int at = indexOfDifference(str1, str2);
/* 4889 */     if (at == -1) {
/* 4890 */       return "";
/*      */     }
/* 4892 */     return str2.substring(at);
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int indexOfDifference(String str1, String str2) {
/* 4919 */     if (str1 == str2) {
/* 4920 */       return -1;
/*      */     }
/* 4922 */     if (str1 == null || str2 == null) {
/* 4923 */       return 0;
/*      */     }
/*      */     int i;
/* 4926 */     for (i = 0; i < str1.length() && i < str2.length() && 
/* 4927 */       str1.charAt(i) == str2.charAt(i); i++);
/*      */ 
/*      */ 
/*      */     
/* 4931 */     if (i < str2.length() || i < str1.length()) {
/* 4932 */       return i;
/*      */     }
/* 4934 */     return -1;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static int getLevenshteinDistance(String s, String t) {
/* 4974 */     if (s == null || t == null) {
/* 4975 */       throw new IllegalArgumentException("Strings must not be null");
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 4995 */     int n = s.length();
/* 4996 */     int m = t.length();
/*      */     
/* 4998 */     if (n == 0)
/* 4999 */       return m; 
/* 5000 */     if (m == 0) {
/* 5001 */       return n;
/*      */     }
/*      */     
/* 5004 */     int[] p = new int[n + 1];
/* 5005 */     int[] d = new int[n + 1];
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     int i;
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 5016 */     for (i = 0; i <= n; i++) {
/* 5017 */       p[i] = i;
/*      */     }
/*      */     
/* 5020 */     for (int j = 1; j <= m; j++) {
/* 5021 */       char t_j = t.charAt(j - 1);
/* 5022 */       d[0] = j;
/*      */       
/* 5024 */       for (i = 1; i <= n; i++) {
/* 5025 */         int cost = (s.charAt(i - 1) == t_j) ? 0 : 1;
/*      */         
/* 5027 */         d[i] = Math.min(Math.min(d[i - 1] + 1, p[i] + 1), p[i - 1] + cost);
/*      */       } 
/*      */ 
/*      */       
/* 5031 */       int[] _d = p;
/* 5032 */       p = d;
/* 5033 */       d = _d;
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 5038 */     return p[n];
/*      */   }
/*      */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\StringUtils.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */