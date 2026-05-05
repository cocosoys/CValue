package org.bukkit.inventory;

public interface CraftingInventory extends Inventory {
  ItemStack getResult();
  
  ItemStack[] getMatrix();
  
  void setResult(ItemStack paramItemStack);
  
  void setMatrix(ItemStack[] paramArrayOfItemStack);
  
  Recipe getRecipe();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\inventory\CraftingInventory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */