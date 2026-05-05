/*     */ package com.avaje.ebeaninternal.server.lib.sql;
/*     */ 
/*     */ import com.avaje.ebean.config.DataSourceConfig;
/*     */ import com.avaje.ebeaninternal.api.ClassUtil;
/*     */ import com.avaje.ebeaninternal.server.lib.cron.CronManager;
/*     */ import java.io.PrintWriter;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DriverManager;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.Statement;
/*     */ import java.util.Properties;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.persistence.PersistenceException;
/*     */ import javax.sql.DataSource;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DataSourcePool
/*     */   implements DataSource
/*     */ {
/*  53 */   private static final Logger logger = Logger.getLogger(DataSourcePool.class.getName());
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String name;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final DataSourceNotify notify;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final DataSourcePoolListener poolListener;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Properties connectionProps;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String databaseUrl;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String databaseDriver;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final String heartbeatsql;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final int transactionIsolation;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean autoCommit;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean captureStackTrace;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int maxStackTraceSize;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean dataSourceDownAlertSent;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long lastTrimTime;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean dataSourceUp = true;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean inWarningMode;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int minConnections;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int maxConnections;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int warningSize;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int waitTimeoutMillis;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int pstmtCacheSize;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private int maxInactiveTimeSecs;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final PooledConnectionQueue queue;
/*     */ 
/*     */ 
/*     */   
/*     */   private long leakTimeMinutes;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DataSourcePool(DataSourceNotify notify, String name, DataSourceConfig params) {
/* 173 */     this.notify = notify;
/* 174 */     this.name = name;
/* 175 */     this.poolListener = createPoolListener(params.getPoolListener());
/*     */     
/* 177 */     this.autoCommit = false;
/* 178 */     this.transactionIsolation = params.getIsolationLevel();
/*     */     
/* 180 */     this.maxInactiveTimeSecs = params.getMaxInactiveTimeSecs();
/* 181 */     this.leakTimeMinutes = params.getLeakTimeMinutes();
/* 182 */     this.captureStackTrace = params.isCaptureStackTrace();
/* 183 */     this.maxStackTraceSize = params.getMaxStackTraceSize();
/* 184 */     this.databaseDriver = params.getDriver();
/* 185 */     this.databaseUrl = params.getUrl();
/* 186 */     this.pstmtCacheSize = params.getPstmtCacheSize();
/*     */     
/* 188 */     this.minConnections = params.getMinConnections();
/* 189 */     this.maxConnections = params.getMaxConnections();
/* 190 */     this.waitTimeoutMillis = params.getWaitTimeoutMillis();
/* 191 */     this.heartbeatsql = params.getHeartbeatSql();
/*     */     
/* 193 */     this.queue = new PooledConnectionQueue(this);
/*     */     
/* 195 */     String un = params.getUsername();
/* 196 */     String pw = params.getPassword();
/* 197 */     if (un == null) {
/* 198 */       throw new RuntimeException("DataSource user is null?");
/*     */     }
/* 200 */     if (pw == null) {
/* 201 */       throw new RuntimeException("DataSource password is null?");
/*     */     }
/* 203 */     this.connectionProps = new Properties();
/* 204 */     this.connectionProps.setProperty("user", un);
/* 205 */     this.connectionProps.setProperty("password", pw);
/*     */     
/*     */     try {
/* 208 */       initialise();
/* 209 */     } catch (SQLException ex) {
/* 210 */       throw new DataSourceException(ex);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private DataSourcePoolListener createPoolListener(String cn) {
/* 218 */     if (cn == null) {
/* 219 */       return null;
/*     */     }
/*     */     try {
/* 222 */       return (DataSourcePoolListener)ClassUtil.newInstance(cn, getClass());
/* 223 */     } catch (Exception e) {
/* 224 */       throw new DataSourceException(e);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void initialise() throws SQLException {
/*     */     try {
/* 232 */       ClassUtil.forName(this.databaseDriver, getClass());
/* 233 */     } catch (Throwable e) {
/* 234 */       throw new PersistenceException("Problem loading Database Driver [" + this.databaseDriver + "]: " + e.getMessage(), e);
/*     */     } 
/*     */ 
/*     */     
/* 238 */     String transIsolation = TransactionIsolation.getLevelDescription(this.transactionIsolation);
/* 239 */     StringBuffer sb = new StringBuffer();
/* 240 */     sb.append("DataSourcePool [").append(this.name);
/* 241 */     sb.append("] autoCommit[").append(this.autoCommit);
/* 242 */     sb.append("] transIsolation[").append(transIsolation);
/* 243 */     sb.append("] min[").append(this.minConnections);
/* 244 */     sb.append("] max[").append(this.maxConnections).append("]");
/*     */     
/* 246 */     logger.info(sb.toString());
/*     */     
/* 248 */     this.queue.ensureMinimumConnections();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isWrapperFor(Class<?> arg0) throws SQLException {
/* 255 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public <T> T unwrap(Class<T> arg0) throws SQLException {
/* 262 */     throw new SQLException("Not Implemented");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getName() {
/* 269 */     return this.name;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxStackTraceSize() {
/* 279 */     return this.maxStackTraceSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isDataSourceUp() {
/* 286 */     return this.dataSourceUp;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void notifyWarning(String msg) {
/* 294 */     if (!this.inWarningMode) {
/*     */       
/* 296 */       this.inWarningMode = true;
/* 297 */       logger.warning(msg);
/* 298 */       if (this.notify != null) {
/* 299 */         String subject = "DataSourcePool [" + this.name + "] warning";
/* 300 */         this.notify.notifyWarning(subject, msg);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void notifyDataSourceIsDown(SQLException ex) {
/* 307 */     if (isExpectedToBeDownNow()) {
/* 308 */       if (this.dataSourceUp) {
/* 309 */         String msg = "DataSourcePool [" + this.name + "] is down but in downtime!";
/* 310 */         logger.log(Level.WARNING, msg, ex);
/*     */       }
/*     */     
/* 313 */     } else if (!this.dataSourceDownAlertSent) {
/*     */       
/* 315 */       String msg = "FATAL: DataSourcePool [" + this.name + "] is down!!!";
/* 316 */       logger.log(Level.SEVERE, msg, ex);
/* 317 */       if (this.notify != null) {
/* 318 */         this.notify.notifyDataSourceDown(this.name);
/*     */       }
/* 320 */       this.dataSourceDownAlertSent = true;
/*     */     } 
/*     */     
/* 323 */     if (this.dataSourceUp) {
/* 324 */       reset();
/*     */     }
/* 326 */     this.dataSourceUp = false;
/*     */   }
/*     */   
/*     */   private void notifyDataSourceIsUp() {
/* 330 */     if (this.dataSourceDownAlertSent) {
/* 331 */       String msg = "RESOLVED FATAL: DataSourcePool [" + this.name + "] is back up!";
/* 332 */       logger.log(Level.SEVERE, msg);
/* 333 */       if (this.notify != null) {
/* 334 */         this.notify.notifyDataSourceUp(this.name);
/*     */       }
/* 336 */       this.dataSourceDownAlertSent = false;
/*     */     }
/* 338 */     else if (!this.dataSourceUp) {
/* 339 */       logger.log(Level.WARNING, "DataSourcePool [" + this.name + "] is back up!");
/*     */     } 
/*     */     
/* 342 */     if (!this.dataSourceUp) {
/* 343 */       this.dataSourceUp = true;
/* 344 */       reset();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void checkDataSource() {
/* 352 */     Connection conn = null;
/*     */     
/*     */     try {
/* 355 */       conn = getConnection();
/* 356 */       testConnection(conn);
/*     */       
/* 358 */       notifyDataSourceIsUp();
/*     */       
/* 360 */       if (System.currentTimeMillis() > this.lastTrimTime + (this.maxInactiveTimeSecs * 1000)) {
/* 361 */         this.queue.trim(this.maxInactiveTimeSecs);
/* 362 */         this.lastTrimTime = System.currentTimeMillis();
/*     */       }
/*     */     
/* 365 */     } catch (SQLException ex) {
/* 366 */       notifyDataSourceIsDown(ex);
/*     */     } finally {
/*     */       try {
/* 369 */         if (conn != null) {
/* 370 */           conn.close();
/*     */         }
/* 372 */       } catch (SQLException ex) {
/* 373 */         logger.log(Level.WARNING, "Can't close connection in checkDataSource!");
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isExpectedToBeDownNow() {
/* 383 */     return CronManager.isDowntime();
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
/*     */   public Connection createUnpooledConnection() throws SQLException {
/*     */     try {
/* 401 */       Connection conn = DriverManager.getConnection(this.databaseUrl, this.connectionProps);
/* 402 */       conn.setAutoCommit(this.autoCommit);
/* 403 */       conn.setTransactionIsolation(this.transactionIsolation);
/* 404 */       return conn;
/*     */     }
/* 406 */     catch (SQLException ex) {
/* 407 */       notifyDataSourceIsDown(null);
/* 408 */       throw ex;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxSize(int max) {
/* 418 */     this.queue.setMaxSize(max);
/* 419 */     this.maxConnections = max;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxSize() {
/* 426 */     return this.maxConnections;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinSize(int min) {
/* 433 */     this.queue.setMinSize(min);
/* 434 */     this.minConnections = min;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMinSize() {
/* 441 */     return this.minConnections;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWarningSize(int warningSize) {
/* 451 */     this.queue.setWarningSize(warningSize);
/* 452 */     this.warningSize = warningSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWarningSize() {
/* 460 */     return this.warningSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWaitTimeoutMillis() {
/* 469 */     return this.waitTimeoutMillis;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxInactiveTimeSecs(int maxInactiveTimeSecs) {
/* 476 */     this.maxInactiveTimeSecs = maxInactiveTimeSecs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxInactiveTimeSecs() {
/* 483 */     return this.maxInactiveTimeSecs;
/*     */   }
/*     */ 
/*     */   
/*     */   private void testConnection(Connection conn) throws SQLException {
/* 488 */     if (this.heartbeatsql == null) {
/*     */       return;
/*     */     }
/* 491 */     Statement stmt = null;
/* 492 */     ResultSet rset = null;
/*     */ 
/*     */     
/*     */     try {
/* 496 */       stmt = conn.createStatement();
/* 497 */       rset = stmt.executeQuery(this.heartbeatsql);
/* 498 */       conn.commit();
/*     */     } finally {
/*     */       
/*     */       try {
/* 502 */         if (rset != null) {
/* 503 */           rset.close();
/*     */         }
/* 505 */       } catch (SQLException e) {
/* 506 */         logger.log(Level.SEVERE, (String)null, e);
/*     */       } 
/*     */       try {
/* 509 */         if (stmt != null) {
/* 510 */           stmt.close();
/*     */         }
/* 512 */       } catch (SQLException e) {
/* 513 */         logger.log(Level.SEVERE, (String)null, e);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean validateConnection(PooledConnection conn) {
/*     */     try {
/* 524 */       if (this.heartbeatsql == null) {
/* 525 */         logger.info("Can not test connection as heartbeatsql is not set");
/* 526 */         return false;
/*     */       } 
/*     */       
/* 529 */       testConnection((Connection)conn);
/* 530 */       return true;
/*     */     }
/* 532 */     catch (Exception e) {
/* 533 */       String desc = "heartbeatsql test failed on connection[" + conn.getName() + "]";
/* 534 */       logger.warning(desc);
/* 535 */       return false;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void returnConnection(PooledConnection pooledConnection) {
/* 554 */     if (this.poolListener != null) {
/* 555 */       this.poolListener.onBeforeReturnConnection((Connection)pooledConnection);
/*     */     }
/* 557 */     this.queue.returnPooledConnection(pooledConnection);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBusyConnectionInformation() {
/* 565 */     return this.queue.getBusyConnectionInformation();
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
/*     */   public void dumpBusyConnectionInformation() {
/* 577 */     this.queue.dumpBusyConnectionInformation();
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
/*     */   public void closeBusyConnections(long leakTimeMinutes) {
/* 594 */     this.queue.closeBusyConnections(leakTimeMinutes);
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
/*     */   protected PooledConnection createConnectionForQueue(int connId) throws SQLException {
/*     */     try {
/* 607 */       Connection c = createUnpooledConnection();
/*     */       
/* 609 */       PooledConnection pc = new PooledConnection(this, connId, c);
/* 610 */       pc.resetForUse();
/*     */       
/* 612 */       if (!this.dataSourceUp) {
/* 613 */         notifyDataSourceIsUp();
/*     */       }
/* 615 */       return pc;
/*     */     }
/* 617 */     catch (SQLException ex) {
/* 618 */       notifyDataSourceIsDown(ex);
/* 619 */       throw ex;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 638 */     this.queue.reset(this.leakTimeMinutes);
/* 639 */     this.inWarningMode = false;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Connection getConnection() throws SQLException {
/* 646 */     return (Connection)getPooledConnection();
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
/*     */   public PooledConnection getPooledConnection() throws SQLException {
/* 658 */     PooledConnection c = this.queue.getPooledConnection();
/*     */     
/* 660 */     if (this.captureStackTrace) {
/* 661 */       c.setStackTrace(Thread.currentThread().getStackTrace());
/*     */     }
/*     */     
/* 664 */     if (this.poolListener != null) {
/* 665 */       this.poolListener.onAfterBorrowConnection((Connection)c);
/*     */     }
/* 667 */     return c;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void testAlert() {
/* 676 */     String subject = "Test DataSourcePool [" + this.name + "]";
/* 677 */     String msg = "Just testing if alert message is sent successfully.";
/*     */     
/* 679 */     if (this.notify != null) {
/* 680 */       this.notify.notifyWarning(subject, msg);
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
/*     */ 
/*     */   
/*     */   public void shutdown() {
/* 694 */     this.queue.shutdown();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getAutoCommit() {
/* 703 */     return this.autoCommit;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTransactionIsolation() {
/* 713 */     return this.transactionIsolation;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCaptureStackTrace() {
/* 724 */     return this.captureStackTrace;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCaptureStackTrace(boolean captureStackTrace) {
/* 733 */     this.captureStackTrace = captureStackTrace;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Connection getConnection(String username, String password) throws SQLException {
/* 740 */     throw new SQLException("Method not supported");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLoginTimeout() throws SQLException {
/* 747 */     throw new SQLException("Method not supported");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLoginTimeout(int seconds) throws SQLException {
/* 754 */     throw new SQLException("Method not supported");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public PrintWriter getLogWriter() {
/* 761 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLogWriter(PrintWriter writer) throws SQLException {
/* 768 */     throw new SQLException("Method not supported");
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
/*     */   public void setLeakTimeMinutes(long leakTimeMinutes) {
/* 782 */     this.leakTimeMinutes = leakTimeMinutes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLeakTimeMinutes() {
/* 790 */     return this.leakTimeMinutes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPstmtCacheSize() {
/* 797 */     return this.pstmtCacheSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPstmtCacheSize(int pstmtCacheSize) {
/* 804 */     this.pstmtCacheSize = pstmtCacheSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Status getStatus(boolean reset) {
/* 815 */     return this.queue.getStatus(reset);
/*     */   }
/*     */ 
/*     */   
/*     */   public static class Status
/*     */   {
/*     */     private final String name;
/*     */     private final int minSize;
/*     */     private final int maxSize;
/*     */     private final int free;
/*     */     private final int busy;
/*     */     private final int waiting;
/*     */     private final int highWaterMark;
/*     */     private final int waitCount;
/*     */     private final int hitCount;
/*     */     
/*     */     protected Status(String name, int minSize, int maxSize, int free, int busy, int waiting, int highWaterMark, int waitCount, int hitCount) {
/* 832 */       this.name = name;
/* 833 */       this.minSize = minSize;
/* 834 */       this.maxSize = maxSize;
/* 835 */       this.free = free;
/* 836 */       this.busy = busy;
/* 837 */       this.waiting = waiting;
/* 838 */       this.highWaterMark = highWaterMark;
/* 839 */       this.waitCount = waitCount;
/* 840 */       this.hitCount = hitCount;
/*     */     }
/*     */     
/*     */     public String toString() {
/* 844 */       return "min:" + this.minSize + " max:" + this.maxSize + " free:" + this.free + " busy:" + this.busy + " waiting:" + this.waiting + " highWaterMark:" + this.highWaterMark + " waitCount:" + this.waitCount + " hitCount:" + this.hitCount;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public String getName() {
/* 852 */       return this.name;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getMinSize() {
/* 859 */       return this.minSize;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getMaxSize() {
/* 866 */       return this.maxSize;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getFree() {
/* 873 */       return this.free;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getBusy() {
/* 880 */       return this.busy;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getWaiting() {
/* 887 */       return this.waiting;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getHighWaterMark() {
/* 894 */       return this.highWaterMark;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getWaitCount() {
/* 901 */       return this.waitCount;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/*     */     public int getHitCount() {
/* 913 */       return this.hitCount;
/*     */     }
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lib\sql\DataSourcePool.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */