/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGenBlockBlob extends WorldGenerator {
/*    */   private Block field_150545_a;
/*    */   private int field_150544_b;
/*    */   private static final String __OBFID = "CL_00000402";
/*    */   
/*    */   public WorldGenBlockBlob(Block p_i45450_1_, int p_i45450_2_) {
/* 14 */     super(false);
/* 15 */     this.field_150545_a = p_i45450_1_;
/* 16 */     this.field_150544_b = p_i45450_2_;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/* 21 */     while (p_76484_4_ > 3) {
/* 22 */       if (!p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_ - 1, p_76484_5_)) {
/* 23 */         Block block = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_);
/* 24 */         if (block == Blocks.field_150349_c || block == Blocks.field_150346_d || block == Blocks.field_150348_b) {
/*    */           break;
/*    */         }
/*    */       } 
/* 28 */       p_76484_4_--;
/*    */     } 
/* 30 */     if (p_76484_4_ <= 3) {
/* 31 */       return false;
/*    */     }
/*    */     
/* 34 */     int i = this.field_150544_b;
/* 35 */     byte b = 0;
/* 36 */     while (i >= 0 && b < 3) {
/*    */       
/* 38 */       int j = i + p_76484_2_.nextInt(2);
/* 39 */       int k = i + p_76484_2_.nextInt(2);
/* 40 */       int m = i + p_76484_2_.nextInt(2);
/* 41 */       float f = (j + k + m) * 0.333F + 0.5F;
/* 42 */       for (int n = p_76484_3_ - j; n <= p_76484_3_ + j; n++) {
/* 43 */         for (int i1 = p_76484_5_ - m; i1 <= p_76484_5_ + m; i1++) {
/* 44 */           for (int i2 = p_76484_4_ - k; i2 <= p_76484_4_ + k; i2++) {
/* 45 */             float f1 = (n - p_76484_3_);
/* 46 */             float f2 = (i1 - p_76484_5_);
/* 47 */             float f3 = (i2 - p_76484_4_);
/* 48 */             if (f1 * f1 + f2 * f2 + f3 * f3 <= f * f)
/*    */             {
/* 50 */               p_76484_1_.func_147465_d(n, i2, i1, this.field_150545_a, 0, 4);
/*    */             }
/*    */           } 
/*    */         } 
/*    */       } 
/* 55 */       p_76484_3_ += -(i + 1) + p_76484_2_.nextInt(2 + i * 2);
/* 56 */       p_76484_5_ += -(i + 1) + p_76484_2_.nextInt(2 + i * 2);
/* 57 */       p_76484_4_ += 0 - p_76484_2_.nextInt(2);
/* 58 */       b++;
/*    */     } 
/*    */     
/* 61 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenBlockBlob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */