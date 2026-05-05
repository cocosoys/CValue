/*    */ package com.avaje.ebeaninternal.server.util;
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
/*    */ public class InternalAssert
/*    */ {
/*    */   public static void notNull(Object o, String msg) {
/* 31 */     if (o == null) {
/* 32 */       throw new IllegalStateException(msg);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static void isTrue(boolean b, String msg) {
/* 40 */     if (!b)
/* 41 */       throw new IllegalStateException(msg); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\serve\\util\InternalAssert.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */