package org.bukkit.block;

import org.bukkit.entity.CreatureType;
import org.bukkit.entity.EntityType;

public interface CreatureSpawner extends BlockState {
  @Deprecated
  CreatureType getCreatureType();
  
  EntityType getSpawnedType();
  
  void setSpawnedType(EntityType paramEntityType);
  
  @Deprecated
  void setCreatureType(CreatureType paramCreatureType);
  
  @Deprecated
  String getCreatureTypeId();
  
  void setCreatureTypeByName(String paramString);
  
  String getCreatureTypeName();
  
  @Deprecated
  void setCreatureTypeId(String paramString);
  
  int getDelay();
  
  void setDelay(int paramInt);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\block\CreatureSpawner.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */