/*    */ package com.avaje.ebeaninternal.server.deploy.parse;
/*    */ 
/*    */ import com.avaje.ebean.annotation.Sql;
/*    */ import com.avaje.ebean.annotation.SqlSelect;
/*    */ import com.avaje.ebeaninternal.server.deploy.DRawSqlMeta;
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
/*    */ public class AnnotationSql
/*    */   extends AnnotationParser
/*    */ {
/*    */   public AnnotationSql(DeployBeanInfo<?> info) {
/* 32 */     super(info);
/*    */   }
/*    */   
/*    */   public void parse() {
/* 36 */     Class<?> cls = this.descriptor.getBeanType();
/* 37 */     Sql sql = cls.<Sql>getAnnotation(Sql.class);
/* 38 */     if (sql != null) {
/* 39 */       setSql(sql);
/*    */     }
/*    */     
/* 42 */     SqlSelect sqlSelect = cls.<SqlSelect>getAnnotation(SqlSelect.class);
/* 43 */     if (sqlSelect != null) {
/* 44 */       setSqlSelect(sqlSelect);
/*    */     }
/*    */   }
/*    */   
/*    */   private void setSql(Sql sql) {
/* 49 */     SqlSelect[] select = sql.select();
/* 50 */     for (int i = 0; i < select.length; i++) {
/* 51 */       setSqlSelect(select[i]);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   private void setSqlSelect(SqlSelect sqlSelect) {
/* 57 */     DRawSqlMeta rawSqlMeta = new DRawSqlMeta(sqlSelect);
/* 58 */     this.descriptor.add(rawSqlMeta);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\deploy\parse\AnnotationSql.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */