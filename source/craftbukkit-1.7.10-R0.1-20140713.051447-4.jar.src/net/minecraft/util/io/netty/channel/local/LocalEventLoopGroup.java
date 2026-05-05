/*    */ package net.minecraft.util.io.netty.channel.local;
/*    */ 
/*    */ import java.util.concurrent.ThreadFactory;
/*    */ import net.minecraft.util.io.netty.channel.MultithreadEventLoopGroup;
/*    */ import net.minecraft.util.io.netty.util.concurrent.EventExecutor;
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
/*    */ public class LocalEventLoopGroup
/*    */   extends MultithreadEventLoopGroup
/*    */ {
/*    */   public LocalEventLoopGroup() {
/* 32 */     this(0);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LocalEventLoopGroup(int nThreads) {
/* 41 */     this(nThreads, null);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public LocalEventLoopGroup(int nThreads, ThreadFactory threadFactory) {
/* 51 */     super(nThreads, threadFactory, new Object[0]);
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected EventExecutor newChild(ThreadFactory threadFactory, Object... args) throws Exception {
/* 57 */     return (EventExecutor)new LocalEventLoop(this, threadFactory);
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\channel\local\LocalEventLoopGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */