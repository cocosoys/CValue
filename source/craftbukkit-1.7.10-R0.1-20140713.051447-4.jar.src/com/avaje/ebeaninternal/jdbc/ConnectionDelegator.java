/*     */ package com.avaje.ebeaninternal.jdbc;
/*     */ 
/*     */ import java.sql.CallableStatement;
/*     */ import java.sql.Connection;
/*     */ import java.sql.DatabaseMetaData;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.SQLWarning;
/*     */ import java.sql.Savepoint;
/*     */ import java.sql.Statement;
/*     */ import java.util.Map;
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
/*     */ public class ConnectionDelegator
/*     */   implements Connection
/*     */ {
/*     */   private final Connection delegate;
/*     */   
/*     */   public ConnectionDelegator(Connection delegate) {
/*  36 */     this.delegate = delegate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Statement createStatement() throws SQLException {
/*  42 */     return this.delegate.createStatement();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PreparedStatement prepareStatement(String sql) throws SQLException {
/*  48 */     return this.delegate.prepareStatement(sql);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CallableStatement prepareCall(String sql) throws SQLException {
/*  54 */     return this.delegate.prepareCall(sql);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String nativeSQL(String sql) throws SQLException {
/*  60 */     return this.delegate.nativeSQL(sql);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAutoCommit(boolean autoCommit) throws SQLException {
/*  66 */     this.delegate.setAutoCommit(autoCommit);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getAutoCommit() throws SQLException {
/*  72 */     return this.delegate.getAutoCommit();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void commit() throws SQLException {
/*  78 */     this.delegate.commit();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void rollback() throws SQLException {
/*  84 */     this.delegate.rollback();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws SQLException {
/*  90 */     this.delegate.close();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isClosed() throws SQLException {
/*  96 */     return this.delegate.isClosed();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public DatabaseMetaData getMetaData() throws SQLException {
/* 102 */     return this.delegate.getMetaData();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setReadOnly(boolean readOnly) throws SQLException {
/* 108 */     this.delegate.setReadOnly(readOnly);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isReadOnly() throws SQLException {
/* 114 */     return this.delegate.isReadOnly();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCatalog(String catalog) throws SQLException {
/* 120 */     this.delegate.setCatalog(catalog);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public String getCatalog() throws SQLException {
/* 126 */     return this.delegate.getCatalog();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTransactionIsolation(int level) throws SQLException {
/* 132 */     this.delegate.setTransactionIsolation(level);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTransactionIsolation() throws SQLException {
/* 138 */     return this.delegate.getTransactionIsolation();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SQLWarning getWarnings() throws SQLException {
/* 144 */     return this.delegate.getWarnings();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearWarnings() throws SQLException {
/* 150 */     this.delegate.clearWarnings();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Statement createStatement(int resultSetType, int resultSetConcurrency) throws SQLException {
/* 156 */     return this.delegate.createStatement(resultSetType, resultSetConcurrency);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
/* 162 */     return this.delegate.prepareStatement(sql, resultSetType, resultSetConcurrency);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency) throws SQLException {
/* 168 */     return this.delegate.prepareCall(sql, resultSetType, resultSetConcurrency);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Map<String, Class<?>> getTypeMap() throws SQLException {
/* 174 */     return this.delegate.getTypeMap();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTypeMap(Map<String, Class<?>> map) throws SQLException {
/* 180 */     this.delegate.setTypeMap(map);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHoldability(int holdability) throws SQLException {
/* 186 */     this.delegate.setHoldability(holdability);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHoldability() throws SQLException {
/* 192 */     return this.delegate.getHoldability();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Savepoint setSavepoint() throws SQLException {
/* 198 */     return this.delegate.setSavepoint();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Savepoint setSavepoint(String name) throws SQLException {
/* 204 */     return this.delegate.setSavepoint(name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void rollback(Savepoint savepoint) throws SQLException {
/* 210 */     this.delegate.rollback(savepoint);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void releaseSavepoint(Savepoint savepoint) throws SQLException {
/* 216 */     this.delegate.releaseSavepoint(savepoint);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Statement createStatement(int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
/* 222 */     return this.delegate.createStatement(resultSetType, resultSetConcurrency, resultSetHoldability);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PreparedStatement prepareStatement(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
/* 228 */     return this.delegate.prepareStatement(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public CallableStatement prepareCall(String sql, int resultSetType, int resultSetConcurrency, int resultSetHoldability) throws SQLException {
/* 234 */     return this.delegate.prepareCall(sql, resultSetType, resultSetConcurrency, resultSetHoldability);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PreparedStatement prepareStatement(String sql, int autoGeneratedKeys) throws SQLException {
/* 240 */     return this.delegate.prepareStatement(sql, autoGeneratedKeys);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PreparedStatement prepareStatement(String sql, int[] columnIndexes) throws SQLException {
/* 246 */     return this.delegate.prepareStatement(sql, columnIndexes);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public PreparedStatement prepareStatement(String sql, String[] columnNames) throws SQLException {
/* 252 */     return this.delegate.prepareStatement(sql, columnNames);
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\jdbc\ConnectionDelegator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */