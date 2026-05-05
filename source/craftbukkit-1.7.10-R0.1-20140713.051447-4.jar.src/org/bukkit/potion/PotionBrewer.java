package org.bukkit.potion;

import java.util.Collection;

public interface PotionBrewer {
  PotionEffect createEffect(PotionEffectType paramPotionEffectType, int paramInt1, int paramInt2);
  
  @Deprecated
  Collection<PotionEffect> getEffectsFromDamage(int paramInt);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\potion\PotionBrewer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */