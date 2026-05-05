/*    */ package com.avaje.ebeaninternal.util;
/*    */ 
/*    */ import com.avaje.ebeaninternal.api.SpiLuceneExpr;
/*    */ import java.util.ArrayList;
/*    */ import org.apache.lucene.search.BooleanClause;
/*    */ import org.apache.lucene.search.BooleanQuery;
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
/*    */ 
/*    */ public class LuceneQueryList
/*    */   implements SpiLuceneExpr
/*    */ {
/*    */   private final SpiLuceneExpr.ExprOccur localOccur;
/* 35 */   private final ArrayList<SpiLuceneExpr> list = new ArrayList<SpiLuceneExpr>();
/*    */   
/*    */   private String description;
/*    */   
/*    */   public LuceneQueryList(SpiLuceneExpr.ExprOccur loccur) {
/* 40 */     this.localOccur = loccur;
/*    */   }
/*    */   
/*    */   public void add(SpiLuceneExpr q) {
/* 44 */     this.list.add(q);
/*    */   }
/*    */   
/*    */   public ArrayList<SpiLuceneExpr> getList() {
/* 48 */     return this.list;
/*    */   }
/*    */   
/*    */   public String getDescription() {
/* 52 */     return this.description;
/*    */   }
/*    */ 
/*    */   
/*    */   public Query mergeLuceneQuery() {
/* 57 */     BooleanClause.Occur luceneOccur = getLuceneOccur();
/*    */     
/* 59 */     StringBuilder sb = new StringBuilder();
/*    */     
/* 61 */     BooleanQuery bq = new BooleanQuery();
/* 62 */     for (int i = 0; i < this.list.size(); i++) {
/* 63 */       SpiLuceneExpr luceneExpr = this.list.get(i);
/* 64 */       Query lucQuery = luceneExpr.mergeLuceneQuery();
/* 65 */       bq.add(lucQuery, luceneOccur);
/*    */       
/* 67 */       if (i > 0) {
/* 68 */         sb.append(" ").append(luceneOccur).append(" ");
/*    */       }
/* 70 */       sb.append(luceneExpr.getDescription());
/*    */     } 
/*    */     
/* 73 */     this.description = sb.toString();
/* 74 */     return (Query)bq;
/*    */   }
/*    */   
/*    */   private BooleanClause.Occur getLuceneOccur() {
/* 78 */     switch (this.localOccur) {
/*    */       case MUST:
/* 80 */         return BooleanClause.Occur.MUST;
/*    */       case MUST_NOT:
/* 82 */         return BooleanClause.Occur.MUST_NOT;
/*    */       case SHOULD:
/* 84 */         return BooleanClause.Occur.SHOULD;
/*    */     } 
/*    */     
/* 87 */     throw new RuntimeException("Invalid type " + this.localOccur);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninterna\\util\LuceneQueryList.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */