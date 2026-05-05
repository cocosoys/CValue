/*    */ package com.google.common.util.concurrent;
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
/*    */ public class UncheckedTimeoutException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 0L;
/*    */   
/*    */   public UncheckedTimeoutException() {}
/*    */   
/*    */   public UncheckedTimeoutException(String message) {
/* 29 */     super(message);
/*    */   }
/*    */   
/*    */   public UncheckedTimeoutException(Throwable cause) {
/* 33 */     super(cause);
/*    */   }
/*    */   
/*    */   public UncheckedTimeoutException(String message, Throwable cause) {
/* 37 */     super(message, cause);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\google\commo\\util\concurrent\UncheckedTimeoutException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */