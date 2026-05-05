/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGenDeadBush
/*    */   extends WorldGenerator {
/*    */   private Block field_150547_a;
/*    */   private static final String __OBFID = "CL_00000406";
/*    */   
/*    */   public WorldGenDeadBush(Block p_i45451_1_) {
/* 14 */     this.field_150547_a = p_i45451_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/*    */     Block block;
/* 20 */     while (((block = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_)).func_149688_o() == Material.field_151579_a || block.func_149688_o() == Material.field_151584_j) && p_76484_4_ > 0) {
/* 21 */       p_76484_4_--;
/*    */     }
/* 23 */     for (byte b = 0; b < 4; b++) {
/* 24 */       int i = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
/* 25 */       int j = p_76484_4_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
/* 26 */       int k = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
/* 27 */       if (p_76484_1_.func_147437_c(i, j, k) && 
/* 28 */         this.field_150547_a.func_149718_j(p_76484_1_, i, j, k)) {
/* 29 */         p_76484_1_.func_147465_d(i, j, k, this.field_150547_a, 0, 2);
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenDeadBush.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */