package org.bukkit.inventory.meta;

import java.util.Map;
import org.bukkit.enchantments.Enchantment;

public interface EnchantmentStorageMeta extends ItemMeta {
  boolean hasStoredEnchants();
  
  boolean hasStoredEnchant(Enchantment paramEnchantment);
  
  int getStoredEnchantLevel(Enchantment paramEnchantment);
  
  Map<Enchantment, Integer> getStoredEnchants();
  
  boolean addStoredEnchant(Enchantment paramEnchantment, int paramInt, boolean paramBoolean);
  
  boolean removeStoredEnchant(Enchantment paramEnchantment) throws IllegalArgumentException;
  
  boolean hasConflictingStoredEnchant(Enchantment paramEnchantment);
  
  EnchantmentStorageMeta clone();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\inventory\meta\EnchantmentStorageMeta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */