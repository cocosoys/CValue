package net.minecraft.util.io.netty.channel;

import net.minecraft.util.io.netty.util.AttributeMap;
import net.minecraft.util.io.netty.util.concurrent.EventExecutor;

public interface ChannelHandlerContext extends AttributeMap, ChannelPropertyAccess, ChannelInboundInvoker, ChannelOutboundInvoker {
  Channel channel();
  
  EventExecutor executor();
  
  String name();
  
  ChannelHandler handler();
  
  boolean isRemoved();
  
  ChannelHandlerContext fireChannelRegistered();
  
  @Deprecated
  ChannelHandlerContext fireChannelUnregistered();
  
  ChannelHandlerContext fireChannelActive();
  
  ChannelHandlerContext fireChannelInactive();
  
  ChannelHandlerContext fireExceptionCaught(Throwable paramThrowable);
  
  ChannelHandlerContext fireUserEventTriggered(Object paramObject);
  
  ChannelHandlerContext fireChannelRead(Object paramObject);
  
  ChannelHandlerContext fireChannelReadComplete();
  
  ChannelHandlerContext fireChannelWritabilityChanged();
  
  ChannelHandlerContext flush();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\channel\ChannelHandlerContext.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */