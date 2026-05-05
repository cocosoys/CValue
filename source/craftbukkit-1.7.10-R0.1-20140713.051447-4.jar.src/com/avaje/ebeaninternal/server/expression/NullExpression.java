/*    */ package com.avaje.ebeaninternal.server.expression;
/*    */ 
/*    */ import com.avaje.ebean.event.BeanQueryRequest;
/*    */ import com.avaje.ebeaninternal.api.SpiExpressionRequest;
/*    */ import com.avaje.ebeaninternal.api.SpiLuceneExpr;
/*    */ import com.avaje.ebeaninternal.server.el.ElPropertyValue;
/*    */ import com.avaje.ebeaninternal.server.query.LuceneResolvableRequest;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class NullExpression
/*    */   extends AbstractExpression
/*    */ {
/*    */   private static final long serialVersionUID = 4246991057451128269L;
/*    */   private final boolean notNull;
/*    */   
/*    */   NullExpression(FilterExprPath pathPrefix, String propertyName, boolean notNull) {
/* 20 */     super(pathPrefix, propertyName);
/* 21 */     this.notNull = notNull;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isLuceneResolvable(LuceneResolvableRequest req) {
/* 26 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public SpiLuceneExpr createLuceneExpr(SpiExpressionRequest request) {
/* 31 */     return null;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void addBindValues(SpiExpressionRequest request) {}
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void addSql(SpiExpressionRequest request) {
/* 44 */     String propertyName = getPropertyName();
/*    */     
/* 46 */     String nullExpr = this.notNull ? " is not null " : " is null ";
/*    */     
/* 48 */     ElPropertyValue prop = getElProp(request);
/* 49 */     if (prop != null && prop.isAssocId()) {
/* 50 */       request.append(prop.getAssocOneIdExpr(propertyName, nullExpr));
/*    */       
/*    */       return;
/*    */     } 
/* 54 */     request.append(propertyName).append(nullExpr);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int queryAutoFetchHash() {
/* 61 */     int hc = NullExpression.class.getName().hashCode();
/* 62 */     hc = hc * 31 + (this.notNull ? 1 : 0);
/* 63 */     hc = hc * 31 + this.propName.hashCode();
/* 64 */     return hc;
/*    */   }
/*    */   
/*    */   public int queryPlanHash(BeanQueryRequest<?> request) {
/* 68 */     return queryAutoFetchHash();
/*    */   }
/*    */   
/*    */   public int queryBindHash() {
/* 72 */     return this.notNull ? 1 : 0;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\expression\NullExpression.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */