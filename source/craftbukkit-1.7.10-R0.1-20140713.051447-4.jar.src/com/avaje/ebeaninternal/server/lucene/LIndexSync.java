/*    */ package com.avaje.ebeaninternal.server.lucene;
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
/*    */ public class LIndexSync
/*    */ {
/*    */   private final String masterHost;
/*    */   private final LIndex index;
/*    */   
/*    */   public LIndexSync(LIndex index, String masterHost) {
/* 30 */     this.index = index;
/* 31 */     this.masterHost = masterHost;
/*    */   }
/*    */   
/*    */   public String getMasterHost() {
/* 35 */     return this.masterHost;
/*    */   }
/*    */   
/*    */   public LIndex getIndex() {
/* 39 */     return this.index;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lucene\LIndexSync.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */