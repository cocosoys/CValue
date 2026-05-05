/*     */ package net.minecraft.world.gen;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MapGenCaves extends MapGenBase {
/*     */   private static final String __OBFID = "CL_00000393";
/*     */   
/*     */   protected void func_151542_a(long p_151542_1_, int p_151542_3_, int p_151542_4_, Block[] p_151542_5_, double p_151542_6_, double p_151542_8_, double p_151542_10_) {
/*  13 */     func_151541_a(p_151542_1_, p_151542_3_, p_151542_4_, p_151542_5_, p_151542_6_, p_151542_8_, p_151542_10_, 1.0F + this.field_75038_b.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
/*     */   }
/*     */   
/*     */   protected void func_151541_a(long p_151541_1_, int p_151541_3_, int p_151541_4_, Block[] p_151541_5_, double p_151541_6_, double p_151541_8_, double p_151541_10_, float p_151541_12_, float p_151541_13_, float p_151541_14_, int p_151541_15_, int p_151541_16_, double p_151541_17_) {
/*  17 */     double d1 = (p_151541_3_ * 16 + 8);
/*  18 */     double d2 = (p_151541_4_ * 16 + 8);
/*     */     
/*  20 */     float f1 = 0.0F;
/*  21 */     float f2 = 0.0F;
/*  22 */     Random random = new Random(p_151541_1_);
/*     */     
/*  24 */     if (p_151541_16_ <= 0) {
/*  25 */       int j = this.field_75040_a * 16 - 16;
/*  26 */       p_151541_16_ = j - random.nextInt(j / 4);
/*     */     } 
/*  28 */     boolean bool1 = false;
/*     */     
/*  30 */     if (p_151541_15_ == -1) {
/*  31 */       p_151541_15_ = p_151541_16_ / 2;
/*  32 */       bool1 = true;
/*     */     } 
/*     */     
/*  35 */     int i = random.nextInt(p_151541_16_ / 2) + p_151541_16_ / 4;
/*  36 */     boolean bool2 = (random.nextInt(6) == 0) ? true : false;
/*     */     
/*  38 */     for (; p_151541_15_ < p_151541_16_; p_151541_15_++) {
/*  39 */       double d3 = 1.5D + (MathHelper.func_76126_a(p_151541_15_ * 3.1415927F / p_151541_16_) * p_151541_12_ * 1.0F);
/*  40 */       double d4 = d3 * p_151541_17_;
/*     */       
/*  42 */       float f3 = MathHelper.func_76134_b(p_151541_14_);
/*  43 */       float f4 = MathHelper.func_76126_a(p_151541_14_);
/*  44 */       p_151541_6_ += (MathHelper.func_76134_b(p_151541_13_) * f3);
/*  45 */       p_151541_8_ += f4;
/*  46 */       p_151541_10_ += (MathHelper.func_76126_a(p_151541_13_) * f3);
/*     */       
/*  48 */       if (bool2) {
/*  49 */         p_151541_14_ *= 0.92F;
/*     */       } else {
/*  51 */         p_151541_14_ *= 0.7F;
/*     */       } 
/*  53 */       p_151541_14_ += f2 * 0.1F;
/*  54 */       p_151541_13_ += f1 * 0.1F;
/*     */       
/*  56 */       f2 *= 0.9F;
/*  57 */       f1 *= 0.75F;
/*  58 */       f2 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
/*  59 */       f1 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;
/*     */       
/*  61 */       if (!bool1 && p_151541_15_ == i && p_151541_12_ > 1.0F && p_151541_16_ > 0) {
/*  62 */         func_151541_a(random.nextLong(), p_151541_3_, p_151541_4_, p_151541_5_, p_151541_6_, p_151541_8_, p_151541_10_, random.nextFloat() * 0.5F + 0.5F, p_151541_13_ - 1.5707964F, p_151541_14_ / 3.0F, p_151541_15_, p_151541_16_, 1.0D);
/*  63 */         func_151541_a(random.nextLong(), p_151541_3_, p_151541_4_, p_151541_5_, p_151541_6_, p_151541_8_, p_151541_10_, random.nextFloat() * 0.5F + 0.5F, p_151541_13_ + 1.5707964F, p_151541_14_ / 3.0F, p_151541_15_, p_151541_16_, 1.0D);
/*     */         return;
/*     */       } 
/*  66 */       if (bool1 || random.nextInt(4) != 0) {
/*     */ 
/*     */         
/*  69 */         double d5 = p_151541_6_ - d1;
/*  70 */         double d6 = p_151541_10_ - d2;
/*  71 */         double d7 = (p_151541_16_ - p_151541_15_);
/*  72 */         double d8 = (p_151541_12_ + 2.0F + 16.0F);
/*  73 */         if (d5 * d5 + d6 * d6 - d7 * d7 > d8 * d8) {
/*     */           return;
/*     */         }
/*     */ 
/*     */         
/*  78 */         if (p_151541_6_ >= d1 - 16.0D - d3 * 2.0D && p_151541_10_ >= d2 - 16.0D - d3 * 2.0D && p_151541_6_ <= d1 + 16.0D + d3 * 2.0D && p_151541_10_ <= d2 + 16.0D + d3 * 2.0D) {
/*     */ 
/*     */           
/*  81 */           int j = MathHelper.func_76128_c(p_151541_6_ - d3) - p_151541_3_ * 16 - 1;
/*  82 */           int k = MathHelper.func_76128_c(p_151541_6_ + d3) - p_151541_3_ * 16 + 1;
/*     */           
/*  84 */           int m = MathHelper.func_76128_c(p_151541_8_ - d4) - 1;
/*  85 */           int n = MathHelper.func_76128_c(p_151541_8_ + d4) + 1;
/*     */           
/*  87 */           int i1 = MathHelper.func_76128_c(p_151541_10_ - d3) - p_151541_4_ * 16 - 1;
/*  88 */           int i2 = MathHelper.func_76128_c(p_151541_10_ + d3) - p_151541_4_ * 16 + 1;
/*     */           
/*  90 */           if (j < 0) j = 0; 
/*  91 */           if (k > 16) k = 16;
/*     */           
/*  93 */           if (m < 1) m = 1; 
/*  94 */           if (n > 248) n = 248;
/*     */           
/*  96 */           if (i1 < 0) i1 = 0; 
/*  97 */           if (i2 > 16) i2 = 16;
/*     */           
/*  99 */           boolean bool = false; int i3;
/* 100 */           for (i3 = j; !bool && i3 < k; i3++) {
/* 101 */             for (int i4 = i1; !bool && i4 < i2; i4++) {
/* 102 */               for (int i5 = n + 1; !bool && i5 >= m - 1; i5--) {
/* 103 */                 int i6 = (i3 * 16 + i4) * 256 + i5;
/* 104 */                 if (i5 >= 0 && i5 < 256) {
/* 105 */                   Block block = p_151541_5_[i6];
/* 106 */                   if (block == Blocks.field_150358_i || block == Blocks.field_150355_j) {
/* 107 */                     bool = true;
/*     */                   }
/* 109 */                   if (i5 != m - 1 && i3 != j && i3 != k - 1 && i4 != i1 && i4 != i2 - 1)
/* 110 */                     i5 = m; 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/* 115 */           if (!bool) {
/*     */             
/* 117 */             for (i3 = j; i3 < k; i3++) {
/* 118 */               double d = ((i3 + p_151541_3_ * 16) + 0.5D - p_151541_6_) / d3;
/* 119 */               for (int i4 = i1; i4 < i2; i4++) {
/* 120 */                 double d9 = ((i4 + p_151541_4_ * 16) + 0.5D - p_151541_10_) / d3;
/* 121 */                 int i5 = (i3 * 16 + i4) * 256 + n;
/* 122 */                 boolean bool3 = false;
/* 123 */                 if (d * d + d9 * d9 < 1.0D) {
/* 124 */                   for (int i6 = n - 1; i6 >= m; i6--) {
/* 125 */                     double d10 = (i6 + 0.5D - p_151541_8_) / d4;
/* 126 */                     if (d10 > -0.7D && d * d + d10 * d10 + d9 * d9 < 1.0D) {
/* 127 */                       Block block = p_151541_5_[i5];
/* 128 */                       if (block == Blocks.field_150349_c) bool3 = true; 
/* 129 */                       if (block == Blocks.field_150348_b || block == Blocks.field_150346_d || block == Blocks.field_150349_c)
/* 130 */                         if (i6 < 10) {
/* 131 */                           p_151541_5_[i5] = Blocks.field_150353_l;
/*     */                         } else {
/* 133 */                           p_151541_5_[i5] = null;
/* 134 */                           if (bool3 && p_151541_5_[i5 - 1] == Blocks.field_150346_d) {
/* 135 */                             p_151541_5_[i5 - 1] = (this.field_75039_c.func_72807_a(i3 + p_151541_3_ * 16, i4 + p_151541_4_ * 16)).field_76752_A;
/*     */                           }
/*     */                         }  
/*     */                     } 
/* 139 */                     i5--;
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */             } 
/* 144 */             if (bool1)
/*     */               break; 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     }  } protected void func_151538_a(World p_151538_1_, int p_151538_2_, int p_151538_3_, int p_151538_4_, int p_151538_5_, Block[] p_151538_6_) {
/* 150 */     int i = this.field_75038_b.nextInt(this.field_75038_b.nextInt(this.field_75038_b.nextInt(15) + 1) + 1);
/* 151 */     if (this.field_75038_b.nextInt(7) != 0) i = 0;
/*     */     
/* 153 */     for (byte b = 0; b < i; b++) {
/* 154 */       double d1 = (p_151538_2_ * 16 + this.field_75038_b.nextInt(16));
/* 155 */       double d2 = this.field_75038_b.nextInt(this.field_75038_b.nextInt(120) + 8);
/* 156 */       double d3 = (p_151538_3_ * 16 + this.field_75038_b.nextInt(16));
/*     */       
/* 158 */       int j = 1;
/* 159 */       if (this.field_75038_b.nextInt(4) == 0) {
/* 160 */         func_151542_a(this.field_75038_b.nextLong(), p_151538_4_, p_151538_5_, p_151538_6_, d1, d2, d3);
/* 161 */         j += this.field_75038_b.nextInt(4);
/*     */       } 
/*     */       
/* 164 */       for (byte b1 = 0; b1 < j; b1++) {
/*     */         
/* 166 */         float f1 = this.field_75038_b.nextFloat() * 3.1415927F * 2.0F;
/* 167 */         float f2 = (this.field_75038_b.nextFloat() - 0.5F) * 2.0F / 8.0F;
/* 168 */         float f3 = this.field_75038_b.nextFloat() * 2.0F + this.field_75038_b.nextFloat();
/* 169 */         if (this.field_75038_b.nextInt(10) == 0) f3 *= this.field_75038_b.nextFloat() * this.field_75038_b.nextFloat() * 3.0F + 1.0F;
/*     */         
/* 171 */         func_151541_a(this.field_75038_b.nextLong(), p_151538_4_, p_151538_5_, p_151538_6_, d1, d2, d3, f3, f1, f2, 0, 0, 1.0D);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\MapGenCaves.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */