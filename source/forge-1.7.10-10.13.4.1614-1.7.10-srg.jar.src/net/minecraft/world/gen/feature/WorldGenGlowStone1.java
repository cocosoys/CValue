/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGenGlowStone1 extends WorldGenerator {
/*    */   private static final String __OBFID = "CL_00000419";
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/* 13 */     if (!p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_, p_76484_5_)) return false; 
/* 14 */     if (p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ + 1, p_76484_5_) != Blocks.field_150424_aL) return false; 
/* 15 */     p_76484_1_.func_147465_d(p_76484_3_, p_76484_4_, p_76484_5_, Blocks.field_150426_aN, 0, 2);
/*    */     
/* 17 */     for (byte b = 0; b < 'ל'; b++) {
/* 18 */       int i = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
/* 19 */       int j = p_76484_4_ - p_76484_2_.nextInt(12);
/* 20 */       int k = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
/* 21 */       if (p_76484_1_.func_147439_a(i, j, k).func_149688_o() == Material.field_151579_a) {
/*    */         
/* 23 */         byte b1 = 0;
/* 24 */         for (byte b2 = 0; b2 < 6; b2++) {
/* 25 */           Block block = null;
/* 26 */           if (b2 == 0) block = p_76484_1_.func_147439_a(i - 1, j, k); 
/* 27 */           if (b2 == 1) block = p_76484_1_.func_147439_a(i + 1, j, k); 
/* 28 */           if (b2 == 2) block = p_76484_1_.func_147439_a(i, j - 1, k); 
/* 29 */           if (b2 == 3) block = p_76484_1_.func_147439_a(i, j + 1, k); 
/* 30 */           if (b2 == 4) block = p_76484_1_.func_147439_a(i, j, k - 1); 
/* 31 */           if (b2 == 5) block = p_76484_1_.func_147439_a(i, j, k + 1);
/*    */           
/* 33 */           if (block == Blocks.field_150426_aN) b1++;
/*    */         
/*    */         } 
/* 36 */         if (b1 == 1) p_76484_1_.func_147465_d(i, j, k, Blocks.field_150426_aN, 0, 2); 
/*    */       } 
/*    */     } 
/* 39 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenGlowStone1.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */