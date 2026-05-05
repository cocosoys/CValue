/*    */ package JinRyuu.JRMCore.items;
/*    */ 
/*    */ import cpw.mods.fml.common.registry.GameRegistry;
/*    */ import net.minecraft.init.Blocks;
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.item.ItemStack;
/*    */ 
/*    */ 
/*    */ public class RecipesJRMC
/*    */ {
/*    */   public static void init() {
/* 12 */     GameRegistry.addRecipe(new ItemStack(ItemsJRMC.ItemBarberSnC, 1), new Object[] { "IP", "SI", 
/* 13 */           Character.valueOf('I'), Items.field_151042_j, Character.valueOf('S'), Items.field_151097_aZ, Character.valueOf('P'), Blocks.field_150344_f });
/* 14 */     GameRegistry.addRecipe(new ItemStack(ItemsJRMC.Custom_fabric, 1), new Object[] { " SW", " W ", "W  ", 
/* 15 */           Character.valueOf('S'), Items.field_151007_F, Character.valueOf('W'), Blocks.field_150325_L });
/* 16 */     GameRegistry.addRecipe(new ItemStack(ItemsJRMC.Costume_creeper, 1), new Object[] { "F F", "WWW", "WWW", 
/* 17 */           Character.valueOf('F'), ItemsJRMC.Custom_fabric, Character.valueOf('W'), new ItemStack(Blocks.field_150325_L, 1, 13) });
/* 18 */     GameRegistry.addRecipe(new ItemStack(ItemsJRMC.Costume_ender, 1), new Object[] { "F F", "WWW", "WWW", 
/* 19 */           Character.valueOf('F'), ItemsJRMC.Custom_fabric, Character.valueOf('W'), new ItemStack(Blocks.field_150325_L, 1, 15) });
/*    */ 
/*    */     
/* 22 */     String[] recept_1 = { " R ", "R R", "RRR", "RRR", "   " };
/* 23 */     String[] recept_2 = { "RFR", "RFR", "RFR", "RFR", "WFW" };
/* 24 */     String[] recept_3 = { " W ", "WWW", "WWW", "W W", "D D" };
/*    */     
/* 26 */     for (int i = 0; i < ItemsJRMC.ItemVanity3.length; i++) {
/* 27 */       GameRegistry.addRecipe(new ItemStack(ItemsJRMC.ItemsVanity[i], 1), new Object[] { recept_1[i], recept_2[i], recept_3[i], 
/* 28 */             Character.valueOf('F'), ItemsJRMC.Custom_fabric, Character.valueOf('R'), new ItemStack(Blocks.field_150325_L, 1, 14), Character.valueOf('W'), new ItemStack(Blocks.field_150325_L, 1, 0), Character.valueOf('D'), new ItemStack(Blocks.field_150325_L, 1, 15) });
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\LifeTools\Google\Chrome\下载\JRMCore-v1.3.51.jar!\JinRyuu\JRMCore\items\RecipesJRMC.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */