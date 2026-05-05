package com.avaje.ebeaninternal.server.cluster;

public interface LuceneClusterFactory {
  LuceneClusterListener createListener(ClusterManager paramClusterManager, int paramInt);
  
  LuceneClusterIndexSync createIndexSync();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\cluster\LuceneClusterFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */