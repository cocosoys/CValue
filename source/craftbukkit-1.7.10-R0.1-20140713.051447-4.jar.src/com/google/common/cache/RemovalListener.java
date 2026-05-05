package com.google.common.cache;

import com.google.common.annotations.Beta;

@Beta
public interface RemovalListener<K, V> {
  void onRemoval(RemovalNotification<K, V> paramRemovalNotification);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\google\common\cache\RemovalListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */