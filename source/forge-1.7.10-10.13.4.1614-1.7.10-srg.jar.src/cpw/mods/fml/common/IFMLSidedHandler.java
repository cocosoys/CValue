package cpw.mods.fml.common;

import cpw.mods.fml.common.eventhandler.EventBus;
import cpw.mods.fml.relauncher.Side;
import java.io.File;
import java.util.List;
import java.util.Set;
import net.minecraft.network.INetHandler;
import net.minecraft.network.NetworkManager;
import net.minecraft.server.MinecraftServer;

public interface IFMLSidedHandler {
  List<String> getAdditionalBrandingInformation();
  
  Side getSide();
  
  void haltGame(String paramString, Throwable paramThrowable);
  
  void showGuiScreen(Object paramObject);
  
  void queryUser(StartupQuery paramStartupQuery) throws InterruptedException;
  
  void beginServerLoading(MinecraftServer paramMinecraftServer);
  
  void finishServerLoading();
  
  File getSavesDirectory();
  
  MinecraftServer getServer();
  
  boolean shouldServerShouldBeKilledQuietly();
  
  void addModAsResource(ModContainer paramModContainer);
  
  String getCurrentLanguage();
  
  void serverStopped();
  
  NetworkManager getClientToServerNetworkManager();
  
  INetHandler getClientPlayHandler();
  
  void waitForPlayClient();
  
  void fireNetRegistrationEvent(EventBus paramEventBus, NetworkManager paramNetworkManager, Set<String> paramSet, String paramString, Side paramSide);
  
  boolean shouldAllowPlayerLogins();
  
  void allowLogins();
  
  void processWindowMessages();
  
  String stripSpecialChars(String paramString);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\forgeSrc-1.7.10-10.13.4.1614-1.7.10.jar!\cpw\mods\fml\common\IFMLSidedHandler.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */