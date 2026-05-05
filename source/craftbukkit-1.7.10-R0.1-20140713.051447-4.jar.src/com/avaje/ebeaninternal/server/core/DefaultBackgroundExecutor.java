/*    */ package com.avaje.ebeaninternal.server.core;
/*    */ 
/*    */ import com.avaje.ebean.BackgroundExecutor;
/*    */ import com.avaje.ebeaninternal.server.lib.DaemonScheduleThreadPool;
/*    */ import com.avaje.ebeaninternal.server.lib.DaemonThreadPool;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DefaultBackgroundExecutor
/*    */   implements BackgroundExecutor
/*    */ {
/*    */   private final DaemonThreadPool pool;
/*    */   private final DaemonScheduleThreadPool schedulePool;
/*    */   
/*    */   public DefaultBackgroundExecutor(int mainPoolSize, int schedulePoolSize, long keepAliveSecs, int shutdownWaitSeconds, String namePrefix) {
/* 51 */     this.pool = new DaemonThreadPool(mainPoolSize, keepAliveSecs, shutdownWaitSeconds, namePrefix);
/* 52 */     this.schedulePool = new DaemonScheduleThreadPool(schedulePoolSize, shutdownWaitSeconds, namePrefix + "-periodic-");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void execute(Runnable r) {
/* 59 */     this.pool.execute(r);
/*    */   }
/*    */   
/*    */   public void executePeriodically(Runnable r, long delay, TimeUnit unit) {
/* 63 */     this.schedulePool.scheduleWithFixedDelay(r, delay, delay, unit);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\core\DefaultBackgroundExecutor.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */