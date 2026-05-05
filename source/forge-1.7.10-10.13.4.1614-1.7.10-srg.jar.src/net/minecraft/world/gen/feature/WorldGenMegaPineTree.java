/*     */ package net.minecraft.world.gen.feature;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class WorldGenMegaPineTree extends WorldGenHugeTrees {
/*     */   private boolean field_150542_e;
/*     */   private static final String __OBFID = "CL_00000421";
/*     */   
/*     */   public WorldGenMegaPineTree(boolean p_i45457_1_, boolean p_i45457_2_) {
/*  15 */     super(p_i45457_1_, 13, 15, 1, 1);
/*  16 */     this.field_150542_e = p_i45457_2_;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/*  22 */     int i = func_150533_a(p_76484_2_);
/*  23 */     if (!func_150537_a(p_76484_1_, p_76484_2_, p_76484_3_, p_76484_4_, p_76484_5_, i)) return false;
/*     */     
/*  25 */     func_150541_c(p_76484_1_, p_76484_3_, p_76484_5_, p_76484_4_ + i, 0, p_76484_2_);
/*     */     
/*  27 */     for (byte b = 0; b < i; b++) {
/*  28 */       Block block = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ + b, p_76484_5_);
/*  29 */       if (block.func_149688_o() == Material.field_151579_a || block.func_149688_o() == Material.field_151584_j) {
/*  30 */         func_150516_a(p_76484_1_, p_76484_3_, p_76484_4_ + b, p_76484_5_, Blocks.field_150364_r, this.field_76520_b);
/*     */       }
/*  32 */       if (b < i - 1) {
/*  33 */         block = p_76484_1_.func_147439_a(p_76484_3_ + 1, p_76484_4_ + b, p_76484_5_);
/*  34 */         if (block.func_149688_o() == Material.field_151579_a || block.func_149688_o() == Material.field_151584_j) {
/*  35 */           func_150516_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + b, p_76484_5_, Blocks.field_150364_r, this.field_76520_b);
/*     */         }
/*  37 */         block = p_76484_1_.func_147439_a(p_76484_3_ + 1, p_76484_4_ + b, p_76484_5_ + 1);
/*  38 */         if (block.func_149688_o() == Material.field_151579_a || block.func_149688_o() == Material.field_151584_j) {
/*  39 */           func_150516_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + b, p_76484_5_ + 1, Blocks.field_150364_r, this.field_76520_b);
/*     */         }
/*  41 */         block = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ + b, p_76484_5_ + 1);
/*  42 */         if (block.func_149688_o() == Material.field_151579_a || block.func_149688_o() == Material.field_151584_j) {
/*  43 */           func_150516_a(p_76484_1_, p_76484_3_, p_76484_4_ + b, p_76484_5_ + 1, Blocks.field_150364_r, this.field_76520_b);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   private void func_150541_c(World p_150541_1_, int p_150541_2_, int p_150541_3_, int p_150541_4_, int p_150541_5_, Random p_150541_6_) {
/*  52 */     int i = p_150541_6_.nextInt(5);
/*  53 */     if (this.field_150542_e) {
/*  54 */       i += this.field_76522_a;
/*     */     } else {
/*  56 */       i += 3;
/*     */     } 
/*  58 */     int j = 0;
/*  59 */     for (int k = p_150541_4_ - i; k <= p_150541_4_; k++) {
/*  60 */       int m = p_150541_4_ - k;
/*  61 */       int n = p_150541_5_ + MathHelper.func_76141_d(m / i * 3.5F);
/*  62 */       func_150535_a(p_150541_1_, p_150541_2_, k, p_150541_3_, n + ((m > 0 && n == j && (k & 0x1) == 0) ? 1 : 0), p_150541_6_);
/*  63 */       j = n;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_150524_b(World p_150524_1_, Random p_150524_2_, int p_150524_3_, int p_150524_4_, int p_150524_5_) {
/*  69 */     func_150539_c(p_150524_1_, p_150524_2_, p_150524_3_ - 1, p_150524_4_, p_150524_5_ - 1);
/*  70 */     func_150539_c(p_150524_1_, p_150524_2_, p_150524_3_ + 2, p_150524_4_, p_150524_5_ - 1);
/*  71 */     func_150539_c(p_150524_1_, p_150524_2_, p_150524_3_ - 1, p_150524_4_, p_150524_5_ + 2);
/*  72 */     func_150539_c(p_150524_1_, p_150524_2_, p_150524_3_ + 2, p_150524_4_, p_150524_5_ + 2);
/*     */     
/*  74 */     for (byte b = 0; b < 5; b++) {
/*  75 */       int i = p_150524_2_.nextInt(64);
/*  76 */       int j = i % 8;
/*  77 */       int k = i / 8;
/*  78 */       if (j == 0 || j == 7 || k == 0 || k == 7) {
/*  79 */         func_150539_c(p_150524_1_, p_150524_2_, p_150524_3_ - 3 + j, p_150524_4_, p_150524_5_ - 3 + k);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_150539_c(World p_150539_1_, Random p_150539_2_, int p_150539_3_, int p_150539_4_, int p_150539_5_) {
/*  86 */     for (byte b = -2; b <= 2; b++) {
/*  87 */       for (byte b1 = -2; b1 <= 2; b1++) {
/*  88 */         if (Math.abs(b) != 2 || Math.abs(b1) != 2) {
/*  89 */           func_150540_a(p_150539_1_, p_150539_3_ + b, p_150539_4_, p_150539_5_ + b1);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void func_150540_a(World p_150540_1_, int p_150540_2_, int p_150540_3_, int p_150540_4_) {
/*  97 */     for (int i = p_150540_3_ + 2; i >= p_150540_3_ - 3; i--) {
/*  98 */       Block block = p_150540_1_.func_147439_a(p_150540_2_, i, p_150540_4_);
/*  99 */       if (block == Blocks.field_150349_c || block == Blocks.field_150346_d) {
/* 100 */         func_150516_a(p_150540_1_, p_150540_2_, i, p_150540_4_, Blocks.field_150346_d, 2); break;
/*     */       } 
/* 102 */       if (block.func_149688_o() != Material.field_151579_a && i < p_150540_3_)
/*     */         break; 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenMegaPineTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */