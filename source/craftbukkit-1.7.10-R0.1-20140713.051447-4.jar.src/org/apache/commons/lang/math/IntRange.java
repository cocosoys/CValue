/*     */ package org.apache.commons.lang.math;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class IntRange
/*     */   extends Range
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 71849363892730L;
/*     */   private final int min;
/*     */   private final int max;
/*  49 */   private transient Integer minObject = null;
/*     */ 
/*     */ 
/*     */   
/*  53 */   private transient Integer maxObject = null;
/*     */ 
/*     */ 
/*     */   
/*  57 */   private transient int hashCode = 0;
/*     */ 
/*     */ 
/*     */   
/*  61 */   private transient String toString = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public IntRange(int number) {
/*  71 */     this.min = number;
/*  72 */     this.max = number;
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
/*     */   public IntRange(Number number) {
/*  84 */     if (number == null) {
/*  85 */       throw new IllegalArgumentException("The number must not be null");
/*     */     }
/*  87 */     this.min = number.intValue();
/*  88 */     this.max = number.intValue();
/*  89 */     if (number instanceof Integer) {
/*  90 */       this.minObject = (Integer)number;
/*  91 */       this.maxObject = (Integer)number;
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
/*     */   public IntRange(int number1, int number2) {
/* 107 */     if (number2 < number1) {
/* 108 */       this.min = number2;
/* 109 */       this.max = number1;
/*     */     } else {
/* 111 */       this.min = number1;
/* 112 */       this.max = number2;
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
/*     */   public IntRange(Number number1, Number number2) {
/* 129 */     if (number1 == null || number2 == null) {
/* 130 */       throw new IllegalArgumentException("The numbers must not be null");
/*     */     }
/* 132 */     int number1val = number1.intValue();
/* 133 */     int number2val = number2.intValue();
/* 134 */     if (number2val < number1val) {
/* 135 */       this.min = number2val;
/* 136 */       this.max = number1val;
/* 137 */       if (number2 instanceof Integer) {
/* 138 */         this.minObject = (Integer)number2;
/*     */       }
/* 140 */       if (number1 instanceof Integer) {
/* 141 */         this.maxObject = (Integer)number1;
/*     */       }
/*     */     } else {
/* 144 */       this.min = number1val;
/* 145 */       this.max = number2val;
/* 146 */       if (number1 instanceof Integer) {
/* 147 */         this.minObject = (Integer)number1;
/*     */       }
/* 149 */       if (number2 instanceof Integer) {
/* 150 */         this.maxObject = (Integer)number2;
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
/*     */   public Number getMinimumNumber() {
/* 164 */     if (this.minObject == null) {
/* 165 */       this.minObject = new Integer(this.min);
/*     */     }
/* 167 */     return this.minObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMinimumLong() {
/* 176 */     return this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMinimumInteger() {
/* 185 */     return this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMinimumDouble() {
/* 194 */     return this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMinimumFloat() {
/* 203 */     return this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getMaximumNumber() {
/* 212 */     if (this.maxObject == null) {
/* 213 */       this.maxObject = new Integer(this.max);
/*     */     }
/* 215 */     return this.maxObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMaximumLong() {
/* 224 */     return this.max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaximumInteger() {
/* 233 */     return this.max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMaximumDouble() {
/* 242 */     return this.max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMaximumFloat() {
/* 251 */     return this.max;
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
/*     */   public boolean containsNumber(Number number) {
/* 267 */     if (number == null) {
/* 268 */       return false;
/*     */     }
/* 270 */     return containsInteger(number.intValue());
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
/*     */   public boolean containsInteger(int value) {
/* 285 */     return (value >= this.min && value <= this.max);
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
/*     */   public boolean containsRange(Range range) {
/* 302 */     if (range == null) {
/* 303 */       return false;
/*     */     }
/* 305 */     return (containsInteger(range.getMinimumInteger()) && containsInteger(range.getMaximumInteger()));
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
/*     */   public boolean overlapsRange(Range range) {
/* 319 */     if (range == null) {
/* 320 */       return false;
/*     */     }
/* 322 */     return (range.containsInteger(this.min) || range.containsInteger(this.max) || containsInteger(range.getMinimumInteger()));
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
/*     */   public boolean equals(Object obj) {
/* 339 */     if (obj == this) {
/* 340 */       return true;
/*     */     }
/* 342 */     if (!(obj instanceof IntRange)) {
/* 343 */       return false;
/*     */     }
/* 345 */     IntRange range = (IntRange)obj;
/* 346 */     return (this.min == range.min && this.max == range.max);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 355 */     if (this.hashCode == 0) {
/* 356 */       this.hashCode = 17;
/* 357 */       this.hashCode = 37 * this.hashCode + getClass().hashCode();
/* 358 */       this.hashCode = 37 * this.hashCode + this.min;
/* 359 */       this.hashCode = 37 * this.hashCode + this.max;
/*     */     } 
/* 361 */     return this.hashCode;
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
/* 372 */     if (this.toString == null) {
/* 373 */       StringBuffer buf = new StringBuffer(32);
/* 374 */       buf.append("Range[");
/* 375 */       buf.append(this.min);
/* 376 */       buf.append(',');
/* 377 */       buf.append(this.max);
/* 378 */       buf.append(']');
/* 379 */       this.toString = buf.toString();
/*     */     } 
/* 381 */     return this.toString;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\math\IntRange.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */