/*    */ package JinRyuu.JYearsC;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ public class JYCTab
/*    */   extends CreativeTabs
/*    */ {
/*    */   public JYCTab(String label) {
/* 12 */     super(label);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public Item func_78016_d() {
/* 23 */     return JYearsCItems.ItemWatch;
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JYearsC-v1.2.5.jar!\JinRyuu\JYearsC\JYCTab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */