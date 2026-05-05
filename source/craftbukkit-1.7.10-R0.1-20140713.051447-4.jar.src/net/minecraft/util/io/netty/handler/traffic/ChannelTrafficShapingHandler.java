/*    */ package net.minecraft.util.io.netty.handler.traffic;
/*    */ 
/*    */ import java.util.concurrent.ScheduledExecutorService;
/*    */ import net.minecraft.util.io.netty.channel.ChannelHandlerContext;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ChannelTrafficShapingHandler
/*    */   extends AbstractTrafficShapingHandler
/*    */ {
/*    */   public ChannelTrafficShapingHandler(long writeLimit, long readLimit, long checkInterval) {
/* 60 */     super(writeLimit, readLimit, checkInterval);
/*    */   }
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
/*    */   public ChannelTrafficShapingHandler(long writeLimit, long readLimit) {
/* 73 */     super(writeLimit, readLimit);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public ChannelTrafficShapingHandler(long checkInterval) {
/* 84 */     super(checkInterval);
/*    */   }
/*    */ 
/*    */   
/*    */   public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
/* 89 */     TrafficCounter trafficCounter = new TrafficCounter(this, (ScheduledExecutorService)ctx.executor(), "ChannelTC" + ctx.channel().hashCode(), this.checkInterval);
/*    */     
/* 91 */     setTrafficCounter(trafficCounter);
/* 92 */     trafficCounter.start();
/*    */   }
/*    */ 
/*    */   
/*    */   public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
/* 97 */     if (this.trafficCounter != null)
/* 98 */       this.trafficCounter.stop(); 
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\handler\traffic\ChannelTrafficShapingHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */