package com.mysql.jdbc.jmx;

import java.sql.SQLException;

public interface LoadBalanceConnectionGroupManagerMBean {
  int getActiveHostCount(String paramString);
  
  int getTotalHostCount(String paramString);
  
  long getTotalLogicalConnectionCount(String paramString);
  
  long getActiveLogicalConnectionCount(String paramString);
  
  long getActivePhysicalConnectionCount(String paramString);
  
  long getTotalPhysicalConnectionCount(String paramString);
  
  long getTotalTransactionCount(String paramString);
  
  void removeHost(String paramString1, String paramString2) throws SQLException;
  
  void stopNewConnectionsToHost(String paramString1, String paramString2) throws SQLException;
  
  void addHost(String paramString1, String paramString2, boolean paramBoolean);
  
  String getActiveHostsList(String paramString);
  
  String getRegisteredConnectionGroups();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\mysql\jdbc\jmx\LoadBalanceConnectionGroupManagerMBean.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */