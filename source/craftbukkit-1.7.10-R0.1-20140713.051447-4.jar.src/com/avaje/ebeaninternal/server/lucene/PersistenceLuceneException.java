/*    */ package com.avaje.ebeaninternal.server.lucene;
/*    */ 
/*    */ import javax.persistence.PersistenceException;
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
/*    */ public class PersistenceLuceneException
/*    */   extends PersistenceException
/*    */ {
/*    */   private static final long serialVersionUID = 1495423311592521260L;
/*    */   
/*    */   public PersistenceLuceneException(Throwable e) {
/* 29 */     super(e);
/*    */   }
/*    */   
/*    */   public PersistenceLuceneException(String msg, Throwable e) {
/* 33 */     super(msg, e);
/*    */   }
/*    */   
/*    */   public PersistenceLuceneException(String msg) {
/* 37 */     super(msg);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lucene\PersistenceLuceneException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */