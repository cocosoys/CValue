package org.bukkit.entity;

public interface Damageable extends Entity {
  void damage(double paramDouble);
  
  @Deprecated
  void damage(int paramInt);
  
  void damage(double paramDouble, Entity paramEntity);
  
  @Deprecated
  void damage(int paramInt, Entity paramEntity);
  
  double getHealth();
  
  @Deprecated
  int getHealth();
  
  void setHealth(double paramDouble);
  
  @Deprecated
  void setHealth(int paramInt);
  
  double getMaxHealth();
  
  @Deprecated
  int getMaxHealth();
  
  void setMaxHealth(double paramDouble);
  
  @Deprecated
  void setMaxHealth(int paramInt);
  
  void resetMaxHealth();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\entity\Damageable.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */