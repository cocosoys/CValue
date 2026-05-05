/*    */ package com.avaje.ebeaninternal.server.type;
/*    */ 
/*    */ import java.sql.SQLException;
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
/*    */ public class ScalarTypeLongVarchar
/*    */   extends ScalarTypeClob
/*    */ {
/*    */   public ScalarTypeLongVarchar() {
/* 31 */     super(true, -1);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public String read(DataReader dataReader) throws SQLException {
/* 37 */     return dataReader.getStringFromStream();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeLongVarchar.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */