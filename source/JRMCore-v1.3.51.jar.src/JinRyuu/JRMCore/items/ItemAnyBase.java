/*    */ package JinRyuu.JRMCore.items;
/*    */ 
/*    */ import JinRyuu.JRMCore.mod_JRMCore;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ public class ItemAnyBase extends Item {
/*    */   public ItemAnyBase() {
/*  9 */     func_77637_a(mod_JRMCore.JRMCore);
/*    */   }
/*    */   
/*    */   public void func_94581_a(IIconRegister iconRegister) {
/* 13 */     this.field_77791_bV = iconRegister.func_94245_a("jinryuumodscore:" + func_77658_a().replaceAll("item.", ""));
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\items\ItemAnyBase.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */