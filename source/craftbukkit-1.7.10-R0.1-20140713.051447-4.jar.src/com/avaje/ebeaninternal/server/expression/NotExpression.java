/*    */ package com.avaje.ebeaninternal.server.expression;
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
/*    */ final class NotExpression
/*    */   implements SpiExpression, LuceneAwareExpression
/*    */ {
/*    */   private static final long serialVersionUID = 5648926732402355781L;
/*    */   private static final String NOT = "not (";
/*    */   private final SpiExpression exp;
/*    */   
/*    */   NotExpression(Expression exp) {
/* 22 */     this.exp = (SpiExpression)exp;
/*    */   }
/*    */   
/*    */   public boolean isLuceneResolvable(LuceneResolvableRequest req) {
/* 26 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public SpiLuceneExpr createLuceneExpr(SpiExpressionRequest request) {
/* 32 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void containsMany(BeanDescriptor<?> desc, ManyWhereJoins manyWhereJoin) {
/* 41 */     this.exp.containsMany(desc, manyWhereJoin);
/*    */   }
/*    */   
/*    */   public void addBindValues(SpiExpressionRequest request) {
/* 45 */     this.exp.addBindValues(request);
/*    */   }
/*    */   
/*    */   public void addSql(SpiExpressionRequest request) {
/* 49 */     request.append("not (");
/* 50 */     this.exp.addSql(request);
/* 51 */     request.append(") ");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int queryAutoFetchHash() {
/* 58 */     int hc = NotExpression.class.getName().hashCode();
/* 59 */     hc = hc * 31 + this.exp.queryAutoFetchHash();
/* 60 */     return hc;
/*    */   }
/*    */   
/*    */   public int queryPlanHash(BeanQueryRequest<?> request) {
/* 64 */     int hc = NotExpression.class.getName().hashCode();
/* 65 */     hc = hc * 31 + this.exp.queryPlanHash(request);
/* 66 */     return hc;
/*    */   }
/*    */   
/*    */   public int queryBindHash() {
/* 70 */     return this.exp.queryBindHash();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\expression\NotExpression.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */