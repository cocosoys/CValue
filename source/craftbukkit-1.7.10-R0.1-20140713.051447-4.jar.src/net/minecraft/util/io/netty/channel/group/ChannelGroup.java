package net.minecraft.util.io.netty.channel.group;

import java.util.Set;
import net.minecraft.util.io.netty.channel.Channel;

public interface ChannelGroup extends Set<Channel>, Comparable<ChannelGroup> {
  String name();
  
  ChannelGroupFuture write(Object paramObject);
  
  ChannelGroupFuture write(Object paramObject, ChannelMatcher paramChannelMatcher);
  
  ChannelGroup flush();
  
  ChannelGroup flush(ChannelMatcher paramChannelMatcher);
  
  ChannelGroupFuture flushAndWrite(Object paramObject);
  
  ChannelGroupFuture flushAndWrite(Object paramObject, ChannelMatcher paramChannelMatcher);
  
  ChannelGroupFuture disconnect();
  
  ChannelGroupFuture disconnect(ChannelMatcher paramChannelMatcher);
  
  ChannelGroupFuture close();
  
  ChannelGroupFuture close(ChannelMatcher paramChannelMatcher);
  
  @Deprecated
  ChannelGroupFuture deregister();
  
  @Deprecated
  ChannelGroupFuture deregister(ChannelMatcher paramChannelMatcher);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\channel\group\ChannelGroup.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */