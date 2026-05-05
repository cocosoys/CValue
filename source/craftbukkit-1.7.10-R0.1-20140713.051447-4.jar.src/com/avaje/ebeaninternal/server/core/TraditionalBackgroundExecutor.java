/*    */ package com.avaje.ebeaninternal.server.core;
/*    */ 
/*    */ import com.avaje.ebean.BackgroundExecutor;
/*    */ import com.avaje.ebeaninternal.server.lib.DaemonScheduleThreadPool;
/*    */ import com.avaje.ebeaninternal.server.lib.thread.ThreadPool;
/*    */ import java.util.concurrent.TimeUnit;
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
/*    */ public class TraditionalBackgroundExecutor
/*    */   implements BackgroundExecutor
/*    */ {
/*    */   private final ThreadPool pool;
/*    */   private final DaemonScheduleThreadPool schedulePool;
/*    */   
/*    */   public TraditionalBackgroundExecutor(ThreadPool pool, int schedulePoolSize, int shutdownWaitSeconds, String namePrefix) {
/* 43 */     this.pool = pool;
/* 44 */     this.schedulePool = new DaemonScheduleThreadPool(schedulePoolSize, shutdownWaitSeconds, namePrefix + "-periodic-");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void execute(Runnable r) {
/* 51 */     this.pool.assign(r, true);
/*    */   }
/*    */   
/*    */   public void executePeriodically(Runnable r, long delay, TimeUnit unit) {
/* 55 */     this.schedulePool.scheduleWithFixedDelay(r, delay, delay, unit);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\core\TraditionalBackgroundExecutor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */