/*    */ package com.avaje.ebeaninternal.server.querydefn;
/*    */ 
/*    */ import com.avaje.ebean.config.dbplatform.SqlLimitRequest;
/*    */ import com.avaje.ebeaninternal.api.SpiQuery;
/*    */ 
/*    */ 
/*    */ public class OrmQueryLimitRequest
/*    */   implements SqlLimitRequest
/*    */ {
/*    */   final SpiQuery<?> ormQuery;
/*    */   final String sql;
/*    */   final String sqlOrderBy;
/*    */   
/*    */   public OrmQueryLimitRequest(String sql, String sqlOrderBy, SpiQuery<?> ormQuery) {
/* 15 */     this.sql = sql;
/* 16 */     this.sqlOrderBy = sqlOrderBy;
/* 17 */     this.ormQuery = ormQuery;
/*    */   }
/*    */   
/*    */   public String getDbOrderBy() {
/* 21 */     return this.sqlOrderBy;
/*    */   }
/*    */   
/*    */   public String getDbSql() {
/* 25 */     return this.sql;
/*    */   }
/*    */   
/*    */   public int getFirstRow() {
/* 29 */     return this.ormQuery.getFirstRow();
/*    */   }
/*    */   
/*    */   public int getMaxRows() {
/* 33 */     return this.ormQuery.getMaxRows();
/*    */   }
/*    */   
/*    */   public boolean isDistinct() {
/* 37 */     return this.ormQuery.isDistinct();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\querydefn\OrmQueryLimitRequest.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */