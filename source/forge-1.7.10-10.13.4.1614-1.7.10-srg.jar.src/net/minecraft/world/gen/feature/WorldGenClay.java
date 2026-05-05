/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGenClay extends WorldGenerator {
/*    */   private Block field_150546_a;
/*    */   private int field_76517_b;
/*    */   private static final String __OBFID = "CL_00000405";
/*    */   
/*    */   public WorldGenClay(int p_i2011_1_) {
/* 15 */     this.field_150546_a = Blocks.field_150435_aG;
/* 16 */     this.field_76517_b = p_i2011_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/* 21 */     if (p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_).func_149688_o() != Material.field_151586_h) return false; 
/* 22 */     int i = p_76484_2_.nextInt(this.field_76517_b - 2) + 2;
/* 23 */     byte b = 1;
/* 24 */     for (int j = p_76484_3_ - i; j <= p_76484_3_ + i; j++) {
/* 25 */       for (int k = p_76484_5_ - i; k <= p_76484_5_ + i; k++) {
/* 26 */         int m = j - p_76484_3_;
/* 27 */         int n = k - p_76484_5_;
/* 28 */         if (m * m + n * n <= i * i) {
/* 29 */           for (int i1 = p_76484_4_ - b; i1 <= p_76484_4_ + b; i1++) {
/* 30 */             Block block = p_76484_1_.func_147439_a(j, i1, k);
/* 31 */             if (block == Blocks.field_150346_d || block == Blocks.field_150435_aG) {
/* 32 */               p_76484_1_.func_147465_d(j, i1, k, this.field_150546_a, 0, 2);
/*    */             }
/*    */           } 
/*    */         }
/*    */       } 
/*    */     } 
/* 38 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenClay.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */