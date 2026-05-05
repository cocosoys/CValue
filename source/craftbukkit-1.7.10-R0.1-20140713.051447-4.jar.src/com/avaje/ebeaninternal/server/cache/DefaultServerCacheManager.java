/*    */ package com.avaje.ebeaninternal.server.cache;
/*    */ 
/*    */ import com.avaje.ebean.EbeanServer;
/*    */ import com.avaje.ebean.cache.ServerCache;
/*    */ import com.avaje.ebean.cache.ServerCacheFactory;
/*    */ import com.avaje.ebean.cache.ServerCacheManager;
/*    */ import com.avaje.ebean.cache.ServerCacheOptions;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DefaultServerCacheManager
/*    */   implements ServerCacheManager
/*    */ {
/*    */   private final DefaultCacheHolder beanCache;
/*    */   private final DefaultCacheHolder queryCache;
/*    */   private final ServerCacheFactory cacheFactory;
/*    */   
/*    */   public DefaultServerCacheManager(ServerCacheFactory cacheFactory, ServerCacheOptions defaultBeanOptions, ServerCacheOptions defaultQueryOptions) {
/* 25 */     this.cacheFactory = cacheFactory;
/* 26 */     this.beanCache = new DefaultCacheHolder(cacheFactory, defaultBeanOptions, true);
/* 27 */     this.queryCache = new DefaultCacheHolder(cacheFactory, defaultQueryOptions, false);
/*    */   }
/*    */ 
/*    */   
/*    */   public void init(EbeanServer server) {
/* 32 */     this.cacheFactory.init(server);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void clear(Class<?> beanType) {
/* 40 */     if (isBeanCaching(beanType)) {
/* 41 */       getBeanCache(beanType).clear();
/*    */     }
/* 43 */     if (isQueryCaching(beanType)) {
/* 44 */       getQueryCache(beanType).clear();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void clearAll() {
/* 50 */     this.beanCache.clearAll();
/* 51 */     this.queryCache.clearAll();
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ServerCache getQueryCache(Class<?> beanType) {
/* 59 */     return this.queryCache.getCache(beanType);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ServerCache getBeanCache(Class<?> beanType) {
/* 66 */     return this.beanCache.getCache(beanType);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isBeanCaching(Class<?> beanType) {
/* 74 */     return this.beanCache.isCaching(beanType);
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isQueryCaching(Class<?> beanType) {
/* 79 */     return this.queryCache.isCaching(beanType);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\cache\DefaultServerCacheManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */