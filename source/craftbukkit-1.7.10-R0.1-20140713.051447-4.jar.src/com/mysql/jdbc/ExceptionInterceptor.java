package com.mysql.jdbc;

import java.sql.SQLException;

public interface ExceptionInterceptor extends Extension {
  SQLException interceptException(SQLException paramSQLException, Connection paramConnection);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\mysql\jdbc\ExceptionInterceptor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */