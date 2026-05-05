package com.avaje.ebean.cache;

import com.avaje.ebean.EbeanServer;

public interface ServerCacheManager {
  void init(EbeanServer paramEbeanServer);
  
  boolean isBeanCaching(Class<?> paramClass);
  
  ServerCache getBeanCache(Class<?> paramClass);
  
  ServerCache getQueryCache(Class<?> paramClass);
  
  void clear(Class<?> paramClass);
  
  void clearAll();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\cache\ServerCacheManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */