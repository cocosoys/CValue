package org.bukkit.entity;

public interface Boat extends Vehicle {
  double getMaxSpeed();
  
  void setMaxSpeed(double paramDouble);
  
  double getOccupiedDeceleration();
  
  void setOccupiedDeceleration(double paramDouble);
  
  double getUnoccupiedDeceleration();
  
  void setUnoccupiedDeceleration(double paramDouble);
  
  boolean getWorkOnLand();
  
  void setWorkOnLand(boolean paramBoolean);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\entity\Boat.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */