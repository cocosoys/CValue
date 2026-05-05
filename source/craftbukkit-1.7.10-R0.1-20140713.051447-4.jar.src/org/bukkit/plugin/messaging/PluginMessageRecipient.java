package org.bukkit.plugin.messaging;

import java.util.Set;
import org.bukkit.plugin.Plugin;

public interface PluginMessageRecipient {
  void sendPluginMessage(Plugin paramPlugin, String paramString, byte[] paramArrayOfbyte);
  
  Set<String> getListeningPluginChannels();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\plugin\messaging\PluginMessageRecipient.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */