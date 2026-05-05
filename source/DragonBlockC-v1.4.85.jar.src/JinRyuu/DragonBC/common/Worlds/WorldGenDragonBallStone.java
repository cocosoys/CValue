/*    */ package JinRyuu.DragonBC.common.Worlds;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*    */ import java.util.Random;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGenDragonBallStone
/*    */   extends WorldGenerator
/*    */ {
/*    */   public boolean func_76484_a(World par1World, Random par2Random, int par3, int par4, int par5) {
/* 18 */     int var7 = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
/* 19 */     int var8 = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
/* 20 */     int var9 = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);
/*    */ 
/*    */     
/* 23 */     if (par1World.func_147437_c(var7, var8, var9) && par1World.func_147439_a(var7, var8 - 1, var9) == Blocks.field_150349_c && BlocksDBC.BlockDragonBallStone.func_149742_c(par1World, var7, var8, var9))
/*    */     {
/* 25 */       par1World.func_147465_d(var7, var8, var9, BlocksDBC.BlockDragonBallStone, 10, 4);
/*    */     }
/*    */     
/* 28 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\WorldGenDragonBallStone.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */