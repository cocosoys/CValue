/*     */ package org.apache.commons.lang;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
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
/*     */ {
/*     */   private final Number min;
/*     */   private final Number max;
/*     */   
/*     */   public NumberRange(Number num) {
/*  53 */     if (num == null) {
/*  54 */       throw new NullPointerException("The number must not be null");
/*     */     }
/*     */     
/*  57 */     this.min = num;
/*  58 */     this.max = num;
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
/*     */   public NumberRange(Number min, Number max) {
/*  74 */     if (min == null)
/*  75 */       throw new NullPointerException("The minimum value must not be null"); 
/*  76 */     if (max == null) {
/*  77 */       throw new NullPointerException("The maximum value must not be null");
/*     */     }
/*     */     
/*  80 */     if (max.doubleValue() < min.doubleValue()) {
/*  81 */       this.min = this.max = min;
/*     */     } else {
/*  83 */       this.min = min;
/*  84 */       this.max = max;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getMinimum() {
/*  94 */     return this.min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Number getMaximum() {
/* 103 */     return this.max;
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
/*     */   public boolean includesNumber(Number number) {
/* 115 */     if (number == null) {
/* 116 */       return false;
/*     */     }
/* 118 */     return (this.min.doubleValue() <= number.doubleValue() && this.max.doubleValue() >= number.doubleValue());
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
/*     */   public boolean includesRange(NumberRange range) {
/* 132 */     if (range == null) {
/* 133 */       return false;
/*     */     }
/* 135 */     return (includesNumber(range.min) && includesNumber(range.max));
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
/*     */   public boolean overlaps(NumberRange range) {
/* 148 */     if (range == null) {
/* 149 */       return false;
/*     */     }
/* 151 */     return (range.includesNumber(this.min) || range.includesNumber(this.max) || includesRange(range));
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
/*     */   public boolean equals(Object obj) {
/* 165 */     if (obj == this)
/* 166 */       return true; 
/* 167 */     if (!(obj instanceof NumberRange)) {
/* 168 */       return false;
/*     */     }
/* 170 */     NumberRange range = (NumberRange)obj;
/* 171 */     return (this.min.equals(range.min) && this.max.equals(range.max));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 181 */     int result = 17;
/* 182 */     result = 37 * result + this.min.hashCode();
/* 183 */     result = 37 * result + this.max.hashCode();
/* 184 */     return result;
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
/*     */   public String toString() {
/* 197 */     StringBuffer sb = new StringBuffer();
/*     */     
/* 199 */     if (this.min.doubleValue() < 0.0D) {
/* 200 */       sb.append('(').append(this.min).append(')');
/*     */     }
/*     */     else {
/*     */       
/* 204 */       sb.append(this.min);
/*     */     } 
/*     */     
/* 207 */     sb.append('-');
/*     */     
/* 209 */     if (this.max.doubleValue() < 0.0D) {
/* 210 */       sb.append('(').append(this.max).append(')');
/*     */     }
/*     */     else {
/*     */       
/* 214 */       sb.append(this.max);
/*     */     } 
/*     */     
/* 217 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\NumberRange.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */