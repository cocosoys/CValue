/*    */ package com.avaje.ebeaninternal.server.cluster.socket;
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
/*    */ public class SocketClusterStatus
/*    */ {
/*    */   private final int currentGroupSize;
/*    */   private final int txnIncoming;
/*    */   private final int txtOutgoing;
/*    */   
/*    */   public SocketClusterStatus(int currentGroupSize, int txnIncoming, int txnOutgoing) {
/* 34 */     this.currentGroupSize = currentGroupSize;
/* 35 */     this.txnIncoming = txnIncoming;
/* 36 */     this.txtOutgoing = txnOutgoing;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getCurrentGroupSize() {
/* 43 */     return this.currentGroupSize;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getTxnIncoming() {
/* 50 */     return this.txnIncoming;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getTxtOutgoing() {
/* 57 */     return this.txtOutgoing;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\cluster\socket\SocketClusterStatus.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */