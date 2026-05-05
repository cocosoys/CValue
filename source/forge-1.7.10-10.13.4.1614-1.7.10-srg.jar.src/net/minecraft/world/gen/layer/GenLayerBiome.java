/*    */ package net.minecraft.world.gen.layer;
/*    */ 
/*    */ import net.minecraft.world.WorldType;
/*    */ import net.minecraft.world.biome.BiomeGenBase;
/*    */ 
/*    */ public class GenLayerBiome extends GenLayer {
/*  7 */   private BiomeGenBase[] field_151623_c = new BiomeGenBase[] { BiomeGenBase.field_76769_d, BiomeGenBase.field_76769_d, BiomeGenBase.field_76769_d, BiomeGenBase.field_150588_X, BiomeGenBase.field_150588_X, BiomeGenBase.field_76772_c };
/*    */ 
/*    */ 
/*    */   
/* 11 */   private BiomeGenBase[] field_151621_d = new BiomeGenBase[] { BiomeGenBase.field_76767_f, BiomeGenBase.field_150585_R, BiomeGenBase.field_76770_e, BiomeGenBase.field_76772_c, BiomeGenBase.field_150583_P, BiomeGenBase.field_76780_h };
/*    */ 
/*    */ 
/*    */   
/* 15 */   private BiomeGenBase[] field_151622_e = new BiomeGenBase[] { BiomeGenBase.field_76767_f, BiomeGenBase.field_76770_e, BiomeGenBase.field_76768_g, BiomeGenBase.field_76772_c };
/*    */ 
/*    */ 
/*    */   
/* 19 */   private BiomeGenBase[] field_151620_f = new BiomeGenBase[] { BiomeGenBase.field_76774_n, BiomeGenBase.field_76774_n, BiomeGenBase.field_76774_n, BiomeGenBase.field_150584_S };
/*    */   
/*    */   private static final String __OBFID = "CL_00000555";
/*    */ 
/*    */   
/*    */   public GenLayerBiome(long p_i2122_1_, GenLayer p_i2122_3_, WorldType p_i2122_4_) {
/* 25 */     super(p_i2122_1_);
/* 26 */     this.field_75909_a = p_i2122_3_;
/*    */     
/* 28 */     if (p_i2122_4_ == WorldType.field_77136_e) {
/* 29 */       this.field_151623_c = new BiomeGenBase[] { BiomeGenBase.field_76769_d, BiomeGenBase.field_76767_f, BiomeGenBase.field_76770_e, BiomeGenBase.field_76780_h, BiomeGenBase.field_76772_c, BiomeGenBase.field_76768_g };
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int[] func_75904_a(int p_75904_1_, int p_75904_2_, int p_75904_3_, int p_75904_4_) {
/* 37 */     int[] arrayOfInt1 = this.field_75909_a.func_75904_a(p_75904_1_, p_75904_2_, p_75904_3_, p_75904_4_);
/*    */     
/* 39 */     int[] arrayOfInt2 = IntCache.func_76445_a(p_75904_3_ * p_75904_4_);
/* 40 */     for (byte b = 0; b < p_75904_4_; b++) {
/* 41 */       for (byte b1 = 0; b1 < p_75904_3_; b1++) {
/* 42 */         func_75903_a((b1 + p_75904_1_), (b + p_75904_2_));
/* 43 */         int i = arrayOfInt1[b1 + b * p_75904_3_];
/* 44 */         int j = (i & 0xF00) >> 8;
/* 45 */         i &= 0xFFFFF0FF;
/* 46 */         if (func_151618_b(i)) {
/* 47 */           arrayOfInt2[b1 + b * p_75904_3_] = i;
/* 48 */         } else if (i == BiomeGenBase.field_76789_p.field_76756_M) {
/* 49 */           arrayOfInt2[b1 + b * p_75904_3_] = i;
/* 50 */         } else if (i == 1) {
/* 51 */           if (j > 0) {
/* 52 */             if (func_75902_a(3) == 0) {
/* 53 */               arrayOfInt2[b1 + b * p_75904_3_] = BiomeGenBase.field_150608_ab.field_76756_M;
/*    */             } else {
/* 55 */               arrayOfInt2[b1 + b * p_75904_3_] = BiomeGenBase.field_150607_aa.field_76756_M;
/*    */             } 
/*    */           } else {
/* 58 */             arrayOfInt2[b1 + b * p_75904_3_] = (this.field_151623_c[func_75902_a(this.field_151623_c.length)]).field_76756_M;
/*    */           } 
/* 60 */         } else if (i == 2) {
/* 61 */           if (j > 0) {
/* 62 */             arrayOfInt2[b1 + b * p_75904_3_] = BiomeGenBase.field_76782_w.field_76756_M;
/*    */           } else {
/* 64 */             arrayOfInt2[b1 + b * p_75904_3_] = (this.field_151621_d[func_75902_a(this.field_151621_d.length)]).field_76756_M;
/*    */           } 
/* 66 */         } else if (i == 3) {
/* 67 */           if (j > 0) {
/* 68 */             arrayOfInt2[b1 + b * p_75904_3_] = BiomeGenBase.field_150578_U.field_76756_M;
/*    */           } else {
/* 70 */             arrayOfInt2[b1 + b * p_75904_3_] = (this.field_151622_e[func_75902_a(this.field_151622_e.length)]).field_76756_M;
/*    */           } 
/* 72 */         } else if (i == 4) {
/* 73 */           arrayOfInt2[b1 + b * p_75904_3_] = (this.field_151620_f[func_75902_a(this.field_151620_f.length)]).field_76756_M;
/*    */         } else {
/* 75 */           arrayOfInt2[b1 + b * p_75904_3_] = BiomeGenBase.field_76789_p.field_76756_M;
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 80 */     return arrayOfInt2;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\layer\GenLayerBiome.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */