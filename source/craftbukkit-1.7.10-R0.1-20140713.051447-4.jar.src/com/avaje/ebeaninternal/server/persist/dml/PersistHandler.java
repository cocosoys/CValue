package com.avaje.ebeaninternal.server.persist.dml;

import java.sql.SQLException;

public interface PersistHandler {
  String getBindLog();
  
  void bind() throws SQLException;
  
  void addBatch() throws SQLException;
  
  void execute() throws SQLException;
  
  void close() throws SQLException;
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\persist\dml\PersistHandler.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */