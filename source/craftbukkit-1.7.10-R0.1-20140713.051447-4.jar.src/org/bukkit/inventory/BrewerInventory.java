package org.bukkit.inventory;

import org.bukkit.block.BrewingStand;

public interface BrewerInventory extends Inventory {
  ItemStack getIngredient();
  
  void setIngredient(ItemStack paramItemStack);
  
  BrewingStand getHolder();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\inventory\BrewerInventory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */