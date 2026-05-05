package net.minecraft.util.io.netty.channel.udt;

import java.net.InetSocketAddress;
import net.minecraft.util.io.netty.channel.Channel;

public interface UdtChannel extends Channel {
  UdtChannelConfig config();
  
  InetSocketAddress localAddress();
  
  InetSocketAddress remoteAddress();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\net\minecraf\\util\io\netty\channe\\udt\UdtChannel.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */