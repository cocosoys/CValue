package com.avaje.ebean.config.dbplatform;

public interface SqlLimiter {
  public static final char NEW_LINE = '\n';
  
  public static final char CARRIAGE_RETURN = '\r';
  
  SqlLimitResponse limit(SqlLimitRequest paramSqlLimitRequest);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\config\dbplatform\SqlLimiter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */