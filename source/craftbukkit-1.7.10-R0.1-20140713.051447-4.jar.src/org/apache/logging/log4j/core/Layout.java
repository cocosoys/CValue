package org.apache.logging.log4j.core;

import java.util.Map;

public interface Layout<T extends java.io.Serializable> {
  byte[] getFooter();
  
  byte[] getHeader();
  
  byte[] toByteArray(LogEvent paramLogEvent);
  
  T toSerializable(LogEvent paramLogEvent);
  
  String getContentType();
  
  Map<String, String> getContentFormat();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\logging\log4j\core\Layout.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */