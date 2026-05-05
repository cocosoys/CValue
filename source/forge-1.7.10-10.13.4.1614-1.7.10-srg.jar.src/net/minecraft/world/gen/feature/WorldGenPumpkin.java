/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGenPumpkin
/*    */   extends WorldGenerator {
/*    */   private static final String __OBFID = "CL_00000428";
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/* 12 */     for (byte b = 0; b < 64; b++) {
/* 13 */       int i = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
/* 14 */       int j = p_76484_4_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
/* 15 */       int k = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
/* 16 */       if (p_76484_1_.func_147437_c(i, j, k) && p_76484_1_.func_147439_a(i, j - 1, k) == Blocks.field_150349_c && 
/* 17 */         Blocks.field_150423_aK.func_149742_c(p_76484_1_, i, j, k)) {
/* 18 */         p_76484_1_.func_147465_d(i, j, k, Blocks.field_150423_aK, p_76484_2_.nextInt(4), 2);
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 23 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenPumpkin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */