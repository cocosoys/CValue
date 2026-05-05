/*    */ package net.minecraft.util.io.netty.channel.local;
/*    */ 
/*    */ import java.util.concurrent.ThreadFactory;
/*    */ import net.minecraft.util.io.netty.channel.EventLoopGroup;
/*    */ import net.minecraft.util.io.netty.channel.SingleThreadEventLoop;
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
/*    */ final class LocalEventLoop
/*    */   extends SingleThreadEventLoop
/*    */ {
/*    */   LocalEventLoop(LocalEventLoopGroup parent, ThreadFactory threadFactory) {
/* 25 */     super((EventLoopGroup)parent, threadFactory, true);
/*    */   }
/*    */ 
/*    */   
/*    */   protected void run() {
/*    */     do {
/* 31 */       Runnable task = takeTask();
/* 32 */       if (task == null)
/* 33 */         continue;  task.run();
/* 34 */       updateLastExecutionTime();
/*    */     
/*    */     }
/* 37 */     while (!confirmShutdown());
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\channel\local\LocalEventLoop.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */