/*    */ package com.avaje.ebeaninternal.server.ldap.expression;
/*    */ 
/*    */ import com.avaje.ebean.Expression;
/*    */ import com.avaje.ebean.event.BeanQueryRequest;
/*    */ import com.avaje.ebeaninternal.api.ManyWhereJoins;
/*    */ import com.avaje.ebeaninternal.api.SpiExpression;
/*    */ import com.avaje.ebeaninternal.api.SpiExpressionRequest;
/*    */ import com.avaje.ebeaninternal.api.SpiLuceneExpr;
/*    */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
/*    */ import com.avaje.ebeaninternal.server.query.LuceneResolvableRequest;
/*    */ 
/*    */ 
/*    */ 
/*    */ final class LdNotExpression
/*    */   implements SpiExpression
/*    */ {
/*    */   private static final long serialVersionUID = 5648926732402355782L;
/*    */   private static final String NOT = "!";
/*    */   private final SpiExpression exp;
/*    */   
/*    */   LdNotExpression(Expression exp) {
/* 22 */     this.exp = (SpiExpression)exp;
/*    */   }
/*    */   
/*    */   public boolean isLuceneResolvable(LuceneResolvableRequest req) {
/* 26 */     return this.exp.isLuceneResolvable(req);
/*    */   }
/*    */   
/*    */   public SpiLuceneExpr createLuceneExpr(SpiExpressionRequest request) {
/* 30 */     return null;
/*    */   }
/*    */   
/*    */   public void containsMany(BeanDescriptor<?> desc, ManyWhereJoins manyWhereJoin) {
/* 34 */     this.exp.containsMany(desc, manyWhereJoin);
/*    */   }
/*    */   
/*    */   public void addBindValues(SpiExpressionRequest request) {
/* 38 */     this.exp.addBindValues(request);
/*    */   }
/*    */   
/*    */   public void addSql(SpiExpressionRequest request) {
/* 42 */     request.append("(");
/* 43 */     request.append("!");
/* 44 */     this.exp.addSql(request);
/* 45 */     request.append(")");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int queryAutoFetchHash() {
/* 52 */     int hc = LdNotExpression.class.getName().hashCode();
/* 53 */     hc = hc * 31 + this.exp.queryAutoFetchHash();
/* 54 */     return hc;
/*    */   }
/*    */   
/*    */   public int queryPlanHash(BeanQueryRequest<?> request) {
/* 58 */     int hc = LdNotExpression.class.getName().hashCode();
/* 59 */     hc = hc * 31 + this.exp.queryPlanHash(request);
/* 60 */     return hc;
/*    */   }
/*    */   
/*    */   public int queryBindHash() {
/* 64 */     return this.exp.queryBindHash();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\ldap\expression\LdNotExpression.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */