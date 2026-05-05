/*    */ package com.avaje.ebeaninternal.server.type;
/*    */ 
/*    */ import java.sql.Timestamp;
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
/*    */ public class ScalarTypeLongToTimestamp
/*    */   extends ScalarTypeWrapper<Long, Timestamp>
/*    */ {
/*    */   public ScalarTypeLongToTimestamp() {
/* 27 */     super(Long.class, new ScalarTypeTimestamp(), new LongToTimestampConverter());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\type\ScalarTypeLongToTimestamp.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */