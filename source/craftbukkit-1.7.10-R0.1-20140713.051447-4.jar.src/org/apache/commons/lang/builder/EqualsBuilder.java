/*     */ package org.apache.commons.lang.builder;
/*     */ 
/*     */ import java.lang.reflect.AccessibleObject;
/*     */ import java.lang.reflect.Field;
/*     */ import java.lang.reflect.Modifier;
/*     */ import java.util.Arrays;
/*     */ import java.util.Collection;
/*     */ import java.util.Collections;
/*     */ import java.util.List;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class EqualsBuilder
/*     */ {
/*     */   private boolean isEquals = true;
/*     */   
/*     */   public static boolean reflectionEquals(Object lhs, Object rhs) {
/* 126 */     return reflectionEquals(lhs, rhs, false, null, null);
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
/*     */   public static boolean reflectionEquals(Object lhs, Object rhs, Collection excludeFields) {
/* 149 */     return reflectionEquals(lhs, rhs, ReflectionToStringBuilder.toNoNullStringArray(excludeFields));
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
/*     */   public static boolean reflectionEquals(Object lhs, Object rhs, String[] excludeFields) {
/* 172 */     return reflectionEquals(lhs, rhs, false, null, excludeFields);
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
/*     */   public static boolean reflectionEquals(Object lhs, Object rhs, boolean testTransients) {
/* 196 */     return reflectionEquals(lhs, rhs, testTransients, null, null);
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
/*     */   public static boolean reflectionEquals(Object lhs, Object rhs, boolean testTransients, Class reflectUpToClass) {
/* 225 */     return reflectionEquals(lhs, rhs, testTransients, reflectUpToClass, null);
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
/*     */   public static boolean reflectionEquals(Object lhs, Object rhs, boolean testTransients, Class reflectUpToClass, String[] excludeFields) {
/*     */     Class clazz1;
/* 256 */     if (lhs == rhs) {
/* 257 */       return true;
/*     */     }
/* 259 */     if (lhs == null || rhs == null) {
/* 260 */       return false;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 266 */     Class lhsClass = lhs.getClass();
/* 267 */     Class rhsClass = rhs.getClass();
/*     */     
/* 269 */     if (lhsClass.isInstance(rhs)) {
/* 270 */       clazz1 = lhsClass;
/* 271 */       if (!rhsClass.isInstance(lhs))
/*     */       {
/* 273 */         clazz1 = rhsClass;
/*     */       }
/* 275 */     } else if (rhsClass.isInstance(lhs)) {
/* 276 */       clazz1 = rhsClass;
/* 277 */       if (!lhsClass.isInstance(rhs))
/*     */       {
/* 279 */         clazz1 = lhsClass;
/*     */       }
/*     */     } else {
/*     */       
/* 283 */       return false;
/*     */     } 
/* 285 */     EqualsBuilder equalsBuilder = new EqualsBuilder();
/*     */     try {
/* 287 */       reflectionAppend(lhs, rhs, clazz1, equalsBuilder, testTransients, excludeFields);
/* 288 */       while (clazz1.getSuperclass() != null && clazz1 != reflectUpToClass) {
/* 289 */         clazz1 = clazz1.getSuperclass();
/* 290 */         reflectionAppend(lhs, rhs, clazz1, equalsBuilder, testTransients, excludeFields);
/*     */       
/*     */       }
/*     */ 
/*     */     
/*     */     }
/*     */     catch (IllegalArgumentException e) {
/*     */       
/* 298 */       return false;
/*     */     } 
/* 300 */     return equalsBuilder.isEquals();
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
/*     */   private static void reflectionAppend(Object lhs, Object rhs, Class clazz, EqualsBuilder builder, boolean useTransients, String[] excludeFields) {
/* 321 */     Field[] fields = clazz.getDeclaredFields();
/* 322 */     List excludedFieldList = (excludeFields != null) ? Arrays.<String>asList(excludeFields) : Collections.EMPTY_LIST;
/* 323 */     AccessibleObject.setAccessible((AccessibleObject[])fields, true);
/* 324 */     for (int i = 0; i < fields.length && builder.isEquals; i++) {
/* 325 */       Field f = fields[i];
/* 326 */       if (!excludedFieldList.contains(f.getName()) && f.getName().indexOf('$') == -1 && (useTransients || !Modifier.isTransient(f.getModifiers())) && !Modifier.isStatic(f.getModifiers())) {
/*     */         
/*     */         try {
/*     */ 
/*     */           
/* 331 */           builder.append(f.get(lhs), f.get(rhs));
/*     */         }
/*     */         catch (IllegalAccessException e) {
/*     */           
/* 335 */           throw new InternalError("Unexpected IllegalAccessException");
/*     */         } 
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
/*     */   public EqualsBuilder appendSuper(boolean superEquals) {
/* 351 */     if (!this.isEquals) {
/* 352 */       return this;
/*     */     }
/* 354 */     this.isEquals = superEquals;
/* 355 */     return this;
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
/*     */   public EqualsBuilder append(Object lhs, Object rhs) {
/* 369 */     if (!this.isEquals) {
/* 370 */       return this;
/*     */     }
/* 372 */     if (lhs == rhs) {
/* 373 */       return this;
/*     */     }
/* 375 */     if (lhs == null || rhs == null) {
/* 376 */       setEquals(false);
/* 377 */       return this;
/*     */     } 
/* 379 */     Class lhsClass = lhs.getClass();
/* 380 */     if (!lhsClass.isArray()) {
/*     */       
/* 382 */       this.isEquals = lhs.equals(rhs);
/* 383 */     } else if (lhs.getClass() != rhs.getClass()) {
/*     */       
/* 385 */       setEquals(false);
/*     */ 
/*     */     
/*     */     }
/* 389 */     else if (lhs instanceof long[]) {
/* 390 */       append((long[])lhs, (long[])rhs);
/* 391 */     } else if (lhs instanceof int[]) {
/* 392 */       append((int[])lhs, (int[])rhs);
/* 393 */     } else if (lhs instanceof short[]) {
/* 394 */       append((short[])lhs, (short[])rhs);
/* 395 */     } else if (lhs instanceof char[]) {
/* 396 */       append((char[])lhs, (char[])rhs);
/* 397 */     } else if (lhs instanceof byte[]) {
/* 398 */       append((byte[])lhs, (byte[])rhs);
/* 399 */     } else if (lhs instanceof double[]) {
/* 400 */       append((double[])lhs, (double[])rhs);
/* 401 */     } else if (lhs instanceof float[]) {
/* 402 */       append((float[])lhs, (float[])rhs);
/* 403 */     } else if (lhs instanceof boolean[]) {
/* 404 */       append((boolean[])lhs, (boolean[])rhs);
/*     */     } else {
/*     */       
/* 407 */       append((Object[])lhs, (Object[])rhs);
/*     */     } 
/* 409 */     return this;
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
/*     */   public EqualsBuilder append(long lhs, long rhs) {
/* 424 */     if (!this.isEquals) {
/* 425 */       return this;
/*     */     }
/* 427 */     this.isEquals = (lhs == rhs);
/* 428 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EqualsBuilder append(int lhs, int rhs) {
/* 439 */     if (!this.isEquals) {
/* 440 */       return this;
/*     */     }
/* 442 */     this.isEquals = (lhs == rhs);
/* 443 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EqualsBuilder append(short lhs, short rhs) {
/* 454 */     if (!this.isEquals) {
/* 455 */       return this;
/*     */     }
/* 457 */     this.isEquals = (lhs == rhs);
/* 458 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EqualsBuilder append(char lhs, char rhs) {
/* 469 */     if (!this.isEquals) {
/* 470 */       return this;
/*     */     }
/* 472 */     this.isEquals = (lhs == rhs);
/* 473 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EqualsBuilder append(byte lhs, byte rhs) {
/* 484 */     if (!this.isEquals) {
/* 485 */       return this;
/*     */     }
/* 487 */     this.isEquals = (lhs == rhs);
/* 488 */     return this;
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
/*     */   public EqualsBuilder append(double lhs, double rhs) {
/* 505 */     if (!this.isEquals) {
/* 506 */       return this;
/*     */     }
/* 508 */     return append(Double.doubleToLongBits(lhs), Double.doubleToLongBits(rhs));
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
/*     */   public EqualsBuilder append(float lhs, float rhs) {
/* 525 */     if (!this.isEquals) {
/* 526 */       return this;
/*     */     }
/* 528 */     return append(Float.floatToIntBits(lhs), Float.floatToIntBits(rhs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public EqualsBuilder append(boolean lhs, boolean rhs) {
/* 539 */     if (!this.isEquals) {
/* 540 */       return this;
/*     */     }
/* 542 */     this.isEquals = (lhs == rhs);
/* 543 */     return this;
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
/*     */   public EqualsBuilder append(Object[] lhs, Object[] rhs) {
/* 557 */     if (!this.isEquals) {
/* 558 */       return this;
/*     */     }
/* 560 */     if (lhs == rhs) {
/* 561 */       return this;
/*     */     }
/* 563 */     if (lhs == null || rhs == null) {
/* 564 */       setEquals(false);
/* 565 */       return this;
/*     */     } 
/* 567 */     if (lhs.length != rhs.length) {
/* 568 */       setEquals(false);
/* 569 */       return this;
/*     */     } 
/* 571 */     for (int i = 0; i < lhs.length && this.isEquals; i++) {
/* 572 */       append(lhs[i], rhs[i]);
/*     */     }
/* 574 */     return this;
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
/*     */   public EqualsBuilder append(long[] lhs, long[] rhs) {
/* 588 */     if (!this.isEquals) {
/* 589 */       return this;
/*     */     }
/* 591 */     if (lhs == rhs) {
/* 592 */       return this;
/*     */     }
/* 594 */     if (lhs == null || rhs == null) {
/* 595 */       setEquals(false);
/* 596 */       return this;
/*     */     } 
/* 598 */     if (lhs.length != rhs.length) {
/* 599 */       setEquals(false);
/* 600 */       return this;
/*     */     } 
/* 602 */     for (int i = 0; i < lhs.length && this.isEquals; i++) {
/* 603 */       append(lhs[i], rhs[i]);
/*     */     }
/* 605 */     return this;
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
/*     */   public EqualsBuilder append(int[] lhs, int[] rhs) {
/* 619 */     if (!this.isEquals) {
/* 620 */       return this;
/*     */     }
/* 622 */     if (lhs == rhs) {
/* 623 */       return this;
/*     */     }
/* 625 */     if (lhs == null || rhs == null) {
/* 626 */       setEquals(false);
/* 627 */       return this;
/*     */     } 
/* 629 */     if (lhs.length != rhs.length) {
/* 630 */       setEquals(false);
/* 631 */       return this;
/*     */     } 
/* 633 */     for (int i = 0; i < lhs.length && this.isEquals; i++) {
/* 634 */       append(lhs[i], rhs[i]);
/*     */     }
/* 636 */     return this;
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
/*     */   public EqualsBuilder append(short[] lhs, short[] rhs) {
/* 650 */     if (!this.isEquals) {
/* 651 */       return this;
/*     */     }
/* 653 */     if (lhs == rhs) {
/* 654 */       return this;
/*     */     }
/* 656 */     if (lhs == null || rhs == null) {
/* 657 */       setEquals(false);
/* 658 */       return this;
/*     */     } 
/* 660 */     if (lhs.length != rhs.length) {
/* 661 */       setEquals(false);
/* 662 */       return this;
/*     */     } 
/* 664 */     for (int i = 0; i < lhs.length && this.isEquals; i++) {
/* 665 */       append(lhs[i], rhs[i]);
/*     */     }
/* 667 */     return this;
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
/*     */   public EqualsBuilder append(char[] lhs, char[] rhs) {
/* 681 */     if (!this.isEquals) {
/* 682 */       return this;
/*     */     }
/* 684 */     if (lhs == rhs) {
/* 685 */       return this;
/*     */     }
/* 687 */     if (lhs == null || rhs == null) {
/* 688 */       setEquals(false);
/* 689 */       return this;
/*     */     } 
/* 691 */     if (lhs.length != rhs.length) {
/* 692 */       setEquals(false);
/* 693 */       return this;
/*     */     } 
/* 695 */     for (int i = 0; i < lhs.length && this.isEquals; i++) {
/* 696 */       append(lhs[i], rhs[i]);
/*     */     }
/* 698 */     return this;
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
/*     */   public EqualsBuilder append(byte[] lhs, byte[] rhs) {
/* 712 */     if (!this.isEquals) {
/* 713 */       return this;
/*     */     }
/* 715 */     if (lhs == rhs) {
/* 716 */       return this;
/*     */     }
/* 718 */     if (lhs == null || rhs == null) {
/* 719 */       setEquals(false);
/* 720 */       return this;
/*     */     } 
/* 722 */     if (lhs.length != rhs.length) {
/* 723 */       setEquals(false);
/* 724 */       return this;
/*     */     } 
/* 726 */     for (int i = 0; i < lhs.length && this.isEquals; i++) {
/* 727 */       append(lhs[i], rhs[i]);
/*     */     }
/* 729 */     return this;
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
/*     */   public EqualsBuilder append(double[] lhs, double[] rhs) {
/* 743 */     if (!this.isEquals) {
/* 744 */       return this;
/*     */     }
/* 746 */     if (lhs == rhs) {
/* 747 */       return this;
/*     */     }
/* 749 */     if (lhs == null || rhs == null) {
/* 750 */       setEquals(false);
/* 751 */       return this;
/*     */     } 
/* 753 */     if (lhs.length != rhs.length) {
/* 754 */       setEquals(false);
/* 755 */       return this;
/*     */     } 
/* 757 */     for (int i = 0; i < lhs.length && this.isEquals; i++) {
/* 758 */       append(lhs[i], rhs[i]);
/*     */     }
/* 760 */     return this;
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
/*     */   public EqualsBuilder append(float[] lhs, float[] rhs) {
/* 774 */     if (!this.isEquals) {
/* 775 */       return this;
/*     */     }
/* 777 */     if (lhs == rhs) {
/* 778 */       return this;
/*     */     }
/* 780 */     if (lhs == null || rhs == null) {
/* 781 */       setEquals(false);
/* 782 */       return this;
/*     */     } 
/* 784 */     if (lhs.length != rhs.length) {
/* 785 */       setEquals(false);
/* 786 */       return this;
/*     */     } 
/* 788 */     for (int i = 0; i < lhs.length && this.isEquals; i++) {
/* 789 */       append(lhs[i], rhs[i]);
/*     */     }
/* 791 */     return this;
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
/*     */   public EqualsBuilder append(boolean[] lhs, boolean[] rhs) {
/* 805 */     if (!this.isEquals) {
/* 806 */       return this;
/*     */     }
/* 808 */     if (lhs == rhs) {
/* 809 */       return this;
/*     */     }
/* 811 */     if (lhs == null || rhs == null) {
/* 812 */       setEquals(false);
/* 813 */       return this;
/*     */     } 
/* 815 */     if (lhs.length != rhs.length) {
/* 816 */       setEquals(false);
/* 817 */       return this;
/*     */     } 
/* 819 */     for (int i = 0; i < lhs.length && this.isEquals; i++) {
/* 820 */       append(lhs[i], rhs[i]);
/*     */     }
/* 822 */     return this;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEquals() {
/* 832 */     return this.isEquals;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setEquals(boolean isEquals) {
/* 842 */     this.isEquals = isEquals;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\builder\EqualsBuilder.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */