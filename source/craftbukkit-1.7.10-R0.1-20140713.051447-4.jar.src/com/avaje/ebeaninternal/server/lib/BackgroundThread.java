/*     */ package com.avaje.ebeaninternal.server.lib;
/*     */ 
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
/*     */ public final class BackgroundThread
/*     */ {
/*  46 */   private static final Logger logger = Logger.getLogger(BackgroundThread.class.getName());
/*     */   
/*     */   private static class Single {
/*  49 */     private static BackgroundThread me = new BackgroundThread();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  55 */   private Vector<BackgroundRunnable> list = new Vector<BackgroundRunnable>();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  60 */   private final Object monitor = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final Thread thread;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  70 */   private long sleepTime = 1000L;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long count;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private long exeTime;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private boolean stopped;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  90 */   private Object threadMonitor = new Object();
/*     */ 
/*     */   
/*     */   private BackgroundThread() {
/*  94 */     this.thread = new Thread(new Runner(), "EbeanBackgroundThread");
/*  95 */     this.thread.setDaemon(true);
/*  96 */     this.thread.start();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void add(int freqInSecs, Runnable runnable) {
/* 103 */     add(new BackgroundRunnable(runnable, freqInSecs));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void add(BackgroundRunnable backgroundRunnable) {
/* 110 */     Single.me.addTask(backgroundRunnable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void shutdown() {
/* 117 */     Single.me.stop();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static Iterator<BackgroundRunnable> runnables() {
/* 124 */     synchronized (Single.me.monitor) {
/* 125 */       return Single.me.list.iterator();
/*     */     } 
/*     */   }
/*     */   
/*     */   private void addTask(BackgroundRunnable backgroundRunnable) {
/* 130 */     synchronized (this.monitor) {
/* 131 */       this.list.add(backgroundRunnable);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private void stop() {
/* 141 */     this.stopped = true;
/* 142 */     synchronized (this.threadMonitor) {
/*     */       try {
/* 144 */         this.threadMonitor.wait(10000L);
/* 145 */       } catch (InterruptedException e) {}
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private class Runner
/*     */     implements Runnable
/*     */   {
/*     */     private Runner() {}
/*     */ 
/*     */ 
/*     */     
/*     */     public void run() {
/* 159 */       if (ShutdownManager.isStopping()) {
/*     */         return;
/*     */       }
/*     */       
/* 163 */       while (!BackgroundThread.this.stopped) {
/*     */         
/*     */         try {
/* 166 */           long actualSleep = BackgroundThread.this.sleepTime - BackgroundThread.this.exeTime;
/* 167 */           if (actualSleep < 0L) {
/* 168 */             actualSleep = BackgroundThread.this.sleepTime;
/*     */           }
/* 170 */           Thread.sleep(actualSleep);
/* 171 */           synchronized (BackgroundThread.this.monitor) {
/* 172 */             runJobs();
/*     */           }
/*     */         
/* 175 */         } catch (InterruptedException e) {
/* 176 */           BackgroundThread.logger.log(Level.SEVERE, (String)null, e);
/*     */         } 
/*     */       } 
/*     */ 
/*     */       
/* 181 */       synchronized (BackgroundThread.this.threadMonitor) {
/* 182 */         BackgroundThread.this.threadMonitor.notifyAll();
/*     */       } 
/*     */     }
/*     */ 
/*     */     
/*     */     private void runJobs() {
/* 188 */       long startTime = System.currentTimeMillis();
/*     */ 
/*     */       
/* 191 */       Iterator<BackgroundRunnable> it = BackgroundThread.this.list.iterator();
/* 192 */       while (it.hasNext()) {
/* 193 */         BackgroundRunnable bgr = it.next();
/* 194 */         if (bgr.isActive()) {
/*     */           
/* 196 */           int freqInSecs = bgr.getFreqInSecs();
/*     */           
/* 198 */           if (BackgroundThread.this.count % freqInSecs == 0L) {
/* 199 */             Runnable runable = bgr.getRunnable();
/* 200 */             if (bgr.runNow(startTime)) {
/* 201 */               bgr.runStart();
/* 202 */               if (BackgroundThread.logger.isLoggable(Level.FINER)) {
/* 203 */                 String msg = BackgroundThread.this.count + " BGRunnable running [" + runable.getClass().getName() + "]";
/*     */                 
/* 205 */                 BackgroundThread.logger.finer(msg);
/*     */               } 
/*     */               
/* 208 */               runable.run();
/* 209 */               bgr.runEnd();
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/* 214 */       BackgroundThread.this.exeTime = System.currentTimeMillis() - startTime;
/* 215 */       BackgroundThread.this.count++;
/*     */       
/* 217 */       if (BackgroundThread.this.count == 86400L)
/*     */       {
/* 219 */         BackgroundThread.this.count = 0L;
/*     */       }
/*     */     }
/*     */   }
/*     */   
/*     */   public String toString() {
/* 225 */     synchronized (this.monitor) {
/* 226 */       StringBuffer sb = new StringBuffer();
/*     */       
/* 228 */       Iterator<BackgroundRunnable> it = runnables();
/* 229 */       while (it.hasNext()) {
/* 230 */         BackgroundRunnable bgr = it.next();
/* 231 */         sb.append(bgr);
/*     */       } 
/*     */       
/* 234 */       return sb.toString();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lib\BackgroundThread.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */