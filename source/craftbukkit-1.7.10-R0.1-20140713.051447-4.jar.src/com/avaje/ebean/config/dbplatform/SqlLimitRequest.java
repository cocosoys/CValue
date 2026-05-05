package com.avaje.ebean.config.dbplatform;

public interface SqlLimitRequest {
  boolean isDistinct();
  
  int getFirstRow();
  
  int getMaxRows();
  
  String getDbSql();
  
  String getDbOrderBy();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\config\dbplatform\SqlLimitRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */