package com.google.common.cache;

import com.google.common.annotations.Beta;
import com.google.common.base.Function;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

@Beta
public interface Cache<K, V> extends Function<K, V> {
  V get(K paramK) throws ExecutionException;
  
  V getUnchecked(K paramK);
  
  V apply(K paramK);
  
  void invalidate(Object paramObject);
  
  void invalidateAll();
  
  long size();
  
  CacheStats stats();
  
  ConcurrentMap<K, V> asMap();
  
  void cleanUp();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\google\common\cache\Cache.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */