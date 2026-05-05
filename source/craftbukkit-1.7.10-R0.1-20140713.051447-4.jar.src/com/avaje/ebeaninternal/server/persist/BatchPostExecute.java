package com.avaje.ebeaninternal.server.persist;

import java.sql.SQLException;

public interface BatchPostExecute {
  void checkRowCount(int paramInt) throws SQLException;
  
  void setGeneratedKey(Object paramObject);
  
  void postExecute() throws SQLException;
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\persist\BatchPostExecute.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */