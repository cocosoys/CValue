/*    */ package com.avaje.ebeaninternal.server.expression;
/*    */ 
/*    */ import com.avaje.ebeaninternal.api.SpiLuceneExpr;
/*    */ import org.apache.lucene.search.Query;
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
/*    */ public class LuceneExprResponse
/*    */   implements SpiLuceneExpr
/*    */ {
/*    */   private final Query query;
/*    */   private final String description;
/*    */   
/*    */   public LuceneExprResponse(Query query, String description) {
/* 33 */     this.query = query;
/* 34 */     this.description = description;
/*    */   }
/*    */   
/*    */   public Query mergeLuceneQuery() {
/* 38 */     return this.query;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 42 */     return this.description;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\expression\LuceneExprResponse.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */