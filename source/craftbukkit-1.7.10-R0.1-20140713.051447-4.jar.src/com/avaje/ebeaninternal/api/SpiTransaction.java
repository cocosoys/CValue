package com.avaje.ebeaninternal.api;

import com.avaje.ebean.Transaction;
import com.avaje.ebean.bean.PersistenceContext;
import com.avaje.ebeaninternal.server.lucene.LIndexUpdateFuture;
import com.avaje.ebeaninternal.server.persist.BatchControl;
import com.avaje.ebeaninternal.server.transaction.TransactionLogBuffer;
import java.sql.Connection;

public interface SpiTransaction extends Transaction {
  boolean isLogSql();
  
  boolean isLogSummary();
  
  void logInternal(String paramString);
  
  void addIndexUpdateFuture(LIndexUpdateFuture paramLIndexUpdateFuture);
  
  TransactionLogBuffer getLogBuffer();
  
  void registerBean(Integer paramInteger);
  
  void unregisterBean(Integer paramInteger);
  
  boolean isRegisteredBean(Integer paramInteger);
  
  String getId();
  
  int getBatchSize();
  
  int depth(int paramInt);
  
  boolean isExplicit();
  
  TransactionEvent getEvent();
  
  boolean isPersistCascade();
  
  boolean isBatchThisRequest();
  
  BatchControl getBatchControl();
  
  void setBatchControl(BatchControl paramBatchControl);
  
  PersistenceContext getPersistenceContext();
  
  void setPersistenceContext(PersistenceContext paramPersistenceContext);
  
  Connection getInternalConnection();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\api\SpiTransaction.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */