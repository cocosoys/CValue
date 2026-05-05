package net.minecraft.util.io.netty.channel;

import net.minecraft.util.io.netty.util.concurrent.Future;
import net.minecraft.util.io.netty.util.concurrent.GenericFutureListener;
import net.minecraft.util.io.netty.util.concurrent.ProgressivePromise;

public interface ChannelProgressivePromise extends ProgressivePromise<Void>, ChannelProgressiveFuture, ChannelPromise {
  ChannelProgressivePromise addListener(GenericFutureListener<? extends Future<? super Void>> paramGenericFutureListener);
  
  ChannelProgressivePromise addListeners(GenericFutureListener<? extends Future<? super Void>>... paramVarArgs);
  
  ChannelProgressivePromise removeListener(GenericFutureListener<? extends Future<? super Void>> paramGenericFutureListener);
  
  ChannelProgressivePromise removeListeners(GenericFutureListener<? extends Future<? super Void>>... paramVarArgs);
  
  ChannelProgressivePromise sync() throws InterruptedException;
  
  ChannelProgressivePromise syncUninterruptibly();
  
  ChannelProgressivePromise await() throws InterruptedException;
  
  ChannelProgressivePromise awaitUninterruptibly();
  
  ChannelProgressivePromise setSuccess(Void paramVoid);
  
  ChannelProgressivePromise setSuccess();
  
  ChannelProgressivePromise setFailure(Throwable paramThrowable);
  
  ChannelProgressivePromise setProgress(long paramLong1, long paramLong2);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\channel\ChannelProgressivePromise.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */