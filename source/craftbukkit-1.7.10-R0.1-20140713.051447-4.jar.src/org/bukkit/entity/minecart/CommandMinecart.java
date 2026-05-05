package org.bukkit.entity.minecart;

import org.bukkit.command.CommandSender;
import org.bukkit.entity.Minecart;

public interface CommandMinecart extends Minecart, CommandSender {
  String getCommand();
  
  void setCommand(String paramString);
  
  void setName(String paramString);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\entity\minecart\CommandMinecart.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */