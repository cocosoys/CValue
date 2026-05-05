/*    */ package cpw.mods.fml.common;
/*    */ 
/*    */ import java.io.PrintStream;
/*    */ import java.io.PrintWriter;
/*    */ import java.io.StringWriter;
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
/*    */ public abstract class EnhancedRuntimeException
/*    */   extends RuntimeException
/*    */ {
/*    */   private static final long serialVersionUID = 1L;
/*    */   
/*    */   public EnhancedRuntimeException() {}
/*    */   
/*    */   public EnhancedRuntimeException(String message) {
/* 24 */     super(message);
/* 25 */   } public EnhancedRuntimeException(String message, Throwable cause) { super(message, cause); } public EnhancedRuntimeException(Throwable cause) {
/* 26 */     super(cause);
/*    */   }
/*    */ 
/*    */   
/*    */   public String getMessage() {
/* 31 */     StackTraceElement[] stack = Thread.currentThread().getStackTrace();
/* 32 */     if (stack.length > 2 && stack[2].getClassName().startsWith("org.apache.logging.log4j.")) {
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 37 */       final StringWriter buf = new StringWriter();
/*    */       
/* 39 */       String msg = super.getMessage();
/* 40 */       if (msg != null) {
/* 41 */         buf.append(msg);
/*    */       }
/* 43 */       buf.append('\n');
/* 44 */       printStackTrace(new WrappedPrintStream()
/*    */           {
/*    */             
/*    */             public void println(String line)
/*    */             {
/* 49 */               buf.append(line).append('\n');
/*    */             }
/*    */           });
/* 52 */       return buf.toString();
/*    */     } 
/* 54 */     return super.getMessage();
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public void printStackTrace(final PrintWriter s) {
/* 60 */     printStackTrace(new WrappedPrintStream()
/*    */         {
/*    */           
/*    */           public void println(String line)
/*    */           {
/* 65 */             s.println(line);
/*    */           }
/*    */         });
/* 68 */     super.printStackTrace(s);
/*    */   }
/*    */   
/*    */   public void printStackTrace(final PrintStream s) {
/* 72 */     printStackTrace(new WrappedPrintStream()
/*    */         {
/*    */           
/*    */           public void println(String line)
/*    */           {
/* 77 */             s.println(line);
/*    */           }
/*    */         });
/* 80 */     super.printStackTrace(s);
/*    */   }
/*    */   
/*    */   protected abstract void printStackTrace(WrappedPrintStream paramWrappedPrintStream);
/*    */   
/*    */   public static abstract class WrappedPrintStream {
/*    */     public abstract void println(String param1String);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\EnhancedRuntimeException.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */