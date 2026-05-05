/*    */ package com.avaje.ebeaninternal.server.lib.util;
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
/*    */ public class InvalidDataException
/*    */   extends RuntimeException
/*    */ {
/*    */   static final long serialVersionUID = 7061559938704539846L;
/*    */   
/*    */   public InvalidDataException(Exception cause) {
/* 29 */     super(cause);
/*    */   }
/*    */   
/*    */   public InvalidDataException(String s, Exception cause) {
/* 33 */     super(s, cause);
/*    */   }
/*    */   
/*    */   public InvalidDataException(String s) {
/* 37 */     super(s);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\li\\util\InvalidDataException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */