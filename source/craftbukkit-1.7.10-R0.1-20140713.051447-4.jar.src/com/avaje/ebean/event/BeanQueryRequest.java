package com.avaje.ebean.event;

import com.avaje.ebean.EbeanServer;
import com.avaje.ebean.Query;
import com.avaje.ebean.Transaction;

public interface BeanQueryRequest<T> {
  EbeanServer getEbeanServer();
  
  Transaction getTransaction();
  
  Query<T> getQuery();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\event\BeanQueryRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */