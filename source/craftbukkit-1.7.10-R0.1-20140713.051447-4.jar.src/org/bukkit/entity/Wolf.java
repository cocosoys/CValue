package org.bukkit.entity;

import org.bukkit.DyeColor;

public interface Wolf extends Animals, Tameable {
  boolean isAngry();
  
  void setAngry(boolean paramBoolean);
  
  boolean isSitting();
  
  void setSitting(boolean paramBoolean);
  
  DyeColor getCollarColor();
  
  void setCollarColor(DyeColor paramDyeColor);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\entity\Wolf.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */