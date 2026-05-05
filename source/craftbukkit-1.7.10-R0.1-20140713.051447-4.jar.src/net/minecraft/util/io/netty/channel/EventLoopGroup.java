package net.minecraft.util.io.netty.channel;

import net.minecraft.util.io.netty.util.concurrent.EventExecutorGroup;

public interface EventLoopGroup extends EventExecutorGroup {
  EventLoop next();
  
  ChannelFuture register(Channel paramChannel);
  
  ChannelFuture register(Channel paramChannel, ChannelPromise paramChannelPromise);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\channel\EventLoopGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */