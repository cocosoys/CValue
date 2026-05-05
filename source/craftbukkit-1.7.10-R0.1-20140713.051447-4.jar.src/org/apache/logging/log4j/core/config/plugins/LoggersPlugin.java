/*    */ package org.apache.logging.log4j.core.config.plugins;
/*    */ 
/*    */ import java.util.concurrent.ConcurrentHashMap;
/*    */ import java.util.concurrent.ConcurrentMap;
/*    */ import org.apache.logging.log4j.core.config.LoggerConfig;
/*    */ import org.apache.logging.log4j.core.config.Loggers;
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
/*    */ 
/*    */ 
/*    */ @Plugin(name = "loggers", category = "Core")
/*    */ public final class LoggersPlugin
/*    */ {
/*    */   @PluginFactory
/*    */   public static Loggers createLoggers(@PluginElement("Loggers") LoggerConfig[] loggers) {
/* 41 */     ConcurrentMap<String, LoggerConfig> loggerMap = new ConcurrentHashMap<String, LoggerConfig>();
/* 42 */     LoggerConfig root = null;
/*    */     
/* 44 */     for (LoggerConfig logger : loggers) {
/* 45 */       if (logger != null) {
/* 46 */         if (logger.getName().isEmpty()) {
/* 47 */           root = logger;
/*    */         }
/* 49 */         loggerMap.put(logger.getName(), logger);
/*    */       } 
/*    */     } 
/*    */     
/* 53 */     return new Loggers(loggerMap, root);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\logging\log4j\core\config\plugins\LoggersPlugin.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */