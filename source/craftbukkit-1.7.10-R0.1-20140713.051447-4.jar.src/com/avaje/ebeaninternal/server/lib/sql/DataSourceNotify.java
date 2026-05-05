package com.avaje.ebeaninternal.server.lib.sql;

public interface DataSourceNotify {
  void notifyDataSourceUp(String paramString);
  
  void notifyDataSourceDown(String paramString);
  
  void notifyWarning(String paramString1, String paramString2);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lib\sql\DataSourceNotify.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */