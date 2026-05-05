/*     */ package net.minecraft.world.gen.feature;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public abstract class WorldGenHugeTrees
/*     */   extends WorldGenAbstractTree {
/*     */   protected final int field_76522_a;
/*     */   protected final int field_76520_b;
/*     */   protected final int field_76521_c;
/*     */   protected int field_150538_d;
/*     */   private static final String __OBFID = "CL_00000423";
/*     */   
/*     */   public WorldGenHugeTrees(boolean p_i45458_1_, int p_i45458_2_, int p_i45458_3_, int p_i45458_4_, int p_i45458_5_) {
/*  18 */     super(p_i45458_1_);
/*  19 */     this.field_76522_a = p_i45458_2_;
/*  20 */     this.field_150538_d = p_i45458_3_;
/*  21 */     this.field_76520_b = p_i45458_4_;
/*  22 */     this.field_76521_c = p_i45458_5_;
/*     */   }
/*     */   
/*     */   protected int func_150533_a(Random p_150533_1_) {
/*  26 */     int i = p_150533_1_.nextInt(3) + this.field_76522_a;
/*  27 */     if (this.field_150538_d > 1) {
/*  28 */       i += p_150533_1_.nextInt(this.field_150538_d);
/*     */     }
/*  30 */     return i;
/*     */   }
/*     */   
/*     */   private boolean func_150536_b(World p_150536_1_, Random p_150536_2_, int p_150536_3_, int p_150536_4_, int p_150536_5_, int p_150536_6_) {
/*  34 */     boolean bool = true;
/*  35 */     if (p_150536_4_ < 1 || p_150536_4_ + p_150536_6_ + 1 > 256) return false;
/*     */     
/*  37 */     for (int i = p_150536_4_; i <= p_150536_4_ + 1 + p_150536_6_; i++) {
/*  38 */       byte b = 2;
/*  39 */       if (i == p_150536_4_) b = 1; 
/*  40 */       if (i >= p_150536_4_ + 1 + p_150536_6_ - 2) b = 2; 
/*  41 */       for (int j = p_150536_3_ - b; j <= p_150536_3_ + b && bool; j++) {
/*  42 */         for (int k = p_150536_5_ - b; k <= p_150536_5_ + b && bool; k++) {
/*  43 */           if (i >= 0 && i < 256) {
/*  44 */             Block block = p_150536_1_.func_147439_a(j, i, k);
/*  45 */             if (!func_150523_a(block)) bool = false; 
/*     */           } else {
/*  47 */             bool = false;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  53 */     return bool;
/*     */   }
/*     */   
/*     */   private boolean func_150532_c(World p_150532_1_, Random p_150532_2_, int p_150532_3_, int p_150532_4_, int p_150532_5_) {
/*  57 */     Block block = p_150532_1_.func_147439_a(p_150532_3_, p_150532_4_ - 1, p_150532_5_);
/*  58 */     if ((block != Blocks.field_150349_c && block != Blocks.field_150346_d) || p_150532_4_ < 2) return false;
/*     */     
/*  60 */     p_150532_1_.func_147465_d(p_150532_3_, p_150532_4_ - 1, p_150532_5_, Blocks.field_150346_d, 0, 2);
/*  61 */     p_150532_1_.func_147465_d(p_150532_3_ + 1, p_150532_4_ - 1, p_150532_5_, Blocks.field_150346_d, 0, 2);
/*  62 */     p_150532_1_.func_147465_d(p_150532_3_, p_150532_4_ - 1, p_150532_5_ + 1, Blocks.field_150346_d, 0, 2);
/*  63 */     p_150532_1_.func_147465_d(p_150532_3_ + 1, p_150532_4_ - 1, p_150532_5_ + 1, Blocks.field_150346_d, 0, 2);
/*     */     
/*  65 */     return true;
/*     */   }
/*     */   
/*     */   protected boolean func_150537_a(World p_150537_1_, Random p_150537_2_, int p_150537_3_, int p_150537_4_, int p_150537_5_, int p_150537_6_) {
/*  69 */     return (func_150536_b(p_150537_1_, p_150537_2_, p_150537_3_, p_150537_4_, p_150537_5_, p_150537_6_) && func_150532_c(p_150537_1_, p_150537_2_, p_150537_3_, p_150537_4_, p_150537_5_));
/*     */   }
/*     */   
/*     */   protected void func_150535_a(World p_150535_1_, int p_150535_2_, int p_150535_3_, int p_150535_4_, int p_150535_5_, Random p_150535_6_) {
/*  73 */     int i = p_150535_5_ * p_150535_5_;
/*     */     
/*  75 */     for (int j = p_150535_2_ - p_150535_5_; j <= p_150535_2_ + p_150535_5_ + 1; j++) {
/*  76 */       int k = j - p_150535_2_;
/*  77 */       for (int m = p_150535_4_ - p_150535_5_; m <= p_150535_4_ + p_150535_5_ + 1; m++) {
/*  78 */         int n = m - p_150535_4_;
/*  79 */         int i1 = k - 1;
/*  80 */         int i2 = n - 1;
/*  81 */         if (k * k + n * n <= i || i1 * i1 + i2 * i2 <= i || k * k + i2 * i2 <= i || i1 * i1 + n * n <= i) {
/*     */ 
/*     */           
/*  84 */           Block block = p_150535_1_.func_147439_a(j, p_150535_3_, m);
/*  85 */           if (block.func_149688_o() == Material.field_151579_a || block.func_149688_o() == Material.field_151584_j) func_150516_a(p_150535_1_, j, p_150535_3_, m, (Block)Blocks.field_150362_t, this.field_76521_c); 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */   protected void func_150534_b(World p_150534_1_, int p_150534_2_, int p_150534_3_, int p_150534_4_, int p_150534_5_, Random p_150534_6_) {
/*  91 */     int i = p_150534_5_ * p_150534_5_;
/*     */     
/*  93 */     for (int j = p_150534_2_ - p_150534_5_; j <= p_150534_2_ + p_150534_5_; j++) {
/*  94 */       int k = j - p_150534_2_;
/*  95 */       for (int m = p_150534_4_ - p_150534_5_; m <= p_150534_4_ + p_150534_5_; m++) {
/*  96 */         int n = m - p_150534_4_;
/*  97 */         if (k * k + n * n <= i) {
/*     */ 
/*     */           
/* 100 */           Block block = p_150534_1_.func_147439_a(j, p_150534_3_, m);
/* 101 */           if (block.func_149688_o() == Material.field_151579_a || block.func_149688_o() == Material.field_151584_j) func_150516_a(p_150534_1_, j, p_150534_3_, m, (Block)Blocks.field_150362_t, this.field_76521_c); 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenHugeTrees.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */