package com.avaje.ebean;

public interface AdminLogging {
  void setLogLevel(LogLevel paramLogLevel);
  
  LogLevel getLogLevel();
  
  boolean isDebugGeneratedSql();
  
  void setDebugGeneratedSql(boolean paramBoolean);
  
  boolean isDebugLazyLoad();
  
  void setDebugLazyLoad(boolean paramBoolean);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\AdminLogging.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */