package net.minecraft.network.login;

import net.minecraft.network.INetHandler;
import net.minecraft.network.login.client.C00PacketLoginStart;
import net.minecraft.network.login.client.C01PacketEncryptionResponse;

public interface INetHandlerLoginServer extends INetHandler {
  void func_147316_a(C00PacketLoginStart paramC00PacketLoginStart);
  
  void func_147315_a(C01PacketEncryptionResponse paramC01PacketEncryptionResponse);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\login\INetHandlerLoginServer.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */