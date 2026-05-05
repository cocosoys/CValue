/*    */ package com.avaje.ebeaninternal.util;
/*    */ 
/*    */ import com.avaje.ebeaninternal.api.SpiExpressionRequest;
/*    */ import com.avaje.ebeaninternal.server.core.SpiOrmQueryRequest;
/*    */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
/*    */ import com.avaje.ebeaninternal.server.deploy.DeployParser;
/*    */ import com.avaje.ebeaninternal.server.lucene.LIndex;
/*    */ import java.util.ArrayList;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DefaultExpressionRequest
/*    */   implements SpiExpressionRequest
/*    */ {
/*    */   private final SpiOrmQueryRequest<?> queryRequest;
/*    */   private final BeanDescriptor<?> beanDescriptor;
/* 17 */   private final StringBuilder sb = new StringBuilder();
/*    */   
/* 19 */   private final ArrayList<Object> bindValues = new ArrayList();
/*    */   
/*    */   private final DeployParser deployParser;
/*    */   
/*    */   private int paramIndex;
/*    */   
/*    */   private LIndex luceneIndex;
/*    */   
/*    */   public DefaultExpressionRequest(SpiOrmQueryRequest<?> queryRequest, DeployParser deployParser) {
/* 28 */     this.queryRequest = queryRequest;
/* 29 */     this.beanDescriptor = queryRequest.getBeanDescriptor();
/* 30 */     this.deployParser = deployParser;
/*    */   }
/*    */   
/*    */   public DefaultExpressionRequest(SpiOrmQueryRequest<?> queryRequest, LIndex index) {
/* 34 */     this.queryRequest = queryRequest;
/* 35 */     this.beanDescriptor = queryRequest.getBeanDescriptor();
/* 36 */     this.deployParser = null;
/* 37 */     this.luceneIndex = index;
/*    */   }
/*    */   
/*    */   public DefaultExpressionRequest(BeanDescriptor<?> beanDescriptor) {
/* 41 */     this.beanDescriptor = beanDescriptor;
/* 42 */     this.queryRequest = null;
/* 43 */     this.deployParser = null;
/*    */   }
/*    */   
/*    */   public LIndex getLuceneIndex() {
/* 47 */     return this.luceneIndex;
/*    */   }
/*    */ 
/*    */   
/*    */   public String parseDeploy(String logicalProp) {
/* 52 */     String s = this.deployParser.getDeployWord(logicalProp);
/* 53 */     return (s == null) ? logicalProp : s;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int nextParameter() {
/* 60 */     return ++this.paramIndex;
/*    */   }
/*    */   
/*    */   public BeanDescriptor<?> getBeanDescriptor() {
/* 64 */     return this.beanDescriptor;
/*    */   }
/*    */   
/*    */   public SpiOrmQueryRequest<?> getQueryRequest() {
/* 68 */     return this.queryRequest;
/*    */   }
/*    */   
/*    */   public SpiExpressionRequest append(String sql) {
/* 72 */     this.sb.append(sql);
/* 73 */     return this;
/*    */   }
/*    */   
/*    */   public void addBindValue(Object bindValue) {
/* 77 */     this.bindValues.add(bindValue);
/*    */   }
/*    */   
/*    */   public boolean includeProperty(String propertyName) {
/* 81 */     return true;
/*    */   }
/*    */   
/*    */   public String getSql() {
/* 85 */     return this.sb.toString();
/*    */   }
/*    */   
/*    */   public ArrayList<Object> getBindValues() {
/* 89 */     return this.bindValues;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninterna\\util\DefaultExpressionRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */