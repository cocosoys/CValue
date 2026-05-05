/*    */ package net.minecraft.block;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenBigMushroom;
/*    */ 
/*    */ public class BlockMushroom extends BlockBush implements IGrowable {
/*    */   protected BlockMushroom() {
/* 10 */     float f = 0.2F;
/* 11 */     func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
/* 12 */     func_149675_a(true);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000272";
/*    */   
/*    */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/* 17 */     if (p_149674_5_.nextInt(25) == 0) {
/* 18 */       byte b1 = 4;
/* 19 */       byte b2 = 5; int i;
/* 20 */       for (i = p_149674_2_ - b1; i <= p_149674_2_ + b1; i++) {
/* 21 */         for (int m = p_149674_4_ - b1; m <= p_149674_4_ + b1; m++) {
/* 22 */           for (int n = p_149674_3_ - 1; n <= p_149674_3_ + 1; n++)
/* 23 */           { if (p_149674_1_.func_147439_a(i, n, m) == this && --b2 <= 0)
/*    */               return;  } 
/*    */         } 
/* 26 */       }  i = p_149674_2_ + p_149674_5_.nextInt(3) - 1;
/* 27 */       int j = p_149674_3_ + p_149674_5_.nextInt(2) - p_149674_5_.nextInt(2);
/* 28 */       int k = p_149674_4_ + p_149674_5_.nextInt(3) - 1;
/* 29 */       for (byte b3 = 0; b3 < 4; b3++) {
/* 30 */         if (p_149674_1_.func_147437_c(i, j, k) && func_149718_j(p_149674_1_, i, j, k)) {
/* 31 */           p_149674_2_ = i;
/* 32 */           p_149674_3_ = j;
/* 33 */           p_149674_4_ = k;
/*    */         } 
/* 35 */         i = p_149674_2_ + p_149674_5_.nextInt(3) - 1;
/* 36 */         j = p_149674_3_ + p_149674_5_.nextInt(2) - p_149674_5_.nextInt(2);
/* 37 */         k = p_149674_4_ + p_149674_5_.nextInt(3) - 1;
/*    */       } 
/*    */       
/* 40 */       if (p_149674_1_.func_147437_c(i, j, k) && func_149718_j(p_149674_1_, i, j, k)) {
/* 41 */         p_149674_1_.func_147465_d(i, j, k, this, 0, 2);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_149742_c(World p_149742_1_, int p_149742_2_, int p_149742_3_, int p_149742_4_) {
/* 48 */     return (super.func_149742_c(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_) && func_149718_j(p_149742_1_, p_149742_2_, p_149742_3_, p_149742_4_));
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean func_149854_a(Block p_149854_1_) {
/* 53 */     return p_149854_1_.func_149730_j();
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_149718_j(World p_149718_1_, int p_149718_2_, int p_149718_3_, int p_149718_4_) {
/* 58 */     if (p_149718_3_ < 0 || p_149718_3_ >= 256) return false;
/*    */     
/* 60 */     Block block = p_149718_1_.func_147439_a(p_149718_2_, p_149718_3_ - 1, p_149718_4_);
/*    */     
/* 62 */     return (block == Blocks.field_150391_bh || (block == Blocks.field_150346_d && p_149718_1_.func_72805_g(p_149718_2_, p_149718_3_ - 1, p_149718_4_) == 2) || (p_149718_1_.func_72883_k(p_149718_2_, p_149718_3_, p_149718_4_) < 13 && func_149854_a(block)));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean func_149884_c(World p_149884_1_, int p_149884_2_, int p_149884_3_, int p_149884_4_, Random p_149884_5_) {
/* 68 */     int i = p_149884_1_.func_72805_g(p_149884_2_, p_149884_3_, p_149884_4_);
/*    */     
/* 70 */     p_149884_1_.func_147468_f(p_149884_2_, p_149884_3_, p_149884_4_);
/* 71 */     WorldGenBigMushroom worldGenBigMushroom = null;
/*    */     
/* 73 */     if (this == Blocks.field_150338_P) {
/* 74 */       worldGenBigMushroom = new WorldGenBigMushroom(0);
/* 75 */     } else if (this == Blocks.field_150337_Q) {
/* 76 */       worldGenBigMushroom = new WorldGenBigMushroom(1);
/*    */     } 
/*    */     
/* 79 */     if (worldGenBigMushroom == null || !worldGenBigMushroom.func_76484_a(p_149884_1_, p_149884_5_, p_149884_2_, p_149884_3_, p_149884_4_)) {
/* 80 */       p_149884_1_.func_147465_d(p_149884_2_, p_149884_3_, p_149884_4_, this, i, 3);
/* 81 */       return false;
/*    */     } 
/* 83 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_149851_a(World p_149851_1_, int p_149851_2_, int p_149851_3_, int p_149851_4_, boolean p_149851_5_) {
/* 88 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_149852_a(World p_149852_1_, Random p_149852_2_, int p_149852_3_, int p_149852_4_, int p_149852_5_) {
/* 93 */     return (p_149852_2_.nextFloat() < 0.4D);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149853_b(World p_149853_1_, Random p_149853_2_, int p_149853_3_, int p_149853_4_, int p_149853_5_) {
/* 98 */     func_149884_c(p_149853_1_, p_149853_3_, p_149853_4_, p_149853_5_, p_149853_2_);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockMushroom.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */