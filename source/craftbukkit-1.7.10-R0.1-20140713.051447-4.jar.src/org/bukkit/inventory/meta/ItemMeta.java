package org.bukkit.inventory.meta;

import java.util.List;
import java.util.Map;
import org.bukkit.configuration.serialization.ConfigurationSerializable;
import org.bukkit.enchantments.Enchantment;

public interface ItemMeta extends Cloneable, ConfigurationSerializable {
  boolean hasDisplayName();
  
  String getDisplayName();
  
  void setDisplayName(String paramString);
  
  boolean hasLore();
  
  List<String> getLore();
  
  void setLore(List<String> paramList);
  
  boolean hasEnchants();
  
  boolean hasEnchant(Enchantment paramEnchantment);
  
  int getEnchantLevel(Enchantment paramEnchantment);
  
  Map<Enchantment, Integer> getEnchants();
  
  boolean addEnchant(Enchantment paramEnchantment, int paramInt, boolean paramBoolean);
  
  boolean removeEnchant(Enchantment paramEnchantment);
  
  boolean hasConflictingEnchant(Enchantment paramEnchantment);
  
  ItemMeta clone();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\inventory\meta\ItemMeta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */