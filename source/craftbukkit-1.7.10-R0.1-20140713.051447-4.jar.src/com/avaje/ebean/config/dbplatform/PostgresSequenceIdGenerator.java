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
/*    */ public class PostgresSequenceIdGenerator
/*    */   extends SequenceIdGenerator
/*    */ {
/*    */   private final String baseSql;
/*    */   
/*    */   public PostgresSequenceIdGenerator(BackgroundExecutor be, DataSource ds, String seqName, int batchSize) {
/* 18 */     super(be, ds, seqName, batchSize);
/* 19 */     this.baseSql = "select nextval('" + seqName + "'), s.generate_series from (" + "select generate_series from generate_series(1,";
/*    */   }
/*    */ 
/*    */   
/*    */   public String getSql(int batchSize) {
/* 24 */     return this.baseSql + batchSize + ") ) as s";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\config\dbplatform\PostgresSequenceIdGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */