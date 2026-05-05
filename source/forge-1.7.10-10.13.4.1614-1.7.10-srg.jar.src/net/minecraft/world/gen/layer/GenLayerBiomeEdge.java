/*    */ package net.minecraft.world.gen.layer;
/*    */ 
/*    */ import net.minecraft.world.biome.BiomeGenBase;
/*    */ 
/*    */ public class GenLayerBiomeEdge
/*    */   extends GenLayer {
/*    */   public GenLayerBiomeEdge(long p_i45475_1_, GenLayer p_i45475_3_) {
/*  8 */     super(p_i45475_1_);
/*  9 */     this.field_75909_a = p_i45475_3_;
/*    */   }
/*    */   private static final String __OBFID = "CL_00000554";
/*    */   
/*    */   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
/* 14 */     int[] arrayOfInt1 = this.field_75909_a.func_75904_a(p_75904_1_ - 1, p_75904_2_ - 1, p_75904_3_ + 2, p_75904_4_ + 2);
/*    */     
/* 16 */     int[] arrayOfInt2 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
/* 17 */     for (byte b = 0; b < p_75904_4_; b++) {
/* 18 */       for (byte b1 = 0; b1 < p_75904_3_; b1++) {
/* 19 */         func_75903_a((b1 + p_75904_1_), (b + p_75904_2_));
/* 20 */         int i = arrayOfInt1[b1 + 1 + (b + 1) * (p_75904_3_ + 2)];
/* 21 */         if (!func_151636_a(arrayOfInt1, arrayOfInt2, b1, b, p_75904_3_, i, BiomeGenBase.field_76770_e.field_76756_M, BiomeGenBase.field_76783_v.field_76756_M) && 
/* 22 */           !func_151635_b(arrayOfInt1, arrayOfInt2, b1, b, p_75904_3_, i, BiomeGenBase.field_150607_aa.field_76756_M, BiomeGenBase.field_150589_Z.field_76756_M) && 
/* 23 */           !func_151635_b(arrayOfInt1, arrayOfInt2, b1, b, p_75904_3_, i, BiomeGenBase.field_150608_ab.field_76756_M, BiomeGenBase.field_150589_Z.field_76756_M) && 
/* 24 */           !func_151635_b(arrayOfInt1, arrayOfInt2, b1, b, p_75904_3_, i, BiomeGenBase.field_150578_U.field_76756_M, BiomeGenBase.field_76768_g.field_76756_M)) {
/* 25 */           if (i == BiomeGenBase.field_76769_d.field_76756_M) {
/* 26 */             int j = arrayOfInt1[b1 + 1 + (b + 1 - 1) * (p_75904_3_ + 2)];
/* 27 */             int k = arrayOfInt1[b1 + 1 + 1 + (b + 1) * (p_75904_3_ + 2)];
/* 28 */             int m = arrayOfInt1[b1 + 1 - 1 + (b + 1) * (p_75904_3_ + 2)];
/* 29 */             int n = arrayOfInt1[b1 + 1 + (b + 1 + 1) * (p_75904_3_ + 2)];
/* 30 */             if (j == BiomeGenBase.field_76774_n.field_76756_M || k == BiomeGenBase.field_76774_n.field_76756_M || m == BiomeGenBase.field_76774_n.field_76756_M || n == BiomeGenBase.field_76774_n.field_76756_M) {
/* 31 */               arrayOfInt2[b1 + b * p_75904_3_] = BiomeGenBase.field_150580_W.field_76756_M;
/*    */             } else {
/* 33 */               arrayOfInt2[b1 + b * p_75904_3_] = i;
/*    */             } 
/* 35 */           } else if (i == BiomeGenBase.field_76780_h.field_76756_M) {
/*    */             
/* 37 */             int j = arrayOfInt1[b1 + 1 + (b + 1 - 1) * (p_75904_3_ + 2)];
/* 38 */             int k = arrayOfInt1[b1 + 1 + 1 + (b + 1) * (p_75904_3_ + 2)];
/* 39 */             int m = arrayOfInt1[b1 + 1 - 1 + (b + 1) * (p_75904_3_ + 2)];
/* 40 */             int n = arrayOfInt1[b1 + 1 + (b + 1 + 1) * (p_75904_3_ + 2)];
/* 41 */             if (j == BiomeGenBase.field_76769_d.field_76756_M || k == BiomeGenBase.field_76769_d.field_76756_M || m == BiomeGenBase.field_76769_d.field_76756_M || n == BiomeGenBase.field_76769_d.field_76756_M || j == BiomeGenBase.field_150584_S.field_76756_M || k == BiomeGenBase.field_150584_S.field_76756_M || m == BiomeGenBase.field_150584_S.field_76756_M || n == BiomeGenBase.field_150584_S.field_76756_M || j == BiomeGenBase.field_76774_n.field_76756_M || k == BiomeGenBase.field_76774_n.field_76756_M || m == BiomeGenBase.field_76774_n.field_76756_M || n == BiomeGenBase.field_76774_n.field_76756_M) {
/*    */               
/* 43 */               arrayOfInt2[b1 + b * p_75904_3_] = BiomeGenBase.field_76772_c.field_76756_M;
/* 44 */             } else if (j == BiomeGenBase.field_76782_w.field_76756_M || n == BiomeGenBase.field_76782_w.field_76756_M || k == BiomeGenBase.field_76782_w.field_76756_M || m == BiomeGenBase.field_76782_w.field_76756_M) {
/* 45 */               arrayOfInt2[b1 + b * p_75904_3_] = BiomeGenBase.field_150574_L.field_76756_M;
/*    */             } else {
/* 47 */               arrayOfInt2[b1 + b * p_75904_3_] = i;
/*    */             } 
/*    */           } else {
/* 50 */             arrayOfInt2[b1 + b * p_75904_3_] = i;
/*    */           } 
/*    */         }
/*    */       } 
/*    */     } 
/* 55 */     return arrayOfInt2;
/*    */   }
/*    */   
/*    */   private boolean func_151636_a(int[] p_151636_1_, int[] p_151636_2_, int p_151636_3_, int p_151636_4_, int p_151636_5_, int p_151636_6_, int p_151636_7_, int p_151636_8_) {
/* 59 */     if (func_151616_a(p_151636_6_, p_151636_7_)) {
/* 60 */       int i = p_151636_1_[p_151636_3_ + 1 + (p_151636_4_ + 1 - 1) * (p_151636_5_ + 2)];
/* 61 */       int j = p_151636_1_[p_151636_3_ + 1 + 1 + (p_151636_4_ + 1) * (p_151636_5_ + 2)];
/* 62 */       int k = p_151636_1_[p_151636_3_ + 1 - 1 + (p_151636_4_ + 1) * (p_151636_5_ + 2)];
/* 63 */       int m = p_151636_1_[p_151636_3_ + 1 + (p_151636_4_ + 1 + 1) * (p_151636_5_ + 2)];
/* 64 */       if (!func_151634_b(i, p_151636_7_) || !func_151634_b(j, p_151636_7_) || !func_151634_b(k, p_151636_7_) || !func_151634_b(m, p_151636_7_)) {
/* 65 */         p_151636_2_[p_151636_3_ + p_151636_4_ * p_151636_5_] = p_151636_8_;
/*    */       } else {
/* 67 */         p_151636_2_[p_151636_3_ + p_151636_4_ * p_151636_5_] = p_151636_6_;
/*    */       } 
/* 69 */       return true;
/*    */     } 
/* 71 */     return false;
/*    */   }
/*    */   
/*    */   private boolean func_151635_b(int[] p_151635_1_, int[] p_151635_2_, int p_151635_3_, int p_151635_4_, int p_151635_5_, int p_151635_6_, int p_151635_7_, int p_151635_8_) {
/* 75 */     if (p_151635_6_ == p_151635_7_) {
/* 76 */       int i = p_151635_1_[p_151635_3_ + 1 + (p_151635_4_ + 1 - 1) * (p_151635_5_ + 2)];
/* 77 */       int j = p_151635_1_[p_151635_3_ + 1 + 1 + (p_151635_4_ + 1) * (p_151635_5_ + 2)];
/* 78 */       int k = p_151635_1_[p_151635_3_ + 1 - 1 + (p_151635_4_ + 1) * (p_151635_5_ + 2)];
/* 79 */       int m = p_151635_1_[p_151635_3_ + 1 + (p_151635_4_ + 1 + 1) * (p_151635_5_ + 2)];
/* 80 */       if (!func_151616_a(i, p_151635_7_) || !func_151616_a(j, p_151635_7_) || !func_151616_a(k, p_151635_7_) || !func_151616_a(m, p_151635_7_)) {
/* 81 */         p_151635_2_[p_151635_3_ + p_151635_4_ * p_151635_5_] = p_151635_8_;
/*    */       } else {
/* 83 */         p_151635_2_[p_151635_3_ + p_151635_4_ * p_151635_5_] = p_151635_6_;
/*    */       } 
/* 85 */       return true;
/*    */     } 
/* 87 */     return false;
/*    */   }
/*    */   
/*    */   private boolean func_151634_b(int p_151634_1_, int p_151634_2_) {
/* 91 */     if (func_151616_a(p_151634_1_, p_151634_2_)) {
/* 92 */       return true;
/*    */     }
/* 94 */     if (BiomeGenBase.func_150568_d(p_151634_1_) != null && BiomeGenBase.func_150568_d(p_151634_2_) != null) {
/* 95 */       BiomeGenBase.TempCategory tempCategory1 = BiomeGenBase.func_150568_d(p_151634_1_).func_150561_m();
/* 96 */       BiomeGenBase.TempCategory tempCategory2 = BiomeGenBase.func_150568_d(p_151634_2_).func_150561_m();
/* 97 */       return (tempCategory1 == tempCategory2 || tempCategory1 == BiomeGenBase.TempCategory.MEDIUM || tempCategory2 == BiomeGenBase.TempCategory.MEDIUM);
/*    */     } 
/* 99 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\layer\GenLayerBiomeEdge.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */