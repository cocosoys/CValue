/*    */ package JinRyuu.DragonBC.common.Worlds;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.material.Material;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGenNamekTrees
/*    */   extends WorldGenerator
/*    */ {
/*    */   private final int minTreeHeight;
/*    */   private final boolean growVines;
/*    */   private final int metaWood;
/*    */   private final int metaLeaves;
/*    */   
/*    */   public WorldGenNamekTrees(boolean par1) {
/* 26 */     this(par1, 8, 0, 0, false);
/*    */   }
/*    */   
/*    */   public WorldGenNamekTrees(boolean par1, int par2, int par3, int par4, boolean par5) {
/* 30 */     super(par1);
/* 31 */     this.minTreeHeight = par2;
/* 32 */     this.metaWood = par3;
/* 33 */     this.metaLeaves = par4;
/* 34 */     this.growVines = par5;
/*    */   }
/*    */   
/*    */   public boolean func_76484_a(World world, Random rand, int i, int j, int k) {
/* 38 */     if (world.func_147437_c(i, j, k) && (world.func_147439_a(i, j - 1, k) == BlocksDBC.BlockNamekGrass || world.func_147439_a(i, j - 1, k) == BlocksDBC.BlockNamekDirt)) {
/*    */       
/* 40 */       setBlock(world, i + 0, j + 0, k + 0, BlocksDBC.BlockNamekLog);
/* 41 */       setBlock(world, i + 0, j + 1, k + 0, BlocksDBC.BlockNamekLog);
/* 42 */       setBlock(world, i + 0, j + 2, k + 0, BlocksDBC.BlockNamekLog);
/* 43 */       setBlock(world, i + 0, j + 3, k + 0, BlocksDBC.BlockNamekLog);
/* 44 */       setBlock(world, i + 0, j + 4, k + 0, BlocksDBC.BlockNamekLog);
/* 45 */       setBlock(world, i + 0, j + 5, k + 0, BlocksDBC.BlockNamekLog);
/* 46 */       setBlock(world, i - 1, j + 6, k + 1, BlocksDBC.BlockNamekLeaves);
/* 47 */       setBlock(world, i - 1, j + 6, k + 0, BlocksDBC.BlockNamekLeaves);
/* 48 */       setBlock(world, i - 1, j + 6, k - 1, BlocksDBC.BlockNamekLeaves);
/* 49 */       setBlock(world, i + 0, j + 6, k + 1, BlocksDBC.BlockNamekLeaves);
/* 50 */       setBlock(world, i + 0, j + 6, k + 0, BlocksDBC.BlockNamekLeaves);
/* 51 */       setBlock(world, i + 0, j + 6, k - 1, BlocksDBC.BlockNamekLeaves);
/* 52 */       setBlock(world, i + 1, j + 6, k + 1, BlocksDBC.BlockNamekLeaves);
/* 53 */       setBlock(world, i + 1, j + 6, k + 0, BlocksDBC.BlockNamekLeaves);
/* 54 */       setBlock(world, i + 1, j + 6, k - 1, BlocksDBC.BlockNamekLeaves);
/* 55 */       setBlock(world, i - 1, j + 7, k + 1, BlocksDBC.BlockNamekLeaves);
/* 56 */       setBlock(world, i - 1, j + 7, k + 0, BlocksDBC.BlockNamekLeaves);
/* 57 */       setBlock(world, i - 1, j + 7, k - 1, BlocksDBC.BlockNamekLeaves);
/* 58 */       setBlock(world, i + 0, j + 7, k + 1, BlocksDBC.BlockNamekLeaves);
/* 59 */       setBlock(world, i + 0, j + 7, k + 0, BlocksDBC.BlockNamekLeaves);
/* 60 */       setBlock(world, i + 0, j + 7, k - 1, BlocksDBC.BlockNamekLeaves);
/* 61 */       setBlock(world, i + 1, j + 7, k + 1, BlocksDBC.BlockNamekLeaves);
/* 62 */       setBlock(world, i + 1, j + 7, k + 0, BlocksDBC.BlockNamekLeaves);
/* 63 */       setBlock(world, i + 1, j + 7, k - 1, BlocksDBC.BlockNamekLeaves);
/* 64 */       setBlock(world, i - 1, j + 8, k + 1, BlocksDBC.BlockNamekLeaves);
/* 65 */       setBlock(world, i - 1, j + 8, k + 0, BlocksDBC.BlockNamekLeaves);
/* 66 */       setBlock(world, i - 1, j + 8, k - 1, BlocksDBC.BlockNamekLeaves);
/* 67 */       setBlock(world, i + 0, j + 8, k + 1, BlocksDBC.BlockNamekLeaves);
/* 68 */       setBlock(world, i + 0, j + 8, k + 0, BlocksDBC.BlockNamekLeaves);
/* 69 */       setBlock(world, i + 0, j + 8, k - 1, BlocksDBC.BlockNamekLeaves);
/* 70 */       setBlock(world, i + 1, j + 8, k + 1, BlocksDBC.BlockNamekLeaves);
/* 71 */       setBlock(world, i + 1, j + 8, k + 0, BlocksDBC.BlockNamekLeaves);
/* 72 */       setBlock(world, i + 1, j + 8, k - 1, BlocksDBC.BlockNamekLeaves);
/*    */     } 
/*    */     
/* 75 */     return true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void setBlock(World world, int i, int j, int k, Block b) {
/* 81 */     world.func_147449_b(i, j, k, b);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected boolean func_150523_a(Block p_150523_1_) {
/* 87 */     return (p_150523_1_.func_149688_o() == Material.field_151579_a || p_150523_1_.func_149688_o() == Material.field_151584_j || p_150523_1_ == BlocksDBC.BlockNamekGrass || p_150523_1_ == BlocksDBC.BlockNamekGrass || p_150523_1_ == BlocksDBC.BlockNamekLog || p_150523_1_ == BlocksDBC.BlockNamekLog || p_150523_1_ == Blocks.field_150345_g || p_150523_1_ == Blocks.field_150395_bd);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_150524_b(World p_150524_1_, Random p_150524_2_, int p_150524_3_, int p_150524_4_, int p_150524_5_) {}
/*    */   
/*    */   protected boolean isReplaceable(World world, int x, int y, int z) {
/* 94 */     Block block = world.func_147439_a(x, y, z);
/* 95 */     return (block.isAir((IBlockAccess)world, x, y, z) || block.isLeaves((IBlockAccess)world, x, y, z) || block.isWood((IBlockAccess)world, x, y, z) || func_150523_a(block));
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\WorldGenNamekTrees.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */