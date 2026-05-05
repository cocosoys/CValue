/*    */ package JinRyuu.JRMCore;
/*    */ 
/*    */ import JinRyuu.JRMCore.blocks.BlocksJRMC;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import net.minecraft.creativetab.CreativeTabs;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ public class JRMCTab
/*    */   extends CreativeTabs
/*    */ {
/*    */   public JRMCTab(String label) {
/* 14 */     super(label);
/*    */   }
/*    */   
/*    */   public ItemStack func_151244_d() {
/* 18 */     return new ItemStack(BlocksJRMC.BlockColoredStone);
/*    */   }
/*    */ 
/*    */   
/*    */   @SideOnly(Side.CLIENT)
/*    */   public Item func_78016_d() {
/* 24 */     return Item.func_150898_a(BlocksJRMC.BlockColoredStone);
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\JRMCTab.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */