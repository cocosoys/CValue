/*    */ package org.apache.logging.log4j.core.async;
/*    */ 
/*    */ import java.net.URI;
/*    */ import org.apache.logging.log4j.core.Logger;
/*    */ import org.apache.logging.log4j.core.LoggerContext;
/*    */ import org.apache.logging.log4j.message.MessageFactory;
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
/*    */ public class AsyncLoggerContext
/*    */   extends LoggerContext
/*    */ {
/*    */   public AsyncLoggerContext(String name) {
/* 31 */     super(name);
/*    */   }
/*    */   
/*    */   public AsyncLoggerContext(String name, Object externalContext) {
/* 35 */     super(name, externalContext);
/*    */   }
/*    */ 
/*    */   
/*    */   public AsyncLoggerContext(String name, Object externalContext, URI configLocn) {
/* 40 */     super(name, externalContext, configLocn);
/*    */   }
/*    */ 
/*    */   
/*    */   public AsyncLoggerContext(String name, Object externalContext, String configLocn) {
/* 45 */     super(name, externalContext, configLocn);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected Logger newInstance(LoggerContext ctx, String name, MessageFactory messageFactory) {
/* 51 */     return new AsyncLogger(ctx, name, messageFactory);
/*    */   }
/*    */ 
/*    */   
/*    */   public void stop() {
/* 56 */     AsyncLogger.stop();
/* 57 */     super.stop();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\logging\log4j\core\async\AsyncLoggerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */