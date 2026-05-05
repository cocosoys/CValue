/*    */ package JinRyuu.DragonBC.common.Blocks;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import JinRyuu.JRMCore.blocks.BlockJRMCCrops;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockWildMedMoss
/*    */   extends BlockJRMCCrops
/*    */ {
/*    */   public BlockWildMedMoss() {
/* 22 */     this.maxGrowthStage = 1;
/* 23 */     func_149658_d(JRMCoreH.tjdbcAssts + ":BlockCropMedMoss2");
/*    */   }
/*    */ 
/*    */   
/*    */   protected boolean func_149854_a(Block parBlock) {
/* 28 */     return (parBlock == Blocks.field_150349_c || parBlock == BlocksDBC.BlockNamekGrass);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int quantityDropped(int parMetadata, int parFortune, Random parRand) {
/* 38 */     return parRand.nextInt(2) + 1;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Item func_149650_a(int parMetadata, Random parRand, int parFortune) {
/* 46 */     return ItemsDBC.ItemMedMoss;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister parIIconRegister) {
/* 53 */     this.iIcon = new net.minecraft.util.IIcon[this.maxGrowthStage + 1];
/*    */ 
/*    */     
/* 56 */     this.iIcon[0] = parIIconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":BlockCropMedMoss2");
/* 57 */     this.iIcon[1] = parIIconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":BlockCropMedMoss3");
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlockWildMedMoss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */