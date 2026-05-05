package org.bukkit.inventory.meta;

public interface SkullMeta extends ItemMeta {
  String getOwner();
  
  boolean hasOwner();
  
  boolean setOwner(String paramString);
  
  SkullMeta clone();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\inventory\meta\SkullMeta.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */