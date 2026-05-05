/*     */ package org.apache.commons.lang.enums;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/* 300 */   private static final Map EMPTY_MAP = Collections.unmodifiableMap(new HashMap(0));
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 305 */   private static final Map cEnumClasses = new WeakHashMap();
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
/* 321 */   protected transient String iToString = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static class Entry
/*     */   {
/* 330 */     final Map map = new HashMap();
/*     */ 
/*     */ 
/*     */     
/* 334 */     final Map unmodifiableMap = Collections.unmodifiableMap(this.map);
/*     */ 
/*     */ 
/*     */     
/* 338 */     final List list = new ArrayList(25);
/*     */ 
/*     */ 
/*     */     
/* 342 */     final List unmodifiableList = Collections.unmodifiableList(this.list);
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
/* 364 */     init(name);
/* 365 */     this.iName = name;
/* 366 */     this.iHashCode = 7 + getEnumClass().hashCode() + 3 * name.hashCode();
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
/* 378 */     if (StringUtils.isEmpty(name)) {
/* 379 */       throw new IllegalArgumentException("The Enum name must not be empty or null");
/*     */     }
/*     */     
/* 382 */     Class enumClass = getEnumClass();
/* 383 */     if (enumClass == null) {
/* 384 */       throw new IllegalArgumentException("getEnumClass() must not be null");
/*     */     }
/* 386 */     Class cls = getClass();
/* 387 */     boolean ok = false;
/* 388 */     while (cls != null && cls != Enum.class && cls != ValuedEnum.class) {
/* 389 */       if (cls == enumClass) {
/* 390 */         ok = true;
/*     */         break;
/*     */       } 
/* 393 */       cls = cls.getSuperclass();
/*     */     } 
/* 395 */     if (!ok) {
/* 396 */       throw new IllegalArgumentException("getEnumClass() must return a superclass of this class");
/*     */     }
/*     */ 
/*     */     
/* 400 */     Entry entry = (Entry)cEnumClasses.get(enumClass);
/* 401 */     if (entry == null) {
/* 402 */       entry = createEntry(enumClass);
/* 403 */       cEnumClasses.put(enumClass, entry);
/*     */     } 
/* 405 */     if (entry.map.containsKey(name)) {
/* 406 */       throw new IllegalArgumentException("The Enum name must be unique, '" + name + "' has already been added");
/*     */     }
/* 408 */     entry.map.put(name, this);
/* 409 */     entry.list.add(this);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected Object readResolve() {
/* 419 */     Entry entry = (Entry)cEnumClasses.get(getEnumClass());
/* 420 */     if (entry == null) {
/* 421 */       return null;
/*     */     }
/* 423 */     return entry.map.get(getName());
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
/* 440 */     Entry entry = getEntry(enumClass);
/* 441 */     if (entry == null) {
/* 442 */       return null;
/*     */     }
/* 444 */     return (Enum)entry.map.get(name);
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
/* 461 */     Entry entry = getEntry(enumClass);
/* 462 */     if (entry == null) {
/* 463 */       return EMPTY_MAP;
/*     */     }
/* 465 */     return entry.unmodifiableMap;
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
/* 483 */     Entry entry = getEntry(enumClass);
/* 484 */     if (entry == null) {
/* 485 */       return Collections.EMPTY_LIST;
/*     */     }
/* 487 */     return entry.unmodifiableList;
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
/* 505 */     return getEnumList(enumClass).iterator();
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
/* 516 */     if (enumClass == null) {
/* 517 */       throw new IllegalArgumentException("The Enum Class must not be null");
/*     */     }
/* 519 */     if (!Enum.class.isAssignableFrom(enumClass)) {
/* 520 */       throw new IllegalArgumentException("The Class must be a subclass of Enum");
/*     */     }
/* 522 */     Entry entry = (Entry)cEnumClasses.get(enumClass);
/* 523 */     return entry;
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
/* 535 */     Entry entry = new Entry();
/* 536 */     Class cls = enumClass.getSuperclass();
/* 537 */     while (cls != null && cls != Enum.class && cls != ValuedEnum.class) {
/* 538 */       Entry loopEntry = (Entry)cEnumClasses.get(cls);
/* 539 */       if (loopEntry != null) {
/* 540 */         entry.list.addAll(loopEntry.list);
/* 541 */         entry.map.putAll(loopEntry.map);
/*     */         break;
/*     */       } 
/* 544 */       cls = (Class)cls.getSuperclass();
/*     */     } 
/* 546 */     return entry;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final String getName() {
/* 556 */     return this.iName;
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
/* 570 */     return getClass();
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
/* 587 */     if (other == this)
/* 588 */       return true; 
/* 589 */     if (other == null)
/* 590 */       return false; 
/* 591 */     if (other.getClass() == getClass())
/*     */     {
/*     */ 
/*     */       
/* 595 */       return this.iName.equals(((Enum)other).iName);
/*     */     }
/*     */     
/* 598 */     if (!other.getClass().getName().equals(getClass().getName())) {
/* 599 */       return false;
/*     */     }
/* 601 */     return this.iName.equals(getNameInOtherClassLoader(other));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public final int hashCode() {
/* 611 */     return this.iHashCode;
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
/* 631 */     if (other == this) {
/* 632 */       return 0;
/*     */     }
/* 634 */     if (other.getClass() != getClass()) {
/* 635 */       if (other.getClass().getName().equals(getClass().getName())) {
/* 636 */         return this.iName.compareTo(getNameInOtherClassLoader(other));
/*     */       }
/* 638 */       throw new ClassCastException("Different enum class '" + ClassUtils.getShortClassName(other.getClass()) + "'");
/*     */     } 
/*     */     
/* 641 */     return this.iName.compareTo(((Enum)other).iName);
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
/* 652 */       Method mth = other.getClass().getMethod("getName", null);
/* 653 */       String name = (String)mth.invoke(other, null);
/* 654 */       return name;
/* 655 */     } catch (NoSuchMethodException e) {
/*     */     
/* 657 */     } catch (IllegalAccessException e) {
/*     */     
/* 659 */     } catch (InvocationTargetException e) {}
/*     */ 
/*     */     
/* 662 */     throw new IllegalStateException("This should not happen");
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
/* 673 */     if (this.iToString == null) {
/* 674 */       String shortName = ClassUtils.getShortClassName(getEnumClass());
/* 675 */       this.iToString = shortName + "[" + getName() + "]";
/*     */     } 
/* 677 */     return this.iToString;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\enums\Enum.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */