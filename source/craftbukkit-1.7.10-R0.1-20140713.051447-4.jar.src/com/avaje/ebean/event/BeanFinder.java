package com.avaje.ebean.event;

import com.avaje.ebean.bean.BeanCollection;

public interface BeanFinder<T> {
  T find(BeanQueryRequest<T> paramBeanQueryRequest);
  
  BeanCollection<T> findMany(BeanQueryRequest<T> paramBeanQueryRequest);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\event\BeanFinder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */