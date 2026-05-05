/*    */ package JinRyuu.JYearsC;
/*    */ 
/*    */ import cpw.mods.fml.common.registry.GameRegistry;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class JYearsCRecipes
/*    */ {
/*    */   public static void init() {
/* 11 */     GameRegistry.addRecipe(new ItemStack(JYearsCItems.ItemWatch, 1), new Object[] { " I ", "LRL", " I ", 
/* 12 */           Character.valueOf('R'), Items.field_151137_ax, Character.valueOf('I'), Items.field_151042_j, Character.valueOf('L'), Items.field_151116_aA });
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JYearsC-v1.2.5.jar!\JinRyuu\JYearsC\JYearsCRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */