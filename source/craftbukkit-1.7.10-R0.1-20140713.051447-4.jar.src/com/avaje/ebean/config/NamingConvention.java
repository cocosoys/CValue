package com.avaje.ebean.config;

import com.avaje.ebean.config.dbplatform.DatabasePlatform;

public interface NamingConvention {
  void setDatabasePlatform(DatabasePlatform paramDatabasePlatform);
  
  TableName getTableName(Class<?> paramClass);
  
  TableName getM2MJoinTableName(TableName paramTableName1, TableName paramTableName2);
  
  String getColumnFromProperty(Class<?> paramClass, String paramString);
  
  String getPropertyFromColumn(Class<?> paramClass, String paramString);
  
  String getSequenceName(String paramString1, String paramString2);
  
  boolean isUseForeignKeyPrefix();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\config\NamingConvention.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */