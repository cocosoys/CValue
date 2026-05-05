/*    */ package com.avaje.ebeaninternal.server.expression;
/*    */ 
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
/*    */ class RawExpression
/*    */   implements SpiExpression
/*    */ {
/*    */   private static final long serialVersionUID = 7973903141340334606L;
/*    */   private final String sql;
/*    */   private final Object[] values;
/*    */   
/*    */   RawExpression(String sql, Object[] values) {
/* 21 */     this.sql = sql;
/* 22 */     this.values = values;
/*    */   }
/*    */   
/*    */   public boolean isLuceneResolvable(LuceneResolvableRequest req) {
/* 26 */     return false;
/*    */   }
/*    */   
/*    */   public SpiLuceneExpr createLuceneExpr(SpiExpressionRequest request) {
/* 30 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public void containsMany(BeanDescriptor<?> desc, ManyWhereJoins manyWhereJoin) {}
/*    */ 
/*    */   
/*    */   public void addBindValues(SpiExpressionRequest request) {
/* 38 */     if (this.values != null) {
/* 39 */       for (int i = 0; i < this.values.length; i++) {
/* 40 */         request.addBindValue(this.values[i]);
/*    */       }
/*    */     }
/*    */   }
/*    */   
/*    */   public void addSql(SpiExpressionRequest request) {
/* 46 */     request.append(this.sql);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int queryAutoFetchHash() {
/* 53 */     int hc = RawExpression.class.getName().hashCode();
/* 54 */     hc = hc * 31 + this.sql.hashCode();
/* 55 */     return hc;
/*    */   }
/*    */   
/*    */   public int queryPlanHash(BeanQueryRequest<?> request) {
/* 59 */     return queryAutoFetchHash();
/*    */   }
/*    */   
/*    */   public int queryBindHash() {
/* 63 */     return this.sql.hashCode();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\expression\RawExpression.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */