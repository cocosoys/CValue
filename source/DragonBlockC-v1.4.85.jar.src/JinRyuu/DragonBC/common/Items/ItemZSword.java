/*    */ package JinRyuu.DragonBC.common.Items;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.client.renderer.texture.IIconRegister;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemSword;
/*    */ 
/*    */ public class ItemZSword
/*    */   extends ItemSword
/*    */ {
/*    */   public ItemZSword(Item.ToolMaterial tm) {
/* 14 */     super(tm);
/* 15 */     func_77656_e(1200);
/* 16 */     func_77637_a(mod_DragonBC.DragonBlockC);
/*    */   }
/*    */   public String getTextureFile() {
/* 19 */     return "jinryuudragonbc:";
/*    */   }
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public void func_94581_a(IIconRegister par1IconRegister) {
/* 24 */     this.field_77791_bV = par1IconRegister.func_94245_a("jinryuudragonbc:" + func_77658_a());
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\ItemZSword.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */