package com.mysql.jdbc;

import java.sql.SQLException;
import java.sql.Savepoint;

public interface ConnectionLifecycleInterceptor extends Extension {
  void close() throws SQLException;
  
  boolean commit() throws SQLException;
  
  boolean rollback() throws SQLException;
  
  boolean rollback(Savepoint paramSavepoint) throws SQLException;
  
  boolean setAutoCommit(boolean paramBoolean) throws SQLException;
  
  boolean setCatalog(String paramString) throws SQLException;
  
  boolean transactionBegun() throws SQLException;
  
  boolean transactionCompleted() throws SQLException;
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\mysql\jdbc\ConnectionLifecycleInterceptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */