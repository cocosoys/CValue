/*    */ package com.avaje.ebean.text;
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
/*    */ public class TextException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 1601310159486033148L;
/*    */   
/*    */   public TextException(String msg) {
/* 35 */     super(msg);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TextException(String msg, Exception e) {
/* 42 */     super(msg, e);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public TextException(Exception e) {
/* 49 */     super(e);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebean\text\TextException.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */