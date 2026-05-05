/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGenShrub extends WorldGenTrees {
/*    */   private int field_150528_a;
/*    */   private int field_150527_b;
/*    */   private static final String __OBFID = "CL_00000411";
/*    */   
/*    */   public WorldGenShrub(int p_i2015_1_, int p_i2015_2_) {
/* 15 */     super(false);
/* 16 */     this.field_150527_b = p_i2015_1_;
/* 17 */     this.field_150528_a = p_i2015_2_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/*    */     Block block1;
/* 24 */     while (((block1 = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_)).func_149688_o() == Material.field_151579_a || block1.func_149688_o() == Material.field_151584_j) && p_76484_4_ > 0) {
/* 25 */       p_76484_4_--;
/*    */     }
/* 27 */     Block block2 = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_);
/* 28 */     if (block2 == Blocks.field_150346_d || block2 == Blocks.field_150349_c) {
/* 29 */       p_76484_4_++;
/* 30 */       func_150516_a(p_76484_1_, p_76484_3_, p_76484_4_, p_76484_5_, Blocks.field_150364_r, this.field_150527_b);
/*    */       
/* 32 */       for (int i = p_76484_4_; i <= p_76484_4_ + 2; i++) {
/* 33 */         int j = i - p_76484_4_;
/* 34 */         int k = 2 - j;
/* 35 */         for (int m = p_76484_3_ - k; m <= p_76484_3_ + k; m++) {
/* 36 */           int n = m - p_76484_3_;
/* 37 */           for (int i1 = p_76484_5_ - k; i1 <= p_76484_5_ + k; i1++) {
/* 38 */             int i2 = i1 - p_76484_5_;
/* 39 */             if ((Math.abs(n) != k || Math.abs(i2) != k || p_76484_2_.nextInt(2) != 0) && 
/* 40 */               !p_76484_1_.func_147439_a(m, i, i1).func_149730_j())
/* 41 */               func_150516_a(p_76484_1_, m, i, i1, (Block)Blocks.field_150362_t, this.field_150528_a); 
/*    */           } 
/*    */         } 
/*    */       } 
/*    */     } 
/* 46 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenShrub.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */