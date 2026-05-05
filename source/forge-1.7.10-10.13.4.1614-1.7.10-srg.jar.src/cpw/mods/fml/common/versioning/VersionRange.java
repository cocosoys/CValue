/*     */ package cpw.mods.fml.common.versioning;
/*     */ 
/*     */ import com.google.common.base.Joiner;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collections;
/*     */ import java.util.Iterator;
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
/*     */ public class VersionRange
/*     */ {
/*     */   private final ArtifactVersion recommendedVersion;
/*     */   private final List<Restriction> restrictions;
/*     */   
/*     */   private VersionRange(ArtifactVersion recommendedVersion, List<Restriction> restrictions) {
/*  58 */     this.recommendedVersion = recommendedVersion;
/*  59 */     this.restrictions = restrictions;
/*     */   }
/*     */ 
/*     */   
/*     */   public ArtifactVersion getRecommendedVersion() {
/*  64 */     return this.recommendedVersion;
/*     */   }
/*     */ 
/*     */   
/*     */   public List<Restriction> getRestrictions() {
/*  69 */     return this.restrictions;
/*     */   }
/*     */ 
/*     */   
/*     */   public VersionRange cloneOf() {
/*  74 */     List<Restriction> copiedRestrictions = null;
/*     */     
/*  76 */     if (this.restrictions != null) {
/*     */       
/*  78 */       copiedRestrictions = new ArrayList<Restriction>();
/*     */       
/*  80 */       if (!this.restrictions.isEmpty())
/*     */       {
/*  82 */         copiedRestrictions.addAll(this.restrictions);
/*     */       }
/*     */     } 
/*     */     
/*  86 */     return new VersionRange(this.recommendedVersion, copiedRestrictions);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static VersionRange newRange(ArtifactVersion version, List<Restriction> restrictions) {
/*  97 */     return new VersionRange(version, restrictions);
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
/*     */   public static VersionRange createFromVersionSpec(String spec) throws InvalidVersionSpecificationException {
/* 119 */     if (spec == null)
/*     */     {
/* 121 */       return null;
/*     */     }
/*     */     
/* 124 */     List<Restriction> restrictions = new ArrayList<Restriction>();
/* 125 */     String process = spec;
/* 126 */     ArtifactVersion version = null;
/* 127 */     ArtifactVersion upperBound = null;
/* 128 */     ArtifactVersion lowerBound = null;
/*     */     
/* 130 */     while (process.startsWith("[") || process.startsWith("(")) {
/*     */       
/* 132 */       int index1 = process.indexOf(")");
/* 133 */       int index2 = process.indexOf("]");
/*     */       
/* 135 */       int index = index2;
/* 136 */       if (index2 < 0 || index1 < index2)
/*     */       {
/* 138 */         if (index1 >= 0)
/*     */         {
/* 140 */           index = index1;
/*     */         }
/*     */       }
/*     */       
/* 144 */       if (index < 0)
/*     */       {
/* 146 */         throw new InvalidVersionSpecificationException("Unbounded range: " + spec);
/*     */       }
/*     */       
/* 149 */       Restriction restriction = parseRestriction(process.substring(0, index + 1));
/* 150 */       if (lowerBound == null)
/*     */       {
/* 152 */         lowerBound = restriction.getLowerBound();
/*     */       }
/* 154 */       if (upperBound != null)
/*     */       {
/* 156 */         if (restriction.getLowerBound() == null || restriction.getLowerBound().compareTo(upperBound) < 0)
/*     */         {
/* 158 */           throw new InvalidVersionSpecificationException("Ranges overlap: " + spec);
/*     */         }
/*     */       }
/* 161 */       restrictions.add(restriction);
/* 162 */       upperBound = restriction.getUpperBound();
/*     */       
/* 164 */       process = process.substring(index + 1).trim();
/*     */       
/* 166 */       if (process.length() > 0 && process.startsWith(","))
/*     */       {
/* 168 */         process = process.substring(1).trim();
/*     */       }
/*     */     } 
/*     */     
/* 172 */     if (process.length() > 0) {
/*     */       
/* 174 */       if (restrictions.size() > 0)
/*     */       {
/* 176 */         throw new InvalidVersionSpecificationException("Only fully-qualified sets allowed in multiple set scenario: " + spec);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 181 */       version = new DefaultArtifactVersion(process);
/* 182 */       restrictions.add(Restriction.EVERYTHING);
/*     */     } 
/*     */ 
/*     */     
/* 186 */     return new VersionRange(version, restrictions);
/*     */   }
/*     */ 
/*     */   
/*     */   private static Restriction parseRestriction(String spec) throws InvalidVersionSpecificationException {
/*     */     Restriction restriction;
/* 192 */     boolean lowerBoundInclusive = spec.startsWith("[");
/* 193 */     boolean upperBoundInclusive = spec.endsWith("]");
/*     */     
/* 195 */     String process = spec.substring(1, spec.length() - 1).trim();
/*     */ 
/*     */ 
/*     */     
/* 199 */     int index = process.indexOf(",");
/*     */     
/* 201 */     if (index < 0) {
/*     */       
/* 203 */       if (!lowerBoundInclusive || !upperBoundInclusive)
/*     */       {
/* 205 */         throw new InvalidVersionSpecificationException("Single version must be surrounded by []: " + spec);
/*     */       }
/*     */       
/* 208 */       ArtifactVersion version = new DefaultArtifactVersion(process);
/*     */       
/* 210 */       restriction = new Restriction(version, lowerBoundInclusive, version, upperBoundInclusive);
/*     */     }
/*     */     else {
/*     */       
/* 214 */       String lowerBound = process.substring(0, index).trim();
/* 215 */       String upperBound = process.substring(index + 1).trim();
/* 216 */       if (lowerBound.equals(upperBound))
/*     */       {
/* 218 */         throw new InvalidVersionSpecificationException("Range cannot have identical boundaries: " + spec);
/*     */       }
/*     */       
/* 221 */       ArtifactVersion lowerVersion = null;
/* 222 */       if (lowerBound.length() > 0)
/*     */       {
/* 224 */         lowerVersion = new DefaultArtifactVersion(lowerBound);
/*     */       }
/* 226 */       ArtifactVersion upperVersion = null;
/* 227 */       if (upperBound.length() > 0)
/*     */       {
/* 229 */         upperVersion = new DefaultArtifactVersion(upperBound);
/*     */       }
/*     */       
/* 232 */       if (upperVersion != null && lowerVersion != null && upperVersion.compareTo(lowerVersion) < 0)
/*     */       {
/* 234 */         throw new InvalidVersionSpecificationException("Range defies version ordering: " + spec);
/*     */       }
/*     */       
/* 237 */       restriction = new Restriction(lowerVersion, lowerBoundInclusive, upperVersion, upperBoundInclusive);
/*     */     } 
/*     */     
/* 240 */     return restriction;
/*     */   }
/*     */ 
/*     */   
/*     */   public static VersionRange createFromVersion(String version, ArtifactVersion existing) {
/* 245 */     List<Restriction> restrictions = Collections.emptyList();
/* 246 */     if (existing == null)
/*     */     {
/* 248 */       existing = new DefaultArtifactVersion(version);
/*     */     }
/* 250 */     return new VersionRange(existing, restrictions);
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
/*     */ 
/*     */ 
/*     */   
/*     */   public VersionRange restrict(VersionRange restriction) {
/* 283 */     List<Restriction> restrictions, r1 = this.restrictions;
/* 284 */     List<Restriction> r2 = restriction.restrictions;
/*     */ 
/*     */     
/* 287 */     if (r1.isEmpty() || r2.isEmpty()) {
/*     */       
/* 289 */       restrictions = Collections.emptyList();
/*     */     }
/*     */     else {
/*     */       
/* 293 */       restrictions = intersection(r1, r2);
/*     */     } 
/*     */     
/* 296 */     ArtifactVersion version = null;
/* 297 */     if (restrictions.size() > 0) {
/*     */       
/* 299 */       for (Restriction r : restrictions)
/*     */       {
/* 301 */         if (this.recommendedVersion != null && r.containsVersion(this.recommendedVersion)) {
/*     */ 
/*     */           
/* 304 */           version = this.recommendedVersion;
/*     */           break;
/*     */         } 
/* 307 */         if (version == null && restriction.getRecommendedVersion() != null && r
/* 308 */           .containsVersion(restriction.getRecommendedVersion()))
/*     */         {
/*     */           
/* 311 */           version = restriction.getRecommendedVersion();
/*     */         }
/*     */       }
/*     */     
/*     */     }
/* 316 */     else if (this.recommendedVersion != null) {
/*     */ 
/*     */       
/* 319 */       version = this.recommendedVersion;
/*     */     }
/* 321 */     else if (restriction.recommendedVersion != null) {
/*     */ 
/*     */ 
/*     */       
/* 325 */       version = restriction.recommendedVersion;
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 334 */     return new VersionRange(version, restrictions);
/*     */   }
/*     */ 
/*     */   
/*     */   private List<Restriction> intersection(List<Restriction> r1, List<Restriction> r2) {
/* 339 */     List<Restriction> restrictions = new ArrayList<Restriction>(r1.size() + r2.size());
/* 340 */     Iterator<Restriction> i1 = r1.iterator();
/* 341 */     Iterator<Restriction> i2 = r2.iterator();
/* 342 */     Restriction res1 = i1.next();
/* 343 */     Restriction res2 = i2.next();
/*     */     
/* 345 */     boolean done = false;
/* 346 */     while (!done) {
/*     */       
/* 348 */       if (res1.getLowerBound() == null || res2.getUpperBound() == null || res1
/* 349 */         .getLowerBound().compareTo(res2.getUpperBound()) <= 0) {
/*     */         
/* 351 */         if (res1.getUpperBound() == null || res2.getLowerBound() == null || res1
/* 352 */           .getUpperBound().compareTo(res2.getLowerBound()) >= 0) {
/*     */           ArtifactVersion lower, upper;
/*     */ 
/*     */ 
/*     */           
/*     */           boolean lowerInclusive, upperInclusive;
/*     */ 
/*     */           
/* 360 */           if (res1.getLowerBound() == null) {
/*     */             
/* 362 */             lower = res2.getLowerBound();
/* 363 */             lowerInclusive = res2.isLowerBoundInclusive();
/*     */           }
/* 365 */           else if (res2.getLowerBound() == null) {
/*     */             
/* 367 */             lower = res1.getLowerBound();
/* 368 */             lowerInclusive = res1.isLowerBoundInclusive();
/*     */           }
/*     */           else {
/*     */             
/* 372 */             int comparison = res1.getLowerBound().compareTo(res2.getLowerBound());
/* 373 */             if (comparison < 0) {
/*     */               
/* 375 */               lower = res2.getLowerBound();
/* 376 */               lowerInclusive = res2.isLowerBoundInclusive();
/*     */             }
/* 378 */             else if (comparison == 0) {
/*     */               
/* 380 */               lower = res1.getLowerBound();
/* 381 */               lowerInclusive = (res1.isLowerBoundInclusive() && res2.isLowerBoundInclusive());
/*     */             }
/*     */             else {
/*     */               
/* 385 */               lower = res1.getLowerBound();
/* 386 */               lowerInclusive = res1.isLowerBoundInclusive();
/*     */             } 
/*     */           } 
/*     */           
/* 390 */           if (res1.getUpperBound() == null) {
/*     */             
/* 392 */             upper = res2.getUpperBound();
/* 393 */             upperInclusive = res2.isUpperBoundInclusive();
/*     */           }
/* 395 */           else if (res2.getUpperBound() == null) {
/*     */             
/* 397 */             upper = res1.getUpperBound();
/* 398 */             upperInclusive = res1.isUpperBoundInclusive();
/*     */           }
/*     */           else {
/*     */             
/* 402 */             int comparison = res1.getUpperBound().compareTo(res2.getUpperBound());
/* 403 */             if (comparison < 0) {
/*     */               
/* 405 */               upper = res1.getUpperBound();
/* 406 */               upperInclusive = res1.isUpperBoundInclusive();
/*     */             }
/* 408 */             else if (comparison == 0) {
/*     */               
/* 410 */               upper = res1.getUpperBound();
/* 411 */               upperInclusive = (res1.isUpperBoundInclusive() && res2.isUpperBoundInclusive());
/*     */             }
/*     */             else {
/*     */               
/* 415 */               upper = res2.getUpperBound();
/* 416 */               upperInclusive = res2.isUpperBoundInclusive();
/*     */             } 
/*     */           } 
/*     */ 
/*     */           
/* 421 */           if (lower == null || upper == null || lower.compareTo(upper) != 0) {
/*     */             
/* 423 */             restrictions.add(new Restriction(lower, lowerInclusive, upper, upperInclusive));
/*     */           }
/* 425 */           else if (lowerInclusive && upperInclusive) {
/*     */             
/* 427 */             restrictions.add(new Restriction(lower, lowerInclusive, upper, upperInclusive));
/*     */           } 
/*     */ 
/*     */           
/* 431 */           if (upper == res2.getUpperBound()) {
/*     */ 
/*     */             
/* 434 */             if (i2.hasNext()) {
/*     */               
/* 436 */               res2 = i2.next();
/*     */               
/*     */               continue;
/*     */             } 
/* 440 */             done = true;
/*     */ 
/*     */             
/*     */             continue;
/*     */           } 
/*     */           
/* 446 */           if (i1.hasNext()) {
/*     */             
/* 448 */             res1 = i1.next();
/*     */             
/*     */             continue;
/*     */           } 
/* 452 */           done = true;
/*     */ 
/*     */           
/*     */           continue;
/*     */         } 
/*     */ 
/*     */         
/* 459 */         if (i1.hasNext()) {
/*     */           
/* 461 */           res1 = i1.next();
/*     */           
/*     */           continue;
/*     */         } 
/* 465 */         done = true;
/*     */ 
/*     */         
/*     */         continue;
/*     */       } 
/*     */ 
/*     */       
/* 472 */       if (i2.hasNext()) {
/*     */         
/* 474 */         res2 = i2.next();
/*     */         
/*     */         continue;
/*     */       } 
/* 478 */       done = true;
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 483 */     return restrictions;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 489 */     if (this.recommendedVersion != null)
/*     */     {
/* 491 */       return this.recommendedVersion.toString();
/*     */     }
/*     */ 
/*     */     
/* 495 */     return Joiner.on(',').join(this.restrictions);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ArtifactVersion matchVersion(List<ArtifactVersion> versions) {
/* 503 */     ArtifactVersion matched = null;
/* 504 */     for (ArtifactVersion version : versions) {
/*     */       
/* 506 */       if (containsVersion(version))
/*     */       {
/*     */         
/* 509 */         if (matched == null || version.compareTo(matched) > 0)
/*     */         {
/* 511 */           matched = version;
/*     */         }
/*     */       }
/*     */     } 
/* 515 */     return matched;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean containsVersion(ArtifactVersion version) {
/* 520 */     for (Restriction restriction : this.restrictions) {
/*     */       
/* 522 */       if (restriction.containsVersion(version))
/*     */       {
/* 524 */         return true;
/*     */       }
/*     */     } 
/* 527 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean hasRestrictions() {
/* 532 */     return (!this.restrictions.isEmpty() && this.recommendedVersion == null);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean equals(Object obj) {
/* 538 */     if (this == obj)
/*     */     {
/* 540 */       return true;
/*     */     }
/* 542 */     if (!(obj instanceof VersionRange))
/*     */     {
/* 544 */       return false;
/*     */     }
/* 546 */     VersionRange other = (VersionRange)obj;
/*     */ 
/*     */ 
/*     */     
/* 550 */     boolean equals = (this.recommendedVersion == other.recommendedVersion || (this.recommendedVersion != null && this.recommendedVersion.equals(other.recommendedVersion)));
/*     */ 
/*     */     
/* 553 */     return equals & ((this.restrictions == other.restrictions || (this.restrictions != null && this.restrictions.equals(other.restrictions))) ? 1 : 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 560 */     int hash = 7;
/* 561 */     hash = 31 * hash + ((this.recommendedVersion == null) ? 0 : this.recommendedVersion.hashCode());
/* 562 */     hash = 31 * hash + ((this.restrictions == null) ? 0 : this.restrictions.hashCode());
/* 563 */     return hash;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isUnboundedAbove() {
/* 568 */     return (this.restrictions.size() == 1 && ((Restriction)this.restrictions.get(0)).getUpperBound() == null && !((Restriction)this.restrictions.get(0)).isUpperBoundInclusive());
/*     */   }
/*     */ 
/*     */   
/*     */   public String getLowerBoundString() {
/* 573 */     return (this.restrictions.size() == 1) ? ((Restriction)this.restrictions.get(0)).getLowerBound().getVersionString() : "";
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\versioning\VersionRange.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */