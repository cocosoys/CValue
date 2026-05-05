/*    */ package JinRyuu.DragonBC.common.Worlds;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*    */ import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier1;
/*    */ import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier2;
/*    */ import JinRyuu.DragonBC.common.Npcs.EntityFreezaSoldier3;
/*    */ import java.util.Random;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.world.World;
/*    */ import net.minecraft.world.gen.feature.WorldGenerator;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class WorldGenFreezaSoldiers
/*    */   extends WorldGenerator
/*    */ {
/*    */   public boolean func_76484_a(World par1World, Random par2Random, int par3, int par4, int par5) {
/* 18 */     for (int var6 = 0; var6 < 1; var6++) {
/*    */       
/* 20 */       int var7 = par3 + par2Random.nextInt(8) - par2Random.nextInt(8);
/* 21 */       int var8 = par4 + par2Random.nextInt(4) - par2Random.nextInt(4);
/* 22 */       int var9 = par5 + par2Random.nextInt(8) - par2Random.nextInt(8);
/*    */       
/* 24 */       if (par1World.func_147437_c(var7, var8, var9) && par1World.func_147439_a(var7, var8 - 1, var9) == BlocksDBC.BlockNamekGrass) {
/*    */ 
/*    */ 
/*    */         
/* 28 */         EntityFreezaSoldier1 Soldier1 = new EntityFreezaSoldier1(par1World);
/* 29 */         EntityFreezaSoldier2 Soldier2 = new EntityFreezaSoldier2(par1World);
/* 30 */         EntityFreezaSoldier3 Soldier3 = new EntityFreezaSoldier3(par1World);
/* 31 */         Soldier1.func_70012_b(var7, var8 + 3.0D, var9, 0.0F, 0.0F);
/* 32 */         Soldier2.func_70012_b(var7, var8 + 3.0D, var9 + 1.0D, 0.0F, 0.0F);
/* 33 */         Soldier3.func_70012_b(var7 + 1.0D, var8 + 3.0D, var9, 0.0F, 0.0F);
/* 34 */         Soldier1.setSpwner((Entity)Soldier1);
/* 35 */         Soldier2.setSpwner((Entity)Soldier2);
/* 36 */         Soldier3.setSpwner((Entity)Soldier3);
/* 37 */         par1World.func_72838_d((Entity)Soldier1);
/* 38 */         par1World.func_72838_d((Entity)Soldier2);
/* 39 */         par1World.func_72838_d((Entity)Soldier3);
/*    */       } 
/*    */     } 
/* 42 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Worlds\WorldGenFreezaSoldiers.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */