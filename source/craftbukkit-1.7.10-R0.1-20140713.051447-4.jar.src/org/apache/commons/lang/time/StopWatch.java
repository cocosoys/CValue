/*     */ package org.apache.commons.lang.time;
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
/*     */ public class StopWatch
/*     */ {
/*     */   private static final int STATE_UNSTARTED = 0;
/*     */   private static final int STATE_RUNNING = 1;
/*     */   private static final int STATE_STOPPED = 2;
/*     */   private static final int STATE_SUSPENDED = 3;
/*     */   private static final int STATE_UNSPLIT = 10;
/*     */   private static final int STATE_SPLIT = 11;
/*  65 */   private int runningState = 0;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  70 */   private int splitState = 10;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*  75 */   private long startTime = -1L;
/*     */ 
/*     */ 
/*     */   
/*  79 */   private long stopTime = -1L;
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
/*     */   public void start() {
/*  96 */     if (this.runningState == 2) {
/*  97 */       throw new IllegalStateException("Stopwatch must be reset before being restarted. ");
/*     */     }
/*  99 */     if (this.runningState != 0) {
/* 100 */       throw new IllegalStateException("Stopwatch already started. ");
/*     */     }
/* 102 */     this.stopTime = -1L;
/* 103 */     this.startTime = System.currentTimeMillis();
/* 104 */     this.runningState = 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void stop() {
/* 115 */     if (this.runningState != 1 && this.runningState != 3) {
/* 116 */       throw new IllegalStateException("Stopwatch is not running. ");
/*     */     }
/* 118 */     if (this.runningState == 1) {
/* 119 */       this.stopTime = System.currentTimeMillis();
/*     */     }
/* 121 */     this.runningState = 2;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void reset() {
/* 130 */     this.runningState = 0;
/* 131 */     this.splitState = 10;
/* 132 */     this.startTime = -1L;
/* 133 */     this.stopTime = -1L;
/*     */   }
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
/*     */   public void split() {
/* 146 */     if (this.runningState != 1) {
/* 147 */       throw new IllegalStateException("Stopwatch is not running. ");
/*     */     }
/* 149 */     this.stopTime = System.currentTimeMillis();
/* 150 */     this.splitState = 11;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void unsplit() {
/* 162 */     if (this.splitState != 11) {
/* 163 */       throw new IllegalStateException("Stopwatch has not been split. ");
/*     */     }
/* 165 */     this.stopTime = -1L;
/* 166 */     this.splitState = 10;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void suspend() {
/* 178 */     if (this.runningState != 1) {
/* 179 */       throw new IllegalStateException("Stopwatch must be running to suspend. ");
/*     */     }
/* 181 */     this.stopTime = System.currentTimeMillis();
/* 182 */     this.runningState = 3;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void resume() {
/* 194 */     if (this.runningState != 3) {
/* 195 */       throw new IllegalStateException("Stopwatch must be suspended to resume. ");
/*     */     }
/* 197 */     this.startTime += System.currentTimeMillis() - this.stopTime;
/* 198 */     this.stopTime = -1L;
/* 199 */     this.runningState = 1;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getTime() {
/* 211 */     if (this.runningState == 2 || this.runningState == 3) {
/* 212 */       return this.stopTime - this.startTime;
/*     */     }
/* 214 */     if (this.runningState == 0) {
/* 215 */       return 0L;
/*     */     }
/* 217 */     if (this.runningState == 1) {
/* 218 */       return System.currentTimeMillis() - this.startTime;
/*     */     }
/* 220 */     throw new RuntimeException("Illegal running state has occured. ");
/*     */   }
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
/*     */   public long getSplitTime() {
/* 234 */     if (this.splitState != 11) {
/* 235 */       throw new IllegalStateException("Stopwatch must be split to get the split time. ");
/*     */     }
/* 237 */     return this.stopTime - this.startTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String toString() {
/* 249 */     return DurationFormatUtils.formatDurationHMS(getTime());
/*     */   }
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
/*     */   public String toSplitString() {
/* 262 */     return DurationFormatUtils.formatDurationHMS(getSplitTime());
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\commons\lang\time\StopWatch.class
 * Java compiler version: 1 (45.3)
 * JD-Core Version:       1.1.3
 */