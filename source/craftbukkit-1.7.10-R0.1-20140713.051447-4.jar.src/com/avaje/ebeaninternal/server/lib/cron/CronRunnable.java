/*     */ package com.avaje.ebeaninternal.server.lib.cron;
/*     */ 
/*     */ import java.util.Calendar;
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
/*     */ public class CronRunnable
/*     */ {
/*     */   boolean isEnabled = true;
/*     */   CronSchedule schedule;
/*     */   Runnable runnable;
/*     */   
/*     */   public CronRunnable(String schedule, Runnable runnable) {
/*  37 */     this(new CronSchedule(schedule), runnable);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public CronRunnable(CronSchedule schedule, Runnable runnable) {
/*  44 */     this.schedule = schedule;
/*  45 */     this.runnable = runnable;
/*     */   }
/*     */   
/*     */   public boolean equals(Object obj) {
/*  49 */     if (obj == null) {
/*  50 */       return false;
/*     */     }
/*  52 */     if (obj instanceof CronRunnable) {
/*  53 */       return (hashCode() == obj.hashCode());
/*     */     }
/*  55 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  59 */     int hc = CronRunnable.class.getName().hashCode();
/*  60 */     hc += 31 * hc + this.schedule.hashCode();
/*  61 */     hc += 31 * hc + this.runnable.hashCode();
/*  62 */     return hc;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isScheduledToRunNow(Calendar thisMinute) {
/*  72 */     return (this.isEnabled && this.schedule.isScheduledToRunNow(thisMinute));
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSchedule(String scheduleLine) {
/*  80 */     this.schedule.setSchedule(scheduleLine);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSchedule() {
/*  87 */     return this.schedule.getSchedule();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public Runnable getRunnable() {
/*  94 */     return this.runnable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setRunnable(Runnable runnable) {
/* 101 */     this.runnable = runnable;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isEnabled() {
/* 108 */     return this.isEnabled;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setEnabled(boolean isEnabled) {
/* 116 */     this.isEnabled = isEnabled;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 120 */     return "CronRunnable: isEnabled[" + this.isEnabled + "] sch[" + this.schedule.getSchedule() + "] [" + this.runnable.toString() + "]";
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lib\cron\CronRunnable.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */