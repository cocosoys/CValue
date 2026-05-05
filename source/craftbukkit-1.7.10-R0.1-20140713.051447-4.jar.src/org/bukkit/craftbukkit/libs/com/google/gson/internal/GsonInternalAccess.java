package org.bukkit.craftbukkit.libs.com.google.gson.internal;

import org.bukkit.craftbukkit.libs.com.google.gson.Gson;
import org.bukkit.craftbukkit.libs.com.google.gson.TypeAdapter;
import org.bukkit.craftbukkit.libs.com.google.gson.TypeAdapterFactory;
import org.bukkit.craftbukkit.libs.com.google.gson.reflect.TypeToken;

public abstract class GsonInternalAccess {
  public static GsonInternalAccess INSTANCE;
  
  public abstract <T> TypeAdapter<T> getNextAdapter(Gson paramGson, TypeAdapterFactory paramTypeAdapterFactory, TypeToken<T> paramTypeToken);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\craftbukkit\libs\com\google\gson\internal\GsonInternalAccess.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */