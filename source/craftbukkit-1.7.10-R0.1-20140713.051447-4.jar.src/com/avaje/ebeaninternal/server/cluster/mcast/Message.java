package com.avaje.ebeaninternal.server.cluster.mcast;

import com.avaje.ebeaninternal.server.cluster.BinaryMessageList;
import java.io.IOException;

public interface Message {
  void writeBinaryMessage(BinaryMessageList paramBinaryMessageList) throws IOException;
  
  boolean isControlMessage();
  
  String getToHostPort();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\cluster\mcast\Message.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */