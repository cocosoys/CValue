package org.apache.logging.log4j.status;

import org.apache.logging.log4j.Level;

public interface StatusListener {
  void log(StatusData paramStatusData);
  
  Level getStatusLevel();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\logging\log4j\status\StatusListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */