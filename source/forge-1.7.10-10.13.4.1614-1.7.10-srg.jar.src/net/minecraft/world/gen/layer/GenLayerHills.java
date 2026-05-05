/*     */ package net.minecraft.world.gen.layer;
/*     */ 
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ 
/*     */ public class GenLayerHills extends GenLayer {
/*   8 */   private static final Logger field_151629_c = LogManager.getLogger();
/*     */   private GenLayer field_151628_d;
/*     */   
/*     */   public GenLayerHills(long p_i45479_1_, GenLayer p_i45479_3_, GenLayer p_i45479_4_) {
/*  12 */     super(p_i45479_1_);
/*  13 */     this.field_75909_a = p_i45479_3_;
/*  14 */     this.field_151628_d = p_i45479_4_;
/*     */   }
/*     */   private static final String __OBFID = "CL_00000563";
/*     */   
/*     */   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
/*  19 */     int[] arrayOfInt1 = this.field_75909_a.func_75904_a(p_75904_1_ - 1, p_75904_2_ - 1, p_75904_3_ + 2, p_75904_4_ + 2);
/*  20 */     int[] arrayOfInt2 = this.field_151628_d.func_75904_a(p_75904_1_ - 1, p_75904_2_ - 1, p_75904_3_ + 2, p_75904_4_ + 2);
/*     */     
/*  22 */     int[] arrayOfInt3 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
/*  23 */     for (byte b = 0; b < p_75904_4_; b++) {
/*  24 */       for (byte b1 = 0; b1 < p_75904_3_; b1++) {
/*  25 */         func_75903_a((b1 + p_75904_1_), (b + p_75904_2_));
/*  26 */         int i = arrayOfInt1[b1 + 1 + (b + 1) * (p_75904_3_ + 2)];
/*  27 */         int j = arrayOfInt2[b1 + 1 + (b + 1) * (p_75904_3_ + 2)];
/*  28 */         boolean bool = ((j - 2) % 29 == 0) ? true : false;
/*  29 */         if (i > 255) {
/*  30 */           field_151629_c.debug("old! " + i);
/*     */         }
/*  32 */         if (i != 0 && j >= 2 && (j - 2) % 29 == 1 && i < 128) {
/*  33 */           if (BiomeGenBase.func_150568_d(i + 128) != null) {
/*  34 */             arrayOfInt3[b1 + b * p_75904_3_] = i + 128;
/*     */           } else {
/*  36 */             arrayOfInt3[b1 + b * p_75904_3_] = i;
/*     */           } 
/*  38 */         } else if (func_75902_a(3) == 0 || bool) {
/*  39 */           int k = i;
/*  40 */           if (i == BiomeGenBase.field_76769_d.field_76756_M) {
/*  41 */             k = BiomeGenBase.field_76786_s.field_76756_M;
/*  42 */           } else if (i == BiomeGenBase.field_76767_f.field_76756_M) {
/*  43 */             k = BiomeGenBase.field_76785_t.field_76756_M;
/*  44 */           } else if (i == BiomeGenBase.field_150583_P.field_76756_M) {
/*  45 */             k = BiomeGenBase.field_150582_Q.field_76756_M;
/*  46 */           } else if (i == BiomeGenBase.field_150585_R.field_76756_M) {
/*  47 */             k = BiomeGenBase.field_76772_c.field_76756_M;
/*  48 */           } else if (i == BiomeGenBase.field_76768_g.field_76756_M) {
/*  49 */             k = BiomeGenBase.field_76784_u.field_76756_M;
/*  50 */           } else if (i == BiomeGenBase.field_150578_U.field_76756_M) {
/*  51 */             k = BiomeGenBase.field_150581_V.field_76756_M;
/*  52 */           } else if (i == BiomeGenBase.field_150584_S.field_76756_M) {
/*  53 */             k = BiomeGenBase.field_150579_T.field_76756_M;
/*  54 */           } else if (i == BiomeGenBase.field_76772_c.field_76756_M) {
/*  55 */             if (func_75902_a(3) == 0) {
/*  56 */               k = BiomeGenBase.field_76785_t.field_76756_M;
/*     */             } else {
/*  58 */               k = BiomeGenBase.field_76767_f.field_76756_M;
/*     */             } 
/*  60 */           } else if (i == BiomeGenBase.field_76774_n.field_76756_M) {
/*  61 */             k = BiomeGenBase.field_76775_o.field_76756_M;
/*  62 */           } else if (i == BiomeGenBase.field_76782_w.field_76756_M) {
/*  63 */             k = BiomeGenBase.field_76792_x.field_76756_M;
/*  64 */           } else if (i == BiomeGenBase.field_76771_b.field_76756_M) {
/*  65 */             k = BiomeGenBase.field_150575_M.field_76756_M;
/*  66 */           } else if (i == BiomeGenBase.field_76770_e.field_76756_M) {
/*  67 */             k = BiomeGenBase.field_150580_W.field_76756_M;
/*  68 */           } else if (i == BiomeGenBase.field_150588_X.field_76756_M) {
/*  69 */             k = BiomeGenBase.field_150587_Y.field_76756_M;
/*  70 */           } else if (func_151616_a(i, BiomeGenBase.field_150607_aa.field_76756_M)) {
/*  71 */             k = BiomeGenBase.field_150589_Z.field_76756_M;
/*  72 */           } else if (i == BiomeGenBase.field_150575_M.field_76756_M && 
/*  73 */             func_75902_a(3) == 0) {
/*  74 */             int m = func_75902_a(2);
/*  75 */             if (m == 0) {
/*  76 */               k = BiomeGenBase.field_76772_c.field_76756_M;
/*     */             } else {
/*  78 */               k = BiomeGenBase.field_76767_f.field_76756_M;
/*     */             } 
/*     */           } 
/*     */           
/*  82 */           if (bool && k != i) {
/*  83 */             if (BiomeGenBase.func_150568_d(k + 128) != null) {
/*  84 */               k += 128;
/*     */             } else {
/*  86 */               k = i;
/*     */             } 
/*     */           }
/*  89 */           if (k == i) {
/*  90 */             arrayOfInt3[b1 + b * p_75904_3_] = i;
/*     */           } else {
/*  92 */             int m = arrayOfInt1[b1 + 1 + (b + 1 - 1) * (p_75904_3_ + 2)];
/*  93 */             int n = arrayOfInt1[b1 + 1 + 1 + (b + 1) * (p_75904_3_ + 2)];
/*  94 */             int i1 = arrayOfInt1[b1 + 1 - 1 + (b + 1) * (p_75904_3_ + 2)];
/*  95 */             int i2 = arrayOfInt1[b1 + 1 + (b + 1 + 1) * (p_75904_3_ + 2)];
/*  96 */             byte b2 = 0;
/*  97 */             if (func_151616_a(m, i)) {
/*  98 */               b2++;
/*     */             }
/* 100 */             if (func_151616_a(n, i)) {
/* 101 */               b2++;
/*     */             }
/* 103 */             if (func_151616_a(i1, i)) {
/* 104 */               b2++;
/*     */             }
/* 106 */             if (func_151616_a(i2, i)) {
/* 107 */               b2++;
/*     */             }
/* 109 */             if (b2 >= 3) {
/* 110 */               arrayOfInt3[b1 + b * p_75904_3_] = k;
/*     */             } else {
/* 112 */               arrayOfInt3[b1 + b * p_75904_3_] = i;
/*     */             } 
/*     */           } 
/*     */         } else {
/* 116 */           arrayOfInt3[b1 + b * p_75904_3_] = i;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 121 */     return arrayOfInt3;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\layer\GenLayerHills.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */