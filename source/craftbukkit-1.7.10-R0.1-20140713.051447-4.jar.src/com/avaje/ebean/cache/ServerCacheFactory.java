package com.avaje.ebean.cache;

import com.avaje.ebean.EbeanServer;

public interface ServerCacheFactory {
  void init(EbeanServer paramEbeanServer);
  
  ServerCache createCache(Class<?> paramClass, ServerCacheOptions paramServerCacheOptions);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\cache\ServerCacheFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */