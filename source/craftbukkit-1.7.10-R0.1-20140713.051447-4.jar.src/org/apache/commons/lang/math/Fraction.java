/*     */ package org.apache.commons.lang.math;
/*     */ 
/*     */ import java.math.BigInteger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class Fraction
/*     */   extends Number
/*     */   implements Comparable
/*     */ {
/*     */   private static final long serialVersionUID = 65382027393090L;
/*  48 */   public static final Fraction ZERO = new Fraction(0, 1);
/*     */ 
/*     */ 
/*     */   
/*  52 */   public static final Fraction ONE = new Fraction(1, 1);
/*     */ 
/*     */ 
/*     */   
/*  56 */   public static final Fraction ONE_HALF = new Fraction(1, 2);
/*     */ 
/*     */ 
/*     */   
/*  60 */   public static final Fraction ONE_THIRD = new Fraction(1, 3);
/*     */ 
/*     */ 
/*     */   
/*  64 */   public static final Fraction TWO_THIRDS = new Fraction(2, 3);
/*     */ 
/*     */ 
/*     */   
/*  68 */   public static final Fraction ONE_QUARTER = new Fraction(1, 4);
/*     */ 
/*     */ 
/*     */   
/*  72 */   public static final Fraction TWO_QUARTERS = new Fraction(2, 4);
/*     */ 
/*     */ 
/*     */   
/*  76 */   public static final Fraction THREE_QUARTERS = new Fraction(3, 4);
/*     */ 
/*     */ 
/*     */   
/*  80 */   public static final Fraction ONE_FIFTH = new Fraction(1, 5);
/*     */ 
/*     */ 
/*     */   
/*  84 */   public static final Fraction TWO_FIFTHS = new Fraction(2, 5);
/*     */ 
/*     */ 
/*     */   
/*  88 */   public static final Fraction THREE_FIFTHS = new Fraction(3, 5);
/*     */ 
/*     */ 
/*     */   
/*  92 */   public static final Fraction FOUR_FIFTHS = new Fraction(4, 5);
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int numerator;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int denominator;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/* 107 */   private transient int hashCode = 0;
/*     */ 
/*     */ 
/*     */   
/* 111 */   private transient String toString = null;
/*     */ 
/*     */ 
/*     */   
/* 115 */   private transient String toProperString = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Fraction(int numerator, int denominator) {
/* 126 */     this.numerator = numerator;
/* 127 */     this.denominator = denominator;
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
/*     */   public static Fraction getFraction(int numerator, int denominator) {
/* 142 */     if (denominator == 0) {
/* 143 */       throw new ArithmeticException("The denominator must not be zero");
/*     */     }
/* 145 */     if (denominator < 0) {
/* 146 */       if (numerator == Integer.MIN_VALUE || denominator == Integer.MIN_VALUE)
/*     */       {
/* 148 */         throw new ArithmeticException("overflow: can't negate");
/*     */       }
/* 150 */       numerator = -numerator;
/* 151 */       denominator = -denominator;
/*     */     } 
/* 153 */     return new Fraction(numerator, denominator);
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
/*     */   public static Fraction getFraction(int whole, int numerator, int denominator) {
/*     */     long l;
/* 173 */     if (denominator == 0) {
/* 174 */       throw new ArithmeticException("The denominator must not be zero");
/*     */     }
/* 176 */     if (denominator < 0) {
/* 177 */       throw new ArithmeticException("The denominator must not be negative");
/*     */     }
/* 179 */     if (numerator < 0) {
/* 180 */       throw new ArithmeticException("The numerator must not be negative");
/*     */     }
/*     */     
/* 183 */     if (whole < 0) {
/* 184 */       l = whole * denominator - numerator;
/*     */     } else {
/* 186 */       l = whole * denominator + numerator;
/*     */     } 
/* 188 */     if (l < -2147483648L || l > 2147483647L)
/*     */     {
/* 190 */       throw new ArithmeticException("Numerator too large to represent as an Integer.");
/*     */     }
/* 192 */     return new Fraction((int)l, denominator);
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
/*     */   public static Fraction getReducedFraction(int numerator, int denominator) {
/* 210 */     if (denominator == 0) {
/* 211 */       throw new ArithmeticException("The denominator must not be zero");
/*     */     }
/* 213 */     if (numerator == 0) {
/* 214 */       return ZERO;
/*     */     }
/*     */     
/* 217 */     if (denominator == Integer.MIN_VALUE && (numerator & 0x1) == 0) {
/* 218 */       numerator /= 2; denominator /= 2;
/*     */     } 
/* 220 */     if (denominator < 0) {
/* 221 */       if (numerator == Integer.MIN_VALUE || denominator == Integer.MIN_VALUE)
/*     */       {
/* 223 */         throw new ArithmeticException("overflow: can't negate");
/*     */       }
/* 225 */       numerator = -numerator;
/* 226 */       denominator = -denominator;
/*     */     } 
/*     */     
/* 229 */     int gcd = greatestCommonDivisor(numerator, denominator);
/* 230 */     numerator /= gcd;
/* 231 */     denominator /= gcd;
/* 232 */     return new Fraction(numerator, denominator);
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
/*     */   public static Fraction getFraction(double value) {
/*     */     double delta1;
/* 250 */     int sign = (value < 0.0D) ? -1 : 1;
/* 251 */     value = Math.abs(value);
/* 252 */     if (value > 2.147483647E9D || Double.isNaN(value)) {
/* 253 */       throw new ArithmeticException("The value must not be greater than Integer.MAX_VALUE or NaN");
/*     */     }
/*     */     
/* 256 */     int wholeNumber = (int)value;
/* 257 */     value -= wholeNumber;
/*     */     
/* 259 */     int numer0 = 0;
/* 260 */     int denom0 = 1;
/* 261 */     int numer1 = 1;
/* 262 */     int denom1 = 0;
/* 263 */     int numer2 = 0;
/* 264 */     int denom2 = 0;
/* 265 */     int a1 = (int)value;
/* 266 */     int a2 = 0;
/* 267 */     double x1 = 1.0D;
/* 268 */     double x2 = 0.0D;
/* 269 */     double y1 = value - a1;
/* 270 */     double y2 = 0.0D;
/* 271 */     double delta2 = Double.MAX_VALUE;
/*     */     
/* 273 */     int i = 1;
/*     */     
/*     */     do {
/* 276 */       delta1 = delta2;
/* 277 */       a2 = (int)(x1 / y1);
/* 278 */       x2 = y1;
/* 279 */       y2 = x1 - a2 * y1;
/* 280 */       numer2 = a1 * numer1 + numer0;
/* 281 */       denom2 = a1 * denom1 + denom0;
/* 282 */       double fraction = numer2 / denom2;
/* 283 */       delta2 = Math.abs(value - fraction);
/*     */       
/* 285 */       a1 = a2;
/* 286 */       x1 = x2;
/* 287 */       y1 = y2;
/* 288 */       numer0 = numer1;
/* 289 */       denom0 = denom1;
/* 290 */       numer1 = numer2;
/* 291 */       denom1 = denom2;
/* 292 */       i++;
/*     */     }
/* 294 */     while (delta1 > delta2 && denom2 <= 10000 && denom2 > 0 && i < 25);
/* 295 */     if (i == 25) {
/* 296 */       throw new ArithmeticException("Unable to convert double to fraction");
/*     */     }
/* 298 */     return getReducedFraction((numer0 + wholeNumber * denom0) * sign, denom0);
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
/*     */   public static Fraction getFraction(String str) {
/* 320 */     if (str == null) {
/* 321 */       throw new IllegalArgumentException("The string must not be null");
/*     */     }
/*     */     
/* 324 */     int pos = str.indexOf('.');
/* 325 */     if (pos >= 0) {
/* 326 */       return getFraction(Double.parseDouble(str));
/*     */     }
/*     */ 
/*     */     
/* 330 */     pos = str.indexOf(' ');
/* 331 */     if (pos > 0) {
/* 332 */       int whole = Integer.parseInt(str.substring(0, pos));
/* 333 */       str = str.substring(pos + 1);
/* 334 */       pos = str.indexOf('/');
/* 335 */       if (pos < 0) {
/* 336 */         throw new NumberFormatException("The fraction could not be parsed as the format X Y/Z");
/*     */       }
/* 338 */       int i = Integer.parseInt(str.substring(0, pos));
/* 339 */       int j = Integer.parseInt(str.substring(pos + 1));
/* 340 */       return getFraction(whole, i, j);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 345 */     pos = str.indexOf('/');
/* 346 */     if (pos < 0)
/*     */     {
/* 348 */       return getFraction(Integer.parseInt(str), 1);
/*     */     }
/* 350 */     int numer = Integer.parseInt(str.substring(0, pos));
/* 351 */     int denom = Integer.parseInt(str.substring(pos + 1));
/* 352 */     return getFraction(numer, denom);
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
/*     */   public int getNumerator() {
/* 368 */     return this.numerator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getDenominator() {
/* 377 */     return this.denominator;
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
/*     */   public int getProperNumerator() {
/* 392 */     return Math.abs(this.numerator % this.denominator);
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
/*     */   public int getProperWhole() {
/* 407 */     return this.numerator / this.denominator;
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
/*     */   public int intValue() {
/* 420 */     return this.numerator / this.denominator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long longValue() {
/* 430 */     return this.numerator / this.denominator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float floatValue() {
/* 440 */     return this.numerator / this.denominator;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public double doubleValue() {
/* 450 */     return this.numerator / this.denominator;
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
/*     */   public Fraction reduce() {
/* 466 */     int gcd = greatestCommonDivisor(Math.abs(this.numerator), this.denominator);
/* 467 */     if (gcd == 1) {
/* 468 */       return this;
/*     */     }
/* 470 */     return getFraction(this.numerator / gcd, this.denominator / gcd);
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
/*     */   public Fraction invert() {
/* 483 */     if (this.numerator == 0) {
/* 484 */       throw new ArithmeticException("Unable to invert zero.");
/*     */     }
/* 486 */     if (this.numerator == Integer.MIN_VALUE) {
/* 487 */       throw new ArithmeticException("overflow: can't negate numerator");
/*     */     }
/* 489 */     if (this.numerator < 0) {
/* 490 */       return new Fraction(-this.denominator, -this.numerator);
/*     */     }
/* 492 */     return new Fraction(this.denominator, this.numerator);
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
/*     */   public Fraction negate() {
/* 505 */     if (this.numerator == Integer.MIN_VALUE) {
/* 506 */       throw new ArithmeticException("overflow: too large to negate");
/*     */     }
/* 508 */     return new Fraction(-this.numerator, this.denominator);
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
/*     */   public Fraction abs() {
/* 521 */     if (this.numerator >= 0) {
/* 522 */       return this;
/*     */     }
/* 524 */     return negate();
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
/*     */   public Fraction pow(int power) {
/* 540 */     if (power == 1)
/* 541 */       return this; 
/* 542 */     if (power == 0)
/* 543 */       return ONE; 
/* 544 */     if (power < 0) {
/* 545 */       if (power == Integer.MIN_VALUE) {
/* 546 */         return invert().pow(2).pow(-(power / 2));
/*     */       }
/* 548 */       return invert().pow(-power);
/*     */     } 
/* 550 */     Fraction f = multiplyBy(this);
/* 551 */     if (power % 2 == 0) {
/* 552 */       return f.pow(power / 2);
/*     */     }
/* 554 */     return f.pow(power / 2).multiplyBy(this);
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
/*     */   private static int greatestCommonDivisor(int u, int v) {
/* 575 */     if (u > 0) u = -u; 
/* 576 */     if (v > 0) v = -v;
/*     */     
/* 578 */     int k = 0;
/* 579 */     while ((u & 0x1) == 0 && (v & 0x1) == 0 && k < 31) {
/* 580 */       u /= 2; v /= 2; k++;
/*     */     } 
/* 582 */     if (k == 31) {
/* 583 */       throw new ArithmeticException("overflow: gcd is 2^31");
/*     */     }
/*     */ 
/*     */     
/* 587 */     int t = ((u & 0x1) == 1) ? v : -(u / 2);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     while (true) {
/* 593 */       while ((t & 0x1) != 0) {
/*     */ 
/*     */ 
/*     */         
/* 597 */         if (t > 0) {
/* 598 */           u = -t;
/*     */         } else {
/* 600 */           v = t;
/*     */         } 
/*     */         
/* 603 */         t = (v - u) / 2;
/*     */ 
/*     */         
/* 606 */         if (t == 0) {
/* 607 */           return -u * (1 << k);
/*     */         }
/*     */       } 
/*     */       t /= 2;
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
/*     */   private static int mulAndCheck(int x, int y) {
/* 623 */     long m = x * y;
/* 624 */     if (m < -2147483648L || m > 2147483647L)
/*     */     {
/* 626 */       throw new ArithmeticException("overflow: mul");
/*     */     }
/* 628 */     return (int)m;
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
/*     */   private static int mulPosAndCheck(int x, int y) {
/* 642 */     long m = x * y;
/* 643 */     if (m > 2147483647L) {
/* 644 */       throw new ArithmeticException("overflow: mulPos");
/*     */     }
/* 646 */     return (int)m;
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
/*     */   private static int addAndCheck(int x, int y) {
/* 659 */     long s = x + y;
/* 660 */     if (s < -2147483648L || s > 2147483647L)
/*     */     {
/* 662 */       throw new ArithmeticException("overflow: add");
/*     */     }
/* 664 */     return (int)s;
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
/*     */   private static int subAndCheck(int x, int y) {
/* 677 */     long s = x - y;
/* 678 */     if (s < -2147483648L || s > 2147483647L)
/*     */     {
/* 680 */       throw new ArithmeticException("overflow: add");
/*     */     }
/* 682 */     return (int)s;
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
/*     */   public Fraction add(Fraction fraction) {
/* 696 */     return addSub(fraction, true);
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
/*     */   public Fraction subtract(Fraction fraction) {
/* 710 */     return addSub(fraction, false);
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
/*     */   private Fraction addSub(Fraction fraction, boolean isAdd) {
/* 724 */     if (fraction == null) {
/* 725 */       throw new IllegalArgumentException("The fraction must not be null");
/*     */     }
/*     */     
/* 728 */     if (this.numerator == 0) {
/* 729 */       return isAdd ? fraction : fraction.negate();
/*     */     }
/* 731 */     if (fraction.numerator == 0) {
/* 732 */       return this;
/*     */     }
/*     */ 
/*     */     
/* 736 */     int d1 = greatestCommonDivisor(this.denominator, fraction.denominator);
/* 737 */     if (d1 == 1) {
/*     */       
/* 739 */       int i = mulAndCheck(this.numerator, fraction.denominator);
/* 740 */       int j = mulAndCheck(fraction.numerator, this.denominator);
/* 741 */       return new Fraction(isAdd ? addAndCheck(i, j) : subAndCheck(i, j), mulPosAndCheck(this.denominator, fraction.denominator));
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 748 */     BigInteger uvp = BigInteger.valueOf(this.numerator).multiply(BigInteger.valueOf((fraction.denominator / d1)));
/*     */     
/* 750 */     BigInteger upv = BigInteger.valueOf(fraction.numerator).multiply(BigInteger.valueOf((this.denominator / d1)));
/*     */     
/* 752 */     BigInteger t = isAdd ? uvp.add(upv) : uvp.subtract(upv);
/*     */ 
/*     */     
/* 755 */     int tmodd1 = t.mod(BigInteger.valueOf(d1)).intValue();
/* 756 */     int d2 = (tmodd1 == 0) ? d1 : greatestCommonDivisor(tmodd1, d1);
/*     */ 
/*     */     
/* 759 */     BigInteger w = t.divide(BigInteger.valueOf(d2));
/* 760 */     if (w.bitLength() > 31) {
/* 761 */       throw new ArithmeticException("overflow: numerator too large after multiply");
/*     */     }
/*     */     
/* 764 */     return new Fraction(w.intValue(), mulPosAndCheck(this.denominator / d1, fraction.denominator / d2));
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
/*     */   public Fraction multiplyBy(Fraction fraction) {
/* 780 */     if (fraction == null) {
/* 781 */       throw new IllegalArgumentException("The fraction must not be null");
/*     */     }
/* 783 */     if (this.numerator == 0 || fraction.numerator == 0) {
/* 784 */       return ZERO;
/*     */     }
/*     */ 
/*     */     
/* 788 */     int d1 = greatestCommonDivisor(this.numerator, fraction.denominator);
/* 789 */     int d2 = greatestCommonDivisor(fraction.numerator, this.denominator);
/* 790 */     return getReducedFraction(mulAndCheck(this.numerator / d1, fraction.numerator / d2), mulPosAndCheck(this.denominator / d2, fraction.denominator / d1));
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
/*     */   public Fraction divideBy(Fraction fraction) {
/* 806 */     if (fraction == null) {
/* 807 */       throw new IllegalArgumentException("The fraction must not be null");
/*     */     }
/* 809 */     if (fraction.numerator == 0) {
/* 810 */       throw new ArithmeticException("The fraction to divide by must not be zero");
/*     */     }
/* 812 */     return multiplyBy(fraction.invert());
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
/* 827 */     if (obj == this) {
/* 828 */       return true;
/*     */     }
/* 830 */     if (!(obj instanceof Fraction)) {
/* 831 */       return false;
/*     */     }
/* 833 */     Fraction other = (Fraction)obj;
/* 834 */     return (getNumerator() == other.getNumerator() && getDenominator() == other.getDenominator());
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int hashCode() {
/* 844 */     if (this.hashCode == 0)
/*     */     {
/* 846 */       this.hashCode = 37 * (629 + getNumerator()) + getDenominator();
/*     */     }
/* 848 */     return this.hashCode;
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
/*     */   public int compareTo(Object object) {
/* 864 */     Fraction other = (Fraction)object;
/* 865 */     if (this == other) {
/* 866 */       return 0;
/*     */     }
/* 868 */     if (this.numerator == other.numerator && this.denominator == other.denominator) {
/* 869 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 873 */     long first = this.numerator * other.denominator;
/* 874 */     long second = other.numerator * this.denominator;
/* 875 */     if (first == second)
/* 876 */       return 0; 
/* 877 */     if (first < second) {
/* 878 */       return -1;
/*     */     }
/* 880 */     return 1;
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
/*     */   public String toString() {
/* 892 */     if (this.toString == null) {
/* 893 */       this.toString = (new StringBuffer(32)).append(getNumerator()).append('/').append(getDenominator()).toString();
/*     */     }
/*     */ 
/*     */ 
/*     */     
/* 898 */     return this.toString;
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
/*     */   public String toProperString() {
/* 911 */     if (this.toProperString == null) {
/* 912 */       if (this.numerator == 0) {
/* 913 */         this.toProperString = "0";
/* 914 */       } else if (this.numerator == this.denominator) {
/* 915 */         this.toProperString = "1";
/* 916 */       } else if (this.numerator == -1 * this.denominator) {
/* 917 */         this.toProperString = "-1";
/* 918 */       } else if (((this.numerator > 0) ? -this.numerator : this.numerator) < -this.denominator) {
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 923 */         int properNumerator = getProperNumerator();
/* 924 */         if (properNumerator == 0) {
/* 925 */           this.toProperString = Integer.toString(getProperWhole());
/*     */         } else {
/* 927 */           this.toProperString = (new StringBuffer(32)).append(getProperWhole()).append(' ').append(properNumerator).append('/').append(getDenominator()).toString();
/*     */         }
/*     */       
/*     */       }
/*     */       else {
/*     */         
/* 933 */         this.toProperString = (new StringBuffer(32)).append(getNumerator()).append('/').append(getDenominator()).toString();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/* 938 */     return this.toProperString;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\math\Fraction.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */