/*     */ package org.apache.commons.lang;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CharRange
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = 8270183163158333422L;
/*     */   private final char start;
/*     */   private final char end;
/*     */   private final boolean negated;
/*     */   private transient String iToString;
/*     */   
/*     */   public CharRange(char ch) {
/*  58 */     this(ch, ch, false);
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
/*     */   public CharRange(char ch, boolean negated) {
/*  71 */     this(ch, ch, negated);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CharRange(char start, char end) {
/*  81 */     this(start, end, false);
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
/*     */   public CharRange(char start, char end, boolean negated) {
/* 100 */     if (start > end) {
/* 101 */       char temp = start;
/* 102 */       start = end;
/* 103 */       end = temp;
/*     */     } 
/*     */     
/* 106 */     this.start = start;
/* 107 */     this.end = end;
/* 108 */     this.negated = negated;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char getStart() {
/* 119 */     return this.start;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public char getEnd() {
/* 128 */     return this.end;
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
/*     */   public boolean isNegated() {
/* 140 */     return this.negated;
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
/*     */   public boolean contains(char ch) {
/* 152 */     return (((ch >= this.start && ch <= this.end)) != this.negated);
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
/*     */   public boolean contains(CharRange range) {
/* 164 */     if (range == null) {
/* 165 */       throw new IllegalArgumentException("The Range must not be null");
/*     */     }
/* 167 */     if (this.negated) {
/* 168 */       if (range.negated) {
/* 169 */         return (this.start >= range.start && this.end <= range.end);
/*     */       }
/* 171 */       return (range.end < this.start || range.start > this.end);
/*     */     } 
/*     */     
/* 174 */     if (range.negated) {
/* 175 */       return (this.start == '\000' && this.end == Character.MAX_VALUE);
/*     */     }
/* 177 */     return (this.start <= range.start && this.end >= range.end);
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
/*     */   public boolean equals(Object obj) {
/* 192 */     if (obj == this) {
/* 193 */       return true;
/*     */     }
/* 195 */     if (!(obj instanceof CharRange)) {
/* 196 */       return false;
/*     */     }
/* 198 */     CharRange other = (CharRange)obj;
/* 199 */     return (this.start == other.start && this.end == other.end && this.negated == other.negated);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 208 */     return 83 + this.start + 7 * this.end + (this.negated ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 217 */     if (this.iToString == null) {
/* 218 */       StringBuffer buf = new StringBuffer(4);
/* 219 */       if (isNegated()) {
/* 220 */         buf.append('^');
/*     */       }
/* 222 */       buf.append(this.start);
/* 223 */       if (this.start != this.end) {
/* 224 */         buf.append('-');
/* 225 */         buf.append(this.end);
/*     */       } 
/* 227 */       this.iToString = buf.toString();
/*     */     } 
/* 229 */     return this.iToString;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\CharRange.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */