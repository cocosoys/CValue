/*    */ package net.minecraft.server.v1_7_R4;
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
/*    */ class ThreadSleepForever
/*    */   extends Thread
/*    */ {
/*    */   ThreadSleepForever(DedicatedServer paramDedicatedServer, String paramString) {
/* 53 */     super(paramString);
/*    */     
/* 55 */     setDaemon(true);
/* 56 */     start();
/*    */   }
/*    */   
/*    */   public void run() {
/*    */     while (true) {
/*    */       try {
/*    */         while (true)
/* 63 */           Thread.sleep(2147483647L);  break;
/* 64 */       } catch (InterruptedException interruptedException) {}
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraft\server\v1_7_R4\ThreadSleepForever.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */