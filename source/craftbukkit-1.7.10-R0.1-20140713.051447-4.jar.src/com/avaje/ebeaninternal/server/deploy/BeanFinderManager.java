package com.avaje.ebeaninternal.server.deploy;

import com.avaje.ebean.event.BeanFinder;
import java.util.List;

public interface BeanFinderManager {
  int getRegisterCount();
  
  int createBeanFinders(List<Class<?>> paramList);
  
  <T> BeanFinder<T> getBeanFinder(Class<T> paramClass);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\deploy\BeanFinderManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */