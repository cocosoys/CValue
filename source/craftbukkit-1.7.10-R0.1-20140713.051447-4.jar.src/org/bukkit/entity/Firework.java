package org.bukkit.entity;

import org.bukkit.inventory.meta.FireworkMeta;

public interface Firework extends Entity {
  FireworkMeta getFireworkMeta();
  
  void setFireworkMeta(FireworkMeta paramFireworkMeta);
  
  void detonate();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\entity\Firework.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */