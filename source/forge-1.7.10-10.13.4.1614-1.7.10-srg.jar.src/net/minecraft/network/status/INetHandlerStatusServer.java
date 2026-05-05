package net.minecraft.network.status;

import net.minecraft.network.INetHandler;
import net.minecraft.network.status.client.C00PacketServerQuery;
import net.minecraft.network.status.client.C01PacketPing;

public interface INetHandlerStatusServer extends INetHandler {
  void func_147311_a(C01PacketPing paramC01PacketPing);
  
  void func_147312_a(C00PacketServerQuery paramC00PacketServerQuery);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\status\INetHandlerStatusServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */