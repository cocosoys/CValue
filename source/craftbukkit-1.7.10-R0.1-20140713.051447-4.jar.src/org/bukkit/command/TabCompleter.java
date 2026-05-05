package org.bukkit.command;

import java.util.List;

public interface TabCompleter {
  List<String> onTabComplete(CommandSender paramCommandSender, Command paramCommand, String paramString, String[] paramArrayOfString);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\command\TabCompleter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */