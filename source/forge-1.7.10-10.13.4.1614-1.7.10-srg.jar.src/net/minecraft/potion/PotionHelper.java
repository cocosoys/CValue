/*     */ package net.minecraft.potion;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
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
/*     */ public class PotionHelper
/*     */ {
/*     */   public static final String field_77924_a;
/*     */   public static final String field_77922_b;
/*     */   public static final String field_77923_c;
/*     */   public static final String field_77920_d;
/*     */   public static final String field_77921_e;
/*     */   public static final String field_77918_f;
/*     */   public static final String field_77919_g;
/*     */   public static final String field_77931_h;
/*     */   public static final String field_77932_i;
/*     */   public static final String field_77929_j;
/*     */   public static final String field_77930_k;
/*     */   public static final String field_82818_l;
/*     */   public static final String field_151423_m;
/*  52 */   private static final HashMap field_77927_l = new HashMap<Object, Object>();
/*  53 */   private static final HashMap field_77928_m = new HashMap<Object, Object>();
/*     */   private static final HashMap field_77925_n;
/*     */   private static final String[] field_77926_o;
/*     */   private static final String __OBFID = "CL_00000078";
/*     */   
/*     */   static {
/*  59 */     field_77924_a = null;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*  81 */     field_77923_c = "+0-1-2-3&4-4+13";
/*  82 */     field_77927_l.put(Integer.valueOf(Potion.field_76428_l.func_76396_c()), "0 & !1 & !2 & !3 & 0+6");
/*     */     
/*  84 */     field_77922_b = "-0+1-2-3&4-4+13";
/*  85 */     field_77927_l.put(Integer.valueOf(Potion.field_76424_c.func_76396_c()), "!0 & 1 & !2 & !3 & 1+6");
/*     */     
/*  87 */     field_77931_h = "+0+1-2-3&4-4+13";
/*  88 */     field_77927_l.put(Integer.valueOf(Potion.field_76426_n.func_76396_c()), "0 & 1 & !2 & !3 & 0+6");
/*     */     
/*  90 */     field_77918_f = "+0-1+2-3&4-4+13";
/*  91 */     field_77927_l.put(Integer.valueOf(Potion.field_76432_h.func_76396_c()), "0 & !1 & 2 & !3");
/*     */     
/*  93 */     field_77920_d = "-0-1+2-3&4-4+13";
/*  94 */     field_77927_l.put(Integer.valueOf(Potion.field_76436_u.func_76396_c()), "!0 & !1 & 2 & !3 & 2+6");
/*     */     
/*  96 */     field_77921_e = "-0+3-4+13";
/*  97 */     field_77927_l.put(Integer.valueOf(Potion.field_76437_t.func_76396_c()), "!0 & !1 & !2 & 3 & 3+6");
/*  98 */     field_77927_l.put(Integer.valueOf(Potion.field_76433_i.func_76396_c()), "!0 & !1 & 2 & 3");
/*  99 */     field_77927_l.put(Integer.valueOf(Potion.field_76421_d.func_76396_c()), "!0 & 1 & !2 & 3 & 3+6");
/*     */     
/* 101 */     field_77919_g = "+0-1-2+3&4-4+13";
/* 102 */     field_77927_l.put(Integer.valueOf(Potion.field_76420_g.func_76396_c()), "0 & !1 & !2 & 3 & 3+6");
/*     */     
/* 104 */     field_82818_l = "-0+1+2-3+13&4-4";
/* 105 */     field_77927_l.put(Integer.valueOf(Potion.field_76439_r.func_76396_c()), "!0 & 1 & 2 & !3 & 2+6");
/*     */ 
/*     */     
/* 108 */     field_77927_l.put(Integer.valueOf(Potion.field_76441_p.func_76396_c()), "!0 & 1 & 2 & 3 & 2+6");
/*     */     
/* 110 */     field_151423_m = "+0-1+2+3+13&4-4";
/* 111 */     field_77927_l.put(Integer.valueOf(Potion.field_76427_o.func_76396_c()), "0 & !1 & 2 & 3 & 2+6");
/*     */ 
/*     */     
/* 114 */     field_77929_j = "+5-6-7";
/* 115 */     field_77928_m.put(Integer.valueOf(Potion.field_76424_c.func_76396_c()), "5");
/* 116 */     field_77928_m.put(Integer.valueOf(Potion.field_76422_e.func_76396_c()), "5");
/* 117 */     field_77928_m.put(Integer.valueOf(Potion.field_76420_g.func_76396_c()), "5");
/* 118 */     field_77928_m.put(Integer.valueOf(Potion.field_76428_l.func_76396_c()), "5");
/* 119 */     field_77928_m.put(Integer.valueOf(Potion.field_76433_i.func_76396_c()), "5");
/* 120 */     field_77928_m.put(Integer.valueOf(Potion.field_76432_h.func_76396_c()), "5");
/* 121 */     field_77928_m.put(Integer.valueOf(Potion.field_76429_m.func_76396_c()), "5");
/* 122 */     field_77928_m.put(Integer.valueOf(Potion.field_76436_u.func_76396_c()), "5");
/*     */ 
/*     */     
/* 125 */     field_77932_i = "-5+6-7";
/*     */ 
/*     */ 
/*     */     
/* 129 */     field_77930_k = "+14&13-13";
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 236 */     field_77925_n = new HashMap<Object, Object>();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 257 */     field_77926_o = new String[] { "potion.prefix.mundane", "potion.prefix.uninteresting", "potion.prefix.bland", "potion.prefix.clear", "potion.prefix.milky", "potion.prefix.diffuse", "potion.prefix.artless", "potion.prefix.thin", "potion.prefix.awkward", "potion.prefix.flat", "potion.prefix.bulky", "potion.prefix.bungling", "potion.prefix.buttered", "potion.prefix.smooth", "potion.prefix.suave", "potion.prefix.debonair", "potion.prefix.thick", "potion.prefix.elegant", "potion.prefix.fancy", "potion.prefix.charming", "potion.prefix.dashing", "potion.prefix.refined", "potion.prefix.cordial", "potion.prefix.sparkling", "potion.prefix.potent", "potion.prefix.foul", "potion.prefix.odorless", "potion.prefix.rank", "potion.prefix.harsh", "potion.prefix.acrid", "potion.prefix.gross", "potion.prefix.stinky" };
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean func_77914_a(int p_77914_0_, int p_77914_1_) {
/*     */     return ((p_77914_0_ & 1 << p_77914_1_) != 0);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int func_77910_c(int p_77910_0_, int p_77910_1_) {
/*     */     return func_77914_a(p_77910_0_, p_77910_1_) ? 1 : 0;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int func_77916_d(int p_77916_0_, int p_77916_1_) {
/*     */     return func_77914_a(p_77916_0_, p_77916_1_) ? 0 : 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static String func_77905_c(int p_77905_0_) {
/* 294 */     int i = func_77909_a(p_77905_0_);
/* 295 */     return field_77926_o[i];
/*     */   }
/*     */   public static int func_77909_a(int p_77909_0_) { return func_77908_a(p_77909_0_, 5, 4, 3, 2, 1); }
/*     */   public static int func_77911_a(Collection p_77911_0_) { int i = 3694022; if (p_77911_0_ == null || p_77911_0_.isEmpty())
/*     */       return i;  float f1 = 0.0F; float f2 = 0.0F; float f3 = 0.0F; float f4 = 0.0F; for (PotionEffect potionEffect : p_77911_0_) { int j = Potion.field_76425_a[potionEffect.func_76456_a()].func_76401_j(); for (byte b = 0; b <= potionEffect.func_76458_c(); b++) { f1 += (j >> 16 & 0xFF) / 255.0F; f2 += (j >> 8 & 0xFF) / 255.0F; f3 += (j >> 0 & 0xFF) / 255.0F; f4++; }  }  f1 = f1 / f4 * 255.0F; f2 = f2 / f4 * 255.0F; f3 = f3 / f4 * 255.0F; return (int)f1 << 16 | (int)f2 << 8 | (int)f3; }
/*     */   public static boolean func_82817_b(Collection p_82817_0_) { for (PotionEffect potionEffect : p_82817_0_) { if (!potionEffect.func_82720_e())
/*     */         return false;  }
/*     */      return true; } @SideOnly(Side.CLIENT) public static int func_77915_a(int p_77915_0_, boolean p_77915_1_) { if (!p_77915_1_) { if (field_77925_n.containsKey(Integer.valueOf(p_77915_0_)))
/*     */         return ((Integer)field_77925_n.get(Integer.valueOf(p_77915_0_))).intValue();  int i = func_77911_a(func_77917_b(p_77915_0_, false)); field_77925_n.put(Integer.valueOf(p_77915_0_), Integer.valueOf(i)); return i; }
/* 304 */      return func_77911_a(func_77917_b(p_77915_0_, p_77915_1_)); } private static int func_77904_a(boolean p_77904_0_, boolean p_77904_1_, boolean p_77904_2_, int p_77904_3_, int p_77904_4_, int p_77904_5_, int p_77904_6_) { int i = 0;
/* 305 */     if (p_77904_0_) {
/* 306 */       i = func_77916_d(p_77904_6_, p_77904_4_);
/* 307 */     } else if (p_77904_3_ != -1) {
/* 308 */       if (p_77904_3_ == 0 && func_77907_h(p_77904_6_) == p_77904_4_) {
/* 309 */         i = 1;
/* 310 */       } else if (p_77904_3_ == 1 && func_77907_h(p_77904_6_) > p_77904_4_) {
/* 311 */         i = 1;
/* 312 */       } else if (p_77904_3_ == 2 && func_77907_h(p_77904_6_) < p_77904_4_) {
/* 313 */         i = 1;
/*     */       } 
/*     */     } else {
/* 316 */       i = func_77910_c(p_77904_6_, p_77904_4_);
/*     */     } 
/* 318 */     if (p_77904_1_) {
/* 319 */       i *= p_77904_5_;
/*     */     }
/* 321 */     if (p_77904_2_) {
/* 322 */       i *= -1;
/*     */     }
/* 324 */     return i; }
/*     */ 
/*     */   
/*     */   private static int func_77907_h(int p_77907_0_) {
/* 328 */     byte b = 0;
/* 329 */     for (; p_77907_0_ > 0; b++) {
/* 330 */       p_77907_0_ &= p_77907_0_ - 1;
/*     */     }
/* 332 */     return b;
/*     */   }
/*     */ 
/*     */   
/*     */   private static int func_77912_a(String p_77912_0_, int p_77912_1_, int p_77912_2_, int p_77912_3_) {
/* 337 */     if (p_77912_1_ >= p_77912_0_.length() || p_77912_2_ < 0 || p_77912_1_ >= p_77912_2_) {
/* 338 */       return 0;
/*     */     }
/*     */ 
/*     */     
/* 342 */     int i = p_77912_0_.indexOf('|', p_77912_1_);
/* 343 */     if (i >= 0 && i < p_77912_2_) {
/* 344 */       int i2 = func_77912_a(p_77912_0_, p_77912_1_, i - 1, p_77912_3_);
/* 345 */       if (i2 > 0) {
/* 346 */         return i2;
/*     */       }
/*     */       
/* 349 */       int i3 = func_77912_a(p_77912_0_, i + 1, p_77912_2_, p_77912_3_);
/* 350 */       if (i3 > 0) {
/* 351 */         return i3;
/*     */       }
/* 353 */       return 0;
/*     */     } 
/*     */     
/* 356 */     int j = p_77912_0_.indexOf('&', p_77912_1_);
/* 357 */     if (j >= 0 && j < p_77912_2_) {
/* 358 */       int i2 = func_77912_a(p_77912_0_, p_77912_1_, j - 1, p_77912_3_);
/* 359 */       if (i2 <= 0) {
/* 360 */         return 0;
/*     */       }
/*     */       
/* 363 */       int i3 = func_77912_a(p_77912_0_, j + 1, p_77912_2_, p_77912_3_);
/* 364 */       if (i3 <= 0) {
/* 365 */         return 0;
/*     */       }
/*     */       
/* 368 */       if (i2 > i3) {
/* 369 */         return i2;
/*     */       }
/* 371 */       return i3;
/*     */     } 
/*     */     
/* 374 */     boolean bool1 = false;
/* 375 */     boolean bool2 = false;
/* 376 */     boolean bool3 = false;
/* 377 */     boolean bool4 = false;
/* 378 */     boolean bool5 = false;
/* 379 */     byte b = -1;
/* 380 */     int k = 0;
/* 381 */     int m = 0;
/* 382 */     int n = 0;
/* 383 */     for (int i1 = p_77912_1_; i1 < p_77912_2_; i1++) {
/*     */       
/* 385 */       char c = p_77912_0_.charAt(i1);
/* 386 */       if (c >= '0' && c <= '9') {
/* 387 */         if (bool1) {
/* 388 */           m = c - 48;
/* 389 */           bool2 = true;
/*     */         } else {
/* 391 */           k *= 10;
/* 392 */           k += c - 48;
/* 393 */           bool3 = true;
/*     */         } 
/* 395 */       } else if (c == '*') {
/* 396 */         bool1 = true;
/* 397 */       } else if (c == '!') {
/* 398 */         if (bool3) {
/* 399 */           n += func_77904_a(bool4, bool2, bool5, b, k, m, p_77912_3_);
/* 400 */           bool3 = bool2 = bool1 = bool5 = bool4 = false;
/* 401 */           k = m = 0;
/* 402 */           b = -1;
/*     */         } 
/*     */         
/* 405 */         bool4 = true;
/* 406 */       } else if (c == '-') {
/* 407 */         if (bool3) {
/* 408 */           n += func_77904_a(bool4, bool2, bool5, b, k, m, p_77912_3_);
/* 409 */           bool3 = bool2 = bool1 = bool5 = bool4 = false;
/* 410 */           k = m = 0;
/* 411 */           b = -1;
/*     */         } 
/*     */         
/* 414 */         bool5 = true;
/* 415 */       } else if (c == '=' || c == '<' || c == '>') {
/* 416 */         if (bool3) {
/* 417 */           n += func_77904_a(bool4, bool2, bool5, b, k, m, p_77912_3_);
/* 418 */           bool3 = bool2 = bool1 = bool5 = bool4 = false;
/* 419 */           k = m = 0;
/* 420 */           b = -1;
/*     */         } 
/*     */         
/* 423 */         if (c == '=') {
/* 424 */           b = 0;
/* 425 */         } else if (c == '<') {
/* 426 */           b = 2;
/* 427 */         } else if (c == '>') {
/* 428 */           b = 1;
/*     */         } 
/* 430 */       } else if (c == '+' && 
/* 431 */         bool3) {
/* 432 */         n += func_77904_a(bool4, bool2, bool5, b, k, m, p_77912_3_);
/* 433 */         bool3 = bool2 = bool1 = bool5 = bool4 = false;
/* 434 */         k = m = 0;
/* 435 */         b = -1;
/*     */       } 
/*     */     } 
/*     */     
/* 439 */     if (bool3) {
/* 440 */       n += func_77904_a(bool4, bool2, bool5, b, k, m, p_77912_3_);
/*     */     }
/*     */     
/* 443 */     return n;
/*     */   }
/*     */ 
/*     */   
/*     */   public static List func_77917_b(int p_77917_0_, boolean p_77917_1_) {
/* 448 */     ArrayList<PotionEffect> arrayList = null;
/*     */     
/* 450 */     for (Potion potion : Potion.field_76425_a) {
/* 451 */       if (potion != null && (!potion.func_76395_i() || p_77917_1_)) {
/*     */ 
/*     */         
/* 454 */         String str = (String)field_77927_l.get(Integer.valueOf(potion.func_76396_c()));
/* 455 */         if (str != null) {
/*     */ 
/*     */ 
/*     */           
/* 459 */           int i = func_77912_a(str, 0, str.length(), p_77917_0_);
/* 460 */           if (i > 0) {
/* 461 */             int j = 0;
/* 462 */             String str1 = (String)field_77928_m.get(Integer.valueOf(potion.func_76396_c()));
/* 463 */             if (str1 != null) {
/* 464 */               j = func_77912_a(str1, 0, str1.length(), p_77917_0_);
/* 465 */               if (j < 0) {
/* 466 */                 j = 0;
/*     */               }
/*     */             } 
/*     */             
/* 470 */             if (potion.func_76403_b()) {
/* 471 */               i = 1;
/*     */             } else {
/*     */               
/* 474 */               i = 1200 * (i * 3 + (i - 1) * 2);
/* 475 */               i >>= j;
/* 476 */               i = (int)Math.round(i * potion.func_76388_g());
/*     */               
/* 478 */               if ((p_77917_0_ & 0x4000) != 0) {
/* 479 */                 i = (int)Math.round(i * 0.75D + 0.5D);
/*     */               }
/*     */             } 
/*     */             
/* 483 */             if (arrayList == null) {
/* 484 */               arrayList = new ArrayList();
/*     */             }
/* 486 */             PotionEffect potionEffect = new PotionEffect(potion.func_76396_c(), i, j);
/* 487 */             if ((p_77917_0_ & 0x4000) != 0) potionEffect.func_82721_a(true); 
/* 488 */             arrayList.add(potionEffect);
/*     */           } 
/*     */         } 
/*     */       } 
/* 492 */     }  return arrayList;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static int func_77906_a(int p_77906_0_, int p_77906_1_, boolean p_77906_2_, boolean p_77906_3_, boolean p_77906_4_) {
/* 578 */     if (p_77906_4_) {
/* 579 */       if (!func_77914_a(p_77906_0_, p_77906_1_)) {
/* 580 */         return 0;
/*     */       }
/* 582 */     } else if (p_77906_2_) {
/* 583 */       p_77906_0_ &= 1 << p_77906_1_ ^ 0xFFFFFFFF;
/* 584 */     } else if (p_77906_3_) {
/* 585 */       if ((p_77906_0_ & 1 << p_77906_1_) == 0) {
/* 586 */         p_77906_0_ |= 1 << p_77906_1_;
/*     */       } else {
/* 588 */         p_77906_0_ &= 1 << p_77906_1_ ^ 0xFFFFFFFF;
/*     */       } 
/*     */     } else {
/* 591 */       p_77906_0_ |= 1 << p_77906_1_;
/*     */     } 
/* 593 */     return p_77906_0_;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int func_77913_a(int p_77913_0_, String p_77913_1_) {
/* 598 */     byte b1 = 0;
/* 599 */     int i = p_77913_1_.length();
/*     */     
/* 601 */     boolean bool1 = false;
/* 602 */     boolean bool2 = false;
/* 603 */     boolean bool3 = false;
/* 604 */     boolean bool4 = false;
/* 605 */     int j = 0;
/* 606 */     for (byte b2 = b1; b2 < i; b2++) {
/*     */       
/* 608 */       char c = p_77913_1_.charAt(b2);
/* 609 */       if (c >= '0' && c <= '9') {
/* 610 */         j *= 10;
/* 611 */         j += c - 48;
/* 612 */         bool1 = true;
/* 613 */       } else if (c == '!') {
/* 614 */         if (bool1) {
/* 615 */           p_77913_0_ = func_77906_a(p_77913_0_, j, bool3, bool2, bool4);
/* 616 */           bool1 = bool3 = bool2 = bool4 = false;
/* 617 */           j = 0;
/*     */         } 
/*     */         
/* 620 */         bool2 = true;
/* 621 */       } else if (c == '-') {
/* 622 */         if (bool1) {
/* 623 */           p_77913_0_ = func_77906_a(p_77913_0_, j, bool3, bool2, bool4);
/* 624 */           bool1 = bool3 = bool2 = bool4 = false;
/* 625 */           j = 0;
/*     */         } 
/*     */         
/* 628 */         bool3 = true;
/* 629 */       } else if (c == '+') {
/* 630 */         if (bool1) {
/* 631 */           p_77913_0_ = func_77906_a(p_77913_0_, j, bool3, bool2, bool4);
/* 632 */           bool1 = bool3 = bool2 = bool4 = false;
/* 633 */           j = 0;
/*     */         } 
/* 635 */       } else if (c == '&') {
/* 636 */         if (bool1) {
/* 637 */           p_77913_0_ = func_77906_a(p_77913_0_, j, bool3, bool2, bool4);
/* 638 */           bool1 = bool3 = bool2 = bool4 = false;
/* 639 */           j = 0;
/*     */         } 
/* 641 */         bool4 = true;
/*     */       } 
/*     */     } 
/* 644 */     if (bool1) {
/* 645 */       p_77913_0_ = func_77906_a(p_77913_0_, j, bool3, bool2, bool4);
/*     */     }
/*     */     
/* 648 */     return p_77913_0_ & 0x7FFF;
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
/*     */   public static int func_77908_a(int p_77908_0_, int p_77908_1_, int p_77908_2_, int p_77908_3_, int p_77908_4_, int p_77908_5_) {
/* 663 */     return (func_77914_a(p_77908_0_, p_77908_1_) ? 16 : 0) | (func_77914_a(p_77908_0_, p_77908_2_) ? 8 : 0) | (func_77914_a(p_77908_0_, p_77908_3_) ? 4 : 0) | (func_77914_a(p_77908_0_, p_77908_4_) ? 2 : 0) | (func_77914_a(p_77908_0_, p_77908_5_) ? 1 : 0);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\potion\PotionHelper.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */