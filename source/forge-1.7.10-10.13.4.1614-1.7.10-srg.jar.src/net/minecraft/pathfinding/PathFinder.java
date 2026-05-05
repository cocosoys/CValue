/*     */ package net.minecraft.pathfinding;
/*     */ 
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.IntHashMap;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.IBlockAccess;
/*     */ 
/*     */ public class PathFinder {
/*     */   private IBlockAccess field_75868_a;
/*  13 */   private Path field_75866_b = new Path();
/*  14 */   private IntHashMap field_75867_c = new IntHashMap();
/*     */   
/*  16 */   private PathPoint[] field_75864_d = new PathPoint[32];
/*     */   private boolean field_75865_e;
/*     */   private boolean field_75862_f;
/*     */   private boolean field_75863_g;
/*     */   private boolean field_75869_h;
/*     */   private static final String __OBFID = "CL_00000576";
/*     */   
/*     */   public PathFinder(IBlockAccess p_i2137_1_, boolean p_i2137_2_, boolean p_i2137_3_, boolean p_i2137_4_, boolean p_i2137_5_) {
/*  24 */     this.field_75868_a = p_i2137_1_;
/*  25 */     this.field_75865_e = p_i2137_2_;
/*  26 */     this.field_75862_f = p_i2137_3_;
/*  27 */     this.field_75863_g = p_i2137_4_;
/*  28 */     this.field_75869_h = p_i2137_5_;
/*     */   }
/*     */   
/*     */   public PathEntity func_75856_a(Entity p_75856_1_, Entity p_75856_2_, float p_75856_3_) {
/*  32 */     return func_75857_a(p_75856_1_, p_75856_2_.field_70165_t, p_75856_2_.field_70121_D.field_72338_b, p_75856_2_.field_70161_v, p_75856_3_);
/*     */   }
/*     */   
/*     */   public PathEntity func_75859_a(Entity p_75859_1_, int p_75859_2_, int p_75859_3_, int p_75859_4_, float p_75859_5_) {
/*  36 */     return func_75857_a(p_75859_1_, (p_75859_2_ + 0.5F), (p_75859_3_ + 0.5F), (p_75859_4_ + 0.5F), p_75859_5_);
/*     */   }
/*     */   
/*     */   private PathEntity func_75857_a(Entity p_75857_1_, double p_75857_2_, double p_75857_4_, double p_75857_6_, float p_75857_8_) {
/*  40 */     this.field_75866_b.func_75848_a();
/*  41 */     this.field_75867_c.func_76046_c();
/*     */     
/*  43 */     boolean bool = this.field_75863_g;
/*  44 */     int i = MathHelper.func_76128_c(p_75857_1_.field_70121_D.field_72338_b + 0.5D);
/*  45 */     if (this.field_75869_h && p_75857_1_.func_70090_H())
/*  46 */     { i = (int)p_75857_1_.field_70121_D.field_72338_b;
/*  47 */       Block block = this.field_75868_a.func_147439_a(MathHelper.func_76128_c(p_75857_1_.field_70165_t), i, MathHelper.func_76128_c(p_75857_1_.field_70161_v));
/*  48 */       while (block == Blocks.field_150358_i || block == Blocks.field_150355_j) {
/*  49 */         i++;
/*  50 */         block = this.field_75868_a.func_147439_a(MathHelper.func_76128_c(p_75857_1_.field_70165_t), i, MathHelper.func_76128_c(p_75857_1_.field_70161_v));
/*     */       } 
/*  52 */       bool = this.field_75863_g;
/*  53 */       this.field_75863_g = false; }
/*  54 */     else { i = MathHelper.func_76128_c(p_75857_1_.field_70121_D.field_72338_b + 0.5D); }
/*     */     
/*  56 */     PathPoint pathPoint1 = func_75854_a(MathHelper.func_76128_c(p_75857_1_.field_70121_D.field_72340_a), i, MathHelper.func_76128_c(p_75857_1_.field_70121_D.field_72339_c));
/*  57 */     PathPoint pathPoint2 = func_75854_a(MathHelper.func_76128_c(p_75857_2_ - (p_75857_1_.field_70130_N / 2.0F)), MathHelper.func_76128_c(p_75857_4_), MathHelper.func_76128_c(p_75857_6_ - (p_75857_1_.field_70130_N / 2.0F)));
/*     */     
/*  59 */     PathPoint pathPoint3 = new PathPoint(MathHelper.func_76141_d(p_75857_1_.field_70130_N + 1.0F), MathHelper.func_76141_d(p_75857_1_.field_70131_O + 1.0F), MathHelper.func_76141_d(p_75857_1_.field_70130_N + 1.0F));
/*  60 */     PathEntity pathEntity = func_75861_a(p_75857_1_, pathPoint1, pathPoint2, pathPoint3, p_75857_8_);
/*     */     
/*  62 */     this.field_75863_g = bool;
/*  63 */     return pathEntity;
/*     */   }
/*     */ 
/*     */   
/*     */   private PathEntity func_75861_a(Entity p_75861_1_, PathPoint p_75861_2_, PathPoint p_75861_3_, PathPoint p_75861_4_, float p_75861_5_) {
/*  68 */     p_75861_2_.field_75836_e = 0.0F;
/*  69 */     p_75861_2_.field_75833_f = p_75861_2_.func_75832_b(p_75861_3_);
/*  70 */     p_75861_2_.field_75834_g = p_75861_2_.field_75833_f;
/*     */     
/*  72 */     this.field_75866_b.func_75848_a();
/*  73 */     this.field_75866_b.func_75849_a(p_75861_2_);
/*     */     
/*  75 */     PathPoint pathPoint = p_75861_2_;
/*     */     
/*  77 */     while (!this.field_75866_b.func_75845_e()) {
/*  78 */       PathPoint pathPoint1 = this.field_75866_b.func_75844_c();
/*     */       
/*  80 */       if (pathPoint1.equals(p_75861_3_)) {
/*  81 */         return func_75853_a(p_75861_2_, p_75861_3_);
/*     */       }
/*     */       
/*  84 */       if (pathPoint1.func_75832_b(p_75861_3_) < pathPoint.func_75832_b(p_75861_3_)) {
/*  85 */         pathPoint = pathPoint1;
/*     */       }
/*  87 */       pathPoint1.field_75842_i = true;
/*     */       
/*  89 */       int i = func_75860_b(p_75861_1_, pathPoint1, p_75861_4_, p_75861_3_, p_75861_5_);
/*  90 */       for (byte b = 0; b < i; b++) {
/*  91 */         PathPoint pathPoint2 = this.field_75864_d[b];
/*     */         
/*  93 */         float f = pathPoint1.field_75836_e + pathPoint1.func_75832_b(pathPoint2);
/*  94 */         if (!pathPoint2.func_75831_a() || f < pathPoint2.field_75836_e) {
/*  95 */           pathPoint2.field_75841_h = pathPoint1;
/*  96 */           pathPoint2.field_75836_e = f;
/*  97 */           pathPoint2.field_75833_f = pathPoint2.func_75832_b(p_75861_3_);
/*  98 */           if (pathPoint2.func_75831_a()) {
/*  99 */             this.field_75866_b.func_75850_a(pathPoint2, pathPoint2.field_75836_e + pathPoint2.field_75833_f);
/*     */           } else {
/* 101 */             pathPoint2.field_75834_g = pathPoint2.field_75836_e + pathPoint2.field_75833_f;
/* 102 */             this.field_75866_b.func_75849_a(pathPoint2);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 108 */     if (pathPoint == p_75861_2_) return null; 
/* 109 */     return func_75853_a(p_75861_2_, pathPoint);
/*     */   }
/*     */   
/*     */   private int func_75860_b(Entity p_75860_1_, PathPoint p_75860_2_, PathPoint p_75860_3_, PathPoint p_75860_4_, float p_75860_5_) {
/* 113 */     byte b = 0;
/*     */     
/* 115 */     boolean bool = false;
/* 116 */     if (func_75855_a(p_75860_1_, p_75860_2_.field_75839_a, p_75860_2_.field_75837_b + 1, p_75860_2_.field_75838_c, p_75860_3_) == 1) bool = true;
/*     */     
/* 118 */     PathPoint pathPoint1 = func_75858_a(p_75860_1_, p_75860_2_.field_75839_a, p_75860_2_.field_75837_b, p_75860_2_.field_75838_c + 1, p_75860_3_, bool);
/* 119 */     PathPoint pathPoint2 = func_75858_a(p_75860_1_, p_75860_2_.field_75839_a - 1, p_75860_2_.field_75837_b, p_75860_2_.field_75838_c, p_75860_3_, bool);
/* 120 */     PathPoint pathPoint3 = func_75858_a(p_75860_1_, p_75860_2_.field_75839_a + 1, p_75860_2_.field_75837_b, p_75860_2_.field_75838_c, p_75860_3_, bool);
/* 121 */     PathPoint pathPoint4 = func_75858_a(p_75860_1_, p_75860_2_.field_75839_a, p_75860_2_.field_75837_b, p_75860_2_.field_75838_c - 1, p_75860_3_, bool);
/*     */     
/* 123 */     if (pathPoint1 != null && !pathPoint1.field_75842_i && pathPoint1.func_75829_a(p_75860_4_) < p_75860_5_) this.field_75864_d[b++] = pathPoint1; 
/* 124 */     if (pathPoint2 != null && !pathPoint2.field_75842_i && pathPoint2.func_75829_a(p_75860_4_) < p_75860_5_) this.field_75864_d[b++] = pathPoint2; 
/* 125 */     if (pathPoint3 != null && !pathPoint3.field_75842_i && pathPoint3.func_75829_a(p_75860_4_) < p_75860_5_) this.field_75864_d[b++] = pathPoint3; 
/* 126 */     if (pathPoint4 != null && !pathPoint4.field_75842_i && pathPoint4.func_75829_a(p_75860_4_) < p_75860_5_) this.field_75864_d[b++] = pathPoint4;
/*     */     
/* 128 */     return b;
/*     */   }
/*     */   
/*     */   private PathPoint func_75858_a(Entity p_75858_1_, int p_75858_2_, int p_75858_3_, int p_75858_4_, PathPoint p_75858_5_, int p_75858_6_) {
/* 132 */     PathPoint pathPoint = null;
/* 133 */     int i = func_75855_a(p_75858_1_, p_75858_2_, p_75858_3_, p_75858_4_, p_75858_5_);
/* 134 */     if (i == 2) return func_75854_a(p_75858_2_, p_75858_3_, p_75858_4_); 
/* 135 */     if (i == 1) pathPoint = func_75854_a(p_75858_2_, p_75858_3_, p_75858_4_); 
/* 136 */     if (pathPoint == null && p_75858_6_ > 0 && i != -3 && i != -4 && func_75855_a(p_75858_1_, p_75858_2_, p_75858_3_ + p_75858_6_, p_75858_4_, p_75858_5_) == 1) {
/* 137 */       pathPoint = func_75854_a(p_75858_2_, p_75858_3_ + p_75858_6_, p_75858_4_);
/* 138 */       p_75858_3_ += p_75858_6_;
/*     */     } 
/*     */     
/* 141 */     if (pathPoint != null) {
/* 142 */       byte b = 0;
/* 143 */       int j = 0;
/*     */       
/* 145 */       while (p_75858_3_ > 0) {
/* 146 */         j = func_75855_a(p_75858_1_, p_75858_2_, p_75858_3_ - 1, p_75858_4_, p_75858_5_);
/* 147 */         if (this.field_75863_g && j == -1) return null; 
/* 148 */         if (j != 1) {
/*     */           break;
/*     */         }
/* 151 */         if (b++ >= p_75858_1_.func_82143_as()) return null; 
/* 152 */         p_75858_3_--;
/* 153 */         if (p_75858_3_ > 0) pathPoint = func_75854_a(p_75858_2_, p_75858_3_, p_75858_4_);
/*     */       
/*     */       } 
/* 156 */       if (j == -2) return null;
/*     */     
/*     */     } 
/* 159 */     return pathPoint;
/*     */   }
/*     */   
/*     */   private final PathPoint func_75854_a(int p_75854_1_, int p_75854_2_, int p_75854_3_) {
/* 163 */     int i = PathPoint.func_75830_a(p_75854_1_, p_75854_2_, p_75854_3_);
/* 164 */     PathPoint pathPoint = (PathPoint)this.field_75867_c.func_76041_a(i);
/* 165 */     if (pathPoint == null) {
/* 166 */       pathPoint = new PathPoint(p_75854_1_, p_75854_2_, p_75854_3_);
/* 167 */       this.field_75867_c.func_76038_a(i, pathPoint);
/*     */     } 
/* 169 */     return pathPoint;
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
/*     */   public int func_75855_a(Entity p_75855_1_, int p_75855_2_, int p_75855_3_, int p_75855_4_, PathPoint p_75855_5_) {
/* 181 */     return func_82565_a(p_75855_1_, p_75855_2_, p_75855_3_, p_75855_4_, p_75855_5_, this.field_75863_g, this.field_75862_f, this.field_75865_e);
/*     */   }
/*     */   
/*     */   public static int func_82565_a(Entity p_82565_0_, int p_82565_1_, int p_82565_2_, int p_82565_3_, PathPoint p_82565_4_, boolean p_82565_5_, boolean p_82565_6_, boolean p_82565_7_) {
/* 185 */     boolean bool = false;
/* 186 */     for (int i = p_82565_1_; i < p_82565_1_ + p_82565_4_.field_75839_a; i++) {
/* 187 */       for (int j = p_82565_2_; j < p_82565_2_ + p_82565_4_.field_75837_b; j++) {
/* 188 */         for (int k = p_82565_3_; k < p_82565_3_ + p_82565_4_.field_75838_c; k++) {
/*     */           
/* 190 */           Block block = p_82565_0_.field_70170_p.func_147439_a(i, j, k);
/* 191 */           if (block.func_149688_o() != Material.field_151579_a) {
/* 192 */             if (block == Blocks.field_150415_aT) { bool = true; }
/* 193 */             else if (block == Blocks.field_150358_i || block == Blocks.field_150355_j)
/* 194 */             { if (p_82565_5_) return -1; 
/* 195 */               bool = true; }
/* 196 */             else if (!p_82565_7_ && block == Blocks.field_150466_ao)
/* 197 */             { return 0; }
/*     */             
/* 199 */             int m = block.func_149645_b();
/*     */             
/* 201 */             if (p_82565_0_.field_70170_p.func_147439_a(i, j, k).func_149645_b() == 9)
/* 202 */             { int n = MathHelper.func_76128_c(p_82565_0_.field_70165_t);
/* 203 */               int i1 = MathHelper.func_76128_c(p_82565_0_.field_70163_u);
/* 204 */               int i2 = MathHelper.func_76128_c(p_82565_0_.field_70161_v);
/* 205 */               if (p_82565_0_.field_70170_p.func_147439_a(n, i1, i2).func_149645_b() != 9 && p_82565_0_.field_70170_p.func_147439_a(n, i1 - 1, i2).func_149645_b() != 9)
/*     */               {
/*     */ 
/*     */                 
/* 209 */                 return -3;
/*     */               
/*     */               } }
/*     */             
/* 213 */             else if (!block.func_149655_b((IBlockAccess)p_82565_0_.field_70170_p, i, j, k) && (
/* 214 */               !p_82565_6_ || block != Blocks.field_150466_ao))
/*     */             
/* 216 */             { if (m == 11 || block == Blocks.field_150396_be || m == 32) return -3;
/*     */               
/* 218 */               if (block == Blocks.field_150415_aT) return -4; 
/* 219 */               Material material = block.func_149688_o();
/* 220 */               if (material == Material.field_151587_i)
/* 221 */               { if (!p_82565_0_.func_70058_J())
/* 222 */                   return -2;  }
/*     */               else
/* 224 */               { return 0; }  } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 228 */     }  return bool ? 2 : 1;
/*     */   }
/*     */ 
/*     */   
/*     */   private PathEntity func_75853_a(PathPoint p_75853_1_, PathPoint p_75853_2_) {
/* 233 */     byte b = 1;
/* 234 */     PathPoint pathPoint = p_75853_2_;
/* 235 */     while (pathPoint.field_75841_h != null) {
/* 236 */       b++;
/* 237 */       pathPoint = pathPoint.field_75841_h;
/*     */     } 
/*     */     
/* 240 */     PathPoint[] arrayOfPathPoint = new PathPoint[b];
/* 241 */     pathPoint = p_75853_2_;
/* 242 */     arrayOfPathPoint[--b] = pathPoint;
/* 243 */     while (pathPoint.field_75841_h != null) {
/* 244 */       pathPoint = pathPoint.field_75841_h;
/* 245 */       arrayOfPathPoint[--b] = pathPoint;
/*     */     } 
/* 247 */     return new PathEntity(arrayOfPathPoint);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\pathfinding\PathFinder.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */