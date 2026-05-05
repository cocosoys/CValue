/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGenTallGrass
/*    */   extends WorldGenerator {
/*    */   private Block field_150522_a;
/*    */   private int field_76534_b;
/*    */   private static final String __OBFID = "CL_00000437";
/*    */   
/*    */   public WorldGenTallGrass(Block p_i45466_1_, int p_i45466_2_) {
/* 15 */     this.field_150522_a = p_i45466_1_;
/* 16 */     this.field_76534_b = p_i45466_2_;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/*    */     Block block;
/* 23 */     while (((block = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_)).func_149688_o() == Material.field_151579_a || block.func_149688_o() == Material.field_151584_j) && p_76484_4_ > 0) {
/* 24 */       p_76484_4_--;
/*    */     }
/* 26 */     for (byte b = 0; b < ''; b++) {
/* 27 */       int i = p_76484_3_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
/* 28 */       int j = p_76484_4_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
/* 29 */       int k = p_76484_5_ + p_76484_2_.nextInt(8) - p_76484_2_.nextInt(8);
/* 30 */       if (p_76484_1_.func_147437_c(i, j, k) && 
/* 31 */         this.field_150522_a.func_149718_j(p_76484_1_, i, j, k)) {
/* 32 */         p_76484_1_.func_147465_d(i, j, k, this.field_150522_a, this.field_76534_b, 2);
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenTallGrass.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */