package org.bukkit.inventory.meta;

import org.bukkit.FireworkEffect;

public interface FireworkEffectMeta extends ItemMeta {
  void setEffect(FireworkEffect paramFireworkEffect);
  
  boolean hasEffect();
  
  FireworkEffect getEffect();
  
  FireworkEffectMeta clone();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\inventory\meta\FireworkEffectMeta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */