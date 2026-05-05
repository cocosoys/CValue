package net.minecraft.util.io.netty.channel;

import net.minecraft.util.io.netty.buffer.ByteBufAllocator;

interface ChannelPropertyAccess {
  ChannelPipeline pipeline();
  
  ByteBufAllocator alloc();
  
  ChannelPromise newPromise();
  
  ChannelProgressivePromise newProgressivePromise();
  
  ChannelFuture newSucceededFuture();
  
  ChannelFuture newFailedFuture(Throwable paramThrowable);
  
  ChannelPromise voidPromise();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\channel\ChannelPropertyAccess.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */