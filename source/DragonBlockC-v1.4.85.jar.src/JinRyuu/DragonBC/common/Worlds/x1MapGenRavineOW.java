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
/*     */ public class x1MapGenRavineOW
/*     */   extends MapGenBase
/*     */ {
/*  14 */   private float[] field_75046_d = new float[1024];
/*     */   
/*     */   private static final String __OBFID = "CL_00000390";
/*     */   
/*     */   protected void func_151540_a(long p_151540_1_, int p_151540_3_, int p_151540_4_, Block[] p_151540_5_, double p_151540_6_, double p_151540_8_, double p_151540_10_, float p_151540_12_, float p_151540_13_, float p_151540_14_, int p_151540_15_, int p_151540_16_, double p_151540_17_) {
/*  19 */     Random random = new Random(p_151540_1_);
/*  20 */     double d4 = (p_151540_3_ * 16 + 8);
/*  21 */     double d5 = (p_151540_4_ * 16 + 8);
/*  22 */     float f3 = 0.0F;
/*  23 */     float f4 = 0.0F;
/*     */     
/*  25 */     if (p_151540_16_ <= 0) {
/*     */       
/*  27 */       int j1 = this.field_75040_a * 16 - 16;
/*  28 */       p_151540_16_ = j1 - random.nextInt(j1 / 4);
/*     */     } 
/*     */     
/*  31 */     boolean flag1 = false;
/*     */     
/*  33 */     if (p_151540_15_ == -1) {
/*     */       
/*  35 */       p_151540_15_ = p_151540_16_ / 2;
/*  36 */       flag1 = true;
/*     */     } 
/*     */     
/*  39 */     float f5 = 1.0F;
/*     */     
/*  41 */     for (int k1 = 0; k1 < 256; k1++) {
/*     */       
/*  43 */       if (k1 == 0 || random.nextInt(3) == 0)
/*     */       {
/*  45 */         f5 = 1.0F + random.nextFloat() * random.nextFloat() * 1.0F;
/*     */       }
/*     */       
/*  48 */       this.field_75046_d[k1] = f5 * f5;
/*     */     } 
/*     */     
/*  51 */     for (; p_151540_15_ < p_151540_16_; p_151540_15_++) {
/*     */       
/*  53 */       double d12 = 1.5D + (MathHelper.func_76126_a(p_151540_15_ * 3.1415927F / p_151540_16_) * p_151540_12_ * 1.0F);
/*  54 */       double d6 = d12 * p_151540_17_;
/*  55 */       d12 *= random.nextFloat() * 0.25D + 0.75D;
/*  56 */       d6 *= random.nextFloat() * 0.25D + 0.75D;
/*  57 */       float f6 = MathHelper.func_76134_b(p_151540_14_);
/*  58 */       float f7 = MathHelper.func_76126_a(p_151540_14_);
/*  59 */       p_151540_6_ += (MathHelper.func_76134_b(p_151540_13_) * f6);
/*  60 */       p_151540_8_ += f7;
/*  61 */       p_151540_10_ += (MathHelper.func_76126_a(p_151540_13_) * f6);
/*  62 */       p_151540_14_ *= 0.7F;
/*  63 */       p_151540_14_ += f4 * 0.05F;
/*  64 */       p_151540_13_ += f3 * 0.05F;
/*  65 */       f4 *= 0.8F;
/*  66 */       f3 *= 0.5F;
/*  67 */       f4 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 2.0F;
/*  68 */       f3 += (random.nextFloat() - random.nextFloat()) * random.nextFloat() * 4.0F;
/*     */       
/*  70 */       if (flag1 || random.nextInt(4) != 0) {
/*     */         
/*  72 */         double d7 = p_151540_6_ - d4;
/*  73 */         double d8 = p_151540_10_ - d5;
/*  74 */         double d9 = (p_151540_16_ - p_151540_15_);
/*  75 */         double d10 = (p_151540_12_ + 2.0F + 16.0F);
/*     */         
/*  77 */         if (d7 * d7 + d8 * d8 - d9 * d9 > d10 * d10) {
/*     */           return;
/*     */         }
/*     */ 
/*     */         
/*  82 */         if (p_151540_6_ >= d4 - 16.0D - d12 * 2.0D && p_151540_10_ >= d5 - 16.0D - d12 * 2.0D && p_151540_6_ <= d4 + 16.0D + d12 * 2.0D && p_151540_10_ <= d5 + 16.0D + d12 * 2.0D) {
/*     */           
/*  84 */           int i4 = MathHelper.func_76128_c(p_151540_6_ - d12) - p_151540_3_ * 16 - 1;
/*  85 */           int l1 = MathHelper.func_76128_c(p_151540_6_ + d12) - p_151540_3_ * 16 + 1;
/*  86 */           int j4 = MathHelper.func_76128_c(p_151540_8_ - d6) - 1;
/*  87 */           int i2 = MathHelper.func_76128_c(p_151540_8_ + d6) + 1;
/*  88 */           int k4 = MathHelper.func_76128_c(p_151540_10_ - d12) - p_151540_4_ * 16 - 1;
/*  89 */           int j2 = MathHelper.func_76128_c(p_151540_10_ + d12) - p_151540_4_ * 16 + 1;
/*     */           
/*  91 */           if (i4 < 0)
/*     */           {
/*  93 */             i4 = 0;
/*     */           }
/*     */           
/*  96 */           if (l1 > 16)
/*     */           {
/*  98 */             l1 = 16;
/*     */           }
/*     */           
/* 101 */           if (j4 < 1)
/*     */           {
/* 103 */             j4 = 1;
/*     */           }
/*     */           
/* 106 */           if (i2 > 248)
/*     */           {
/* 108 */             i2 = 248;
/*     */           }
/*     */           
/* 111 */           if (k4 < 0)
/*     */           {
/* 113 */             k4 = 0;
/*     */           }
/*     */           
/* 116 */           if (j2 > 16)
/*     */           {
/* 118 */             j2 = 16;
/*     */           }
/*     */           
/* 121 */           boolean flag2 = false;
/*     */           
/*     */           int k2;
/*     */           
/* 125 */           for (k2 = i4; !flag2 && k2 < l1; k2++) {
/*     */             
/* 127 */             for (int l2 = k4; !flag2 && l2 < j2; l2++) {
/*     */               
/* 129 */               for (int i3 = i2 + 1; !flag2 && i3 >= j4 - 1; i3--) {
/*     */                 
/* 131 */                 int j3 = (k2 * 16 + l2) * 256 + i3;
/*     */                 
/* 133 */                 if (i3 >= 0 && i3 < 256) {
/*     */                   
/* 135 */                   Block block = p_151540_5_[j3];
/*     */                   
/* 137 */                   if (isOceanBlock(p_151540_5_, j3, k2, i3, l2, p_151540_3_, p_151540_4_))
/*     */                   {
/* 139 */                     flag2 = true;
/*     */                   }
/*     */                   
/* 142 */                   if (i3 != j4 - 1 && k2 != i4 && k2 != l1 - 1 && l2 != k4 && l2 != j2 - 1)
/*     */                   {
/* 144 */                     i3 = j4;
/*     */                   }
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/* 151 */           if (!flag2) {
/*     */             
/* 153 */             for (k2 = i4; k2 < l1; k2++) {
/*     */               
/* 155 */               double d13 = ((k2 + p_151540_3_ * 16) + 0.5D - p_151540_6_) / d12;
/*     */               
/* 157 */               for (int j3 = k4; j3 < j2; j3++) {
/*     */                 
/* 159 */                 double d14 = ((j3 + p_151540_4_ * 16) + 0.5D - p_151540_10_) / d12;
/* 160 */                 int k3 = (k2 * 16 + j3) * 256 + i2;
/* 161 */                 boolean flag = false;
/*     */                 
/* 163 */                 if (d13 * d13 + d14 * d14 < 1.0D)
/*     */                 {
/* 165 */                   for (int l3 = i2 - 1; l3 >= j4; l3--) {
/*     */                     
/* 167 */                     double d11 = (l3 + 0.5D - p_151540_8_) / d6;
/*     */                     
/* 169 */                     if ((d13 * d13 + d14 * d14) * this.field_75046_d[l3] + d11 * d11 / 6.0D < 1.0D) {
/*     */                       
/* 171 */                       Block block1 = p_151540_5_[k3];
/*     */                       
/* 173 */                       if (isTopBlock(p_151540_5_, k3, k2, l3, j3, p_151540_3_, p_151540_4_))
/*     */                       {
/* 175 */                         flag = true;
/*     */                       }
/*     */                       
/* 178 */                       digBlock(p_151540_5_, k3, k2, l3, j3, p_151540_3_, p_151540_4_, flag);
/*     */                     } 
/*     */                     
/* 181 */                     k3--;
/*     */                   } 
/*     */                 }
/*     */               } 
/*     */             } 
/*     */             
/* 187 */             if (flag1) {
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
/* 199 */     if (this.field_75038_b.nextInt(50) == 0) {
/*     */       
/* 201 */       double d0 = (p_151538_2_ * 16 + this.field_75038_b.nextInt(16));
/* 202 */       double d1 = (this.field_75038_b.nextInt(this.field_75038_b.nextInt(40) + 8) + 20);
/* 203 */       double d2 = (p_151538_3_ * 16 + this.field_75038_b.nextInt(16));
/* 204 */       byte b0 = 1;
/*     */       
/* 206 */       for (int i1 = 0; i1 < b0; i1++) {
/*     */         
/* 208 */         float f = this.field_75038_b.nextFloat() * 3.1415927F * 2.0F;
/* 209 */         float f1 = (this.field_75038_b.nextFloat() - 0.5F) * 2.0F / 8.0F;
/* 210 */         float f2 = (this.field_75038_b.nextFloat() * 2.0F + this.field_75038_b.nextFloat()) * 2.0F;
/* 211 */         func_151540_a(this.field_75038_b.nextLong(), p_151538_4_, p_151538_5_, p_151538_6_, d0, d1, d2, f2, f, f1, 0, 0, 3.0D);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isOceanBlock(Block[] data, int index, int x, int y, int z, int chunkX, int chunkZ) {
/* 218 */     return (data[index] == Blocks.field_150355_j || data[index] == Blocks.field_150358_i);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isExceptionBiome(BiomeGenBase biome) {
/* 224 */     if (biome == BiomeGenBase.field_76789_p) return true; 
/* 225 */     if (biome == BiomeGenBase.field_76787_r) return true; 
/* 226 */     if (biome == BiomeGenBase.field_76769_d) return true; 
/* 227 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isTopBlock(Block[] data, int index, int x, int y, int z, int chunkX, int chunkZ) {
/* 234 */     BiomeGenBase biome = this.field_75039_c.func_72807_a(x + chunkX * 16, z + chunkZ * 16);
/* 235 */     return isExceptionBiome(biome) ? ((data[index] == Blocks.field_150349_c)) : ((data[index] == biome.field_76752_A));
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
/* 255 */     BiomeGenBase biome = this.field_75039_c.func_72807_a(x + chunkX * 16, z + chunkZ * 16);
/* 256 */     Block top = isExceptionBiome(biome) ? (Block)Blocks.field_150349_c : biome.field_76752_A;
/* 257 */     Block filler = isExceptionBiome(biome) ? Blocks.field_150346_d : biome.field_76753_B;
/* 258 */     Block block = data[index];
/*     */     
/* 260 */     if (block == Blocks.field_150348_b || block == Blocks.field_150346_d || block == filler || block == top)
/*     */     {
/* 262 */       if (y < 10) {
/*     */         
/* 264 */         data[index] = (Block)Blocks.field_150356_k;
/*     */       }
/*     */       else {
/*     */         
/* 268 */         data[index] = null;
/*     */         
/* 270 */         if (foundTop && data[index - 1] == filler)
/*     */         {
/* 272 */           data[index - 1] = top;
/*     */         }
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\x1MapGenRavineOW.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */