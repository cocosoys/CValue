/*     */ package com.avaje.ebeaninternal.server.cache;
/*     */ 
/*     */ import com.avaje.ebean.annotation.CacheTuning;
/*     */ import com.avaje.ebean.cache.ServerCache;
/*     */ import com.avaje.ebean.cache.ServerCacheFactory;
/*     */ import com.avaje.ebean.cache.ServerCacheOptions;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.concurrent.ConcurrentHashMap;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class DefaultCacheHolder
/*     */ {
/*  17 */   private final ConcurrentHashMap<Class<?>, ServerCache> concMap = new ConcurrentHashMap<Class<?>, ServerCache>();
/*     */   
/*  19 */   private final HashMap<Class<?>, ServerCache> synchMap = new HashMap<Class<?>, ServerCache>();
/*     */   
/*  21 */   private final Object monitor = new Object();
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ServerCacheFactory cacheFactory;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final ServerCacheOptions defaultOptions;
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private final boolean useBeanTuning;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public DefaultCacheHolder(ServerCacheFactory cacheFactory, ServerCacheOptions defaultOptions, boolean useBeanTuning) {
/*  43 */     this.cacheFactory = cacheFactory;
/*  44 */     this.defaultOptions = defaultOptions;
/*  45 */     this.useBeanTuning = useBeanTuning;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ServerCacheOptions getDefaultOptions() {
/*  52 */     return this.defaultOptions;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public ServerCache getCache(Class<?> beanType) {
/*  60 */     ServerCache cache = this.concMap.get(beanType);
/*  61 */     if (cache != null) {
/*  62 */       return cache;
/*     */     }
/*  64 */     synchronized (this.monitor) {
/*  65 */       cache = this.synchMap.get(beanType);
/*  66 */       if (cache == null) {
/*  67 */         ServerCacheOptions options = getCacheOptions(beanType);
/*  68 */         cache = this.cacheFactory.createCache(beanType, options);
/*  69 */         this.synchMap.put(beanType, cache);
/*  70 */         this.concMap.put(beanType, cache);
/*     */       } 
/*  72 */       return cache;
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isCaching(Class<?> beanType) {
/*  80 */     return this.concMap.containsKey(beanType);
/*     */   }
/*     */   
/*     */   public void clearAll() {
/*  84 */     Iterator<ServerCache> it = this.concMap.values().iterator();
/*  85 */     while (it.hasNext()) {
/*  86 */       ServerCache serverCache = it.next();
/*  87 */       serverCache.clear();
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   private ServerCacheOptions getCacheOptions(Class<?> beanType) {
/*  96 */     if (this.useBeanTuning) {
/*     */       
/*  98 */       CacheTuning cacheTuning = beanType.<CacheTuning>getAnnotation(CacheTuning.class);
/*  99 */       if (cacheTuning != null) {
/* 100 */         ServerCacheOptions o = new ServerCacheOptions(cacheTuning);
/* 101 */         o.applyDefaults(this.defaultOptions);
/* 102 */         return o;
/*     */       } 
/*     */     } 
/*     */     
/* 106 */     return this.defaultOptions.copy();
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\cache\DefaultCacheHolder.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */