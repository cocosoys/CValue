package com.avaje.ebeaninternal.server.core;

import com.avaje.ebean.QueryIterator;
import com.avaje.ebean.bean.BeanCollection;
import com.avaje.ebeaninternal.api.BeanIdList;

public interface OrmQueryEngine {
  <T> T findId(OrmQueryRequest<T> paramOrmQueryRequest);
  
  <T> BeanCollection<T> findMany(OrmQueryRequest<T> paramOrmQueryRequest);
  
  <T> QueryIterator<T> findIterate(OrmQueryRequest<T> paramOrmQueryRequest);
  
  <T> int findRowCount(OrmQueryRequest<T> paramOrmQueryRequest);
  
  <T> BeanIdList findIds(OrmQueryRequest<T> paramOrmQueryRequest);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\core\OrmQueryEngine.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */