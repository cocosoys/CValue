package com.avaje.ebean.event;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.Transaction;
import java.util.Set;

public interface BeanPersistRequest<T> {
  EbeanServer getEbeanServer();
  
  Transaction getTransaction();
  
  Set<String> getLoadedProperties();
  
  Set<String> getUpdatedProperties();
  
  T getBean();
  
  T getOldValues();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\event\BeanPersistRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */