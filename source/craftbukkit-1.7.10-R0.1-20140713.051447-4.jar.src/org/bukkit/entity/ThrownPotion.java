package org.bukkit.entity;

import java.util.Collection;
import org.bukkit.inventory.ItemStack;
import org.bukkit.potion.PotionEffect;

public interface ThrownPotion extends Projectile {
  Collection<PotionEffect> getEffects();
  
  ItemStack getItem();
  
  void setItem(ItemStack paramItemStack);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\entity\ThrownPotion.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */