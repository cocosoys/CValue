/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class WorldGenForest
/*    */   extends WorldGenAbstractTree
/*    */ {
/*    */   private boolean field_150531_a;
/*    */   private static final String __OBFID = "CL_00000401";
/*    */   
/*    */   public WorldGenForest(boolean p_i45449_1_, boolean p_i45449_2_) {
/* 17 */     super(p_i45449_1_);
/* 18 */     this.field_150531_a = p_i45449_2_;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/* 23 */     int i = p_76484_2_.nextInt(3) + 5;
/* 24 */     if (this.field_150531_a) {
/* 25 */       i += p_76484_2_.nextInt(7);
/*    */     }
/*    */     
/* 28 */     boolean bool = true;
/* 29 */     if (p_76484_4_ < 1 || p_76484_4_ + i + 1 > 256) return false;
/*    */     
/* 31 */     for (int j = p_76484_4_; j <= p_76484_4_ + 1 + i; j++) {
/* 32 */       byte b = 1;
/* 33 */       if (j == p_76484_4_) b = 0; 
/* 34 */       if (j >= p_76484_4_ + 1 + i - 2) b = 2; 
/* 35 */       for (int m = p_76484_3_ - b; m <= p_76484_3_ + b && bool; m++) {
/* 36 */         for (int n = p_76484_5_ - b; n <= p_76484_5_ + b && bool; n++) {
/* 37 */           if (j >= 0 && j < 256) {
/* 38 */             Block block1 = p_76484_1_.func_147439_a(m, j, n);
/* 39 */             if (!func_150523_a(block1)) bool = false; 
/*    */           } else {
/* 41 */             bool = false;
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 47 */     if (!bool) return false;
/*    */     
/* 49 */     Block block = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_);
/* 50 */     if ((block != Blocks.field_150349_c && block != Blocks.field_150346_d && block != Blocks.field_150458_ak) || p_76484_4_ >= 256 - i - 1) return false;
/*    */     
/* 52 */     func_150515_a(p_76484_1_, p_76484_3_, p_76484_4_ - 1, p_76484_5_, Blocks.field_150346_d);
/*    */     int k;
/* 54 */     for (k = p_76484_4_ - 3 + i; k <= p_76484_4_ + i; k++) {
/* 55 */       int m = k - p_76484_4_ + i;
/* 56 */       int n = 1 - m / 2;
/* 57 */       for (int i1 = p_76484_3_ - n; i1 <= p_76484_3_ + n; i1++) {
/* 58 */         int i2 = i1 - p_76484_3_;
/* 59 */         for (int i3 = p_76484_5_ - n; i3 <= p_76484_5_ + n; i3++) {
/* 60 */           int i4 = i3 - p_76484_5_;
/* 61 */           if (Math.abs(i2) != n || Math.abs(i4) != n || (p_76484_2_.nextInt(2) != 0 && m != 0)) {
/* 62 */             Block block1 = p_76484_1_.func_147439_a(i1, k, i3);
/* 63 */             if (block1.func_149688_o() == Material.field_151579_a || block1.func_149688_o() == Material.field_151584_j) func_150516_a(p_76484_1_, i1, k, i3, (Block)Blocks.field_150362_t, 2); 
/*    */           } 
/*    */         } 
/*    */       } 
/* 67 */     }  for (k = 0; k < i; k++) {
/* 68 */       Block block1 = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ + k, p_76484_5_);
/* 69 */       if (block1.func_149688_o() == Material.field_151579_a || block1.func_149688_o() == Material.field_151584_j) func_150516_a(p_76484_1_, p_76484_3_, p_76484_4_ + k, p_76484_5_, Blocks.field_150364_r, 2); 
/*    */     } 
/* 71 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenForest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */