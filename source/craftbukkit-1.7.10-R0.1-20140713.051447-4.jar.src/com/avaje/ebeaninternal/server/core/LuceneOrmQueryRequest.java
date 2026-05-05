/*    */ package com.avaje.ebeaninternal.server.core;
/*    */ 
/*    */ import org.apache.lucene.search.Query;
/*    */ import org.apache.lucene.search.Sort;
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
/*    */ public class LuceneOrmQueryRequest
/*    */ {
/*    */   private final Query luceneQuery;
/*    */   private final Sort luceneSort;
/*    */   private final String description;
/*    */   private final String sortDesc;
/*    */   
/*    */   public LuceneOrmQueryRequest(Query luceneQuery, Sort luceneSort, String description, String sortDesc) {
/* 36 */     this.luceneQuery = luceneQuery;
/* 37 */     this.luceneSort = luceneSort;
/* 38 */     this.description = description;
/* 39 */     this.sortDesc = sortDesc;
/*    */   }
/*    */   
/*    */   public Query getLuceneQuery() {
/* 43 */     return this.luceneQuery;
/*    */   }
/*    */   
/*    */   public Sort getLuceneSort() {
/* 47 */     return this.luceneSort;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 51 */     return this.description;
/*    */   }
/*    */   
/*    */   public String getSortDesc() {
/* 55 */     return this.sortDesc;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\core\LuceneOrmQueryRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */