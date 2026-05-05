package org.bukkit.plugin;

import java.io.File;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import org.bukkit.event.Event;
import org.bukkit.event.Listener;

public interface PluginLoader {
  Plugin loadPlugin(File paramFile) throws InvalidPluginException, UnknownDependencyException;
  
  PluginDescriptionFile getPluginDescription(File paramFile) throws InvalidDescriptionException;
  
  Pattern[] getPluginFileFilters();
  
  Map<Class<? extends Event>, Set<RegisteredListener>> createRegisteredListeners(Listener paramListener, Plugin paramPlugin);
  
  void enablePlugin(Plugin paramPlugin);
  
  void disablePlugin(Plugin paramPlugin);
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\plugin\PluginLoader.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */