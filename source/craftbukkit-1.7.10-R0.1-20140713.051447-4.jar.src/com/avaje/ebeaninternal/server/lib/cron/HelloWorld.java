/*    */ package com.avaje.ebeaninternal.server.lib.cron;
/*    */ 
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;
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
/*    */ public class HelloWorld
/*    */   implements Runnable
/*    */ {
/* 30 */   private static final Logger logger = Logger.getLogger(HelloWorld.class.getName());
/*    */   
/*    */   public String toString() {
/* 33 */     return "Hello World";
/*    */   }
/*    */   
/*    */   public void run() {
/*    */     try {
/* 38 */       SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss.SSS ");
/* 39 */       String now = sdf.format(new Date());
/* 40 */       logger.info("Hello World " + now + "  ... sleeping 20 secs");
/*    */       
/* 42 */       Thread.sleep(20000L);
/* 43 */       logger.info("Hello World finished.");
/*    */     }
/* 45 */     catch (InterruptedException ex) {
/* 46 */       logger.log(Level.SEVERE, "", ex);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\com\avaje\ebeaninternal\server\lib\cron\HelloWorld.class
 * Java compiler version: 5 (49.0)
 * JD-Core Version:       1.1.3
 */