package org.apache.logging.log4j.spi;

import java.net.URI;

public interface LoggerContextFactory {
  LoggerContext getContext(String paramString, ClassLoader paramClassLoader, boolean paramBoolean);
  
  LoggerContext getContext(String paramString, ClassLoader paramClassLoader, boolean paramBoolean, URI paramURI);
  
  void removeContext(LoggerContext paramLoggerContext);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\logging\log4j\spi\LoggerContextFactory.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */