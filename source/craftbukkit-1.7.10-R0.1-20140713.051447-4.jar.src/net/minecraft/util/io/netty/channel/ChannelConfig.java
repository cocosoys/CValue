package net.minecraft.util.io.netty.channel;

import java.util.Map;
import net.minecraft.util.io.netty.buffer.ByteBufAllocator;

public interface ChannelConfig {
  Map<ChannelOption<?>, Object> getOptions();
  
  boolean setOptions(Map<ChannelOption<?>, ?> paramMap);
  
  <T> T getOption(ChannelOption<T> paramChannelOption);
  
  <T> boolean setOption(ChannelOption<T> paramChannelOption, T paramT);
  
  int getConnectTimeoutMillis();
  
  ChannelConfig setConnectTimeoutMillis(int paramInt);
  
  int getMaxMessagesPerRead();
  
  ChannelConfig setMaxMessagesPerRead(int paramInt);
  
  int getWriteSpinCount();
  
  ChannelConfig setWriteSpinCount(int paramInt);
  
  ByteBufAllocator getAllocator();
  
  ChannelConfig setAllocator(ByteBufAllocator paramByteBufAllocator);
  
  RecvByteBufAllocator getRecvByteBufAllocator();
  
  ChannelConfig setRecvByteBufAllocator(RecvByteBufAllocator paramRecvByteBufAllocator);
  
  boolean isAutoRead();
  
  ChannelConfig setAutoRead(boolean paramBoolean);
  
  int getWriteBufferHighWaterMark();
  
  ChannelConfig setWriteBufferHighWaterMark(int paramInt);
  
  int getWriteBufferLowWaterMark();
  
  ChannelConfig setWriteBufferLowWaterMark(int paramInt);
  
  MessageSizeEstimator getMessageSizeEstimator();
  
  ChannelConfig setMessageSizeEstimator(MessageSizeEstimator paramMessageSizeEstimator);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\channel\ChannelConfig.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */