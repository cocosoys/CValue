/*    */ package com.mysql.jdbc.exceptions;
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
/*    */ public class MySQLStatementCancelledException
/*    */   extends MySQLNonTransientException
/*    */ {
/*    */   public MySQLStatementCancelledException(String reason, String SQLState, int vendorCode) {
/* 29 */     super(reason, SQLState, vendorCode);
/*    */   }
/*    */   
/*    */   public MySQLStatementCancelledException(String reason, String SQLState) {
/* 33 */     super(reason, SQLState);
/*    */   }
/*    */   
/*    */   public MySQLStatementCancelledException(String reason) {
/* 37 */     super(reason);
/*    */   }
/*    */   
/*    */   public MySQLStatementCancelledException() {
/* 41 */     super("Statement cancelled due to client request");
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\mysql\jdbc\exceptions\MySQLStatementCancelledException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */