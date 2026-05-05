/*    */ package cpw.mods.fml.common;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.FMLRelaunchLog;
/*    */ import org.apache.logging.log4j.Level;
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
/*    */ public class FMLLog
/*    */ {
/* 21 */   private static FMLRelaunchLog coreLog = FMLRelaunchLog.log;
/*    */ 
/*    */   
/*    */   public static void log(String targetLog, Level level, String format, Object... data) {
/* 25 */     FMLRelaunchLog.log(targetLog, level, format, data);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void log(Level level, String format, Object... data) {
/* 30 */     FMLRelaunchLog.log(level, format, data);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void log(String targetLog, Level level, Throwable ex, String format, Object... data) {
/* 35 */     FMLRelaunchLog.log(targetLog, level, ex, format, data);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void log(Level level, Throwable ex, String format, Object... data) {
/* 40 */     FMLRelaunchLog.log(level, ex, format, data);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void severe(String format, Object... data) {
/* 45 */     log(Level.ERROR, format, data);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void bigWarning(String format, Object... data) {
/* 50 */     StackTraceElement[] trace = Thread.currentThread().getStackTrace();
/* 51 */     log(Level.WARN, "****************************************", new Object[0]);
/* 52 */     log(Level.WARN, "* " + format, data);
/* 53 */     for (int i = 2; i < 8 && i < trace.length; i++) {
/*    */       
/* 55 */       log(Level.WARN, "*  at %s%s", new Object[] { trace[i].toString(), (i == 7) ? "..." : "" });
/*    */     } 
/* 57 */     log(Level.WARN, "****************************************", new Object[0]);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void warning(String format, Object... data) {
/* 62 */     log(Level.WARN, format, data);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void info(String format, Object... data) {
/* 67 */     log(Level.INFO, format, data);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void fine(String format, Object... data) {
/* 72 */     log(Level.DEBUG, format, data);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void finer(String format, Object... data) {
/* 77 */     log(Level.TRACE, format, data);
/*    */   }
/*    */ 
/*    */   
/*    */   public static Logger getLogger() {
/* 82 */     return coreLog.getLogger();
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\FMLLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */