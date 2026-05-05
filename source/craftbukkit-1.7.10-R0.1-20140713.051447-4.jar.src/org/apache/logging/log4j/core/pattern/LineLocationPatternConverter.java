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
/*    */ @Plugin(name = "LineLocationPatternConverter", category = "Converter")
/*    */ @ConverterKeys({"L", "line"})
/*    */ public final class LineLocationPatternConverter
/*    */   extends LogEventPatternConverter
/*    */ {
/* 31 */   private static final LineLocationPatternConverter INSTANCE = new LineLocationPatternConverter();
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private LineLocationPatternConverter() {
/* 38 */     super("Line", "line");
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public static LineLocationPatternConverter newInstance(String[] options) {
/* 49 */     return INSTANCE;
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public void format(LogEvent event, StringBuilder output) {
/* 57 */     StackTraceElement element = event.getSource();
/*    */     
/* 59 */     if (element != null)
/* 60 */       output.append(element.getLineNumber()); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\apache\logging\log4j\core\pattern\LineLocationPatternConverter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */