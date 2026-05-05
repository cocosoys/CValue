package com.avaje.ebeaninternal.api;

import com.avaje.ebean.ExpressionFactory;
import com.avaje.ebean.ExpressionList;
import com.avaje.ebean.event.BeanQueryRequest;
import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
import com.avaje.ebeaninternal.server.query.LuceneResolvableRequest;
import java.util.ArrayList;

public interface SpiExpressionList<T> extends ExpressionList<T> {
  boolean isLuceneResolvable(LuceneResolvableRequest paramLuceneResolvableRequest);
  
  SpiLuceneExpr createLuceneExpr(SpiExpressionRequest paramSpiExpressionRequest, SpiLuceneExpr.ExprOccur paramExprOccur);
  
  void trimPath(int paramInt);
  
  void setExpressionFactory(ExpressionFactory paramExpressionFactory);
  
  void containsMany(BeanDescriptor<?> paramBeanDescriptor, ManyWhereJoins paramManyWhereJoins);
  
  boolean isEmpty();
  
  String buildSql(SpiExpressionRequest paramSpiExpressionRequest);
  
  ArrayList<Object> buildBindValues(SpiExpressionRequest paramSpiExpressionRequest);
  
  int queryPlanHash(BeanQueryRequest<?> paramBeanQueryRequest);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\api\SpiExpressionList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */