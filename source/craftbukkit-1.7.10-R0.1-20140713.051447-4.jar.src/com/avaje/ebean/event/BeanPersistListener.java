package com.avaje.ebean.event;

import java.util.Set;

public interface BeanPersistListener<T> {
  boolean inserted(T paramT);
  
  boolean updated(T paramT, Set<String> paramSet);
  
  boolean deleted(T paramT);
  
  void remoteInsert(Object paramObject);
  
  void remoteUpdate(Object paramObject);
  
  void remoteDelete(Object paramObject);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\event\BeanPersistListener.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */