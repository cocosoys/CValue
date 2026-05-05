package com.avaje.ebeaninternal.api;

import com.avaje.ebean.Expression;
import com.avaje.ebean.event.BeanQueryRequest;
import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
import com.avaje.ebeaninternal.server.query.LuceneResolvableRequest;

public interface SpiExpression extends Expression {
  boolean isLuceneResolvable(LuceneResolvableRequest paramLuceneResolvableRequest);
  
  SpiLuceneExpr createLuceneExpr(SpiExpressionRequest paramSpiExpressionRequest);
  
  void containsMany(BeanDescriptor<?> paramBeanDescriptor, ManyWhereJoins paramManyWhereJoins);
  
  int queryAutoFetchHash();
  
  int queryPlanHash(BeanQueryRequest<?> paramBeanQueryRequest);
  
  int queryBindHash();
  
  void addSql(SpiExpressionRequest paramSpiExpressionRequest);
  
  void addBindValues(SpiExpressionRequest paramSpiExpressionRequest);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\api\SpiExpression.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */