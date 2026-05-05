/*    */ package net.minecraft.world.gen.feature;
/*    */ 
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public abstract class WorldGenAbstractTree extends WorldGenerator {
/*    */   private static final String __OBFID = "CL_00000399";
/*    */   
/*    */   public WorldGenAbstractTree(boolean p_i45448_1_) {
/* 13 */     super(p_i45448_1_);
/*    */   }
/*    */   
/*    */   protected boolean func_150523_a(Block p_150523_1_) {
/* 17 */     return (p_150523_1_.func_149688_o() == Material.field_151579_a || p_150523_1_.func_149688_o() == Material.field_151584_j || p_150523_1_ == Blocks.field_150349_c || p_150523_1_ == Blocks.field_150346_d || p_150523_1_ == Blocks.field_150364_r || p_150523_1_ == Blocks.field_150363_s || p_150523_1_ == Blocks.field_150345_g || p_150523_1_ == Blocks.field_150395_bd);
/*    */   }
/*    */   
/*    */   public void func_150524_b(World p_150524_1_, Random p_150524_2_, int p_150524_3_, int p_150524_4_, int p_150524_5_) {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\world\gen\feature\WorldGenAbstractTree.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */