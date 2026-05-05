/*    */ package org.apache.logging.log4j.core.web;
/*    */ 
/*    */ import javax.servlet.UnavailableException;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ interface Log4jWebInitializer
/*    */ {
/*    */   public static final String LOG4J_CONTEXT_NAME = "log4jContextName";
/*    */   public static final String LOG4J_CONFIG_LOCATION = "log4jConfiguration";
/*    */   public static final String IS_LOG4J_CONTEXT_SELECTOR_NAMED = "isLog4jContextSelectorNamed";
/* 46 */   public static final String INITIALIZER_ATTRIBUTE = Log4jWebInitializer.class.getName() + ".INSTANCE";
/*    */   
/*    */   void initialize() throws UnavailableException;
/*    */   
/*    */   void deinitialize();
/*    */   
/*    */   void setLoggerContext();
/*    */   
/*    */   void clearLoggerContext();
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\logging\log4j\core\web\Log4jWebInitializer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */