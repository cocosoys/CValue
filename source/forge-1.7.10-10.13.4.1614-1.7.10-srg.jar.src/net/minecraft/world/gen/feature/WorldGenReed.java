/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGenReed
/*    */   extends WorldGenerator {
/*    */   private static final String __OBFID = "CL_00000429";
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/* 13 */     for (byte b = 0; b < 20; b++) {
/* 14 */       int i = p_76484_3_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
/* 15 */       int j = p_76484_4_;
/* 16 */       int k = p_76484_5_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
/* 17 */       if (p_76484_1_.func_147437_c(i, j, k) && (
/* 18 */         p_76484_1_.func_147439_a(i - 1, j - 1, k).func_149688_o() == Material.field_151586_h || p_76484_1_.func_147439_a(i + 1, j - 1, k).func_149688_o() == Material.field_151586_h || p_76484_1_.func_147439_a(i, j - 1, k - 1).func_149688_o() == Material.field_151586_h || p_76484_1_.func_147439_a(i, j - 1, k + 1).func_149688_o() == Material.field_151586_h)) {
/*    */ 
/*    */         
/* 21 */         int m = 2 + p_76484_2_.nextInt(p_76484_2_.nextInt(3) + 1);
/* 22 */         for (byte b1 = 0; b1 < m; b1++) {
/* 23 */           if (Blocks.field_150436_aH.func_149718_j(p_76484_1_, i, j + b1, k)) {
/* 24 */             p_76484_1_.func_147465_d(i, j + b1, k, Blocks.field_150436_aH, 0, 2);
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/*    */ 
/*    */     
/* 31 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenReed.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */