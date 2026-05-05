/*     */ package com.avaje.ebeaninternal.server.transaction;
/*     */ 
/*     */ import com.avaje.ebean.LogLevel;
/*     */ import com.avaje.ebean.bean.PersistenceContext;
/*     */ import com.avaje.ebeaninternal.api.SpiTransaction;
/*     */ import com.avaje.ebeaninternal.api.TransactionEvent;
/*     */ import com.avaje.ebeaninternal.server.lucene.LIndexUpdateFuture;
/*     */ import com.avaje.ebeaninternal.server.lucene.PersistenceLuceneException;
/*     */ import com.avaje.ebeaninternal.server.persist.BatchControl;
/*     */ import java.sql.Connection;
/*     */ import java.sql.SQLException;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashSet;
/*     */ import java.util.List;
/*     */ import java.util.concurrent.ExecutionException;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.persistence.PersistenceException;
/*     */ import javax.persistence.RollbackException;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class JdbcTransaction
/*     */   implements SpiTransaction
/*     */ {
/*  49 */   private static final Logger logger = Logger.getLogger(JdbcTransaction.class.getName());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final String illegalStateMessage = "Transaction is Inactive";
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected final TransactionManager manager;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final String id;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final boolean explicit;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   final TransactionManager.OnQueryOnly onQueryOnly;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   boolean active;
/*     */ 
/*     */ 
/*     */   
/*     */   Connection connection;
/*     */ 
/*     */ 
/*     */   
/*     */   BatchControl batchControl;
/*     */ 
/*     */ 
/*     */   
/*     */   TransactionEvent event;
/*     */ 
/*     */ 
/*     */   
/*     */   PersistenceContext persistenceContext;
/*     */ 
/*     */ 
/*     */   
/*     */   boolean persistCascade = true;
/*     */ 
/*     */ 
/*     */   
/*     */   boolean queryOnly = true;
/*     */ 
/*     */ 
/*     */   
/*     */   boolean localReadOnly;
/*     */ 
/*     */ 
/*     */   
/*     */   LogLevel logLevel;
/*     */ 
/*     */ 
/*     */   
/*     */   boolean batchMode;
/*     */ 
/*     */ 
/*     */   
/* 119 */   int batchSize = -1;
/*     */ 
/*     */   
/*     */   boolean batchFlushOnQuery = true;
/*     */ 
/*     */   
/*     */   Boolean batchGetGeneratedKeys;
/*     */ 
/*     */   
/*     */   Boolean batchFlushOnMixed;
/*     */ 
/*     */   
/* 131 */   int depth = 0;
/*     */ 
/*     */   
/*     */   HashSet<Integer> persistingBeans;
/*     */ 
/*     */   
/*     */   TransactionLogBuffer logBuffer;
/*     */   
/*     */   List<LIndexUpdateFuture> indexUpdateFutures;
/*     */ 
/*     */   
/*     */   public JdbcTransaction(String id, boolean explicit, LogLevel logLevel, Connection connection, TransactionManager manager) {
/*     */     try {
/* 144 */       this.active = true;
/* 145 */       this.id = id;
/* 146 */       this.explicit = explicit;
/* 147 */       this.logLevel = logLevel;
/* 148 */       this.manager = manager;
/* 149 */       this.connection = connection;
/* 150 */       this.onQueryOnly = (manager == null) ? TransactionManager.OnQueryOnly.ROLLBACK : manager.getOnQueryOnly();
/* 151 */       this.persistenceContext = new DefaultPersistenceContext();
/*     */       
/* 153 */       this.logBuffer = new TransactionLogBuffer(50, id);
/*     */     }
/* 155 */     catch (Exception e) {
/* 156 */       throw new PersistenceException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public String toString() {
/* 161 */     return "Trans[" + this.id + "]";
/*     */   }
/*     */ 
/*     */   
/*     */   public void addIndexUpdateFuture(LIndexUpdateFuture future) {
/* 166 */     if (this.indexUpdateFutures == null) {
/* 167 */       this.indexUpdateFutures = new ArrayList<LIndexUpdateFuture>();
/*     */     }
/* 169 */     this.indexUpdateFutures.add(future);
/*     */   }
/*     */   
/*     */   public void waitForIndexUpdates() {
/* 173 */     if (this.indexUpdateFutures != null) {
/*     */       try {
/* 175 */         for (LIndexUpdateFuture lIndexUpdateFuture : this.indexUpdateFutures) {
/* 176 */           lIndexUpdateFuture.get();
/*     */         }
/* 178 */       } catch (InterruptedException e) {
/* 179 */         throw new PersistenceLuceneException(e);
/* 180 */       } catch (ExecutionException e) {
/* 181 */         throw new PersistenceLuceneException(e);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerBean(Integer persistingBean) {
/* 194 */     if (this.persistingBeans == null) {
/* 195 */       this.persistingBeans = new HashSet<Integer>();
/*     */     }
/* 197 */     this.persistingBeans.add(persistingBean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unregisterBean(Integer persistedBean) {
/* 204 */     if (this.persistingBeans != null) {
/* 205 */       this.persistingBeans.remove(persistedBean);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isRegisteredBean(Integer persistingBean) {
/* 213 */     if (this.persistingBeans == null) {
/* 214 */       return false;
/*     */     }
/* 216 */     return this.persistingBeans.contains(persistingBean);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int depth(int diff) {
/* 237 */     this.depth += diff;
/* 238 */     return this.depth;
/*     */   }
/*     */   
/*     */   public boolean isReadOnly() {
/* 242 */     if (!isActive()) {
/* 243 */       throw new IllegalStateException("Transaction is Inactive");
/*     */     }
/*     */     try {
/* 246 */       return this.connection.isReadOnly();
/* 247 */     } catch (SQLException e) {
/* 248 */       throw new PersistenceException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setReadOnly(boolean readOnly) {
/* 253 */     if (!isActive()) {
/* 254 */       throw new IllegalStateException("Transaction is Inactive");
/*     */     }
/*     */     try {
/* 257 */       this.localReadOnly = readOnly;
/* 258 */       this.connection.setReadOnly(readOnly);
/* 259 */     } catch (SQLException e) {
/* 260 */       throw new PersistenceException(e);
/*     */     } 
/*     */   }
/*     */   
/*     */   public void setBatchMode(boolean batchMode) {
/* 265 */     if (!isActive()) {
/* 266 */       throw new IllegalStateException("Transaction is Inactive");
/*     */     }
/* 268 */     this.batchMode = batchMode;
/*     */   }
/*     */   
/*     */   public void setBatchGetGeneratedKeys(boolean getGeneratedKeys) {
/* 272 */     this.batchGetGeneratedKeys = Boolean.valueOf(getGeneratedKeys);
/* 273 */     if (this.batchControl != null) {
/* 274 */       this.batchControl.setGetGeneratedKeys(Boolean.valueOf(getGeneratedKeys));
/*     */     }
/*     */   }
/*     */   
/*     */   public void setBatchFlushOnMixed(boolean batchFlushOnMixed) {
/* 279 */     this.batchFlushOnMixed = Boolean.valueOf(batchFlushOnMixed);
/* 280 */     if (this.batchControl != null) {
/* 281 */       this.batchControl.setBatchFlushOnMixed(batchFlushOnMixed);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getBatchSize() {
/* 292 */     return this.batchSize;
/*     */   }
/*     */   
/*     */   public void setBatchSize(int batchSize) {
/* 296 */     this.batchSize = batchSize;
/* 297 */     if (this.batchControl != null) {
/* 298 */       this.batchControl.setBatchSize(batchSize);
/*     */     }
/*     */   }
/*     */   
/*     */   public boolean isBatchFlushOnQuery() {
/* 303 */     return this.batchFlushOnQuery;
/*     */   }
/*     */   
/*     */   public void setBatchFlushOnQuery(boolean batchFlushOnQuery) {
/* 307 */     this.batchFlushOnQuery = batchFlushOnQuery;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isBatchThisRequest() {
/* 315 */     if (!this.explicit && this.depth <= 0)
/*     */     {
/*     */       
/* 318 */       return false;
/*     */     }
/* 320 */     return this.batchMode;
/*     */   }
/*     */ 
/*     */   
/*     */   public BatchControl getBatchControl() {
/* 325 */     return this.batchControl;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBatchControl(BatchControl batchControl) {
/* 333 */     this.queryOnly = false;
/* 334 */     this.batchControl = batchControl;
/*     */     
/* 336 */     if (this.batchGetGeneratedKeys != null) {
/* 337 */       batchControl.setGetGeneratedKeys(this.batchGetGeneratedKeys);
/*     */     }
/* 339 */     if (this.batchSize != -1) {
/* 340 */       batchControl.setBatchSize(this.batchSize);
/*     */     }
/* 342 */     if (this.batchFlushOnMixed != null) {
/* 343 */       batchControl.setBatchFlushOnMixed(this.batchFlushOnMixed.booleanValue());
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void flushBatch() {
/* 355 */     if (!isActive()) {
/* 356 */       throw new IllegalStateException("Transaction is Inactive");
/*     */     }
/* 358 */     if (this.batchControl != null) {
/* 359 */       this.batchControl.flush();
/*     */     }
/*     */   }
/*     */   
/*     */   public void batchFlush() {
/* 364 */     flushBatch();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PersistenceContext getPersistenceContext() {
/* 372 */     return this.persistenceContext;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPersistenceContext(PersistenceContext context) {
/* 384 */     if (!isActive()) {
/* 385 */       throw new IllegalStateException("Transaction is Inactive");
/*     */     }
/* 387 */     this.persistenceContext = context;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public TransactionEvent getEvent() {
/* 394 */     this.queryOnly = false;
/* 395 */     if (this.event == null) {
/* 396 */       this.event = new TransactionEvent();
/*     */     }
/* 398 */     return this.event;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLoggingOn(boolean loggingOn) {
/* 405 */     if (loggingOn) {
/* 406 */       this.logLevel = LogLevel.SQL;
/*     */     } else {
/* 408 */       this.logLevel = LogLevel.NONE;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isExplicit() {
/* 416 */     return this.explicit;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isLogSql() {
/* 421 */     return (this.logLevel.ordinal() >= LogLevel.SQL.ordinal());
/*     */   }
/*     */   
/*     */   public boolean isLogSummary() {
/* 425 */     return (this.logLevel.ordinal() >= LogLevel.SUMMARY.ordinal());
/*     */   }
/*     */   
/*     */   public LogLevel getLogLevel() {
/* 429 */     return this.logLevel;
/*     */   }
/*     */   
/*     */   public void setLogLevel(LogLevel logLevel) {
/* 433 */     this.logLevel = logLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void log(String msg) {
/* 440 */     if (isLogSummary()) {
/* 441 */       logInternal(msg);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void logInternal(String msg) {
/* 450 */     if (this.manager != null && 
/* 451 */       this.logBuffer.add(msg)) {
/*     */       
/* 453 */       this.manager.log(this.logBuffer);
/* 454 */       this.logBuffer = this.logBuffer.newBuffer();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getId() {
/* 463 */     return this.id;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Connection getInternalConnection() {
/* 470 */     if (!isActive()) {
/* 471 */       throw new IllegalStateException("Transaction is Inactive");
/*     */     }
/* 473 */     return this.connection;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Connection getConnection() {
/* 480 */     this.queryOnly = false;
/* 481 */     return getInternalConnection();
/*     */   }
/*     */   
/*     */   protected void deactivate() {
/*     */     try {
/* 486 */       if (this.localReadOnly) {
/* 487 */         this.connection.setReadOnly(false);
/*     */       }
/* 489 */     } catch (SQLException e) {
/* 490 */       logger.log(Level.SEVERE, "Error setting to readOnly?", e);
/*     */     } 
/*     */     try {
/* 493 */       this.connection.close();
/* 494 */     } catch (Exception ex) {
/*     */ 
/*     */       
/* 497 */       logger.log(Level.SEVERE, "Error closing connection", ex);
/*     */     } 
/* 499 */     this.connection = null;
/* 500 */     this.active = false;
/*     */   }
/*     */   
/*     */   public TransactionLogBuffer getLogBuffer() {
/* 504 */     return this.logBuffer;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void notifyCommit() {
/* 511 */     if (this.manager == null) {
/*     */       return;
/*     */     }
/* 514 */     if (this.queryOnly) {
/* 515 */       this.manager.notifyOfQueryOnly(true, this, null);
/*     */     } else {
/* 517 */       this.manager.notifyOfCommit(this);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void commitQueryOnly() {
/*     */     try {
/* 530 */       switch (this.onQueryOnly) {
/*     */         case ROLLBACK:
/* 532 */           this.connection.rollback();
/*     */         
/*     */         case COMMIT:
/* 535 */           this.connection.commit();
/*     */ 
/*     */         
/*     */         case CLOSE_ON_READCOMMITTED:
/*     */           return;
/*     */       } 
/*     */       
/* 542 */       this.connection.rollback();
/*     */     }
/* 544 */     catch (SQLException e) {
/* 545 */       String m = "Error when ending a query only transaction via " + this.onQueryOnly;
/* 546 */       logger.log(Level.SEVERE, m, e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void commit() throws RollbackException {
/* 554 */     if (!isActive()) {
/* 555 */       throw new IllegalStateException("Transaction is Inactive");
/*     */     }
/*     */     try {
/* 558 */       if (this.queryOnly) {
/*     */         
/* 560 */         commitQueryOnly();
/*     */       } else {
/*     */         
/* 563 */         if (this.batchControl != null && !this.batchControl.isEmpty()) {
/* 564 */           this.batchControl.flush();
/*     */         }
/* 566 */         this.connection.commit();
/*     */       } 
/*     */       
/* 569 */       deactivate();
/* 570 */       notifyCommit();
/*     */     }
/* 572 */     catch (Exception e) {
/* 573 */       throw new RollbackException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void notifyRollback(Throwable cause) {
/* 581 */     if (this.manager == null) {
/*     */       return;
/*     */     }
/* 584 */     if (this.queryOnly) {
/* 585 */       this.manager.notifyOfQueryOnly(false, this, cause);
/*     */     } else {
/* 587 */       this.manager.notifyOfRollback(this, cause);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rollback() throws PersistenceException {
/* 595 */     rollback(null);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void rollback(Throwable cause) throws PersistenceException {
/* 603 */     if (!isActive()) {
/* 604 */       throw new IllegalStateException("Transaction is Inactive");
/*     */     }
/*     */     try {
/* 607 */       this.connection.rollback();
/*     */ 
/*     */       
/* 610 */       deactivate();
/* 611 */       notifyRollback(cause);
/*     */     }
/* 613 */     catch (Exception ex) {
/* 614 */       throw new PersistenceException(ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void end() throws PersistenceException {
/* 622 */     if (isActive()) {
/* 623 */       rollback();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isActive() {
/* 631 */     return this.active;
/*     */   }
/*     */   
/*     */   public boolean isPersistCascade() {
/* 635 */     return this.persistCascade;
/*     */   }
/*     */   
/*     */   public void setPersistCascade(boolean persistCascade) {
/* 639 */     this.persistCascade = persistCascade;
/*     */   }
/*     */   
/*     */   public void addModification(String tableName, boolean inserts, boolean updates, boolean deletes) {
/* 643 */     getEvent().add(tableName, inserts, updates, deletes);
/*     */   }
/*     */   
/*     */   public final TransactionManager getTransactionManger() {
/* 647 */     return this.manager;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\transaction\JdbcTransaction.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */