package com.avaje.ebean.text.csv;

import com.avaje.ebean.EbeanServer;

public interface CsvCallback<T> {
  void begin(EbeanServer paramEbeanServer);
  
  void readHeader(String[] paramArrayOfString);
  
  boolean processLine(int paramInt, String[] paramArrayOfString);
  
  void processBean(int paramInt, String[] paramArrayOfString, T paramT);
  
  void end(int paramInt);
  
  void endWithError(int paramInt, Exception paramException);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\text\csv\CsvCallback.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */