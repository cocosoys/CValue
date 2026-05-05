package com.avaje.ebeaninternal.server.cluster;

import com.avaje.ebeaninternal.server.transaction.RemoteTransactionEvent;

public interface ClusterBroadcast {
  void startup(ClusterManager paramClusterManager);
  
  void shutdown();
  
  void broadcast(RemoteTransactionEvent paramRemoteTransactionEvent);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\cluster\ClusterBroadcast.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */