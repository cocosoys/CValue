/*    */ package com.avaje.ebeaninternal.server.text.json;
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
/*    */ public class WriteJsonBufferString
/*    */   implements WriteJsonBuffer
/*    */ {
/* 27 */   private final StringBuilder buffer = new StringBuilder(256);
/*    */ 
/*    */   
/*    */   public WriteJsonBufferString append(String content) {
/* 31 */     this.buffer.append(content);
/* 32 */     return this;
/*    */   }
/*    */   
/*    */   public String getBufferOutput() {
/* 36 */     return this.buffer.toString();
/*    */   }
/*    */   
/*    */   public String toString() {
/* 40 */     return this.buffer.toString();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\text\json\WriteJsonBufferString.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */