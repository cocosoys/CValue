/*     */ package net.minecraft.world.gen.layer;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.biome.BiomeGenJungle;
/*     */ 
/*     */ public class GenLayerShore extends GenLayer {
/*     */   public GenLayerShore(long p_i2130_1_, GenLayer p_i2130_3_) {
/*   7 */     super(p_i2130_1_);
/*   8 */     this.field_75909_a = p_i2130_3_;
/*     */   }
/*     */   private static final String __OBFID = "CL_00000568";
/*     */   
/*     */   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
/*  13 */     int[] arrayOfInt1 = this.field_75909_a.func_75904_a(p_75904_1_ - 1, p_75904_2_ - 1, p_75904_3_ + 2, p_75904_4_ + 2);
/*     */     
/*  15 */     int[] arrayOfInt2 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
/*  16 */     for (byte b = 0; b < p_75904_4_; b++) {
/*  17 */       for (byte b1 = 0; b1 < p_75904_3_; b1++) {
/*  18 */         func_75903_a((b1 + p_75904_1_), (b + p_75904_2_));
/*  19 */         int i = arrayOfInt1[b1 + 1 + (b + 1) * (p_75904_3_ + 2)];
/*  20 */         BiomeGenBase biomeGenBase = BiomeGenBase.func_150568_d(i);
/*  21 */         if (i == BiomeGenBase.field_76789_p.field_76756_M) {
/*  22 */           int j = arrayOfInt1[b1 + 1 + (b + 1 - 1) * (p_75904_3_ + 2)];
/*  23 */           int k = arrayOfInt1[b1 + 1 + 1 + (b + 1) * (p_75904_3_ + 2)];
/*  24 */           int m = arrayOfInt1[b1 + 1 - 1 + (b + 1) * (p_75904_3_ + 2)];
/*  25 */           int n = arrayOfInt1[b1 + 1 + (b + 1 + 1) * (p_75904_3_ + 2)];
/*  26 */           if (j == BiomeGenBase.field_76771_b.field_76756_M || k == BiomeGenBase.field_76771_b.field_76756_M || m == BiomeGenBase.field_76771_b.field_76756_M || n == BiomeGenBase.field_76771_b.field_76756_M) {
/*  27 */             arrayOfInt2[b1 + b * p_75904_3_] = BiomeGenBase.field_76788_q.field_76756_M;
/*     */           } else {
/*  29 */             arrayOfInt2[b1 + b * p_75904_3_] = i;
/*     */           } 
/*  31 */         } else if (biomeGenBase != null && biomeGenBase.func_150562_l() == BiomeGenJungle.class) {
/*  32 */           int j = arrayOfInt1[b1 + 1 + (b + 1 - 1) * (p_75904_3_ + 2)];
/*  33 */           int k = arrayOfInt1[b1 + 1 + 1 + (b + 1) * (p_75904_3_ + 2)];
/*  34 */           int m = arrayOfInt1[b1 + 1 - 1 + (b + 1) * (p_75904_3_ + 2)];
/*  35 */           int n = arrayOfInt1[b1 + 1 + (b + 1 + 1) * (p_75904_3_ + 2)];
/*  36 */           if (!func_151631_c(j) || !func_151631_c(k) || !func_151631_c(m) || !func_151631_c(n)) {
/*  37 */             arrayOfInt2[b1 + b * p_75904_3_] = BiomeGenBase.field_150574_L.field_76756_M;
/*  38 */           } else if (func_151618_b(j) || func_151618_b(k) || func_151618_b(m) || func_151618_b(n)) {
/*  39 */             arrayOfInt2[b1 + b * p_75904_3_] = BiomeGenBase.field_76787_r.field_76756_M;
/*     */           } else {
/*  41 */             arrayOfInt2[b1 + b * p_75904_3_] = i;
/*     */           } 
/*  43 */         } else if (i == BiomeGenBase.field_76770_e.field_76756_M || i == BiomeGenBase.field_150580_W.field_76756_M || i == BiomeGenBase.field_76783_v.field_76756_M) {
/*  44 */           func_151632_a(arrayOfInt1, arrayOfInt2, b1, b, p_75904_3_, i, BiomeGenBase.field_150576_N.field_76756_M);
/*  45 */         } else if (biomeGenBase != null && biomeGenBase.func_150559_j()) {
/*  46 */           func_151632_a(arrayOfInt1, arrayOfInt2, b1, b, p_75904_3_, i, BiomeGenBase.field_150577_O.field_76756_M);
/*  47 */         } else if (i == BiomeGenBase.field_150589_Z.field_76756_M || i == BiomeGenBase.field_150607_aa.field_76756_M) {
/*  48 */           int j = arrayOfInt1[b1 + 1 + (b + 1 - 1) * (p_75904_3_ + 2)];
/*  49 */           int k = arrayOfInt1[b1 + 1 + 1 + (b + 1) * (p_75904_3_ + 2)];
/*  50 */           int m = arrayOfInt1[b1 + 1 - 1 + (b + 1) * (p_75904_3_ + 2)];
/*  51 */           int n = arrayOfInt1[b1 + 1 + (b + 1 + 1) * (p_75904_3_ + 2)];
/*  52 */           if (func_151618_b(j) || func_151618_b(k) || func_151618_b(m) || func_151618_b(n)) {
/*  53 */             arrayOfInt2[b1 + b * p_75904_3_] = i;
/*  54 */           } else if (!func_151633_d(j) || !func_151633_d(k) || !func_151633_d(m) || !func_151633_d(n)) {
/*  55 */             arrayOfInt2[b1 + b * p_75904_3_] = BiomeGenBase.field_76769_d.field_76756_M;
/*     */           } else {
/*  57 */             arrayOfInt2[b1 + b * p_75904_3_] = i;
/*     */           } 
/*  59 */         } else if (i != BiomeGenBase.field_76771_b.field_76756_M && i != BiomeGenBase.field_150575_M.field_76756_M && i != BiomeGenBase.field_76781_i.field_76756_M && i != BiomeGenBase.field_76780_h.field_76756_M) {
/*  60 */           int j = arrayOfInt1[b1 + 1 + (b + 1 - 1) * (p_75904_3_ + 2)];
/*  61 */           int k = arrayOfInt1[b1 + 1 + 1 + (b + 1) * (p_75904_3_ + 2)];
/*  62 */           int m = arrayOfInt1[b1 + 1 - 1 + (b + 1) * (p_75904_3_ + 2)];
/*  63 */           int n = arrayOfInt1[b1 + 1 + (b + 1 + 1) * (p_75904_3_ + 2)];
/*  64 */           if (func_151618_b(j) || func_151618_b(k) || func_151618_b(m) || func_151618_b(n)) {
/*  65 */             arrayOfInt2[b1 + b * p_75904_3_] = BiomeGenBase.field_76787_r.field_76756_M;
/*     */           } else {
/*  67 */             arrayOfInt2[b1 + b * p_75904_3_] = i;
/*     */           } 
/*     */         } else {
/*     */           
/*  71 */           arrayOfInt2[b1 + b * p_75904_3_] = i;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  77 */     return arrayOfInt2;
/*     */   }
/*     */   
/*     */   private void func_151632_a(int[] p_151632_1_, int[] p_151632_2_, int p_151632_3_, int p_151632_4_, int p_151632_5_, int p_151632_6_, int p_151632_7_) {
/*  81 */     if (func_151618_b(p_151632_6_)) {
/*  82 */       p_151632_2_[p_151632_3_ + p_151632_4_ * p_151632_5_] = p_151632_6_;
/*     */       return;
/*     */     } 
/*  85 */     int i = p_151632_1_[p_151632_3_ + 1 + (p_151632_4_ + 1 - 1) * (p_151632_5_ + 2)];
/*  86 */     int j = p_151632_1_[p_151632_3_ + 1 + 1 + (p_151632_4_ + 1) * (p_151632_5_ + 2)];
/*  87 */     int k = p_151632_1_[p_151632_3_ + 1 - 1 + (p_151632_4_ + 1) * (p_151632_5_ + 2)];
/*  88 */     int m = p_151632_1_[p_151632_3_ + 1 + (p_151632_4_ + 1 + 1) * (p_151632_5_ + 2)];
/*  89 */     if (func_151618_b(i) || func_151618_b(j) || func_151618_b(k) || func_151618_b(m)) {
/*  90 */       p_151632_2_[p_151632_3_ + p_151632_4_ * p_151632_5_] = p_151632_7_;
/*     */     } else {
/*  92 */       p_151632_2_[p_151632_3_ + p_151632_4_ * p_151632_5_] = p_151632_6_;
/*     */     } 
/*     */   }
/*     */   
/*     */   private boolean func_151631_c(int p_151631_1_) {
/*  97 */     if (BiomeGenBase.func_150568_d(p_151631_1_) != null && BiomeGenBase.func_150568_d(p_151631_1_).func_150562_l() == BiomeGenJungle.class) {
/*  98 */       return true;
/*     */     }
/*     */     
/* 101 */     return (p_151631_1_ == BiomeGenBase.field_150574_L.field_76756_M || p_151631_1_ == BiomeGenBase.field_76782_w.field_76756_M || p_151631_1_ == BiomeGenBase.field_76792_x.field_76756_M || p_151631_1_ == BiomeGenBase.field_76767_f.field_76756_M || p_151631_1_ == BiomeGenBase.field_76768_g.field_76756_M || func_151618_b(p_151631_1_));
/*     */   }
/*     */   
/*     */   private boolean func_151633_d(int p_151633_1_) {
/* 105 */     return (BiomeGenBase.func_150568_d(p_151633_1_) != null && BiomeGenBase.func_150568_d(p_151633_1_) instanceof net.minecraft.world.biome.BiomeGenMesa);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\layer\GenLayerShore.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */