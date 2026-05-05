/*    */ package net.minecraft.server.v1_7_R4;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftItemStack;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.inventory.CraftShapelessRecipe;
/*    */ import org.bukkit.craftbukkit.v1_7_R4.util.CraftMagicNumbers;
/*    */ import org.bukkit.inventory.ItemStack;
/*    */ import org.bukkit.inventory.Recipe;
/*    */ import org.bukkit.inventory.ShapelessRecipe;
/*    */ 
/*    */ public class ShapelessRecipes implements IRecipe {
/*    */   private final ItemStack result;
/*    */   private final List ingredients;
/*    */   
/*    */   public ShapelessRecipes(ItemStack itemstack, List list) {
/* 18 */     this.result = itemstack;
/* 19 */     this.ingredients = list;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public ShapelessRecipe toBukkitRecipe() {
/* 25 */     CraftItemStack result = CraftItemStack.asCraftMirror(this.result);
/* 26 */     CraftShapelessRecipe recipe = new CraftShapelessRecipe((ItemStack)result, this);
/* 27 */     for (ItemStack stack : this.ingredients) {
/* 28 */       if (stack != null) {
/* 29 */         recipe.addIngredient(CraftMagicNumbers.getMaterial(stack.getItem()), stack.getData());
/*    */       }
/*    */     } 
/* 32 */     return (ShapelessRecipe)recipe;
/*    */   }
/*    */ 
/*    */   
/*    */   public ItemStack b() {
/* 37 */     return this.result;
/*    */   }
/*    */   
/*    */   public boolean a(InventoryCrafting inventorycrafting, World world) {
/* 41 */     ArrayList arraylist = new ArrayList(this.ingredients);
/*    */     
/* 43 */     for (int i = 0; i < 3; i++) {
/* 44 */       for (int j = 0; j < 3; j++) {
/* 45 */         ItemStack itemstack = inventorycrafting.b(j, i);
/*    */         
/* 47 */         if (itemstack != null) {
/* 48 */           boolean flag = false;
/* 49 */           Iterator<ItemStack> iterator = arraylist.iterator();
/*    */           
/* 51 */           while (iterator.hasNext()) {
/* 52 */             ItemStack itemstack1 = iterator.next();
/*    */             
/* 54 */             if (itemstack.getItem() == itemstack1.getItem() && (itemstack1.getData() == 32767 || itemstack.getData() == itemstack1.getData())) {
/* 55 */               flag = true;
/* 56 */               arraylist.remove(itemstack1);
/*    */               
/*    */               break;
/*    */             } 
/*    */           } 
/* 61 */           if (!flag) {
/* 62 */             return false;
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } 
/*    */     
/* 68 */     return arraylist.isEmpty();
/*    */   }
/*    */   
/*    */   public ItemStack a(InventoryCrafting inventorycrafting) {
/* 72 */     return this.result.cloneItemStack();
/*    */   }
/*    */   
/*    */   public int a() {
/* 76 */     return this.ingredients.size();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ShapelessRecipes.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */