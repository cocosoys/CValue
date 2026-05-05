/*    */ package com.avaje.ebeaninternal.server.ldap.expression;
/*    */ 
/*    */ import com.avaje.ebean.event.BeanQueryRequest;
/*    */ import com.avaje.ebeaninternal.api.ManyWhereJoins;
/*    */ import com.avaje.ebeaninternal.api.SpiExpression;
/*    */ import com.avaje.ebeaninternal.api.SpiExpressionRequest;
/*    */ import com.avaje.ebeaninternal.api.SpiLuceneExpr;
/*    */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
/*    */ import com.avaje.ebeaninternal.server.deploy.BeanProperty;
/*    */ import com.avaje.ebeaninternal.server.query.LuceneResolvableRequest;
/*    */ import com.avaje.ebeaninternal.util.DefaultExpressionRequest;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class LdIdExpression
/*    */   extends LdAbstractExpression
/*    */   implements SpiExpression
/*    */ {
/*    */   private static final long serialVersionUID = -3065936341718489843L;
/*    */   private final Object value;
/*    */   
/*    */   LdIdExpression(Object value) {
/* 24 */     super(null);
/* 25 */     this.value = value;
/*    */   }
/*    */   
/*    */   public boolean isLuceneResolvable(LuceneResolvableRequest req) {
/* 29 */     return false;
/*    */   }
/*    */   
/*    */   public SpiLuceneExpr createLuceneExpr(SpiExpressionRequest request) {
/* 33 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void containsMany(BeanDescriptor<?> desc, ManyWhereJoins manyWhereJoin) {}
/*    */ 
/*    */ 
/*    */   
/*    */   public void addBindValues(SpiExpressionRequest request) {
/* 44 */     DefaultExpressionRequest r = (DefaultExpressionRequest)request;
/* 45 */     BeanProperty[] propertiesId = r.getBeanDescriptor().propertiesId();
/* 46 */     if (propertiesId.length > 1) {
/* 47 */       throw new RuntimeException("Only single Id property is supported for LDAP");
/*    */     }
/* 49 */     request.addBindValue(this.value);
/*    */   }
/*    */ 
/*    */   
/*    */   public void addSql(SpiExpressionRequest request) {
/* 54 */     DefaultExpressionRequest r = (DefaultExpressionRequest)request;
/* 55 */     BeanProperty[] propertiesId = r.getBeanDescriptor().propertiesId();
/* 56 */     if (propertiesId.length > 1) {
/* 57 */       throw new RuntimeException("Only single Id property is supported for LDAP");
/*    */     }
/*    */     
/* 60 */     String ldapProp = propertiesId[0].getDbColumn();
/* 61 */     request.append(ldapProp).append("=").append(nextParam(request));
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int queryAutoFetchHash() {
/* 70 */     return LdIdExpression.class.getName().hashCode();
/*    */   }
/*    */   
/*    */   public int queryPlanHash(BeanQueryRequest<?> request) {
/* 74 */     return queryAutoFetchHash();
/*    */   }
/*    */   
/*    */   public int queryBindHash() {
/* 78 */     return this.value.hashCode();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\ldap\expression\LdIdExpression.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */