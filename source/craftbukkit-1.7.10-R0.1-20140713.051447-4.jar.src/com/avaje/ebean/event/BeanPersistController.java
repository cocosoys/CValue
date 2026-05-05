package com.avaje.ebean.event;

import java.util.Set;

public interface BeanPersistController {
  int getExecutionOrder();
  
  boolean isRegisterFor(Class<?> paramClass);
  
  boolean preInsert(BeanPersistRequest<?> paramBeanPersistRequest);
  
  boolean preUpdate(BeanPersistRequest<?> paramBeanPersistRequest);
  
  boolean preDelete(BeanPersistRequest<?> paramBeanPersistRequest);
  
  void postInsert(BeanPersistRequest<?> paramBeanPersistRequest);
  
  void postUpdate(BeanPersistRequest<?> paramBeanPersistRequest);
  
  void postDelete(BeanPersistRequest<?> paramBeanPersistRequest);
  
  void postLoad(Object paramObject, Set<String> paramSet);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\event\BeanPersistController.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */