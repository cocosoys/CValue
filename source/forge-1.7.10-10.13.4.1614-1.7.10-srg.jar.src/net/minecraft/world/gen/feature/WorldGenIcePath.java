/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGenIcePath extends WorldGenerator {
/*    */   private Block field_150555_a;
/*    */   private int field_150554_b;
/*    */   private static final String __OBFID = "CL_00000416";
/*    */   
/*    */   public WorldGenIcePath(int p_i45454_1_) {
/* 14 */     this.field_150555_a = Blocks.field_150403_cj;
/* 15 */     this.field_150554_b = p_i45454_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/* 20 */     while (p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_, p_76484_5_) && p_76484_4_ > 2) {
/* 21 */       p_76484_4_--;
/*    */     }
/* 23 */     if (p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_) != Blocks.field_150433_aE) {
/* 24 */       return false;
/*    */     }
/* 26 */     int i = p_76484_2_.nextInt(this.field_150554_b - 2) + 2;
/* 27 */     byte b = 1;
/* 28 */     for (int j = p_76484_3_ - i; j <= p_76484_3_ + i; j++) {
/* 29 */       for (int k = p_76484_5_ - i; k <= p_76484_5_ + i; k++) {
/* 30 */         int m = j - p_76484_3_;
/* 31 */         int n = k - p_76484_5_;
/* 32 */         if (m * m + n * n <= i * i) {
/* 33 */           for (int i1 = p_76484_4_ - b; i1 <= p_76484_4_ + b; i1++) {
/* 34 */             Block block = p_76484_1_.func_147439_a(j, i1, k);
/* 35 */             if (block == Blocks.field_150346_d || block == Blocks.field_150433_aE || block == Blocks.field_150432_aD) {
/* 36 */               p_76484_1_.func_147465_d(j, i1, k, this.field_150555_a, 0, 2);
/*    */             }
/*    */           } 
/*    */         }
/*    */       } 
/*    */     } 
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenIcePath.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */