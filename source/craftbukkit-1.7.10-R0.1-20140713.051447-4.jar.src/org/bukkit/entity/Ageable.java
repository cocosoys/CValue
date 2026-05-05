package org.bukkit.entity;

public interface Ageable extends Creature {
  int getAge();
  
  void setAge(int paramInt);
  
  void setAgeLock(boolean paramBoolean);
  
  boolean getAgeLock();
  
  void setBaby();
  
  void setAdult();
  
  boolean isAdult();
  
  boolean canBreed();
  
  void setBreed(boolean paramBoolean);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\entity\Ageable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */