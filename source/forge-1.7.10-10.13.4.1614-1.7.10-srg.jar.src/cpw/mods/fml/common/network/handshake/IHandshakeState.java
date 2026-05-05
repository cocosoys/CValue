package cpw.mods.fml.common.network.handshake;

import io.netty.channel.ChannelHandlerContext;

public interface IHandshakeState<S> {
  S accept(ChannelHandlerContext paramChannelHandlerContext, FMLHandshakeMessage paramFMLHandshakeMessage);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\network\handshake\IHandshakeState.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */