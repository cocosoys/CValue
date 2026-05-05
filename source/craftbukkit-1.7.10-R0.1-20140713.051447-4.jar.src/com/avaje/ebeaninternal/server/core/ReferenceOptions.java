/*    */ package com.avaje.ebeaninternal.server.core;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ReferenceOptions
/*    */ {
/*    */   private final boolean readOnly;
/*    */   private final boolean useCache;
/*    */   private final String warmingQuery;
/*    */   
/*    */   public ReferenceOptions(boolean useCache, boolean readOnly, String warmingQuery) {
/* 18 */     this.useCache = useCache;
/* 19 */     this.readOnly = readOnly;
/* 20 */     this.warmingQuery = warmingQuery;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isUseCache() {
/* 27 */     return this.useCache;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public boolean isReadOnly() {
/* 34 */     return this.readOnly;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public String getWarmingQuery() {
/* 41 */     return this.warmingQuery;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\core\ReferenceOptions.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */