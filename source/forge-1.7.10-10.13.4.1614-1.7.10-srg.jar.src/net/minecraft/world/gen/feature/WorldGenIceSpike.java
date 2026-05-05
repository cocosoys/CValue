/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGenIceSpike
/*    */   extends WorldGenerator {
/*    */   private static final String __OBFID = "CL_00000417";
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/* 15 */     while (p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_, p_76484_5_) && p_76484_4_ > 2) {
/* 16 */       p_76484_4_--;
/*    */     }
/* 18 */     if (p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_) != Blocks.field_150433_aE) {
/* 19 */       return false;
/*    */     }
/* 21 */     p_76484_4_ += p_76484_2_.nextInt(4);
/*    */     
/* 23 */     int i = p_76484_2_.nextInt(4) + 7;
/* 24 */     int j = i / 4 + p_76484_2_.nextInt(2);
/*    */     
/* 26 */     if (j > 1 && p_76484_2_.nextInt(60) == 0) {
/* 27 */       p_76484_4_ += 10 + p_76484_2_.nextInt(30);
/*    */     }
/*    */     int k;
/* 30 */     for (k = 0; k < i; k++) {
/* 31 */       float f = (1.0F - k / i) * j;
/* 32 */       int n = MathHelper.func_76123_f(f);
/*    */       
/* 34 */       for (int i1 = -n; i1 <= n; i1++) {
/* 35 */         float f1 = MathHelper.func_76130_a(i1) - 0.25F;
/* 36 */         for (int i2 = -n; i2 <= n; i2++) {
/* 37 */           float f2 = MathHelper.func_76130_a(i2) - 0.25F;
/* 38 */           if ((i1 == 0 && i2 == 0) || f1 * f1 + f2 * f2 <= f * f)
/*    */           {
/*    */             
/* 41 */             if ((i1 != -n && i1 != n && i2 != -n && i2 != n) || 
/* 42 */               p_76484_2_.nextFloat() <= 0.75F) {
/*    */ 
/*    */ 
/*    */ 
/*    */               
/* 47 */               Block block = p_76484_1_.func_147439_a(p_76484_3_ + i1, p_76484_4_ + k, p_76484_5_ + i2);
/* 48 */               if (block.func_149688_o() == Material.field_151579_a || block == Blocks.field_150346_d || block == Blocks.field_150433_aE || block == Blocks.field_150432_aD) {
/* 49 */                 func_150515_a(p_76484_1_, p_76484_3_ + i1, p_76484_4_ + k, p_76484_5_ + i2, Blocks.field_150403_cj);
/*    */               }
/* 51 */               if (k != 0 && n > 1) {
/* 52 */                 block = p_76484_1_.func_147439_a(p_76484_3_ + i1, p_76484_4_ - k, p_76484_5_ + i2);
/* 53 */                 if (block.func_149688_o() == Material.field_151579_a || block == Blocks.field_150346_d || block == Blocks.field_150433_aE || block == Blocks.field_150432_aD)
/* 54 */                   func_150515_a(p_76484_1_, p_76484_3_ + i1, p_76484_4_ - k, p_76484_5_ + i2, Blocks.field_150403_cj); 
/*    */               } 
/*    */             }  } 
/*    */         } 
/*    */       } 
/*    */     } 
/* 60 */     k = j - 1;
/* 61 */     if (k < 0) {
/* 62 */       k = 0;
/* 63 */     } else if (k > 1) {
/* 64 */       k = 1;
/*    */     } 
/* 66 */     for (int m = -k; m <= k; m++) {
/* 67 */       for (int n = -k; n <= k; n++) {
/* 68 */         int i1 = p_76484_4_ - 1;
/* 69 */         int i2 = 50;
/* 70 */         if (Math.abs(m) == 1 && Math.abs(n) == 1) {
/* 71 */           i2 = p_76484_2_.nextInt(5);
/*    */         }
/* 73 */         while (i1 > 50) {
/* 74 */           Block block = p_76484_1_.func_147439_a(p_76484_3_ + m, i1, p_76484_5_ + n);
/* 75 */           if (block.func_149688_o() == Material.field_151579_a || block == Blocks.field_150346_d || block == Blocks.field_150433_aE || block == Blocks.field_150432_aD || block == Blocks.field_150403_cj) {
/* 76 */             func_150515_a(p_76484_1_, p_76484_3_ + m, i1, p_76484_5_ + n, Blocks.field_150403_cj);
/*    */ 
/*    */ 
/*    */             
/* 80 */             i1--;
/* 81 */             i2--;
/* 82 */             if (i2 <= 0) {
/* 83 */               i1 -= p_76484_2_.nextInt(5) + 1;
/* 84 */               i2 = p_76484_2_.nextInt(5);
/*    */             } 
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/* 90 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenIceSpike.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */