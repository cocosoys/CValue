/*     */ package net.minecraft.world.biome;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Arrays;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.NoiseGeneratorPerlin;
/*     */ import net.minecraft.world.gen.feature.WorldGenAbstractTree;
/*     */ 
/*     */ 
/*     */ public class BiomeGenMesa
/*     */   extends BiomeGenBase
/*     */ {
/*     */   private byte[] field_150621_aC;
/*     */   private long field_150622_aD;
/*     */   private NoiseGeneratorPerlin field_150623_aE;
/*     */   private NoiseGeneratorPerlin field_150624_aF;
/*     */   
/*     */   public BiomeGenMesa(int p_i45380_1_, boolean p_i45380_2_, boolean p_i45380_3_) {
/*  24 */     super(p_i45380_1_);
/*  25 */     this.field_150626_aH = p_i45380_2_;
/*  26 */     this.field_150620_aI = p_i45380_3_;
/*     */     
/*  28 */     func_76745_m();
/*  29 */     func_76732_a(2.0F, 0.0F);
/*     */ 
/*     */     
/*  32 */     this.field_76762_K.clear();
/*  33 */     this.field_76752_A = (Block)Blocks.field_150354_m;
/*  34 */     this.field_150604_aj = 1;
/*  35 */     this.field_76753_B = Blocks.field_150406_ce;
/*     */     
/*  37 */     this.field_76760_I.field_76832_z = -999;
/*  38 */     this.field_76760_I.field_76804_C = 20;
/*  39 */     this.field_76760_I.field_76799_E = 3;
/*  40 */     this.field_76760_I.field_76800_F = 5;
/*  41 */     this.field_76760_I.field_76802_A = 0;
/*     */     
/*  43 */     this.field_76762_K.clear();
/*     */     
/*  45 */     if (p_i45380_3_)
/*  46 */       this.field_76760_I.field_76832_z = 5; 
/*     */   }
/*     */   private NoiseGeneratorPerlin field_150625_aG; private boolean field_150626_aH; private boolean field_150620_aI;
/*     */   private static final String __OBFID = "CL_00000176";
/*     */   
/*     */   public WorldGenAbstractTree func_150567_a(Random p_150567_1_) {
/*  52 */     return (WorldGenAbstractTree)this.field_76757_N;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_150571_c(int p_150571_1_, int p_150571_2_, int p_150571_3_) {
/*  57 */     return 10387789;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_150558_b(int p_150558_1_, int p_150558_2_, int p_150558_3_) {
/*  62 */     return 9470285;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_76728_a(World p_76728_1_, Random p_76728_2_, int p_76728_3_, int p_76728_4_) {
/*  67 */     super.func_76728_a(p_76728_1_, p_76728_2_, p_76728_3_, p_76728_4_);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_150573_a(World p_150573_1_, Random p_150573_2_, Block[] p_150573_3_, byte[] p_150573_4_, int p_150573_5_, int p_150573_6_, double p_150573_7_) {
/*  73 */     if (this.field_150621_aC == null || this.field_150622_aD != p_150573_1_.func_72905_C()) {
/*  74 */       func_150619_a(p_150573_1_.func_72905_C());
/*     */     }
/*  76 */     if (this.field_150623_aE == null || this.field_150624_aF == null || this.field_150622_aD != p_150573_1_.func_72905_C()) {
/*  77 */       Random random = new Random(this.field_150622_aD);
/*  78 */       this.field_150623_aE = new NoiseGeneratorPerlin(random, 4);
/*  79 */       this.field_150624_aF = new NoiseGeneratorPerlin(random, 1);
/*     */     } 
/*  81 */     this.field_150622_aD = p_150573_1_.func_72905_C();
/*     */ 
/*     */     
/*  84 */     double d = 0.0D;
/*  85 */     if (this.field_150626_aH) {
/*  86 */       int i1 = (p_150573_5_ & 0xFFFFFFF0) + (p_150573_6_ & 0xF);
/*  87 */       int i2 = (p_150573_6_ & 0xFFFFFFF0) + (p_150573_5_ & 0xF);
/*     */       
/*  89 */       double d1 = Math.min(Math.abs(p_150573_7_), this.field_150623_aE.func_151601_a(i1 * 0.25D, i2 * 0.25D));
/*  90 */       if (d1 > 0.0D) {
/*  91 */         double d2 = 0.001953125D;
/*  92 */         double d3 = Math.abs(this.field_150624_aF.func_151601_a(i1 * d2, i2 * d2));
/*  93 */         d = d1 * d1 * 2.5D;
/*  94 */         double d4 = Math.ceil(d3 * 50.0D) + 14.0D;
/*  95 */         if (d > d4) {
/*  96 */           d = d4;
/*     */         }
/*  98 */         d += 64.0D;
/*     */       } 
/*     */     } 
/*     */     
/* 102 */     int i = p_150573_5_ & 0xF;
/* 103 */     int j = p_150573_6_ & 0xF;
/*     */     
/* 105 */     byte b = 63;
/*     */     
/* 107 */     Block block1 = Blocks.field_150406_ce;
/* 108 */     Block block2 = this.field_76753_B;
/*     */     
/* 110 */     int k = (int)(p_150573_7_ / 3.0D + 3.0D + p_150573_2_.nextDouble() * 0.25D);
/* 111 */     boolean bool1 = (Math.cos(p_150573_7_ / 3.0D * Math.PI) > 0.0D) ? true : false;
/* 112 */     int m = -1;
/* 113 */     boolean bool2 = false;
/*     */     
/* 115 */     int n = p_150573_3_.length / 256;
/* 116 */     for (char c = 'ÿ'; c >= '\000'; c--) {
/* 117 */       int i1 = (j * 16 + i) * n + c;
/*     */       
/* 119 */       if ((p_150573_3_[i1] == null || p_150573_3_[i1].func_149688_o() == Material.field_151579_a) && c < (int)d) {
/* 120 */         p_150573_3_[i1] = Blocks.field_150348_b;
/*     */       }
/*     */       
/* 123 */       if (c <= 0 + p_150573_2_.nextInt(5)) {
/* 124 */         p_150573_3_[i1] = Blocks.field_150357_h;
/*     */       } else {
/* 126 */         Block block = p_150573_3_[i1];
/*     */         
/* 128 */         if (block == null || block.func_149688_o() == Material.field_151579_a) {
/* 129 */           m = -1;
/* 130 */         } else if (block == Blocks.field_150348_b) {
/* 131 */           if (m == -1) {
/* 132 */             bool2 = false;
/* 133 */             if (k <= 0) {
/* 134 */               block1 = null;
/* 135 */               block2 = Blocks.field_150348_b;
/* 136 */             } else if (c >= ';' && c <= '@') {
/* 137 */               block1 = Blocks.field_150406_ce;
/* 138 */               block2 = this.field_76753_B;
/*     */             } 
/*     */             
/* 141 */             if (c < '?' && (block1 == null || block1.func_149688_o() == Material.field_151579_a)) {
/* 142 */               block1 = Blocks.field_150355_j;
/*     */             }
/*     */             
/* 145 */             m = k + Math.max(0, c - 63);
/* 146 */             if (c >= '>') {
/* 147 */               if (this.field_150620_aI && c > 86 + k * 2) {
/* 148 */                 if (bool1) {
/* 149 */                   p_150573_3_[i1] = Blocks.field_150346_d;
/* 150 */                   p_150573_4_[i1] = 1;
/*     */                 } else {
/* 152 */                   p_150573_3_[i1] = (Block)Blocks.field_150349_c;
/*     */                 } 
/* 154 */               } else if (c > 66 + k) {
/* 155 */                 byte b1 = 16;
/* 156 */                 if (c < '@' || c > '') {
/* 157 */                   b1 = 1;
/* 158 */                 } else if (!bool1) {
/*     */                   
/* 160 */                   b1 = func_150618_d(p_150573_5_, c, p_150573_6_);
/*     */                 } 
/* 162 */                 if (b1 < 16) {
/* 163 */                   p_150573_3_[i1] = Blocks.field_150406_ce;
/* 164 */                   p_150573_4_[i1] = (byte)b1;
/*     */                 } else {
/* 166 */                   p_150573_3_[i1] = Blocks.field_150405_ch;
/*     */                 } 
/*     */               } else {
/* 169 */                 p_150573_3_[i1] = this.field_76752_A;
/* 170 */                 p_150573_4_[i1] = (byte)this.field_150604_aj;
/* 171 */                 bool2 = true;
/*     */               } 
/*     */             } else {
/* 174 */               p_150573_3_[i1] = block2;
/* 175 */               if (block2 == Blocks.field_150406_ce) {
/* 176 */                 p_150573_4_[i1] = 1;
/*     */               }
/*     */             } 
/* 179 */           } else if (m > 0) {
/* 180 */             m--;
/*     */             
/* 182 */             if (bool2) {
/* 183 */               p_150573_3_[i1] = Blocks.field_150406_ce;
/* 184 */               p_150573_4_[i1] = 1;
/*     */             } else {
/* 186 */               byte b1 = func_150618_d(p_150573_5_, c, p_150573_6_);
/* 187 */               if (b1 < 16) {
/* 188 */                 p_150573_3_[i1] = Blocks.field_150406_ce;
/* 189 */                 p_150573_4_[i1] = b1;
/*     */               } else {
/* 191 */                 p_150573_3_[i1] = Blocks.field_150405_ch;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void func_150619_a(long p_150619_1_) {
/* 201 */     this.field_150621_aC = new byte[64];
/* 202 */     Arrays.fill(this.field_150621_aC, (byte)16);
/*     */     
/* 204 */     Random random = new Random(p_150619_1_);
/* 205 */     this.field_150625_aG = new NoiseGeneratorPerlin(random, 1);
/*     */     int i;
/* 207 */     for (i = 0; i < 64; i++) {
/* 208 */       i += random.nextInt(5) + 1;
/* 209 */       if (i < 64) {
/* 210 */         this.field_150621_aC[i] = 1;
/*     */       }
/*     */     } 
/*     */     
/* 214 */     i = random.nextInt(4) + 2; int j;
/* 215 */     for (j = 0; j < i; j++) {
/* 216 */       int i1 = random.nextInt(3) + 1;
/* 217 */       int i2 = random.nextInt(64);
/*     */       
/* 219 */       for (byte b1 = 0; i2 + b1 < 64 && b1 < i1; b1++) {
/* 220 */         this.field_150621_aC[i2 + b1] = 4;
/*     */       }
/*     */     } 
/* 223 */     j = random.nextInt(4) + 2; int k;
/* 224 */     for (k = 0; k < j; k++) {
/* 225 */       int i1 = random.nextInt(3) + 2;
/* 226 */       int i2 = random.nextInt(64);
/*     */       
/* 228 */       for (byte b1 = 0; i2 + b1 < 64 && b1 < i1; b1++) {
/* 229 */         this.field_150621_aC[i2 + b1] = 12;
/*     */       }
/*     */     } 
/* 232 */     k = random.nextInt(4) + 2; int m;
/* 233 */     for (m = 0; m < k; m++) {
/* 234 */       int i1 = random.nextInt(3) + 1;
/* 235 */       int i2 = random.nextInt(64);
/*     */       
/* 237 */       for (byte b1 = 0; i2 + b1 < 64 && b1 < i1; b1++) {
/* 238 */         this.field_150621_aC[i2 + b1] = 14;
/*     */       }
/*     */     } 
/* 241 */     m = random.nextInt(3) + 3;
/* 242 */     int n = 0;
/* 243 */     for (byte b = 0; b < m; b++) {
/* 244 */       byte b1 = 1;
/* 245 */       n += random.nextInt(16) + 4;
/*     */       
/* 247 */       for (byte b2 = 0; n + b2 < 64 && b2 < b1; b2++) {
/* 248 */         this.field_150621_aC[n + b2] = 0;
/* 249 */         if (n + b2 > 1 && random.nextBoolean()) {
/* 250 */           this.field_150621_aC[n + b2 - 1] = 8;
/*     */         }
/* 252 */         if (n + b2 < 63 && random.nextBoolean()) {
/* 253 */           this.field_150621_aC[n + b2 + 1] = 8;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public byte func_150618_d(int p_150618_1_, int p_150618_2_, int p_150618_3_) {
/* 260 */     int i = (int)Math.round(this.field_150625_aG.func_151601_a(p_150618_1_ * 1.0D / 512.0D, p_150618_1_ * 1.0D / 512.0D) * 2.0D);
/* 261 */     return this.field_150621_aC[(p_150618_2_ + i + 64) % 64];
/*     */   }
/*     */ 
/*     */   
/*     */   public BiomeGenBase func_150566_k() {
/* 266 */     boolean bool = (this.field_76756_M == BiomeGenBase.field_150589_Z.field_76756_M) ? true : false;
/*     */     
/* 268 */     BiomeGenMesa biomeGenMesa = new BiomeGenMesa(this.field_76756_M + 128, bool, this.field_150620_aI);
/*     */     
/* 270 */     if (!bool) {
/* 271 */       biomeGenMesa.func_150570_a(field_150591_g);
/* 272 */       biomeGenMesa.func_76735_a(this.field_76791_y + " M");
/*     */     } else {
/* 274 */       biomeGenMesa.func_76735_a(this.field_76791_y + " (Bryce)");
/*     */     } 
/* 276 */     biomeGenMesa.func_150557_a(this.field_76790_z, true);
/*     */     
/* 278 */     return biomeGenMesa;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\BiomeGenMesa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */