/*    */ package com.avaje.ebeaninternal.server.expression;
/*    */ 
/*    */ import com.avaje.ebean.event.BeanQueryRequest;
/*    */ import com.avaje.ebeaninternal.api.SpiExpressionRequest;
/*    */ import com.avaje.ebeaninternal.api.SpiLuceneExpr;
/*    */ import com.avaje.ebeaninternal.server.query.LuceneResolvableRequest;
/*    */ import org.apache.lucene.queryParser.ParseException;
/*    */ import org.apache.lucene.queryParser.QueryParser;
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
/*    */ 
/*    */ 
/*    */ class LuceneExpression
/*    */   extends AbstractExpression
/*    */   implements LuceneAwareExpression
/*    */ {
/*    */   private static final long serialVersionUID = 8959252357123977939L;
/*    */   private final String val;
/*    */   private final boolean andOperator;
/*    */   
/*    */   LuceneExpression(FilterExprPath pathPrefix, String propertyName, String value, boolean andOperator) {
/* 40 */     super(pathPrefix, propertyName);
/* 41 */     this.val = value;
/* 42 */     this.andOperator = andOperator;
/*    */   }
/*    */   
/*    */   public boolean isLuceneResolvable(LuceneResolvableRequest req) {
/* 46 */     return true;
/*    */   }
/*    */ 
/*    */   
/*    */   public SpiLuceneExpr createLuceneExpr(SpiExpressionRequest request) {
/*    */     try {
/* 52 */       String propertyName = getPropertyName();
/*    */       
/* 54 */       String desc = propertyName + " " + this.val;
/*    */       
/* 56 */       QueryParser p = request.getLuceneIndex().createQueryParser(propertyName);
/* 57 */       p.setDefaultOperator(QueryParser.Operator.OR);
/* 58 */       return new LuceneExprResponse(p.parse(this.val), desc);
/* 59 */     } catch (ParseException e) {
/* 60 */       throw new PersistenceLuceneParseException(e);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void addBindValues(SpiExpressionRequest request) {}
/*    */ 
/*    */   
/*    */   public void addSql(SpiExpressionRequest request) {}
/*    */   
/*    */   public int queryPlanHash(BeanQueryRequest<?> request) {
/* 71 */     return queryAutoFetchHash();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int queryAutoFetchHash() {
/* 78 */     int hc = LuceneExpression.class.getName().hashCode();
/* 79 */     hc = hc * 31 + (this.andOperator ? 0 : 1);
/* 80 */     hc = hc * 31 + this.propName.hashCode();
/* 81 */     return hc;
/*    */   }
/*    */   
/*    */   public int queryBindHash() {
/* 85 */     return this.val.hashCode();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\expression\LuceneExpression.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */