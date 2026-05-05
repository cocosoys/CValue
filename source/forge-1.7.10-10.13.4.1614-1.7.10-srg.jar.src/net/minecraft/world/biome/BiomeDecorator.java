/*     */ package net.minecraft.world.biome;
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.BlockFlower;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraft.world.gen.feature.WorldGenAbstractTree;
/*     */ import net.minecraft.world.gen.feature.WorldGenCactus;
/*     */ import net.minecraft.world.gen.feature.WorldGenDeadBush;
/*     */ import net.minecraft.world.gen.feature.WorldGenFlowers;
/*     */ import net.minecraft.world.gen.feature.WorldGenLiquids;
/*     */ import net.minecraft.world.gen.feature.WorldGenMinable;
/*     */ import net.minecraft.world.gen.feature.WorldGenSand;
/*     */ import net.minecraft.world.gen.feature.WorldGenerator;
/*     */ 
/*     */ public class BiomeDecorator {
/*     */   public World field_76815_a;
/*     */   public Random field_76813_b;
/*     */   
/*     */   public void func_150512_a(World p_150512_1_, Random p_150512_2_, BiomeGenBase p_150512_3_, int p_150512_4_, int p_150512_5_) {
/*  21 */     if (this.field_76815_a != null) throw new RuntimeException("Already decorating!!"); 
/*  22 */     this.field_76815_a = p_150512_1_;
/*  23 */     this.field_76813_b = p_150512_2_;
/*  24 */     this.field_76814_c = p_150512_4_;
/*  25 */     this.field_76811_d = p_150512_5_;
/*     */     
/*  27 */     func_150513_a(p_150512_3_);
/*     */     
/*  29 */     this.field_76815_a = null;
/*  30 */     this.field_76813_b = null;
/*     */   }
/*     */   public int field_76814_c; public int field_76811_d;
/*  33 */   public WorldGenerator field_76809_f = (WorldGenerator)new WorldGenClay(4);
/*  34 */   public WorldGenerator field_76810_g = (WorldGenerator)new WorldGenSand((Block)Blocks.field_150354_m, 7);
/*  35 */   public WorldGenerator field_76822_h = (WorldGenerator)new WorldGenSand(Blocks.field_150351_n, 6);
/*  36 */   public WorldGenerator field_76823_i = (WorldGenerator)new WorldGenMinable(Blocks.field_150346_d, 32);
/*  37 */   public WorldGenerator field_76820_j = (WorldGenerator)new WorldGenMinable(Blocks.field_150351_n, 32);
/*  38 */   public WorldGenerator field_76821_k = (WorldGenerator)new WorldGenMinable(Blocks.field_150365_q, 16);
/*  39 */   public WorldGenerator field_76818_l = (WorldGenerator)new WorldGenMinable(Blocks.field_150366_p, 8);
/*  40 */   public WorldGenerator field_76819_m = (WorldGenerator)new WorldGenMinable(Blocks.field_150352_o, 8);
/*  41 */   public WorldGenerator field_76816_n = (WorldGenerator)new WorldGenMinable(Blocks.field_150450_ax, 7);
/*  42 */   public WorldGenerator field_76817_o = (WorldGenerator)new WorldGenMinable(Blocks.field_150482_ag, 7);
/*  43 */   public WorldGenerator field_76831_p = (WorldGenerator)new WorldGenMinable(Blocks.field_150369_x, 6);
/*  44 */   public WorldGenFlowers field_150514_p = new WorldGenFlowers((Block)Blocks.field_150327_N);
/*  45 */   public WorldGenerator field_76828_s = (WorldGenerator)new WorldGenFlowers((Block)Blocks.field_150338_P);
/*  46 */   public WorldGenerator field_76827_t = (WorldGenerator)new WorldGenFlowers((Block)Blocks.field_150337_Q);
/*  47 */   public WorldGenerator field_76826_u = (WorldGenerator)new WorldGenBigMushroom();
/*  48 */   public WorldGenerator field_76825_v = (WorldGenerator)new WorldGenReed();
/*  49 */   public WorldGenerator field_76824_w = (WorldGenerator)new WorldGenCactus();
/*  50 */   public WorldGenerator field_76834_x = (WorldGenerator)new WorldGenWaterlily();
/*     */   
/*     */   public int field_76833_y;
/*     */   public int field_76832_z;
/*  54 */   public int field_76802_A = 2;
/*  55 */   public int field_76803_B = 1;
/*     */   public int field_76804_C;
/*     */   public int field_76798_D;
/*     */   public int field_76799_E;
/*     */   public int field_76800_F;
/*  60 */   public int field_76801_G = 1;
/*  61 */   public int field_76805_H = 3;
/*  62 */   public int field_76806_I = 1; public int field_76807_J;
/*     */   public boolean field_76808_K = true;
/*     */   private static final String __OBFID = "CL_00000164";
/*     */   
/*     */   protected void func_150513_a(BiomeGenBase p_150513_1_) {
/*  67 */     func_76797_b();
/*     */     int i;
/*  69 */     for (i = 0; i < this.field_76805_H; i++) {
/*  70 */       int k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/*  71 */       int m = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/*  72 */       this.field_76810_g.func_76484_a(this.field_76815_a, this.field_76813_b, k, this.field_76815_a.func_72825_h(k, m), m);
/*     */     } 
/*     */     
/*  75 */     for (i = 0; i < this.field_76806_I; i++) {
/*  76 */       int k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/*  77 */       int m = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/*  78 */       this.field_76809_f.func_76484_a(this.field_76815_a, this.field_76813_b, k, this.field_76815_a.func_72825_h(k, m), m);
/*     */     } 
/*     */     
/*  81 */     for (i = 0; i < this.field_76801_G; i++) {
/*  82 */       int k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/*  83 */       int m = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/*  84 */       this.field_76822_h.func_76484_a(this.field_76815_a, this.field_76813_b, k, this.field_76815_a.func_72825_h(k, m), m);
/*     */     } 
/*     */     
/*  87 */     i = this.field_76832_z;
/*  88 */     if (this.field_76813_b.nextInt(10) == 0) i++; 
/*     */     int j;
/*  90 */     for (j = 0; j < i; j++) {
/*  91 */       int k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/*  92 */       int m = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/*  93 */       int n = this.field_76815_a.func_72976_f(k, m);
/*  94 */       WorldGenAbstractTree worldGenAbstractTree = p_150513_1_.func_150567_a(this.field_76813_b);
/*  95 */       worldGenAbstractTree.func_76487_a(1.0D, 1.0D, 1.0D);
/*  96 */       if (worldGenAbstractTree.func_76484_a(this.field_76815_a, this.field_76813_b, k, n, m)) {
/*  97 */         worldGenAbstractTree.func_150524_b(this.field_76815_a, this.field_76813_b, k, n, m);
/*     */       }
/*     */     } 
/*     */     
/* 101 */     for (j = 0; j < this.field_76807_J; j++) {
/* 102 */       int k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 103 */       int m = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 104 */       this.field_76826_u.func_76484_a(this.field_76815_a, this.field_76813_b, k, this.field_76815_a.func_72976_f(k, m), m);
/*     */     } 
/*     */     
/* 107 */     for (j = 0; j < this.field_76802_A; j++) {
/* 108 */       int k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 109 */       int m = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 110 */       int n = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(k, m) + 32);
/* 111 */       String str = p_150513_1_.func_150572_a(this.field_76813_b, k, n, m);
/* 112 */       BlockFlower blockFlower = BlockFlower.func_149857_e(str);
/* 113 */       if (blockFlower.func_149688_o() != Material.field_151579_a) {
/* 114 */         this.field_150514_p.func_150550_a((Block)blockFlower, BlockFlower.func_149856_f(str));
/* 115 */         this.field_150514_p.func_76484_a(this.field_76815_a, this.field_76813_b, k, n, m);
/*     */       } 
/*     */     } 
/*     */     
/* 119 */     for (j = 0; j < this.field_76803_B; j++) {
/* 120 */       int k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 121 */       int m = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 122 */       int n = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(k, m) * 2);
/* 123 */       WorldGenerator worldGenerator = p_150513_1_.func_76730_b(this.field_76813_b);
/* 124 */       worldGenerator.func_76484_a(this.field_76815_a, this.field_76813_b, k, n, m);
/*     */     } 
/*     */     
/* 127 */     for (j = 0; j < this.field_76804_C; j++) {
/* 128 */       int k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 129 */       int m = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 130 */       int n = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(k, m) * 2);
/* 131 */       (new WorldGenDeadBush((Block)Blocks.field_150330_I)).func_76484_a(this.field_76815_a, this.field_76813_b, k, n, m);
/*     */     } 
/*     */     
/* 134 */     for (j = 0; j < this.field_76833_y; j++) {
/* 135 */       int k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 136 */       int m = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 137 */       int n = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(k, m) * 2);
/* 138 */       while (n > 0 && this.field_76815_a.func_147437_c(k, n - 1, m))
/* 139 */         n--; 
/* 140 */       this.field_76834_x.func_76484_a(this.field_76815_a, this.field_76813_b, k, n, m);
/*     */     } 
/*     */     
/* 143 */     for (j = 0; j < this.field_76798_D; j++) {
/* 144 */       if (this.field_76813_b.nextInt(4) == 0) {
/* 145 */         int k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 146 */         int m = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 147 */         int n = this.field_76815_a.func_72976_f(k, m);
/* 148 */         this.field_76828_s.func_76484_a(this.field_76815_a, this.field_76813_b, k, n, m);
/*     */       } 
/*     */       
/* 151 */       if (this.field_76813_b.nextInt(8) == 0) {
/* 152 */         int k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 153 */         int m = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 154 */         int n = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(k, m) * 2);
/* 155 */         this.field_76827_t.func_76484_a(this.field_76815_a, this.field_76813_b, k, n, m);
/*     */       } 
/*     */     } 
/*     */     
/* 159 */     if (this.field_76813_b.nextInt(4) == 0) {
/* 160 */       j = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 161 */       int k = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 162 */       int m = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(j, k) * 2);
/* 163 */       this.field_76828_s.func_76484_a(this.field_76815_a, this.field_76813_b, j, m, k);
/*     */     } 
/*     */     
/* 166 */     if (this.field_76813_b.nextInt(8) == 0) {
/* 167 */       j = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 168 */       int k = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 169 */       int m = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(j, k) * 2);
/* 170 */       this.field_76827_t.func_76484_a(this.field_76815_a, this.field_76813_b, j, m, k);
/*     */     } 
/*     */     
/* 173 */     for (j = 0; j < this.field_76799_E; j++) {
/* 174 */       int k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 175 */       int m = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 176 */       int n = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(k, m) * 2);
/* 177 */       this.field_76825_v.func_76484_a(this.field_76815_a, this.field_76813_b, k, n, m);
/*     */     } 
/*     */     
/* 180 */     for (j = 0; j < 10; j++) {
/* 181 */       int k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 182 */       int m = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 183 */       int n = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(k, m) * 2);
/* 184 */       this.field_76825_v.func_76484_a(this.field_76815_a, this.field_76813_b, k, n, m);
/*     */     } 
/*     */     
/* 187 */     if (this.field_76813_b.nextInt(32) == 0) {
/* 188 */       j = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 189 */       int k = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 190 */       int m = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(j, k) * 2);
/* 191 */       (new WorldGenPumpkin()).func_76484_a(this.field_76815_a, this.field_76813_b, j, m, k);
/*     */     } 
/*     */     
/* 194 */     for (j = 0; j < this.field_76800_F; j++) {
/* 195 */       int k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 196 */       int m = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 197 */       int n = this.field_76813_b.nextInt(this.field_76815_a.func_72976_f(k, m) * 2);
/* 198 */       this.field_76824_w.func_76484_a(this.field_76815_a, this.field_76813_b, k, n, m);
/*     */     } 
/*     */     
/* 201 */     if (this.field_76808_K) {
/* 202 */       for (j = 0; j < 50; j++) {
/* 203 */         int k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 204 */         int m = this.field_76813_b.nextInt(this.field_76813_b.nextInt(248) + 8);
/* 205 */         int n = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 206 */         (new WorldGenLiquids((Block)Blocks.field_150358_i)).func_76484_a(this.field_76815_a, this.field_76813_b, k, m, n);
/*     */       } 
/*     */       
/* 209 */       for (j = 0; j < 20; j++) {
/* 210 */         int k = this.field_76814_c + this.field_76813_b.nextInt(16) + 8;
/* 211 */         int m = this.field_76813_b.nextInt(this.field_76813_b.nextInt(this.field_76813_b.nextInt(240) + 8) + 8);
/* 212 */         int n = this.field_76811_d + this.field_76813_b.nextInt(16) + 8;
/* 213 */         (new WorldGenLiquids((Block)Blocks.field_150356_k)).func_76484_a(this.field_76815_a, this.field_76813_b, k, m, n);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_76795_a(int p_76795_1_, WorldGenerator p_76795_2_, int p_76795_3_, int p_76795_4_) {
/* 223 */     for (byte b = 0; b < p_76795_1_; b++) {
/* 224 */       int i = this.field_76814_c + this.field_76813_b.nextInt(16);
/* 225 */       int j = this.field_76813_b.nextInt(p_76795_4_ - p_76795_3_) + p_76795_3_;
/* 226 */       int k = this.field_76811_d + this.field_76813_b.nextInt(16);
/* 227 */       p_76795_2_.func_76484_a(this.field_76815_a, this.field_76813_b, i, j, k);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_76793_b(int p_76793_1_, WorldGenerator p_76793_2_, int p_76793_3_, int p_76793_4_) {
/* 232 */     for (byte b = 0; b < p_76793_1_; b++) {
/* 233 */       int i = this.field_76814_c + this.field_76813_b.nextInt(16);
/* 234 */       int j = this.field_76813_b.nextInt(p_76793_4_) + this.field_76813_b.nextInt(p_76793_4_) + p_76793_3_ - p_76793_4_;
/* 235 */       int k = this.field_76811_d + this.field_76813_b.nextInt(16);
/* 236 */       p_76793_2_.func_76484_a(this.field_76815_a, this.field_76813_b, i, j, k);
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_76797_b() {
/* 241 */     func_76795_a(20, this.field_76823_i, 0, 256);
/* 242 */     func_76795_a(10, this.field_76820_j, 0, 256);
/* 243 */     func_76795_a(20, this.field_76821_k, 0, 128);
/* 244 */     func_76795_a(20, this.field_76818_l, 0, 64);
/* 245 */     func_76795_a(2, this.field_76819_m, 0, 32);
/* 246 */     func_76795_a(8, this.field_76816_n, 0, 16);
/* 247 */     func_76795_a(1, this.field_76817_o, 0, 16);
/* 248 */     func_76793_b(1, this.field_76831_p, 16, 16);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\biome\BiomeDecorator.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */