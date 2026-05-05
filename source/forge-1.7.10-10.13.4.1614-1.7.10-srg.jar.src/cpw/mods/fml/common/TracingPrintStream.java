/*    */ package cpw.mods.fml.common;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import org.apache.logging.log4j.Logger;
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
/*    */ public class TracingPrintStream
/*    */   extends PrintStream
/*    */ {
/*    */   private Logger logger;
/* 24 */   private int BASE_DEPTH = 3;
/*    */   
/*    */   public TracingPrintStream(Logger logger, PrintStream original) {
/* 27 */     super(original);
/* 28 */     this.logger = logger;
/*    */   }
/*    */ 
/*    */   
/*    */   public void println(Object o) {
/* 33 */     this.logger.info(getPrefix() + o);
/*    */   }
/*    */ 
/*    */   
/*    */   public void println(String s) {
/* 38 */     this.logger.info(getPrefix() + s);
/*    */   }
/*    */   
/*    */   private String getPrefix() {
/* 42 */     StackTraceElement[] elems = Thread.currentThread().getStackTrace();
/* 43 */     StackTraceElement elem = elems[this.BASE_DEPTH];
/* 44 */     if (elem.getClassName().startsWith("kotlin.io.")) {
/* 45 */       elem = elems[this.BASE_DEPTH + 2];
/*    */     }
/* 47 */     return "[" + elem.getClassName() + ":" + elem.getMethodName() + ":" + elem.getLineNumber() + "]: ";
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\TracingPrintStream.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */