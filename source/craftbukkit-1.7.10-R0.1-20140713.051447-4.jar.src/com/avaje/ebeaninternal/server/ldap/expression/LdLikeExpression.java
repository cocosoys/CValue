/*    */ package com.avaje.ebeaninternal.server.ldap.expression;
/*    */ 
/*    */ import com.avaje.ebean.event.BeanQueryRequest;
/*    */ import com.avaje.ebeaninternal.api.SpiExpressionRequest;
/*    */ import com.avaje.ebeaninternal.api.SpiLuceneExpr;
/*    */ import com.avaje.ebeaninternal.server.query.LuceneResolvableRequest;
/*    */ 
/*    */ class LdLikeExpression
/*    */   extends LdAbstractExpression
/*    */ {
/*    */   private static final long serialVersionUID = 4091359751840929076L;
/*    */   private final String value;
/*    */   
/*    */   public LdLikeExpression(String propertyName, String value) {
/* 15 */     super(propertyName);
/* 16 */     this.value = value;
/*    */   }
/*    */   
/*    */   public boolean isLuceneResolvable(LuceneResolvableRequest req) {
/* 20 */     return false;
/*    */   }
/*    */   
/*    */   public SpiLuceneExpr createLuceneExpr(SpiExpressionRequest request) {
/* 24 */     return null;
/*    */   }
/*    */   
/*    */   public String getPropertyName() {
/* 28 */     return this.propertyName;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void addBindValues(SpiExpressionRequest request) {}
/*    */ 
/*    */   
/*    */   public void addSql(SpiExpressionRequest request) {
/*    */     String escapedValue;
/* 38 */     if (this.value == null) {
/* 39 */       escapedValue = "*";
/*    */     } else {
/* 41 */       escapedValue = LdEscape.forLike(this.value);
/*    */     } 
/*    */     
/* 44 */     String parsed = request.parseDeploy(this.propertyName);
/*    */     
/* 46 */     request.append("(").append(parsed).append("=").append(escapedValue).append(")");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int queryAutoFetchHash() {
/* 54 */     int hc = LdLikeExpression.class.getName().hashCode();
/* 55 */     hc = hc * 31 + this.propertyName.hashCode();
/* 56 */     return hc;
/*    */   }
/*    */   
/*    */   public int queryPlanHash(BeanQueryRequest<?> request) {
/* 60 */     return queryAutoFetchHash();
/*    */   }
/*    */   
/*    */   public int queryBindHash() {
/* 64 */     return this.value.hashCode();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\ldap\expression\LdLikeExpression.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */