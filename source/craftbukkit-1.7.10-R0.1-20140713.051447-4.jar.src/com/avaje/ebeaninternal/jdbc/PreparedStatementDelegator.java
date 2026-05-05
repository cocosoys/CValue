/*     */ package com.avaje.ebeaninternal.jdbc;
/*     */ 
/*     */ import java.io.InputStream;
/*     */ import java.io.Reader;
/*     */ import java.math.BigDecimal;
/*     */ import java.net.URL;
/*     */ import java.sql.Array;
/*     */ import java.sql.Blob;
/*     */ import java.sql.Clob;
/*     */ import java.sql.Connection;
/*     */ import java.sql.Date;
/*     */ import java.sql.ParameterMetaData;
/*     */ import java.sql.PreparedStatement;
/*     */ import java.sql.Ref;
/*     */ import java.sql.ResultSet;
/*     */ import java.sql.ResultSetMetaData;
/*     */ import java.sql.SQLException;
/*     */ import java.sql.SQLWarning;
/*     */ import java.sql.Time;
/*     */ import java.sql.Timestamp;
/*     */ import java.util.Calendar;
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
/*     */ public class PreparedStatementDelegator
/*     */   implements PreparedStatement
/*     */ {
/*     */   private final PreparedStatement delegate;
/*     */   
/*     */   public PreparedStatementDelegator(PreparedStatement delegate) {
/*  46 */     this.delegate = delegate;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ResultSet executeQuery() throws SQLException {
/*  52 */     return this.delegate.executeQuery();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int executeUpdate() throws SQLException {
/*  58 */     return this.delegate.executeUpdate();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNull(int parameterIndex, int sqlType) throws SQLException {
/*  64 */     this.delegate.setNull(parameterIndex, sqlType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBoolean(int parameterIndex, boolean x) throws SQLException {
/*  70 */     this.delegate.setBoolean(parameterIndex, x);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setByte(int parameterIndex, byte x) throws SQLException {
/*  76 */     this.delegate.setByte(parameterIndex, x);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setShort(int parameterIndex, short x) throws SQLException {
/*  82 */     this.delegate.setShort(parameterIndex, x);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setInt(int parameterIndex, int x) throws SQLException {
/*  88 */     this.delegate.setInt(parameterIndex, x);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setLong(int parameterIndex, long x) throws SQLException {
/*  94 */     this.delegate.setLong(parameterIndex, x);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFloat(int parameterIndex, float x) throws SQLException {
/* 100 */     this.delegate.setFloat(parameterIndex, x);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDouble(int parameterIndex, double x) throws SQLException {
/* 106 */     this.delegate.setDouble(parameterIndex, x);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
/* 112 */     this.delegate.setBigDecimal(parameterIndex, x);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setString(int parameterIndex, String x) throws SQLException {
/* 118 */     this.delegate.setString(parameterIndex, x);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBytes(int parameterIndex, byte[] x) throws SQLException {
/* 124 */     this.delegate.setBytes(parameterIndex, x);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDate(int parameterIndex, Date x) throws SQLException {
/* 130 */     this.delegate.setDate(parameterIndex, x);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTime(int parameterIndex, Time x) throws SQLException {
/* 136 */     this.delegate.setTime(parameterIndex, x);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
/* 142 */     this.delegate.setTimestamp(parameterIndex, x);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
/* 148 */     this.delegate.setAsciiStream(parameterIndex, x, length);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
/* 155 */     this.delegate.setUnicodeStream(parameterIndex, x, length);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
/* 161 */     this.delegate.setBinaryStream(parameterIndex, x, length);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearParameters() throws SQLException {
/* 167 */     this.delegate.clearParameters();
/*     */   }
/*     */ 
/*     */   
/*     */   public void setObject(int i, Object o, int i1, int i2) throws SQLException {
/* 172 */     this.delegate.setObject(i, o, i1, i2);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
/* 178 */     this.delegate.setObject(parameterIndex, x, targetSqlType);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setObject(int parameterIndex, Object x) throws SQLException {
/* 184 */     this.delegate.setObject(parameterIndex, x);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean execute() throws SQLException {
/* 190 */     return this.delegate.execute();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addBatch() throws SQLException {
/* 196 */     this.delegate.addBatch();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
/* 202 */     this.delegate.setCharacterStream(parameterIndex, reader, length);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRef(int parameterIndex, Ref x) throws SQLException {
/* 208 */     this.delegate.setRef(parameterIndex, x);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setBlob(int parameterIndex, Blob x) throws SQLException {
/* 214 */     this.delegate.setBlob(parameterIndex, x);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setClob(int parameterIndex, Clob x) throws SQLException {
/* 220 */     this.delegate.setClob(parameterIndex, x);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setArray(int parameterIndex, Array x) throws SQLException {
/* 226 */     this.delegate.setArray(parameterIndex, x);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ResultSetMetaData getMetaData() throws SQLException {
/* 232 */     return this.delegate.getMetaData();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
/* 238 */     this.delegate.setDate(parameterIndex, x, cal);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
/* 244 */     this.delegate.setTime(parameterIndex, x, cal);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
/* 250 */     this.delegate.setTimestamp(parameterIndex, x, cal);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
/* 256 */     this.delegate.setNull(parameterIndex, sqlType, typeName);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setURL(int parameterIndex, URL x) throws SQLException {
/* 262 */     this.delegate.setURL(parameterIndex, x);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ParameterMetaData getParameterMetaData() throws SQLException {
/* 268 */     return this.delegate.getParameterMetaData();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ResultSet executeQuery(String sql) throws SQLException {
/* 274 */     return this.delegate.executeQuery(sql);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int executeUpdate(String sql) throws SQLException {
/* 280 */     return this.delegate.executeUpdate(sql);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void close() throws SQLException {
/* 286 */     this.delegate.close();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxFieldSize() throws SQLException {
/* 292 */     return this.delegate.getMaxFieldSize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxFieldSize(int max) throws SQLException {
/* 298 */     this.delegate.setMaxFieldSize(max);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxRows() throws SQLException {
/* 304 */     return this.delegate.getMaxRows();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxRows(int max) throws SQLException {
/* 310 */     this.delegate.setMaxRows(max);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEscapeProcessing(boolean enable) throws SQLException {
/* 316 */     this.delegate.setEscapeProcessing(enable);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getQueryTimeout() throws SQLException {
/* 322 */     return this.delegate.getQueryTimeout();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setQueryTimeout(int seconds) throws SQLException {
/* 328 */     this.delegate.setQueryTimeout(seconds);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void cancel() throws SQLException {
/* 334 */     this.delegate.cancel();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public SQLWarning getWarnings() throws SQLException {
/* 340 */     return this.delegate.getWarnings();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearWarnings() throws SQLException {
/* 346 */     this.delegate.clearWarnings();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCursorName(String name) throws SQLException {
/* 352 */     this.delegate.setCursorName(name);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean execute(String sql) throws SQLException {
/* 358 */     return this.delegate.execute(sql);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ResultSet getResultSet() throws SQLException {
/* 364 */     return this.delegate.getResultSet();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getUpdateCount() throws SQLException {
/* 370 */     return this.delegate.getUpdateCount();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getMoreResults() throws SQLException {
/* 376 */     return this.delegate.getMoreResults();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFetchDirection(int direction) throws SQLException {
/* 382 */     this.delegate.setFetchDirection(direction);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFetchDirection() throws SQLException {
/* 388 */     return this.delegate.getFetchDirection();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void setFetchSize(int rows) throws SQLException {
/* 394 */     this.delegate.setFetchSize(rows);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFetchSize() throws SQLException {
/* 400 */     return this.delegate.getFetchSize();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getResultSetConcurrency() throws SQLException {
/* 406 */     return this.delegate.getResultSetConcurrency();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getResultSetType() throws SQLException {
/* 412 */     return this.delegate.getResultSetType();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void addBatch(String sql) throws SQLException {
/* 418 */     this.delegate.addBatch(sql);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void clearBatch() throws SQLException {
/* 424 */     this.delegate.clearBatch();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int[] executeBatch() throws SQLException {
/* 430 */     return this.delegate.executeBatch();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Connection getConnection() throws SQLException {
/* 436 */     return this.delegate.getConnection();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean getMoreResults(int current) throws SQLException {
/* 442 */     return this.delegate.getMoreResults(current);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public ResultSet getGeneratedKeys() throws SQLException {
/* 448 */     return this.delegate.getGeneratedKeys();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int executeUpdate(String sql, int autoGeneratedKeys) throws SQLException {
/* 454 */     return this.delegate.executeUpdate(sql, autoGeneratedKeys);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int executeUpdate(String sql, int[] columnIndexes) throws SQLException {
/* 460 */     return this.delegate.executeUpdate(sql, columnIndexes);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int executeUpdate(String sql, String[] columnNames) throws SQLException {
/* 466 */     return this.delegate.executeUpdate(sql, columnNames);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean execute(String sql, int autoGeneratedKeys) throws SQLException {
/* 472 */     return this.delegate.execute(sql, autoGeneratedKeys);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean execute(String sql, int[] columnIndexes) throws SQLException {
/* 478 */     return this.delegate.execute(sql, columnIndexes);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean execute(String sql, String[] columnNames) throws SQLException {
/* 484 */     return this.delegate.execute(sql, columnNames);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public int getResultSetHoldability() throws SQLException {
/* 490 */     return this.delegate.getResultSetHoldability();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\jdbc\PreparedStatementDelegator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */