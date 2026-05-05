package org.bukkit.entity;

import org.bukkit.inventory.ItemStack;

public interface Item extends Entity {
  ItemStack getItemStack();
  
  void setItemStack(ItemStack paramItemStack);
  
  int getPickupDelay();
  
  void setPickupDelay(int paramInt);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\entity\Item.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */