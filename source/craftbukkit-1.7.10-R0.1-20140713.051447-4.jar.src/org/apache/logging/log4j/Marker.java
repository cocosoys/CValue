package org.apache.logging.log4j;

import java.io.Serializable;

public interface Marker extends Serializable {
  String getName();
  
  Marker getParent();
  
  boolean isInstanceOf(Marker paramMarker);
  
  boolean isInstanceOf(String paramString);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\logging\log4j\Marker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */