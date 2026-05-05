package org.bukkit.craftbukkit.libs.joptsimple;

public interface ValueConverter<V> {
  V convert(String paramString);
  
  Class<V> valueType();
  
  String valuePattern();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\libs\joptsimple\ValueConverter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */