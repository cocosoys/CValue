/*    */ package com.avaje.ebeaninternal.api;
/*    */ 
/*    */ import com.avaje.ebean.Transaction;
/*    */ import com.avaje.ebean.bean.EntityBeanIntercept;
/*    */ import java.util.List;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class LoadBeanRequest
/*    */   extends LoadRequest
/*    */ {
/*    */   private final List<EntityBeanIntercept> batch;
/*    */   private final LoadBeanContext loadContext;
/*    */   private final String lazyLoadProperty;
/*    */   
/*    */   public LoadBeanRequest(LoadBeanContext loadContext, List<EntityBeanIntercept> batch, Transaction transaction, int batchSize, boolean lazy, String lazyLoadProperty) {
/* 41 */     super(transaction, batchSize, lazy);
/* 42 */     this.loadContext = loadContext;
/* 43 */     this.batch = batch;
/* 44 */     this.lazyLoadProperty = lazyLoadProperty;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 48 */     String fullPath = this.loadContext.getFullPath();
/* 49 */     String s = "path:" + fullPath + " batch:" + this.batchSize + " actual:" + this.batch.size();
/*    */     
/* 51 */     return s;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<EntityBeanIntercept> getBatch() {
/* 58 */     return this.batch;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LoadBeanContext getLoadContext() {
/* 65 */     return this.loadContext;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getLazyLoadProperty() {
/* 72 */     return this.lazyLoadProperty;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\api\LoadBeanRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */