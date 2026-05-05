/*    */ package com.avaje.ebeaninternal.api;
/*    */ 
/*    */ import com.avaje.ebean.Transaction;
/*    */ import com.avaje.ebean.bean.BeanCollection;
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
/*    */ 
/*    */ 
/*    */ public class LoadManyRequest
/*    */   extends LoadRequest
/*    */ {
/*    */   private final List<BeanCollection<?>> batch;
/*    */   private final LoadManyContext loadContext;
/*    */   private final boolean onlyIds;
/*    */   
/*    */   public LoadManyRequest(LoadManyContext loadContext, List<BeanCollection<?>> batch, Transaction transaction, int batchSize, boolean lazy, boolean onlyIds) {
/* 43 */     super(transaction, batchSize, lazy);
/* 44 */     this.loadContext = loadContext;
/* 45 */     this.batch = batch;
/* 46 */     this.onlyIds = onlyIds;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 50 */     String fullPath = this.loadContext.getFullPath();
/* 51 */     String s = "path:" + fullPath + " batch:" + this.batchSize + " actual:" + this.batch.size();
/*    */     
/* 53 */     return s;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public List<BeanCollection<?>> getBatch() {
/* 60 */     return this.batch;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LoadManyContext getLoadContext() {
/* 67 */     return this.loadContext;
/*    */   }
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
/*    */   public boolean isOnlyIds() {
/* 80 */     return this.onlyIds;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\api\LoadManyRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */