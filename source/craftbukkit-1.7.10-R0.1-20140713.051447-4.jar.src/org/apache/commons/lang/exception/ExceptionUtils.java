/*     */ package org.apache.commons.lang.exception;
/*     */ 
/*     */ import java.io.PrintStream;
/*     */ import java.io.PrintWriter;
/*     */ import java.io.StringWriter;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Arrays;
/*     */ import java.util.List;
/*     */ import java.util.StringTokenizer;
/*     */ import org.apache.commons.lang.ArrayUtils;
/*     */ import org.apache.commons.lang.ClassUtils;
/*     */ import org.apache.commons.lang.NullArgumentException;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ import org.apache.commons.lang.SystemUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ExceptionUtils
/*     */ {
/*     */   static final String WRAPPED_MARKER = " [wrapped] ";
/*     */   
/*     */   static {
/*     */     Method method;
/*     */   }
/*     */   
/*  62 */   private static String[] CAUSE_METHOD_NAMES = new String[] { "getCause", "getNextException", "getTargetException", "getException", "getSourceException", "getRootCause", "getCausedByException", "getNested", "getLinkedException", "getNestedException", "getLinkedCause", "getThrowable" };
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final Method THROWABLE_CAUSE_METHOD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final Method THROWABLE_INITCAUSE_METHOD;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static {
/*     */     try {
/*  90 */       method = Throwable.class.getMethod("getCause", null);
/*     */     } catch (Exception e) {
/*  92 */       method = null;
/*     */     } 
/*  94 */     THROWABLE_CAUSE_METHOD = method;
/*     */     try {
/*  96 */       method = Throwable.class.getMethod("initCause", new Class[] { Throwable.class });
/*     */     } catch (Exception e) {
/*  98 */       method = null;
/*     */     } 
/* 100 */     THROWABLE_INITCAUSE_METHOD = method;
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
/*     */   public static void addCauseMethodName(String methodName) {
/* 123 */     if (StringUtils.isNotEmpty(methodName) && !isCauseMethodName(methodName)) {
/* 124 */       List list = getCauseMethodNameList();
/* 125 */       if (list.add(methodName)) {
/* 126 */         CAUSE_METHOD_NAMES = toArray(list);
/*     */       }
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
/*     */   public static void removeCauseMethodName(String methodName) {
/* 140 */     if (StringUtils.isNotEmpty(methodName)) {
/* 141 */       List list = getCauseMethodNameList();
/* 142 */       if (list.remove(methodName)) {
/* 143 */         CAUSE_METHOD_NAMES = toArray(list);
/*     */       }
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
/*     */   public static boolean setCause(Throwable target, Throwable cause) {
/* 177 */     if (target == null) {
/* 178 */       throw new NullArgumentException("target");
/*     */     }
/* 180 */     Object[] causeArgs = { cause };
/* 181 */     boolean modifiedTarget = false;
/* 182 */     if (THROWABLE_INITCAUSE_METHOD != null) {
/*     */       try {
/* 184 */         THROWABLE_INITCAUSE_METHOD.invoke(target, causeArgs);
/* 185 */         modifiedTarget = true;
/* 186 */       } catch (IllegalAccessException ignored) {
/*     */       
/* 188 */       } catch (InvocationTargetException ignored) {}
/*     */     }
/*     */ 
/*     */     
/*     */     try {
/* 193 */       Method setCauseMethod = target.getClass().getMethod("setCause", new Class[] { Throwable.class });
/* 194 */       setCauseMethod.invoke(target, causeArgs);
/* 195 */       modifiedTarget = true;
/* 196 */     } catch (NoSuchMethodException ignored) {
/*     */     
/* 198 */     } catch (IllegalAccessException ignored) {
/*     */     
/* 200 */     } catch (InvocationTargetException ignored) {}
/*     */ 
/*     */     
/* 203 */     return modifiedTarget;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static String[] toArray(List list) {
/* 212 */     return (String[])list.toArray((Object[])new String[list.size()]);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static ArrayList getCauseMethodNameList() {
/* 221 */     return new ArrayList(Arrays.asList((Object[])CAUSE_METHOD_NAMES));
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
/*     */   public static boolean isCauseMethodName(String methodName) {
/* 234 */     return (ArrayUtils.indexOf((Object[])CAUSE_METHOD_NAMES, methodName) >= 0);
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
/*     */   public static Throwable getCause(Throwable throwable) {
/* 270 */     return getCause(throwable, CAUSE_METHOD_NAMES);
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
/*     */   public static Throwable getCause(Throwable throwable, String[] methodNames) {
/* 292 */     if (throwable == null) {
/* 293 */       return null;
/*     */     }
/* 295 */     Throwable cause = getCauseUsingWellKnownTypes(throwable);
/* 296 */     if (cause == null) {
/* 297 */       if (methodNames == null) {
/* 298 */         methodNames = CAUSE_METHOD_NAMES;
/*     */       }
/* 300 */       for (int i = 0; i < methodNames.length; i++) {
/* 301 */         String methodName = methodNames[i];
/* 302 */         if (methodName != null) {
/* 303 */           cause = getCauseUsingMethodName(throwable, methodName);
/* 304 */           if (cause != null) {
/*     */             break;
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 310 */       if (cause == null) {
/* 311 */         cause = getCauseUsingFieldName(throwable, "detail");
/*     */       }
/*     */     } 
/* 314 */     return cause;
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
/*     */   public static Throwable getRootCause(Throwable throwable) {
/* 335 */     List list = getThrowableList(throwable);
/* 336 */     return (list.size() < 2) ? null : list.get(list.size() - 1);
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
/*     */   private static Throwable getCauseUsingWellKnownTypes(Throwable throwable) {
/* 350 */     if (throwable instanceof Nestable)
/* 351 */       return ((Nestable)throwable).getCause(); 
/* 352 */     if (throwable instanceof SQLException)
/* 353 */       return ((SQLException)throwable).getNextException(); 
/* 354 */     if (throwable instanceof InvocationTargetException) {
/* 355 */       return ((InvocationTargetException)throwable).getTargetException();
/*     */     }
/* 357 */     return null;
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
/*     */   private static Throwable getCauseUsingMethodName(Throwable throwable, String methodName) {
/* 369 */     Method method = null;
/*     */     try {
/* 371 */       method = throwable.getClass().getMethod(methodName, null);
/* 372 */     } catch (NoSuchMethodException ignored) {
/*     */     
/* 374 */     } catch (SecurityException ignored) {}
/*     */ 
/*     */ 
/*     */     
/* 378 */     if (method != null && Throwable.class.isAssignableFrom(method.getReturnType())) {
/*     */       try {
/* 380 */         return (Throwable)method.invoke(throwable, ArrayUtils.EMPTY_OBJECT_ARRAY);
/* 381 */       } catch (IllegalAccessException ignored) {
/*     */       
/* 383 */       } catch (IllegalArgumentException ignored) {
/*     */       
/* 385 */       } catch (InvocationTargetException ignored) {}
/*     */     }
/*     */ 
/*     */     
/* 389 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Throwable getCauseUsingFieldName(Throwable throwable, String fieldName) {
/* 400 */     Field field = null;
/*     */     try {
/* 402 */       field = throwable.getClass().getField(fieldName);
/* 403 */     } catch (NoSuchFieldException ignored) {
/*     */     
/* 405 */     } catch (SecurityException ignored) {}
/*     */ 
/*     */ 
/*     */     
/* 409 */     if (field != null && Throwable.class.isAssignableFrom(field.getType())) {
/*     */       try {
/* 411 */         return (Throwable)field.get(throwable);
/* 412 */       } catch (IllegalAccessException ignored) {
/*     */       
/* 414 */       } catch (IllegalArgumentException ignored) {}
/*     */     }
/*     */ 
/*     */     
/* 418 */     return null;
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
/*     */   public static boolean isThrowableNested() {
/* 431 */     return (THROWABLE_CAUSE_METHOD != null);
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
/*     */   public static boolean isNestedThrowable(Throwable throwable) {
/* 444 */     if (throwable == null) {
/* 445 */       return false;
/*     */     }
/*     */     
/* 448 */     if (throwable instanceof Nestable)
/* 449 */       return true; 
/* 450 */     if (throwable instanceof SQLException)
/* 451 */       return true; 
/* 452 */     if (throwable instanceof InvocationTargetException)
/* 453 */       return true; 
/* 454 */     if (isThrowableNested()) {
/* 455 */       return true;
/*     */     }
/*     */     
/* 458 */     Class cls = throwable.getClass();
/* 459 */     for (int i = 0, isize = CAUSE_METHOD_NAMES.length; i < isize; i++) {
/*     */       try {
/* 461 */         Method method = cls.getMethod(CAUSE_METHOD_NAMES[i], null);
/* 462 */         if (method != null && Throwable.class.isAssignableFrom(method.getReturnType())) {
/* 463 */           return true;
/*     */         }
/* 465 */       } catch (NoSuchMethodException ignored) {
/*     */       
/* 467 */       } catch (SecurityException ignored) {}
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*     */     try {
/* 473 */       Field field = cls.getField("detail");
/* 474 */       if (field != null) {
/* 475 */         return true;
/*     */       }
/* 477 */     } catch (NoSuchFieldException ignored) {
/*     */     
/* 479 */     } catch (SecurityException ignored) {}
/*     */ 
/*     */ 
/*     */     
/* 483 */     return false;
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
/*     */   public static int getThrowableCount(Throwable throwable) {
/* 504 */     return getThrowableList(throwable).size();
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
/*     */   public static Throwable[] getThrowables(Throwable throwable) {
/* 527 */     List list = getThrowableList(throwable);
/* 528 */     return (Throwable[])list.toArray((Object[])new Throwable[list.size()]);
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
/*     */   public static List getThrowableList(Throwable throwable) {
/* 551 */     List list = new ArrayList();
/* 552 */     while (throwable != null && !list.contains(throwable)) {
/* 553 */       list.add(throwable);
/* 554 */       throwable = getCause(throwable);
/*     */     } 
/* 556 */     return list;
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
/*     */   public static int indexOfThrowable(Throwable throwable, Class clazz) {
/* 575 */     return indexOf(throwable, clazz, 0, false);
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
/*     */   public static int indexOfThrowable(Throwable throwable, Class clazz, int fromIndex) {
/* 598 */     return indexOf(throwable, clazz, fromIndex, false);
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
/*     */   public static int indexOfType(Throwable throwable, Class type) {
/* 618 */     return indexOf(throwable, type, 0, true);
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
/*     */   public static int indexOfType(Throwable throwable, Class type, int fromIndex) {
/* 642 */     return indexOf(throwable, type, fromIndex, true);
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
/*     */   private static int indexOf(Throwable throwable, Class type, int fromIndex, boolean subclass) {
/* 657 */     if (throwable == null || type == null) {
/* 658 */       return -1;
/*     */     }
/* 660 */     if (fromIndex < 0) {
/* 661 */       fromIndex = 0;
/*     */     }
/* 663 */     Throwable[] throwables = getThrowables(throwable);
/* 664 */     if (fromIndex >= throwables.length) {
/* 665 */       return -1;
/*     */     }
/* 667 */     if (subclass) {
/* 668 */       for (int i = fromIndex; i < throwables.length; i++) {
/* 669 */         if (type.isAssignableFrom(throwables[i].getClass())) {
/* 670 */           return i;
/*     */         }
/*     */       } 
/*     */     } else {
/* 674 */       for (int i = fromIndex; i < throwables.length; i++) {
/* 675 */         if (type.equals(throwables[i].getClass())) {
/* 676 */           return i;
/*     */         }
/*     */       } 
/*     */     } 
/* 680 */     return -1;
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
/*     */   public static void printRootCauseStackTrace(Throwable throwable) {
/* 703 */     printRootCauseStackTrace(throwable, System.err);
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
/*     */   public static void printRootCauseStackTrace(Throwable throwable, PrintStream stream) {
/* 726 */     if (throwable == null) {
/*     */       return;
/*     */     }
/* 729 */     if (stream == null) {
/* 730 */       throw new IllegalArgumentException("The PrintStream must not be null");
/*     */     }
/* 732 */     String[] trace = getRootCauseStackTrace(throwable);
/* 733 */     for (int i = 0; i < trace.length; i++) {
/* 734 */       stream.println(trace[i]);
/*     */     }
/* 736 */     stream.flush();
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
/*     */   public static void printRootCauseStackTrace(Throwable throwable, PrintWriter writer) {
/* 759 */     if (throwable == null) {
/*     */       return;
/*     */     }
/* 762 */     if (writer == null) {
/* 763 */       throw new IllegalArgumentException("The PrintWriter must not be null");
/*     */     }
/* 765 */     String[] trace = getRootCauseStackTrace(throwable);
/* 766 */     for (int i = 0; i < trace.length; i++) {
/* 767 */       writer.println(trace[i]);
/*     */     }
/* 769 */     writer.flush();
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
/*     */   public static String[] getRootCauseStackTrace(Throwable throwable) {
/* 787 */     if (throwable == null) {
/* 788 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*     */     }
/* 790 */     Throwable[] throwables = getThrowables(throwable);
/* 791 */     int count = throwables.length;
/* 792 */     ArrayList frames = new ArrayList();
/* 793 */     List nextTrace = getStackFrameList(throwables[count - 1]);
/* 794 */     for (int i = count; --i >= 0; ) {
/* 795 */       List trace = nextTrace;
/* 796 */       if (i != 0) {
/* 797 */         nextTrace = getStackFrameList(throwables[i - 1]);
/* 798 */         removeCommonFrames(trace, nextTrace);
/*     */       } 
/* 800 */       if (i == count - 1) {
/* 801 */         frames.add(throwables[i].toString());
/*     */       } else {
/* 803 */         frames.add(" [wrapped] " + throwables[i].toString());
/*     */       } 
/* 805 */       for (int j = 0; j < trace.size(); j++) {
/* 806 */         frames.add(trace.get(j));
/*     */       }
/*     */     } 
/* 809 */     return frames.<String>toArray(new String[0]);
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
/*     */   public static void removeCommonFrames(List causeFrames, List wrapperFrames) {
/* 821 */     if (causeFrames == null || wrapperFrames == null) {
/* 822 */       throw new IllegalArgumentException("The List must not be null");
/*     */     }
/* 824 */     int causeFrameIndex = causeFrames.size() - 1;
/* 825 */     int wrapperFrameIndex = wrapperFrames.size() - 1;
/* 826 */     while (causeFrameIndex >= 0 && wrapperFrameIndex >= 0) {
/*     */ 
/*     */       
/* 829 */       String causeFrame = causeFrames.get(causeFrameIndex);
/* 830 */       String wrapperFrame = wrapperFrames.get(wrapperFrameIndex);
/* 831 */       if (causeFrame.equals(wrapperFrame)) {
/* 832 */         causeFrames.remove(causeFrameIndex);
/*     */       }
/* 834 */       causeFrameIndex--;
/* 835 */       wrapperFrameIndex--;
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
/*     */   public static String getFullStackTrace(Throwable throwable) {
/* 851 */     StringWriter sw = new StringWriter();
/* 852 */     PrintWriter pw = new PrintWriter(sw, true);
/* 853 */     Throwable[] ts = getThrowables(throwable);
/* 854 */     for (int i = 0; i < ts.length; i++) {
/* 855 */       ts[i].printStackTrace(pw);
/* 856 */       if (isNestedThrowable(ts[i])) {
/*     */         break;
/*     */       }
/*     */     } 
/* 860 */     return sw.getBuffer().toString();
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
/*     */   public static String getStackTrace(Throwable throwable) {
/* 877 */     StringWriter sw = new StringWriter();
/* 878 */     PrintWriter pw = new PrintWriter(sw, true);
/* 879 */     throwable.printStackTrace(pw);
/* 880 */     return sw.getBuffer().toString();
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
/*     */   public static String[] getStackFrames(Throwable throwable) {
/* 897 */     if (throwable == null) {
/* 898 */       return ArrayUtils.EMPTY_STRING_ARRAY;
/*     */     }
/* 900 */     return getStackFrames(getStackTrace(throwable));
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
/*     */   static String[] getStackFrames(String stackTrace) {
/* 917 */     String linebreak = SystemUtils.LINE_SEPARATOR;
/* 918 */     StringTokenizer frames = new StringTokenizer(stackTrace, linebreak);
/* 919 */     List list = new ArrayList();
/* 920 */     while (frames.hasMoreTokens()) {
/* 921 */       list.add(frames.nextToken());
/*     */     }
/* 923 */     return toArray(list);
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
/*     */   static List getStackFrameList(Throwable t) {
/* 939 */     String stackTrace = getStackTrace(t);
/* 940 */     String linebreak = SystemUtils.LINE_SEPARATOR;
/* 941 */     StringTokenizer frames = new StringTokenizer(stackTrace, linebreak);
/* 942 */     List list = new ArrayList();
/* 943 */     boolean traceStarted = false;
/* 944 */     while (frames.hasMoreTokens()) {
/* 945 */       String token = frames.nextToken();
/*     */       
/* 947 */       int at = token.indexOf("at");
/* 948 */       if (at != -1 && token.substring(0, at).trim().length() == 0) {
/* 949 */         traceStarted = true;
/* 950 */         list.add(token); continue;
/* 951 */       }  if (traceStarted) {
/*     */         break;
/*     */       }
/*     */     } 
/* 955 */     return list;
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
/*     */   public static String getMessage(Throwable th) {
/* 970 */     if (th == null) {
/* 971 */       return "";
/*     */     }
/* 973 */     String clsName = ClassUtils.getShortClassName(th, null);
/* 974 */     String msg = th.getMessage();
/* 975 */     return clsName + ": " + StringUtils.defaultString(msg);
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
/*     */   public static String getRootCauseMessage(Throwable th) {
/* 990 */     Throwable root = getRootCause(th);
/* 991 */     root = (root == null) ? th : root;
/* 992 */     return getMessage(root);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\exception\ExceptionUtils.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */