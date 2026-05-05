package com.avaje.ebeaninternal.server.lucene;

import com.avaje.ebean.Query;
import com.avaje.ebean.config.lucene.IndexDefn;
import com.avaje.ebeaninternal.api.SpiEbeanServer;
import com.avaje.ebeaninternal.api.SpiTransaction;
import com.avaje.ebeaninternal.server.cluster.LuceneClusterIndexSync;
import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
import com.avaje.ebeaninternal.server.transaction.IndexEvent;
import com.avaje.ebeaninternal.server.transaction.RemoteTransactionEvent;
import java.io.IOException;

public interface LuceneIndexManager {
  void start();
  
  void shutdown();
  
  boolean isLuceneAvailable();
  
  LuceneClusterIndexSync getClusterIndexSync();
  
  void processEvent(RemoteTransactionEvent paramRemoteTransactionEvent, SpiTransaction paramSpiTransaction);
  
  void processEvent(IndexEvent paramIndexEvent);
  
  Query.UseIndex getDefaultUseIndex();
  
  LIndex create(IndexDefn<?> paramIndexDefn, BeanDescriptor<?> paramBeanDescriptor) throws IOException;
  
  LIndex getIndex(String paramString);
  
  SpiEbeanServer getServer();
  
  void setServer(SpiEbeanServer paramSpiEbeanServer);
  
  void addIndex(LIndex paramLIndex) throws IOException;
  
  String getIndexDirectory(String paramString);
  
  void notifyCluster(IndexEvent paramIndexEvent);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lucene\LuceneIndexManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */