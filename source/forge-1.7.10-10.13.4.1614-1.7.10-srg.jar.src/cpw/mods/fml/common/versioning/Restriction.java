/*     */ package cpw.mods.fml.common.versioning;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class Restriction
/*     */ {
/*     */   private final ArtifactVersion lowerBound;
/*     */   private final boolean lowerBoundInclusive;
/*     */   private final ArtifactVersion upperBound;
/*     */   private final boolean upperBoundInclusive;
/*  49 */   public static final Restriction EVERYTHING = new Restriction(null, false, null, false);
/*     */ 
/*     */ 
/*     */   
/*     */   public Restriction(ArtifactVersion lowerBound, boolean lowerBoundInclusive, ArtifactVersion upperBound, boolean upperBoundInclusive) {
/*  54 */     this.lowerBound = lowerBound;
/*  55 */     this.lowerBoundInclusive = lowerBoundInclusive;
/*  56 */     this.upperBound = upperBound;
/*  57 */     this.upperBoundInclusive = upperBoundInclusive;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArtifactVersion getLowerBound() {
/*  62 */     return this.lowerBound;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLowerBoundInclusive() {
/*  67 */     return this.lowerBoundInclusive;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArtifactVersion getUpperBound() {
/*  72 */     return this.upperBound;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isUpperBoundInclusive() {
/*  77 */     return this.upperBoundInclusive;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsVersion(ArtifactVersion version) {
/*  82 */     if (this.lowerBound != null) {
/*     */       
/*  84 */       int comparison = this.lowerBound.compareTo(version);
/*     */       
/*  86 */       if (comparison == 0 && !this.lowerBoundInclusive)
/*     */       {
/*  88 */         return false;
/*     */       }
/*  90 */       if (comparison > 0)
/*     */       {
/*  92 */         return false;
/*     */       }
/*     */     } 
/*  95 */     if (this.upperBound != null) {
/*     */       
/*  97 */       int comparison = this.upperBound.compareTo(version);
/*     */       
/*  99 */       if (comparison == 0 && !this.upperBoundInclusive)
/*     */       {
/* 101 */         return false;
/*     */       }
/* 103 */       if (comparison < 0)
/*     */       {
/* 105 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 109 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 115 */     int result = 13;
/*     */     
/* 117 */     if (this.lowerBound == null) {
/*     */       
/* 119 */       result++;
/*     */     }
/*     */     else {
/*     */       
/* 123 */       result += this.lowerBound.hashCode();
/*     */     } 
/*     */     
/* 126 */     result *= this.lowerBoundInclusive ? 1 : 2;
/*     */     
/* 128 */     if (this.upperBound == null) {
/*     */       
/* 130 */       result -= 3;
/*     */     }
/*     */     else {
/*     */       
/* 134 */       result -= this.upperBound.hashCode();
/*     */     } 
/*     */     
/* 137 */     result *= this.upperBoundInclusive ? 2 : 3;
/*     */     
/* 139 */     return result;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object other) {
/* 145 */     if (this == other)
/*     */     {
/* 147 */       return true;
/*     */     }
/*     */     
/* 150 */     if (!(other instanceof Restriction))
/*     */     {
/* 152 */       return false;
/*     */     }
/*     */     
/* 155 */     Restriction restriction = (Restriction)other;
/* 156 */     if (this.lowerBound != null) {
/*     */       
/* 158 */       if (!this.lowerBound.equals(restriction.lowerBound))
/*     */       {
/* 160 */         return false;
/*     */       }
/*     */     }
/* 163 */     else if (restriction.lowerBound != null) {
/*     */       
/* 165 */       return false;
/*     */     } 
/*     */     
/* 168 */     if (this.lowerBoundInclusive != restriction.lowerBoundInclusive)
/*     */     {
/* 170 */       return false;
/*     */     }
/*     */     
/* 173 */     if (this.upperBound != null) {
/*     */       
/* 175 */       if (!this.upperBound.equals(restriction.upperBound))
/*     */       {
/* 177 */         return false;
/*     */       }
/*     */     }
/* 180 */     else if (restriction.upperBound != null) {
/*     */       
/* 182 */       return false;
/*     */     } 
/*     */     
/* 185 */     if (this.upperBoundInclusive != restriction.upperBoundInclusive)
/*     */     {
/* 187 */       return false;
/*     */     }
/*     */     
/* 190 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 196 */     StringBuilder buf = new StringBuilder();
/*     */     
/* 198 */     buf.append(isLowerBoundInclusive() ? "[" : "(");
/* 199 */     if (getLowerBound() != null)
/*     */     {
/* 201 */       buf.append(getLowerBound().toString());
/*     */     }
/* 203 */     buf.append(",");
/* 204 */     if (getUpperBound() != null)
/*     */     {
/* 206 */       buf.append(getUpperBound().toString());
/*     */     }
/* 208 */     buf.append(isUpperBoundInclusive() ? "]" : ")");
/*     */     
/* 210 */     return buf.toString();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\versioning\Restriction.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */