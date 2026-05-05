/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class WorldGenWaterlily
/*    */   extends WorldGenerator
/*    */ {
/*    */   private static final String __OBFID = "CL_00000189";
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/* 14 */     for (byte b = 0; b < 10; b++) {
/* 15 */       int i = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
/* 16 */       int j = p_76484_4_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
/* 17 */       int k = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
/* 18 */       if (p_76484_1_.func_147437_c(i, j, k) && 
/* 19 */         Blocks.field_150392_bi.func_149742_c(p_76484_1_, i, j, k)) {
/* 20 */         p_76484_1_.func_147465_d(i, j, k, Blocks.field_150392_bi, 0, 2);
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 25 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenWaterlily.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */