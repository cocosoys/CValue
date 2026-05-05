/*    */ package com.avaje.ebeaninternal.server.lucene.cluster;
/*    */ 
/*    */ import com.avaje.ebeaninternal.server.cluster.LuceneClusterIndexSync;
/*    */ import com.avaje.ebeaninternal.server.lucene.LIndex;
/*    */ import java.io.IOException;
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
/*    */ public class SLuceneIndexSync
/*    */   implements LuceneClusterIndexSync
/*    */ {
/*    */   private LuceneClusterIndexSync.Mode mode;
/*    */   private String masterHost;
/*    */   
/*    */   public boolean sync(LIndex index, String masterHost) throws IOException {
/* 35 */     SLuceneClusterSocketClient c = new SLuceneClusterSocketClient(index);
/* 36 */     if (c.isSynchIndex(masterHost)) {
/* 37 */       c.transferFiles();
/*    */       
/* 39 */       index.refresh(true);
/* 40 */       return true;
/*    */     } 
/* 42 */     return false;
/*    */   }
/*    */   
/*    */   public boolean isMaster() {
/* 46 */     return LuceneClusterIndexSync.Mode.MASTER_MODE.equals(this.mode);
/*    */   }
/*    */   
/*    */   public String getMasterHost() {
/* 50 */     return this.masterHost;
/*    */   }
/*    */   
/*    */   public LuceneClusterIndexSync.Mode getMode() {
/* 54 */     return this.mode;
/*    */   }
/*    */   
/*    */   public void setMasterHost(String masterHost) {
/* 58 */     this.masterHost = masterHost;
/*    */   }
/*    */   
/*    */   public void setMode(LuceneClusterIndexSync.Mode mode) {
/* 62 */     this.mode = mode;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lucene\cluster\SLuceneIndexSync.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */