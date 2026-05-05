/*    */ package net.minecraft.item.crafting;
/*    */ 
/*    */ import net.minecraft.init.Items;
/*    */ import net.minecraft.inventory.InventoryCrafting;
/*    */ import net.minecraft.item.ItemStack;
/*    */ import net.minecraft.nbt.NBTTagCompound;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class RecipeBookCloning
/*    */   implements IRecipe {
/*    */   public boolean func_77569_a(InventoryCrafting p_77569_1_, World p_77569_2_) {
/* 12 */     byte b1 = 0;
/* 13 */     ItemStack itemStack = null;
/*    */     
/* 15 */     for (byte b2 = 0; b2 < p_77569_1_.func_70302_i_(); b2++) {
/* 16 */       ItemStack itemStack1 = p_77569_1_.func_70301_a(b2);
/* 17 */       if (itemStack1 != null)
/*    */       {
/* 19 */         if (itemStack1.func_77973_b() == Items.field_151164_bB) {
/* 20 */           if (itemStack != null) return false; 
/* 21 */           itemStack = itemStack1;
/* 22 */         } else if (itemStack1.func_77973_b() == Items.field_151099_bA) {
/* 23 */           b1++;
/*    */         } else {
/* 25 */           return false;
/*    */         } 
/*    */       }
/*    */     } 
/* 29 */     return (itemStack != null && b1 > 0);
/*    */   }
/*    */   private static final String __OBFID = "CL_00000081";
/*    */   
/*    */   public ItemStack func_77572_b(InventoryCrafting p_77572_1_) {
/* 34 */     byte b1 = 0;
/* 35 */     ItemStack itemStack1 = null;
/*    */     
/* 37 */     for (byte b2 = 0; b2 < p_77572_1_.func_70302_i_(); b2++) {
/* 38 */       ItemStack itemStack = p_77572_1_.func_70301_a(b2);
/* 39 */       if (itemStack != null)
/*    */       {
/* 41 */         if (itemStack.func_77973_b() == Items.field_151164_bB) {
/* 42 */           if (itemStack1 != null) return null; 
/* 43 */           itemStack1 = itemStack;
/* 44 */         } else if (itemStack.func_77973_b() == Items.field_151099_bA) {
/* 45 */           b1++;
/*    */         } else {
/* 47 */           return null;
/*    */         } 
/*    */       }
/*    */     } 
/* 51 */     if (itemStack1 == null || b1 < 1) return null;
/*    */     
/* 53 */     ItemStack itemStack2 = new ItemStack(Items.field_151164_bB, b1 + 1);
/* 54 */     itemStack2.func_77982_d((NBTTagCompound)itemStack1.func_77978_p().func_74737_b());
/* 55 */     if (itemStack1.func_82837_s()) itemStack2.func_151001_c(itemStack1.func_82833_r()); 
/* 56 */     return itemStack2;
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_77570_a() {
/* 61 */     return 9;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack func_77571_b() {
/* 66 */     return null;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\item\crafting\RecipeBookCloning.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */