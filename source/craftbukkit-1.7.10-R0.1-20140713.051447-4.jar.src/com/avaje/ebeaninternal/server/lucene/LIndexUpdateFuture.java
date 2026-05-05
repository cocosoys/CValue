/*    */ package com.avaje.ebeaninternal.server.lucene;
/*    */ 
/*    */ import com.avaje.ebean.config.lucene.IndexUpdateFuture;
/*    */ import java.util.concurrent.ExecutionException;
/*    */ import java.util.concurrent.Future;
/*    */ import java.util.concurrent.FutureTask;
/*    */ import java.util.concurrent.TimeUnit;
/*    */ import java.util.concurrent.TimeoutException;
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
/*    */ public class LIndexUpdateFuture
/*    */   implements Future<Integer>, IndexUpdateFuture
/*    */ {
/*    */   private final Class<?> beanType;
/*    */   private final Runnable commitRunnable;
/*    */   private final FutureTask<Void> commitFuture;
/*    */   private FutureTask<Integer> task;
/*    */   
/*    */   public LIndexUpdateFuture(Class<?> beanType) {
/* 38 */     this.beanType = beanType;
/* 39 */     this.commitRunnable = new DummyRunnable();
/* 40 */     this.commitFuture = new FutureTask<Void>(this.commitRunnable, null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Class<?> getBeanType() {
/* 47 */     return this.beanType;
/*    */   }
/*    */   
/*    */   public Runnable getCommitRunnable() {
/* 51 */     return this.commitFuture;
/*    */   }
/*    */   
/*    */   public void setTask(FutureTask<Integer> task) {
/* 55 */     this.task = task;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isCancelled() {
/* 62 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean cancel(boolean mayInterruptIfRunning) {
/* 69 */     return false;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer get() throws InterruptedException, ExecutionException {
/* 76 */     this.commitFuture.get();
/* 77 */     return this.task.get();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Integer get(long timeout, TimeUnit unit) throws InterruptedException, ExecutionException, TimeoutException {
/* 84 */     this.commitFuture.get(timeout, unit);
/* 85 */     return this.task.get(0L, unit);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isDone() {
/* 92 */     return this.commitFuture.isDone();
/*    */   }
/*    */   
/*    */   private static class DummyRunnable implements Runnable {
/*    */     public void run() {
/* 97 */       System.out.println("-- dummy runnable");
/*    */     }
/*    */     
/*    */     private DummyRunnable() {}
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lucene\LIndexUpdateFuture.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */