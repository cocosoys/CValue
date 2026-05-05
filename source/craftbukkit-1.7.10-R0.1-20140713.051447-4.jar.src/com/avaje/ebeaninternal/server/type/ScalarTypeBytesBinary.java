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
/*    */ public class ScalarTypeBytesBinary
/*    */   extends ScalarTypeBytesBase
/*    */ {
/*    */   public ScalarTypeBytesBinary() {
/* 31 */     super(true, -2);
/*    */   }
/*    */   
/*    */   public byte[] read(DataReader dataReader) throws SQLException {
/* 35 */     return dataReader.getBytes();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeBytesBinary.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */