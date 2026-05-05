package org.bukkit.entity;

public interface Tameable {
  boolean isTamed();
  
  void setTamed(boolean paramBoolean);
  
  AnimalTamer getOwner();
  
  void setOwner(AnimalTamer paramAnimalTamer);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\entity\Tameable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */