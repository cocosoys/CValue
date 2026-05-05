/*    */ package JinRyuu.DragonBC.common.Blocks;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import JinRyuu.JRMCore.blocks.BlockJRMCCrops;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class BlockCropMedMoss
/*    */   extends BlockJRMCCrops
/*    */ {
/*    */   public BlockCropMedMoss() {
/* 20 */     func_149658_d(JRMCoreH.tjdbcAssts + ":BlockCropMedMoss0");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int quantityDropped(int parMetadata, int parFortune, Random parRand) {
/* 30 */     return (parMetadata / 3 > 1) ? (parMetadata / 3 + parRand.nextInt(2)) : (parMetadata / 3);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Item func_149650_a(int parMetadata, Random parRand, int parFortune) {
/* 38 */     return ItemsDBC.ItemMedMoss;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_149651_a(IIconRegister parIIconRegister) {
/* 45 */     this.iIcon = new net.minecraft.util.IIcon[this.maxGrowthStage + 1];
/*    */ 
/*    */     
/* 48 */     this.iIcon[0] = parIIconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":BlockCropMedMoss0");
/* 49 */     this.iIcon[1] = parIIconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":BlockCropMedMoss0");
/* 50 */     this.iIcon[2] = parIIconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":BlockCropMedMoss0");
/* 51 */     this.iIcon[3] = parIIconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":BlockCropMedMoss1");
/* 52 */     this.iIcon[4] = parIIconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":BlockCropMedMoss1");
/* 53 */     this.iIcon[5] = parIIconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":BlockCropMedMoss2");
/* 54 */     this.iIcon[6] = parIIconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":BlockCropMedMoss2");
/* 55 */     this.iIcon[7] = parIIconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":BlockCropMedMoss3");
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Blocks\BlockCropMedMoss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */