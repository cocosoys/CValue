/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemWarenai
/*    */   extends Item
/*    */ {
/*    */   public ItemWarenai() {
/* 15 */     func_77637_a(mod_DragonBC.DragonBlockC);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getTextureFile() {
/* 33 */     return "jinryuudragonbc:";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister iconRegister) {
/* 38 */     this.field_77791_bV = iconRegister.func_94245_a("jinryuudragonbc:" + func_77658_a());
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemWarenai.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */