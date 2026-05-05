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
/*    */ public class WorldGenOWTrees
/*    */   extends WorldGenerator
/*    */ {
/*    */   private final int minTreeHeight;
/*    */   private final boolean growVines;
/*    */   private final int metaWood;
/*    */   private final int metaLeaves;
/*    */   
/*    */   public WorldGenOWTrees(boolean par1) {
/* 26 */     this(par1, 8, 0, 0, false);
/*    */   }
/*    */   
/*    */   public WorldGenOWTrees(boolean par1, int par2, int par3, int par4, boolean par5) {
/* 30 */     super(par1);
/* 31 */     this.minTreeHeight = par2;
/* 32 */     this.metaWood = par3;
/* 33 */     this.metaLeaves = par4;
/* 34 */     this.growVines = par5;
/*    */   }
/*    */   
/*    */   public boolean func_76484_a(World world, Random rand, int i, int j, int k) {
/* 38 */     int height = 4 + rand.nextInt(4);
/* 39 */     int sizex = 3 + rand.nextInt(5);
/* 40 */     int sizez = 3 + rand.nextInt(5);
/* 41 */     int sxh = sizex / 2;
/* 42 */     int szh = sizez / 2;
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 47 */     if (world.func_147437_c(i, j, k) && !world.func_147437_c(i, j - 1, k)) {
/*    */       
/* 49 */       int sizey = 4 + rand.nextInt(4);
/* 50 */       for (int i2 = 0; i2 < sizex; i2++) {
/* 51 */         for (int j2 = 0; j2 < sizez; j2++) {
/* 52 */           for (int m = 0; m < sizey; m++) {
/* 53 */             setBlock(world, i + i2 - sxh, j + height - 3 + m, k + j2 - szh, (Block)Blocks.field_150362_t);
/*    */           }
/*    */         } 
/*    */       } 
/* 57 */       for (int k2 = 0; k2 < height; k2++) {
/* 58 */         setBlock(world, i + 0, j + k2, k + 0, Blocks.field_150364_r);
/*    */       }
/*    */     } 
/*    */     
/* 62 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   private void setBlock(World world, int i, int j, int k, Block b) {
/* 67 */     if (world.func_72904_c(i, j, k, i, j, k))
/*    */     {
/* 69 */       func_150516_a(world, i, j, k, b, 0);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean func_150523_a(Block p_150523_1_) {
/* 75 */     return (p_150523_1_.func_149688_o() == Material.field_151579_a || p_150523_1_.func_149688_o() == Material.field_151584_j || p_150523_1_ == BlocksDBC.BlockNamekGrass || p_150523_1_ == BlocksDBC.BlockNamekGrass || p_150523_1_ == BlocksDBC.BlockNamekLog || p_150523_1_ == BlocksDBC.BlockNamekLog || p_150523_1_ == Blocks.field_150345_g || p_150523_1_ == Blocks.field_150395_bd);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_150524_b(World p_150524_1_, Random p_150524_2_, int p_150524_3_, int p_150524_4_, int p_150524_5_) {}
/*    */   
/*    */   protected boolean isReplaceable(World world, int x, int y, int z) {
/* 82 */     Block block = world.func_147439_a(x, y, z);
/* 83 */     return (block.isAir((IBlockAccess)world, x, y, z) || block.isLeaves((IBlockAccess)world, x, y, z) || block.isWood((IBlockAccess)world, x, y, z) || func_150523_a(block));
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\WorldGenOWTrees.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */