package net.minecraft.network.status;

import net.minecraft.network.INetHandler;
import net.minecraft.network.status.server.S00PacketServerInfo;
import net.minecraft.network.status.server.S01PacketPong;

public interface INetHandlerStatusClient extends INetHandler {
  void func_147397_a(S00PacketServerInfo paramS00PacketServerInfo);
  
  void func_147398_a(S01PacketPong paramS01PacketPong);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\status\INetHandlerStatusClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */