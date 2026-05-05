/*    */ package com.avaje.ebeaninternal.server.ldap.expression;
/*    */ 
/*    */ import com.avaje.ebean.event.BeanQueryRequest;
/*    */ import com.avaje.ebeaninternal.api.SpiExpressionRequest;
/*    */ import com.avaje.ebeaninternal.api.SpiLuceneExpr;
/*    */ import com.avaje.ebeaninternal.server.query.LuceneResolvableRequest;
/*    */ 
/*    */ 
/*    */ class LdPresentExpression
/*    */   extends LdAbstractExpression
/*    */ {
/*    */   private static final long serialVersionUID = -4221300142054382003L;
/*    */   
/*    */   public LdPresentExpression(String propertyName) {
/* 15 */     super(propertyName);
/*    */   }
/*    */   
/*    */   public boolean isLuceneResolvable(LuceneResolvableRequest req) {
/* 19 */     return false;
/*    */   }
/*    */   
/*    */   public SpiLuceneExpr createLuceneExpr(SpiExpressionRequest request) {
/* 23 */     return null;
/*    */   }
/*    */   
/*    */   public String getPropertyName() {
/* 27 */     return this.propertyName;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void addBindValues(SpiExpressionRequest request) {}
/*    */ 
/*    */   
/*    */   public void addSql(SpiExpressionRequest request) {
/* 36 */     String parsed = request.parseDeploy(this.propertyName);
/* 37 */     request.append("(").append(parsed).append("=*").append(")");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int queryAutoFetchHash() {
/* 45 */     int hc = LdPresentExpression.class.getName().hashCode();
/* 46 */     hc = hc * 31 + this.propertyName.hashCode();
/* 47 */     return hc;
/*    */   }
/*    */   
/*    */   public int queryPlanHash(BeanQueryRequest<?> request) {
/* 51 */     return queryAutoFetchHash();
/*    */   }
/*    */   
/*    */   public int queryBindHash() {
/* 55 */     return 1;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\ldap\expression\LdPresentExpression.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */