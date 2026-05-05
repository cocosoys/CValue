/*    */ package com.avaje.ebeaninternal.server.cluster;
/*    */ 
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
/*    */ public interface LuceneClusterIndexSync
/*    */ {
/*    */   boolean sync(LIndex paramLIndex, String paramString) throws IOException;
/*    */   
/*    */   boolean isMaster();
/*    */   
/*    */   Mode getMode();
/*    */   
/*    */   void setMode(Mode paramMode);
/*    */   
/*    */   String getMasterHost();
/*    */   
/*    */   void setMasterHost(String paramString);
/*    */   
/*    */   public enum Mode
/*    */   {
/* 32 */     MASTER_MODE,
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 37 */     SLAVE_MODE;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\cluster\LuceneClusterIndexSync.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */