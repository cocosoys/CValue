package org.bukkit.block;

import org.bukkit.inventory.BrewerInventory;

public interface BrewingStand extends BlockState, ContainerBlock {
  int getBrewingTime();
  
  void setBrewingTime(int paramInt);
  
  BrewerInventory getInventory();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\block\BrewingStand.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */