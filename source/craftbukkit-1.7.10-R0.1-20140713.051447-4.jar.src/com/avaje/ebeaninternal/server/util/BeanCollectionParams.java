/*    */ package com.avaje.ebeaninternal.server.util;
/*    */ 
/*    */ import com.avaje.ebean.Query;
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
/*    */ public class BeanCollectionParams
/*    */ {
/*    */   private final Query.Type manyType;
/*    */   
/*    */   public BeanCollectionParams(Query.Type manyType) {
/* 35 */     this.manyType = manyType;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public Query.Type getManyType() {
/* 42 */     return this.manyType;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\serve\\util\BeanCollectionParams.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */