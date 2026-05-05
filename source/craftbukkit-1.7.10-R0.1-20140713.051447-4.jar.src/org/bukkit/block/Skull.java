package org.bukkit.block;

import org.bukkit.SkullType;

public interface Skull extends BlockState {
  boolean hasOwner();
  
  String getOwner();
  
  boolean setOwner(String paramString);
  
  BlockFace getRotation();
  
  void setRotation(BlockFace paramBlockFace);
  
  SkullType getSkullType();
  
  void setSkullType(SkullType paramSkullType);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\block\Skull.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */