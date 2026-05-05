/*     */ package com.avaje.ebean.config;
/*     */ 
/*     */ import com.avaje.ebeaninternal.server.lib.sql.TransactionIsolation;
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
/*     */ public class DataSourceConfig
/*     */ {
/*     */   private String url;
/*     */   private String username;
/*     */   private String password;
/*     */   private String driver;
/*  25 */   private int minConnections = 2;
/*     */   
/*  27 */   private int maxConnections = 20;
/*     */   
/*  29 */   private int isolationLevel = 2;
/*     */   
/*     */   private String heartbeatSql;
/*     */   
/*     */   private boolean captureStackTrace;
/*     */   
/*  35 */   private int maxStackTraceSize = 5;
/*     */   
/*  37 */   private int leakTimeMinutes = 30;
/*     */   
/*  39 */   private int maxInactiveTimeSecs = 900;
/*     */   
/*  41 */   private int pstmtCacheSize = 20;
/*  42 */   private int cstmtCacheSize = 20;
/*     */   
/*  44 */   private int waitTimeoutMillis = 1000;
/*     */ 
/*     */   
/*     */   private String poolListener;
/*     */ 
/*     */   
/*     */   private boolean offline;
/*     */ 
/*     */   
/*     */   public String getUrl() {
/*  54 */     return this.url;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUrl(String url) {
/*  61 */     this.url = url;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getUsername() {
/*  68 */     return this.username;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUsername(String username) {
/*  75 */     this.username = username;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPassword() {
/*  82 */     return this.password;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPassword(String password) {
/*  89 */     this.password = password;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getDriver() {
/*  96 */     return this.driver;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDriver(String driver) {
/* 103 */     this.driver = driver;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getIsolationLevel() {
/* 110 */     return this.isolationLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setIsolationLevel(int isolationLevel) {
/* 117 */     this.isolationLevel = isolationLevel;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMinConnections() {
/* 124 */     return this.minConnections;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMinConnections(int minConnections) {
/* 131 */     this.minConnections = minConnections;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxConnections() {
/* 138 */     return this.maxConnections;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxConnections(int maxConnections) {
/* 145 */     this.maxConnections = maxConnections;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getHeartbeatSql() {
/* 155 */     return this.heartbeatSql;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHeartbeatSql(String heartbeatSql) {
/* 165 */     this.heartbeatSql = heartbeatSql;
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
/*     */   public boolean isCaptureStackTrace() {
/* 180 */     return this.captureStackTrace;
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
/*     */   public void setCaptureStackTrace(boolean captureStackTrace) {
/* 194 */     this.captureStackTrace = captureStackTrace;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxStackTraceSize() {
/* 201 */     return this.maxStackTraceSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxStackTraceSize(int maxStackTraceSize) {
/* 208 */     this.maxStackTraceSize = maxStackTraceSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getLeakTimeMinutes() {
/* 216 */     return this.leakTimeMinutes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLeakTimeMinutes(int leakTimeMinutes) {
/* 224 */     this.leakTimeMinutes = leakTimeMinutes;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getPstmtCacheSize() {
/* 231 */     return this.pstmtCacheSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPstmtCacheSize(int pstmtCacheSize) {
/* 238 */     this.pstmtCacheSize = pstmtCacheSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getCstmtCacheSize() {
/* 245 */     return this.cstmtCacheSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCstmtCacheSize(int cstmtCacheSize) {
/* 252 */     this.cstmtCacheSize = cstmtCacheSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getWaitTimeoutMillis() {
/* 260 */     return this.waitTimeoutMillis;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setWaitTimeoutMillis(int waitTimeoutMillis) {
/* 268 */     this.waitTimeoutMillis = waitTimeoutMillis;
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
/*     */   public int getMaxInactiveTimeSecs() {
/* 280 */     return this.maxInactiveTimeSecs;
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
/*     */   public void setMaxInactiveTimeSecs(int maxInactiveTimeSecs) {
/* 292 */     this.maxInactiveTimeSecs = maxInactiveTimeSecs;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getPoolListener() {
/* 299 */     return this.poolListener;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setPoolListener(String poolListener) {
/* 307 */     this.poolListener = poolListener;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOffline() {
/* 318 */     return this.offline;
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
/*     */   public void setOffline(boolean offline) {
/* 333 */     this.offline = offline;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void loadSettings(String serverName) {
/* 341 */     String prefix = "datasource." + serverName + ".";
/*     */     
/* 343 */     this.username = GlobalProperties.get(prefix + "username", null);
/* 344 */     this.password = GlobalProperties.get(prefix + "password", null);
/*     */ 
/*     */ 
/*     */     
/* 348 */     String v = GlobalProperties.get(prefix + "databaseDriver", null);
/* 349 */     this.driver = GlobalProperties.get(prefix + "driver", v);
/*     */ 
/*     */     
/* 352 */     v = GlobalProperties.get(prefix + "databaseUrl", null);
/* 353 */     this.url = GlobalProperties.get(prefix + "url", v);
/*     */     
/* 355 */     this.captureStackTrace = GlobalProperties.getBoolean(prefix + "captureStackTrace", false);
/* 356 */     this.maxStackTraceSize = GlobalProperties.getInt(prefix + "maxStackTraceSize", 5);
/* 357 */     this.leakTimeMinutes = GlobalProperties.getInt(prefix + "leakTimeMinutes", 30);
/* 358 */     this.maxInactiveTimeSecs = GlobalProperties.getInt(prefix + "maxInactiveTimeSecs", 900);
/*     */     
/* 360 */     this.minConnections = GlobalProperties.getInt(prefix + "minConnections", 0);
/* 361 */     this.maxConnections = GlobalProperties.getInt(prefix + "maxConnections", 20);
/* 362 */     this.pstmtCacheSize = GlobalProperties.getInt(prefix + "pstmtCacheSize", 20);
/* 363 */     this.cstmtCacheSize = GlobalProperties.getInt(prefix + "cstmtCacheSize", 20);
/*     */     
/* 365 */     this.waitTimeoutMillis = GlobalProperties.getInt(prefix + "waitTimeout", 1000);
/*     */     
/* 367 */     this.heartbeatSql = GlobalProperties.get(prefix + "heartbeatSql", null);
/* 368 */     this.poolListener = GlobalProperties.get(prefix + "poolListener", null);
/* 369 */     this.offline = GlobalProperties.getBoolean(prefix + "offline", false);
/*     */     
/* 371 */     String isoLevel = GlobalProperties.get(prefix + "isolationlevel", "READ_COMMITTED");
/* 372 */     this.isolationLevel = TransactionIsolation.getLevel(isoLevel);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\config\DataSourceConfig.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */