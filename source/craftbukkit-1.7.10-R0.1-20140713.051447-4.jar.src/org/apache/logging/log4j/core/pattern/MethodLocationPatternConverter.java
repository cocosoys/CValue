/*    */ package org.apache.logging.log4j.core.pattern;
/*    */ 
/*    */ import org.apache.logging.log4j.core.LogEvent;
/*    */ import org.apache.logging.log4j.core.config.plugins.Plugin;
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
/*    */ @Plugin(name = "MethodLocationPatternConverter", category = "Converter")
/*    */ @ConverterKeys({"M", "method"})
/*    */ public final class MethodLocationPatternConverter
/*    */   extends LogEventPatternConverter
/*    */ {
/* 32 */   private static final MethodLocationPatternConverter INSTANCE = new MethodLocationPatternConverter();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private MethodLocationPatternConverter() {
/* 39 */     super("Method", "method");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static MethodLocationPatternConverter newInstance(String[] options) {
/* 49 */     return INSTANCE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void format(LogEvent event, StringBuilder toAppendTo) {
/* 57 */     StackTraceElement element = event.getSource();
/*    */     
/* 59 */     if (element != null)
/* 60 */       toAppendTo.append(element.getMethodName()); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\logging\log4j\core\pattern\MethodLocationPatternConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */