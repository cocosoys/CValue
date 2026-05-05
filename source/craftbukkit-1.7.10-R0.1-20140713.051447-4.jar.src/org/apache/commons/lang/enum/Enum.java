/*     */ package org.apache.commons.lang.enum;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import java.lang.reflect.InvocationTargetException;
/*     */ import java.lang.reflect.Method;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import java.util.Map;
/*     */ import java.util.WeakHashMap;
/*     */ import org.apache.commons.lang.ClassUtils;
/*     */ import org.apache.commons.lang.StringUtils;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class Enum
/*     */   implements Comparable, Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -487045951170455942L;
/* 254 */   private static final Map EMPTY_MAP = Collections.unmodifiableMap(new HashMap(0));
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 259 */   private static final Map cEnumClasses = new WeakHashMap();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String iName;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final transient int iHashCode;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 275 */   protected transient String iToString = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Entry
/*     */   {
/* 284 */     final Map map = new HashMap();
/*     */ 
/*     */ 
/*     */     
/* 288 */     final Map unmodifiableMap = Collections.unmodifiableMap(this.map);
/*     */ 
/*     */ 
/*     */     
/* 292 */     final List list = new ArrayList(25);
/*     */ 
/*     */ 
/*     */     
/* 296 */     final List unmodifiableList = Collections.unmodifiableList(this.list);
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
/*     */   protected Enum(String name) {
/* 318 */     init(name);
/* 319 */     this.iName = name;
/* 320 */     this.iHashCode = 7 + getEnumClass().hashCode() + 3 * name.hashCode();
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
/*     */   private void init(String name) {
/* 332 */     if (StringUtils.isEmpty(name)) {
/* 333 */       throw new IllegalArgumentException("The Enum name must not be empty or null");
/*     */     }
/*     */     
/* 336 */     Class enumClass = getEnumClass();
/* 337 */     if (enumClass == null) {
/* 338 */       throw new IllegalArgumentException("getEnumClass() must not be null");
/*     */     }
/* 340 */     Class cls = getClass();
/* 341 */     boolean ok = false;
/* 342 */     while (cls != null && cls != Enum.class && cls != ValuedEnum.class) {
/* 343 */       if (cls == enumClass) {
/* 344 */         ok = true;
/*     */         break;
/*     */       } 
/* 347 */       cls = cls.getSuperclass();
/*     */     } 
/* 349 */     if (!ok) {
/* 350 */       throw new IllegalArgumentException("getEnumClass() must return a superclass of this class");
/*     */     }
/*     */ 
/*     */     
/* 354 */     Entry entry = (Entry)cEnumClasses.get(enumClass);
/* 355 */     if (entry == null) {
/* 356 */       entry = createEntry(enumClass);
/* 357 */       cEnumClasses.put(enumClass, entry);
/*     */     } 
/* 359 */     if (entry.map.containsKey(name)) {
/* 360 */       throw new IllegalArgumentException("The Enum name must be unique, '" + name + "' has already been added");
/*     */     }
/* 362 */     entry.map.put(name, this);
/* 363 */     entry.list.add(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object readResolve() {
/* 373 */     Entry entry = (Entry)cEnumClasses.get(getEnumClass());
/* 374 */     if (entry == null) {
/* 375 */       return null;
/*     */     }
/* 377 */     return entry.map.get(getName());
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
/*     */   protected static Enum getEnum(Class enumClass, String name) {
/* 394 */     Entry entry = getEntry(enumClass);
/* 395 */     if (entry == null) {
/* 396 */       return null;
/*     */     }
/* 398 */     return (Enum)entry.map.get(name);
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
/*     */   protected static Map getEnumMap(Class enumClass) {
/* 415 */     Entry entry = getEntry(enumClass);
/* 416 */     if (entry == null) {
/* 417 */       return EMPTY_MAP;
/*     */     }
/* 419 */     return entry.unmodifiableMap;
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
/*     */   protected static List getEnumList(Class enumClass) {
/* 437 */     Entry entry = getEntry(enumClass);
/* 438 */     if (entry == null) {
/* 439 */       return Collections.EMPTY_LIST;
/*     */     }
/* 441 */     return entry.unmodifiableList;
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
/*     */   protected static Iterator iterator(Class enumClass) {
/* 459 */     return getEnumList(enumClass).iterator();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static Entry getEntry(Class enumClass) {
/* 470 */     if (enumClass == null) {
/* 471 */       throw new IllegalArgumentException("The Enum Class must not be null");
/*     */     }
/* 473 */     if (!Enum.class.isAssignableFrom(enumClass)) {
/* 474 */       throw new IllegalArgumentException("The Class must be a subclass of Enum");
/*     */     }
/* 476 */     Entry entry = (Entry)cEnumClasses.get(enumClass);
/* 477 */     return entry;
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
/*     */   private static Entry createEntry(Class enumClass) {
/* 489 */     Entry entry = new Entry();
/* 490 */     Class cls = enumClass.getSuperclass();
/* 491 */     while (cls != null && cls != Enum.class && cls != ValuedEnum.class) {
/* 492 */       Entry loopEntry = (Entry)cEnumClasses.get(cls);
/* 493 */       if (loopEntry != null) {
/* 494 */         entry.list.addAll(loopEntry.list);
/* 495 */         entry.map.putAll(loopEntry.map);
/*     */         break;
/*     */       } 
/* 498 */       cls = (Class)cls.getSuperclass();
/*     */     } 
/* 500 */     return entry;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getName() {
/* 510 */     return this.iName;
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
/*     */   public Class getEnumClass() {
/* 524 */     return getClass();
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
/*     */   public final boolean equals(Object other) {
/* 541 */     if (other == this)
/* 542 */       return true; 
/* 543 */     if (other == null)
/* 544 */       return false; 
/* 545 */     if (other.getClass() == getClass())
/*     */     {
/*     */ 
/*     */       
/* 549 */       return this.iName.equals(((Enum)other).iName);
/*     */     }
/*     */     
/* 552 */     if (!other.getClass().getName().equals(getClass().getName())) {
/* 553 */       return false;
/*     */     }
/* 555 */     return this.iName.equals(getNameInOtherClassLoader(other));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 565 */     return this.iHashCode;
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
/*     */   public int compareTo(Object other) {
/* 585 */     if (other == this) {
/* 586 */       return 0;
/*     */     }
/* 588 */     if (other.getClass() != getClass() && 
/* 589 */       other.getClass().getName().equals(getClass().getName())) {
/* 590 */       return this.iName.compareTo(getNameInOtherClassLoader(other));
/*     */     }
/*     */     
/* 593 */     return this.iName.compareTo(((Enum)other).iName);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private String getNameInOtherClassLoader(Object other) {
/*     */     try {
/* 604 */       Method mth = other.getClass().getMethod("getName", null);
/* 605 */       String name = (String)mth.invoke(other, null);
/* 606 */       return name;
/* 607 */     } catch (NoSuchMethodException e) {
/*     */     
/* 609 */     } catch (IllegalAccessException e) {
/*     */     
/* 611 */     } catch (InvocationTargetException e) {}
/*     */ 
/*     */     
/* 614 */     throw new IllegalStateException("This should not happen");
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
/* 625 */     if (this.iToString == null) {
/* 626 */       String shortName = ClassUtils.getShortClassName(getEnumClass());
/* 627 */       this.iToString = shortName + "[" + getName() + "]";
/*     */     } 
/* 629 */     return this.iToString;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\enum\Enum.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */