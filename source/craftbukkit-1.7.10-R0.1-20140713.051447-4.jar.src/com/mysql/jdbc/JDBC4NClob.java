/*    */ package com.mysql.jdbc;
/*    */ 
/*    */ import java.sql.NClob;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class JDBC4NClob
/*    */   extends Clob
/*    */   implements NClob
/*    */ {
/*    */   JDBC4NClob(ExceptionInterceptor exceptionInterceptor) {
/* 39 */     super(exceptionInterceptor);
/*    */   }
/*    */   
/*    */   JDBC4NClob(String charDataInit, ExceptionInterceptor exceptionInterceptor) {
/* 43 */     super(charDataInit, exceptionInterceptor);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\mysql\jdbc\JDBC4NClob.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */