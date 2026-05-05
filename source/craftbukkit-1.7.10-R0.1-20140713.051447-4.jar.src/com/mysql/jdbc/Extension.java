package com.mysql.jdbc;

import java.sql.SQLException;
import java.util.Properties;

public interface Extension {
  void init(Connection paramConnection, Properties paramProperties) throws SQLException;
  
  void destroy();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\mysql\jdbc\Extension.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */