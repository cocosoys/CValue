/*    */ package net.minecraft.block;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class BlockStaticLiquid extends BlockLiquid {
/*    */   protected BlockStaticLiquid(Material p_i45429_1_) {
/* 10 */     super(p_i45429_1_);
/*    */     
/* 12 */     func_149675_a(false);
/* 13 */     if (p_i45429_1_ == Material.field_151587_i) func_149675_a(true);
/*    */   
/*    */   }
/*    */   
/*    */   public void func_149695_a(World p_149695_1_, int p_149695_2_, int p_149695_3_, int p_149695_4_, Block p_149695_5_) {
/* 18 */     super.func_149695_a(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_, p_149695_5_);
/* 19 */     if (p_149695_1_.func_147439_a(p_149695_2_, p_149695_3_, p_149695_4_) == this)
/* 20 */       func_149818_n(p_149695_1_, p_149695_2_, p_149695_3_, p_149695_4_); 
/*    */   }
/*    */   private static final String __OBFID = "CL_00000315";
/*    */   
/*    */   private void func_149818_n(World p_149818_1_, int p_149818_2_, int p_149818_3_, int p_149818_4_) {
/* 25 */     int i = p_149818_1_.func_72805_g(p_149818_2_, p_149818_3_, p_149818_4_);
/*    */     
/* 27 */     p_149818_1_.func_147465_d(p_149818_2_, p_149818_3_, p_149818_4_, Block.func_149729_e(Block.func_149682_b(this) - 1), i, 2);
/* 28 */     p_149818_1_.func_147464_a(p_149818_2_, p_149818_3_, p_149818_4_, Block.func_149729_e(Block.func_149682_b(this) - 1), func_149738_a(p_149818_1_));
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_149674_a(World p_149674_1_, int p_149674_2_, int p_149674_3_, int p_149674_4_, Random p_149674_5_) {
/* 33 */     if (this.field_149764_J == Material.field_151587_i) {
/* 34 */       int i = p_149674_5_.nextInt(3); int j;
/* 35 */       for (j = 0; j < i; j++) {
/* 36 */         p_149674_2_ += p_149674_5_.nextInt(3) - 1;
/* 37 */         p_149674_3_++;
/* 38 */         p_149674_4_ += p_149674_5_.nextInt(3) - 1;
/* 39 */         Block block = p_149674_1_.func_147439_a(p_149674_2_, p_149674_3_, p_149674_4_);
/* 40 */         if (block.field_149764_J == Material.field_151579_a) {
/* 41 */           if (func_149817_o(p_149674_1_, p_149674_2_ - 1, p_149674_3_, p_149674_4_) || func_149817_o(p_149674_1_, p_149674_2_ + 1, p_149674_3_, p_149674_4_) || func_149817_o(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_ - 1) || func_149817_o(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_ + 1) || func_149817_o(p_149674_1_, p_149674_2_, p_149674_3_ - 1, p_149674_4_) || func_149817_o(p_149674_1_, p_149674_2_, p_149674_3_ + 1, p_149674_4_)) {
/* 42 */             p_149674_1_.func_147449_b(p_149674_2_, p_149674_3_, p_149674_4_, Blocks.field_150480_ab);
/*    */             return;
/*    */           } 
/* 45 */         } else if (block.field_149764_J.func_76230_c()) {
/*    */           return;
/*    */         } 
/*    */       } 
/* 49 */       if (i == 0) {
/* 50 */         j = p_149674_2_;
/* 51 */         int k = p_149674_4_;
/* 52 */         for (byte b = 0; b < 3; b++) {
/* 53 */           p_149674_2_ = j + p_149674_5_.nextInt(3) - 1;
/* 54 */           p_149674_4_ = k + p_149674_5_.nextInt(3) - 1;
/* 55 */           if (p_149674_1_.func_147437_c(p_149674_2_, p_149674_3_ + 1, p_149674_4_) && func_149817_o(p_149674_1_, p_149674_2_, p_149674_3_, p_149674_4_)) {
/* 56 */             p_149674_1_.func_147449_b(p_149674_2_, p_149674_3_ + 1, p_149674_4_, Blocks.field_150480_ab);
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   private boolean func_149817_o(World p_149817_1_, int p_149817_2_, int p_149817_3_, int p_149817_4_) {
/* 64 */     return p_149817_1_.func_147439_a(p_149817_2_, p_149817_3_, p_149817_4_).func_149688_o().func_76217_h();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\block\BlockStaticLiquid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */