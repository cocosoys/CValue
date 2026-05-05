package org.bukkit.metadata;

import org.bukkit.plugin.Plugin;

public interface MetadataValue {
  Object value();
  
  int asInt();
  
  float asFloat();
  
  double asDouble();
  
  long asLong();
  
  short asShort();
  
  byte asByte();
  
  boolean asBoolean();
  
  String asString();
  
  Plugin getOwningPlugin();
  
  void invalidate();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\metadata\MetadataValue.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */