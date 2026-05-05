package org.bukkit.inventory;

import org.bukkit.block.Furnace;

public interface FurnaceInventory extends Inventory {
  ItemStack getResult();
  
  ItemStack getFuel();
  
  ItemStack getSmelting();
  
  void setFuel(ItemStack paramItemStack);
  
  void setResult(ItemStack paramItemStack);
  
  void setSmelting(ItemStack paramItemStack);
  
  Furnace getHolder();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\inventory\FurnaceInventory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */