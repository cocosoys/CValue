package org.bukkit.inventory.meta;

import java.util.List;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public interface PotionMeta extends ItemMeta {
  boolean hasCustomEffects();
  
  List<PotionEffect> getCustomEffects();
  
  boolean addCustomEffect(PotionEffect paramPotionEffect, boolean paramBoolean);
  
  boolean removeCustomEffect(PotionEffectType paramPotionEffectType);
  
  boolean hasCustomEffect(PotionEffectType paramPotionEffectType);
  
  boolean setMainEffect(PotionEffectType paramPotionEffectType);
  
  boolean clearCustomEffects();
  
  PotionMeta clone();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\inventory\meta\PotionMeta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */