/*    */ package net.minecraft.item.crafting;
/*    */ 
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.inventory.InventoryCrafting;
/*    */ import net.minecraft.item.Item;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class RecipesMapCloning implements IRecipe {
/*    */   public boolean func_77569_a(InventoryCrafting p_77569_1_, World p_77569_2_) {
/* 11 */     byte b1 = 0;
/* 12 */     ItemStack itemStack = null;
/*    */     
/* 14 */     for (byte b2 = 0; b2 < p_77569_1_.func_70302_i_(); b2++) {
/* 15 */       ItemStack itemStack1 = p_77569_1_.func_70301_a(b2);
/* 16 */       if (itemStack1 != null)
/*    */       {
/* 18 */         if (itemStack1.func_77973_b() == Items.field_151098_aY) {
/* 19 */           if (itemStack != null) return false; 
/* 20 */           itemStack = itemStack1;
/* 21 */         } else if (itemStack1.func_77973_b() == Items.field_151148_bJ) {
/* 22 */           b1++;
/*    */         } else {
/* 24 */           return false;
/*    */         } 
/*    */       }
/*    */     } 
/* 28 */     return (itemStack != null && b1 > 0);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000087";
/*    */   
/*    */   public ItemStack func_77572_b(InventoryCrafting p_77572_1_) {
/* 33 */     byte b1 = 0;
/* 34 */     ItemStack itemStack1 = null;
/*    */     
/* 36 */     for (byte b2 = 0; b2 < p_77572_1_.func_70302_i_(); b2++) {
/* 37 */       ItemStack itemStack = p_77572_1_.func_70301_a(b2);
/* 38 */       if (itemStack != null)
/*    */       {
/* 40 */         if (itemStack.func_77973_b() == Items.field_151098_aY) {
/* 41 */           if (itemStack1 != null) return null; 
/* 42 */           itemStack1 = itemStack;
/* 43 */         } else if (itemStack.func_77973_b() == Items.field_151148_bJ) {
/* 44 */           b1++;
/*    */         } else {
/* 46 */           return null;
/*    */         } 
/*    */       }
/*    */     } 
/* 50 */     if (itemStack1 == null || b1 < 1) return null;
/*    */     
/* 52 */     ItemStack itemStack2 = new ItemStack((Item)Items.field_151098_aY, b1 + 1, itemStack1.func_77960_j());
/* 53 */     if (itemStack1.func_82837_s()) itemStack2.func_151001_c(itemStack1.func_82833_r()); 
/* 54 */     return itemStack2;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77570_a() {
/* 59 */     return 9;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_77571_b() {
/* 64 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\crafting\RecipesMapCloning.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */