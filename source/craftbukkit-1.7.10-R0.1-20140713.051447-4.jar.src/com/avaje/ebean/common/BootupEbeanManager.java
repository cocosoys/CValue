package com.avaje.ebean.common;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.config.ServerConfig;

public interface BootupEbeanManager {
  EbeanServer createServer(ServerConfig paramServerConfig);
  
  EbeanServer createServer(String paramString);
  
  void shutdown();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\common\BootupEbeanManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */