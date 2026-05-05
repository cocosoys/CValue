/*     */ package JinRyuu.JRMCore.server;
/*     */ 
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ 
/*     */ public class JGMathHelper
/*     */ {
/*     */   public static double StringMethod(String method, double n1, double n2) {
/*   9 */     if (method.equals("+")) { n1 += n2; }
/*  10 */     else if (method.equals("-")) { n1 -= n2; }
/*  11 */     else if (method.equals("*")) { n1 *= n2; }
/*  12 */     else if (method.equals("/")) { n1 /= n2; }
/*  13 */     else if (method.equals("%")) { n1 %= n2; }
/*  14 */      return n1;
/*     */   }
/*     */ 
/*     */   
/*     */   public static long StringMethod(String method, long n1, long n2) {
/*  19 */     if (method.equals("+")) { n1 += n2; }
/*  20 */     else if (method.equals("-")) { n1 -= n2; }
/*  21 */     else if (method.equals("*")) { n1 *= n2; }
/*  22 */     else if (method.equals("/")) { n1 /= n2; }
/*  23 */     else if (method.equals("%")) { n1 %= n2; }
/*  24 */      return n1;
/*     */   }
/*     */ 
/*     */   
/*     */   public static double doubleLimit(double value, double max) {
/*  29 */     boolean minus = (value < 0.0D);
/*  30 */     if (minus) value *= -1.0D; 
/*  31 */     if (value > max) value = max; 
/*  32 */     if (minus) value *= -1.0D; 
/*  33 */     return value;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean doubleHigherThan(double value, double min) {
/*  38 */     return (value < 0.0D) ? ((-value > min)) : ((value > min));
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean doubleSmallerThan(double value, double min) {
/*  43 */     return (value < 0.0D) ? ((-value < min)) : ((value < min));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isMotionSmallerThanN(Entity entity, double minMotion, boolean doX, boolean doY, boolean doZ, boolean methodOne) {
/*  49 */     if (methodOne) {
/*     */       
/*  51 */       double d1 = entity.field_70159_w;
/*  52 */       double d2 = entity.field_70181_x;
/*  53 */       double d3 = entity.field_70179_y;
/*  54 */       boolean canDoX = doX ? ((d1 <= minMotion && d1 >= -minMotion)) : true;
/*  55 */       boolean canDoY = doY ? ((d2 <= minMotion && d2 >= -minMotion)) : true;
/*  56 */       boolean canDoZ = doZ ? ((d3 <= minMotion && d3 >= -minMotion)) : true;
/*  57 */       return (canDoX && canDoY && canDoZ);
/*     */     } 
/*     */ 
/*     */     
/*  61 */     double motion = 0.0D;
/*  62 */     double x = doX ? entity.field_70159_w : 0.0D; if (x < 0.0D) x *= -1.0D; 
/*  63 */     double y = doY ? entity.field_70181_x : 0.0D; if (y < 0.0D) y *= -1.0D; 
/*  64 */     double z = doZ ? entity.field_70179_y : 0.0D; if (z < 0.0D) z *= -1.0D; 
/*  65 */     motion += x + y + z;
/*  66 */     return (motion < minMotion);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isMotionBiggerThanN(Entity entity, double minMotion, boolean doX, boolean doY, boolean doZ, boolean methodOne) {
/*  72 */     if (methodOne) {
/*     */       
/*  74 */       double d1 = entity.field_70159_w;
/*  75 */       double d2 = entity.field_70181_x;
/*  76 */       double d3 = entity.field_70179_y;
/*  77 */       boolean canDoX = doX ? ((d1 >= minMotion && d1 <= -minMotion)) : false;
/*  78 */       boolean canDoY = doY ? ((d2 >= minMotion && d2 <= -minMotion)) : false;
/*  79 */       boolean canDoZ = doZ ? ((d3 >= minMotion && d3 <= -minMotion)) : false;
/*  80 */       return (canDoX || canDoY || canDoZ);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/*  85 */     double motion = 0.0D;
/*  86 */     double x = doX ? entity.field_70159_w : 0.0D; if (x < 0.0D) x *= -1.0D; 
/*  87 */     double y = doY ? entity.field_70181_x : 0.0D; if (y < 0.0D) y *= -1.0D; 
/*  88 */     double z = doZ ? entity.field_70179_y : 0.0D; if (z < 0.0D) z *= -1.0D; 
/*  89 */     motion += x + y + z;
/*  90 */     return (motion > minMotion);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isMotionSmallerThanN(Entity entity, double minMotion) {
/*  96 */     return isMotionSmallerThanN(entity, minMotion, true, true, true, true);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isMotionBiggerThanN(Entity entity, double minMotion) {
/* 104 */     return isMotionBiggerThanN(entity, minMotion, true, true, true, true);
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\server\JGMathHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */