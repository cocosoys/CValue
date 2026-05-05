/*    */ package JinRyuu.DragonBC.common.Blocks.m;
/*    */ 
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.block.BlockStairs;
/*    */ import net.minecraft.world.IBlockAccess;
/*    */ import net.minecraftforge.common.util.ForgeDirection;
/*    */ 
/*    */ public class MyWoodStairs
/*    */   extends BlockStairs
/*    */ {
/*    */   protected MyWoodStairs(Block sakuraStairs, int meta) {
/* 12 */     super(ModdedBlocks.SakuraPlank, meta);
/* 13 */     this.field_149783_u = true;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public int getFireSpreadSpeed(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
/* 19 */     return 40;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getFlammability(IBlockAccess world, int x, int y, int z, ForgeDirection face) {
/* 24 */     return 5;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\m\MyWoodStairs.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */