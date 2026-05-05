/*    */ package com.avaje.ebeaninternal.server.expression;
/*    */ 
/*    */ import com.avaje.ebeaninternal.api.SpiExpressionRequest;
/*    */ import com.avaje.ebeaninternal.api.SpiLuceneExpr;
/*    */ import org.apache.lucene.queryParser.ParseException;
/*    */ import org.apache.lucene.queryParser.QueryParser;
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
/*    */ public class CaseInsensitiveEqualExpressionLucene
/*    */ {
/*    */   public SpiLuceneExpr createLuceneExpr(SpiExpressionRequest request, String propertyName, String value) {
/*    */     try {
/* 34 */       String desc = propertyName + " ieq " + value;
/*    */       
/* 36 */       QueryParser queryParser = request.getLuceneIndex().createQueryParser(propertyName);
/* 37 */       return new LuceneExprResponse(queryParser.parse(value), desc);
/* 38 */     } catch (ParseException e) {
/* 39 */       throw new PersistenceLuceneParseException(e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\expression\CaseInsensitiveEqualExpressionLucene.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */