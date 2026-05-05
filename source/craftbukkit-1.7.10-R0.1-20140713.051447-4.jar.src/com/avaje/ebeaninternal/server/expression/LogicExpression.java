/*     */ package com.avaje.ebeaninternal.server.expression;
/*     */ 
/*     */ import com.avaje.ebean.Expression;
/*     */ import com.avaje.ebean.event.BeanQueryRequest;
/*     */ import com.avaje.ebeaninternal.api.ManyWhereJoins;
/*     */ import com.avaje.ebeaninternal.api.SpiExpression;
/*     */ import com.avaje.ebeaninternal.api.SpiExpressionRequest;
/*     */ import com.avaje.ebeaninternal.api.SpiLuceneExpr;
/*     */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
/*     */ import com.avaje.ebeaninternal.server.query.LuceneResolvableRequest;
/*     */ 
/*     */ abstract class LogicExpression
/*     */   implements SpiExpression
/*     */ {
/*     */   private static final long serialVersionUID = 616860781960645251L;
/*     */   static final String AND = " and ";
/*     */   static final String OR = " or ";
/*     */   private final SpiExpression expOne;
/*     */   private final SpiExpression expTwo;
/*     */   private final String joinType;
/*     */   
/*     */   static class And
/*     */     extends LogicExpression
/*     */   {
/*     */     private static final long serialVersionUID = -3832889676798526444L;
/*     */     
/*     */     And(Expression expOne, Expression expTwo) {
/*  28 */       super(" and ", expOne, expTwo);
/*     */     }
/*     */   }
/*     */   
/*     */   static class Or
/*     */     extends LogicExpression {
/*     */     private static final long serialVersionUID = -6871993143194094819L;
/*     */     
/*     */     Or(Expression expOne, Expression expTwo) {
/*  37 */       super(" or ", expOne, expTwo);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   LogicExpression(String joinType, Expression expOne, Expression expTwo) {
/*  48 */     this.joinType = joinType;
/*  49 */     this.expOne = (SpiExpression)expOne;
/*  50 */     this.expTwo = (SpiExpression)expTwo;
/*     */   }
/*     */   
/*     */   public boolean isLuceneResolvable(LuceneResolvableRequest req) {
/*  54 */     return (this.expOne.isLuceneResolvable(req) && this.expTwo.isLuceneResolvable(req));
/*     */   }
/*     */ 
/*     */   
/*     */   public SpiLuceneExpr createLuceneExpr(SpiExpressionRequest request) {
/*  59 */     return (new LogicExpressionLucene()).addLuceneQuery(this.joinType, request, this.expOne, this.expTwo);
/*     */   }
/*     */   
/*     */   public void containsMany(BeanDescriptor<?> desc, ManyWhereJoins manyWhereJoin) {
/*  63 */     this.expOne.containsMany(desc, manyWhereJoin);
/*  64 */     this.expTwo.containsMany(desc, manyWhereJoin);
/*     */   }
/*     */   
/*     */   public void addBindValues(SpiExpressionRequest request) {
/*  68 */     this.expOne.addBindValues(request);
/*  69 */     this.expTwo.addBindValues(request);
/*     */   }
/*     */ 
/*     */   
/*     */   public void addSql(SpiExpressionRequest request) {
/*  74 */     request.append("(");
/*  75 */     this.expOne.addSql(request);
/*  76 */     request.append(this.joinType);
/*  77 */     this.expTwo.addSql(request);
/*  78 */     request.append(") ");
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int queryAutoFetchHash() {
/*  85 */     int hc = LogicExpression.class.getName().hashCode() + this.joinType.hashCode();
/*  86 */     hc = hc * 31 + this.expOne.queryAutoFetchHash();
/*  87 */     hc = hc * 31 + this.expTwo.queryAutoFetchHash();
/*  88 */     return hc;
/*     */   }
/*     */   
/*     */   public int queryPlanHash(BeanQueryRequest<?> request) {
/*  92 */     int hc = LogicExpression.class.getName().hashCode() + this.joinType.hashCode();
/*  93 */     hc = hc * 31 + this.expOne.queryPlanHash(request);
/*  94 */     hc = hc * 31 + this.expTwo.queryPlanHash(request);
/*  95 */     return hc;
/*     */   }
/*     */   
/*     */   public int queryBindHash() {
/*  99 */     int hc = this.expOne.queryBindHash();
/* 100 */     hc = hc * 31 + this.expTwo.queryBindHash();
/* 101 */     return hc;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\expression\LogicExpression.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */