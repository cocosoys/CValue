/*    */ package JinRyuu.DragonBC.common.Worlds;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*    */ import java.util.Random;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ public class WorldGenNamekMedMoss
/*    */   extends WorldGenerator {
/*    */   public WorldGenNamekMedMoss(boolean doBlockNotify) {
/* 11 */     super(doBlockNotify);
/*    */   }
/*    */   
/*    */   public boolean func_76484_a(World world, Random rand, int i, int j, int k) {
/* 15 */     if (world.func_147437_c(i, j, k) && world.func_147439_a(i, j - 1, k) == BlocksDBC.BlockNamekGrass) {
/* 16 */       func_150515_a(world, i + 0, j + 0, k + 0, BlocksDBC.BlockWildMedMoss);
/*    */     }
/*    */     
/* 19 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\WorldGenNamekMedMoss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */