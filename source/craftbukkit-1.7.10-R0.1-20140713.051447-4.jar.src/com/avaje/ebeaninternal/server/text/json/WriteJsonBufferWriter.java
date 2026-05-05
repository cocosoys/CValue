/*    */ package com.avaje.ebeaninternal.server.text.json;
/*    */ 
/*    */ import com.avaje.ebean.text.TextException;
/*    */ import java.io.IOException;
/*    */ import java.io.Writer;
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
/*    */ public class WriteJsonBufferWriter
/*    */   implements WriteJsonBuffer
/*    */ {
/*    */   private final Writer buffer;
/*    */   
/*    */   public WriteJsonBufferWriter(Writer buffer) {
/* 32 */     this.buffer = buffer;
/*    */   }
/*    */   
/*    */   public WriteJsonBufferWriter append(String content) {
/*    */     try {
/* 37 */       this.buffer.write(content);
/* 38 */       return this;
/* 39 */     } catch (IOException e) {
/* 40 */       throw new TextException(e);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\text\json\WriteJsonBufferWriter.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */