/*    */ package com.avaje.ebeaninternal.server.lucene;
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
/*    */ public final class LIndexWork
/*    */ {
/*    */   private final WorkType workType;
/*    */   private final LIndexUpdateFuture future;
/*    */   private final IndexUpdates indexUpdates;
/*    */   
/*    */   public enum WorkType
/*    */   {
/* 30 */     TXN_UPDATE,
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 35 */     QUERY_UPDATE,
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 40 */     REBUILD;
/*    */   }
/*    */   
/*    */   public static LIndexWork newRebuild(LIndexUpdateFuture future) {
/* 44 */     return new LIndexWork(WorkType.REBUILD, future, null);
/*    */   }
/*    */   
/*    */   public static LIndexWork newQueryUpdate(LIndexUpdateFuture future) {
/* 48 */     return new LIndexWork(WorkType.QUERY_UPDATE, future, null);
/*    */   }
/*    */   
/*    */   public static LIndexWork newTxnUpdate(LIndexUpdateFuture future, IndexUpdates indexUpdates) {
/* 52 */     return new LIndexWork(WorkType.TXN_UPDATE, future, indexUpdates);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private LIndexWork(WorkType workType, LIndexUpdateFuture future, IndexUpdates indexUpdates) {
/* 62 */     this.workType = workType;
/* 63 */     this.future = future;
/* 64 */     this.indexUpdates = indexUpdates;
/*    */   }
/*    */   
/*    */   public WorkType getWorkType() {
/* 68 */     return this.workType;
/*    */   }
/*    */   
/*    */   public IndexUpdates getIndexUpdates() {
/* 72 */     return this.indexUpdates;
/*    */   }
/*    */   
/*    */   public LIndexUpdateFuture getFuture() {
/* 76 */     return this.future;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lucene\LIndexWork.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */