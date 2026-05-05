package org.bukkit.inventory;

import org.bukkit.block.DoubleChest;

public interface DoubleChestInventory extends Inventory {
  Inventory getLeftSide();
  
  Inventory getRightSide();
  
  DoubleChest getHolder();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\inventory\DoubleChestInventory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */