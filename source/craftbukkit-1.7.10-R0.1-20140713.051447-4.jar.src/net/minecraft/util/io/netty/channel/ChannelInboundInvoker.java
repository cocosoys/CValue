package net.minecraft.util.io.netty.channel;

interface ChannelInboundInvoker {
  ChannelInboundInvoker fireChannelRegistered();
  
  @Deprecated
  ChannelInboundInvoker fireChannelUnregistered();
  
  ChannelInboundInvoker fireChannelActive();
  
  ChannelInboundInvoker fireChannelInactive();
  
  ChannelInboundInvoker fireExceptionCaught(Throwable paramThrowable);
  
  ChannelInboundInvoker fireUserEventTriggered(Object paramObject);
  
  ChannelInboundInvoker fireChannelRead(Object paramObject);
  
  ChannelInboundInvoker fireChannelReadComplete();
  
  ChannelInboundInvoker fireChannelWritabilityChanged();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\channel\ChannelInboundInvoker.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */