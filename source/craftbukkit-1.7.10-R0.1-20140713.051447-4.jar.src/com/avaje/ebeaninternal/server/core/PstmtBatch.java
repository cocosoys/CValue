package com.avaje.ebeaninternal.server.core;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public interface PstmtBatch {
  void setBatchSize(PreparedStatement paramPreparedStatement, int paramInt);
  
  void addBatch(PreparedStatement paramPreparedStatement) throws SQLException;
  
  int executeBatch(PreparedStatement paramPreparedStatement, int paramInt, String paramString, boolean paramBoolean) throws SQLException;
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\core\PstmtBatch.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */