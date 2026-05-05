/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import JinRyuu.JRMCore.items.ItemWeight;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ 
/*    */ public class ItemWeight
/*    */   extends ItemWeight {
/*    */   public ItemWeight(int weight) {
/* 12 */     super(weight);
/* 13 */     func_77637_a(mod_DragonBC.DragonBlockC);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_94581_a(IIconRegister par1IconRegister) {
/* 22 */     this.field_77791_bV = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_77658_a());
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemWeight.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */