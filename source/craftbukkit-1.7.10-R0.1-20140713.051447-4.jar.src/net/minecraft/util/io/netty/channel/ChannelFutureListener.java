/*    */ package net.minecraft.util.io.netty.channel;
/*    */ 
/*    */ import net.minecraft.util.io.netty.util.concurrent.Future;
/*    */ import net.minecraft.util.io.netty.util.concurrent.GenericFutureListener;
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
/*    */ public interface ChannelFutureListener
/*    */   extends GenericFutureListener<ChannelFuture>
/*    */ {
/* 41 */   public static final ChannelFutureListener CLOSE = new ChannelFutureListener()
/*    */     {
/*    */       public void operationComplete(ChannelFuture future) {
/* 44 */         future.channel().close();
/*    */       }
/*    */     };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 52 */   public static final ChannelFutureListener CLOSE_ON_FAILURE = new ChannelFutureListener()
/*    */     {
/*    */       public void operationComplete(ChannelFuture future) {
/* 55 */         if (!future.isSuccess()) {
/* 56 */           future.channel().close();
/*    */         }
/*    */       }
/*    */     };
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */   
/* 65 */   public static final ChannelFutureListener FIRE_EXCEPTION_ON_FAILURE = new ChannelFutureListener()
/*    */     {
/*    */       public void operationComplete(ChannelFuture future) {
/* 68 */         if (!future.isSuccess())
/* 69 */           future.channel().pipeline().fireExceptionCaught(future.cause()); 
/*    */       }
/*    */     };
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\channel\ChannelFutureListener.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */