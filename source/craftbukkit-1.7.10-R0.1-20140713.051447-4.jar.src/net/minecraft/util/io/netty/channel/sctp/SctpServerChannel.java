package net.minecraft.util.io.netty.channel.sctp;

import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.util.Set;
import net.minecraft.util.io.netty.channel.ChannelFuture;
import net.minecraft.util.io.netty.channel.ChannelPromise;
import net.minecraft.util.io.netty.channel.ServerChannel;

public interface SctpServerChannel extends ServerChannel {
  SctpServerChannelConfig config();
  
  InetSocketAddress localAddress();
  
  Set<InetSocketAddress> allLocalAddresses();
  
  ChannelFuture bindAddress(InetAddress paramInetAddress);
  
  ChannelFuture bindAddress(InetAddress paramInetAddress, ChannelPromise paramChannelPromise);
  
  ChannelFuture unbindAddress(InetAddress paramInetAddress);
  
  ChannelFuture unbindAddress(InetAddress paramInetAddress, ChannelPromise paramChannelPromise);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\channel\sctp\SctpServerChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */