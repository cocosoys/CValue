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
/*    */ public class GeneralException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 5783084420007103280L;
/*    */   
/*    */   public GeneralException(Exception cause) {
/* 28 */     super(cause);
/*    */   }
/*    */   
/*    */   public GeneralException(String s, Exception cause) {
/* 32 */     super(s, cause);
/*    */   }
/*    */   
/*    */   public GeneralException(String s) {
/* 36 */     super(s);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\li\\util\GeneralException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */