/*    */ package com.avaje.ebeaninternal.server.expression;
/*    */ 
/*    */ import com.avaje.ebean.event.BeanQueryRequest;
/*    */ import com.avaje.ebeaninternal.api.ManyWhereJoins;
/*    */ import com.avaje.ebeaninternal.api.SpiExpression;
/*    */ import com.avaje.ebeaninternal.api.SpiExpressionRequest;
/*    */ import com.avaje.ebeaninternal.api.SpiLuceneExpr;
/*    */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
/*    */ import com.avaje.ebeaninternal.server.query.LuceneResolvableRequest;
/*    */ import com.avaje.ebeaninternal.util.DefaultExpressionRequest;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class IdExpression
/*    */   implements SpiExpression
/*    */ {
/*    */   private static final long serialVersionUID = -3065936341718489842L;
/*    */   private final Object value;
/*    */   
/*    */   IdExpression(Object value) {
/* 23 */     this.value = value;
/*    */   }
/*    */   
/*    */   public boolean isLuceneResolvable(LuceneResolvableRequest req) {
/* 27 */     return false;
/*    */   }
/*    */   
/*    */   public SpiLuceneExpr createLuceneExpr(SpiExpressionRequest request) {
/* 31 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void containsMany(BeanDescriptor<?> desc, ManyWhereJoins manyWhereJoin) {}
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void addBindValues(SpiExpressionRequest request) {
/* 54 */     DefaultExpressionRequest r = (DefaultExpressionRequest)request;
/* 55 */     Object[] bindIdValues = r.getBeanDescriptor().getBindIdValues(this.value);
/* 56 */     for (int i = 0; i < bindIdValues.length; i++) {
/* 57 */       request.addBindValue(bindIdValues[i]);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void addSql(SpiExpressionRequest request) {
/* 63 */     DefaultExpressionRequest r = (DefaultExpressionRequest)request;
/* 64 */     String idSql = r.getBeanDescriptor().getIdBinderIdSql();
/*    */     
/* 66 */     request.append(idSql).append(" ");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int queryAutoFetchHash() {
/* 75 */     return IdExpression.class.getName().hashCode();
/*    */   }
/*    */   
/*    */   public int queryPlanHash(BeanQueryRequest<?> request) {
/* 79 */     return queryAutoFetchHash();
/*    */   }
/*    */   
/*    */   public int queryBindHash() {
/* 83 */     return this.value.hashCode();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\expression\IdExpression.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */