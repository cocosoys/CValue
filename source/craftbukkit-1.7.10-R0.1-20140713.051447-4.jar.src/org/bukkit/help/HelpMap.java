package org.bukkit.help;

import java.util.Collection;
import java.util.List;

public interface HelpMap {
  HelpTopic getHelpTopic(String paramString);
  
  Collection<HelpTopic> getHelpTopics();
  
  void addTopic(HelpTopic paramHelpTopic);
  
  void clear();
  
  void registerHelpTopicFactory(Class<?> paramClass, HelpTopicFactory<?> paramHelpTopicFactory);
  
  List<String> getIgnoredPlugins();
}


/* Location:              D:\WorkTools\Project\Minecraft\plugins\craftbukkit\1.7.10\CValue\libs\core\craftbukkit-1.7.10-R0.1-20140713.051447-4.jar!\org\bukkit\help\HelpMap.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */