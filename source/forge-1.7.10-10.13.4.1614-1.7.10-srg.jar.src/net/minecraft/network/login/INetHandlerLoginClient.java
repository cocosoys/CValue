package net.minecraft.network.login;

import net.minecraft.network.INetHandler;
import net.minecraft.network.login.server.S00PacketDisconnect;
import net.minecraft.network.login.server.S01PacketEncryptionRequest;
import net.minecraft.network.login.server.S02PacketLoginSuccess;

public interface INetHandlerLoginClient extends INetHandler {
  void func_147389_a(S01PacketEncryptionRequest paramS01PacketEncryptionRequest);
  
  void func_147390_a(S02PacketLoginSuccess paramS02PacketLoginSuccess);
  
  void func_147388_a(S00PacketDisconnect paramS00PacketDisconnect);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forge-1.7.10-10.13.4.1614-1.7.10-srg.jar!\net\minecraft\network\login\INetHandlerLoginClient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */