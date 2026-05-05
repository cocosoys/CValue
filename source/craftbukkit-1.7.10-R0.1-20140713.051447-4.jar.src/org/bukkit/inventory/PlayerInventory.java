package org.bukkit.inventory;

import org.bukkit.entity.HumanEntity;

public interface PlayerInventory extends Inventory {
  ItemStack[] getArmorContents();
  
  ItemStack getHelmet();
  
  ItemStack getChestplate();
  
  ItemStack getLeggings();
  
  ItemStack getBoots();
  
  void setArmorContents(ItemStack[] paramArrayOfItemStack);
  
  void setHelmet(ItemStack paramItemStack);
  
  void setChestplate(ItemStack paramItemStack);
  
  void setLeggings(ItemStack paramItemStack);
  
  void setBoots(ItemStack paramItemStack);
  
  ItemStack getItemInHand();
  
  void setItemInHand(ItemStack paramItemStack);
  
  int getHeldItemSlot();
  
  void setHeldItemSlot(int paramInt);
  
  @Deprecated
  int clear(int paramInt1, int paramInt2);
  
  HumanEntity getHolder();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\inventory\PlayerInventory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */