/*    */ package com.avaje.ebeaninternal.server.lucene.cluster;
/*    */ 
/*    */ import com.avaje.ebeaninternal.server.cluster.ClusterManager;
/*    */ import com.avaje.ebeaninternal.server.cluster.LuceneClusterFactory;
/*    */ import com.avaje.ebeaninternal.server.cluster.LuceneClusterIndexSync;
/*    */ import com.avaje.ebeaninternal.server.cluster.LuceneClusterListener;
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
/*    */ public class SLuceneClusterFactory
/*    */   implements LuceneClusterFactory
/*    */ {
/*    */   public LuceneClusterListener createListener(ClusterManager m, int port) {
/* 31 */     return new SLuceneClusterSocketListener(m, port);
/*    */   }
/*    */ 
/*    */   
/*    */   public LuceneClusterIndexSync createIndexSync() {
/* 36 */     return new SLuceneIndexSync();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lucene\cluster\SLuceneClusterFactory.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */