/*    */ package com.avaje.ebean.config.lucene;
/*    */ 
/*    */ import org.apache.lucene.analysis.Analyzer;
/*    */ import org.apache.lucene.document.Fieldable;
/*    */ import org.apache.lucene.index.IndexWriter;
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
/*    */ public abstract class AbstractIndexDefn<T>
/*    */   implements IndexDefn<T>
/*    */ {
/*    */   public Analyzer getAnalyzer() {
/* 37 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getMaxBufferedDocs() {
/* 42 */     return 0;
/*    */   }
/*    */   
/*    */   public IndexWriter.MaxFieldLength getMaxFieldLength() {
/* 46 */     return IndexWriter.MaxFieldLength.UNLIMITED;
/*    */   }
/*    */ 
/*    */   
/*    */   public double getRAMBufferSizeMB() {
/* 51 */     return 0.0D;
/*    */   }
/*    */ 
/*    */   
/*    */   public int getTermIndexInterval() {
/* 56 */     return 0;
/*    */   }
/*    */   
/*    */   public void visitCreatedField(Fieldable field) {}
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\config\lucene\AbstractIndexDefn.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */