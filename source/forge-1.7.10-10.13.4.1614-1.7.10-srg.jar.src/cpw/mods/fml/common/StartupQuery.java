/*     */ package cpw.mods.fml.common;
/*     */ 
/*     */ import java.util.concurrent.CountDownLatch;
/*     */ import java.util.concurrent.atomic.AtomicBoolean;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ 
/*     */ 
/*     */ public class StartupQuery
/*     */ {
/*     */   private static volatile StartupQuery pending;
/*     */   
/*     */   public static boolean confirm(String text) {
/*  13 */     StartupQuery query = new StartupQuery(text, new AtomicBoolean());
/*  14 */     query.execute();
/*  15 */     return query.getResult().booleanValue();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void notify(String text) {
/*  20 */     StartupQuery query = new StartupQuery(text, null);
/*  21 */     query.execute();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void abort() {
/*  26 */     MinecraftServer server = FMLCommonHandler.instance().getMinecraftServerInstance();
/*  27 */     if (server != null) server.initiateShutdown();
/*     */     
/*  29 */     aborted = true;
/*  30 */     throw new AbortedException();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void reset() {
/*  36 */     pending = null;
/*  37 */     aborted = false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean check() {
/*  42 */     if (pending != null) {
/*     */ 
/*     */       
/*     */       try {
/*  46 */         FMLCommonHandler.instance().queryUser(pending);
/*     */       }
/*  48 */       catch (InterruptedException e) {
/*     */         
/*  50 */         FMLLog.warning("query interrupted", new Object[0]);
/*  51 */         abort();
/*     */       } 
/*     */       
/*  54 */       pending = null;
/*     */     } 
/*     */     
/*  57 */     return !aborted;
/*     */   }
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
/*     */   private static volatile boolean aborted = false;
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
/*     */   private String text;
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
/*     */   private AtomicBoolean result;
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
/*     */   private CountDownLatch signal;
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
/*     */   private volatile boolean synchronous;
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
/*     */   private StartupQuery(String text, AtomicBoolean result) {
/* 144 */     this.signal = new CountDownLatch(1);
/*     */     this.text = text;
/*     */     this.result = result;
/*     */   }
/*     */   
/*     */   public Boolean getResult() {
/*     */     return (this.result == null) ? null : Boolean.valueOf(this.result.get());
/*     */   }
/*     */   
/*     */   public void setResult(boolean result) {
/*     */     this.result.set(result);
/*     */   }
/*     */   
/*     */   public String getText() {
/*     */     return this.text;
/*     */   }
/*     */   
/*     */   public boolean isSynchronous() {
/*     */     return this.synchronous;
/*     */   }
/*     */   
/*     */   public void finish() {
/*     */     this.signal.countDown();
/*     */   }
/*     */   
/*     */   private void execute() {
/*     */     String prop = System.getProperty("fml.queryResult");
/*     */     if (this.result != null && prop != null) {
/*     */       FMLLog.info("Using fml.queryResult %s to answer the following query:\n%s", new Object[] { prop, this.text });
/*     */       if (prop.equalsIgnoreCase("confirm")) {
/*     */         setResult(true);
/*     */         return;
/*     */       } 
/*     */       if (prop.equalsIgnoreCase("cancel")) {
/*     */         setResult(false);
/*     */         return;
/*     */       } 
/*     */       FMLLog.warning("Invalid value for fml.queryResult: %s, expected confirm or cancel", new Object[] { prop });
/*     */     } 
/*     */     this.synchronous = false;
/*     */     pending = this;
/*     */     if (FMLCommonHandler.instance().getSide().isServer() || FMLCommonHandler.instance().getEffectiveSide().isClient()) {
/*     */       this.synchronous = true;
/*     */       check();
/*     */     } 
/*     */     try {
/*     */       this.signal.await();
/*     */       reset();
/*     */     } catch (InterruptedException e) {
/*     */       FMLLog.warning("query interrupted", new Object[0]);
/*     */       abort();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static class AbortedException extends RuntimeException {
/*     */     private static final long serialVersionUID = -5933665223696833921L;
/*     */     
/*     */     private AbortedException() {}
/*     */   }
/*     */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\StartupQuery.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */