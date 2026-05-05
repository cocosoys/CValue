/*    */ package JinRyuu.DragonBC.common.Items.m;
/*    */ 
/*    */ import JinRyuu.DragonBC.common.mod_DragonBC;
/*    */ import JinRyuu.JRMCore.JRMCoreH;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemPickaxe;
/*    */ 
/*    */ public class MyPickaxes extends ItemPickaxe {
/*    */   protected MyPickaxes(String unlocalizedName, Item.ToolMaterial material) {
/* 10 */     super(material);
/* 11 */     func_77655_b(unlocalizedName);
/* 12 */     func_111206_d(JRMCoreH.tjdbcAssts + ":" + unlocalizedName);
/* 13 */     func_77637_a(mod_DragonBC.DragonBlockC);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\DragonBlockC-v1.4.85.jar!\JinRyuu\DragonBC\common\Items\m\MyPickaxes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */