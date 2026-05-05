/*    */ package com.avaje.ebean.config.dbplatform;
/*    */ 
/*    */ import com.avaje.ebean.BackgroundExecutor;
/*    */ import javax.sql.DataSource;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class DB2SequenceIdGenerator
/*    */   extends SequenceIdGenerator
/*    */ {
/*    */   private final String baseSql;
/*    */   private final String unionBaseSql;
/*    */   
/*    */   public DB2SequenceIdGenerator(BackgroundExecutor be, DataSource ds, String seqName, int batchSize) {
/* 19 */     super(be, ds, seqName, batchSize);
/* 20 */     this.baseSql = "select nextval for " + seqName;
/* 21 */     this.unionBaseSql = " union " + this.baseSql;
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSql(int batchSize) {
/* 26 */     StringBuilder sb = new StringBuilder();
/* 27 */     sb.append(this.baseSql);
/* 28 */     for (int i = 1; i < batchSize; i++) {
/* 29 */       sb.append(this.unionBaseSql);
/*    */     }
/* 31 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\config\dbplatform\DB2SequenceIdGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */