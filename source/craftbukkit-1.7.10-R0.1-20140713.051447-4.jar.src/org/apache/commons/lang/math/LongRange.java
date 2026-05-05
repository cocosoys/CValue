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
/*     */ public final class LongRange
/*     */   extends Range
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 71849363892720L;
/*     */   private final long min;
/*     */   private final long max;
/*  49 */   private transient Long minObject = null;
/*     */ 
/*     */ 
/*     */   
/*  53 */   private transient Long maxObject = null;
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
/*     */   public LongRange(long number) {
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
/*     */   
/*     */   public LongRange(Number number) {
/*  85 */     if (number == null) {
/*  86 */       throw new IllegalArgumentException("The number must not be null");
/*     */     }
/*  88 */     this.min = number.longValue();
/*  89 */     this.max = number.longValue();
/*  90 */     if (number instanceof Long) {
/*  91 */       this.minObject = (Long)number;
/*  92 */       this.maxObject = (Long)number;
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
/*     */   public LongRange(long number1, long number2) {
/* 108 */     if (number2 < number1) {
/* 109 */       this.min = number2;
/* 110 */       this.max = number1;
/*     */     } else {
/* 112 */       this.min = number1;
/* 113 */       this.max = number2;
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
/*     */   public LongRange(Number number1, Number number2) {
/* 130 */     if (number1 == null || number2 == null) {
/* 131 */       throw new IllegalArgumentException("The numbers must not be null");
/*     */     }
/* 133 */     long number1val = number1.longValue();
/* 134 */     long number2val = number2.longValue();
/* 135 */     if (number2val < number1val) {
/* 136 */       this.min = number2val;
/* 137 */       this.max = number1val;
/* 138 */       if (number2 instanceof Long) {
/* 139 */         this.minObject = (Long)number2;
/*     */       }
/* 141 */       if (number1 instanceof Long) {
/* 142 */         this.maxObject = (Long)number1;
/*     */       }
/*     */     } else {
/* 145 */       this.min = number1val;
/* 146 */       this.max = number2val;
/* 147 */       if (number1 instanceof Long) {
/* 148 */         this.minObject = (Long)number1;
/*     */       }
/* 150 */       if (number2 instanceof Long) {
/* 151 */         this.maxObject = (Long)number2;
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
/* 165 */     if (this.minObject == null) {
/* 166 */       this.minObject = new Long(this.min);
/*     */     }
/* 168 */     return this.minObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMinimumLong() {
/* 177 */     return this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMinimumInteger() {
/* 188 */     return (int)this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMinimumDouble() {
/* 199 */     return this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMinimumFloat() {
/* 210 */     return (float)this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getMaximumNumber() {
/* 219 */     if (this.maxObject == null) {
/* 220 */       this.maxObject = new Long(this.max);
/*     */     }
/* 222 */     return this.maxObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMaximumLong() {
/* 231 */     return this.max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaximumInteger() {
/* 242 */     return (int)this.max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMaximumDouble() {
/* 253 */     return this.max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getMaximumFloat() {
/* 264 */     return (float)this.max;
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
/* 280 */     if (number == null) {
/* 281 */       return false;
/*     */     }
/* 283 */     return containsLong(number.longValue());
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
/*     */   public boolean containsLong(long value) {
/* 298 */     return (value >= this.min && value <= this.max);
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
/* 315 */     if (range == null) {
/* 316 */       return false;
/*     */     }
/* 318 */     return (containsLong(range.getMinimumLong()) && containsLong(range.getMaximumLong()));
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
/* 332 */     if (range == null) {
/* 333 */       return false;
/*     */     }
/* 335 */     return (range.containsLong(this.min) || range.containsLong(this.max) || containsLong(range.getMinimumLong()));
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
/* 352 */     if (obj == this) {
/* 353 */       return true;
/*     */     }
/* 355 */     if (!(obj instanceof LongRange)) {
/* 356 */       return false;
/*     */     }
/* 358 */     LongRange range = (LongRange)obj;
/* 359 */     return (this.min == range.min && this.max == range.max);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 368 */     if (this.hashCode == 0) {
/* 369 */       this.hashCode = 17;
/* 370 */       this.hashCode = 37 * this.hashCode + getClass().hashCode();
/* 371 */       this.hashCode = 37 * this.hashCode + (int)(this.min ^ this.min >> 32L);
/* 372 */       this.hashCode = 37 * this.hashCode + (int)(this.max ^ this.max >> 32L);
/*     */     } 
/* 374 */     return this.hashCode;
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
/* 385 */     if (this.toString == null) {
/* 386 */       StringBuffer buf = new StringBuffer(32);
/* 387 */       buf.append("Range[");
/* 388 */       buf.append(this.min);
/* 389 */       buf.append(',');
/* 390 */       buf.append(this.max);
/* 391 */       buf.append(']');
/* 392 */       this.toString = buf.toString();
/*     */     } 
/* 394 */     return this.toString;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\math\LongRange.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */