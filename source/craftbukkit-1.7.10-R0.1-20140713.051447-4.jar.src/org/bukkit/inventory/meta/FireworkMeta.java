package org.bukkit.inventory.meta;

import java.util.List;
import org.bukkit.FireworkEffect;

public interface FireworkMeta extends ItemMeta {
  void addEffect(FireworkEffect paramFireworkEffect) throws IllegalArgumentException;
  
  void addEffects(FireworkEffect... paramVarArgs) throws IllegalArgumentException;
  
  void addEffects(Iterable<FireworkEffect> paramIterable) throws IllegalArgumentException;
  
  List<FireworkEffect> getEffects();
  
  int getEffectsSize();
  
  void removeEffect(int paramInt) throws IndexOutOfBoundsException;
  
  void clearEffects();
  
  boolean hasEffects();
  
  int getPower();
  
  void setPower(int paramInt) throws IllegalArgumentException;
  
  FireworkMeta clone();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\inventory\meta\FireworkMeta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */