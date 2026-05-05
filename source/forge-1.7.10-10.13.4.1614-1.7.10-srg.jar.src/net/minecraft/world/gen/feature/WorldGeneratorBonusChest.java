/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.inventory.IInventory;
/*    */ import net.minecraft.tileentity.TileEntityChest;
/*    */ import net.minecraft.util.WeightedRandomChestContent;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class WorldGeneratorBonusChest
/*    */   extends WorldGenerator {
/*    */   private final WeightedRandomChestContent[] field_76546_a;
/*    */   
/*    */   public WorldGeneratorBonusChest(WeightedRandomChestContent[] p_i2010_1_, int p_i2010_2_) {
/* 18 */     this.field_76546_a = p_i2010_1_;
/* 19 */     this.field_76545_b = p_i2010_2_;
/*    */   }
/*    */   private final int field_76545_b; private static final String __OBFID = "CL_00000403";
/*    */   
/*    */   public boolean func_76484_a(World p_76484_1_, Random p_76484_2_, int p_76484_3_, int p_76484_4_, int p_76484_5_) {
/*    */     Block block;
/* 25 */     while (((block = p_76484_1_.func_147439_a(p_76484_3_, p_76484_4_, p_76484_5_)).func_149688_o() == Material.field_151579_a || block.func_149688_o() == Material.field_151584_j) && p_76484_4_ > 1) {
/* 26 */       p_76484_4_--;
/*    */     }
/* 28 */     if (p_76484_4_ < 1) {
/* 29 */       return false;
/*    */     }
/* 31 */     p_76484_4_++;
/*    */     
/* 33 */     for (byte b = 0; b < 4; b++) {
/* 34 */       int i = p_76484_3_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
/* 35 */       int j = p_76484_4_ + p_76484_2_.nextInt(3) - p_76484_2_.nextInt(3);
/* 36 */       int k = p_76484_5_ + p_76484_2_.nextInt(4) - p_76484_2_.nextInt(4);
/* 37 */       if (p_76484_1_.func_147437_c(i, j, k) && World.func_147466_a((IBlockAccess)p_76484_1_, i, j - 1, k)) {
/* 38 */         p_76484_1_.func_147465_d(i, j, k, (Block)Blocks.field_150486_ae, 0, 2);
/* 39 */         TileEntityChest tileEntityChest = (TileEntityChest)p_76484_1_.func_147438_o(i, j, k);
/* 40 */         if (tileEntityChest != null && 
/* 41 */           tileEntityChest != null) WeightedRandomChestContent.func_76293_a(p_76484_2_, this.field_76546_a, (IInventory)tileEntityChest, this.field_76545_b);
/*    */         
/* 43 */         if (p_76484_1_.func_147437_c(i - 1, j, k) && World.func_147466_a((IBlockAccess)p_76484_1_, i - 1, j - 1, k)) {
/* 44 */           p_76484_1_.func_147465_d(i - 1, j, k, Blocks.field_150478_aa, 0, 2);
/*    */         }
/* 46 */         if (p_76484_1_.func_147437_c(i + 1, j, k) && World.func_147466_a((IBlockAccess)p_76484_1_, i - 1, j - 1, k)) {
/* 47 */           p_76484_1_.func_147465_d(i + 1, j, k, Blocks.field_150478_aa, 0, 2);
/*    */         }
/* 49 */         if (p_76484_1_.func_147437_c(i, j, k - 1) && World.func_147466_a((IBlockAccess)p_76484_1_, i - 1, j - 1, k)) {
/* 50 */           p_76484_1_.func_147465_d(i, j, k - 1, Blocks.field_150478_aa, 0, 2);
/*    */         }
/* 52 */         if (p_76484_1_.func_147437_c(i, j, k + 1) && World.func_147466_a((IBlockAccess)p_76484_1_, i - 1, j - 1, k)) {
/* 53 */           p_76484_1_.func_147465_d(i, j, k + 1, Blocks.field_150478_aa, 0, 2);
/*    */         }
/* 55 */         return true;
/*    */       } 
/*    */     } 
/*    */     
/* 59 */     return false;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGeneratorBonusChest.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */