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
/*    */ public class OracleSequenceIdGenerator
/*    */   extends SequenceIdGenerator
/*    */ {
/*    */   private final String baseSql;
/*    */   
/*    */   public OracleSequenceIdGenerator(BackgroundExecutor be, DataSource ds, String seqName, int batchSize) {
/* 18 */     super(be, ds, seqName, batchSize);
/* 19 */     this.baseSql = "select " + seqName + ".nextval, a from (select level as a FROM dual CONNECT BY level <= ";
/*    */   }
/*    */   
/*    */   public String getSql(int batchSize) {
/* 23 */     return this.baseSql + batchSize + ")";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\config\dbplatform\OracleSequenceIdGenerator.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */