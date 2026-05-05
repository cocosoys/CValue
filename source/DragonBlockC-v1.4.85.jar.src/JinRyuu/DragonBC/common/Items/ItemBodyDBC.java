/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import JinRyuu.JRMCore.items.ItemBodysuit;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class ItemBodyDBC
/*    */   extends ItemBodysuit {
/*    */   public String armorNamePrefix;
/*    */   
/*    */   public ItemBodyDBC(int defcol, String armornamePrefix) {
/* 15 */     super(defcol);
/* 16 */     this.armorNamePrefix = armornamePrefix;
/*    */     
/* 18 */     func_77637_a(mod_DragonBC.DragonBlockC);
/*    */   }
/*    */   
/*    */   public String getTextureFile() {
/* 22 */     return JRMCoreH.tjdbcAssts + ":";
/*    */   }
/*    */   
/*    */   public void func_94581_a(IIconRegister iconRegister) {
/* 26 */     this.field_77791_bV = iconRegister.func_94245_a(JRMCoreH.tjdbcAssts + ":" + func_77658_a().replaceAll("item.", ""));
/*    */   }
/*    */ 
/*    */   
/*    */   public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type) {
/* 31 */     String armor = "";
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
/* 43 */     armor = "jinryuudragonbc:armor/" + this.armorNamePrefix + ".png";
/*    */     
/* 45 */     return armor;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemBodyDBC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */