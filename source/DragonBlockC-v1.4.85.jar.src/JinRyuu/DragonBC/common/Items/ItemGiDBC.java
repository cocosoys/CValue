/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import JinRyuu.JRMCore.items.ItemBodysuit;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ItemGiDBC
/*    */   extends ItemBodysuit
/*    */ {
/*    */   public String armorNamePrefix;
/*    */   
/*    */   public ItemGiDBC(int defcol, String armornamePrefix) {
/* 20 */     super(defcol);
/* 21 */     this.armorNamePrefix = armornamePrefix;
/*    */     
/* 23 */     func_77637_a(mod_DragonBC.DragonBlockC);
/*    */   }
/*    */   
/*    */   public String getTextureFile() {
/* 27 */     return JRMCoreH.tjdbcAssts + ":";
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_94581_a(IIconRegister iconRegister) {
/* 32 */     this.field_77791_bV = iconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":" + func_77658_a().replaceAll("item.", ""));
/*    */   }
/*    */ 
/*    */   
/*    */   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
/* 37 */     String armor = "";
/* 38 */     armor = "jinryuudragonbc:armor/" + this.armorNamePrefix + ".png";
/* 39 */     return armor;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemGiDBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */