/*     */ package com.avaje.ebean.meta;
/*     */ 
/*     */ import java.io.Serializable;
/*     */ import javax.persistence.Entity;
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
/*     */ @Entity
/*     */ public class MetaQueryStatistic
/*     */   implements Serializable
/*     */ {
/*     */   private static final long serialVersionUID = -8746524372894472583L;
/*     */   boolean autofetchTuned;
/*     */   String beanType;
/*     */   int origQueryPlanHash;
/*     */   int finalQueryPlanHash;
/*     */   String sql;
/*     */   int executionCount;
/*     */   int totalLoadedBeans;
/*     */   int totalTimeMicros;
/*     */   long collectionStart;
/*     */   long lastQueryTime;
/*     */   int avgTimeMicros;
/*     */   int avgLoadedBeans;
/*     */   
/*     */   public MetaQueryStatistic() {}
/*     */   
/*     */   public MetaQueryStatistic(boolean autofetchTuned, String beanType, int plan, String sql, int executionCount, int totalLoadedBeans, int totalTimeMicros, long collectionStart, long lastQueryTime) {
/*  55 */     this.autofetchTuned = autofetchTuned;
/*  56 */     this.beanType = beanType;
/*  57 */     this.finalQueryPlanHash = plan;
/*  58 */     this.sql = sql;
/*  59 */     this.executionCount = executionCount;
/*  60 */     this.totalLoadedBeans = totalLoadedBeans;
/*  61 */     this.totalTimeMicros = totalTimeMicros;
/*  62 */     this.collectionStart = collectionStart;
/*     */     
/*  64 */     this.lastQueryTime = lastQueryTime;
/*  65 */     this.avgTimeMicros = (executionCount == 0) ? 0 : (totalTimeMicros / executionCount);
/*  66 */     this.avgLoadedBeans = (executionCount == 0) ? 0 : (totalLoadedBeans / executionCount);
/*     */   }
/*     */   
/*     */   public String toString() {
/*  70 */     return "type=" + this.beanType + " tuned:" + this.autofetchTuned + " origHash=" + this.origQueryPlanHash + " count=" + this.executionCount + " avgMicros=" + getAvgTimeMicros();
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isAutofetchTuned() {
/*  77 */     return this.autofetchTuned;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getOrigQueryPlanHash() {
/*  87 */     return this.origQueryPlanHash;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getFinalQueryPlanHash() {
/*  94 */     return this.finalQueryPlanHash;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getBeanType() {
/* 101 */     return this.beanType;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public String getSql() {
/* 108 */     return this.sql;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getExecutionCount() {
/* 115 */     return this.executionCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalLoadedBeans() {
/* 125 */     return this.totalLoadedBeans;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getTotalTimeMicros() {
/* 132 */     return this.totalTimeMicros;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getCollectionStart() {
/* 139 */     return this.collectionStart;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public long getLastQueryTime() {
/* 146 */     return this.lastQueryTime;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAvgTimeMicros() {
/* 156 */     return this.avgTimeMicros;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getAvgLoadedBeans() {
/* 166 */     return this.avgLoadedBeans;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\meta\MetaQueryStatistic.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */