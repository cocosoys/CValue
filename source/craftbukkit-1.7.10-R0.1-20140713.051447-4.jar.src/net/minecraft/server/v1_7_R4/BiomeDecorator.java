/*     */ package net.minecraft.server.v1_7_R4;
/*     */ 
/*     */ import java.util.Random;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class BiomeDecorator
/*     */ {
/*     */   protected World a;
/*     */   protected Random b;
/*     */   protected int c;
/*     */   protected int d;
/*     */   
/*     */   public void a(World paramWorld, Random paramRandom, BiomeBase paramBiomeBase, int paramInt1, int paramInt2) {
/*  21 */     if (this.a != null) throw new RuntimeException("Already decorating!!"); 
/*  22 */     this.a = paramWorld;
/*  23 */     this.b = paramRandom;
/*  24 */     this.c = paramInt1;
/*  25 */     this.d = paramInt2;
/*     */     
/*  27 */     a(paramBiomeBase);
/*     */     
/*  29 */     this.a = null;
/*  30 */     this.b = null;
/*     */   }
/*     */   
/*  33 */   protected WorldGenerator e = new WorldGenClay(4);
/*  34 */   protected WorldGenerator f = new WorldGenSand(Blocks.SAND, 7);
/*  35 */   protected WorldGenerator g = new WorldGenSand(Blocks.GRAVEL, 6);
/*  36 */   protected WorldGenerator h = new WorldGenMinable(Blocks.DIRT, 32);
/*  37 */   protected WorldGenerator i = new WorldGenMinable(Blocks.GRAVEL, 32);
/*  38 */   protected WorldGenerator j = new WorldGenMinable(Blocks.COAL_ORE, 16);
/*  39 */   protected WorldGenerator k = new WorldGenMinable(Blocks.IRON_ORE, 8);
/*  40 */   protected WorldGenerator l = new WorldGenMinable(Blocks.GOLD_ORE, 8);
/*  41 */   protected WorldGenerator m = new WorldGenMinable(Blocks.REDSTONE_ORE, 7);
/*  42 */   protected WorldGenerator n = new WorldGenMinable(Blocks.DIAMOND_ORE, 7);
/*  43 */   protected WorldGenerator o = new WorldGenMinable(Blocks.LAPIS_ORE, 6);
/*  44 */   protected WorldGenFlowers p = new WorldGenFlowers(Blocks.YELLOW_FLOWER);
/*  45 */   protected WorldGenerator q = new WorldGenFlowers(Blocks.BROWN_MUSHROOM);
/*  46 */   protected WorldGenerator r = new WorldGenFlowers(Blocks.RED_MUSHROOM);
/*  47 */   protected WorldGenerator s = new WorldGenHugeMushroom();
/*  48 */   protected WorldGenerator t = new WorldGenReed();
/*  49 */   protected WorldGenerator u = new WorldGenCactus();
/*  50 */   protected WorldGenerator v = new WorldGenWaterLily();
/*     */   
/*     */   protected int w;
/*     */   protected int x;
/*  54 */   protected int y = 2;
/*  55 */   protected int z = 1;
/*     */   protected int A;
/*     */   protected int B;
/*     */   protected int C;
/*     */   protected int D;
/*  60 */   protected int E = 1;
/*  61 */   protected int F = 3;
/*  62 */   protected int G = 1;
/*     */   protected int H;
/*     */   public boolean I = true;
/*     */   
/*     */   protected void a(BiomeBase paramBiomeBase) {
/*  67 */     a();
/*     */     int i;
/*  69 */     for (i = 0; i < this.F; i++) {
/*  70 */       int k = this.c + this.b.nextInt(16) + 8;
/*  71 */       int m = this.d + this.b.nextInt(16) + 8;
/*  72 */       this.f.generate(this.a, this.b, k, this.a.i(k, m), m);
/*     */     } 
/*     */     
/*  75 */     for (i = 0; i < this.G; i++) {
/*  76 */       int k = this.c + this.b.nextInt(16) + 8;
/*  77 */       int m = this.d + this.b.nextInt(16) + 8;
/*  78 */       this.e.generate(this.a, this.b, k, this.a.i(k, m), m);
/*     */     } 
/*     */     
/*  81 */     for (i = 0; i < this.E; i++) {
/*  82 */       int k = this.c + this.b.nextInt(16) + 8;
/*  83 */       int m = this.d + this.b.nextInt(16) + 8;
/*  84 */       this.g.generate(this.a, this.b, k, this.a.i(k, m), m);
/*     */     } 
/*     */     
/*  87 */     i = this.x;
/*  88 */     if (this.b.nextInt(10) == 0) i++; 
/*     */     int j;
/*  90 */     for (j = 0; j < i; j++) {
/*  91 */       int k = this.c + this.b.nextInt(16) + 8;
/*  92 */       int m = this.d + this.b.nextInt(16) + 8;
/*  93 */       int n = this.a.getHighestBlockYAt(k, m);
/*  94 */       WorldGenTreeAbstract worldGenTreeAbstract = paramBiomeBase.a(this.b);
/*  95 */       worldGenTreeAbstract.a(1.0D, 1.0D, 1.0D);
/*  96 */       if (worldGenTreeAbstract.generate(this.a, this.b, k, n, m)) {
/*  97 */         worldGenTreeAbstract.b(this.a, this.b, k, n, m);
/*     */       }
/*     */     } 
/*     */     
/* 101 */     for (j = 0; j < this.H; j++) {
/* 102 */       int k = this.c + this.b.nextInt(16) + 8;
/* 103 */       int m = this.d + this.b.nextInt(16) + 8;
/* 104 */       this.s.generate(this.a, this.b, k, this.a.getHighestBlockYAt(k, m), m);
/*     */     } 
/*     */     
/* 107 */     for (j = 0; j < this.y; j++) {
/* 108 */       int k = this.c + this.b.nextInt(16) + 8;
/* 109 */       int m = this.d + this.b.nextInt(16) + 8;
/* 110 */       int n = this.b.nextInt(this.a.getHighestBlockYAt(k, m) + 32);
/* 111 */       String str = paramBiomeBase.a(this.b, k, n, m);
/* 112 */       BlockFlowers blockFlowers = BlockFlowers.e(str);
/* 113 */       if (blockFlowers.getMaterial() != Material.AIR) {
/* 114 */         this.p.a(blockFlowers, BlockFlowers.f(str));
/* 115 */         this.p.generate(this.a, this.b, k, n, m);
/*     */       } 
/*     */     } 
/*     */     
/* 119 */     for (j = 0; j < this.z; j++) {
/* 120 */       int k = this.c + this.b.nextInt(16) + 8;
/* 121 */       int m = this.d + this.b.nextInt(16) + 8;
/* 122 */       int n = this.b.nextInt(this.a.getHighestBlockYAt(k, m) * 2);
/* 123 */       WorldGenerator worldGenerator = paramBiomeBase.b(this.b);
/* 124 */       worldGenerator.generate(this.a, this.b, k, n, m);
/*     */     } 
/*     */     
/* 127 */     for (j = 0; j < this.A; j++) {
/* 128 */       int k = this.c + this.b.nextInt(16) + 8;
/* 129 */       int m = this.d + this.b.nextInt(16) + 8;
/* 130 */       int n = this.b.nextInt(this.a.getHighestBlockYAt(k, m) * 2);
/* 131 */       (new WorldGenDeadBush(Blocks.DEAD_BUSH)).generate(this.a, this.b, k, n, m);
/*     */     } 
/*     */     
/* 134 */     for (j = 0; j < this.w; j++) {
/* 135 */       int k = this.c + this.b.nextInt(16) + 8;
/* 136 */       int m = this.d + this.b.nextInt(16) + 8;
/* 137 */       int n = this.b.nextInt(this.a.getHighestBlockYAt(k, m) * 2);
/* 138 */       while (n > 0 && this.a.isEmpty(k, n - 1, m))
/* 139 */         n--; 
/* 140 */       this.v.generate(this.a, this.b, k, n, m);
/*     */     } 
/*     */     
/* 143 */     for (j = 0; j < this.B; j++) {
/* 144 */       if (this.b.nextInt(4) == 0) {
/* 145 */         int k = this.c + this.b.nextInt(16) + 8;
/* 146 */         int m = this.d + this.b.nextInt(16) + 8;
/* 147 */         int n = this.a.getHighestBlockYAt(k, m);
/* 148 */         this.q.generate(this.a, this.b, k, n, m);
/*     */       } 
/*     */       
/* 151 */       if (this.b.nextInt(8) == 0) {
/* 152 */         int k = this.c + this.b.nextInt(16) + 8;
/* 153 */         int m = this.d + this.b.nextInt(16) + 8;
/* 154 */         int n = this.b.nextInt(this.a.getHighestBlockYAt(k, m) * 2);
/* 155 */         this.r.generate(this.a, this.b, k, n, m);
/*     */       } 
/*     */     } 
/*     */     
/* 159 */     if (this.b.nextInt(4) == 0) {
/* 160 */       j = this.c + this.b.nextInt(16) + 8;
/* 161 */       int k = this.d + this.b.nextInt(16) + 8;
/* 162 */       int m = this.b.nextInt(this.a.getHighestBlockYAt(j, k) * 2);
/* 163 */       this.q.generate(this.a, this.b, j, m, k);
/*     */     } 
/*     */     
/* 166 */     if (this.b.nextInt(8) == 0) {
/* 167 */       j = this.c + this.b.nextInt(16) + 8;
/* 168 */       int k = this.d + this.b.nextInt(16) + 8;
/* 169 */       int m = this.b.nextInt(this.a.getHighestBlockYAt(j, k) * 2);
/* 170 */       this.r.generate(this.a, this.b, j, m, k);
/*     */     } 
/*     */     
/* 173 */     for (j = 0; j < this.C; j++) {
/* 174 */       int k = this.c + this.b.nextInt(16) + 8;
/* 175 */       int m = this.d + this.b.nextInt(16) + 8;
/* 176 */       int n = this.b.nextInt(this.a.getHighestBlockYAt(k, m) * 2);
/* 177 */       this.t.generate(this.a, this.b, k, n, m);
/*     */     } 
/*     */     
/* 180 */     for (j = 0; j < 10; j++) {
/* 181 */       int k = this.c + this.b.nextInt(16) + 8;
/* 182 */       int m = this.d + this.b.nextInt(16) + 8;
/* 183 */       int n = this.b.nextInt(this.a.getHighestBlockYAt(k, m) * 2);
/* 184 */       this.t.generate(this.a, this.b, k, n, m);
/*     */     } 
/*     */     
/* 187 */     if (this.b.nextInt(32) == 0) {
/* 188 */       j = this.c + this.b.nextInt(16) + 8;
/* 189 */       int k = this.d + this.b.nextInt(16) + 8;
/* 190 */       int m = this.b.nextInt(this.a.getHighestBlockYAt(j, k) * 2);
/* 191 */       (new WorldGenPumpkin()).generate(this.a, this.b, j, m, k);
/*     */     } 
/*     */     
/* 194 */     for (j = 0; j < this.D; j++) {
/* 195 */       int k = this.c + this.b.nextInt(16) + 8;
/* 196 */       int m = this.d + this.b.nextInt(16) + 8;
/* 197 */       int n = this.b.nextInt(this.a.getHighestBlockYAt(k, m) * 2);
/* 198 */       this.u.generate(this.a, this.b, k, n, m);
/*     */     } 
/*     */     
/* 201 */     if (this.I) {
/* 202 */       for (j = 0; j < 50; j++) {
/* 203 */         int k = this.c + this.b.nextInt(16) + 8;
/* 204 */         int m = this.b.nextInt(this.b.nextInt(248) + 8);
/* 205 */         int n = this.d + this.b.nextInt(16) + 8;
/* 206 */         (new WorldGenLiquids(Blocks.WATER)).generate(this.a, this.b, k, m, n);
/*     */       } 
/*     */       
/* 209 */       for (j = 0; j < 20; j++) {
/* 210 */         int k = this.c + this.b.nextInt(16) + 8;
/* 211 */         int m = this.b.nextInt(this.b.nextInt(this.b.nextInt(240) + 8) + 8);
/* 212 */         int n = this.d + this.b.nextInt(16) + 8;
/* 213 */         (new WorldGenLiquids(Blocks.LAVA)).generate(this.a, this.b, k, m, n);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void a(int paramInt1, WorldGenerator paramWorldGenerator, int paramInt2, int paramInt3) {
/* 223 */     for (byte b = 0; b < paramInt1; b++) {
/* 224 */       int i = this.c + this.b.nextInt(16);
/* 225 */       int j = this.b.nextInt(paramInt3 - paramInt2) + paramInt2;
/* 226 */       int k = this.d + this.b.nextInt(16);
/* 227 */       paramWorldGenerator.generate(this.a, this.b, i, j, k);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void b(int paramInt1, WorldGenerator paramWorldGenerator, int paramInt2, int paramInt3) {
/* 232 */     for (byte b = 0; b < paramInt1; b++) {
/* 233 */       int i = this.c + this.b.nextInt(16);
/* 234 */       int j = this.b.nextInt(paramInt3) + this.b.nextInt(paramInt3) + paramInt2 - paramInt3;
/* 235 */       int k = this.d + this.b.nextInt(16);
/* 236 */       paramWorldGenerator.generate(this.a, this.b, i, j, k);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void a() {
/* 241 */     a(20, this.h, 0, 256);
/* 242 */     a(10, this.i, 0, 256);
/* 243 */     a(20, this.j, 0, 128);
/* 244 */     a(20, this.k, 0, 64);
/* 245 */     a(2, this.l, 0, 32);
/* 246 */     a(8, this.m, 0, 16);
/* 247 */     a(1, this.n, 0, 16);
/* 248 */     b(1, this.o, 16, 16);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\BiomeDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */