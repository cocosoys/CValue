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
/*     */ 
/*     */ 
/*     */ public final class NumberRange
/*     */   extends Range
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 71849363892710L;
/*     */   private final Number min;
/*     */   private final Number max;
/*  51 */   private transient int hashCode = 0;
/*     */ 
/*     */ 
/*     */   
/*  55 */   private transient String toString = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public NumberRange(Number num) {
/*  67 */     if (num == null) {
/*  68 */       throw new IllegalArgumentException("The number must not be null");
/*     */     }
/*  70 */     if (!(num instanceof Comparable)) {
/*  71 */       throw new IllegalArgumentException("The number must implement Comparable");
/*     */     }
/*  73 */     if (num instanceof Double && ((Double)num).isNaN()) {
/*  74 */       throw new IllegalArgumentException("The number must not be NaN");
/*     */     }
/*  76 */     if (num instanceof Float && ((Float)num).isNaN()) {
/*  77 */       throw new IllegalArgumentException("The number must not be NaN");
/*     */     }
/*     */     
/*  80 */     this.min = num;
/*  81 */     this.max = num;
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
/*     */   public NumberRange(Number num1, Number num2) {
/* 103 */     if (num1 == null || num2 == null) {
/* 104 */       throw new IllegalArgumentException("The numbers must not be null");
/*     */     }
/* 106 */     if (num1.getClass() != num2.getClass()) {
/* 107 */       throw new IllegalArgumentException("The numbers must be of the same type");
/*     */     }
/* 109 */     if (!(num1 instanceof Comparable)) {
/* 110 */       throw new IllegalArgumentException("The numbers must implement Comparable");
/*     */     }
/* 112 */     if (num1 instanceof Double) {
/* 113 */       if (((Double)num1).isNaN() || ((Double)num2).isNaN()) {
/* 114 */         throw new IllegalArgumentException("The number must not be NaN");
/*     */       }
/* 116 */     } else if (num1 instanceof Float && ((
/* 117 */       (Float)num1).isNaN() || ((Float)num2).isNaN())) {
/* 118 */       throw new IllegalArgumentException("The number must not be NaN");
/*     */     } 
/*     */ 
/*     */     
/* 122 */     int compare = ((Comparable)num1).compareTo(num2);
/* 123 */     if (compare == 0) {
/* 124 */       this.min = num1;
/* 125 */       this.max = num1;
/* 126 */     } else if (compare > 0) {
/* 127 */       this.min = num2;
/* 128 */       this.max = num1;
/*     */     } else {
/* 130 */       this.min = num1;
/* 131 */       this.max = num2;
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
/* 144 */     return this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getMaximumNumber() {
/* 153 */     return this.max;
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
/*     */   public boolean containsNumber(Number number) {
/* 170 */     if (number == null) {
/* 171 */       return false;
/*     */     }
/* 173 */     if (number.getClass() != this.min.getClass()) {
/* 174 */       throw new IllegalArgumentException("The number must be of the same type as the range numbers");
/*     */     }
/* 176 */     int compareMin = ((Comparable)this.min).compareTo(number);
/* 177 */     int compareMax = ((Comparable)this.max).compareTo(number);
/* 178 */     return (compareMin <= 0 && compareMax >= 0);
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
/*     */   public boolean equals(Object obj) {
/* 197 */     if (obj == this) {
/* 198 */       return true;
/*     */     }
/* 200 */     if (!(obj instanceof NumberRange)) {
/* 201 */       return false;
/*     */     }
/* 203 */     NumberRange range = (NumberRange)obj;
/* 204 */     return (this.min.equals(range.min) && this.max.equals(range.max));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 213 */     if (this.hashCode == 0) {
/* 214 */       this.hashCode = 17;
/* 215 */       this.hashCode = 37 * this.hashCode + getClass().hashCode();
/* 216 */       this.hashCode = 37 * this.hashCode + this.min.hashCode();
/* 217 */       this.hashCode = 37 * this.hashCode + this.max.hashCode();
/*     */     } 
/* 219 */     return this.hashCode;
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
/* 230 */     if (this.toString == null) {
/* 231 */       StringBuffer buf = new StringBuffer(32);
/* 232 */       buf.append("Range[");
/* 233 */       buf.append(this.min);
/* 234 */       buf.append(',');
/* 235 */       buf.append(this.max);
/* 236 */       buf.append(']');
/* 237 */       this.toString = buf.toString();
/*     */     } 
/* 239 */     return this.toString;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\math\NumberRange.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */