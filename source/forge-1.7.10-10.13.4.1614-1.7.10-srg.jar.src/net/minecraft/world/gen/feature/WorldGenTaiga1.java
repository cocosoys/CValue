/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGenTaiga1
/*    */   extends WorldGenAbstractTree {
/*    */   public WorldGenTaiga1() {
/* 12 */     super(false);
/*    */   }
/*    */ 
/*    */   
/*    */   private static final String __OBFID = "CL_00000427";
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/* 19 */     int i = p_76484_2_.nextInt(5) + 7;
/* 20 */     int j = i - p_76484_2_.nextInt(2) - 3;
/* 21 */     int k = i - j;
/* 22 */     int m = 1 + p_76484_2_.nextInt(k + 1);
/*    */     
/* 24 */     boolean bool = true;
/*    */     
/* 26 */     if (p_76484_4_ < 1 || p_76484_4_ + i + 1 > 256) {
/* 27 */       return false;
/*    */     }
/*    */ 
/*    */     
/* 31 */     for (int n = p_76484_4_; n <= p_76484_4_ + 1 + i && bool; n++) {
/*    */       
/* 33 */       int i2 = 1;
/* 34 */       if (n - p_76484_4_ < j) {
/* 35 */         i2 = 0;
/*    */       } else {
/* 37 */         i2 = m;
/*    */       } 
/* 39 */       for (int i3 = p_76484_3_ - i2; i3 <= p_76484_3_ + i2 && bool; i3++) {
/* 40 */         for (int i4 = p_76484_5_ - i2; i4 <= p_76484_5_ + i2 && bool; i4++) {
/* 41 */           if (n >= 0 && n < 256) {
/* 42 */             Block block1 = p_76484_1_.func_147439_a(i3, n, i4);
/* 43 */             if (!func_150523_a(block1)) bool = false; 
/*    */           } else {
/* 45 */             bool = false;
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 51 */     if (!bool) return false;
/*    */ 
/*    */     
/* 54 */     Block block = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_);
/* 55 */     if ((block != Blocks.field_150349_c && block != Blocks.field_150346_d) || p_76484_4_ >= 256 - i - 1) {
/* 56 */       return false;
/*    */     }
/* 58 */     func_150515_a(p_76484_1_, p_76484_3_, p_76484_4_ - 1, p_76484_5_, Blocks.field_150346_d);
/*    */ 
/*    */     
/* 61 */     byte b = 0; int i1;
/* 62 */     for (i1 = p_76484_4_ + i; i1 >= p_76484_4_ + j; i1--) {
/*    */       
/* 64 */       for (int i2 = p_76484_3_ - b; i2 <= p_76484_3_ + b; i2++) {
/* 65 */         int i3 = i2 - p_76484_3_;
/* 66 */         for (int i4 = p_76484_5_ - b; i4 <= p_76484_5_ + b; i4++) {
/* 67 */           int i5 = i4 - p_76484_5_;
/* 68 */           if ((Math.abs(i3) != b || Math.abs(i5) != b || b <= 0) && 
/* 69 */             !p_76484_1_.func_147439_a(i2, i1, i4).func_149730_j()) {
/* 70 */             func_150516_a(p_76484_1_, i2, i1, i4, (Block)Blocks.field_150362_t, 1);
/*    */           }
/*    */         } 
/*    */       } 
/* 74 */       if (b >= 1 && i1 == p_76484_4_ + j + 1) {
/* 75 */         b--;
/* 76 */       } else if (b < m) {
/* 77 */         b++;
/*    */       } 
/*    */     } 
/* 80 */     for (i1 = 0; i1 < i - 1; i1++) {
/* 81 */       Block block1 = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ + i1, p_76484_5_);
/* 82 */       if (block1.func_149688_o() == Material.field_151579_a || block1.func_149688_o() == Material.field_151584_j) func_150516_a(p_76484_1_, p_76484_3_, p_76484_4_ + i1, p_76484_5_, Blocks.field_150364_r, 1); 
/*    */     } 
/* 84 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenTaiga1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */