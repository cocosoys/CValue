/*    */ package net.minecraft.util.io.netty.channel;
/*    */ 
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
/*    */ 
/*    */ 
/*    */ 
/*    */ final class SucceededChannelFuture
/*    */   extends CompleteChannelFuture
/*    */ {
/*    */   public SucceededChannelFuture(Channel channel, EventExecutor executor) {
/* 33 */     super(channel, executor);
/*    */   }
/*    */ 
/*    */   
/*    */   public Throwable cause() {
/* 38 */     return null;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isSuccess() {
/* 43 */     return true;
/*    */   }
/*    */ }


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\channel\SucceededChannelFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */