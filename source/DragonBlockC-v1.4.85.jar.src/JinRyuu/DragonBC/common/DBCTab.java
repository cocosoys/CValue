/*    */ package JinRyuu.DragonBC.common;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.Items.ItemsDBC;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class DBCTab extends CreativeTabs {
/*    */   public DBCTab(String label) {
/* 12 */     super(label);
/*    */   } public ItemStack func_151244_d() {
/* 14 */     return new ItemStack(ItemsDBC.ItemDragonBlock);
/*    */   }
/*    */   @SideOnly(Side.CLIENT)
/*    */   public Item func_78016_d() {
/* 18 */     return ItemsDBC.ItemDragonBlock;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\DBCTab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */