/*     */ package org.apache.commons.lang;
/*     */ 
/*     */ import java.lang.reflect.Method;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class ClassUtils
/*     */ {
/*     */   public static final char PACKAGE_SEPARATOR_CHAR = '.';
/*  51 */   public static final String PACKAGE_SEPARATOR = String.valueOf('.');
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static final char INNER_CLASS_SEPARATOR_CHAR = '$';
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  61 */   public static final String INNER_CLASS_SEPARATOR = String.valueOf('$');
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  66 */   private static Map primitiveWrapperMap = new HashMap();
/*     */   static {
/*  68 */     primitiveWrapperMap.put(boolean.class, Boolean.class);
/*  69 */     primitiveWrapperMap.put(byte.class, Byte.class);
/*  70 */     primitiveWrapperMap.put(char.class, Character.class);
/*  71 */     primitiveWrapperMap.put(short.class, Short.class);
/*  72 */     primitiveWrapperMap.put(int.class, Integer.class);
/*  73 */     primitiveWrapperMap.put(long.class, Long.class);
/*  74 */     primitiveWrapperMap.put(double.class, Double.class);
/*  75 */     primitiveWrapperMap.put(float.class, Float.class);
/*  76 */     primitiveWrapperMap.put(void.class, void.class);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  82 */   private static Map abbreviationMap = new HashMap();
/*     */   static {
/*  84 */     abbreviationMap.put("int", "I");
/*  85 */     abbreviationMap.put("boolean", "Z");
/*  86 */     abbreviationMap.put("float", "F");
/*  87 */     abbreviationMap.put("long", "J");
/*  88 */     abbreviationMap.put("short", "S");
/*  89 */     abbreviationMap.put("byte", "B");
/*  90 */     abbreviationMap.put("double", "D");
/*  91 */     abbreviationMap.put("char", "C");
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
/*     */   public static String getShortClassName(Object object, String valueIfNull) {
/* 116 */     if (object == null) {
/* 117 */       return valueIfNull;
/*     */     }
/* 119 */     return getShortClassName(object.getClass().getName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getShortClassName(Class cls) {
/* 129 */     if (cls == null) {
/* 130 */       return "";
/*     */     }
/* 132 */     return getShortClassName(cls.getName());
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
/*     */   public static String getShortClassName(String className) {
/* 144 */     if (className == null) {
/* 145 */       return "";
/*     */     }
/* 147 */     if (className.length() == 0) {
/* 148 */       return "";
/*     */     }
/* 150 */     char[] chars = className.toCharArray();
/* 151 */     int lastDot = 0;
/* 152 */     for (int i = 0; i < chars.length; i++) {
/* 153 */       if (chars[i] == '.') {
/* 154 */         lastDot = i + 1;
/* 155 */       } else if (chars[i] == '$') {
/* 156 */         chars[i] = '.';
/*     */       } 
/*     */     } 
/* 159 */     return new String(chars, lastDot, chars.length - lastDot);
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
/*     */   public static String getPackageName(Object object, String valueIfNull) {
/* 172 */     if (object == null) {
/* 173 */       return valueIfNull;
/*     */     }
/* 175 */     return getPackageName(object.getClass().getName());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String getPackageName(Class cls) {
/* 185 */     if (cls == null) {
/* 186 */       return "";
/*     */     }
/* 188 */     return getPackageName(cls.getName());
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
/*     */   public static String getPackageName(String className) {
/* 201 */     if (className == null) {
/* 202 */       return "";
/*     */     }
/* 204 */     int i = className.lastIndexOf('.');
/* 205 */     if (i == -1) {
/* 206 */       return "";
/*     */     }
/* 208 */     return className.substring(0, i);
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
/*     */   public static List getAllSuperclasses(Class cls) {
/* 221 */     if (cls == null) {
/* 222 */       return null;
/*     */     }
/* 224 */     List classes = new ArrayList();
/* 225 */     Class superclass = cls.getSuperclass();
/* 226 */     while (superclass != null) {
/* 227 */       classes.add(superclass);
/* 228 */       superclass = superclass.getSuperclass();
/*     */     } 
/* 230 */     return classes;
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
/*     */   public static List getAllInterfaces(Class cls) {
/* 247 */     if (cls == null) {
/* 248 */       return null;
/*     */     }
/* 250 */     List list = new ArrayList();
/* 251 */     while (cls != null) {
/* 252 */       Class[] interfaces = cls.getInterfaces();
/* 253 */       for (int i = 0; i < interfaces.length; i++) {
/* 254 */         if (!list.contains(interfaces[i])) {
/* 255 */           list.add(interfaces[i]);
/*     */         }
/* 257 */         List superInterfaces = getAllInterfaces(interfaces[i]);
/* 258 */         for (Iterator it = superInterfaces.iterator(); it.hasNext(); ) {
/* 259 */           Class intface = it.next();
/* 260 */           if (!list.contains(intface)) {
/* 261 */             list.add(intface);
/*     */           }
/*     */         } 
/*     */       } 
/* 265 */       cls = cls.getSuperclass();
/*     */     } 
/* 267 */     return list;
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
/*     */   public static List convertClassNamesToClasses(List classNames) {
/* 285 */     if (classNames == null) {
/* 286 */       return null;
/*     */     }
/* 288 */     List classes = new ArrayList(classNames.size());
/* 289 */     for (Iterator it = classNames.iterator(); it.hasNext(); ) {
/* 290 */       String className = it.next();
/*     */       try {
/* 292 */         classes.add(Class.forName(className));
/*     */       } catch (Exception ex) {
/* 294 */         classes.add(null);
/*     */       } 
/*     */     } 
/* 297 */     return classes;
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
/*     */   public static List convertClassesToClassNames(List classes) {
/* 313 */     if (classes == null) {
/* 314 */       return null;
/*     */     }
/* 316 */     List classNames = new ArrayList(classes.size());
/* 317 */     for (Iterator it = classes.iterator(); it.hasNext(); ) {
/* 318 */       Class cls = it.next();
/* 319 */       if (cls == null) {
/* 320 */         classNames.add(null); continue;
/*     */       } 
/* 322 */       classNames.add(cls.getName());
/*     */     } 
/*     */     
/* 325 */     return classNames;
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
/*     */   public static boolean isAssignable(Class[] classArray, Class[] toClassArray) {
/* 362 */     if (!ArrayUtils.isSameLength((Object[])classArray, (Object[])toClassArray)) {
/* 363 */       return false;
/*     */     }
/* 365 */     if (classArray == null) {
/* 366 */       classArray = ArrayUtils.EMPTY_CLASS_ARRAY;
/*     */     }
/* 368 */     if (toClassArray == null) {
/* 369 */       toClassArray = ArrayUtils.EMPTY_CLASS_ARRAY;
/*     */     }
/* 371 */     for (int i = 0; i < classArray.length; i++) {
/* 372 */       if (!isAssignable(classArray[i], toClassArray[i])) {
/* 373 */         return false;
/*     */       }
/*     */     } 
/* 376 */     return true;
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
/*     */   public static boolean isAssignable(Class cls, Class toClass) {
/* 406 */     if (toClass == null) {
/* 407 */       return false;
/*     */     }
/*     */     
/* 410 */     if (cls == null) {
/* 411 */       return !toClass.isPrimitive();
/*     */     }
/* 413 */     if (cls.equals(toClass)) {
/* 414 */       return true;
/*     */     }
/* 416 */     if (cls.isPrimitive()) {
/* 417 */       if (!toClass.isPrimitive()) {
/* 418 */         return false;
/*     */       }
/* 420 */       if (int.class.equals(cls)) {
/* 421 */         return (long.class.equals(toClass) || float.class.equals(toClass) || double.class.equals(toClass));
/*     */       }
/*     */ 
/*     */       
/* 425 */       if (long.class.equals(cls)) {
/* 426 */         return (float.class.equals(toClass) || double.class.equals(toClass));
/*     */       }
/*     */       
/* 429 */       if (boolean.class.equals(cls)) {
/* 430 */         return false;
/*     */       }
/* 432 */       if (double.class.equals(cls)) {
/* 433 */         return false;
/*     */       }
/* 435 */       if (float.class.equals(cls)) {
/* 436 */         return double.class.equals(toClass);
/*     */       }
/* 438 */       if (char.class.equals(cls)) {
/* 439 */         return (int.class.equals(toClass) || long.class.equals(toClass) || float.class.equals(toClass) || double.class.equals(toClass));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 444 */       if (short.class.equals(cls)) {
/* 445 */         return (int.class.equals(toClass) || long.class.equals(toClass) || float.class.equals(toClass) || double.class.equals(toClass));
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 450 */       if (byte.class.equals(cls)) {
/* 451 */         return (short.class.equals(toClass) || int.class.equals(toClass) || long.class.equals(toClass) || float.class.equals(toClass) || double.class.equals(toClass));
/*     */       }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 458 */       return false;
/*     */     } 
/* 460 */     return toClass.isAssignableFrom(cls);
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
/*     */   public static Class primitiveToWrapper(Class cls) {
/* 476 */     Class convertedClass = cls;
/* 477 */     if (cls != null && cls.isPrimitive()) {
/* 478 */       convertedClass = (Class)primitiveWrapperMap.get(cls);
/*     */     }
/* 480 */     return convertedClass;
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
/*     */   public static Class[] primitivesToWrappers(Class[] classes) {
/* 494 */     if (classes == null) {
/* 495 */       return null;
/*     */     }
/*     */     
/* 498 */     if (classes.length == 0) {
/* 499 */       return classes;
/*     */     }
/*     */     
/* 502 */     Class[] convertedClasses = new Class[classes.length];
/* 503 */     for (int i = 0; i < classes.length; i++) {
/* 504 */       convertedClasses[i] = primitiveToWrapper(classes[i]);
/*     */     }
/* 506 */     return convertedClasses;
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
/*     */   public static boolean isInnerClass(Class cls) {
/* 519 */     if (cls == null) {
/* 520 */       return false;
/*     */     }
/* 522 */     return (cls.getName().indexOf('$') >= 0);
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
/*     */   public static Class getClass(ClassLoader classLoader, String className, boolean initialize) throws ClassNotFoundException {
/*     */     Class clazz;
/* 541 */     if (abbreviationMap.containsKey(className)) {
/* 542 */       String clsName = "[" + abbreviationMap.get(className);
/* 543 */       clazz = Class.forName(clsName, initialize, classLoader).getComponentType();
/*     */     } else {
/* 545 */       clazz = Class.forName(toProperClassName(className), initialize, classLoader);
/*     */     } 
/* 547 */     return clazz;
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
/*     */   public static Class getClass(ClassLoader classLoader, String className) throws ClassNotFoundException {
/* 562 */     return getClass(classLoader, className, true);
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
/*     */   public static Class getClass(String className) throws ClassNotFoundException {
/* 576 */     return getClass(className, true);
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
/*     */   public static Class getClass(String className, boolean initialize) throws ClassNotFoundException {
/* 591 */     ClassLoader contextCL = Thread.currentThread().getContextClassLoader();
/* 592 */     ClassLoader loader = (contextCL == null) ? ClassUtils.class.getClassLoader() : contextCL;
/* 593 */     return getClass(loader, className, initialize);
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
/*     */   public static Method getPublicMethod(Class cls, String methodName, Class[] parameterTypes) throws SecurityException, NoSuchMethodException {
/* 622 */     Method declaredMethod = cls.getMethod(methodName, parameterTypes);
/* 623 */     if (Modifier.isPublic(declaredMethod.getDeclaringClass().getModifiers())) {
/* 624 */       return declaredMethod;
/*     */     }
/*     */     
/* 627 */     List candidateClasses = new ArrayList();
/* 628 */     candidateClasses.addAll(getAllInterfaces(cls));
/* 629 */     candidateClasses.addAll(getAllSuperclasses(cls));
/*     */     
/* 631 */     for (Iterator it = candidateClasses.iterator(); it.hasNext(); ) {
/* 632 */       Method candidateMethod; Class candidateClass = it.next();
/* 633 */       if (!Modifier.isPublic(candidateClass.getModifiers())) {
/*     */         continue;
/*     */       }
/*     */       
/*     */       try {
/* 638 */         candidateMethod = candidateClass.getMethod(methodName, parameterTypes);
/*     */       }
/* 640 */       catch (NoSuchMethodException ex) {
/*     */         continue;
/* 642 */       }  if (Modifier.isPublic(candidateMethod.getDeclaringClass().getModifiers())) {
/* 643 */         return candidateMethod;
/*     */       }
/*     */     } 
/*     */     
/* 647 */     throw new NoSuchMethodException("Can't find a public method for " + methodName + " " + ArrayUtils.toString(parameterTypes));
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
/*     */   private static String toProperClassName(String className) {
/* 659 */     className = StringUtils.deleteWhitespace(className);
/* 660 */     if (className == null)
/* 661 */       throw new NullArgumentException("className"); 
/* 662 */     if (className.endsWith("[]")) {
/* 663 */       StringBuffer classNameBuffer = new StringBuffer();
/* 664 */       while (className.endsWith("[]")) {
/* 665 */         className = className.substring(0, className.length() - 2);
/* 666 */         classNameBuffer.append("[");
/*     */       } 
/* 668 */       String abbreviation = (String)abbreviationMap.get(className);
/* 669 */       if (abbreviation != null) {
/* 670 */         classNameBuffer.append(abbreviation);
/*     */       } else {
/* 672 */         classNameBuffer.append("L").append(className).append(";");
/*     */       } 
/* 674 */       className = classNameBuffer.toString();
/*     */     } 
/* 676 */     return className;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\ClassUtils.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */