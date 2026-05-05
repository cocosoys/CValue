/*    */ package com.avaje.ebeaninternal.server.lucene;
/*    */ 
/*    */ import com.avaje.ebean.Query;
/*    */ import com.avaje.ebean.config.lucene.IndexDefn;
/*    */ import com.avaje.ebeaninternal.api.SpiEbeanServer;
/*    */ import com.avaje.ebeaninternal.api.SpiTransaction;
/*    */ import com.avaje.ebeaninternal.server.cluster.LuceneClusterIndexSync;
/*    */ import com.avaje.ebeaninternal.server.deploy.BeanDescriptor;
/*    */ import com.avaje.ebeaninternal.server.transaction.IndexEvent;
/*    */ import com.avaje.ebeaninternal.server.transaction.RemoteTransactionEvent;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class NoLuceneIndexManager
/*    */   implements LuceneIndexManager
/*    */ {
/*    */   public void start() {}
/*    */   
/*    */   public void shutdown() {}
/*    */   
/*    */   public void setServer(SpiEbeanServer server) {}
/*    */   
/*    */   public boolean isLuceneAvailable() {
/* 50 */     return false;
/*    */   }
/*    */   
/*    */   public void processEvent(RemoteTransactionEvent txnEvent, SpiTransaction t) {
/* 54 */     throw new RuntimeException("Never Called");
/*    */   }
/*    */   
/*    */   public void processEvent(IndexEvent indexEvent) {
/* 58 */     throw new RuntimeException("Never Called");
/*    */   }
/*    */   
/*    */   public LuceneClusterIndexSync getClusterIndexSync() {
/* 62 */     throw new RuntimeException("Never Called");
/*    */   }
/*    */   
/*    */   public void notifyCluster(IndexEvent event) {
/* 66 */     throw new RuntimeException("Never Called");
/*    */   }
/*    */   
/*    */   public void addIndex(LIndex index) throws IOException {
/* 70 */     throw new RuntimeException("Never Called");
/*    */   }
/*    */   
/*    */   public LIndex getIndex(String defnName) {
/* 74 */     throw new RuntimeException("Never Called");
/*    */   }
/*    */   
/*    */   public LIndex create(IndexDefn<?> indexDefn, BeanDescriptor<?> descriptor) throws IOException {
/* 78 */     throw new RuntimeException("Never Called");
/*    */   }
/*    */   
/*    */   public Query.UseIndex getDefaultUseIndex() {
/* 82 */     return Query.UseIndex.NO;
/*    */   }
/*    */   
/*    */   public LIndex getIndexByTypeAndName(Class<?> beanType, String name) {
/* 86 */     throw new RuntimeException("Never Called");
/*    */   }
/*    */   
/*    */   public String getIndexDirectory(String indexName) {
/* 90 */     throw new RuntimeException("Never Called");
/*    */   }
/*    */   
/*    */   public SpiEbeanServer getServer() {
/* 94 */     throw new RuntimeException("Never Called");
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lucene\NoLuceneIndexManager.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */