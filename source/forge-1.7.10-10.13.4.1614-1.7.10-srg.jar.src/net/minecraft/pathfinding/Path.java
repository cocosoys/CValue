/*     */ package net.minecraft.pathfinding;
/*     */ 
/*     */ public class Path {
/*   4 */   private PathPoint[] field_75852_a = new PathPoint[1024];
/*     */   private int field_75851_b;
/*     */   private static final String __OBFID = "CL_00000573";
/*     */   
/*     */   public PathPoint func_75849_a(PathPoint p_75849_1_) {
/*   9 */     if (p_75849_1_.field_75835_d >= 0) throw new IllegalStateException("OW KNOWS!");
/*     */     
/*  11 */     if (this.field_75851_b == this.field_75852_a.length) {
/*  12 */       PathPoint[] arrayOfPathPoint = new PathPoint[this.field_75851_b << 1];
/*  13 */       System.arraycopy(this.field_75852_a, 0, arrayOfPathPoint, 0, this.field_75851_b);
/*  14 */       this.field_75852_a = arrayOfPathPoint;
/*     */     } 
/*     */ 
/*     */     
/*  18 */     this.field_75852_a[this.field_75851_b] = p_75849_1_;
/*  19 */     p_75849_1_.field_75835_d = this.field_75851_b;
/*  20 */     func_75847_a(this.field_75851_b++);
/*     */     
/*  22 */     return p_75849_1_;
/*     */   }
/*     */   
/*     */   public void func_75848_a() {
/*  26 */     this.field_75851_b = 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PathPoint func_75844_c() {
/*  34 */     PathPoint pathPoint = this.field_75852_a[0];
/*  35 */     this.field_75852_a[0] = this.field_75852_a[--this.field_75851_b];
/*  36 */     this.field_75852_a[this.field_75851_b] = null;
/*  37 */     if (this.field_75851_b > 0) func_75846_b(0); 
/*  38 */     pathPoint.field_75835_d = -1;
/*  39 */     return pathPoint;
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
/*     */   public void func_75850_a(PathPoint p_75850_1_, float p_75850_2_) {
/*  58 */     float f = p_75850_1_.field_75834_g;
/*  59 */     p_75850_1_.field_75834_g = p_75850_2_;
/*  60 */     if (p_75850_2_ < f) {
/*  61 */       func_75847_a(p_75850_1_.field_75835_d);
/*     */     } else {
/*  63 */       func_75846_b(p_75850_1_.field_75835_d);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void func_75847_a(int p_75847_1_) {
/*  72 */     PathPoint pathPoint = this.field_75852_a[p_75847_1_];
/*  73 */     float f = pathPoint.field_75834_g;
/*  74 */     while (p_75847_1_ > 0) {
/*  75 */       int i = p_75847_1_ - 1 >> 1;
/*  76 */       PathPoint pathPoint1 = this.field_75852_a[i];
/*  77 */       if (f < pathPoint1.field_75834_g) {
/*  78 */         this.field_75852_a[p_75847_1_] = pathPoint1;
/*  79 */         pathPoint1.field_75835_d = p_75847_1_;
/*  80 */         p_75847_1_ = i;
/*     */       } 
/*     */     } 
/*  83 */     this.field_75852_a[p_75847_1_] = pathPoint;
/*  84 */     pathPoint.field_75835_d = p_75847_1_;
/*     */   }
/*     */   
/*     */   private void func_75846_b(int p_75846_1_) {
/*  88 */     PathPoint pathPoint = this.field_75852_a[p_75846_1_];
/*  89 */     float f = pathPoint.field_75834_g; while (true) {
/*     */       PathPoint pathPoint2;
/*     */       float f2;
/*  92 */       int i = 1 + (p_75846_1_ << 1);
/*  93 */       int j = i + 1;
/*     */       
/*  95 */       if (i >= this.field_75851_b) {
/*     */         break;
/*     */       }
/*  98 */       PathPoint pathPoint1 = this.field_75852_a[i];
/*  99 */       float f1 = pathPoint1.field_75834_g;
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 104 */       if (j >= this.field_75851_b) {
/*     */         
/* 106 */         pathPoint2 = null;
/* 107 */         f2 = Float.POSITIVE_INFINITY;
/*     */       } else {
/* 109 */         pathPoint2 = this.field_75852_a[j];
/* 110 */         f2 = pathPoint2.field_75834_g;
/*     */       } 
/*     */ 
/*     */ 
/*     */       
/* 115 */       if (f1 < f2) {
/* 116 */         if (f1 < f) {
/* 117 */           this.field_75852_a[p_75846_1_] = pathPoint1;
/* 118 */           pathPoint1.field_75835_d = p_75846_1_;
/* 119 */           p_75846_1_ = i; continue;
/*     */         }  break;
/*     */       } 
/* 122 */       if (f2 < f) {
/* 123 */         this.field_75852_a[p_75846_1_] = pathPoint2;
/* 124 */         pathPoint2.field_75835_d = p_75846_1_;
/* 125 */         p_75846_1_ = j;
/*     */         continue;
/*     */       } 
/*     */       break;
/*     */     } 
/* 130 */     this.field_75852_a[p_75846_1_] = pathPoint;
/* 131 */     pathPoint.field_75835_d = p_75846_1_;
/*     */   }
/*     */   
/*     */   public boolean func_75845_e() {
/* 135 */     return (this.field_75851_b == 0);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\pathfinding\Path.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */