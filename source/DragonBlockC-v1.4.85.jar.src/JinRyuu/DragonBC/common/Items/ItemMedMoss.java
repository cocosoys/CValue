/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Blocks.BlocksDBC;
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import JinRyuu.JRMCore.items.ItemJRMCSeedFood;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.init.Blocks;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemMedMoss
/*    */   extends ItemJRMCSeedFood
/*    */ {
/*    */   public ItemMedMoss(int f, float g) {
/* 15 */     super(f, g, BlocksDBC.BlockCropMedMoss, Blocks.field_150458_ak);
/* 16 */     func_77637_a(mod_DragonBC.DragonBlockC);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getTextureFile() {
/* 21 */     return "jinryuudragonbc:";
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister iconRegister) {
/* 27 */     this.field_77791_bV = iconRegister.func_94245_a("jinryuudragonbc:" + func_77658_a().replaceAll("item.", ""));
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemMedMoss.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */