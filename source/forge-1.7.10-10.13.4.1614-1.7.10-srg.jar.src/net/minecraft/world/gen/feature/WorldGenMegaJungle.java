/*     */ package net.minecraft.world.gen.feature;
/*     */ 
/*     */ import java.util.Random;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class WorldGenMegaJungle
/*     */   extends WorldGenHugeTrees {
/*     */   public WorldGenMegaJungle(boolean p_i45456_1_, int p_i45456_2_, int p_i45456_3_, int p_i45456_4_, int p_i45456_5_) {
/*  13 */     super(p_i45456_1_, p_i45456_2_, p_i45456_3_, p_i45456_4_, p_i45456_5_);
/*     */   }
/*     */   
/*     */   private static final String __OBFID = "CL_00000420";
/*     */   
/*     */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/*  19 */     int i = func_150533_a(p_76484_2_);
/*  20 */     if (!func_150537_a(p_76484_1_, p_76484_2_, p_76484_3_, p_76484_4_, p_76484_5_, i)) return false;
/*     */     
/*  22 */     func_150543_c(p_76484_1_, p_76484_3_, p_76484_5_, p_76484_4_ + i, 2, p_76484_2_);
/*     */     
/*  24 */     int j = p_76484_4_ + i - 2 - p_76484_2_.nextInt(4);
/*  25 */     while (j > p_76484_4_ + i / 2) {
/*  26 */       float f = p_76484_2_.nextFloat() * 3.1415927F * 2.0F;
/*  27 */       int k = p_76484_3_ + (int)(0.5F + MathHelper.func_76134_b(f) * 4.0F);
/*  28 */       int m = p_76484_5_ + (int)(0.5F + MathHelper.func_76126_a(f) * 4.0F);
/*     */       int n;
/*  30 */       for (n = 0; n < 5; n++) {
/*  31 */         k = p_76484_3_ + (int)(1.5F + MathHelper.func_76134_b(f) * n);
/*  32 */         m = p_76484_5_ + (int)(1.5F + MathHelper.func_76126_a(f) * n);
/*  33 */         func_150516_a(p_76484_1_, k, j - 3 + n / 2, m, Blocks.field_150364_r, this.field_76520_b);
/*     */       } 
/*  35 */       n = 1 + p_76484_2_.nextInt(2);
/*  36 */       int i1 = j;
/*  37 */       for (int i2 = i1 - n; i2 <= i1; i2++) {
/*  38 */         int i3 = i2 - i1;
/*  39 */         func_150534_b(p_76484_1_, k, i2, m, 1 - i3, p_76484_2_);
/*     */       } 
/*     */       
/*  42 */       j -= 2 + p_76484_2_.nextInt(4);
/*     */     } 
/*     */     
/*  45 */     for (byte b = 0; b < i; b++) {
/*  46 */       Block block = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ + b, p_76484_5_);
/*  47 */       if (block.func_149688_o() == Material.field_151579_a || block.func_149688_o() == Material.field_151584_j) {
/*  48 */         func_150516_a(p_76484_1_, p_76484_3_, p_76484_4_ + b, p_76484_5_, Blocks.field_150364_r, this.field_76520_b);
/*  49 */         if (b > 0) {
/*  50 */           if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_147437_c(p_76484_3_ - 1, p_76484_4_ + b, p_76484_5_)) {
/*  51 */             func_150516_a(p_76484_1_, p_76484_3_ - 1, p_76484_4_ + b, p_76484_5_, Blocks.field_150395_bd, 8);
/*     */           }
/*  53 */           if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_ + b, p_76484_5_ - 1)) {
/*  54 */             func_150516_a(p_76484_1_, p_76484_3_, p_76484_4_ + b, p_76484_5_ - 1, Blocks.field_150395_bd, 1);
/*     */           }
/*     */         } 
/*     */       } 
/*  58 */       if (b < i - 1) {
/*  59 */         block = p_76484_1_.func_147439_a(p_76484_3_ + 1, p_76484_4_ + b, p_76484_5_);
/*  60 */         if (block.func_149688_o() == Material.field_151579_a || block.func_149688_o() == Material.field_151584_j) {
/*  61 */           func_150516_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + b, p_76484_5_, Blocks.field_150364_r, this.field_76520_b);
/*  62 */           if (b > 0) {
/*  63 */             if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_147437_c(p_76484_3_ + 2, p_76484_4_ + b, p_76484_5_)) {
/*  64 */               func_150516_a(p_76484_1_, p_76484_3_ + 2, p_76484_4_ + b, p_76484_5_, Blocks.field_150395_bd, 2);
/*     */             }
/*  66 */             if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_147437_c(p_76484_3_ + 1, p_76484_4_ + b, p_76484_5_ - 1)) {
/*  67 */               func_150516_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + b, p_76484_5_ - 1, Blocks.field_150395_bd, 1);
/*     */             }
/*     */           } 
/*     */         } 
/*  71 */         block = p_76484_1_.func_147439_a(p_76484_3_ + 1, p_76484_4_ + b, p_76484_5_ + 1);
/*  72 */         if (block.func_149688_o() == Material.field_151579_a || block.func_149688_o() == Material.field_151584_j) {
/*  73 */           func_150516_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + b, p_76484_5_ + 1, Blocks.field_150364_r, this.field_76520_b);
/*  74 */           if (b > 0) {
/*  75 */             if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_147437_c(p_76484_3_ + 2, p_76484_4_ + b, p_76484_5_ + 1)) {
/*  76 */               func_150516_a(p_76484_1_, p_76484_3_ + 2, p_76484_4_ + b, p_76484_5_ + 1, Blocks.field_150395_bd, 2);
/*     */             }
/*  78 */             if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_147437_c(p_76484_3_ + 1, p_76484_4_ + b, p_76484_5_ + 2)) {
/*  79 */               func_150516_a(p_76484_1_, p_76484_3_ + 1, p_76484_4_ + b, p_76484_5_ + 2, Blocks.field_150395_bd, 4);
/*     */             }
/*     */           } 
/*     */         } 
/*  83 */         block = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ + b, p_76484_5_ + 1);
/*  84 */         if (block.func_149688_o() == Material.field_151579_a || block.func_149688_o() == Material.field_151584_j) {
/*  85 */           func_150516_a(p_76484_1_, p_76484_3_, p_76484_4_ + b, p_76484_5_ + 1, Blocks.field_150364_r, this.field_76520_b);
/*  86 */           if (b > 0) {
/*  87 */             if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_147437_c(p_76484_3_ - 1, p_76484_4_ + b, p_76484_5_ + 1)) {
/*  88 */               func_150516_a(p_76484_1_, p_76484_3_ - 1, p_76484_4_ + b, p_76484_5_ + 1, Blocks.field_150395_bd, 8);
/*     */             }
/*  90 */             if (p_76484_2_.nextInt(3) > 0 && p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_ + b, p_76484_5_ + 2)) {
/*  91 */               func_150516_a(p_76484_1_, p_76484_3_, p_76484_4_ + b, p_76484_5_ + 2, Blocks.field_150395_bd, 4);
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  98 */     return true;
/*     */   }
/*     */   
/*     */   private void func_150543_c(World p_150543_1_, int p_150543_2_, int p_150543_3_, int p_150543_4_, int p_150543_5_, Random p_150543_6_) {
/* 102 */     byte b = 2;
/* 103 */     for (int i = p_150543_4_ - b; i <= p_150543_4_; i++) {
/* 104 */       int j = i - p_150543_4_;
/* 105 */       func_150535_a(p_150543_1_, p_150543_2_, i, p_150543_3_, p_150543_5_ + 1 - j, p_150543_6_);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenMegaJungle.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */