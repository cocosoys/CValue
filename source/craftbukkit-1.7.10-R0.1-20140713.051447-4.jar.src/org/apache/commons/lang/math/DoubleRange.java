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
/*     */ public final class DoubleRange
/*     */   extends Range
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 71849363892740L;
/*     */   private final double min;
/*     */   private final double max;
/*  49 */   private transient Double minObject = null;
/*     */ 
/*     */ 
/*     */   
/*  53 */   private transient Double maxObject = null;
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
/*     */   
/*     */   public DoubleRange(double number) {
/*  72 */     if (Double.isNaN(number)) {
/*  73 */       throw new IllegalArgumentException("The number must not be NaN");
/*     */     }
/*  75 */     this.min = number;
/*  76 */     this.max = number;
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
/*     */   public DoubleRange(Number number) {
/*  90 */     if (number == null) {
/*  91 */       throw new IllegalArgumentException("The number must not be null");
/*     */     }
/*  93 */     this.min = number.doubleValue();
/*  94 */     this.max = number.doubleValue();
/*  95 */     if (Double.isNaN(this.min) || Double.isNaN(this.max)) {
/*  96 */       throw new IllegalArgumentException("The number must not be NaN");
/*     */     }
/*  98 */     if (number instanceof Double) {
/*  99 */       this.minObject = (Double)number;
/* 100 */       this.maxObject = (Double)number;
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
/*     */   public DoubleRange(double number1, double number2) {
/* 117 */     if (Double.isNaN(number1) || Double.isNaN(number2)) {
/* 118 */       throw new IllegalArgumentException("The numbers must not be NaN");
/*     */     }
/* 120 */     if (number2 < number1) {
/* 121 */       this.min = number2;
/* 122 */       this.max = number1;
/*     */     } else {
/* 124 */       this.min = number1;
/* 125 */       this.max = number2;
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
/*     */   public DoubleRange(Number number1, Number number2) {
/* 143 */     if (number1 == null || number2 == null) {
/* 144 */       throw new IllegalArgumentException("The numbers must not be null");
/*     */     }
/* 146 */     double number1val = number1.doubleValue();
/* 147 */     double number2val = number2.doubleValue();
/* 148 */     if (Double.isNaN(number1val) || Double.isNaN(number2val)) {
/* 149 */       throw new IllegalArgumentException("The numbers must not be NaN");
/*     */     }
/* 151 */     if (number2val < number1val) {
/* 152 */       this.min = number2val;
/* 153 */       this.max = number1val;
/* 154 */       if (number2 instanceof Double) {
/* 155 */         this.minObject = (Double)number2;
/*     */       }
/* 157 */       if (number1 instanceof Double) {
/* 158 */         this.maxObject = (Double)number1;
/*     */       }
/*     */     } else {
/* 161 */       this.min = number1val;
/* 162 */       this.max = number2val;
/* 163 */       if (number1 instanceof Double) {
/* 164 */         this.minObject = (Double)number1;
/*     */       }
/* 166 */       if (number2 instanceof Double) {
/* 167 */         this.maxObject = (Double)number2;
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
/* 181 */     if (this.minObject == null) {
/* 182 */       this.minObject = new Double(this.min);
/*     */     }
/* 184 */     return this.minObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMinimumLong() {
/* 195 */     return (long)this.min;
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
/* 206 */     return (int)this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMinimumDouble() {
/* 215 */     return this.min;
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
/* 226 */     return (float)this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getMaximumNumber() {
/* 235 */     if (this.maxObject == null) {
/* 236 */       this.maxObject = new Double(this.max);
/*     */     }
/* 238 */     return this.maxObject;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getMaximumLong() {
/* 249 */     return (long)this.max;
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
/* 260 */     return (int)this.max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double getMaximumDouble() {
/* 269 */     return this.max;
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
/* 280 */     return (float)this.max;
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
/* 296 */     if (number == null) {
/* 297 */       return false;
/*     */     }
/* 299 */     return containsDouble(number.doubleValue());
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
/*     */   public boolean containsDouble(double value) {
/* 314 */     return (value >= this.min && value <= this.max);
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
/* 331 */     if (range == null) {
/* 332 */       return false;
/*     */     }
/* 334 */     return (containsDouble(range.getMinimumDouble()) && containsDouble(range.getMaximumDouble()));
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
/* 348 */     if (range == null) {
/* 349 */       return false;
/*     */     }
/* 351 */     return (range.containsDouble(this.min) || range.containsDouble(this.max) || containsDouble(range.getMinimumDouble()));
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
/* 368 */     if (obj == this) {
/* 369 */       return true;
/*     */     }
/* 371 */     if (!(obj instanceof DoubleRange)) {
/* 372 */       return false;
/*     */     }
/* 374 */     DoubleRange range = (DoubleRange)obj;
/* 375 */     return (Double.doubleToLongBits(this.min) == Double.doubleToLongBits(range.min) && Double.doubleToLongBits(this.max) == Double.doubleToLongBits(range.max));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 385 */     if (this.hashCode == 0) {
/* 386 */       this.hashCode = 17;
/* 387 */       this.hashCode = 37 * this.hashCode + getClass().hashCode();
/* 388 */       long lng = Double.doubleToLongBits(this.min);
/* 389 */       this.hashCode = 37 * this.hashCode + (int)(lng ^ lng >> 32L);
/* 390 */       lng = Double.doubleToLongBits(this.max);
/* 391 */       this.hashCode = 37 * this.hashCode + (int)(lng ^ lng >> 32L);
/*     */     } 
/* 393 */     return this.hashCode;
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
/* 404 */     if (this.toString == null) {
/* 405 */       StringBuffer buf = new StringBuffer(32);
/* 406 */       buf.append("Range[");
/* 407 */       buf.append(this.min);
/* 408 */       buf.append(',');
/* 409 */       buf.append(this.max);
/* 410 */       buf.append(']');
/* 411 */       this.toString = buf.toString();
/*     */     } 
/* 413 */     return this.toString;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\math\DoubleRange.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */