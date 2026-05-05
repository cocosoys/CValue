/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.item.EntityEnderCrystal;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGenSpikes extends WorldGenerator {
/*    */   private Block field_150520_a;
/*    */   private static final String __OBFID = "CL_00000433";
/*    */   
/*    */   public WorldGenSpikes(Block p_i45464_1_) {
/* 15 */     this.field_150520_a = p_i45464_1_;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/* 20 */     if (!p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_, p_76484_5_) || p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_) != this.field_150520_a) {
/* 21 */       return false;
/*    */     }
/* 23 */     int i = p_76484_2_.nextInt(32) + 6;
/* 24 */     int j = p_76484_2_.nextInt(4) + 1; int k;
/* 25 */     for (k = p_76484_3_ - j; k <= p_76484_3_ + j; k++) {
/* 26 */       for (int m = p_76484_5_ - j; m <= p_76484_5_ + j; m++) {
/* 27 */         int n = k - p_76484_3_;
/* 28 */         int i1 = m - p_76484_5_;
/* 29 */         if (n * n + i1 * i1 <= j * j + 1 && 
/* 30 */           p_76484_1_.func_147439_a(k, p_76484_4_ - 1, m) != this.field_150520_a) return false; 
/*    */       } 
/*    */     } 
/* 33 */     for (k = p_76484_4_; k < p_76484_4_ + i && 
/* 34 */       k < 256; k++) {
/* 35 */       for (int m = p_76484_3_ - j; m <= p_76484_3_ + j; m++) {
/* 36 */         for (int n = p_76484_5_ - j; n <= p_76484_5_ + j; n++) {
/* 37 */           int i1 = m - p_76484_3_;
/* 38 */           int i2 = n - p_76484_5_;
/* 39 */           if (i1 * i1 + i2 * i2 <= j * j + 1) {
/* 40 */             p_76484_1_.func_147465_d(m, k, n, Blocks.field_150343_Z, 0, 2);
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 46 */     EntityEnderCrystal entityEnderCrystal = new EntityEnderCrystal(p_76484_1_);
/* 47 */     entityEnderCrystal.func_70012_b((p_76484_3_ + 0.5F), (p_76484_4_ + i), (p_76484_5_ + 0.5F), p_76484_2_.nextFloat() * 360.0F, 0.0F);
/* 48 */     p_76484_1_.func_72838_d((Entity)entityEnderCrystal);
/* 49 */     p_76484_1_.func_147465_d(p_76484_3_, p_76484_4_ + i, p_76484_5_, Blocks.field_150357_h, 0, 2);
/*    */     
/* 51 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenSpikes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */