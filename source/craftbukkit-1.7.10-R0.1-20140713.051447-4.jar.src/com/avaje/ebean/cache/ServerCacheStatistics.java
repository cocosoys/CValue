/*     */ package com.avaje.ebean.cache;
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
/*     */ public class ServerCacheStatistics
/*     */ {
/*     */   protected String cacheName;
/*     */   protected int maxSize;
/*     */   protected int size;
/*     */   protected int hitCount;
/*     */   protected int missCount;
/*     */   
/*     */   public String getCacheName() {
/*  47 */     return this.cacheName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setCacheName(String cacheName) {
/*  54 */     this.cacheName = cacheName;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHitCount() {
/*  61 */     return this.hitCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setHitCount(int hitCount) {
/*  68 */     this.hitCount = hitCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMissCount() {
/*  75 */     return this.missCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMissCount(int missCount) {
/*  82 */     this.missCount = missCount;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getSize() {
/*  89 */     return this.size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setSize(int size) {
/*  96 */     this.size = size;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getMaxSize() {
/* 107 */     return this.maxSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void setMaxSize(int maxSize) {
/* 114 */     this.maxSize = maxSize;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public int getHitRatio() {
/* 125 */     int totalCount = this.hitCount + this.missCount;
/* 126 */     if (totalCount == 0) {
/* 127 */       return 0;
/*     */     }
/* 129 */     return this.hitCount * 100 / totalCount;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\cache\ServerCacheStatistics.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */