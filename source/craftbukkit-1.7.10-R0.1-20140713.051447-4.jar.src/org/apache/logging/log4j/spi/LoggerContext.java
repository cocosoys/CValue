package org.apache.logging.log4j.spi;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.message.MessageFactory;

public interface LoggerContext {
  Object getExternalContext();
  
  Logger getLogger(String paramString);
  
  Logger getLogger(String paramString, MessageFactory paramMessageFactory);
  
  boolean hasLogger(String paramString);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\logging\log4j\spi\LoggerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */