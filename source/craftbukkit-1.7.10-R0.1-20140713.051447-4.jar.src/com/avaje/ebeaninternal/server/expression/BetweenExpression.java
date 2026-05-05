/*    */ package com.avaje.ebeaninternal.server.expression;
/*    */ 
/*    */ import com.avaje.ebean.event.BeanQueryRequest;
/*    */ import com.avaje.ebeaninternal.api.SpiExpressionRequest;
/*    */ import com.avaje.ebeaninternal.api.SpiLuceneExpr;
/*    */ import java.util.Set;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class BetweenExpression
/*    */   extends AbstractExpression
/*    */ {
/*    */   private static final long serialVersionUID = 2078918165221454910L;
/*    */   private static final String BETWEEN = " between ";
/*    */   private final Object valueHigh;
/*    */   private final Object valueLow;
/*    */   
/*    */   BetweenExpression(FilterExprPath pathPrefix, String propertyName, Object valLo, Object valHigh) {
/* 21 */     super(pathPrefix, propertyName);
/* 22 */     this.valueLow = valLo;
/* 23 */     this.valueHigh = valHigh;
/*    */   }
/*    */   
/*    */   public boolean isLuceneResolvable(Set<String> indexedProperties) {
/* 27 */     return indexedProperties.contains(getPropertyName());
/*    */   }
/*    */   
/*    */   public SpiLuceneExpr createLuceneExpr(SpiExpressionRequest request) {
/* 31 */     return null;
/*    */   }
/*    */   
/*    */   public void addBindValues(SpiExpressionRequest request) {
/* 35 */     request.addBindValue(this.valueLow);
/* 36 */     request.addBindValue(this.valueHigh);
/*    */   }
/*    */ 
/*    */   
/*    */   public void addSql(SpiExpressionRequest request) {
/* 41 */     request.append(getPropertyName()).append(" between ").append(" ? and ? ");
/*    */   }
/*    */   
/*    */   public int queryAutoFetchHash() {
/* 45 */     int hc = BetweenExpression.class.getName().hashCode();
/* 46 */     hc = hc * 31 + this.propName.hashCode();
/* 47 */     return hc;
/*    */   }
/*    */   
/*    */   public int queryPlanHash(BeanQueryRequest<?> request) {
/* 51 */     return queryAutoFetchHash();
/*    */   }
/*    */   
/*    */   public int queryBindHash() {
/* 55 */     int hc = this.valueLow.hashCode();
/* 56 */     hc = hc * 31 + this.valueHigh.hashCode();
/* 57 */     return hc;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\expression\BetweenExpression.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */