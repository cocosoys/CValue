/*     */ package com.avaje.ebeaninternal.server.lib.cron;
/*     */ 
/*     */ import com.avaje.ebean.config.GlobalProperties;
/*     */ import com.avaje.ebeaninternal.server.lib.ShutdownManager;
/*     */ import com.avaje.ebeaninternal.server.lib.thread.ThreadPool;
/*     */ import com.avaje.ebeaninternal.server.lib.thread.ThreadPoolManager;
/*     */ import java.util.Date;
/*     */ import java.util.Enumeration;
/*     */ import java.util.GregorianCalendar;
/*     */ import java.util.Iterator;
/*     */ import java.util.Vector;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public final class CronManager
/*     */ {
/*  43 */   private static final Logger logger = Logger.getLogger(CronManager.class.getName());
/*     */   
/*     */   private static class CronManagerHolder {
/*  46 */     private static CronManager me = new CronManager();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean running = true;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ThreadPool threadPool;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Vector<CronRunnable> runList;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private Thread backgroundThread;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean isDowntime = false;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static final long SMALL_DELAY = 10L;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private CronManager() {
/*  83 */     this.runList = new Vector<CronRunnable>();
/*  84 */     this.threadPool = ThreadPoolManager.getThreadPool("CronManager");
/*     */     
/*  86 */     this.backgroundThread = new Thread(new Runner(), "CronManager Daemon");
/*  87 */     this.backgroundThread.setDaemon(true);
/*  88 */     this.backgroundThread.start();
/*     */   }
/*     */ 
/*     */   
/*     */   private void init() {
/*  93 */     CronRunnable sr = new CronRunnable("* * * * *", new HelloWorld());
/*  94 */     sr.setEnabled(false);
/*  95 */     add(sr);
/*     */ 
/*     */     
/*  98 */     CronRunnable dt = new CronRunnable("25 23 * * *", new Downtime(this));
/*  99 */     dt.setEnabled(false);
/*     */     
/* 101 */     String downtimeSchedule = GlobalProperties.get("system.downtime.schedule", null);
/* 102 */     if (downtimeSchedule != null) {
/*     */       
/* 104 */       dt.setSchedule(downtimeSchedule);
/* 105 */       dt.setEnabled(true);
/*     */     } 
/* 107 */     add(dt);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean isDowntime() {
/* 115 */     return (getInstance()).isDowntime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void setDowntime(boolean isDowntime) {
/* 124 */     this.isDowntime = isDowntime;
/* 125 */     if (isDowntime) {
/* 126 */       String duration = GlobalProperties.get("system.downtime.duration", null);
/* 127 */       logger.warning("System downtime has started for [" + duration + "] seconds");
/*     */     } else {
/* 129 */       logger.warning("System downtime has finished.");
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void setRunning(boolean running) {
/* 137 */     CronManagerHolder.me.running = running;
/*     */   }
/*     */   
/*     */   private void runScheduledJobs() {
/* 141 */     if (!this.running) {
/*     */       return;
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 151 */     Date nowDate = new Date((System.currentTimeMillis() + 5000L) / 60000L * 60000L);
/* 152 */     GregorianCalendar thisMinute = new GregorianCalendar();
/* 153 */     thisMinute.setTime(nowDate);
/*     */     
/* 155 */     Enumeration<CronRunnable> en = this.runList.elements();
/* 156 */     while (en.hasMoreElements()) {
/* 157 */       CronRunnable sr = en.nextElement();
/*     */       
/* 159 */       if (sr.isScheduledToRunNow(thisMinute)) {
/* 160 */         this.threadPool.assign(sr.getRunnable(), true);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private static CronManager getInstance() {
/* 171 */     return CronManagerHolder.me;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void add(String schedule, Runnable runnable) {
/* 178 */     CronRunnable sr = new CronRunnable(schedule, runnable);
/* 179 */     add(sr);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void add(CronRunnable runnable) {
/* 186 */     (getInstance()).runList.add(runnable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Iterator<CronRunnable> iterator() {
/* 193 */     return (getInstance()).runList.iterator();
/*     */   }
/*     */   
/*     */   private class Runner
/*     */     implements Runnable {
/*     */     public void run() {
/* 199 */       CronManager.this.init();
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       while (true) {
/*     */         try {
/* 206 */           long nextMinute = System.currentTimeMillis() / 60000L * 60000L + 60000L;
/* 207 */           long now = System.currentTimeMillis();
/* 208 */           long nextSleepTime = nextMinute - now + 10L;
/* 209 */           if (nextSleepTime > 0L)
/*     */           {
/*     */             
/* 212 */             Thread.sleep(nextSleepTime);
/*     */           }
/*     */ 
/*     */           
/* 216 */           long additionalDelay = nextMinute - System.currentTimeMillis();
/* 217 */           if (additionalDelay > 0L)
/*     */           {
/*     */             
/* 220 */             Thread.sleep(additionalDelay + 20L);
/*     */           }
/*     */ 
/*     */           
/* 224 */           boolean stopping = ShutdownManager.isStopping();
/* 225 */           if (!stopping) {
/* 226 */             CronManager.this.runScheduledJobs();
/*     */           }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */           
/* 234 */           Thread.sleep(5000L);
/*     */         }
/* 236 */         catch (InterruptedException e) {
/* 237 */           CronManager.logger.log(Level.SEVERE, "", e);
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*     */     private Runner() {}
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lib\cron\CronManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */