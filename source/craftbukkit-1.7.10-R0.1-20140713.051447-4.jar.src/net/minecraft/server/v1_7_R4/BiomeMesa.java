/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.Arrays;
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BiomeMesa
/*     */   extends BiomeBase
/*     */ {
/*     */   private byte[] aC;
/*     */   private long aD;
/*     */   private NoiseGenerator3 aE;
/*     */   private NoiseGenerator3 aF;
/*     */   private NoiseGenerator3 aG;
/*     */   private boolean aH;
/*     */   private boolean aI;
/*     */   
/*     */   public BiomeMesa(int paramInt, boolean paramBoolean1, boolean paramBoolean2) {
/*  24 */     super(paramInt);
/*  25 */     this.aH = paramBoolean1;
/*  26 */     this.aI = paramBoolean2;
/*     */     
/*  28 */     b();
/*  29 */     a(2.0F, 0.0F);
/*     */ 
/*     */     
/*  32 */     this.at.clear();
/*  33 */     this.ai = Blocks.SAND;
/*  34 */     this.aj = 1;
/*  35 */     this.ak = Blocks.STAINED_HARDENED_CLAY;
/*     */     
/*  37 */     this.ar.x = -999;
/*  38 */     this.ar.A = 20;
/*  39 */     this.ar.C = 3;
/*  40 */     this.ar.D = 5;
/*  41 */     this.ar.y = 0;
/*     */     
/*  43 */     this.at.clear();
/*     */     
/*  45 */     if (paramBoolean2) {
/*  46 */       this.ar.x = 5;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public WorldGenTreeAbstract a(Random paramRandom) {
/*  52 */     return this.az;
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
/*     */   public void a(World paramWorld, Random paramRandom, int paramInt1, int paramInt2) {
/*  67 */     super.a(paramWorld, paramRandom, paramInt1, paramInt2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void a(World paramWorld, Random paramRandom, Block[] paramArrayOfBlock, byte[] paramArrayOfbyte, int paramInt1, int paramInt2, double paramDouble) {
/*  73 */     if (this.aC == null || this.aD != paramWorld.getSeed()) {
/*  74 */       a(paramWorld.getSeed());
/*     */     }
/*  76 */     if (this.aE == null || this.aF == null || this.aD != paramWorld.getSeed()) {
/*  77 */       Random random = new Random(this.aD);
/*  78 */       this.aE = new NoiseGenerator3(random, 4);
/*  79 */       this.aF = new NoiseGenerator3(random, 1);
/*     */     } 
/*  81 */     this.aD = paramWorld.getSeed();
/*     */ 
/*     */     
/*  84 */     double d = 0.0D;
/*  85 */     if (this.aH) {
/*  86 */       int i1 = (paramInt1 & 0xFFFFFFF0) + (paramInt2 & 0xF);
/*  87 */       int i2 = (paramInt2 & 0xFFFFFFF0) + (paramInt1 & 0xF);
/*     */       
/*  89 */       double d1 = Math.min(Math.abs(paramDouble), this.aE.a(i1 * 0.25D, i2 * 0.25D));
/*  90 */       if (d1 > 0.0D) {
/*  91 */         double d2 = 0.001953125D;
/*  92 */         double d3 = Math.abs(this.aF.a(i1 * d2, i2 * d2));
/*  93 */         d = d1 * d1 * 2.5D;
/*  94 */         double d4 = Math.ceil(d3 * 50.0D) + 14.0D;
/*  95 */         if (d > d4) {
/*  96 */           d = d4;
/*     */         }
/*  98 */         d += 64.0D;
/*     */       } 
/*     */     } 
/*     */     
/* 102 */     int i = paramInt1 & 0xF;
/* 103 */     int j = paramInt2 & 0xF;
/*     */     
/* 105 */     byte b = 63;
/*     */     
/* 107 */     Block block1 = Blocks.STAINED_HARDENED_CLAY;
/* 108 */     Block block2 = this.ak;
/*     */     
/* 110 */     int k = (int)(paramDouble / 3.0D + 3.0D + paramRandom.nextDouble() * 0.25D);
/* 111 */     boolean bool1 = (Math.cos(paramDouble / 3.0D * Math.PI) > 0.0D) ? true : false;
/* 112 */     int m = -1;
/* 113 */     boolean bool2 = false;
/*     */     
/* 115 */     int n = paramArrayOfBlock.length / 256;
/* 116 */     for (char c = 'ÿ'; c >= '\000'; c--) {
/* 117 */       int i1 = (j * 16 + i) * n + c;
/*     */       
/* 119 */       if ((paramArrayOfBlock[i1] == null || paramArrayOfBlock[i1].getMaterial() == Material.AIR) && c < (int)d) {
/* 120 */         paramArrayOfBlock[i1] = Blocks.STONE;
/*     */       }
/*     */       
/* 123 */       if (c <= 0 + paramRandom.nextInt(5)) {
/* 124 */         paramArrayOfBlock[i1] = Blocks.BEDROCK;
/*     */       } else {
/* 126 */         Block block = paramArrayOfBlock[i1];
/*     */         
/* 128 */         if (block == null || block.getMaterial() == Material.AIR) {
/* 129 */           m = -1;
/* 130 */         } else if (block == Blocks.STONE) {
/* 131 */           if (m == -1) {
/* 132 */             bool2 = false;
/* 133 */             if (k <= 0) {
/* 134 */               block1 = null;
/* 135 */               block2 = Blocks.STONE;
/* 136 */             } else if (c >= ';' && c <= '@') {
/* 137 */               block1 = Blocks.STAINED_HARDENED_CLAY;
/* 138 */               block2 = this.ak;
/*     */             } 
/*     */             
/* 141 */             if (c < '?' && (block1 == null || block1.getMaterial() == Material.AIR)) {
/* 142 */               block1 = Blocks.STATIONARY_WATER;
/*     */             }
/*     */             
/* 145 */             m = k + Math.max(0, c - 63);
/* 146 */             if (c >= '>') {
/* 147 */               if (this.aI && c > 86 + k * 2) {
/* 148 */                 if (bool1) {
/* 149 */                   paramArrayOfBlock[i1] = Blocks.DIRT;
/* 150 */                   paramArrayOfbyte[i1] = 1;
/*     */                 } else {
/* 152 */                   paramArrayOfBlock[i1] = Blocks.GRASS;
/*     */                 } 
/* 154 */               } else if (c > 66 + k) {
/* 155 */                 byte b1 = 16;
/* 156 */                 if (c < '@' || c > '') {
/* 157 */                   b1 = 1;
/* 158 */                 } else if (!bool1) {
/*     */                   
/* 160 */                   b1 = d(paramInt1, c, paramInt2);
/*     */                 } 
/* 162 */                 if (b1 < 16) {
/* 163 */                   paramArrayOfBlock[i1] = Blocks.STAINED_HARDENED_CLAY;
/* 164 */                   paramArrayOfbyte[i1] = (byte)b1;
/*     */                 } else {
/* 166 */                   paramArrayOfBlock[i1] = Blocks.HARDENED_CLAY;
/*     */                 } 
/*     */               } else {
/* 169 */                 paramArrayOfBlock[i1] = this.ai;
/* 170 */                 paramArrayOfbyte[i1] = (byte)this.aj;
/* 171 */                 bool2 = true;
/*     */               } 
/*     */             } else {
/* 174 */               paramArrayOfBlock[i1] = block2;
/* 175 */               if (block2 == Blocks.STAINED_HARDENED_CLAY) {
/* 176 */                 paramArrayOfbyte[i1] = 1;
/*     */               }
/*     */             } 
/* 179 */           } else if (m > 0) {
/* 180 */             m--;
/*     */             
/* 182 */             if (bool2) {
/* 183 */               paramArrayOfBlock[i1] = Blocks.STAINED_HARDENED_CLAY;
/* 184 */               paramArrayOfbyte[i1] = 1;
/*     */             } else {
/* 186 */               byte b1 = d(paramInt1, c, paramInt2);
/* 187 */               if (b1 < 16) {
/* 188 */                 paramArrayOfBlock[i1] = Blocks.STAINED_HARDENED_CLAY;
/* 189 */                 paramArrayOfbyte[i1] = b1;
/*     */               } else {
/* 191 */                 paramArrayOfBlock[i1] = Blocks.HARDENED_CLAY;
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private void a(long paramLong) {
/* 201 */     this.aC = new byte[64];
/* 202 */     Arrays.fill(this.aC, (byte)16);
/*     */     
/* 204 */     Random random = new Random(paramLong);
/* 205 */     this.aG = new NoiseGenerator3(random, 1);
/*     */     int i;
/* 207 */     for (i = 0; i < 64; i++) {
/* 208 */       i += random.nextInt(5) + 1;
/* 209 */       if (i < 64) {
/* 210 */         this.aC[i] = 1;
/*     */       }
/*     */     } 
/*     */     
/* 214 */     i = random.nextInt(4) + 2; int j;
/* 215 */     for (j = 0; j < i; j++) {
/* 216 */       int i1 = random.nextInt(3) + 1;
/* 217 */       int i2 = random.nextInt(64);
/*     */       
/* 219 */       for (byte b1 = 0; i2 + b1 < 64 && b1 < i1; b1++) {
/* 220 */         this.aC[i2 + b1] = 4;
/*     */       }
/*     */     } 
/* 223 */     j = random.nextInt(4) + 2; int k;
/* 224 */     for (k = 0; k < j; k++) {
/* 225 */       int i1 = random.nextInt(3) + 2;
/* 226 */       int i2 = random.nextInt(64);
/*     */       
/* 228 */       for (byte b1 = 0; i2 + b1 < 64 && b1 < i1; b1++) {
/* 229 */         this.aC[i2 + b1] = 12;
/*     */       }
/*     */     } 
/* 232 */     k = random.nextInt(4) + 2; int m;
/* 233 */     for (m = 0; m < k; m++) {
/* 234 */       int i1 = random.nextInt(3) + 1;
/* 235 */       int i2 = random.nextInt(64);
/*     */       
/* 237 */       for (byte b1 = 0; i2 + b1 < 64 && b1 < i1; b1++) {
/* 238 */         this.aC[i2 + b1] = 14;
/*     */       }
/*     */     } 
/* 241 */     m = random.nextInt(3) + 3;
/* 242 */     int n = 0;
/* 243 */     for (byte b = 0; b < m; b++) {
/* 244 */       byte b1 = 1;
/* 245 */       n += random.nextInt(16) + 4;
/*     */       
/* 247 */       for (byte b2 = 0; n + b2 < 64 && b2 < b1; b2++) {
/* 248 */         this.aC[n + b2] = 0;
/* 249 */         if (n + b2 > 1 && random.nextBoolean()) {
/* 250 */           this.aC[n + b2 - 1] = 8;
/*     */         }
/* 252 */         if (n + b2 < 63 && random.nextBoolean()) {
/* 253 */           this.aC[n + b2 + 1] = 8;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   private byte d(int paramInt1, int paramInt2, int paramInt3) {
/* 260 */     int i = (int)Math.round(this.aG.a(paramInt1 * 1.0D / 512.0D, paramInt1 * 1.0D / 512.0D) * 2.0D);
/* 261 */     return this.aC[(paramInt2 + i + 64) % 64];
/*     */   }
/*     */ 
/*     */   
/*     */   protected BiomeBase k() {
/* 266 */     boolean bool = (this.id == BiomeBase.MESA.id) ? true : false;
/*     */     
/* 268 */     BiomeMesa biomeMesa = new BiomeMesa(this.id + 128, bool, this.aI);
/*     */     
/* 270 */     if (!bool) {
/* 271 */       biomeMesa.a(g);
/* 272 */       biomeMesa.a(this.af + " M");
/*     */     } else {
/* 274 */       biomeMesa.a(this.af + " (Bryce)");
/*     */     } 
/* 276 */     biomeMesa.a(this.ag, true);
/*     */     
/* 278 */     return biomeMesa;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BiomeMesa.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */