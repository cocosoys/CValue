/*    */ package com.avaje.ebeaninternal.server.query;
/*    */ 
/*    */ import com.avaje.ebean.Query;
/*    */ import com.avaje.ebean.Transaction;
/*    */ import com.avaje.ebeaninternal.api.SpiEbeanServer;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class CallableQuery<T>
/*    */ {
/*    */   protected final Query<T> query;
/*    */   protected final SpiEbeanServer server;
/*    */   protected final Transaction t;
/*    */   
/*    */   public CallableQuery(SpiEbeanServer server, Query<T> query, Transaction t) {
/* 42 */     this.server = server;
/* 43 */     this.query = query;
/* 44 */     this.t = t;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\query\CallableQuery.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */