/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGenTaiga2
/*    */   extends WorldGenAbstractTree {
/*    */   public WorldGenTaiga2(boolean p_i2025_1_) {
/* 12 */     super(p_i2025_1_);
/*    */   }
/*    */ 
/*    */   
/*    */   private static final String __OBFID = "CL_00000435";
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/* 19 */     int i = p_76484_2_.nextInt(4) + 6;
/* 20 */     int j = 1 + p_76484_2_.nextInt(2);
/* 21 */     int k = i - j;
/* 22 */     int m = 2 + p_76484_2_.nextInt(2);
/*    */     
/* 24 */     boolean bool1 = true;
/*    */     
/* 26 */     if (p_76484_4_ < 1 || p_76484_4_ + i + 1 > 256) {
/* 27 */       return false;
/*    */     }
/*    */ 
/*    */     
/* 31 */     for (int n = p_76484_4_; n <= p_76484_4_ + 1 + i && bool1; n++) {
/*    */       
/* 33 */       int i4 = 1;
/* 34 */       if (n - p_76484_4_ < j) {
/* 35 */         i4 = 0;
/*    */       } else {
/* 37 */         i4 = m;
/*    */       } 
/* 39 */       for (int i5 = p_76484_3_ - i4; i5 <= p_76484_3_ + i4 && bool1; i5++) {
/* 40 */         for (int i6 = p_76484_5_ - i4; i6 <= p_76484_5_ + i4 && bool1; i6++) {
/* 41 */           if (n >= 0 && n < 256) {
/* 42 */             Block block1 = p_76484_1_.func_147439_a(i5, n, i6);
/* 43 */             if (block1.func_149688_o() != Material.field_151579_a && block1.func_149688_o() != Material.field_151584_j) bool1 = false; 
/*    */           } else {
/* 45 */             bool1 = false;
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 51 */     if (!bool1) return false;
/*    */ 
/*    */     
/* 54 */     Block block = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_);
/* 55 */     if ((block != Blocks.field_150349_c && block != Blocks.field_150346_d && block != Blocks.field_150458_ak) || p_76484_4_ >= 256 - i - 1) {
/* 56 */       return false;
/*    */     }
/* 58 */     func_150515_a(p_76484_1_, p_76484_3_, p_76484_4_ - 1, p_76484_5_, Blocks.field_150346_d);
/*    */ 
/*    */     
/* 61 */     int i1 = p_76484_2_.nextInt(2);
/* 62 */     int i2 = 1;
/* 63 */     boolean bool2 = false; int i3;
/* 64 */     for (i3 = 0; i3 <= k; i3++) {
/*    */       
/* 66 */       int i4 = p_76484_4_ + i - i3;
/*    */       
/* 68 */       for (int i5 = p_76484_3_ - i1; i5 <= p_76484_3_ + i1; i5++) {
/* 69 */         int i6 = i5 - p_76484_3_;
/* 70 */         for (int i7 = p_76484_5_ - i1; i7 <= p_76484_5_ + i1; i7++) {
/* 71 */           int i8 = i7 - p_76484_5_;
/* 72 */           if ((Math.abs(i6) != i1 || Math.abs(i8) != i1 || i1 <= 0) && 
/* 73 */             !p_76484_1_.func_147439_a(i5, i4, i7).func_149730_j()) {
/* 74 */             func_150516_a(p_76484_1_, i5, i4, i7, (Block)Blocks.field_150362_t, 1);
/*    */           }
/*    */         } 
/*    */       } 
/* 78 */       if (i1 >= i2) {
/* 79 */         i1 = bool2;
/* 80 */         bool2 = true;
/* 81 */         i2++;
/* 82 */         if (i2 > m) {
/* 83 */           i2 = m;
/*    */         }
/*    */       } else {
/* 86 */         i1++;
/*    */       } 
/*    */     } 
/* 89 */     i3 = p_76484_2_.nextInt(3);
/* 90 */     for (byte b = 0; b < i - i3; b++) {
/* 91 */       Block block1 = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ + b, p_76484_5_);
/* 92 */       if (block1.func_149688_o() == Material.field_151579_a || block1.func_149688_o() == Material.field_151584_j) func_150516_a(p_76484_1_, p_76484_3_, p_76484_4_ + b, p_76484_5_, Blocks.field_150364_r, 1); 
/*    */     } 
/* 94 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenTaiga2.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */