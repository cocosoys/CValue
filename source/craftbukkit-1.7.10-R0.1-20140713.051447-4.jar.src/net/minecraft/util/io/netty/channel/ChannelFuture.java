package net.minecraft.util.io.netty.channel;

import net.minecraft.util.io.netty.util.concurrent.Future;
import net.minecraft.util.io.netty.util.concurrent.GenericFutureListener;

public interface ChannelFuture extends Future<Void> {
  Channel channel();
  
  ChannelFuture addListener(GenericFutureListener<? extends Future<? super Void>> paramGenericFutureListener);
  
  ChannelFuture addListeners(GenericFutureListener<? extends Future<? super Void>>... paramVarArgs);
  
  ChannelFuture removeListener(GenericFutureListener<? extends Future<? super Void>> paramGenericFutureListener);
  
  ChannelFuture removeListeners(GenericFutureListener<? extends Future<? super Void>>... paramVarArgs);
  
  ChannelFuture sync() throws InterruptedException;
  
  ChannelFuture syncUninterruptibly();
  
  ChannelFuture await() throws InterruptedException;
  
  ChannelFuture awaitUninterruptibly();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\channel\ChannelFuture.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */