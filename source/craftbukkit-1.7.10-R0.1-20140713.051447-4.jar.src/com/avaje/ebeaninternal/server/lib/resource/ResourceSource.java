package com.avaje.ebeaninternal.server.lib.resource;

import java.io.IOException;

public interface ResourceSource {
  String getRealPath();
  
  ResourceContent getContent(String paramString);
  
  String readString(ResourceContent paramResourceContent, int paramInt) throws IOException;
  
  byte[] readBytes(ResourceContent paramResourceContent, int paramInt) throws IOException;
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lib\resource\ResourceSource.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */