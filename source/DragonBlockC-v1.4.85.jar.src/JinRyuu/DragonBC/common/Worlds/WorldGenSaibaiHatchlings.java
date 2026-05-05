/*    */ package JinRyuu.DragonBC.common.Worlds;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*    */ import JinRyuu.DragonBC.common.Npcs.EntitySaibaiman;
/*    */ import java.util.Random;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGenSaibaiHatchlings
/*    */   extends WorldGenerator
/*    */ {
/*    */   public boolean func_76484_a(World par1World, Random par2Random, int par3, int par4, int par5) {
/* 16 */     for (int var6 = 0; var6 < 1; var6++) {
/*    */       
/* 18 */       int var7 = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
/* 19 */       int var8 = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
/* 20 */       int var9 = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);
/*    */ 
/*    */       
/* 23 */       if (par1World.func_147437_c(var7, var8, var9) && par1World.func_147439_a(var7, var8 - 1, var9) == BlocksDBC.BlockNamekDirt && BlocksDBC.SaibaiHatched.func_149742_c(par1World, var7, var8, var9)) {
/*    */         
/* 25 */         par1World.func_147465_d(var7, var8 - 1, var9, BlocksDBC.SaibaiHatched, 1, 4);
/*    */         
/* 27 */         EntitySaibaiman Saibaiman = new EntitySaibaiman(par1World);
/* 28 */         Saibaiman.func_70012_b(var7, var8, var9, 0.0F, 0.0F);
/*    */         
/* 30 */         par1World.func_72838_d((Entity)Saibaiman);
/*    */       } 
/*    */     } 
/* 33 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\WorldGenSaibaiHatchlings.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */