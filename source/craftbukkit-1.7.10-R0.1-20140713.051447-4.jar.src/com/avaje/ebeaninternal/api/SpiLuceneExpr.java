/*    */ package com.avaje.ebeaninternal.api;
/*    */ 
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
/*    */ 
/*    */ public interface SpiLuceneExpr
/*    */ {
/*    */   Query mergeLuceneQuery();
/*    */   
/*    */   String getDescription();
/*    */   
/*    */   public enum ExprOccur
/*    */   {
/* 34 */     MUST,
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 39 */     SHOULD,
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 44 */     MUST_NOT;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\api\SpiLuceneExpr.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */