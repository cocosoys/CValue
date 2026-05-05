/*     */ package JinRyuu.DragonBC.common.Worlds;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.biome.BiomeGenBase;
/*     */ import net.minecraft.world.gen.MapGenBase;
/*     */ 
/*     */ 
/*     */ public class x1MapGenCavesOW
/*     */   extends MapGenBase
/*     */ {
/*     */   private static final String __OBFID = "CL_00000393";
/*     */   
/*     */   protected void func_151542_a(long p_151542_1_, int p_151542_3_, int p_151542_4_, Block[] p_151542_5_, double p_151542_6_, double p_151542_8_, double p_151542_10_) {
/*  18 */     func_151541_a(p_151542_1_, p_151542_3_, p_151542_4_, p_151542_5_, p_151542_6_, p_151542_8_, p_151542_10_, 1.0F + this.field_75038_b.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_151541_a(long p_151541_1_, int p_151541_3_, int p_151541_4_, Block[] p_151541_5_, double p_151541_6_, double p_151541_8_, double p_151541_10_, float p_151541_12_, float p_151541_13_, float p_151541_14_, int p_151541_15_, int p_151541_16_, double p_151541_17_) {
/*  23 */     double d4 = (p_151541_3_ * 16 + 8);
/*  24 */     double d5 = (p_151541_4_ * 16 + 8);
/*  25 */     float f3 = 0.0F;
/*  26 */     float f4 = 0.0F;
/*  27 */     Random random = new Random(p_151541_1_);
/*     */     
/*  29 */     if (p_151541_16_ <= 0) {
/*     */       
/*  31 */       int j1 = this.field_75040_a * 16 - 16;
/*  32 */       p_151541_16_ = j1 - random.nextInt(j1 / 4);
/*     */     } 
/*     */     
/*  35 */     boolean flag2 = false;
/*     */     
/*  37 */     if (p_151541_15_ == -1) {
/*     */       
/*  39 */       p_151541_15_ = p_151541_16_ / 2;
/*  40 */       flag2 = true;
/*     */     } 
/*     */     
/*  43 */     int k1 = random.nextInt(p_151541_16_ / 2) + p_151541_16_ / 4;
/*     */     
/*  45 */     for (boolean flag = (random.nextInt(6) == 0); p_151541_15_ < p_151541_16_; p_151541_15_++) {
/*     */       
/*  47 */       double d6 = 1.5D + (MathHelper.func_76126_a(p_151541_15_ * 3.1415927F / p_151541_16_) * p_151541_12_ * 1.0F);
/*  48 */       double d7 = d6 * p_151541_17_;
/*  49 */       float f5 = MathHelper.func_76134_b(p_151541_14_);
/*  50 */       float f6 = MathHelper.func_76126_a(p_151541_14_);
/*  51 */       p_151541_6_ += (MathHelper.func_76134_b(p_151541_13_) * f5);
/*  52 */       p_151541_8_ += f6;
/*  53 */       p_151541_10_ += (MathHelper.func_76126_a(p_151541_13_) * f5);
/*     */       
/*  55 */       if (flag) {
/*     */         
/*  57 */         p_151541_14_ *= 0.92F;
/*     */       }
/*     */       else {
/*     */         
/*  61 */         p_151541_14_ *= 0.7F;
/*     */       } 
/*     */       
/*  64 */       p_151541_14_ += f4 * 0.1F;
/*  65 */       p_151541_13_ += f3 * 0.1F;
/*  66 */       f4 *= 0.9F;
/*  67 */       f3 *= 0.75F;
/*  68 */       f4 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
/*  69 */       f3 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;
/*     */       
/*  71 */       if (!flag2 && p_151541_15_ == k1 && p_151541_12_ > 1.0F && p_151541_16_ > 0) {
/*     */         
/*  73 */         func_151541_a(random.nextLong(), p_151541_3_, p_151541_4_, p_151541_5_, p_151541_6_, p_151541_8_, p_151541_10_, random.nextFloat() * 0.5F + 0.5F, p_151541_13_ - 1.5707964F, p_151541_14_ / 3.0F, p_151541_15_, p_151541_16_, 1.0D);
/*  74 */         func_151541_a(random.nextLong(), p_151541_3_, p_151541_4_, p_151541_5_, p_151541_6_, p_151541_8_, p_151541_10_, random.nextFloat() * 0.5F + 0.5F, p_151541_13_ + 1.5707964F, p_151541_14_ / 3.0F, p_151541_15_, p_151541_16_, 1.0D);
/*     */         
/*     */         return;
/*     */       } 
/*  78 */       if (flag2 || random.nextInt(4) != 0) {
/*     */         
/*  80 */         double d8 = p_151541_6_ - d4;
/*  81 */         double d9 = p_151541_10_ - d5;
/*  82 */         double d10 = (p_151541_16_ - p_151541_15_);
/*  83 */         double d11 = (p_151541_12_ + 2.0F + 16.0F);
/*     */         
/*  85 */         if (d8 * d8 + d9 * d9 - d10 * d10 > d11 * d11) {
/*     */           return;
/*     */         }
/*     */ 
/*     */         
/*  90 */         if (p_151541_6_ >= d4 - 16.0D - d6 * 2.0D && p_151541_10_ >= d5 - 16.0D - d6 * 2.0D && p_151541_6_ <= d4 + 16.0D + d6 * 2.0D && p_151541_10_ <= d5 + 16.0D + d6 * 2.0D) {
/*     */           
/*  92 */           int i4 = MathHelper.func_76128_c(p_151541_6_ - d6) - p_151541_3_ * 16 - 1;
/*  93 */           int l1 = MathHelper.func_76128_c(p_151541_6_ + d6) - p_151541_3_ * 16 + 1;
/*  94 */           int j4 = MathHelper.func_76128_c(p_151541_8_ - d7) - 1;
/*  95 */           int i2 = MathHelper.func_76128_c(p_151541_8_ + d7) + 1;
/*  96 */           int k4 = MathHelper.func_76128_c(p_151541_10_ - d6) - p_151541_4_ * 16 - 1;
/*  97 */           int j2 = MathHelper.func_76128_c(p_151541_10_ + d6) - p_151541_4_ * 16 + 1;
/*     */           
/*  99 */           if (i4 < 0)
/*     */           {
/* 101 */             i4 = 0;
/*     */           }
/*     */           
/* 104 */           if (l1 > 16)
/*     */           {
/* 106 */             l1 = 16;
/*     */           }
/*     */           
/* 109 */           if (j4 < 1)
/*     */           {
/* 111 */             j4 = 1;
/*     */           }
/*     */           
/* 114 */           if (i2 > 248)
/*     */           {
/* 116 */             i2 = 248;
/*     */           }
/*     */           
/* 119 */           if (k4 < 0)
/*     */           {
/* 121 */             k4 = 0;
/*     */           }
/*     */           
/* 124 */           if (j2 > 16)
/*     */           {
/* 126 */             j2 = 16;
/*     */           }
/*     */           
/* 129 */           boolean flag3 = false;
/*     */           
/*     */           int k2;
/*     */           
/* 133 */           for (k2 = i4; !flag3 && k2 < l1; k2++) {
/*     */             
/* 135 */             for (int l2 = k4; !flag3 && l2 < j2; l2++) {
/*     */               
/* 137 */               for (int i3 = i2 + 1; !flag3 && i3 >= j4 - 1; i3--) {
/*     */                 
/* 139 */                 int j3 = (k2 * 16 + l2) * 256 + i3;
/*     */                 
/* 141 */                 if (i3 >= 0 && i3 < 256) {
/*     */                   
/* 143 */                   Block block = p_151541_5_[j3];
/*     */                   
/* 145 */                   if (isOceanBlock(p_151541_5_, j3, k2, i3, l2, p_151541_3_, p_151541_4_))
/*     */                   {
/* 147 */                     flag3 = true;
/*     */                   }
/*     */                   
/* 150 */                   if (i3 != j4 - 1 && k2 != i4 && k2 != l1 - 1 && l2 != k4 && l2 != j2 - 1)
/*     */                   {
/* 152 */                     i3 = j4;
/*     */                   }
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/* 159 */           if (!flag3) {
/*     */             
/* 161 */             for (k2 = i4; k2 < l1; k2++) {
/*     */               
/* 163 */               double d13 = ((k2 + p_151541_3_ * 16) + 0.5D - p_151541_6_) / d6;
/*     */               
/* 165 */               for (int j3 = k4; j3 < j2; j3++) {
/*     */                 
/* 167 */                 double d14 = ((j3 + p_151541_4_ * 16) + 0.5D - p_151541_10_) / d6;
/* 168 */                 int k3 = (k2 * 16 + j3) * 256 + i2;
/* 169 */                 boolean flag1 = false;
/*     */                 
/* 171 */                 if (d13 * d13 + d14 * d14 < 1.0D)
/*     */                 {
/* 173 */                   for (int l3 = i2 - 1; l3 >= j4; l3--) {
/*     */                     
/* 175 */                     double d12 = (l3 + 0.5D - p_151541_8_) / d7;
/*     */                     
/* 177 */                     if (d12 > -0.7D && d13 * d13 + d12 * d12 + d14 * d14 < 1.0D) {
/*     */                       
/* 179 */                       Block block1 = p_151541_5_[k3];
/*     */                       
/* 181 */                       if (isTopBlock(p_151541_5_, k3, k2, l3, j3, p_151541_3_, p_151541_4_))
/*     */                       {
/* 183 */                         flag1 = true;
/*     */                       }
/* 185 */                       digBlock(p_151541_5_, k3, k2, l3, j3, p_151541_3_, p_151541_4_, flag1);
/*     */                     } 
/*     */                     
/* 188 */                     k3--;
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */             } 
/*     */             
/* 194 */             if (flag2) {
/*     */               break;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_151538_a(World p_151538_1_, int p_151538_2_, int p_151538_3_, int p_151538_4_, int p_151538_5_, Block[] p_151538_6_) {
/* 206 */     int i1 = this.field_75038_b.nextInt(this.field_75038_b.nextInt(this.field_75038_b.nextInt(15) + 1) + 1);
/*     */     
/* 208 */     if (this.field_75038_b.nextInt(7) != 0)
/*     */     {
/* 210 */       i1 = 0;
/*     */     }
/*     */     
/* 213 */     for (int j1 = 0; j1 < i1; j1++) {
/*     */       
/* 215 */       double d0 = (p_151538_2_ * 16 + this.field_75038_b.nextInt(16));
/* 216 */       double d1 = this.field_75038_b.nextInt(this.field_75038_b.nextInt(120) + 8);
/* 217 */       double d2 = (p_151538_3_ * 16 + this.field_75038_b.nextInt(16));
/* 218 */       int k1 = 1;
/*     */       
/* 220 */       if (this.field_75038_b.nextInt(4) == 0) {
/*     */         
/* 222 */         func_151542_a(this.field_75038_b.nextLong(), p_151538_4_, p_151538_5_, p_151538_6_, d0, d1, d2);
/* 223 */         k1 += this.field_75038_b.nextInt(4);
/*     */       } 
/*     */       
/* 226 */       for (int l1 = 0; l1 < k1; l1++) {
/*     */         
/* 228 */         float f = this.field_75038_b.nextFloat() * 3.1415927F * 2.0F;
/* 229 */         float f1 = (this.field_75038_b.nextFloat() - 0.5F) * 2.0F / 8.0F;
/* 230 */         float f2 = this.field_75038_b.nextFloat() * 2.0F + this.field_75038_b.nextFloat();
/*     */         
/* 232 */         if (this.field_75038_b.nextInt(10) == 0)
/*     */         {
/* 234 */           f2 *= this.field_75038_b.nextFloat() * this.field_75038_b.nextFloat() * 3.0F + 1.0F;
/*     */         }
/*     */         
/* 237 */         func_151541_a(this.field_75038_b.nextLong(), p_151538_4_, p_151538_5_, p_151538_6_, d0, d1, d2, f2, f, f1, 0, 0, 1.0D);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isOceanBlock(Block[] data, int index, int x, int y, int z, int chunkX, int chunkZ) {
/* 244 */     return (data[index] == Blocks.field_150358_i || data[index] == Blocks.field_150355_j);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isExceptionBiome(BiomeGenBase biome) {
/* 250 */     if (biome == BiomeGenBase.field_76789_p) return true; 
/* 251 */     if (biome == BiomeGenBase.field_76787_r) return true; 
/* 252 */     if (biome == BiomeGenBase.field_76769_d) return true; 
/* 253 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isTopBlock(Block[] data, int index, int x, int y, int z, int chunkX, int chunkZ) {
/* 260 */     BiomeGenBase biome = this.field_75039_c.func_72807_a(x + chunkX * 16, z + chunkZ * 16);
/* 261 */     return isExceptionBiome(biome) ? ((data[index] == Blocks.field_150349_c)) : ((data[index] == biome.field_76752_A));
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
/*     */   protected void digBlock(Block[] data, int index, int x, int y, int z, int chunkX, int chunkZ, boolean foundTop) {
/* 281 */     BiomeGenBase biome = this.field_75039_c.func_72807_a(x + chunkX * 16, z + chunkZ * 16);
/* 282 */     Block top = isExceptionBiome(biome) ? (Block)Blocks.field_150349_c : biome.field_76752_A;
/* 283 */     Block filler = isExceptionBiome(biome) ? Blocks.field_150346_d : biome.field_76753_B;
/* 284 */     Block block = data[index];
/*     */     
/* 286 */     if (block == Blocks.field_150348_b || block == Blocks.field_150346_d || block == filler || block == top)
/*     */     {
/* 288 */       if (y < 10) {
/*     */         
/* 290 */         data[index] = Blocks.field_150353_l;
/*     */       }
/*     */       else {
/*     */         
/* 294 */         data[index] = null;
/*     */         
/* 296 */         if (foundTop && data[index - 1] == filler)
/*     */         {
/* 298 */           data[index - 1] = top;
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\x1MapGenCavesOW.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */