/*     */ package cpw.mods.fml.relauncher;
/*     */ 
/*     */ import cpw.mods.fml.common.TracingPrintStream;
/*     */ import java.io.File;
/*     */ import java.io.PrintStream;
/*     */ import java.util.Locale;
/*     */ import org.apache.logging.log4j.Level;
/*     */ import org.apache.logging.log4j.LogManager;
/*     */ import org.apache.logging.log4j.Logger;
/*     */ import org.apache.logging.log4j.ThreadContext;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class FMLRelaunchLog
/*     */ {
/*  31 */   public static FMLRelaunchLog log = new FMLRelaunchLog();
/*     */ 
/*     */ 
/*     */   
/*     */   static File minecraftHome;
/*     */ 
/*     */   
/*     */   private static boolean configured;
/*     */ 
/*     */   
/*     */   private Logger myLog;
/*     */ 
/*     */   
/*     */   static Side side;
/*     */ 
/*     */ 
/*     */   
/*     */   private static void configureLogging() {
/*  49 */     log.myLog = LogManager.getLogger("FML");
/*  50 */     ThreadContext.put("side", side.name().toLowerCase(Locale.ENGLISH));
/*  51 */     configured = true;
/*     */     
/*  53 */     fine("Injecting tracing printstreams for STDOUT/STDERR.", new Object[0]);
/*  54 */     System.setOut((PrintStream)new TracingPrintStream(LogManager.getLogger("STDOUT"), System.out));
/*  55 */     System.setErr((PrintStream)new TracingPrintStream(LogManager.getLogger("STDERR"), System.err));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void log(String targetLog, Level level, String format, Object... data) {
/*  60 */     LogManager.getLogger(targetLog).log(level, String.format(format, data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void log(Level level, String format, Object... data) {
/*  65 */     if (!configured)
/*     */     {
/*  67 */       configureLogging();
/*     */     }
/*  69 */     log.myLog.log(level, String.format(format, data));
/*     */   }
/*     */ 
/*     */   
/*     */   public static void log(String targetLog, Level level, Throwable ex, String format, Object... data) {
/*  74 */     LogManager.getLogger(targetLog).log(level, String.format(format, data), ex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void log(Level level, Throwable ex, String format, Object... data) {
/*  79 */     if (!configured)
/*     */     {
/*  81 */       configureLogging();
/*     */     }
/*  83 */     log.myLog.log(level, String.format(format, data), ex);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void severe(String format, Object... data) {
/*  88 */     log(Level.ERROR, format, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void warning(String format, Object... data) {
/*  93 */     log(Level.WARN, format, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void info(String format, Object... data) {
/*  98 */     log(Level.INFO, format, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void fine(String format, Object... data) {
/* 103 */     log(Level.DEBUG, format, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public static void finer(String format, Object... data) {
/* 108 */     log(Level.TRACE, format, data);
/*     */   }
/*     */ 
/*     */   
/*     */   public Logger getLogger() {
/* 113 */     return this.myLog;
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\relauncher\FMLRelaunchLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */