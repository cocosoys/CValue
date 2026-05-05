/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGenHellLava extends WorldGenerator {
/*    */   private Block field_150553_a;
/*    */   private boolean field_94524_b;
/*    */   private static final String __OBFID = "CL_00000414";
/*    */   
/*    */   public WorldGenHellLava(Block p_i45453_1_, boolean p_i45453_2_) {
/* 15 */     this.field_150553_a = p_i45453_1_;
/* 16 */     this.field_94524_b = p_i45453_2_;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/* 21 */     if (p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ + 1, p_76484_5_) != Blocks.field_150424_aL) return false; 
/* 22 */     if (p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_).func_149688_o() != Material.field_151579_a && p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_) != Blocks.field_150424_aL) return false;
/*    */     
/* 24 */     byte b1 = 0;
/* 25 */     if (p_76484_1_.func_147439_a(p_76484_3_ - 1, p_76484_4_, p_76484_5_) == Blocks.field_150424_aL) b1++; 
/* 26 */     if (p_76484_1_.func_147439_a(p_76484_3_ + 1, p_76484_4_, p_76484_5_) == Blocks.field_150424_aL) b1++; 
/* 27 */     if (p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_ - 1) == Blocks.field_150424_aL) b1++; 
/* 28 */     if (p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_ + 1) == Blocks.field_150424_aL) b1++; 
/* 29 */     if (p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_ - 1, p_76484_5_) == Blocks.field_150424_aL) b1++;
/*    */     
/* 31 */     byte b2 = 0;
/* 32 */     if (p_76484_1_.func_147437_c(p_76484_3_ - 1, p_76484_4_, p_76484_5_)) b2++; 
/* 33 */     if (p_76484_1_.func_147437_c(p_76484_3_ + 1, p_76484_4_, p_76484_5_)) b2++; 
/* 34 */     if (p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_, p_76484_5_ - 1)) b2++; 
/* 35 */     if (p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_, p_76484_5_ + 1)) b2++; 
/* 36 */     if (p_76484_1_.func_147437_c(p_76484_3_, p_76484_4_ - 1, p_76484_5_)) b2++;
/*    */     
/* 38 */     if ((!this.field_94524_b && b1 == 4 && b2 == 1) || b1 == 5) {
/* 39 */       p_76484_1_.func_147465_d(p_76484_3_, p_76484_4_, p_76484_5_, this.field_150553_a, 0, 2);
/* 40 */       p_76484_1_.field_72999_e = true;
/* 41 */       this.field_150553_a.func_149674_a(p_76484_1_, p_76484_3_, p_76484_4_, p_76484_5_, p_76484_2_);
/* 42 */       p_76484_1_.field_72999_e = false;
/*    */     } 
/*    */     
/* 45 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenHellLava.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */